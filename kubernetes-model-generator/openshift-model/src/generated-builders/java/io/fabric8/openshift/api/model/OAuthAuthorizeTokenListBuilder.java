package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OAuthAuthorizeTokenListBuilder extends OAuthAuthorizeTokenListFluent<OAuthAuthorizeTokenListBuilder> implements VisitableBuilder<OAuthAuthorizeTokenList,OAuthAuthorizeTokenListBuilder>{

  OAuthAuthorizeTokenListFluent<?> fluent;

  public OAuthAuthorizeTokenListBuilder() {
    this(new OAuthAuthorizeTokenList());
  }
  
  public OAuthAuthorizeTokenListBuilder(OAuthAuthorizeTokenListFluent<?> fluent) {
    this(fluent, new OAuthAuthorizeTokenList());
  }
  
  public OAuthAuthorizeTokenListBuilder(OAuthAuthorizeTokenList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OAuthAuthorizeTokenListBuilder(OAuthAuthorizeTokenListFluent<?> fluent,OAuthAuthorizeTokenList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OAuthAuthorizeTokenList build() {
    OAuthAuthorizeTokenList buildable = new OAuthAuthorizeTokenList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}