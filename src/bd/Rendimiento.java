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
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * @author petete-ntbk
 *
 */
public class Rendimiento {
    private Byte _estanqueLleno;
    private Long _idRendimiento;
    private Byte _borrado;
    private Integer _costo;
    private Integer _km;
    private Integer _litros;
    private String _fechaModificacion;
    private Long _idUsuario;
    private Long _idVehiculo;
    private Integer _latitud;
    private Integer _longitud;

    private final static String _str_sql = 
        "    SELECT" +
        "    re.estanque_lleno AS estanque_lleno," +
        "    re.id_rendimiento AS id_rendimiento," +
        "    re.borrado AS borrado," +
        "    re.costo AS costo," +
        "    re.km AS km," +
        "    re.litros AS litros," +
        "    re.fecha_modificacion AS fecha_modificacion," +
        "    re.id_usuario AS id_usuario," +
        "    re.id_vehiculo AS id_vehiculo," +
        "    re.latitud AS latitud," +
        "    re.longitud AS longitud" +
        "    FROM rendimiento re";

    public Rendimiento() {
        _estanqueLleno = null;
        _idRendimiento = null;
        _borrado = null;
        _costo = null;
        _km = null;
        _litros = null;
        _fechaModificacion = null;
        _idUsuario = null;
        _idVehiculo = null;
        _latitud = null;
        _longitud = null;

    }
    /**
     * @return the _estanque_lleno
     */
    public Byte getEstanqueLleno() {
        return _estanqueLleno;
    }
    /**
     * @return the _id_rendimiento
     */
    public Long getIdRendimiento() {
        return _idRendimiento;
    }
    /**
     * @return the _borrado
     */
    public Byte getBorrado() {
        return _borrado;
    }
    /**
     * @return the _costo
     */
    public Integer getCosto() {
        return _costo;
    }
    /**
     * @return the _km
     */
    public Integer getKm() {
        return _km;
    }
    /**
     * @return the _litros
     */
    public Integer getLitros() {
        return _litros;
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
     * @return the _latitud
     */
    public Integer getLatitud() {
        return _latitud;
    }
    /**
     * @return the _longitud
     */
    public Integer getLongitud() {
        return _longitud;
    }
    /**
     * @param _estanqueLleno the _estanqueLleno to set
     */
    public void setEstanqueLleno(Byte _estanqueLleno) {
        this._estanqueLleno = _estanqueLleno;
    }
    /**
     * @param _idRendimiento the _idRendimiento to set
     */
    public void setIdRendimiento(Long _idRendimiento) {
        this._idRendimiento = _idRendimiento;
    }
    /**
     * @param _borrado the _borrado to set
     */
    public void setBorrado(Byte _borrado) {
        this._borrado = _borrado;
    }
    /**
     * @param _costo the _costo to set
     */
    public void setCosto(Integer _costo) {
        this._costo = _costo;
    }
    /**
     * @param _km the _km to set
     */
    public void setKm(Integer _km) {
        this._km = _km;
    }
    /**
     * @param _litros the _litros to set
     */
    public void setLitros(Integer _litros) {
        this._litros = _litros;
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
     * @param _latitud the _latitud to set
     */
    public void setLatitud(Integer _latitud) {
        this._latitud = _latitud;
    }
    /**
     * @param _longitud the _longitud to set
     */
    public void setLongitud(Integer _longitud) {
        this._longitud = _longitud;
    }

    public static Rendimiento fromRS(ResultSet p_rs) throws SQLException {
        Rendimiento ret = new Rendimiento();

        ret.setEstanqueLleno(p_rs.getByte("estanque_lleno"));
        ret.setIdRendimiento(p_rs.getLong("id_rendimiento"));
        ret.setBorrado(p_rs.getByte("borrado"));
        ret.setCosto(p_rs.getInt("costo"));
        ret.setKm(p_rs.getInt("km"));
        ret.setLitros(p_rs.getInt("litros"));
        ret.setFechaModificacion(p_rs.getString("fecha_modificacion"));
        ret.setIdUsuario(p_rs.getLong("id_usuario"));
        ret.setIdVehiculo(p_rs.getLong("id_vehiculo"));
        ret.setLatitud(p_rs.getInt("latitud"));
        ret.setLongitud(p_rs.getInt("longitud"));

        return ret;
    }

    public static Rendimiento getByParameter(Connection p_conn, String p_key, String p_value) throws SQLException {
        Rendimiento ret = null;
        
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

    
    public static ArrayList<Rendimiento> seek(Connection p_conn, ArrayList<AbstractMap.SimpleEntry<String, String>> p_parameters, String p_order, String p_direction, int p_offset, int p_limit) throws Exception {
        Statement stmt = null;
        ResultSet rs = null;
        String str_sql;
        ArrayList<Rendimiento> ret;
        
        str_sql = "";
        
        try {
            ArrayList<String> array_clauses = new ArrayList<String>();
            
            ret = new ArrayList<Rendimiento>();
            
            str_sql = _str_sql;
            
            for (AbstractMap.SimpleEntry<String, String> p : p_parameters) {
                if (p.getKey().equals("id_usuario")) {
                    array_clauses.add("re.id_usuario = " + p.getValue());
                }
                else if (p.getKey().equals("id_rendimiento")) {
                    array_clauses.add("re.id_rendimiento = " + p.getValue());
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
                else if (p.getKey().equals("no borrado")) {
                    array_clauses.add("re.borrado = 0");
                }
                else if (p.getKey().equals("borrado")) {
                    array_clauses.add("re.borrado = 1");
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
            "    UPDATE rendimiento" +
            "    SET" +
            "    estanque_lleno = " + (_estanqueLleno != null ? _estanqueLleno : "null") + "," +
            "    borrado = " + (_borrado != null ? _borrado : "null") + "," +
            "    costo = " + (_costo != null ? _costo : "null") + "," +
            "    km = " + (_km != null ? _km : "null") + "," +
            "    litros = " + (_litros != null ? _litros : "null") + "," +
            "    fecha_modificacion = " + (_fechaModificacion != null ? "'" + _fechaModificacion + "'" : "null") + "," +
            "    latitud = " + (_latitud != null ? _latitud : "null") + "," +
            "    longitud = " + (_longitud != null ? _longitud : "null") +
            "    WHERE" +
            "    id_usuario = " + Long.toString(this._idUsuario) + " AND" +
            "    id_rendimiento = " + Long.toString(this._idRendimiento);

        try {
            stmt = p_conn.createStatement();

            ret = stmt.executeUpdate(str_sql);

            load(p_conn);

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
            "    INSERT INTO rendimiento" +
            "    (" +
            "    estanque_lleno, " +
            "    id_rendimiento, " +
            "    costo, " +
            "    km, " +
            "    litros, " +
            "    id_usuario, " +
            "    id_vehiculo, " +
            "    latitud, " +
            "    longitud)" +
            "    VALUES" +
            "    (" +
            "    " + (_estanqueLleno != null ? "'" + _estanqueLleno + "'" : "null") + "," +
            "    " + (_idRendimiento != null ? "'" + _idRendimiento + "'" : "null") + "," +
            "    " + (_costo != null ? "'" + _costo + "'" : "null") + "," +
            "    " + (_km != null ? "'" + _km + "'" : "null") + "," +
            "    " + (_litros != null ? "'" + _litros + "'" : "null") + "," +
            "    " + (_idUsuario != null ? "'" + _idUsuario + "'" : "null") + "," +
            "    " + (_idVehiculo != null ? "'" + _idVehiculo + "'" : "null") + "," +
            "    " + (_latitud != null ? "'" + _latitud + "'" : "null") + "," +
            "    " + (_longitud != null ? "'" + _longitud + "'" : "null") +
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
            "    DELETE FROM rendimiento" +
            "    WHERE" +
            "    id_usuario = " + Long.toString(this._idUsuario) + " AND" +
            "    id_rendimiento = " + Long.toString(this._idRendimiento);

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
        Rendimiento obj = null;
        
        String str_sql = _str_sql +
            "    WHERE" +
            "    id_usuario = " + Long.toString(this._idUsuario) + " AND" +
            "    id_rendimiento = " + Long.toString(this._idRendimiento) +
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

                _estanqueLleno = obj.getEstanqueLleno();
                _borrado = obj.getBorrado();
                _costo = obj.getCosto();
                _km = obj.getKm();
                _litros = obj.getLitros();
                _fechaModificacion = obj.getFechaModificacion();
                _idVehiculo = obj.getIdVehiculo();
                _latitud = obj.getLatitud();
                _longitud = obj.getLongitud();
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
        return "Rendimiento [" +
	           "    _estanqueLleno = " + (_estanqueLleno != null ? _estanqueLleno : "null") + "," +
	           "    _idRendimiento = " + (_idRendimiento != null ? _idRendimiento : "null") + "," +
	           "    _borrado = " + (_borrado != null ? _borrado : "null") + "," +
	           "    _costo = " + (_costo != null ? _costo : "null") + "," +
	           "    _km = " + (_km != null ? _km : "null") + "," +
	           "    _litros = " + (_litros != null ? _litros : "null") + "," +
	           "    _fechaModificacion = " + (_fechaModificacion != null ? "'" + _fechaModificacion + "'" : "null") + "," +
	           "    _idUsuario = " + (_idUsuario != null ? _idUsuario : "null") + "," +
	           "    _idVehiculo = " + (_idVehiculo != null ? _idVehiculo : "null") + "," +
	           "    _latitud = " + (_latitud != null ? _latitud : "null") + "," +
	           "    _longitud = " + (_longitud != null ? _longitud : "null") +
			   "]";
    }


    public String toJSON() {
        return "{\"Rendimiento\" : {" +
	           "    \"_estanqueLleno\" : " + (_estanqueLleno != null ? _estanqueLleno : "null") + "," +
	           "    \"_idRendimiento\" : " + (_idRendimiento != null ? _idRendimiento : "null") + "," +
	           "    \"_borrado\" : " + (_borrado != null ? _borrado : "null") + "," +
	           "    \"_costo\" : " + (_costo != null ? _costo : "null") + "," +
	           "    \"_km\" : " + (_km != null ? _km : "null") + "," +
	           "    \"_litros\" : " + (_litros != null ? _litros : "null") + "," +
	           "    \"_fecha_modificacion\" : " + (_fechaModificacion != null ? "\"" + _fechaModificacion + "\"" : "null") + "," +
	           "    \"_idUsuario\" : " + (_idUsuario != null ? _idUsuario : "null") + "," +
	           "    \"_idVehiculo\" : " + (_idVehiculo != null ? _idVehiculo : "null") + "," +
	           "    \"_latitud\" : " + (_latitud != null ? _latitud : "null") + "," +
	           "    \"_longitud\" : " + (_longitud != null ? _longitud : "null") +
			   "}}";
    }


    public String toXML() {
        return "<Rendimiento>" +
	           "    <estanqueLleno" + (_estanqueLleno != null ? ">" + _estanqueLleno + "</estanqueLleno>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <idRendimiento" + (_idRendimiento != null ? ">" + _idRendimiento + "</idRendimiento>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <borrado" + (_borrado != null ? ">" + _borrado + "</borrado>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <costo" + (_costo != null ? ">" + _costo + "</costo>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <km" + (_km != null ? ">" + _km + "</km>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <litros" + (_litros != null ? ">" + _litros + "</litros>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <fechaModificacion" + (_fechaModificacion != null ? ">" + _fechaModificacion + "</fechaModificacion>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <idUsuario" + (_idUsuario != null ? ">" + _idUsuario + "</idUsuario>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <idVehiculo" + (_idVehiculo != null ? ">" + _idVehiculo + "</idVehiculo>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <latitud" + (_latitud != null ? ">" + _latitud + "</latitud>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <longitud" + (_longitud != null ? ">" + _longitud + "</longitud>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
			   "</Rendimiento>";
    }


    public static Rendimiento fromXMLNode(Node xmlNode) {
        Rendimiento ret = new Rendimiento();

        Element element = (Element) xmlNode;

        ret.setEstanqueLleno(Byte.decode(element.getElementsByTagName("estanque_lleno").item(0).getTextContent()));
        ret.setIdRendimiento(Long.decode(element.getElementsByTagName("id_rendimiento").item(0).getTextContent()));
        ret.setBorrado(Byte.decode(element.getElementsByTagName("borrado").item(0).getTextContent()));
        ret.setCosto(Integer.decode(element.getElementsByTagName("costo").item(0).getTextContent()));
        ret.setKm(Integer.decode(element.getElementsByTagName("km").item(0).getTextContent()));
        ret.setLitros(Integer.decode(element.getElementsByTagName("litros").item(0).getTextContent()));
        ret.setFechaModificacion(element.getElementsByTagName("fecha_modificacion").item(0).getTextContent());
        ret.setIdUsuario(Long.decode(element.getElementsByTagName("id_usuario").item(0).getTextContent()));
        ret.setIdVehiculo(Long.decode(element.getElementsByTagName("id_vehiculo").item(0).getTextContent()));
        ret.setLatitud(Integer.decode(element.getElementsByTagName("latitud").item(0).getTextContent()));
        ret.setLongitud(Integer.decode(element.getElementsByTagName("longitud").item(0).getTextContent()));

        return ret;
    }
}
