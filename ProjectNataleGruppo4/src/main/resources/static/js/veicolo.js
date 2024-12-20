
let id = 1;

fetch(`http://localhost:8099/api/veicolo/${id}`)
  .then(response => response.json())
  .then(data => console.log(data))
  .catch(error => console.error('Error:', error));