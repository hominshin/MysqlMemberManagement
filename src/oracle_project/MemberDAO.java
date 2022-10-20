package oracle_project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
	
	
	
	public int insertData(DTO dto){
	
			
	
			int result = 0;
	
			
	
			Connection conn = DBconn.getConnection();
	
			PreparedStatement pstmt = null;
	
			String sql;
	
			
	
			try {
	
				sql = "insert into dbMember (id,pw,name,gender,birth,email,tel,address) ";
	
				sql+= "values (?,?,?,?,?,?,?,?)";
	
				
	
				pstmt = conn.prepareStatement(sql);
	
				
	
				pstmt.setString(1, dto.getId());
	
				pstmt.setString(2, dto.getPw());
	
				pstmt.setString(3, dto.getName());
	
				pstmt.setString(4, dto.getGender());
	
				pstmt.setString(5, dto.getBirth());
	
				pstmt.setString(6, dto.getEmail());
	
				pstmt.setString(7, dto.getTel());
				
				pstmt.setString(8, dto.getAddress());
	
				
	
				result = pstmt.executeUpdate();
	
				
	
				pstmt.close();
				conn.close();
	
				
	
			} catch (Exception e) {
	
				System.out.println(e.toString());
	
			}
	
			
	
			return result;
	
			
	
		}
	
		
	
	
	
		//2.update
	
		public int updateData(DTO dto){
	
			
	
			int result = 0;
	
			
	
			Connection conn = DBconn.getConnection();
	
			PreparedStatement pstmt = null;
	
			String sql;
	
			
	
			try {
	
				sql = "update dbMember set pw=?, email=?, tel=? ";
	
				sql+= "where id=?";
	
				
	
				pstmt = conn.prepareStatement(sql);
	
				
	
				pstmt.setString(1, dto.getPw());
	
				pstmt.setString(2, dto.getEmail());
	
				pstmt.setString(3, dto.getTel());
	
				pstmt.setString(4, dto.getId());
				
	
				
	
				result = pstmt.executeUpdate();
	
				
	
				pstmt.close();
	
				
	
			} catch (Exception e) {
	
				System.out.println(e.toString());
	
			}
	
			
	
			return result;
	
			
	
		}
	
		
	
	
	
		//3.delete
	
		public int deleteDate(String id, String pw){
	
		
	
			int result = 0;
	
			
	
			Connection conn = DBconn.getConnection();
	
			PreparedStatement pstmt = null;
	
			String sql;
	
			
	
			try {
	
				sql = "delete dbMember where id=? and pw=?";
	
				
	
				pstmt = conn.prepareStatement(sql);
	
				
	
				pstmt.setString(1, id);
	
				pstmt.setString(2, pw);
	
				
	
				result = pstmt.executeUpdate();
	
				
	
				pstmt.close();
				conn.close();
	
				
	
			} catch (Exception e) {
	
				System.out.println(e.toString());
	
			}
	
			
	
			return result;	
	
		
	
		}
	
		
	
	
	
		//4.selectAll
	
		public List<DTO> getList() {
	
			
	
			List<DTO> lists = new ArrayList<DTO>();
	
			Connection conn = DBconn.getConnection();
	
			PreparedStatement pstmt = null;
	
			ResultSet rs = null;
	
			String sql;
	
			
	
			try {
	
				sql = "select id,pw,name,gender,birth,email,tel,address ";
	
				sql+= "from dbMember order by name";
	
				
	
				pstmt = conn.prepareStatement(sql);
	
				
	
				rs = pstmt.executeQuery();
	
				
	
				while(rs.next()){
	
					
	
					DTO dto = new DTO();
	
					
	
					dto.setId(rs.getString("id"));
	
					dto.setPw(rs.getString("pw"));
	
					dto.setName(rs.getString("name"));
	
					dto.setGender(rs.getString("gender"));
	
					dto.setBirth(rs.getString("birth"));
	
					dto.setEmail(rs.getString("email"));
	
					dto.setTel(rs.getString("tel"));
	
					dto.setAddress(rs.getString("address"));
	
					lists.add(dto);
	
								
	
				}
	
				
	
				rs.close();
	
				pstmt.close();
				
				conn.close();
	
				
	
			} catch (Exception e) {
	
				System.out.println(e.toString());
	
			}
	
			
	
			return lists;
	
			
	
		}
	
	
	
		
	
		//5.searchId
	
		public List<DTO> getList(String id){
	
			
	
			List<DTO> lists = new ArrayList<DTO>();
	
			Connection conn = DBconn.getConnection();
	
			PreparedStatement pstmt = null;
	
			ResultSet rs = null;
	
			String sql;
	
			
	
			try{
	
				sql = "select id,pw,name,gender,birth,email,tel,address ";
	
				sql+= "from dbMember where id=?";
	
			
	
				pstmt = conn.prepareStatement(sql);
	
			
	
				pstmt.setString(1, id);
	
				
	
				rs = pstmt.executeQuery();
	
				
	
				while(rs.next()){
	
					
	
					DTO dto = new DTO();
	
					
	
					dto.setId(rs.getString("id"));
	
					dto.setPw(rs.getString("pw"));
	
					dto.setName(rs.getString("name"));
	
					dto.setGender(rs.getString("gender"));
	
					dto.setBirth(rs.getString("birth"));
	
					dto.setEmail(rs.getString("email"));
	
					dto.setTel(rs.getString("tel"));
	
					dto.setAddress(rs.getString("address"));
	
					lists.add(dto);
	
								
	
				}
	
				
	
				rs.close();
	
				pstmt.close();
				
				conn.close();
	
				
	
			}catch (Exception e) {
	
				System.out.println(e.toString());
	
			}			
	
			return lists;
	
		}

}
