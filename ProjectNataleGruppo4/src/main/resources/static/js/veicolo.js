

fetch(`http://127.0.0.1:5500/src/main/resources/static/veicolo.html`)
  .then(response => response.json())
  .then(data => console.log(data))
  .catch(error => console.error('Error:', error));