package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HostIPBuilder extends HostIPFluent<HostIPBuilder> implements VisitableBuilder<HostIP,HostIPBuilder>{

  HostIPFluent<?> fluent;

  public HostIPBuilder() {
    this(new HostIP());
  }
  
  public HostIPBuilder(HostIPFluent<?> fluent) {
    this(fluent, new HostIP());
  }
  
  public HostIPBuilder(HostIP instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HostIPBuilder(HostIPFluent<?> fluent,HostIP instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HostIP build() {
    HostIP buildable = new HostIP(fluent.getIp());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}