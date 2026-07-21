package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PercentBuilder extends PercentFluent<PercentBuilder> implements VisitableBuilder<Percent,PercentBuilder>{

  PercentFluent<?> fluent;

  public PercentBuilder() {
    this(new Percent());
  }
  
  public PercentBuilder(PercentFluent<?> fluent) {
    this(fluent, new Percent());
  }
  
  public PercentBuilder(Percent instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PercentBuilder(PercentFluent<?> fluent,Percent instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Percent build() {
    Percent buildable = new Percent(fluent.getValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}