import { ADD_VACATION, REMOVE_VACATION } from "../actions/vacation";

const initialState = [];

const vacationReducer = (state = initialState, action) => {
    switch (action.type) {
        case ADD_VACATION:
            return [...state, action.value];
        case REMOVE_VACATION:
            //TODO
            return null;
        default:
            return initialState;
    }
}

export default vacationReducer;