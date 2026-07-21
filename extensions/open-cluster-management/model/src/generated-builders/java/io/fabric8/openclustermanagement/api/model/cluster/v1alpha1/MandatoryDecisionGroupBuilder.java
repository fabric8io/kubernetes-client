package io.fabric8.openclustermanagement.api.model.cluster.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MandatoryDecisionGroupBuilder extends MandatoryDecisionGroupFluent<MandatoryDecisionGroupBuilder> implements VisitableBuilder<MandatoryDecisionGroup,MandatoryDecisionGroupBuilder>{

  MandatoryDecisionGroupFluent<?> fluent;

  public MandatoryDecisionGroupBuilder() {
    this(new MandatoryDecisionGroup());
  }
  
  public MandatoryDecisionGroupBuilder(MandatoryDecisionGroupFluent<?> fluent) {
    this(fluent, new MandatoryDecisionGroup());
  }
  
  public MandatoryDecisionGroupBuilder(MandatoryDecisionGroup instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MandatoryDecisionGroupBuilder(MandatoryDecisionGroupFluent<?> fluent,MandatoryDecisionGroup instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MandatoryDecisionGroup build() {
    MandatoryDecisionGroup buildable = new MandatoryDecisionGroup(fluent.getGroupIndex(), fluent.getGroupName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}