
function findGames(){
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/ServletsAsync_3C_war/readGames'
    }).done(function(res){
        let listGame = res.listGames;
        let result = document.querySelector('#res');
        result.innerHTML='';
        var count=0;
        for (let game of listGame) {
            count=count+1;
            result.innerHTML += `
           <tr>
           <td>${count}</td>
           <td>${game.name}</td>
           <td>${game.datePremiere}</td>
           <td>${game.Category_idCategory.nameCategory}</td>
           </tr>
           `
        }
    });
}


