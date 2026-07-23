package io.fabric8.kubernetes.api.model.admissionregistration.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TypeCheckingBuilder extends TypeCheckingFluent<TypeCheckingBuilder> implements VisitableBuilder<TypeChecking,TypeCheckingBuilder>{

  TypeCheckingFluent<?> fluent;

  public TypeCheckingBuilder() {
    this(new TypeChecking());
  }
  
  public TypeCheckingBuilder(TypeCheckingFluent<?> fluent) {
    this(fluent, new TypeChecking());
  }
  
  public TypeCheckingBuilder(TypeChecking instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TypeCheckingBuilder(TypeCheckingFluent<?> fluent,TypeChecking instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TypeChecking build() {
    TypeChecking buildable = new TypeChecking(fluent.buildExpressionWarnings());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}