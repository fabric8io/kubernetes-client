package io.fabric8.openclustermanagement.api.model.apps.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AnsibleJobsStatusBuilder extends AnsibleJobsStatusFluent<AnsibleJobsStatusBuilder> implements VisitableBuilder<AnsibleJobsStatus,AnsibleJobsStatusBuilder>{

  AnsibleJobsStatusFluent<?> fluent;

  public AnsibleJobsStatusBuilder() {
    this(new AnsibleJobsStatus());
  }
  
  public AnsibleJobsStatusBuilder(AnsibleJobsStatusFluent<?> fluent) {
    this(fluent, new AnsibleJobsStatus());
  }
  
  public AnsibleJobsStatusBuilder(AnsibleJobsStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AnsibleJobsStatusBuilder(AnsibleJobsStatusFluent<?> fluent,AnsibleJobsStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AnsibleJobsStatus build() {
    AnsibleJobsStatus buildable = new AnsibleJobsStatus(fluent.getLastposthookjob(), fluent.getLastprehookjob(), fluent.getPosthookjobshistory(), fluent.getPrehookjobshistory());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}