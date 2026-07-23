package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MistakeSpecBuilder extends MistakeSpecFluent<MistakeSpecBuilder> implements VisitableBuilder<MistakeSpec,MistakeSpecBuilder>{

  MistakeSpecFluent<?> fluent;

  public MistakeSpecBuilder() {
    this(new MistakeSpec());
  }
  
  public MistakeSpecBuilder(MistakeSpecFluent<?> fluent) {
    this(fluent, new MistakeSpec());
  }
  
  public MistakeSpecBuilder(MistakeSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MistakeSpecBuilder(MistakeSpecFluent<?> fluent,MistakeSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MistakeSpec build() {
    MistakeSpec buildable = new MistakeSpec(fluent.getFilling(), fluent.getMaxLength(), fluent.getMaxOccurrences());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}