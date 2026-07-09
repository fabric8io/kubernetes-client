package io.fabric8.kubernetes.api.model.policy.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class FSGroupStrategyOptionsBuilder extends FSGroupStrategyOptionsFluent<FSGroupStrategyOptionsBuilder> implements VisitableBuilder<FSGroupStrategyOptions,FSGroupStrategyOptionsBuilder>{

  FSGroupStrategyOptionsFluent<?> fluent;

  public FSGroupStrategyOptionsBuilder() {
    this(new FSGroupStrategyOptions());
  }
  
  public FSGroupStrategyOptionsBuilder(FSGroupStrategyOptionsFluent<?> fluent) {
    this(fluent, new FSGroupStrategyOptions());
  }
  
  public FSGroupStrategyOptionsBuilder(FSGroupStrategyOptions instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public FSGroupStrategyOptionsBuilder(FSGroupStrategyOptionsFluent<?> fluent,FSGroupStrategyOptions instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public FSGroupStrategyOptions build() {
    FSGroupStrategyOptions buildable = new FSGroupStrategyOptions(fluent.buildRanges(), fluent.getRule());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}