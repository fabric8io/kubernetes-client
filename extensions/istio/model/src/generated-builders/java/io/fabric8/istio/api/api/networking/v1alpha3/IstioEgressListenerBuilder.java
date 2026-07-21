package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IstioEgressListenerBuilder extends IstioEgressListenerFluent<IstioEgressListenerBuilder> implements VisitableBuilder<IstioEgressListener,IstioEgressListenerBuilder>{

  IstioEgressListenerFluent<?> fluent;

  public IstioEgressListenerBuilder() {
    this(new IstioEgressListener());
  }
  
  public IstioEgressListenerBuilder(IstioEgressListenerFluent<?> fluent) {
    this(fluent, new IstioEgressListener());
  }
  
  public IstioEgressListenerBuilder(IstioEgressListener instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IstioEgressListenerBuilder(IstioEgressListenerFluent<?> fluent,IstioEgressListener instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IstioEgressListener build() {
    IstioEgressListener buildable = new IstioEgressListener(fluent.getBind(), fluent.getCaptureMode(), fluent.getHosts(), fluent.buildPort());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}