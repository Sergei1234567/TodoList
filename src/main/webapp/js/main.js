function deleteItem(id) {
    $.ajax({
        url: `/item?value=${id}`,
        type: "DELETE",
        success: () => {
            document.getElementById(id).remove();
        },
        error: () => {

        }
    });
}