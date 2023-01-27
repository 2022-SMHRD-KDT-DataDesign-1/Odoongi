package Main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Music music = new Music("C:\\Users\\SMHRD\\Downloads\\뒹굴뒹굴.mp3");
		Scanner sc = new Scanner(System.in);
		Controller ct = new Controller();
		BabyEmotion baby = new BabyEmotion();

		music.play(music.getMusicPath());

		baby.login();
		System.out.println(" ￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣\r\n"
				+ "|　오둥이 키우기!　　　　　　　　　　　　　　　　　　　　　　[－][口][×]|\r\n" + "|￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣|\r\n"
				+ "|　안녕하세요 안녕하세요 안녕하세요 안녕하세요 안녕하세요.　　　       |\r\n" + "|　정말인가요?　　　　　　　　　　　　　　　　　　　　　　　　 　       |\r\n"
				+ "|　　　　＿＿＿＿＿＿　　　　＿＿＿＿＿＿　　　　＿＿＿＿＿　　　        |\r\n" + "| 　　　｜예　　　　|　　　｜아마도?　 ｜ 　 |예　　  |　 　　      |\r\n"
				+ "|　　　　￣￣￣￣￣￣　　　　￣￣￣￣￣￣　　　　￣￣￣￣￣　　　	    |\r\n" + "￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣\r\n"
				+ "");
		System.out.println();
		sc.nextLine();
		music.stop();
		System.out.println();
		System.out.println();
		
		// 바꿔보시죠
		while (true) {
			Music music2 = new Music("C:\\Users\\SMHRD\\Downloads\\game.mp3");
			music2.play(music2.getMusicPath());
			System.out.println(" ￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣\r\n"
	                 + "|　오둥이 키우기!　　　　　　　　　　　　　　　　　　　　　　                    [－][口][×]   |\r\n"
	                 + "|￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣  |\r\n"
	                 + "|                                                                       |\r\n"
	                 + "|                                                                       |\r\n"
	                 + "|　＿＿＿＿＿＿＿　　　　＿＿＿＿＿＿＿＿　　　 ＿＿＿＿＿＿　　　＿＿＿＿＿＿＿＿＿＿    ＿＿＿＿＿＿  |\r\n"
	                 + "| ｜[1]로그인 ｜　　　｜[2]회원가입 ｜ 　 ｜[3]랭킹　｜   ｜[4]게임규칙설명｜　  ｜[5]종료｜  |\r\n"
	                 + "|　￣￣￣￣￣￣￣　　　　￣￣￣￣￣￣￣￣　　　 ￣￣￣￣￣￣　　　￣￣￣￣￣￣￣￣￣￣    ￣￣￣￣￣￣  |\r\n"
	                 + "￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣\r\n"
	                 + "");
			int select = sc.nextInt();

			if (select == 1) {
				Music btn = new Music("C:\\Users\\SMHRD\\Downloads\\cute_click_12.mp3");
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
						 System.out.println(" ￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣\r\n"
		                           + "|　오둥이 키우기!　　　　　　　　　　　　　　　　　　　　　　                         [－][口][×]|\r\n"
		                           + "|￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣|\r\n"
		                           + "|                                                                            |\r\n"
		                           + "|                                                                            |\r\n"
		                           + "|　＿＿＿＿＿＿＿　　　　＿＿＿＿＿＿　　　 ＿＿＿＿＿＿　　　＿＿＿＿＿＿＿＿    ＿＿＿＿＿＿＿＿＿＿＿＿＿＿  |\r\n"
		                           + "| ｜[1]밥먹기 ｜　　　｜[2]놀기 ｜ 　 ｜[3]잠자기｜   ｜[4]공부하기｜　  ｜[5]메인화면으로 돌아가기｜ |\r\n"
		                           + "|　￣￣￣￣￣￣￣　　　　￣￣￣￣￣￣　　　 ￣￣￣￣￣￣　　　￣￣￣￣￣￣￣￣    ￣￣￣￣￣￣￣￣￣￣￣￣￣￣  |\r\n"
		                           + "￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣\r\n"
		                           + "");
						int option = sc.nextInt();

						if (option == 1) {
							Music btn1 = new Music("C:\\Users\\SMHRD\\Downloads\\cute_click_12.mp3");
							btn1.play(btn.getMusicPath());
							// 밥먹기
							baby.hungry();
							ct.hungry(dto);
							
							btn1.stop();
							
							if (ct.isGameOver(dto) == false) {
								music2.stop();
								Music gameOver = new Music("C:\\Users\\SMHRD\\Downloads\\game_over.mp3");
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
							Music btn1 = new Music("C:\\Users\\SMHRD\\Downloads\\cute_click_12.mp3");
							btn1.play(btn.getMusicPath());
							
							baby.play();
							ct.Play(dto);
							
							btn1.stop();
							
							if (ct.isGameOver(dto) == false) {
								music2.stop();
								Music gameOver = new Music("C:\\Users\\SMHRD\\Downloads\\game_over.mp3");
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
							Music btn1 = new Music("C:\\Users\\SMHRD\\Downloads\\cute_click_12.mp3");
							btn1.play(btn.getMusicPath());
							
							baby.sleep();
							ct.sleep(dto);
							
							btn1.stop();
							
							if (ct.isGameOver(dto) == false) {
								music2.stop();
								Music gameOver = new Music("C:\\Users\\SMHRD\\Downloads\\game_over.mp3");
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
							Music btn1 = new Music("C:\\Users\\SMHRD\\Downloads\\cute_click_12.mp3");
							btn1.play(btn.getMusicPath());
							
							baby.knowledge();
							ct.study(dto);
							
							btn1.stop();
							
							if (ct.isGameOver(dto) == false) {
								music2.stop();
								Music gameOver = new Music("C:\\Users\\SMHRD\\Downloads\\game_over.mp3");
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
							System.out.println(" ￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣\r\n"
		                              + "|　오둥이 키우기!　　　　　　　　　[－][口][×]|\r\n"
		                              + "|￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣|\r\n"
		                              + "|        ＿＿＿＿＿＿＿＿＿＿＿＿＿        |\r\n"
		                              + "|        ｜메인화면으로 돌아갑니다｜       |\r\n"
		                              + "|　       ￣￣￣￣￣￣￣￣￣￣￣￣￣        |\r\n"
		                              + "|　                                |\r\n"
		                              + "￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣\r\n"
		                              + "");
							music2.stop();
							break;
						} else {
							System.out.println(" ￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣\r\n"
		                              + "|　오둥이 키우기!　　　　　　　　　[－][口][×]|\r\n"
		                              + "|￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣|\r\n"
		                              + "|        ＿＿＿＿＿＿＿＿＿＿＿＿＿＿       |\r\n"
		                              + "|        ｜올바른 번호를 입력하세요｜      |\r\n"
		                              + "|　       ￣￣￣￣￣￣￣￣￣￣￣￣￣￣      |\r\n"
		                              + "|　                                |\r\n"
		                              + "￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣\r\n"
		                              + "");
						}
						

					}

				}
			} else if (select == 2) {
				Music btn = new Music("C:\\Users\\SMHRD\\Downloads\\cute_click_12.mp3");
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
				music2.stop();
				ct.join(dto);
				ct.NewBaby(dto);

			} else if (select == 3) {
				Music btn = new Music("C:\\Users\\SMHRD\\Downloads\\cute_click_12.mp3");
				btn.play(btn.getMusicPath());
				
				// 랭킹
				ct.printRank();
				btn.stop();
				music2.stop();
			} else if (select == 4) {
				Music btn = new Music("C:\\Users\\SMHRD\\Downloads\\cute_click_12.mp3");
				btn.play(btn.getMusicPath());
				
			
				System.out.println(" ￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣\r\n"
                        + "|　오둥이 키우기!　　　　　　　　            　[－][口][×]|\r\n"
                        + "|￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣|\r\n"
                        + "|        오둥이는 총 4가지 행동을 취할 수 있습니다.       |\r\n"
                        + "|        오둥이의 행동에 따라 오둥이의 상태가 변합니다.     |\r\n"
                        + "|        각 수치 중 하나라도 0이 되면 게임 종료 !        |\r\n"
                        + "|　       행동 한 번에 성장률이 1씩 오르며              |\r\n"
                        + "|　       성장률 순서대로 랭킹이 부여됩니다.             |\r\n"
                        + "|　       오둥이를 잘 키워주세요!                     |\r\n"
                        + "|　                                            |\r\n"
                        + "￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣\r\n"
                        + "");
				btn.stop();
				sc.nextLine();
				String end = sc.nextLine();
				if("\n".equals(end)) {
					break;
				}
				music2.stop();
			} else if (select == 5) {
				Music btn = new Music("C:\\Users\\SMHRD\\Downloads\\cute_click_12.mp3");
				btn.play(btn.getMusicPath());
				
				
				 System.out.println(" ￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣\r\n"
	                     + "|　오둥이 키우기!　　　　　　　[－][口][×]|\r\n"
	                     + "|￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣|\r\n"
	                     + "|        ＿＿＿＿＿＿＿＿＿           |\r\n"
	                     + "|        ｜종료되었습니다｜           |\r\n"
	                     + "|　       ￣￣￣￣￣￣￣￣￣           |\r\n"
	                     + "|　                              |\r\n"
	                     + "￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣\r\n"
	                     + "");
				btn.stop();
				break;
			} else {
				Music btn = new Music("C:\\Users\\SMHRD\\Downloads\\cute_click_12.mp3");
				btn.play(btn.getMusicPath());
				
				 System.out.println(" ￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣\r\n"
	                     + "|　오둥이 키우기!　　　　　　　　　[－][口][×]|\r\n"
	                     + "|￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣ |\r\n"
	                     + "|        ＿＿＿＿＿＿＿＿＿＿＿＿＿＿       |\r\n"
	                     + "|        ｜올바른 번호를 입력하세요｜      |\r\n"
	                     + "|　       ￣￣￣￣￣￣￣￣￣￣￣￣￣￣       |\r\n"
	                     + "|　                                |\r\n"
	                     + "￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣\r\n"
	                     + "");
				 btn.stop();
				 music2.stop();
			}
		}

	}


}
