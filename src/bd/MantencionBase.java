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
public class MantencionBase {
    private Integer _diasEntreMantenciones;
    private String _tipoTransmision;
    private String _codigoMotor;
    private Integer _kmEntreMantenciones;
    private Byte _dependeKm;
    private String _accion;
    private String _url;
    private String _descripcionItem;
    private String _fechaModificacion;
    private Long _idModeloAnio;
    private Long _id;
    private String _item;
    private String _tipoTraccion;
    private String _beneficios;

    private final static String _str_sql = 
        "    SELECT" +
        "    ma.dias_entre_mantenciones AS dias_entre_mantenciones," +
        "    ma.tipo_transmision AS tipo_transmision," +
        "    ma.codigo_motor AS codigo_motor," +
        "    ma.km_entre_mantenciones AS km_entre_mantenciones," +
        "    ma.depende_km AS depende_km," +
        "    ma.accion AS accion," +
        "    ma.url AS url," +
        "    ma.descripcion_item AS descripcion_item," +
        "    ma.fecha_modificacion AS fecha_modificacion," +
        "    ma.id_modelo_anio AS id_modelo_anio," +
        "    ma.id_mantencion_base AS id," +
        "    ma.item AS item," +
        "    ma.tipo_traccion AS tipo_traccion," +
        "    ma.beneficios AS beneficios" +
        "    FROM mantencion_base ma";

    public MantencionBase() {
        _diasEntreMantenciones = null;
        _tipoTransmision = null;
        _codigoMotor = null;
        _kmEntreMantenciones = null;
        _dependeKm = null;
        _accion = null;
        _url = null;
        _descripcionItem = null;
        _fechaModificacion = null;
        _idModeloAnio = null;
        _id = null;
        _item = null;
        _tipoTraccion = null;
        _beneficios = null;

    }
    /**
     * @return the _dias_entre_mantenciones
     */
    public Integer getDiasEntreMantenciones() {
        return _diasEntreMantenciones;
    }
    /**
     * @return the _tipo_transmision
     */
    public String getTipoTransmision() {
        return _tipoTransmision;
    }
    /**
     * @return the _codigo_motor
     */
    public String getCodigoMotor() {
        return _codigoMotor;
    }
    /**
     * @return the _km_entre_mantenciones
     */
    public Integer getKmEntreMantenciones() {
        return _kmEntreMantenciones;
    }
    /**
     * @return the _depende_km
     */
    public Byte getDependeKm() {
        return _dependeKm;
    }
    /**
     * @return the _accion
     */
    public String getAccion() {
        return _accion;
    }
    /**
     * @return the _url
     */
    public String getUrl() {
        return _url;
    }
    /**
     * @return the _descripcion_item
     */
    public String getDescripcionItem() {
        return _descripcionItem;
    }
    /**
     * @return the _fecha_modificacion
     */
    public String getFechaModificacion() {
        return _fechaModificacion;
    }
    /**
     * @return the _id_modelo_anio
     */
    public Long getIdModeloAnio() {
        return _idModeloAnio;
    }
    /**
     * @return the _id
     */
    public Long getId() {
        return _id;
    }
    /**
     * @return the _item
     */
    public String getItem() {
        return _item;
    }
    /**
     * @return the _tipo_traccion
     */
    public String getTipoTraccion() {
        return _tipoTraccion;
    }
    /**
     * @return the _beneficios
     */
    public String getBeneficios() {
        return _beneficios;
    }
    /**
     * @param _diasEntreMantenciones the _diasEntreMantenciones to set
     */
    public void setDiasEntreMantenciones(Integer _diasEntreMantenciones) {
        this._diasEntreMantenciones = _diasEntreMantenciones;
    }
    /**
     * @param _tipoTransmision the _tipoTransmision to set
     */
    public void setTipoTransmision(String _tipoTransmision) {
        this._tipoTransmision = _tipoTransmision;
    }
    /**
     * @param _codigoMotor the _codigoMotor to set
     */
    public void setCodigoMotor(String _codigoMotor) {
        this._codigoMotor = _codigoMotor;
    }
    /**
     * @param _kmEntreMantenciones the _kmEntreMantenciones to set
     */
    public void setKmEntreMantenciones(Integer _kmEntreMantenciones) {
        this._kmEntreMantenciones = _kmEntreMantenciones;
    }
    /**
     * @param _dependeKm the _dependeKm to set
     */
    public void setDependeKm(Byte _dependeKm) {
        this._dependeKm = _dependeKm;
    }
    /**
     * @param _accion the _accion to set
     */
    public void setAccion(String _accion) {
        this._accion = _accion;
    }
    /**
     * @param _url the _url to set
     */
    public void setUrl(String _url) {
        this._url = _url;
    }
    /**
     * @param _descripcionItem the _descripcionItem to set
     */
    public void setDescripcionItem(String _descripcionItem) {
        this._descripcionItem = _descripcionItem;
    }
    /**
     * @param _fechaModificacion the _fechaModificacion to set
     */
    public void setFechaModificacion(String _fechaModificacion) {
        this._fechaModificacion = _fechaModificacion;
    }
    /**
     * @param _idModeloAnio the _idModeloAnio to set
     */
    public void setIdModeloAnio(Long _idModeloAnio) {
        this._idModeloAnio = _idModeloAnio;
    }
    /**
     * @param _id the _id to set
     */
    public void setId(Long _id) {
        this._id = _id;
    }
    /**
     * @param _item the _item to set
     */
    public void setItem(String _item) {
        this._item = _item;
    }
    /**
     * @param _tipoTraccion the _tipoTraccion to set
     */
    public void setTipoTraccion(String _tipoTraccion) {
        this._tipoTraccion = _tipoTraccion;
    }
    /**
     * @param _beneficios the _beneficios to set
     */
    public void setBeneficios(String _beneficios) {
        this._beneficios = _beneficios;
    }

    public static MantencionBase fromRS(ResultSet p_rs) throws SQLException {
        MantencionBase ret = new MantencionBase();

        ret.setDiasEntreMantenciones(p_rs.getInt("dias_entre_mantenciones"));
        ret.setTipoTransmision(p_rs.getString("tipo_transmision"));
        ret.setCodigoMotor(p_rs.getString("codigo_motor"));
        ret.setKmEntreMantenciones(p_rs.getInt("km_entre_mantenciones"));
        ret.setDependeKm(p_rs.getByte("depende_km"));
        ret.setAccion(p_rs.getString("accion"));
        ret.setUrl(p_rs.getString("url"));
        ret.setDescripcionItem(p_rs.getString("descripcion_item"));
        ret.setFechaModificacion(p_rs.getString("fecha_modificacion"));
        ret.setIdModeloAnio(p_rs.getLong("id_modelo_anio"));
        ret.setId(p_rs.getLong("id"));
        ret.setItem(p_rs.getString("item"));
        ret.setTipoTraccion(p_rs.getString("tipo_traccion"));
        ret.setBeneficios(p_rs.getString("beneficios"));

        return ret;
    }

    public static MantencionBase getByParameter(Connection p_conn, String p_key, String p_value) throws SQLException {
        MantencionBase ret = null;
        
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

    public static MantencionBase getById(Connection p_conn, String p_id) throws Exception {
        return getByParameter(p_conn, "id_mantencion_base", p_id);
    }
    
    public static ArrayList<MantencionBase> seek(Connection p_conn, ArrayList<AbstractMap.SimpleEntry<String, String>> p_parameters, String p_order, String p_direction, int p_offset, int p_limit) throws Exception {
        Statement stmt = null;
        ResultSet rs = null;
        String str_sql;
        ArrayList<MantencionBase> ret;
        
        str_sql = "";
        
        try {
            ArrayList<String> array_clauses = new ArrayList<String>();
            
            ret = new ArrayList<MantencionBase>();
            
            str_sql = _str_sql;
            
            for (AbstractMap.SimpleEntry<String, String> p : p_parameters) {
                if (p.getKey().equals("id_mantencion_base")) {
                    array_clauses.add("ma.id_mantencion_base = " + p.getValue());
                }
                else if (p.getKey().equals("id_modelo_anio")) {
                    array_clauses.add("ma.id_modelo_anio = " + p.getValue());
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
            "    UPDATE mantencion_base" +
            "    SET" +
            "    dias_entre_mantenciones = " + (_diasEntreMantenciones != null ? _diasEntreMantenciones : "null") + "," +
            "    tipo_transmision = " + (_tipoTransmision != null ? "'" + _tipoTransmision + "'" : "null") + "," +
            "    codigo_motor = " + (_codigoMotor != null ? "'" + _codigoMotor + "'" : "null") + "," +
            "    km_entre_mantenciones = " + (_kmEntreMantenciones != null ? _kmEntreMantenciones : "null") + "," +
            "    depende_km = " + (_dependeKm != null ? _dependeKm : "null") + "," +
            "    accion = " + (_accion != null ? "'" + _accion + "'" : "null") + "," +
            "    url = " + (_url != null ? "'" + _url + "'" : "null") + "," +
            "    descripcion_item = " + (_descripcionItem != null ? "'" + _descripcionItem + "'" : "null") + "," +
            "    fecha_modificacion = " + (_fechaModificacion != null ? "'" + _fechaModificacion + "'" : "null") + "," +
            "    item = " + (_item != null ? "'" + _item + "'" : "null") + "," +
            "    tipo_traccion = " + (_tipoTraccion != null ? "'" + _tipoTraccion + "'" : "null") + "," +
            "    beneficios = " + (_beneficios != null ? "'" + _beneficios + "'" : "null") +
            "    WHERE" +
            "    id_mantencion_base = " + Long.toString(this._id);

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
            "    INSERT INTO mantencion_base" +
            "    (" +
            "    dias_entre_mantenciones, " +
            "    tipo_transmision, " +
            "    codigo_motor, " +
            "    km_entre_mantenciones, " +
            "    depende_km, " +
            "    accion, " +
            "    url, " +
            "    descripcion_item, " +
            "    id_modelo_anio, " +
            "    id_mantencion_base, " +
            "    item, " +
            "    tipo_traccion, " +
            "    beneficios)" +
            "    VALUES" +
            "    (" +
            "    " + (_diasEntreMantenciones != null ? "'" + _diasEntreMantenciones + "'" : "null") + "," +
            "    " + (_tipoTransmision != null ? "'" + _tipoTransmision + "'" : "null") + "," +
            "    " + (_codigoMotor != null ? "'" + _codigoMotor + "'" : "null") + "," +
            "    " + (_kmEntreMantenciones != null ? "'" + _kmEntreMantenciones + "'" : "null") + "," +
            "    " + (_dependeKm != null ? "'" + _dependeKm + "'" : "null") + "," +
            "    " + (_accion != null ? "'" + _accion + "'" : "null") + "," +
            "    " + (_url != null ? "'" + _url + "'" : "null") + "," +
            "    " + (_descripcionItem != null ? "'" + _descripcionItem + "'" : "null") + "," +
            "    " + (_idModeloAnio != null ? "'" + _idModeloAnio + "'" : "null") + "," +
            "    " + (_id != null ? "'" + _id + "'" : "null") + "," +
            "    " + (_item != null ? "'" + _item + "'" : "null") + "," +
            "    " + (_tipoTraccion != null ? "'" + _tipoTraccion + "'" : "null") + "," +
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
            "    DELETE FROM mantencion_base" +
            "    WHERE" +
            "    id_mantencion_base = " + Long.toString(this._id);

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
        MantencionBase obj = null;
        
        String str_sql = _str_sql +
            "    WHERE" +
            "    id_mantencion_base = " + Long.toString(this._id) +
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

                _diasEntreMantenciones = obj.getDiasEntreMantenciones();
                _tipoTransmision = obj.getTipoTransmision();
                _codigoMotor = obj.getCodigoMotor();
                _kmEntreMantenciones = obj.getKmEntreMantenciones();
                _dependeKm = obj.getDependeKm();
                _accion = obj.getAccion();
                _url = obj.getUrl();
                _descripcionItem = obj.getDescripcionItem();
                _fechaModificacion = obj.getFechaModificacion();
                _idModeloAnio = obj.getIdModeloAnio();
                _item = obj.getItem();
                _tipoTraccion = obj.getTipoTraccion();
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
        return "MantencionBase [" +
	           "    _diasEntreMantenciones = " + (_diasEntreMantenciones != null ? _diasEntreMantenciones : "null") + "," +
	           "    _tipoTransmision = " + (_tipoTransmision != null ? "'" + _tipoTransmision + "'" : "null") + "," +
	           "    _codigoMotor = " + (_codigoMotor != null ? "'" + _codigoMotor + "'" : "null") + "," +
	           "    _kmEntreMantenciones = " + (_kmEntreMantenciones != null ? _kmEntreMantenciones : "null") + "," +
	           "    _dependeKm = " + (_dependeKm != null ? _dependeKm : "null") + "," +
	           "    _accion = " + (_accion != null ? "'" + _accion + "'" : "null") + "," +
	           "    _url = " + (_url != null ? "'" + _url + "'" : "null") + "," +
	           "    _descripcionItem = " + (_descripcionItem != null ? "'" + _descripcionItem + "'" : "null") + "," +
	           "    _fechaModificacion = " + (_fechaModificacion != null ? "'" + _fechaModificacion + "'" : "null") + "," +
	           "    _idModeloAnio = " + (_idModeloAnio != null ? _idModeloAnio : "null") + "," +
	           "    _id = " + (_id != null ? _id : "null") + "," +
	           "    _item = " + (_item != null ? "'" + _item + "'" : "null") + "," +
	           "    _tipoTraccion = " + (_tipoTraccion != null ? "'" + _tipoTraccion + "'" : "null") + "," +
	           "    _beneficios = " + (_beneficios != null ? "'" + _beneficios + "'" : "null") +
			   "]";
    }


    public String toJSON() {
        return "{\"MantencionBase\" : {" +
	           "    \"_diasEntreMantenciones\" : " + (_diasEntreMantenciones != null ? _diasEntreMantenciones : "null") + "," +
	           "    \"_tipo_transmision\" : " + (_tipoTransmision != null ? "\"" + _tipoTransmision + "\"" : "null") + "," +
	           "    \"_codigo_motor\" : " + (_codigoMotor != null ? "\"" + _codigoMotor + "\"" : "null") + "," +
	           "    \"_kmEntreMantenciones\" : " + (_kmEntreMantenciones != null ? _kmEntreMantenciones : "null") + "," +
	           "    \"_dependeKm\" : " + (_dependeKm != null ? _dependeKm : "null") + "," +
	           "    \"_accion\" : " + (_accion != null ? "\"" + _accion + "\"" : "null") + "," +
	           "    \"_url\" : " + (_url != null ? "\"" + _url + "\"" : "null") + "," +
	           "    \"_descripcion_item\" : " + (_descripcionItem != null ? "\"" + _descripcionItem + "\"" : "null") + "," +
	           "    \"_fecha_modificacion\" : " + (_fechaModificacion != null ? "\"" + _fechaModificacion + "\"" : "null") + "," +
	           "    \"_idModeloAnio\" : " + (_idModeloAnio != null ? _idModeloAnio : "null") + "," +
	           "    \"_id\" : " + (_id != null ? _id : "null") + "," +
	           "    \"_item\" : " + (_item != null ? "\"" + _item + "\"" : "null") + "," +
	           "    \"_tipo_traccion\" : " + (_tipoTraccion != null ? "\"" + _tipoTraccion + "\"" : "null") + "," +
	           "    \"_beneficios\" : " + (_beneficios != null ? "\"" + _beneficios + "\"" : "null") +
			   "}}";
    }

}
