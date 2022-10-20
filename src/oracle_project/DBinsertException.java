package oracle_project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;

import javax.naming.spi.DirStateFactory.Result;

public class DBinsertException {
	
	public void idFormat(String str) throws AuthenException{

		

		if(str.length()<5 || str.length()>15){

			throw new AuthenException("5~15자 이내의 아이디만 가능합니다");

		}

		

		int cnt1=0;

		int cnt2=0;

		

		for(int i=0;i<str.length();i++){

			char ch = str.charAt(i);

			if((ch>='a' && ch<='z') || (ch>='A' && ch<='Z'))

				cnt1++;

			else if(ch>='0' && ch<='9')

				cnt2++;

		}

		

		if(cnt1==0 || cnt2==0)

			throw new AuthenException("아이디는 영문자와 숫자를 혼용해서 만들어주세요");	

	}

	

      //비밀번호 확인

	public void pwCheck(String pw1, String pw2) throws AuthenException{

		

		int cnt1=0;

		int cnt2=0;

		

		for(int i=0;i<pw1.length();i++){

			char ch = pw1.charAt(i);

			if((ch>='a' && ch<='z') || (ch>='A' && ch<='Z'))

				cnt1++;

			else if(ch>='0' && ch<='9')

				cnt2++;

		}

		

		if(cnt1==0 || cnt2==0)

			throw new AuthenException("비밀번호는 영문자와 숫자를 혼용해서 만들어주세요");	

		

		if(!pw1.equals(pw2))

			throw new AuthenException("비밀번호가 다릅니다");	

	}



        //성별확인

	public void genCheck(String gender) throws AuthenException{

		

		if(!gender.equals("남") && !gender.equals("여")){

			throw new AuthenException("※성별이 모호하군요!\n성별은 여/남으로 적어주세요;)");

		}

	}



       //이름 확인

	public void nameCheck(String name) throws AuthenException {

		boolean check = Pattern.matches("^[ㄱ-ㅎ가-힣]*$", name);

		if (!check)

			throw new AuthenException("※이름은 한글로 입력해주세요");

	}



	// 전화번호 확인

	public void phoneCheck(String phone) throws AuthenException {
		
		String sql = "select tel from dbmember";
		String newphone = null;
		ResultSet rs = null;
		
		try { // 중복검사 테스트
			PreparedStatement pstmt = DBconn.getConnection().prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				newphone = rs.getString("tel");
				if(newphone.equals(phone)) {
					throw new AuthenException("이미 가입된 번호입니다.");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		

		boolean check = Pattern.matches(

				"(010|011|016|017|018?019)-(\\d{3,4})-(\\d{4})", phone);

		if (!check) {

			throw new AuthenException("※전화번호 입력 형식은 [XXX-XXXX-XXXX]입니다");
		}
		
		
	}
	
	
	public void emailCheck(String email) throws AuthenException {
		
		String sql = "select email from dbmember";
		String newemail = null;
		ResultSet rs = null;
		
		try { // 중복검사 테스트
			PreparedStatement pstmt = DBconn.getConnection().prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				newemail = rs.getString("email");
				if(newemail.equals(email)) {
					throw new AuthenException("이미 가입된 이메일입니다.");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		
	}


}


