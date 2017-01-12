/**
 * IDKWTFIAD
 */

/*
 * JQuery attempt
 */

$(document).ready(function(){
    $("button").click(function(){
        var btn = $("button");  
        btn.fadeOut();
        /*
        btn.animate({left: '100px'}, "slow");
        btn.animate({fontSize: '3em'}, "slow");
        btn.innerHTML = 'rolling';
        btn.animate({fontSize: '2em'}, "slow");
        btn.animate({left: '0px'}, "slow");*/
        roll();
        btn.fadeIn();
        
    });
});

/*
 * Dice
 */
function roll(){
	var die1 = document.getElementById("die1");
	var die2 = document.getElementById("die2");
	var d1 = Math.floor(Math.floor(Math.random() * 6) + 1);
	var d2 = Math.floor(Math.floor(Math.random() * 6) + 1);
	
	die1.innerHTML = getDieFace(d1);
	die2.innerHTML = getDieFace(d2);
	
	var response = document.getElementById("info");
	response.innerHTML = '<div class="alert alert-success">' 
							+ '<strong>You did it...</strong> ' 
							+ 'good for you...'
							+ '</div>';
	
	//window.alert("Alert\n" + d1 + "\n" + d2);
}

function getDieFace(input){
	var side = 1;
	
	switch(input) {
	case 1:
		side = '<span class="dice dice-1" title="Dice 1"></span>'
		break;
	case 2:
		side = '<span class="dice dice-2" title="Dice 2"></span>'
		break;
	case 3:
		side = '<span class="dice dice-3" title="Dice 3"></span>'
		break;
	case 4:
		side = '<span class="dice dice-4" title="Dice 4"></span>'
		break;
	case 5:
		side = '<span class="dice dice-5" title="Dice 5"></span>'
		break;
	case 6:
		side = '<span class="dice dice-6" title="Dice 6"></span>'
		break;
	default:
		side = 'IDK'
	}
	
	return side;
}