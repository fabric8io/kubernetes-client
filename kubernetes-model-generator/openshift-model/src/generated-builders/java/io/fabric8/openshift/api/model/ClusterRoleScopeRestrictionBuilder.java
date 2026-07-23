package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterRoleScopeRestrictionBuilder extends ClusterRoleScopeRestrictionFluent<ClusterRoleScopeRestrictionBuilder> implements VisitableBuilder<ClusterRoleScopeRestriction,ClusterRoleScopeRestrictionBuilder>{

  ClusterRoleScopeRestrictionFluent<?> fluent;

  public ClusterRoleScopeRestrictionBuilder() {
    this(new ClusterRoleScopeRestriction());
  }
  
  public ClusterRoleScopeRestrictionBuilder(ClusterRoleScopeRestrictionFluent<?> fluent) {
    this(fluent, new ClusterRoleScopeRestriction());
  }
  
  public ClusterRoleScopeRestrictionBuilder(ClusterRoleScopeRestriction instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterRoleScopeRestrictionBuilder(ClusterRoleScopeRestrictionFluent<?> fluent,ClusterRoleScopeRestriction instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterRoleScopeRestriction build() {
    ClusterRoleScopeRestriction buildable = new ClusterRoleScopeRestriction(fluent.getAllowEscalation(), fluent.getNamespaces(), fluent.getRoleNames());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}