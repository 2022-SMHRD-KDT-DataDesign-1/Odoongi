package Main;

import java.util.ArrayList;


public class Controller {

	public void sleep(BabyDTO dto) {
		BabyDAO dao = new BabyDAO();
		int row = dao.sleep(dto);

		if (row > 0)
			printBaby(dto);

	}

	public void study(BabyDTO dto) {
		BabyDAO dao = new BabyDAO();
		int row = dao.study(dto);

		if (row > 0)
			printBaby(dto);

	}

	// 현재 상태 출력
	public void printBaby(BabyDTO dto) {
		BabyDAO dao = new BabyDAO();
		ArrayList<BabyDTO> list = dao.printBaby(dto);

		for (int i = 0; i < list.size(); i++) {
			System.out.printf("피로도 %d\t", list.get(i).getTired());
			System.out.printf("포만감 %d\t", list.get(i).getHungry());
			System.out.printf("지루해 %d\t", list.get(i).getBoring());
			System.out.printf("지식 %d\n", list.get(i).getKnowledge());
		}

	}
	
	// 게임 오버 판단
	public boolean isGameOver(BabyDTO dto) {
		
		int tired = dto.getTired();
		int hungry = dto.getHungry();
		int boring = dto.getBoring();
		int knowledge = dto.getKnowledge();
		
		if (tired >= 50 || hungry <= 50 || boring >= 50 || knowledge <= 50) {
			return false;
		}
		
		return true;
	}
}
