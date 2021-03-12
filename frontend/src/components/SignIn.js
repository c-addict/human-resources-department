import React from "react";
import { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import style from "../styles/SignIn.module.css";
import Header from "./Header";
import { useHistory } from "react-router-dom";
import { connect } from "react-redux";
import loginActionCreator from "../store/actionCreators/auth/loginActionCreator";


const SignIn = props => {

    const [login, setLogin] = useState("");
    const [password, setPassword] = useState("");

    const history = useHistory();

    useEffect(
        () => {},
        []
    )

    const signIn = async event => {
        event.preventDefault();
        const url = "http://localhost:8080/login";
        const data = {
            login: login,
            password: password
        };

        await fetch(url, {
            method: "POST",
            headers: {
              "Content-Type": "application/json"
            },
            body: JSON.stringify(data)
        }).then(response => {
            if (response.ok) {
                return response.json();
            }
            throw response;
        }).then(data => {
            const value = {
                login: data.login,
                token: data.token
            };
            props.loginActionCreator(value);
            history.push("/account");
        }).catch(error => {
            console.log(error);
        }).finally(

        );
    }

    return (
        <div className={style.SignIn}>
            <Header/>
            <h1>Sign in</h1>
            <form>
                <fieldset className={style.FormGroup}>
                    <fieldset className={style.FormGroup}>
                        <input type="text"
                        className={style.LoginInput}
                        value={login}
                        placeholder="Login"
                        required
                        onChange={(event) => {setLogin(event.target.value)}}/>
                    </fieldset>
                    <fieldset className={style.FormGroup}>
                        <input type="password"
                               className={style.PasswordInput}
                        value={password}
                        placeholder="Password"
                        required
                        autoComplete="on"
                        onChange={(event) => {setPassword(event.target.value)}}/>
                    </fieldset>
                    <button
                        className={style.SubmitButton}
                        type="submit"
                        onClick={signIn}>
                        Sign in
                    </button>
                </fieldset>
            </form>
            Not registered yet?
            <Link to="/register">
                <span> &ensp; Sign up</span>
            </Link>
        </div>
    );
}

export default connect(null, { loginActionCreator })(SignIn);