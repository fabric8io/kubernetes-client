package io.fabric8.knative.internal.networking.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class LoadBalancerIngressStatusBuilder extends LoadBalancerIngressStatusFluent<LoadBalancerIngressStatusBuilder> implements VisitableBuilder<LoadBalancerIngressStatus,LoadBalancerIngressStatusBuilder>{

  LoadBalancerIngressStatusFluent<?> fluent;

  public LoadBalancerIngressStatusBuilder() {
    this(new LoadBalancerIngressStatus());
  }
  
  public LoadBalancerIngressStatusBuilder(LoadBalancerIngressStatusFluent<?> fluent) {
    this(fluent, new LoadBalancerIngressStatus());
  }
  
  public LoadBalancerIngressStatusBuilder(LoadBalancerIngressStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public LoadBalancerIngressStatusBuilder(LoadBalancerIngressStatusFluent<?> fluent,LoadBalancerIngressStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public LoadBalancerIngressStatus build() {
    LoadBalancerIngressStatus buildable = new LoadBalancerIngressStatus(fluent.getDomain(), fluent.getDomainInternal(), fluent.getIp(), fluent.getMeshOnly());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}