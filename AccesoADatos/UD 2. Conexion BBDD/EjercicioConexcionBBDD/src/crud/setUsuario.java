package crud;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class setUsuario {

public static void main(String[] args) {
		
		conexion.conectar();
		conexion.desconectar();
		
		try {
			String nombre = "carlos";
			String consulta = "select * from usuarios where nombre = ?";
			PreparedStatement ps = conexion.conectar().prepareStatement(consulta);
			
			ps.setString(1, nombre);
		
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
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
