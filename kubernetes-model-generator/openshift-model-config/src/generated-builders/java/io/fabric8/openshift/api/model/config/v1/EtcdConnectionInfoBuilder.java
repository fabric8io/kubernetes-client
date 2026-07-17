package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EtcdConnectionInfoBuilder extends EtcdConnectionInfoFluent<EtcdConnectionInfoBuilder> implements VisitableBuilder<EtcdConnectionInfo,EtcdConnectionInfoBuilder>{

  EtcdConnectionInfoFluent<?> fluent;

  public EtcdConnectionInfoBuilder() {
    this(new EtcdConnectionInfo());
  }
  
  public EtcdConnectionInfoBuilder(EtcdConnectionInfoFluent<?> fluent) {
    this(fluent, new EtcdConnectionInfo());
  }
  
  public EtcdConnectionInfoBuilder(EtcdConnectionInfo instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EtcdConnectionInfoBuilder(EtcdConnectionInfoFluent<?> fluent,EtcdConnectionInfo instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EtcdConnectionInfo build() {
    EtcdConnectionInfo buildable = new EtcdConnectionInfo(fluent.getCa(), fluent.getCertFile(), fluent.getKeyFile(), fluent.getUrls());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}