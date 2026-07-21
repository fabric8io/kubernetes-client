package io.fabric8.istio.api.api.analysis.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AnalysisMessageWeakSchemaArgTypeBuilder extends AnalysisMessageWeakSchemaArgTypeFluent<AnalysisMessageWeakSchemaArgTypeBuilder> implements VisitableBuilder<AnalysisMessageWeakSchemaArgType,AnalysisMessageWeakSchemaArgTypeBuilder>{

  AnalysisMessageWeakSchemaArgTypeFluent<?> fluent;

  public AnalysisMessageWeakSchemaArgTypeBuilder() {
    this(new AnalysisMessageWeakSchemaArgType());
  }
  
  public AnalysisMessageWeakSchemaArgTypeBuilder(AnalysisMessageWeakSchemaArgTypeFluent<?> fluent) {
    this(fluent, new AnalysisMessageWeakSchemaArgType());
  }
  
  public AnalysisMessageWeakSchemaArgTypeBuilder(AnalysisMessageWeakSchemaArgType instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AnalysisMessageWeakSchemaArgTypeBuilder(AnalysisMessageWeakSchemaArgTypeFluent<?> fluent,AnalysisMessageWeakSchemaArgType instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AnalysisMessageWeakSchemaArgType build() {
    AnalysisMessageWeakSchemaArgType buildable = new AnalysisMessageWeakSchemaArgType(fluent.getGoType(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}