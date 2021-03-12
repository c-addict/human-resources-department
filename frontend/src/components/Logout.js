import React from "react";
import { useEffect } from "react";
import { useHistory } from "react-router-dom";
import logoutActionCreator from "../store/actionCreators/auth/logoutActionCreator";
import { connect } from "react-redux";

const Logout = props => {

    const history = useHistory();

    useEffect(
        () => {
            props.logoutActionCreator();
            history.push("/");
        }
    )

    return (
        <div>

        </div>
    );
}

export default connect(null, { logoutActionCreator })(Logout);