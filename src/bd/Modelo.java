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
public class Modelo {
    private String _descripcion;
    private Integer _id_tipo_vehiculo;
    private String _fecha_modificacion;
    private Integer _id;
    private Integer _id_marca;

    private final static String _str_sql = 
        "    SELECT" +
        "    mo.descripcion AS descripcion," +
        "    mo.id_tipo_vehiculo AS id_tipo_vehiculo," +
        "    mo.fecha_modificacion AS fecha_modificacion," +
        "    mo.id_modelo AS id," +
        "    mo.id_marca AS id_marca" +
        "    FROM modelo mo";

    public Modelo() {
        _descripcion = null;
        _id_tipo_vehiculo = null;
        _fecha_modificacion = null;
        _id = null;
        _id_marca = null;

    }
    /**
     * @return the _descripcion
     */
    public String get_descripcion() {
        return _descripcion;
    }
    /**
     * @return the _id_tipo_vehiculo
     */
    public Integer get_id_tipo_vehiculo() {
        return _id_tipo_vehiculo;
    }
    /**
     * @return the _fecha_modificacion
     */
    public String get_fecha_modificacion() {
        return _fecha_modificacion;
    }
    /**
     * @return the _id
     */
    public Integer get_id() {
        return _id;
    }
    /**
     * @return the _id_marca
     */
    public Integer get_id_marca() {
        return _id_marca;
    }
    /**
     * @param _descripcion the _descripcion to set
     */
    public void set_descripcion(String _descripcion) {
        this._descripcion = _descripcion;
    }
    /**
     * @param _id_tipo_vehiculo the _id_tipo_vehiculo to set
     */
    public void set_id_tipo_vehiculo(Integer _id_tipo_vehiculo) {
        this._id_tipo_vehiculo = _id_tipo_vehiculo;
    }
    /**
     * @param _fecha_modificacion the _fecha_modificacion to set
     */
    public void set_fecha_modificacion(String _fecha_modificacion) {
        this._fecha_modificacion = _fecha_modificacion;
    }
    /**
     * @param _id the _id to set
     */
    public void set_id(Integer _id) {
        this._id = _id;
    }
    /**
     * @param _id_marca the _id_marca to set
     */
    public void set_id_marca(Integer _id_marca) {
        this._id_marca = _id_marca;
    }

    public static Modelo fromRS(ResultSet p_rs) throws SQLException {
        Modelo ret = new Modelo();

        ret.set_descripcion(p_rs.getString("descripcion"));
        ret.set_id_tipo_vehiculo(p_rs.getInt("id_tipo_vehiculo"));
        ret.set_fecha_modificacion(p_rs.getString("fecha_modificacion"));
        ret.set_id(p_rs.getInt("id"));
        ret.set_id_marca(p_rs.getInt("id_marca"));

        return ret;
    }

    public static Modelo getByParameter(Connection p_conn, String p_key, String p_value) throws SQLException {
        Modelo ret = null;
        
        String str_sql = _str_sql +
            "  WHERE mo." + p_key + " = " + p_value +
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

    public static Modelo getById(Connection p_conn, String p_id) throws Exception {
        return getByParameter(p_conn, "id_modelo", p_id);
    }
    
    public static ArrayList<Modelo> seek(Connection p_conn, ArrayList<AbstractMap.SimpleEntry<String, String>> p_parameters, String p_order, String p_direction, int p_offset, int p_limit) throws Exception {
        Statement stmt = null;
        ResultSet rs = null;
        String str_sql;
        ArrayList<Modelo> ret;
        
        str_sql = "";
        
        try {
            ArrayList<String> array_clauses = new ArrayList<String>();
            
            ret = new ArrayList<Modelo>();
            
            str_sql = _str_sql;
            
            for (AbstractMap.SimpleEntry<String, String> p : p_parameters) {
                if (p.getKey().equals("id_modelo")) {
                    array_clauses.add("mo.id_modelo = " + p.getValue());
                }
                else if (p.getKey().equals("id_tipo_vehiculo")) {
                    array_clauses.add("mo.id_tipo_vehiculo = " + p.getValue());
                }
                else if (p.getKey().equals("id_marca")) {
                    array_clauses.add("mo.id_marca = " + p.getValue());
                }
                else if (p.getKey().equals("mas reciente")) {
                    array_clauses.add("mo.fecha_modificacion > '" + p.getValue() + "'");
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
            "    UPDATE modelo" +
            "    SET" +
            "    descripcion = " + (_descripcion != null ? "'" + _descripcion + "'" : "null") + "," +
            "    fecha_modificacion = " + (_fecha_modificacion != null ? "'" + _fecha_modificacion + "'" : "null") +
            "    WHERE" +
            "    id_modelo = " + Integer.toString(this._id);

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
            "    INSERT INTO modelo" +
            "    (" +
            "    descripcion, " +
            "    id_tipo_vehiculo, " +
            "    id_modelo, " +
            "    id_marca)" +
            "    VALUES" +
            "    (" +
            "    " + (_descripcion != null ? "'" + _descripcion + "'" : "null") + "," +
            "    " + (_id_tipo_vehiculo != null ? "'" + _id_tipo_vehiculo + "'" : "null") + "," +
            "    " + (_id != null ? "'" + _id + "'" : "null") + "," +
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
            "    DELETE FROM modelo" +
            "    WHERE" +
            "    id_modelo = " + Integer.toString(this._id);

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
