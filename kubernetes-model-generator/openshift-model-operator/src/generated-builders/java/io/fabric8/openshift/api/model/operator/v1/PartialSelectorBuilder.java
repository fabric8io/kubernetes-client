package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PartialSelectorBuilder extends PartialSelectorFluent<PartialSelectorBuilder> implements VisitableBuilder<PartialSelector,PartialSelectorBuilder>{

  PartialSelectorFluent<?> fluent;

  public PartialSelectorBuilder() {
    this(new PartialSelector());
  }
  
  public PartialSelectorBuilder(PartialSelectorFluent<?> fluent) {
    this(fluent, new PartialSelector());
  }
  
  public PartialSelectorBuilder(PartialSelector instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PartialSelectorBuilder(PartialSelectorFluent<?> fluent,PartialSelector instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PartialSelector build() {
    PartialSelector buildable = new PartialSelector(fluent.buildMachineResourceSelector());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}