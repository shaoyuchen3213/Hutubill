package service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import dao.RecordDao;
import entity.Record;
import util.DateUtil;

import java.text.SimpleDateFormat;

public class ReportService {
	
	/*
	 * 获取某一天的消费金额
	 * @param d
	 * @param monthRawData
	 * @return
	 * 
	 */
	
	//获取一天的消费数据
    public int getDaySpend(Date d,List<Record> monthData) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dstring = sdf.format(d);
        int daySpend = 0;
        for(Record day : monthData) {
            String rdate = sdf.format(day.date);
            if(rdate.equals(dstring)) {
            daySpend += day.getSpend();
            }
        }
        return daySpend;
    }
	
	/*
	 * 获取一个月的消费记录集合
	 * @return
	 */
	public List<Record> listThisMonthRecords(){
		RecordDao dao = new RecordDao();
		List<Record> monthRawData = dao.listThisMonth();
		List<Record> result = new ArrayList<>();
		Date monthBegin = DateUtil.monthBegin();
		int monthTotalDay = DateUtil.thisMonthTotalDay();
		Calendar c = Calendar.getInstance();
		for(int i=0; i<monthTotalDay; i++) {
			Record r = new Record();
			c.setTime(monthBegin);
			c.add(Calendar.DATE, i);
			Date eachDayOfThisMonth = c.getTime();
			int daySpend = getDaySpend(eachDayOfThisMonth, monthRawData);
			r.spend = daySpend;
			result.add(r);
		}
		return result;
	}
		
}
