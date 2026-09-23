package io.fabric8.openshift.api.model.operator.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterAPIStatusBuilder extends ClusterAPIStatusFluent<ClusterAPIStatusBuilder> implements VisitableBuilder<ClusterAPIStatus,ClusterAPIStatusBuilder>{

  ClusterAPIStatusFluent<?> fluent;

  public ClusterAPIStatusBuilder() {
    this(new ClusterAPIStatus());
  }
  
  public ClusterAPIStatusBuilder(ClusterAPIStatusFluent<?> fluent) {
    this(fluent, new ClusterAPIStatus());
  }
  
  public ClusterAPIStatusBuilder(ClusterAPIStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterAPIStatusBuilder(ClusterAPIStatusFluent<?> fluent,ClusterAPIStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterAPIStatus build() {
    ClusterAPIStatus buildable = new ClusterAPIStatus(fluent.getCurrentRevision(), fluent.getDesiredRevision(), fluent.getObservedRevisionGeneration(), fluent.buildRevisions());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}