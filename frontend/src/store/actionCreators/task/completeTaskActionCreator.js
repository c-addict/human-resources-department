import { COMPLETE_TASK } from "../../actions/task";

const completeTaskActionCreator = value => {

    return {
        type: COMPLETE_TASK,
        value: value
    }
}

export default completeTaskActionCreator;