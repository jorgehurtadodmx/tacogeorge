package george.taco_cloud.repository;

import george.taco_cloud.stufftoorder.TacoOrder;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository  extends CrudRepository<TacoOrder, Long> {
}
