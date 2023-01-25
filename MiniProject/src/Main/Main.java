package Main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

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
				Controller ct = new Controller();

				System.out.println("======아기 키우기 시작======");
				System.out.println("당신의 아기를 등록하세요 !");
				System.out.print("아기 이름 입력하기 >> ");
				String bName = sc.next();

				dto.setbName(bName);

				while (true) {
					System.out.print("[1]밥먹기 [2]놀기 [3]잠자기 [4]공부하기 >> ");
					int option = sc.nextInt();

					if (option == 1) {
						// 밥먹기

					} else if (option == 2) {
						// 놀기

					} else if (option == 3) {
						// 잠자기
						ct.sleep(dto);
						if (ct.isGameOver(dto) == true)
							break;

					} else if (option == 4) {
						// 공부
						ct.study(dto);
						if (ct.isGameOver(dto) == true)
							break;

					} else {
						System.out.println("올바른 번호를 입력하세요");
					}

					ct.printBaby(dto);
				}

			} else if (select == 2) {
				// 회원가입
				System.out.print("ID  : ");
				String id = sc.next();
				System.out.print("PWD : ");
				String pwd = sc.next();

			} else if (select == 3) {
				// 랭킹
				Controller ct = new Controller();
				ct.printRank();
			} else if (select == 4) {
				// 등록
				break;
			} else {
				System.out.println("올바른 숫자를 입력하세요");
			}
		}

	}

}
