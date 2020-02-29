/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii._ConsumeAPI.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author BWP
 */
@Entity
@Table(name = "study_class")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StudyClass.findAll", query = "SELECT s FROM StudyClass s")
    , @NamedQuery(name = "StudyClass.findById", query = "SELECT s FROM StudyClass s WHERE s.id = :id")
    , @NamedQuery(name = "StudyClass.findByName", query = "SELECT s FROM StudyClass s WHERE s.name = :name")
    , @NamedQuery(name = "StudyClass.findByRoomName", query = "SELECT s FROM StudyClass s WHERE s.roomName = :roomName")})
public class StudyClass implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "room_name")
    private String roomName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "class1", fetch = FetchType.LAZY)
    private List<BatchClass> batchClassList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studyClass", fetch = FetchType.LAZY)
    private List<Theory> theoryList;

    public StudyClass() {
    }

    public StudyClass(Integer id) {
        this.id = id;
    }

    public StudyClass(Integer id, String name, String roomName) {
        this.id = id;
        this.name = name;
        this.roomName = roomName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    @XmlTransient
    public List<BatchClass> getBatchClassList() {
        return batchClassList;
    }

    public void setBatchClassList(List<BatchClass> batchClassList) {
        this.batchClassList = batchClassList;
    }

    @XmlTransient
    public List<Theory> getTheoryList() {
        return theoryList;
    }

    public void setTheoryList(List<Theory> theoryList) {
        this.theoryList = theoryList;
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
        if (!(object instanceof StudyClass)) {
            return false;
        }
        StudyClass other = (StudyClass) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mii._ConsumeAPI.entities.StudyClass[ id=" + id + " ]";
    }
    
}
