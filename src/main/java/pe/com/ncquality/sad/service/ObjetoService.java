
package pe.com.ncquality.sad.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pe.com.ncquality.sad.dto.ObjetoDTO;
import pe.com.ncquality.sad.entity.TbCategoria;
import pe.com.ncquality.sad.entity.TbSubcategoria;
import pe.com.ncquality.sad.entity.TbTipoDoc;
import pe.com.ncquality.sad.repository.NcCategoriaRepositorio;
import pe.com.ncquality.sad.repository.NcSubcategoriaRepositorio;
import pe.com.ncquality.sad.repository.NcTipoDocRepositorio;
import org.springframework.data.domain.PageRequest;
import pe.com.ncquality.sad.entity.TbCodigos;
import pe.com.ncquality.sad.entity.TbServicios;
import pe.com.ncquality.sad.entity.TbTipoPersona;
import pe.com.ncquality.sad.entity.TbTipoProducto;
import pe.com.ncquality.sad.repository.NcCodigosRepositorio;
import pe.com.ncquality.sad.repository.NcGrupoRepositorio;
import pe.com.ncquality.sad.repository.NcServicioRepositorio;
import pe.com.ncquality.sad.repository.NcTipoPersonaRepositorio;
import pe.com.ncquality.sad.repository.NcTipoProductoRepositorio;

@Service("objetoService")
public class ObjetoService {
    
    @Autowired
    @Qualifier ("ncCategoriaRepositorio")
    private NcCategoriaRepositorio ncCategoriaRepositorio;
    
    @Autowired
    @Qualifier ("ncSubcategoriaRepositorio")
    private NcSubcategoriaRepositorio ncSubcategoriaRepositorio;
    
    @Autowired
    @Qualifier ("ncTipoDocRepositorio")
    private NcTipoDocRepositorio ncTipoDocRepositorio;
    
    @Autowired
    @Qualifier ("ncTipoPersonaRepositorio")
    private NcTipoPersonaRepositorio ncTipoPersonaRepositorio;
    
    @Autowired
    @Qualifier ("ncTipoProductoRepositorio")
    private NcTipoProductoRepositorio ncTipoProductoRepositorio;
    
    @Autowired
    @Qualifier ("ncServicioRepositorio")
    private NcServicioRepositorio ncServicioRepositorio;
    
    @Autowired
    @Qualifier ("ncGrupoRepositorio")
    private NcGrupoRepositorio ncGrupoRepositorio;
    
    @Autowired
    @Qualifier ("ncCodigosRepositorio")
    private NcCodigosRepositorio ncCodigosRepositorio;
    
    // Método para obtener todas las categorías
    public List<ObjetoDTO> obtenerCategorias() {
        return ncCategoriaRepositorio.ObtenerCategoria()
        .stream()
        .map(obj -> new ObjetoDTO((Integer) obj[0], (String) obj[1], (char) obj[2]))
        .collect(Collectors.toList());
    }

    // Método para obtener todas las subcategorías
    public List<ObjetoDTO> obtenerSubcategorias() {
          return ncSubcategoriaRepositorio.ObtenerSubcategoria()
        .stream()
        .map(obj -> new ObjetoDTO((Integer) obj[0], (String) obj[1], (char) obj[2]))
        .collect(Collectors.toList());
    }

    
    /*public List<TbTipoDoc> listarTipoDoc() {
        return ncTipoDocRepositorio.findOnlyTipoDoc();
    }*/
    
    // Método para obtener todos los tipos de documentos
    /*public List<ObjetoDTO> listarTipoDocumentos() {
        List<Object[]> resultados = ncTipoDocRepositorio.obtenerDocumentos();

        return resultados.stream()
            .map(obj -> new ObjetoDTO(
                (Integer) obj[0],
                (String) obj[1],
                ((char) obj[2])
            ))
            .collect(Collectors.toList());
    }*/
    
    public List<ObjetoDTO> listarTipoDocumentos() {
    return ncTipoDocRepositorio.obtenerDocumentos()
        .stream()
        .map(obj -> new ObjetoDTO((Integer) obj[0], (String) obj[1], (char) obj[2]))
        .collect(Collectors.toList());
    }
    
    public List<ObjetoDTO> listarTipoPersona() {
    return ncTipoPersonaRepositorio.obtenerTipoPersona()
        .stream()
        .map(obj -> new ObjetoDTO((Integer) obj[0], (String) obj[1], (char) obj[2]))
        .collect(Collectors.toList());
    }
    
    /*public List<TbTipoPersona> listaTipoPersona () {
        return ncTipoPersonaRepositorio.findAll();
    }*/
    
    public List<TbTipoProducto> listarTipoProducto(){
        return ncTipoProductoRepositorio.findAll();
    }
    
    public List<ObjetoDTO> listarGrupoPersona() {
    return ncGrupoRepositorio.obtenerGrupo()
            .stream()
            .map(obj -> new ObjetoDTO((Integer) obj[0], (String) obj[1], (char) obj[2]))
            .collect(Collectors.toList());
    }
    
    public List<TbCodigos> listarPorTipo(String tipo) {
        return ncCodigosRepositorio.ObtenerListaByTipo(tipo);
    }
    
    public List<TbServicios> listarServicios(){
        return ncServicioRepositorio.findAll();
    }
}
    
   
