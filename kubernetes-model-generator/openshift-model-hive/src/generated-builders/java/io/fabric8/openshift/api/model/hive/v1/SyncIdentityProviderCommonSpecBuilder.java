package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SyncIdentityProviderCommonSpecBuilder extends SyncIdentityProviderCommonSpecFluent<SyncIdentityProviderCommonSpecBuilder> implements VisitableBuilder<SyncIdentityProviderCommonSpec,SyncIdentityProviderCommonSpecBuilder>{

  SyncIdentityProviderCommonSpecFluent<?> fluent;

  public SyncIdentityProviderCommonSpecBuilder() {
    this(new SyncIdentityProviderCommonSpec());
  }
  
  public SyncIdentityProviderCommonSpecBuilder(SyncIdentityProviderCommonSpecFluent<?> fluent) {
    this(fluent, new SyncIdentityProviderCommonSpec());
  }
  
  public SyncIdentityProviderCommonSpecBuilder(SyncIdentityProviderCommonSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SyncIdentityProviderCommonSpecBuilder(SyncIdentityProviderCommonSpecFluent<?> fluent,SyncIdentityProviderCommonSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SyncIdentityProviderCommonSpec build() {
    SyncIdentityProviderCommonSpec buildable = new SyncIdentityProviderCommonSpec(fluent.getIdentityProviders());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}