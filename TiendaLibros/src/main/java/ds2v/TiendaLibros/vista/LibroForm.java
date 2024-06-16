package ds2v.TiendaLibros.vista;

import ds2v.TiendaLibros.servicio.LibroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class LibroForm extends JFrame{
    private JPanel panel;
    LibroServicio libroServicio;

    @Autowired
    public LibroForm(LibroServicio libroServicio){
        this.libroServicio = libroServicio;
        iniciaForma();
    }

    public void iniciaForma(){
        setContentPane(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(900,700);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension tamanioPantalla = toolkit.getScreenSize();
        int x = (tamanioPantalla.width - getWidth()/ 2);
        int y = (tamanioPantalla.height - getHeight() / 2);
        setLocation(x, y);
    }
}