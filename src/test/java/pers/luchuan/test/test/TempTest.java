package pers.luchuan.test.test;

import org.junit.Test;

/**
 * Created by Lu Chuan on 2019/3/4
 */
public class TempTest {
	
	@Test
	public void testString() {
		String str = "111" + null;
		System.out.println(str); // 结果：111null
	}
	
	@Test
	public void testTryCatch() throws Exception{
		System.out.println("111");
		try {
			int i = 1 / 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("222");
	}
}
