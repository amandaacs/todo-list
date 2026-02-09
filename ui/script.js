let tasks = [];

$(document).ready(function () {

    $("#taskInput").on("submit", function (e) {
        e.preventDefault();
        saveTask();
    });

});

function saveTask(){

    const index = $("#editIndex").val();

    const task = {
        name: $("#name").val(),
        description: $("#description").val(),
        dueDate: $("#dueDate").val(),
        priority: $("#priority").val(),
        category: $("#category").val(),
        status: $("#status").val(),
    };

    if(index == ""){
        tasks.push(task);
    } else {
        tasks[index] = task;
        $("#editIndex").val("");
    }

    renderTasks();
    clearForm();

}

function renderTasks(){
    const filter = $("#statusFilter").val();

    $("#taskList").html("");

    tasks
        .filter(t => !filter || t.status === filter)
        .forEach((task, index) => {
            $("#taskList").append(`
                <tr>
                    <td>${task.name}</td>
                    <td>${task.category}</td>
                    <td>${task.priority}</td>
                    <td>${task.status}</td>
                    <td>
                        <button onclick="editTask(${index})">Editar</button>
                        <button onclick="deleteTask(${index})">Excluir</button>                        
                    </td>
                </tr>
                `);
        }); 
}

function editTask(index){
    const task = tasks[index];

    $("#name").val(task.name);
    $("#description").val(task.description);
    $("#dueDate").val(task.dueDate);
    $("#priority").val(task.priority);
    $("#category").val(task.category);
    $("#status").val(task.status);
    $("#editIndex").val(index);
}

function deleteTask(index){

    tasks.splice(index, 1);
    renderTasks();

}

function clearForm(){

    $("#name, #description, #dueDate, #category").val("");
    $("#editIndex").val("");

}

