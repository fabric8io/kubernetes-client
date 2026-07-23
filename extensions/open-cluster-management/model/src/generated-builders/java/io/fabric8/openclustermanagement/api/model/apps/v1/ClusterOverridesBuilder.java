package io.fabric8.openclustermanagement.api.model.apps.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterOverridesBuilder extends ClusterOverridesFluent<ClusterOverridesBuilder> implements VisitableBuilder<ClusterOverrides,ClusterOverridesBuilder>{

  ClusterOverridesFluent<?> fluent;

  public ClusterOverridesBuilder() {
    this(new ClusterOverrides());
  }
  
  public ClusterOverridesBuilder(ClusterOverridesFluent<?> fluent) {
    this(fluent, new ClusterOverrides());
  }
  
  public ClusterOverridesBuilder(ClusterOverrides instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterOverridesBuilder(ClusterOverridesFluent<?> fluent,ClusterOverrides instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterOverrides build() {
    ClusterOverrides buildable = new ClusterOverrides(fluent.getClusterName(), fluent.buildClusterOverrides());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}