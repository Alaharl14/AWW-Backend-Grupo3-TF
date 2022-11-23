package pe.edu.upc.backendaww.servicesimpls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.upc.backendaww.entities.Reporte;
import pe.edu.upc.backendaww.entities.Respuesta;
import pe.edu.upc.backendaww.entities.Respuesta2;
import pe.edu.upc.backendaww.entities.Respuesta5;
import pe.edu.upc.backendaww.repositories.IReporteRepository;
import pe.edu.upc.backendaww.servicesinterfaces.IReporteService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ReporteServiceImpl implements IReporteService {

    @Autowired
    private IReporteRepository rR;
    @Override
    @Transactional
    public boolean insertar(Reporte reporte) {
        Reporte objReporte = rR.save(reporte);
        if (objReporte == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public List<Reporte> listar() {
        return rR.findAll();
    }

    @Override
    @Transactional
    public void eliminar(int idReporte) {
        rR.deleteById(idReporte);
    }

    @Override
    public Optional<Reporte> listarId(int idReporte) {
        return rR.findById(idReporte);
    }

    @Override
    public List<Reporte> buscarObjeto(String nombreObjeto) {
        return rR.buscarObjeto(nombreObjeto);
    }

    @Override
    public List<Reporte> buscarEstadoReporte(String nombreEstadoReporte) {
        return rR.buscarEstadoReporte(nombreEstadoReporte);
    }
    @Override
    public List<Reporte> buscarReporte(String nombreReporte) {
        return rR.buscarReporte(nombreReporte);
    }

    @Override
    public List<Reporte> reportesUltimosdias() {
        return rR.reportesUltimosdias();
    }

    @Override
    public List<Reporte> reporteTomado() {
        return rR.reporteTomado();
    }

    @Override
    public List<Respuesta2> reporteCantidadObjetos() {
        List<Respuesta2>lista=new ArrayList<>();
        rR.reporteCantidadCategoriaObjetos().forEach(y->{
            Respuesta2 r=new Respuesta2();
            r.setNombre_categoria_objeto(y[0]);
            r.setCantidad(y[1]);
            lista.add(r);
        });
        return lista;
    }

    @Override
    public List<Respuesta5> reporteCantidadCompletadoEnProceso() {
        List<Respuesta5>lista=new ArrayList<>();
        rR.reporteCantidadCategoriaCompletadoEnProceso().forEach(y->{
            Respuesta5 r=new Respuesta5();
            r.setNombre_estado_reporte(y[0]);
            r.setCantidad(y[1]);
            lista.add(r);
        });
        return lista;
    }
}