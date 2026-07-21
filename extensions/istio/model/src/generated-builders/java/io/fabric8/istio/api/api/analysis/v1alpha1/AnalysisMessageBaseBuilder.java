package io.fabric8.istio.api.api.analysis.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AnalysisMessageBaseBuilder extends AnalysisMessageBaseFluent<AnalysisMessageBaseBuilder> implements VisitableBuilder<AnalysisMessageBase,AnalysisMessageBaseBuilder>{

  AnalysisMessageBaseFluent<?> fluent;

  public AnalysisMessageBaseBuilder() {
    this(new AnalysisMessageBase());
  }
  
  public AnalysisMessageBaseBuilder(AnalysisMessageBaseFluent<?> fluent) {
    this(fluent, new AnalysisMessageBase());
  }
  
  public AnalysisMessageBaseBuilder(AnalysisMessageBase instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AnalysisMessageBaseBuilder(AnalysisMessageBaseFluent<?> fluent,AnalysisMessageBase instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AnalysisMessageBase build() {
    AnalysisMessageBase buildable = new AnalysisMessageBase(fluent.getDocumentationUrl(), fluent.getLevel(), fluent.buildType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}