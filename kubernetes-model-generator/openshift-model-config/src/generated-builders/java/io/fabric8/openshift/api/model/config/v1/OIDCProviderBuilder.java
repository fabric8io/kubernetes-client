package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OIDCProviderBuilder extends OIDCProviderFluent<OIDCProviderBuilder> implements VisitableBuilder<OIDCProvider,OIDCProviderBuilder>{

  OIDCProviderFluent<?> fluent;

  public OIDCProviderBuilder() {
    this(new OIDCProvider());
  }
  
  public OIDCProviderBuilder(OIDCProviderFluent<?> fluent) {
    this(fluent, new OIDCProvider());
  }
  
  public OIDCProviderBuilder(OIDCProvider instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OIDCProviderBuilder(OIDCProviderFluent<?> fluent,OIDCProvider instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OIDCProvider build() {
    OIDCProvider buildable = new OIDCProvider(fluent.buildClaimMappings(), fluent.buildClaimValidationRules(), fluent.buildIssuer(), fluent.getName(), fluent.buildOidcClients());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}