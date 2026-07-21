package io.fabric8.istio.api.api.security.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RuleFromBuilder extends RuleFromFluent<RuleFromBuilder> implements VisitableBuilder<RuleFrom,RuleFromBuilder>{

  RuleFromFluent<?> fluent;

  public RuleFromBuilder() {
    this(new RuleFrom());
  }
  
  public RuleFromBuilder(RuleFromFluent<?> fluent) {
    this(fluent, new RuleFrom());
  }
  
  public RuleFromBuilder(RuleFrom instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RuleFromBuilder(RuleFromFluent<?> fluent,RuleFrom instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RuleFrom build() {
    RuleFrom buildable = new RuleFrom(fluent.buildSource());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}