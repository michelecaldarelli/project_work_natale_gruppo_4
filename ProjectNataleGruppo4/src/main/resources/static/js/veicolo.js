fetch(`http://localhost:8099/api/veicolo/${localStorage.getItem("idVeicolo")}`)
.then(response => response.json())
.then(data => {

      const nomeVeicolo = document.querySelector('.marca-modello');
      const immagineVeicolo = document.querySelector('.immagine-veicolo');
      const categoriaVeicolo = document.querySelector('.categoria');
      const descVeicolo = document.querySelector('.descrizione');
      const aliVeicolo = document.querySelector('.alimentazione');
      const indirizzo = document.querySelector('.indirizzo');
      const noleggiaBtn = document.querySelector('.btn-noleggia');   

  
      nomeVeicolo.innerHTML = `${data.marca} - ${data.modello}`;
      immagineVeicolo.setAttribute("src", `images/img-database/${data.immagineVeicolo}`);
      categoriaVeicolo.innerHTML = data.categoria;
      descVeicolo.innerHTML = data.descrizione;
      aliVeicolo.innerHTML = data.alimentazione;
      indirizzo.innerHTML = data.indirizzo;

      checkDisponibilita(data);
      
      var map = L.map("map").setView([51.505, -0.09], 14);
      L.tileLayer("https://tile.openstreetmap.org/{z}/{x}/{y}.png", {
        attribution:
          '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors',
      }).addTo(map);
      
      const addressElement = document.getElementById("vehicle-address");
      const address = addressElement.textContent;
      
      function getCoordinatesFromAddress(address) {
        const geocodeUrl = `https://nominatim.openstreetmap.org/search?format=json&q=${encodeURIComponent(
          address
        )}`;
      
        fetch(geocodeUrl)
          .then((response) => response.json())
          .then((data) => {
            if (data.length > 0) {
              const { lat, lon } = data[0];
      
              map.setView([lat, lon], 14);
              L.marker([lat, lon])
                .addTo(map)
                .bindPopup(`Indirizzo: ${address}`)
                .openPopup();
            } else {
              console.error("Indirizzo non trovato!");
            }
          })
          .catch((error) => console.error("Errore nella geocodifica:", error));
      }
      
      getCoordinatesFromAddress(address);
      
      addressElement.addEventListener("input", () => {
        getCoordinatesFromAddress(addressElement.textContent);
      });
      
      noleggiaBtn.addEventListener('click', e => {
        if(noleggiaBtn.innerHTML == "Noleggia Ora") {
          fetch(`http://localhost:8099/api/veicolo/prenota:${localStorage.getItem("idVeicolo")}`, 
          {
            method: 'PUT'
          })
          .then(res => res.json())
          .then(data => {
            console.log(data);
            checkDisponibilita(data);
          })
          .catch(err => console.log(err))
        }
      });
})


function checkDisponibilita(data) {
  const noleggiaBtn = document.querySelector('.btn-noleggia');

  if (data.disponibilita == 0) {
    noleggiaBtn.innerHTML = "Non Disponibile";
    noleggiaBtn.classList.remove("btn-primary"); 
    noleggiaBtn.classList.add("btn-danger");  
    noleggiaBtn.setAttribute("disabled", "true"); 
  } else {
    noleggiaBtn.innerHTML = "Noleggia Ora";
    noleggiaBtn.classList.remove("btn-danger"); 
    noleggiaBtn.classList.add("btn-primary"); 
    noleggiaBtn.removeAttribute("disabled"); 
  }
}
