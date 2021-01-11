
const REGISTRATION_URL = "http://localhost:8080/registration";
const LOGIN_URL = "http://localhost:8080/login";

class AuthenticationService {

    registration = async (login, password) => {
        const registrationData = {
            login: login,
            password: password
        }

        await fetch(REGISTRATION_URL,
            {
                method: 'POST',
                body: JSON.stringify(registrationData),
                headers: {
                    'Content-Type': 'application/json'
                }
        });
    }

    login = async (login, password) => {

        const loginData = {
            login: login,
            password: password
        };

        const response = await fetch(LOGIN_URL,
            {
                method: "POST",
                body: JSON.stringify(loginData),
                headers: {
                    'Content-Type': 'application/json'
                }
            });

        const data = await response.json();

        localStorage.setItem("token", data.token);
    }
}


export default new AuthenticationService();