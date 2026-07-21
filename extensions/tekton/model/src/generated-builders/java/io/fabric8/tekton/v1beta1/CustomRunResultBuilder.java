package io.fabric8.tekton.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CustomRunResultBuilder extends CustomRunResultFluent<CustomRunResultBuilder> implements VisitableBuilder<CustomRunResult,CustomRunResultBuilder>{

  CustomRunResultFluent<?> fluent;

  public CustomRunResultBuilder() {
    this(new CustomRunResult());
  }
  
  public CustomRunResultBuilder(CustomRunResultFluent<?> fluent) {
    this(fluent, new CustomRunResult());
  }
  
  public CustomRunResultBuilder(CustomRunResult instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CustomRunResultBuilder(CustomRunResultFluent<?> fluent,CustomRunResult instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CustomRunResult build() {
    CustomRunResult buildable = new CustomRunResult(fluent.getName(), fluent.getValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}