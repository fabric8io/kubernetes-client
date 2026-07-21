package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DestinationBuilder extends DestinationFluent<DestinationBuilder> implements VisitableBuilder<Destination,DestinationBuilder>{

  DestinationFluent<?> fluent;

  public DestinationBuilder() {
    this(new Destination());
  }
  
  public DestinationBuilder(DestinationFluent<?> fluent) {
    this(fluent, new Destination());
  }
  
  public DestinationBuilder(Destination instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DestinationBuilder(DestinationFluent<?> fluent,Destination instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Destination build() {
    Destination buildable = new Destination(fluent.getHost(), fluent.buildPort(), fluent.getSubset());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}