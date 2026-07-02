package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VolumeResourceRequirementsBuilder extends VolumeResourceRequirementsFluent<VolumeResourceRequirementsBuilder> implements VisitableBuilder<VolumeResourceRequirements,VolumeResourceRequirementsBuilder>{

  VolumeResourceRequirementsFluent<?> fluent;

  public VolumeResourceRequirementsBuilder() {
    this(new VolumeResourceRequirements());
  }
  
  public VolumeResourceRequirementsBuilder(VolumeResourceRequirementsFluent<?> fluent) {
    this(fluent, new VolumeResourceRequirements());
  }
  
  public VolumeResourceRequirementsBuilder(VolumeResourceRequirements instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VolumeResourceRequirementsBuilder(VolumeResourceRequirementsFluent<?> fluent,VolumeResourceRequirements instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VolumeResourceRequirements build() {
    VolumeResourceRequirements buildable = new VolumeResourceRequirements(fluent.getLimits(), fluent.getRequests());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}