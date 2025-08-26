
package pe.com.ncquality.sad.repository;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.com.ncquality.sad.entity.TbProyecto;

@Repository("ncProyectoRepositorio")
public interface NcProyectoRepositorio extends JpaRepository<TbProyecto, Serializable>{
    @Query(value = "SELECT ROW_NUMBER() OVER (ORDER BY p.id_proyecto) AS fila,"
            + " p.id_proyecto, "
            + " c.v_nro_cotiza ,"
            + " p.v_nomb_proyecto AS nomProyecto,"
            + " per.v_nombres_razon, per.v_ape_parterno,"
            + " d.v_descripcion AS tipoDoc, per.v_num_doc,"
            + " p.d_fec_ini_ejec, p.d_fec_fin_ejec,"
            + " i.n_monto AS costo,"
            + " e.n_monto AS gasto,"
            + " p.s_cod_etapa,"
            + " a.v_descripcion AS actividad,"
            + " COUNT(*) OVER() AS total_registros "
            + " FROM tb_proyecto p"
            + " INNER JOIN tb_cotizacion c ON p.id_cotizacion = c.id_cotizacion "
            + " INNER JOIN tb_personas per ON p.id_persona = per.id_persona "
            + " INNER JOIN tb_tipo_doc d ON per.id_tipo_doc = d.id_tipo_doc "
            + " INNER JOIN tb_egreso e ON p.id_proyecto = e.id_proyecto "
            + " INNER JOIN tb_ingreso i ON p.id_proyecto = i.id_proyecto "
            + " INNER JOIN tb_actividad a ON p.id_proyecto = a.id_proyecto "
            + " INNER JOIN tb_responsable r ON r.id_proyecto = p.id_proyecto"
            + " WHERE c.v_nro_cotiza = :codCotiza"
            + " AND  p.v_nomb_proyecto = :proyecto"
            + " AND p.d_fec_ini_ejec = :fecini"
            + " AND p.d_fec_fin_ejec = :fecfin"
            + " AND r.id_empleado = :codRes" 
            + " AND p.s_cod_etapa = :codEtapa"
            + " ORDER BY p.id_proyecto"
            + " LIMIT :limit OFFSET :offset"
            , nativeQuery = true)
    List<Object[]> ObtenerProyectoInfo(@Param("codCotiza") String codCotiza, 
            @Param("proyecto") String proyecto,
            @Param("fecini") Date fecini,
            @Param("fecfin") Date fecfin,
            @Param("codRes") Integer codRes,
            @Param("codEtapa") String codEtapa, 
            @Param("limit") Integer limit,
            @Param("offset") Integer offset
            );  
    
    
   
}
