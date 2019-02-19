/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Darth Revan
 */
@Entity
@Table(name = "zanr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Zanr.findAll", query = "SELECT z FROM Zanr z")
    , @NamedQuery(name = "Zanr.findByZnrId", query = "SELECT z FROM Zanr z WHERE z.znrId = :znrId")
    , @NamedQuery(name = "Zanr.findByZnrNaziv", query = "SELECT z FROM Zanr z WHERE z.znrNaziv = :znrNaziv")})
public class Zanr implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "znr_id")
    private Integer znrId;
    @Size(max = 45)
    @Column(name = "znr_naziv")
    private String znrNaziv;
    @OneToMany(mappedBy = "znrId")
    private Set<Igra> igraSet;

    public Zanr() {
    }

    public Zanr(Integer znrId) {
        this.znrId = znrId;
    }

    public Integer getZnrId() {
        return znrId;
    }

    public void setZnrId(Integer znrId) {
        this.znrId = znrId;
    }

    public String getZnrNaziv() {
        return znrNaziv;
    }

    public void setZnrNaziv(String znrNaziv) {
        this.znrNaziv = znrNaziv;
    }

    @XmlTransient
    public Set<Igra> getIgraSet() {
        return igraSet;
    }

    public void setIgraSet(Set<Igra> igraSet) {
        this.igraSet = igraSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (znrId != null ? znrId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Zanr)) {
            return false;
        }
        Zanr other = (Zanr) object;
        if ((this.znrId == null && other.znrId != null) || (this.znrId != null && !this.znrId.equals(other.znrId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.Zanr[ znrId=" + znrId + " ]";
    }
    
}
