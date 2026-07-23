package io.fabric8.openclustermanagement.api.model.cluster.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterSetManagedNamespaceConfigBuilder extends ClusterSetManagedNamespaceConfigFluent<ClusterSetManagedNamespaceConfigBuilder> implements VisitableBuilder<ClusterSetManagedNamespaceConfig,ClusterSetManagedNamespaceConfigBuilder>{

  ClusterSetManagedNamespaceConfigFluent<?> fluent;

  public ClusterSetManagedNamespaceConfigBuilder() {
    this(new ClusterSetManagedNamespaceConfig());
  }
  
  public ClusterSetManagedNamespaceConfigBuilder(ClusterSetManagedNamespaceConfigFluent<?> fluent) {
    this(fluent, new ClusterSetManagedNamespaceConfig());
  }
  
  public ClusterSetManagedNamespaceConfigBuilder(ClusterSetManagedNamespaceConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterSetManagedNamespaceConfigBuilder(ClusterSetManagedNamespaceConfigFluent<?> fluent,ClusterSetManagedNamespaceConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterSetManagedNamespaceConfig build() {
    ClusterSetManagedNamespaceConfig buildable = new ClusterSetManagedNamespaceConfig(fluent.getClusterSet(), fluent.getConditions(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}