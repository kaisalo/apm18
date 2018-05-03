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
@Table(name = "worklogs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Worklogs.findAll", query = "SELECT w FROM Worklogs w")
    , @NamedQuery(name = "Worklogs.findByWorklogid", query = "SELECT w FROM Worklogs w WHERE w.worklogid = :worklogid")
    , @NamedQuery(name = "Worklogs.findByTaskid", query = "SELECT w FROM Worklogs w WHERE w.taskid = :taskid")
    , @NamedQuery(name = "Worklogs.findByEmployeeid", query = "SELECT w FROM Worklogs w WHERE w.employeeid = :employeeid")
    , @NamedQuery(name = "Worklogs.findByDate", query = "SELECT w FROM Worklogs w WHERE w.date = :date")
    , @NamedQuery(name = "Worklogs.findByHours", query = "SELECT w FROM Worklogs w WHERE w.hours = :hours")
    , @NamedQuery(name = "Worklogs.findByWorkdescription", query = "SELECT w FROM Worklogs w WHERE w.workdescription = :workdescription")
    , @NamedQuery(name = "Worklogs.findByAdditionalinfo", query = "SELECT w FROM Worklogs w WHERE w.additionalinfo = :additionalinfo")
    , @NamedQuery(name = "Worklogs.findByKilometres", query = "SELECT w FROM Worklogs w WHERE w.kilometres = :kilometres")
    , @NamedQuery(name = "Worklogs.findByParking", query = "SELECT w FROM Worklogs w WHERE w.parking = :parking")})
public class Worklogs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "worklogid")
    private Integer worklogid;
    @Column(name = "taskid")
    private Integer taskid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "employeeid")
    private int employeeid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hours")
    private float hours;
    @Size(max = 255)
    @Column(name = "workdescription")
    private String workdescription;
    @Size(max = 255)
    @Column(name = "additionalinfo")
    private String additionalinfo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "kilometres")
    private Float kilometres;
    @Column(name = "parking")
    private Float parking;

    public Worklogs() {
    }

    public Worklogs(Integer worklogid) {
        this.worklogid = worklogid;
    }

    public Worklogs(Integer worklogid, int employeeid, Date date, float hours) {
        this.worklogid = worklogid;
        this.employeeid = employeeid;
        this.date = date;
        this.hours = hours;
    }

    public Integer getWorklogid() {
        return worklogid;
    }

    public void setWorklogid(Integer worklogid) {
        this.worklogid = worklogid;
    }

    public Integer getTaskid() {
        return taskid;
    }

    public void setTaskid(Integer taskid) {
        this.taskid = taskid;
    }

    public int getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(int employeeid) {
        this.employeeid = employeeid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getHours() {
        return hours;
    }

    public void setHours(float hours) {
        this.hours = hours;
    }

    public String getWorkdescription() {
        return workdescription;
    }

    public void setWorkdescription(String workdescription) {
        this.workdescription = workdescription;
    }

    public String getAdditionalinfo() {
        return additionalinfo;
    }

    public void setAdditionalinfo(String additionalinfo) {
        this.additionalinfo = additionalinfo;
    }

    public Float getKilometres() {
        return kilometres;
    }

    public void setKilometres(Float kilometres) {
        this.kilometres = kilometres;
    }

    public Float getParking() {
        return parking;
    }

    public void setParking(Float parking) {
        this.parking = parking;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (worklogid != null ? worklogid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Worklogs)) {
            return false;
        }
        Worklogs other = (Worklogs) object;
        if ((this.worklogid == null && other.worklogid != null) || (this.worklogid != null && !this.worklogid.equals(other.worklogid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Worklogs[ worklogid=" + worklogid + " ]";
    }
    
}
