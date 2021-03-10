import React from "react";
import style from "../styles/App.module.css";
import { BrowserRouter as Router, Switch, Route} from "react-router-dom";
import Home from "./Home";
import SignIn from "./SignIn";
import SignUp from "./SignUp";
import About from "./About";
import Contacts from "./Contacts";
import Logout from "./Logout";
import Account from "./Account";


const App = props => {

    return (
        <div className={style.App}>
            <Router>
                <Switch>
                    <Route exact path="/" component={Home}/>
                    <Route path="/about" component={About}/>
                    <Route path="/contacts" component={Contacts}/>
                    <Route path="/login" component={SignIn}/>
                    <Route path="/register" component={SignUp}/>
                    <Route path="/logout" component={Logout}/>
                    <Route path="/account" component={Account}/>
                </Switch>
            </Router>
        </div>
    );
}
export default App;
