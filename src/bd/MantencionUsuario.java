/**
 * 
 */
package bd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.AbstractMap;
import java.util.ArrayList;

/**
 * @author petete-ntbk
 *
 */
public class MantencionUsuario {
    private Integer _KmEntreMantenciones;
    private String _descripcion;
    private Integer _id_mantencion_usuario;
    private String _mantencion_usuariocol;
    private String _DependeKm;
    private Integer _mantecion_base;
    private String _nombre;
    private String _MantencionUsuariocol;
    private String _fecha_modificacion;
    private Integer _id_usuario;
    private Integer _id_mantencion_base;
    private Integer _id_vehiculo;
    private Integer _DiasEntreMantenciones;
    private String _URL;
    private String _beneficios;

    private final static String _str_sql = 
        "    SELECT" +
        "    ma.KmEntreMantenciones AS KmEntreMantenciones," +
        "    ma.descripcion AS descripcion," +
        "    ma.id_mantencion_usuario AS id_mantencion_usuario," +
        "    ma.mantencion_usuariocol AS mantencion_usuariocol," +
        "    ma.DependeKm AS DependeKm," +
        "    ma.mantecion_base AS mantecion_base," +
        "    ma.nombre AS nombre," +
        "    ma.MantencionUsuariocol AS MantencionUsuariocol," +
        "    ma.fecha_modificacion AS fecha_modificacion," +
        "    ma.id_usuario AS id_usuario," +
        "    ma.id_mantencion_base AS id_mantencion_base," +
        "    ma.id_vehiculo AS id_vehiculo," +
        "    ma.DiasEntreMantenciones AS DiasEntreMantenciones," +
        "    ma.URL AS URL," +
        "    ma.beneficios AS beneficios" +
        "    FROM mantencion_usuario ma";

    public MantencionUsuario() {
        _KmEntreMantenciones = null;
        _descripcion = null;
        _id_mantencion_usuario = null;
        _mantencion_usuariocol = null;
        _DependeKm = null;
        _mantecion_base = null;
        _nombre = null;
        _MantencionUsuariocol = null;
        _fecha_modificacion = null;
        _id_usuario = null;
        _id_mantencion_base = null;
        _id_vehiculo = null;
        _DiasEntreMantenciones = null;
        _URL = null;
        _beneficios = null;

    }
    /**
     * @return the _KmEntreMantenciones
     */
    public Integer get_KmEntreMantenciones() {
        return _KmEntreMantenciones;
    }
    /**
     * @return the _descripcion
     */
    public String get_descripcion() {
        return _descripcion;
    }
    /**
     * @return the _id_mantencion_usuario
     */
    public Integer get_id_mantencion_usuario() {
        return _id_mantencion_usuario;
    }
    /**
     * @return the _mantencion_usuariocol
     */
    public String get_mantencion_usuariocol() {
        return _mantencion_usuariocol;
    }
    /**
     * @return the _DependeKm
     */
    public String get_DependeKm() {
        return _DependeKm;
    }
    /**
     * @return the _mantecion_base
     */
    public Integer get_mantecion_base() {
        return _mantecion_base;
    }
    /**
     * @return the _nombre
     */
    public String get_nombre() {
        return _nombre;
    }
    /**
     * @return the _MantencionUsuariocol
     */
    public String get_MantencionUsuariocol() {
        return _MantencionUsuariocol;
    }
    /**
     * @return the _fecha_modificacion
     */
    public String get_fecha_modificacion() {
        return _fecha_modificacion;
    }
    /**
     * @return the _id_usuario
     */
    public Integer get_id_usuario() {
        return _id_usuario;
    }
    /**
     * @return the _id_mantencion_base
     */
    public Integer get_id_mantencion_base() {
        return _id_mantencion_base;
    }
    /**
     * @return the _id_vehiculo
     */
    public Integer get_id_vehiculo() {
        return _id_vehiculo;
    }
    /**
     * @return the _DiasEntreMantenciones
     */
    public Integer get_DiasEntreMantenciones() {
        return _DiasEntreMantenciones;
    }
    /**
     * @return the _URL
     */
    public String get_URL() {
        return _URL;
    }
    /**
     * @return the _beneficios
     */
    public String get_beneficios() {
        return _beneficios;
    }
    /**
     * @param _KmEntreMantenciones the _KmEntreMantenciones to set
     */
    public void set_KmEntreMantenciones(Integer _KmEntreMantenciones) {
        this._KmEntreMantenciones = _KmEntreMantenciones;
    }
    /**
     * @param _descripcion the _descripcion to set
     */
    public void set_descripcion(String _descripcion) {
        this._descripcion = _descripcion;
    }
    /**
     * @param _id_mantencion_usuario the _id_mantencion_usuario to set
     */
    public void set_id_mantencion_usuario(Integer _id_mantencion_usuario) {
        this._id_mantencion_usuario = _id_mantencion_usuario;
    }
    /**
     * @param _mantencion_usuariocol the _mantencion_usuariocol to set
     */
    public void set_mantencion_usuariocol(String _mantencion_usuariocol) {
        this._mantencion_usuariocol = _mantencion_usuariocol;
    }
    /**
     * @param _DependeKm the _DependeKm to set
     */
    public void set_DependeKm(String _DependeKm) {
        this._DependeKm = _DependeKm;
    }
    /**
     * @param _mantecion_base the _mantecion_base to set
     */
    public void set_mantecion_base(Integer _mantecion_base) {
        this._mantecion_base = _mantecion_base;
    }
    /**
     * @param _nombre the _nombre to set
     */
    public void set_nombre(String _nombre) {
        this._nombre = _nombre;
    }
    /**
     * @param _MantencionUsuariocol the _MantencionUsuariocol to set
     */
    public void set_MantencionUsuariocol(String _MantencionUsuariocol) {
        this._MantencionUsuariocol = _MantencionUsuariocol;
    }
    /**
     * @param _fecha_modificacion the _fecha_modificacion to set
     */
    public void set_fecha_modificacion(String _fecha_modificacion) {
        this._fecha_modificacion = _fecha_modificacion;
    }
    /**
     * @param _id_usuario the _id_usuario to set
     */
    public void set_id_usuario(Integer _id_usuario) {
        this._id_usuario = _id_usuario;
    }
    /**
     * @param _id_mantencion_base the _id_mantencion_base to set
     */
    public void set_id_mantencion_base(Integer _id_mantencion_base) {
        this._id_mantencion_base = _id_mantencion_base;
    }
    /**
     * @param _id_vehiculo the _id_vehiculo to set
     */
    public void set_id_vehiculo(Integer _id_vehiculo) {
        this._id_vehiculo = _id_vehiculo;
    }
    /**
     * @param _DiasEntreMantenciones the _DiasEntreMantenciones to set
     */
    public void set_DiasEntreMantenciones(Integer _DiasEntreMantenciones) {
        this._DiasEntreMantenciones = _DiasEntreMantenciones;
    }
    /**
     * @param _URL the _URL to set
     */
    public void set_URL(String _URL) {
        this._URL = _URL;
    }
    /**
     * @param _beneficios the _beneficios to set
     */
    public void set_beneficios(String _beneficios) {
        this._beneficios = _beneficios;
    }

    public static MantencionUsuario fromRS(ResultSet p_rs) throws SQLException {
        MantencionUsuario ret = new MantencionUsuario();

        ret.set_KmEntreMantenciones(p_rs.getInt("KmEntreMantenciones"));
        ret.set_descripcion(p_rs.getString("descripcion"));
        ret.set_id_mantencion_usuario(p_rs.getInt("id_mantencion_usuario"));
        ret.set_mantencion_usuariocol(p_rs.getString("mantencion_usuariocol"));
        ret.set_DependeKm(p_rs.getString("DependeKm"));
        ret.set_mantecion_base(p_rs.getInt("mantecion_base"));
        ret.set_nombre(p_rs.getString("nombre"));
        ret.set_MantencionUsuariocol(p_rs.getString("MantencionUsuariocol"));
        ret.set_fecha_modificacion(p_rs.getString("fecha_modificacion"));
        ret.set_id_usuario(p_rs.getInt("id_usuario"));
        ret.set_id_mantencion_base(p_rs.getInt("id_mantencion_base"));
        ret.set_id_vehiculo(p_rs.getInt("id_vehiculo"));
        ret.set_DiasEntreMantenciones(p_rs.getInt("DiasEntreMantenciones"));
        ret.set_URL(p_rs.getString("URL"));
        ret.set_beneficios(p_rs.getString("beneficios"));

        return ret;
    }

    public static MantencionUsuario getByParameter(Connection p_conn, String p_key, String p_value) throws SQLException {
        MantencionUsuario ret = null;
        
        String str_sql = _str_sql +
            "  WHERE ma." + p_key + " = " + p_value +
            "  LIMIT 0, 1";
        
        //System.out.println(str_sql);
        
        // assume that conn is an already created JDBC connection (see previous examples)
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = p_conn.createStatement();
            //System.out.println("stmt = p_conn.createStatement() ok");
            rs = stmt.executeQuery(str_sql);
            //System.out.println("rs = stmt.executeQuery(str_sql) ok");

            // Now do something with the ResultSet ....
            
            if (rs.next()) {
                //System.out.println("rs.next() ok");
                ret = fromRS(rs);
                //System.out.println("fromRS(rs) ok");
            }
        }
        catch (SQLException ex){
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage() + " sentencia: " + str_sql);
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            
            throw ex;
        }
        finally {
            // it is a good idea to release
            // resources in a finally{} block
            // in reverse-order of their creation
            // if they are no-longer needed
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) { 
                    
                } // ignore
                rs = null;
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) {
                    
                } // ignore
                stmt = null;
            }
        }        
        
        return ret;        
    }

    
    public static ArrayList<MantencionUsuario> seek(Connection p_conn, ArrayList<AbstractMap.SimpleEntry<String, String>> p_parameters, String p_order, String p_direction, int p_offset, int p_limit) throws Exception {
        Statement stmt = null;
        ResultSet rs = null;
        String str_sql;
        ArrayList<MantencionUsuario> ret;
        
        str_sql = "";
        
        try {
            ArrayList<String> array_clauses = new ArrayList<String>();
            
            ret = new ArrayList<MantencionUsuario>();
            
            str_sql = _str_sql;
            
            for (AbstractMap.SimpleEntry<String, String> p : p_parameters) {
                if (p.getKey().equals("id_usuario")) {
                    array_clauses.add("ma.id_usuario = " + p.getValue());
                }
                else if (p.getKey().equals("id_mantencion_usuario")) {
                    array_clauses.add("ma.id_mantencion_usuario = " + p.getValue());
                }
                else if (p.getKey().equals("id_usuario")) {
                    array_clauses.add("ma.id_usuario = " + p.getValue());
                }
                else if (p.getKey().equals("id_vehiculo")) {
                    array_clauses.add("ma.id_vehiculo = " + p.getValue());
                }
                else if (p.getKey().equals("mas reciente")) {
                    array_clauses.add("ma.fecha_modificacion > '" + p.getValue() + "'");
                }
                else {
                    throw new Exception("Parametro no soportado: " + p.getKey());
                }
            }
                                
            boolean bFirstTime = false;
            
            for(String clause : array_clauses) {
                if (!bFirstTime) {
                     bFirstTime = true;
                     str_sql += " WHERE ";
                }
                else {
                     str_sql += " AND ";
                }
                str_sql += clause;
            }
            
            if (p_order != null && p_direction != null) {
                str_sql += " ORDER BY " + p_order + " " + p_direction;
            }
            
            if (p_offset != -1 && p_limit != -1) {
                str_sql += "  LIMIT " +  Integer.toString(p_offset) + ", " + Integer.toString(p_limit);
            }
            
            //echo "<br>" . str_sql . "<br>";
        
            stmt = p_conn.createStatement();
            
            rs = stmt.executeQuery(str_sql);
            
            while (rs.next()) {
                ret.add(fromRS(rs));
            }
            /*
            if (ret.size() == 0) {
                ret = null;
            }
            */
        }
        catch (SQLException ex){
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage() + " sentencia: " + str_sql);
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            
            throw ex;
        }
        catch (Exception ex) {
            throw ex;
        }
        finally {
            // it is a good idea to release
            // resources in a finally{} block
            // in reverse-order of their creation
            // if they are no-longer needed
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) { 
                    
                } // ignore
                rs = null;
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) {
                    
                } // ignore
                stmt = null;
            }
        }        

        return ret;
    }

    public int update(Connection p_conn) throws SQLException {

        int ret = -1;
        Statement stmt = null;

        String str_sql =
            "    UPDATE mantencion_usuario" +
            "    SET" +
            "    KmEntreMantenciones = " + (_KmEntreMantenciones != null ? _KmEntreMantenciones : "null") + "," +
            "    descripcion = " + (_descripcion != null ? "'" + _descripcion + "'" : "null") + "," +
            "    mantencion_usuariocol = " + (_mantencion_usuariocol != null ? "'" + _mantencion_usuariocol + "'" : "null") + "," +
            "    DependeKm = " + (_DependeKm != null ? "'" + _DependeKm + "'" : "null") + "," +
            "    mantecion_base = " + (_mantecion_base != null ? _mantecion_base : "null") + "," +
            "    nombre = " + (_nombre != null ? "'" + _nombre + "'" : "null") + "," +
            "    MantencionUsuariocol = " + (_MantencionUsuariocol != null ? "'" + _MantencionUsuariocol + "'" : "null") + "," +
            "    fecha_modificacion = " + (_fecha_modificacion != null ? "'" + _fecha_modificacion + "'" : "null") + "," +
            "    id_mantencion_base = " + (_id_mantencion_base != null ? _id_mantencion_base : "null") + "," +
            "    DiasEntreMantenciones = " + (_DiasEntreMantenciones != null ? _DiasEntreMantenciones : "null") + "," +
            "    URL = " + (_URL != null ? "'" + _URL + "'" : "null") + "," +
            "    beneficios = " + (_beneficios != null ? "'" + _beneficios + "'" : "null") +
            "    WHERE" +
            "    id_usuario = " + Integer.toString(this._id_usuario) + " AND" +
            "    id_mantencion_usuario = " + Integer.toString(this._id_mantencion_usuario);

        try {
            stmt = p_conn.createStatement();
            
            ret = stmt.executeUpdate(str_sql);
            /*
            if (stmt.executeUpdate(str_sql) < 1) {
                throw new Exception("No hubo filas afectadas");
            }
            */
            
        }
        catch (SQLException ex){
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage() + " sentencia: " + str_sql);
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            
            throw ex;
        }
        finally {
            // it is a good idea to release
            // resources in a finally{} block
            // in reverse-order of their creation
            // if they are no-longer needed
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) {
                    
                } // ignore
                stmt = null;
            }
        }
        
        return ret;
    }
    
    public int insert(Connection p_conn) throws SQLException {
        
        int ret = -1;
        Statement stmt = null;
        ResultSet rs = null;

        String str_sql =
            "    INSERT INTO mantencion_usuario" +
            "    (" +
            "    KmEntreMantenciones, " +
            "    descripcion, " +
            "    id_mantencion_usuario, " +
            "    mantencion_usuariocol, " +
            "    DependeKm, " +
            "    mantecion_base, " +
            "    nombre, " +
            "    MantencionUsuariocol, " +
            "    id_usuario, " +
            "    id_mantencion_base, " +
            "    id_vehiculo, " +
            "    DiasEntreMantenciones, " +
            "    URL, " +
            "    beneficios)" +
            "    VALUES" +
            "    (" +
            "    " + (_KmEntreMantenciones != null ? "'" + _KmEntreMantenciones + "'" : "null") + "," +
            "    " + (_descripcion != null ? "'" + _descripcion + "'" : "null") + "," +
            "    " + (_id_mantencion_usuario != null ? "'" + _id_mantencion_usuario + "'" : "null") + "," +
            "    " + (_mantencion_usuariocol != null ? "'" + _mantencion_usuariocol + "'" : "null") + "," +
            "    " + (_DependeKm != null ? "'" + _DependeKm + "'" : "null") + "," +
            "    " + (_mantecion_base != null ? "'" + _mantecion_base + "'" : "null") + "," +
            "    " + (_nombre != null ? "'" + _nombre + "'" : "null") + "," +
            "    " + (_MantencionUsuariocol != null ? "'" + _MantencionUsuariocol + "'" : "null") + "," +
            "    " + (_id_usuario != null ? "'" + _id_usuario + "'" : "null") + "," +
            "    " + (_id_mantencion_base != null ? "'" + _id_mantencion_base + "'" : "null") + "," +
            "    " + (_id_vehiculo != null ? "'" + _id_vehiculo + "'" : "null") + "," +
            "    " + (_DiasEntreMantenciones != null ? "'" + _DiasEntreMantenciones + "'" : "null") + "," +
            "    " + (_URL != null ? "'" + _URL + "'" : "null") + "," +
            "    " + (_beneficios != null ? "'" + _beneficios + "'" : "null") +
            "    )";
        
        try {
            stmt = p_conn.createStatement();
            
            ret = stmt.executeUpdate(str_sql);

        }
        catch (SQLException ex){
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage() + " sentencia: " + str_sql);
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            
            throw ex;
        }
        finally {
            // it is a good idea to release
            // resources in a finally{} block
            // in reverse-order of their creation
            // if they are no-longer needed
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) { 
                    
                } // ignore
                rs = null;
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) {
                    
                } // ignore
                stmt = null;
            }
        }
        
        return ret;
    }

    public int delete(Connection p_conn) throws SQLException {

        int ret = -1;
        Statement stmt = null;

        String str_sql =
            "    DELETE FROM mantencion_usuario" +
            "    WHERE" +
            "    id_usuario = " + Integer.toString(this._id_usuario) + " AND" +
            "    id_mantencion_usuario = " + Integer.toString(this._id_mantencion_usuario);

        try {
            stmt = p_conn.createStatement();
            
            ret = stmt.executeUpdate(str_sql);
        }
        catch (SQLException ex){
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage() + " sentencia: " + str_sql);
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            
            throw ex;
        }
        finally {
            // it is a good idea to release
            // resources in a finally{} block
            // in reverse-order of their creation
            // if they are no-longer needed
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) {
                    
                } // ignore
                stmt = null;
            }
        }
        
        return ret;
    }
}
