package restaurant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Conector {
 
//	Atributos de clase
	
	private static Connection con;
	private static Conector INSTANCE =null;
	
	// Constructor
	
	private Conector(){
		
	}
	 //crear instancia
	
	private synchronized static void crearInstancia(){
		if(INSTANCE == null){
			INSTANCE = new Conector();
			crearConexion();
		}
	}
	
	// obtener instancia
	public static Conector getInstancia(){
	if (INSTANCE ==null){
		crearInstancia();
	} 
	return INSTANCE;
	}
		
	
	//crear conexion
	
	
	private static void crearConexion(){
		String host = "127.0.0.1";
		String user = "nicky";
		String password = "Hopeinthegalaxy";
		String dataBase = "cuarentena";
		try {
			// importando libreria de conexion
			Class.forName("com.mysql.jdbc.Driver");
			//Url de conexion
			String urlConexion = "jdbc:mysql://" + host +"/" 
			+dataBase+"?user="+user+"&password="+password;
			con = DriverManager.getConnection(urlConexion);
			System.out.println("Al fin, ya era hora");
		}catch (Exception e){
			System.out.println("Error al conectar");
		}
	}
	
	public ArrayList<String> getPaciente() throws SQLException{
		ArrayList<String> listaPacientes=new ArrayList<String>();
		PreparedStatement ps =con.prepareStatement("select persona.nombres from persona inner join paciente on paciente.personaID=persona.CI;");
		ResultSet rs= ps.executeQuery();
		while(rs.next()){
			listaPacientes.add(rs.getString("nombres"));
		}
		rs.close();
		return listaPacientes;
	}

	public ArrayList<List<String>> getDocYCon() throws SQLException{
		ArrayList<List<String>> listaDocYCon=new ArrayList<List<String>>();
		PreparedStatement ps =con.prepareStatement("select persona.nombres, persona.apellidos,consultorio.nro as Numeroconsultorio,consultorio.piso,consultorio.ID as consultorioID from persona inner join doctor on persona.CI=doctor.personaID inner join consultorio on doctor.consultorioID=consultorio.ID;");
		ResultSet rs= ps.executeQuery();
		for (int i=0;i<5;i++){
			listaDocYCon.add(new ArrayList<String>());
		}
		while(rs.next()){
			for (int i=0;i<5;i++){
				if (i==0){
					 listaDocYCon.get(i).add(rs.getString("nombres"));
				}else if (i==1){
					listaDocYCon.get(i).add(rs.getString("apellidos"));
				} else if (i==2){
					 listaDocYCon.get(i).add(rs.getString("Numeroconsultorio"));
				} else if (i==3){
					 listaDocYCon.get(i).add(rs.getString("piso"));
				} else {
					 listaDocYCon.get(i).add(rs.getString("consultorioID"));
				}
			}
		}
		rs.close();
		return listaDocYCon;
	}

	
	

}
