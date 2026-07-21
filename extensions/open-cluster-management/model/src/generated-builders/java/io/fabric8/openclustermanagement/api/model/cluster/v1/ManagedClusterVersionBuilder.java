package io.fabric8.openclustermanagement.api.model.cluster.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ManagedClusterVersionBuilder extends ManagedClusterVersionFluent<ManagedClusterVersionBuilder> implements VisitableBuilder<ManagedClusterVersion,ManagedClusterVersionBuilder>{

  ManagedClusterVersionFluent<?> fluent;

  public ManagedClusterVersionBuilder() {
    this(new ManagedClusterVersion());
  }
  
  public ManagedClusterVersionBuilder(ManagedClusterVersionFluent<?> fluent) {
    this(fluent, new ManagedClusterVersion());
  }
  
  public ManagedClusterVersionBuilder(ManagedClusterVersion instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ManagedClusterVersionBuilder(ManagedClusterVersionFluent<?> fluent,ManagedClusterVersion instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ManagedClusterVersion build() {
    ManagedClusterVersion buildable = new ManagedClusterVersion(fluent.getKubernetes());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}