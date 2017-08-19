package com.bdqn.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bdqn.dao.GossipDao;
import com.bdqn.entity.Gossip;
/**
 * GossipDao的实现类，对留言进行数据库的操作
 * @author xinyuanru1
 *
 */
public class GossipDaoImpl extends BaseDaoImpl implements GossipDao{
	
	/**
	 * 增加Gossip
	 */
	public int addGossipDao(Gossip gossip) {
		// TODO Auto-generated method stub
		int flag = 0;
		String sql = "INSERT INTO `coffee`.`gossip` (`gossipTime`, `gossipContent`, `gossipTitle`) VALUES (?,?,?); ";
		String date = new SimpleDateFormat().format(new Date());
		Object[] params = {date,gossip.getGossipContent(),gossip.getGossipTitle()};
		flag = super.executeUpdate(sql, params);
		return flag;
	}
	/**
	 * 根据gossipNo（主键）删除Gossip
	 */
	public int deleteGossipDao(int gossipNo) {
		// TODO Auto-generated method stub
		int flag = 0;
		String sql = "DELETE FROM `coffee`.`gossip` WHERE `gossipNo` = ?; ";
		Object[] params = {gossipNo};
		flag = super.executeUpdate(sql, params);
		return flag;
	}

	/**
	 * 得到所有Gossip集合
	 */
	public ArrayList<Gossip> getAll() {
		// TODO Auto-generated method stub
		ArrayList<Gossip> gossips = new ArrayList<Gossip>();
		if(getConnection()){
			String sql = "select * from gossip";
			try {
				preparedStatement = connection.prepareStatement(sql);
				resultSet = preparedStatement.executeQuery();
				while(resultSet.next()){
					Gossip gossip = new Gossip();
					gossip.setGossipContent(resultSet.getString("gossipContent"));
					gossip.setGossipNo(resultSet.getInt("gossipNo"));
					gossip.setGossipTime(resultSet.getString("gossipTime"));
					gossip.setGossipTitle(resultSet.getString("gossipTitle"));
					gossips.add(gossip);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return gossips;
	}

	/**
	 * 根据gossipNo得到Gossip实体
	 */
	public Gossip getByNo(int gossipNo) {
		// TODO Auto-generated method stub
		Gossip gossip = null;
		String sql = "select * from gossip where gossipNo = ?";
		try {
			getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, gossipNo);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				gossip = new Gossip();
				gossip.setGossipContent(resultSet.getString("gossipContent"));
				gossip.setGossipNo(resultSet.getInt("gossipNo"));
				gossip.setGoods(resultSet.getInt("goods"));
				gossip.setBads(resultSet.getInt("bads"));
				gossip.setReply(resultSet.getString("reply"));
				gossip.setGossipTime(resultSet.getString("gossipTime"));
				gossip.setGossipTitle(resultSet.getString("gossipTitle"));
				gossip.setReplyTime(resultSet.getString("replyTime"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
		return gossip;
	}

	/**
	 * 修改Gossip各项数据，GossipNo（主键）不可修改
	 */
	public int update(Gossip gossip) {
		// TODO Auto-generated method stub
		int flag = 0;
		String date = new SimpleDateFormat().format(new Date());
		String sql = "UPDATE `coffee`.`gossip` SET `gossipTime` = ? , `gossipContent` = ? , `reply` = ? ," +
				" `gossipTitle` = ? WHERE `gossipNo` = ?; ";
		Object[] params = {date,gossip.getGossipContent(),gossip.getReply(),gossip.getGossipTitle(),gossip.getGossipNo()};
		flag = super.executeUpdate(sql, params);
		return flag;
	}
	public List<Gossip> getGossips(int pageIndex, int pageSize) {
		List<Gossip> gossips = new ArrayList<Gossip>();
		int start = (pageIndex-1)*pageSize;
		String sql ="SELECT * FROM gossip ORDER BY gossipNo desc LIMIT ?,?";
		Object [] params ={start,pageSize};
		
		ResultSet rs = super.executeQuery(sql, params);
		
		try {
			while(rs.next()){
				Gossip gossip = new Gossip();
				gossip.setGossipContent(resultSet.getString("gossipContent"));
				gossip.setGossipNo(resultSet.getInt("gossipNo"));
				gossip.setGoods(resultSet.getInt("goods"));
				gossip.setBads(resultSet.getInt("bads"));
				gossip.setReply(resultSet.getString("reply"));
				gossip.setGossipTime(resultSet.getString("gossipTime"));
				gossip.setGossipTitle(resultSet.getString("gossipTitle"));
				gossip.setReplyTime(resultSet.getString("replyTime"));
				gossips.add(gossip);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			this.closeConnection();
		}
		
		return gossips;
	}
	/**
	 * 得到Gossip总数
	 */
	public int getTotalCount() {
		int totalCount=0;
		Object[] params ={};
		String sql="SELECT COUNT(*) FROM gossip";
		ResultSet rs = super.executeQuery(sql, params);
		try {
			while(rs.next()){
				totalCount = rs.getInt(1);
			}
		} catch (Exception e) {
		}finally{
			super.closeConnection();
		}
		return totalCount;
	}
	public List<Gossip> getSome(String key,int pageIndex, int pageSize) {
		List<Gossip> gossips = new ArrayList<Gossip>();
		int start = (pageIndex-1)*pageSize;
		StringBuffer sbsql = new StringBuffer("SELECT * FROM gossip WHERE `gossipContent` LIKE '%");
		sbsql.append(key);
		sbsql.append("%'  LIMIT ?,?;");
		String sql =sbsql.toString();
		Object [] params ={start,pageSize};
		
		ResultSet rs = super.executeQuery(sql, params);
		
		try {
			while(rs.next()){
				Gossip gossip = new Gossip();
				gossip.setGossipContent(resultSet.getString("gossipContent"));
				gossip.setGossipNo(resultSet.getInt("gossipNo"));
				gossip.setGoods(resultSet.getInt("goods"));
				gossip.setBads(resultSet.getInt("bads"));
				gossip.setReply(resultSet.getString("reply"));
				gossip.setGossipTime(resultSet.getString("gossipTime"));
				gossip.setGossipTitle(resultSet.getString("gossipTitle"));
				gossip.setReplyTime(resultSet.getString("replyTime"));
				gossips.add(gossip);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			this.closeConnection();
		}
		
		return gossips;
	}
	public int getSomeTotalCount(String key) {
		int totalCount=0;
		Object[] params ={};
		StringBuffer sbsql = new StringBuffer("SELECT COUNT(*) FROM gossip WHERE `gossipContent` LIKE '%");
		sbsql.append(key);
		sbsql.append("%'");
		String sql=sbsql.toString();
		ResultSet rs = super.executeQuery(sql, params);
		try {
			while(rs.next()){
				totalCount = rs.getInt(1);
			}
		} catch (Exception e) {
		}finally{
			super.closeConnection();
		}
		return totalCount;
	}
	public int addBads(Gossip gossip) {
		int oldBads = gossip.getBads();
		String sql = "UPDATE `coffee`.`gossip` SET `bads` = ? WHERE `gossipNo` = ?; ";
		Object[] params = {oldBads+1,gossip.getGossipNo()};
		int flag = super.executeUpdate(sql, params);
		return flag;
	}
	
	public int addGoods(Gossip gossip) {
		int oldGoods = gossip.getGoods();
		String sql = "UPDATE `coffee`.`gossip` SET `goods` = ? WHERE `gossipNo` = ?;";
		Object[] params = {oldGoods+1,gossip.getGossipNo()};
		int flag = super.executeUpdate(sql, params);
		return flag;
	}
	public int addReply(Gossip gossip,String reply) {
		// TODO Auto-generated method stub
		gossip.setReply(reply);
		String date = new SimpleDateFormat().format(new Date());
		gossip.setReplyTime(date);
		String sql = "UPDATE `coffee`.`gossip` SET `reply` = ? , `replyTime` = ? WHERE `gossipNo` = ?";
		Object[] params ={reply,date,gossip.getGossipNo()};
		int flag = super.executeUpdate(sql, params);
		return flag;
	}
	
}
