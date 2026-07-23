package io.fabric8.knative.serving.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RevisionStatusBuilder extends RevisionStatusFluent<RevisionStatusBuilder> implements VisitableBuilder<RevisionStatus,RevisionStatusBuilder>{

  RevisionStatusFluent<?> fluent;

  public RevisionStatusBuilder() {
    this(new RevisionStatus());
  }
  
  public RevisionStatusBuilder(RevisionStatusFluent<?> fluent) {
    this(fluent, new RevisionStatus());
  }
  
  public RevisionStatusBuilder(RevisionStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RevisionStatusBuilder(RevisionStatusFluent<?> fluent,RevisionStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RevisionStatus build() {
    RevisionStatus buildable = new RevisionStatus(fluent.getActualReplicas(), fluent.getAnnotations(), fluent.buildConditions(), fluent.buildContainerStatuses(), fluent.getDesiredReplicas(), fluent.buildInitContainerStatuses(), fluent.getLogUrl(), fluent.getObservedGeneration());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}