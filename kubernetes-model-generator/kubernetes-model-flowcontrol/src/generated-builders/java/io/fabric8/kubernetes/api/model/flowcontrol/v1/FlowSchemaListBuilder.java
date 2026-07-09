package io.fabric8.kubernetes.api.model.flowcontrol.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class FlowSchemaListBuilder extends FlowSchemaListFluent<FlowSchemaListBuilder> implements VisitableBuilder<FlowSchemaList,FlowSchemaListBuilder>{

  FlowSchemaListFluent<?> fluent;

  public FlowSchemaListBuilder() {
    this(new FlowSchemaList());
  }
  
  public FlowSchemaListBuilder(FlowSchemaListFluent<?> fluent) {
    this(fluent, new FlowSchemaList());
  }
  
  public FlowSchemaListBuilder(FlowSchemaList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public FlowSchemaListBuilder(FlowSchemaListFluent<?> fluent,FlowSchemaList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public FlowSchemaList build() {
    FlowSchemaList buildable = new FlowSchemaList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}