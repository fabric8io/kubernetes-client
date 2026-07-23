package io.fabric8.kubernetes.api.model.batch.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CronJobSpecBuilder extends CronJobSpecFluent<CronJobSpecBuilder> implements VisitableBuilder<CronJobSpec,CronJobSpecBuilder>{

  CronJobSpecFluent<?> fluent;

  public CronJobSpecBuilder() {
    this(new CronJobSpec());
  }
  
  public CronJobSpecBuilder(CronJobSpecFluent<?> fluent) {
    this(fluent, new CronJobSpec());
  }
  
  public CronJobSpecBuilder(CronJobSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CronJobSpecBuilder(CronJobSpecFluent<?> fluent,CronJobSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CronJobSpec build() {
    CronJobSpec buildable = new CronJobSpec(fluent.getConcurrencyPolicy(), fluent.getFailedJobsHistoryLimit(), fluent.buildJobTemplate(), fluent.getSchedule(), fluent.getStartingDeadlineSeconds(), fluent.getSuccessfulJobsHistoryLimit(), fluent.getSuspend());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}