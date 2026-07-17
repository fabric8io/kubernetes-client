package io.fabric8.openshift.api.model.insights.v1alpha2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CustomBuilder extends CustomFluent<CustomBuilder> implements VisitableBuilder<Custom,CustomBuilder>{

  CustomFluent<?> fluent;

  public CustomBuilder() {
    this(new Custom());
  }
  
  public CustomBuilder(CustomFluent<?> fluent) {
    this(fluent, new Custom());
  }
  
  public CustomBuilder(Custom instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CustomBuilder(CustomFluent<?> fluent,Custom instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Custom build() {
    Custom buildable = new Custom(fluent.buildConfigs());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}