package io.fabric8.kubernetes.api.model.batch.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CronJobBuilder extends CronJobFluent<CronJobBuilder> implements VisitableBuilder<CronJob,CronJobBuilder>{

  CronJobFluent<?> fluent;

  public CronJobBuilder() {
    this(new CronJob());
  }
  
  public CronJobBuilder(CronJobFluent<?> fluent) {
    this(fluent, new CronJob());
  }
  
  public CronJobBuilder(CronJob instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CronJobBuilder(CronJobFluent<?> fluent,CronJob instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CronJob build() {
    CronJob buildable = new CronJob(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}