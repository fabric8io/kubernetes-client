package io.fabric8.openclustermanagement.api.model.cluster.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MandatoryDecisionGroupsBuilder extends MandatoryDecisionGroupsFluent<MandatoryDecisionGroupsBuilder> implements VisitableBuilder<MandatoryDecisionGroups,MandatoryDecisionGroupsBuilder>{

  MandatoryDecisionGroupsFluent<?> fluent;

  public MandatoryDecisionGroupsBuilder() {
    this(new MandatoryDecisionGroups());
  }
  
  public MandatoryDecisionGroupsBuilder(MandatoryDecisionGroupsFluent<?> fluent) {
    this(fluent, new MandatoryDecisionGroups());
  }
  
  public MandatoryDecisionGroupsBuilder(MandatoryDecisionGroups instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MandatoryDecisionGroupsBuilder(MandatoryDecisionGroupsFluent<?> fluent,MandatoryDecisionGroups instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MandatoryDecisionGroups build() {
    MandatoryDecisionGroups buildable = new MandatoryDecisionGroups(fluent.buildMandatoryDecisionGroups());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}