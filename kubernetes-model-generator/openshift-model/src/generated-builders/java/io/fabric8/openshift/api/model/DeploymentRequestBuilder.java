package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DeploymentRequestBuilder extends DeploymentRequestFluent<DeploymentRequestBuilder> implements VisitableBuilder<DeploymentRequest,DeploymentRequestBuilder>{

  DeploymentRequestFluent<?> fluent;

  public DeploymentRequestBuilder() {
    this(new DeploymentRequest());
  }
  
  public DeploymentRequestBuilder(DeploymentRequestFluent<?> fluent) {
    this(fluent, new DeploymentRequest());
  }
  
  public DeploymentRequestBuilder(DeploymentRequest instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DeploymentRequestBuilder(DeploymentRequestFluent<?> fluent,DeploymentRequest instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DeploymentRequest build() {
    DeploymentRequest buildable = new DeploymentRequest(fluent.getApiVersion(), fluent.getExcludeTriggers(), fluent.getForce(), fluent.getKind(), fluent.getLatest(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}