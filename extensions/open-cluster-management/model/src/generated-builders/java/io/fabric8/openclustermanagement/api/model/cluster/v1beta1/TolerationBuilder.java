package io.fabric8.openclustermanagement.api.model.cluster.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TolerationBuilder extends TolerationFluent<TolerationBuilder> implements VisitableBuilder<Toleration,TolerationBuilder>{

  TolerationFluent<?> fluent;

  public TolerationBuilder() {
    this(new Toleration());
  }
  
  public TolerationBuilder(TolerationFluent<?> fluent) {
    this(fluent, new Toleration());
  }
  
  public TolerationBuilder(Toleration instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TolerationBuilder(TolerationFluent<?> fluent,Toleration instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Toleration build() {
    Toleration buildable = new Toleration(fluent.getEffect(), fluent.getKey(), fluent.getOperator(), fluent.getTolerationSeconds(), fluent.getValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}