package io.fabric8.kubernetes.api.model.node.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OverheadBuilder extends OverheadFluent<OverheadBuilder> implements VisitableBuilder<Overhead,OverheadBuilder>{

  OverheadFluent<?> fluent;

  public OverheadBuilder() {
    this(new Overhead());
  }
  
  public OverheadBuilder(OverheadFluent<?> fluent) {
    this(fluent, new Overhead());
  }
  
  public OverheadBuilder(Overhead instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OverheadBuilder(OverheadFluent<?> fluent,Overhead instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Overhead build() {
    Overhead buildable = new Overhead(fluent.getPodFixed());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}