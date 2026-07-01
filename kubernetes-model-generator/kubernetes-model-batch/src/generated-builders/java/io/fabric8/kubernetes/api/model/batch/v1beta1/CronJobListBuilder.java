package io.fabric8.kubernetes.api.model.batch.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CronJobListBuilder extends CronJobListFluent<CronJobListBuilder> implements VisitableBuilder<CronJobList,CronJobListBuilder>{

  CronJobListFluent<?> fluent;

  public CronJobListBuilder() {
    this(new CronJobList());
  }
  
  public CronJobListBuilder(CronJobListFluent<?> fluent) {
    this(fluent, new CronJobList());
  }
  
  public CronJobListBuilder(CronJobList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CronJobListBuilder(CronJobListFluent<?> fluent,CronJobList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CronJobList build() {
    CronJobList buildable = new CronJobList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}