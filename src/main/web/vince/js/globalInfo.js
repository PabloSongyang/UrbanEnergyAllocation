$(function () {
    var adminTxt = $("#adminTxt");
    var nowTime = $("#nowTime");

    var right_admin_name = $('#right-admin-name');
    var right_second_admin = $('#right-second-admin');

    var logoutBtn = $('#logoutBtn');

    var startTime;

    $.get(
        'ajax_current_worker',
        function (data) {
            adminTxt.text("当前用户：" + data.curWorker.workerName);

            right_admin_name.text(data.curWorker.workerName);
            right_second_admin.text("姓名：" + data.curWorker.workerName);

            startTime = data.curWorker.nowdate;
            setInterval(function () {
                startTime += 1000;
                nowTime.text(datefomate(startTime));
            }, 1000)
        }, 'json'
    );

    logoutBtn.click(function () {
        $.get(
            'ajax_logout',
            function (data) {
                if (data.code == 105) {
                    layer.msg(data.msg, {icon: 1, time: 1000}, function () {
                        location.href = "index.html";
                    })
                } else {
                    layer.msg(data.msg, {icon: 5, time: 1000});
                }
            },'json'
        )
    })
});

function datefomate(value) {
    if (value == null || value == undefined) {
        return "";
    }
    var date = new Date(value);

    Y = date.getFullYear(),
        m = date.getMonth() + 1,
        d = date.getDate(),
        H = date.getHours(),
        i = date.getMinutes(),
        s = date.getSeconds();
    return Y + '-' + m + '-' + d + " " + H + ":" + i + ":" + s;
};