package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class QuickStartsBuilder extends QuickStartsFluent<QuickStartsBuilder> implements VisitableBuilder<QuickStarts,QuickStartsBuilder>{

  QuickStartsFluent<?> fluent;

  public QuickStartsBuilder() {
    this(new QuickStarts());
  }
  
  public QuickStartsBuilder(QuickStartsFluent<?> fluent) {
    this(fluent, new QuickStarts());
  }
  
  public QuickStartsBuilder(QuickStarts instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public QuickStartsBuilder(QuickStartsFluent<?> fluent,QuickStarts instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public QuickStarts build() {
    QuickStarts buildable = new QuickStarts(fluent.getDisabled());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}