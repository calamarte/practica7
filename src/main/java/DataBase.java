import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.util.*;


/**
 * Created by Dgarcia on 23/05/2017.
 */
public class DataBase {

    //define conexion
    Connection conn;

    //objeto database para conectar con el servidor
    public DataBase(String server, String database, String username, String password) throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://"+server+"/"+database, username, password);
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    //insertar objeto socio en la base de datos
    public void insertSocio(Object socio) throws Exception {
        Socio s = (Socio) socio;
        String fecha = Util.calendarToString(s.getFechaNa());
        Statement stmt;
        stmt = conn.createStatement();
        stmt.execute("insert into socio (n_socio,nombre,dni,fecha_nacimiento) values (default, '" + s.getNombre() + "', '" + s.getDni() + "', '" + fecha + "');");
        stmt.close();
    }

    //insertar objeto autor en la base de datos
    public void insertAutor(Object autor) throws Exception {
        Autor a = (Autor) autor;
        Statement stmt = conn.createStatement();
        stmt.execute("insert into autor values (default, '" + Util.calendarToString(a.getFecha()) + "'," +
                " '" + a.getNacionalidad() + "', '" + a.getAlias() + "', '" + a.getNombre() + "');");
        stmt.close();
    }

    //insertar objeto libro en la base de datos
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

    //insertar objeto sancion en la base de datos
    public void insertSancion(Object sancion) throws Exception {
        Sancion s = (Sancion) sancion;
        Statement stmt;
        stmt = conn.createStatement();
        stmt.execute("insert into sancion (id,descripcion,fecha,tipo,id_prestamo," +
                "id_libro_prestamo,n_socio_socio_prestamo,usuario_bibliotecario_prestamo)" +
                " values (default, '" + s.getDescripcion() + "', now()," +
                " '" + s.getTipo() + "', '" + s.getPrestamo().getIdPrestamo() + "','" +
                ""+s.getPrestamo().getLibro().getId()+"','"+s.getPrestamo().getSocio().getId()+"'," +
                "'"+s.getPrestamo().getBibliotecario().getUsuario()+"');");
        stmt.close();
    }

    //insertar objeto prestamo en la base de datos
    public void insertPrestamo(Object prestamo) throws Exception {
        Prestamo p =(Prestamo) prestamo;
        Statement stmt;
        stmt = conn.createStatement();
        stmt.execute("insert into prestamo (id,id_libro,n_socio_socio,usuario_bibliotecario,n_copia,fecha_inicial,fecha_final,entregado)" +
                " values (DEFAULT , '" + p.getLibro().getId() + "', '" + p.getSocio().getId() + "'," +
                " '" + Main.bi.getUsuario() + "', '" + p.getnCopia() + "',now(),'"+Util.calendarToString(p.getFechaFinal())+"',FALSE);");
        stmt.close();
    }

    //actualiza campo fecha baja en socio de la base de datos segun la id del objeto socio
    public void deleteSocio(Object socio) throws Exception {
        Socio s = (Socio) socio;
        Statement stmt;
        stmt = conn.createStatement();
        stmt.execute("UPDATE socio SET fecha_baja = now() WHERE n_socio = '"+s.getId()+"';");
        stmt.close();
    }

    //consulta si el usuario bibliotecario existe para hacer login
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

    //devuelve objeto bibliotecario
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
    //devuelve array de socios segun campo de busqueda instroducido
    public Socio[] getSocios(String campo, String key) throws SQLException, ParseException {
        List<Socio> socioList = new ArrayList<Socio>();
        Statement stmt = conn.createStatement();
        ResultSet rs;

        if (campo.equals("Todos")) rs = stmt.executeQuery("SELECT * FROM socio WHERE fecha_baja IS NULL ;");
        else if (campo.equals("Nombre")) rs = stmt.executeQuery("SELECT * FROM socio WHERE nombre = '" + key + "' AND fecha_baja IS NULL ;");
        else if (campo.equals("DNI")) rs = stmt.executeQuery("SELECT * FROM socio WHERE dni = '" + key + "' AND fecha_baja IS NULL ;");
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

    //devuelve array de tematicas
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

    //devuelve array de autores
    public Autor[] getAutores () throws SQLException, ParseException {
        List<Autor> autorList  = new ArrayList<Autor>();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM autor;");

        while (rs.next()){
            autorList.add(new Autor(rs.getInt("id"),rs.getString("nombre"),
                    rs.getString("nacionalidad"),rs.getString("alias"),
                   Util.getCalendarDate(rs.getString("fecha_nacimiento"))));
        }
        rs.close();
        stmt.close();
        Autor[] resultado = new Autor[autorList.size()];
        autorList.toArray(resultado);
        return resultado;
    }

    //devuelve array de libros
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

    //devuelve array de prestamos
    public Prestamo[] getPrestamos() throws SQLException, ParseException {
        List<Prestamo> prestamoList = new ArrayList<Prestamo>();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM socio INNER JOIN prestamo ON " +
                "socio.n_socio = prestamo.n_socio_socio INNER JOIN bibliotecario ON" +
                " prestamo.usuario_bibliotecario = bibliotecario.usuario" +
                " INNER JOIN libro ON prestamo.id_libro = libro.id;");

        while (rs.next()){
            Calendar cSocio = Util.getCalendarDate(rs.getString("socio.fecha_nacimiento"));
            Socio s = new Socio(rs.getInt("socio.n_socio"),rs.getString("socio.nombre"),
                    rs.getString("socio.dni"),cSocio);

            Calendar cBibliotecario = Util.getCalendarDate(rs.getString("fecha_nacimiento"));
            Bibliotecario b = new Bibliotecario(rs.getString("bibliotecario.usuario"),
                    rs.getString("bibliotecario.nombre"),
                    rs.getString("dni"),rs.getString("password"),
                    cBibliotecario);

            Libro l = new Libro(rs.getInt("libro.id"),rs.getString("libro.isbn"),
                    rs.getString("libro.titulo"),rs.getString("libro.portada"),
                    rs.getString("libro.editorial"),rs.getInt("libro.n_paginas"),
                    rs.getString("libro.tipo_tematica"));

            Calendar cPrestamoInicial = Util.getCalendarDate(rs.getString("prestamo.fecha_inicial"));
            Calendar cPrestamoFinal = Util.getCalendarDate(rs.getString("prestamo.fecha_final"));
            prestamoList.add(new Prestamo(rs.getInt("prestamo.id"),cPrestamoInicial,cPrestamoFinal,l,s,b,
                    rs.getInt("n_copia")));
        }

        Prestamo[] resultado = new Prestamo[prestamoList.size()];
        prestamoList.toArray(resultado);
        return resultado;
    }

    //devuelve array de sanciones
    public Sancion[] getSanciones(String nombre) throws SQLException, ParseException {
        List<Sancion> sancionList = new ArrayList<Sancion>();
        Statement smt = conn.createStatement();
        ResultSet rs = smt.executeQuery("SELECT * FROM socio INNER JOIN prestamo ON socio.n_socio = prestamo.n_socio_socio INNER JOIN bibliotecario ON prestamo.usuario_bibliotecario = bibliotecario.usuario\n" +
                "INNER JOIN libro ON prestamo.id_libro = libro.id INNER JOIN sancion ON prestamo.id = sancion.id_prestamo WHERE socio.nombre = '"+nombre+"';");

        while (rs.next()){
            Calendar cSocio = Util.getCalendarDate(rs.getString("socio.fecha_nacimiento"));
            Socio s = new Socio(rs.getInt("socio.n_socio"),rs.getString("socio.nombre"),
                    rs.getString("socio.dni"),cSocio);

            Calendar cBibliotecario = Util.getCalendarDate(rs.getString("fecha_nacimiento"));
            Bibliotecario b = new Bibliotecario(rs.getString("bibliotecario.usuario"),
                    rs.getString("bibliotecario.nombre"),
                    rs.getString("dni"),rs.getString("password"),
                    cBibliotecario);

            Libro l = new Libro(rs.getInt("libro.id"),rs.getString("libro.isbn"),
                    rs.getString("libro.titulo"),rs.getString("libro.portada"),
                    rs.getString("libro.editorial"),rs.getInt("libro.n_paginas"),
                    rs.getString("libro.tipo_tematica"));

            Calendar cPrestamoInicial = Util.getCalendarDate(rs.getString("prestamo.fecha_inicial"));
            Calendar cPrestamoFinal = Util.getCalendarDate(rs.getString("prestamo.fecha_final"));
            Prestamo p = new Prestamo(rs.getInt("prestamo.id"),cPrestamoInicial,cPrestamoFinal,l,s,b,
                    rs.getInt("n_copia"));

            Calendar cSancion = Util.getCalendarDate(rs.getString("sancion.fecha"));
            sancionList.add(new Sancion(rs.getInt("sancion.id"),rs.getString("sancion.descripcion"),
                    cSancion,rs.getString("sancion.tipo"),p));
        }

        Sancion[] resultado = new Sancion[sancionList.size()];
        sancionList.toArray(resultado);
        return resultado;
    }
}