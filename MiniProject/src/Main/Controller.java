package Main;

import java.util.ArrayList;







public class Controller {
	
	BabyDAO dao = new BabyDAO();
	//회원가입 컨트롤러
	public boolean join(BabyDTO dto) {
	      int row = dao.join(dto);
	      if (row > 0) {
	         System.out.println("회원가입 성공!! 로그인 후 이용해주세요");
	         return true;
	      } else {
	         System.out.println("회원가입 실패!! 다시 입력해주세요");
	         return false;
	      }
	   }
	// 로그인 컨트롤러
	public boolean login(BabyDTO dto) {
		boolean result = dao.login(dto); 
		if (result) {
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
	
	public void Play(BabyDTO dto) {
		// test test
		BabyDAO dao = new BabyDAO();
		int row = dao.Play(dto);
		if (row > 0)
			printBaby(dto);
	}
	//
	public void hungry(BabyDTO dto) {
		// test test
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
		dto = dao.printBaby(dto);
		System.out.println("┌────────────────────────────────────────────────┐\r\n"
				 		 + "|  오둥이 키우기!!　　　　　　　　　　          [ㅡ][口][×]|\r\n" 
				 		 + "|────────────────────────────────────────────────|\r\n"
				 		 + "|  오둥이의 현재 상태                                |");
		System.out.println("|                                                |");
							printGuage("피로도", dto.getTired());
							printGuage("포만감", dto.getHungry());
							printGuage("지루함", dto.getBoring());
							printGuage("지 식", dto.getKnowledge());
				 		 
		System.out.println("|                                                |\r\n"
				 		 + "└────────────────────────────────────────────────┘");
		
//		System.out.printf("피로도 %d 포만감 %d 지루함 %d 지식 %d\n",dto.getTired(), dto.getHungry(), dto.getBoring(),
//				dto.getKnowledge());
	}
	
	public void printGuage(String title, int num) {
		if(num < 0) {
			num = -num;
		}
		System.out.print("|\t");
		System.out.print(title + "\t| ");
		for(int i = 0; i < num / 10; i++) {
			System.out.print("▮");
			if(num / 10 > 10) {
				System.out.println("\t\t |");
				break;
			}
		}
		for(int i = 0; i < 10 - (num / 10); i++) {
			System.out.print("▯");
		}
		System.out.println("\t\t |");
	}
	
//	private void printGuage(String s, int g) {
//		if (g >= 0 && g <= 20) {
//			System.out.printf("%s : ▮▮▯▯▯▯▯▯▯\n", s);
//		} else if (g > 20 && g <= 40) {
//			System.out.printf("%s : ▮▮▮▮▯▯▯▯▯\n", s);
//		} else if (g > 40 && g <= 60) {
//			System.out.printf("%s : ▮▮▮▮▮▯▯▯▯\n", s);
//		} else if (g > 60 && g <= 80) {
//			System.out.printf("%s : ▮▮▮▮▮▮▮▯▯\n", s);
//		} else if (g > 80 && g <= 100) {
//			System.out.printf("%s : ▮▮▮▮▮▮▮▮▮\n", s);
//		}
//	}
	
	// 게임 오버 판단
	public boolean isGameOver(BabyDTO dto) {
		
		int tired = dto.getTired();
		int hungry = dto.getHungry();
		int boring = dto.getBoring();
		int knowledge = dto.getKnowledge();
		
		if (tired >= 60 || hungry <= 40 || boring >= 60 || knowledge <= 40) {
			return false;
		}
		
		return true;
	}
	
	// 랭킹 출력
	public void printRank() {
		BabyDAO dao = new BabyDAO();
		ArrayList<BabyDTO> list = dao.printRank();
		
		System.out.println("순위  아기 이름 \t아기 성장률 \tID \t");
		
		for (int i = 0; i < list.size(); i++) {
			System.out.print(i + 1 + ".   " + list.get(i).getbName() + " \t ");
			System.out.print(list.get(i).getGrowth() + " \t \t");
			System.out.println(list.get(i).getId() + " \t");
		}
		System.out.println();
	}
}