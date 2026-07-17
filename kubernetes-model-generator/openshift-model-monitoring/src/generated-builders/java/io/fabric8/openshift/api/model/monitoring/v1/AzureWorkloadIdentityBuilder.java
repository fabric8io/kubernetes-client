package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AzureWorkloadIdentityBuilder extends AzureWorkloadIdentityFluent<AzureWorkloadIdentityBuilder> implements VisitableBuilder<AzureWorkloadIdentity,AzureWorkloadIdentityBuilder>{

  AzureWorkloadIdentityFluent<?> fluent;

  public AzureWorkloadIdentityBuilder() {
    this(new AzureWorkloadIdentity());
  }
  
  public AzureWorkloadIdentityBuilder(AzureWorkloadIdentityFluent<?> fluent) {
    this(fluent, new AzureWorkloadIdentity());
  }
  
  public AzureWorkloadIdentityBuilder(AzureWorkloadIdentity instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AzureWorkloadIdentityBuilder(AzureWorkloadIdentityFluent<?> fluent,AzureWorkloadIdentity instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AzureWorkloadIdentity build() {
    AzureWorkloadIdentity buildable = new AzureWorkloadIdentity(fluent.getClientId(), fluent.getTenantId());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}