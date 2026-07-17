package io.fabric8.openshift.api.model.hive.aws.v1;

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
public class VPCEndpointServiceFluent<A extends io.fabric8.openshift.api.model.hive.aws.v1.VPCEndpointServiceFluent<A>> extends BaseFluent<A>{

  private List<String> additionalAllowedPrincipals = new ArrayList<String>();
  private Map<String,Object> additionalProperties;
  private String defaultAllowedPrincipal;
  private String id;
  private String name;

  public VPCEndpointServiceFluent() {
  }
  
  public VPCEndpointServiceFluent(VPCEndpointService instance) {
    this.copyInstance(instance);
  }

  public A addAllToAdditionalAllowedPrincipals(Collection<String> items) {
    if (this.additionalAllowedPrincipals == null) {
      this.additionalAllowedPrincipals = new ArrayList();
    }
    for (String item : items) {
      this.additionalAllowedPrincipals.add(item);
    }
    return (A) this;
  }
  
  public A addToAdditionalAllowedPrincipals(String... items) {
    if (this.additionalAllowedPrincipals == null) {
      this.additionalAllowedPrincipals = new ArrayList();
    }
    for (String item : items) {
      this.additionalAllowedPrincipals.add(item);
    }
    return (A) this;
  }
  
  public A addToAdditionalAllowedPrincipals(int index,String item) {
    if (this.additionalAllowedPrincipals == null) {
      this.additionalAllowedPrincipals = new ArrayList();
    }
    this.additionalAllowedPrincipals.add(index, item);
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
  
  protected void copyInstance(VPCEndpointService instance) {
    instance = instance != null ? instance : new VPCEndpointService();
    if (instance != null) {
        this.withAdditionalAllowedPrincipals(instance.getAdditionalAllowedPrincipals());
        this.withDefaultAllowedPrincipal(instance.getDefaultAllowedPrincipal());
        this.withId(instance.getId());
        this.withName(instance.getName());
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
    VPCEndpointServiceFluent that = (VPCEndpointServiceFluent) o;
    if (!(Objects.equals(additionalAllowedPrincipals, that.additionalAllowedPrincipals))) {
      return false;
    }
    if (!(Objects.equals(defaultAllowedPrincipal, that.defaultAllowedPrincipal))) {
      return false;
    }
    if (!(Objects.equals(id, that.id))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(additionalProperties, that.additionalProperties))) {
      return false;
    }
    return true;
  }
  
  public String getAdditionalAllowedPrincipal(int index) {
    return this.additionalAllowedPrincipals.get(index);
  }
  
  public List<String> getAdditionalAllowedPrincipals() {
    return this.additionalAllowedPrincipals;
  }
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public String getDefaultAllowedPrincipal() {
    return this.defaultAllowedPrincipal;
  }
  
  public String getFirstAdditionalAllowedPrincipal() {
    return this.additionalAllowedPrincipals.get(0);
  }
  
  public String getId() {
    return this.id;
  }
  
  public String getLastAdditionalAllowedPrincipal() {
    return this.additionalAllowedPrincipals.get(additionalAllowedPrincipals.size() - 1);
  }
  
  public String getMatchingAdditionalAllowedPrincipal(Predicate<String> predicate) {
      for (String item : additionalAllowedPrincipals) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getName() {
    return this.name;
  }
  
  public boolean hasAdditionalAllowedPrincipals() {
    return this.additionalAllowedPrincipals != null && !(this.additionalAllowedPrincipals.isEmpty());
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDefaultAllowedPrincipal() {
    return this.defaultAllowedPrincipal != null;
  }
  
  public boolean hasId() {
    return this.id != null;
  }
  
  public boolean hasMatchingAdditionalAllowedPrincipal(Predicate<String> predicate) {
      for (String item : additionalAllowedPrincipals) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public int hashCode() {
    return Objects.hash(additionalAllowedPrincipals, defaultAllowedPrincipal, id, name, additionalProperties);
  }
  
  public A removeAllFromAdditionalAllowedPrincipals(Collection<String> items) {
    if (this.additionalAllowedPrincipals == null) {
      return (A) this;
    }
    for (String item : items) {
      this.additionalAllowedPrincipals.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromAdditionalAllowedPrincipals(String... items) {
    if (this.additionalAllowedPrincipals == null) {
      return (A) this;
    }
    for (String item : items) {
      this.additionalAllowedPrincipals.remove(item);
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
  
  public A setToAdditionalAllowedPrincipals(int index,String item) {
    if (this.additionalAllowedPrincipals == null) {
      this.additionalAllowedPrincipals = new ArrayList();
    }
    this.additionalAllowedPrincipals.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(additionalAllowedPrincipals == null) && !(additionalAllowedPrincipals.isEmpty())) {
        sb.append("additionalAllowedPrincipals:");
        sb.append(additionalAllowedPrincipals);
        sb.append(",");
    }
    if (!(defaultAllowedPrincipal == null)) {
        sb.append("defaultAllowedPrincipal:");
        sb.append(defaultAllowedPrincipal);
        sb.append(",");
    }
    if (!(id == null)) {
        sb.append("id:");
        sb.append(id);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public A withAdditionalAllowedPrincipals(List<String> additionalAllowedPrincipals) {
    if (additionalAllowedPrincipals != null) {
        this.additionalAllowedPrincipals = new ArrayList();
        for (String item : additionalAllowedPrincipals) {
          this.addToAdditionalAllowedPrincipals(item);
        }
    } else {
      this.additionalAllowedPrincipals = null;
    }
    return (A) this;
  }
  
  public A withAdditionalAllowedPrincipals(String... additionalAllowedPrincipals) {
    if (this.additionalAllowedPrincipals != null) {
        this.additionalAllowedPrincipals.clear();
        _visitables.remove("additionalAllowedPrincipals");
    }
    if (additionalAllowedPrincipals != null) {
      for (String item : additionalAllowedPrincipals) {
        this.addToAdditionalAllowedPrincipals(item);
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
  
  public A withDefaultAllowedPrincipal(String defaultAllowedPrincipal) {
    this.defaultAllowedPrincipal = defaultAllowedPrincipal;
    return (A) this;
  }
  
  public A withId(String id) {
    this.id = id;
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
}