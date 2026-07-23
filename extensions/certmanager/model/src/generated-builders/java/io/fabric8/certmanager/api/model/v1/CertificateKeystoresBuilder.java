package io.fabric8.certmanager.api.model.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CertificateKeystoresBuilder extends CertificateKeystoresFluent<CertificateKeystoresBuilder> implements VisitableBuilder<CertificateKeystores,CertificateKeystoresBuilder>{

  CertificateKeystoresFluent<?> fluent;

  public CertificateKeystoresBuilder() {
    this(new CertificateKeystores());
  }
  
  public CertificateKeystoresBuilder(CertificateKeystoresFluent<?> fluent) {
    this(fluent, new CertificateKeystores());
  }
  
  public CertificateKeystoresBuilder(CertificateKeystores instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CertificateKeystoresBuilder(CertificateKeystoresFluent<?> fluent,CertificateKeystores instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CertificateKeystores build() {
    CertificateKeystores buildable = new CertificateKeystores(fluent.buildJks(), fluent.buildPkcs12());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}