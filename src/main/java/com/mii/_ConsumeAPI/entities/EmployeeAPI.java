/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii._ConsumeAPI.entities;

import java.util.List;

/**
 *
 * @author BWP
 */
public class EmployeeAPI {
    private List<String> roles;
    private String id, firstName, lastName, email, birthDate,birthPlace,gender,
            isDelete,department, nationality;
    private EmployeeAPI manager;

    public List<String> getRoles() {
        return roles;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public String getGender() {
        return gender;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public String getDepartment() {
        return department;
    }

    public String getNationality() {
        return nationality;
    }

    public EmployeeAPI getManager() {
        return manager;
    }

    
    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setManager(EmployeeAPI manager) {
        this.manager = manager;
    }
    
    
}
