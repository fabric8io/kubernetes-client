package io.fabric8.kubernetes.api.model.batch.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CronJobStatusBuilder extends CronJobStatusFluent<CronJobStatusBuilder> implements VisitableBuilder<CronJobStatus,CronJobStatusBuilder>{

  CronJobStatusFluent<?> fluent;

  public CronJobStatusBuilder() {
    this(new CronJobStatus());
  }
  
  public CronJobStatusBuilder(CronJobStatusFluent<?> fluent) {
    this(fluent, new CronJobStatus());
  }
  
  public CronJobStatusBuilder(CronJobStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CronJobStatusBuilder(CronJobStatusFluent<?> fluent,CronJobStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CronJobStatus build() {
    CronJobStatus buildable = new CronJobStatus(fluent.buildActive(), fluent.getLastScheduleTime(), fluent.getLastSuccessfulTime());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}