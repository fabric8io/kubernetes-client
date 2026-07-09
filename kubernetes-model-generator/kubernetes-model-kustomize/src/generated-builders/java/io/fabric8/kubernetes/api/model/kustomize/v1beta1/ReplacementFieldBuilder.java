package io.fabric8.kubernetes.api.model.kustomize.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ReplacementFieldBuilder extends ReplacementFieldFluent<ReplacementFieldBuilder> implements VisitableBuilder<ReplacementField,ReplacementFieldBuilder>{

  ReplacementFieldFluent<?> fluent;

  public ReplacementFieldBuilder() {
    this(new ReplacementField());
  }
  
  public ReplacementFieldBuilder(ReplacementFieldFluent<?> fluent) {
    this(fluent, new ReplacementField());
  }
  
  public ReplacementFieldBuilder(ReplacementField instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ReplacementFieldBuilder(ReplacementFieldFluent<?> fluent,ReplacementField instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ReplacementField build() {
    ReplacementField buildable = new ReplacementField(fluent.getPath(), fluent.buildSource(), fluent.getSourceValue(), fluent.buildTargets());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}