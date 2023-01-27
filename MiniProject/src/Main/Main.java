package Main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Music music = new Music(".\\\\src\\뒹굴뒹굴.mp3");
		Scanner sc = new Scanner(System.in);
		Controller ct = new Controller();
		BabyEmotion baby = new BabyEmotion();

		music.play(music.getMusicPath());

		baby.login();
		System.out.println("┌────────────────────────────────────────────────┐\r\n"
						 + "|  오둥이 키우기!!　　　　　　　　　　          [ㅡ][口][×]|\r\n" 
						 + "|────────────────────────────────────────────────|\r\n"
						 + "|  오둥이 키우기에 오신 것을 환영합니다!!                |\r\n" 
						 + "|                                                |\r\n" 
						 + "|  시작해볼까요?　　　　　　　　　　　　　　　　　　　　　　　　 　|\r\n"
						 + "|                                                |\r\n" 
						 + "|    ┌───────┐　\t \t \t┌───────┐ \t |\r\n"
						 + "|    |넹\t     |   \t \t|응애\t| 　 \t |\r\n"
						 + "|    └───────┘　\t \t \t└───────┘　\t |\r\n"
						 + "└────────────────────────────────────────────────┘");
		System.out.println();
		sc.nextLine();
		music.stop();
		System.out.println();
		System.out.println();
		Music music2 = new Music(".\\\\src\\game.mp3");
		music2.play(music2.getMusicPath());
		// 바꿔보시죠
		while (true) {
//			Music music2 = new Music("C:\\Users\\SMHRD\\Downloads\\game.mp3");
//			music2.play(music2.getMusicPath());
			System.out.println("┌──────────────────────────────────────────────────────────────────┐\r\n"
							 + "|　 오둥이 키우기! 　   　　　　　　　　　      　　　 　　　             [ㅡ][口][×] |\r\n"
							 + "|──────────────────────────────────────────────────────────────────|\r\n"
							 + "|                                                                  |\r\n"
							 + "|                                                                  |\r\n"
							 + "| ┌──────────┐ ┌──────────┐ ┌──────────┐ ┌──────────┐ ┌──────────┐ |\r\n"
							 + "| |[1]로그인   | |[2]회원가입 | |[3]랭킹    | |[4]규칙설명 | |[5]종료    | |\r\n"
							 + "| └──────────┘ └──────────┘ └──────────┘ └──────────┘ └──────────┘ |\r\n"
							 + "└──────────────────────────────────────────────────────────────────┘");
			int select = sc.nextInt();

			if (select == 1) {
				Music btn = new Music(".\\\\src\\cute_click_12.mp3");
				btn.play(btn.getMusicPath());
				
				// 로그인
				System.out.print("ID  : ");
				String id = sc.next();
				System.out.print("PWD : ");
				String pwd = sc.next();

				btn.stop();
				
				BabyDTO dto = new BabyDTO(id, pwd);

				if (ct.login(dto)) {
					while (ct.login(dto)) {
						System.out.println("┌──────────────────────────────────────────────────────────────────┐\r\n"
								 + "|　 오둥이 키우기! 　   　　　　　　　　　      　　　 　　　             [ㅡ][口][×] |\r\n"
								 + "|──────────────────────────────────────────────────────────────────|\r\n"
								 + "|                                                                  |\r\n"
								 + "|                                                                  |\r\n"
								 + "| ┌──────────┐ ┌──────────┐ ┌──────────┐ ┌──────────┐ ┌──────────┐ |\r\n"
								 + "| |[1]밥먹기   | |[2]놀기    | |[3]잠자기   | |[4]공부하기 | |[5]메인가기 | |\r\n"
								 + "| └──────────┘ └──────────┘ └──────────┘ └──────────┘ └──────────┘ |\r\n"
								 + "└──────────────────────────────────────────────────────────────────┘");
						
						int option = sc.nextInt();

						if (option == 1) {
							Music btn1 = new Music(".\\\\src\\cute_click_12.mp3");
							btn1.play(btn.getMusicPath());
							// 밥먹기
							baby.hungry();
							ct.hungry(dto);
							
							btn1.stop();
							
							if (ct.isGameOver(dto) == false) {
								music2.stop();
								Music gameOver = new Music(".\\\\src\\game_over.mp3");
								gameOver.play(gameOver.getMusicPath());
								
								baby.gameover();
								System.out.println(".                              |\r\n"
										+ "  　╲　　　　　　　　　　　╱\r\n"
										+ "  　　　　　　　　　　/\r\n"
										+ "  　　　╲　　　　　　　　╱\r\n"
										+ "  　　╲　　    　　　　　╱\r\n"
										+ "  -　-　　GAME OVER　　　-　-\r\n"
										+ "  　　╱　PRESS ENTER 　╲\r\n"
										+ "  　╱　　/                                 .\r\n"
										+ "  　　╱　　　　　　　　╲\r\n"
										+ "  　　　　　/　|　　　\r\n"
										+ "  　　　　　　　.\r\n"
										+ "");
								sc.nextLine();
								String end = sc.nextLine();
								if("\n".equals(end)) {
									gameOver.stop();
									break;
								}
								music2.play(music2.getMusicPath());
							}
						} else if (option == 2) {
							// 놀기
							Music btn1 = new Music(".\\\\src\\cute_click_12.mp3");
							btn1.play(btn.getMusicPath());
							
							baby.play();
							ct.Play(dto);
							
							btn1.stop();
							
							if (ct.isGameOver(dto) == false) {
								music2.stop();
								Music gameOver = new Music(".\\\\src\\game_over.mp3");
								gameOver.play(gameOver.getMusicPath());
								
								baby.gameover();
								System.out.println(".                              |\r\n"
										+ "  　╲　　　　　　　　　　　╱\r\n"
										+ "  　　　　　　　　　　/\r\n"
										+ "  　　　╲　　　　　　　　╱\r\n"
										+ "  　　╲　　    　　　　　╱\r\n"
										+ "  -　-　　GAME OVER　　　-　-\r\n"
										+ "  　　╱　PRESS ENTER 　╲\r\n"
										+ "  　╱　　/                                 .\r\n"
										+ "  　　╱　　　　　　　　╲\r\n"
										+ "  　　　　　/　|　　　\r\n"
										+ "  　　　　　　　.\r\n"
										+ "");
								sc.nextLine();
								String end = sc.nextLine();
								if("\n".equals(end)) {
									gameOver.stop();
									
									break;
								}
								music2.play(music2.getMusicPath());
							}

						} else if (option == 3) {
							// 잠자기
							Music btn1 = new Music(".\\\\src\\cute_click_12.mp3");
							btn1.play(btn.getMusicPath());
							
							baby.sleep();
							ct.sleep(dto);
							
							btn1.stop();
							
							if (ct.isGameOver(dto) == false) {
								music2.stop();
								Music gameOver = new Music(".\\\\src\\game_over.mp3");
								gameOver.play(gameOver.getMusicPath());
								
								baby.gameover();
								System.out.println(".                              |\r\n"
										+ "  　╲　　　　　　　　　　　╱\r\n"
										+ "  　　　　　　　　　　/\r\n"
										+ "  　　　╲　　　　　　　　╱\r\n"
										+ "  　　╲　　    　　　　　╱\r\n"
										+ "  -　-　　GAME OVER　　　-　-\r\n"
										+ "  　　╱　PRESS ENTER 　╲\r\n"
										+ "  　╱　　/                                 .\r\n"
										+ "  　　╱　　　　　　　　╲\r\n"
										+ "  　　　　　/　|　　　\r\n"
										+ "  　　　　　　　.\r\n"
										+ "");
								sc.nextLine();
								String end = sc.nextLine();
								if("\n".equals(end)) {
									gameOver.stop();
									break;
								}
								music2.play(music2.getMusicPath());
							}

						} else if (option == 4) {
							// 공부
							Music btn1 = new Music(".\\\\src\\cute_click_12.mp3");
							btn1.play(btn.getMusicPath());
							
							baby.knowledge();
							ct.study(dto);
							
							btn1.stop();
							
							if (ct.isGameOver(dto) == false) {
								music2.stop();
								Music gameOver = new Music(".\\\\src\\game_over.mp3");
								gameOver.play(gameOver.getMusicPath());
								
								baby.gameover();
								System.out.println(".                              |\r\n"
										+ "  　╲　　　　　　　　　　　╱\r\n"
										+ "  　　　　　　　　　　/\r\n"
										+ "  　　　╲　　　　　　　　╱\r\n"
										+ "  　　╲　　    　　　　　╱\r\n"
										+ "  -　-　　GAME OVER　　　-　-\r\n"
										+ "  　　╱　PRESS ENTER 　╲\r\n"
										+ "  　╱　　/                                 .\r\n"
										+ "  　　╱　　　　　　　　╲\r\n"
										+ "  　　　　　/　|　　　\r\n"
										+ "  　　　　　　　.\r\n"
										+ "");
								sc.nextLine();
								String end = sc.nextLine();
								if("\n".equals(end)) {
									gameOver.stop();
									break;
								}
								music2.play(music2.getMusicPath());
							}
						} else if (option == 5) {
							System.out.println("┌────────────────────────────────────────────────┐\r\n"
											 + "|  오둥이 키우기!!　　　　　　　　　　          [ㅡ][口][×]|\r\n" 
											 + "|────────────────────────────────────────────────|\r\n"
											 + "|                                                |\r\n" 
											 + "|          ┌─────────────────────────┐           |\r\n" 
											 + "|            　　　　　　　　　　　　　　　　　　　　　　　　 　|\r\n"
											 + "|               메인화면으로 돌아갑니당             \t |\r\n" 
											 + "|                                                |\r\n"
											 + "|          └─────────────────────────┘           |\r\n"
											 + "|                                                |\r\n"
											 + "└────────────────────────────────────────────────┘");
							music2.stop();
							break;
						} else {
							System.out.println("┌────────────────────────────────────────────────┐\r\n"
									 + "|  오둥이 키우기!!　　　　　　　　　　          [ㅡ][口][×]|\r\n" 
									 + "|────────────────────────────────────────────────|\r\n"
									 + "|                                                |\r\n" 
									 + "|          ┌─────────────────────────┐           |\r\n" 
									 + "|            　　　　　　　　　　　　　　　　　　　　　　　　 　|\r\n"
									 + "|                  잘못된 번호입니당              \t |\r\n" 
									 + "|                                                |\r\n"
									 + "|          └─────────────────────────┘           |\r\n"
									 + "|                                                |\r\n"
									 + "└────────────────────────────────────────────────┘");
						}
						

					}

				}
			} else if (select == 2) {
				Music btn = new Music(".\\\\src\\cute_click_12.mp3");
				btn.play(btn.getMusicPath());
				
				// 회원가입
				System.out.print("ID를 입력해주세요 >> ");
				String id = sc.next();
				System.out.print("비밀번호를 입력해주세요 >> ");
				String pwd = sc.next();
				System.out.print("오둥이 이름을 입력해주세요 >> ");
				String bName = sc.next();
				BabyDTO dto = new BabyDTO(id, pwd, bName);
				
				btn.stop();
				ct.join(dto);
				ct.NewBaby(dto);

			} else if (select == 3) {
				Music btn = new Music(".\\\\src\\cute_click_12.mp3");
				btn.play(btn.getMusicPath());
				
				// 랭킹
				ct.printRank();
				btn.stop();
			} else if (select == 4) {
				Music btn = new Music(".\\\\src\\cute_click_12.mp3");
				btn.play(btn.getMusicPath());
				
				System.out.println("┌──────────────────────────────────────────────────────────────────┐\r\n"
						 		 + "|　 오둥이 키우기! 　   　　　　　　　　　      　　　 　　　             [ㅡ][口][×] |\r\n"
						 		 + "|──────────────────────────────────────────────────────────────────|\r\n"
						 		 + "|                                                                  |\r\n"
						 		 + "|  첫째. 오둥이는 총 4가지 행동(밥 먹기,놀기,잠자기,공부하기)을 해요.           |\r\n"
						 		 + "|                                                                  |\r\n"
						 		 + "|  둘째. 오둥이의 해애동에 따라 오둥이의 상태가 변해요.                       |\r\n"
						 		 + "|                                                                  |\r\n"
						 		 + "|  셋째. 오둥이의 상태(피로도, 포만감, 지루함, 지식)가 나빠지면 종료돼요.        |\r\n"
						 		 + "|                                                                  |\r\n"
						 		 + "|  넷째. 오둥이가 행동 할 때마다 성장률이 1씩 올라요.                        |\r\n"
						 		 + "|  (성장률은 랭킹의 기준이되고, 10%의 확률로 성장률이 두 배 오를 수 있어요.)     |\r\n"
						 		 + "|                                                                  |\r\n"
						 		 + "|  오둥이를 잘 키워주세요!                                              |\r\n"
						 		 + "|                                                                  |\r\n"
						 		 + "└──────────────────────────────────────────────────────────────────┘");
			
			
				sc.nextLine();
				String end = sc.nextLine();
				if("\n".equals(end)) {
					btn.stop();
					break;
				}
			} else if (select == 5) {
				Music btn = new Music(".\\\\src\\cute_click_12.mp3");
				btn.play(btn.getMusicPath());
				
				System.out.println("┌────────────────────────────────────────────────┐\r\n"
						 + "|  오둥이 키우기!!　　　　　　　　　　          [ㅡ][口][×]|\r\n" 
						 + "|────────────────────────────────────────────────|\r\n"
						 + "|                                                |\r\n" 
						 + "|          ┌─────────────────────────┐           |\r\n" 
						 + "|            　　　　　　　　　　　　　　　　　　　　　　　　 　|\r\n"
						 + "|                  종료되었습니당                \t |\r\n" 
						 + "|                                                |\r\n"
						 + "|          └─────────────────────────┘           |\r\n"
						 + "|                                                |\r\n"
						 + "└────────────────────────────────────────────────┘");
				btn.stop();
				break;
			} else {
				Music btn = new Music(".\\\\src\\cute_click_12.mp3");
				btn.play(btn.getMusicPath());
				
				System.out.println("┌────────────────────────────────────────────────┐\r\n"
						 + "|  오둥이 키우기!!　　　　　　　　　　          [ㅡ][口][×]|\r\n" 
						 + "|────────────────────────────────────────────────|\r\n"
						 + "|                                                |\r\n" 
						 + "|          ┌─────────────────────────┐           |\r\n" 
						 + "|            　　　　　　　　　　　　　　　　　　　　　　　　 　|\r\n"
						 + "|                  잘못된 번호입니당              \t |\r\n" 
						 + "|                                                |\r\n"
						 + "|          └─────────────────────────┘           |\r\n"
						 + "|                                                |\r\n"
						 + "└────────────────────────────────────────────────┘");
				 btn.stop();
			}
		}

	}


}
