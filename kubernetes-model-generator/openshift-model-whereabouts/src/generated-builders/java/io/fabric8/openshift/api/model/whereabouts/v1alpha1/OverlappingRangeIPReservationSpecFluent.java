package io.fabric8.openshift.api.model.whereabouts.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class OverlappingRangeIPReservationSpecFluent<A extends io.fabric8.openshift.api.model.whereabouts.v1alpha1.OverlappingRangeIPReservationSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String containerid;
  private String ifname;
  private String podref;

  public OverlappingRangeIPReservationSpecFluent() {
  }
  
  public OverlappingRangeIPReservationSpecFluent(OverlappingRangeIPReservationSpec instance) {
    this.copyInstance(instance);
  }

  public A addToAdditionalProperties(Map<String,Object> map) {
    if (this.additionalProperties == null && map != null) {
      this.additionalProperties = new LinkedHashMap();
    }
    if (map != null) {
      this.additionalProperties.putAll(map);
    }
    return (A) this;
  }
  
  public A addToAdditionalProperties(String key,Object value) {
    if (this.additionalProperties == null && key != null && value != null) {
      this.additionalProperties = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.additionalProperties.put(key, value);
    }
    return (A) this;
  }
  
  protected void copyInstance(OverlappingRangeIPReservationSpec instance) {
    instance = instance != null ? instance : new OverlappingRangeIPReservationSpec();
    if (instance != null) {
        this.withContainerid(instance.getContainerid());
        this.withIfname(instance.getIfname());
        this.withPodref(instance.getPodref());
        this.withAdditionalProperties(instance.getAdditionalProperties());
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
    OverlappingRangeIPReservationSpecFluent that = (OverlappingRangeIPReservationSpecFluent) o;
    if (!(Objects.equals(containerid, that.containerid))) {
      return false;
    }
    if (!(Objects.equals(ifname, that.ifname))) {
      return false;
    }
    if (!(Objects.equals(podref, that.podref))) {
      return false;
    }
    if (!(Objects.equals(additionalProperties, that.additionalProperties))) {
      return false;
    }
    return true;
  }
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public String getContainerid() {
    return this.containerid;
  }
  
  public String getIfname() {
    return this.ifname;
  }
  
  public String getPodref() {
    return this.podref;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasContainerid() {
    return this.containerid != null;
  }
  
  public boolean hasIfname() {
    return this.ifname != null;
  }
  
  public boolean hasPodref() {
    return this.podref != null;
  }
  
  public int hashCode() {
    return Objects.hash(containerid, ifname, podref, additionalProperties);
  }
  
  public A removeFromAdditionalProperties(String key) {
    if (this.additionalProperties == null) {
      return (A) this;
    }
    if (key != null && this.additionalProperties != null) {
      this.additionalProperties.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromAdditionalProperties(Map<String,Object> map) {
    if (this.additionalProperties == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.additionalProperties != null) {
          this.additionalProperties.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(containerid == null)) {
        sb.append("containerid:");
        sb.append(containerid);
        sb.append(",");
    }
    if (!(ifname == null)) {
        sb.append("ifname:");
        sb.append(ifname);
        sb.append(",");
    }
    if (!(podref == null)) {
        sb.append("podref:");
        sb.append(podref);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public A withContainerid(String containerid) {
    this.containerid = containerid;
    return (A) this;
  }
  
  public A withIfname(String ifname) {
    this.ifname = ifname;
    return (A) this;
  }
  
  public A withPodref(String podref) {
    this.podref = podref;
    return (A) this;
  }
  
}