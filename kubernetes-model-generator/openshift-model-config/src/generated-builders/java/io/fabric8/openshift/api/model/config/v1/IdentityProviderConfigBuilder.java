package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IdentityProviderConfigBuilder extends IdentityProviderConfigFluent<IdentityProviderConfigBuilder> implements VisitableBuilder<IdentityProviderConfig,IdentityProviderConfigBuilder>{

  IdentityProviderConfigFluent<?> fluent;

  public IdentityProviderConfigBuilder() {
    this(new IdentityProviderConfig());
  }
  
  public IdentityProviderConfigBuilder(IdentityProviderConfigFluent<?> fluent) {
    this(fluent, new IdentityProviderConfig());
  }
  
  public IdentityProviderConfigBuilder(IdentityProviderConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IdentityProviderConfigBuilder(IdentityProviderConfigFluent<?> fluent,IdentityProviderConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IdentityProviderConfig build() {
    IdentityProviderConfig buildable = new IdentityProviderConfig(fluent.buildBasicAuth(), fluent.buildGithub(), fluent.buildGitlab(), fluent.buildGoogle(), fluent.buildHtpasswd(), fluent.buildKeystone(), fluent.buildLdap(), fluent.buildOpenID(), fluent.buildRequestHeader(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}