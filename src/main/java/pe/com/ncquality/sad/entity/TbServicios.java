
package pe.com.ncquality.sad.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "tb_servicios", schema = "public")
public class TbServicios implements java.io.Serializable {
    
    private Integer idServicio;
    private String vDescripcion;
    private char bEstado;
    private String vCategoria;

    public TbServicios() {
    }

    public TbServicios(Integer idServicio, String vDescripcion, char bEstado, String vCategoria) {
        this.idServicio = idServicio;
        this.vDescripcion = vDescripcion;
        this.bEstado = bEstado;
        this.vCategoria = vCategoria;
    }

    @Id
    @Column(name = "id_servicio", unique = true, nullable = false, length = 15)
    public Integer getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Integer idServicio) {
        this.idServicio = idServicio;
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
    
    @Column(name = "v_categoria", nullable = false, length = 100)
    public String getvCategoria() {
        return vCategoria;
    }

    public void setvCategoria(String vCategoria) {
        this.vCategoria = vCategoria;
    }
    
    
   
    
}
