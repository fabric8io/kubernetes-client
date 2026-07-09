package io.fabric8.kubernetes.api.model.flowcontrol.v1beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class FlowSchemaBuilder extends FlowSchemaFluent<FlowSchemaBuilder> implements VisitableBuilder<FlowSchema,FlowSchemaBuilder>{

  FlowSchemaFluent<?> fluent;

  public FlowSchemaBuilder() {
    this(new FlowSchema());
  }
  
  public FlowSchemaBuilder(FlowSchemaFluent<?> fluent) {
    this(fluent, new FlowSchema());
  }
  
  public FlowSchemaBuilder(FlowSchema instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public FlowSchemaBuilder(FlowSchemaFluent<?> fluent,FlowSchema instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public FlowSchema build() {
    FlowSchema buildable = new FlowSchema(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}