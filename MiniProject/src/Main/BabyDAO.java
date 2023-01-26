package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class BabyDAO {

	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;

	public void getCon() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@gjaischool-b.ddns.net:1525:xe";
			String user = "campus_d_0120_3";
			String pwd = "smhrd3";

			conn = DriverManager.getConnection(url, user, pwd);

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("데이터베이스 연결 실패");
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

	
	public int join(BabyDTO dto) {
		int row = 0;
		Scanner sc = new Scanner(System.in);

		try {
			getCon();
			String sql = "insert into USER_INFO values (?,?,default)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPwd());
			row = psmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("SQL 전송 실패");
			e.printStackTrace();
		} finally {
			getClose();
		}
		return row;

	}
	
	
	public int NewBaby (BabyDTO dto) {
		int row = 0;
		
		try {
			getCon();
			String sql = "insert into baby values (?, 0, ? ,default, 0, 100, 100, 100, 100, 100)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getbName());
			psmt.setString(2, dto.getId());
			row = psmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("SQL 전송 실패");
			e.printStackTrace();
		} finally {
			getClose();
		}
		return row;
		
		
	}
	
	public boolean login(BabyDTO dto) {

		getCon();
		boolean result = false;

		try {
			String sql = "select * from USER_INFO where id = ? and password = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPwd());
			rs = psmt.executeQuery();

			result = rs.next();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			getClose();
		}
		return result;

	}
	
	// 랭킹 조회
	public ArrayList<BabyDTO> printRank() {
		ArrayList<BabyDTO> list = new ArrayList<>();

		getCon();

		try {
			String sql = "SELECT * FROM ( SELECT NAME, AGE, ID, GROWTH FROM BABY WHERE AGE IS NOT NULL ORDER BY AGE, GROWTH DESC) WHERE ROWNUM <= 10";
			psmt = conn.prepareStatement(sql);

			rs = psmt.executeQuery();

			while (rs.next()) {
				String bName = rs.getString("name");
				int age = rs.getInt("age");
				String id = rs.getString("id");
				int growth = rs.getInt("growth");

				BabyDTO dto2 = new BabyDTO(bName, age, id, growth);
				list.add(dto2);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			getClose();
		}

		return list;
	}
	
	
	
	
	
	
	
	
	private int updateBaby(BabyDTO dto, int row) {
		try {
			getCon();

			String sql = "UPDATE BABY SET GROWTH = ?, TIRED = ?, HUNGRY = ?, BORING = ?, KNOWLEDGE = ?"
					+ "WHERE ID = ?";
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

	// 잠자기
	public int sleep(BabyDTO dto) {

		int row = 0;

		dto.setTired(dto.getTired() - 90);
		dto.setHungry(dto.getHungry() - 90);
		dto.setKnowledge(dto.getKnowledge() - 30);
		dto.setGrowth(dto.getGrowth() + 1);

		row = updateBaby(dto, row);

		return row;
	}

	// 공부하기
	public int study(BabyDTO dto) {

		int row = 0;

		dto.setTired(dto.getTired() + 80);
		dto.setHungry(dto.getHungry() - 30);
		dto.setBoring(dto.getBoring() + 50);
		dto.setKnowledge(dto.getKnowledge() + 50);
		dto.setGrowth(dto.getGrowth() + 1);

		row = updateBaby(dto, row);

		return row;
	}
	
	
	// 현재 상태 출력
	public BabyDTO printBaby(BabyDTO dto) {
		
		getCon();

		try {

			String sql = "SELECT TIRED, HUNGRY, BORING, KNOWLEDGE FROM BABY WHERE ID = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());

			rs = psmt.executeQuery();

			while (rs.next()) {
				int tired = rs.getInt(1);
				int hungry = rs.getInt(2);
				int boring = rs.getInt(3);
				int knowldege = rs.getInt(4);

				dto = new BabyDTO(tired, hungry, boring, knowldege);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			getClose();
		}

		return dto;
	}
}
