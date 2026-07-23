package io.fabric8.openshift.api.model.machine.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Boolean;
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
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class SubnetParamFluent<A extends io.fabric8.openshift.api.model.machine.v1alpha1.SubnetParamFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private SubnetFilterBuilder filter;
  private Boolean portSecurity;
  private List<String> portTags = new ArrayList<String>();
  private String uuid;

  public SubnetParamFluent() {
  }
  
  public SubnetParamFluent(SubnetParam instance) {
    this.copyInstance(instance);
  }

  public A addAllToPortTags(Collection<String> items) {
    if (this.portTags == null) {
      this.portTags = new ArrayList();
    }
    for (String item : items) {
      this.portTags.add(item);
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
  
  public A addToPortTags(String... items) {
    if (this.portTags == null) {
      this.portTags = new ArrayList();
    }
    for (String item : items) {
      this.portTags.add(item);
    }
    return (A) this;
  }
  
  public A addToPortTags(int index,String item) {
    if (this.portTags == null) {
      this.portTags = new ArrayList();
    }
    this.portTags.add(index, item);
    return (A) this;
  }
  
  public SubnetFilter buildFilter() {
    return this.filter != null ? this.filter.build() : null;
  }
  
  protected void copyInstance(SubnetParam instance) {
    instance = instance != null ? instance : new SubnetParam();
    if (instance != null) {
        this.withFilter(instance.getFilter());
        this.withPortSecurity(instance.getPortSecurity());
        this.withPortTags(instance.getPortTags());
        this.withUuid(instance.getUuid());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public FilterNested<A> editFilter() {
    return this.withNewFilterLike(Optional.ofNullable(this.buildFilter()).orElse(null));
  }
  
  public FilterNested<A> editOrNewFilter() {
    return this.withNewFilterLike(Optional.ofNullable(this.buildFilter()).orElse(new SubnetFilterBuilder().build()));
  }
  
  public FilterNested<A> editOrNewFilterLike(SubnetFilter item) {
    return this.withNewFilterLike(Optional.ofNullable(this.buildFilter()).orElse(item));
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
    SubnetParamFluent that = (SubnetParamFluent) o;
    if (!(Objects.equals(filter, that.filter))) {
      return false;
    }
    if (!(Objects.equals(portSecurity, that.portSecurity))) {
      return false;
    }
    if (!(Objects.equals(portTags, that.portTags))) {
      return false;
    }
    if (!(Objects.equals(uuid, that.uuid))) {
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
  
  public String getFirstPortTag() {
    return this.portTags.get(0);
  }
  
  public String getLastPortTag() {
    return this.portTags.get(portTags.size() - 1);
  }
  
  public String getMatchingPortTag(Predicate<String> predicate) {
      for (String item : portTags) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public Boolean getPortSecurity() {
    return this.portSecurity;
  }
  
  public String getPortTag(int index) {
    return this.portTags.get(index);
  }
  
  public List<String> getPortTags() {
    return this.portTags;
  }
  
  public String getUuid() {
    return this.uuid;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasFilter() {
    return this.filter != null;
  }
  
  public boolean hasMatchingPortTag(Predicate<String> predicate) {
      for (String item : portTags) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPortSecurity() {
    return this.portSecurity != null;
  }
  
  public boolean hasPortTags() {
    return this.portTags != null && !(this.portTags.isEmpty());
  }
  
  public boolean hasUuid() {
    return this.uuid != null;
  }
  
  public int hashCode() {
    return Objects.hash(filter, portSecurity, portTags, uuid, additionalProperties);
  }
  
  public A removeAllFromPortTags(Collection<String> items) {
    if (this.portTags == null) {
      return (A) this;
    }
    for (String item : items) {
      this.portTags.remove(item);
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
  
  public A removeFromPortTags(String... items) {
    if (this.portTags == null) {
      return (A) this;
    }
    for (String item : items) {
      this.portTags.remove(item);
    }
    return (A) this;
  }
  
  public A setToPortTags(int index,String item) {
    if (this.portTags == null) {
      this.portTags = new ArrayList();
    }
    this.portTags.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(filter == null)) {
        sb.append("filter:");
        sb.append(filter);
        sb.append(",");
    }
    if (!(portSecurity == null)) {
        sb.append("portSecurity:");
        sb.append(portSecurity);
        sb.append(",");
    }
    if (!(portTags == null) && !(portTags.isEmpty())) {
        sb.append("portTags:");
        sb.append(portTags);
        sb.append(",");
    }
    if (!(uuid == null)) {
        sb.append("uuid:");
        sb.append(uuid);
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
  
  public A withFilter(SubnetFilter filter) {
    this._visitables.remove("filter");
    if (filter != null) {
        this.filter = new SubnetFilterBuilder(filter);
        this._visitables.get("filter").add(this.filter);
    } else {
        this.filter = null;
        this._visitables.get("filter").remove(this.filter);
    }
    return (A) this;
  }
  
  public FilterNested<A> withNewFilter() {
    return new FilterNested(null);
  }
  
  public FilterNested<A> withNewFilterLike(SubnetFilter item) {
    return new FilterNested(item);
  }
  
  public A withPortSecurity() {
    return withPortSecurity(true);
  }
  
  public A withPortSecurity(Boolean portSecurity) {
    this.portSecurity = portSecurity;
    return (A) this;
  }
  
  public A withPortTags(List<String> portTags) {
    if (portTags != null) {
        this.portTags = new ArrayList();
        for (String item : portTags) {
          this.addToPortTags(item);
        }
    } else {
      this.portTags = null;
    }
    return (A) this;
  }
  
  public A withPortTags(String... portTags) {
    if (this.portTags != null) {
        this.portTags.clear();
        _visitables.remove("portTags");
    }
    if (portTags != null) {
      for (String item : portTags) {
        this.addToPortTags(item);
      }
    }
    return (A) this;
  }
  
  public A withUuid(String uuid) {
    this.uuid = uuid;
    return (A) this;
  }
  public class FilterNested<N> extends SubnetFilterFluent<FilterNested<N>> implements Nested<N>{
  
    SubnetFilterBuilder builder;
  
    FilterNested(SubnetFilter item) {
      this.builder = new SubnetFilterBuilder(this, item);
    }
  
    public N and() {
      return (N) SubnetParamFluent.this.withFilter(builder.build());
    }
    
    public N endFilter() {
      return and();
    }
    
  }
}