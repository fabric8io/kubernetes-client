package io.fabric8.openshift.api.model.operator.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GenerationHistoryBuilder extends GenerationHistoryFluent<GenerationHistoryBuilder> implements VisitableBuilder<GenerationHistory,GenerationHistoryBuilder>{

  GenerationHistoryFluent<?> fluent;

  public GenerationHistoryBuilder() {
    this(new GenerationHistory());
  }
  
  public GenerationHistoryBuilder(GenerationHistoryFluent<?> fluent) {
    this(fluent, new GenerationHistory());
  }
  
  public GenerationHistoryBuilder(GenerationHistory instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GenerationHistoryBuilder(GenerationHistoryFluent<?> fluent,GenerationHistory instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GenerationHistory build() {
    GenerationHistory buildable = new GenerationHistory(fluent.getGroup(), fluent.getLastGeneration(), fluent.getName(), fluent.getNamespace(), fluent.getResource());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}