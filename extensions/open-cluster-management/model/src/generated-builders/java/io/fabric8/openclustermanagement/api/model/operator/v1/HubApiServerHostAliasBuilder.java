package io.fabric8.openclustermanagement.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HubApiServerHostAliasBuilder extends HubApiServerHostAliasFluent<HubApiServerHostAliasBuilder> implements VisitableBuilder<HubApiServerHostAlias,HubApiServerHostAliasBuilder>{

  HubApiServerHostAliasFluent<?> fluent;

  public HubApiServerHostAliasBuilder() {
    this(new HubApiServerHostAlias());
  }
  
  public HubApiServerHostAliasBuilder(HubApiServerHostAliasFluent<?> fluent) {
    this(fluent, new HubApiServerHostAlias());
  }
  
  public HubApiServerHostAliasBuilder(HubApiServerHostAlias instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HubApiServerHostAliasBuilder(HubApiServerHostAliasFluent<?> fluent,HubApiServerHostAlias instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HubApiServerHostAlias build() {
    HubApiServerHostAlias buildable = new HubApiServerHostAlias(fluent.getHostname(), fluent.getIp());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}