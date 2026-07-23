package io.fabric8.openshift.api.model.miscellaneous.cloudcredential.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VSpherePermissionBuilder extends VSpherePermissionFluent<VSpherePermissionBuilder> implements VisitableBuilder<VSpherePermission,VSpherePermissionBuilder>{

  VSpherePermissionFluent<?> fluent;

  public VSpherePermissionBuilder() {
    this(new VSpherePermission());
  }
  
  public VSpherePermissionBuilder(VSpherePermissionFluent<?> fluent) {
    this(fluent, new VSpherePermission());
  }
  
  public VSpherePermissionBuilder(VSpherePermission instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VSpherePermissionBuilder(VSpherePermissionFluent<?> fluent,VSpherePermission instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VSpherePermission build() {
    VSpherePermission buildable = new VSpherePermission(fluent.getPrivileges());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}