package io.fabric8.openclustermanagement.api.model.observability.v1beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class InstrumentationSpecBuilder extends InstrumentationSpecFluent<InstrumentationSpecBuilder> implements VisitableBuilder<InstrumentationSpec,InstrumentationSpecBuilder>{

  InstrumentationSpecFluent<?> fluent;

  public InstrumentationSpecBuilder() {
    this(new InstrumentationSpec());
  }
  
  public InstrumentationSpecBuilder(InstrumentationSpecFluent<?> fluent) {
    this(fluent, new InstrumentationSpec());
  }
  
  public InstrumentationSpecBuilder(InstrumentationSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public InstrumentationSpecBuilder(InstrumentationSpecFluent<?> fluent,InstrumentationSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public InstrumentationSpec build() {
    InstrumentationSpec buildable = new InstrumentationSpec(fluent.getEnabled());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}