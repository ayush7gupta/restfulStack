$(document).ready(function () {

    $("#create-form").submit(function (event) {

        //stop submit the form, we will post it manually.
        event.preventDefault();

        fire_ajax_create();

    });

});

$(document).ready(function () {

    $("#push-form").submit(function (event) {

        //stop submit the form, we will post it manually.
        event.preventDefault();

        fire_ajax_push();

    });

});

$(document).ready(function () {

    $("#pop-button").click(function (event) {

        //stop submit the form, we will post it manually.
        event.preventDefault();

        fire_ajax_pop();

    });

});

$(document).ready(function () {

    $("#peek-button").click(function (event) {

        //stop submit the form, we will post it manually.
        event.preventDefault();

        fire_ajax_peek();

    });

});

$(document).ready(function () {

    $("#reset-button").click(function (event) {

        //stop submit the form, we will post it manually.
        event.preventDefault();

        fire_ajax_reset();

    });

});

function fire_ajax_create() {

    var search = {}
    search["num"] = $("#create").val();


    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/stack/create",
        data: JSON.stringify(search),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {

            var json = "<h4 style=\"color:Tomato;\">Response</h4><pre>"
                + JSON.stringify(data, null, 4) + "</pre>";
            $('#feedback').html(json);
            console.log("SUCCESS : ", data);
        },
        error: function (e) {

            var json = "<h4 style=\"color:Tomato;\">Response</h4><pre>"
                + e.responseText + "</pre>";
            $('#feedback').html(json);
            console.log("ERROR : ", e);
        }
    });

}

function fire_ajax_push() {

    var search = {}
    search["num"] = $("#push").val();

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/stack/push",
        data: JSON.stringify(search),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {

            var json = "<h4 style=\"color:Tomato;\">Response</h4><pre>"
                + JSON.stringify(data, null, 4) + "</pre>";
            $('#feedback').html(json);
            console.log("SUCCESS : ", data);
        },
        error: function (e) {
            var json = "<h4 style=\"color:Tomato;\">Response</h4><pre>"
                + e.responseText + "</pre>";
            $('#feedback').html(json);
            console.log("ERROR : ", e);
        }
    });

}

function fire_ajax_pop() {
    $.ajax({
        type: "DELETE",
        url: "/stack/pop",
        dataType: 'json',
        timeout: 600000,
        success: function (data) {

            var json = "<h4 style=\"color:Tomato;\">Response</h4><pre>"
                + JSON.stringify(data, null, 4) + "</pre>";
            $('#feedback').html(json);

            console.log("SUCCESS : ", data);
        },
        error: function (e) {

            var json = "<h4 style=\"color:Tomato;\">Response</h4><pre>"
                + e.responseText + "</pre>";
            $('#feedback').html(json);

            console.log("ERROR : ", e);
           }
    });

}

function fire_ajax_peek() {
    $.ajax({
        type: "GET",
        url: "/stack/peek",
        dataType: 'json',
        timeout: 600000,
        success: function (data) {

            var json = "<h4 style=\"color:Tomato;\">Response</h4><pre>"
                + JSON.stringify(data, null, 4) + "</pre>";
            $('#feedback').html(json);

            console.log("SUCCESS : ", data);
           },
        error: function (e) {

            var json = "<h4 style=\"color:Tomato;\">Response</h4><pre>"
                + e.responseText + "</pre>";
            $('#feedback').html(json);

            console.log("ERROR : ", e);
            }
    });

}

function fire_ajax_reset() {
    $.ajax({
        type: "GET",
        url: "/stack/reset",
        dataType: 'json',
        timeout: 600000,
        success: function (data) {

            var json = "<h4 style=\"color:Tomato;\">Response</h4><pre>"
                + JSON.stringify(data, null, 4) + "</pre>";
            $('#feedback').html(json);

            console.log("SUCCESS : ", data);
           },
        error: function (e) {

            var json = "<h4 style=\"color:Tomato;\">Response</h4><pre>"
                + e.responseText + "</pre>";
            $('#feedback').html(json);

            console.log("ERROR : ", e);
            }
    });

}
