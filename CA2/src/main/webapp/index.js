let data; 
function requestID(id){
    var URL = 'http://localhost:8080/CA2/api/Person/'+id;
    fetch(URL)
    .then(response =>response.json())
    .then(json => {
        console.log(json);
        document.getElementById("info").innerHTML = '<br><p><b>Person  : </b></p><p>ID: ' + json.id + '</p><p>Name: ' + json.firstName + '</p>';
    });
}
function requestAll(url, div)
{
    var res = '<table style = width: 100%><tr id = "tableHead"><th>ID</th><th>First Name</th><th>Last Name</th><th>Email</th><th>Phone</th><th>Hobby</th><th>Address</th></tr>';
    for(i = 1; i <= 10; i++)
    {
        res += '<id =' + i + '>'
        fetch(url+i)
        .then(response => response.json())
        .then(json => 
            {
                console.log('Current i value: ' + res);
                console.log(json);
                document.getElementById('tableHead').insertAdjacentHTML('afterend', '<tr><td>'+json.id+'</td><td>'+json.firstName+'</td><td>'+json.lastName+'</td><td>'+json.email+'</td><td>'+json.phones+'</td><td>'+json.hobbies+'</td><td>'+json.addresses+'</td></tr>')
                
            });
    }
    res += '</table>';
    document.getElementById(div).innerHTML = res;
}

function deletePerson(id) {
  return fetch('http://localhost:8080/CA2/api/Person/'+id, {
    method: 'delete'
  })
  .then(response => response.json());
}


function createPerson(firstName, id) {
  return fetch('http://localhost:8080/CA2/api/Person/'+id, {
    method: 'POST'
  })
  .then(response => response.json());
}
