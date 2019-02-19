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
@Table(name = "vrsta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vrsta.findAll", query = "SELECT v FROM Vrsta v")})
public class Vrsta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "vrs_id")
    private Integer vrsId;
    @Size(max = 45)
    @Column(name = "vrs_naziv")
    private String vrsNaziv;
    @OneToMany(mappedBy = "vrsId")
    private Set<Eksternilink> eksternilinkSet;

    public Vrsta() {
    }

    public Vrsta(Integer vrsId) {
        this.vrsId = vrsId;
    }

    public Integer getVrsId() {
        return vrsId;
    }

    public void setVrsId(Integer vrsId) {
        this.vrsId = vrsId;
    }

    public String getVrsNaziv() {
        return vrsNaziv;
    }

    public void setVrsNaziv(String vrsNaziv) {
        this.vrsNaziv = vrsNaziv;
    }

    @XmlTransient
    public Set<Eksternilink> getEksternilinkSet() {
        return eksternilinkSet;
    }

    public void setEksternilinkSet(Set<Eksternilink> eksternilinkSet) {
        this.eksternilinkSet = eksternilinkSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vrsId != null ? vrsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vrsta)) {
            return false;
        }
        Vrsta other = (Vrsta) object;
        if ((this.vrsId == null && other.vrsId != null) || (this.vrsId != null && !this.vrsId.equals(other.vrsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.Vrsta[ vrsId=" + vrsId + " ]";
    }
    
}
