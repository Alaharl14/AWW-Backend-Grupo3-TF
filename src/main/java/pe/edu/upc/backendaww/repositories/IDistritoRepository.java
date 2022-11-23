package pe.edu.upc.backendaww.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.backendaww.entities.Distrito;
import pe.edu.upc.backendaww.entities.Respuesta3;

import java.util.List;

@Repository
public interface IDistritoRepository extends JpaRepository<Distrito,Integer>{

    @Query("from Distrito d where d.ciudad.nombreCiudad like %:nombreCiudad%")
    List<Distrito> buscarCiudad(@Param("nombreCiudad") String nombreCiudad);

    @Query("from Distrito d where d.nombreDistrito like %:nombreDistrito%")
    List<Distrito> buscarDistrito(@Param("nombreDistrito") String nombreDistrito);

    @Query (value = "select nombre_distrito, cantidad from vista1 where cantidad=(select MAX(cantidad) FROM vista1)",nativeQuery = true)
    List<String[]> reporteCantidadCuentaDistritos();

}
