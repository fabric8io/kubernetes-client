package io.fabric8.openshift.api.model.machineconfiguration.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ControllerCertificateBuilder extends ControllerCertificateFluent<ControllerCertificateBuilder> implements VisitableBuilder<ControllerCertificate,ControllerCertificateBuilder>{

  ControllerCertificateFluent<?> fluent;

  public ControllerCertificateBuilder() {
    this(new ControllerCertificate());
  }
  
  public ControllerCertificateBuilder(ControllerCertificateFluent<?> fluent) {
    this(fluent, new ControllerCertificate());
  }
  
  public ControllerCertificateBuilder(ControllerCertificate instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ControllerCertificateBuilder(ControllerCertificateFluent<?> fluent,ControllerCertificate instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ControllerCertificate build() {
    ControllerCertificate buildable = new ControllerCertificate(fluent.getBundleFile(), fluent.getNotAfter(), fluent.getNotBefore(), fluent.getSigner(), fluent.getSubject());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}