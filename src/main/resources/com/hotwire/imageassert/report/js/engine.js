function getClass(delta, threshold) {
    if (delta == '0') {
        return 'match';
    } else if (delta <= threshold) {
        return 'threshold';
    } else {
        return 'mismatch';
    }
}

$.getJSON('report.json', function(items) {
    for (i in items) {
        var item = items[i];
        console.log(item);

        $('img').each(function(i, item) {
            $(item).load(function() { if ($(this).width() > $(this).height()) $(this).addClass('rotate');});
        })

        var div = $('<div/>');
        div.addClass(getClass(item.mismatch, item.threshold));
        div.text(item.id);
        div.click(function(item) {
            return function() {
                $('div.right').removeClass('match');
                $('div.right').removeClass('mismatch');
                $('div.right').removeClass('threshold');
                $('div.right').addClass(getClass(item.mismatch, item.threshold));
                $('img.base').attr('src', item.base);
                $('img.delta').attr('src', item.delta);
                $('img.sample').attr('src', item.sample);
            }
        }(item));
        div.appendTo($('div.left'));
    }
})