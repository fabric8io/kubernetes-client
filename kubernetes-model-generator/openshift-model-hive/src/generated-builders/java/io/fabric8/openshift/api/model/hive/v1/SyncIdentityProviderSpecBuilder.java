package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SyncIdentityProviderSpecBuilder extends SyncIdentityProviderSpecFluent<SyncIdentityProviderSpecBuilder> implements VisitableBuilder<SyncIdentityProviderSpec,SyncIdentityProviderSpecBuilder>{

  SyncIdentityProviderSpecFluent<?> fluent;

  public SyncIdentityProviderSpecBuilder() {
    this(new SyncIdentityProviderSpec());
  }
  
  public SyncIdentityProviderSpecBuilder(SyncIdentityProviderSpecFluent<?> fluent) {
    this(fluent, new SyncIdentityProviderSpec());
  }
  
  public SyncIdentityProviderSpecBuilder(SyncIdentityProviderSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SyncIdentityProviderSpecBuilder(SyncIdentityProviderSpecFluent<?> fluent,SyncIdentityProviderSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SyncIdentityProviderSpec build() {
    SyncIdentityProviderSpec buildable = new SyncIdentityProviderSpec(fluent.buildClusterDeploymentRefs(), fluent.getIdentityProviders());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}