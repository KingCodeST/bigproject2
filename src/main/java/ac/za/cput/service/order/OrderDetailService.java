package ac.za.cput.service.order;

import ac.za.cput.domain.order.OrderDetail;
import ac.za.cput.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderDetailService extends IService<OrderDetail,String> {
    OrderDetail retrieveByDesc(String orderDetailDesc);
    List<OrderDetail> getAll();
}
