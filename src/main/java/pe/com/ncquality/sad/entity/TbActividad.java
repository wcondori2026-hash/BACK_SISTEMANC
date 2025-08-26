
package pe.com.ncquality.sad.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table (name = "tb_actividad", schema = "public")
public class TbActividad {
    private Integer idActividad;
    private String codTipoAct;
    private String descrip;
    private Date fecAct;
    private String estado;
    private Integer idUserCre;
    private Date fecRegCrea;
    private Integer idUserMod;
    private Date fecRegMod;
    private TbProyecto tbProyecto;

    public TbActividad() {
    }

    public TbActividad(Integer idActividad, String codTipoAct, String descrip, Date fecAct,
            String estado, Integer idUserCre, Date fecRegCrea, Integer idUserMod, 
            Date fecRegMod, TbProyecto tbProyecto) {
        this.idActividad = idActividad;
        this.codTipoAct = codTipoAct;
        this.descrip = descrip;
        this.fecAct = fecAct;
        this.estado = estado;
        this.idUserCre = idUserCre;
        this.fecRegCrea = fecRegCrea;
        this.idUserMod = idUserMod;
        this.fecRegMod = fecRegMod;
        this.tbProyecto = tbProyecto;
    }

    @Id
    @Column (name = "id_actividad", unique = true, nullable = false, length = 15)
    public Integer getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(Integer idActividad) {
        this.idActividad = idActividad;
    }

    @Column(name = "v_cod_tipo_act", nullable = false, length = 5)
    public String getCodTipoAct() {
        return codTipoAct;
    }

    public void setCodTipoAct(String codTipoAct) {
        this.codTipoAct = codTipoAct;
    }

    @Column(name = "v_descripcion", nullable = false, length = 200)
    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    @Column(name = "d_fec_act", nullable = false, length = 15)
    @Temporal(TemporalType.DATE)
    public Date getFecAct() {
        return fecAct;
    }

    public void setFecAct(Date fecAct) {
        this.fecAct = fecAct;
    }

    @Column(name = "b_estado", nullable = false, length = 1)
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Column(name = "i_id_usuario_crea", nullable = false, length = 15)
    public Integer getIdUserCre() {
        return idUserCre;
    }

    public void setIdUserCre(Integer idUserCre) {
        this.idUserCre = idUserCre;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "d_fecha_reg_cre", nullable = false, length = 15)    
    public Date getFecRegCrea() {
        return fecRegCrea;
    }

    public void setFecRegCrea(Date fecRegCrea) {
        this.fecRegCrea = fecRegCrea;
    }

    @Column(name = "i_id_usuario_mod", nullable = false, length = 15)
    public Integer getIdUserMod() {
        return idUserMod;
    }

    public void setIdUserMod(Integer idUserMod) {
        this.idUserMod = idUserMod;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "d_fecha_reg_mod", nullable = false, length = 15)    
    public Date getFecRegMod() {
        return fecRegMod;
    }

    public void setFecRegMod(Date fecRegMod) {
        this.fecRegMod = fecRegMod;
    }

    @ManyToOne
    @JoinColumn (name = "id_proyecto", referencedColumnName = "id_proyecto", unique = true)
    public TbProyecto getTbProyecto() {
        return tbProyecto;
    }

    public void setTbProyecto(TbProyecto tbProyecto) {
        this.tbProyecto = tbProyecto;
    }
    
    
    
    
    
}
