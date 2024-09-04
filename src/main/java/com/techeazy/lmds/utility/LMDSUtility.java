package com.techeazy.lmds.utility;

import java.sql.Date;

public class LMDSUtility {

	public static Date getDate() {
		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);
		return date;

	}
	public static void main(String[] args) {
		System.out.println(getDate());
	}

}
