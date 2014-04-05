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
public class Estilo {
    private String _nombre;
    private Integer _puertas;
    private String _traccion;
    private Integer _id_modelo_anio;
    private Integer _rendimiento_carretera;
    private Integer _rendimiento_ciudad;
    private Integer _id;

    private final static String _str_sql = 
        "    SELECT" +
        "    es.nombre AS nombre," +
        "    es.puertas AS puertas," +
        "    es.traccion AS traccion," +
        "    es.id_modelo_anio AS id_modelo_anio," +
        "    es.rendimiento_carretera AS rendimiento_carretera," +
        "    es.rendimiento_ciudad AS rendimiento_ciudad," +
        "    es.id_estilo AS id" +
        "    FROM estilo es";

    public Estilo() {
        _nombre = null;
        _puertas = null;
        _traccion = null;
        _id_modelo_anio = null;
        _rendimiento_carretera = null;
        _rendimiento_ciudad = null;
        _id = null;

    }
    /**
     * @return the _nombre
     */
    public String get_nombre() {
        return _nombre;
    }
    /**
     * @return the _puertas
     */
    public Integer get_puertas() {
        return _puertas;
    }
    /**
     * @return the _traccion
     */
    public String get_traccion() {
        return _traccion;
    }
    /**
     * @return the _id_modelo_anio
     */
    public Integer get_id_modelo_anio() {
        return _id_modelo_anio;
    }
    /**
     * @return the _rendimiento_carretera
     */
    public Integer get_rendimiento_carretera() {
        return _rendimiento_carretera;
    }
    /**
     * @return the _rendimiento_ciudad
     */
    public Integer get_rendimiento_ciudad() {
        return _rendimiento_ciudad;
    }
    /**
     * @return the _id
     */
    public Integer get_id() {
        return _id;
    }
    /**
     * @param _nombre the _nombre to set
     */
    public void set_nombre(String _nombre) {
        this._nombre = _nombre;
    }
    /**
     * @param _puertas the _puertas to set
     */
    public void set_puertas(Integer _puertas) {
        this._puertas = _puertas;
    }
    /**
     * @param _traccion the _traccion to set
     */
    public void set_traccion(String _traccion) {
        this._traccion = _traccion;
    }
    /**
     * @param _id_modelo_anio the _id_modelo_anio to set
     */
    public void set_id_modelo_anio(Integer _id_modelo_anio) {
        this._id_modelo_anio = _id_modelo_anio;
    }
    /**
     * @param _rendimiento_carretera the _rendimiento_carretera to set
     */
    public void set_rendimiento_carretera(Integer _rendimiento_carretera) {
        this._rendimiento_carretera = _rendimiento_carretera;
    }
    /**
     * @param _rendimiento_ciudad the _rendimiento_ciudad to set
     */
    public void set_rendimiento_ciudad(Integer _rendimiento_ciudad) {
        this._rendimiento_ciudad = _rendimiento_ciudad;
    }
    /**
     * @param _id the _id to set
     */
    public void set_id(Integer _id) {
        this._id = _id;
    }

    public static Estilo fromRS(ResultSet p_rs) throws SQLException {
        Estilo ret = new Estilo();

        ret.set_nombre(p_rs.getString("nombre"));
        ret.set_puertas(p_rs.getInt("puertas"));
        ret.set_traccion(p_rs.getString("traccion"));
        ret.set_id_modelo_anio(p_rs.getInt("id_modelo_anio"));
        ret.set_rendimiento_carretera(p_rs.getInt("rendimiento_carretera"));
        ret.set_rendimiento_ciudad(p_rs.getInt("rendimiento_ciudad"));
        ret.set_id(p_rs.getInt("id"));

        return ret;
    }

    public static Estilo getByParameter(Connection p_conn, String p_key, String p_value) throws SQLException {
        Estilo ret = null;
        
        String str_sql = _str_sql +
            "  WHERE es." + p_key + " = " + p_value +
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

    public static Estilo getById(Connection p_conn, String p_id) throws Exception {
        return getByParameter(p_conn, "id_estilo", p_id);
    }
    
    public static ArrayList<Estilo> seek(Connection p_conn, ArrayList<AbstractMap.SimpleEntry<String, String>> p_parameters, String p_order, String p_direction, int p_offset, int p_limit) throws Exception {
        Statement stmt = null;
        ResultSet rs = null;
        String str_sql;
        ArrayList<Estilo> ret;
        
        str_sql = "";
        
        try {
            ArrayList<String> array_clauses = new ArrayList<String>();
            
            ret = new ArrayList<Estilo>();
            
            str_sql = _str_sql;
            
            for (AbstractMap.SimpleEntry<String, String> p : p_parameters) {
                if (p.getKey().equals("id_estilo")) {
                    array_clauses.add("es.id_estilo = " + p.getValue());
                }
                else if (p.getKey().equals("id_modelo_anio")) {
                    array_clauses.add("es.id_modelo_anio = " + p.getValue());
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
            "    UPDATE estilo" +
            "    SET" +
            "    nombre = " + (_nombre != null ? "'" + _nombre + "'" : "null") + "," +
            "    puertas = " + (_puertas != null ? _puertas : "null") + "," +
            "    traccion = " + (_traccion != null ? "'" + _traccion + "'" : "null") + "," +
            "    rendimiento_carretera = " + (_rendimiento_carretera != null ? _rendimiento_carretera : "null") + "," +
            "    rendimiento_ciudad = " + (_rendimiento_ciudad != null ? _rendimiento_ciudad : "null") +
            "    WHERE" +
            "    id_estilo = " + Integer.toString(this._id);

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
            "    INSERT INTO estilo" +
            "    (" +
            "    nombre, " +
            "    puertas, " +
            "    traccion, " +
            "    id_modelo_anio, " +
            "    rendimiento_carretera, " +
            "    rendimiento_ciudad, " +
            "    id_estilo)" +
            "    VALUES" +
            "    (" +
            "    " + (_nombre != null ? "'" + _nombre + "'" : "null") + "," +
            "    " + (_puertas != null ? "'" + _puertas + "'" : "null") + "," +
            "    " + (_traccion != null ? "'" + _traccion + "'" : "null") + "," +
            "    " + (_id_modelo_anio != null ? "'" + _id_modelo_anio + "'" : "null") + "," +
            "    " + (_rendimiento_carretera != null ? "'" + _rendimiento_carretera + "'" : "null") + "," +
            "    " + (_rendimiento_ciudad != null ? "'" + _rendimiento_ciudad + "'" : "null") + "," +
            "    " + (_id != null ? "'" + _id + "'" : "null") +
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
            "    DELETE FROM estilo" +
            "    WHERE" +
            "    id_estilo = " + Integer.toString(this._id);

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
