import { SET_VACATIONS } from "../../actions/vacation";

const setVacationsActionCreator = value => {

    return {
        type: SET_VACATIONS,
        value: value
    }
}

export default setVacationsActionCreator;