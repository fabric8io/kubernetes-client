package io.fabric8.kubernetes.api.model.extensions;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DaemonSetUpdateStrategyBuilder extends DaemonSetUpdateStrategyFluent<DaemonSetUpdateStrategyBuilder> implements VisitableBuilder<DaemonSetUpdateStrategy,DaemonSetUpdateStrategyBuilder>{

  DaemonSetUpdateStrategyFluent<?> fluent;

  public DaemonSetUpdateStrategyBuilder() {
    this(new DaemonSetUpdateStrategy());
  }
  
  public DaemonSetUpdateStrategyBuilder(DaemonSetUpdateStrategyFluent<?> fluent) {
    this(fluent, new DaemonSetUpdateStrategy());
  }
  
  public DaemonSetUpdateStrategyBuilder(DaemonSetUpdateStrategy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DaemonSetUpdateStrategyBuilder(DaemonSetUpdateStrategyFluent<?> fluent,DaemonSetUpdateStrategy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DaemonSetUpdateStrategy build() {
    DaemonSetUpdateStrategy buildable = new DaemonSetUpdateStrategy(fluent.buildRollingUpdate(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}