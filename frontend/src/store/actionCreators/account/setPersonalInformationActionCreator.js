import { SET_PERSONAL_INFORMATION } from "../../actions/account";

const setPersonalInformationActionCreator = value => {
    return {
        type: SET_PERSONAL_INFORMATION,
        value: value
    }
}

export default setPersonalInformationActionCreator;