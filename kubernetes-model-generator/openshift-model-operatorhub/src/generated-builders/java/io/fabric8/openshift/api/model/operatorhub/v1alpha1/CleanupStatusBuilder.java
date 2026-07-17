package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CleanupStatusBuilder extends CleanupStatusFluent<CleanupStatusBuilder> implements VisitableBuilder<CleanupStatus,CleanupStatusBuilder>{

  CleanupStatusFluent<?> fluent;

  public CleanupStatusBuilder() {
    this(new CleanupStatus());
  }
  
  public CleanupStatusBuilder(CleanupStatusFluent<?> fluent) {
    this(fluent, new CleanupStatus());
  }
  
  public CleanupStatusBuilder(CleanupStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CleanupStatusBuilder(CleanupStatusFluent<?> fluent,CleanupStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CleanupStatus build() {
    CleanupStatus buildable = new CleanupStatus(fluent.buildPendingDeletion());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}