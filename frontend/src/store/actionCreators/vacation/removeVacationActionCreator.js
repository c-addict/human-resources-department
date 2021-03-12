import { REMOVE_VACATION } from "../../actions/vacation";

const removeVacationActionCreator = value => {

    return {
        type: REMOVE_VACATION,
        value: value
    }
}

export default removeVacationActionCreator;