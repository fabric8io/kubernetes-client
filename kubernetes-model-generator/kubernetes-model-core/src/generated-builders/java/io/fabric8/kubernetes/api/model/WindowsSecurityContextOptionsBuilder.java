package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class WindowsSecurityContextOptionsBuilder extends WindowsSecurityContextOptionsFluent<WindowsSecurityContextOptionsBuilder> implements VisitableBuilder<WindowsSecurityContextOptions,WindowsSecurityContextOptionsBuilder>{

  WindowsSecurityContextOptionsFluent<?> fluent;

  public WindowsSecurityContextOptionsBuilder() {
    this(new WindowsSecurityContextOptions());
  }
  
  public WindowsSecurityContextOptionsBuilder(WindowsSecurityContextOptionsFluent<?> fluent) {
    this(fluent, new WindowsSecurityContextOptions());
  }
  
  public WindowsSecurityContextOptionsBuilder(WindowsSecurityContextOptions instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public WindowsSecurityContextOptionsBuilder(WindowsSecurityContextOptionsFluent<?> fluent,WindowsSecurityContextOptions instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public WindowsSecurityContextOptions build() {
    WindowsSecurityContextOptions buildable = new WindowsSecurityContextOptions(fluent.getGmsaCredentialSpec(), fluent.getGmsaCredentialSpecName(), fluent.getHostProcess(), fluent.getRunAsUserName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}