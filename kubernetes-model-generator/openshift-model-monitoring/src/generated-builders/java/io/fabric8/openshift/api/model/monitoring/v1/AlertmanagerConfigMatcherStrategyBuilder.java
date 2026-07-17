package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AlertmanagerConfigMatcherStrategyBuilder extends AlertmanagerConfigMatcherStrategyFluent<AlertmanagerConfigMatcherStrategyBuilder> implements VisitableBuilder<AlertmanagerConfigMatcherStrategy,AlertmanagerConfigMatcherStrategyBuilder>{

  AlertmanagerConfigMatcherStrategyFluent<?> fluent;

  public AlertmanagerConfigMatcherStrategyBuilder() {
    this(new AlertmanagerConfigMatcherStrategy());
  }
  
  public AlertmanagerConfigMatcherStrategyBuilder(AlertmanagerConfigMatcherStrategyFluent<?> fluent) {
    this(fluent, new AlertmanagerConfigMatcherStrategy());
  }
  
  public AlertmanagerConfigMatcherStrategyBuilder(AlertmanagerConfigMatcherStrategy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AlertmanagerConfigMatcherStrategyBuilder(AlertmanagerConfigMatcherStrategyFluent<?> fluent,AlertmanagerConfigMatcherStrategy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AlertmanagerConfigMatcherStrategy build() {
    AlertmanagerConfigMatcherStrategy buildable = new AlertmanagerConfigMatcherStrategy(fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}