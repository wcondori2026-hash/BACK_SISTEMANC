
package pe.com.ncquality.sad.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_proyecto", schema = "public")
public class TbProyecto {
    private Integer idProyecto;
    private String sCodEtapa;
    private String vCodTipoObra;
    private String vCodTipoSuelo;
    private String vNombProyecto;
    private Date fFecIniProg;
    private Date fFecFinProg;
    private Date fFecIniEjec;
    private Date fFecFinEjec;
    private String vDireccion;
    private String vDescripcion;
    private char bEstado;
    private Integer iIdUsuarioCrea;
    private Date dFecRegCrea;
    private Integer iIdUsuarioMod;
    private Date dFecRegMod;
    private Set<TbProyecto> tbProyecto = new HashSet<TbProyecto>(0);
    private TbEmpresa tbEmpresa;

    public TbProyecto() {
    }
    public TbProyecto(Integer idProyecto, String sCodEtapa, String vCodTipoObra, String vCodTipoSuelo, String vNombProyecto, Date fFecIniProg, 
            Date fFecFinProg, Date fFecIniEjec, Date fFecFinEjec, String vDireccion, String vDescripcion, 
            char bEstado, Integer iIdUsuarioCrea, Date dFecRegCrea, Integer iIdUsuarioMod, Date dFecRegMod) {
        this.idProyecto = idProyecto;
        this.sCodEtapa = sCodEtapa;
        this.vCodTipoObra = vCodTipoObra;
        this.vCodTipoSuelo = vCodTipoSuelo;
        this.vNombProyecto = vNombProyecto;
        this.fFecIniProg = fFecIniProg;
        this.fFecFinProg = fFecFinProg;
        this.fFecIniEjec = fFecIniEjec;
        this.fFecFinEjec = fFecFinEjec;
        this.vDireccion = vDireccion;
        this.vDescripcion = vDescripcion;
        this.bEstado = bEstado;
        this.iIdUsuarioCrea = iIdUsuarioCrea;
        this.dFecRegCrea = dFecRegCrea;
        this.iIdUsuarioMod = iIdUsuarioMod;
        this.dFecRegMod = dFecRegMod;
       ;
    }

    public TbProyecto(Integer idProyecto, String sCodEtapa, String vCodTipoObra, String vCodTipoSuelo, String vNombProyecto, Date fFecIniProg,
            Date fFecFinProg, Date fFecIniEjec, Date fFecFinEjec, String vDireccion, String vDescripcion, 
            char bEstado, Integer iIdUsuarioCrea, Date dFecRegCrea, Integer iIdUsuarioMod, Date dFecRegMod, 
            Set<TbProyecto> tbProyecto, TbEmpresa tbEmpresa) {
        this.idProyecto = idProyecto;
        this.sCodEtapa = sCodEtapa;
        this.vCodTipoObra = vCodTipoObra;
        this.vCodTipoSuelo = vCodTipoSuelo;
        this.vNombProyecto = vNombProyecto;
        this.fFecIniProg = fFecIniProg;
        this.fFecFinProg = fFecFinProg;
        this.fFecIniEjec = fFecIniEjec;
        this.fFecFinEjec = fFecFinEjec;
        this.vDireccion = vDireccion;
        this.vDescripcion = vDescripcion;
        this.bEstado = bEstado;
        this.iIdUsuarioCrea = iIdUsuarioCrea;
        this.dFecRegCrea = dFecRegCrea;
        this.iIdUsuarioMod = iIdUsuarioMod;
        this.dFecRegMod = dFecRegMod;
        this.tbProyecto = tbProyecto;
         this.tbEmpresa = tbEmpresa;
    }
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column (name = "id_proyecto", unique = true, nullable = false, length = 15)
    public Integer getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }

    @Column(name = "s_cod_etapa", nullable = false, length = 20)
    public String getsCodEtapa() {
        return sCodEtapa;
    }

    public void setsCodEtapa(String sCodEtapa) {
        this.sCodEtapa = sCodEtapa;
    }

    @Column(name = "v_cod_tip_obra", nullable = false, length = 5)
    public String getvCodTipoObra() {
        return vCodTipoObra;
    }

    public void setvCodTipoObra(String vCodTipoObra) {
        this.vCodTipoObra = vCodTipoObra;
    }

    @Column(name = "v_cod_tip_suelo", nullable = false, length = 5)
    public String getvCodTipoSuelo() {
        return vCodTipoSuelo;
    }

    public void setvCodTipoSuelo(String vCodTipoSuelo) {
        this.vCodTipoSuelo = vCodTipoSuelo;
    }

    @Column(name = "v_nomb_proyecto", nullable = false, length = 200)
    public String getvNombProyecto() {
        return vNombProyecto;
    }

    public void setvNombProyecto(String vNombProyecto) {
        this.vNombProyecto = vNombProyecto;
    }
    
    
    @Temporal(TemporalType.DATE)
    @Column(name = "d_fec_ini_prog", nullable = false, length = 15)
    public Date getfFecIniProg() {
        return fFecIniProg;
    }

    public void setfFecIniProg(Date fFecIniProg) {
        this.fFecIniProg = fFecIniProg;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "d_fec_fin_prog", nullable = false, length = 15)
    public Date getfFecFinProg() {
        return fFecFinProg;
    }

    public void setfFecFinProg(Date fFecFinProg) {
        this.fFecFinProg = fFecFinProg;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "d_fec_ini_ejec", nullable = false, length = 15)
    public Date getfFecIniEjec() {
        return fFecIniEjec;
    }

    public void setfFecIniEjec(Date fFecIniEjec) {
        this.fFecIniEjec = fFecIniEjec;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "d_fec_fin_ejec", nullable = false, length = 15)
    public Date getfFecFinEjec() {
        return fFecFinEjec;
    }

    public void setfFecFinEjec(Date fFecFinEjec) {
        this.fFecFinEjec = fFecFinEjec;
    }

    @Column(name = "v_direccion", nullable = false, length = 200)
    public String getvDireccion() {
        return vDireccion;
    }

    public void setvDireccion(String vDireccion) {
        this.vDireccion = vDireccion;
    }

    @Column(name = "v_descripcion", nullable = false, length = 200)
    public String getvDescripcion() {
        return vDescripcion;
    }

    public void setvDescripcion(String vDescripcion) {
        this.vDescripcion = vDescripcion;
    }

    @Column(name = "b_estado", nullable = false, length = 1)
    public char getbEstado() {
        return bEstado;
    }

    public void setbEstado(char bEstado) {
        this.bEstado = bEstado;
    }

    @Column (name = "i_id_usuario_crea", unique = true, nullable = false, length = 15)
    public Integer getiIdUsuarioCrea() {
        return iIdUsuarioCrea;
    }

    public void setiIdUsuarioCrea(Integer iIdUsuarioCrea) {
        this.iIdUsuarioCrea = iIdUsuarioCrea;
    }

    @Temporal(TemporalType.DATE)
    @Column (name = "d_fecha_reg_crea", unique = true, nullable = false, length = 15)
    public Date getdFecRegCrea() {
        return dFecRegCrea;
    }

    public void setdFecRegCrea(Date dFecRegCrea) {
        this.dFecRegCrea = dFecRegCrea;
    }

    @Column (name = "i_id_usuario_mod", unique = true, nullable = false, length = 15)
    public Integer getiIdUsuarioMod() {
        return iIdUsuarioMod;
    }

    public void setiIdUsuarioMod(Integer iIdUsuarioMod) {
        this.iIdUsuarioMod = iIdUsuarioMod;
    }

    @Temporal(TemporalType.DATE)
    @Column (name = "d_fecha_reg_mod", unique = true, nullable = false, length = 15)
    public Date getdFecRegMod() {
        return dFecRegMod;
    }

    public void setdFecRegMod(Date dFecRegMod) {
        this.dFecRegMod = dFecRegMod;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tbProyecto")
    public Set<TbProyecto> getTbProyecto() {
        return tbProyecto;
    }

    public void setTbProyecto(Set<TbProyecto> tbProyecto) {
        this.tbProyecto = tbProyecto;
    }

    @ManyToOne
    @JoinColumn (name = "id_empresa", referencedColumnName = "id_empresa")
    public TbEmpresa getTbEmpresa() {
        return tbEmpresa;
    }

    public void setTbEmpresa(TbEmpresa tbEmpresa) {
        this.tbEmpresa = tbEmpresa;
    }
    
    
    
}
