package io.fabric8.openclustermanagement.api.model.cluster.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TaintBuilder extends TaintFluent<TaintBuilder> implements VisitableBuilder<Taint,TaintBuilder>{

  TaintFluent<?> fluent;

  public TaintBuilder() {
    this(new Taint());
  }
  
  public TaintBuilder(TaintFluent<?> fluent) {
    this(fluent, new Taint());
  }
  
  public TaintBuilder(Taint instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TaintBuilder(TaintFluent<?> fluent,Taint instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Taint build() {
    Taint buildable = new Taint(fluent.getEffect(), fluent.getKey(), fluent.getTimeAdded(), fluent.getValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}