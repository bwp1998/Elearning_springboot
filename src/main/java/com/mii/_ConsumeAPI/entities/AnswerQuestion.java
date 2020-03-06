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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author BWP
 */
@Entity
@Table(name = "answer_question")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AnswerQuestion.findAll", query = "SELECT a FROM AnswerQuestion a")
    , @NamedQuery(name = "AnswerQuestion.findById", query = "SELECT a FROM AnswerQuestion a WHERE a.id = :id")
    , @NamedQuery(name = "AnswerQuestion.findByAnswer", query = "SELECT a FROM AnswerQuestion a WHERE a.answer = :answer")
    , @NamedQuery(name = "AnswerQuestion.findByIsTrue", query = "SELECT a FROM AnswerQuestion a WHERE a.isTrue = :isTrue")})
public class AnswerQuestion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "answer")
    private String answer;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_true")
    private int isTrue;
    @JoinColumn(name = "emp_bundle_answer", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EmpBundleAnswer empBundleAnswer;
    @JoinColumn(name = "question", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Question question;

    public AnswerQuestion() {
    }

    public AnswerQuestion(Integer id) {
        this.id = id;
    }

    public AnswerQuestion(Integer id, String answer, int isTrue) {
        this.id = id;
        this.answer = answer;
        this.isTrue = isTrue;
    }

    public AnswerQuestion(Integer id, String answer, int isTrue, EmpBundleAnswer empBundleAnswer, Question question) {
        this.id = id;
        this.answer = answer;
        this.isTrue = isTrue;
        this.empBundleAnswer = empBundleAnswer;
        this.question = question;
    }

    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getIsTrue() {
        return isTrue;
    }

    public void setIsTrue(int isTrue) {
        this.isTrue = isTrue;
    }

    public EmpBundleAnswer getEmpBundleAnswer() {
        return empBundleAnswer;
    }

    public void setEmpBundleAnswer(EmpBundleAnswer empBundleAnswer) {
        this.empBundleAnswer = empBundleAnswer;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
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
        if (!(object instanceof AnswerQuestion)) {
            return false;
        }
        AnswerQuestion other = (AnswerQuestion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mii._ConsumeAPI.entities.AnswerQuestion[ id=" + id + " ]";
    }
    
}
