
function send() {
    if (($("#name").val().length > 0) && ($("#msg").val().length)) {
        $.post("ChatServlet", {name: $("#name").val(), msg: $("#msg").val()}, ajaxCallBack);
        document.getElementById("name").value = "";
        document.getElementById("msg").value = "";
    }
}
function ajaxCallBack(responseTxt, statusTxt, xhr) {
    if (statusTxt == "success")
//                     alert("External content loaded successfully!");
        if (statusTxt == "error")
            alert("Error: " + xhr.status + ": " + xhr.statusText);
}
function chat() {

    $.get("ChatServlet", ajaxgetCallBack);
}

function parseJSONResponse(jsonRes) {
    if (jsonRes.length != 0) {
$("#table2").empty();
        for (i = 0; i < jsonRes.length; i++) {
             chatContent = "<tr class=\"row100\">";
            chatContent += "<td class=\"column100 column2\" data-column=\"column1\">";
            chatContent += jsonRes[i].name;
            chatContent += "</td>";
            chatContent += "<td class=\"column100 column1\" data-column=\"column2\">";
            chatContent += jsonRes[i].msg;
            chatContent += "</td>";
            chatContent += "</tr>";
$("#table2").append(chatContent);

        }
    }
    console.log(jsonRes.length);

}
function ajaxgetCallBack(responseTxt, statusTxt, xhr) {
    if (statusTxt == "success") {
        console.log(responseTxt);
        var res = JSON.parse(responseTxt);
        parseJSONResponse(res);
    }

}