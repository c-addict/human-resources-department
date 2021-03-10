import { UPDATE_PERSONAL_INFORMATION } from "../actions/account";

const initialState = {

};

const accountReducer = (state = initialState, action) => {
    switch (action.type) {
        case UPDATE_PERSONAL_INFORMATION:
            return action.value;
        default:
            return initialState;
    }
}

export default accountReducer;