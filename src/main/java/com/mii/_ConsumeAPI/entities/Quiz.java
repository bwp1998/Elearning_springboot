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
@Table(name = "quiz")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Quiz.findAll", query = "SELECT q FROM Quiz q")
    , @NamedQuery(name = "Quiz.findById", query = "SELECT q FROM Quiz q WHERE q.id = :id")
    , @NamedQuery(name = "Quiz.findByDetail", query = "SELECT q FROM Quiz q WHERE q.detail = :detail")
    , @NamedQuery(name = "Quiz.findByQuizTime", query = "SELECT q FROM Quiz q WHERE q.quizTime = :quizTime")
    , @NamedQuery(name = "Quiz.findByPassingGrade", query = "SELECT q FROM Quiz q WHERE q.passingGrade = :passingGrade")})
public class Quiz implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 400)
    @Column(name = "detail")
    private String detail;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quiz_time")
    private int quizTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "passing_grade")
    private int passingGrade;
    @JoinColumn(name = "theory", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Theory theory;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "quiz", fetch = FetchType.LAZY)
    private List<Question> questionList;

    public Quiz() {
    }

    public Quiz(String id) {
        this.id = id;
    }

    public Quiz(String id, String detail, int quizTime, int passingGrade) {
        this.id = id;
        this.detail = detail;
        this.quizTime = quizTime;
        this.passingGrade = passingGrade;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getQuizTime() {
        return quizTime;
    }

    public void setQuizTime(int quizTime) {
        this.quizTime = quizTime;
    }

    public int getPassingGrade() {
        return passingGrade;
    }

    public void setPassingGrade(int passingGrade) {
        this.passingGrade = passingGrade;
    }

    public Theory getTheory() {
        return theory;
    }

    public void setTheory(Theory theory) {
        this.theory = theory;
    }

    @XmlTransient
    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
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
        if (!(object instanceof Quiz)) {
            return false;
        }
        Quiz other = (Quiz) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mii._ConsumeAPI.entities.Quiz[ id=" + id + " ]";
    }
    
}
