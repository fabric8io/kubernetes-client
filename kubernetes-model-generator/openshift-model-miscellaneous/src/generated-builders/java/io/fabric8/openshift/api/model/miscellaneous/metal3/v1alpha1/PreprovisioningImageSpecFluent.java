package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class PreprovisioningImageSpecFluent<A extends io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1.PreprovisioningImageSpecFluent<A>> extends BaseFluent<A>{

  private List<String> acceptFormats = new ArrayList<String>();
  private Map<String,Object> additionalProperties;
  private String architecture;
  private String networkDataName;

  public PreprovisioningImageSpecFluent() {
  }
  
  public PreprovisioningImageSpecFluent(PreprovisioningImageSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToAcceptFormats(Collection<String> items) {
    if (this.acceptFormats == null) {
      this.acceptFormats = new ArrayList();
    }
    for (String item : items) {
      this.acceptFormats.add(item);
    }
    return (A) this;
  }
  
  public A addToAcceptFormats(String... items) {
    if (this.acceptFormats == null) {
      this.acceptFormats = new ArrayList();
    }
    for (String item : items) {
      this.acceptFormats.add(item);
    }
    return (A) this;
  }
  
  public A addToAcceptFormats(int index,String item) {
    if (this.acceptFormats == null) {
      this.acceptFormats = new ArrayList();
    }
    this.acceptFormats.add(index, item);
    return (A) this;
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
  
  protected void copyInstance(PreprovisioningImageSpec instance) {
    instance = instance != null ? instance : new PreprovisioningImageSpec();
    if (instance != null) {
        this.withAcceptFormats(instance.getAcceptFormats());
        this.withArchitecture(instance.getArchitecture());
        this.withNetworkDataName(instance.getNetworkDataName());
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
    PreprovisioningImageSpecFluent that = (PreprovisioningImageSpecFluent) o;
    if (!(Objects.equals(acceptFormats, that.acceptFormats))) {
      return false;
    }
    if (!(Objects.equals(architecture, that.architecture))) {
      return false;
    }
    if (!(Objects.equals(networkDataName, that.networkDataName))) {
      return false;
    }
    if (!(Objects.equals(additionalProperties, that.additionalProperties))) {
      return false;
    }
    return true;
  }
  
  public String getAcceptFormat(int index) {
    return this.acceptFormats.get(index);
  }
  
  public List<String> getAcceptFormats() {
    return this.acceptFormats;
  }
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public String getArchitecture() {
    return this.architecture;
  }
  
  public String getFirstAcceptFormat() {
    return this.acceptFormats.get(0);
  }
  
  public String getLastAcceptFormat() {
    return this.acceptFormats.get(acceptFormats.size() - 1);
  }
  
  public String getMatchingAcceptFormat(Predicate<String> predicate) {
      for (String item : acceptFormats) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getNetworkDataName() {
    return this.networkDataName;
  }
  
  public boolean hasAcceptFormats() {
    return this.acceptFormats != null && !(this.acceptFormats.isEmpty());
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasArchitecture() {
    return this.architecture != null;
  }
  
  public boolean hasMatchingAcceptFormat(Predicate<String> predicate) {
      for (String item : acceptFormats) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNetworkDataName() {
    return this.networkDataName != null;
  }
  
  public int hashCode() {
    return Objects.hash(acceptFormats, architecture, networkDataName, additionalProperties);
  }
  
  public A removeAllFromAcceptFormats(Collection<String> items) {
    if (this.acceptFormats == null) {
      return (A) this;
    }
    for (String item : items) {
      this.acceptFormats.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromAcceptFormats(String... items) {
    if (this.acceptFormats == null) {
      return (A) this;
    }
    for (String item : items) {
      this.acceptFormats.remove(item);
    }
    return (A) this;
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
  
  public A setToAcceptFormats(int index,String item) {
    if (this.acceptFormats == null) {
      this.acceptFormats = new ArrayList();
    }
    this.acceptFormats.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(acceptFormats == null) && !(acceptFormats.isEmpty())) {
        sb.append("acceptFormats:");
        sb.append(acceptFormats);
        sb.append(",");
    }
    if (!(architecture == null)) {
        sb.append("architecture:");
        sb.append(architecture);
        sb.append(",");
    }
    if (!(networkDataName == null)) {
        sb.append("networkDataName:");
        sb.append(networkDataName);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public A withAcceptFormats(List<String> acceptFormats) {
    if (acceptFormats != null) {
        this.acceptFormats = new ArrayList();
        for (String item : acceptFormats) {
          this.addToAcceptFormats(item);
        }
    } else {
      this.acceptFormats = null;
    }
    return (A) this;
  }
  
  public A withAcceptFormats(String... acceptFormats) {
    if (this.acceptFormats != null) {
        this.acceptFormats.clear();
        _visitables.remove("acceptFormats");
    }
    if (acceptFormats != null) {
      for (String item : acceptFormats) {
        this.addToAcceptFormats(item);
      }
    }
    return (A) this;
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public A withArchitecture(String architecture) {
    this.architecture = architecture;
    return (A) this;
  }
  
  public A withNetworkDataName(String networkDataName) {
    this.networkDataName = networkDataName;
    return (A) this;
  }
  
}