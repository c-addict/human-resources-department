import React from "react";
import { useState, useEffect } from "react";
import style from "../styles/Account.module.css";
import Header from "./Header";

const EditView = props => {

    return (
        <div>

        </div>
    );
}

const StaticView = props => {

    return (
        <div>

        </div>
    );
}

const Account = props => {

    const [isEdit, setIsEdit] = useState(false);

    useEffect(
        () => {},
        [isEdit]
    )

    return (
        <div className={style.Account}>
            <Header/>
            <button onClick={(event) => {setIsEdit(!isEdit)}}>Edit</button>
            <div>
                { isEdit ? <EditView/> : <StaticView/> }
            </div>
        </div>
    );

}

export default Account;