
package pe.com.ncquality.sad.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "tb_tipo_doc", schema = "public")
public class TbTipoDoc implements java.io.Serializable {
    private int idTipoDoc;
    private String vDescripcion;
    private char bEstado;
    private Set<TbPersonas> TbPersonas = new HashSet<TbPersonas>(0);

    public TbTipoDoc() {
    }

    public TbTipoDoc(int idTipoDoc, String vDescripcion, char bEstado) {
        this.idTipoDoc = idTipoDoc;
        this.vDescripcion = vDescripcion;
        this.bEstado = bEstado;
    }
    
    public TbTipoDoc(int idTipoDoc, String vDescripcion, char bEstado, Set<TbPersonas> TbPersonas) {
        this.idTipoDoc = idTipoDoc;
        this.vDescripcion = vDescripcion;
        this.bEstado = bEstado;
        this.TbPersonas = TbPersonas;
    }
    
    
    @Id
    @Column(name = "id_tipo_doc", unique = true, nullable = false, length = 15)
    public int getIdTipoDoc() {
        return idTipoDoc;
    }

    public void setIdTipoDoc(int idTipoDoc) {
        this.idTipoDoc = idTipoDoc;
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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tbTipoDoc")
    public Set<TbPersonas> getTbPersonas() {
        return TbPersonas;
    }

    public void setTbPersonas(Set<TbPersonas> TbPersonas) {
        this.TbPersonas = TbPersonas;
    }


    

    
  
}

