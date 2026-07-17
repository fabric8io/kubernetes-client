package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IdentityBuilder extends IdentityFluent<IdentityBuilder> implements VisitableBuilder<Identity,IdentityBuilder>{

  IdentityFluent<?> fluent;

  public IdentityBuilder() {
    this(new Identity());
  }
  
  public IdentityBuilder(IdentityFluent<?> fluent) {
    this(fluent, new Identity());
  }
  
  public IdentityBuilder(Identity instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IdentityBuilder(IdentityFluent<?> fluent,Identity instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Identity build() {
    Identity buildable = new Identity(fluent.getApiVersion(), fluent.getExtra(), fluent.getKind(), fluent.buildMetadata(), fluent.getProviderName(), fluent.getProviderUserName(), fluent.buildUser());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}