var total = 0;
var diceRolled = 0;

function resetDice(){
    total = 0;
    diceRolled = 0;
    $('#total').css("display", "none");
    $('#dice-success').css("display", "none");
    $('#dice-danger').css("display", "none");
    document.getElementById('dicep').innerHTML = "";
}

function rollDice(){
    total = 0;
    diceRolled = 0;
    document.getElementById('dicep').innerHTML = "";
	for (var index = 0; index < options.dice; index++){
        var dieSpan = "<span title=\"Die " + (index + 1) + "\" id=\"die" + (index + 1) + "\" class=\"test\"></span>";
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
            if ($('#dice-seven').is(':checked')){
                total += number;
                //console.log(number);
                $('#total').show();
                document.getElementById('total').innerHTML = "Total: <strong>" + total + "</strong>";
            }else{
                $('#total').css("display", "none");
            }
            $(diceDiv).center();
            diceRolled++;
            if (diceRolled == options.dice){
                checkResult();
            }
        }
    }

    iterator(die);
}

function checkResult(){
    hideErrorBoxes();

    if ($('#dice-doubles').is(':checked')){
        var previous = '';
        var doubles = true;
        for (var index = 0; index < options.dice; index++){
            var current = document.getElementById('die' + (index + 1)).className;
            if (previous == ''){
                previous = current;
            }else{
                if (previous != current){
                    doubles = false;
                    break;
                }
            }
        }
        if (doubles){
            $('#dice-success').show();
            document.getElementById('dice-success').innerHTML = "You have rolled doubles. Congratulations!!!";
        }else{
            $('#dice-danger').show();
            document.getElementById('dice-danger').innerHTML = "You haven't rolled doubles. :(";
        }
    }else if ($('#dice-seven').is(':checked')){
        if (total == 7){
            $('#dice-success').show();
            document.getElementById('dice-success').innerHTML = "You have rolled 7. Congratulations!!!";
        }else{
            $('#dice-danger').show();
            document.getElementById('dice-danger').innerHTML = "You haven't rolled 7. :(";
        }
    }
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

function hideErrorBoxes(){
    $('#dice-success').css("display", "none");
    $('#dice-danger').css("display", "none");
}

$(document).ready(function() {
    console.log( "ready!" );
    $('#total').css("display", "none");
    $('#dice-success').css("display", "none");
    $('#dice-danger').css("display", "none");
});
