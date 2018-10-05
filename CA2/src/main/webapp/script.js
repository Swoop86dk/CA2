const root = document.getElementById("root");
const btn = document.getElementById("btnCreateNewPerson");
const url = 'http://localhost:8084/CA2/api/Person/';
const resource = 'allasarray';

console.log("url: ", url + 'all');
const update = () => {
    let content = '<h2>List of all persons</h2>';
    fetch(url + resource, {method: 'GET'})
            .then((response) => response.json())
            .then((data) => {
                content += '<table><tr><th>ID</th><th>Name</th><th>Age</th><th></th><th></th></tr>';
                content += data.map(el => `<tr><td>${el.id}</td><td>${el.FirstName}</td><td>${el.LastName}</td><td>${el.Phones}</td><td>
                <td>${el.Email}</td><td><td>${el.Hobbies}</td><td>
                <a href="#" class="btnedit" id=${el.id}>edit</a> / 
                <a href="#" class="btndelete" id=${el.id}>delete</a>
                </td><td><span id="editform${el.id}"/></td></tr>`).join("");
                content += '</table>';
                root.innerHTML = content;
                const del = document.getElementsByClassName("btndelete");
                const edit = document.getElementsByClassName("btnedit");
                clickHandler(del);
                clickHandler(edit);
            }).catch(error => {
        console.log('get error: ', error);
    });
};
update();
btn.onclick = () => {
    const FirstName = document.getElementById("FirstName").value;
    const LastName = document.getElementById("LastName").value;
    const Phones = document.getElementById("Phones").value;
    const Email = document.getElementById("Email").value;
    const Hobbies = document.getElementById("Hobbies").value;
    const data = {FirstName, LastName, Phones, Email, Hobbies};

    fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json; charset=utf-8'
        },
        body: JSON.stringify(data) // body data type must match "Content-Type" header
    }).then((res) => res.json()).then((data) => {
        console.log('data from post', data);
        update();
    }).catch(error => console.log(error));
};
//take a collection of clickable elements like in this case buttons of either edit og delete.
const clickHandler = (elements) => {
    [...elements].forEach(el => {
        el.onclick = (event) => { //clicking the edit button on any of the persons.
            const className = event.target.className;
            const id = event.target.id;
            if (className === 'btndelete')
                deleteData(event.target.id);
            if (className === 'btnedit') {

                const editform = document.getElementById(`editform${id}`);
                editform.innerHTML = `<input type="text" id="newFirstName${id}" value="">
                <input type="text" id="newLastName${id}" value="">
                <input type="text" id="newPhones${id}" value="">
                <input type="text" id="newEmail${id}" value="">
                <input type="text" id="newHobbies${id}" value="">
                <button class="submitEdit" id="${id}">Submit</button>`;


                [...document.getElementsByClassName("submitEdit")].forEach(el => el.onclick = (event) => {
                        const newFirstName = document.getElementById(`newFirstName${id}`).value;
                        const newLastName = document.getElementById(`newLastName${id}`).value;
                        const newPhones = document.getElementById(`newPhones${id}`).value;
                        const newEmail = document.getElementById(`newEmail${id}`).value;
                        const newHobbies = document.getElementById(`newHobbies${id}`).value;
                        updateData(event.target.id, newFirstName, newLastName, newPhones, newEmail, newHobbies);
                        editform.innerHTML = '';
                    });

            }
        };
    });
};
// IKKE FÆRDIG - data sendes ikke med i request body af en eller anden grund.
const updateData = (id, FirstName, LastName, Phones, Email, Hobbies) => {
    const per = {FirstName, LastName, Phones, Email, Hobbies};
    fetch(url + id, {
        method: 'put',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(per)
    }).then(resp => resp.json()).then((data) => {
        console.log(data);
        update();
    }).catch((err) => console.log(err));
};

const deleteData = (id) => {
//    console.log(`id: ${id}`);
    fetch(url + id, {method: 'DELETE'}).then(resp => resp.json()).then((data) => {
        console.log('data from delete: ', data);
        update();
    }).catch((error) => {
        console.log(error);
    });
};


