package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TLSProfileSpecBuilder extends TLSProfileSpecFluent<TLSProfileSpecBuilder> implements VisitableBuilder<TLSProfileSpec,TLSProfileSpecBuilder>{

  TLSProfileSpecFluent<?> fluent;

  public TLSProfileSpecBuilder() {
    this(new TLSProfileSpec());
  }
  
  public TLSProfileSpecBuilder(TLSProfileSpecFluent<?> fluent) {
    this(fluent, new TLSProfileSpec());
  }
  
  public TLSProfileSpecBuilder(TLSProfileSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TLSProfileSpecBuilder(TLSProfileSpecFluent<?> fluent,TLSProfileSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TLSProfileSpec build() {
    TLSProfileSpec buildable = new TLSProfileSpec(fluent.getCiphers(), fluent.getMinTLSVersion());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}