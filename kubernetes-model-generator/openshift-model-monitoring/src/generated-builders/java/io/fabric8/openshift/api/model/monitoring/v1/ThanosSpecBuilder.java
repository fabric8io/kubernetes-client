package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ThanosSpecBuilder extends ThanosSpecFluent<ThanosSpecBuilder> implements VisitableBuilder<ThanosSpec,ThanosSpecBuilder>{

  ThanosSpecFluent<?> fluent;

  public ThanosSpecBuilder() {
    this(new ThanosSpec());
  }
  
  public ThanosSpecBuilder(ThanosSpecFluent<?> fluent) {
    this(fluent, new ThanosSpec());
  }
  
  public ThanosSpecBuilder(ThanosSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ThanosSpecBuilder(ThanosSpecFluent<?> fluent,ThanosSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ThanosSpec build() {
    ThanosSpec buildable = new ThanosSpec(fluent.buildAdditionalArgs(), fluent.getBaseImage(), fluent.getBlockSize(), fluent.getGetConfigInterval(), fluent.getGetConfigTimeout(), fluent.getGrpcListenLocal(), fluent.buildGrpcServerTlsConfig(), fluent.getHttpListenLocal(), fluent.getImage(), fluent.getListenLocal(), fluent.getLogFormat(), fluent.getLogLevel(), fluent.getMinTime(), fluent.getObjectStorageConfig(), fluent.getObjectStorageConfigFile(), fluent.getReadyTimeout(), fluent.buildResources(), fluent.getSha(), fluent.getTag(), fluent.getTracingConfig(), fluent.getTracingConfigFile(), fluent.getVersion(), fluent.buildVolumeMounts());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}