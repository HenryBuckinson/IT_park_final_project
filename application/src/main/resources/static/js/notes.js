$(document).ready(function () {

    $('.rowInfo > .noteHead > #noteText').on("keyup", function (event) {
        if (event.keyCode === 13) {
            // alert("Enter")
            let textNote = $(this).val();
            let textOrder = this.parentNode.previousElementSibling.textContent;
            let numberOrder = Number(textOrder);
            if (textNote === "") {
                $.ajax({
                    url: '/api/notes/delete/' + numberOrder,
                    type: 'DELETE',
                    success: function () {
                        alert('Пустая заметка удалена!');
                        location.href = '/notes';
                    }
                });
            } else {
                $.ajax({
                    url: '/api/notes/update/' + numberOrder,
                    type: 'PUT',
                    headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                    },
                    data: JSON.stringify({
                        'note': textNote,
                    }),
                    success: function () {
                        alert('Заметка обновлена!');
                    }
                });
            }
        }
    })//скриипт обрабатывает текстовое поле заметки

    $('.rowInfo').on('change', '#statusNoteSelector', function () {
        // alert("No enter")
        let val = $(this).val();
        let parent = $(this).parent().parent().parent();
        let textOrder = parent[0].firstElementChild.childNodes[0].textContent;
        let numberNoteOrder = Number(textOrder);
        // alert(val)
        // alert(numberNoteOrder)
        if (val === "0") {
            let response = String(false);
            $.ajax({
                url: '/api/notes/set-status/' + numberNoteOrder + '/?status=' + response,
                type: 'POST',
                success: function () {
                    alert('Заметка в процессе выполнения');
                    location.reload();
                }
            });
        }
        if (val === "1") {
            let response = String(true);
            $.ajax({
                url: '/api/notes/set-status/' + numberNoteOrder + "/?status=" + response,
                type: 'POST',
                success: function () {
                    alert('Заметка завершена!');
                    location.reload();
                }
            });
        }
    })//скрипт для обработки статуса заметки

    $(document).ready(function () {
        $('#toDoListTable > #tableBody > #onlyOneRow').each(function (outerIndex, row) {
            let val = row.querySelector('#statusNoteSelector').value;
            if (val === "0") {
                $(this).css('background-color', 'cornsilk');
            }
            if (val === "1") {
                $(this).css('background-color', 'darkseagreen');
            }
        })
    })//скрипт для цветовой окраски строки при загрузке

});
