package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OAuthBuilder extends OAuthFluent<OAuthBuilder> implements VisitableBuilder<OAuth,OAuthBuilder>{

  OAuthFluent<?> fluent;

  public OAuthBuilder() {
    this(new OAuth());
  }
  
  public OAuthBuilder(OAuthFluent<?> fluent) {
    this(fluent, new OAuth());
  }
  
  public OAuthBuilder(OAuth instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OAuthBuilder(OAuthFluent<?> fluent,OAuth instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OAuth build() {
    OAuth buildable = new OAuth(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}