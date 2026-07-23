package io.fabric8.certmanager.api.model.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CertificateSecretTemplateBuilder extends CertificateSecretTemplateFluent<CertificateSecretTemplateBuilder> implements VisitableBuilder<CertificateSecretTemplate,CertificateSecretTemplateBuilder>{

  CertificateSecretTemplateFluent<?> fluent;

  public CertificateSecretTemplateBuilder() {
    this(new CertificateSecretTemplate());
  }
  
  public CertificateSecretTemplateBuilder(CertificateSecretTemplateFluent<?> fluent) {
    this(fluent, new CertificateSecretTemplate());
  }
  
  public CertificateSecretTemplateBuilder(CertificateSecretTemplate instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CertificateSecretTemplateBuilder(CertificateSecretTemplateFluent<?> fluent,CertificateSecretTemplate instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CertificateSecretTemplate build() {
    CertificateSecretTemplate buildable = new CertificateSecretTemplate(fluent.getAnnotations(), fluent.getLabels());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}