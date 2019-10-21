package ac.za.cput.service.order;

import ac.za.cput.domain.order.Item;
import ac.za.cput.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemService extends IService<Item,String> {
    Item retrieveByDesc(String itemDesc);
    List<Item> getAll();
}
