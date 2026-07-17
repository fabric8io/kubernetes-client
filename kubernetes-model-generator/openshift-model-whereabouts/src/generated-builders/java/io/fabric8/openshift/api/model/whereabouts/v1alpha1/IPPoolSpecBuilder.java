package io.fabric8.openshift.api.model.whereabouts.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IPPoolSpecBuilder extends IPPoolSpecFluent<IPPoolSpecBuilder> implements VisitableBuilder<IPPoolSpec,IPPoolSpecBuilder>{

  IPPoolSpecFluent<?> fluent;

  public IPPoolSpecBuilder() {
    this(new IPPoolSpec());
  }
  
  public IPPoolSpecBuilder(IPPoolSpecFluent<?> fluent) {
    this(fluent, new IPPoolSpec());
  }
  
  public IPPoolSpecBuilder(IPPoolSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IPPoolSpecBuilder(IPPoolSpecFluent<?> fluent,IPPoolSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IPPoolSpec build() {
    IPPoolSpec buildable = new IPPoolSpec(fluent.getAllocations(), fluent.getRange());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}