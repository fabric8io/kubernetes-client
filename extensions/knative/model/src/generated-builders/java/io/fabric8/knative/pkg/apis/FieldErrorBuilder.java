package io.fabric8.knative.pkg.apis;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class FieldErrorBuilder extends FieldErrorFluent<FieldErrorBuilder> implements VisitableBuilder<FieldError,FieldErrorBuilder>{

  FieldErrorFluent<?> fluent;

  public FieldErrorBuilder() {
    this(new FieldError());
  }
  
  public FieldErrorBuilder(FieldErrorFluent<?> fluent) {
    this(fluent, new FieldError());
  }
  
  public FieldErrorBuilder(FieldError instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public FieldErrorBuilder(FieldErrorFluent<?> fluent,FieldError instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public FieldError build() {
    FieldError buildable = new FieldError(fluent.getDetails(), fluent.getLevel(), fluent.getMessage(), fluent.getPaths());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}