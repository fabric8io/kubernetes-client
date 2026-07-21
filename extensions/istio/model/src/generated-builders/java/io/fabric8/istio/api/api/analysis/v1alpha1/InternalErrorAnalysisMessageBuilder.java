package io.fabric8.istio.api.api.analysis.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class InternalErrorAnalysisMessageBuilder extends InternalErrorAnalysisMessageFluent<InternalErrorAnalysisMessageBuilder> implements VisitableBuilder<InternalErrorAnalysisMessage,InternalErrorAnalysisMessageBuilder>{

  InternalErrorAnalysisMessageFluent<?> fluent;

  public InternalErrorAnalysisMessageBuilder() {
    this(new InternalErrorAnalysisMessage());
  }
  
  public InternalErrorAnalysisMessageBuilder(InternalErrorAnalysisMessageFluent<?> fluent) {
    this(fluent, new InternalErrorAnalysisMessage());
  }
  
  public InternalErrorAnalysisMessageBuilder(InternalErrorAnalysisMessage instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public InternalErrorAnalysisMessageBuilder(InternalErrorAnalysisMessageFluent<?> fluent,InternalErrorAnalysisMessage instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public InternalErrorAnalysisMessage build() {
    InternalErrorAnalysisMessage buildable = new InternalErrorAnalysisMessage(fluent.getDetail(), fluent.buildMessageBase());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}