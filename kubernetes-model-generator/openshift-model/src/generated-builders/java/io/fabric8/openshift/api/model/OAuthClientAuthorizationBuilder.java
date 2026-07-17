package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OAuthClientAuthorizationBuilder extends OAuthClientAuthorizationFluent<OAuthClientAuthorizationBuilder> implements VisitableBuilder<OAuthClientAuthorization,OAuthClientAuthorizationBuilder>{

  OAuthClientAuthorizationFluent<?> fluent;

  public OAuthClientAuthorizationBuilder() {
    this(new OAuthClientAuthorization());
  }
  
  public OAuthClientAuthorizationBuilder(OAuthClientAuthorizationFluent<?> fluent) {
    this(fluent, new OAuthClientAuthorization());
  }
  
  public OAuthClientAuthorizationBuilder(OAuthClientAuthorization instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OAuthClientAuthorizationBuilder(OAuthClientAuthorizationFluent<?> fluent,OAuthClientAuthorization instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OAuthClientAuthorization build() {
    OAuthClientAuthorization buildable = new OAuthClientAuthorization(fluent.getApiVersion(), fluent.getClientName(), fluent.getKind(), fluent.buildMetadata(), fluent.getScopes(), fluent.getUserName(), fluent.getUserUID());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}