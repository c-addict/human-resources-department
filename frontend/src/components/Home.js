import React from "react";
import style from "../styles/Home.module.css";
import Header from "./Header";

const Home = props => {

    return (
        <div className={style.Home}>
            <Header/>
        </div>
    );
}

export default Home;