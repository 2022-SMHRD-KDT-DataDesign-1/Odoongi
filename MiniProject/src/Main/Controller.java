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
	public boolean login(BabyDTO dto) {
		boolean result = dao.login(dto); 
		if (result) {
			System.out.println("로그인 성공!! 즐거운 플레이 되세요!!");
			return true;
		} else {
			System.out.println("로그인 실패 아이디와 비밀번호를 확인해주세요!!");
			return false;
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
	
	public void hungry(BabyDTO dto) {
		BabyDAO dao = new BabyDAO();
		int row = dao.hungry(dto);

		if (row > 0)
			printBaby(dto);

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
		BabyDTO dto2 = dao.printBaby(dto);

		System.out.printf("피로도 %d\t", dto2.getTired());
		System.out.printf("포만감 %d\t", dto2.getHungry());
		System.out.printf("지루해 %d\t", dto2.getBoring());
		System.out.printf("지식 %d\n", dto2.getKnowledge());

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
		
		System.out.println("순위  아기 이름 \t 아기 나이 \t아기 성장률 \tID \t");
		
		for (int i = 0; i < list.size(); i++) {
			System.out.print(i + 1 + ".   " + list.get(i).getbName() + " \t ");
			System.out.print(list.get(i).getAge() + " \t \t");
			System.out.print(list.get(i).getGrowth() + " \t \t");
			System.out.println(list.get(i).getId() + " \t");
		}
		System.out.println();
	}
}
