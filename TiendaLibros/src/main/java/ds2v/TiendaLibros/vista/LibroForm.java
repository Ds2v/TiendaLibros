package ds2v.TiendaLibros.vista;

import ds2v.TiendaLibros.servicio.LibroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Component
public class LibroForm extends JFrame{
    private JPanel panel;
    private JTable tablaLibros;
    private JTextField textoLibro;
    private JTextField textoAutor;
    private JTextField textoValor;
    private JTextField textoExistencias;
    private JButton guardarButton;
    private JButton modificarButton;
    private JButton eliminarButton;
    private DefaultTableModel tablaModeloLibros;
    LibroServicio libroServicio;

    @Autowired
    public LibroForm(LibroServicio libroServicio){
        this.libroServicio = libroServicio;
        iniciaForma();
        guardarButton.addActionListener(e -> {

        });
    }

    private void iniciaForma(){
        setContentPane(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(900,600);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension tamanioPantalla = toolkit.getScreenSize();
        int x = (tamanioPantalla.width - getWidth()/ 2);
        int y = (tamanioPantalla.height - getHeight() / 2);
        setLocation(x, y);
        mostrarLibros();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        this.tablaModeloLibros = new DefaultTableModel(0,5);
        String[] cabeceros = {"Id", "Libro", "Autor", "Valor", "Existencias"};
        this.tablaModeloLibros.setColumnIdentifiers(cabeceros);
        this.tablaLibros = new JTable(tablaModeloLibros);
    }

    private void mostrarLibros(){
        // Limpiar la tabla antes de mostrarla
        tablaModeloLibros.setRowCount(0);
        // Obtener los libros
        var libros = libroServicio.listarlibros();
        libros.forEach((libro) -> {
            Object[] reglonLibro = {
                   libro.getIdLibro(),
                   libro.getNombreLibro(),
                   libro.getAutor(),
                   libro.getValor(),
                   libro.getExistencias()
            };
            this.tablaModeloLibros.addRow(reglonLibro);
        });
    }
}