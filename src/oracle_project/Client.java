package oracle_project;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Client {
	
	Scanner sc = new Scanner(System.in);

	MemberDAO dao = new MemberDAO();

	

	DBinsertException ne = new DBinsertException();

	

	//회원가입

	public void insert() throws AuthenException {

		

		String pw2=null;

		boolean id=true;

		boolean pw=true;

        boolean name=true;

		boolean gender=true;

		boolean tel=true;
		
		boolean email = true;

		

		System.out.println("                 회원가입");

		System.out.println("-------------------------------------");

		

		try {

			

			DTO dto = new DTO();

			

			do{

				try{

					System.out.print("아이디:");

					dto.setId(sc.next());;

					ne.idFormat(dto.getId());

					

					id=false;

					

				}catch (AuthenException e) {

					System.out.println(e.toString());

				}

				

			} while(id);

			

			

			do{

				try{

					System.out.print("비밀번호:");

					dto.setPw(sc.next());

					

					System.out.print("비밀번호 확인:");

					pw2 = sc.next();

					ne.pwCheck(dto.getPw(), pw2);

					

					pw=false;

				

				}catch (AuthenException e) {

					System.out.println(e.toString());

					

				}

			

			} while(pw);



			do{

				try{

					System.out.print("이름:");

					dto.setName(sc.next());

					ne.nameCheck(dto.getName());

					

					name=false;

				

				}catch (AuthenException e) {

					System.out.println(e.toString());

					

				}

			

			} while(name);



		

			do{

				try{

					System.out.print("성별[여/남]:");

					dto.setGender(sc.next());

					ne.genCheck(dto.getGender());

					

					gender=false;

					

				}catch (AuthenException e) {

					System.out.println(e.toString());

					

				}

				

			} while(gender);

			

			System.out.print("생일[xxxx-xx-xx]:");

			dto.setBirth(sc.next());
			
			
			
			do {
				try {
					System.out.print("이메일[xxxxx@daum.net]:");

					dto.setEmail(sc.next());
					
					ne.emailCheck(dto.getEmail());
					
					email = false;
				
				}catch(AuthenException e) {
					
					System.out.println(e.toString());
				}	
			}while(email);

			

			do{

				try{

					System.out.print("전화번호[xxx-xxxx-xxxx]:");

					dto.setTel(sc.next());

					ne.phoneCheck(dto.getTel());

					

					tel=false;

				

				}catch (AuthenException e) {

					System.out.println(e.toString());

					

				}

			

			} while(tel);
			
			
			System.out.print("주소:");

			dto.setAddress(sc.next());

			

			int result = dao.insertData(dto);

			

			if(result!=0){

				System.out.println();

				System.out.println("****성공적으로 가입이 되었습니다!****");

				System.out.println();

				

				System.out.println("-----------[회원가입 확인]-----------");

				System.out.println(dto.toString());	

			}

			else

				System.out.println("회원가입에 실패했습니다");		

		

			

		} catch (Exception e) {

			System.out.println(e.toString());

		}

		

	}

	

	//수정

	public void update() {

		

		try {

			DTO dto = new DTO();

			

			System.out.print("수정 할 아이디:");

			dto.setId(sc.next());

			

			System.out.print("비밀번호:");

			dto.setPw(sc.next());

			

			System.out.print("이메일[xxxxx@daum.net]:");

			dto.setEmail(sc.next());

			

			System.out.print("전화번호[xxx-xxxx-xxxx]:");

			dto.setTel(sc.next());		

			

			int result = dao.updateData(dto);

			

			if(result!=0)

				System.out.println("회원정보가 수정되었습니다");

			else

				System.out.println("회원정보수정에 실패했습니다");

			

		} catch (Exception e) {

			System.out.println(e.toString());

		}

		

	}

	

	//탈퇴

	public void delete() {

		

		try {

			

			String id, pw;

			

			System.out.print("탈퇴 할 아이디:");

			id = sc.next();

			

			System.out.print("비밀번호 확인:");

			pw = sc.next();

			

			int result = dao.deleteDate(id,pw);

			

			if(result!=0)

				System.out.println("성공적으로 탈퇴하였습니다.\n다음에 다시 가입해주세요! ;)");

			else

				System.out.println("탈퇴에 실패했습니다.\n영원히 회원으로 남아주세요:)");

			

		} catch (Exception e) {

			System.out.println(e.toString());

		}

		

		

	}

	

	//회원 전체출력

	public void selectAll() {

		

		List<DTO> lists = dao.getList();

		

		Iterator<DTO> it = lists.iterator();

		

		int i=1;

		while(it.hasNext()){

			

			DTO dto = it.next();

			System.out.println("[회원 "+i+"]");

			System.out.println(dto.toString());

			i++;

		}

	

	}

	

	//아이디검색

	public void searchId() {

		

		System.out.print("검색 할 아이디:");

		List<DTO> lists = dao.getList(sc.next());

		

		Iterator<DTO> it = lists.iterator();



   if(!it.hasNext()){

			System.out.println("검색한 아이디는 존재하지 않습니다.");

		}



		while(it.hasNext()){

			DTO dto = it.next();

			System.out.println(dto.toString());

		}

		

	}

}
