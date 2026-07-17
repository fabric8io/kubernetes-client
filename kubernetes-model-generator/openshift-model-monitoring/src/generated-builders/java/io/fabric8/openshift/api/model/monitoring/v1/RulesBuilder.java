package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RulesBuilder extends RulesFluent<RulesBuilder> implements VisitableBuilder<Rules,RulesBuilder>{

  RulesFluent<?> fluent;

  public RulesBuilder() {
    this(new Rules());
  }
  
  public RulesBuilder(RulesFluent<?> fluent) {
    this(fluent, new Rules());
  }
  
  public RulesBuilder(Rules instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RulesBuilder(RulesFluent<?> fluent,Rules instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Rules build() {
    Rules buildable = new Rules(fluent.buildAlert());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}