package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IstioIngressListenerBuilder extends IstioIngressListenerFluent<IstioIngressListenerBuilder> implements VisitableBuilder<IstioIngressListener,IstioIngressListenerBuilder>{

  IstioIngressListenerFluent<?> fluent;

  public IstioIngressListenerBuilder() {
    this(new IstioIngressListener());
  }
  
  public IstioIngressListenerBuilder(IstioIngressListenerFluent<?> fluent) {
    this(fluent, new IstioIngressListener());
  }
  
  public IstioIngressListenerBuilder(IstioIngressListener instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IstioIngressListenerBuilder(IstioIngressListenerFluent<?> fluent,IstioIngressListener instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IstioIngressListener build() {
    IstioIngressListener buildable = new IstioIngressListener(fluent.getBind(), fluent.getCaptureMode(), fluent.buildConnectionPool(), fluent.getDefaultEndpoint(), fluent.buildPort(), fluent.buildTls());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}