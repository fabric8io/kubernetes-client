package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OAuthSpecBuilder extends OAuthSpecFluent<OAuthSpecBuilder> implements VisitableBuilder<OAuthSpec,OAuthSpecBuilder>{

  OAuthSpecFluent<?> fluent;

  public OAuthSpecBuilder() {
    this(new OAuthSpec());
  }
  
  public OAuthSpecBuilder(OAuthSpecFluent<?> fluent) {
    this(fluent, new OAuthSpec());
  }
  
  public OAuthSpecBuilder(OAuthSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OAuthSpecBuilder(OAuthSpecFluent<?> fluent,OAuthSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OAuthSpec build() {
    OAuthSpec buildable = new OAuthSpec(fluent.buildIdentityProviders(), fluent.buildTemplates(), fluent.buildTokenConfig());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}