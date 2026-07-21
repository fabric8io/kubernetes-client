package io.fabric8.tekton.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RunStatusFieldsBuilder extends RunStatusFieldsFluent<RunStatusFieldsBuilder> implements VisitableBuilder<RunStatusFields,RunStatusFieldsBuilder>{

  RunStatusFieldsFluent<?> fluent;

  public RunStatusFieldsBuilder() {
    this(new RunStatusFields());
  }
  
  public RunStatusFieldsBuilder(RunStatusFieldsFluent<?> fluent) {
    this(fluent, new RunStatusFields());
  }
  
  public RunStatusFieldsBuilder(RunStatusFields instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RunStatusFieldsBuilder(RunStatusFieldsFluent<?> fluent,RunStatusFields instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RunStatusFields build() {
    RunStatusFields buildable = new RunStatusFields(fluent.getCompletionTime(), fluent.getExtraFields(), fluent.buildResults(), fluent.buildRetriesStatus(), fluent.getStartTime());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}