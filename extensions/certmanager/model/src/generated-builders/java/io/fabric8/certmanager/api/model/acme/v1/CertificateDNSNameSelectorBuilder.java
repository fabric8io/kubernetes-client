package io.fabric8.certmanager.api.model.acme.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CertificateDNSNameSelectorBuilder extends CertificateDNSNameSelectorFluent<CertificateDNSNameSelectorBuilder> implements VisitableBuilder<CertificateDNSNameSelector,CertificateDNSNameSelectorBuilder>{

  CertificateDNSNameSelectorFluent<?> fluent;

  public CertificateDNSNameSelectorBuilder() {
    this(new CertificateDNSNameSelector());
  }
  
  public CertificateDNSNameSelectorBuilder(CertificateDNSNameSelectorFluent<?> fluent) {
    this(fluent, new CertificateDNSNameSelector());
  }
  
  public CertificateDNSNameSelectorBuilder(CertificateDNSNameSelector instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CertificateDNSNameSelectorBuilder(CertificateDNSNameSelectorFluent<?> fluent,CertificateDNSNameSelector instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CertificateDNSNameSelector build() {
    CertificateDNSNameSelector buildable = new CertificateDNSNameSelector(fluent.getDnsNames(), fluent.getDnsZones(), fluent.getMatchLabels());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}