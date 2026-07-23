package io.fabric8.openshift.api.model.machine.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SecurityGroupFilterBuilder extends SecurityGroupFilterFluent<SecurityGroupFilterBuilder> implements VisitableBuilder<SecurityGroupFilter,SecurityGroupFilterBuilder>{

  SecurityGroupFilterFluent<?> fluent;

  public SecurityGroupFilterBuilder() {
    this(new SecurityGroupFilter());
  }
  
  public SecurityGroupFilterBuilder(SecurityGroupFilterFluent<?> fluent) {
    this(fluent, new SecurityGroupFilter());
  }
  
  public SecurityGroupFilterBuilder(SecurityGroupFilter instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SecurityGroupFilterBuilder(SecurityGroupFilterFluent<?> fluent,SecurityGroupFilter instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SecurityGroupFilter build() {
    SecurityGroupFilter buildable = new SecurityGroupFilter(fluent.getDescription(), fluent.getId(), fluent.getLimit(), fluent.getMarker(), fluent.getName(), fluent.getNotTags(), fluent.getNotTagsAny(), fluent.getProjectId(), fluent.getSortDir(), fluent.getSortKey(), fluent.getTags(), fluent.getTagsAny(), fluent.getTenantId());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}