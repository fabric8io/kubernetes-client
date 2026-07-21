package io.fabric8.istio.api.api.analysis.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GenericAnalysisMessageBuilder extends GenericAnalysisMessageFluent<GenericAnalysisMessageBuilder> implements VisitableBuilder<GenericAnalysisMessage,GenericAnalysisMessageBuilder>{

  GenericAnalysisMessageFluent<?> fluent;

  public GenericAnalysisMessageBuilder() {
    this(new GenericAnalysisMessage());
  }
  
  public GenericAnalysisMessageBuilder(GenericAnalysisMessageFluent<?> fluent) {
    this(fluent, new GenericAnalysisMessage());
  }
  
  public GenericAnalysisMessageBuilder(GenericAnalysisMessage instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GenericAnalysisMessageBuilder(GenericAnalysisMessageFluent<?> fluent,GenericAnalysisMessage instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GenericAnalysisMessage build() {
    GenericAnalysisMessage buildable = new GenericAnalysisMessage(fluent.getArgs(), fluent.buildMessageBase(), fluent.getResourcePaths());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}