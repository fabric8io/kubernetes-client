package io.fabric8.openclustermanagement.api.model.apps.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterOverrideBuilder extends ClusterOverrideFluent<ClusterOverrideBuilder> implements VisitableBuilder<ClusterOverride,ClusterOverrideBuilder>{

  ClusterOverrideFluent<?> fluent;

  public ClusterOverrideBuilder() {
    this(new ClusterOverride());
  }
  
  public ClusterOverrideBuilder(ClusterOverrideFluent<?> fluent) {
    this(fluent, new ClusterOverride());
  }
  
  public ClusterOverrideBuilder(ClusterOverride instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterOverrideBuilder(ClusterOverrideFluent<?> fluent,ClusterOverride instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterOverride build() {
    ClusterOverride buildable = new ClusterOverride();
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}