package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GroupRestrictionBuilder extends GroupRestrictionFluent<GroupRestrictionBuilder> implements VisitableBuilder<GroupRestriction,GroupRestrictionBuilder>{

  GroupRestrictionFluent<?> fluent;

  public GroupRestrictionBuilder() {
    this(new GroupRestriction());
  }
  
  public GroupRestrictionBuilder(GroupRestrictionFluent<?> fluent) {
    this(fluent, new GroupRestriction());
  }
  
  public GroupRestrictionBuilder(GroupRestriction instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GroupRestrictionBuilder(GroupRestrictionFluent<?> fluent,GroupRestriction instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GroupRestriction build() {
    GroupRestriction buildable = new GroupRestriction(fluent.getGroups(), fluent.buildLabels());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}