package biz.global.util;

import java.time.LocalDate;


public class NumberGenerator {
	
	public String generator(int size) {
		return "SN-" + Integer.toString(LocalDate.now().getYear()) + "-" +String.format("%04d",size);
	}

}
