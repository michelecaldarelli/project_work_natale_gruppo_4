const form = document.querySelector('#loginForm');
const errorMessage = document.querySelector('.error-message');

form.addEventListener('submit', (e) => {
    e.preventDefault();
    const email = document.querySelector('#email').value;
    const password = document.querySelector('#password').value;

    fetch('http://localhost:8099/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ email, password })
    })
    .then(res => res.json())
    .then(data => {
            checkLogin();
            console.log(data.message);
            
            if(data.message != "Utente loggato") {
                errorMessage.innerHTML = data.message;
                document.querySelector('#password').value = "";
                if(data.message != "Password errata") {
                    document.querySelector('#email').value = "";
                }
                errorMessage.classList.remove("d-none");
            }
            else {
                errorMessage.innerHTML = "";
                errorMessage.classList.add("d-none");
                
                let str = window.location.pathname.split("/");
                str[str.length-1] = "homepage.html";
                window.location.pathname = str.join("/");
            }
        })
    .catch(err => {
        console.log(err);
    });
})


