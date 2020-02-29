/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii._ConsumeAPI.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author BWP
 */
@Entity
@Table(name = "emp_action")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmpAction.findAll", query = "SELECT e FROM EmpAction e")
    , @NamedQuery(name = "EmpAction.findById", query = "SELECT e FROM EmpAction e WHERE e.id = :id")
    , @NamedQuery(name = "EmpAction.findByAction", query = "SELECT e FROM EmpAction e WHERE e.action = :action")
    , @NamedQuery(name = "EmpAction.findByActionDate", query = "SELECT e FROM EmpAction e WHERE e.actionDate = :actionDate")
    , @NamedQuery(name = "EmpAction.findByActionComment", query = "SELECT e FROM EmpAction e WHERE e.actionComment = :actionComment")
    , @NamedQuery(name = "EmpAction.findByRate", query = "SELECT e FROM EmpAction e WHERE e.rate = :rate")})
public class EmpAction implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 7)
    @Column(name = "ACTION")
    private String action;
    @Basic(optional = false)
    @NotNull
    @Column(name = "action_date")
    @Temporal(TemporalType.DATE)
    private Date actionDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "action_comment")
    private String actionComment;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rate")
    private int rate;
    @JoinColumn(name = "forum", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Forum forum;

    public EmpAction() {
    }

    public EmpAction(Integer id) {
        this.id = id;
    }

    public EmpAction(Integer id, Date actionDate, String actionComment, int rate) {
        this.id = id;
        this.actionDate = actionDate;
        this.actionComment = actionComment;
        this.rate = rate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Date getActionDate() {
        return actionDate;
    }

    public void setActionDate(Date actionDate) {
        this.actionDate = actionDate;
    }

    public String getActionComment() {
        return actionComment;
    }

    public void setActionComment(String actionComment) {
        this.actionComment = actionComment;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public Forum getForum() {
        return forum;
    }

    public void setForum(Forum forum) {
        this.forum = forum;
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
        if (!(object instanceof EmpAction)) {
            return false;
        }
        EmpAction other = (EmpAction) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mii._ConsumeAPI.entities.EmpAction[ id=" + id + " ]";
    }
    
}
