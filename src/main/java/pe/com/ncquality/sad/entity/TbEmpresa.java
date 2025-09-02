
package pe.com.ncquality.sad.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tb_empresa", schema="public")
public class TbEmpresa {
    private Integer idEmpresa;
    private String cNroRuc;
    private String vRazonSocial;
    private String vDireccion;
    private String vSigla;
    private String vAlias;
    private String bEstado;
    private Integer iIdUsuarioCrea;
    private Integer iIdUsuarioMod;
    private Date fFecRegCrea;
    private Date fFecRegMod;
    

    private List<TbProyecto> tbproyecto;
    //private Set<TbEmpresa> tbEmpresa = new HashSet<TbEmpresa>(0);

    public TbEmpresa() {
    }

    public TbEmpresa(Integer idEmpresa, String cNroRuc, String vRazonSocial, 
            String vDireccion, String vSigla, String vAlias, String bEstado, 
            Integer iIdUsuarioCrea, Integer iIdUsuarioMod, Date fFecRegCrea, Date fFecRegMod, List<TbProyecto> tbProyecto/*, Set<TbEmpresa> tbEmpresa*/) {
        this.idEmpresa = idEmpresa;
        this.cNroRuc = cNroRuc;
        this.vRazonSocial = vRazonSocial;
        this.vDireccion = vDireccion;
        this.vSigla = vSigla;
        this.vAlias = vAlias;
        this.bEstado = bEstado;
        this.iIdUsuarioCrea = iIdUsuarioCrea;
        this.iIdUsuarioMod = iIdUsuarioMod;
        this.fFecRegCrea = fFecRegCrea;
        this.fFecRegMod = fFecRegMod;
        //this.tbEmpresa = tbEmpresa;
        this.tbproyecto = tbProyecto;
    }

    @Id
    @Column(name = "id_empresa", unique = true, nullable = false, length = 15)
    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    @Column(name = "v_nro_ruc", nullable = false, length = 20)
    public String getcNroRuc() {
        return cNroRuc;
    }

    public void setcNroRuc(String cNroRuc) {
        this.cNroRuc = cNroRuc;
    }

    @Column(name = "v_razon_social", nullable = false, length = 20)
    public String getvRazonSocial() {
        return vRazonSocial;
    }

    public void setvRazonSocial(String vRazonSocial) {
        this.vRazonSocial = vRazonSocial;
    }

    @Column(name = "v_direccion", nullable = false, length = 20)
    public String getvDireccion() {
        return vDireccion;
    }

    public void setvDireccion(String vDireccion) {
        this.vDireccion = vDireccion;
    }

    @Column(name = "v_sigla", nullable = false, length = 20)
    public String getvSigla() {
        return vSigla;
    }

    public void setvSigla(String vSigla) {
        this.vSigla = vSigla;
    }

    @Column(name = "v_alias", nullable = false, length = 20)
    public String getvAlias() {
        return vAlias;
    }

    public void setvAlias(String vAlias) {
        this.vAlias = vAlias;
    }

    @Column(name = "b_estado", nullable = false, length = 1)
    public String getbEstado() {
        return bEstado;
    }

    public void setbEstado(String bEstado) {
        this.bEstado = bEstado;
    }

    @Column(name = "i_id_usuario_crea", nullable = false, length = 20)
    public Integer getiIdUsuarioCrea() {
        return iIdUsuarioCrea;
    }

    public void setiIdUsuarioCrea(Integer iIdUsuarioCrea) {
        this.iIdUsuarioCrea = iIdUsuarioCrea;
    }

   
    @Column(name = "i_id_usuario_mod", nullable = false, length = 20)
    public Integer getiIdUsuarioMod() {
        return iIdUsuarioMod;
    }

    public void setiIdUsuarioMod(Integer iIdUsuarioMod) {
        this.iIdUsuarioMod = iIdUsuarioMod;
    }
    
    @Temporal(TemporalType.DATE)
    @Column(name = "f_fecha_reg_crea", nullable = false, length = 20)
    public Date getfFecRegCrea() {
        return fFecRegCrea;
    }

    public void setfFecRegCrea(Date fFecRegCrea) {
        this.fFecRegCrea = fFecRegCrea;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "f_fecha_reg_mod", nullable = false, length = 20)
    public Date getfFecRegMod() {
        return fFecRegMod;
    }

    public void setfFecRegMod(Date fFecRegMod) {
        this.fFecRegMod = fFecRegMod;
    }

   /* @OneToMany(fetch = FetchType.LAZY, mappedBy = "tbEmpresa")
    @JsonManagedReference
    public Set<TbEmpresa> getTbEmpresa() {
        return tbEmpresa;
    }

    public void setTbEmpresa(Set<TbEmpresa> tbEmpresa) {
        this.tbEmpresa = tbEmpresa;
    }*/

    @OneToMany
    @JoinColumn(name = "id_empresa")
    public List<TbProyecto> getTbproyecto() {
        return tbproyecto;
    }

    public void setTbproyecto(List<TbProyecto> tbproyecto) {
        this.tbproyecto = tbproyecto;
    }
    
    
    
}
