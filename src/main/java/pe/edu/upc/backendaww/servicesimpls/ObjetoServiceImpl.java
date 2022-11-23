package pe.edu.upc.backendaww.servicesimpls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.upc.backendaww.entities.Objeto;
import pe.edu.upc.backendaww.entities.Respuesta3;
import pe.edu.upc.backendaww.entities.Respuesta4;
import pe.edu.upc.backendaww.repositories.IObjetoRepository;
import pe.edu.upc.backendaww.servicesinterfaces.IObjetoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ObjetoServiceImpl implements IObjetoService {

    @Autowired
    private IObjetoRepository oR;

    @Override
    @Transactional
    public boolean insertar(Objeto objeto) {
        Objeto objObjeto = oR.save(objeto);
        if (objObjeto == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public List<Objeto> listar() {
        return oR.findAll();
    }

    @Override
    @Transactional
    public void eliminar(int idObjeto) {
        oR.deleteById(idObjeto);
    }

    @Override
    public Optional<Objeto> listarId(int idObjeto) {
        return oR.findById(idObjeto);
    }

    @Override
    public List<Objeto> buscarCuenta(String nombreCuenta) {
        return oR.buscarCuenta(nombreCuenta);
    }

    @Override
    public List<Objeto> buscarRecordatorio(String estadoRecordatorio) { return oR.buscarRecordatorio(estadoRecordatorio); }

    @Override
    public List<Objeto>buscarCategoriaObjeto(String nombreCategoriaObjeto) {
        return oR.buscarCategoriaObjeto(nombreCategoriaObjeto);
    }

    @Override
    public List<Objeto> buscarEstadoObjeto(String nombreEstadoObjeto) {
        return oR.buscarEstadoObjeto(nombreEstadoObjeto);
    }

    @Override
    public List<Objeto> buscarObjeto(String nombreObjeto) {
        return oR.buscarObjeto(nombreObjeto);
    }

    @Override
    public List<Objeto> reporteCuentaCategoriaPersonal() {
        return oR.reporteCuentaCategoriaPersonal();
    }

    @Override
    public List<Respuesta4> reporteCantidadDistritos() {
        List<Respuesta4> lista = new ArrayList<>();
        oR.reporteCantidadObjetoDistritos().forEach(y -> {
            Respuesta4 r = new Respuesta4();
            r.setNombre_distrito(y[0]);
            r.setCantidad(y[1]);
            lista.add(r);
        });
        return lista;
    }


}
