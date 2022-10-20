package oracle_project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Login {

	Connection conn = DBconn.getConnection();
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Calendar cal = Calendar.getInstance();
	Scanner scr = new Scanner(System.in);
	String realbirth;
    String birth;	
	
	public void checkid() {
		boolean idcheck = true;
		String realmemberid;
		System.out.println("---------------<로그인>---------------\n");
		do {		
		    System.out.print("ID :");
			String memberid = scr.next();
			String sql = "select id,birth from dbmember";
		
			try {
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
			
				while(rs.next()) {
					realmemberid = rs.getString("id");
					this.realbirth = rs.getString("birth");
					if(realmemberid.equals(memberid)) {
						idcheck = false;
						this.birth = this.realbirth;
						break;
					}else {
						idcheck = true;
					}
				}				
				if(idcheck == true) {
					System.out.println("\n<ID가 틀렸습니다>\n");
				}
				
				pstmt.close();
				rs.close();
					
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}while(idcheck);
	}
	
	
	
	public void checkpw() {
		boolean pwcheck = true;
		String realmemberpw;
		do {
			System.out.print("PW :");
			String memberpw = scr.next();
			String sql = "select pw from dbmember";
		
			try {
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
			
				while(rs.next()) {
					realmemberpw = rs.getString("pw");
					if(realmemberpw.equals(memberpw)) {
						pwcheck = false;
						break;
					}else {
						pwcheck = true;
					}
				}
				if(pwcheck == true) {
					System.out.println("\n<PW가 틀렸습니다>\n");
				}
				
				pstmt.close();
				rs.close();
				conn.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}while(pwcheck);
	}
	
	
	public void birthcheck() {
			
		int month = cal.get(cal.MONTH);
		int day = cal.get(cal.DAY_OF_MONTH);
		  
		StringTokenizer tokenizer = new StringTokenizer(this.birth,"-");
			
		String[] arr2 = new String[3];	
		int[] arr = new int[3];
		
		int token = 0;
		
		while(tokenizer.hasMoreTokens()) {
			arr2[token] = tokenizer.nextToken();
			arr[token] = Integer.parseInt(arr2[token]);
			token++;		
		}
		
		if((month+1 == arr[1])&&(day == arr[2])) {
			System.out.println("\n-------------생신축하드려요!------------");
		}
		
		  
	}
	
	
	
}
