package io.fabric8.certmanager.api.model.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VenafiIssuerBuilder extends VenafiIssuerFluent<VenafiIssuerBuilder> implements VisitableBuilder<VenafiIssuer,VenafiIssuerBuilder>{

  VenafiIssuerFluent<?> fluent;

  public VenafiIssuerBuilder() {
    this(new VenafiIssuer());
  }
  
  public VenafiIssuerBuilder(VenafiIssuerFluent<?> fluent) {
    this(fluent, new VenafiIssuer());
  }
  
  public VenafiIssuerBuilder(VenafiIssuer instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VenafiIssuerBuilder(VenafiIssuerFluent<?> fluent,VenafiIssuer instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VenafiIssuer build() {
    VenafiIssuer buildable = new VenafiIssuer(fluent.buildCloud(), fluent.buildTpp(), fluent.getZone());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}