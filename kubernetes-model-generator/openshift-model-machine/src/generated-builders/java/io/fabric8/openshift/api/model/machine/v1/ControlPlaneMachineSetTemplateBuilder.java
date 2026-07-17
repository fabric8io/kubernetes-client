package io.fabric8.openshift.api.model.machine.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ControlPlaneMachineSetTemplateBuilder extends ControlPlaneMachineSetTemplateFluent<ControlPlaneMachineSetTemplateBuilder> implements VisitableBuilder<ControlPlaneMachineSetTemplate,ControlPlaneMachineSetTemplateBuilder>{

  ControlPlaneMachineSetTemplateFluent<?> fluent;

  public ControlPlaneMachineSetTemplateBuilder() {
    this(new ControlPlaneMachineSetTemplate());
  }
  
  public ControlPlaneMachineSetTemplateBuilder(ControlPlaneMachineSetTemplateFluent<?> fluent) {
    this(fluent, new ControlPlaneMachineSetTemplate());
  }
  
  public ControlPlaneMachineSetTemplateBuilder(ControlPlaneMachineSetTemplate instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ControlPlaneMachineSetTemplateBuilder(ControlPlaneMachineSetTemplateFluent<?> fluent,ControlPlaneMachineSetTemplate instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ControlPlaneMachineSetTemplate build() {
    ControlPlaneMachineSetTemplate buildable = new ControlPlaneMachineSetTemplate(fluent.getMachineType(), fluent.buildMachinesV1beta1MachineOpenshiftIo());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}