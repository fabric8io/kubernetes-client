package io.fabric8.openshift.api.model.machine.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class LoadBalancerReferenceBuilder extends LoadBalancerReferenceFluent<LoadBalancerReferenceBuilder> implements VisitableBuilder<LoadBalancerReference,LoadBalancerReferenceBuilder>{

  LoadBalancerReferenceFluent<?> fluent;

  public LoadBalancerReferenceBuilder() {
    this(new LoadBalancerReference());
  }
  
  public LoadBalancerReferenceBuilder(LoadBalancerReferenceFluent<?> fluent) {
    this(fluent, new LoadBalancerReference());
  }
  
  public LoadBalancerReferenceBuilder(LoadBalancerReference instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public LoadBalancerReferenceBuilder(LoadBalancerReferenceFluent<?> fluent,LoadBalancerReference instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public LoadBalancerReference build() {
    LoadBalancerReference buildable = new LoadBalancerReference(fluent.getName(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}