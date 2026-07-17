package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SelectorSyncIdentityProviderSpecBuilder extends SelectorSyncIdentityProviderSpecFluent<SelectorSyncIdentityProviderSpecBuilder> implements VisitableBuilder<SelectorSyncIdentityProviderSpec,SelectorSyncIdentityProviderSpecBuilder>{

  SelectorSyncIdentityProviderSpecFluent<?> fluent;

  public SelectorSyncIdentityProviderSpecBuilder() {
    this(new SelectorSyncIdentityProviderSpec());
  }
  
  public SelectorSyncIdentityProviderSpecBuilder(SelectorSyncIdentityProviderSpecFluent<?> fluent) {
    this(fluent, new SelectorSyncIdentityProviderSpec());
  }
  
  public SelectorSyncIdentityProviderSpecBuilder(SelectorSyncIdentityProviderSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SelectorSyncIdentityProviderSpecBuilder(SelectorSyncIdentityProviderSpecFluent<?> fluent,SelectorSyncIdentityProviderSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SelectorSyncIdentityProviderSpec build() {
    SelectorSyncIdentityProviderSpec buildable = new SelectorSyncIdentityProviderSpec(fluent.buildClusterDeploymentSelector(), fluent.getIdentityProviders());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}