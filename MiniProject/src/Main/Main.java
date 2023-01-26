package Main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Controller ct = new Controller();
		// 바꿔보시죠
		while (true) {
			System.out.print("[1]로그인 [2]회원가입 [3]랭킹 [4]종료 >> ");
			int select = sc.nextInt();

			if (select == 1) {
				// 로그인
				System.out.println("ID  : ");
				String id = sc.next();
				System.out.println("PWD : ");
				String pwd = sc.next();

				BabyDTO dto = new BabyDTO(id, pwd);


				while (ct.login(dto)) {
					System.out.print("[1]밥먹기 [2]놀기 [3]잠자기 [4]공부하기 >> ");
					int option = sc.nextInt();

					if (option == 1) {
						// 밥먹기
						ct.hungry(dto);
						if (ct.isGameOver(dto) == false)
							System.out.println("GAME OVER");
							break;
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
						if (ct.isGameOver(dto) == false)
							break;

					} else {
						System.out.println("올바른 번호를 입력하세요");
					}

					ct.printBaby(dto);
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
				System.out.println("종료되었습니다");
				break;
			} else {
				System.out.println("올바른 숫자를 입력하세요");
			}
		}

	}

}
