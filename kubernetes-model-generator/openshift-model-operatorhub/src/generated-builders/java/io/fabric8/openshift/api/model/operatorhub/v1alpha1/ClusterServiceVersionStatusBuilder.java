package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterServiceVersionStatusBuilder extends ClusterServiceVersionStatusFluent<ClusterServiceVersionStatusBuilder> implements VisitableBuilder<ClusterServiceVersionStatus,ClusterServiceVersionStatusBuilder>{

  ClusterServiceVersionStatusFluent<?> fluent;

  public ClusterServiceVersionStatusBuilder() {
    this(new ClusterServiceVersionStatus());
  }
  
  public ClusterServiceVersionStatusBuilder(ClusterServiceVersionStatusFluent<?> fluent) {
    this(fluent, new ClusterServiceVersionStatus());
  }
  
  public ClusterServiceVersionStatusBuilder(ClusterServiceVersionStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterServiceVersionStatusBuilder(ClusterServiceVersionStatusFluent<?> fluent,ClusterServiceVersionStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterServiceVersionStatus build() {
    ClusterServiceVersionStatus buildable = new ClusterServiceVersionStatus(fluent.getCertsLastUpdated(), fluent.getCertsRotateAt(), fluent.buildCleanup(), fluent.buildConditions(), fluent.getLastTransitionTime(), fluent.getLastUpdateTime(), fluent.getMessage(), fluent.getPhase(), fluent.getReason(), fluent.buildRequirementStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}