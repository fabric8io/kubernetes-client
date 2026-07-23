package io.fabric8.openshift.api.model.machineconfiguration.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CertExpiryBuilder extends CertExpiryFluent<CertExpiryBuilder> implements VisitableBuilder<CertExpiry,CertExpiryBuilder>{

  CertExpiryFluent<?> fluent;

  public CertExpiryBuilder() {
    this(new CertExpiry());
  }
  
  public CertExpiryBuilder(CertExpiryFluent<?> fluent) {
    this(fluent, new CertExpiry());
  }
  
  public CertExpiryBuilder(CertExpiry instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CertExpiryBuilder(CertExpiryFluent<?> fluent,CertExpiry instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CertExpiry build() {
    CertExpiry buildable = new CertExpiry(fluent.getBundle(), fluent.getExpiry(), fluent.getSubject());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}