package cl.dsoft.dbtest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Properties;

import cl.dsoft.mobile.db.CargaCombustible;
import cl.dsoft.mobile.db.MantencionBaseHecha;
import cl.dsoft.mobile.db.MantencionUsuario;
import cl.dsoft.mobile.db.MantencionUsuarioHecha;
import cl.dsoft.mobile.db.Recordatorio;
import cl.dsoft.mobile.db.Rendimiento;
import cl.dsoft.mobile.db.Reparacion;
import cl.dsoft.mobile.db.UnsupportedParameter;
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
			  
				try {
					int i;
					ArrayList<MantencionBaseHecha> list_mbh;
					
					//Class.forName("org.sqldroid.SQLDroidDriver");
					//conn = DriverManager.getConnection("jdbc:sqldroid:" + "/data/data/cl.dsoft.dbtest/databases/" + "car.db3");
					String url = "jdbc:sqldroid:" + "/data/data/cl.dsoft.dbtest/" + "car.db3";
					
					conn = new org.sqldroid.SQLDroidDriver().connect(url , new Properties());
					
			    	conn.setAutoCommit(false);
			    	
			    	conn.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
			    	
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
			    	
			    	Vehiculo ve = new Vehiculo();
			    	
			    	ve.setIdUsuario(u.getId());
			    	ve.setIdModelo(8057399L);
			    	ve.setIdTipoTransmision((byte) 2);
			    	ve.setIdCombustible((byte) 2);
			    	ve.setIdTraccion((byte) 3);
			    	ve.setAlias("Toco");
			    	
			    	ve.insert(conn);
			    	
			    	System.out.println(v.toString());
			    	
			    	//System.out.println(v.toJSON());
			    	
			    	ve.setAnio(2012);
			    	ve.setKm(1500);
			    	
			    	ve.update(conn);

			    	System.out.println(v.toString());
			    	
			    	//System.out.println(v.toJSON());
			    	
			    	Reparacion rep = new Reparacion();
			    	
			    	//rep.setIdReparacion(1L);
			    	rep.setIdUsuario(u.getId());
			    	rep.setIdVehiculo(ve.getIdVehiculo());
			    	rep.setTitulo("titulo");
			    	rep.setDescripcion("descripcion");
			    	
			    	rep.insert(conn);
			    	
			    	Recordatorio rec = new Recordatorio();
			    	
			    	//rec.setIdRecordatorio(1L);
			    	rec.setIdUsuario(u.getId());
			    	rec.setIdVehiculo(ve.getIdVehiculo());
			    	rec.setKm(180000);
			    	rec.setTitulo("titulo");
			    	rec.setDescripcion("descripcion");
			    	
			    	rec.insert(conn);
			    	
			    	MantencionUsuario mu = new MantencionUsuario();
			    	
			    	//mu.setIdMantencionUsuario(1L);
			    	mu.setIdUsuario(u.getId());
			    	mu.setIdVehiculo(ve.getIdVehiculo());
			    	mu.setNombre("nombre");
			    	mu.setDescripcion("descripcion");
			    	mu.setDependeKm(true);
			    	mu.setKmEntreMantenciones(1000);
			    	//mu.setMesesEntreMantenciones();
			    	
			    	mu.insert(conn);
			    	/*
			    	MantencionUsuarioHecha muh = new MantencionUsuarioHecha();
			    	
			    	//muh.setIdMantencionUsuarioHecha(1L);
			    	muh.setIdUsuario(u.getId());
			    	muh.setIdVehiculo(ve.getIdVehiculo());
			    	muh.setIdMantencionUsuario(mu.getIdMantencionUsuario());
			    	
			    	muh.insert(conn);
			    	*/
			    	CargaCombustible cc = new CargaCombustible();
			    	
			    	//cc.setIdCargaCombustible(1L);
			    	cc.setIdUsuario(u.getId());
			    	cc.setIdVehiculo(ve.getIdVehiculo());
			    	cc.setEstanqueLleno(true);
			    	cc.setFecha("2010-01-01");
			    	cc.setKm(100000);
			    	cc.setLitros(70);
			    	
			    	cc.insert(conn);

			    	cc.setIdCargaCombustible(null);
			    	cc.setIdUsuario(u.getId());
			    	cc.setIdVehiculo(ve.getIdVehiculo());
			    	cc.setEstanqueLleno(false);
			    	cc.setFecha("2010-01-15");
			    	cc.setKm(100600);
			    	cc.setLitros(40);
			    	
			    	cc.insert(conn);
			    	
			    	cc.setIdCargaCombustible(null);
			    	cc.setIdUsuario(u.getId());
			    	cc.setIdVehiculo(ve.getIdVehiculo());
			    	cc.setEstanqueLleno(true);
			    	cc.setFecha("2010-01-31");
			    	cc.setKm(101100);
			    	cc.setLitros(70);
			    	
			    	cc.insert(conn);

			    	cc.setIdCargaCombustible(null);
			    	cc.setIdUsuario(u.getId());
			    	cc.setIdVehiculo(ve.getIdVehiculo());
			    	cc.setEstanqueLleno(true);
			    	cc.setFecha("2010-02-15");
			    	cc.setKm(101800);
			    	cc.setLitros(70);
			    	
			    	cc.insert(conn);

			    	cc.setIdCargaCombustible(null);
			    	cc.setIdUsuario(u.getId());
			    	cc.setIdVehiculo(ve.getIdVehiculo());
			    	cc.setEstanqueLleno(false);
			    	cc.setFecha("2010-03-01");
			    	cc.setKm(102300);
			    	cc.setLitros(20);
			    	
			    	cc.insert(conn);

			    	cc.setIdCargaCombustible(null);
			    	cc.setIdUsuario(u.getId());
			    	cc.setIdVehiculo(ve.getIdVehiculo());
			    	cc.setEstanqueLleno(true);
			    	cc.setFecha("2010-04-01");
			    	cc.setKm(102700);
			    	cc.setLitros(70);
			    	
			    	cc.insert(conn);

			    	cc.setIdCargaCombustible(null);
			    	cc.setIdUsuario(u.getId());
			    	cc.setIdVehiculo(ve.getIdVehiculo());
			    	cc.setEstanqueLleno(true);
			    	cc.setFecha("2010-05-01");
			    	cc.setKm(103300);
			    	cc.setLitros(60);
			    	
			    	cc.insert(conn);
			    	
			    	cc.setIdCargaCombustible(null);
			    	cc.setIdUsuario(u.getId());
			    	cc.setIdVehiculo(ve.getIdVehiculo());
			    	cc.setEstanqueLleno(true);
			    	cc.setFecha("2010-06-01");
			    	cc.setKm(103800);
			    	cc.setLitros(50);
			    	
			    	cc.insert(conn);

			    	cc.setIdCargaCombustible(null);
			    	cc.setIdUsuario(u.getId());
			    	cc.setIdVehiculo(ve.getIdVehiculo());
			    	cc.setEstanqueLleno(false);
			    	cc.setFecha("2010-07-01");
			    	cc.setKm(104500);
			    	cc.setLitros(10);
			    	
			    	cc.insert(conn);
			    	
			    	//v.setBorrado(true); 
			    	
			    	conn.commit();

					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
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
		});
		
		buttonByIdRedSocial.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				try {
					int i;
					ArrayList<MantencionBaseHecha> list_mbh;
					ArrayList<MantencionUsuarioHecha> list_muh;
					ArrayList<Rendimiento> list_r;
										
					//Class.forName("org.sqldroid.SQLDroidDriver");
					//conn = DriverManager.getConnection("jdbc:sqldroid:" + "/data/data/cl.dsoft.dbtest/databases/" + "car.db3");
					String url = "jdbc:sqldroid:" + "/data/data/cl.dsoft.dbtest/" + "car.db3";
					
					conn = new org.sqldroid.SQLDroidDriver().connect(url , new Properties());
					
			    	conn.setAutoCommit(false);
			    	
			    	Vehiculo ve = Vehiculo.getByParameter(conn, "id_vehiculo", "1");
			    				    	
			    	list_mbh = ve.getMantencionesBasePendientes(conn);
			    	
			    	i = 1;
			    	for (MantencionBaseHecha mbh : list_mbh) {
			    		
			    		switch(i) {
			    		case 1:
			    			mbh.setFecha("2014-01-22");
			    			break;
			    		case 2:
			    			mbh.setFecha("2010-01-30");
			    			mbh.insert(conn);
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
			    		
			    		//System.out.println(mbh.toString());
			    	}
			    	
			    	list_muh = ve.getMantencionesUsuarioPendientes(conn);
			    	
			    	i = 1;
			    	for (MantencionUsuarioHecha muh : list_muh) {
			    		/*
			    		switch(i) {
			    		case 1:
			    			mbh.setFecha("2014-01-22");
			    			break;
			    		case 2:
			    			mbh.setFecha("2010-01-30");
			    			mbh.insert(conn);
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
			    		*/
			    		System.out.println(muh.toString());
			    		
			    		//System.out.println(mbh.toString());
			    	}

			    	list_r = ve.getRendimiento(conn);
			    	
			    	i = 1;
			    	for (Rendimiento r : list_r) {
			    		/*
			    		switch(i) {
			    		case 1:
			    			mbh.setFecha("2014-01-22");
			    			break;
			    		case 2:
			    			mbh.setFecha("2010-01-30");
			    			mbh.insert(conn);
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
			    		*/
			    		System.out.println(r.toString());
			    		
			    		//System.out.println(mbh.toString());
			    	}
			    	
			    	//v.setBorrado(true); 
			    	
			    	conn.commit();

					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnsupportedParameter e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
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
		});
		
		copiarBaseDatos();

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
