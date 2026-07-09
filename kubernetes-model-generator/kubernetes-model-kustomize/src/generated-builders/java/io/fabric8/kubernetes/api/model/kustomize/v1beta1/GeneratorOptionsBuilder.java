package io.fabric8.kubernetes.api.model.kustomize.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GeneratorOptionsBuilder extends GeneratorOptionsFluent<GeneratorOptionsBuilder> implements VisitableBuilder<GeneratorOptions,GeneratorOptionsBuilder>{

  GeneratorOptionsFluent<?> fluent;

  public GeneratorOptionsBuilder() {
    this(new GeneratorOptions());
  }
  
  public GeneratorOptionsBuilder(GeneratorOptionsFluent<?> fluent) {
    this(fluent, new GeneratorOptions());
  }
  
  public GeneratorOptionsBuilder(GeneratorOptions instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GeneratorOptionsBuilder(GeneratorOptionsFluent<?> fluent,GeneratorOptions instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GeneratorOptions build() {
    GeneratorOptions buildable = new GeneratorOptions(fluent.getAnnotations(), fluent.getDisableNameSuffixHash(), fluent.getImmutable(), fluent.getLabels());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}