package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Object;
import java.lang.RuntimeException;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class ZoneAwareLoadBalancerSettingFluent<A extends io.fabric8.istio.api.api.networking.v1alpha3.ZoneAwareLoadBalancerSettingFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Boolean enabled;
  private ArrayList<ZoneAwareLoadBalancerSettingFailoverBuilder> failover = new ArrayList<ZoneAwareLoadBalancerSettingFailoverBuilder>();
  private List<String> failoverPriority = new ArrayList<String>();
  private Integer minClusterSize;

  public ZoneAwareLoadBalancerSettingFluent() {
  }
  
  public ZoneAwareLoadBalancerSettingFluent(ZoneAwareLoadBalancerSetting instance) {
    this.copyInstance(instance);
  }

  public A addAllToFailover(Collection<ZoneAwareLoadBalancerSettingFailover> items) {
    if (this.failover == null) {
      this.failover = new ArrayList();
    }
    for (ZoneAwareLoadBalancerSettingFailover item : items) {
        ZoneAwareLoadBalancerSettingFailoverBuilder builder = new ZoneAwareLoadBalancerSettingFailoverBuilder(item);
        _visitables.get("failover").add(builder);
        this.failover.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToFailoverPriority(Collection<String> items) {
    if (this.failoverPriority == null) {
      this.failoverPriority = new ArrayList();
    }
    for (String item : items) {
      this.failoverPriority.add(item);
    }
    return (A) this;
  }
  
  public FailoverNested<A> addNewFailover() {
    return new FailoverNested(-1, null);
  }
  
  public A addNewFailover(String from,String to) {
    return (A) this.addToFailover(new ZoneAwareLoadBalancerSettingFailover(from, to));
  }
  
  public FailoverNested<A> addNewFailoverLike(ZoneAwareLoadBalancerSettingFailover item) {
    return new FailoverNested(-1, item);
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
  
  public A addToFailover(ZoneAwareLoadBalancerSettingFailover... items) {
    if (this.failover == null) {
      this.failover = new ArrayList();
    }
    for (ZoneAwareLoadBalancerSettingFailover item : items) {
        ZoneAwareLoadBalancerSettingFailoverBuilder builder = new ZoneAwareLoadBalancerSettingFailoverBuilder(item);
        _visitables.get("failover").add(builder);
        this.failover.add(builder);
    }
    return (A) this;
  }
  
  public A addToFailover(int index,ZoneAwareLoadBalancerSettingFailover item) {
    if (this.failover == null) {
      this.failover = new ArrayList();
    }
    ZoneAwareLoadBalancerSettingFailoverBuilder builder = new ZoneAwareLoadBalancerSettingFailoverBuilder(item);
    if (index < 0 || index >= failover.size()) {
        _visitables.get("failover").add(builder);
        failover.add(builder);
    } else {
        _visitables.get("failover").add(builder);
        failover.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToFailoverPriority(String... items) {
    if (this.failoverPriority == null) {
      this.failoverPriority = new ArrayList();
    }
    for (String item : items) {
      this.failoverPriority.add(item);
    }
    return (A) this;
  }
  
  public A addToFailoverPriority(int index,String item) {
    if (this.failoverPriority == null) {
      this.failoverPriority = new ArrayList();
    }
    this.failoverPriority.add(index, item);
    return (A) this;
  }
  
  public List<ZoneAwareLoadBalancerSettingFailover> buildFailover() {
    return this.failover != null ? build(failover) : null;
  }
  
  public ZoneAwareLoadBalancerSettingFailover buildFailover(int index) {
    return this.failover.get(index).build();
  }
  
  public ZoneAwareLoadBalancerSettingFailover buildFirstFailover() {
    return this.failover.get(0).build();
  }
  
  public ZoneAwareLoadBalancerSettingFailover buildLastFailover() {
    return this.failover.get(failover.size() - 1).build();
  }
  
  public ZoneAwareLoadBalancerSettingFailover buildMatchingFailover(Predicate<ZoneAwareLoadBalancerSettingFailoverBuilder> predicate) {
      for (ZoneAwareLoadBalancerSettingFailoverBuilder item : failover) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(ZoneAwareLoadBalancerSetting instance) {
    instance = instance != null ? instance : new ZoneAwareLoadBalancerSetting();
    if (instance != null) {
        this.withEnabled(instance.getEnabled());
        this.withFailover(instance.getFailover());
        this.withFailoverPriority(instance.getFailoverPriority());
        this.withMinClusterSize(instance.getMinClusterSize());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public FailoverNested<A> editFailover(int index) {
    if (failover.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "failover"));
    }
    return this.setNewFailoverLike(index, this.buildFailover(index));
  }
  
  public FailoverNested<A> editFirstFailover() {
    if (failover.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "failover"));
    }
    return this.setNewFailoverLike(0, this.buildFailover(0));
  }
  
  public FailoverNested<A> editLastFailover() {
    int index = failover.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "failover"));
    }
    return this.setNewFailoverLike(index, this.buildFailover(index));
  }
  
  public FailoverNested<A> editMatchingFailover(Predicate<ZoneAwareLoadBalancerSettingFailoverBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < failover.size();i++) {
      if (predicate.test(failover.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "failover"));
    }
    return this.setNewFailoverLike(index, this.buildFailover(index));
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
    ZoneAwareLoadBalancerSettingFluent that = (ZoneAwareLoadBalancerSettingFluent) o;
    if (!(Objects.equals(enabled, that.enabled))) {
      return false;
    }
    if (!(Objects.equals(failover, that.failover))) {
      return false;
    }
    if (!(Objects.equals(failoverPriority, that.failoverPriority))) {
      return false;
    }
    if (!(Objects.equals(minClusterSize, that.minClusterSize))) {
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
  
  public Boolean getEnabled() {
    return this.enabled;
  }
  
  public List<String> getFailoverPriority() {
    return this.failoverPriority;
  }
  
  public String getFailoverPriority(int index) {
    return this.failoverPriority.get(index);
  }
  
  public String getFirstFailoverPriority() {
    return this.failoverPriority.get(0);
  }
  
  public String getLastFailoverPriority() {
    return this.failoverPriority.get(failoverPriority.size() - 1);
  }
  
  public String getMatchingFailoverPriority(Predicate<String> predicate) {
      for (String item : failoverPriority) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public Integer getMinClusterSize() {
    return this.minClusterSize;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasEnabled() {
    return this.enabled != null;
  }
  
  public boolean hasFailover() {
    return this.failover != null && !(this.failover.isEmpty());
  }
  
  public boolean hasFailoverPriority() {
    return this.failoverPriority != null && !(this.failoverPriority.isEmpty());
  }
  
  public boolean hasMatchingFailover(Predicate<ZoneAwareLoadBalancerSettingFailoverBuilder> predicate) {
      for (ZoneAwareLoadBalancerSettingFailoverBuilder item : failover) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingFailoverPriority(Predicate<String> predicate) {
      for (String item : failoverPriority) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMinClusterSize() {
    return this.minClusterSize != null;
  }
  
  public int hashCode() {
    return Objects.hash(enabled, failover, failoverPriority, minClusterSize, additionalProperties);
  }
  
  public A removeAllFromFailover(Collection<ZoneAwareLoadBalancerSettingFailover> items) {
    if (this.failover == null) {
      return (A) this;
    }
    for (ZoneAwareLoadBalancerSettingFailover item : items) {
        ZoneAwareLoadBalancerSettingFailoverBuilder builder = new ZoneAwareLoadBalancerSettingFailoverBuilder(item);
        _visitables.get("failover").remove(builder);
        this.failover.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromFailoverPriority(Collection<String> items) {
    if (this.failoverPriority == null) {
      return (A) this;
    }
    for (String item : items) {
      this.failoverPriority.remove(item);
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
  
  public A removeFromFailover(ZoneAwareLoadBalancerSettingFailover... items) {
    if (this.failover == null) {
      return (A) this;
    }
    for (ZoneAwareLoadBalancerSettingFailover item : items) {
        ZoneAwareLoadBalancerSettingFailoverBuilder builder = new ZoneAwareLoadBalancerSettingFailoverBuilder(item);
        _visitables.get("failover").remove(builder);
        this.failover.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromFailoverPriority(String... items) {
    if (this.failoverPriority == null) {
      return (A) this;
    }
    for (String item : items) {
      this.failoverPriority.remove(item);
    }
    return (A) this;
  }
  
  public A removeMatchingFromFailover(Predicate<ZoneAwareLoadBalancerSettingFailoverBuilder> predicate) {
    if (failover == null) {
      return (A) this;
    }
    Iterator<ZoneAwareLoadBalancerSettingFailoverBuilder> each = failover.iterator();
    List visitables = _visitables.get("failover");
    while (each.hasNext()) {
        ZoneAwareLoadBalancerSettingFailoverBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public FailoverNested<A> setNewFailoverLike(int index,ZoneAwareLoadBalancerSettingFailover item) {
    return new FailoverNested(index, item);
  }
  
  public A setToFailover(int index,ZoneAwareLoadBalancerSettingFailover item) {
    if (this.failover == null) {
      this.failover = new ArrayList();
    }
    ZoneAwareLoadBalancerSettingFailoverBuilder builder = new ZoneAwareLoadBalancerSettingFailoverBuilder(item);
    if (index < 0 || index >= failover.size()) {
        _visitables.get("failover").add(builder);
        failover.add(builder);
    } else {
        _visitables.get("failover").add(builder);
        failover.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToFailoverPriority(int index,String item) {
    if (this.failoverPriority == null) {
      this.failoverPriority = new ArrayList();
    }
    this.failoverPriority.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(enabled == null)) {
        sb.append("enabled:");
        sb.append(enabled);
        sb.append(",");
    }
    if (!(failover == null) && !(failover.isEmpty())) {
        sb.append("failover:");
        sb.append(failover);
        sb.append(",");
    }
    if (!(failoverPriority == null) && !(failoverPriority.isEmpty())) {
        sb.append("failoverPriority:");
        sb.append(failoverPriority);
        sb.append(",");
    }
    if (!(minClusterSize == null)) {
        sb.append("minClusterSize:");
        sb.append(minClusterSize);
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
  
  public A withEnabled() {
    return withEnabled(true);
  }
  
  public A withEnabled(Boolean enabled) {
    this.enabled = enabled;
    return (A) this;
  }
  
  public A withFailover(List<ZoneAwareLoadBalancerSettingFailover> failover) {
    if (this.failover != null) {
      this._visitables.get("failover").clear();
    }
    if (failover != null) {
        this.failover = new ArrayList();
        for (ZoneAwareLoadBalancerSettingFailover item : failover) {
          this.addToFailover(item);
        }
    } else {
      this.failover = null;
    }
    return (A) this;
  }
  
  public A withFailover(ZoneAwareLoadBalancerSettingFailover... failover) {
    if (this.failover != null) {
        this.failover.clear();
        _visitables.remove("failover");
    }
    if (failover != null) {
      for (ZoneAwareLoadBalancerSettingFailover item : failover) {
        this.addToFailover(item);
      }
    }
    return (A) this;
  }
  
  public A withFailoverPriority(List<String> failoverPriority) {
    if (failoverPriority != null) {
        this.failoverPriority = new ArrayList();
        for (String item : failoverPriority) {
          this.addToFailoverPriority(item);
        }
    } else {
      this.failoverPriority = null;
    }
    return (A) this;
  }
  
  public A withFailoverPriority(String... failoverPriority) {
    if (this.failoverPriority != null) {
        this.failoverPriority.clear();
        _visitables.remove("failoverPriority");
    }
    if (failoverPriority != null) {
      for (String item : failoverPriority) {
        this.addToFailoverPriority(item);
      }
    }
    return (A) this;
  }
  
  public A withMinClusterSize(Integer minClusterSize) {
    this.minClusterSize = minClusterSize;
    return (A) this;
  }
  public class FailoverNested<N> extends ZoneAwareLoadBalancerSettingFailoverFluent<FailoverNested<N>> implements Nested<N>{
  
    ZoneAwareLoadBalancerSettingFailoverBuilder builder;
    int index;
  
    FailoverNested(int index,ZoneAwareLoadBalancerSettingFailover item) {
      this.index = index;
      this.builder = new ZoneAwareLoadBalancerSettingFailoverBuilder(this, item);
    }
  
    public N and() {
      return (N) ZoneAwareLoadBalancerSettingFluent.this.setToFailover(index, builder.build());
    }
    
    public N endFailover() {
      return and();
    }
    
  }
}