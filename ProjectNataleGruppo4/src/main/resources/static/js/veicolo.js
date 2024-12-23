fetch(`http://localhost:8099/api/veicolo/${localStorage.getItem("idVeicolo")}`)
.then(response => response.json())
.then(data => {

      const nomeVeicolo = document.querySelector('.marca-modello');
      const immagineVeicolo = document.querySelector('.immagine-veicolo');
      const categoriaVeicolo = document.querySelector('.categoria');
      const descVeicolo = document.querySelector('.descrizione');
      const aliVeicolo = document.querySelector('.alimentazione');
      const indirizzo = document.querySelector('.indirizzo');
  
      console.log(data.immagineVeicolo);
      console.log(immagineVeicolo);
      

  
      nomeVeicolo.innerHTML = `${data.marca} - ${data.modello}`;
      immagineVeicolo.setAttribute("src", `images/img-database/${data.immagineVeicolo}`);
      categoriaVeicolo.innerHTML = data.categoria;
      descVeicolo.innerHTML = data.descrizione;
      aliVeicolo.innerHTML = data.alimentazione;
      indirizzo.innerHTML = data.indirizzo;
      const progressCircle = document.querySelector(".autoplay-progress svg");
      const progressContent = document.querySelector(".autoplay-progress span");
      var swiper = new Swiper(".mySwiper", {
        spaceBetween: 30,
        centeredSlides: true,
        autoplay: {
          delay: 5000,
          disableOnInteraction: false,
        },
        pagination: {
          el: ".swiper-pagination",
          clickable: true,
        },
        navigation: {
          nextEl: ".swiper-button-next",
          prevEl: ".swiper-button-prev",
        }
      });
      
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
})















    
