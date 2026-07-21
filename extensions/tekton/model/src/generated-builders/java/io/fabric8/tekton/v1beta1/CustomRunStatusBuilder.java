package io.fabric8.tekton.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CustomRunStatusBuilder extends CustomRunStatusFluent<CustomRunStatusBuilder> implements VisitableBuilder<CustomRunStatus,CustomRunStatusBuilder>{

  CustomRunStatusFluent<?> fluent;

  public CustomRunStatusBuilder() {
    this(new CustomRunStatus());
  }
  
  public CustomRunStatusBuilder(CustomRunStatusFluent<?> fluent) {
    this(fluent, new CustomRunStatus());
  }
  
  public CustomRunStatusBuilder(CustomRunStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CustomRunStatusBuilder(CustomRunStatusFluent<?> fluent,CustomRunStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CustomRunStatus build() {
    CustomRunStatus buildable = new CustomRunStatus(fluent.getAnnotations(), fluent.getCompletionTime(), fluent.getConditions(), fluent.getExtraFields(), fluent.getObservedGeneration(), fluent.buildResults(), fluent.buildRetriesStatus(), fluent.getStartTime());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}