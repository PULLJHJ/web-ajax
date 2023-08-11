package com.web.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.web.vo.UserInfoVO;

public class MybatisConfig {
	
	private static SqlSessionFactory SSF;
	private final static String CONFIG_PATH = "config/mybatis-config.xml";
	
	static {
		try {
			InputStream is = Resources.getResourceAsStream(CONFIG_PATH); 
			SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
			SSF = ssfb.build(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSessionFactory getSqlSessionFactory() {
		return SSF;
	}
	
	public static void main(String[] args) {
		try(SqlSession session = getSqlSessionFactory().openSession(true)) {
			List<UserInfoVO> list = session.selectList("com.web.mapper.UserInfoMapper.selectUserInfoList");
			for(UserInfoVO userInfo : list) {
				System.out.println(userInfo);
			}

//			int uiNum = 25;
//			UserInfoVO updateUser = new UserInfoVO();
//			updateUser.setUiNum(uiNum);
//			updateUser.setUiName("정해준");
//			updateUser.setUiId("test");
//			updateUser.setUiPwd("test132");
//			updateUser.setUiDesc("test23");
//			updateUser.setUiBirth("20230811");
//
//			int updateCount = session.update("com.web.mapper.UserInfoMapper.updateUserInfo", updateUser);
//			session.commit();
//			
//			System.out.println(updateUser);
//			System.out.println(updateCount);
			
//			int uiNum = 25;
//			UserInfoVO deleteUser = new UserInfoVO();
//			deleteUser.setUiNum(uiNum);
//			int updateCount = session.delete("com.web.mapper.UserInfoMapper.deleteUserInfo", deleteUser);
//			session.commit();
//			System.out.println(deleteUser);
//			System.out.println(updateCount);
			
//			UserInfoVO insertUser = new UserInfoVO();
//			insertUser.setUiName("김철수");
//			insertUser.setUiId("qwer");
//			insertUser.setUiPwd("qwer1234");
//			insertUser.setUiDesc("김철수");
//			insertUser.setUiBirth("20230811");
//			
//			int insertCount = session.insert("com.web.mapper.UserInfoMapper.insertUserInfo", insertUser);
//			session.commit();
//			System.out.println(insertCount);
//			System.out.println(insertUser);
		} catch(Exception e) {
			throw e;
		}
	}
}
