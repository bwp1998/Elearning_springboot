/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii._ConsumeAPI.entities;

/**
 *
 * @author BWP
 */
public class EmployeeLogin {
    
    private EmployeeAPI employee;
    private String status;

    public void setEmployee(EmployeeAPI employee) {
        this.employee = employee;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public EmployeeAPI getEmployee() {
        return employee;
    }

    public String getStatus() {
        return status;
    }
    
    
}
