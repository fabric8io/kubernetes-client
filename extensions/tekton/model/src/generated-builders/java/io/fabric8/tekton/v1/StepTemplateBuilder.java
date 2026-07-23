package io.fabric8.tekton.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StepTemplateBuilder extends StepTemplateFluent<StepTemplateBuilder> implements VisitableBuilder<StepTemplate,StepTemplateBuilder>{

  StepTemplateFluent<?> fluent;

  public StepTemplateBuilder() {
    this(new StepTemplate());
  }
  
  public StepTemplateBuilder(StepTemplateFluent<?> fluent) {
    this(fluent, new StepTemplate());
  }
  
  public StepTemplateBuilder(StepTemplate instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StepTemplateBuilder(StepTemplateFluent<?> fluent,StepTemplate instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public StepTemplate build() {
    StepTemplate buildable = new StepTemplate(fluent.getArgs(), fluent.getCommand(), fluent.buildComputeResources(), fluent.buildEnv(), fluent.getEnvFrom(), fluent.getImage(), fluent.getImagePullPolicy(), fluent.getSecurityContext(), fluent.getVolumeDevices(), fluent.buildVolumeMounts(), fluent.getWorkingDir());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}