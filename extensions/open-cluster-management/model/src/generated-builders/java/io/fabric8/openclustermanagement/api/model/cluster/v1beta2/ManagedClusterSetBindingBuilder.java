package io.fabric8.openclustermanagement.api.model.cluster.v1beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ManagedClusterSetBindingBuilder extends ManagedClusterSetBindingFluent<ManagedClusterSetBindingBuilder> implements VisitableBuilder<ManagedClusterSetBinding,ManagedClusterSetBindingBuilder>{

  ManagedClusterSetBindingFluent<?> fluent;

  public ManagedClusterSetBindingBuilder() {
    this(new ManagedClusterSetBinding());
  }
  
  public ManagedClusterSetBindingBuilder(ManagedClusterSetBindingFluent<?> fluent) {
    this(fluent, new ManagedClusterSetBinding());
  }
  
  public ManagedClusterSetBindingBuilder(ManagedClusterSetBinding instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ManagedClusterSetBindingBuilder(ManagedClusterSetBindingFluent<?> fluent,ManagedClusterSetBinding instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ManagedClusterSetBinding build() {
    ManagedClusterSetBinding buildable = new ManagedClusterSetBinding(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}