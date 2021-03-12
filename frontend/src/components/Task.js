import React from "react";
import style from "../styles/Task.module.css";

const Task = props => {

    return (
        <div className={style.Task}>
            <div className={style.DataContainer}>
                <ul className={style.DataList}>

                    <li>
                        <h3>{props.title}</h3>
                    </li>

                    <li>
                        <p>{props.description}</p>
                    </li>

                    <li>
                        {props.deadline}
                    </li>
                </ul>
            </div>

        </div>
    );
}

export default Task;