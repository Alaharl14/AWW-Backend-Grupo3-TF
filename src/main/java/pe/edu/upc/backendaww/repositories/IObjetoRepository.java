package pe.edu.upc.backendaww.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.backendaww.entities.Objeto;

import java.util.List;

@Repository
public interface IObjetoRepository extends JpaRepository<Objeto,Integer> {

    @Query("from Objeto o where o.cuenta.nombreCuenta like %:nombreCuenta%")
    List<Objeto> buscarCuenta(@Param("nombreCuenta") String nombreCuenta);

    @Query("from Objeto o where o.recordatorio.estadoRecordatorio like %:estadoRecordatorio%")
    List<Objeto> buscarRecordatorio(@Param("estadoRecordatorio") String estadoRecordatorio);

    @Query("from Objeto o where o.categoriaObjeto.nombreCategoriaObjeto like %:nombreCategoriaObjeto%")
    List<Objeto> buscarCategoriaObjeto(@Param("nombreCategoriaObjeto") String nombreCategoriaObjeto);

    @Query("from Objeto o where o.estadoObjeto.nombreEstadoObjeto like %:nombreEstadoObjeto%")
    List<Objeto> buscarEstadoObjeto(@Param("nombreEstadoObjeto") String nombreEstadoObjeto);

    @Query("from Objeto o where o.nombreObjeto like %:nombreObjeto%")
    List<Objeto> buscarObjeto(@Param("nombreObjeto") String nombreObjeto);

    @Query(value = "select * from cuenta cu join objeto obj on obj.id_cuenta = cu.id_cuenta join categoria_objeto co on obj.id_categoria_objeto = co.id_categoria_objeto where (co.nombre_categoria_objeto like 'Personal')", nativeQuery = true)
    List<Objeto> reporteCuentaCategoriaPersonal();

    @Query(value = "select di.nombre_distrito,count(obj.id_objeto) as cantidad from objeto obj, cuenta cu, distrito di WHERE obj.id_cuenta=cu.id_cuenta and cu.id_distrito=di.id_distrito group by di.nombre_distrito",nativeQuery = true)
    List<String[]> reporteCantidadObjetoDistritos();
}
