package io.fabric8.kubernetes.api.model.networking.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IngressLoadBalancerIngressBuilder extends IngressLoadBalancerIngressFluent<IngressLoadBalancerIngressBuilder> implements VisitableBuilder<IngressLoadBalancerIngress,IngressLoadBalancerIngressBuilder>{

  IngressLoadBalancerIngressFluent<?> fluent;

  public IngressLoadBalancerIngressBuilder() {
    this(new IngressLoadBalancerIngress());
  }
  
  public IngressLoadBalancerIngressBuilder(IngressLoadBalancerIngressFluent<?> fluent) {
    this(fluent, new IngressLoadBalancerIngress());
  }
  
  public IngressLoadBalancerIngressBuilder(IngressLoadBalancerIngress instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IngressLoadBalancerIngressBuilder(IngressLoadBalancerIngressFluent<?> fluent,IngressLoadBalancerIngress instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IngressLoadBalancerIngress build() {
    IngressLoadBalancerIngress buildable = new IngressLoadBalancerIngress(fluent.getHostname(), fluent.getIp(), fluent.buildPorts());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}