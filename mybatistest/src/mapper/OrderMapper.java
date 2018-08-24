package mapper;

import java.util.List;

import pojo.OrderUser;
import pojo.Orders;

public interface OrderMapper {
	List<Orders> getOrderList();
	List<OrderUser> getOrderUserList();
}
