package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HostAliasBuilder extends HostAliasFluent<HostAliasBuilder> implements VisitableBuilder<HostAlias,HostAliasBuilder>{

  HostAliasFluent<?> fluent;

  public HostAliasBuilder() {
    this(new HostAlias());
  }
  
  public HostAliasBuilder(HostAliasFluent<?> fluent) {
    this(fluent, new HostAlias());
  }
  
  public HostAliasBuilder(HostAlias instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HostAliasBuilder(HostAliasFluent<?> fluent,HostAlias instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HostAlias build() {
    HostAlias buildable = new HostAlias(fluent.getHostnames(), fluent.getIp());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}