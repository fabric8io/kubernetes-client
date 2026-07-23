package io.fabric8.kubernetes.api.model.networking.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IPBlockBuilder extends IPBlockFluent<IPBlockBuilder> implements VisitableBuilder<IPBlock,IPBlockBuilder>{

  IPBlockFluent<?> fluent;

  public IPBlockBuilder() {
    this(new IPBlock());
  }
  
  public IPBlockBuilder(IPBlockFluent<?> fluent) {
    this(fluent, new IPBlock());
  }
  
  public IPBlockBuilder(IPBlock instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IPBlockBuilder(IPBlockFluent<?> fluent,IPBlock instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IPBlock build() {
    IPBlock buildable = new IPBlock(fluent.getCidr(), fluent.getExcept());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}