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
@Table(name = "clients")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clients.findAll", query = "SELECT c FROM Clients c")
    , @NamedQuery(name = "Clients.findByClientid", query = "SELECT c FROM Clients c WHERE c.clientid = :clientid")
    , @NamedQuery(name = "Clients.findByClientname", query = "SELECT c FROM Clients c WHERE c.clientname = :clientname")
    , @NamedQuery(name = "Clients.findByBillingaddress", query = "SELECT c FROM Clients c WHERE c.billingaddress = :billingaddress")
    , @NamedQuery(name = "Clients.findByPostalcode", query = "SELECT c FROM Clients c WHERE c.postalcode = :postalcode")
    , @NamedQuery(name = "Clients.findByClientaddress", query = "SELECT c FROM Clients c WHERE c.clientaddress = :clientaddress")})
public class Clients implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    //@NotNull
    @Column(name = "clientid")
    private Integer clientid;
    @Basic(optional = false)
    //@NotNull
    @Size(min = 1, max = 255)
    @Column(name = "clientname")
    private String clientname;
    @Basic(optional = false)
    //@NotNull
    @Size(min = 1, max = 255)
    @Column(name = "billingaddress")
    private String billingaddress;
    @Size(max = 255)
    @Column(name = "postalcode")
    private String postalcode;
    @Basic(optional = false)
    //@NotNull
    @Size(min = 1, max = 255)
    @Column(name = "clientaddress")
    private String clientaddress;

    public Clients() {
    }

    public Clients(Integer clientid) {
        this.clientid = clientid;
    }

    public Clients(Integer clientid, String clientname, String billingaddress, String clientaddress) {
        this.clientid = clientid;
        this.clientname = clientname;
        this.billingaddress = billingaddress;
        this.clientaddress = clientaddress;
    }

    public Integer getClientid() {
        return clientid;
    }

    public void setClientid(Integer clientid) {
        this.clientid = clientid;
    }

    public String getClientname() {
        return clientname;
    }

    public void setClientname(String clientname) {
        this.clientname = clientname;
    }

    public String getBillingaddress() {
        return billingaddress;
    }

    public void setBillingaddress(String billingaddress) {
        this.billingaddress = billingaddress;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getClientaddress() {
        return clientaddress;
    }

    public void setClientaddress(String clientaddress) {
        this.clientaddress = clientaddress;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clientid != null ? clientid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clients)) {
            return false;
        }
        Clients other = (Clients) object;
        if ((this.clientid == null && other.clientid != null) || (this.clientid != null && !this.clientid.equals(other.clientid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Clients[ clientid=" + clientid + " ]";
    }
    
}
