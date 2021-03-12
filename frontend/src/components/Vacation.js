import React from "react";
import style from "../styles/Vacation.module.css";


const Vacation = props => {

    return (
        <div className={style.Vacation}>
            <ul>

                <li>
                    {props.startDate}
                </li>

                <li>
                    {props.endDate}
                </li>

            </ul>
        </div>
    );
}

export default Vacation;