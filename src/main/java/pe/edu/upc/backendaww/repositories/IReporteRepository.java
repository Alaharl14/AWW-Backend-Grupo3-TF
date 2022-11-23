package pe.edu.upc.backendaww.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.backendaww.entities.Reporte;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IReporteRepository extends JpaRepository<Reporte,Integer> {

    @Query("from Reporte r where r.objeto.nombreObjeto like %:nombreObjeto%")
    List<Reporte> buscarObjeto(@Param("nombreObjeto") String nombreObjeto);

    @Query("from Reporte r where r.estadoreporte.nombreEstadoReporte like %:nombreEstadoReporte%")
    List<Reporte> buscarEstadoReporte(@Param("nombreEstadoReporte") String nombreEstadoReporte);

    @Query("from Reporte r where r.nombreReporte like %:nombreReporte%")
    List<Reporte> buscarReporte(@Param("nombreReporte") String nombreReporte);

    @Query(value = "select * from reporte where fecha_reporte>'2022-11-08' and fecha_reporte<'2022-11-22'",nativeQuery = true)
    List<Reporte> reportesUltimosdias();

    @Query(value = "select * from reporte r, estado_reporte er where r.id_estado_reporte=er.id_estado_reporte and (er.nombre_estado_reporte like 'Tomado')",nativeQuery = true)
    List<Reporte> reporteTomado();

    @Query(value = "select co.nombre_categoria_objeto, count(r.id_reporte) as cantidad from reporte r join objeto obj on obj.id_objeto = r.id_objeto join categoria_objeto co on co.id_categoria_objeto = obj.id_categoria_objeto where r.id_objeto=obj.id_objeto and obj.id_categoria_objeto = co.id_categoria_objeto group by co.nombre_categoria_objeto",nativeQuery = true)
    List<String[]>reporteCantidadCategoriaObjetos();

    @Query(value = "select er.nombre_estado_reporte, count(r.nombre_reporte) as cantidad from reporte r join estado_reporte er on er.id_estado_reporte = r.id_estado_reporte where (er.nombre_estado_reporte like 'Completado' or er.nombre_estado_reporte like 'En proceso') group by er.nombre_estado_reporte", nativeQuery = true)
    List<String[]>reporteCantidadCategoriaCompletadoEnProceso();
}