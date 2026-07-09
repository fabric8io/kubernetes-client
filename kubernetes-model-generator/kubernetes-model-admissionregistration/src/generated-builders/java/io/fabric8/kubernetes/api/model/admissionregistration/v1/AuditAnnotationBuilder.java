package io.fabric8.kubernetes.api.model.admissionregistration.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AuditAnnotationBuilder extends AuditAnnotationFluent<AuditAnnotationBuilder> implements VisitableBuilder<AuditAnnotation,AuditAnnotationBuilder>{

  AuditAnnotationFluent<?> fluent;

  public AuditAnnotationBuilder() {
    this(new AuditAnnotation());
  }
  
  public AuditAnnotationBuilder(AuditAnnotationFluent<?> fluent) {
    this(fluent, new AuditAnnotation());
  }
  
  public AuditAnnotationBuilder(AuditAnnotation instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AuditAnnotationBuilder(AuditAnnotationFluent<?> fluent,AuditAnnotation instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AuditAnnotation build() {
    AuditAnnotation buildable = new AuditAnnotation(fluent.getKey(), fluent.getValueExpression());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}