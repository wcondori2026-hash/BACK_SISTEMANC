
package pe.com.ncquality.sad.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "tb_tipo_persona", schema = "public")
public class TbTipoPersona implements java.io.Serializable {
    private int idTipoper;
    private String vDescripcion;
    private char bEstado;
    private TbPersonas tbPersonas;

    public TbTipoPersona() {
    }

    public TbTipoPersona(int idTipoper, String vDescripcion, char bEstado) {
        this.idTipoper = idTipoper;
        this.vDescripcion = vDescripcion;
        this.bEstado = bEstado;
    }

    public TbTipoPersona(int idTipoper, String vDescripcion, char bEstado, TbPersonas tbPersonas) {
        this.idTipoper = idTipoper;
        this.vDescripcion = vDescripcion;
        this.bEstado = bEstado;
        this.tbPersonas = tbPersonas;
    }
    
    

    @Id
    @Column(name = "id_tipo_pers", unique = true, nullable = false, length = 15)
    public int getIdTipoper() {
        return idTipoper;
    }

    public void setIdTipoper(int idTipoper) {
        this.idTipoper = idTipoper;
    }

    @Column(name = "v_descripcion", nullable = false, length = 15)
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

    @OneToOne(mappedBy = "tbTipoPersona")
    public TbPersonas getTbPersonas() {
        return tbPersonas;
    }

    public void setTbPersonas(TbPersonas tbPersonas) {
        this.tbPersonas = tbPersonas;
    }
   
}


