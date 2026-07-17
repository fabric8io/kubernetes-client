package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ExtraMappingBuilder extends ExtraMappingFluent<ExtraMappingBuilder> implements VisitableBuilder<ExtraMapping,ExtraMappingBuilder>{

  ExtraMappingFluent<?> fluent;

  public ExtraMappingBuilder() {
    this(new ExtraMapping());
  }
  
  public ExtraMappingBuilder(ExtraMappingFluent<?> fluent) {
    this(fluent, new ExtraMapping());
  }
  
  public ExtraMappingBuilder(ExtraMapping instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ExtraMappingBuilder(ExtraMappingFluent<?> fluent,ExtraMapping instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ExtraMapping build() {
    ExtraMapping buildable = new ExtraMapping(fluent.getKey(), fluent.getValueExpression());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}