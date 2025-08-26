
package pe.com.ncquality.sad.repository;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.com.ncquality.sad.entity.TbEgreso;

@Repository ("ncShoppingRepositorio")
public interface NcShoppingRepositorio extends JpaRepository<TbEgreso, Serializable> {
    
     @Query(value = "SELECT ROW_NUMBER() OVER (ORDER BY e.id_egreso) AS fila,"
            + " e.id_egreso, pe.v_nombres_razon, c.v_descripcion AS categoria_descr, "
            + "p.v_descripcion AS proyecto_descr, "
            + " e.v_num_doc, e.d_fec_emi, e.d_fec_venc, e.s_cod_etapa, "
            + " e.n_tasa_igv, e.n_igv_mon, e.n_monto,"
            + " COUNT(*) OVER() AS total_registros  "
            + " FROM tb_egreso e"
            + " INNER JOIN tb_personas pe ON e.id_persona = pe.id_persona"
            + " INNER JOIN tb_proyecto p ON e.id_proyecto = p.id_proyecto"
            + " INNER JOIN tb_categoria c ON e.id_categoria = c.id_categoria"
            + " INNER JOIN tb_cotizacion co ON p.id_cotizacion = co.id_cotizacion"
            + " WHERE co.v_nro_cotiza = :codCotiza"
            + " AND  p.id_proyecto = :codProyecto"
            + " AND e.d_fec_emi = :fecemi"
            + " AND e.d_fec_venc = :fecvenc"
            + " AND e.v_cod_doc = :codDoc"
            + " AND e.v_serie_doc = :serieDoc"
            + " AND e.v_num_doc = :numDoc"
            + " AND e.s_cod_etapa = :codEtapa"
            + " ORDER BY e.id_egreso"
            + " LIMIT :limit OFFSET :offset"
            , nativeQuery = true)
    List<Object[]> ObtenerEgresoInfo(@Param("codCotiza") String codCotiza, 
            @Param("codProyecto") Integer codProyecto,
            @Param("fecemi") Date fecemi,
            @Param("fecvenc") Date fecvenc,
            @Param("codDoc") String codDoc,
            @Param("serieDoc") String serieDoc, 
            @Param("numDoc") String numDoc,
            @Param("codEtapa") String codEta,
            @Param("limit") int limit,
            @Param("offset") int offset
            );  
    
    
    //TbEgreso findByidEgreso (int idEgreso);
    /*@Modifying
    @Transactional
    @Query(value = "INSERT INTO tb_egreso (" +
            "id_egreso, id_empresa, id_persona, id_proyecto, id_categoria, id_subcateg, " +
            "s_cod_etapa, v_cod_compra, v_cod_subdiario, v_cod_doc, v_num_doc, v_serie_doc, " +
            "d_fec_emi, d_fec_venc, n_tasa_igv, n_igv_mon, n_monto, " +
            "d_fec_emi_ref, v_cod_doc_ref, v_num_doc_ref, v_serie_doc_ref, " +
            "v_cod_tipo_conver, v_tipo_camb, d_fec_camb, v_glosa, v_cod_moned, " +
            "b_estado, i_id_usuario_cre, d_fecha_reg_cre, i_id_usuario_mod, d_fecha_reg_mod) " +
            "VALUES (:idEgreso, :idEmpresa, :idPersona, :idProyecto, :idCategoria, :idSubcateg, " +
            ":sCodEtapa, :vCodCompra, :vCodSubdiario, :vCodDoc, :vNumDoc, :vSerieDoc, " +
            ":dFecEmi, :dFecVenc, :nTasaIgv, :nIgvMon, :nMonto, " +
            ":dFecEmiRef, :vCodDocRef, :vNumDocRef, :vSerieDocRef, " +
            ":vCodTipoConver, :vTipoCamb, :dFecCamb, :vGlosa, :vCodMoned, " +
            ":bEstado, :iIdUsuarioCre, :dFechaRegCre, :iIdUsuarioMod, :dFechaRegMod)", 
            nativeQuery = true)
    void insertarEgreso(
            @Param("idEgreso") Integer idEgreso,
            @Param("idEmpresa") Integer idEmpresa,
            @Param("idPersona") Integer idPersona,
            @Param("idProyecto") Integer idProyecto,
            @Param("idCategoria") Integer idCategoria,
            @Param("idSubcateg") Integer idSubcateg,
            @Param("sCodEtapa") String sCodEtapa,
            @Param("vCodCompra") String vCodCompra,
            @Param("vCodSubdiario") String vCodSubdiario,
            @Param("vCodDoc") String vCodDoc,
            @Param("vNumDoc") String vNumDoc,
            @Param("vSerieDoc") String vSerieDoc,
            @Param("dFecEmi") Date dFecEmi,
            @Param("dFecVenc") Date dFecVenc,
            @Param("nTasaIgv") Double nTasaIgv,
            @Param("nIgvMon") Double nIgvMon,
            @Param("nMonto") Double nMonto,
            @Param("dFecEmiRef") Date dFecEmiRef,
            @Param("vCodDocRef") String vCodDocRef,
            @Param("vNumDocRef") String vNumDocRef,
            @Param("vSerieDocRef") String vSerieDocRef,
            @Param("vCodTipoConver") String vCodTipoConver,
            @Param("vTipoCamb") Double vTipoCamb,
            @Param("dFecCamb") Date dFecCamb,
            @Param("vGlosa") String vGlosa,
            @Param("vCodMoned") String vCodMoned,
            @Param("bEstado") String bEstado,
            @Param("iIdUsuarioCre") Integer iIdUsuarioCre,
            @Param("dFechaRegCre") Date dFechaRegCre,
            @Param("iIdUsuarioMod") Integer iIdUsuarioMod,
            @Param("dFechaRegMod") Date dFechaRegMod
    );*/
    @Query(value = "SELECT " +
            "e.id_egreso, " +                  
            "e.s_cod_etapa, " +                
            "e.v_cod_compra, " +               
            "e.v_cod_subdiario, " +            
            "e.v_cod_doc, " +                  
            "e.v_num_doc, " +                  
            "e.v_serie_doc, " +                
            "e.d_fec_emi, " +                  
            "e.d_fec_venc, " +                 
            "e.n_tasa_igv, " +                 
            "e.n_igv_mon, " +                  
            "e.n_monto, " +                    
            "e.d_fec_emi_ref, " +              
            "e.v_cod_doc_ref, " +              
            "e.v_num_doc_ref, " +              
            "e.v_serie_doc_ref, " +            
            "e.v_cod_tipo_conver, " +          
            "e.v_tipo_camb, " +                
            "e.d_fec_camb, " +                 
            "e.v_glosa, " +                    
            "e.v_cod_moned, " +                
            "e.b_estado, " +                   
            "e.i_id_usuario_cre, " +             
            "e.d_fecha_reg_cre, " +            
            "e.i_id_usuario_mod, " +             
            "e.d_fecha_reg_mod, " +            
            "c.id_categoria, " +               
            "pro.id_proyecto, " +                
            "p.id_persona, " +                 
            "em.id_empresa, " +                 
            "s.id_subcateg " +                 
            "FROM tb_egreso e " +
            "INNER JOIN tb_personas p ON e.id_persona = p.id_persona " +
            " INNER JOIN tb_empresa em ON e.id_empresa = em.id_empresa "
            + "INNER JOIN tb_proyecto pro ON e.id_proyecto = pro.id_proyecto "
            + "INNER JOIN tb_categoria c ON e.id_categoria = c.id_categoria "
            + "INNER JOIN tb_subcategoria s ON e.id_subcateg = s.id_subcateg " +
            "WHERE id_egreso = :idEgreso",
            nativeQuery = true)
    List<Object[]> findEgresoById(@Param("idEgreso") Integer idEgreso);

    //public Optional<TbEgreso> findByidEgreso(Integer id);
    
    
    
}
