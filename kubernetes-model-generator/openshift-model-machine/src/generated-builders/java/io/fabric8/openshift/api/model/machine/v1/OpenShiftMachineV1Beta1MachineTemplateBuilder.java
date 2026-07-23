package io.fabric8.openshift.api.model.machine.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OpenShiftMachineV1Beta1MachineTemplateBuilder extends OpenShiftMachineV1Beta1MachineTemplateFluent<OpenShiftMachineV1Beta1MachineTemplateBuilder> implements VisitableBuilder<OpenShiftMachineV1Beta1MachineTemplate,OpenShiftMachineV1Beta1MachineTemplateBuilder>{

  OpenShiftMachineV1Beta1MachineTemplateFluent<?> fluent;

  public OpenShiftMachineV1Beta1MachineTemplateBuilder() {
    this(new OpenShiftMachineV1Beta1MachineTemplate());
  }
  
  public OpenShiftMachineV1Beta1MachineTemplateBuilder(OpenShiftMachineV1Beta1MachineTemplateFluent<?> fluent) {
    this(fluent, new OpenShiftMachineV1Beta1MachineTemplate());
  }
  
  public OpenShiftMachineV1Beta1MachineTemplateBuilder(OpenShiftMachineV1Beta1MachineTemplate instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OpenShiftMachineV1Beta1MachineTemplateBuilder(OpenShiftMachineV1Beta1MachineTemplateFluent<?> fluent,OpenShiftMachineV1Beta1MachineTemplate instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OpenShiftMachineV1Beta1MachineTemplate build() {
    OpenShiftMachineV1Beta1MachineTemplate buildable = new OpenShiftMachineV1Beta1MachineTemplate(fluent.buildFailureDomains(), fluent.buildMetadata(), fluent.buildSpec());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}