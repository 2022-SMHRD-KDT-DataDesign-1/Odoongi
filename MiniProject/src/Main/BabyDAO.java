package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class BabyDAO {

	Random rd = new Random();

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

	public int NewBaby(BabyDTO dto) {
		int row = 0;

		try {
			getCon();
			String sql = "insert into baby values (?, 0, ? ,default, 0, 0, 100, 0, 100, 100)";
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
			String sql = "SELECT NAME, AGE, A.ID, B_DATE, GROWTH" + ", TIRED, HUNGRY, BORING, KNOWLEDGE"
					+ " FROM BABY A, USER_INFO B" + " WHERE B.ID = ? AND B.PASSWORD = ? AND A.ID = B.ID";

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPwd());
			rs = psmt.executeQuery();

			result = rs.next();

			dto.setAge(rs.getInt("age"));
			dto.setGrowth(rs.getInt("growth"));
			dto.setTired(rs.getInt("tired"));
			dto.setHungry(rs.getInt("hungry"));
			dto.setBoring(rs.getInt("boring"));
			dto.setKnowledge(rs.getInt("knowledge"));

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

	         String sql = "UPDATE BABY SET AGE = ?, GROWTH = ?, TIRED = ?, HUNGRY = ?, BORING = ?, KNOWLEDGE = ?"
	               + "WHERE ID = ?";
	         psmt = conn.prepareStatement(sql);

	         dto.setAge((int)dto.getGrowth()/10);
	         
	         psmt.setInt(1, dto.getAge());
	         psmt.setDouble(2, dto.getGrowth());
	         psmt.setInt(3, dto.getTired() > 100 ? 100 : dto.getTired() < 0 ? 0 : dto.getTired());
	         psmt.setInt(4, dto.getHungry() > 100 ? 100 : dto.getHungry() < 0 ? 0 : dto.getHungry());
	         psmt.setInt(5, dto.getBoring() > 100 ? 100 : dto.getBoring() < 0 ? 0 : dto.getBoring());
	         psmt.setInt(6, dto.getKnowledge() > 100 ? 100 : dto.getKnowledge() < 0 ? 0 : dto.getKnowledge());
	         psmt.setString(7, dto.getId());

	         row = psmt.executeUpdate();

	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         getClose();
	      }
	      return row;
	   }
<<<<<<< HEAD

=======

>>>>>>> 1480cc793c25309f5038ed96a2ede8603320304c
//		try {
//			getCon();
//
//			String sql = "UPDATE BABY SET AGE = ?, GROWTH = ?, TIRED = ?, HUNGRY = ?, BORING = ?, KNOWLEDGE = ?"
//					+ "WHERE ID = ?";
//			psmt = conn.prepareStatement(sql);
//
//			dto.setAge((int) dto.getGrowth() / 10);
//
//			psmt.setInt(1, dto.getAge());
//			psmt.setDouble(2, dto.getGrowth());
//			psmt.setInt(3, dto.getTired());
//			psmt.setInt(4, dto.getHungry());
//			psmt.setInt(5, dto.getBoring());
//			psmt.setInt(6, dto.getKnowledge());
//			psmt.setString(7, dto.getId());
//
//			row = psmt.executeUpdate();
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			getClose();
//		}
//		return row;
//	}

	// 놀기
	public int Play(BabyDTO dto) {
		int row = 0;

		if (gotcha() == 1) {
			dto.setTired(dto.getTired() + 0);
			dto.setHungry(dto.getHungry() - 0);
			dto.setBoring(dto.getBoring() - 30);
			dto.setKnowledge(dto.getKnowledge() - 0);
			dto.setGrowth(dto.getGrowth() + 2.0);
		} else {
			dto.setTired(dto.getTired() + 5);
			dto.setHungry(dto.getHungry() - 15);
			dto.setBoring(dto.getBoring() - 20);
			dto.setKnowledge(dto.getKnowledge() - 15);
			dto.setGrowth(dto.getGrowth() + 1.0);

		}

		row = updateBaby(dto, row);

		return row;
	}

	// 밥먹기
	public int hungry(BabyDTO dto) {
		// test2
		int row = 0;

		if (gotcha() == 1) {
			dto.setTired(dto.getTired() - 0);
			dto.setHungry(dto.getHungry() + 30);
			dto.setKnowledge(dto.getKnowledge() - 0);
			dto.setGrowth(dto.getGrowth() + 2.0);
			dto.setTired(dto.getTired() + 0);
		} else {
			dto.setTired(dto.getTired() + 15);
			dto.setHungry(dto.getHungry() + 20);
			dto.setKnowledge(dto.getKnowledge() - 5);
			dto.setTired(dto.getBoring() + 5);
			dto.setGrowth(dto.getGrowth() + 1.0);
		}

		row = updateBaby(dto, row);

		return row;
	}

	// 잠자기
	public int sleep(BabyDTO dto) {

		int row = 0;

		if (gotcha() == 1) {
			dto.setTired(dto.getTired() - 30);
			dto.setHungry(dto.getHungry() - 0);
			dto.setKnowledge(dto.getKnowledge() - 0);
			dto.setTired(dto.getBoring() + 0);
			dto.setGrowth(dto.getGrowth() + 2.0);
		} else {
			dto.setTired(dto.getTired() - 15);
			dto.setHungry(dto.getHungry() - 5);
			dto.setKnowledge(dto.getKnowledge() - 5);
			dto.setTired(dto.getBoring() + 5);
			dto.setGrowth(dto.getGrowth() + 1.0);

		}

		row = updateBaby(dto, row);

		return row;
	}

	// 공부하기
	public int study(BabyDTO dto) {

		int row = 0;
		if (gotcha() == 1) {

			dto.setTired(dto.getTired() - 0);
			dto.setHungry(dto.getHungry() - 0);
			dto.setBoring(dto.getBoring() + 0);
			dto.setKnowledge(dto.getKnowledge() + 30);
			dto.setGrowth(dto.getGrowth() + 2.0);
		} else {
			dto.setTired(dto.getTired() + 5);
			dto.setHungry(dto.getHungry() - 5);
			dto.setBoring(dto.getBoring() + 15);
			dto.setKnowledge(dto.getKnowledge() + 20);
			dto.setGrowth(dto.getGrowth() + 1.0);
		}

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

			if (rs.next() == true) {
				dto.setTired(rs.getInt(1));
				dto.setHungry(rs.getInt(2));
				dto.setBoring(rs.getInt(3));
				dto.setKnowledge(rs.getInt(4));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			getClose();
		}

		return dto;
	}

	// ----------------------------------------------
	// 가챠
	public int gotcha() {
		int num = rd.nextInt(10) + 1;
		return num;
	}

}