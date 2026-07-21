package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SubsetBuilder extends SubsetFluent<SubsetBuilder> implements VisitableBuilder<Subset,SubsetBuilder>{

  SubsetFluent<?> fluent;

  public SubsetBuilder() {
    this(new Subset());
  }
  
  public SubsetBuilder(SubsetFluent<?> fluent) {
    this(fluent, new Subset());
  }
  
  public SubsetBuilder(Subset instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SubsetBuilder(SubsetFluent<?> fluent,Subset instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Subset build() {
    Subset buildable = new Subset(fluent.getLabels(), fluent.getName(), fluent.buildTrafficPolicy());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}