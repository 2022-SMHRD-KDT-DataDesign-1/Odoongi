package Main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Controller ct = new Controller();
		// 바꿔보시죠
		while (true) {
			System.out.print("[1]로그인 [2]회원가입 [3]랭킹 [4]게임규칙설명 [5]종료 >> ");
			int select = sc.nextInt();

			if (select == 1) {
				// 로그인
				System.out.print("ID  : ");
				String id = sc.next();
				System.out.print("PWD : ");
				String pwd = sc.next();

				BabyDTO dto = new BabyDTO(id, pwd);

				if (ct.login(dto)) {
					while (ct.login(dto)) {
						System.out.print("[1]밥먹기 [2]놀기 [3]잠자기 [4]공부하기 [5]메인화면으로 돌아가기>> ");
						int option = sc.nextInt();

						if (option == 1) {
							ct.hungry(dto);
							// 밥먹기
						} else if (option == 2) {
							// 놀기
							ct.Play(dto);
						if (ct.isGameOver(dto) == false)
							System.out.println("GAME OVER");
							break;
						} else if (option == 3) {
							// 잠자기
							ct.sleep(dto);
						if (ct.isGameOver(dto) == false)
							System.out.println("GAME OVER");
							break;

						} else if (option == 4) {
							// 공부
							ct.study(dto);
//						if (ct.isGameOver(dto) == false)
//							break;

						} else if (option == 5) {
							System.out.println("메인화면으로 돌아갑니다");
							break;
						} else {
							System.out.println("올바른 번호를 입력하세요");
						}

					}
					System.out.println("GAME OVER");
					break;
				}
			} else if (select == 2) {
				// 회원가입
				System.out.print("ID를 입력해주세요 >> ");
				String id = sc.next();
				System.out.print("비밀번호를 입력해주세요 >> ");
				String pwd = sc.next();
				System.out.print("오둥이 이름을 입력해주세요 >> ");
				String bName = sc.next();
				BabyDTO dto = new BabyDTO(id, pwd, bName);

				ct.join(dto);
				ct.NewBaby(dto);

			} else if (select == 3) {
				// 랭킹
				ct.printRank();
			} else if (select == 4) {
				System.out.println("게임규칙 솰라솰라");
			} else if (select == 5) {
				System.out.println("종료되었습니다");
				break;
			} else {
				System.out.println("올바른 숫자를 입력하세요");
			}
		}

	}

}
