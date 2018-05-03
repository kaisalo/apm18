/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kaisa
 */
@Entity
@Table(name = "locations")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Locations.findAll", query = "SELECT l FROM Locations l")
    , @NamedQuery(name = "Locations.findByLocid", query = "SELECT l FROM Locations l WHERE l.locid = :locid")
    , @NamedQuery(name = "Locations.findByClientid", query = "SELECT l FROM Locations l WHERE l.clientid = :clientid")
    , @NamedQuery(name = "Locations.findByLocname", query = "SELECT l FROM Locations l WHERE l.locname = :locname")
    , @NamedQuery(name = "Locations.findByLocstreetaddress", query = "SELECT l FROM Locations l WHERE l.locstreetaddress = :locstreetaddress")
    , @NamedQuery(name = "Locations.findByLoccity", query = "SELECT l FROM Locations l WHERE l.loccity = :loccity")})
public class Locations implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "locid")
    private Integer locid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "clientid")
    private int clientid;
    @Size(max = 255)
    @Column(name = "locname")
    private String locname;
    @Size(max = 255)
    @Column(name = "locstreetaddress")
    private String locstreetaddress;
    @Size(max = 255)
    @Column(name = "loccity")
    private String loccity;

    public Locations() {
    }

    public Locations(Integer locid) {
        this.locid = locid;
    }

    public Locations(Integer locid, int clientid) {
        this.locid = locid;
        this.clientid = clientid;
    }

    public Integer getLocid() {
        return locid;
    }

    public void setLocid(Integer locid) {
        this.locid = locid;
    }

    public int getClientid() {
        return clientid;
    }

    public void setClientid(int clientid) {
        this.clientid = clientid;
    }

    public String getLocname() {
        return locname;
    }

    public void setLocname(String locname) {
        this.locname = locname;
    }

    public String getLocstreetaddress() {
        return locstreetaddress;
    }

    public void setLocstreetaddress(String locstreetaddress) {
        this.locstreetaddress = locstreetaddress;
    }

    public String getLoccity() {
        return loccity;
    }

    public void setLoccity(String loccity) {
        this.loccity = loccity;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (locid != null ? locid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Locations)) {
            return false;
        }
        Locations other = (Locations) object;
        if ((this.locid == null && other.locid != null) || (this.locid != null && !this.locid.equals(other.locid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Locations[ locid=" + locid + " ]";
    }
    
}
