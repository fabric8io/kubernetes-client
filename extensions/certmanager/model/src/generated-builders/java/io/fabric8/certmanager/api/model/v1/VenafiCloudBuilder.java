package io.fabric8.certmanager.api.model.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VenafiCloudBuilder extends VenafiCloudFluent<VenafiCloudBuilder> implements VisitableBuilder<VenafiCloud,VenafiCloudBuilder>{

  VenafiCloudFluent<?> fluent;

  public VenafiCloudBuilder() {
    this(new VenafiCloud());
  }
  
  public VenafiCloudBuilder(VenafiCloudFluent<?> fluent) {
    this(fluent, new VenafiCloud());
  }
  
  public VenafiCloudBuilder(VenafiCloud instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VenafiCloudBuilder(VenafiCloudFluent<?> fluent,VenafiCloud instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VenafiCloud build() {
    VenafiCloud buildable = new VenafiCloud(fluent.buildApiTokenSecretRef(), fluent.getUrl());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}