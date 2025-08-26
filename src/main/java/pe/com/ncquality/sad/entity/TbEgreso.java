
package pe.com.ncquality.sad.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_egreso", schema = "public")
public class TbEgreso {
    private Integer idEgreso;
    private String sCodEtapa;
    private String vCodCompra;
    private String vCodSubsi;
    private String vCodDoc;
    private String vNumCod;
    private String vSerieDoc;
    private Date dFecEmi;
    private Date dFecVenc;
    private Integer nTasaIgv;
    private Double nIgvMon;
    private Double nMonto;
    private Date dFecEmiRef;
    private String vCodDocRef;
    private String vNumDocRef;
    private String vSerieDocRef;
    private String vCodTipoConver;
    private Double vTipoCambio;
    private Date dFecCambio;
    private String vGlosa;
    private String vCodMoneda;
    private String bEstado;
    private Integer iIdUsuarioCrea;
    private Date dFecRegCrea;
    private Integer iIdUsuarioMod;
    private Date dFecRegMod;
    private TbCategoria tbCategoria;
    private TbProyecto tbProyecto;
    private TbPersonas tbPersonas;
    private TbEmpresa tbEmpresa;
    private TbSubcategoria tbSubcategoria;
    private Set<TbEgreso> tbEgreso = new HashSet<TbEgreso>(0);

    public TbEgreso() {
    }

    public TbEgreso(Integer idEgreso, String sCodEtapa, String vCodCompra, String vCodSubsi,
            String vCodDoc, String vNumCod, String vSerieDoc, Date dFecEmi, Date dFecVenc,
            Integer nTasaIgv, Double nIgvMon, Double nMonto, Date dFecEmiRef, String vCodDocRef, 
            String vNumDocRef, String vSerieDocRef, String vCodTipoConver, Double vTipoCambio, 
            Date dFecCambio, String vGlosa, String vCodMoneda, String bEstado, Integer iIdUsuarioCrea, 
            Date dFecRegCrea, Integer iIdUsuarioMod, Date dFecRegMod, TbCategoria tbCategoria, TbProyecto tbProyecto, 
            TbPersonas tbPersonas, TbEmpresa tbEmpresa, TbSubcategoria tbSubcategoria) {
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
        this.tbCategoria = tbCategoria;
        this.tbProyecto = tbProyecto;
        this.tbPersonas = tbPersonas;
        this.tbEmpresa = tbEmpresa;
        this.tbSubcategoria = tbSubcategoria;
    }
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column (name = "id_egreso", unique = true, nullable = false, length = 15)
    public Integer getIdEgreso() {
        return idEgreso;
    }

    public void setIdEgreso(Integer idEgreso) {
        this.idEgreso = idEgreso;
    }

    @Column(name = "s_cod_etapa", nullable = false, length = 5)
    public String getsCodEtapa() {
        return sCodEtapa;
    }

    public void setsCodEtapa(String sCodEtapa) {
        this.sCodEtapa = sCodEtapa;
    }

    @Column (name = "v_cod_compra", unique = true, nullable = false, length = 5)
    public String getvCodCompra() {
        return vCodCompra;
    }

    public void setvCodCompra(String vCodCompra) {
        this.vCodCompra = vCodCompra;
    }

    @Column (name = "v_cod_subdiario", unique = true, nullable = false, length = 5)
    public String getvCodSubsi() {
        return vCodSubsi;
    }

    public void setvCodSubsi(String vCodSubsi) {
        this.vCodSubsi = vCodSubsi;
    }

    @Column (name = "v_cod_doc", unique = true, nullable = false, length = 5)
    public String getvCodDoc() {
        return vCodDoc;
    }

    public void setvCodDoc(String vCodDoc) {
        this.vCodDoc = vCodDoc;
    }

    @Column (name = "v_num_doc", unique = true, nullable = false, length = 20)
    public String getvNumCod() {
        return vNumCod;
    }

    public void setvNumCod(String vNumCod) {
        this.vNumCod = vNumCod;
    }

    @Column (name = "v_serie_doc", unique = true, nullable = false, length = 2)
    public String getvSerieDoc() {
        return vSerieDoc;
    }

    public void setvSerieDoc(String vSerieDoc) {
        this.vSerieDoc = vSerieDoc;
    }

    @Temporal(TemporalType.DATE)
    @Column (name = "d_fec_emi", unique = true, nullable = false, length = 15)
    public Date getdFecEmi() {
        return dFecEmi;
    }

    public void setdFecEmi(Date dFecEmi) {
        this.dFecEmi = dFecEmi;
    }

    @Temporal(TemporalType.DATE)
    @Column (name = "d_fec_venc", unique = true, nullable = false, length = 15)
    public Date getdFecVenc() {
        return dFecVenc;
    }

    public void setdFecVenc(Date dFecVenc) {
        this.dFecVenc = dFecVenc;
    }

    @Column (name = "n_tasa_igv", unique = true, nullable = false, length = 15)
    public Integer getnTasaIgv() {
        return nTasaIgv;
    }

    public void setnTasaIgv(Integer nTasaIgv) {
        this.nTasaIgv = nTasaIgv;
    }

    @Column (name = "n_igv_mon", unique = true, nullable = false, length = 15)
    public Double getnIgvMon() {
        return nIgvMon;
    }

    public void setnIgvMon(Double nIgvMon) {
        this.nIgvMon = nIgvMon;
    }

    @Column (name = "n_monto", unique = true, nullable = false, length = 15)
    public Double getnMonto() {
        return nMonto;
    }

    public void setnMonto(Double nMonto) {
        this.nMonto = nMonto;
    }

    @Temporal(TemporalType.DATE)
    @Column (name = "d_fec_emi_ref", unique = true, nullable = false, length = 15)
    public Date getdFecEmiRef() {
        return dFecEmiRef;
    }

    public void setdFecEmiRef(Date dFecEmiRef) {
        this.dFecEmiRef = dFecEmiRef;
    }

    @Column (name = "v_cod_doc_ref", unique = true, nullable = false, length = 15)
    public String getvCodDocRef() {
        return vCodDocRef;
    }

    public void setvCodDocRef(String vCodDocRef) {
        this.vCodDocRef = vCodDocRef;
    }

    @Column (name = "v_num_doc_ref", unique = true, nullable = false, length = 15)
    public String getvNumDocRef() {
        return vNumDocRef;
    }

    public void setvNumDocRef(String vNumDocRef) {
        this.vNumDocRef = vNumDocRef;
    }

    @Column (name = "v_serie_doc_ref", unique = true, nullable = false, length = 15)
    public String getvSerieDocRef() {
        return vSerieDocRef;
    }

    public void setvSerieDocRef(String vSerieDocRef) {
        this.vSerieDocRef = vSerieDocRef;
    }

    @Column (name = "v_cod_tipo_conver", unique = true, nullable = false, length = 15)
    public String getvCodTipoConver() {
        return vCodTipoConver;
    }

    public void setvCodTipoConver(String vCodTipoConver) {
        this.vCodTipoConver = vCodTipoConver;
    }

    @Column (name = "v_tipo_camb", unique = true, nullable = false, length = 15)
    public Double getvTipoCambio() {
        return vTipoCambio;
    }

    public void setvTipoCambio(Double vTipoCambio) {
        this.vTipoCambio = vTipoCambio;
    }

    @Temporal(TemporalType.DATE)
    @Column (name = "d_fec_camb", unique = true, nullable = false, length = 15)
    public Date getdFecCambio() {
        return dFecCambio;
    }

    public void setdFecCambio(Date dFecCambio) {
        this.dFecCambio = dFecCambio;
    }

    @Column (name = "v_glosa", unique = true, nullable = false, length = 15)
    public String getvGlosa() {
        return vGlosa;
    }

    public void setvGlosa(String vGlosa) {
        this.vGlosa = vGlosa;
    }

    @Column (name = "v_cod_moned", unique = true, nullable = false, length = 15)
    public String getvCodMoneda() {
        return vCodMoneda;
    }

    public void setvCodMoneda(String vCodMoneda) {
        this.vCodMoneda = vCodMoneda;
    }

    @Column(name = "b_estado", nullable = false, length = 1)
    public String getbEstado() {
        return bEstado;
    }

    public void setbEstado(String bEstado) {
        this.bEstado = bEstado;
    }

    @Column (name = "i_id_usuario_cre", unique = true, nullable = false, length = 15)
    public Integer getiIdUsuarioCrea() {
        return iIdUsuarioCrea;
    }

    public void setiIdUsuarioCrea(Integer iIdUsuarioCrea) {
        this.iIdUsuarioCrea = iIdUsuarioCrea;
    }

    @Temporal(TemporalType.DATE)
    @Column (name = "d_fecha_reg_cre", unique = true, nullable = false, length = 15)
    public Date getdFecRegCrea() {
        return dFecRegCrea;
    }

    public void setdFecRegCrea(Date dFecRegCrea) {
        this.dFecRegCrea = dFecRegCrea;
    }

    @Column (name = "i_id_usuario_mod", unique = true, nullable = false, length = 15)
    public Integer getiIdUsuarioMod() {
        return iIdUsuarioMod;
    }

    public void setiIdUsuarioMod(Integer iIdUsuarioMod) {
        this.iIdUsuarioMod = iIdUsuarioMod;
    }

    @Temporal(TemporalType.DATE)
    @Column (name = "d_fecha_reg_mod", unique = true, nullable = false, length = 15)
    public Date getdFecRegMod() {
        return dFecRegMod;
    }

    public void setdFecRegMod(Date dFecRegMod) {
        this.dFecRegMod = dFecRegMod;
    }

    @ManyToOne
    @JoinColumn (name = "id_categoria", referencedColumnName = "id_categoria", unique = true)
    public TbCategoria getTbCategoria() {
        return tbCategoria;
    }

    public void setTbCategoria(TbCategoria tbCategoria) {
        this.tbCategoria = tbCategoria;
    }

    @ManyToOne
    @JoinColumn (name = "id_proyecto", referencedColumnName = "id_proyecto", unique = true)
    public TbProyecto getTbProyecto() {
        return tbProyecto;
    }

    public void setTbProyecto(TbProyecto tbProyecto) {
        this.tbProyecto = tbProyecto;
    }

    @ManyToOne
    @JoinColumn (name = "id_persona", referencedColumnName = "id_persona", unique = true)
    public TbPersonas getTbPersonas() {
        return tbPersonas;
    }

    public void setTbPersonas(TbPersonas tbPersonas) {
        this.tbPersonas = tbPersonas;
    }

    @ManyToOne
    @JoinColumn (name = "id_empresa", referencedColumnName = "id_empresa", unique = true)
    public TbEmpresa getTbEmpresa() {
        return tbEmpresa;
    }

    public void setTbEmpresa(TbEmpresa tbEmpresa) {
        this.tbEmpresa = tbEmpresa;
    }

    @ManyToOne
    @JoinColumn (name = "id_subcateg", referencedColumnName = "id_subcateg", unique = true)
    public TbSubcategoria getTbSubcategoria() {
        return tbSubcategoria;
    }

    public void setTbSubcategoria(TbSubcategoria tbSubcategoria) {
        this.tbSubcategoria = tbSubcategoria;
    }    
    
    }
    
