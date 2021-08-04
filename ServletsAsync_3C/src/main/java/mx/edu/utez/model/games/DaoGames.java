package mx.edu.utez.model.games;

import mx.edu.utez.model.category.BeanCategory;
import mx.edu.utez.service.ConnectionMySQL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.CallableStatement;
import java.sql.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class DaoGames {
    private Connection con;
    private CallableStatement cstm;
    private ResultSet rs;
    final private Logger PRINT = LoggerFactory.getLogger(DaoGames.class);

    public List<BeanGames> findAll(){
        List<BeanGames> listGames = new ArrayList<>();

         try {
             con = ConnectionMySQL.getConnection();
             cstm =con.prepareCall("{call sp_findGames}");
             rs = cstm.executeQuery();

             while(rs.next()){
                 BeanCategory beanCategory = new BeanCategory();
                 BeanGames beanGames = new BeanGames();
                 beanCategory.setIdCategory(rs.getInt("idCategory"));
                 beanCategory.setName(rs.getString("name"));
                 beanCategory.setStatus(rs.getInt("status"));
                 beanGames.setIdGames(rs.getInt("idGames"));
                 beanGames.setName(rs.getString("name"));
                 beanGames.setImgGame(Base64.getEncoder().encodeToString(rs.getBytes("img_game")));
                 beanGames.setDatePremiere(rs.getString("date_premiere"));
                 beanGames.setStatus(rs.getInt("status"));
                 beanGames.setCategory_idCategory(beanCategory);
                 listGames.add(beanGames);
             }
         }catch (SQLException e){
            PRINT.error("Se ha encontrado el error:" + e);
         }finally {
            ConnectionMySQL.closeConnections(con,cstm,rs);
         }

        return listGames;
    }
    public BeanGames findById(long id){
        BeanGames game = null;
        try {
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{call sp_findById(?)}");
            cstm.setLong(1, id);
            rs = cstm.executeQuery();

            if(rs.next()){
                BeanCategory beanCategory = new BeanCategory();
                game = new BeanGames();

                beanCategory.setIdCategory(rs.getInt("idCategory"));
                beanCategory.setName(rs.getString("name"));
                beanCategory.setStatus(rs.getInt("status"));
                game.setIdGames(rs.getInt("idGames"));
                game.setName(rs.getString("name"));
                game.setImgGame(Base64.getEncoder().encodeToString(rs.getBytes("img_game")));
                game.setDatePremiere(rs.getString("date_premiere"));
                game.setStatus(rs.getInt("status"));
                game.setCategory_idCategory(beanCategory);

            }
        }catch (SQLException e){
            PRINT.error("Ha ocurrido un error: " + e.getMessage());
        } finally {
            ConnectionMySQL.closeConnections(con, cstm, rs);
        }
        return game;
    }

    public boolean create(BeanGames game){
        boolean flag = false;
        try{
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{call sp_create(?,?,?,?)}");
            cstm.setString(1, game.getName());
            cstm.setBytes(2, Base64.getDecoder().decode(game.getImgGame()));
            cstm.setString(3,game.getDatePremiere() );
            cstm.setInt(4, game.getCategory_idCategory().getIdCategory());
            flag =  cstm.execute();;
        }catch(SQLException e){
            PRINT.error("Ha ocurrido un error: " + e.getMessage());
        } finally {
            ConnectionMySQL.closeConnections(con, cstm);
        }
        return flag;
    }

    public boolean update(BeanGames game){
        boolean flag = false;
        try{
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{call sp_update(?,?,?,?,?,?,?)}");
            cstm.setInt(1, game.getIdGames());
            cstm.setString(2, game.getName());
            cstm.setBytes(2, Base64.getDecoder().decode(game.getImgGame()));
            cstm.setString(4, game.getDatePremiere());
            cstm.setInt(5,game.getCategory_idCategory().getIdCategory() );
            flag = cstm.execute();
        }catch(SQLException e){
            PRINT.error("Ha ocurrido un error: " + e.getMessage());
        }finally{
            ConnectionMySQL.closeConnections(con, cstm);
        }
        return flag;
    }

    public boolean delete(long idGame){
        boolean flag = false;
        try{
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{call sp_delete(?)}");
            cstm.setLong(1, idGame);

            flag = cstm.execute();
        }catch(SQLException e){
            PRINT.error("Ha ocurrido un error: " + e.getMessage());
        }finally{
            ConnectionMySQL.closeConnections(con, cstm);
        }
        return flag;
    }
}
