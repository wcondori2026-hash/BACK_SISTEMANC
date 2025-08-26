
package pe.com.ncquality.sad.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table (name = "tb_categoria", schema = "public")
public class TbCategoria implements java.io.Serializable {
    
    private Integer idCategoria;
    private String vDescripcion;
    private char bEstado;
    private Integer iIdUsuarioCrea;
    private Date fFechaRegCrea;
    private Integer iIdUsuarioMod;
    private Date fFechaRegMod;
    private Set<TbCategoria> tbCategoria = new HashSet<TbCategoria>(0);

    public TbCategoria() {
    }

    public TbCategoria(Integer idCategoria, String vDescripcion, char bEstado, Integer iIdUsuarioCrea, Date fFechaRegCrea,
            Integer iIdUsuarioMod, Date fFechaRegMod, Set<TbCategoria> tbCategoria) {
        this.idCategoria = idCategoria;
        this.vDescripcion = vDescripcion;
        this.bEstado = bEstado;
        this.iIdUsuarioCrea = iIdUsuarioCrea;
        this.fFechaRegCrea = fFechaRegCrea;
        this.iIdUsuarioMod = iIdUsuarioMod;
        this.fFechaRegMod = fFechaRegMod;
        this.tbCategoria = tbCategoria;
    }
    
    

    @Id
    @Column (name = "id_categoria", unique = true, nullable = false, length = 15)
    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
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

    @Column(name = "i_id_usuario_crea", nullable = false, length = 15)
    public Integer getiIdUsuarioCrea() {
        return iIdUsuarioCrea;
    }

    public void setiIdUsuarioCrea(Integer iIdUsuarioCrea) {
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

     @Column(name = "i_id_usuario_mod", nullable = false, length = 15)
    public Integer getiIdUsuarioMod() {
        return iIdUsuarioMod;
    }

    public void setiIdUsuarioMod(Integer iIdUsuarioMod) {
        this.iIdUsuarioMod = iIdUsuarioMod;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "f_fecha_reg_mod", nullable = false, length = 15)
    public Date getfFechaRegMod() {
        return fFechaRegMod;
    }

    public void setfFechaRegMod(Date fFechaRegMod) {
        this.fFechaRegMod = fFechaRegMod;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tbCategoria")
    public Set<TbCategoria> getTbCategoria() {
        return tbCategoria;
    }

    public void setTbCategoria(Set<TbCategoria> tbCategoria) {
        this.tbCategoria = tbCategoria;
    }
    
    
    
  
}
