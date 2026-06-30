package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class LoadBalancerIngressBuilder extends LoadBalancerIngressFluent<LoadBalancerIngressBuilder> implements VisitableBuilder<LoadBalancerIngress,LoadBalancerIngressBuilder>{

  LoadBalancerIngressFluent<?> fluent;

  public LoadBalancerIngressBuilder() {
    this(new LoadBalancerIngress());
  }
  
  public LoadBalancerIngressBuilder(LoadBalancerIngressFluent<?> fluent) {
    this(fluent, new LoadBalancerIngress());
  }
  
  public LoadBalancerIngressBuilder(LoadBalancerIngress instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public LoadBalancerIngressBuilder(LoadBalancerIngressFluent<?> fluent,LoadBalancerIngress instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public LoadBalancerIngress build() {
    LoadBalancerIngress buildable = new LoadBalancerIngress(fluent.getHostname(), fluent.getIp(), fluent.getIpMode(), fluent.buildPorts());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}