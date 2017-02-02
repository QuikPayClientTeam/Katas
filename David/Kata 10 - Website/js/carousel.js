$(document).ready(function() {
    $('#door-success').css("display", "none");
    $('#door-danger').css("display", "none");
    checkSlide();

    $('#myCarousel').bind('slid.bs.carousel', function (e) {
    	checkSlide();
    });
	$('#myCarousel').bind('slide.bs.carousel', function (e) {
    	hideSlides();
    });
});

function hideSlides(){
	$('#doorDiv').hide();
	$('#diceDiv').hide();
}

function checkSlide(){
    var currentSlide = $('#myCarousel div.active').index() + 1;

    if(currentSlide == 1){
        $('#diceDiv').show();
        $('#doorDiv').hide();
        resetDice();
    }

    if(currentSlide == 2){
        $('#diceDiv').hide();
        $('#doorDiv').show();
        resetGame();
    }
}
