package com.study.springcore.tx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class BookDaoImpl implements BookDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Integer getPrice(Integer bid) {
		String sql="select price from book where bid=?";
		return jdbcTemplate.queryForObject(sql, Integer.class,bid);
	}

	@Override
	public Integer getStockAmount(Integer bid) {
		String sql="select amount from stock where bid=?";
		return jdbcTemplate.queryForObject(sql, Integer.class,bid);
	
	}

	@Override
	public Integer getWalletMoney(Integer wid) {
		String sql="select money from wallet where wid=?";
		return jdbcTemplate.queryForObject(sql, Integer.class,wid);
	
	}

	@Override
	public Integer updateStock(Integer bid, Integer amount) {
		// 修改庫存
		String sql="update stock set amount=amount-? where bid=?";
		return null;
	}

	@Override
	public Integer updateWallet(Integer wid, Integer money) {
		// 修改餘額
		String sql="select wallet set money =money=? where wid=?";
		return jdbcTemplate.queryForObject(sql, Integer.class,wid);
	
	}
}
