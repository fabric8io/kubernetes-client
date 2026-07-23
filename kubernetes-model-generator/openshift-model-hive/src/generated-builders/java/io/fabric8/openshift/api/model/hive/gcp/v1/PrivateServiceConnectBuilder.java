package io.fabric8.openshift.api.model.hive.gcp.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PrivateServiceConnectBuilder extends PrivateServiceConnectFluent<PrivateServiceConnectBuilder> implements VisitableBuilder<PrivateServiceConnect,PrivateServiceConnectBuilder>{

  PrivateServiceConnectFluent<?> fluent;

  public PrivateServiceConnectBuilder() {
    this(new PrivateServiceConnect());
  }
  
  public PrivateServiceConnectBuilder(PrivateServiceConnectFluent<?> fluent) {
    this(fluent, new PrivateServiceConnect());
  }
  
  public PrivateServiceConnectBuilder(PrivateServiceConnect instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PrivateServiceConnectBuilder(PrivateServiceConnectFluent<?> fluent,PrivateServiceConnect instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PrivateServiceConnect build() {
    PrivateServiceConnect buildable = new PrivateServiceConnect(fluent.getEnabled(), fluent.buildServiceAttachment());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}