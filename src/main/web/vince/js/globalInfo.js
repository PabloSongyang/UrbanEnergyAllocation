/**
 * 作者：Pablo风暴洋
 * 功能：登录人员显示，更新服务器时间
 */


var startTime;

$(function () {
    var adminTxt = $("#adminTxt");
    var nowTime = $("#nowTime");

    var right_admin_name = $('#right-admin-name');
    var right_second_admin = $('#right-second-admin');

    var logoutBtn = $('#logoutBtn');


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
            }, 'json'
        )
    })
});

/**
 * 时间格式转换
 * @param value 毫秒值
 * @returns {string} 格式化时间字符串返回
 */
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

/**
 * 时间格式转换
 * @param value 毫秒值
 * @returns {string} 格式化时间字符串返回
 */
function datefomate1(value) {
    if (value == null || value == undefined) {
        return "";
    }
    var date = new Date(value);

    Y = date.getFullYear(),
        m = date.getMonth() + 1,
        d = date.getDate();


    return Y + '-' + m + '-' + d;
};

/**
 * 获取当前服务器时间戳（毫秒）
 * @returns {*}
 */
function getNowTime() {
    return startTime;
}

/**
 * 获取当前服务器时间戳（年月日）
 * @returns {*}
 */
function getNowDate() {
    var date = datefomate1(startTime);

    var year = date.split('-')[0];
    var month = date.split('-')[1];
    var day = date.split('-')[2];

    if (month / 10 < 1)
        month = '0' + month;
    if (day / 10 < 1)
        day = '0' + day;
    return year + '-' + month + '-' + day;
}