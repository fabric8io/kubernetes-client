package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IdentityProviderBuilder extends IdentityProviderFluent<IdentityProviderBuilder> implements VisitableBuilder<IdentityProvider,IdentityProviderBuilder>{

  IdentityProviderFluent<?> fluent;

  public IdentityProviderBuilder() {
    this(new IdentityProvider());
  }
  
  public IdentityProviderBuilder(IdentityProviderFluent<?> fluent) {
    this(fluent, new IdentityProvider());
  }
  
  public IdentityProviderBuilder(IdentityProvider instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IdentityProviderBuilder(IdentityProviderFluent<?> fluent,IdentityProvider instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IdentityProvider build() {
    IdentityProvider buildable = new IdentityProvider(fluent.buildBasicAuth(), fluent.buildGithub(), fluent.buildGitlab(), fluent.buildGoogle(), fluent.buildHtpasswd(), fluent.buildKeystone(), fluent.buildLdap(), fluent.getMappingMethod(), fluent.getName(), fluent.buildOpenID(), fluent.buildRequestHeader(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}