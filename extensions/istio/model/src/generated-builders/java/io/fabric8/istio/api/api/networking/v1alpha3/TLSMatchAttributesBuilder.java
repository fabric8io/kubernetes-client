package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TLSMatchAttributesBuilder extends TLSMatchAttributesFluent<TLSMatchAttributesBuilder> implements VisitableBuilder<TLSMatchAttributes,TLSMatchAttributesBuilder>{

  TLSMatchAttributesFluent<?> fluent;

  public TLSMatchAttributesBuilder() {
    this(new TLSMatchAttributes());
  }
  
  public TLSMatchAttributesBuilder(TLSMatchAttributesFluent<?> fluent) {
    this(fluent, new TLSMatchAttributes());
  }
  
  public TLSMatchAttributesBuilder(TLSMatchAttributes instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TLSMatchAttributesBuilder(TLSMatchAttributesFluent<?> fluent,TLSMatchAttributes instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TLSMatchAttributes build() {
    TLSMatchAttributes buildable = new TLSMatchAttributes(fluent.getDestinationSubnets(), fluent.getGateways(), fluent.getPort(), fluent.getSniHosts(), fluent.getSourceLabels(), fluent.getSourceNamespace());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}