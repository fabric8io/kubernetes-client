package io.fabric8.openclustermanagement.api.model.cluster.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ManagedNamespaceConfigBuilder extends ManagedNamespaceConfigFluent<ManagedNamespaceConfigBuilder> implements VisitableBuilder<ManagedNamespaceConfig,ManagedNamespaceConfigBuilder>{

  ManagedNamespaceConfigFluent<?> fluent;

  public ManagedNamespaceConfigBuilder() {
    this(new ManagedNamespaceConfig());
  }
  
  public ManagedNamespaceConfigBuilder(ManagedNamespaceConfigFluent<?> fluent) {
    this(fluent, new ManagedNamespaceConfig());
  }
  
  public ManagedNamespaceConfigBuilder(ManagedNamespaceConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ManagedNamespaceConfigBuilder(ManagedNamespaceConfigFluent<?> fluent,ManagedNamespaceConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ManagedNamespaceConfig build() {
    ManagedNamespaceConfig buildable = new ManagedNamespaceConfig(fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}