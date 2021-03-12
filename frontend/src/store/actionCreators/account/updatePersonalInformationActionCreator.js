import { UPDATE_PERSONAL_INFORMATION } from "../../actions/account";

const updatePersonalInformationActionCreator = value => {

    return {
        type: UPDATE_PERSONAL_INFORMATION,
        value: value
    }
}

export default updatePersonalInformationActionCreator;