package sia.tacocloud.repositories;

import org.springframework.data.repository.CrudRepository;
import sia.tacocloud.data.TacoOrder;

public interface OrderRepository extends CrudRepository<TacoOrder, Long> {

}