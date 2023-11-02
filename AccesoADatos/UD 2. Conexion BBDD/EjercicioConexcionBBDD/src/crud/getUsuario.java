package crud;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class getUsuario {

	public static void main(String[] args) {
		
		conexion.conectar();
		conexion.desconectar();
		
		try {
			String consulta = "select * from usuarios";
			PreparedStatement ps = conexion.conectar().prepareStatement(consulta);
		
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				String nombre = rs.getString(1);
				String apellido = rs.getString(2);
				int edad = rs.getInt(3);
				int id = rs.getInt(4);
				
				System.out.println("El id es: " + id + " el nombre es: " + nombre + " el apellido es: " + apellido + " y la edad es: " + edad);
			}
			
			ps.close();
		} catch (SQLException e) {
			System.out.println(e);
		}

	}

}
