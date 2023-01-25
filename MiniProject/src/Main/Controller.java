package Main;

import java.util.ArrayList;






public class Controller {
	
	BabyDAO dao = new BabyDAO();
	//회원가입 컨트롤러
	public void join(BabyDTO dto) {
		int row = dao.join(dto);
		if (row > 0) {
			System.out.println("회원가입 성공!! 로그인 후 이용해주세요");
		} else {
			System.out.println("회원가입 실패");
		}
	}
	// 로그인 컨트롤러
	public void login(BabyDTO dto) {
		boolean result = dao.login(dto); 
		if (result) {
			System.out.println("로그인 성공!! 즐거운 플레이 되세요!!");
		} else {
			System.out.println("로그인 실패 아이디와 비밀번호를 확인해주세요!!");
		}

	}
	// 아이디 만들때 baby테이블에 자동으로 default값을 넣는 것
	public void NewBaby(BabyDTO dto) {
		int row = dao.NewBaby(dto);
		if (row > 0) {
			System.out.println("오둥이 입양 성공!!");
		} else {
			System.out.println("오둥이 입양 실패ㅠㅠ");
		}		
	}
	

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
	
	// 랭킹 출력
	public void printRank() {
		BabyDAO dao = new BabyDAO();
		ArrayList<BabyDTO> list = dao.printRank();

		for (int i = 0; i < list.size(); i++) {
			System.out.printf(i + 1 + ". 아기 이름 %d\t", list.get(i).getbName());
			System.out.printf("아기 나이 %d\t", list.get(i).getAge());
			System.out.printf("아기 성장률 %d\t", list.get(i).getGrowth());
			System.out.printf("ID %d\t", list.get(i).getId());
		}
	}
}
