package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OAuthAccessTokenListBuilder extends OAuthAccessTokenListFluent<OAuthAccessTokenListBuilder> implements VisitableBuilder<OAuthAccessTokenList,OAuthAccessTokenListBuilder>{

  OAuthAccessTokenListFluent<?> fluent;

  public OAuthAccessTokenListBuilder() {
    this(new OAuthAccessTokenList());
  }
  
  public OAuthAccessTokenListBuilder(OAuthAccessTokenListFluent<?> fluent) {
    this(fluent, new OAuthAccessTokenList());
  }
  
  public OAuthAccessTokenListBuilder(OAuthAccessTokenList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OAuthAccessTokenListBuilder(OAuthAccessTokenListFluent<?> fluent,OAuthAccessTokenList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OAuthAccessTokenList build() {
    OAuthAccessTokenList buildable = new OAuthAccessTokenList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}