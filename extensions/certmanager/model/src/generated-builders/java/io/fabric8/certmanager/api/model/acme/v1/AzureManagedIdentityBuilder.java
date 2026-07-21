package io.fabric8.certmanager.api.model.acme.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AzureManagedIdentityBuilder extends AzureManagedIdentityFluent<AzureManagedIdentityBuilder> implements VisitableBuilder<AzureManagedIdentity,AzureManagedIdentityBuilder>{

  AzureManagedIdentityFluent<?> fluent;

  public AzureManagedIdentityBuilder() {
    this(new AzureManagedIdentity());
  }
  
  public AzureManagedIdentityBuilder(AzureManagedIdentityFluent<?> fluent) {
    this(fluent, new AzureManagedIdentity());
  }
  
  public AzureManagedIdentityBuilder(AzureManagedIdentity instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AzureManagedIdentityBuilder(AzureManagedIdentityFluent<?> fluent,AzureManagedIdentity instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AzureManagedIdentity build() {
    AzureManagedIdentity buildable = new AzureManagedIdentity(fluent.getClientID(), fluent.getResourceID(), fluent.getTenantID());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}