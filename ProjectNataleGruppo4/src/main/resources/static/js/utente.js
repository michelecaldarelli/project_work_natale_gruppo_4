fetch('http://localhost:8099/login/userData')
    .then(res => res.json())
    .then(data => {
        const profilo = document.querySelector('.profilo-name');
        const listaPrenotazioni = document.querySelector('.lista-prenotazioni');

        // Ruolo - nome dinamico nella welcome section
        if(data.ruolo != null) {
            profilo.innerHTML = `<h1>${data.ruolo} - ${data.nome}</h1>`
        }

        fetch(`http://localhost:8099/api/utente/id:${data.id}`)
            .then(res => res.json())
            .then(data => {
                let prenotazioni = data.prenotazioni;
                prenotazioni.forEach(p => {
                    fetch(`http://localhost:8099/api/veicolo/${p.veicoloId}`)
                        .then(res => res.json())
                        .then(data => {
                            
                            // HO USATO IL CLASSLIST PER BOOTSTRAP STEEE
                            const listItem = document.createElement('li');
                            listItem.classList.add('list-group-item', 'd-flex', 'justify-content-between', 'align-items-center');
                            
                            listItem.innerHTML = `
                                <div>${data.marca} - ${data.modello}</div>
                                <button class="btn">
                                    <i class="fa-regular fa-trash-can"></i> 
                                </button>
                            `;

                            listaPrenotazioni.appendChild(listItem);
                        });
                });
            })
    });


