package io.fabric8.kubernetes.api.model.flowcontrol.v1beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class FlowSchemaSpecBuilder extends FlowSchemaSpecFluent<FlowSchemaSpecBuilder> implements VisitableBuilder<FlowSchemaSpec,FlowSchemaSpecBuilder>{

  FlowSchemaSpecFluent<?> fluent;

  public FlowSchemaSpecBuilder() {
    this(new FlowSchemaSpec());
  }
  
  public FlowSchemaSpecBuilder(FlowSchemaSpecFluent<?> fluent) {
    this(fluent, new FlowSchemaSpec());
  }
  
  public FlowSchemaSpecBuilder(FlowSchemaSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public FlowSchemaSpecBuilder(FlowSchemaSpecFluent<?> fluent,FlowSchemaSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public FlowSchemaSpec build() {
    FlowSchemaSpec buildable = new FlowSchemaSpec(fluent.buildDistinguisherMethod(), fluent.getMatchingPrecedence(), fluent.buildPriorityLevelConfiguration(), fluent.buildRules());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}