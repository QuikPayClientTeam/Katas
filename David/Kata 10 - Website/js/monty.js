var selectedDoor = '';
var playing = false;
var car = '';
var openedDoor = '';
var remainingDoor = '';
var defaultStyleImages = 'margin-left:150px;';

$(document).ready(function() {

    placeCar();

    $('#door1').on('click',function(){
        if (!playing){
            selectDoor(this);
        }
    });
    $('#door2').on('click',function(){
        if (!playing){
            selectDoor(this);
        }
    });
    $('#door3').on('click',function(){
        if (!playing){
            selectDoor(this);
        }
    });
});

function selectDoor(door){
    resetDoorsExcept(door);
    $('#' + door.id).attr("src","images/" + door.id + "-selected.png");
    selectedDoor = door.id;
	$('#playDoor').prop('disabled', false);
	montyHallDisplayMessage("Press Play to open one of the remaining doors", "info");
    //alert(selectedDoor);
}

function resetGame(){
    resetDoorsExcept('door');
    $('#playDoor').prop('disabled', true);
	$('#playDoor').show();
    $('#switchDoor').hide();
    $('#keepDoor').hide();
	$('#montyPlayAgain').hide();
    playing = false;
    car = '';
    selectedDoor = '';
    remainingDoor = '';
    placeCar();
	montyHallDisplayMessage("Please, select a door", "info");
}

function resetDoorsExcept(door){
    var arraysOfIds = $('#doors img').map(function(){
                                                    return this.id;
                                                    }).get();
    for (var index = 0; index < arraysOfIds.length; index++){
        if (arraysOfIds[index] != door.id){
            $('#' + arraysOfIds[index]).attr("src","images/" + arraysOfIds[index] + ".png");
            $('#' + arraysOfIds[index]).attr("style", defaultStyleImages);
        }
    }
}

function placeCar(){
    car = chooseRandomDoor();
}

function chooseRandomDoor(){
	var minimum = 1;
    var maximum = 3;
    return 'door' + (Math.floor(Math.random() * (maximum - minimum + 1)) + minimum);
}

function playMontyHall(){
    playing = true;
	$('#playDoor').hide();
    openDoorWithGoat();
}

function openDoorWithGoat(){
    var arraysOfIds = $('#doors img').map(function(){
                                          return this.id;
                                          }).get();

	var isGoat = false;

	while(!isGoat){
		var randomDoor = chooseRandomDoor();
		if (randomDoor != car && randomDoor != selectedDoor){
			isGoat = true;
			for (var index = 0; index < arraysOfIds.length; index++){
		        if (arraysOfIds[index] == randomDoor){
		            $('#' + arraysOfIds[index]).attr("src","images/goat.png");
		            openedDoor = arraysOfIds[index];
		        }else{
					$('#' + arraysOfIds[index]).attr("style","margin-top:-102px;" + defaultStyleImages);
				}
		    }
		}
	}

    for (var index = 0; index < arraysOfIds.length; index++){
        if (arraysOfIds[index] != openedDoor && arraysOfIds[index] != selectedDoor){
            remainingDoor = arraysOfIds[index];
        }
    }

    $('#switchDoor').show();
    $('#keepDoor').show();

	montyHallDisplayMessage("Choose whether you want to switch doors or not", "info");
}

function montyHallDisplayMessage(message, className){
	$('#messageMontyHall').show();
	document.getElementById('messageMontyHall').innerHTML = message;
	document.getElementById('messageMontyHall').className = "total alert alert-" + className;
}

function openDoor(selectedDoor, remainingDoor){
	$('#switchDoor').hide();
    $('#keepDoor').hide();
	$('#montyPlayAgain').show();
	if (selectedDoor != car){
        $('#' + selectedDoor).attr("src","images/goat-selected.png");
        $('#' + selectedDoor).attr("style","margin-top:0px;" + defaultStyleImages);
        $('#' + remainingDoor).attr("src","images/car.png");
        $('#' + remainingDoor).attr("style","margin-top:0px;" + defaultStyleImages);
		montyHallDisplayMessage("You haven't won the car. :(", "danger");
    }else{
        $('#' + selectedDoor).attr("src","images/car-selected.png");
        $('#' + selectedDoor).attr("style","margin-top:0px;" + defaultStyleImages);
        $('#' + remainingDoor).attr("src","images/goat.png");
        $('#' + remainingDoor).attr("style","margin-top:0px;" + defaultStyleImages);
		montyHallDisplayMessage("You have won the car. Congratulations!!!", "success");
    }
}

function switchDoor(){
    openDoor(remainingDoor, selectedDoor);
}

function keepDoor(){
    openDoor(selectedDoor, remainingDoor);
}
