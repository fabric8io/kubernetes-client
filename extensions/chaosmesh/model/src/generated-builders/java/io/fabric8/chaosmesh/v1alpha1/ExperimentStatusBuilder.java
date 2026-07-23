package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ExperimentStatusBuilder extends ExperimentStatusFluent<ExperimentStatusBuilder> implements VisitableBuilder<ExperimentStatus,ExperimentStatusBuilder>{

  ExperimentStatusFluent<?> fluent;

  public ExperimentStatusBuilder() {
    this(new ExperimentStatus());
  }
  
  public ExperimentStatusBuilder(ExperimentStatusFluent<?> fluent) {
    this(fluent, new ExperimentStatus());
  }
  
  public ExperimentStatusBuilder(ExperimentStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ExperimentStatusBuilder(ExperimentStatusFluent<?> fluent,ExperimentStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ExperimentStatus build() {
    ExperimentStatus buildable = new ExperimentStatus(fluent.buildContainerRecords(), fluent.getDesiredPhase());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}