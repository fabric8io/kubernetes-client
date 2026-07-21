package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ChaosStatusBuilder extends ChaosStatusFluent<ChaosStatusBuilder> implements VisitableBuilder<ChaosStatus,ChaosStatusBuilder>{

  ChaosStatusFluent<?> fluent;

  public ChaosStatusBuilder() {
    this(new ChaosStatus());
  }
  
  public ChaosStatusBuilder(ChaosStatusFluent<?> fluent) {
    this(fluent, new ChaosStatus());
  }
  
  public ChaosStatusBuilder(ChaosStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ChaosStatusBuilder(ChaosStatusFluent<?> fluent,ChaosStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ChaosStatus build() {
    ChaosStatus buildable = new ChaosStatus(fluent.buildConditions(), fluent.buildExperiment());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}