package io.fabric8.certmanager.api.model.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CertificatePrivateKeyBuilder extends CertificatePrivateKeyFluent<CertificatePrivateKeyBuilder> implements VisitableBuilder<CertificatePrivateKey,CertificatePrivateKeyBuilder>{

  CertificatePrivateKeyFluent<?> fluent;

  public CertificatePrivateKeyBuilder() {
    this(new CertificatePrivateKey());
  }
  
  public CertificatePrivateKeyBuilder(CertificatePrivateKeyFluent<?> fluent) {
    this(fluent, new CertificatePrivateKey());
  }
  
  public CertificatePrivateKeyBuilder(CertificatePrivateKey instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CertificatePrivateKeyBuilder(CertificatePrivateKeyFluent<?> fluent,CertificatePrivateKey instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CertificatePrivateKey build() {
    CertificatePrivateKey buildable = new CertificatePrivateKey(fluent.getAlgorithm(), fluent.getEncoding(), fluent.getRotationPolicy(), fluent.getSize());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}