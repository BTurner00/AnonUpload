function getFiles(data) {
    for (var i in data) {
        var elem = $("<a>");
        elem.attr("href", "/files/" + data[i].realFileName);
        elem.text(data[i].originalFileName);
        $("#list").append(elem);
        $("#list").append($("<br>"));
    }
}


$.get("/files", getFiles)