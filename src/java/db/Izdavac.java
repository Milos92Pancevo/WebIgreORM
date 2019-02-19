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
@Table(name = "izdavac")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Izdavac.findAll", query = "SELECT i FROM Izdavac i")
    , @NamedQuery(name = "Izdavac.findByIzdId", query = "SELECT i FROM Izdavac i WHERE i.izdId = :izdId")
    , @NamedQuery(name = "Izdavac.findByIzdNaziv", query = "SELECT i FROM Izdavac i WHERE i.izdNaziv = :izdNaziv")
    , @NamedQuery(name = "Izdavac.findByIzdDrzava", query = "SELECT i FROM Izdavac i WHERE i.izdDrzava = :izdDrzava")})
public class Izdavac implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "izd_id")
    private Integer izdId;
    @Size(max = 45)
    @Column(name = "izd_naziv")
    private String izdNaziv;
    @Size(max = 45)
    @Column(name = "izd_drzava")
    private String izdDrzava;
    @OneToMany(mappedBy = "izdId")
    private Set<Igra> igraSet;

    public Izdavac() {
    }

    public Izdavac(Integer izdId) {
        this.izdId = izdId;
    }

    public Integer getIzdId() {
        return izdId;
    }

    public void setIzdId(Integer izdId) {
        this.izdId = izdId;
    }

    public String getIzdNaziv() {
        return izdNaziv;
    }

    public void setIzdNaziv(String izdNaziv) {
        this.izdNaziv = izdNaziv;
    }

    public String getIzdDrzava() {
        return izdDrzava;
    }

    public void setIzdDrzava(String izdDrzava) {
        this.izdDrzava = izdDrzava;
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
        hash += (izdId != null ? izdId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Izdavac)) {
            return false;
        }
        Izdavac other = (Izdavac) object;
        if ((this.izdId == null && other.izdId != null) || (this.izdId != null && !this.izdId.equals(other.izdId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.Izdavac[ izdId=" + izdId + " ]";
    }
    
}
