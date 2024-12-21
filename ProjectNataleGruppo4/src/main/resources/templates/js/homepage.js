
const titles = [
  "Affidabilità",
  "Versatilità",
  "Sostenibilità"
];

const descriptions = [
  "Disponibilità garantita dei veicoli prenotati, veicoli regolarmente controllati e in ottime condizioni e assistenza clienti disponibile in qualsiasi momento. Affidabilità significa sapere che ogni volta che ne hai bisogno, il tuo veicolo è lì per te: perfettamente manutenuto, facilmente accessibile e sempre pronto a partire. Con il nostro servizio di car sharing, ti garantiamo un’esperienza senza intoppi, supporto continuo e la certezza di un viaggio sereno, ogni volta.",
  "Versatilità è adattarsi al tuo stile di vita: un'auto per ogni occasione, da un veloce spostamento urbano a una fuga nel weekend, o una semplice bicicletta per una passeggiata con gli affetti. Con il nostro servizio di car sharing, hai la libertà di scegliere il veicolo giusto, quando vuoi, per soddisfare ogni tua esigenza con semplicità e flessibilità.",
  "Sostenibilità è più di una scelta, è un impegno: muoversi in modo responsabile, ridurre l'impatto ambientale e contribuire a città più pulite. Con il nostro car sharing, ogni viaggio è un passo verso un futuro più verde, grazie a veicoli efficienti e soluzioni pensate per rispettare il pianeta."
];

const titleElement = document.getElementById("carousel-title");
const descriptionElement = document.getElementById("carousel-description");

var swiper = new Swiper(".mySwiper", {
  spaceBetween: 30,
  centeredSlides: true,
  autoplay: {
    delay: 5000,
    disableOnInteraction: false
  },
  pagination: {
    el: ".swiper-pagination",
    clickable: true
  },
  navigation: {
    nextEl: ".swiper-button-next",
    prevEl: ".swiper-button-prev"
  },
  on: {
    slideChange: function () {
      const activeIndex = this.activeIndex;
      titleElement.textContent = titles[activeIndex];
      descriptionElement.textContent = descriptions[activeIndex];
    }
  }
});

titleElement.textContent = titles[0];
descriptionElement.textContent = descriptions[0];


/* ------------------------ CARDS VEICOLI DISPONIBILI ----------------------- */

const veicoliDisponibili = document.querySelector('.cards-disponibili');

fetch('http://localhost:8099/api/veicolo')
  .then(response => response.json())
  .then(data => {
    for(let i = 0; i<data.length; i++){
      if(data[i].disponibilita) {
        veicoliDisponibili.innerHTML += `
          <div class="card-container col-sm-12 col-md-6 col-lg-3 d-flex justify-content-center">
            <div class="card" style="width: 15rem;">
              <img class="card-img-top" src="images/img-database/${data[i].immagineVeicolo}" alt="Card image cap">
              <div class="card-body">
                <h5 class="card-title">${data[i].marca} - ${data[i].modello}</h5>
                <p class="card-text">
                  Categoria: ${data[i].categoria}<br />
                  Alimentazione: ${data[i].alimentazione}<br />
                  Indirizzo: ${data[i].indirizzo}<br />
                </p>
                <a href="veicolo.html" class="btn btn-outline-primary">Scopri di più</a>
              </div>
            </div>
          </div>
        `;
      }
    }
  })
  .catch(error => console.error('Error:', error));



/* ------------------------ CARDS VEICOLI NOLEGGIATI ----------------------- */

const veicoliNoleggiati = document.querySelector('.cards-noleggiati');

fetch('http://localhost:8099/api/veicolo')
  .then(response => response.json())
  .then(data => {
    for(let i = 0; i<data.length; i++){
      if(!data[i].disponibilita) {
        veicoliNoleggiati.innerHTML += `
          <div class="card-container col-sm-12 col-md-6 col-lg-3 d-flex justify-content-center">
            <div class="card" style="width: 15rem;">
              <img class="card-img-top" src="images/img-database/${data[i].immagineVeicolo}" alt="Card image cap">
              <div class="card-body">
                <h5 class="card-title">${data[i].marca} - ${data[i].modello}</h5>
                <p class="card-text">
                  Categoria: ${data[i].categoria}<br />
                  Alimentazione: ${data[i].alimentazione}<br />
                  Indirizzo: ${data[i].indirizzo}<br />
                </p>
                <a href="veicolo.html" class="btn btn-outline-primary">Scopri di più</a>
              </div>
            </div>
          </div>
        `;
      }
    }
  })
  .catch(error => console.error('Error:', error));