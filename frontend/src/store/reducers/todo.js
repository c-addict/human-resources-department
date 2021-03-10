import { ADD_TASK, COMPLETE_TASK } from "../actions/todo";

const initialState = [];

const todoReducer = (state = initialState, action) => {
    switch (action.type) {
        case ADD_TASK:
            return [...state, action.value];
        case COMPLETE_TASK:
            return state;
        default:
            return state;
    }
};

export default todoReducer;