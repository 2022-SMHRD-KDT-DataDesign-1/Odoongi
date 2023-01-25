package Main;

public class Controller {

	
	public void sleep(BabyDTO dto) {
		BabyDAO dao = new BabyDAO();
		int row = dao.sleep(dto);
		
		if (row > 0)
			System.out.println("아기 현재상태 출력");
		
	}
}
