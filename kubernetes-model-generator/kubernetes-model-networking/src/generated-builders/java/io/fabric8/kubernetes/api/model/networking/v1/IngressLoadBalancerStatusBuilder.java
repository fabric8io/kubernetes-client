package io.fabric8.kubernetes.api.model.networking.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IngressLoadBalancerStatusBuilder extends IngressLoadBalancerStatusFluent<IngressLoadBalancerStatusBuilder> implements VisitableBuilder<IngressLoadBalancerStatus,IngressLoadBalancerStatusBuilder>{

  IngressLoadBalancerStatusFluent<?> fluent;

  public IngressLoadBalancerStatusBuilder() {
    this(new IngressLoadBalancerStatus());
  }
  
  public IngressLoadBalancerStatusBuilder(IngressLoadBalancerStatusFluent<?> fluent) {
    this(fluent, new IngressLoadBalancerStatus());
  }
  
  public IngressLoadBalancerStatusBuilder(IngressLoadBalancerStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IngressLoadBalancerStatusBuilder(IngressLoadBalancerStatusFluent<?> fluent,IngressLoadBalancerStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IngressLoadBalancerStatus build() {
    IngressLoadBalancerStatus buildable = new IngressLoadBalancerStatus(fluent.buildIngress());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}