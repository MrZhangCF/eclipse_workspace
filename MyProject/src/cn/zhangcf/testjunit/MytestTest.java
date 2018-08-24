package cn.zhangcf.testjunit;

import static org.junit.Assert.*;

import org.junit.Test;

import cn.zhangcf.test.Mytest;
import junit.framework.TestCase;

public class MytestTest {

	@Test
	public void testAdd() {
		TestCase.assertEquals(Mytest.add(10, 20), 30);
	}

}
