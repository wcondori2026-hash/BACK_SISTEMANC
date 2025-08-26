/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ncquality.sad.dto;

import java.util.Date;
import pe.com.ncquality.sad.entity.TbEmpleado;
import pe.com.ncquality.sad.entity.TbTipoDoc;
import pe.com.ncquality.sad.entity.TbTipoPersona;

/**
 *
 * @author USUARIO
 */
public class PersonasDTO implements java.io.Serializable  {
     private Integer idPersona;
     private Integer idEmpleado;
    private String vNumDocumento;
    private String vApelPaterno;
    private String vApelMaterno;
    private String vNombRazon;
    private Date dFecNacimiento;
    private String vNroCel;
    private String vDireccion;
    private char bEstado;
    private Integer iIdUsuarioCrea;
    private Date fFechaRegCrea;
    private Integer iIdUsuarioMod;
    private Date fFechaRegMod;
    private TbEmpleado tbEmpleado;
    private TbTipoPersona tbTipoPersona;
    private TbTipoDoc tbTipoDoc;
                        
    public PersonasDTO(int idPersona,  int idEmpleado, String vNumDocumento, String vApelPaterno, String vApelMaterno, 
            String vNombRazon, Date dFecNacimiento, String vNroCel, String vDireccion,
            char bEstado, String vCorreo) {
        this.idPersona = idPersona;
        this.idEmpleado = idEmpleado;
        this.vNumDocumento = vNumDocumento;
        this.vApelPaterno = vApelPaterno;
        this.vApelMaterno = vApelMaterno;
        this.vNombRazon = vNombRazon;
        this.dFecNacimiento = dFecNacimiento;
        this.vNroCel = vNroCel;
        this.vDireccion = vDireccion;
        this.bEstado = bEstado;
        this.iIdUsuarioCrea = iIdUsuarioCrea;
        this.fFechaRegCrea = fFechaRegCrea;
        this.iIdUsuarioMod = iIdUsuarioMod;
        this.fFechaRegMod = fFechaRegMod;
        this.tbEmpleado = tbEmpleado;
        this.tbTipoPersona = tbTipoPersona;
        this.tbTipoDoc = tbTipoDoc;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
    
    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getvNumDocumento() {
        return vNumDocumento;
    }

    public void setvNumDocumento(String vNumDocumento) {
        this.vNumDocumento = vNumDocumento;
    }

    public String getvApelPaterno() {
        return vApelPaterno;
    }

    public void setvApelPaterno(String vApelPaterno) {
        this.vApelPaterno = vApelPaterno;
    }

    public String getvApelMaterno() {
        return vApelMaterno;
    }

    public void setvApelMaterno(String vApelMaterno) {
        this.vApelMaterno = vApelMaterno;
    }

    public String getvNombRazon() {
        return vNombRazon;
    }

    public void setvNombRazon(String vNombRazon) {
        this.vNombRazon = vNombRazon;
    }

    public Date getdFecNacimiento() {
        return dFecNacimiento;
    }

    public void setdFecNacimiento(Date dFecNacimiento) {
        this.dFecNacimiento = dFecNacimiento;
    }

    public String getvNroCel() {
        return vNroCel;
    }

    public void setvNroCel(String vNroCel) {
        this.vNroCel = vNroCel;
    }

    public String getvDireccion() {
        return vDireccion;
    }

    public void setvDireccion(String vDireccion) {
        this.vDireccion = vDireccion;
    }

    public char getbEstado() {
        return bEstado;
    }

    public void setbEstado(char bEstado) {
        this.bEstado = bEstado;
    }

    public Integer getiIdUsuarioCrea() {
        return iIdUsuarioCrea;
    }

    public void setiIdUsuarioCrea(Integer iIdUsuarioCrea) {
        this.iIdUsuarioCrea = iIdUsuarioCrea;
    }

    public Date getfFechaRegCrea() {
        return fFechaRegCrea;
    }

    public void setfFechaRegCrea(Date fFechaRegCrea) {
        this.fFechaRegCrea = fFechaRegCrea;
    }

    public Integer getiIdUsuarioMod() {
        return iIdUsuarioMod;
    }

    public void setiIdUsuarioMod(Integer iIdUsuarioMod) {
        this.iIdUsuarioMod = iIdUsuarioMod;
    }

    public Date getfFechaRegMod() {
        return fFechaRegMod;
    }

    public void setfFechaRegMod(Date fFechaRegMod) {
        this.fFechaRegMod = fFechaRegMod;
    }

    public TbEmpleado getTbEmpleado() {
        return tbEmpleado;
    }

    public void setTbEmpleado(TbEmpleado tbEmpleado) {
        this.tbEmpleado = tbEmpleado;
    }

    public TbTipoPersona getTbTipoPersona() {
        return tbTipoPersona;
    }

    public void setTbTipoPersona(TbTipoPersona tbTipoPersona) {
        this.tbTipoPersona = tbTipoPersona;
    }

    public TbTipoDoc getTbTipoDoc() {
        return tbTipoDoc;
    }

    public void setTbTipoDoc(TbTipoDoc tbTipoDoc) {
        this.tbTipoDoc = tbTipoDoc;
    }
    
    
}
