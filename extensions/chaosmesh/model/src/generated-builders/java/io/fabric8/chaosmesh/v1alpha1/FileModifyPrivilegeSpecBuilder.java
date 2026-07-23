package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class FileModifyPrivilegeSpecBuilder extends FileModifyPrivilegeSpecFluent<FileModifyPrivilegeSpecBuilder> implements VisitableBuilder<FileModifyPrivilegeSpec,FileModifyPrivilegeSpecBuilder>{

  FileModifyPrivilegeSpecFluent<?> fluent;

  public FileModifyPrivilegeSpecBuilder() {
    this(new FileModifyPrivilegeSpec());
  }
  
  public FileModifyPrivilegeSpecBuilder(FileModifyPrivilegeSpecFluent<?> fluent) {
    this(fluent, new FileModifyPrivilegeSpec());
  }
  
  public FileModifyPrivilegeSpecBuilder(FileModifyPrivilegeSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public FileModifyPrivilegeSpecBuilder(FileModifyPrivilegeSpecFluent<?> fluent,FileModifyPrivilegeSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public FileModifyPrivilegeSpec build() {
    FileModifyPrivilegeSpec buildable = new FileModifyPrivilegeSpec(fluent.getFileName(), fluent.getPrivilege());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}