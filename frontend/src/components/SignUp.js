import React from "react";
import { useState, useEffect } from "react";
import style from "../styles/SignUp.module.css";
import Header from "./Header";
import { useHistory } from "react-router-dom";
import { connect } from "react-redux";
import registerActionCreator from "../store/actionCreators/registerActionCreator";


const SignUp = props => {

    const [login, setLogin] = useState("");
    const [password, setPassword] = useState("");

    const history = useHistory();

    useEffect(
        () => {},
        []
    )

    const signUp = async event => {
        event.preventDefault();
        const url = "http://localhost:8080/registration"
        const data = {
            login: login,
            password: password
        }
        await fetch(url, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(data)
        }).then(response => {
            if (response.ok) {
                console.log(response);
                setLogin("");
                setPassword("");
                return response.json();
            }
            throw response;
        }).then(data => {
            console.log(data);
            history.push("/");
        }).catch(error => {
            console.log(error);
        }).finally(
        )
    }

    return (
        <div className={style.SignUp}>
            <Header/>
            <form>
                <fieldset className={style.FormGroup}>
                    <fieldset className={style.FormGroup}>
                        <input
                            type="text"
                            value={login}
                            placeholder="Login"
                            required
                            onChange={(event) => {setLogin(event.target.value)}}/>
                    </fieldset>

                    <fieldset className={style.FormGroup}>
                        <input
                            type="password"
                            value={password}
                            placeholder="Password"
                            required
                            onChange={(event) => {setPassword(event.target.value)}}/>
                    </fieldset>

                    <button
                        type="submit"
                        onClick={signUp}>
                        Sign up
                    </button>
                </fieldset>
            </form>
        </div>
    );
}

export default connect(null, {registerActionCreator})(SignUp);