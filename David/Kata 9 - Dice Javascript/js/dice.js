var total = 0;

function rollDice(){
    total = 0;
    document.getElementById('dicep').innerHTML = "";
	for (var index = 0; index < options.dice; index++){
        var dieSpan = "<span title=\"Dieeee " + (index + 1) + "\" id=\"die" + (index + 1) + "\" class=\"test\"></span>";
        document.getElementById('dicep').innerHTML += "\n\t" + dieSpan;
        rollDieNumber((index + 1));
	}
}

function rollDieNumber(die){
    //console.log(die);
    var index = 0;
    var number = 0;

    var iterator = function (die){
        number = rollDie();
        document.getElementById('die' + die).className = "dice dice-" + number;
        //console.log("Updating class to " + number);
        index++;
        if (index < 7){
            setTimeout(function () {
                iterator(die);
            }, 75);
        }else{
            total += number;
            //console.log(number);
			$(mainDiv).center();
            document.getElementById('total').innerHTML = "Total: <strong>" + total + "</strong>";
        }
    }

    iterator(die);
}

function rollDie() {
	var minimum = 1;
	var maximum = 6;
    return Math.floor(Math.random() * (maximum - minimum + 1)) + minimum;
}

jQuery.fn.center = function() {
    this.css("position","absolute");
    this.css("left", Math.max(0, (($(window).width() - $(this).outerWidth()) / 2) + $(window).scrollLeft()) + "px");
    return this;
}

$(document).ready(function() {
    console.log( "ready!" );
    $(mainDiv).center();
});
