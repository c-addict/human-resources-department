import { SET_TASKS } from "../../actions/task";


const setTasksActionCreator = value => {

    return {
        type: SET_TASKS,
        value: value
    };
}

export default setTasksActionCreator;