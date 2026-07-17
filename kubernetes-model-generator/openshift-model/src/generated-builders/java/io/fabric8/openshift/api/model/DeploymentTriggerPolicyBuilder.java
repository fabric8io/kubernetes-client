package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DeploymentTriggerPolicyBuilder extends DeploymentTriggerPolicyFluent<DeploymentTriggerPolicyBuilder> implements VisitableBuilder<DeploymentTriggerPolicy,DeploymentTriggerPolicyBuilder>{

  DeploymentTriggerPolicyFluent<?> fluent;

  public DeploymentTriggerPolicyBuilder() {
    this(new DeploymentTriggerPolicy());
  }
  
  public DeploymentTriggerPolicyBuilder(DeploymentTriggerPolicyFluent<?> fluent) {
    this(fluent, new DeploymentTriggerPolicy());
  }
  
  public DeploymentTriggerPolicyBuilder(DeploymentTriggerPolicy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DeploymentTriggerPolicyBuilder(DeploymentTriggerPolicyFluent<?> fluent,DeploymentTriggerPolicy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DeploymentTriggerPolicy build() {
    DeploymentTriggerPolicy buildable = new DeploymentTriggerPolicy(fluent.buildImageChangeParams(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}