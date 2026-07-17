package io.fabric8.openshift.api.model.installer.gcp.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DNSZoneParamsBuilder extends DNSZoneParamsFluent<DNSZoneParamsBuilder> implements VisitableBuilder<DNSZoneParams,DNSZoneParamsBuilder>{

  DNSZoneParamsFluent<?> fluent;

  public DNSZoneParamsBuilder() {
    this(new DNSZoneParams());
  }
  
  public DNSZoneParamsBuilder(DNSZoneParamsFluent<?> fluent) {
    this(fluent, new DNSZoneParams());
  }
  
  public DNSZoneParamsBuilder(DNSZoneParams instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DNSZoneParamsBuilder(DNSZoneParamsFluent<?> fluent,DNSZoneParams instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DNSZoneParams build() {
    DNSZoneParams buildable = new DNSZoneParams(fluent.getBaseDomain(), fluent.getInstallerCreated(), fluent.getIsPublic(), fluent.getName(), fluent.getProject());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}