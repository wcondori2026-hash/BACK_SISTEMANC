/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ncquality.sad.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pe.com.ncquality.sad.bean.ProcessResult;
import pe.com.ncquality.sad.dto.ProyectoDTO;
import pe.com.ncquality.sad.entity.TbProyecto;
import pe.com.ncquality.sad.repository.NcProyectoRepositorio;
import pe.com.ncquality.sad.service.GenericService;
import pe.com.ncquality.sad.service.ProyectoService;

@RestController
@Api(tags = "Proyectos")
@RequestMapping("/v1/proyectos")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
public class ProyectoController {
    
    @Autowired
    ProyectoService proyectoService;
    
    @Autowired
    private NcProyectoRepositorio ncProyectoRepositorio;

    @Autowired
    private GenericService genericService;


    private static Logger depurador = Logger.getLogger(ObjectController.class.getName());
    
    @ApiOperation(value = "Obtener lista de Proyectos")
    @RequestMapping(value = "/getListaProyectos", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public ProcessResult<List<ProyectoDTO>> getListaProyectos(@RequestBody(required = false) Map<String, Object> proyecto) {

        ProcessResult<List<ProyectoDTO>> result = new ProcessResult<>();

        try {
            // Validar que el request no esté vacío
            if (proyecto == null || proyecto.isEmpty()) {
                result.setCodigo("001");
                result.setMessage("El request está vacío o es nulo.");
                return result;
            }

            // Validar campos obligatorios
            if (proyecto.get("codCotiza") == null || proyecto.get("proyecto") == null ||
                proyecto.get("fecIni") == null || proyecto.get("fecFin") == null ||
                proyecto.get("codRes") == null || proyecto.get("codEtapa") == null ||
                proyecto.get("page") == null || proyecto.get("size") == null) {

                result.setCodigo("001");
                result.setMessage("Faltan campos obligatorios en el request.");
                return result;
            }

            // Conversión segura
            String codCotiza   = proyecto.get("codCotiza").toString().trim().toUpperCase();
            String nomProyecto = proyecto.get("proyecto").toString().trim().toUpperCase();

            String fecIniStr   = proyecto.get("fecIni").toString().trim();
            String fecFinStr   = proyecto.get("fecFin").toString().trim();

            String codResStr   = proyecto.get("codRes").toString().trim();
            String codEtapa    = proyecto.get("codEtapa").toString().trim().toUpperCase();

            String pageStr     = proyecto.get("page").toString().trim();
            String sizeStr     = proyecto.get("size").toString().trim();

            // Validar vacíos
            if (codCotiza.isEmpty() || nomProyecto.isEmpty() || fecIniStr.isEmpty() || fecFinStr.isEmpty()
                || codResStr.isEmpty() || codEtapa.isEmpty() || pageStr.isEmpty() || sizeStr.isEmpty()) {

                result.setCodigo("001");
                result.setMessage("Los parámetros no deben estar vacíos.");
                return result;
            }

            // Validar numéricos
            int page;
            int size;
            Integer codRes;
            try {
                codRes = Integer.parseInt(codResStr);
                page   = Integer.parseInt(pageStr);
                size   = Integer.parseInt(sizeStr);
            } catch (NumberFormatException e) {
                result.setCodigo("002");
                result.setMessage("Error en los valores numéricos. 'codRes', 'page' y 'size' deben ser números enteros.");
                return result;
            }

            //  Validación de formato de fecha (dd/MM/yyyy)
            String fechaPattern = "^\\d{2}/\\d{2}/\\d{4}$"; 
            if (!fecIniStr.matches(fechaPattern) || !fecFinStr.matches(fechaPattern)) {
                result.setCodigo("001");
                result.setMessage("Formato de fecha inválido. Use dd/MM/yyyy, ejemplo: 15/08/2025");
                return result;
            }

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            sdf.setLenient(false); // evita aceptar fechas inválidas como 32/01/2025
            Date fecIni = sdf.parse(fecIniStr);
            Date fecFin = sdf.parse(fecFinStr);

            int offset = page * size;

            depurador.info(":::::::::::::::::::: Obtener info Proyectos ::::::::::::::::::::::::");

            // 🔹 Llamada al servicio
            List<ProyectoDTO> lista = proyectoService.ObtenerProyectoInfo(
                codCotiza,
                nomProyecto,
                fecIni, fecFin,
                codRes,
                codEtapa,
                size,
                offset
            );

            if (lista == null || lista.isEmpty()) {
                result.setCodigo("001");
                result.setMessage("La lista de Proyectos está vacía.");
                return result;
            }

            result.setCodigo("000");
            result.setMessage("OK");
            result.setResult(lista);

        } catch (ParseException e) {
            result.setCodigo("002");
            result.setMessage("Fecha inválida. Use dd/MM/yyyy.");
            result.setException(e.getMessage());
        } catch (Exception e) {
            result.setCodigo("002");
            result.setMessage("Ocurrió un error inesperado al obtener la información de proyectos.");
            result.setException(e.getMessage());
        }

        return result;
    }
    
    
    /*@ApiOperation(value = "Añadir registro de proyectos")
    @RequestMapping(value = "/setRegistrarProyecto", method = RequestMethod.POST)
    public ProcessResult<String> setRegistrar(@RequestBody TbProyecto proyecto) {
        depurador.info(":::::::::::::::::::: Registrar nuevo Proyecto ::::::::::::::::::::::::");

            ProcessResult<String> result= new ProcessResult<String>();
            
 
         try {
             proyectoService.guardarProyecto(proyecto);
            
            
            
         }catch (Exception e) {
         depurador.error("Error al registrar el proyecto", e);
             result.setCodigo("002");
             result.setMessage("Ocurrió un error al registrar el proyecto");
             result.setException(e.getMessage());
        }
        
         return result;
   
    }*/
    
    
    @ApiOperation(value = "Grabar registro de proyectos")
    @RequestMapping(value = "/grabarProyecto",consumes = "application/json", method = RequestMethod.POST)
    public ProcessResult<TbProyecto> grabarProyecto(@RequestBody TbProyecto proyecto) {
        depurador.info("::::::::::::::: Grabar nuevo Proyecto :::::::::::::::");

        ProcessResult<TbProyecto> result = new ProcessResult<>();

        try {
            TbProyecto saved = genericService.save(ncProyectoRepositorio, proyecto);

            result.setCodigo("001");
            result.setMessage("Proyecto grabado correctamente");

        } catch (Exception e) {
            depurador.error("Error al grabar el proyecto", e);
            result.setCodigo("002");
            result.setMessage("Ocurrió un error al grabar el proyecto");
            result.setException(e.getMessage());
        }

        return result;
    }
    
    @ApiOperation(value = "Obtener por Id la lista de proyectos")
    @RequestMapping(value = "/obtenerProyectoById",consumes = "application/json", method = RequestMethod.POST)
    public ProcessResult<TbProyecto> ObtenerProyecto(@RequestBody Integer id) {
        depurador.info("::::::::::::::: Obtener Proyecto :::::::::::::::");

        ProcessResult<TbProyecto> result = new ProcessResult<>();

        try {
            result.setResult(genericService.findById(ncProyectoRepositorio, id)); 

            result.setCodigo("001");
            result.setMessage("Proyecto grabado correctamente");

        } catch (Exception e) {
            depurador.error("Error al grabar el proyecto", e);
            result.setCodigo("002");
            result.setMessage("Ocurrió un error al grabar el proyecto");
            result.setException(e.getMessage());
        }

        return result;
    }
      
}
