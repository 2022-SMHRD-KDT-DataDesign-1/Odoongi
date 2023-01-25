package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BabyDAO {

	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;

	public void getCon() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String pwd = "12345";

			conn = DriverManager.getConnection(url, user, pwd);

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("회원가입 : 데이터베이스 연결 실패");
			e.printStackTrace();
		}

	}

	public void getClose() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 잠자기
	public int sleep(BabyDTO dto) {
		
		int row = 0;
		
		dto.setTired(dto.getTired() - 90);
		dto.setBoring(dto.getBoring() - 90);
		dto.setKnowledge(dto.getKnowledge() - 30);
		dto.setGrowth(dto.getGrowth() + 1);

		try {
			getCon();

			String sql = "UPDATE BABY SET GROWTH = ?, TIRED = ?, HUNGRY = ?, BORING = ?, KNOWLEDGE = ?"
					+ "WHERE B_NAME = ?";
			psmt = conn.prepareStatement(sql);

			psmt.setInt(1, dto.getGrowth());
			psmt.setInt(2, dto.getTired());
			psmt.setInt(3, dto.getHungry());
			psmt.setInt(4, dto.getBoring());
			psmt.setInt(5, dto.getKnowledge());
			psmt.setString(6, dto.getbName());

			row = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			getClose();
		}
		
		return row;
	}

	
}
