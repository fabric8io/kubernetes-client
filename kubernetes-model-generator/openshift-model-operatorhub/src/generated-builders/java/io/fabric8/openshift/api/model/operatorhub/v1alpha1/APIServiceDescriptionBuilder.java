package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class APIServiceDescriptionBuilder extends APIServiceDescriptionFluent<APIServiceDescriptionBuilder> implements VisitableBuilder<APIServiceDescription,APIServiceDescriptionBuilder>{

  APIServiceDescriptionFluent<?> fluent;

  public APIServiceDescriptionBuilder() {
    this(new APIServiceDescription());
  }
  
  public APIServiceDescriptionBuilder(APIServiceDescriptionFluent<?> fluent) {
    this(fluent, new APIServiceDescription());
  }
  
  public APIServiceDescriptionBuilder(APIServiceDescription instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public APIServiceDescriptionBuilder(APIServiceDescriptionFluent<?> fluent,APIServiceDescription instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public APIServiceDescription build() {
    APIServiceDescription buildable = new APIServiceDescription(fluent.buildActionDescriptors(), fluent.getContainerPort(), fluent.getDeploymentName(), fluent.getDescription(), fluent.getDisplayName(), fluent.getGroup(), fluent.getKind(), fluent.getName(), fluent.buildResources(), fluent.buildSpecDescriptors(), fluent.buildStatusDescriptors(), fluent.getVersion());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}