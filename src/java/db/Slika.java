/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Darth Revan
 */
@Entity
@Table(name = "slika")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Slika.findAll", query = "SELECT s FROM Slika s")
    , @NamedQuery(name = "Slika.findBySlkId", query = "SELECT s FROM Slika s WHERE s.slkId = :slkId")})
public class Slika implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "slk_id")
    private Integer slkId;
    @Lob
    @Column(name = "slk_naziv")
    private byte[] slkNaziv;
    @JoinColumn(name = "igr_id", referencedColumnName = "igr_id")
    @ManyToOne
    private Igra igrId;

    public Slika() {
    }

    public Slika(Integer slkId) {
        this.slkId = slkId;
    }

    public Integer getSlkId() {
        return slkId;
    }

    public void setSlkId(Integer slkId) {
        this.slkId = slkId;
    }

    public byte[] getSlkNaziv() {
        return slkNaziv;
    }

    public void setSlkNaziv(byte[] slkNaziv) {
        this.slkNaziv = slkNaziv;
    }

    public Igra getIgrId() {
        return igrId;
    }

    public void setIgrId(Igra igrId) {
        this.igrId = igrId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (slkId != null ? slkId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Slika)) {
            return false;
        }
        Slika other = (Slika) object;
        if ((this.slkId == null && other.slkId != null) || (this.slkId != null && !this.slkId.equals(other.slkId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.Slika[ slkId=" + slkId + " ]";
    }
    
}
