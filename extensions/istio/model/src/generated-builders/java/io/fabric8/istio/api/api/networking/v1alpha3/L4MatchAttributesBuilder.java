package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class L4MatchAttributesBuilder extends L4MatchAttributesFluent<L4MatchAttributesBuilder> implements VisitableBuilder<L4MatchAttributes,L4MatchAttributesBuilder>{

  L4MatchAttributesFluent<?> fluent;

  public L4MatchAttributesBuilder() {
    this(new L4MatchAttributes());
  }
  
  public L4MatchAttributesBuilder(L4MatchAttributesFluent<?> fluent) {
    this(fluent, new L4MatchAttributes());
  }
  
  public L4MatchAttributesBuilder(L4MatchAttributes instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public L4MatchAttributesBuilder(L4MatchAttributesFluent<?> fluent,L4MatchAttributes instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public L4MatchAttributes build() {
    L4MatchAttributes buildable = new L4MatchAttributes(fluent.getDestinationSubnets(), fluent.getGateways(), fluent.getPort(), fluent.getSourceLabels(), fluent.getSourceNamespace(), fluent.getSourceSubnet());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}