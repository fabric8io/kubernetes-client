package io.fabric8.openshift.api.model.hive.gcp.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class KMSKeyReferenceBuilder extends KMSKeyReferenceFluent<KMSKeyReferenceBuilder> implements VisitableBuilder<KMSKeyReference,KMSKeyReferenceBuilder>{

  KMSKeyReferenceFluent<?> fluent;

  public KMSKeyReferenceBuilder() {
    this(new KMSKeyReference());
  }
  
  public KMSKeyReferenceBuilder(KMSKeyReferenceFluent<?> fluent) {
    this(fluent, new KMSKeyReference());
  }
  
  public KMSKeyReferenceBuilder(KMSKeyReference instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public KMSKeyReferenceBuilder(KMSKeyReferenceFluent<?> fluent,KMSKeyReference instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public KMSKeyReference build() {
    KMSKeyReference buildable = new KMSKeyReference(fluent.getKeyRing(), fluent.getLocation(), fluent.getName(), fluent.getProjectID());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}