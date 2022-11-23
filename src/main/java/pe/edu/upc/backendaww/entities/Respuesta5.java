package pe.edu.upc.backendaww.entities;

public class Respuesta5 {

    private String nombre_estado_reporte;
    private String cantidad;

    public String getNombre_estado_reporte() {
        return nombre_estado_reporte;
    }

    public void setNombre_estado_reporte(String nombre_estado_reporte) {
        this.nombre_estado_reporte = nombre_estado_reporte;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public Respuesta5() {
    }

    public Respuesta5(String nombre_estado_reporte, String cantidad) {
        this.nombre_estado_reporte = nombre_estado_reporte;
        this.cantidad = cantidad;
    }
}
