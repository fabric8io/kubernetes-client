package io.fabric8.certmanager.api.model.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CertificateAdditionalOutputFormatBuilder extends CertificateAdditionalOutputFormatFluent<CertificateAdditionalOutputFormatBuilder> implements VisitableBuilder<CertificateAdditionalOutputFormat,CertificateAdditionalOutputFormatBuilder>{

  CertificateAdditionalOutputFormatFluent<?> fluent;

  public CertificateAdditionalOutputFormatBuilder() {
    this(new CertificateAdditionalOutputFormat());
  }
  
  public CertificateAdditionalOutputFormatBuilder(CertificateAdditionalOutputFormatFluent<?> fluent) {
    this(fluent, new CertificateAdditionalOutputFormat());
  }
  
  public CertificateAdditionalOutputFormatBuilder(CertificateAdditionalOutputFormat instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CertificateAdditionalOutputFormatBuilder(CertificateAdditionalOutputFormatFluent<?> fluent,CertificateAdditionalOutputFormat instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CertificateAdditionalOutputFormat build() {
    CertificateAdditionalOutputFormat buildable = new CertificateAdditionalOutputFormat(fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}