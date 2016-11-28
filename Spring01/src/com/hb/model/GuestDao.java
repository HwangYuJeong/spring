package com.hb.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hb.util.OraDB;

public class GuestDao {

   private Connection conn;
   private PreparedStatement pstmt;
   private ResultSet rs;
   private GuestVo vo;

   public GuestDao() throws ClassNotFoundException, SQLException {
     
   }

   public List<GuestVo> selectAll() {
      // TODO Auto-generated method stub
      List<GuestVo> list = new ArrayList<GuestVo>();
      String sql = "select * from guest";
      try {
    	 conn=OraDB.getConn();
         pstmt = conn.prepareStatement(sql);
         rs = pstmt.executeQuery();
         while (rs.next()) {
            list.add(new GuestVo(rs.getInt("sabun"), rs.getString("name"),
                  rs.getDate("nalja"), rs.getInt("pay")));
         }
         return list;
      } catch (Exception e) {
         e.printStackTrace();
      
      } finally {
         try {
            if (rs != null)
               rs.close();
            if (pstmt != null)
               pstmt.close();
            if (conn != null)
               conn.close();
         } catch (SQLException e) {
            e.printStackTrace();
         }
      }
      return null;
   }

		public void insertOne(GuestVo bean) {
			String sql="insert into guest values(?,?,sysdate,?)";
			try {
				conn=OraDB.getConn();
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1,bean.getSabun());
				pstmt.setString(2,bean.getName());
				pstmt.setInt(3,bean.getPay());
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
		         try {
		             if (rs != null)
		                rs.close();
		             if (pstmt != null)
		                pstmt.close();
		             if (conn != null)
		                conn.close();
		          } catch (SQLException e) {
		             // TODO Auto-generated catch block
		             e.printStackTrace();
		          }
		       }
		}

		public GuestVo selectOne(int sabun) {
			String sql="select * from guest where sabun=?";
			try {
				conn=OraDB.getConn();
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1,sabun);
				rs=pstmt.executeQuery();
				if(rs.next()){
					return new GuestVo(rs.getInt("sabun")
							,rs.getString("name")
							,rs.getDate("nalja")
							,rs.getInt("pay"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
		         try {
		             if (rs != null)
		                rs.close();
		             if (pstmt != null)
		                pstmt.close();
		             if (conn != null)
		                conn.close();
		          } catch (SQLException e) {
		             e.printStackTrace();
		          }
		       }
			return null;
		}

		public void updateOne(GuestVo guestVo) {
			String sql="update guest set name=?,pay=? where sabun=?";
			try {
				conn=OraDB.getConn();
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1,vo.getName());
				pstmt.setInt(2, vo.getPay());
				pstmt.setInt(3, vo.getPay());
				rs=pstmt.executeQuery();
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
		         try {
		             if (rs != null)
		                rs.close();
		             if (pstmt != null)
		                pstmt.close();
		             if (conn != null)
		                conn.close();
		          } catch (SQLException e) {
		             e.printStackTrace();
		          }
		       }
		}

		public void deleteOne(int sabun) {
			String sql="delete from guest where sabun=?";
			try {
				conn=OraDB.getConn();
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, sabun);
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
		         try {
		             if (rs != null)
		                rs.close();
		             if (pstmt != null)
		                pstmt.close();
		             if (conn != null)
		                conn.close();
		          } catch (SQLException e) {
		             e.printStackTrace();
		          }
		       }
		}

}