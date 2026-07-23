package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SchemaReferenceBuilder extends SchemaReferenceFluent<SchemaReferenceBuilder> implements VisitableBuilder<SchemaReference,SchemaReferenceBuilder>{

  SchemaReferenceFluent<?> fluent;

  public SchemaReferenceBuilder() {
    this(new SchemaReference());
  }
  
  public SchemaReferenceBuilder(SchemaReferenceFluent<?> fluent) {
    this(fluent, new SchemaReference());
  }
  
  public SchemaReferenceBuilder(SchemaReference instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SchemaReferenceBuilder(SchemaReferenceFluent<?> fluent,SchemaReference instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SchemaReference build() {
    SchemaReference buildable = new SchemaReference(fluent.getName(), fluent.getNamespace());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}