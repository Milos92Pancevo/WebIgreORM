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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Darth Revan
 */
@Entity
@Table(name = "korisnik")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Korisnik.findAll", query = "SELECT k FROM Korisnik k")
    , @NamedQuery(name = "Korisnik.findByKorId", query = "SELECT k FROM Korisnik k WHERE k.korId = :korId")
    , @NamedQuery(name = "Korisnik.findByKorEmail", query = "SELECT k FROM Korisnik k WHERE k.korEmail = :korEmail")
    , @NamedQuery(name = "Korisnik.findByKorPass", query = "SELECT k FROM Korisnik k WHERE k.korPass = :korPass")
    , @NamedQuery(name = "Korisnik.findByKorIme", query = "SELECT k FROM Korisnik k WHERE k.korIme = :korIme")
    , @NamedQuery(name = "Korisnik.findByKorPrezime", query = "SELECT k FROM Korisnik k WHERE k.korPrezime = :korPrezime")
    , @NamedQuery(name = "Korisnik.findByKogRegistrovan", query = "SELECT k FROM Korisnik k WHERE k.kogRegistrovan = :kogRegistrovan")})
public class Korisnik implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "kor_id")
    private Integer korId;
    @Size(max = 45)
    @Column(name = "kor_email")
    private String korEmail;
    @Size(max = 45)
    @Column(name = "kor_pass")
    private String korPass;
    @Size(max = 45)
    @Column(name = "kor_ime")
    private String korIme;
    @Size(max = 45)
    @Column(name = "kor_prezime")
    private String korPrezime;
    @Column(name = "kog_registrovan")
    @Temporal(TemporalType.TIMESTAMP)
    private Date kogRegistrovan;
    @OneToMany(mappedBy = "korId")
    private Set<Komentar> komentarSet;

    public Korisnik() {
    }

    public Korisnik(Integer korId) {
        this.korId = korId;
    }

    public Integer getKorId() {
        return korId;
    }

    public void setKorId(Integer korId) {
        this.korId = korId;
    }

    public String getKorEmail() {
        return korEmail;
    }

    public void setKorEmail(String korEmail) {
        this.korEmail = korEmail;
    }

    public String getKorPass() {
        return korPass;
    }

    public void setKorPass(String korPass) {
        this.korPass = korPass;
    }

    public String getKorIme() {
        return korIme;
    }

    public void setKorIme(String korIme) {
        this.korIme = korIme;
    }

    public String getKorPrezime() {
        return korPrezime;
    }

    public void setKorPrezime(String korPrezime) {
        this.korPrezime = korPrezime;
    }

    public Date getKogRegistrovan() {
        return kogRegistrovan;
    }

    public void setKogRegistrovan(Date kogRegistrovan) {
        this.kogRegistrovan = kogRegistrovan;
    }

    @XmlTransient
    public Set<Komentar> getKomentarSet() {
        return komentarSet;
    }

    public void setKomentarSet(Set<Komentar> komentarSet) {
        this.komentarSet = komentarSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (korId != null ? korId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Korisnik)) {
            return false;
        }
        Korisnik other = (Korisnik) object;
        if ((this.korId == null && other.korId != null) || (this.korId != null && !this.korId.equals(other.korId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.Korisnik[ korId=" + korId + " ]";
    }
    
}
