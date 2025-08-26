package pe.com.ncquality.sad.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_personas", schema = "public")
public class TbPersonas implements java.io.Serializable {
    private Integer idPersona;
    private String vNumDocumento;
    private String vApelPaterno;
    private String vApelMaterno;
    private String vNombRazon;
    private Date dFecNacimiento;
    private String vNroCel;
    private String vDireccion;
    private char bEstado;
    private Integer iIdUsuarioCrea;
    private Date fFechaRegCrea;
    private Integer iIdUsuarioMod;
    private Date fFechaRegMod;
    private TbEmpleado tbEmpleado;
    private TbTipoPersona tbTipoPersona;
    private TbTipoDoc tbTipoDoc;
    private Set<TbPersonas> tbPersonas = new HashSet<TbPersonas>(0);

    public TbPersonas() {
    }

    public TbPersonas(int idPersona, String vNumDocumento, String vApelPaterno, String vApelMaterno, String vNombRazon, Date dFecNacimiento, String vNroCel, String vDireccion, char bEstado, int iIdUsuarioCrea, Date fFechaRegCrea, Integer iIdUsuarioMod, Date fFechaRegMod) {
        this.idPersona = idPersona;
        this.vNumDocumento = vNumDocumento;
        this.vApelPaterno = vApelPaterno;
        this.vApelMaterno = vApelMaterno;
        this.vNombRazon = vNombRazon;
        this.dFecNacimiento = dFecNacimiento;
        this.vNroCel = vNroCel;
        this.vDireccion = vDireccion;
        this.bEstado = bEstado;
        this.iIdUsuarioCrea = iIdUsuarioCrea;
        this.fFechaRegCrea = fFechaRegCrea;
        this.iIdUsuarioMod = iIdUsuarioMod;
        this.fFechaRegMod = fFechaRegMod;
    }

    public TbPersonas(int idPersona, String vNumDocumento, String vApelPaterno, String vApelMaterno, 
            String vNombRazon, Date dFecNacimiento, String vNroCel, String vDireccion, char bEstado, 
            int iIdUsuarioCrea, Date fFechaRegCrea, Integer iIdUsuarioMod, Date fFechaRegMod, TbEmpleado tbEmpleado,
            TbTipoPersona tbTipoPersona, TbTipoDoc tbTipoDoc, Set<TbPersonas> tbPersonas) {
        this.idPersona = idPersona;
        this.vNumDocumento = vNumDocumento;
        this.vApelPaterno = vApelPaterno;
        this.vApelMaterno = vApelMaterno;
        this.vNombRazon = vNombRazon;
        this.dFecNacimiento = dFecNacimiento;
        this.vNroCel = vNroCel;
        this.vDireccion = vDireccion;
        this.bEstado = bEstado;
        this.iIdUsuarioCrea = iIdUsuarioCrea;
        this.fFechaRegCrea = fFechaRegCrea;
        this.iIdUsuarioMod = iIdUsuarioMod;
        this.fFechaRegMod = fFechaRegMod;
        this.tbEmpleado = tbEmpleado;
        this.tbTipoPersona = tbTipoPersona;
        this.tbTipoDoc = tbTipoDoc;
        this.tbPersonas = tbPersonas;
    }

    
    @Id
    @Column(name = "id_persona", unique = true, nullable = false, length = 15)
    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    @Column(name = "v_num_doc", nullable = false, length = 15)
    public String getvNumDocumento() {
        return vNumDocumento;
    }

    public void setvNumDocumento(String vNumDocumento) {
        this.vNumDocumento = vNumDocumento;
    }

    @Column(name = "v_ape_parterno", nullable = false, length = 15)
    public String getvApelPaterno() {
        return vApelPaterno;
    }

    public void setvApelPaterno(String vApelPaterno) {
        this.vApelPaterno = vApelPaterno;
    }

    @Column(name = "v_ape_materno", nullable = false, length = 15)
    public String getvApelMaterno() {
        return vApelMaterno;
    }

    public void setvApelMaterno(String vApelMaterno) {
        this.vApelMaterno = vApelMaterno;
    }

    @Column(name = "v_nombres_razon", nullable = false, length = 15)
    public String getvNombRazon() {
        return vNombRazon;
    }

    public void setvNombRazon(String vNombRazon) {
        this.vNombRazon = vNombRazon;
    }
    
    @Temporal(TemporalType.DATE)
    @Column(name = "d_fecha_nac", nullable = false, length = 15)
    public Date getdFecNacimiento() {
        return dFecNacimiento;
    }

    public void setdFecNacimiento(Date dFecNacimiento) {
        this.dFecNacimiento = dFecNacimiento;
    }

    @Column(name = "v_nro_cel", nullable = false, length = 15)
    public String getvNroCel() {
        return vNroCel;
    }

    public void setvNroCel(String vNroCel) {
        this.vNroCel = vNroCel;
    }

    @Column(name = "v_direccion", nullable = false, length = 15)
    public String getvDireccion() {
        return vDireccion;
    }

    public void setvDireccion(String vDireccion) {
        this.vDireccion = vDireccion;
    }

    @Column(name = "b_estado", nullable = false, length = 1)
    public char getbEstado() {
        return bEstado;
    }

    public void setbEstado(char bEstado) {
        this.bEstado = bEstado;
    }

    @Column(name = "i_id_usuario_crea", nullable = false, length = 15)
    public int getiIdUsuarioCrea() {
        return iIdUsuarioCrea;
    }

    public void setiIdUsuarioCrea(int iIdUsuarioCrea) {
        this.iIdUsuarioCrea = iIdUsuarioCrea;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "d_fecha_reg_crea", nullable = false, length = 15)
    public Date getfFechaRegCrea() {
        return fFechaRegCrea;
    }

    public void setfFechaRegCrea(Date fFechaRegCrea) {
        this.fFechaRegCrea = fFechaRegCrea;
    }

    @Column(name = "i_id_usuario_mod", nullable = true, length = 15)
    public Integer getiIdUsuarioMod() {
        return iIdUsuarioMod;
    }

    public void setiIdUsuarioMod(Integer iIdUsuarioMod) {
        this.iIdUsuarioMod = iIdUsuarioMod;
    }
    
    @Temporal(TemporalType.DATE)
    @Column(name = "d_fecha_reg_mod", nullable = false, length = 15)
    public Date getfFechaRegMod() {
        return fFechaRegMod;
    }

    public void setfFechaRegMod(Date fFechaRegMod) {
        this.fFechaRegMod = fFechaRegMod;
    }

    @OneToOne(mappedBy = "tbPersonas")
    public TbEmpleado getTbEmpleado() {
        return tbEmpleado;
    }

    public void setTbEmpleado(TbEmpleado tbEmpleado) {
        this.tbEmpleado = tbEmpleado;
    }

    @OneToOne
    @JoinColumn (name = "id_tipo_pers", referencedColumnName = "id_tipo_pers", unique = true)
    public TbTipoPersona getTbTipoPersona() {
        return tbTipoPersona;
    }

    public void setTbTipoPersona(TbTipoPersona tbTipoPersona) {
        this.tbTipoPersona = tbTipoPersona;
    }

    @ManyToOne
    @JoinColumn (name = "id_tipo_doc", referencedColumnName = "id_tipo_doc", unique = true)
    public TbTipoDoc getTbTipoDoc() {
        return tbTipoDoc;
    }

    public void setTbTipoDoc(TbTipoDoc tbTipoDoc) {
        this.tbTipoDoc = tbTipoDoc;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tbPersonas")
    public Set<TbPersonas> getTbPersonas() {
        return tbPersonas;
    }

    public void setTbPersonas(Set<TbPersonas> tbPersonas) {
        this.tbPersonas = tbPersonas;
    }
    
     
}
