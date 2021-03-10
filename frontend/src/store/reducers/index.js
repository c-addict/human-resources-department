import { combineReducers } from "redux";
import authReducer from "./auth";
import todoReducer from "./todo";
import accountReducer from "./account";
import vacationReducer from "./vacation";

const combinedReducers = combineReducers({
    authReducer,
    todoReducer,
    accountReducer,
    vacationReducer
});

export default combinedReducers;