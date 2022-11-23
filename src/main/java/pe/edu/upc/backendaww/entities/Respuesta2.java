package pe.edu.upc.backendaww.entities;

public class Respuesta2 {

    private String nombre_categoria_objeto;
    private String cantidad;

    public Respuesta2() {
    }

    public Respuesta2(String nombre_categoria_objeto, String cantidad) {
        this.nombre_categoria_objeto = nombre_categoria_objeto;
        this.cantidad = cantidad;
    }

    public String getNombre_categoria_objeto() {
        return nombre_categoria_objeto;
    }

    public void setNombre_categoria_objeto(String nombre_categoria_objeto) {
        this.nombre_categoria_objeto = nombre_categoria_objeto;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }
}
