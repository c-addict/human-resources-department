import React from "react";
import { useState, useEffect } from "react";
import style from "../styles/Account.module.css";
import Header from "./Header";
import { connect } from "react-redux";
import Address from "./Address";
import setPersonalInformationActionCreator from "../store/actionCreators/account/setPersonalInformationActionCreator";

const EditableView = props => {

    return (
        <div>
            <form>

                <fieldset className={style.FormGroup}>

                    <fieldset className={style.FormGroup}>
                        <input
                            className={style.EditInputField}
                            type="text"
                            value={props.firstNameValue}
                            placeholder="First name"
                            onChange={props.firstNameChangeCallback}
                            required
                        />
                    </fieldset>

                    <fieldset className={style.FormGroup}>
                        <input
                            className={style.EditInputField}
                            type="text"
                            value={props.lastNameValue}
                            placeholder="Last name"
                            onChange={props.lastNameChangeCallback}
                            required
                        />
                    </fieldset>

                    <fieldset className={style.FormGroup}>
                        <input
                            className={style.EditInputField}
                            type="date"
                            value={props.birthdayDateValue}
                            onChange={props.birthdayDateChangeCallback}
                        />
                    </fieldset>

                    <fieldset className={style.FormGroup}>
                        <input
                            className={style.EditInputField}
                            type="text"
                            value={props.phoneValue}
                            placeholder="Phone"
                            onChange={props.phoneChangeCallback}
                            required
                        />
                    </fieldset>

                    <fieldset className={style.FormGroup}>
                        <input
                            className={style.EditInputField}
                            type="text"
                            value={props.salaryValue}
                            placeholder="Salary"
                            onChange={props.salaryChangeCallback}
                        />
                    </fieldset>

                    <fieldset className={style.FormGroup}>
                        <input
                            className={style.EditInputField}
                            type="text"
                            value={props.departmentValue}
                            placeholder="Department"
                            onChange={props.departmentChangeCallback}
                        />
                    </fieldset>

                    <fieldset className={style.FormGroup}>
                        <input
                            className={style.EditInputField}
                            type="text"
                            value={props.positionValue}
                            placeholder="Position"
                            onChange={props.positionChangeCallback}
                        />
                    </fieldset>

                    {props.addresses.map((address, index) => {
                        return <li>
                            <Address/>
                        </li>
                    })}

                    <button
                        className={style.SaveButton}
                        type="submit"
                        onClick={props.saveCallback}
                    >Save
                    </button>

                    <button
                        className={style.EditButton}
                        onClick={props.editCallback}>
                        Edit
                    </button>
                </fieldset>

            </form>

        </div>
    );
}

const StaticView = props => {

    return (
        <div className={style.StaticView}>
            <div className={style.StaticViewContainer}>

                <h1>Personal information</h1>

                <ul className={style.DateList}>

                    <li>
                        <span>First name: { props.firstName }</span>
                    </li>

                    <li>
                        <span>Last name: { props.lastName }</span>
                    </li>

                    <li>
                        <span>Birthday date: { props.birthdayDate }</span>
                    </li>

                    <li>
                        <span>Phone: { props.phone }</span>
                    </li>

                    <li>
                        <span>Salary: { props.salary }</span>
                    </li>

                    <li>
                        <span>Department: { props.department }</span>
                    </li>

                    <li>
                        <span>Position: { props.position }</span>
                    </li>

                    {props.addresses.map((address, index) => {
                        //TODO addresses
                        return <li>
                            <Address />
                        </li>;
                    })}
                </ul>
                <button className={style.EditButton} onClick={props.editCallback}>Edit</button>
            </div>
        </div>
    );
}

const Account = props => {

    const [isEdit, setIsEdit] = useState(false);

    //const history = useHistory();


    //data state
    const [firstName, setFirstName] = useState("");
    const [lastName, setLastName] = useState("");
    const [birthdayDate, setBirthdayDate] = useState("2020-12-12");
    const [phone, setPhone] = useState("");
    const [salary, setSalary] = useState(0);
    const [department, setDepartment] = useState("");
    const [position, setPosition] = useState("");
    const [addresses, setAddresses] = useState([]);

    useEffect(
        () => {
            if (!isEdit) {
                const url = `http://localhost:8080/data/${props.login}`;
                fetch(url, {
                    method: "GET",
                    headers: {
                        "Content-Type": "application/json",
                        "Authorization": `Bearer ${props.token}`,
                        "Accept": "*/*"
                    }
                }).then((response) => {
                    if (response.ok) {
                        return response.json();
                    }
                    throw response;
                }).then((data) => {
                    setFirstName(data.firstName);
                    setLastName(data.lastName);
                    setBirthdayDate(data.birthdayDate);
                    setPhone(data.phone);
                    setSalary(data.salary);
                    setDepartment(data.department);
                    setPosition(data.position);
                    setAddresses(data.addresses);

                    const value  = {
                        firstName: data.firstName,
                        lastName: data.lastName,
                        birthdayDate: data.birthdayDate,
                        phone: data.phone,
                        salary: data.salary,
                        department: data.department,
                        position: data.position,
                        addresses: data.addresses
                    };

                    props.setPersonalInformationActionCreator(value);
                }).catch((error) => {
                    console.log(error);
                })
            }

        },
        [isEdit]
    );

    const savePersonalInformation = async event => {
        const updatedPersonalInformation = {
                firstName: firstName,
                lastName: lastName,
                birthdayDate: birthdayDate,
                phone: phone,
                salary: salary,
                department: department,
                position: position,
                addresses: addresses
        };

        const url = `http://localhost:8080/data/${props.login}`
        await fetch(url, {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
                "Authorization": `Bearer ${props.token}`,
                "Accept": "*/*"
            },
            body: JSON.stringify(updatedPersonalInformation)
        }).then((response) => {
            if (response.ok) {
                return response.json();
            }
            throw response;
        }).then((data) => {
            console.log(data);
        }).catch((error) => {
            console.log(error);
        })

        setIsEdit(false);

        //props.setPersonalInformationActionCreator(updatedPersonalInformation);
        //TODO: create post method to update personal information in data base
    }

    return (
        <div className={style.Account}>
            <Header/>
            <div>
                { isEdit ?
                    <EditableView

                        firstNameValue = {firstName}
                        firstNameChangeCallback = {(event) => {setFirstName(event.target.value)}}

                        lastNameValue = {lastName}
                        lastNameChangeCallback = {(event) => {setLastName(event.target.value)}}

                        birthdayDateValue = {birthdayDate}
                        birthdayDateChangeCallback = {(event) => {setBirthdayDate(event.target.value)}}

                        phoneValue = {phone}
                        phoneChangeCallback = {(event) => {setPhone(event.target.value)}}

                        salaryValue = {salary}
                        salaryChangeCallback = {(event) => {setSalary(event.target.value)}}

                        departmentValue = {department}
                        departmentChangeCallback={(event) => {setDepartment(event.target.value)}}

                        positionValue = {position}
                        positionChangeCallback = {(event) => {setPosition(event.target.value)}}

                        addresses = {addresses}

                        saveCallback={savePersonalInformation}

                        editCallback={()=> {setIsEdit(!isEdit)}}
                    />
                    : <StaticView
                        firstName={firstName}
                        lastName={lastName}
                        birthdayDate={birthdayDate}
                        phone={phone}
                        salary={salary}
                        department={department}
                        position={position}
                        addresses={addresses}
                        editCallback={()=>{setIsEdit(!isEdit)}}/> }
            </div>
        </div>
    );

}

const mapStateToProps = state => {
    const { login, token, isLoggedIn } = state.authReducer;

    return {
        login: login,
        token: token,
        isLoggedIn: isLoggedIn
    }
}

export default connect(mapStateToProps,
    { setPersonalInformationActionCreator })(Account);