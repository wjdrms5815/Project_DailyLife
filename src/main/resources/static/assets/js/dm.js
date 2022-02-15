$(function (){
    $("input[type='text']").keypress(function (e) {
        if(e.keyCode == 13 && $(this).val().length) {
            let _val = $(this).val();
            let _class = $(this).attr("class");
            $(this).val('');
            let _tar = $(".char_wrap .inner").append(' ' +
                '<div class="item '+_class+'">\n' +
                '                        <div class="box">\n' +
                '                            <p class="msg">'+_val+'</p>\n' +
                '                            <span class="time">'+currentTime()+'</span>\n' +
                '                        </div>\n' +
                '                    </div>'
            )
        }
        setTimeout(function () {
            $(".char_wrap .inner").find(".item:last").addClass("on")
        },10)

        $(".char_wrap .inner").stop().animate({scrollTop:$(".char_wrap .inner").height()},500);
    })
});

let currentTime = function (){
    let date = new Date();
    let hh = date.getHours();
    let mm = date.getMinutes();
    let apm = hh > 12 ? "오후" :  "오전";
    let ct = hh+":"+mm+"";
    return ct;
};