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
fetch(apiUrl + 'client')
        .then(resc => resc.json())
        .then(function (json) {
            clientsFetch(json);
        })
        .catch(err => console.log(err));


const clientsFetch = clients => {
    let htmlString = '';
    let clientName = '';
    let locName = '';
    let taskNum = 0;
    let button = false;
    
    for (let client of clients) {
        console.log(client);
        fetch(apiUrl + 'client/' + client.clientid)
                .then(resc => resc.json())
                .then(json => {
                    clientName = json.clientname;
                    htmlString += `<div class ="title">${clientName}</div>
                        <ul>
                            <li class="checked">`;
                    let locationFetch = locs => {
                        

                        for (let loc of locs) {
                            fetch(apiUrl + 'location/' + loc.locationID)
                                    .then(resl => resl.json())
                                    .then(json => {
                                        locName = json.locname;
                                        
                                        htmlString += `<span>${locName}</span>
                                        <div class="info">`;
                                        
                                        let taskFetch = tasks => {                                            
                                            
                                            for (let task of tasks){
                                                fetch(apiUrl + 'task/'+taskid)
                                                        .then(rest => rest.json())
                                                        .then(json =>{
                                                            taskNum++;
                                                            button = true;
                                                            
                                                        })
                                                .catch(err => console.log(err));
                                        
                                            }
                                            if(button){
                                                htmlString += `<div class = "button green">Finished</div>`;
                                            }else{
                                                htmlString += `<div class = "button">Tasks: ${taskNum}</div>`;
                                            }
                                        };
                                        
                                    })
                                    .catch(err => console.log(err));

                        }
                    };
                    htmlString += `</div>
                    </li>
                    </ul>`;
                    document.querySelector('#locstest').innerHTML = htmlString;

                })
                .catch(err => console.log(err));
    }

};
  /* document.getElementById('urgent-btn').checked = false; */
  


// The X sign button that cancel add task in the form
