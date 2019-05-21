$(document).ready(function () {
    prepared()
    suspension()
})

function suspension() {
    $("a#product").click(function () {
        var str = "table." + $(this).text()
        $(str).slideDown(300)
        $("div#backGround").show()
        $(str).click(function () {
            $(this).slideUp(300)
            $("div#backGround").hide()
        })
    })
}


function prepared() {
    $("#quantity").on("blur", function () {
        $("form").submit()
    })

    $("#Remove").parent().hide()
    removeChange()
}


function removeChange() {
    var timeout;
    var $r = $("#Remove").parents("tr").find("#productId")

    $r.css("cursor", "hand")
    $r.mousedown(function () {
        timeout = setTimeout(function () {
        }, 2000)
    })

    $r.mouseup(function () {
        clearTimeout(timeout)
        $("#Remove").parent().show(1000, function () {
        })
        changeStatus()
    })
}

function changeStatus() {
    $("#Remove").parent().after("<td hidden='hidden'><a id='cancel' class='Button'>cancel</a></td>")
    $("#cancel").parent().show(1500, function () {
    })
    $("#cancel").click(function () {
        var $r = $("#cancel").parent()
        $r.animate({
            opacity: 0.0,
            paddingLeft: '-=80'
        }, 500, function () {
            $(this).remove()
            $("#Remove").parent().hide(1000, function () {
            })
        })
    })
}