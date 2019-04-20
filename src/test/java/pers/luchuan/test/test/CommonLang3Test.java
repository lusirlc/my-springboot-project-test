package pers.luchuan.test.test;

import org.apache.commons.collections.ListUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.*;
import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;
import pers.luchuan.test.entity.UserBean;
import pers.luchuan.test.enums.BooleanEnum;

import java.util.Collections;
import java.util.Objects;
import java.util.List;
import java.util.Map;

/**
 * Created By Chuan Lu On 2019/3/8 11:23
 */
public class CommonLang3Test {
	@Test
	public void testClassPathUtils() {
//		String path = ClassPathUtils.toFullyQualifiedName(UserBean.class, "UserBean");
		String path = ClassPathUtils.toFullyQualifiedName(UserBean.class.getPackage(), "UserBean");
		String position = ClassPathUtils.toFullyQualifiedPath(UserBean.class, "UserBean");
		System.out.println(path);
		System.out.println(position);
	}
	
	@Test
	public void testEnumUtils() {
		BooleanEnum no = EnumUtils.getEnum(BooleanEnum.class, "NO");
		List<BooleanEnum> enumList = EnumUtils.getEnumList(BooleanEnum.class);
		Map<String, BooleanEnum> enumMap = EnumUtils.getEnumMap(BooleanEnum.class);
		System.out.println(no);
		for (BooleanEnum booleanEnum : enumList) {
			System.out.println(booleanEnum.getValue());
		}
		for (Map.Entry<String, BooleanEnum> enumEntry : enumMap.entrySet()) {
			System.out.println(enumEntry.getKey()+":"+enumEntry.getValue());
		}
	}
	
	@Test
	public void testObjectUtils() {
		System.out.println(ObjectUtils.allNotNull(null, new Object()));
		System.out.println(ObjectUtils.anyNotNull(null, new Object()));
		System.out.println(ObjectUtils.defaultIfNull(null, 1));
	}
	
	@Test
	public void testRandomUtils() {
		System.out.println(RandomUtils.nextBoolean());
		System.out.println(RandomUtils.nextBytes(5));
		System.out.println(RandomUtils.nextDouble());
		System.out.println(RandomUtils.nextFloat());
		System.out.println(RandomUtils.nextFloat(1,10));
		System.out.println(RandomUtils.nextInt());
		System.out.println(RandomUtils.nextInt(1,10));
		System.out.println(RandomUtils.nextLong(1,10));
	}
	
	@Test
	public void testSystemUtils() {
		System.out.println(SystemUtils.IS_OS_WINDOWS);
		System.out.println(SystemUtils.getHostName());
		System.out.println(SystemUtils.getJavaHome());
		System.out.println(SystemUtils.getUserHome());
		System.out.println(SystemUtils.getUserDir());
		System.out.println(SystemUtils.JAVA_HOME);
		System.out.println(SystemUtils.JAVA_VERSION);
		System.out.println(SystemUtils.OS_NAME);
		System.out.println(SystemUtils.FILE_ENCODING);
		System.out.println(SystemUtils.USER_LANGUAGE);
	}
	
	@Test
	public void testStringUtils() {
		System.out.println(ObjectUtils.notEqual(null, null));
		ObjectUtils.identityToString(null);
		System.out.println(Objects.equals(null, null));
	}
}
