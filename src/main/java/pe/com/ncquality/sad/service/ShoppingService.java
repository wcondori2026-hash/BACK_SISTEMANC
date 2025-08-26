
package pe.com.ncquality.sad.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Collectors;
import static org.hibernate.type.InstantType.FORMATTER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pe.com.ncquality.sad.bean.ProcessResult;
import pe.com.ncquality.sad.dto.RegistroDTO;
import pe.com.ncquality.sad.dto.ShoppingDTO;
import pe.com.ncquality.sad.entity.TbCategoria;
import pe.com.ncquality.sad.entity.TbEgreso;
import pe.com.ncquality.sad.entity.TbEmpresa;
import pe.com.ncquality.sad.entity.TbPersonas;
import pe.com.ncquality.sad.entity.TbProyecto;
import pe.com.ncquality.sad.entity.TbSubcategoria;
import pe.com.ncquality.sad.repository.NcCategoriaRepositorio;
import pe.com.ncquality.sad.repository.NcEmpresaRepositorio;
import pe.com.ncquality.sad.repository.NcPersonaRepositorio;
import pe.com.ncquality.sad.repository.NcProyectoRepositorio;
import pe.com.ncquality.sad.repository.NcShoppingRepositorio;
import pe.com.ncquality.sad.repository.NcSubcategoriaRepositorio;


@Service("shoppingService")
public class ShoppingService {
    
    @Autowired
    @Qualifier ("ncShoppingRepositorio")
    private NcShoppingRepositorio ncShoppingRepositorio;  
    
    @Autowired
    @Qualifier ("ncCategoriaRepositorio")
    private NcCategoriaRepositorio ncCategoriaRepositorio;
    
    @Autowired
    @Qualifier ("ncSubcategoriaRepositorio")
    private NcSubcategoriaRepositorio ncSubcategoriaRepositorio;
    
    @Autowired
    @Qualifier ("ncEmpresaRepositorio")
    private NcEmpresaRepositorio ncEmpresaRepositorio;
    
    @Autowired
    @Qualifier ("ncPersonaRepositorio")
    private NcPersonaRepositorio ncPersonaRepositorio;
    
    @Autowired
    @Qualifier ("ncProyectoRepositorio")
    private NcProyectoRepositorio ncProyectoRepositorio;
    
    //private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final String DATE_PATTERN = "dd/MM/yyyy";
    
    public List<ShoppingDTO> obtenerEgresosInfo(String codCotiza, Integer codProyecto,
                                                Date fecemi, Date fecvenc, String codDoc,
                                                String serieDoc, String numDoc, String codEtapa,
                                                int limit, int offset) {
        
        return ncShoppingRepositorio.ObtenerEgresoInfo(codCotiza, codProyecto, fecemi, fecvenc, codDoc, serieDoc,
                numDoc, codEtapa, limit, offset)
        .stream()
        .map(obj -> new ShoppingDTO(
            (BigInteger) obj[0],  
            (Integer) obj[1],
            (String) obj[2],
            (String) obj[3],
            (String) obj[4],
            (String) obj[5],
            (Date) obj[6],
            (Date) obj[7],
            (String) obj[8],
            (Integer) obj[9],   
            ((Number) obj[10]).doubleValue(), 
            ((Number) obj[11]).doubleValue(),
            (BigInteger) obj[12]
        ))
        .collect(Collectors.toList());
    }

    
    /*public TbEgreso registrarEgreso (TbEgreso egreso) {
        ncShoppingRepositorio.insertarEgreso(
            egreso.getIdEgreso(),
            egreso.getTbEmpresa().getIdEmpresa(),
            egreso.getTbPersonas().getIdPersona(),
            egreso.getTbProyecto().getIdProyecto(),
            egreso.getTbCategoria().getIdCategoria(),
            egreso.getTbSubcategoria().getIdSubcateg(),
            egreso.getsCodEtapa(),
            egreso.getvCodCompra(),
            egreso.getvCodSubsi(),
            egreso.getvCodDoc(),
            egreso.getvNumCod(),
            egreso.getvSerieDoc(),
            egreso.getdFecEmi(),
            egreso.getdFecVenc(),
            egreso.getnTasaIgv(),
            egreso.getnIgvMon(),
            egreso.getnMonto(),
            egreso.getdFecEmiRef(),
            egreso.getvCodDocRef(),
            egreso.getvNumDocRef(),
            egreso.getvSerieDocRef(),
            egreso.getvCodTipoConver(),
            egreso.getvTipoCambio(),
            egreso.getdFecCambio(),
            egreso.getvGlosa(),
            egreso.getvCodMoneda(),
            egreso.getbEstado(),
            egreso.getiIdUsuarioCrea(),
            egreso.getdFecRegCrea(),
            egreso.getiIdUsuarioMod(),
            egreso.getdFecRegMod()
        );
        return egreso;
    }*/
   
    
    // Crear nuevoEgreso
    public ProcessResult<String> nuevoEgreso(RegistroDTO egreso)  {
        ProcessResult<String> result= new ProcessResult<String>();
        try {
            
           //VALIDACION DE FK
            TbEmpresa empresa = ncEmpresaRepositorio.findById(egreso.getIdEmpresa()).orElse(null);
            if (empresa == null) {
            //throw new IllegalArgumentException("La fecha de emisión debe tener formato yyyy-MM-dd");
            result.setCodigo("001");
            result.setMessage("Los datos de la empresa no se encuentran");
            return result;
        }
            
            TbCategoria categoria = ncCategoriaRepositorio.findById(egreso.getIdCategoria()).orElse(null);
             if (categoria == null) {
                //throw new IllegalArgumentException("La fecha de emisión debe tener formato yyyy-MM-dd");
                result.setCodigo("001");
                result.setMessage("Los datos de la empresa no se encuentran");
                return result;
         }
        
            TbPersonas persona = ncPersonaRepositorio.findById(egreso.getIdPersonas()).orElse(null);
             if (persona == null) {
                //throw new IllegalArgumentException("La fecha de emisión debe tener formato yyyy-MM-dd");
                result.setCodigo("001");
                result.setMessage("Los datos de la empresa no se encuentran");
                return result;
         }
         
            TbSubcategoria subCateg = ncSubcategoriaRepositorio.findById(egreso.getIdSubcategoria()).orElse(null);
             if (subCateg == null) {
                //throw new IllegalArgumentException("La fecha de emisión debe tener formato yyyy-MM-dd");
                result.setCodigo("001");
                result.setMessage("Los datos de la empresa no se encuentran");
                return result;
         }
         
            TbProyecto proyecto = ncProyectoRepositorio.findById(egreso.getIdProyecto()).orElse(null);
             if (proyecto == null) {
                //throw new IllegalArgumentException("La fecha de emisión debe tener formato yyyy-MM-dd");
                result.setCodigo("001");
                result.setMessage("Los datos de la empresa no se encuentran");
                return result;
         }
        
         
        //VALIDACION DE FECHAS 
        /*if (!esFechaValida(egreso.getdFecEmi())) {
            //throw new IllegalArgumentException("La fecha de emisión debe tener formato yyyy-MM-dd");
            result.setCodigo("001");
            result.setMessage("La fecha de emisión debe tener formato dd/mm/yyyy");
            return result;
        }
        if (!esFechaValida(egreso.getdFecVenc())) {
            result.setCodigo("001");
            result.setMessage("La fecha de vencimiento debe tener formato dd/mm/yyyy");
            return result;
        }
        if (!esFechaValida(egreso.getdFecRegCrea())) {
            result.setCodigo("001");
            result.setMessage("La fecha de Creación debe tener formato dd/mm/yyyy");
            return result;
        }
        if (!esFechaValida(egreso.getdFecRegMod())) {
            result.setCodigo("001");
            result.setMessage("La fecha de Modificación debe tener formato dd/mm/yyyy");
            return result;
        }
        if (!esFechaValida(egreso.getdFecEmiRef())) {
            result.setCodigo("001");
            result.setMessage("La fecha de Emisión de referencia debe tener formato dd/mm/yyyy");
            return result;
        }
        if (!esFechaValida(egreso.getdFecCambio())) {
            result.setCodigo("001");
            result.setMessage("La fecha de Modificación debe tener formato dd/mm/yyyy");
            return result;
        }*/
        
        //VALIDACION DE FECHAS
        ProcessResult<Void> validacion;

        validacion = validarFecha(egreso.getdFecEmi(), "Fecha de Emisión");
        if (!"000".equals(validacion.getCodigo())) return (ProcessResult) validacion;

        validacion = validarFecha(egreso.getdFecVenc(), "Fecha de Vencimiento");
        if (!"000".equals(validacion.getCodigo())) return (ProcessResult) validacion;

        validacion = validarFecha(egreso.getdFecRegCrea(), "Fecha de Creación");
        if (!"000".equals(validacion.getCodigo())) return (ProcessResult) validacion;

        validacion = validarFecha(egreso.getdFecRegMod(), "Fecha de Modificación");
        if (!"000".equals(validacion.getCodigo())) return (ProcessResult) validacion;

        validacion = validarFecha(egreso.getdFecEmiRef(), "Fecha de Emisión de Referencia");
        if (!"000".equals(validacion.getCodigo())) return (ProcessResult) validacion;

        validacion = validarFecha(egreso.getdFecCambio(), "Fecha de Cambio");
        if (!"000".equals(validacion.getCodigo())) return (ProcessResult) validacion;
        
        //VALIDACION DE TEXTOS
       validacion = validarNuloStr(egreso.getbEstado(), "Estado");
       if("001".equals(validacion.getCodigo())) return (ProcessResult) validacion;
       
       validacion = validarNuloStr(egreso.getsCodEtapa(), "Etapa");
       if("001".equals(validacion.getCodigo())) return (ProcessResult) validacion;
       
       validacion = validarNuloStr(egreso.getvCodCompra(), "Código de Compra");
       if("001".equals(validacion.getCodigo())) return (ProcessResult) validacion;
       
       validacion = validarNuloStr(egreso.getvCodDoc(), "Código del documento" );
       if("001".equals(validacion.getCodigo())) return (ProcessResult) validacion;
       
       validacion = validarNuloStr(egreso.getvCodSubsi(), "Código de Subsidiario");
       if("001".equals(validacion.getCodigo())) return (ProcessResult) validacion;
       
       validacion = validarNuloStr(egreso.getvNumCod(), "Número documento");
       if("001".equals(validacion.getCodigo())) return (ProcessResult) validacion;
       
       validacion = validarNuloStr(egreso.getvSerieDoc(), "Serie documento");
       if("001".equals(validacion.getCodigo())) return (ProcessResult) validacion;
        
       //VALIDACION DE NUMEROS
       validacion = validarNuloNumber (egreso.getIdCategoria(), "Id Categoria");
       if("001".equals(validacion.getCodigo())) return (ProcessResult) validacion;
       
       //validacion = validarNuloNumber (egreso.getIdEgreso(), "Id Egreso");
       //if("001".equals(validacion.getCodigo())) return (ProcessResult) validacion;
       
       validacion = validarNuloNumber (egreso.getIdEmpresa(), "Id Empresa");
       if("001".equals(validacion.getCodigo())) return (ProcessResult) validacion;
       
       validacion = validarNuloNumber (egreso.getIdPersonas(), "Id Personas");
       if("001".equals(validacion.getCodigo())) return (ProcessResult) validacion;
       
       validacion = validarNuloNumber (egreso.getIdProyecto(), "Id Proyecto");
       if("001".equals(validacion.getCodigo())) return (ProcessResult) validacion;
       
       validacion = validarNuloNumber(egreso.getIdSubcategoria(), "Id SubCategoria");
       if("001".equals(validacion.getCodigo())) return (ProcessResult) validacion;
       
       validacion = validarNuloNumber(egreso.getnIgvMon(), "Monto del IGV");
       if("001".equals(validacion.getCodigo())) return (ProcessResult) validacion;
       
       validacion = validarNuloNumber(egreso.getnMonto(), "Monto");
       if("001".equals(validacion.getCodigo())) return (ProcessResult) validacion;
       
       validacion = validarNuloNumber(egreso.getnTasaIgv(), "Tasa IGV");
       if("001".equals(validacion.getCodigo())) return (ProcessResult) validacion;
        
        /*TbEgreso nuevoEgreso = new TbEgreso();
        nuevoEgreso.setIdEgreso(egreso.getIdEgreso());
        nuevoEgreso.setTbCategoria(categoria);
        nuevoEgreso.setTbEmpresa(empresa);
        nuevoEgreso.setTbPersonas(persona);
        nuevoEgreso.setTbSubcategoria(subCateg);
        nuevoEgreso.setTbProyecto(proyecto);
        nuevoEgreso.setbEstado(egreso.getbEstado());
        nuevoEgreso.setdFecCambio(egreso.getdFecCambio());
        nuevoEgreso.setdFecEmi(egreso.getdFecEmi());
        nuevoEgreso.setdFecEmiRef(egreso.getdFecEmiRef());
        nuevoEgreso.setdFecRegCrea(egreso.getdFecRegCrea());
        nuevoEgreso.setdFecRegMod(egreso.getdFecRegMod());
        nuevoEgreso.setdFecVenc(egreso.getdFecVenc());
        nuevoEgreso.setiIdUsuarioCrea(egreso.getiIdUsuarioCrea());
        nuevoEgreso.setiIdUsuarioMod(egreso.getiIdUsuarioMod());
        nuevoEgreso.setnIgvMon(egreso.getnIgvMon());
        nuevoEgreso.setnMonto(egreso.getnMonto());
        nuevoEgreso.setnTasaIgv(egreso.getnTasaIgv());
        nuevoEgreso.setsCodEtapa(egreso.getsCodEtapa());
        nuevoEgreso.setvCodCompra(egreso.getvCodCompra());
        nuevoEgreso.setvCodDoc(egreso.getvCodDoc());
        nuevoEgreso.setvCodDocRef(egreso.getvCodDocRef());
        nuevoEgreso.setvCodMoneda(egreso.getvCodMoneda());
        nuevoEgreso.setvCodSubsi(egreso.getvCodSubsi());
        nuevoEgreso.setvCodTipoConver(egreso.getvCodTipoConver());
        nuevoEgreso.setvGlosa(egreso.getvGlosa());
        nuevoEgreso.setvNumCod(egreso.getvNumCod());
        nuevoEgreso.setvNumDocRef(egreso.getvNumDocRef());
        nuevoEgreso.setvSerieDoc(egreso.getvSerieDoc());
        nuevoEgreso.setvSerieDocRef(egreso.getvSerieDocRef());
        nuevoEgreso.setvTipoCambio(egreso.getvTipoCambio());
        
        return ncShoppingRepositorio.save(nuevoEgreso);
    }*/
        // Crear entidad
        TbEgreso nuevoEgreso = new TbEgreso();
        //nuevoEgreso.setIdEgreso(egreso.getIdEgreso());
        nuevoEgreso.setTbCategoria(categoria);
        nuevoEgreso.setTbEmpresa(empresa);
        nuevoEgreso.setTbPersonas(persona);
        nuevoEgreso.setTbSubcategoria(subCateg);
        nuevoEgreso.setTbProyecto(proyecto);
        nuevoEgreso.setbEstado(egreso.getbEstado());

        // Convertir String → java.sql.Date 
        nuevoEgreso.setdFecEmi(parsearFecha(egreso.getdFecEmi()));
        nuevoEgreso.setdFecEmiRef(parsearFecha(egreso.getdFecEmiRef()));
        nuevoEgreso.setdFecRegCrea(parsearFecha(egreso.getdFecRegCrea()));
        nuevoEgreso.setdFecRegMod(parsearFecha(egreso.getdFecRegMod()));
        nuevoEgreso.setdFecVenc(parsearFecha(egreso.getdFecVenc()));
        nuevoEgreso.setdFecCambio(parsearFecha(egreso.getdFecCambio()));

        // 🔹 Otros campos
        nuevoEgreso.setiIdUsuarioCrea(egreso.getiIdUsuarioCrea());
        nuevoEgreso.setiIdUsuarioMod(egreso.getiIdUsuarioMod());
        nuevoEgreso.setnIgvMon(egreso.getnIgvMon());
        nuevoEgreso.setnMonto(egreso.getnMonto());
        nuevoEgreso.setnTasaIgv(egreso.getnTasaIgv());
        nuevoEgreso.setsCodEtapa(egreso.getsCodEtapa());
        nuevoEgreso.setvCodCompra(egreso.getvCodCompra());
        nuevoEgreso.setvCodDoc(egreso.getvCodDoc());
        nuevoEgreso.setvCodDocRef(egreso.getvCodDocRef());
        nuevoEgreso.setvCodMoneda(egreso.getvCodMoneda());
        nuevoEgreso.setvCodSubsi(egreso.getvCodSubsi());
        nuevoEgreso.setvCodTipoConver(egreso.getvCodTipoConver());
        nuevoEgreso.setvGlosa(egreso.getvGlosa());
        nuevoEgreso.setvNumCod(egreso.getvNumCod());
        nuevoEgreso.setvNumDocRef(egreso.getvNumDocRef());
        nuevoEgreso.setvSerieDoc(egreso.getvSerieDoc());
        nuevoEgreso.setvSerieDocRef(egreso.getvSerieDocRef());
        nuevoEgreso.setvTipoCambio(egreso.getvTipoCambio());
        
        //  Guardar en BD
        //ncShoppingRepositorio.save(nuevoEgreso);
        //result.setResult("pk: " + egreso.getIdEgreso());
       TbEgreso savedEgreso = ncShoppingRepositorio.save(nuevoEgreso);
        result.setCodigo("000");
        result.setMessage("Registro exitoso");
        result.setResult(savedEgreso.getIdEgreso().toString());
        
        }catch(Exception ex){
            result.setCodigo("002");
            result.setMessage("Error en el registro de de datos");
            result.setException(ex.getMessage());
        }
        
        return result;
    }
    
    //METODO DE CONVERSIOM (STRING A FECHA)
        public Date parsearFecha(String fechaStr) {
            try{
                SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);
                sdf.setLenient(false);
                // evita que acepte fechas como 32/01/2025

                return sdf.parse(fechaStr); // 👈 aquí se convierte a java.util.Date
                
            }catch(Exception ex){
                throw new RuntimeException("Error al convertir la fecha: " + fechaStr, ex);
            }
        
        }
        
    //METODO DE VALIDACIÓN
        /*public static boolean esFechaValida(String fecha) {
            if (fecha == null || fecha.trim().isEmpty()) {
                return false;
            }        
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_PATTERN);
            LocalDate.parse(fecha, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }*/
        
        //MÉTODO DE VALIDACIÓN DE NULOS TEXTO
        public ProcessResult<Void> validarNuloStr (String nonulo, String nombreCampo){
            ProcessResult<Void> result = new ProcessResult<>();
            if (nonulo == null || nonulo.trim().isEmpty()){
               
                result.setCodigo("001");
                result.setMessage("El campo " + nombreCampo + " no puede ser nulo o vacío");
            }
            return result;
        }
        
        //MÉTODO DE VALIDACIÓN DE NULOS INTEGER
        public ProcessResult<Void> validarNuloNumber (Number nonulo, String nombreCampo){
            ProcessResult<Void> result = new ProcessResult<>();
            if (nonulo == null){
                result.setCodigo("001");
                result.setMessage("El campo "+ nombreCampo + " no puede ser nulo");
            }
            return result;
        }
        
        
        //MÉTODO DE VALIDACIÓN FECHA
        public ProcessResult<Void> validarFecha(String fecha, String nombreCampo) {
        ProcessResult<Void> result = new ProcessResult<>();

        if (fecha == null || fecha.trim().isEmpty()) {
            result.setCodigo("001");
            result.setMessage("El campo " + nombreCampo + " no puede ser nulo o vacío");
            return result;
        }
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_PATTERN);
            LocalDate.parse(fecha, formatter);
            result.setCodigo("000");
            result.setMessage("OK");
            return result;
        } catch (DateTimeParseException e) {
            result.setCodigo("001");
            result.setMessage("El campo " + nombreCampo + " debe tener el formato dd/MM/yyyy");
            return result;
        }
    }
        
        /*public List<TbEgreso> getProductoById(Integer id) {
        return ncShoppingRepositorio.findByidEgreso(id);
    }
        
         public List<TbEgreso> getProductos() {
        return ncShoppingRepositorio.findAll();
    }*/
        
      public List<RegistroDTO> listarEgresosPorId(Integer idEgreso) {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    return ncShoppingRepositorio.findEgresoById(idEgreso)
        .stream()
        .map(obj -> new RegistroDTO(
            (Integer) obj[0],
            (String) obj[1],
            (String) obj[2],
            (String) obj[3],
            (String) obj[4],
            (String) obj[5],
            (String) obj[6],
            obj[7] != null ? sdf.format((Date) obj[7]) : null,
            obj[8] != null ? sdf.format((Date) obj[8]) : null,
            (Integer) obj[9],        
            obj[10] != null ? ((BigDecimal) obj[10]).doubleValue() : null,
            obj[11] != null ? ((BigDecimal) obj[11]).doubleValue() : null,
            obj[12] != null ? sdf.format((Date) obj[12]) : null,
            (String) obj[13],
            (String) obj[14],
            (String) obj[15],
            (String) obj[16],
            obj[17] != null ? ((BigDecimal) obj[17]).doubleValue() : null,
            obj[18] != null ? sdf.format((Date) obj[18]) : null,
            (String) obj[19],
            (String) obj[20],
            obj[21] != null ? obj[21].toString() : null,
            (Integer) obj[22],
            obj[23] != null ? sdf.format((Date) obj[23]) : null,
            (Integer) obj[24],
            obj[25] != null ? sdf.format((Date) obj[25]) : null,
            (Integer) obj[26],
            (Integer) obj[27],
            (Integer) obj[28],
            (Integer) obj[29],
            (Integer) obj[30]
        ))
        .collect(Collectors.toList());
}
        
        
         /*public ProcessResult<Optional<TbEgreso>> obtenerPorId(Integer id) {
            result = ncShoppingRepositorio.findByidEgreso(id);
            return result;
    }*/
        
        
}
