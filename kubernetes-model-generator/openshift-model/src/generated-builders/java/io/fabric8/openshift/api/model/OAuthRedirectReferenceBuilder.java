package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OAuthRedirectReferenceBuilder extends OAuthRedirectReferenceFluent<OAuthRedirectReferenceBuilder> implements VisitableBuilder<OAuthRedirectReference,OAuthRedirectReferenceBuilder>{

  OAuthRedirectReferenceFluent<?> fluent;

  public OAuthRedirectReferenceBuilder() {
    this(new OAuthRedirectReference());
  }
  
  public OAuthRedirectReferenceBuilder(OAuthRedirectReferenceFluent<?> fluent) {
    this(fluent, new OAuthRedirectReference());
  }
  
  public OAuthRedirectReferenceBuilder(OAuthRedirectReference instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OAuthRedirectReferenceBuilder(OAuthRedirectReferenceFluent<?> fluent,OAuthRedirectReference instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OAuthRedirectReference build() {
    OAuthRedirectReference buildable = new OAuthRedirectReference(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildReference());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}