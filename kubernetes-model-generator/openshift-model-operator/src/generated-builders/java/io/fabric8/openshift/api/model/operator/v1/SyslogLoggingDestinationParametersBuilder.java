package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SyslogLoggingDestinationParametersBuilder extends SyslogLoggingDestinationParametersFluent<SyslogLoggingDestinationParametersBuilder> implements VisitableBuilder<SyslogLoggingDestinationParameters,SyslogLoggingDestinationParametersBuilder>{

  SyslogLoggingDestinationParametersFluent<?> fluent;

  public SyslogLoggingDestinationParametersBuilder() {
    this(new SyslogLoggingDestinationParameters());
  }
  
  public SyslogLoggingDestinationParametersBuilder(SyslogLoggingDestinationParametersFluent<?> fluent) {
    this(fluent, new SyslogLoggingDestinationParameters());
  }
  
  public SyslogLoggingDestinationParametersBuilder(SyslogLoggingDestinationParameters instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SyslogLoggingDestinationParametersBuilder(SyslogLoggingDestinationParametersFluent<?> fluent,SyslogLoggingDestinationParameters instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SyslogLoggingDestinationParameters build() {
    SyslogLoggingDestinationParameters buildable = new SyslogLoggingDestinationParameters(fluent.getAddress(), fluent.getFacility(), fluent.getMaxLength(), fluent.getPort());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}