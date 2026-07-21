package io.fabric8.knative.duck.v1beta1;

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
    Destination buildable = new Destination(fluent.getCACerts(), fluent.getApiVersion(), fluent.getKind(), fluent.getName(), fluent.getNamespace(), fluent.buildRef(), fluent.getUri());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}