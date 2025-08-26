
package pe.com.ncquality.sad.dto;


public class RegistroObraDTO {
    private Integer idEmpresa;
    private Integer idDis;
    private Integer idDep;
    private Integer idPro;
    private Integer idCotiza;
    private Integer idPersona;
    private String codEtapa;
    private String codTipoObra;
    private String codTipoSuelo;
    private String fecIniProg;
    private String fecFinProg;
    private String fecIniEje;
    private String fecFinEje;
    private String direc;
    private String descrip;
    private String estado;
    private Integer idUsuCrea;
    private String fecRegCrea;
    private Integer idUsuMod;
    private String fecRegMod;

    public RegistroObraDTO() {
    }

    public RegistroObraDTO(Integer idEmpresa, Integer idDis, Integer idDep, Integer idPro, Integer idCotiza,
            Integer idPersona, String codEtapa, String codTipoObra, String codTipoSuelo, String fecIniProg,
            String fecFinProg, String fecIniEje, String fecFinEje, String direc, String descrip, String estado, 
            Integer idUsuCrea, String fecRegCrea, Integer idUsuMod, String fecRegMod) {
        this.idEmpresa = idEmpresa;
        this.idDis = idDis;
        this.idDep = idDep;
        this.idPro = idPro;
        this.idCotiza = idCotiza;
        this.idPersona = idPersona;
        this.codEtapa = codEtapa;
        this.codTipoObra = codTipoObra;
        this.codTipoSuelo = codTipoSuelo;
        this.fecIniProg = fecIniProg;
        this.fecFinProg = fecFinProg;
        this.fecIniEje = fecIniEje;
        this.fecFinEje = fecFinEje;
        this.direc = direc;
        this.descrip = descrip;
        this.estado = estado;
        this.idUsuCrea = idUsuCrea;
        this.fecRegCrea = fecRegCrea;
        this.idUsuMod = idUsuMod;
        this.fecRegMod = fecRegMod;
    }
    
    

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Integer getIdDis() {
        return idDis;
    }

    public void setIdDis(Integer idDis) {
        this.idDis = idDis;
    }

    public Integer getIdDep() {
        return idDep;
    }

    public void setIdDep(Integer idDep) {
        this.idDep = idDep;
    }

    public Integer getIdPro() {
        return idPro;
    }

    public void setIdPro(Integer idPro) {
        this.idPro = idPro;
    }

    public Integer getIdCotiza() {
        return idCotiza;
    }

    public void setIdCotiza(Integer idCotiza) {
        this.idCotiza = idCotiza;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getCodEtapa() {
        return codEtapa;
    }

    public void setCodEtapa(String codEtapa) {
        this.codEtapa = codEtapa;
    }

    public String getCodTipoObra() {
        return codTipoObra;
    }

    public void setCodTipoObra(String codTipoObra) {
        this.codTipoObra = codTipoObra;
    }

    public String getCodTipoSuelo() {
        return codTipoSuelo;
    }

    public void setCodTipoSuelo(String codTipoSuelo) {
        this.codTipoSuelo = codTipoSuelo;
    }

    public String getFecIniProg() {
        return fecIniProg;
    }

    public void setFecIniProg(String fecIniProg) {
        this.fecIniProg = fecIniProg;
    }

    public String getFecFinProg() {
        return fecFinProg;
    }

    public void setFecFinProg(String fecFinProg) {
        this.fecFinProg = fecFinProg;
    }

    public String getFecIniEje() {
        return fecIniEje;
    }

    public void setFecIniEje(String fecIniEje) {
        this.fecIniEje = fecIniEje;
    }

    public String getFecFinEje() {
        return fecFinEje;
    }

    public void setFecFinEje(String fecFinEje) {
        this.fecFinEje = fecFinEje;
    }

    public String getDirec() {
        return direc;
    }

    public void setDirec(String direc) {
        this.direc = direc;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getIdUsuCrea() {
        return idUsuCrea;
    }

    public void setIdUsuCrea(Integer idUsuCrea) {
        this.idUsuCrea = idUsuCrea;
    }

    public String getFecRegCrea() {
        return fecRegCrea;
    }

    public void setFecRegCrea(String fecRegCrea) {
        this.fecRegCrea = fecRegCrea;
    }

    public Integer getIdUsuMod() {
        return idUsuMod;
    }

    public void setIdUsuMod(Integer idUsuMod) {
        this.idUsuMod = idUsuMod;
    }

    public String getFecRegMod() {
        return fecRegMod;
    }

    public void setFecRegMod(String fecRegMod) {
        this.fecRegMod = fecRegMod;
    }
    
    
    
    
    
}
