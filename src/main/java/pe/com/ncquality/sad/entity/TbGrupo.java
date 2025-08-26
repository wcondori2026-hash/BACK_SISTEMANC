
package pe.com.ncquality.sad.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "tb_grupo", schema = "public")       
public class TbGrupo implements java.io.Serializable {
    private Integer idGrupo;
    private String vDescripcion;
    private char bEstado;

    public TbGrupo() {
    }

    public TbGrupo(Integer idGrupo, String vDescripcion, char bEstado) {
        this.idGrupo = idGrupo;
        this.vDescripcion = vDescripcion;
        this.bEstado = bEstado;
    }

    @Id
    @Column (name = "id_grupo", unique = true, nullable = false, length = 15)
    public Integer getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Integer idGrupo) {
        this.idGrupo = idGrupo;
    }

    @Column(name = "v_descripcion", nullable = false, length = 20)
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
    
    
}
