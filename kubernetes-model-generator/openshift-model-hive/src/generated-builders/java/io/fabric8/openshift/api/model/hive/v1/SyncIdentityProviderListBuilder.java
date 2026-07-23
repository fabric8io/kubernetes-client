package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SyncIdentityProviderListBuilder extends SyncIdentityProviderListFluent<SyncIdentityProviderListBuilder> implements VisitableBuilder<SyncIdentityProviderList,SyncIdentityProviderListBuilder>{

  SyncIdentityProviderListFluent<?> fluent;

  public SyncIdentityProviderListBuilder() {
    this(new SyncIdentityProviderList());
  }
  
  public SyncIdentityProviderListBuilder(SyncIdentityProviderListFluent<?> fluent) {
    this(fluent, new SyncIdentityProviderList());
  }
  
  public SyncIdentityProviderListBuilder(SyncIdentityProviderList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SyncIdentityProviderListBuilder(SyncIdentityProviderListFluent<?> fluent,SyncIdentityProviderList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SyncIdentityProviderList build() {
    SyncIdentityProviderList buildable = new SyncIdentityProviderList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}