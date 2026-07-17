package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OAuthStatusBuilder extends OAuthStatusFluent<OAuthStatusBuilder> implements VisitableBuilder<OAuthStatus,OAuthStatusBuilder>{

  OAuthStatusFluent<?> fluent;

  public OAuthStatusBuilder() {
    this(new OAuthStatus());
  }
  
  public OAuthStatusBuilder(OAuthStatusFluent<?> fluent) {
    this(fluent, new OAuthStatus());
  }
  
  public OAuthStatusBuilder(OAuthStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OAuthStatusBuilder(OAuthStatusFluent<?> fluent,OAuthStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OAuthStatus build() {
    OAuthStatus buildable = new OAuthStatus();
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}