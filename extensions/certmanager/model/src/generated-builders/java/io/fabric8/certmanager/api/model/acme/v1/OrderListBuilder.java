package io.fabric8.certmanager.api.model.acme.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OrderListBuilder extends OrderListFluent<OrderListBuilder> implements VisitableBuilder<OrderList,OrderListBuilder>{

  OrderListFluent<?> fluent;

  public OrderListBuilder() {
    this(new OrderList());
  }
  
  public OrderListBuilder(OrderListFluent<?> fluent) {
    this(fluent, new OrderList());
  }
  
  public OrderListBuilder(OrderList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OrderListBuilder(OrderListFluent<?> fluent,OrderList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OrderList build() {
    OrderList buildable = new OrderList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}