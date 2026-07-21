package io.fabric8.istio.api.api.analysis.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AnalysisMessageWeakSchemaBuilder extends AnalysisMessageWeakSchemaFluent<AnalysisMessageWeakSchemaBuilder> implements VisitableBuilder<AnalysisMessageWeakSchema,AnalysisMessageWeakSchemaBuilder>{

  AnalysisMessageWeakSchemaFluent<?> fluent;

  public AnalysisMessageWeakSchemaBuilder() {
    this(new AnalysisMessageWeakSchema());
  }
  
  public AnalysisMessageWeakSchemaBuilder(AnalysisMessageWeakSchemaFluent<?> fluent) {
    this(fluent, new AnalysisMessageWeakSchema());
  }
  
  public AnalysisMessageWeakSchemaBuilder(AnalysisMessageWeakSchema instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AnalysisMessageWeakSchemaBuilder(AnalysisMessageWeakSchemaFluent<?> fluent,AnalysisMessageWeakSchema instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AnalysisMessageWeakSchema build() {
    AnalysisMessageWeakSchema buildable = new AnalysisMessageWeakSchema(fluent.buildArgs(), fluent.getDescription(), fluent.buildMessageBase(), fluent.getTemplate());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}