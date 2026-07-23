package io.fabric8.kubernetes.api.model.runtime;

import io.fabric8.kubernetes.api.model.AnyTypeFluent;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.Objects;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class RawExtensionFluent<A extends io.fabric8.kubernetes.api.model.runtime.RawExtensionFluent<A>> extends AnyTypeFluent<A>{

  
  public RawExtensionFluent() {
  }
  
  public RawExtensionFluent(RawExtension instance) {
    this.copyInstance(instance);
  }

  protected void copyInstance(RawExtension instance) {
    instance = instance != null ? instance : new RawExtension();
    if (instance != null) {
      this.withValue(instance.getValue());
    }
  }
  
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    if (!(super.equals(o))) {
      return false;
    }
    RawExtensionFluent that = (RawExtensionFluent) o;
    return true;
  }
  
  public int hashCode() {
    return Objects.hash();
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    sb.append("}");
    return sb.toString();
  }
  
}