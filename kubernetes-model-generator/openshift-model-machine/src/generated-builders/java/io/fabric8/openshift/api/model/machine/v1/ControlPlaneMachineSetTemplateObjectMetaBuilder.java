package io.fabric8.openshift.api.model.machine.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ControlPlaneMachineSetTemplateObjectMetaBuilder extends ControlPlaneMachineSetTemplateObjectMetaFluent<ControlPlaneMachineSetTemplateObjectMetaBuilder> implements VisitableBuilder<ControlPlaneMachineSetTemplateObjectMeta,ControlPlaneMachineSetTemplateObjectMetaBuilder>{

  ControlPlaneMachineSetTemplateObjectMetaFluent<?> fluent;

  public ControlPlaneMachineSetTemplateObjectMetaBuilder() {
    this(new ControlPlaneMachineSetTemplateObjectMeta());
  }
  
  public ControlPlaneMachineSetTemplateObjectMetaBuilder(ControlPlaneMachineSetTemplateObjectMetaFluent<?> fluent) {
    this(fluent, new ControlPlaneMachineSetTemplateObjectMeta());
  }
  
  public ControlPlaneMachineSetTemplateObjectMetaBuilder(ControlPlaneMachineSetTemplateObjectMeta instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ControlPlaneMachineSetTemplateObjectMetaBuilder(ControlPlaneMachineSetTemplateObjectMetaFluent<?> fluent,ControlPlaneMachineSetTemplateObjectMeta instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ControlPlaneMachineSetTemplateObjectMeta build() {
    ControlPlaneMachineSetTemplateObjectMeta buildable = new ControlPlaneMachineSetTemplateObjectMeta(fluent.getAnnotations(), fluent.getLabels());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}