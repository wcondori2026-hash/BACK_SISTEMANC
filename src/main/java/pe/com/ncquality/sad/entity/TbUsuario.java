
package pe.com.ncquality.sad.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "tb_usuario", schema = "public")
public class TbUsuario implements java.io.Serializable {

    private int idEmpleado;
    private String vUsuario;
    private Date dFecAlta;
    private Date dFecBaja;
    private String vAuthi;
    private String vClave;
    private String vEsUsua;
    private Date dFecModAuth;
    private int nIntentos;
    private int iIdUsuarioCrea;
    private Date fFechaRegCrea;
    private Integer iIdUsuarioMod;
    private Date fFechaRegMod;
    private char bEstado;
    private TbEmpleado tbEmpleado;

    public TbUsuario() {
    }

    public TbUsuario(int idEmpleado, String vUsuario, Date dFecAlta, Date dFecBaja, String vAuthi, String vClave, String vEsUsua, Date dFecModAuth, int nIntentos, int iIdUsuarioCrea, Date fFechaRegCrea, Integer iIdUsuarioMod, Date fFechaRegMod, char bEstado, TbEmpleado tbEmpleado) {
        this.idEmpleado = idEmpleado;
        this.vUsuario = vUsuario;
        this.dFecAlta = dFecAlta;
        this.dFecBaja = dFecBaja;
        this.vAuthi = vAuthi;
        this.vClave = vClave;
        this.vEsUsua = vEsUsua;
        this.dFecModAuth = dFecModAuth;
        this.nIntentos = nIntentos;
        this.iIdUsuarioCrea = iIdUsuarioCrea;
        this.fFechaRegCrea = fFechaRegCrea;
        this.iIdUsuarioMod = iIdUsuarioMod;
        this.fFechaRegMod = fFechaRegMod;
        this.bEstado = bEstado;
        this.tbEmpleado = tbEmpleado;
    }


    
    @Id
    @Column(name = "id_empleado", unique = true, nullable = false, length = 15)
    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "id_empleado")
    public TbEmpleado getTbEmpleado() {
        return tbEmpleado;
    }

    public void setTbEmpleado(TbEmpleado tbEmpleado) {
        this.tbEmpleado = tbEmpleado;
    }
    
    @Column(name = "v_usuario", nullable = false, length = 15)
    public String getvUsuario() {
        return vUsuario;
    }

    public void setvUsuario(String vUsuario) {
        this.vUsuario = vUsuario;
    }
    
    @Temporal(TemporalType.DATE)
    @Column(name = "d_fec_alta", nullable = false, length = 15)
    public Date getdFecAlta() {
        return dFecAlta;
    }

    public void setdFecAlta(Date dFecAlta) {
        this.dFecAlta = dFecAlta;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "d_fec_baja", nullable = true, length = 15)
    public Date getdFecBaja() {
        return dFecBaja;
    }

    
    public void setdFecBaja(Date dFecBaja) {
        this.dFecBaja = dFecBaja;
    }

    @Column(name = "v_authi", nullable = false, length = 15)
    public String getvAuthi() {
        return vAuthi;
    }

    public void setvAuthi(String vAuthi) {
        this.vAuthi = vAuthi;
    }
    
    @Column(name = "v_clave", nullable = false, length = 200)
    public String getvClave() {
        return vClave;
    }

    public void setvClave(String vClave) {
        this.vClave = vClave;
    }
    

    @Column(name = "v_es_usua", nullable = false, length = 15)
    public String getvEsUsua() {
        return vEsUsua;
    }

    public void setvEsUsua(String vEsUsua) {
        this.vEsUsua = vEsUsua;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "d_fec_mod_auth", nullable = true, length = 15)
    public Date getdFecModAuth() {
        return dFecModAuth;
    }

    public void setdFecModAuth(Date dFecModAuth) {
        this.dFecModAuth = dFecModAuth;
    }

    @Column(name = "n_intentos", nullable = true, length = 15)
    public int getnIntentos() {
        return nIntentos;
    }

    public void setnIntentos(int nIntentos) {
        this.nIntentos = nIntentos;
    }

    @Column(name = "i_id_usuario_crea", nullable = false, length = 15)
    public int getiIdUsuarioCrea() {
        return iIdUsuarioCrea;
    }

    public void setiIdUsuarioCrea(int iIdUsuarioCrea) {
        this.iIdUsuarioCrea = iIdUsuarioCrea;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "f_fecha_reg_crea", nullable = false, length = 15)
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
    @Column(name = "f_fecha_reg_mod", nullable = true, length = 15)
    public Date getfFechaRegMod() {
        return fFechaRegMod;
    }

    public void setfFechaRegMod(Date fFechaRegMod) {
        this.fFechaRegMod = fFechaRegMod;
    }

    @Column(name = "b_estado", nullable = false, length = 1)
    public char getbEstado() {
        return bEstado;
    }

    public void setbEstado(char bEstado) {
        this.bEstado = bEstado;
    }
    

}
