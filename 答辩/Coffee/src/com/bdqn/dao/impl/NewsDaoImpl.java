package com.bdqn.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bdqn.dao.NewsDao;
import com.bdqn.entity.News;
/**
 * NewsDao的实现类，对新闻进行数据库的操作
 * @author xinyuanru1
 *
 */
public class NewsDaoImpl extends BaseDaoImpl implements NewsDao{
	News news = new News();
	/**
	 * 按分页形式得到News集合
	 */
	public List<News> getNews(int pageIndex, int pageSize) {
		List<News> nnews = new ArrayList<News>();
		
		int start =(pageIndex-1)*pageSize;
		Object[] params={start,pageSize};
		 
		String sql ="SELECT * FROM news ORDER BY newsNo desc LIMIT ?,?";
		ResultSet rs = super.executeQuery(sql, params);
		
		try {
			while(rs.next()){
				News news = new News();
				news.setNewsNo(rs.getInt(1));
				news.setNewsTitle(rs.getString(2));
				news.setNewsContent(rs.getString(3));
				nnews.add(news);
				
			}
		} catch (Exception e) {
		}finally{
			super.closeConnection();
		}
		return nnews;
	}

	/**
	 * 得到News总数
	 */
	public int getTotalCount() {
		int totalCount=0;
		Object[] params ={};
		String sql="SELECT COUNT(*) FROM news";
		ResultSet rs =  super.executeQuery(sql, params);
		try {
			while(rs.next()){
				totalCount=rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			super.closeConnection();
		}
		return totalCount;
	}
	/**
	 * 增加News
	 */
	public int addNews(News news) {
		int result=0;
		try {
			String sql="INSERT INTO `coffee`.`news` ( `NewsTitle`, `NewsContent`) VALUES ( ?, ?)";
			Object[] params={
					news.getNewsTitle(),
					news.getNewsContent(),
			};
			result = executeUpdate(sql, params);
		} catch (Exception e) {
		}
		return result;
	}

	/**
	 * 根据newsNo（主键）删除News
	 */
	public int delNews(int newsNo) {
		int result = 0;
		try {
			
			String sql="DELETE FROM `coffee`.`news` WHERE NewsNO=?";
			Object[] params={
				newsNo
			};
			result = super.executeUpdate(sql, params);
		} catch (Exception e) {
		}
		return result;
		
		
	}

	/**
	 * 得到所有News集合
	 */
	public List<News> getAll() {
		List<News> newss = new ArrayList<News>();
		
		try {
			
			String sql = "SELECT * FROM `coffee`.`news`";
			Object[] params={};
			ResultSet rs=super.executeQuery(sql, params);
			while(rs.next()){
				News news = new News();
				news.setNewsNo(rs.getInt(1));
				news.setNewsTitle(rs.getString(2));
				news.setNewsContent(rs.getString(3));
				newss.add(news);
			}
		} catch (Exception e) {
		}finally{
		}
		return newss;
	}
	/**
	 * 根据newsNo得到News实体
	 */
	public News searchByNewsNo(int newsNo) {
		News news = null;
		try {
			String sql ="SELECT * FROM `coffee`.`news` WHERE newsNo = ?";
			Object[] params={newsNo};
			ResultSet rs = super.executeQuery(sql, params);
			while(rs.next()){
				news = new News();
				news.setNewsNo(rs.getInt("newsNo"));
				news.setNewsTitle(rs.getString("newsTitle"));
				news.setNewsContent(rs.getString("newsContent"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return news;
	}

	/**
	 * 修改News各项数据，newsNo（主键）不可修改
	 */
	public int updateStudent(News news) {
		int result=0;
		try {
			String sql=" UPDATE `coffee`.`news` SET `newsTitle` = ? , `newsContent` = ?  WHERE `newsNo` = ?; ";
			Object[] params={
					news.getNewsTitle(),
					news.getNewsContent(),
					news.getNewsNo()
			};
			result = super.executeUpdate(sql, params);
		} catch (Exception e) {
		}
		return result;
		
	}
}
