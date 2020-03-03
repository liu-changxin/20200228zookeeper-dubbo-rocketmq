package com.lcx;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.reflect.generics.reflectiveObjects.LazyReflectiveObjectGenerator;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringbootZdrMqProviderApplicationTests {
	@Test
	public void test1(){
		Item1 item1=new Item1();
		try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("testFile"))){
			System.out.println("哈哈");
			oos.writeObject(item1);
		}catch (Exception e){
			System.out.println("报错信息："+e.getMessage());
		}
	}
	@Test
	public void test2() {
		try(ObjectInputStream oos=new ObjectInputStream(new FileInputStream("testFile"))){
			System.out.println("哈哈");
			System.out.println(oos.readObject());
		}catch (Exception e){
			System.out.println("报错信息："+e.getMessage());
		}
	}
	@Test
	public void test3() {
		List<String> list1=new ArrayList<String>();
		list1.add("xx");
		list1.add("xx");
		list1.add("yy");
		list1.add("yy");
		list1.add("zz");
		list1.add("zz");
//		list1.add("xx");
//		list1.add("xx");
//		list1.add("yy");
//		list1.add("yy");
//		list1.add("zz");
//		list1.add("zz");
		System.out.println(list1);
//		for (int i = 0; i < list1.size(); i++) {
////			String stringvalue1=list1.get(i);
////			if("yy".equals(stringvalue1)){
////				list1.remove(stringvalue1);
////			}
////		}
		Iterator<String> iterator=list1.iterator();
		while(iterator.hasNext()){
			String next = iterator.next();
			if("yy".equals(next)){
				System.out.println("开始删除？");
				iterator.remove();
			}
		}
		System.out.println(list1);
	}
}
class Item1 implements Serializable {
	private static final long serialVersionUID =42L;
//	private String name;

}