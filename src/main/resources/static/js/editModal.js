function DeleteObj(objName, id) {
    var btnDeleteModal = document.getElementById("DeleteModalButton");
    btnDeleteModal.setAttribute("href", objName + "/remove/" + id);
}


function editBoss(id, name, salary) {
    document.getElementById("editModalForm").action = "/boss/update/" + id;
    document.getElementById("editName").value = name;
    document.getElementById("editSalary").value = salary;
}