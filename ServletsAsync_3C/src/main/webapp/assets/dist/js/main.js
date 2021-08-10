
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
           <td><img width="100" height="100" src="data:image/jpeg;base64,${ game.imgGame }"</td>
           <td>${game.datePremiere}</td>
           <td>${game.Category_idCategory.nameCategory}</td>
           <td>${game.status}</td>
           </tr>
           `
        }
    });
}


function createGame(){
    let data = new FormData();
    data.append('action','create');
    data.append('name',document.getElementById("name").value);
    data.append('date',document.getElementById("date").value);
    data.append('image',document.getElementById("image").files[0]);
    data.append('category',document.getElementById("category").value);
    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/ServletsAsync_3C_war/createGames',
        contentType: false,
        processData: false,
        data: data
    }).done(function(res){
        document.getElementById("name").value="";
        document.getElementById("date").value="";
        document.getElementById("image").value="";
        document.getElementById("category").value="";
        findGames();
    });
}

