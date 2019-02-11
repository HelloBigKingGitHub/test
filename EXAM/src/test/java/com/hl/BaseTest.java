package com.hl;
import javax.annotation.Resource;
import javax.sql.DataSource;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 需要注意的时spring-test的jar包有依赖版本问题 使用<version>4.1.0.RELEASE</version>
 * 这个版本的jar包依赖就能解决到相关的报错
 * @author admin
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml","classpath:spring/spring-transaction.xml"})
public class BaseTest extends AbstractTransactionalJUnit4SpringContextTests{
 
	/*
	 * 这个方法也是能省略的，只要是dao层配置中定义的数据的id属性和dataSource一致就行
	 * 如果不一致就使用@Resource(name = "dataSource")进行修改
	 * */
    @Override
    @Resource(name = "dataSource")
    public void setDataSource(DataSource dataSource) {
        // TODO Auto-generated method stub
        super.setDataSource(dataSource);
    }
}
