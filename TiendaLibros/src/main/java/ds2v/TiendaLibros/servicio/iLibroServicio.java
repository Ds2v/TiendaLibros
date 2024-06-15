package ds2v.TiendaLibros.servicio;

import ds2v.TiendaLibros.modelo.Libro;

import java.util.List;

public interface iLibroServicio {

    public List<Libro> listarlibros();

    public Libro buscarLibroId(Integer idLibro);

    // Uso del metodo para guardar/modificar un libro
    public void guardarLibro(Libro libro);

    public void eliminarLibro(Libro libro);
}
