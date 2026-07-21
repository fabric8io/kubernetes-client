package io.fabric8.openclustermanagement.api.model.cluster.v1beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ManagedClusterSetBindingSpecBuilder extends ManagedClusterSetBindingSpecFluent<ManagedClusterSetBindingSpecBuilder> implements VisitableBuilder<ManagedClusterSetBindingSpec,ManagedClusterSetBindingSpecBuilder>{

  ManagedClusterSetBindingSpecFluent<?> fluent;

  public ManagedClusterSetBindingSpecBuilder() {
    this(new ManagedClusterSetBindingSpec());
  }
  
  public ManagedClusterSetBindingSpecBuilder(ManagedClusterSetBindingSpecFluent<?> fluent) {
    this(fluent, new ManagedClusterSetBindingSpec());
  }
  
  public ManagedClusterSetBindingSpecBuilder(ManagedClusterSetBindingSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ManagedClusterSetBindingSpecBuilder(ManagedClusterSetBindingSpecFluent<?> fluent,ManagedClusterSetBindingSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ManagedClusterSetBindingSpec build() {
    ManagedClusterSetBindingSpec buildable = new ManagedClusterSetBindingSpec(fluent.getClusterSet());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}