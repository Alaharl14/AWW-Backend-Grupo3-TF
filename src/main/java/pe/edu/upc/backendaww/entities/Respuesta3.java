package pe.edu.upc.backendaww.entities;

public class Respuesta3 {

    private String nombre_distrito;
    private String cantidad;

    public String getNombre_distrito() {
        return nombre_distrito;
    }

    public void setNombre_distrito(String nombre_distrito) {
        this.nombre_distrito = nombre_distrito;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public Respuesta3() {
    }

    public Respuesta3(String nombre_distrito, String cantidad) {
        this.nombre_distrito = nombre_distrito;
        this.cantidad = cantidad;
    }
}
