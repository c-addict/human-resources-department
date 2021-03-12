import React from "react";
import { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import style from "../styles/SignUp.module.css";
import Header from "./Header";
import { useHistory } from "react-router-dom";
import { connect } from "react-redux";
import registerActionCreator from "../store/actionCreators/auth/registerActionCreator";


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
            <h1>Sign up</h1>
            <form className={style.SignUpForm}>
                <fieldset className={style.FormGroup}>
                    <fieldset className={style.FormGroup}>
                        <input
                            className={style.LoginInput}
                            type="text"
                            value={login}
                            placeholder="Login"
                            required
                            onChange={(event) => {setLogin(event.target.value)}}/>
                    </fieldset>

                    <fieldset className={style.FormGroup}>
                        <input
                            className={style.PasswordInput}
                            type="password"
                            value={password}
                            placeholder="Password"
                            required
                            autoComplete="on"
                            onChange={(event) => {setPassword(event.target.value)}}/>
                    </fieldset>

                    <button
                        className={style.SubmitButton}
                        type="submit"
                        onClick={signUp}>
                        Sign up
                    </button>
                </fieldset>
            </form>
            Already have an account?
            <Link to="/login">
                <span> &ensp; Sign in</span>
            </Link>
        </div>
    );
}

export default connect(null, {registerActionCreator})(SignUp);