/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii._ConsumeAPI.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author iqbaloutlaw
 */
@Entity
@Table(name = "emp_join")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmpJoin.findAll", query = "SELECT e FROM EmpJoin e")
    , @NamedQuery(name = "EmpJoin.findById", query = "SELECT e FROM EmpJoin e WHERE e.id = :id")})
public class EmpJoin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "batch_class", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private BatchClass batchClass;
    @JoinColumn(name = "employee", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Employee employee;

    public EmpJoin() {
    }

    public EmpJoin(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BatchClass getBatchClass() {
        return batchClass;
    }

    public void setBatchClass(BatchClass batchClass) {
        this.batchClass = batchClass;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpJoin)) {
            return false;
        }
        EmpJoin other = (EmpJoin) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mii._ConsumeAPI.entities.EmpJoin[ id=" + id + " ]";
    }
    
}
