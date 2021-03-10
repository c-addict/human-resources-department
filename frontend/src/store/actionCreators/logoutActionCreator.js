import { LOGOUT } from "../actions/auth";

const logoutActionCreator = () => {
    return {
        type: LOGOUT
    }
}

export default logoutActionCreator;