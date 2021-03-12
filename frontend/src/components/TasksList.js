import React from "react";
import { useEffect } from "react";
import style from "../styles/TasksList.module.css";
import { connect } from "react-redux";
import setTasksActionCreator from "../store/actionCreators/task/setTasksActionCreator";
import Task from "./Task";
import Header from "./Header";

const TasksList = props => {

    useEffect(
        () => {

            const url = `http://localhost:8080/work/task/${props.login}`
            fetch(url, {
                method: "GET",
                headers: {
                    "Content-Type": "application/json"
                }
            }).then(response => {
                if (response.ok) {
                    return response.json();
                }
                throw response;
            }).then(data => {
                props.setTasksActionCreator(data);
            })
        }, [])

    return (
        <div className={style.TasksList}>
            <Header/>
            { props.tasks.map((task, index) => {
                return <Task
                        title={task.title}
                        description={task.description}
                        deadline={task.deadline}/>
            }) }
        </div>
    );


}

const mapStateToProps = state => {
    const { login, isLoggedIn } = state.authReducer;
    const { tasks } = state.tasksReducer;

    return {
        login,
        isLoggedIn,
        tasks
    }
};


export default connect(mapStateToProps, { setTasksActionCreator })(TasksList);