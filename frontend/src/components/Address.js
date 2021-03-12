import React from "react";
import { useEffect } from "react";
import style from "../styles/Address.module.css";


const Address = props => {

    useEffect(() => {

    }, []);

    return (
        <div className={style.Address}>
            <ul>

                <li>
                    {props.country}
                </li>

                <li>
                    {props.city}
                </li>

                <li>
                    {props.street}
                </li>

                <li>
                    {props.building}
                </li>

                <li>
                    {props.postcode}
                </li>
            </ul>
        </div>
    );
}

export default Address;