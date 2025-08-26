
package pe.com.ncquality.sad.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigInteger;
import java.util.Date;


public class ShoppingDTO implements java.io.Serializable {
    private BigInteger fila;
    private Integer idEgreso;
    private String razonSocial;
    private String categoria;
    private String proyecto;
    private String documento;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Lima")
    private Date fechaEmi;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Lima")
    private Date fechaVenc;
    
    private String codEtapa;
    private Integer tasaIgv;
    private Double igvMon;
    private Double montoTotal;
    private BigInteger totalRegistro;

    public ShoppingDTO() {
    }   

    public ShoppingDTO(BigInteger fila, Integer idEgreso, String razonSocial, String categoria, String proyecto, String documento, Date fechaEmi, Date fechaVenc, String codEtapa, Integer tasaIgv, Double igvMon, Double montoTotal, BigInteger totalRegistro) {
        this.fila = fila;
        this.idEgreso = idEgreso;
        this.razonSocial = razonSocial;
        this.categoria = categoria;
        this.proyecto = proyecto;
        this.documento = documento;
        this.fechaEmi = fechaEmi;
        this.fechaVenc = fechaVenc;
        this.codEtapa = codEtapa;
        this.tasaIgv = tasaIgv;
        this.igvMon = igvMon;
        this.montoTotal = montoTotal;
        this.totalRegistro = totalRegistro;
    }

    public BigInteger getFila() {
        return fila;
    }

    public void setFila(BigInteger fila) {
        this.fila = fila;
    }

    public Integer getIdEgreso() {
        return idEgreso;
    }

    public void setIdEgreso(Integer idEgreso) {
        this.idEgreso = idEgreso;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getProyecto() {
        return proyecto;
    }

    public void setProyecto(String proyecto) {
        this.proyecto = proyecto;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Date getFechaEmi() {
        return fechaEmi;
    }

    public void setFechaEmi(Date fechaEmi) {
        this.fechaEmi = fechaEmi;
    }

    public Date getFechaVenc() {
        return fechaVenc;
    }

    public void setFechaVenc(Date fechaVenc) {
        this.fechaVenc = fechaVenc;
    }

    public String getCodEtapa() {
        return codEtapa;
    }

    public void setCodEtapa(String codEtapa) {
        this.codEtapa = codEtapa;
    }

    public Integer getTasaIgv() {
        return tasaIgv;
    }

    public void setTasaIgv(Integer tasaIgv) {
        this.tasaIgv = tasaIgv;
    }

    public Double getIgvMon() {
        return igvMon;
    }

    public void setIgvMon(Double igvMon) {
        this.igvMon = igvMon;
    }

    public Double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public BigInteger getTotalRegistro() {
        return totalRegistro;
    }

    public void setTotalRegistro(BigInteger totalRegistro) {
        this.totalRegistro = totalRegistro;
    }
    
    
    
}
