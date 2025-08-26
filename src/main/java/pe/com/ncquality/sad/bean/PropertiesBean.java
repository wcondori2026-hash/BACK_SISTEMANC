package pe.com.ncquality.sad.bean;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:mpd.properties")
public class PropertiesBean implements Serializable {

	private static final long serialVersionUID = 1L;
	@Value("${jwt.secret}")
	private String secret;
		
	@Value("${sgd.secret_key_password}")
	private String sgdSecretKeyPassword;

	@Value("${sgd.codigo_grupo}")
	private String sgdCodigoGrupo;
	

	@Value("${sgd.codigo_proceso}")
	private String sgdCodigoProceso;
	
	@Value("${sgd.es_estado}")
	private String sgdEstado;
	
	//EXPEDIENTE
	@Value("${sgd.remitos.co_loc_emi}")
	private String sgdRemitosCodLocEmi;
	@Value("${sgd.remitos.co_gru}")
	private String sgdRemitosCodGru;
	@Value("${sgd.remitos.es_doc_emi}")
	private String sgdRemitosEstDocEmi;
	@Value("${sgd.remitos.nu_dia_ate}")
	private String sgdRemitosNumDiaAte;
	@Value("${sgd.remitos.es_eli}")
	private String sgdRemitosEstEli;
	@Value("${sgd.remitos.es_upd}")
	private String sgdRemitosEstUpd;
	@Value("${sgd.remitos.nu_det_exp}")
	private String sgdRemitosNumDetExp;
	@Value("${sgd.remitos.in_busca_texto}")
	private String sgdRemitosBuscaTexto;
	@Value("${sgd.remitos.ccod_origing}")
	private String sgdRemitosCodOriging;
	@Value("${sgd.remitos.aut_correoe}")
	private String sgdRemitosAutCorreoe;
	@Value("${sgd.remitos.ind_reitconginv}")
	private String sgdRemitosIndReitconginv;
	@Value("${sgd.remitos.cind_sensible}")
	private String sgdRemitosIndSensible;
	@Value("${sgd.remitos.nu_candes}")
	private String sgdRemitosNumCandes;
	@Value("${sgd.remitos.in_oficio}")
	private String sgdRemitosIndOficio;
	
	@Value("${sgd.destinos.nu_des}")
	private String sgdDestinosNumDes;
	@Value("${sgd.destinos.ti_des}")
	private String sgdDestinosTipDes;
	@Value("${sgd.destinos.es_eli}")
	private String sgdDestinosEstEli;
	@Value("${sgd.destinos.co_mot}")
	private String sgdDestinosCoMot;
	@Value("${sgd.destinos.co_pri}")
	private String sgdDestinosCoPri;
	@Value("${sgd.destinos.es_ent_mp}")
	private String sgdDestinosEsEntMp;
	@Value("${sgd.destinos.es_doc_rec}")
	private String sgdDestinosEsDocRec;
	
	@Value("${sgd.estadomovimiento.ti_proceso}")
	private String sgdEstadomovimientoTiProceso;
	@Value("${sgd.estadomovimiento.es_proceso}")
	private String sgdEstadomovimientoEsProceso;
	@Value("${sgd.estadomovimiento.es_firma}")
	private String sgdEstadomovimientoEsFirma;
	
	@Value("${sgd.archivodocumento.es_firma}")
	private String sgdArchivodocumentoEsFirma;
	
	@Value("${mpd.solicitud.estado_aprobado}")
	private String mpdSolicitudEstadoAprobado;
	@Value("${mpd.solicitud.estado_observado}")
	private String mpdSolicitudEstadoObservado;

	@Value("${mpd.esquema}")
	private String mpdEsquema;

	public String getMpdEsquema() {
		return mpdEsquema;
	}

	public void setMpdEsquema(String mpdEsquema) {
		this.mpdEsquema = mpdEsquema;
	}

	public String getMpdSolicitudEstadoAprobado() {
		return mpdSolicitudEstadoAprobado;
	}
	public void setMpdSolicitudEstadoAprobado(String mpdSolicitudEstadoAprobado) {
		this.mpdSolicitudEstadoAprobado = mpdSolicitudEstadoAprobado;
	}
	public String getMpdSolicitudEstadoObservado() {
		return mpdSolicitudEstadoObservado;
	}
	public void setMpdSolicitudEstadoObservado(String mpdSolicitudEstadoObservado) {
		this.mpdSolicitudEstadoObservado = mpdSolicitudEstadoObservado;
	}
	public String getSgdArchivodocumentoEsFirma() {
		return sgdArchivodocumentoEsFirma;
	}
	public void setSgdArchivodocumentoEsFirma(String sgdArchivodocumentoEsFirma) {
		this.sgdArchivodocumentoEsFirma = sgdArchivodocumentoEsFirma;
	}
	public String getSgdDestinosEsEntMp() {
		return sgdDestinosEsEntMp;
	}
	public void setSgdDestinosEsEntMp(String sgdDestinosEsEntMp) {
		this.sgdDestinosEsEntMp = sgdDestinosEsEntMp;
	}
	public String getSgdDestinosEsDocRec() {
		return sgdDestinosEsDocRec;
	}
	public void setSgdDestinosEsDocRec(String sgdDestinosEsDocRec) {
		this.sgdDestinosEsDocRec = sgdDestinosEsDocRec;
	}
	
	
	
	public String getSgdEstadomovimientoTiProceso() {
		return sgdEstadomovimientoTiProceso;
	}
	public void setSgdEstadomovimientoTiProceso(String sgdEstadomovimientoTiProceso) {
		this.sgdEstadomovimientoTiProceso = sgdEstadomovimientoTiProceso;
	}
	public String getSgdEstadomovimientoEsProceso() {
		return sgdEstadomovimientoEsProceso;
	}
	public void setSgdEstadomovimientoEsProceso(String sgdEstadomovimientoEsProceso) {
		this.sgdEstadomovimientoEsProceso = sgdEstadomovimientoEsProceso;
	}
	public String getSgdEstadomovimientoEsFirma() {
		return sgdEstadomovimientoEsFirma;
	}
	public void setSgdEstadomovimientoEsFirma(String sgdEstadomovimientoEsFirma) {
		this.sgdEstadomovimientoEsFirma = sgdEstadomovimientoEsFirma;
	}
	public String getSgdDestinosTipDes() {
		return sgdDestinosTipDes;
	}
	public void setSgdDestinosTipDes(String sgdDestinosTipDes) {
		this.sgdDestinosTipDes = sgdDestinosTipDes;
	}
	public String getSgdDestinosEstEli() {
		return sgdDestinosEstEli;
	}
	public void setSgdDestinosEstEli(String sgdDestinosEstEli) {
		this.sgdDestinosEstEli = sgdDestinosEstEli;
	}
	
	public String getSgdDestinosCoMot() {
		return sgdDestinosCoMot;
	}
	public void setSgdDestinosCoMot(String sgdDestinosCoMot) {
		this.sgdDestinosCoMot = sgdDestinosCoMot;
	}
	public String getSgdDestinosCoPri() {
		return sgdDestinosCoPri;
	}
	public void setSgdDestinosCoPri(String sgdDestinosCoPri) {
		this.sgdDestinosCoPri = sgdDestinosCoPri;
	}
	public String getSgdRemitosCodLocEmi() {
		return sgdRemitosCodLocEmi;
	}
	public void setSgdRemitosCodLocEmi(String sgdRemitosCodLocEmi) {
		this.sgdRemitosCodLocEmi = sgdRemitosCodLocEmi;
	}
	public String getSgdRemitosCodGru() {
		return sgdRemitosCodGru;
	}
	public void setSgdRemitosCodGru(String sgdRemitosCodGru) {
		this.sgdRemitosCodGru = sgdRemitosCodGru;
	}
	public String getSgdRemitosEstDocEmi() {
		return sgdRemitosEstDocEmi;
	}
	public void setSgdRemitosEstDocEmi(String sgdRemitosEstDocEmi) {
		this.sgdRemitosEstDocEmi = sgdRemitosEstDocEmi;
	}
	
	public String getSgdRemitosNumDiaAte() {
		return sgdRemitosNumDiaAte;
	}
	public void setSgdRemitosNumDiaAte(String sgdRemitosNumDiaAte) {
		this.sgdRemitosNumDiaAte = sgdRemitosNumDiaAte;
	}
	public String getSgdRemitosEstEli() {
		return sgdRemitosEstEli;
	}
	public void setSgdRemitosEstEli(String sgdRemitosEstEli) {
		this.sgdRemitosEstEli = sgdRemitosEstEli;
	}
	
	public String getSgdRemitosEstUpd() {
		return sgdRemitosEstUpd;
	}
	public void setSgdRemitosEstUpd(String sgdRemitosEstUpd) {
		this.sgdRemitosEstUpd = sgdRemitosEstUpd;
	}
	public String getSgdRemitosNumDetExp() {
		return sgdRemitosNumDetExp;
	}
	public void setSgdRemitosNumDetExp(String sgdRemitosNumDetExp) {
		this.sgdRemitosNumDetExp = sgdRemitosNumDetExp;
	}
	
	public String getSgdRemitosBuscaTexto() {
		return sgdRemitosBuscaTexto;
	}
	public void setSgdRemitosBuscaTexto(String sgdRemitosBuscaTexto) {
		this.sgdRemitosBuscaTexto = sgdRemitosBuscaTexto;
	}
	public String getSgdRemitosCodOriging() {
		return sgdRemitosCodOriging;
	}
	public void setSgdRemitosCodOriging(String sgdRemitosCodOriging) {
		this.sgdRemitosCodOriging = sgdRemitosCodOriging;
	}
	
	
	public String getSgdRemitosAutCorreoe() {
		return sgdRemitosAutCorreoe;
	}
	public void setSgdRemitosAutCorreoe(String sgdRemitosAutCorreoe) {
		this.sgdRemitosAutCorreoe = sgdRemitosAutCorreoe;
	}
	public String getSgdRemitosIndReitconginv() {
		return sgdRemitosIndReitconginv;
	}
	public void setSgdRemitosIndReitconginv(String sgdRemitosIndReitconginv) {
		this.sgdRemitosIndReitconginv = sgdRemitosIndReitconginv;
	}
	
	public String getSgdRemitosIndSensible() {
		return sgdRemitosIndSensible;
	}
	public void setSgdRemitosIndSensible(String sgdRemitosIndSensible) {
		this.sgdRemitosIndSensible = sgdRemitosIndSensible;
	}
	public String getSgdRemitosNumCandes() {
		return sgdRemitosNumCandes;
	}
	public void setSgdRemitosNumCandes(String sgdRemitosNumCandes) {
		this.sgdRemitosNumCandes = sgdRemitosNumCandes;
	}
	
	
	
	public String getSgdRemitosIndOficio() {
		return sgdRemitosIndOficio;
	}
	public void setSgdRemitosIndOficio(String sgdRemitosIndOficio) {
		this.sgdRemitosIndOficio = sgdRemitosIndOficio;
	}
	public String getSgdDestinosNumDes() {
		return sgdDestinosNumDes;
	}
	public void setSgdDestinosNumDes(String sgdDestinosNumDes) {
		this.sgdDestinosNumDes = sgdDestinosNumDes;
	}
	public String getSgdCodigoProceso() {
		return sgdCodigoProceso;
	}
	public void setSgdCodigoProceso(String sgdCodigoProceso) {
		this.sgdCodigoProceso = sgdCodigoProceso;
	}
	public String getSgdEstado() {
		return sgdEstado;
	}
	public void setSgdEstado(String sgdEstado) {
		this.sgdEstado = sgdEstado;
	}
	public String getSecret() {
		return secret;
	}
	public void setSecret(String secret) {
		this.secret = secret;
	}
	public String getSgdSecretKeyPassword() {
		return sgdSecretKeyPassword;
	}
	public void setSgdSecretKeyPassword(String sgdSecretKeyPassword) {
		this.sgdSecretKeyPassword = sgdSecretKeyPassword;
	}
	public String getSgdCodigoGrupo() {
		return sgdCodigoGrupo;
	}
	public void setSgdCodigoGrupo(String sgdCodigoGrupo) {
		this.sgdCodigoGrupo = sgdCodigoGrupo;
	}
	
	
	
}
