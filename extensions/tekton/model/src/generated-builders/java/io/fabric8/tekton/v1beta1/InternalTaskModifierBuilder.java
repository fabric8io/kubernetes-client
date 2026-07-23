package io.fabric8.tekton.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class InternalTaskModifierBuilder extends InternalTaskModifierFluent<InternalTaskModifierBuilder> implements VisitableBuilder<InternalTaskModifier,InternalTaskModifierBuilder>{

  InternalTaskModifierFluent<?> fluent;

  public InternalTaskModifierBuilder() {
    this(new InternalTaskModifier());
  }
  
  public InternalTaskModifierBuilder(InternalTaskModifierFluent<?> fluent) {
    this(fluent, new InternalTaskModifier());
  }
  
  public InternalTaskModifierBuilder(InternalTaskModifier instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public InternalTaskModifierBuilder(InternalTaskModifierFluent<?> fluent,InternalTaskModifier instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public InternalTaskModifier build() {
    InternalTaskModifier buildable = new InternalTaskModifier(fluent.buildStepsToAppend(), fluent.buildStepsToPrepend(), fluent.buildVolumes());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}