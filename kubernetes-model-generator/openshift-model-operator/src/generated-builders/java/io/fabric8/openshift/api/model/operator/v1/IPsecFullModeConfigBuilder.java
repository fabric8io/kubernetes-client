package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IPsecFullModeConfigBuilder extends IPsecFullModeConfigFluent<IPsecFullModeConfigBuilder> implements VisitableBuilder<IPsecFullModeConfig,IPsecFullModeConfigBuilder>{

  IPsecFullModeConfigFluent<?> fluent;

  public IPsecFullModeConfigBuilder() {
    this(new IPsecFullModeConfig());
  }
  
  public IPsecFullModeConfigBuilder(IPsecFullModeConfigFluent<?> fluent) {
    this(fluent, new IPsecFullModeConfig());
  }
  
  public IPsecFullModeConfigBuilder(IPsecFullModeConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IPsecFullModeConfigBuilder(IPsecFullModeConfigFluent<?> fluent,IPsecFullModeConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IPsecFullModeConfig build() {
    IPsecFullModeConfig buildable = new IPsecFullModeConfig(fluent.getEncapsulation());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}