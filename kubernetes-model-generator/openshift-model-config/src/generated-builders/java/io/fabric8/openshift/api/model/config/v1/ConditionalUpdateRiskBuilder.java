package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConditionalUpdateRiskBuilder extends ConditionalUpdateRiskFluent<ConditionalUpdateRiskBuilder> implements VisitableBuilder<ConditionalUpdateRisk,ConditionalUpdateRiskBuilder>{

  ConditionalUpdateRiskFluent<?> fluent;

  public ConditionalUpdateRiskBuilder() {
    this(new ConditionalUpdateRisk());
  }
  
  public ConditionalUpdateRiskBuilder(ConditionalUpdateRiskFluent<?> fluent) {
    this(fluent, new ConditionalUpdateRisk());
  }
  
  public ConditionalUpdateRiskBuilder(ConditionalUpdateRisk instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConditionalUpdateRiskBuilder(ConditionalUpdateRiskFluent<?> fluent,ConditionalUpdateRisk instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConditionalUpdateRisk build() {
    ConditionalUpdateRisk buildable = new ConditionalUpdateRisk(fluent.buildMatchingRules(), fluent.getMessage(), fluent.getName(), fluent.getUrl());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}