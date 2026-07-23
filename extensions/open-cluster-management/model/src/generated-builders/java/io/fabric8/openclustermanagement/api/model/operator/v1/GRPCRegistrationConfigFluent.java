package io.fabric8.openclustermanagement.api.model.operator.v1;

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
public class GRPCRegistrationConfigFluent<A extends io.fabric8.openclustermanagement.api.model.operator.v1.GRPCRegistrationConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> autoApprovedIdentities = new ArrayList<String>();

  public GRPCRegistrationConfigFluent() {
  }
  
  public GRPCRegistrationConfigFluent(GRPCRegistrationConfig instance) {
    this.copyInstance(instance);
  }

  public A addAllToAutoApprovedIdentities(Collection<String> items) {
    if (this.autoApprovedIdentities == null) {
      this.autoApprovedIdentities = new ArrayList();
    }
    for (String item : items) {
      this.autoApprovedIdentities.add(item);
    }
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
  
  public A addToAutoApprovedIdentities(String... items) {
    if (this.autoApprovedIdentities == null) {
      this.autoApprovedIdentities = new ArrayList();
    }
    for (String item : items) {
      this.autoApprovedIdentities.add(item);
    }
    return (A) this;
  }
  
  public A addToAutoApprovedIdentities(int index,String item) {
    if (this.autoApprovedIdentities == null) {
      this.autoApprovedIdentities = new ArrayList();
    }
    this.autoApprovedIdentities.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(GRPCRegistrationConfig instance) {
    instance = instance != null ? instance : new GRPCRegistrationConfig();
    if (instance != null) {
        this.withAutoApprovedIdentities(instance.getAutoApprovedIdentities());
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
    GRPCRegistrationConfigFluent that = (GRPCRegistrationConfigFluent) o;
    if (!(Objects.equals(autoApprovedIdentities, that.autoApprovedIdentities))) {
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
  
  public List<String> getAutoApprovedIdentities() {
    return this.autoApprovedIdentities;
  }
  
  public String getAutoApprovedIdentity(int index) {
    return this.autoApprovedIdentities.get(index);
  }
  
  public String getFirstAutoApprovedIdentity() {
    return this.autoApprovedIdentities.get(0);
  }
  
  public String getLastAutoApprovedIdentity() {
    return this.autoApprovedIdentities.get(autoApprovedIdentities.size() - 1);
  }
  
  public String getMatchingAutoApprovedIdentity(Predicate<String> predicate) {
      for (String item : autoApprovedIdentities) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAutoApprovedIdentities() {
    return this.autoApprovedIdentities != null && !(this.autoApprovedIdentities.isEmpty());
  }
  
  public boolean hasMatchingAutoApprovedIdentity(Predicate<String> predicate) {
      for (String item : autoApprovedIdentities) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(autoApprovedIdentities, additionalProperties);
  }
  
  public A removeAllFromAutoApprovedIdentities(Collection<String> items) {
    if (this.autoApprovedIdentities == null) {
      return (A) this;
    }
    for (String item : items) {
      this.autoApprovedIdentities.remove(item);
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
  
  public A removeFromAutoApprovedIdentities(String... items) {
    if (this.autoApprovedIdentities == null) {
      return (A) this;
    }
    for (String item : items) {
      this.autoApprovedIdentities.remove(item);
    }
    return (A) this;
  }
  
  public A setToAutoApprovedIdentities(int index,String item) {
    if (this.autoApprovedIdentities == null) {
      this.autoApprovedIdentities = new ArrayList();
    }
    this.autoApprovedIdentities.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(autoApprovedIdentities == null) && !(autoApprovedIdentities.isEmpty())) {
        sb.append("autoApprovedIdentities:");
        sb.append(autoApprovedIdentities);
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
  
  public A withAutoApprovedIdentities(List<String> autoApprovedIdentities) {
    if (autoApprovedIdentities != null) {
        this.autoApprovedIdentities = new ArrayList();
        for (String item : autoApprovedIdentities) {
          this.addToAutoApprovedIdentities(item);
        }
    } else {
      this.autoApprovedIdentities = null;
    }
    return (A) this;
  }
  
  public A withAutoApprovedIdentities(String... autoApprovedIdentities) {
    if (this.autoApprovedIdentities != null) {
        this.autoApprovedIdentities.clear();
        _visitables.remove("autoApprovedIdentities");
    }
    if (autoApprovedIdentities != null) {
      for (String item : autoApprovedIdentities) {
        this.addToAutoApprovedIdentities(item);
      }
    }
    return (A) this;
  }
  
}