var num = 150; //number of pixels before modifying styles

$(window).bind('scroll', function () {
    if ($(window).scrollTop() > num) {
        $('#menu').addClass('fixed');
        $('#menu').removeClass('base');
    } else {
        $('#menu').addClass('base');
        $('#menu').removeClass('fixed');
    }
});
