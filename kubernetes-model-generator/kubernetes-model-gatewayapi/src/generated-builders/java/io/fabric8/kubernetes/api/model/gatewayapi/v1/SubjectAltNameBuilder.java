package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SubjectAltNameBuilder extends SubjectAltNameFluent<SubjectAltNameBuilder> implements VisitableBuilder<SubjectAltName,SubjectAltNameBuilder>{

  SubjectAltNameFluent<?> fluent;

  public SubjectAltNameBuilder() {
    this(new SubjectAltName());
  }
  
  public SubjectAltNameBuilder(SubjectAltNameFluent<?> fluent) {
    this(fluent, new SubjectAltName());
  }
  
  public SubjectAltNameBuilder(SubjectAltName instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SubjectAltNameBuilder(SubjectAltNameFluent<?> fluent,SubjectAltName instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SubjectAltName build() {
    SubjectAltName buildable = new SubjectAltName(fluent.getHostname(), fluent.getType(), fluent.getUri());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}