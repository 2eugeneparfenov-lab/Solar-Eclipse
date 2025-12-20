// function oneCellClick(row, col){
//     fetch(`/api/lightsoff?row=${row}&col=${col}`)
//         .then(response => response.json())
//         .then(data => {
//             document.getElementById("gameField").innerHTML = data.html;
//             if(data.gameWon){
//                 document.getElementById("message").innerText = "Game solved!";
//             }else{
//                 document.getElementById("message").innerText = "";
//             }
//         })
//
//         .catch(err => {
//             console.error("Error: ", err);
//         });
// }