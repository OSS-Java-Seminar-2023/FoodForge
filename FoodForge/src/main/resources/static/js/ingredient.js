function openCreateModal() {
    var createModal = document.getElementById('createModal');
    createModal.style.display = 'block';
}

function closeCreateModal() {
    var createModal = document.getElementById('createModal');
    createModal.style.display = 'none';
}

function openUpdateModal(id, name, unit) {
    var updateModal = document.getElementById('updateModal');
    updateModal.style.display = 'block';

    let ingredientId = id.toString();

    document.getElementById('updateForm').action = "/admin/ingredients/update/" + ingredientId;

    document.getElementById('updatedIngredientName').value = name;
    document.getElementById('updatedUnit').value = unit;
}
function openCreateModal() {
    var createModal = document.getElementById('createModal');
    createModal.style.display = 'block';
}

function closeCreateModal() {
    var createModal = document.getElementById('createModal');
    createModal.style.display = 'none';
}

function openUpdateModal(id, name, unit) {
    var updateModal = document.getElementById('updateModal');
    updateModal.style.display = 'block';

    let ingredientId = id.toString();

    document.getElementById('updateForm').action = "/admin/ingredients/update/" + ingredientId;

    document.getElementById('updatedIngredientName').value = name;
    document.getElementById('updatedUnit').value = unit;
}

function closeUpdateModal() {
    var updateModal = document.getElementById('updateModal');
    updateModal.style.display = 'none';
}


function openDeleteModal(id) {
    var deleteModal = document.getElementById('deleteModal');
    deleteModal.style.display = 'block';

    document.getElementById('deleteForm').action = "/admin/ingredients/delete/" + id;
    document.getElementById('deleteIngredientId').value = id;
}

function closeDeleteModal() {
    var deleteModal = document.getElementById('deleteModal');
    deleteModal.style.display = 'none';
}

window.onclick = function (event) {
    var createModal = document.getElementById('createModal');
    var updateModal = document.getElementById('updateModal');

    if (event.target === createModal) {
        createModal.style.display = 'none';
    }

    if (event.target === updateModal) {
        updateModal.style.display = 'none';
    }
};
function closeUpdateModal() {
    var updateModal = document.getElementById('updateModal');
    updateModal.style.display = 'none';
}


function openDeleteModal(id) {
    var deleteModal = document.getElementById('deleteModal');
    deleteModal.style.display = 'block';

    document.getElementById('deleteForm').action = "/admin/ingredients/delete/" + id;
    document.getElementById('deleteIngredientId').value = id;
}

function closeDeleteModal() {
    var deleteModal = document.getElementById('deleteModal');
    deleteModal.style.display = 'none';
}

window.onclick = function (event) {
    var createModal = document.getElementById('createModal');
    var updateModal = document.getElementById('updateModal');

    if (event.target === createModal) {
        createModal.style.display = 'none';
    }

    if (event.target === updateModal) {
        updateModal.style.display = 'none';
    }
};