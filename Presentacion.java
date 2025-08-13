import javax.swing.*;
import java.awt.Font;
import java.awt.Color;

public class Presentacion
{
    JFrame ventana;
    JLabel lbl_universidad, lbl_facultad, lbl_carrera, lbl_materia, lbl_profesor, lbl_estudiante, lbl_cedula, lbl_grupo, lbl_fecha;

    Presentacion(JFrame frame)

    {
        ventana = frame;
        ventana.getContentPane().removeAll();
        ventana.setTitle("PRESENTACIÓN DEL PROYECTO");

        lbl_universidad = new JLabel("UNIVERSIDAD TECNOLÓGICA DE PANAMÁ");
        lbl_universidad.setBounds(230, 100, 700, 20);
        lbl_universidad.setHorizontalAlignment(JLabel.CENTER);
        lbl_universidad.setFont(new Font("Arial", Font.BOLD, 18));
        lbl_universidad.setForeground(new Color(255, 255, 255));
        ventana.add(lbl_universidad);

        lbl_facultad = new JLabel("FACULTAD DE INGENIERÍA EN SISTEMAS COMPUTACIONALES");
        lbl_facultad.setBounds(230, 140, 700, 20);
        lbl_facultad.setHorizontalAlignment(JLabel.CENTER);
        lbl_facultad.setFont(new Font("Arial", Font.BOLD, 18));
        lbl_facultad.setForeground(new Color(255, 255, 255));
        ventana.add(lbl_facultad);
 
        lbl_carrera = new JLabel("LICENCIATURA EN DESARROLLO Y GESTIÓN DE SOFTWARE");
        lbl_carrera.setBounds(230, 180, 700, 20);
        lbl_carrera.setHorizontalAlignment(JLabel.CENTER);
        lbl_carrera.setFont(new Font("Arial", Font.BOLD, 18));
        lbl_carrera.setForeground(new Color(255, 255, 255));
        ventana.add(lbl_carrera);

        lbl_materia = new JLabel("DESARROLLO DE SOFTWARE III");
        lbl_materia.setBounds(230, 220, 700, 20);
        lbl_materia.setHorizontalAlignment(JLabel.CENTER);
        lbl_materia.setFont(new Font("Arial", Font.BOLD, 18));
        lbl_materia.setForeground(new Color(255, 255, 255));
        ventana.add(lbl_materia);

        lbl_profesor = new JLabel("RICARDO CHAN");
        lbl_profesor.setBounds(230, 290, 700, 20);
        lbl_profesor.setHorizontalAlignment(JLabel.CENTER);
        lbl_profesor.setFont(new Font("Arial", Font.BOLD, 18));
        lbl_profesor.setForeground(new Color(255, 255, 255));
        ventana.add(lbl_profesor);

        lbl_estudiante = new JLabel("KENNETH CARTER");
        lbl_estudiante.setBounds(230, 340, 700, 20);
        lbl_estudiante.setHorizontalAlignment(JLabel.CENTER);
        lbl_estudiante.setFont(new Font("Arial", Font.BOLD, 18));
        lbl_estudiante.setForeground(new Color(255, 255, 255));
        ventana.add(lbl_estudiante);

        lbl_cedula = new JLabel("8-1001-1227");
        lbl_cedula.setBounds(230, 380, 700, 20);
        lbl_cedula.setHorizontalAlignment(JLabel.CENTER);
        lbl_cedula.setFont(new Font("Arial", Font.BOLD, 18));
        lbl_cedula.setForeground(new Color(255, 255, 255));
        ventana.add(lbl_cedula);

        lbl_grupo = new JLabel("1GS222");
        lbl_grupo.setBounds(230, 420, 700, 20);
        lbl_grupo.setHorizontalAlignment(JLabel.CENTER);
        lbl_grupo.setFont(new Font("Arial", Font.BOLD, 18));
        lbl_grupo.setForeground(new Color(255, 255, 255));
        ventana.add(lbl_grupo);

        lbl_fecha = new JLabel("3 DE AGOSTO DEL 2025");
        lbl_fecha.setBounds(230, 460, 700, 20);
        lbl_fecha.setHorizontalAlignment(JLabel.CENTER);
        lbl_fecha.setFont(new Font("Arial", Font.BOLD, 18));
        lbl_fecha.setForeground(new Color(255, 255, 255));
        ventana.add(lbl_fecha);


        ventana.setVisible(true);
        ventana.repaint();

    }
}



