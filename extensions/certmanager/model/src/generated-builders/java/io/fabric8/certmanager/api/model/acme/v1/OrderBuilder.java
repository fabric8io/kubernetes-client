package io.fabric8.certmanager.api.model.acme.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OrderBuilder extends OrderFluent<OrderBuilder> implements VisitableBuilder<Order,OrderBuilder>{

  OrderFluent<?> fluent;

  public OrderBuilder() {
    this(new Order());
  }
  
  public OrderBuilder(OrderFluent<?> fluent) {
    this(fluent, new Order());
  }
  
  public OrderBuilder(Order instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OrderBuilder(OrderFluent<?> fluent,Order instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Order build() {
    Order buildable = new Order(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}