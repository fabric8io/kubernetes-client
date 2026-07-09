package io.fabric8.kubernetes.api.model.kustomize.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class FieldOptionsBuilder extends FieldOptionsFluent<FieldOptionsBuilder> implements VisitableBuilder<FieldOptions,FieldOptionsBuilder>{

  FieldOptionsFluent<?> fluent;

  public FieldOptionsBuilder() {
    this(new FieldOptions());
  }
  
  public FieldOptionsBuilder(FieldOptionsFluent<?> fluent) {
    this(fluent, new FieldOptions());
  }
  
  public FieldOptionsBuilder(FieldOptions instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public FieldOptionsBuilder(FieldOptionsFluent<?> fluent,FieldOptions instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public FieldOptions build() {
    FieldOptions buildable = new FieldOptions(fluent.getCreate(), fluent.getDelimiter(), fluent.getEncoding(), fluent.getIndex());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}