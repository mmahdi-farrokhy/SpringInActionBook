package mmf.tacocloud.tacos.data;

import mmf.tacocloud.tacos.TacoOrder;

public interface OrderRepository {
    TacoOrder save(TacoOrder order);
}
