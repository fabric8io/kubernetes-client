package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PrivateStrategyBuilder extends PrivateStrategyFluent<PrivateStrategyBuilder> implements VisitableBuilder<PrivateStrategy,PrivateStrategyBuilder>{

  PrivateStrategyFluent<?> fluent;

  public PrivateStrategyBuilder() {
    this(new PrivateStrategy());
  }
  
  public PrivateStrategyBuilder(PrivateStrategyFluent<?> fluent) {
    this(fluent, new PrivateStrategy());
  }
  
  public PrivateStrategyBuilder(PrivateStrategy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PrivateStrategyBuilder(PrivateStrategyFluent<?> fluent,PrivateStrategy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PrivateStrategy build() {
    PrivateStrategy buildable = new PrivateStrategy(fluent.getProtocol());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}