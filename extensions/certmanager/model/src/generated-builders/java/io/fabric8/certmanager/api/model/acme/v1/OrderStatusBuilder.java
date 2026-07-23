package io.fabric8.certmanager.api.model.acme.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OrderStatusBuilder extends OrderStatusFluent<OrderStatusBuilder> implements VisitableBuilder<OrderStatus,OrderStatusBuilder>{

  OrderStatusFluent<?> fluent;

  public OrderStatusBuilder() {
    this(new OrderStatus());
  }
  
  public OrderStatusBuilder(OrderStatusFluent<?> fluent) {
    this(fluent, new OrderStatus());
  }
  
  public OrderStatusBuilder(OrderStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OrderStatusBuilder(OrderStatusFluent<?> fluent,OrderStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OrderStatus build() {
    OrderStatus buildable = new OrderStatus(fluent.buildAuthorizations(), fluent.getCertificate(), fluent.getFailureTime(), fluent.getFinalizeURL(), fluent.getReason(), fluent.getState(), fluent.getUrl());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}