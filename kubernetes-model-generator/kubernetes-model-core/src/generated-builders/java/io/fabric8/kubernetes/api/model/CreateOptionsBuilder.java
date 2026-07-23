package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CreateOptionsBuilder extends CreateOptionsFluent<CreateOptionsBuilder> implements VisitableBuilder<CreateOptions,CreateOptionsBuilder>{

  CreateOptionsFluent<?> fluent;

  public CreateOptionsBuilder() {
    this(new CreateOptions());
  }
  
  public CreateOptionsBuilder(CreateOptionsFluent<?> fluent) {
    this(fluent, new CreateOptions());
  }
  
  public CreateOptionsBuilder(CreateOptions instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CreateOptionsBuilder(CreateOptionsFluent<?> fluent,CreateOptions instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CreateOptions build() {
    CreateOptions buildable = new CreateOptions(fluent.getApiVersion(), fluent.getDryRun(), fluent.getFieldManager(), fluent.getFieldValidation(), fluent.getKind());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}