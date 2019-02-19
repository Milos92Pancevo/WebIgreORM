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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Darth Revan
 */
@Entity
@Table(name = "eksternilink")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Eksternilink.findAll", query = "SELECT e FROM Eksternilink e")})
public class Eksternilink implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ekl_id")
    private Integer eklId;
    @Lob
    @Size(max = 65535)
    @Column(name = "ekl_url")
    private String eklUrl;
    @JoinColumn(name = "igr_id", referencedColumnName = "igr_id")
    @ManyToOne
    private Igra igrId;
    @JoinColumn(name = "vrs_id", referencedColumnName = "vrs_id")
    @ManyToOne
    private Vrsta vrsId;

    public Eksternilink() {
    }

    public Eksternilink(Integer eklId) {
        this.eklId = eklId;
    }

    public Integer getEklId() {
        return eklId;
    }

    public void setEklId(Integer eklId) {
        this.eklId = eklId;
    }

    public String getEklUrl() {
        return eklUrl;
    }

    public void setEklUrl(String eklUrl) {
        this.eklUrl = eklUrl;
    }

    public Igra getIgrId() {
        return igrId;
    }

    public void setIgrId(Igra igrId) {
        this.igrId = igrId;
    }

    public Vrsta getVrsId() {
        return vrsId;
    }

    public void setVrsId(Vrsta vrsId) {
        this.vrsId = vrsId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eklId != null ? eklId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Eksternilink)) {
            return false;
        }
        Eksternilink other = (Eksternilink) object;
        if ((this.eklId == null && other.eklId != null) || (this.eklId != null && !this.eklId.equals(other.eklId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.Eksternilink[ eklId=" + eklId + " ]";
    }
    
}
