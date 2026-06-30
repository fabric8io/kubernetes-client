package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class UpdateOptionsBuilder extends UpdateOptionsFluent<UpdateOptionsBuilder> implements VisitableBuilder<UpdateOptions,UpdateOptionsBuilder>{

  UpdateOptionsFluent<?> fluent;

  public UpdateOptionsBuilder() {
    this(new UpdateOptions());
  }
  
  public UpdateOptionsBuilder(UpdateOptionsFluent<?> fluent) {
    this(fluent, new UpdateOptions());
  }
  
  public UpdateOptionsBuilder(UpdateOptions instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public UpdateOptionsBuilder(UpdateOptionsFluent<?> fluent,UpdateOptions instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public UpdateOptions build() {
    UpdateOptions buildable = new UpdateOptions(fluent.getApiVersion(), fluent.getDryRun(), fluent.getFieldManager(), fluent.getFieldValidation(), fluent.getKind());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}