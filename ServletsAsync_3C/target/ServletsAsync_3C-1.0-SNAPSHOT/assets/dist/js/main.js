
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
    alert("entro")
    var image = document.getElementById("image").files[0].size;
    alert(image);
    let name = document.getElementById("name").value;
    let date = document.getElementById("date").value;
    let category = document.getElementById("category").value;

    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/ServletsAsync_3C_war/createGames',
        data: {
            action: 'create',
            name: name,
            image: image,
            date: date,
            idCategory: category
        }
    }).done(function(res){
        console.log(res);
        let message = res.message;
        alert(message);
        findGames();
    });
}

