package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class UpdateStrategyBuilder extends UpdateStrategyFluent<UpdateStrategyBuilder> implements VisitableBuilder<UpdateStrategy,UpdateStrategyBuilder>{

  UpdateStrategyFluent<?> fluent;

  public UpdateStrategyBuilder() {
    this(new UpdateStrategy());
  }
  
  public UpdateStrategyBuilder(UpdateStrategyFluent<?> fluent) {
    this(fluent, new UpdateStrategy());
  }
  
  public UpdateStrategyBuilder(UpdateStrategy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public UpdateStrategyBuilder(UpdateStrategyFluent<?> fluent,UpdateStrategy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public UpdateStrategy build() {
    UpdateStrategy buildable = new UpdateStrategy(fluent.buildRegistryPoll());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}