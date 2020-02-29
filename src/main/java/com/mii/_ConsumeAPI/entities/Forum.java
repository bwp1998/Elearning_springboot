/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii._ConsumeAPI.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author BWP
 */
@Entity
@Table(name = "forum")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Forum.findAll", query = "SELECT f FROM Forum f")
    , @NamedQuery(name = "Forum.findById", query = "SELECT f FROM Forum f WHERE f.id = :id")
    , @NamedQuery(name = "Forum.findByTopic", query = "SELECT f FROM Forum f WHERE f.topic = :topic")
    , @NamedQuery(name = "Forum.findByForumDescription", query = "SELECT f FROM Forum f WHERE f.forumDescription = :forumDescription")
    , @NamedQuery(name = "Forum.findByDateForum", query = "SELECT f FROM Forum f WHERE f.dateForum = :dateForum")})
public class Forum implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "topic")
    private String topic;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4000)
    @Column(name = "forum_description")
    private String forumDescription;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_forum")
    @Temporal(TemporalType.DATE)
    private Date dateForum;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "forum", fetch = FetchType.LAZY)
    private List<EmpAction> empActionList;

    public Forum() {
    }

    public Forum(Integer id) {
        this.id = id;
    }

    public Forum(Integer id, String topic, String forumDescription, Date dateForum) {
        this.id = id;
        this.topic = topic;
        this.forumDescription = forumDescription;
        this.dateForum = dateForum;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getForumDescription() {
        return forumDescription;
    }

    public void setForumDescription(String forumDescription) {
        this.forumDescription = forumDescription;
    }

    public Date getDateForum() {
        return dateForum;
    }

    public void setDateForum(Date dateForum) {
        this.dateForum = dateForum;
    }

    @XmlTransient
    public List<EmpAction> getEmpActionList() {
        return empActionList;
    }

    public void setEmpActionList(List<EmpAction> empActionList) {
        this.empActionList = empActionList;
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
        if (!(object instanceof Forum)) {
            return false;
        }
        Forum other = (Forum) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mii._ConsumeAPI.entities.Forum[ id=" + id + " ]";
    }
    
}
