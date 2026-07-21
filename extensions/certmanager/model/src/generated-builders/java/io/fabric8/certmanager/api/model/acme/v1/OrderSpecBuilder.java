package io.fabric8.certmanager.api.model.acme.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OrderSpecBuilder extends OrderSpecFluent<OrderSpecBuilder> implements VisitableBuilder<OrderSpec,OrderSpecBuilder>{

  OrderSpecFluent<?> fluent;

  public OrderSpecBuilder() {
    this(new OrderSpec());
  }
  
  public OrderSpecBuilder(OrderSpecFluent<?> fluent) {
    this(fluent, new OrderSpec());
  }
  
  public OrderSpecBuilder(OrderSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OrderSpecBuilder(OrderSpecFluent<?> fluent,OrderSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OrderSpec build() {
    OrderSpec buildable = new OrderSpec(fluent.getCommonName(), fluent.getDnsNames(), fluent.getDuration(), fluent.getIpAddresses(), fluent.buildIssuerRef(), fluent.getProfile(), fluent.getRequest());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}