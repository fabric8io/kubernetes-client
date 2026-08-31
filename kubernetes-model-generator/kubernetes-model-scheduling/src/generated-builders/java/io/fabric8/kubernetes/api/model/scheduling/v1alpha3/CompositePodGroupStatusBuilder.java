package io.fabric8.kubernetes.api.model.scheduling.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CompositePodGroupStatusBuilder extends CompositePodGroupStatusFluent<CompositePodGroupStatusBuilder> implements VisitableBuilder<CompositePodGroupStatus,CompositePodGroupStatusBuilder>{

  CompositePodGroupStatusFluent<?> fluent;

  public CompositePodGroupStatusBuilder() {
    this(new CompositePodGroupStatus());
  }
  
  public CompositePodGroupStatusBuilder(CompositePodGroupStatusFluent<?> fluent) {
    this(fluent, new CompositePodGroupStatus());
  }
  
  public CompositePodGroupStatusBuilder(CompositePodGroupStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CompositePodGroupStatusBuilder(CompositePodGroupStatusFluent<?> fluent,CompositePodGroupStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CompositePodGroupStatus build() {
    CompositePodGroupStatus buildable = new CompositePodGroupStatus(fluent.getConditions());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}