package io.fabric8.certmanager.api.model.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VenafiNGTSBuilder extends VenafiNGTSFluent<VenafiNGTSBuilder> implements VisitableBuilder<VenafiNGTS,VenafiNGTSBuilder>{

  VenafiNGTSFluent<?> fluent;

  public VenafiNGTSBuilder() {
    this(new VenafiNGTS());
  }
  
  public VenafiNGTSBuilder(VenafiNGTSFluent<?> fluent) {
    this(fluent, new VenafiNGTS());
  }
  
  public VenafiNGTSBuilder(VenafiNGTS instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VenafiNGTSBuilder(VenafiNGTSFluent<?> fluent,VenafiNGTS instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VenafiNGTS build() {
    VenafiNGTS buildable = new VenafiNGTS(fluent.buildCredentialsRef(), fluent.getTokenEndpoint(), fluent.getTsgID(), fluent.getUrl());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}