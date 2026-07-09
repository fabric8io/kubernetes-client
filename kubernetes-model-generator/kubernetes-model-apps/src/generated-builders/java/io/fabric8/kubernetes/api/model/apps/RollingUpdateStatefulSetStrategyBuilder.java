package io.fabric8.kubernetes.api.model.apps;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RollingUpdateStatefulSetStrategyBuilder extends RollingUpdateStatefulSetStrategyFluent<RollingUpdateStatefulSetStrategyBuilder> implements VisitableBuilder<RollingUpdateStatefulSetStrategy,RollingUpdateStatefulSetStrategyBuilder>{

  RollingUpdateStatefulSetStrategyFluent<?> fluent;

  public RollingUpdateStatefulSetStrategyBuilder() {
    this(new RollingUpdateStatefulSetStrategy());
  }
  
  public RollingUpdateStatefulSetStrategyBuilder(RollingUpdateStatefulSetStrategyFluent<?> fluent) {
    this(fluent, new RollingUpdateStatefulSetStrategy());
  }
  
  public RollingUpdateStatefulSetStrategyBuilder(RollingUpdateStatefulSetStrategy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RollingUpdateStatefulSetStrategyBuilder(RollingUpdateStatefulSetStrategyFluent<?> fluent,RollingUpdateStatefulSetStrategy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RollingUpdateStatefulSetStrategy build() {
    RollingUpdateStatefulSetStrategy buildable = new RollingUpdateStatefulSetStrategy(fluent.buildMaxUnavailable(), fluent.getPartition());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}