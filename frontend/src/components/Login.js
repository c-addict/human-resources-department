import React, {useState, useEffect} from "react";
import service from "../services/AuthenticationService";
import style from "../styles/Login.module.css";


const Login = () => {

    const [login, setLogin] = useState("");
    const [password, setPassword] = useState("");

    useEffect(() => {

    }, []);

    const handleLoginChange = (event) => {
        setLogin(event.target.value);
    }

    const handlePasswordChange = (event) => {
        setPassword(event.target.value);
    }

    const handleLogin = (event) => {
        event.preventDefault();
        service.login(login, password);
    }

    return(
        <div className={style.Login}>
            <form>
                <ul>
                    <li>
                        <input type="text" name="login" placeholder="login" value={login} onChange={handleLoginChange}/>
                    </li>

                    <li>
                        <input type="password" name="password" placeholder="password" value={password} onChange={handlePasswordChange}/>
                    </li>

                    <li>
                        <button onClick={handleLogin}>Login</button>
                    </li>
                </ul>
            </form>
        </div>
    );
}

export default Login;