package io.fabric8.knative.sinks.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class LogBuilder extends LogFluent<LogBuilder> implements VisitableBuilder<Log,LogBuilder>{

  LogFluent<?> fluent;

  public LogBuilder() {
    this(new Log());
  }
  
  public LogBuilder(LogFluent<?> fluent) {
    this(fluent, new Log());
  }
  
  public LogBuilder(Log instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public LogBuilder(LogFluent<?> fluent,Log instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Log build() {
    Log buildable = new Log(fluent.getLevel(), fluent.getLogMask(), fluent.getLoggerName(), fluent.getMarker(), fluent.getMultiline(), fluent.getShowAllProperties(), fluent.getShowBody(), fluent.getShowBodyType(), fluent.getShowCachedStreams(), fluent.getShowExchangePattern(), fluent.getShowHeaders(), fluent.getShowProperties(), fluent.getShowStreams());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}