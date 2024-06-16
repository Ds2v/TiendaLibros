package ds2v.TiendaLibros.servicio;

import ds2v.TiendaLibros.modelo.Libro;
import ds2v.TiendaLibros.repositorio.LibroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroServicio implements iLibroServicio{

    @Autowired
    LibroRepositorio libroRepositorio;


    @Override
    public List<Libro> listarlibros() {
        List<Libro> libros = libroRepositorio.findAll();
        return libros;
    }

    @Override
    public Libro buscarLibroId(Integer idLibro) {
        Libro libro = libroRepositorio.findById(idLibro).orElse(null);
        return libro;
    }

    @Override
    public void guardarLibro(Libro libro) {
        libroRepositorio.save(libro);
    }

    @Override
    public void eliminarLibro(Libro libro) {
        libroRepositorio.delete(libro);
    }
}
