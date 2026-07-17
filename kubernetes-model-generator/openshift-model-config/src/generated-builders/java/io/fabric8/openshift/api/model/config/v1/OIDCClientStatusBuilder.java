package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OIDCClientStatusBuilder extends OIDCClientStatusFluent<OIDCClientStatusBuilder> implements VisitableBuilder<OIDCClientStatus,OIDCClientStatusBuilder>{

  OIDCClientStatusFluent<?> fluent;

  public OIDCClientStatusBuilder() {
    this(new OIDCClientStatus());
  }
  
  public OIDCClientStatusBuilder(OIDCClientStatusFluent<?> fluent) {
    this(fluent, new OIDCClientStatus());
  }
  
  public OIDCClientStatusBuilder(OIDCClientStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OIDCClientStatusBuilder(OIDCClientStatusFluent<?> fluent,OIDCClientStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OIDCClientStatus build() {
    OIDCClientStatus buildable = new OIDCClientStatus(fluent.getComponentName(), fluent.getComponentNamespace(), fluent.getConditions(), fluent.getConsumingUsers(), fluent.buildCurrentOIDCClients());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}