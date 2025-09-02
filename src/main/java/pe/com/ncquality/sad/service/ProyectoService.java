/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ncquality.sad.service;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pe.com.ncquality.sad.bean.ProcessResult;
import pe.com.ncquality.sad.dto.ProyectoDTO;
import pe.com.ncquality.sad.dto.RegistroObraDTO;
import pe.com.ncquality.sad.entity.TbCategoria;
import pe.com.ncquality.sad.entity.TbEgreso;
import pe.com.ncquality.sad.entity.TbEmpresa;
import pe.com.ncquality.sad.entity.TbPersonas;
import pe.com.ncquality.sad.entity.TbProyecto;
import pe.com.ncquality.sad.entity.TbSubcategoria;
import pe.com.ncquality.sad.repository.NcProyectoRepositorio;


@Service("proyectoService")
public class ProyectoService {
    @Autowired
    @Qualifier ("ncProyectoRepositorio")
    private NcProyectoRepositorio ncProyectoRepositorio;
    
     //private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final String DATE_PATTERN = "dd/MM/yyyy";
    
     public List<ProyectoDTO> ObtenerProyectoInfo(String codCotiza, String proyecto,
                                                Date fecIni, Date fecFin, Integer codRes,
                                                 String codEtapa, Integer limit, Integer offset) {
        
        return ncProyectoRepositorio.ObtenerProyectoInfo(codCotiza, proyecto, fecIni, fecFin, codRes,
                codEtapa, limit, offset)
        .stream()
        .map(obj -> new ProyectoDTO(
            (BigInteger) obj[0],  
            (Integer) obj[1],
            (String) obj[2],
            (String) obj[3],
            (String) obj[4],
            (String) obj[5],
            (String) obj[6],
            (String) obj[7],
            (Date) obj[8],
            (Date) obj[9],   
            obj[10] != null ? ((BigDecimal) obj[10]).doubleValue() : null,
            obj[11] != null ? ((BigDecimal) obj[11]).doubleValue() : null,
            (String) obj[12],
            (String) obj[13],
            (BigInteger) obj[14]
            
        ))
        .collect(Collectors.toList());
    }
   
     
     public TbProyecto guardarProyecto(TbProyecto proyecto) {
        return ncProyectoRepositorio.save(proyecto); 
    }
    
     
}
