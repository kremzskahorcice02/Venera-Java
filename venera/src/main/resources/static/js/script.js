let bg = document.getElementById('bg');
let venus = document.getElementById('venus');
let lod = document.getElementById('lod');
let mountain = document.getElementById('mountain');
let road = document.getElementById('road');

window.addEventListener('scroll', function() {
    var value = window.scrollY;

    bg.style.top = value * 0.5 + 'px';
    venus.style.top = value * 0.5 + 'px';
    lod.style.left = value * 0.7 + 'px';
    lod.style.top = value * 0.7 + 'px';
    mountain.style.top = value * 0.15 + 'px';
    road.style.top = value * 0.2 + 'px';
    text.style.top = value * 0.8 + 'px';
})

$(window).on("load",function() {
    $(window).scroll(function() {
        var windowBottom = $(this).scrollTop() + $(this).innerHeight();
        $(".fade").each(function() {
            /* Check the location of each desired element */
            var objectBottom = $(this).offset().top + $(this).outerHeight();

            /* If the element is completely within bounds of the window, fade it in */
            if (objectBottom < windowBottom) { //object comes into view (scrolling down)
                if ($(this).css("opacity")==0) {$(this).fadeTo(400,1);}
            }
        });
    }).scroll(); //invoke scroll-handler on page-load
});


// Get the button:
let mybutton = document.getElementById("myBtn");
mybutton.addEventListener('click', function() {topFunction(), false});

// When the user scrolls down 20px from the top of the document, show the button
window.onscroll = function() {scrollFunction()};

function scrollFunction() {
    const divAbout = document.getElementById('top');
    let top = divAbout.offsetTop;
    let height = divAbout.offsetHeight;
    let bottom = top + height;
    if (document.body.scrollTop > bottom || document.documentElement.scrollTop > bottom) {
        mybutton.style.display = "block";
    } else {
        mybutton.style.display = "none";
    }
}

// When the user clicks on the button, scroll to the top of the document
function topFunction() {
    const divAbout = document.getElementById('top');
    let top = divAbout.offsetTop;
    document.body.scrollTop = top; // For Safari
    document.documentElement.scrollTop = top; // For Chrome, Firefox, IE and Opera
}

// events showing functions

function showPreviousEvents() {
    document.getElementById("futureEvents").style.display = "none";
    document.getElementById("previousEvents").style.display = "block";
}

function showFutureEvents() {
    document.getElementById("previousEvents").style.display = "none";
    document.getElementById("futureEvents").style.display = "block";
}