document.addEventListener("DOMContentLoaded", function () {
    let tasksBtn = document.querySelector("#tasks-link");
    let logsBtn = document.querySelector("#logs-link");
    let tasksView = document.querySelector("#tasks");
    let logsView = document.querySelector("#logs");
    let tasksContent = document.querySelector("#tasks-content");
    let logsContent = document.querySelector("#logs-content");



    tasksBtn.classList.add("active");
    logsView.classList.add("hidden");
    logsContent.classList.add("hidden");

    tasksBtn.addEventListener("click", function (event) {
        tasksBtn.classList.add("active");
        logsBtn.classList.remove("active");

        logsContent.classList.add("hidden");
        logsView.classList.add("hidden");

        tasksView.classList.remove("hidden");
        tasksContent.classList.remove("hidden");
    });
    logsBtn.addEventListener("click", function (event) {
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
    let apiURL = 'wr/';
    let htmlString = '';
    let clientName = '';
    let clientID;
    let locationName = '';
    let locClientID;
    let taskNum = 0;
    let clientList = [];
    let clientIdList = [];
    let locationList = [];
    let taskList = [];
    let button = false;

    fetch(apiURL + 'client')
        .then(resc => resc.json())
        .then(function (json) {
            cliFetch(json);
        })
        .catch(err => console.log(err));


    let cliFetch = clients => {

//        for (let client of clients) {

            fetch(apiURL + 'client/' )//+ client.clientid)
                //.then(resc => resc.json())
                .then(function (response) {
                    return response.json();
                })
                .then(json => {

                    clientName = json.clientname;
                    clientList.push(clientName);

                    clientID = json.clientid;
                    clientIdList.push(clientID);

                    fetch(apiURL + 'location')
                        .then(resc => resc.json())
                        .then(function (json) {
                            locsFetch(json);
                        })
                        .catch(err => console.log(err));
                });

      //  };

    };

    let locsFetch = locations => {
        //   for (let loc of locations) {
        fetch(apiURL + 'location/')//+ loc.locid)
            .then(function (response) {
                return response.json();
            })
            .then(function (myjson) {
                for (let i = 0; i < clientIdList.length; i++) {
                    htmlString += `<div class = "title">` + clientList[i] + `</div>
                    <ul>`;
                    for (let j of myjson) {
                        //console.log(clientIdList[i])
                       // console.log(j.locname)

                        locationName = j.locname;
                        if (j.clientid === clientIdList[i]) {
                            htmlString += `<li>
                            <span>`+locationName+`</span>
                            </li>`;
                        }

                    }
                }
                htmlString += `</ul>
                </div>`;

                document.getElementById('locstest').innerHTML = htmlString;


            });
    }
   
});
 /* document.getElementById('urgent-btn').checked = false; */



    // The X sign button that cancel add task in the form



                /* locName = myjson.locname;
                 locClientID = myjson.clientID;
                 // console.log(clientIdList.length);
                 console.log(myjson.clientid);
                 for (let j of myjson) {
                     k = j;
                     let jidnum = k.clientid;
                 }
                 for (let i of clientIdList) {
                     let idnum = clientIdList[i];


                 }*/


                /*htmlString += `<div class ="title">${clientName}</div>
                                        <ul>
                                        <li class="checked">`;
                                    document.getElementById('locstest').innerHTML = htmlString;*/



                //  })