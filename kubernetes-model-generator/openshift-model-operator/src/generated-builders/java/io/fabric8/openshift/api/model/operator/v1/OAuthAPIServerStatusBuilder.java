package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OAuthAPIServerStatusBuilder extends OAuthAPIServerStatusFluent<OAuthAPIServerStatusBuilder> implements VisitableBuilder<OAuthAPIServerStatus,OAuthAPIServerStatusBuilder>{

  OAuthAPIServerStatusFluent<?> fluent;

  public OAuthAPIServerStatusBuilder() {
    this(new OAuthAPIServerStatus());
  }
  
  public OAuthAPIServerStatusBuilder(OAuthAPIServerStatusFluent<?> fluent) {
    this(fluent, new OAuthAPIServerStatus());
  }
  
  public OAuthAPIServerStatusBuilder(OAuthAPIServerStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OAuthAPIServerStatusBuilder(OAuthAPIServerStatusFluent<?> fluent,OAuthAPIServerStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OAuthAPIServerStatus build() {
    OAuthAPIServerStatus buildable = new OAuthAPIServerStatus(fluent.getLatestAvailableRevision());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}