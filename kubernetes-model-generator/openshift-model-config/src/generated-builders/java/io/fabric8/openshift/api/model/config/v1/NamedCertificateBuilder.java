package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NamedCertificateBuilder extends NamedCertificateFluent<NamedCertificateBuilder> implements VisitableBuilder<NamedCertificate,NamedCertificateBuilder>{

  NamedCertificateFluent<?> fluent;

  public NamedCertificateBuilder() {
    this(new NamedCertificate());
  }
  
  public NamedCertificateBuilder(NamedCertificateFluent<?> fluent) {
    this(fluent, new NamedCertificate());
  }
  
  public NamedCertificateBuilder(NamedCertificate instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NamedCertificateBuilder(NamedCertificateFluent<?> fluent,NamedCertificate instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NamedCertificate build() {
    NamedCertificate buildable = new NamedCertificate(fluent.getCertFile(), fluent.getKeyFile(), fluent.getNames());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}