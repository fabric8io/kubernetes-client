package io.fabric8.openshift.api.model.machine.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SubnetFilterBuilder extends SubnetFilterFluent<SubnetFilterBuilder> implements VisitableBuilder<SubnetFilter,SubnetFilterBuilder>{

  SubnetFilterFluent<?> fluent;

  public SubnetFilterBuilder() {
    this(new SubnetFilter());
  }
  
  public SubnetFilterBuilder(SubnetFilterFluent<?> fluent) {
    this(fluent, new SubnetFilter());
  }
  
  public SubnetFilterBuilder(SubnetFilter instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SubnetFilterBuilder(SubnetFilterFluent<?> fluent,SubnetFilter instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SubnetFilter build() {
    SubnetFilter buildable = new SubnetFilter(fluent.getCidr(), fluent.getDescription(), fluent.getEnableDhcp(), fluent.getGatewayIp(), fluent.getId(), fluent.getIpVersion(), fluent.getIpv6AddressMode(), fluent.getIpv6RaMode(), fluent.getLimit(), fluent.getMarker(), fluent.getName(), fluent.getNetworkId(), fluent.getNotTags(), fluent.getNotTagsAny(), fluent.getProjectId(), fluent.getSortDir(), fluent.getSortKey(), fluent.getSubnetpoolId(), fluent.getTags(), fluent.getTagsAny(), fluent.getTenantId());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}