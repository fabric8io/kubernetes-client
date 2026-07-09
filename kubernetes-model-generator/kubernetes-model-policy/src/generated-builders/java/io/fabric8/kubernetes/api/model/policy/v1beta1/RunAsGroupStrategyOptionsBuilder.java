package io.fabric8.kubernetes.api.model.policy.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RunAsGroupStrategyOptionsBuilder extends RunAsGroupStrategyOptionsFluent<RunAsGroupStrategyOptionsBuilder> implements VisitableBuilder<RunAsGroupStrategyOptions,RunAsGroupStrategyOptionsBuilder>{

  RunAsGroupStrategyOptionsFluent<?> fluent;

  public RunAsGroupStrategyOptionsBuilder() {
    this(new RunAsGroupStrategyOptions());
  }
  
  public RunAsGroupStrategyOptionsBuilder(RunAsGroupStrategyOptionsFluent<?> fluent) {
    this(fluent, new RunAsGroupStrategyOptions());
  }
  
  public RunAsGroupStrategyOptionsBuilder(RunAsGroupStrategyOptions instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RunAsGroupStrategyOptionsBuilder(RunAsGroupStrategyOptionsFluent<?> fluent,RunAsGroupStrategyOptions instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RunAsGroupStrategyOptions build() {
    RunAsGroupStrategyOptions buildable = new RunAsGroupStrategyOptions(fluent.buildRanges(), fluent.getRule());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}