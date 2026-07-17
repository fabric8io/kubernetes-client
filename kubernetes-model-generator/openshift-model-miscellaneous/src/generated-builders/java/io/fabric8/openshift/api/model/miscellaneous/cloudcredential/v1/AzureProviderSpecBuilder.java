package io.fabric8.openshift.api.model.miscellaneous.cloudcredential.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AzureProviderSpecBuilder extends AzureProviderSpecFluent<AzureProviderSpecBuilder> implements VisitableBuilder<AzureProviderSpec,AzureProviderSpecBuilder>{

  AzureProviderSpecFluent<?> fluent;

  public AzureProviderSpecBuilder() {
    this(new AzureProviderSpec());
  }
  
  public AzureProviderSpecBuilder(AzureProviderSpecFluent<?> fluent) {
    this(fluent, new AzureProviderSpec());
  }
  
  public AzureProviderSpecBuilder(AzureProviderSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AzureProviderSpecBuilder(AzureProviderSpecFluent<?> fluent,AzureProviderSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AzureProviderSpec build() {
    AzureProviderSpec buildable = new AzureProviderSpec(fluent.getApiVersion(), fluent.getAzureClientID(), fluent.getAzureRegion(), fluent.getAzureSubscriptionID(), fluent.getAzureTenantID(), fluent.getDataPermissions(), fluent.getKind(), fluent.getPermissions(), fluent.buildRoleBindings());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}