package pe.edu.upc.backendaww.servicesinterfaces;

import pe.edu.upc.backendaww.entities.Reporte;
import pe.edu.upc.backendaww.entities.Respuesta;
import pe.edu.upc.backendaww.entities.Respuesta2;
import pe.edu.upc.backendaww.entities.Respuesta5;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IReporteService {

    public boolean insertar(Reporte reporte);
    List<Reporte> listar();
    public void eliminar(int idReporte);

    public Optional<Reporte> listarId(int idReporte);

    List<Reporte> buscarObjeto(String nombreObjeto);

    List<Reporte> buscarEstadoReporte(String nombreEstadoObjeto);

    List<Reporte> buscarReporte(String nombreReporte);

    List<Reporte> reportesUltimosdias();

    List<Reporte> reporteTomado();

    List<Respuesta2> reporteCantidadObjetos();

    List<Respuesta5> reporteCantidadCompletadoEnProceso();
}