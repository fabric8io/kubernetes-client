package io.fabric8.openshift.api.model.miscellaneous.cncf.cni.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NoK8sNetworkErrorBuilder extends NoK8sNetworkErrorFluent<NoK8sNetworkErrorBuilder> implements VisitableBuilder<NoK8sNetworkError,NoK8sNetworkErrorBuilder>{

  NoK8sNetworkErrorFluent<?> fluent;

  public NoK8sNetworkErrorBuilder() {
    this(new NoK8sNetworkError());
  }
  
  public NoK8sNetworkErrorBuilder(NoK8sNetworkErrorFluent<?> fluent) {
    this(fluent, new NoK8sNetworkError());
  }
  
  public NoK8sNetworkErrorBuilder(NoK8sNetworkError instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NoK8sNetworkErrorBuilder(NoK8sNetworkErrorFluent<?> fluent,NoK8sNetworkError instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NoK8sNetworkError build() {
    NoK8sNetworkError buildable = new NoK8sNetworkError(fluent.getMessage());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}