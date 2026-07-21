package io.fabric8.volcano.api.model.flow.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class FlowBuilder extends FlowFluent<FlowBuilder> implements VisitableBuilder<Flow,FlowBuilder>{

  FlowFluent<?> fluent;

  public FlowBuilder() {
    this(new Flow());
  }
  
  public FlowBuilder(FlowFluent<?> fluent) {
    this(fluent, new Flow());
  }
  
  public FlowBuilder(Flow instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public FlowBuilder(FlowFluent<?> fluent,Flow instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Flow build() {
    Flow buildable = new Flow(fluent.buildDependsOn(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}