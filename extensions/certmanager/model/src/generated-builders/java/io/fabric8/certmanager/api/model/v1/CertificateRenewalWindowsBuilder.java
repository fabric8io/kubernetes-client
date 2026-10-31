package io.fabric8.certmanager.api.model.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CertificateRenewalWindowsBuilder extends CertificateRenewalWindowsFluent<CertificateRenewalWindowsBuilder> implements VisitableBuilder<CertificateRenewalWindows,CertificateRenewalWindowsBuilder>{

  CertificateRenewalWindowsFluent<?> fluent;

  public CertificateRenewalWindowsBuilder() {
    this(new CertificateRenewalWindows());
  }
  
  public CertificateRenewalWindowsBuilder(CertificateRenewalWindowsFluent<?> fluent) {
    this(fluent, new CertificateRenewalWindows());
  }
  
  public CertificateRenewalWindowsBuilder(CertificateRenewalWindows instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CertificateRenewalWindowsBuilder(CertificateRenewalWindowsFluent<?> fluent,CertificateRenewalWindows instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CertificateRenewalWindows build() {
    CertificateRenewalWindows buildable = new CertificateRenewalWindows(fluent.getCron(), fluent.getTimezone(), fluent.getWindowDuration());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}