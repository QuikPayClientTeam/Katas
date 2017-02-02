/**
 * IDKWTFIAD
 */

// Instantiate the Bootstrap carousel
$('.multi-item-carousel').carousel({
	interval : false
});

// for every slide in carousel, copy the next slide's item in the slide.
// Do the same for the next, next item.
$('.multi-item-carousel .item').each(
		function() {
			var next = $(this).next();
			if (!next.length) {
				next = $(this).siblings(':first');
			}
			next.children(':first-child').clone().appendTo($(this));

			if (next.next().length > 0) {
				next.next().children(':first-child').clone().appendTo($(this));
			} else {
				$(this).siblings(':first').children(':first-child').clone()
						.appendTo($(this));
			}
		});

function decrease() {

	var currentProgress = document.getElementById("myprogressbar").style.width;
	currentProgress = currentProgress.replace('%', '');

	if (currentProgress > 0) {
		var newProgress = parseInt(currentProgress) - 10;
		var isZero = false;
		if (newProgress === 0) {
			isZero = true;
		}
		newProgress = newProgress + '%';
		document.getElementById("myprogressbar").style.width = newProgress;
		// NEAT: add percentage to bar
		// document.getElementById("myprogressbar").innerHTML = newProgress;
		document.getElementById("percentage").innerHTML = newProgress;

		if (isZero) {
			document.getElementById("progess-container").innerHTML = '<div class="alert alert-danger"> '
					+ '<div id="percentage"><strong>0%</strong></div> </div>';
		} else {
			document.getElementById("progess-container").innerHTML = '<div class="alert alert-info"> '
					+ '<div id="percentage">' + newProgress + '</div> </div>';
			// document.getElementById("percentage").innerHTML = newProgress;
		}

	}

	// window.alert("Decrease:\n" + currentProgress + "\n" + newProgress);
}

function increase() {
	var currentProgress = document.getElementById("myprogressbar").style.width;
	currentProgress = currentProgress.replace('%', '');

	if (currentProgress < 100) {
		var newProgress = parseInt(currentProgress) + 10;
		var isHundred = false;
		if (newProgress === 100) {
			isHundred = true;
		}
		newProgress = newProgress + '%';
		document.getElementById("myprogressbar").style.width = newProgress;

		if (isHundred) {
			document.getElementById("progess-container").innerHTML = '<div class="alert alert-success"> '
					+ '<div id="percentage"><strong>100%</strong></div> </div>';
		} else {
			document.getElementById("progess-container").innerHTML = '<div class="alert alert-info"> '
					+ '<div id="percentage">' + newProgress + '</div> </div>';
		}
	}

	// window.alert("Decrease:\n" + currentProgress + "\n" + newProgress);
}

$(document).ready(function() {
	$('[data-toggle="tooltip"]').tooltip();
});

// draggable
$(function() {
	$("#draggable").draggable();
});

$(function() {
	$("#sortable").sortable();
	$("#sortable").disableSelection();
});
