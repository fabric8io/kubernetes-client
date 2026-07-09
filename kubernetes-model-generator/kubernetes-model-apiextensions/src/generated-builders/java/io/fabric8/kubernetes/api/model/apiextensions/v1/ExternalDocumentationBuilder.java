package io.fabric8.kubernetes.api.model.apiextensions.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ExternalDocumentationBuilder extends ExternalDocumentationFluent<ExternalDocumentationBuilder> implements VisitableBuilder<ExternalDocumentation,ExternalDocumentationBuilder>{

  ExternalDocumentationFluent<?> fluent;

  public ExternalDocumentationBuilder() {
    this(new ExternalDocumentation());
  }
  
  public ExternalDocumentationBuilder(ExternalDocumentationFluent<?> fluent) {
    this(fluent, new ExternalDocumentation());
  }
  
  public ExternalDocumentationBuilder(ExternalDocumentation instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ExternalDocumentationBuilder(ExternalDocumentationFluent<?> fluent,ExternalDocumentation instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ExternalDocumentation build() {
    ExternalDocumentation buildable = new ExternalDocumentation(fluent.getDescription(), fluent.getUrl());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}