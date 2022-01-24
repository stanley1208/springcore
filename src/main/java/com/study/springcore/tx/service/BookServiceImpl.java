package com.study.springcore.tx.service;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springcore.tx.dao.BookDao;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private BookDao bookDao;
	
	@Override
	public void buyOne(Integer wid, Integer bid) {
		// 減去一本庫存
		bookDao.updateStock(bid, 1);
		// 取得書籍價格
		Integer price=bookDao.getPrice(bid);
		// 減去錢包裡的金額
		bookDao.updateWallet(wid, price);
		// Log ...
	}

	@Override
	public void buyMany(Integer wid, Integer... bids) {
		// 重複執行 buyOne
		Stream.of(bids).forEach(bid->buyOne(wid, bid));
		// Log ...
	}
	
}
