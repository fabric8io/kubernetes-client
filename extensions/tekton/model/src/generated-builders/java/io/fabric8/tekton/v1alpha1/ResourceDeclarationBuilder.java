package io.fabric8.tekton.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ResourceDeclarationBuilder extends ResourceDeclarationFluent<ResourceDeclarationBuilder> implements VisitableBuilder<ResourceDeclaration,ResourceDeclarationBuilder>{

  ResourceDeclarationFluent<?> fluent;

  public ResourceDeclarationBuilder() {
    this(new ResourceDeclaration());
  }
  
  public ResourceDeclarationBuilder(ResourceDeclarationFluent<?> fluent) {
    this(fluent, new ResourceDeclaration());
  }
  
  public ResourceDeclarationBuilder(ResourceDeclaration instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ResourceDeclarationBuilder(ResourceDeclarationFluent<?> fluent,ResourceDeclaration instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ResourceDeclaration build() {
    ResourceDeclaration buildable = new ResourceDeclaration(fluent.getDescription(), fluent.getName(), fluent.getOptional(), fluent.getTargetPath(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}