package io.fabric8.kubernetes.api.model.extensions;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RunAsUserStrategyOptionsBuilder extends RunAsUserStrategyOptionsFluent<RunAsUserStrategyOptionsBuilder> implements VisitableBuilder<RunAsUserStrategyOptions,RunAsUserStrategyOptionsBuilder>{

  RunAsUserStrategyOptionsFluent<?> fluent;

  public RunAsUserStrategyOptionsBuilder() {
    this(new RunAsUserStrategyOptions());
  }
  
  public RunAsUserStrategyOptionsBuilder(RunAsUserStrategyOptionsFluent<?> fluent) {
    this(fluent, new RunAsUserStrategyOptions());
  }
  
  public RunAsUserStrategyOptionsBuilder(RunAsUserStrategyOptions instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RunAsUserStrategyOptionsBuilder(RunAsUserStrategyOptionsFluent<?> fluent,RunAsUserStrategyOptions instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RunAsUserStrategyOptions build() {
    RunAsUserStrategyOptions buildable = new RunAsUserStrategyOptions(fluent.buildRanges(), fluent.getRule());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}