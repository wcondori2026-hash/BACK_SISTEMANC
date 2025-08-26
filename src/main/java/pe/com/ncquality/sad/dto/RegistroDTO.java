
package pe.com.ncquality.sad.dto;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import javax.validation.constraints.NotNull;

public class RegistroDTO {
    private Integer idEgreso;
    private String sCodEtapa;
    private String vCodCompra;
    private String vCodSubsi;
    private String vCodDoc;
    private String vNumCod;
    private String vSerieDoc;
    
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy"
    private String dFecEmi;
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private String dFecVenc;
    
    //private Double nTasaIgv;
    private Integer nTasaIgv;
    private Double nIgvMon;
    private Double nMonto;
    
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private String dFecEmiRef;
    
    private String vCodDocRef;
    private String vNumDocRef;
    private String vSerieDocRef;
    private String vCodTipoConver;
    private Double vTipoCambio;
    
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy"
    private String dFecCambio;
    
    private String vGlosa;
    private String vCodMoneda;
    private String bEstado;
    private Integer iIdUsuarioCrea;
    
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private String dFecRegCrea;
    
    private Integer iIdUsuarioMod;
    
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private String dFecRegMod;
    
    private Integer idCategoria;
    private Integer idProyecto;
    private Integer idPersonas;
    private Integer idEmpresa;
    private Integer idSubcategoria;

    public RegistroDTO() {
    }

    public RegistroDTO(Integer idEgreso, String sCodEtapa, String vCodCompra, String vCodSubsi, String vCodDoc,
            String vNumCod, String vSerieDoc, String dFecEmi, String dFecVenc, Integer nTasaIgv, Double nIgvMon, 
            Double nMonto, String dFecEmiRef, String vCodDocRef, String vNumDocRef, String vSerieDocRef, 
            String vCodTipoConver, Double vTipoCambio, String dFecCambio, String vGlosa, String vCodMoneda,
            String bEstado, Integer iIdUsuarioCrea, String dFecRegCrea, Integer iIdUsuarioMod, String dFecRegMod,
            Integer idCategoria, Integer idProyecto, Integer idPersonas, Integer idEmpresa, Integer idSubcategoria) {
        this.idEgreso = idEgreso;
        this.sCodEtapa = sCodEtapa;
        this.vCodCompra = vCodCompra;
        this.vCodSubsi = vCodSubsi;
        this.vCodDoc = vCodDoc;
        this.vNumCod = vNumCod;
        this.vSerieDoc = vSerieDoc;
        this.dFecEmi = dFecEmi;
        this.dFecVenc = dFecVenc;
        this.nTasaIgv = nTasaIgv;
        this.nIgvMon = nIgvMon;
        this.nMonto = nMonto;
        this.dFecEmiRef = dFecEmiRef;
        this.vCodDocRef = vCodDocRef;
        this.vNumDocRef = vNumDocRef;
        this.vSerieDocRef = vSerieDocRef;
        this.vCodTipoConver = vCodTipoConver;
        this.vTipoCambio = vTipoCambio;
        this.dFecCambio = dFecCambio;
        this.vGlosa = vGlosa;
        this.vCodMoneda = vCodMoneda;
        this.bEstado = bEstado;
        this.iIdUsuarioCrea = iIdUsuarioCrea;
        this.dFecRegCrea = dFecRegCrea;
        this.iIdUsuarioMod = iIdUsuarioMod;
        this.dFecRegMod = dFecRegMod;
        this.idCategoria = idCategoria;
        this.idProyecto = idProyecto;
        this.idPersonas = idPersonas;
        this.idEmpresa = idEmpresa;
        this.idSubcategoria = idSubcategoria;
    }
    
    

    public Integer getIdEgreso() {
        return idEgreso;
    }

    public void setIdEgreso(Integer idEgreso) {
        this.idEgreso = idEgreso;
    }

    public String getsCodEtapa() {
        return sCodEtapa;
    }

    public void setsCodEtapa(String sCodEtapa) {
        this.sCodEtapa = sCodEtapa;
    }

    public String getvCodCompra() {
        return vCodCompra;
    }

    public void setvCodCompra(String vCodCompra) {
        this.vCodCompra = vCodCompra;
    }

    public String getvCodSubsi() {
        return vCodSubsi;
    }

    public void setvCodSubsi(String vCodSubsi) {
        this.vCodSubsi = vCodSubsi;
    }

    public String getvCodDoc() {
        return vCodDoc;
    }

    public void setvCodDoc(String vCodDoc) {
        this.vCodDoc = vCodDoc;
    }

    public String getvNumCod() {
        return vNumCod;
    }

    public void setvNumCod(String vNumCod) {
        this.vNumCod = vNumCod;
    }

    public String getvSerieDoc() {
        return vSerieDoc;
    }

    public void setvSerieDoc(String vSerieDoc) {
        this.vSerieDoc = vSerieDoc;
    }

    public String getdFecEmi() {
        return dFecEmi;
    }

    public void setdFecEmi(String dFecEmi) {
        this.dFecEmi = dFecEmi;
    }

    public String getdFecVenc() {
        return dFecVenc;
    }

    public void setdFecVenc(String dFecVenc) {
        this.dFecVenc = dFecVenc;
    }

    public Integer getnTasaIgv() {
        return nTasaIgv;
    }

    public void setnTasaIgv(Integer nTasaIgv) {
        this.nTasaIgv = nTasaIgv;
    }

    public Double getnIgvMon() {
        return nIgvMon;
    }

    public void setnIgvMon(Double nIgvMon) {
        this.nIgvMon = nIgvMon;
    }

    public Double getnMonto() {
        return nMonto;
    }

    public void setnMonto(Double nMonto) {
        this.nMonto = nMonto;
    }

    public String getdFecEmiRef() {
        return dFecEmiRef;
    }

    public void setdFecEmiRef(String dFecEmiRef) {
        this.dFecEmiRef = dFecEmiRef;
    }

    public String getvCodDocRef() {
        return vCodDocRef;
    }

    public void setvCodDocRef(String vCodDocRef) {
        this.vCodDocRef = vCodDocRef;
    }

    public String getvNumDocRef() {
        return vNumDocRef;
    }

    public void setvNumDocRef(String vNumDocRef) {
        this.vNumDocRef = vNumDocRef;
    }

    public String getvSerieDocRef() {
        return vSerieDocRef;
    }

    public void setvSerieDocRef(String vSerieDocRef) {
        this.vSerieDocRef = vSerieDocRef;
    }

    public String getvCodTipoConver() {
        return vCodTipoConver;
    }

    public void setvCodTipoConver(String vCodTipoConver) {
        this.vCodTipoConver = vCodTipoConver;
    }

    public Double getvTipoCambio() {
        return vTipoCambio;
    }

    public void setvTipoCambio(Double vTipoCambio) {
        this.vTipoCambio = vTipoCambio;
    }

    public String getdFecCambio() {
        return dFecCambio;
    }

    public void setdFecCambio(String dFecCambio) {
        this.dFecCambio = dFecCambio;
    }

    public String getvGlosa() {
        return vGlosa;
    }

    public void setvGlosa(String vGlosa) {
        this.vGlosa = vGlosa;
    }

    public String getvCodMoneda() {
        return vCodMoneda;
    }

    public void setvCodMoneda(String vCodMoneda) {
        this.vCodMoneda = vCodMoneda;
    }

    public String getbEstado() {
        return bEstado;
    }

    public void setbEstado(String bEstado) {
        this.bEstado = bEstado;
    }

    public Integer getiIdUsuarioCrea() {
        return iIdUsuarioCrea;
    }

    public void setiIdUsuarioCrea(Integer iIdUsuarioCrea) {
        this.iIdUsuarioCrea = iIdUsuarioCrea;
    }

    public String getdFecRegCrea() {
        return dFecRegCrea;
    }

    public void setdFecRegCrea(String dFecRegCrea) {
        this.dFecRegCrea = dFecRegCrea;
    }

    public Integer getiIdUsuarioMod() {
        return iIdUsuarioMod;
    }

    public void setiIdUsuarioMod(Integer iIdUsuarioMod) {
        this.iIdUsuarioMod = iIdUsuarioMod;
    }

    public String getdFecRegMod() {
        return dFecRegMod;
    }

    public void setdFecRegMod(String dFecRegMod) {
        this.dFecRegMod = dFecRegMod;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Integer getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }

    public Integer getIdPersonas() {
        return idPersonas;
    }

    public void setIdPersonas(Integer idPersonas) {
        this.idPersonas = idPersonas;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Integer getIdSubcategoria() {
        return idSubcategoria;
    }

    public void setIdSubcategoria(Integer idSubcategoria) {
        this.idSubcategoria = idSubcategoria;
    }
    
    
    
    
}
    
