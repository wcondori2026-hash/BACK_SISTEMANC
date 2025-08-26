
package pe.com.ncquality.sad.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.Map;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pe.com.ncquality.sad.bean.ProcessResult;
import pe.com.ncquality.sad.dto.ObjetoDTO;
import pe.com.ncquality.sad.entity.TbCategoria;
import pe.com.ncquality.sad.entity.TbCodigos;
import pe.com.ncquality.sad.entity.TbServicios;
import pe.com.ncquality.sad.entity.TbSubcategoria;
import pe.com.ncquality.sad.entity.TbTipoProducto;
import pe.com.ncquality.sad.service.ObjetoService;

@RestController
@Api( tags = "Objetos")
@RequestMapping("/v1/objects") 
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ObjectController {
    
    @Autowired
    ObjetoService objetoService;
    
    private static Logger depurador = Logger.getLogger(ObjectController.class.getName());
    
    //Obtener lista de Categorias
    @ApiOperation(value = "Obtener lista de categorías")
    @RequestMapping(value = "/getListaCategorias", method = RequestMethod.GET)
                                                           //RequestMethod.GET 
    //public ResponseEntity<?> getListaCategorias (@RequestBody Map<String, Object>  obtenerCategorias) {
    public ProcessResult<?> getListaCategorias () {
        depurador.info(":::::::::::::::::::: obtenerCategorias :::::::::::::::::::::::::" /*+ obtenerCategorias.get(this)*/ );
            ProcessResult<List<?>> result= new ProcessResult<List<?>>();
        try {
            List<ObjetoDTO> lista = objetoService.obtenerCategorias();

            if (lista == null || lista.isEmpty()) {
                result.setCodigo("001");
                result.setMessage("La lista de Categorías esta vacía o es null.");
                
                return result; 
            }
            result.setResult(lista);
            result.setCodigo("000");
            result.setMessage("Lista obtenida con éxito");

            return result; 
        } catch (Exception e) {
            result.setCodigo("002");
            result.setMessage("Ocurrió un error al obtener las categorías");
            result.setException(e.getMessage());
            return result;
        }
    }
    
    //Obtener lista de Subcategorias
    @ApiOperation(value = "Obtener lista de Subcategorías")
    @RequestMapping(value = "/getListaSubcategorias", method = RequestMethod.GET)
    public ProcessResult<?> getListaSubcategorias () {
        depurador.info(":::::::::::::::::::: obtenerSubcategorias :::::::::::::::::::::::::" );
            ProcessResult<List<?>> result= new ProcessResult<List<?>>();
        try {
            List<ObjetoDTO> lista = objetoService.obtenerSubcategorias();

            if (lista == null || lista.isEmpty()) {
                result.setCodigo("001");
                result.setMessage("La lista de Subcategorías esta vacía o es null.");
                
                return result; 
            }

            result.setResult(lista);
            result.setCodigo("000");
            result.setMessage("Lista obtenida con éxito");

            return result;
        } catch (Exception e) {
            result.setCodigo("002");
            result.setMessage("Ocurrió un error al obtener las subategorías");
            result.setException(e.getMessage());
            return result;
        }
    }
    
    
    //Obtener lista de Tipo de Documentos
    @ApiOperation(value = "Obtener lista de Documentos")
    @RequestMapping(value = "/getListaTipoDocumentos", method = RequestMethod.GET)
    public ProcessResult<?> getListaTipoDocumentos () {
        depurador.info(":::::::::::::::::::: obtenerDocumentos :::::::::::::::::::::::::");
            ProcessResult<List<?>> result= new ProcessResult<List<?>>();
        try {
            List<ObjetoDTO> lista = objetoService.listarTipoDocumentos();

            if (lista == null || lista.isEmpty()) {
                result.setCodigo("001");
                result.setMessage("La lista de Tipos de Documentos esta vacía o es null.");
                
                return result; 
            }

            result.setResult(lista);
            result.setCodigo("000");
            result.setMessage("Lista obtenida con éxito");

            return result;
        } catch (Exception e) {
            result.setCodigo("002");
            result.setMessage("Ocurrió un error al obtener los tipos de documento");
            result.setException(e.getMessage());
            return result;
        }
    }
    
     //Obtener lista de Tipo de Personas
    @ApiOperation(value = "Obtener lista de Tipo de Personas")
    @RequestMapping(value = "/getListaTipoPersonas", method = RequestMethod.GET)
    public ProcessResult<?> getListaTipoPersonas () {
        depurador.info(":::::::::::::::::::: obtenerTipoPersonas :::::::::::::::::::::::::");
            ProcessResult<List<?>> result= new ProcessResult<List<?>>();
        try {
            List<ObjetoDTO> lista = objetoService.listarTipoPersona();

            if (lista == null || lista.isEmpty()) {
                result.setCodigo("001");
                result.setMessage("La lista de Tipos de Persona esta vacía o es null.");
                
                return result; 
            }

            result.setResult(lista);
            result.setCodigo("000");
            result.setMessage("Lista obtenida con éxito");

            return result;
        } catch (Exception e) {
            result.setCodigo("002");
            result.setMessage("Ocurrió un error al obtener los tipos de persona");
            result.setException(e.getMessage());
            return result;
        }
    }
    
    //Obtener lista Grupo Personas
    @ApiOperation(value = "Obtener lista Grupo Personas")
    @RequestMapping(value = "/getListaGrupoPersonas", method = RequestMethod.GET)
    public ProcessResult<?> getListaGrupo() {
        depurador.info(":::::::::::::::::::: obtenerGrupoPersonas :::::::::::::::::::::::::");
            ProcessResult<List<?>> result= new ProcessResult<List<?>>();
        try {
            List<ObjetoDTO> lista = objetoService.listarGrupoPersona();

            if (lista == null || lista.isEmpty()) {
                result.setCodigo("001");
                result.setMessage("La lista de Grupo de Persona esta vacía o es null.");
                
                return result; 
            }

            result.setResult(lista);
            result.setCodigo("000");
            result.setMessage("Lista obtenida con éxito");

            return result;
        } catch (Exception e) {
            result.setCodigo("002");
            result.setMessage("Ocurrió un error al obtener los grupos de persona");
            result.setException(e.getMessage());
            return result;
        }
    }
    
     //Obtener lista de Tipo de Productos
    @ApiOperation(value = "Obtener lista de Tipo Productos")
    @RequestMapping(value = "/getListaTipoProductos", method = RequestMethod.GET)
    public ProcessResult<?> getListaTipoProductos () {
        depurador.info(":::::::::::::::::::: obtenerProductos :::::::::::::::::::::::::");
        ProcessResult<List<?>> result= new ProcessResult<List<?>>();
        try {
            List<TbTipoProducto> lista = objetoService.listarTipoProducto();

            if (lista == null || lista.isEmpty()) {
                result.setCodigo("001");
                result.setMessage("La lista de Grupo de Persona esta vacía o es null.");
                
                return result;
            }

            result.setResult(lista);
            result.setCodigo("000");
            result.setMessage("Lista obtenida con éxito");

            return result;
        } catch (Exception e) {
            result.setCodigo("002");
            result.setMessage("Ocurrió un error al obtener los grupos de persona");
            result.setException(e.getMessage());
            return result;
        }
    } 

//Obtener lista de Servicios
    @ApiOperation(value = "Obtener lista de Servicios")
    @RequestMapping(value = "/getListaServicios", method = RequestMethod.GET)
    public ProcessResult<?> getListaServicios () {
        depurador.info(":::::::::::::::::::: obtenerServicios :::::::::::::::::::::::::");
        ProcessResult<List<?>> result= new ProcessResult<List<?>>();
        try {
            List<TbServicios> lista = objetoService.listarServicios();

            if (lista == null || lista.isEmpty()) {
                result.setCodigo("001");
                result.setMessage("La lista de Grupo de Persona esta vacía o es null.");
                
                return result;
            }

            result.setResult(lista);
            result.setCodigo("000");
            result.setMessage("Lista obtenida con éxito");
            
            return result;
        } catch (Exception e) {
            result.setCodigo("002");
            result.setMessage("Ocurrió un error al obtener los grupos de persona");
            result.setException(e.getMessage());
            return result;
        }
    }
    
    @ApiOperation(value = "Obtener lista de codigos por TipoCodigo")
    @RequestMapping(value = "/getListaCodigos", method = RequestMethod.POST)
    public ProcessResult<?> getListaCodigos (@RequestBody Map<String, Object> codigo){
        String tipo = codigo.get("tipo").toString().toUpperCase();
        depurador.info(":::::::::::::::::::: Obtener códigos del tipo: " + tipo + " ::::::::::::::::::::::::");
        ProcessResult<List<?>> result= new ProcessResult<List<?>>();
        try {
        if (tipo == null || tipo.trim().isEmpty()) {
            result.setCodigo("001");
            result.setMessage("El parámetro tipo es obligatorio");
                
                return result;
        }
        List<TbCodigos> lista = objetoService.listarPorTipo(tipo);
        
        if (lista == null || lista.isEmpty()) {
            result.setCodigo("001");
            result.setMessage("La lista de códigos para el tipo " + tipo + " está vacía o es null.");
                
            return result;
        }

            result.setResult(lista);
            result.setCodigo("000");
            result.setMessage("Lista obtenida con éxito");
            
            return result;
    } catch (Exception e) {
        result.setCodigo("002");
            result.setMessage("Ocurrió un error al obtener la lista con el código "+tipo);
            result.setException(e.getMessage());
            return result;
        }
    }
    

}
