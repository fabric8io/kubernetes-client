package io.fabric8.openclustermanagement.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class WorkConfigurationBuilder extends WorkConfigurationFluent<WorkConfigurationBuilder> implements VisitableBuilder<WorkConfiguration,WorkConfigurationBuilder>{

  WorkConfigurationFluent<?> fluent;

  public WorkConfigurationBuilder() {
    this(new WorkConfiguration());
  }
  
  public WorkConfigurationBuilder(WorkConfigurationFluent<?> fluent) {
    this(fluent, new WorkConfiguration());
  }
  
  public WorkConfigurationBuilder(WorkConfiguration instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public WorkConfigurationBuilder(WorkConfigurationFluent<?> fluent,WorkConfiguration instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public WorkConfiguration build() {
    WorkConfiguration buildable = new WorkConfiguration(fluent.buildFeatureGates(), fluent.getWorkDriver());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}