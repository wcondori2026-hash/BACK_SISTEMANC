
package pe.com.ncquality.sad.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "tb_codigos", schema = "public")
public class TbCodigos {
    private Integer idCodigo;
    private String vCodTipo;
    private String vDescripcion;
    private String vDescripCorta;
    private char bEstado;
    private String vTipo;

    public TbCodigos() {
    }

    public TbCodigos(Integer idCodigo, String vCodTipo, String vDescripcion, String vDescripCorta, char bEstado, String vTipo) {
        this.idCodigo = idCodigo;
        this.vCodTipo = vCodTipo;
        this.vDescripcion = vDescripcion;
        this.vDescripCorta = vDescripCorta;
        this.bEstado = bEstado;
        this.vTipo = vTipo;
    }

    @Id
    @Column (name = "id_codigo", unique = true, nullable = false, length = 15)
    public Integer getIdCodigo() {
        return idCodigo;
    }

    public void setIdCodigo(Integer idCodigo) {
        this.idCodigo = idCodigo;
    }

    @Column(name = "v_cod_tipo", nullable = false, length = 5)
    public String getvCodTipo() {
        return vCodTipo;
    }

    public void setvCodTipo(String vCodTipo) {
        this.vCodTipo = vCodTipo;
    }

    @Column(name = "v_descripcion", nullable = false, length = 50)
    public String getvDescripcion() {
        return vDescripcion;
    }

    public void setvDescripcion(String vDescripcion) {
        this.vDescripcion = vDescripcion;
    }

    @Column(name = "v_descr_corta", nullable = false, length = 20)
    public String getvDescripCorta() {
        return vDescripCorta;
    }

    public void setvDescripCorta(String vDescripCorta) {
        this.vDescripCorta = vDescripCorta;
    }

    @Column(name = "b_estado", nullable = false, length = 1)
    public char getbEstado() {
        return bEstado;
    }

    public void setbEstado(char bEstado) {
        this.bEstado = bEstado;
    }

    @Column(name = "v_tipo", nullable = false, length = 20)
    public String getvTipo() {
        return vTipo;
    }

    public void setvTipo(String vTipo) {
        this.vTipo = vTipo;
    }
    
    
}
