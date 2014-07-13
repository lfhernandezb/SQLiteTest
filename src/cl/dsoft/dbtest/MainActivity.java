package cl.dsoft.dbtest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import cl.dsoft.mobile.db.CargaCombustible;
import cl.dsoft.mobile.db.MantencionBaseHecha;
import cl.dsoft.mobile.db.MantencionUsuario;
import cl.dsoft.mobile.db.MantencionUsuarioHecha;
import cl.dsoft.mobile.db.Recordatorio;
import cl.dsoft.mobile.db.Reparacion;
import cl.dsoft.mobile.db.Usuario;
import cl.dsoft.mobile.db.Vehiculo;

//import bd.Combustible;
//import bd.MantencionUsuario;
//import bd.MantencionUsuarioHecha;
//import bd.Marca;
//import bd.Recordatorio;
//import bd.Rendimiento;
//import bd.Reparacion;
//import bd.Usuario;
//import bd.Vehiculo;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	
	java.sql.Connection conn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		//Marca marca;
		//Combustible c;
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button buttonByIdUsuario = (Button) findViewById(R.id.button1);
		
		Button buttonByIdRedSocial = (Button) findViewById(R.id.button2);
		
		buttonByIdUsuario.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			  
			}
		});
		
		buttonByIdRedSocial.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});

		try {
			int i;
			ArrayList<MantencionBaseHecha> list_mbh;
			
			copiarBaseDatos();
			
			//Class.forName("org.sqldroid.SQLDroidDriver");
			//conn = DriverManager.getConnection("jdbc:sqldroid:" + "/data/data/cl.dsoft.dbtest/databases/" + "car.db3");
			String url = "jdbc:sqldroid:" + "/data/data/cl.dsoft.dbtest/" + "car.db3";
			
			conn = new org.sqldroid.SQLDroidDriver().connect(url , new Properties());
			
	    	conn.setAutoCommit(false);
	    	
	    	//marca = Marca.getById(conn, "1");
	    	
	    	//Log.e("CLAC", "Nombre=" + marca.get_descripcion());
	    	
	    	//c = new Combustible();
	    	
	    	//c.set_id((byte) 101);
	    	//c.set_descripcion("gas");
	    	
	    	//c.insert(conn);
	    	
	    	
	    	Usuario u = new Usuario();
	    	
	    	u.setIdComuna(1L);
	    	
	    	u.insert(conn);
	    	
	    	u.setNombre("Violetta");

	    	u.update(conn);
	    	
	    	System.out.println(u.toString());
	    	
	    	Vehiculo v = new Vehiculo();
	    	
	    	v.setIdUsuario(u.getId());
	    	v.setIdModelo(8057399L);
	    	v.setIdTipoTransmision((byte) 2);
	    	v.setIdCombustible((byte) 2);
	    	v.setIdTraccion((byte) 3);
	    	v.setAlias("Toco");
	    	
	    	v.insert(conn);
	    	
	    	System.out.println(v.toString());
	    	
	    	//System.out.println(v.toJSON());
	    	
	    	v.setAnio(2004);
	    	v.setKm(156000);
	    	
	    	v.update(conn);

	    	System.out.println(v.toString());
	    	
	    	//System.out.println(v.toJSON());
	    	
	    	Reparacion rep = new Reparacion();
	    	
	    	//rep.setIdReparacion(1L);
	    	rep.setIdUsuario(u.getId());
	    	rep.setIdVehiculo(v.getIdVehiculo());
	    	rep.setTitulo("titulo");
	    	rep.setDescripcion("descripcion");
	    	
	    	rep.insert(conn);
	    	
	    	Recordatorio rec = new Recordatorio();
	    	
	    	//rec.setIdRecordatorio(1L);
	    	rec.setIdUsuario(u.getId());
	    	rec.setIdVehiculo(v.getIdVehiculo());
	    	rec.setKm(180000);
	    	rec.setTitulo("titulo");
	    	rec.setDescripcion("descripcion");
	    	
	    	rec.insert(conn);
	    	
	    	MantencionUsuario mu = new MantencionUsuario();
	    	
	    	//mu.setIdMantencionUsuario(1L);
	    	mu.setIdUsuario(u.getId());
	    	mu.setIdVehiculo(v.getIdVehiculo());
	    	mu.setNombre("nombre");
	    	mu.setDescripcion("descripcion");
	    	
	    	mu.insert(conn);
	    	
	    	MantencionUsuarioHecha muh = new MantencionUsuarioHecha();
	    	
	    	//muh.setIdMantencionUsuarioHecha(1L);
	    	muh.setIdUsuario(u.getId());
	    	muh.setIdMantencionUsuario(mu.getIdMantencionUsuario());
	    	
	    	muh.insert(conn);
	    	
	    	CargaCombustible cc = new CargaCombustible();
	    	
	    	//cc.setIdCargaCombustible(1L);
	    	cc.setIdUsuario(u.getId());
	    	cc.setIdVehiculo(v.getIdVehiculo());
	    	
	    	cc.insert(conn);
	    	
	    	list_mbh = v.getMantencionesPendientes(conn);
	    	
	    	i = 1;
	    	for (MantencionBaseHecha mbh : list_mbh) {
	    		
	    		switch(i) {
	    		case 1:
	    			mbh.setFecha("2014-01-22");
	    			break;
	    		case 2:
	    			mbh.setFecha("2010-11-30");
	    			break;
	    		case 3:
	    			mbh.setFecha("2011-07-10");
	    			break;
	    		case 4:
	    			mbh.setFecha("1999-12-31");
	    			break;
	    		case 5:
	    			mbh.setFecha("2014-05-05");
	    			break;
	    		}
	    		
	    		i++;
	    		
	    		System.out.println(mbh.toString());
	    		
	    		mbh.insert(conn);
	    		
	    		System.out.println(mbh.toString());
	    	}
	    	
	    	//v.setBorrado(true); 
	    	
	    	conn.commit();

			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
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
