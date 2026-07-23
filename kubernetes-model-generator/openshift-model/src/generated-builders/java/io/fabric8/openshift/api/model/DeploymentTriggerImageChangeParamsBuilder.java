package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DeploymentTriggerImageChangeParamsBuilder extends DeploymentTriggerImageChangeParamsFluent<DeploymentTriggerImageChangeParamsBuilder> implements VisitableBuilder<DeploymentTriggerImageChangeParams,DeploymentTriggerImageChangeParamsBuilder>{

  DeploymentTriggerImageChangeParamsFluent<?> fluent;

  public DeploymentTriggerImageChangeParamsBuilder() {
    this(new DeploymentTriggerImageChangeParams());
  }
  
  public DeploymentTriggerImageChangeParamsBuilder(DeploymentTriggerImageChangeParamsFluent<?> fluent) {
    this(fluent, new DeploymentTriggerImageChangeParams());
  }
  
  public DeploymentTriggerImageChangeParamsBuilder(DeploymentTriggerImageChangeParams instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DeploymentTriggerImageChangeParamsBuilder(DeploymentTriggerImageChangeParamsFluent<?> fluent,DeploymentTriggerImageChangeParams instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DeploymentTriggerImageChangeParams build() {
    DeploymentTriggerImageChangeParams buildable = new DeploymentTriggerImageChangeParams(fluent.getAutomatic(), fluent.getContainerNames(), fluent.buildFrom(), fluent.getLastTriggeredImage());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}