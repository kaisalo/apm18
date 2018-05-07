function addButton() {
    document.getElementById("hidden-add-form").style.visibility = "visible";
}
; //The plus sign button that shows the form

function cancelButton() {
    document.getElementById("hidden-add-form").style.visibility = "hidden";
    document.getElementById("my-form").reset();

    /* document.getElementById('urgent-btn').checked = false; */
}
; // The X sign button that cancel add task in the form

//IN PROGRESS
let apiUrl = 'wr/';

fetch(apiUrl + 'task')
        .then(re => res.json())
        .then(function (json) {
            tasksFetch(json);
        })
        .catch(err => console.log(err));

const taskFetch = tasks => {
    let htmlString = '';
    let clientName = '';

    for (let task of tasks) {
        fetch(apiUrl + 'client/' + task.clientID)
                .then(res => res.json())
                .then(json => {
                    clientName = json.clientname;
                    htmlString += `<div class="title">${task.clientname}></div>
<ul><li class ="checked">
<span>${task.}`;
                })
    }

};