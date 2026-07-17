package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DeploymentDetailsBuilder extends DeploymentDetailsFluent<DeploymentDetailsBuilder> implements VisitableBuilder<DeploymentDetails,DeploymentDetailsBuilder>{

  DeploymentDetailsFluent<?> fluent;

  public DeploymentDetailsBuilder() {
    this(new DeploymentDetails());
  }
  
  public DeploymentDetailsBuilder(DeploymentDetailsFluent<?> fluent) {
    this(fluent, new DeploymentDetails());
  }
  
  public DeploymentDetailsBuilder(DeploymentDetails instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DeploymentDetailsBuilder(DeploymentDetailsFluent<?> fluent,DeploymentDetails instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DeploymentDetails build() {
    DeploymentDetails buildable = new DeploymentDetails(fluent.buildCauses(), fluent.getMessage());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}