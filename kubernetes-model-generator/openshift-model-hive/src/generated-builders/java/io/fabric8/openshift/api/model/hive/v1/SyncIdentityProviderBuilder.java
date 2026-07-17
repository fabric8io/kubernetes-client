package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SyncIdentityProviderBuilder extends SyncIdentityProviderFluent<SyncIdentityProviderBuilder> implements VisitableBuilder<SyncIdentityProvider,SyncIdentityProviderBuilder>{

  SyncIdentityProviderFluent<?> fluent;

  public SyncIdentityProviderBuilder() {
    this(new SyncIdentityProvider());
  }
  
  public SyncIdentityProviderBuilder(SyncIdentityProviderFluent<?> fluent) {
    this(fluent, new SyncIdentityProvider());
  }
  
  public SyncIdentityProviderBuilder(SyncIdentityProvider instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SyncIdentityProviderBuilder(SyncIdentityProviderFluent<?> fluent,SyncIdentityProvider instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SyncIdentityProvider build() {
    SyncIdentityProvider buildable = new SyncIdentityProvider(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}