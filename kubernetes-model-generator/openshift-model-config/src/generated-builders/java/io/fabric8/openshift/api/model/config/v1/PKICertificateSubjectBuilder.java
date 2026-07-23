package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PKICertificateSubjectBuilder extends PKICertificateSubjectFluent<PKICertificateSubjectBuilder> implements VisitableBuilder<PKICertificateSubject,PKICertificateSubjectBuilder>{

  PKICertificateSubjectFluent<?> fluent;

  public PKICertificateSubjectBuilder() {
    this(new PKICertificateSubject());
  }
  
  public PKICertificateSubjectBuilder(PKICertificateSubjectFluent<?> fluent) {
    this(fluent, new PKICertificateSubject());
  }
  
  public PKICertificateSubjectBuilder(PKICertificateSubject instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PKICertificateSubjectBuilder(PKICertificateSubjectFluent<?> fluent,PKICertificateSubject instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PKICertificateSubject build() {
    PKICertificateSubject buildable = new PKICertificateSubject(fluent.getEmail(), fluent.getHostname());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}