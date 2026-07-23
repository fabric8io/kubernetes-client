package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AWSChaosStatusBuilder extends AWSChaosStatusFluent<AWSChaosStatusBuilder> implements VisitableBuilder<AWSChaosStatus,AWSChaosStatusBuilder>{

  AWSChaosStatusFluent<?> fluent;

  public AWSChaosStatusBuilder() {
    this(new AWSChaosStatus());
  }
  
  public AWSChaosStatusBuilder(AWSChaosStatusFluent<?> fluent) {
    this(fluent, new AWSChaosStatus());
  }
  
  public AWSChaosStatusBuilder(AWSChaosStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AWSChaosStatusBuilder(AWSChaosStatusFluent<?> fluent,AWSChaosStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AWSChaosStatus build() {
    AWSChaosStatus buildable = new AWSChaosStatus(fluent.buildConditions(), fluent.buildExperiment());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}