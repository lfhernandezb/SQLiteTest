package cl.dsoft.dbtest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import bd.Combustible;
import bd.MantencionUsuario;
import bd.MantencionUsuarioHecha;
import bd.Marca;
import bd.Recordatorio;
import bd.Rendimiento;
import bd.Reparacion;
import bd.Usuario;
import bd.Vehiculo;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {
	
	java.sql.Connection conn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		//Marca marca;
		Combustible c;
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		try {
			
			copiarBaseDatos();
			
			//Class.forName("org.sqldroid.SQLDroidDriver");
			//conn = DriverManager.getConnection("jdbc:sqldroid:" + "/data/data/cl.dsoft.dbtest/databases/" + "car.db3");
			String url = "jdbc:sqldroid:" + "/data/data/cl.dsoft.dbtest/" + "car.db3";
			
			conn = new org.sqldroid.SQLDroidDriver().connect(url , new Properties());
			
		    
		    try {
		    	
		    	conn.setAutoCommit(false);
		    	
		    	//marca = Marca.getById(conn, "1");
		    	
		    	//Log.e("CLAC", "Nombre=" + marca.get_descripcion());
		    	/*
		    	c = new Combustible();
		    	
		    	c.set_id((byte) 101);
		    	c.set_descripcion("gas");
		    	
		    	c.insert(conn);
		    	*/
		    	
		    	Usuario u = new Usuario();
		    	
		    	u.setId(1L);
		    	u.setIdComuna(1L);
		    	
		    	u.insert(conn);
		    	
		    	u.setNombre("Violetta");

		    	u.update(conn);
		    	
		    	Vehiculo v = new Vehiculo();
		    	
		    	v.setIdVehiculo(1L);
		    	v.setIdUsuario(u.getId());
		    	v.setIdModelo(1L);
		    	v.setIdTipoTransmision(2);
		    	v.setIdCombustible(2);
		    	v.setIdTraccion(3);
		    	v.setAlias("Toco");
		    	
		    	v.insert(conn);
		    	
		    	System.out.println(v.toString());
		    	
		    	//System.out.println(v.toJSON());
		    	
		    	v.setAnio(2004);
		    	
		    	v.update(conn);

		    	System.out.println(v.toString());
		    	
		    	//System.out.println(v.toJSON());
		    	
		    	Reparacion rep = new Reparacion();
		    	
		    	rep.setIdReparacion(1L);
		    	rep.setIdUsuario(u.getId());
		    	rep.setIdVehiculo(v.getIdVehiculo());
		    	rep.setTitulo("titulo");
		    	rep.setDescripcion("descripcion");
		    	
		    	rep.insert(conn);
		    	
		    	Recordatorio rec = new Recordatorio();
		    	
		    	rec.setIdRecordatorio(1L);
		    	rec.setIdUsuario(u.getId());
		    	rec.setIdVehiculo(v.getIdVehiculo());
		    	rec.setKm(100000);
		    	rec.setTitulo("titulo");
		    	rec.setDescripcion("descripcion");
		    	
		    	rec.insert(conn);
		    	
		    	MantencionUsuario mu = new MantencionUsuario();
		    	
		    	mu.setIdMantencionUsuario(1L);
		    	mu.setIdUsuario(u.getId());
		    	mu.setIdVehiculo(v.getIdVehiculo());
		    	mu.setNombre("nombre");
		    	mu.setDescripcion("descripcion");
		    	
		    	mu.insert(conn);
		    	
		    	MantencionUsuarioHecha muh = new MantencionUsuarioHecha();
		    	
		    	muh.setIdMantencionUsuarioHecha(1L);
		    	muh.setIdUsuario(u.getId());
		    	muh.setIdMantencionUsuario(mu.getIdMantencionUsuario());
		    	
		    	muh.insert(conn);
		    	
		    	Rendimiento ren = new Rendimiento();
		    	
		    	ren.setIdRendimiento(1L);
		    	ren.setIdUsuario(u.getId());
		    	ren.setIdVehiculo(v.getIdVehiculo());
		    	
		    	ren.insert(conn);
		    	
		    	v.setBorrado((byte) 1); 
		    	
		    	conn.commit();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		    	Log.e("CLAC", "Error. No existe id=1" + e.toString());
		    	
		    	conn.rollback();
		    	
		    	/*
		    	try {
					conn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    	return;
		    	*/
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		    	Log.e("CLAC", "Error. No existe id=1" + e.toString());
		    	/*
		    	try {
					conn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    	return;
		    	*/
			}
		    finally {
		    	conn.close();
		    }
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	 private void copiarBaseDatos() {
	        String ruta = "/data/data/cl.dsoft.dbtest/";
	        String archivo = "car.db3";
	        File archivoDB = new File(ruta + archivo);
	        if (!archivoDB.exists()) {
		        try {
		            InputStream IS = getApplicationContext().getAssets().open(archivo);
		            OutputStream OS = new FileOutputStream(archivoDB);
		            byte[] buffer = new byte[1024];
		            int length = 0;
		            while ((length = IS.read(buffer))>0){
		                OS.write(buffer, 0, length);
		            }
		            OS.flush();
		            OS.close();
		            IS.close();
		        } catch (FileNotFoundException e) {
		            Log.e("ERROR", "Archivo no encontrado, " + e.toString());
		        } catch (IOException e) {
		            Log.e("ERROR", "Error al copiar la Base de Datos, " + e.toString());
		        }
		    }
		 }


}
