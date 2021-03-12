import { LOGIN } from "../../actions/auth";

const loginActionCreator = value => {
    return {
        type: LOGIN,
        value: value
    }
}

export default loginActionCreator;