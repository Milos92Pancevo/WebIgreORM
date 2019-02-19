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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Darth Revan
 */
@Entity
@Table(name = "platforma")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Platforma.findAll", query = "SELECT p FROM Platforma p")
    , @NamedQuery(name = "Platforma.findByPltId", query = "SELECT p FROM Platforma p WHERE p.pltId = :pltId")
    , @NamedQuery(name = "Platforma.findByPltNaziv", query = "SELECT p FROM Platforma p WHERE p.pltNaziv = :pltNaziv")})
public class Platforma implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "plt_id")
    private Integer pltId;
    @Size(max = 45)
    @Column(name = "plt_naziv")
    private String pltNaziv;

    public Platforma() {
    }

    public Platforma(Integer pltId) {
        this.pltId = pltId;
    }

    public Integer getPltId() {
        return pltId;
    }

    public void setPltId(Integer pltId) {
        this.pltId = pltId;
    }

    public String getPltNaziv() {
        return pltNaziv;
    }

    public void setPltNaziv(String pltNaziv) {
        this.pltNaziv = pltNaziv;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pltId != null ? pltId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Platforma)) {
            return false;
        }
        Platforma other = (Platforma) object;
        if ((this.pltId == null && other.pltId != null) || (this.pltId != null && !this.pltId.equals(other.pltId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.Platforma[ pltId=" + pltId + " ]";
    }
    
}
