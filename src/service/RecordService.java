package service;

import java.util.Date;

import dao.RecordDao;
import entity.Record;
import entity.Category;


public class RecordService {
	RecordDao recordDao = new RecordDao();
	public void add(int spend, Category c, String comment, Date date) {
		Record r = new Record();
		r.spend =spend;
		r.cid = c.id;
		r.comment = comment;
		r.date = date;
		System.out.print(r.date);
		recordDao.add(r);
	}
}
