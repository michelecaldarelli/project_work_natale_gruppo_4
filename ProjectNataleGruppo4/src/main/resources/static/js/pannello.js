const pannello = document.querySelector('.pannello');




pannello.addEventListener('submit', e => {
    e.preventDefault();

    console.log(document.querySelector('#categoria-veicolo'));
    
    const categoriaVeicolo = document.querySelector('#categoria-veicolo').value;
    const marca = document.querySelector('#marca').value;
    const modello = document.querySelector('#modello').value;
    const descrizione = document.querySelector('#descrizione').value;
    const alimentazione = document.querySelector('#alimentazione').value;
    const indirizzo = document.querySelector('#indirizzo').value;



    fetch('http://localhost:8099/api/veicolo', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ categoriaVeicolo, marca, modello, descrizione, alimentazione, indirizzo, "disponibilita": "true"})
    })
    .then(res => res.json())
    .then(data => {
           console.log(data);   
        })
    .catch(err => {
        console.log(err);
    });
    

    
})