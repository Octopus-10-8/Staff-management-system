package com.octopus.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 数据库工具类
 * 
 * @author Administrator
 *
 */
public class DButils {

	private static DataSource dataSource = null;

	// 加载C3P0连接池
	static {
		// 自动加载c3p0.xml配置文件

		dataSource = new ComboPooledDataSource();
		System.out.println("加载C3p0文件成功");
	}

	public static QueryRunner getQueryRunner() {

		// 创建QueryRunner，并且传入连接池，它会自动从数据源获取连接，并且会自动关闭连接
		System.out.println("数据库连接");
		return new QueryRunner(dataSource);
	}

	// 获取数据库连接，（备用的）
	public static Connection getconnection() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;

	}

	// 公共方法，用于增删改，使用的是update
	public static boolean updateOrder(String sql, Object[] arr) throws Exception {

		QueryRunner qRunner = getQueryRunner();

		int i = qRunner.update(sql, arr);
		if (i > 0) {
			return true;
		} else {

			return false;
		}

	}

}
