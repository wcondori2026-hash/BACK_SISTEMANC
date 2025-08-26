
package pe.com.ncquality.sad.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_tipo_producto", schema = "public")
public class TbTipoProducto implements java.io.Serializable {
    private Integer idTipoProd;
    private String vDescripcion;
    private char bEstado;
    private String vCategoria;

    public TbTipoProducto() {
    }

    public TbTipoProducto(Integer idTipoProd, String vDescripcion, char bEstado, String vCategoria) {
        this.idTipoProd = idTipoProd;
        this.vDescripcion = vDescripcion;
        this.bEstado = bEstado;
        this.vCategoria = vCategoria;
    }

    @Id
    @Column (name = "id_tipo_prod", unique = true, nullable = false, length = 15 )
    public Integer getIdTipoProd() {
        return idTipoProd;
    }

    public void setIdTipoProd(Integer idTipoProd) {
        this.idTipoProd = idTipoProd;
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

    @Column(name = "v_categoria", nullable = false, length = 200)
    public String getvCategoria() {
        return vCategoria;
    }

    public void setvCategoria(String vCategoria) {
        this.vCategoria = vCategoria;
    }
    
    
}
