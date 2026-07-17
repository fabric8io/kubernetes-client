package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterVersionStatusBuilder extends ClusterVersionStatusFluent<ClusterVersionStatusBuilder> implements VisitableBuilder<ClusterVersionStatus,ClusterVersionStatusBuilder>{

  ClusterVersionStatusFluent<?> fluent;

  public ClusterVersionStatusBuilder() {
    this(new ClusterVersionStatus());
  }
  
  public ClusterVersionStatusBuilder(ClusterVersionStatusFluent<?> fluent) {
    this(fluent, new ClusterVersionStatus());
  }
  
  public ClusterVersionStatusBuilder(ClusterVersionStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterVersionStatusBuilder(ClusterVersionStatusFluent<?> fluent,ClusterVersionStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterVersionStatus build() {
    ClusterVersionStatus buildable = new ClusterVersionStatus(fluent.buildAvailableUpdates(), fluent.buildCapabilities(), fluent.buildConditionalUpdates(), fluent.buildConditions(), fluent.buildDesired(), fluent.buildHistory(), fluent.getObservedGeneration(), fluent.getVersionHash());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}