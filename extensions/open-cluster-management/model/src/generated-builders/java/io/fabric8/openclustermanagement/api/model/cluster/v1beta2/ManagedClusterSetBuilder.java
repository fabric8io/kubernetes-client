package io.fabric8.openclustermanagement.api.model.cluster.v1beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ManagedClusterSetBuilder extends ManagedClusterSetFluent<ManagedClusterSetBuilder> implements VisitableBuilder<ManagedClusterSet,ManagedClusterSetBuilder>{

  ManagedClusterSetFluent<?> fluent;

  public ManagedClusterSetBuilder() {
    this(new ManagedClusterSet());
  }
  
  public ManagedClusterSetBuilder(ManagedClusterSetFluent<?> fluent) {
    this(fluent, new ManagedClusterSet());
  }
  
  public ManagedClusterSetBuilder(ManagedClusterSet instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ManagedClusterSetBuilder(ManagedClusterSetFluent<?> fluent,ManagedClusterSet instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ManagedClusterSet build() {
    ManagedClusterSet buildable = new ManagedClusterSet(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}