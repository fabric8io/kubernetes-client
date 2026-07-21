package io.fabric8.openclustermanagement.api.model.cluster.v1beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ManagedClusterSetSpecBuilder extends ManagedClusterSetSpecFluent<ManagedClusterSetSpecBuilder> implements VisitableBuilder<ManagedClusterSetSpec,ManagedClusterSetSpecBuilder>{

  ManagedClusterSetSpecFluent<?> fluent;

  public ManagedClusterSetSpecBuilder() {
    this(new ManagedClusterSetSpec());
  }
  
  public ManagedClusterSetSpecBuilder(ManagedClusterSetSpecFluent<?> fluent) {
    this(fluent, new ManagedClusterSetSpec());
  }
  
  public ManagedClusterSetSpecBuilder(ManagedClusterSetSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ManagedClusterSetSpecBuilder(ManagedClusterSetSpecFluent<?> fluent,ManagedClusterSetSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ManagedClusterSetSpec build() {
    ManagedClusterSetSpec buildable = new ManagedClusterSetSpec(fluent.buildClusterSelector(), fluent.buildManagedNamespaces());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}