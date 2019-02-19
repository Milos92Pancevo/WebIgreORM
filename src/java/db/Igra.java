/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
 * @author Darth Revan
 */
@Entity
@Table(name = "igra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Igra.findAll", query = "SELECT i FROM Igra i")
    , @NamedQuery(name = "Igra.findByIgrId", query = "SELECT i FROM Igra i WHERE i.igrId = :igrId")
    , @NamedQuery(name = "Igra.findByIgrNaziv", query = "SELECT i FROM Igra i WHERE i.igrNaziv = :igrNaziv")
    , @NamedQuery(name = "Igra.findByIgrDatum", query = "SELECT i FROM Igra i WHERE i.igrDatum = :igrDatum")})
public class Igra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "igr_id")
    private Integer igrId;
    @Size(max = 45)
    @Column(name = "igr_naziv")
    private String igrNaziv;
    @Column(name = "igr_datum")
    @Temporal(TemporalType.TIMESTAMP)
    private Date igrDatum;
    @Lob
    @Size(max = 65535)
    @Column(name = "igr_opis")
    private String igrOpis;
    @JoinTable(name = "igra_platforma", joinColumns = {
        @JoinColumn(name = "igr_id", referencedColumnName = "igr_id")}, inverseJoinColumns = {
        @JoinColumn(name = "plt_id", referencedColumnName = "plt_id")})
    @ManyToMany
    private Set<Platforma> platformaSet;
    @OneToMany(mappedBy = "igrId")
    private Set<Eksternilink> eksternilinkSet;
    @OneToMany(mappedBy = "igrId")
    private Set<Slika> slikaSet;
    @OneToMany(mappedBy = "igrId")
    private Set<Komentar> komentarSet;
    @JoinColumn(name = "izd_id", referencedColumnName = "izd_id")
    @ManyToOne
    private Izdavac izdId;
    @JoinColumn(name = "znr_id", referencedColumnName = "znr_id")
    @ManyToOne
    private Zanr znrId;
    
    public Igra() {
    }

    public Igra(Integer igrId) {
        this.igrId = igrId;
    }

    public Integer getIgrId() {
        return igrId;
    }

    public void setIgrId(Integer igrId) {
        this.igrId = igrId;
    }

    public String getIgrNaziv() {
        return igrNaziv;
    }

    public void setIgrNaziv(String igrNaziv) {
        this.igrNaziv = igrNaziv;
    }

    public Date getIgrDatum() {
        return igrDatum;
    }

    public void setIgrDatum(Date igrDatum) {
        this.igrDatum = igrDatum;
    }

    public String getIgrOpis() {
        return igrOpis;
    }

    public void setIgrOpis(String igrOpis) {
        this.igrOpis = igrOpis;
    }

    @XmlTransient
    public Set<Platforma> getPlatformaSet() {
        return platformaSet;
    }

    public void setPlatformaSet(Set<Platforma> platformaSet) {
        this.platformaSet = platformaSet;
    }

    @XmlTransient
    public Set<Eksternilink> getEksternilinkSet() {
        return eksternilinkSet;
    }

    public void setEksternilinkSet(Set<Eksternilink> eksternilinkSet) {
        this.eksternilinkSet = eksternilinkSet;
    }

    @XmlTransient
    public Set<Slika> getSlikaSet() {
        return slikaSet;
    }

    public void setSlikaSet(Set<Slika> slikaSet) {
        this.slikaSet = slikaSet;
    }

    @XmlTransient
    public Set<Komentar> getKomentarSet() {
        return komentarSet;
    }

    public void setKomentarSet(Set<Komentar> komentarSet) {
        this.komentarSet = komentarSet;
    }

    public Izdavac getIzdId() {
        return izdId;
    }

    public void setIzdId(Izdavac izdId) {
        this.izdId = izdId;
    }

    public Zanr getZnrId() {
        return znrId;
    }

    public void setZnrId(Zanr znrId) {
        this.znrId = znrId;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (igrId != null ? igrId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Igra)) {
            return false;
        }
        Igra other = (Igra) object;
        if ((this.igrId == null && other.igrId != null) || (this.igrId != null && !this.igrId.equals(other.igrId))) {
            return false;
        }
        return true;
    }
}

 /**   @Override
    public String toString() {
        return "db.Igra[ igrId=" + igrId + " ]";
    }

    public boolean getPlatforma() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
**/
