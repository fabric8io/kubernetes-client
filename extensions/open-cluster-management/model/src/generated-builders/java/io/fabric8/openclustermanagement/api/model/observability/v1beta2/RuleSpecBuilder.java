package io.fabric8.openclustermanagement.api.model.observability.v1beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RuleSpecBuilder extends RuleSpecFluent<RuleSpecBuilder> implements VisitableBuilder<RuleSpec,RuleSpecBuilder>{

  RuleSpecFluent<?> fluent;

  public RuleSpecBuilder() {
    this(new RuleSpec());
  }
  
  public RuleSpecBuilder(RuleSpecFluent<?> fluent) {
    this(fluent, new RuleSpec());
  }
  
  public RuleSpecBuilder(RuleSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RuleSpecBuilder(RuleSpecFluent<?> fluent,RuleSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RuleSpec build() {
    RuleSpec buildable = new RuleSpec(fluent.buildContainers(), fluent.getEvalInterval(), fluent.getReplicas(), fluent.buildResources(), fluent.getServiceAccountAnnotations());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}