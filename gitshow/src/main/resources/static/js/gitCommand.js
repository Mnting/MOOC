$(function () {
    $("[data-toggle='popover']").popover({
        trigger:'manual',
        placement : 'bottom',//弹出位置
        html : true,//content中插入html代码
        animation: false
    }).on("mouseenter", function () {
        var _this = this;
        $(this).popover("show");
        $(this).siblings(".popover").on("mouseleave", function () {
            $(_this).popover('hide');
        });
    })
        .on("mouseleave", function () {
        var _this = this;
        setTimeout(function () {
            if (!$(".popover:hover").length) {
                $(_this).popover("hide")
            }
        }, 100);
    })
    ;
});