package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class LabelSelectorBuilder extends LabelSelectorFluent<LabelSelectorBuilder> implements VisitableBuilder<LabelSelector,LabelSelectorBuilder>{

  LabelSelectorFluent<?> fluent;

  public LabelSelectorBuilder() {
    this(new LabelSelector());
  }
  
  public LabelSelectorBuilder(LabelSelectorFluent<?> fluent) {
    this(fluent, new LabelSelector());
  }
  
  public LabelSelectorBuilder(LabelSelector instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public LabelSelectorBuilder(LabelSelectorFluent<?> fluent,LabelSelector instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public LabelSelector build() {
    LabelSelector buildable = new LabelSelector(fluent.buildMatchExpressions(), fluent.getMatchLabels());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}