import React, {useState, useEffect} from "react";
import style from "../styles/Registration.module.css";
import service from "../services/AuthenticationService"


const Registration = () => {

    const [login, setLogin] = useState("");
    const [password, setPassword] = useState("");

    useEffect(() => {

    }, [])

    const handleLoginChange = (event) => {
        setLogin(event.target.value);
    }

    const handlePasswordChange = (event) => {
        setPassword(event.target.value);
    }

    const register = (event) => {
        event.preventDefault();
        service.registration(login, password);
    }

    return(
        <div className = {style.Registration}>
            <form>
                <ul>
                    <li>
                        <input type="text" name="login" placeholder="login" value={login} onChange={handleLoginChange}/>
                    </li>

                    <li>
                        <input type="password" name="password" placeholder="password" value={password} onChange={handlePasswordChange}/>
                    </li>

                    <li>
                        <button onClick={register}>Save</button>
                    </li>
                </ul>
            </form>
        </div>
    );
}

export default Registration;