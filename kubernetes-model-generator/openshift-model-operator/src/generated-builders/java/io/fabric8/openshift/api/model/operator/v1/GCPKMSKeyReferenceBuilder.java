package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GCPKMSKeyReferenceBuilder extends GCPKMSKeyReferenceFluent<GCPKMSKeyReferenceBuilder> implements VisitableBuilder<GCPKMSKeyReference,GCPKMSKeyReferenceBuilder>{

  GCPKMSKeyReferenceFluent<?> fluent;

  public GCPKMSKeyReferenceBuilder() {
    this(new GCPKMSKeyReference());
  }
  
  public GCPKMSKeyReferenceBuilder(GCPKMSKeyReferenceFluent<?> fluent) {
    this(fluent, new GCPKMSKeyReference());
  }
  
  public GCPKMSKeyReferenceBuilder(GCPKMSKeyReference instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GCPKMSKeyReferenceBuilder(GCPKMSKeyReferenceFluent<?> fluent,GCPKMSKeyReference instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GCPKMSKeyReference build() {
    GCPKMSKeyReference buildable = new GCPKMSKeyReference(fluent.getKeyRing(), fluent.getLocation(), fluent.getName(), fluent.getProjectID());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}