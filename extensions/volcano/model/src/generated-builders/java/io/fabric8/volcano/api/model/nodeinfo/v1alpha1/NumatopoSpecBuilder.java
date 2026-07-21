package io.fabric8.volcano.api.model.nodeinfo.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NumatopoSpecBuilder extends NumatopoSpecFluent<NumatopoSpecBuilder> implements VisitableBuilder<NumatopoSpec,NumatopoSpecBuilder>{

  NumatopoSpecFluent<?> fluent;

  public NumatopoSpecBuilder() {
    this(new NumatopoSpec());
  }
  
  public NumatopoSpecBuilder(NumatopoSpecFluent<?> fluent) {
    this(fluent, new NumatopoSpec());
  }
  
  public NumatopoSpecBuilder(NumatopoSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NumatopoSpecBuilder(NumatopoSpecFluent<?> fluent,NumatopoSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NumatopoSpec build() {
    NumatopoSpec buildable = new NumatopoSpec(fluent.getCpuDetail(), fluent.getNumares(), fluent.getPolicies(), fluent.getResReserved());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}