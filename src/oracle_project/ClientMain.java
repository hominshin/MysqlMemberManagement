package oracle_project;

import java.util.Scanner;

public class ClientMain {

	public static void main(String[] args) throws AuthenException {
			
			Login login = new Login();
			
			login.checkid();
			login.checkpw();
			login.birthcheck();
				
			Scanner sc = new Scanner(System.in);

			Client ob = new Client();
			
			int ch = 0;

			

			while(true){

				

				do{
					
					System.out.println("\n");

					System.out.print("1.입력  2.수정  3.탈퇴  4.회원전체출력  5.아이디검색  6.종료");

					System.out.print("\n-------------------------------------\n▶");

					ch = sc.nextInt();

				} while(ch<1 || ch>6);

				

				System.out.println();

				

				switch(ch){

				

				case 1:

					ob.insert();

					System.out.println(); break;

				case 2:

					ob.update();

					System.out.println(); break;

				case 3:

					ob.delete();

					System.out.println(); break;

				case 4:

					ob.selectAll();

					System.out.println(); break;

				case 5:

					ob.searchId();

					System.out.println(); break;

				case 6:
					System.out.println("프로그램 종료....");
					System.exit(0);

					
				}

				

			}

		}

		


	}


