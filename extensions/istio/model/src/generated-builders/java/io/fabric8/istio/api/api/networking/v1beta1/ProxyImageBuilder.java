package io.fabric8.istio.api.api.networking.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ProxyImageBuilder extends ProxyImageFluent<ProxyImageBuilder> implements VisitableBuilder<ProxyImage,ProxyImageBuilder>{

  ProxyImageFluent<?> fluent;

  public ProxyImageBuilder() {
    this(new ProxyImage());
  }
  
  public ProxyImageBuilder(ProxyImageFluent<?> fluent) {
    this(fluent, new ProxyImage());
  }
  
  public ProxyImageBuilder(ProxyImage instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ProxyImageBuilder(ProxyImageFluent<?> fluent,ProxyImage instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ProxyImage build() {
    ProxyImage buildable = new ProxyImage(fluent.getImageType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}