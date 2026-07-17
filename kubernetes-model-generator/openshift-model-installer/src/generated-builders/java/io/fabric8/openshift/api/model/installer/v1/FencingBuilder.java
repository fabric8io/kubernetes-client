package io.fabric8.openshift.api.model.installer.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class FencingBuilder extends FencingFluent<FencingBuilder> implements VisitableBuilder<Fencing,FencingBuilder>{

  FencingFluent<?> fluent;

  public FencingBuilder() {
    this(new Fencing());
  }
  
  public FencingBuilder(FencingFluent<?> fluent) {
    this(fluent, new Fencing());
  }
  
  public FencingBuilder(Fencing instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public FencingBuilder(FencingFluent<?> fluent,Fencing instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Fencing build() {
    Fencing buildable = new Fencing(fluent.buildCredentials());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}