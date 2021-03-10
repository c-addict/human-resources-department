import React from "react";
import style from "../styles/Contacts.module.css";
import Header from "./Header";

const Contacts = props => {

    return (
        <div className={style.Contacts}>
            <Header/>
        </div>
    );
}

export default Contacts;