package io.fabric8.openshift.api.model.monitoring.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OpsGenieConfigResponderBuilder extends OpsGenieConfigResponderFluent<OpsGenieConfigResponderBuilder> implements VisitableBuilder<OpsGenieConfigResponder,OpsGenieConfigResponderBuilder>{

  OpsGenieConfigResponderFluent<?> fluent;

  public OpsGenieConfigResponderBuilder() {
    this(new OpsGenieConfigResponder());
  }
  
  public OpsGenieConfigResponderBuilder(OpsGenieConfigResponderFluent<?> fluent) {
    this(fluent, new OpsGenieConfigResponder());
  }
  
  public OpsGenieConfigResponderBuilder(OpsGenieConfigResponder instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OpsGenieConfigResponderBuilder(OpsGenieConfigResponderFluent<?> fluent,OpsGenieConfigResponder instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OpsGenieConfigResponder build() {
    OpsGenieConfigResponder buildable = new OpsGenieConfigResponder(fluent.getId(), fluent.getName(), fluent.getType(), fluent.getUsername());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}