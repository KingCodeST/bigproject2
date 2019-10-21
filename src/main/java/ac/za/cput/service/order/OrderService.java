package ac.za.cput.service.order;

import ac.za.cput.domain.order.Orders;
import ac.za.cput.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService extends IService<Orders,String> {
    Orders retrieveByDesc(String orderDesc);
    List<Orders> getAll();
}
