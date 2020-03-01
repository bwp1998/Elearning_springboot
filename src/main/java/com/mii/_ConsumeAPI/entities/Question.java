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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "question")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Question.findAll", query = "SELECT q FROM Question q")
    , @NamedQuery(name = "Question.findById", query = "SELECT q FROM Question q WHERE q.id = :id")
    , @NamedQuery(name = "Question.findByQuestion", query = "SELECT q FROM Question q WHERE q.question = :question")
    , @NamedQuery(name = "Question.findByOption1", query = "SELECT q FROM Question q WHERE q.option1 = :option1")
    , @NamedQuery(name = "Question.findByOption2", query = "SELECT q FROM Question q WHERE q.option2 = :option2")
    , @NamedQuery(name = "Question.findByOption3", query = "SELECT q FROM Question q WHERE q.option3 = :option3")
    , @NamedQuery(name = "Question.findByOption4", query = "SELECT q FROM Question q WHERE q.option4 = :option4")
    , @NamedQuery(name = "Question.findByQuestionKey", query = "SELECT q FROM Question q WHERE q.questionKey = :questionKey")})
public class Question implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "question")
    private String question;
    @Size(max = 25)
    @Column(name = "option_1")
    private String option1;
    @Size(max = 25)
    @Column(name = "option_2")
    private String option2;
    @Size(max = 25)
    @Column(name = "option_3")
    private String option3;
    @Size(max = 25)
    @Column(name = "option_4")
    private String option4;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "question_key")
    private String questionKey;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "question", fetch = FetchType.LAZY)
    private List<AnswerQuestion> answerQuestionList;
    @JoinColumn(name = "quiz", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Quiz quiz;

    public Question() {
    }

    public Question(Integer id) {
        this.id = id;
    }

    public Question(Integer id, String question, String questionKey) {
        this.id = id;
        this.question = question;
        this.questionKey = questionKey;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public String getQuestionKey() {
        return questionKey;
    }

    public void setQuestionKey(String questionKey) {
        this.questionKey = questionKey;
    }

    @XmlTransient
    public List<AnswerQuestion> getAnswerQuestionList() {
        return answerQuestionList;
    }

    public void setAnswerQuestionList(List<AnswerQuestion> answerQuestionList) {
        this.answerQuestionList = answerQuestionList;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
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
        if (!(object instanceof Question)) {
            return false;
        }
        Question other = (Question) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mii._ConsumeAPI.entities.Question[ id=" + id + " ]";
    }
    
}
