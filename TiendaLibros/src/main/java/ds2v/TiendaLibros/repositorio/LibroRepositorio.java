package ds2v.TiendaLibros.repositorio;

import ds2v.TiendaLibros.modelo.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepositorio extends JpaRepository<Libro, Integer> {
}
