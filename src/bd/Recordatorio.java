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
public class Recordatorio {
    private String _fecha;
    private String _descripcion;
    private Byte _recordarKm;
    private Integer _km;
    private Byte _recordarFecha;
    private Byte _descartado;
    private Long _idRecordatorio;
    private String _titulo;
    private String _fechaModificacion;
    private Long _idUsuario;
    private Long _idVehiculo;
    private String _recordatoriocol;

    private final static String _str_sql = 
        "    SELECT" +
        "    re.fecha AS fecha," +
        "    re.descripcion AS descripcion," +
        "    re.recordar_km AS recordar_km," +
        "    re.km AS km," +
        "    re.recordar_fecha AS recordar_fecha," +
        "    re.descartado AS descartado," +
        "    re.id_recordatorio AS id_recordatorio," +
        "    re.titulo AS titulo," +
        "    re.fecha_modificacion AS fecha_modificacion," +
        "    re.id_usuario AS id_usuario," +
        "    re.id_vehiculo AS id_vehiculo," +
        "    re.recordatoriocol AS recordatoriocol" +
        "    FROM recordatorio re";

    public Recordatorio() {
        _fecha = null;
        _descripcion = null;
        _recordarKm = null;
        _km = null;
        _recordarFecha = null;
        _descartado = null;
        _idRecordatorio = null;
        _titulo = null;
        _fechaModificacion = null;
        _idUsuario = null;
        _idVehiculo = null;
        _recordatoriocol = null;

    }
    /**
     * @return the _fecha
     */
    public String getFecha() {
        return _fecha;
    }
    /**
     * @return the _descripcion
     */
    public String getDescripcion() {
        return _descripcion;
    }
    /**
     * @return the _recordar_km
     */
    public Byte getRecordarKm() {
        return _recordarKm;
    }
    /**
     * @return the _km
     */
    public Integer getKm() {
        return _km;
    }
    /**
     * @return the _recordar_fecha
     */
    public Byte getRecordarFecha() {
        return _recordarFecha;
    }
    /**
     * @return the _descartado
     */
    public Byte getDescartado() {
        return _descartado;
    }
    /**
     * @return the _id_recordatorio
     */
    public Long getIdRecordatorio() {
        return _idRecordatorio;
    }
    /**
     * @return the _titulo
     */
    public String getTitulo() {
        return _titulo;
    }
    /**
     * @return the _fecha_modificacion
     */
    public String getFechaModificacion() {
        return _fechaModificacion;
    }
    /**
     * @return the _id_usuario
     */
    public Long getIdUsuario() {
        return _idUsuario;
    }
    /**
     * @return the _id_vehiculo
     */
    public Long getIdVehiculo() {
        return _idVehiculo;
    }
    /**
     * @return the _recordatoriocol
     */
    public String getRecordatoriocol() {
        return _recordatoriocol;
    }
    /**
     * @param _fecha the _fecha to set
     */
    public void setFecha(String _fecha) {
        this._fecha = _fecha;
    }
    /**
     * @param _descripcion the _descripcion to set
     */
    public void setDescripcion(String _descripcion) {
        this._descripcion = _descripcion;
    }
    /**
     * @param _recordarKm the _recordarKm to set
     */
    public void setRecordarKm(Byte _recordarKm) {
        this._recordarKm = _recordarKm;
    }
    /**
     * @param _km the _km to set
     */
    public void setKm(Integer _km) {
        this._km = _km;
    }
    /**
     * @param _recordarFecha the _recordarFecha to set
     */
    public void setRecordarFecha(Byte _recordarFecha) {
        this._recordarFecha = _recordarFecha;
    }
    /**
     * @param _descartado the _descartado to set
     */
    public void setDescartado(Byte _descartado) {
        this._descartado = _descartado;
    }
    /**
     * @param _idRecordatorio the _idRecordatorio to set
     */
    public void setIdRecordatorio(Long _idRecordatorio) {
        this._idRecordatorio = _idRecordatorio;
    }
    /**
     * @param _titulo the _titulo to set
     */
    public void setTitulo(String _titulo) {
        this._titulo = _titulo;
    }
    /**
     * @param _fechaModificacion the _fechaModificacion to set
     */
    public void setFechaModificacion(String _fechaModificacion) {
        this._fechaModificacion = _fechaModificacion;
    }
    /**
     * @param _idUsuario the _idUsuario to set
     */
    public void setIdUsuario(Long _idUsuario) {
        this._idUsuario = _idUsuario;
    }
    /**
     * @param _idVehiculo the _idVehiculo to set
     */
    public void setIdVehiculo(Long _idVehiculo) {
        this._idVehiculo = _idVehiculo;
    }
    /**
     * @param _recordatoriocol the _recordatoriocol to set
     */
    public void setRecordatoriocol(String _recordatoriocol) {
        this._recordatoriocol = _recordatoriocol;
    }

    public static Recordatorio fromRS(ResultSet p_rs) throws SQLException {
        Recordatorio ret = new Recordatorio();

        ret.setFecha(p_rs.getString("fecha"));
        ret.setDescripcion(p_rs.getString("descripcion"));
        ret.setRecordarKm(p_rs.getByte("recordar_km"));
        ret.setKm(p_rs.getInt("km"));
        ret.setRecordarFecha(p_rs.getByte("recordar_fecha"));
        ret.setDescartado(p_rs.getByte("descartado"));
        ret.setIdRecordatorio(p_rs.getLong("id_recordatorio"));
        ret.setTitulo(p_rs.getString("titulo"));
        ret.setFechaModificacion(p_rs.getString("fecha_modificacion"));
        ret.setIdUsuario(p_rs.getLong("id_usuario"));
        ret.setIdVehiculo(p_rs.getLong("id_vehiculo"));
        ret.setRecordatoriocol(p_rs.getString("recordatoriocol"));

        return ret;
    }

    public static Recordatorio getByParameter(Connection p_conn, String p_key, String p_value) throws SQLException {
        Recordatorio ret = null;
        
        String str_sql = _str_sql +
            "  WHERE re." + p_key + " = " + p_value +
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

    
    public static ArrayList<Recordatorio> seek(Connection p_conn, ArrayList<AbstractMap.SimpleEntry<String, String>> p_parameters, String p_order, String p_direction, int p_offset, int p_limit) throws Exception {
        Statement stmt = null;
        ResultSet rs = null;
        String str_sql;
        ArrayList<Recordatorio> ret;
        
        str_sql = "";
        
        try {
            ArrayList<String> array_clauses = new ArrayList<String>();
            
            ret = new ArrayList<Recordatorio>();
            
            str_sql = _str_sql;
            
            for (AbstractMap.SimpleEntry<String, String> p : p_parameters) {
                if (p.getKey().equals("id_recordatorio")) {
                    array_clauses.add("re.id_recordatorio = " + p.getValue());
                }
                else if (p.getKey().equals("id_usuario")) {
                    array_clauses.add("re.id_usuario = " + p.getValue());
                }
                else if (p.getKey().equals("id_usuario")) {
                    array_clauses.add("re.id_usuario = " + p.getValue());
                }
                else if (p.getKey().equals("id_vehiculo")) {
                    array_clauses.add("re.id_vehiculo = " + p.getValue());
                }
                else if (p.getKey().equals("mas reciente")) {
                    array_clauses.add("re.fecha_modificacion > '" + p.getValue() + "'");
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
            "    UPDATE recordatorio" +
            "    SET" +
            "    fecha = " + (_fecha != null ? "'" + _fecha + "'" : "null") + "," +
            "    descripcion = " + (_descripcion != null ? "'" + _descripcion + "'" : "null") + "," +
            "    recordar_km = " + (_recordarKm != null ? _recordarKm : "null") + "," +
            "    km = " + (_km != null ? _km : "null") + "," +
            "    recordar_fecha = " + (_recordarFecha != null ? _recordarFecha : "null") + "," +
            "    descartado = " + (_descartado != null ? _descartado : "null") + "," +
            "    titulo = " + (_titulo != null ? "'" + _titulo + "'" : "null") + "," +
            "    fecha_modificacion = " + (_fechaModificacion != null ? "'" + _fechaModificacion + "'" : "null") + "," +
            "    recordatoriocol = " + (_recordatoriocol != null ? "'" + _recordatoriocol + "'" : "null") +
            "    WHERE" +
            "    id_recordatorio = " + Long.toString(this._idRecordatorio) + " AND" +
            "    id_usuario = " + Long.toString(this._idUsuario);

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
            "    INSERT INTO recordatorio" +
            "    (" +
            "    fecha, " +
            "    descripcion, " +
            "    recordar_km, " +
            "    km, " +
            "    recordar_fecha, " +
            "    id_recordatorio, " +
            "    titulo, " +
            "    id_usuario, " +
            "    id_vehiculo, " +
            "    recordatoriocol)" +
            "    VALUES" +
            "    (" +
            "    " + (_fecha != null ? "'" + _fecha + "'" : "null") + "," +
            "    " + (_descripcion != null ? "'" + _descripcion + "'" : "null") + "," +
            "    " + (_recordarKm != null ? "'" + _recordarKm + "'" : "null") + "," +
            "    " + (_km != null ? "'" + _km + "'" : "null") + "," +
            "    " + (_recordarFecha != null ? "'" + _recordarFecha + "'" : "null") + "," +
            "    " + (_idRecordatorio != null ? "'" + _idRecordatorio + "'" : "null") + "," +
            "    " + (_titulo != null ? "'" + _titulo + "'" : "null") + "," +
            "    " + (_idUsuario != null ? "'" + _idUsuario + "'" : "null") + "," +
            "    " + (_idVehiculo != null ? "'" + _idVehiculo + "'" : "null") + "," +
            "    " + (_recordatoriocol != null ? "'" + _recordatoriocol + "'" : "null") +
            "    )";
        
        try {
            stmt = p_conn.createStatement();
            
            ret = stmt.executeUpdate(str_sql);

            load(p_conn);

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
            "    DELETE FROM recordatorio" +
            "    WHERE" +
            "    id_recordatorio = " + Long.toString(this._idRecordatorio) + " AND" +
            "    id_usuario = " + Long.toString(this._idUsuario);

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

    public void load(Connection p_conn) throws SQLException {
        Recordatorio obj = null;
        
        String str_sql = _str_sql +
            "    WHERE" +
            "    id_recordatorio = " + Long.toString(this._idRecordatorio) + " AND" +
            "    id_usuario = " + Long.toString(this._idUsuario) +
            "    LIMIT 0, 1";
        
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
                obj = fromRS(rs);
                //System.out.println("fromRS(rs) ok");

                _fecha = obj.getFecha();
                _descripcion = obj.getDescripcion();
                _recordarKm = obj.getRecordarKm();
                _km = obj.getKm();
                _recordarFecha = obj.getRecordarFecha();
                _descartado = obj.getDescartado();
                _titulo = obj.getTitulo();
                _fechaModificacion = obj.getFechaModificacion();
                _idVehiculo = obj.getIdVehiculo();
                _recordatoriocol = obj.getRecordatoriocol();
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
        
    }


@Override
    public String toString() {
        return "Recordatorio [" +
	           "    _fecha = " + (_fecha != null ? "'" + _fecha + "'" : "null") + "," +
	           "    _descripcion = " + (_descripcion != null ? "'" + _descripcion + "'" : "null") + "," +
	           "    _recordarKm = " + (_recordarKm != null ? _recordarKm : "null") + "," +
	           "    _km = " + (_km != null ? _km : "null") + "," +
	           "    _recordarFecha = " + (_recordarFecha != null ? _recordarFecha : "null") + "," +
	           "    _descartado = " + (_descartado != null ? _descartado : "null") + "," +
	           "    _idRecordatorio = " + (_idRecordatorio != null ? _idRecordatorio : "null") + "," +
	           "    _titulo = " + (_titulo != null ? "'" + _titulo + "'" : "null") + "," +
	           "    _fechaModificacion = " + (_fechaModificacion != null ? "'" + _fechaModificacion + "'" : "null") + "," +
	           "    _idUsuario = " + (_idUsuario != null ? _idUsuario : "null") + "," +
	           "    _idVehiculo = " + (_idVehiculo != null ? _idVehiculo : "null") + "," +
	           "    _recordatoriocol = " + (_recordatoriocol != null ? "'" + _recordatoriocol + "'" : "null") +
			   "]";
    }


    public String toJSON() {
        return "{\"Recordatorio\" : {" +
	           "    \"_fecha\" : " + (_fecha != null ? "\"" + _fecha + "\"" : "null") + "," +
	           "    \"_descripcion\" : " + (_descripcion != null ? "\"" + _descripcion + "\"" : "null") + "," +
	           "    \"_recordarKm\" : " + (_recordarKm != null ? _recordarKm : "null") + "," +
	           "    \"_km\" : " + (_km != null ? _km : "null") + "," +
	           "    \"_recordarFecha\" : " + (_recordarFecha != null ? _recordarFecha : "null") + "," +
	           "    \"_descartado\" : " + (_descartado != null ? _descartado : "null") + "," +
	           "    \"_idRecordatorio\" : " + (_idRecordatorio != null ? _idRecordatorio : "null") + "," +
	           "    \"_titulo\" : " + (_titulo != null ? "\"" + _titulo + "\"" : "null") + "," +
	           "    \"_fecha_modificacion\" : " + (_fechaModificacion != null ? "\"" + _fechaModificacion + "\"" : "null") + "," +
	           "    \"_idUsuario\" : " + (_idUsuario != null ? _idUsuario : "null") + "," +
	           "    \"_idVehiculo\" : " + (_idVehiculo != null ? _idVehiculo : "null") + "," +
	           "    \"_recordatoriocol\" : " + (_recordatoriocol != null ? "\"" + _recordatoriocol + "\"" : "null") +
			   "}}";
    }

}
