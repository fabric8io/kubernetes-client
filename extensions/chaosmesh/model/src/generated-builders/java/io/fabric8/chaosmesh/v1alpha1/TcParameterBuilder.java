package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TcParameterBuilder extends TcParameterFluent<TcParameterBuilder> implements VisitableBuilder<TcParameter,TcParameterBuilder>{

  TcParameterFluent<?> fluent;

  public TcParameterBuilder() {
    this(new TcParameter());
  }
  
  public TcParameterBuilder(TcParameterFluent<?> fluent) {
    this(fluent, new TcParameter());
  }
  
  public TcParameterBuilder(TcParameter instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TcParameterBuilder(TcParameterFluent<?> fluent,TcParameter instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TcParameter build() {
    TcParameter buildable = new TcParameter(fluent.buildBandwidth(), fluent.buildCorrupt(), fluent.buildDelay(), fluent.buildDuplicate(), fluent.buildLoss(), fluent.buildRate());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}