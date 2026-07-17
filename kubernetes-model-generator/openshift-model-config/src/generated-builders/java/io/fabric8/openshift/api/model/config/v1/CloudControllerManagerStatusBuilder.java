package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CloudControllerManagerStatusBuilder extends CloudControllerManagerStatusFluent<CloudControllerManagerStatusBuilder> implements VisitableBuilder<CloudControllerManagerStatus,CloudControllerManagerStatusBuilder>{

  CloudControllerManagerStatusFluent<?> fluent;

  public CloudControllerManagerStatusBuilder() {
    this(new CloudControllerManagerStatus());
  }
  
  public CloudControllerManagerStatusBuilder(CloudControllerManagerStatusFluent<?> fluent) {
    this(fluent, new CloudControllerManagerStatus());
  }
  
  public CloudControllerManagerStatusBuilder(CloudControllerManagerStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CloudControllerManagerStatusBuilder(CloudControllerManagerStatusFluent<?> fluent,CloudControllerManagerStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CloudControllerManagerStatus build() {
    CloudControllerManagerStatus buildable = new CloudControllerManagerStatus(fluent.getState());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}