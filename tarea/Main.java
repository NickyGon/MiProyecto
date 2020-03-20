package restaurant;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Conector instancia = Conector.getInstancia();
	try {
		System.out.println("Nombres de Pacientes");
		System.out.println("-----------------------");
		ArrayList<String> listCompanies = instancia.getPaciente();
		for(String paciente:listCompanies){
			System.out.println(paciente);
		}
		System.out.println("-----------------------");
		System.out.println();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	try {
		System.out.println("------------------------------------");
		System.out.println("Nombre | Apellidos | N° | Piso | ID");
		System.out.println("------------------------------------");
		ArrayList<List<String>> listDocyCon = instancia.getDocYCon();
		int i=0;
		while (i<listDocyCon.get(0).size()){
			for (int j=0;j<listDocyCon.size();j++){
				System.out.print(listDocyCon.get(j).get(i) + " | ");
			}
			System.out.println();
			i++;
		}
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	
//	}
/// 1)Crear nuevo usuario en Mysql
/// 2)Conectarse a la base cuarentena con el new user
/// 3)Mostrar los nombres de los pacientes
/// 4)Mostrar el consultorio y nombre de los doctores
	
	
	
	
	
	}
}
