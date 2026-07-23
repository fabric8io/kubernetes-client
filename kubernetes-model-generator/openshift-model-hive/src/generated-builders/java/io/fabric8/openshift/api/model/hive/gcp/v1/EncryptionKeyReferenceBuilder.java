package io.fabric8.openshift.api.model.hive.gcp.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EncryptionKeyReferenceBuilder extends EncryptionKeyReferenceFluent<EncryptionKeyReferenceBuilder> implements VisitableBuilder<EncryptionKeyReference,EncryptionKeyReferenceBuilder>{

  EncryptionKeyReferenceFluent<?> fluent;

  public EncryptionKeyReferenceBuilder() {
    this(new EncryptionKeyReference());
  }
  
  public EncryptionKeyReferenceBuilder(EncryptionKeyReferenceFluent<?> fluent) {
    this(fluent, new EncryptionKeyReference());
  }
  
  public EncryptionKeyReferenceBuilder(EncryptionKeyReference instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EncryptionKeyReferenceBuilder(EncryptionKeyReferenceFluent<?> fluent,EncryptionKeyReference instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EncryptionKeyReference build() {
    EncryptionKeyReference buildable = new EncryptionKeyReference(fluent.buildKmsKey(), fluent.getKmsKeyServiceAccount());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}