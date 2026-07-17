package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HostSelectorBuilder extends HostSelectorFluent<HostSelectorBuilder> implements VisitableBuilder<HostSelector,HostSelectorBuilder>{

  HostSelectorFluent<?> fluent;

  public HostSelectorBuilder() {
    this(new HostSelector());
  }
  
  public HostSelectorBuilder(HostSelectorFluent<?> fluent) {
    this(fluent, new HostSelector());
  }
  
  public HostSelectorBuilder(HostSelector instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HostSelectorBuilder(HostSelectorFluent<?> fluent,HostSelector instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HostSelector build() {
    HostSelector buildable = new HostSelector(fluent.getInNamespace(), fluent.buildMatchExpressions(), fluent.getMatchLabels());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}