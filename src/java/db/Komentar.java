/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Darth Revan
 */
@Entity
@Table(name = "komentar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Komentar.findAll", query = "SELECT k FROM Komentar k")
    , @NamedQuery(name = "Komentar.findByKomId", query = "SELECT k FROM Komentar k WHERE k.komId = :komId")
    , @NamedQuery(name = "Komentar.findByKomOcena", query = "SELECT k FROM Komentar k WHERE k.komOcena = :komOcena")
    , @NamedQuery(name = "Komentar.findByKomDatum", query = "SELECT k FROM Komentar k WHERE k.komDatum = :komDatum")})
public class Komentar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "kom_id")
    private Integer komId;
    @Lob
    @Size(max = 65535)
    @Column(name = "kom_text")
    private String komText;
    @Column(name = "kom_ocena")
    private Short komOcena;
    @Column(name = "kom_datum")
    @Temporal(TemporalType.TIMESTAMP)
    private Date komDatum;
    @JoinColumn(name = "igr_id", referencedColumnName = "igr_id")
    @ManyToOne
    private Igra igrId;
    @JoinColumn(name = "kor_id", referencedColumnName = "kor_id")
    @ManyToOne
    private Korisnik korId;

    public Komentar() {
    }

    public Komentar(Integer komId) {
        this.komId = komId;
    }

    public Integer getKomId() {
        return komId;
    }

    public void setKomId(Integer komId) {
        this.komId = komId;
    }

    public String getKomText() {
        return komText;
    }

    public void setKomText(String komText) {
        this.komText = komText;
    }

    public Short getKomOcena() {
        return komOcena;
    }

    public void setKomOcena(Short komOcena) {
        this.komOcena = komOcena;
    }

    public Date getKomDatum() {
        return komDatum;
    }

    public void setKomDatum(Date komDatum) {
        this.komDatum = komDatum;
    }

    public Igra getIgrId() {
        return igrId;
    }

    public void setIgrId(Igra igrId) {
        this.igrId = igrId;
    }

    public Korisnik getKorId() {
        return korId;
    }

    public void setKorId(Korisnik korId) {
        this.korId = korId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (komId != null ? komId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Komentar)) {
            return false;
        }
        Komentar other = (Komentar) object;
        if ((this.komId == null && other.komId != null) || (this.komId != null && !this.komId.equals(other.komId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.Komentar[ komId=" + komId + " ]";
    }
    
}
