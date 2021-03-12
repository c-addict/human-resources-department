import { LOGOUT, LOGIN, REGISTER } from "../actions/auth";

const initialState = {
    login: "",
    token: "",
    isLoggedIn: false
};

const authReducer = (state = initialState, action) => {
    switch (action.type) {
        case LOGIN:
            return {
                login: action.value.login,
                token: action.value.token,
                isLoggedIn: true
            };

        case LOGOUT:
            return initialState;

        case REGISTER:
            return {
                login: action.value.login,
                token: action.value.token,
                isLoggedIn: true
            };

        default:
            return state;
    }
}

export default authReducer;