package io.fabric8.volcano.api.model.scheduling.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GuaranteeBuilder extends GuaranteeFluent<GuaranteeBuilder> implements VisitableBuilder<Guarantee,GuaranteeBuilder>{

  GuaranteeFluent<?> fluent;

  public GuaranteeBuilder() {
    this(new Guarantee());
  }
  
  public GuaranteeBuilder(GuaranteeFluent<?> fluent) {
    this(fluent, new Guarantee());
  }
  
  public GuaranteeBuilder(Guarantee instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GuaranteeBuilder(GuaranteeFluent<?> fluent,Guarantee instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Guarantee build() {
    Guarantee buildable = new Guarantee(fluent.getResource());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}