
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
