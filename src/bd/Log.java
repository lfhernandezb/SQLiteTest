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
public class Log {
    private Integer _id_tipo_vehiculo;
    private String _fecha;
    private Integer _id_usuario;
    private Integer _id_vehiculo;
    private Float _latitud;
    private Integer _id_log;
    private Integer _id_modelo;
    private Float _longitud;
    private String _accion;
    private Integer _km;
    private Integer _id_marca;

    private final static String _str_sql = 
        "    SELECT" +
        "    lo.id_tipo_vehiculo AS id_tipo_vehiculo," +
        "    lo.fecha AS fecha," +
        "    lo.id_usuario AS id_usuario," +
        "    lo.id_vehiculo AS id_vehiculo," +
        "    lo.latitud AS latitud," +
        "    lo.id_log AS id_log," +
        "    lo.id_modelo AS id_modelo," +
        "    lo.longitud AS longitud," +
        "    lo.accion AS accion," +
        "    lo.km AS km," +
        "    lo.id_marca AS id_marca" +
        "    FROM log lo";

    public Log() {
        _id_tipo_vehiculo = null;
        _fecha = null;
        _id_usuario = null;
        _id_vehiculo = null;
        _latitud = null;
        _id_log = null;
        _id_modelo = null;
        _longitud = null;
        _accion = null;
        _km = null;
        _id_marca = null;

    }
    /**
     * @return the _id_tipo_vehiculo
     */
    public Integer get_id_tipo_vehiculo() {
        return _id_tipo_vehiculo;
    }
    /**
     * @return the _fecha
     */
    public String get_fecha() {
        return _fecha;
    }
    /**
     * @return the _id_usuario
     */
    public Integer get_id_usuario() {
        return _id_usuario;
    }
    /**
     * @return the _id_vehiculo
     */
    public Integer get_id_vehiculo() {
        return _id_vehiculo;
    }
    /**
     * @return the _latitud
     */
    public Float get_latitud() {
        return _latitud;
    }
    /**
     * @return the _id_log
     */
    public Integer get_id_log() {
        return _id_log;
    }
    /**
     * @return the _id_modelo
     */
    public Integer get_id_modelo() {
        return _id_modelo;
    }
    /**
     * @return the _longitud
     */
    public Float get_longitud() {
        return _longitud;
    }
    /**
     * @return the _accion
     */
    public String get_accion() {
        return _accion;
    }
    /**
     * @return the _km
     */
    public Integer get_km() {
        return _km;
    }
    /**
     * @return the _id_marca
     */
    public Integer get_id_marca() {
        return _id_marca;
    }
    /**
     * @param _id_tipo_vehiculo the _id_tipo_vehiculo to set
     */
    public void set_id_tipo_vehiculo(Integer _id_tipo_vehiculo) {
        this._id_tipo_vehiculo = _id_tipo_vehiculo;
    }
    /**
     * @param _fecha the _fecha to set
     */
    public void set_fecha(String _fecha) {
        this._fecha = _fecha;
    }
    /**
     * @param _id_usuario the _id_usuario to set
     */
    public void set_id_usuario(Integer _id_usuario) {
        this._id_usuario = _id_usuario;
    }
    /**
     * @param _id_vehiculo the _id_vehiculo to set
     */
    public void set_id_vehiculo(Integer _id_vehiculo) {
        this._id_vehiculo = _id_vehiculo;
    }
    /**
     * @param _latitud the _latitud to set
     */
    public void set_latitud(Float _latitud) {
        this._latitud = _latitud;
    }
    /**
     * @param _id_log the _id_log to set
     */
    public void set_id_log(Integer _id_log) {
        this._id_log = _id_log;
    }
    /**
     * @param _id_modelo the _id_modelo to set
     */
    public void set_id_modelo(Integer _id_modelo) {
        this._id_modelo = _id_modelo;
    }
    /**
     * @param _longitud the _longitud to set
     */
    public void set_longitud(Float _longitud) {
        this._longitud = _longitud;
    }
    /**
     * @param _accion the _accion to set
     */
    public void set_accion(String _accion) {
        this._accion = _accion;
    }
    /**
     * @param _km the _km to set
     */
    public void set_km(Integer _km) {
        this._km = _km;
    }
    /**
     * @param _id_marca the _id_marca to set
     */
    public void set_id_marca(Integer _id_marca) {
        this._id_marca = _id_marca;
    }

    public static Log fromRS(ResultSet p_rs) throws SQLException {
        Log ret = new Log();

        ret.set_id_tipo_vehiculo(p_rs.getInt("id_tipo_vehiculo"));
        ret.set_fecha(p_rs.getString("fecha"));
        ret.set_id_usuario(p_rs.getInt("id_usuario"));
        ret.set_id_vehiculo(p_rs.getInt("id_vehiculo"));
        ret.set_latitud(p_rs.getFloat("latitud"));
        ret.set_id_log(p_rs.getInt("id_log"));
        ret.set_id_modelo(p_rs.getInt("id_modelo"));
        ret.set_longitud(p_rs.getFloat("longitud"));
        ret.set_accion(p_rs.getString("accion"));
        ret.set_km(p_rs.getInt("km"));
        ret.set_id_marca(p_rs.getInt("id_marca"));

        return ret;
    }

    public static Log getByParameter(Connection p_conn, String p_key, String p_value) throws SQLException {
        Log ret = null;
        
        String str_sql = _str_sql +
            "  WHERE lo." + p_key + " = " + p_value +
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

    
    public static ArrayList<Log> seek(Connection p_conn, ArrayList<AbstractMap.SimpleEntry<String, String>> p_parameters, String p_order, String p_direction, int p_offset, int p_limit) throws Exception {
        Statement stmt = null;
        ResultSet rs = null;
        String str_sql;
        ArrayList<Log> ret;
        
        str_sql = "";
        
        try {
            ArrayList<String> array_clauses = new ArrayList<String>();
            
            ret = new ArrayList<Log>();
            
            str_sql = _str_sql;
            
            for (AbstractMap.SimpleEntry<String, String> p : p_parameters) {
                if (p.getKey().equals("id_usuario")) {
                    array_clauses.add("lo.id_usuario = " + p.getValue());
                }
                else if (p.getKey().equals("id_log")) {
                    array_clauses.add("lo.id_log = " + p.getValue());
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
            "    UPDATE log" +
            "    SET" +
            "    id_tipo_vehiculo = " + (_id_tipo_vehiculo != null ? _id_tipo_vehiculo : "null") + "," +
            "    fecha = " + (_fecha != null ? "'" + _fecha + "'" : "null") + "," +
            "    id_vehiculo = " + (_id_vehiculo != null ? _id_vehiculo : "null") + "," +
            "    latitud = " + (_latitud != null ? _latitud : "null") + "," +
            "    id_modelo = " + (_id_modelo != null ? _id_modelo : "null") + "," +
            "    longitud = " + (_longitud != null ? _longitud : "null") + "," +
            "    accion = " + (_accion != null ? "'" + _accion + "'" : "null") + "," +
            "    km = " + (_km != null ? _km : "null") + "," +
            "    id_marca = " + (_id_marca != null ? _id_marca : "null") +
            "    WHERE" +
            "    id_usuario = " + Integer.toString(this._id_usuario) + " AND" +
            "    id_log = " + Integer.toString(this._id_log);

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
            "    INSERT INTO log" +
            "    (" +
            "    id_tipo_vehiculo, " +
            "    id_usuario, " +
            "    id_vehiculo, " +
            "    latitud, " +
            "    id_log, " +
            "    id_modelo, " +
            "    longitud, " +
            "    accion, " +
            "    km, " +
            "    id_marca)" +
            "    VALUES" +
            "    (" +
            "    " + (_id_tipo_vehiculo != null ? "'" + _id_tipo_vehiculo + "'" : "null") + "," +
            "    " + (_id_usuario != null ? "'" + _id_usuario + "'" : "null") + "," +
            "    " + (_id_vehiculo != null ? "'" + _id_vehiculo + "'" : "null") + "," +
            "    " + (_latitud != null ? "'" + _latitud + "'" : "null") + "," +
            "    " + (_id_log != null ? "'" + _id_log + "'" : "null") + "," +
            "    " + (_id_modelo != null ? "'" + _id_modelo + "'" : "null") + "," +
            "    " + (_longitud != null ? "'" + _longitud + "'" : "null") + "," +
            "    " + (_accion != null ? "'" + _accion + "'" : "null") + "," +
            "    " + (_km != null ? "'" + _km + "'" : "null") + "," +
            "    " + (_id_marca != null ? "'" + _id_marca + "'" : "null") +
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
            "    DELETE FROM log" +
            "    WHERE" +
            "    id_usuario = " + Integer.toString(this._id_usuario) + " AND" +
            "    id_log = " + Integer.toString(this._id_log);

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
