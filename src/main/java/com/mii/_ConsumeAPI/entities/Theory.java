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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * @author iqbaloutlaw
 */
@Entity
@Table(name = "theory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Theory.findAll", query = "SELECT t FROM Theory t")
    , @NamedQuery(name = "Theory.findById", query = "SELECT t FROM Theory t WHERE t.id = :id")
    , @NamedQuery(name = "Theory.findByTheoryTitle", query = "SELECT t FROM Theory t WHERE t.theoryTitle = :theoryTitle")
    , @NamedQuery(name = "Theory.findByTheoryDefiniton", query = "SELECT t FROM Theory t WHERE t.theoryDefiniton = :theoryDefiniton")
    , @NamedQuery(name = "Theory.findByFileMatery", query = "SELECT t FROM Theory t WHERE t.fileMatery = :fileMatery")})
public class Theory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "theory_title")
    private String theoryTitle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4000)
    @Column(name = "theory_definiton")
    private String theoryDefiniton;
    @Size(max = 100)
    @Column(name = "file_matery")
    private String fileMatery;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "theory", fetch = FetchType.LAZY)
    private List<Quiz> quizList;
    @JoinColumn(name = "creator", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Employee creator;
    @JoinColumn(name = "study_class", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private StudyClass studyClass;

    public Theory() {
    }

    public Theory(Integer id) {
        this.id = id;
    }

    public Theory(Integer id, String theoryTitle, String theoryDefiniton) {
        this.id = id;
        this.theoryTitle = theoryTitle;
        this.theoryDefiniton = theoryDefiniton;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTheoryTitle() {
        return theoryTitle;
    }

    public void setTheoryTitle(String theoryTitle) {
        this.theoryTitle = theoryTitle;
    }

    public String getTheoryDefiniton() {
        return theoryDefiniton;
    }

    public void setTheoryDefiniton(String theoryDefiniton) {
        this.theoryDefiniton = theoryDefiniton;
    }

    public String getFileMatery() {
        return fileMatery;
    }

    public void setFileMatery(String fileMatery) {
        this.fileMatery = fileMatery;
    }

    @XmlTransient
    public List<Quiz> getQuizList() {
        return quizList;
    }

    public void setQuizList(List<Quiz> quizList) {
        this.quizList = quizList;
    }

    public Employee getCreator() {
        return creator;
    }

    public void setCreator(Employee creator) {
        this.creator = creator;
    }

    public StudyClass getStudyClass() {
        return studyClass;
    }

    public void setStudyClass(StudyClass studyClass) {
        this.studyClass = studyClass;
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
        if (!(object instanceof Theory)) {
            return false;
        }
        Theory other = (Theory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mii._ConsumeAPI.entities.Theory[ id=" + id + " ]";
    }
    
}
