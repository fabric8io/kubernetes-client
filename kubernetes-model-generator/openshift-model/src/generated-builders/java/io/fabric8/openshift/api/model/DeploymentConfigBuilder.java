package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DeploymentConfigBuilder extends DeploymentConfigFluent<DeploymentConfigBuilder> implements VisitableBuilder<DeploymentConfig,DeploymentConfigBuilder>{

  DeploymentConfigFluent<?> fluent;

  public DeploymentConfigBuilder() {
    this(new DeploymentConfig());
  }
  
  public DeploymentConfigBuilder(DeploymentConfigFluent<?> fluent) {
    this(fluent, new DeploymentConfig());
  }
  
  public DeploymentConfigBuilder(DeploymentConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DeploymentConfigBuilder(DeploymentConfigFluent<?> fluent,DeploymentConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DeploymentConfig build() {
    DeploymentConfig buildable = new DeploymentConfig(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}