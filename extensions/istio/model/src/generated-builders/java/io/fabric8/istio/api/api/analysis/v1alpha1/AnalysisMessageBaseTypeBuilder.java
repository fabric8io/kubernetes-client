package io.fabric8.istio.api.api.analysis.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AnalysisMessageBaseTypeBuilder extends AnalysisMessageBaseTypeFluent<AnalysisMessageBaseTypeBuilder> implements VisitableBuilder<AnalysisMessageBaseType,AnalysisMessageBaseTypeBuilder>{

  AnalysisMessageBaseTypeFluent<?> fluent;

  public AnalysisMessageBaseTypeBuilder() {
    this(new AnalysisMessageBaseType());
  }
  
  public AnalysisMessageBaseTypeBuilder(AnalysisMessageBaseTypeFluent<?> fluent) {
    this(fluent, new AnalysisMessageBaseType());
  }
  
  public AnalysisMessageBaseTypeBuilder(AnalysisMessageBaseType instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AnalysisMessageBaseTypeBuilder(AnalysisMessageBaseTypeFluent<?> fluent,AnalysisMessageBaseType instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AnalysisMessageBaseType build() {
    AnalysisMessageBaseType buildable = new AnalysisMessageBaseType(fluent.getCode(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}