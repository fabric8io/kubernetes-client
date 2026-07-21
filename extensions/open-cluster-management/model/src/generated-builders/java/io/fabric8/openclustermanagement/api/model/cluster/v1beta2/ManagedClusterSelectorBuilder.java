package io.fabric8.openclustermanagement.api.model.cluster.v1beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ManagedClusterSelectorBuilder extends ManagedClusterSelectorFluent<ManagedClusterSelectorBuilder> implements VisitableBuilder<ManagedClusterSelector,ManagedClusterSelectorBuilder>{

  ManagedClusterSelectorFluent<?> fluent;

  public ManagedClusterSelectorBuilder() {
    this(new ManagedClusterSelector());
  }
  
  public ManagedClusterSelectorBuilder(ManagedClusterSelectorFluent<?> fluent) {
    this(fluent, new ManagedClusterSelector());
  }
  
  public ManagedClusterSelectorBuilder(ManagedClusterSelector instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ManagedClusterSelectorBuilder(ManagedClusterSelectorFluent<?> fluent,ManagedClusterSelector instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ManagedClusterSelector build() {
    ManagedClusterSelector buildable = new ManagedClusterSelector(fluent.buildLabelSelector(), fluent.getSelectorType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}