import React, { useEffect } from "react";
import style from "../styles/Header.module.css";
import { Link } from "react-router-dom";
import { connect } from "react-redux";

const StaticLinks = props => {

    return (
        <div className={style.LinksContainer}>
            <ul className={style.LinksUl}>
                <li>
                    <Link to="/">
                        Home
                    </Link>
                </li>
                <li>
                    <Link to="/about">
                        About
                    </Link>
                </li>

                <li>
                    <Link to="/contacts">
                        Contacts
                    </Link>
                </li>
            </ul>
        </div>
    );
}

const LoggedInLinksView = props => {

    return (
        <div>
            <StaticLinks/>

            <div className={style.LinksContainer}>
                <ul className={style.LinksUl}>
                    <li>
                        <Link to="/account">
                            {props.login}
                        </Link>
                    </li>

                    <li>
                        <Link to="/logout">
                            Logout
                        </Link>
                    </li>
                </ul>
            </div>
        </div>
    );
}

const LoggedOutLinksView = props => {

    return (
        <div>
            <StaticLinks/>

            <div className={style.LinksContainer}>
                <ul className={style.LinksUl}>
                    <li>
                        <Link to="/login">
                            Sign in
                        </Link>
                    </li>

                    <li>
                        <Link to="/register">
                            Sign up
                        </Link>
                    </li>
                </ul>
            </div>
        </div>
    );
}

const Header = props => {


    useEffect(
        () => {},
        []);


    return (
        <div className={style.Header}>

            <div className={style.ImageContainer}>
                <img src="" alt="logo"/>
            </div>

            { props.isLoggedIn ?
                <LoggedInLinksView login={props.login}/> :
                <LoggedOutLinksView/>
            }
        </div>
    );
}

const mapStateToProps = state => {

    const { login, isLoggedIn } = state.authReducer;

    return {
        login,
        isLoggedIn
    };
}

export default connect(mapStateToProps)(Header);