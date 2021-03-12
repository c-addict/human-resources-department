import { ADD_VACATION, REMOVE_VACATION, SET_VACATIONS } from "../actions/vacation";

const initialState = {
    vacations: []
};

const vacationReducer = (state = initialState, action) => {
    switch (action.type) {
        case ADD_VACATION:
            return {
                vacations: [...state, action.value]
            };
        case REMOVE_VACATION:
            //TODO
            return null;
        case SET_VACATIONS:
            return {
                vacations: action.value
            }

        default:
            return initialState;
    }
}

export default vacationReducer;