package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class KubeconfigSecretReferenceBuilder extends KubeconfigSecretReferenceFluent<KubeconfigSecretReferenceBuilder> implements VisitableBuilder<KubeconfigSecretReference,KubeconfigSecretReferenceBuilder>{

  KubeconfigSecretReferenceFluent<?> fluent;

  public KubeconfigSecretReferenceBuilder() {
    this(new KubeconfigSecretReference());
  }
  
  public KubeconfigSecretReferenceBuilder(KubeconfigSecretReferenceFluent<?> fluent) {
    this(fluent, new KubeconfigSecretReference());
  }
  
  public KubeconfigSecretReferenceBuilder(KubeconfigSecretReference instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public KubeconfigSecretReferenceBuilder(KubeconfigSecretReferenceFluent<?> fluent,KubeconfigSecretReference instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public KubeconfigSecretReference build() {
    KubeconfigSecretReference buildable = new KubeconfigSecretReference(fluent.getName(), fluent.getNamespace());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}