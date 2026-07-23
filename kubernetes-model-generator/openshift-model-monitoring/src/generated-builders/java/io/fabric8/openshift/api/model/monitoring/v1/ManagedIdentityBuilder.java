package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ManagedIdentityBuilder extends ManagedIdentityFluent<ManagedIdentityBuilder> implements VisitableBuilder<ManagedIdentity,ManagedIdentityBuilder>{

  ManagedIdentityFluent<?> fluent;

  public ManagedIdentityBuilder() {
    this(new ManagedIdentity());
  }
  
  public ManagedIdentityBuilder(ManagedIdentityFluent<?> fluent) {
    this(fluent, new ManagedIdentity());
  }
  
  public ManagedIdentityBuilder(ManagedIdentity instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ManagedIdentityBuilder(ManagedIdentityFluent<?> fluent,ManagedIdentity instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ManagedIdentity build() {
    ManagedIdentity buildable = new ManagedIdentity(fluent.getClientId());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}