import { ADD_VACATION } from "../../actions/vacation";

const addVacationActionCreator = value => {

    return {
        type: ADD_VACATION,
        value: value
    }
}

export default addVacationActionCreator;