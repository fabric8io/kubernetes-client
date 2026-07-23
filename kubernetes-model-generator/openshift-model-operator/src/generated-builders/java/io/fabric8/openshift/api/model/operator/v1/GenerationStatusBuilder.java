package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GenerationStatusBuilder extends GenerationStatusFluent<GenerationStatusBuilder> implements VisitableBuilder<GenerationStatus,GenerationStatusBuilder>{

  GenerationStatusFluent<?> fluent;

  public GenerationStatusBuilder() {
    this(new GenerationStatus());
  }
  
  public GenerationStatusBuilder(GenerationStatusFluent<?> fluent) {
    this(fluent, new GenerationStatus());
  }
  
  public GenerationStatusBuilder(GenerationStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GenerationStatusBuilder(GenerationStatusFluent<?> fluent,GenerationStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GenerationStatus build() {
    GenerationStatus buildable = new GenerationStatus(fluent.getGroup(), fluent.getHash(), fluent.getLastGeneration(), fluent.getName(), fluent.getNamespace(), fluent.getResource());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}