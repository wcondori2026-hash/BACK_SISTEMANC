
package pe.com.ncquality.sad.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigInteger;
import java.util.Date;


public class ProyectoDTO {
    private BigInteger fila;
    private Integer idProyecto;
    private String nroCotiza;
    private String proyecto;
    private String nombreCliente;
    private String apelPat;
    private String tipoDoc;
    private String numDoc;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Lima")
    private Date fecIni;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Lima")
    private Date fecFin;

    private Double costo;
    private Double gasto;
    private String etapa;
    private String actividad;
    private BigInteger totalRegistro;

    public ProyectoDTO() {
    }

    public ProyectoDTO(BigInteger fila, Integer idProyecto, String nroCotiza, String proyecto, 
            String nombreCliente, String apelPat, String tipoDoc, String numDoc, Date fecIni, Date fecFin, 
            Double costo, Double gasto, String etapa, String actividad, BigInteger totalRegistro) {
        this.fila = fila;
        this.idProyecto = idProyecto;
        this.nroCotiza = nroCotiza;
        this.proyecto = proyecto;
        this.nombreCliente = nombreCliente;
        this.apelPat = apelPat;
        this.tipoDoc = tipoDoc;
        this.numDoc = numDoc;
        this.fecIni = fecIni;
        this.fecFin = fecFin;
        this.costo = costo;
        this.gasto = gasto;
        this.etapa = etapa;
        this.actividad = actividad;
        this.totalRegistro = totalRegistro;
    }

    public BigInteger getFila() {
        return fila;
    }

    public void setFila(BigInteger fila) {
        this.fila = fila;
    }

    public Integer getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getNroCotiza() {
        return nroCotiza;
    }

    public void setNroCotiza(String nroCotiza) {
        this.nroCotiza = nroCotiza;
    }

    public String getProyecto() {
        return proyecto;
    }

    public void setProyecto(String proyecto) {
        this.proyecto = proyecto;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApelPat() {
        return apelPat;
    }

    public void setApelPat(String apelPat) {
        this.apelPat = apelPat;
    }

    public String getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public String getNumDoc() {
        return numDoc;
    }

    public void setNumDoc(String numDoc) {
        this.numDoc = numDoc;
    }

    public Date getFecIni() {
        return fecIni;
    }

    public void setFecIni(Date fecIni) {
        this.fecIni = fecIni;
    }

    public Date getFecFin() {
        return fecFin;
    }

    public void setFecFin(Date fecFin) {
        this.fecFin = fecFin;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public Double getGasto() {
        return gasto;
    }

    public void setGasto(Double gasto) {
        this.gasto = gasto;
    }

    public String getEtapa() {
        return etapa;
    }

    public void setEtapa(String etapa) {
        this.etapa = etapa;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public BigInteger getTotalRegistro() {
        return totalRegistro;
    }

    public void setTotalRegistro(BigInteger totalRegistro) {
        this.totalRegistro = totalRegistro;
    }

    
       
    
}
