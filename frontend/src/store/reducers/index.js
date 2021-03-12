import { combineReducers } from "redux";
import authReducer from "./auth";
import tasksReducer from "./task";
import accountReducer from "./account";
import vacationReducer from "./vacation";

const combinedReducers = combineReducers({
    authReducer,
    tasksReducer,
    accountReducer,
    vacationReducer
});

export default combinedReducers;