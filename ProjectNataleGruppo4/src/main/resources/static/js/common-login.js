const loginName = document.querySelector(".login-name");
const btnLogin = document.querySelector(".btn-login");

async function checkLogin() {
    fetch('/login/userData')
        .then(res => {
            if (res.status === 200) {
            return res.json();
        } else {
            throw new Error(`Nessun utente loggato`);
        }})
        .then(data => {
            console.log(data);
            if(data.nome != null) {
                loginName.classList.remove("d-none");

                console.log("siamo qui");
                loginName.innerHTML = `${data.ruolo}: ${data.nome}`;

                btnLogin.textContent="Logout";
            }
            else {
                console.log("ao");
                
                loginName.classList.add("d-none");
                btnLogin.textContent="Accedi";
            }
        })
        .catch(e => console.log(e))
}

checkLogin();


btnLogin.addEventListener('click', e =>{
    if(btnLogin.innerHTML === "Logout") {
        fetch('/logout')
            .then(res => res.json())
            .then(data => {
                console.log(data);
                checkLogin();
        })
    }
    else {
        let str = window.location.pathname.split("/");
        str[str.length-1] = "login.html";
        window.location.pathname = str.join("/");
    }
});