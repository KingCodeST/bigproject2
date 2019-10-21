package ac.za.cput.service.order;

import ac.za.cput.domain.order.OrderStatus;
import ac.za.cput.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderStatusService extends IService<OrderStatus,String> {
    OrderStatus retrieveByDesc(String orderStatusDesc);
    List<OrderStatus> getAll();
}
