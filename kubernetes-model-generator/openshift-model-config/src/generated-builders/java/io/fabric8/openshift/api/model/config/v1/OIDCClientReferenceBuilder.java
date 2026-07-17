package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OIDCClientReferenceBuilder extends OIDCClientReferenceFluent<OIDCClientReferenceBuilder> implements VisitableBuilder<OIDCClientReference,OIDCClientReferenceBuilder>{

  OIDCClientReferenceFluent<?> fluent;

  public OIDCClientReferenceBuilder() {
    this(new OIDCClientReference());
  }
  
  public OIDCClientReferenceBuilder(OIDCClientReferenceFluent<?> fluent) {
    this(fluent, new OIDCClientReference());
  }
  
  public OIDCClientReferenceBuilder(OIDCClientReference instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OIDCClientReferenceBuilder(OIDCClientReferenceFluent<?> fluent,OIDCClientReference instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OIDCClientReference build() {
    OIDCClientReference buildable = new OIDCClientReference(fluent.getClientID(), fluent.getIssuerURL(), fluent.getOidcProviderName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}