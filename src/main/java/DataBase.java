import java.security.MessageDigest;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


/**
 * Created by Dgarcia on 23/05/2017.
 */
public class DataBase {
    String servidor;
    String usuario;
    String passwd;
    Connection conn;

    public DataBase(String server, String username, String password) throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/practica", username, password);
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    public void insertSocio(Object socio) throws Exception {
        Socio s = (Socio) socio;
        String fecha = Util.calendarToString(s.getFechaNa());
        Statement stmt;
        stmt = conn.createStatement();
        stmt.execute("insert into socio (n_socio,nombre,dni,fecha_nacimiento) values (default, '" + s.getNombre() + "', '" + s.getDni() + "', '" + fecha + "');");
        stmt.close();
    }

    public void InsertAutor(Date fecha, String nacionalidad, String alias, String nombre) throws Exception {
        Statement stmt;

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String fechaStr = formatter.format(fecha);

        stmt = conn.createStatement();
        stmt.execute("insert into autor values (default, '" + fechaStr + "', '" + nacionalidad + "', '" + alias + "', '" + nombre + "');");
        stmt.close();
    }

    public void insertLibro(Object libro, Object autor) throws Exception {
        Libro l = (Libro) libro;
        Autor a = (Autor) autor;
        Statement stmt;
        stmt = conn.createStatement();
        stmt.execute("insert into libro (id,isbn,titulo,portada,editorial,n_paginas,tipo_tematica) values (default," +
                " '" + l.getIsbn() + "', '" + l.getTitulo() + "','" + l.getPortada() + "', '" + l.getEditorial() + "'," +
                " '" + l.getPaginas() + "', '" + l.getTematica() + "');");

        stmt.execute("INSERT INTO libro_autor (id_libro,id_autor) VALUES ((SELECT MAX(id) FROM libro),"+a.getId()+ ");");
        stmt.close();
    }

    public void InsertSancion(String descripcion, String fecha, String tipo, String prestamo) throws Exception {
        Statement stmt;
        stmt = conn.createStatement();
        stmt.execute("insert into sancion values (default, '" + descripcion + "', '" + fecha + "', '" + tipo + "', '" + prestamo + "');");
        stmt.close();
    }

    public void insertPrestamo(Object prestamo) throws Exception {
        Prestamo p =(Prestamo) prestamo;

        Statement stmt;
        stmt = conn.createStatement();
        stmt.execute("insert into prestamo (id,id_libro,n_socio_socio,usuario_bibliotecario,n_copia,fecha_inicial,fecha_final)" +
                " values (DEFAULT , '" + p.getLibro().getId() + "', '" + p.getSocio().getId() + "'," +
                " '" + Main.bi.getUsuario() + "', '" + p.getnCopia() + "',now(),'"+Util.calendarToString(p.getFechaFinal())+"');");
        stmt.close();
    }

    public void DeleteAutor(int id) throws Exception {
        Statement stmt;
        stmt = conn.createStatement();
        stmt.close();
    }

    public void DeleteLibro(int id) throws Exception {
        Statement stmt;
        stmt = conn.createStatement();
        stmt.close();
    }

    public void DeletePrestamo(int id) throws Exception {
        Statement stmt;
        stmt = conn.createStatement();
        stmt.close();
    }

    public void DeleteSancion(int id) throws Exception {
        Statement stmt;
        stmt = conn.createStatement();
        stmt.close();
    }

    public void DeleteSocio(int id) throws Exception {
        Statement stmt;
        stmt = conn.createStatement();
        stmt.close();
    }

    public boolean login(String bibliotecario, String password) {
        try {
            Statement stmt;
            ResultSet rs;
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM bibliotecario where usuario = '" + bibliotecario + "' and password = md5('" + password + "');");
            if (rs.next()) return true;
            else throw new Exception();
        } catch (Exception e) {
            return false;
        }

    }

    public Bibliotecario getBibliotecario(String usuario,String passwd) throws SQLException, ParseException {
        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM bibliotecario WHERE usuario = '"+usuario+"' AND " +
                "password = MD5('"+passwd+"');");
        rs.next();
        Bibliotecario bi = new Bibliotecario(rs.getString("usuario"),rs.getString("nombre"),
                rs.getString("dni"),rs.getString("password"),
                Util.getCalendarDate(rs.getString("fecha_nacimiento")));
        stmt.close();
        return bi;
    }

    public Socio[] getSocios(String campo, String key) throws SQLException, ParseException {
        List<Socio> socioList = new ArrayList<Socio>();
        Statement stmt = conn.createStatement();
        ResultSet rs;


        if (campo.equals("Todos")) rs = stmt.executeQuery("SELECT * FROM socio;");
        else if (campo.equals("Nombre")) rs = stmt.executeQuery("SELECT * FROM socio WHERE nombre = '" + key + "' ;");
        else if (campo.equals("DNI")) rs = stmt.executeQuery("SELECT * FROM socio WHERE dni = '" + key + "';");
        else if (campo.equals("Fecha de Nacimiento"))
            rs = stmt.executeQuery("SELECT * FROM socio WHERE fecha_nacimiento = '" + key + "';");
        else return null;

        while (rs.next()) {
            Socio s = new Socio(rs.getInt("n_socio"), rs.getString("nombre"), rs.getString("dni"),
                   Util.getCalendarDate(rs.getString("fecha_nacimiento")));
            socioList.add(s);
        }
        rs.close();
        stmt.close();
        Socio resultado[] = new Socio[socioList.size()];
        socioList.toArray(resultado);
        return resultado;
    }

    public Tematica[] getTematicas () throws SQLException {
        List<Tematica> tematicaList  = new ArrayList<Tematica>();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM tematica;");

        while (rs.next()){
            tematicaList.add(new Tematica(rs.getString("tipo")));
        }
        rs.close();
        stmt.close();
        Tematica resultado[] = new Tematica[tematicaList.size()];
        tematicaList.toArray(resultado);
        return resultado;
    }

    public Autor[] getAutores () throws SQLException {
        List<Autor> autorList  = new ArrayList<Autor>();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM autor;");

        while (rs.next()){
            autorList.add(new Autor(rs.getInt("id"),rs.getString("nombre"),
                    rs.getString("nacionalidad"),rs.getString("alias"),
                    rs.getString("fecha_nacimiento")));
        }
        rs.close();
        stmt.close();
        Autor[] resultado = new Autor[autorList.size()];
        autorList.toArray(resultado);
        return resultado;
    }

    public Libro[] getLibros() throws SQLException {
        List<Libro> libroList = new ArrayList<Libro>();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM libro;");

        while (rs.next()){
            libroList.add(new Libro(rs.getInt("id"),rs.getString("isbn"),
                    rs.getString("titulo"),rs.getString("portada"),
                    rs.getString("editorial"),rs.getInt("n_paginas"),
                    rs.getString("tipo_tematica")));
        }
        rs.close();
        stmt.close();
        Libro[] resultado = new Libro[libroList.size()];
        libroList.toArray(resultado);
        return resultado;
    }
}
