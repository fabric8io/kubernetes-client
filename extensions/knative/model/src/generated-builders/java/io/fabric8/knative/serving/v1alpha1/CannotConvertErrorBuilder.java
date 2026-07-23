package io.fabric8.knative.serving.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CannotConvertErrorBuilder extends CannotConvertErrorFluent<CannotConvertErrorBuilder> implements VisitableBuilder<CannotConvertError,CannotConvertErrorBuilder>{

  CannotConvertErrorFluent<?> fluent;

  public CannotConvertErrorBuilder() {
    this(new CannotConvertError());
  }
  
  public CannotConvertErrorBuilder(CannotConvertErrorFluent<?> fluent) {
    this(fluent, new CannotConvertError());
  }
  
  public CannotConvertErrorBuilder(CannotConvertError instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CannotConvertErrorBuilder(CannotConvertErrorFluent<?> fluent,CannotConvertError instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CannotConvertError build() {
    CannotConvertError buildable = new CannotConvertError(fluent.getField(), fluent.getMessage());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}