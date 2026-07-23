package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OAuthClientAuthorizationListBuilder extends OAuthClientAuthorizationListFluent<OAuthClientAuthorizationListBuilder> implements VisitableBuilder<OAuthClientAuthorizationList,OAuthClientAuthorizationListBuilder>{

  OAuthClientAuthorizationListFluent<?> fluent;

  public OAuthClientAuthorizationListBuilder() {
    this(new OAuthClientAuthorizationList());
  }
  
  public OAuthClientAuthorizationListBuilder(OAuthClientAuthorizationListFluent<?> fluent) {
    this(fluent, new OAuthClientAuthorizationList());
  }
  
  public OAuthClientAuthorizationListBuilder(OAuthClientAuthorizationList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OAuthClientAuthorizationListBuilder(OAuthClientAuthorizationListFluent<?> fluent,OAuthClientAuthorizationList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OAuthClientAuthorizationList build() {
    OAuthClientAuthorizationList buildable = new OAuthClientAuthorizationList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}