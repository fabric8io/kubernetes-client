package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class InfrastructureStatusBuilder extends InfrastructureStatusFluent<InfrastructureStatusBuilder> implements VisitableBuilder<InfrastructureStatus,InfrastructureStatusBuilder>{

  InfrastructureStatusFluent<?> fluent;

  public InfrastructureStatusBuilder() {
    this(new InfrastructureStatus());
  }
  
  public InfrastructureStatusBuilder(InfrastructureStatusFluent<?> fluent) {
    this(fluent, new InfrastructureStatus());
  }
  
  public InfrastructureStatusBuilder(InfrastructureStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public InfrastructureStatusBuilder(InfrastructureStatusFluent<?> fluent,InfrastructureStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public InfrastructureStatus build() {
    InfrastructureStatus buildable = new InfrastructureStatus(fluent.getApiServerInternalURI(), fluent.getApiServerURL(), fluent.getControlPlaneTopology(), fluent.getCpuPartitioning(), fluent.getEtcdDiscoveryDomain(), fluent.getInfrastructureName(), fluent.getInfrastructureTopology(), fluent.getPlatform(), fluent.buildPlatformStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}