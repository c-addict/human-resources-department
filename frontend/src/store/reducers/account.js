import { SET_PERSONAL_INFORMATION } from "../actions/account";

const initialState = {
        firstName: "",
        lastName: "",
        birthdayDate: new Date(),
        phone: "",
        salary: 0,
        department: "",
        position: "",
        addresses: []
};

const accountReducer = (state = initialState, action) => {
    switch (action.type) {
        case SET_PERSONAL_INFORMATION:
            return {
                    firstName: action.value.firstName,
                    lastName: action.value.lastName,
                    birthdayDate: action.value.birthdayDate,
                    phone: action.value.phone,
                    salary: action.value.salary,
                    department: action.value.department,
                    position: action.value.position,
                    addresses: action.value.addresses
            }
        default:
            return initialState;
    }
}

export default accountReducer;