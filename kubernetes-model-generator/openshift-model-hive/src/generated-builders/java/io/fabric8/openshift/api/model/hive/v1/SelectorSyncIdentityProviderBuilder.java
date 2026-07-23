package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SelectorSyncIdentityProviderBuilder extends SelectorSyncIdentityProviderFluent<SelectorSyncIdentityProviderBuilder> implements VisitableBuilder<SelectorSyncIdentityProvider,SelectorSyncIdentityProviderBuilder>{

  SelectorSyncIdentityProviderFluent<?> fluent;

  public SelectorSyncIdentityProviderBuilder() {
    this(new SelectorSyncIdentityProvider());
  }
  
  public SelectorSyncIdentityProviderBuilder(SelectorSyncIdentityProviderFluent<?> fluent) {
    this(fluent, new SelectorSyncIdentityProvider());
  }
  
  public SelectorSyncIdentityProviderBuilder(SelectorSyncIdentityProvider instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SelectorSyncIdentityProviderBuilder(SelectorSyncIdentityProviderFluent<?> fluent,SelectorSyncIdentityProvider instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SelectorSyncIdentityProvider build() {
    SelectorSyncIdentityProvider buildable = new SelectorSyncIdentityProvider(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}