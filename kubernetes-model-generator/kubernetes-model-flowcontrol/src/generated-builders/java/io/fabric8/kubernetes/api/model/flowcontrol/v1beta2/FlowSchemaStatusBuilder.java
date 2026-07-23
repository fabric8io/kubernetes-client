package io.fabric8.kubernetes.api.model.flowcontrol.v1beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class FlowSchemaStatusBuilder extends FlowSchemaStatusFluent<FlowSchemaStatusBuilder> implements VisitableBuilder<FlowSchemaStatus,FlowSchemaStatusBuilder>{

  FlowSchemaStatusFluent<?> fluent;

  public FlowSchemaStatusBuilder() {
    this(new FlowSchemaStatus());
  }
  
  public FlowSchemaStatusBuilder(FlowSchemaStatusFluent<?> fluent) {
    this(fluent, new FlowSchemaStatus());
  }
  
  public FlowSchemaStatusBuilder(FlowSchemaStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public FlowSchemaStatusBuilder(FlowSchemaStatusFluent<?> fluent,FlowSchemaStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public FlowSchemaStatus build() {
    FlowSchemaStatus buildable = new FlowSchemaStatus(fluent.buildConditions());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}