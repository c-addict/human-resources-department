import { ADD_TASK, COMPLETE_TASK, SET_TASKS } from "../actions/task";

const initialState = {
    tasks: []
};

const tasksReducer = (state = initialState, action) => {
    switch (action.type) {
        case ADD_TASK:
            return {
                tasks: [...state, action.value]
            };
        case COMPLETE_TASK:
            return state;
        case SET_TASKS:
            return {
                tasks: action.value
            }
        default:
            return state;
    }
};

export default tasksReducer;