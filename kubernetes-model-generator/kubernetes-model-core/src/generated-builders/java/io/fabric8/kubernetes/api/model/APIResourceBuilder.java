package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class APIResourceBuilder extends APIResourceFluent<APIResourceBuilder> implements VisitableBuilder<APIResource,APIResourceBuilder>{

  APIResourceFluent<?> fluent;

  public APIResourceBuilder() {
    this(new APIResource());
  }
  
  public APIResourceBuilder(APIResourceFluent<?> fluent) {
    this(fluent, new APIResource());
  }
  
  public APIResourceBuilder(APIResource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public APIResourceBuilder(APIResourceFluent<?> fluent,APIResource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public APIResource build() {
    APIResource buildable = new APIResource(fluent.getCategories(), fluent.getGroup(), fluent.getKind(), fluent.getName(), fluent.getNamespaced(), fluent.getShortNames(), fluent.getSingularName(), fluent.getStorageVersionHash(), fluent.getVerbs(), fluent.getVersion());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}