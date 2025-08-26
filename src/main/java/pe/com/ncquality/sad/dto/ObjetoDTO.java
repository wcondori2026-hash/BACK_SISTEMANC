
package pe.com.ncquality.sad.dto;


public class ObjetoDTO implements java.io.Serializable {
    private Integer id;
    private String vDescripcion;
    private char bEstado;

    public ObjetoDTO() {
    }

    public ObjetoDTO(Integer id, String vDescripcion, char bEstado) {
        this.id = id;
        this.vDescripcion = vDescripcion;
        this.bEstado = bEstado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getvDescripcion() {
        return vDescripcion;
    }

    public void setvDescripcion(String vDescripcion) {
        this.vDescripcion = vDescripcion;
    }

    public char getbEstado() {
        return bEstado;
    }

    public void setbEstado(char bEstado) {
        this.bEstado = bEstado;
    }

    
    
    
}
