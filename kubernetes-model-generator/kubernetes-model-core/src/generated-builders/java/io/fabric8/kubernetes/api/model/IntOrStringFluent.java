package io.fabric8.kubernetes.api.model;

import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.Objects;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class IntOrStringFluent<A extends io.fabric8.kubernetes.api.model.IntOrStringFluent<A>> extends AnyTypeFluent<A>{

  
  public IntOrStringFluent() {
  }
  
  public IntOrStringFluent(IntOrString instance) {
    this.copyInstance(instance);
  }

  protected void copyInstance(IntOrString instance) {
    instance = instance != null ? instance : new IntOrString();
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
    IntOrStringFluent that = (IntOrStringFluent) o;
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