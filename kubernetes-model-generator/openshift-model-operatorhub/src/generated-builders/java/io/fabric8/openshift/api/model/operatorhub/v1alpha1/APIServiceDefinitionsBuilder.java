package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class APIServiceDefinitionsBuilder extends APIServiceDefinitionsFluent<APIServiceDefinitionsBuilder> implements VisitableBuilder<APIServiceDefinitions,APIServiceDefinitionsBuilder>{

  APIServiceDefinitionsFluent<?> fluent;

  public APIServiceDefinitionsBuilder() {
    this(new APIServiceDefinitions());
  }
  
  public APIServiceDefinitionsBuilder(APIServiceDefinitionsFluent<?> fluent) {
    this(fluent, new APIServiceDefinitions());
  }
  
  public APIServiceDefinitionsBuilder(APIServiceDefinitions instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public APIServiceDefinitionsBuilder(APIServiceDefinitionsFluent<?> fluent,APIServiceDefinitions instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public APIServiceDefinitions build() {
    APIServiceDefinitions buildable = new APIServiceDefinitions(fluent.buildOwned(), fluent.buildRequired());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}