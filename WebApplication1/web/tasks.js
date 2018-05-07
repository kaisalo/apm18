let tasksBtn = document.querySelector("#tasks-link");
let logsBtn = document.querySelector("#logs-link");
let tasksView = document.querySelector("#tasks");
let logsView = document.querySelector("#logs");
let tasksContent = document.querySelector("#tasks-content");
let logsContent = document.querySelector("#logs-content");


tasksBtn.classList.add("active");
logsView.classList.add("hidden");
logsContent.classList.add("hidden");

tasksBtn.addEventListener("click", function(event) {
    tasksBtn.classList.add("active");
    logsBtn.classList.remove("active");
    
    logsContent.classList.add("hidden");
    logsView.classList.add("hidden");
    
    tasksView.classList.remove("hidden");  
    tasksContent.classList.remove("hidden");
});
logsBtn.addEventListener("click", function(event) {
    logsBtn.classList.add("active");
    tasksBtn.classList.remove("active");
    
    logsView.classList.remove("hidden");
    logsContent.classList.remove("hidden");
    
    tasksView.classList.add("hidden");
    tasksContent.classList.add("hidden");
});


function addButton() {
  document.getElementById("hidden-add-form").style.visibility = "visible";
}; //The plus sign button that shows the form

function cancelButton() {
  document.getElementById("hidden-add-form").style.visibility = "hidden";
  document.getElementById("my-form").reset();

  /* document.getElementById('urgent-btn').checked = false; */
  

}; // The X sign button that cancel add task in the form