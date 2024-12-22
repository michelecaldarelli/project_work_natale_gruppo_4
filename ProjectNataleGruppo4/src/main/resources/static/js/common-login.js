const loginName = document.querySelector(".login-name");
const btnLogin = document.querySelector(".btn-login");

/* --------------------- FUNZIONE CHE CONTROLLA CHI E' LOGGATO -------------------- */
async function checkLogin() {
    if(window.location.pathname != "/login" || btnLogin.textContent === "Logout"){
        btnLogin.classList.remove("d-none");
    }
    fetch('http://localhost:8099/login/userData')
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
                loginName.innerHTML = `${data.ruolo}: ${data.nome}`;

                btnLogin.textContent="Logout";
                btnLogin.classList.remove("d-none");
            }
            else {
                loginName.classList.add("d-none");
                if(window.location.pathname === "/login") {
                    btnLogin.classList.add("d-none");
                }
                btnLogin.textContent="Accedi";
            }
        })
        .catch(e => console.log(e))
}

checkLogin();

/* -------------------------- BOTTONE LOGIN/LOGOUT -------------------------- */
btnLogin.addEventListener('click', e =>{
    if(btnLogin.innerHTML === "Logout") {
        fetch('/logout')
            .then(res => res.json())
            .then(data => {
                window.location.href='./homepage.html';
                checkLogin();
        })
    }
    else {
        let str = window.location.pathname.split("/");
        str[str.length-1] = "login.html";
        window.location.pathname = str.join("/");
    }
});