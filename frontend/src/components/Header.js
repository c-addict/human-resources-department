import React, {useState, useEffect} from "react";
import style from "../styles/Header.module.css";

const Header = () => {

    useEffect(() => {

    },
        [])

    return(
        <div className={style.Header}>
            <img src="" alt="logo"/>

            <div className={style.HeaderNavigationContainer}>

            </div>

            <div className={style.HeaderAccountContainer}>

            </div>
        </div>
    );
}

export default Header;