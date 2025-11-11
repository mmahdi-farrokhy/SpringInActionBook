package org.mmf.chapter7.data;

import org.mmf.chapter7.TacoOrder;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<TacoOrder, Long> {
}
