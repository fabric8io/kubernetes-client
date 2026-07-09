package io.fabric8.kubernetes.api.model.flowcontrol.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class FlowDistinguisherMethodBuilder extends FlowDistinguisherMethodFluent<FlowDistinguisherMethodBuilder> implements VisitableBuilder<FlowDistinguisherMethod,FlowDistinguisherMethodBuilder>{

  FlowDistinguisherMethodFluent<?> fluent;

  public FlowDistinguisherMethodBuilder() {
    this(new FlowDistinguisherMethod());
  }
  
  public FlowDistinguisherMethodBuilder(FlowDistinguisherMethodFluent<?> fluent) {
    this(fluent, new FlowDistinguisherMethod());
  }
  
  public FlowDistinguisherMethodBuilder(FlowDistinguisherMethod instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public FlowDistinguisherMethodBuilder(FlowDistinguisherMethodFluent<?> fluent,FlowDistinguisherMethod instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public FlowDistinguisherMethod build() {
    FlowDistinguisherMethod buildable = new FlowDistinguisherMethod(fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}