package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IdentityProviderStatusBuilder extends IdentityProviderStatusFluent<IdentityProviderStatusBuilder> implements VisitableBuilder<IdentityProviderStatus,IdentityProviderStatusBuilder>{

  IdentityProviderStatusFluent<?> fluent;

  public IdentityProviderStatusBuilder() {
    this(new IdentityProviderStatus());
  }
  
  public IdentityProviderStatusBuilder(IdentityProviderStatusFluent<?> fluent) {
    this(fluent, new IdentityProviderStatus());
  }
  
  public IdentityProviderStatusBuilder(IdentityProviderStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IdentityProviderStatusBuilder(IdentityProviderStatusFluent<?> fluent,IdentityProviderStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IdentityProviderStatus build() {
    IdentityProviderStatus buildable = new IdentityProviderStatus();
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}