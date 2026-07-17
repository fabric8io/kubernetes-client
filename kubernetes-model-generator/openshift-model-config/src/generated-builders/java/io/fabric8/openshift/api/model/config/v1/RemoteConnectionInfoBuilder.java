package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RemoteConnectionInfoBuilder extends RemoteConnectionInfoFluent<RemoteConnectionInfoBuilder> implements VisitableBuilder<RemoteConnectionInfo,RemoteConnectionInfoBuilder>{

  RemoteConnectionInfoFluent<?> fluent;

  public RemoteConnectionInfoBuilder() {
    this(new RemoteConnectionInfo());
  }
  
  public RemoteConnectionInfoBuilder(RemoteConnectionInfoFluent<?> fluent) {
    this(fluent, new RemoteConnectionInfo());
  }
  
  public RemoteConnectionInfoBuilder(RemoteConnectionInfo instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RemoteConnectionInfoBuilder(RemoteConnectionInfoFluent<?> fluent,RemoteConnectionInfo instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RemoteConnectionInfo build() {
    RemoteConnectionInfo buildable = new RemoteConnectionInfo(fluent.getCa(), fluent.getCertFile(), fluent.getKeyFile(), fluent.getUrl());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}