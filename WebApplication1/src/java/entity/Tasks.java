/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
 * @author kaisa
 */
@Entity
@Table(name = "tasks")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tasks.findAll", query = "SELECT t FROM Tasks t")
    , @NamedQuery(name = "Tasks.findByTaskid", query = "SELECT t FROM Tasks t WHERE t.taskid = :taskid")
    , @NamedQuery(name = "Tasks.findByLocid", query = "SELECT t FROM Tasks t WHERE t.locid = :locid")
    , @NamedQuery(name = "Tasks.findByTaskname", query = "SELECT t FROM Tasks t WHERE t.taskname = :taskname")
    , @NamedQuery(name = "Tasks.findByTaskdescription", query = "SELECT t FROM Tasks t WHERE t.taskdescription = :taskdescription")
    , @NamedQuery(name = "Tasks.findByStartdate", query = "SELECT t FROM Tasks t WHERE t.startdate = :startdate")
    , @NamedQuery(name = "Tasks.findByEnddate", query = "SELECT t FROM Tasks t WHERE t.enddate = :enddate")
    , @NamedQuery(name = "Tasks.findByStatus", query = "SELECT t FROM Tasks t WHERE t.status = :status")})
public class Tasks implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    //@NotNull
    @Column(name = "taskid")
    private Integer taskid;
    @Basic(optional = false)
    //@NotNull
    @Column(name = "locid")
    private int locid;
    @Basic(optional = false)
    //@NotNull
    @Size(min = 1, max = 255)
    @Column(name = "taskname")
    private String taskname;
    @Size(max = 255)
    @Column(name = "taskdescription")
    private String taskdescription;
    @Basic(optional = false)
    //@NotNull
    @Column(name = "startdate")
    @Temporal(TemporalType.DATE)
    private Date startdate;
    @Column(name = "enddate")
    @Temporal(TemporalType.DATE)
    private Date enddate;
    @Column(name = "status")
    private Boolean status;

    public Tasks() {
    }

    public Tasks(Integer taskid) {
        this.taskid = taskid;
    }

    public Tasks(Integer taskid, int locid, String taskname, Date startdate) {
        this.taskid = taskid;
        this.locid = locid;
        this.taskname = taskname;
        this.startdate = startdate;
    }

    public Integer getTaskid() {
        return taskid;
    }

    public void setTaskid(Integer taskid) {
        this.taskid = taskid;
    }

    public int getLocid() {
        return locid;
    }

    public void setLocid(int locid) {
        this.locid = locid;
    }

    public String getTaskname() {
        return taskname;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }

    public String getTaskdescription() {
        return taskdescription;
    }

    public void setTaskdescription(String taskdescription) {
        this.taskdescription = taskdescription;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (taskid != null ? taskid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tasks)) {
            return false;
        }
        Tasks other = (Tasks) object;
        if ((this.taskid == null && other.taskid != null) || (this.taskid != null && !this.taskid.equals(other.taskid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Tasks[ taskid=" + taskid + " ]";
    }
    
}
