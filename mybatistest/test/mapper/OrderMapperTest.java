package mapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import pojo.OrderUser;
import pojo.Orders;

public class OrderMapperTest {

	private SqlSessionFactory sqlSessionFactory = null; // 工厂对象一般在我们的系统中是单例的

    @Before
    public void init() throws IOException {
        // 第一步，创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        // 第二步，加载配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 第三步，创建SqlSessionFactory对象
        sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
    }

    //@Test
    public void testGetOrderList() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        List<Orders> orderList = orderMapper.getOrderList();
        for (Orders orders : orderList) {
            System.out.println(orders);
        }
        sqlSession.close();
    }
    @Test
    public void testGetOrderUserList(){
    	SqlSession ss = sqlSessionFactory.openSession();
    	OrderMapper om = ss.getMapper(OrderMapper.class);
    	List<OrderUser> list = om.getOrderUserList();
    	for(OrderUser ou:list){
    		System.out.println(ou);
    	}
    }
}
