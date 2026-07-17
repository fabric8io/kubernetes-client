package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SelectorSyncIdentityProviderListBuilder extends SelectorSyncIdentityProviderListFluent<SelectorSyncIdentityProviderListBuilder> implements VisitableBuilder<SelectorSyncIdentityProviderList,SelectorSyncIdentityProviderListBuilder>{

  SelectorSyncIdentityProviderListFluent<?> fluent;

  public SelectorSyncIdentityProviderListBuilder() {
    this(new SelectorSyncIdentityProviderList());
  }
  
  public SelectorSyncIdentityProviderListBuilder(SelectorSyncIdentityProviderListFluent<?> fluent) {
    this(fluent, new SelectorSyncIdentityProviderList());
  }
  
  public SelectorSyncIdentityProviderListBuilder(SelectorSyncIdentityProviderList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SelectorSyncIdentityProviderListBuilder(SelectorSyncIdentityProviderListFluent<?> fluent,SelectorSyncIdentityProviderList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SelectorSyncIdentityProviderList build() {
    SelectorSyncIdentityProviderList buildable = new SelectorSyncIdentityProviderList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}