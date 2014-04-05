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
import bd.Marca;
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
		    	//marca = Marca.getById(conn, "1");
		    	
		    	//Log.e("CLAC", "Nombre=" + marca.get_descripcion());
		    	/*
		    	c = new Combustible();
		    	
		    	c.set_id((byte) 101);
		    	c.set_descripcion("gas");
		    	
		    	c.insert(conn);
		    	*/
		    	/*
		    	Usuario u = new Usuario();
		    	
		    	u.set_id(1);
		    	u.set_id_comuna(1);
		    	
		    	u.insert(conn);
		    	
		    	u.set_nombre("Violetta");

		    	u.update(conn);
		    	*/
		    	Vehiculo v = new Vehiculo();
		    	
		    	v.set_id_vehiculo(1);
		    	v.set_id_usuario(1);
		    	v.set_id_modelo(1);
		    	v.set_id_tipo_transmision(2);
		    	v.set_id_combustible(2);
		    	v.set_id_traccion(3);
		    	v.set_alias("Toco");
		    	
		    	v.insert(conn);
		    	
		    	v.set_anio(2004);
		    	
		    	v.update(conn);
		    	
			} catch (SQLException e) {
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
