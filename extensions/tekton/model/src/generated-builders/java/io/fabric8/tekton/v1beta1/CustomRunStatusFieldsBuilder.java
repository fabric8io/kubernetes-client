package io.fabric8.tekton.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CustomRunStatusFieldsBuilder extends CustomRunStatusFieldsFluent<CustomRunStatusFieldsBuilder> implements VisitableBuilder<CustomRunStatusFields,CustomRunStatusFieldsBuilder>{

  CustomRunStatusFieldsFluent<?> fluent;

  public CustomRunStatusFieldsBuilder() {
    this(new CustomRunStatusFields());
  }
  
  public CustomRunStatusFieldsBuilder(CustomRunStatusFieldsFluent<?> fluent) {
    this(fluent, new CustomRunStatusFields());
  }
  
  public CustomRunStatusFieldsBuilder(CustomRunStatusFields instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CustomRunStatusFieldsBuilder(CustomRunStatusFieldsFluent<?> fluent,CustomRunStatusFields instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CustomRunStatusFields build() {
    CustomRunStatusFields buildable = new CustomRunStatusFields(fluent.getCompletionTime(), fluent.getExtraFields(), fluent.buildResults(), fluent.buildRetriesStatus(), fluent.getStartTime());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}