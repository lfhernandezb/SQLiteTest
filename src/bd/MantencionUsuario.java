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
    private Integer _kmentremantenciones;
    private String _descripcion;
    private Long _idMantencionUsuario;
    private String _mantencionUsuariocol;
    private Byte _dependekm;
    private Integer _mantecionBase;
    private String _nombre;
    private String _mantencionusuariocol;
    private String _fechaModificacion;
    private Long _idUsuario;
    private Long _idMantencionBase;
    private Long _idVehiculo;
    private Integer _diasentremantenciones;
    private String _url;
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
        _kmentremantenciones = null;
        _descripcion = null;
        _idMantencionUsuario = null;
        _mantencionUsuariocol = null;
        _dependekm = null;
        _mantecionBase = null;
        _nombre = null;
        _mantencionusuariocol = null;
        _fechaModificacion = null;
        _idUsuario = null;
        _idMantencionBase = null;
        _idVehiculo = null;
        _diasentremantenciones = null;
        _url = null;
        _beneficios = null;

    }
    /**
     * @return the _KmEntreMantenciones
     */
    public Integer getKmentremantenciones() {
        return _kmentremantenciones;
    }
    /**
     * @return the _descripcion
     */
    public String getDescripcion() {
        return _descripcion;
    }
    /**
     * @return the _id_mantencion_usuario
     */
    public Long getIdMantencionUsuario() {
        return _idMantencionUsuario;
    }
    /**
     * @return the _mantencion_usuariocol
     */
    public String getMantencionUsuariocol() {
        return _mantencionUsuariocol;
    }
    /**
     * @return the _DependeKm
     */
    public Byte getDependekm() {
        return _dependekm;
    }
    /**
     * @return the _mantecion_base
     */
    public Integer getMantecionBase() {
        return _mantecionBase;
    }
    /**
     * @return the _nombre
     */
    public String getNombre() {
        return _nombre;
    }
    /**
     * @return the _MantencionUsuariocol
     */
    public String getMantencionusuariocol() {
        return _mantencionusuariocol;
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
     * @return the _id_mantencion_base
     */
    public Long getIdMantencionBase() {
        return _idMantencionBase;
    }
    /**
     * @return the _id_vehiculo
     */
    public Long getIdVehiculo() {
        return _idVehiculo;
    }
    /**
     * @return the _DiasEntreMantenciones
     */
    public Integer getDiasentremantenciones() {
        return _diasentremantenciones;
    }
    /**
     * @return the _URL
     */
    public String getUrl() {
        return _url;
    }
    /**
     * @return the _beneficios
     */
    public String getBeneficios() {
        return _beneficios;
    }
    /**
     * @param _kmentremantenciones the _kmentremantenciones to set
     */
    public void setKmentremantenciones(Integer _kmentremantenciones) {
        this._kmentremantenciones = _kmentremantenciones;
    }
    /**
     * @param _descripcion the _descripcion to set
     */
    public void setDescripcion(String _descripcion) {
        this._descripcion = _descripcion;
    }
    /**
     * @param _idMantencionUsuario the _idMantencionUsuario to set
     */
    public void setIdMantencionUsuario(Long _idMantencionUsuario) {
        this._idMantencionUsuario = _idMantencionUsuario;
    }
    /**
     * @param _mantencionUsuariocol the _mantencionUsuariocol to set
     */
    public void setMantencionUsuariocol(String _mantencionUsuariocol) {
        this._mantencionUsuariocol = _mantencionUsuariocol;
    }
    /**
     * @param _dependekm the _dependekm to set
     */
    public void setDependekm(Byte _dependekm) {
        this._dependekm = _dependekm;
    }
    /**
     * @param _mantecionBase the _mantecionBase to set
     */
    public void setMantecionBase(Integer _mantecionBase) {
        this._mantecionBase = _mantecionBase;
    }
    /**
     * @param _nombre the _nombre to set
     */
    public void setNombre(String _nombre) {
        this._nombre = _nombre;
    }
    /**
     * @param _mantencionusuariocol the _mantencionusuariocol to set
     */
    public void setMantencionusuariocol(String _mantencionusuariocol) {
        this._mantencionusuariocol = _mantencionusuariocol;
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
     * @param _idMantencionBase the _idMantencionBase to set
     */
    public void setIdMantencionBase(Long _idMantencionBase) {
        this._idMantencionBase = _idMantencionBase;
    }
    /**
     * @param _idVehiculo the _idVehiculo to set
     */
    public void setIdVehiculo(Long _idVehiculo) {
        this._idVehiculo = _idVehiculo;
    }
    /**
     * @param _diasentremantenciones the _diasentremantenciones to set
     */
    public void setDiasentremantenciones(Integer _diasentremantenciones) {
        this._diasentremantenciones = _diasentremantenciones;
    }
    /**
     * @param _url the _url to set
     */
    public void setUrl(String _url) {
        this._url = _url;
    }
    /**
     * @param _beneficios the _beneficios to set
     */
    public void setBeneficios(String _beneficios) {
        this._beneficios = _beneficios;
    }

    public static MantencionUsuario fromRS(ResultSet p_rs) throws SQLException {
        MantencionUsuario ret = new MantencionUsuario();

        ret.setKmentremantenciones(p_rs.getInt("KmEntreMantenciones"));
        ret.setDescripcion(p_rs.getString("descripcion"));
        ret.setIdMantencionUsuario(p_rs.getLong("id_mantencion_usuario"));
        ret.setMantencionUsuariocol(p_rs.getString("mantencion_usuariocol"));
        ret.setDependekm(p_rs.getByte("DependeKm"));
        ret.setMantecionBase(p_rs.getInt("mantecion_base"));
        ret.setNombre(p_rs.getString("nombre"));
        ret.setMantencionusuariocol(p_rs.getString("MantencionUsuariocol"));
        ret.setFechaModificacion(p_rs.getString("fecha_modificacion"));
        ret.setIdUsuario(p_rs.getLong("id_usuario"));
        ret.setIdMantencionBase(p_rs.getLong("id_mantencion_base"));
        ret.setIdVehiculo(p_rs.getLong("id_vehiculo"));
        ret.setDiasentremantenciones(p_rs.getInt("DiasEntreMantenciones"));
        ret.setUrl(p_rs.getString("URL"));
        ret.setBeneficios(p_rs.getString("beneficios"));

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
            "    KmEntreMantenciones = " + (_kmentremantenciones != null ? _kmentremantenciones : "null") + "," +
            "    descripcion = " + (_descripcion != null ? "'" + _descripcion + "'" : "null") + "," +
            "    mantencion_usuariocol = " + (_mantencionUsuariocol != null ? "'" + _mantencionUsuariocol + "'" : "null") + "," +
            "    DependeKm = " + (_dependekm != null ? _dependekm : "null") + "," +
            "    mantecion_base = " + (_mantecionBase != null ? _mantecionBase : "null") + "," +
            "    nombre = " + (_nombre != null ? "'" + _nombre + "'" : "null") + "," +
            "    MantencionUsuariocol = " + (_mantencionusuariocol != null ? "'" + _mantencionusuariocol + "'" : "null") + "," +
            "    fecha_modificacion = " + (_fechaModificacion != null ? "'" + _fechaModificacion + "'" : "null") + "," +
            "    id_mantencion_base = " + (_idMantencionBase != null ? _idMantencionBase : "null") + "," +
            "    DiasEntreMantenciones = " + (_diasentremantenciones != null ? _diasentremantenciones : "null") + "," +
            "    URL = " + (_url != null ? "'" + _url + "'" : "null") + "," +
            "    beneficios = " + (_beneficios != null ? "'" + _beneficios + "'" : "null") +
            "    WHERE" +
            "    id_usuario = " + Long.toString(this._idUsuario) + " AND" +
            "    id_mantencion_usuario = " + Long.toString(this._idMantencionUsuario);

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
            "    " + (_kmentremantenciones != null ? "'" + _kmentremantenciones + "'" : "null") + "," +
            "    " + (_descripcion != null ? "'" + _descripcion + "'" : "null") + "," +
            "    " + (_idMantencionUsuario != null ? "'" + _idMantencionUsuario + "'" : "null") + "," +
            "    " + (_mantencionUsuariocol != null ? "'" + _mantencionUsuariocol + "'" : "null") + "," +
            "    " + (_dependekm != null ? "'" + _dependekm + "'" : "null") + "," +
            "    " + (_mantecionBase != null ? "'" + _mantecionBase + "'" : "null") + "," +
            "    " + (_nombre != null ? "'" + _nombre + "'" : "null") + "," +
            "    " + (_mantencionusuariocol != null ? "'" + _mantencionusuariocol + "'" : "null") + "," +
            "    " + (_idUsuario != null ? "'" + _idUsuario + "'" : "null") + "," +
            "    " + (_idMantencionBase != null ? "'" + _idMantencionBase + "'" : "null") + "," +
            "    " + (_idVehiculo != null ? "'" + _idVehiculo + "'" : "null") + "," +
            "    " + (_diasentremantenciones != null ? "'" + _diasentremantenciones + "'" : "null") + "," +
            "    " + (_url != null ? "'" + _url + "'" : "null") + "," +
            "    " + (_beneficios != null ? "'" + _beneficios + "'" : "null") +
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
            "    DELETE FROM mantencion_usuario" +
            "    WHERE" +
            "    id_usuario = " + Long.toString(this._idUsuario) + " AND" +
            "    id_mantencion_usuario = " + Long.toString(this._idMantencionUsuario);

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
        MantencionUsuario obj = null;
        
        String str_sql = _str_sql +
            "    WHERE" +
            "    id_usuario = " + Long.toString(this._idUsuario) + " AND" +
            "    id_mantencion_usuario = " + Long.toString(this._idMantencionUsuario) +
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

                _kmentremantenciones = obj.getKmentremantenciones();
                _descripcion = obj.getDescripcion();
                _mantencionUsuariocol = obj.getMantencionUsuariocol();
                _dependekm = obj.getDependekm();
                _mantecionBase = obj.getMantecionBase();
                _nombre = obj.getNombre();
                _mantencionusuariocol = obj.getMantencionusuariocol();
                _fechaModificacion = obj.getFechaModificacion();
                _idMantencionBase = obj.getIdMantencionBase();
                _idVehiculo = obj.getIdVehiculo();
                _diasentremantenciones = obj.getDiasentremantenciones();
                _url = obj.getUrl();
                _beneficios = obj.getBeneficios();
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
        return "MantencionUsuario [" +
	           "    _kmentremantenciones = " + (_kmentremantenciones != null ? _kmentremantenciones : "null") + "," +
	           "    _descripcion = " + (_descripcion != null ? "'" + _descripcion + "'" : "null") + "," +
	           "    _idMantencionUsuario = " + (_idMantencionUsuario != null ? _idMantencionUsuario : "null") + "," +
	           "    _mantencionUsuariocol = " + (_mantencionUsuariocol != null ? "'" + _mantencionUsuariocol + "'" : "null") + "," +
	           "    _dependekm = " + (_dependekm != null ? _dependekm : "null") + "," +
	           "    _mantecionBase = " + (_mantecionBase != null ? _mantecionBase : "null") + "," +
	           "    _nombre = " + (_nombre != null ? "'" + _nombre + "'" : "null") + "," +
	           "    _mantencionusuariocol = " + (_mantencionusuariocol != null ? "'" + _mantencionusuariocol + "'" : "null") + "," +
	           "    _fechaModificacion = " + (_fechaModificacion != null ? "'" + _fechaModificacion + "'" : "null") + "," +
	           "    _idUsuario = " + (_idUsuario != null ? _idUsuario : "null") + "," +
	           "    _idMantencionBase = " + (_idMantencionBase != null ? _idMantencionBase : "null") + "," +
	           "    _idVehiculo = " + (_idVehiculo != null ? _idVehiculo : "null") + "," +
	           "    _diasentremantenciones = " + (_diasentremantenciones != null ? _diasentremantenciones : "null") + "," +
	           "    _url = " + (_url != null ? "'" + _url + "'" : "null") + "," +
	           "    _beneficios = " + (_beneficios != null ? "'" + _beneficios + "'" : "null") +
			   "]";
    }


    public String toJSON() {
        return "{\"MantencionUsuario\" : {" +
	           "    \"_kmentremantenciones\" : " + (_kmentremantenciones != null ? _kmentremantenciones : "null") + "," +
	           "    \"_descripcion\" : " + (_descripcion != null ? "\"" + _descripcion + "\"" : "null") + "," +
	           "    \"_idMantencionUsuario\" : " + (_idMantencionUsuario != null ? _idMantencionUsuario : "null") + "," +
	           "    \"_mantencion_usuariocol\" : " + (_mantencionUsuariocol != null ? "\"" + _mantencionUsuariocol + "\"" : "null") + "," +
	           "    \"_dependekm\" : " + (_dependekm != null ? _dependekm : "null") + "," +
	           "    \"_mantecionBase\" : " + (_mantecionBase != null ? _mantecionBase : "null") + "," +
	           "    \"_nombre\" : " + (_nombre != null ? "\"" + _nombre + "\"" : "null") + "," +
	           "    \"_MantencionUsuariocol\" : " + (_mantencionusuariocol != null ? "\"" + _mantencionusuariocol + "\"" : "null") + "," +
	           "    \"_fecha_modificacion\" : " + (_fechaModificacion != null ? "\"" + _fechaModificacion + "\"" : "null") + "," +
	           "    \"_idUsuario\" : " + (_idUsuario != null ? _idUsuario : "null") + "," +
	           "    \"_idMantencionBase\" : " + (_idMantencionBase != null ? _idMantencionBase : "null") + "," +
	           "    \"_idVehiculo\" : " + (_idVehiculo != null ? _idVehiculo : "null") + "," +
	           "    \"_diasentremantenciones\" : " + (_diasentremantenciones != null ? _diasentremantenciones : "null") + "," +
	           "    \"_URL\" : " + (_url != null ? "\"" + _url + "\"" : "null") + "," +
	           "    \"_beneficios\" : " + (_beneficios != null ? "\"" + _beneficios + "\"" : "null") +
			   "}}";
    }

}
