package com.zelenev.data.dto;

import java.util.Date;
import java.util.List;

public class PersonalInformationDto {

    protected String firstName;

    protected String lastName;

    protected Date birthdayDate;

    protected String phone;

    protected Integer salary;

    protected String department;

    protected String position;

    protected List<AddressDto> addresses;

    public PersonalInformationDto(String firstName,
                                  String lastName,
                                  Date birthdayDate,
                                  String phone,
                                  Integer salary,
                                  String department,
                                  String position,
                                  List<AddressDto> addresses) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdayDate = birthdayDate;
        this.phone = phone;
        this.salary = salary;
        this.department = department;
        this.position = position;
        this.addresses = addresses;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthdayDate() {
        return birthdayDate;
    }

    public void setBirthdayDate(Date birthdayDate) {
        this.birthdayDate = birthdayDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public List<AddressDto> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<AddressDto> addresses) {
        this.addresses = addresses;
    }
}
