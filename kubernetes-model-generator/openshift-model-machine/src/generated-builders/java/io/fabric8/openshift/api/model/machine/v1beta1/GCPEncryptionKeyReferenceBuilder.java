package io.fabric8.openshift.api.model.machine.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GCPEncryptionKeyReferenceBuilder extends GCPEncryptionKeyReferenceFluent<GCPEncryptionKeyReferenceBuilder> implements VisitableBuilder<GCPEncryptionKeyReference,GCPEncryptionKeyReferenceBuilder>{

  GCPEncryptionKeyReferenceFluent<?> fluent;

  public GCPEncryptionKeyReferenceBuilder() {
    this(new GCPEncryptionKeyReference());
  }
  
  public GCPEncryptionKeyReferenceBuilder(GCPEncryptionKeyReferenceFluent<?> fluent) {
    this(fluent, new GCPEncryptionKeyReference());
  }
  
  public GCPEncryptionKeyReferenceBuilder(GCPEncryptionKeyReference instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GCPEncryptionKeyReferenceBuilder(GCPEncryptionKeyReferenceFluent<?> fluent,GCPEncryptionKeyReference instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GCPEncryptionKeyReference build() {
    GCPEncryptionKeyReference buildable = new GCPEncryptionKeyReference(fluent.buildKmsKey(), fluent.getKmsKeyServiceAccount());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}