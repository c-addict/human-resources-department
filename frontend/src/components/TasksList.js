import React from "react";
import { useEffect, useState } from "react";
import style from "../styles/TasksList.module.css";
import { connect } from "react-redux";
import setTasksActionCreator from "../store/actionCreators/task/setTasksActionCreator";
import addTaskActionCreator from "../store/actionCreators/task/addTaskActionCreator";
import Task from "./Task";
import Header from "./Header";

const TasksList = props => {

    const [newTaskTitle, setNewTaskTitle] = useState("");
    const [newTaskDescription, setNewTaskDescription] = useState("");
    const [newTaskDeadline, setNewTaskDeadline] = useState(new Date());

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

    const createTask = async event => {
        const url = `http://localhost:8080/work/task/${props.login}`;

        const task = {
            title: newTaskTitle,
            description: newTaskDescription,
            deadline: newTaskDeadline
        }

        await fetch(url, {
            method: "PUT",
            headers: {
                "Content-Type": "application/json",
                "Authorization": `Bearer ${props.token}`,
            },
            body: JSON.stringify(task)
        }).then((response) => {
            console.log(response);
        })

        setNewTaskTitle("");
        setNewTaskDescription("");
    }


    return (
        <div className={style.TasksList}>
            <Header/>
            { props.tasks.map((task, index) => {
                return <Task
                        title={task.title}
                        description={task.description}
                        deadline={task.deadline}/>
            }) }

            <div className={style.NewTaskForm}>
                <form>
                    <fieldset className={style.FormGroup}>
                        <fieldset className={style.FormGroup}>
                            <input
                                type="text"
                                className={style.InputField}
                                placeholder="Title"
                                value={newTaskTitle}
                                onChange={(event) => {setNewTaskTitle(event.target.value)}}
                            />
                        </fieldset>

                        <fieldset className={style.FormGroup}>
                            <input
                                type="text"
                                className={style.InputField}
                                placeholder="Description"
                                value={newTaskDescription}
                                onChange={(event) => {setNewTaskDescription(event.target.value)}}
                            />
                        </fieldset>

                        <fieldset className={style.FormGroup}>
                            <input
                                type="date"
                                className={style.InputField}
                                value={newTaskDeadline}
                                onChange={(event) => {setNewTaskDeadline(event.target.value)}}
                            />
                        </fieldset>
                    </fieldset>

                    <button
                        className={style.AddTaskButton}
                        onClick={createTask}
                    >Create
                    </button>
                </form>

            </div>
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


export default connect(mapStateToProps, { setTasksActionCreator, addTaskActionCreator })(TasksList);