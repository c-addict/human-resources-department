import { ADD_TASK } from "../../actions/task";

const addTaskActionCreator = value => {

    return {
        type: ADD_TASK,
        value: value
    }
}

export default addTaskActionCreator;