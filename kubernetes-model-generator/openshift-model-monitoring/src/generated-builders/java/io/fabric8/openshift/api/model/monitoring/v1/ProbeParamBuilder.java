package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ProbeParamBuilder extends ProbeParamFluent<ProbeParamBuilder> implements VisitableBuilder<ProbeParam,ProbeParamBuilder>{

  ProbeParamFluent<?> fluent;

  public ProbeParamBuilder() {
    this(new ProbeParam());
  }
  
  public ProbeParamBuilder(ProbeParamFluent<?> fluent) {
    this(fluent, new ProbeParam());
  }
  
  public ProbeParamBuilder(ProbeParam instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ProbeParamBuilder(ProbeParamFluent<?> fluent,ProbeParam instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ProbeParam build() {
    ProbeParam buildable = new ProbeParam(fluent.getName(), fluent.getValues());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}