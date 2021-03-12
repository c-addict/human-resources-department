import { REGISTER } from "../actions/auth";

const registerActionCreator = (value) => {
    return {
        type: REGISTER,
        value: value
    }
}

export default registerActionCreator;