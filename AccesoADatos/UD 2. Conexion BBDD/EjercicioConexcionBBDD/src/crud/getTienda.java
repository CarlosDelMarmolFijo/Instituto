package crud;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class getTienda {

	public static void main(String[] args) {

		conexion.conectar();
		conexion.desconectar();

		try {
			String consulta = "select * from tienda";
			PreparedStatement ps = conexion.conectar().prepareStatement(consulta);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt(1);
				String nombre = rs.getString(2);
				String apellido = rs.getString(3);

				System.out.println("El id es: " + id + " el nombre es: " + nombre + " el apellido es: " + apellido);
			}

			ps.close();
		} catch (SQLException e) {
			System.out.println(e);
		}

	}
}
