package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RuleGroupBuilder extends RuleGroupFluent<RuleGroupBuilder> implements VisitableBuilder<RuleGroup,RuleGroupBuilder>{

  RuleGroupFluent<?> fluent;

  public RuleGroupBuilder() {
    this(new RuleGroup());
  }
  
  public RuleGroupBuilder(RuleGroupFluent<?> fluent) {
    this(fluent, new RuleGroup());
  }
  
  public RuleGroupBuilder(RuleGroup instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RuleGroupBuilder(RuleGroupFluent<?> fluent,RuleGroup instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RuleGroup build() {
    RuleGroup buildable = new RuleGroup(fluent.getInterval(), fluent.getName(), fluent.buildRules());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}