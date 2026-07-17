package io.fabric8.openshift.api.model.operator.imageregistry.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class KMSEncryptionAlibabaBuilder extends KMSEncryptionAlibabaFluent<KMSEncryptionAlibabaBuilder> implements VisitableBuilder<KMSEncryptionAlibaba,KMSEncryptionAlibabaBuilder>{

  KMSEncryptionAlibabaFluent<?> fluent;

  public KMSEncryptionAlibabaBuilder() {
    this(new KMSEncryptionAlibaba());
  }
  
  public KMSEncryptionAlibabaBuilder(KMSEncryptionAlibabaFluent<?> fluent) {
    this(fluent, new KMSEncryptionAlibaba());
  }
  
  public KMSEncryptionAlibabaBuilder(KMSEncryptionAlibaba instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public KMSEncryptionAlibabaBuilder(KMSEncryptionAlibabaFluent<?> fluent,KMSEncryptionAlibaba instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public KMSEncryptionAlibaba build() {
    KMSEncryptionAlibaba buildable = new KMSEncryptionAlibaba(fluent.getKeyID());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}