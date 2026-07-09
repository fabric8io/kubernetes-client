package io.fabric8.kubernetes.api.model.apiextensions.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SelectableFieldBuilder extends SelectableFieldFluent<SelectableFieldBuilder> implements VisitableBuilder<SelectableField,SelectableFieldBuilder>{

  SelectableFieldFluent<?> fluent;

  public SelectableFieldBuilder() {
    this(new SelectableField());
  }
  
  public SelectableFieldBuilder(SelectableFieldFluent<?> fluent) {
    this(fluent, new SelectableField());
  }
  
  public SelectableFieldBuilder(SelectableField instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SelectableFieldBuilder(SelectableFieldFluent<?> fluent,SelectableField instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SelectableField build() {
    SelectableField buildable = new SelectableField(fluent.getJsonPath());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}