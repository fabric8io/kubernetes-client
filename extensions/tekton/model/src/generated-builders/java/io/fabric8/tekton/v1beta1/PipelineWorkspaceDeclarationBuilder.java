package io.fabric8.tekton.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PipelineWorkspaceDeclarationBuilder extends PipelineWorkspaceDeclarationFluent<PipelineWorkspaceDeclarationBuilder> implements VisitableBuilder<PipelineWorkspaceDeclaration,PipelineWorkspaceDeclarationBuilder>{

  PipelineWorkspaceDeclarationFluent<?> fluent;

  public PipelineWorkspaceDeclarationBuilder() {
    this(new PipelineWorkspaceDeclaration());
  }
  
  public PipelineWorkspaceDeclarationBuilder(PipelineWorkspaceDeclarationFluent<?> fluent) {
    this(fluent, new PipelineWorkspaceDeclaration());
  }
  
  public PipelineWorkspaceDeclarationBuilder(PipelineWorkspaceDeclaration instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PipelineWorkspaceDeclarationBuilder(PipelineWorkspaceDeclarationFluent<?> fluent,PipelineWorkspaceDeclaration instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PipelineWorkspaceDeclaration build() {
    PipelineWorkspaceDeclaration buildable = new PipelineWorkspaceDeclaration(fluent.getDescription(), fluent.getName(), fluent.getOptional());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}