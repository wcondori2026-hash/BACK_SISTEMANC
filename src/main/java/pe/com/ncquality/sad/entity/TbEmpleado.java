package pe.com.ncquality.sad.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_empleado", schema = "public")
public class TbEmpleado implements java.io.Serializable{
    
    private int idEmpleado;
    //private int idPersona;
    private char bEstado;
    private String codEtapa;
    private int iIdUsuarioCrea;
    private Date fFechaRegCrea;
    private Integer iIdUsuarioMod;
    private Date fFechaRegMod;
    private TbUsuario tbUsuario;
     
    private TbPersonas tbPersonas;

    public TbEmpleado() {
    }

    public TbEmpleado(int idEmpleado, char bEstado, String codEtapa, int iIdUsuarioCrea, Date fFechaRegCrea, Integer iIdUsuarioMod, Date fFechaRegMod, TbUsuario tbUsuario, TbPersonas tbPersonas) {
        this.idEmpleado = idEmpleado;
        this.bEstado = bEstado;
        this.codEtapa = codEtapa;
        this.iIdUsuarioCrea = iIdUsuarioCrea;
        this.fFechaRegCrea = fFechaRegCrea;
        this.iIdUsuarioMod = iIdUsuarioMod;
        this.fFechaRegMod = fFechaRegMod;
        this.tbUsuario = tbUsuario;
        this.tbPersonas = tbPersonas;
    }

    


    @Id
    @Column(name = "id_empleado", unique = true, nullable = false, length = 15)
    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
    
    @OneToOne (mappedBy = "tbEmpleado", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY) 
    @PrimaryKeyJoinColumn
    public TbUsuario getTbUsuario() {
        return tbUsuario;
    }

    public void setTbUsuario(TbUsuario TbUsuario) {
        this.tbUsuario = TbUsuario;
    }

    /*@Column(name = "id_persona", nullable = false, length = 15, insertable = false, updatable = false )
    public int getIdPersona() {
        return idPersona;
    }
   

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }*/
        
    /*OneToOne
    @JoinColumn (name = "id_persona", referencedColumnName = "id_persona", unique = true)
    public TbPersonas getTbpersonas() {
        return tbPersonas;
    }

    public void setTbpersonas(TbPersonas tbPersonas) {
        this.tbPersonas = tbersonas;
    }*/

    @OneToOne
    @JoinColumn (name = "id_persona", referencedColumnName = "id_persona", unique = true)
    public TbPersonas getTbPersonas() {
        return tbPersonas;
    }

    public void setTbPersonas(TbPersonas tbPersonas) {
        this.tbPersonas = tbPersonas;
    }

    

    @Column(name = "b_estado", nullable = false, length = 1)
    public char getbEstado() {
        return bEstado;
    }

    public void setbEstado(char bEstado) {
        this.bEstado = bEstado;
    }

    @Column(name = "v_cod_estapa", nullable = false, length = 15)
    public String getCodEtapa() {
        return codEtapa;
    }

    public void setCodEtapa(String codEtapa) {
        this.codEtapa = codEtapa;
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
    @Column(name = "f_fecha_reg_mod", nullable = true, length = 1)
    public Date getfFechaRegMod() {
        return fFechaRegMod;
    }

    public void setfFechaRegMod(Date fFechaRegMod) {
        this.fFechaRegMod = fFechaRegMod;
    }

    
}
