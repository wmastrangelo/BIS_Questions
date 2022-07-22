// Walker Mastrangelo   July 20th, 2022
// BIS Interview Follow-Up Questions
// JavaScript Exercise

//Function runs when Let's Play button is clicked
document.getElementById("play").onclick = function () {
    const minRandom = 1;
    const maxRandom = 100000;
    
    var time = 0;
    //Runs randoms numbers for 2.5 seconds
    const interval = setInterval(function () {
        if (time <= 25) {
            number = Math.floor(Math.random() * (maxRandom) + minRandom);
            document.getElementById("randomNumber").innerText = number;
            time++;
        }
        else {
            //Stops the time-based loop
            clearInterval(interval);
            
            testWin();
        }
    }, 100);

}

//Checks if the last generated number is in the winning range
function testWin() {
    const drawnNum = document.getElementById("randomNumber").innerText;
    
    const winMax = 1000;
    const winMin = 1;
    if ( drawnNum <= winMax && drawnNum >= 1) {
        alert("You won!");
    }
    else {
        alert("Too bad! You've lost!");
    }
}