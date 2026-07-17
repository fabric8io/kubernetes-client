package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RemediationStrategyBuilder extends RemediationStrategyFluent<RemediationStrategyBuilder> implements VisitableBuilder<RemediationStrategy,RemediationStrategyBuilder>{

  RemediationStrategyFluent<?> fluent;

  public RemediationStrategyBuilder() {
    this(new RemediationStrategy());
  }
  
  public RemediationStrategyBuilder(RemediationStrategyFluent<?> fluent) {
    this(fluent, new RemediationStrategy());
  }
  
  public RemediationStrategyBuilder(RemediationStrategy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RemediationStrategyBuilder(RemediationStrategyFluent<?> fluent,RemediationStrategy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RemediationStrategy build() {
    RemediationStrategy buildable = new RemediationStrategy(fluent.getRetryLimit(), fluent.getTimeout(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}