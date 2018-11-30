var num = 160; //number of pixels before modifying styles

$(window).bind('scroll', function () {
    if ($(window).scrollTop() > num) {
        $('#menuGlobal').removeClass('hidden');
        $('#menuBase').addClass('hidden');
    } else {
        $('#menuGlobal').addClass('hidden');
        $('#menuBase').removeClass('hidden');
    }
});

