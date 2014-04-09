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
public class Usuario {
    private String _fechaVencimientoLicencia;
    private Byte _hombre;
    private Byte _borrado;
    private String _telefono;
    private String _fechaModifiacion;
    private String _fechaNacimiento;
    private String _nombre;
    private Long _id;
    private Long _idComuna;
    private String _correo;

    private final static String _str_sql = 
        "    SELECT" +
        "    us.fecha_vencimiento_licencia AS fecha_vencimiento_licencia," +
        "    us.hombre AS hombre," +
        "    us.borrado AS borrado," +
        "    us.telefono AS telefono," +
        "    us.fecha_modifiacion AS fecha_modifiacion," +
        "    us.fecha_nacimiento AS fecha_nacimiento," +
        "    us.nombre AS nombre," +
        "    us.id_usuario AS id," +
        "    us.id_comuna AS id_comuna," +
        "    us.correo AS correo" +
        "    FROM usuario us";

    public Usuario() {
        _fechaVencimientoLicencia = null;
        _hombre = null;
        _borrado = null;
        _telefono = null;
        _fechaModifiacion = null;
        _fechaNacimiento = null;
        _nombre = null;
        _id = null;
        _idComuna = null;
        _correo = null;

    }
    /**
     * @return the _fecha_vencimiento_licencia
     */
    public String getFechaVencimientoLicencia() {
        return _fechaVencimientoLicencia;
    }
    /**
     * @return the _hombre
     */
    public Byte getHombre() {
        return _hombre;
    }
    /**
     * @return the _borrado
     */
    public Byte getBorrado() {
        return _borrado;
    }
    /**
     * @return the _telefono
     */
    public String getTelefono() {
        return _telefono;
    }
    /**
     * @return the _fecha_modifiacion
     */
    public String getFechaModifiacion() {
        return _fechaModifiacion;
    }
    /**
     * @return the _fecha_nacimiento
     */
    public String getFechaNacimiento() {
        return _fechaNacimiento;
    }
    /**
     * @return the _nombre
     */
    public String getNombre() {
        return _nombre;
    }
    /**
     * @return the _id
     */
    public Long getId() {
        return _id;
    }
    /**
     * @return the _id_comuna
     */
    public Long getIdComuna() {
        return _idComuna;
    }
    /**
     * @return the _correo
     */
    public String getCorreo() {
        return _correo;
    }
    /**
     * @param _fechaVencimientoLicencia the _fechaVencimientoLicencia to set
     */
    public void setFechaVencimientoLicencia(String _fechaVencimientoLicencia) {
        this._fechaVencimientoLicencia = _fechaVencimientoLicencia;
    }
    /**
     * @param _hombre the _hombre to set
     */
    public void setHombre(Byte _hombre) {
        this._hombre = _hombre;
    }
    /**
     * @param _borrado the _borrado to set
     */
    public void setBorrado(Byte _borrado) {
        this._borrado = _borrado;
    }
    /**
     * @param _telefono the _telefono to set
     */
    public void setTelefono(String _telefono) {
        this._telefono = _telefono;
    }
    /**
     * @param _fechaModifiacion the _fechaModifiacion to set
     */
    public void setFechaModifiacion(String _fechaModifiacion) {
        this._fechaModifiacion = _fechaModifiacion;
    }
    /**
     * @param _fechaNacimiento the _fechaNacimiento to set
     */
    public void setFechaNacimiento(String _fechaNacimiento) {
        this._fechaNacimiento = _fechaNacimiento;
    }
    /**
     * @param _nombre the _nombre to set
     */
    public void setNombre(String _nombre) {
        this._nombre = _nombre;
    }
    /**
     * @param _id the _id to set
     */
    public void setId(Long _id) {
        this._id = _id;
    }
    /**
     * @param _idComuna the _idComuna to set
     */
    public void setIdComuna(Long _idComuna) {
        this._idComuna = _idComuna;
    }
    /**
     * @param _correo the _correo to set
     */
    public void setCorreo(String _correo) {
        this._correo = _correo;
    }

    public static Usuario fromRS(ResultSet p_rs) throws SQLException {
        Usuario ret = new Usuario();

        ret.setFechaVencimientoLicencia(p_rs.getString("fecha_vencimiento_licencia"));
        ret.setHombre(p_rs.getByte("hombre"));
        ret.setBorrado(p_rs.getByte("borrado"));
        ret.setTelefono(p_rs.getString("telefono"));
        ret.setFechaModifiacion(p_rs.getString("fecha_modifiacion"));
        ret.setFechaNacimiento(p_rs.getString("fecha_nacimiento"));
        ret.setNombre(p_rs.getString("nombre"));
        ret.setId(p_rs.getLong("id"));
        ret.setIdComuna(p_rs.getLong("id_comuna"));
        ret.setCorreo(p_rs.getString("correo"));

        return ret;
    }

    public static Usuario getByParameter(Connection p_conn, String p_key, String p_value) throws SQLException {
        Usuario ret = null;
        
        String str_sql = _str_sql +
            "  WHERE us." + p_key + " = " + p_value +
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

    public static Usuario getById(Connection p_conn, String p_id) throws Exception {
        return getByParameter(p_conn, "id_usuario", p_id);
    }
    
    public static ArrayList<Usuario> seek(Connection p_conn, ArrayList<AbstractMap.SimpleEntry<String, String>> p_parameters, String p_order, String p_direction, int p_offset, int p_limit) throws Exception {
        Statement stmt = null;
        ResultSet rs = null;
        String str_sql;
        ArrayList<Usuario> ret;
        
        str_sql = "";
        
        try {
            ArrayList<String> array_clauses = new ArrayList<String>();
            
            ret = new ArrayList<Usuario>();
            
            str_sql = _str_sql;
            
            for (AbstractMap.SimpleEntry<String, String> p : p_parameters) {
                if (p.getKey().equals("id_usuario")) {
                    array_clauses.add("us.id_usuario = " + p.getValue());
                }
                else if (p.getKey().equals("id_comuna")) {
                    array_clauses.add("us.id_comuna = " + p.getValue());
                }
                else if (p.getKey().equals("no borrado")) {
                    array_clauses.add("us.borrado = 0");
                }
                else if (p.getKey().equals("borrado")) {
                    array_clauses.add("us.borrado = 1");
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
            "    UPDATE usuario" +
            "    SET" +
            "    fecha_vencimiento_licencia = " + (_fechaVencimientoLicencia != null ? "'" + _fechaVencimientoLicencia + "'" : "null") + "," +
            "    hombre = " + (_hombre != null ? _hombre : "null") + "," +
            "    borrado = " + (_borrado != null ? _borrado : "null") + "," +
            "    telefono = " + (_telefono != null ? "'" + _telefono + "'" : "null") + "," +
            "    fecha_modifiacion = " + (_fechaModifiacion != null ? "'" + _fechaModifiacion + "'" : "null") + "," +
            "    fecha_nacimiento = " + (_fechaNacimiento != null ? "'" + _fechaNacimiento + "'" : "null") + "," +
            "    nombre = " + (_nombre != null ? "'" + _nombre + "'" : "null") + "," +
            "    correo = " + (_correo != null ? "'" + _correo + "'" : "null") +
            "    WHERE" +
            "    id_usuario = " + Long.toString(this._id);

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
            "    INSERT INTO usuario" +
            "    (" +
            "    fecha_vencimiento_licencia, " +
            "    hombre, " +
            "    telefono, " +
            "    fecha_nacimiento, " +
            "    nombre, " +
            "    id_usuario, " +
            "    id_comuna, " +
            "    correo)" +
            "    VALUES" +
            "    (" +
            "    " + (_fechaVencimientoLicencia != null ? "'" + _fechaVencimientoLicencia + "'" : "null") + "," +
            "    " + (_hombre != null ? "'" + _hombre + "'" : "null") + "," +
            "    " + (_telefono != null ? "'" + _telefono + "'" : "null") + "," +
            "    " + (_fechaNacimiento != null ? "'" + _fechaNacimiento + "'" : "null") + "," +
            "    " + (_nombre != null ? "'" + _nombre + "'" : "null") + "," +
            "    " + (_id != null ? "'" + _id + "'" : "null") + "," +
            "    " + (_idComuna != null ? "'" + _idComuna + "'" : "null") + "," +
            "    " + (_correo != null ? "'" + _correo + "'" : "null") +
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
            "    DELETE FROM usuario" +
            "    WHERE" +
            "    id_usuario = " + Long.toString(this._id);

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
        Usuario obj = null;
        
        String str_sql = _str_sql +
            "    WHERE" +
            "    id_usuario = " + Long.toString(this._id) +
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

                _fechaVencimientoLicencia = obj.getFechaVencimientoLicencia();
                _hombre = obj.getHombre();
                _borrado = obj.getBorrado();
                _telefono = obj.getTelefono();
                _fechaModifiacion = obj.getFechaModifiacion();
                _fechaNacimiento = obj.getFechaNacimiento();
                _nombre = obj.getNombre();
                _idComuna = obj.getIdComuna();
                _correo = obj.getCorreo();
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
        return "Usuario [" +
	           "    _fechaVencimientoLicencia = " + (_fechaVencimientoLicencia != null ? "'" + _fechaVencimientoLicencia + "'" : "null") + "," +
	           "    _hombre = " + (_hombre != null ? _hombre : "null") + "," +
	           "    _borrado = " + (_borrado != null ? _borrado : "null") + "," +
	           "    _telefono = " + (_telefono != null ? "'" + _telefono + "'" : "null") + "," +
	           "    _fechaModifiacion = " + (_fechaModifiacion != null ? "'" + _fechaModifiacion + "'" : "null") + "," +
	           "    _fechaNacimiento = " + (_fechaNacimiento != null ? "'" + _fechaNacimiento + "'" : "null") + "," +
	           "    _nombre = " + (_nombre != null ? "'" + _nombre + "'" : "null") + "," +
	           "    _id = " + (_id != null ? _id : "null") + "," +
	           "    _idComuna = " + (_idComuna != null ? _idComuna : "null") + "," +
	           "    _correo = " + (_correo != null ? "'" + _correo + "'" : "null") +
			   "]";
    }


    public String toJSON() {
        return "{\"Usuario\" : {" +
	           "    \"_fecha_vencimiento_licencia\" : " + (_fechaVencimientoLicencia != null ? "\"" + _fechaVencimientoLicencia + "\"" : "null") + "," +
	           "    \"_hombre\" : " + (_hombre != null ? _hombre : "null") + "," +
	           "    \"_borrado\" : " + (_borrado != null ? _borrado : "null") + "," +
	           "    \"_telefono\" : " + (_telefono != null ? "\"" + _telefono + "\"" : "null") + "," +
	           "    \"_fecha_modifiacion\" : " + (_fechaModifiacion != null ? "\"" + _fechaModifiacion + "\"" : "null") + "," +
	           "    \"_fecha_nacimiento\" : " + (_fechaNacimiento != null ? "\"" + _fechaNacimiento + "\"" : "null") + "," +
	           "    \"_nombre\" : " + (_nombre != null ? "\"" + _nombre + "\"" : "null") + "," +
	           "    \"_id\" : " + (_id != null ? _id : "null") + "," +
	           "    \"_idComuna\" : " + (_idComuna != null ? _idComuna : "null") + "," +
	           "    \"_correo\" : " + (_correo != null ? "\"" + _correo + "\"" : "null") +
			   "}}";
    }

}
