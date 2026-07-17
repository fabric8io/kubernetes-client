package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ControlPlaneAdditionalCertificateBuilder extends ControlPlaneAdditionalCertificateFluent<ControlPlaneAdditionalCertificateBuilder> implements VisitableBuilder<ControlPlaneAdditionalCertificate,ControlPlaneAdditionalCertificateBuilder>{

  ControlPlaneAdditionalCertificateFluent<?> fluent;

  public ControlPlaneAdditionalCertificateBuilder() {
    this(new ControlPlaneAdditionalCertificate());
  }
  
  public ControlPlaneAdditionalCertificateBuilder(ControlPlaneAdditionalCertificateFluent<?> fluent) {
    this(fluent, new ControlPlaneAdditionalCertificate());
  }
  
  public ControlPlaneAdditionalCertificateBuilder(ControlPlaneAdditionalCertificate instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ControlPlaneAdditionalCertificateBuilder(ControlPlaneAdditionalCertificateFluent<?> fluent,ControlPlaneAdditionalCertificate instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ControlPlaneAdditionalCertificate build() {
    ControlPlaneAdditionalCertificate buildable = new ControlPlaneAdditionalCertificate(fluent.getDomain(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}