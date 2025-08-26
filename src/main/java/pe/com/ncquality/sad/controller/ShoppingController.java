
package pe.com.ncquality.sad.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.Model;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pe.com.ncquality.sad.bean.ProcessResult;
import pe.com.ncquality.sad.dto.RegistroDTO;
import pe.com.ncquality.sad.service.ShoppingService;
import pe.com.ncquality.sad.dto.ShoppingDTO;
import pe.com.ncquality.sad.entity.TbEgreso;
import pe.com.ncquality.sad.util.ServletUtility;


@RestController
@Api(tags = "Compras")
@RequestMapping("/v1/compras")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
public class ShoppingController {

    @Autowired
    ShoppingService shoppingService;

    private static Logger depurador = Logger.getLogger(ObjectController.class.getName());

    @ApiOperation(value = "Obtener lista de Egresos")
    @RequestMapping(value = "/getListaEgresos", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE) 
    @ResponseBody
    public ProcessResult<List<ShoppingDTO>> getListaProyectos (@RequestBody Map<String, Object> egreso) {
        
           /* String codCotiza = ServletUtility.getInstancia().loadRequestParameter(request, "codCotiza");
            Integer codProyecto =Integer.valueOf(ServletUtility.getInstancia().loadRequestParameter(request, "codProyecto"));
            String codDoc = ServletUtility.getInstancia().loadRequestParameter(request, "codDoc");
            String serieDoc = ServletUtility.getInstancia().loadRequestParameter(request, "serieDoc");
            String numDoc = ServletUtility.getInstancia().loadRequestParameter(request, "numDoc");
            String codEtapa = ServletUtility.getInstancia().loadRequestParameter(request, "codEtapa");
            String fecemiStr = ServletUtility.getInstancia().loadRequestParameter(request, "fecemi");
            String fecvencStr = ServletUtility.getInstancia().loadRequestParameter(request, "fecvenc");
            String _page =  ServletUtility.getInstancia().loadRequestParameter(request, "page");
            String _size =  ServletUtility.getInstancia().loadRequestParameter(request, "size");*/
            String codCotiza = egreso.get("codCotiza").toString().toUpperCase();
            Integer codProyecto = Integer.parseInt(egreso.get("codProyecto").toString());
            String codDoc = egreso.get("codDoc").toString().toUpperCase();
            String serieDoc = egreso.get("serieDoc").toString().toUpperCase();
            String numDoc = egreso.get("numDoc").toString().toUpperCase();
            String codEtapa = egreso.get("codEtapa").toString().toUpperCase();
            
            String fecemiStr = egreso.get("fecemi").toString();
            String fecvencStr = egreso.get("fecvenc").toString();
             String _page = egreso.get("page").toString();
            String _size = egreso.get("size").toString();
            
             ProcessResult<List<ShoppingDTO>> result= new ProcessResult<List<ShoppingDTO>>();
            
            //Para validacion de la fecha
            String fechaPattern = "^\\d{4}-\\d{2}-\\d{2}$"; // yyyy-MM-dd

            if (!fecemiStr.matches(fechaPattern) || !fecvencStr.matches(fechaPattern)) {
                /*return ResponseEntity.badRequest().body(
                    "Formato de fecha inválido. Las fechas deben tener formato yyyy-MM-dd, ejemplo: 2025-08-15"
                );*/
                result.setCodigo("001");
                result.setMessage("Formato de fecha inválido. Las fechas deben tener formato yyyy-MM-dd");
            }
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date fecemi = null;
            Date fecvenc = null;
            
            int page = Integer.parseInt(_page);
            int size = Integer.parseInt(_size);

            try {
                fecemi = sdf.parse(fecemiStr);
                fecvenc = sdf.parse(fecvencStr);
            } catch (ParseException e) {
                depurador.error("Error al parsear las fechas", e);
                 result.setCodigo("002");
                result.setMessage("Formato de fecha inválido. Use yyyy-MM-dd");
               // return ResponseEntity.badRequest().body("Formato de fecha inválido. Use yyyy-MM-dd");
            }
            int offset = page * size;

        depurador.info(":::::::::::::::::::: Obtener info Egresos ::::::::::::::::::::::::");

        try {
           
            List<ShoppingDTO> lista = shoppingService.obtenerEgresosInfo(
                    codCotiza,
                    codProyecto,
                    fecemi, fecvenc,
                    codDoc ,
                    serieDoc ,
                    numDoc ,
                    codEtapa,
                    size,
                    offset       
            );

            if (lista == null || lista.isEmpty()) {
                result.setCodigo("001");
                result.setMessage("La lista de Egresos esta vacía o es null.");
                
                return result;
                
            }
            result.setCodigo("000");
            result.setMessage("OK");
            result.setResult(lista);
            //return ResponseEntity.ok(result); // HTTP 200 con la lista

        } catch (Exception e) {
            depurador.error("Error al obtener la información de egresos", e);
             result.setCodigo("002");
             result.setMessage("Ocurrió un error al obtener la información de egresos");
             result.setException(e.getMessage());
           // return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocurrió un error al obtener la información de egresos.");
        }
       return result;
    }
    
    /*@ApiOperation(value = "Obtener lista de Egresos")
    @RequestMapping(value = "/getListaEgresos", method = RequestMethod.POST)
    public ResponseEntity<?> getListaCodigos (@RequestBody Map<String, Object> egreso) {
            String codCotiza = egreso.get("codCotiza").toString().toUpperCase();
            Integer codProyecto = Integer.parseInt(egreso.get("codProyecto").toString());
            String codDoc = egreso.get("codDoc").toString().toUpperCase();
            String serieDoc = egreso.get("serieDoc").toString().toUpperCase();
            String numDoc = egreso.get("numDoc").toString().toUpperCase();
            String codEtapa = egreso.get("codEtapa").toString().toUpperCase();
            
            String fecemiStr = egreso.get("fecemi").toString();
            String fecvencStr = egreso.get("fecvenc").toString();
            
             ProcessResult<List<ShoppingDTO>> result= new ProcessResult<List<ShoppingDTO>>();
            
            //Para validacion de la fecha
            String fechaPattern = "^\\d{4}-\\d{2}-\\d{2}$"; // yyyy-MM-dd

            if (!fecemiStr.matches(fechaPattern) || !fecvencStr.matches(fechaPattern)) {
                return ResponseEntity.badRequest().body(
                    "Formato de fecha inválido. Las fechas deben tener formato yyyy-MM-dd, ejemplo: 2025-08-15"
                );
            }
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date fecemi = null;
            Date fecvenc = null;
            
            int page = Integer.parseInt(egreso.get("page").toString());
            int size = Integer.parseInt(egreso.get("size").toString());

            try {
                fecemi = sdf.parse(fecemiStr);
                fecvenc = sdf.parse(fecvencStr);
            } catch (ParseException e) {
                depurador.error("Error al parsear las fechas", e);
                return ResponseEntity.badRequest().body("Formato de fecha inválido. Use yyyy-MM-dd");
            }
            int offset = page * size;

        depurador.info(":::::::::::::::::::: Obtener info Egresos ::::::::::::::::::::::::");

        try {
           
            List<ShoppingDTO> lista = shoppingService.obtenerEgresosInfo(
                    codCotiza,
                    codProyecto,
                    fecemi, fecvenc,
                    codDoc ,
                    serieDoc ,
                    numDoc ,
                    codEtapa,
                    size,
                    offset       
            );

            if (lista == null || lista.isEmpty()) {
                depurador.warn("La lista de egresos con los filtros especificados está vacía.");
                return ResponseEntity.noContent().build(); // HTTP 204
            }
            result.setResult(lista);
            return ResponseEntity.ok(result); // HTTP 200 con la lista

        } catch (Exception e) {
            depurador.error("Error al obtener la información de egresos", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Ocurrió un error al obtener la información de egresos.");
        }
    }*/
    
    /*@ApiOperation(value = "Añadir registrar egreso")
    @RequestMapping(value = "/setRegistrar", method = RequestMethod.POST)
    public ResponseEntity<TbEgreso> setRegistrar (@RequestBody TbEgreso egreso) {
        try{
        TbEgreso nuevoEgreso = shoppingService.crearVenta(egreso);
        //validaciones de campos fecha y numericosResponseEntity
        
        return new ResponseEntity<> (nuevoEgreso, HttpStatus.CREATED);   
        }catch (Exception e){
            depurador.error("Error al obtener la información de egresos", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }*/
    
    @ApiOperation(value = "Añadir registrar egreso")
    @RequestMapping(value = "/setRegistrar", method = RequestMethod.POST)
    public ProcessResult<String> setRegistrar(@RequestBody RegistroDTO registro) {
        depurador.info(":::::::::::::::::::: Registrar nuevo Egreso ::::::::::::::::::::::::");

            ProcessResult<String> result= new ProcessResult<String>();
            
 
         try {
            result = shoppingService.nuevoEgreso(registro); 
            
            //result.setMessage("OK");
            //result.setCodigo("000");
            /*SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            sdf.setLenient(false); // Para evitar fechas inválidas como 2025-13-40
            

            String fecEmiStr = sdf.format(registro.getdFecEmi());
            String fecVencStr = sdf.format(registro.getdFecVenc());
            String fecEmiRefStr = sdf.format(registro.getdFecEmiRef());
            String fecRegCreaStr = sdf.format(registro.getdFecRegCrea());
            String fecRegModStr = sdf.format(registro.getdFecRegMod());
            String fecCambioStr = sdf.format(registro.getdFecCambio());
             //Para validacion de la fecha
             
           String fechaPattern = "^\\d{2}/\\d{2}/\\d{4}$"; // dd/MM/yyyy

            if (!fecEmiStr.matches(fechaPattern) || !fecVencStr.matches(fechaPattern) || !fecEmiRefStr.matches(fechaPattern)
                    ||!fecRegCreaStr.matches(fechaPattern) || !fecRegModStr.matches(fechaPattern) || !fecCambioStr.matches(fechaPattern)) {
                result.setCodigo("001");
                result.setMessage("Formato de fecha inválido. Las fechas deben tener formato dd/MM/yyyy");
            }
            
            Date fecEmi = sdf.parse(fecEmiStr);
            Date fecVenc = sdf.parse(fecVencStr);
            Date fecCambio = sdf.parse(fecCambioStr);
            Date fecEmiRef = sdf.parse(fecEmiRefStr);
            Date fecRegCrea = sdf.parse(fecRegCreaStr);
            Date fecRegMod = sdf.parse(fecRegModStr);*/
            
            
            
           // result.setCodigo("000");
           // result.setMessage("OK");
            /*List<RegistroDTO> lista = new ArrayList<>();
            lista.add(dto);*/
           // result.setResult("OK");
            
         /*} catch (ParseException e) {
            result.setCodigo("002");
            result.setMessage("Formato de fecha inválido");
            result.setException(e.getMessage());*/
            
         }catch (Exception e) {
         depurador.error("Error al registrar egreso", e);
             result.setCodigo("002");
             result.setMessage("Ocurrió un error al registrar el egreso");
             result.setException(e.getMessage());
        }
        
         return result;
   
    }
    
    @ApiOperation(value = "Obtener registro por ID")
@RequestMapping(value = "/getRegistroEgreso", method = RequestMethod.POST)
public ProcessResult<List<RegistroDTO>> getRegistroEgreso(@RequestBody Map<String, Integer> id) {
    ProcessResult<List<RegistroDTO>> result = new ProcessResult<>();
    try {
        Integer idEgreso = id.get("id");

        if (idEgreso == null) {
            result.setCodigo("001");
            result.setMessage("El id no fue enviado");
            return result;
        }

        depurador.info(":::::::::::::::::::: Obtener códigos del tipo: " + idEgreso + " ::::::::::::::::::::::::");

        List<RegistroDTO> lista = shoppingService.listarEgresosPorId(idEgreso);

        if (lista == null || lista.isEmpty()) {
            result.setCodigo("002");
            result.setMessage("No se encontraron registros para el id " + idEgreso);
            result.setResult(lista);
        } else {
            result.setCodigo("000");
            result.setMessage("Registros obtenidos correctamente");
            result.setResult(lista);
        }

    } catch (Exception e) {
        depurador.error("Error al obtener los códigos para el id: " + id.get("id"), e);
        result.setCodigo("003");
        result.setMessage("Ocurrió un error al obtener los códigos para el id: " + id.get("id"));
    }
    return result;
}
    
    
    /*@ApiOperation(value = "Encontrar egreso por ID")
    @RequestMapping(value = "/getRegistroEgreso", method = RequestMethod.POST)
    public ProcessResult<Optional<TbEgreso>> getProductoById(@RequestBody IdRequestDTO request) {
        ProcessResult<String> result= new ProcessResult<String>();
        result.setCodigo("000");
        result.setMessage("Registro Encontrado");
        result = shoppingService.obtenerPorId(request.getId());
    return result;
    }*/
    
}
  
