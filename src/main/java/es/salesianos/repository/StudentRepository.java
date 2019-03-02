package es.salesianos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import es.salesianos.connection.AbstractConnection;
import es.salesianos.connection.H2Connection;
import es.salesianos.model.Student;


@Repository
public class StudentRepository {

	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test";
	AbstractConnection manager = new H2Connection();
	
	public void insert(Student student) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO STUDENT (cod, name)" + "VALUES (?, ?)");
			preparedStatement.setString(1, student.getName());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
	}
	
	public void delete(Student student) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("DELETE FROM STUDENT WHERE cod=?");
			preparedStatement.setInt(1, student.getCod());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
	}
	
	
	public List<Student> selectAllStudent() {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		List<Student> listStudent = new ArrayList<Student>();
		try {
			preparedStatement = conn.prepareStatement("SELECT * FROM STUDENT");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Student studentfromDataBase = new Student();
				studentfromDataBase.setCod(resultSet.getInt(1));
				studentfromDataBase.setName(resultSet.getNString(2));
				listStudent.add(studentfromDataBase);
			}

		} catch (SQLException e) {

			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
		return listStudent;
	}
	
	
	
}
