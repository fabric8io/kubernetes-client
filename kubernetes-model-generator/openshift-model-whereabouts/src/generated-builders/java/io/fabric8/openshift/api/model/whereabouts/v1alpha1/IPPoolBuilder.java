package io.fabric8.openshift.api.model.whereabouts.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IPPoolBuilder extends IPPoolFluent<IPPoolBuilder> implements VisitableBuilder<IPPool,IPPoolBuilder>{

  IPPoolFluent<?> fluent;

  public IPPoolBuilder() {
    this(new IPPool());
  }
  
  public IPPoolBuilder(IPPoolFluent<?> fluent) {
    this(fluent, new IPPool());
  }
  
  public IPPoolBuilder(IPPool instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IPPoolBuilder(IPPoolFluent<?> fluent,IPPool instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IPPool build() {
    IPPool buildable = new IPPool(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}