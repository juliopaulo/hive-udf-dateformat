package com.hive.udf;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.hadoop.hive.ql.exec.Description;
import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.Text;

@Description(extended = "", name = "", value = "")
public class DateFormat extends UDF {

	
	public static String DATE_FORMAT_MM_DD_YY="MM/dd/yy"; //08/22/54
	public static String DATE_FORMAT_MM_DD_YYYY="MM/dd/yyyy"; //08/22/1954
	public static String DATE_FORMAT_MMM_D_YYYY="MMM d, yyyy"; //Jan 11, 2004
	
	public static String DATE_FORMAT_MMM_DD_YY_FINAL="MM/dd/yy"; //
	
	public static String DATE_FORMAT_MMM_DD_YY_HH_MM_SS="yyyy-MM-dd HH:mm:ss"; //
	
	/**
	 * Jan 11, 2004
	 * 6/17/1969
	 * 08/22/54
	 * @param s
	 * @return
	 */
	
	public Text evaluate(final Text s) {
		
		SimpleDateFormat formatter=null;
		Date dFinal=null;
		if (s == null) {
			return null;
		}
		
		String sDate= s.toString();
		
		formatter=new SimpleDateFormat(DATE_FORMAT_MMM_D_YYYY);
		try {
			dFinal=formatter.parse(sDate);
		} catch (ParseException e) {
			
			formatter=new SimpleDateFormat(DATE_FORMAT_MM_DD_YYYY);
			try {
				dFinal=formatter.parse(sDate);
			} catch (ParseException e1) {
				formatter=new SimpleDateFormat(DATE_FORMAT_MM_DD_YY);
				try {
					dFinal=formatter.parse(sDate);
				} catch (ParseException e2) {
					formatter=new SimpleDateFormat(DATE_FORMAT_MMM_DD_YY_HH_MM_SS);
					
					try {
						dFinal=formatter.parse(sDate);
					} catch (ParseException e3) {
						e3.printStackTrace();
					}
				}
			}
		}
		
		formatter=new SimpleDateFormat(DATE_FORMAT_MMM_DD_YY_FINAL);
		String finalDate=formatter.format(dFinal);
		
		
		return new Text(finalDate);
	}

}
