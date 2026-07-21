package io.fabric8.tekton.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class WorkspaceDeclarationBuilder extends WorkspaceDeclarationFluent<WorkspaceDeclarationBuilder> implements VisitableBuilder<WorkspaceDeclaration,WorkspaceDeclarationBuilder>{

  WorkspaceDeclarationFluent<?> fluent;

  public WorkspaceDeclarationBuilder() {
    this(new WorkspaceDeclaration());
  }
  
  public WorkspaceDeclarationBuilder(WorkspaceDeclarationFluent<?> fluent) {
    this(fluent, new WorkspaceDeclaration());
  }
  
  public WorkspaceDeclarationBuilder(WorkspaceDeclaration instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public WorkspaceDeclarationBuilder(WorkspaceDeclarationFluent<?> fluent,WorkspaceDeclaration instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public WorkspaceDeclaration build() {
    WorkspaceDeclaration buildable = new WorkspaceDeclaration(fluent.getDescription(), fluent.getMountPath(), fluent.getName(), fluent.getOptional(), fluent.getReadOnly());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}