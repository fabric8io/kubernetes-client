package io.fabric8.certmanager.api.model.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VenafiTPPBuilder extends VenafiTPPFluent<VenafiTPPBuilder> implements VisitableBuilder<VenafiTPP,VenafiTPPBuilder>{

  VenafiTPPFluent<?> fluent;

  public VenafiTPPBuilder() {
    this(new VenafiTPP());
  }
  
  public VenafiTPPBuilder(VenafiTPPFluent<?> fluent) {
    this(fluent, new VenafiTPP());
  }
  
  public VenafiTPPBuilder(VenafiTPP instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VenafiTPPBuilder(VenafiTPPFluent<?> fluent,VenafiTPP instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VenafiTPP build() {
    VenafiTPP buildable = new VenafiTPP(fluent.getCaBundle(), fluent.buildCaBundleSecretRef(), fluent.buildCredentialsRef(), fluent.getUrl());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}