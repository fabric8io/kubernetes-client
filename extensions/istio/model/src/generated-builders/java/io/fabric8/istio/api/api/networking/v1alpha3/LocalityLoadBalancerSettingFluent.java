package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Boolean;
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
public class LocalityLoadBalancerSettingFluent<A extends io.fabric8.istio.api.api.networking.v1alpha3.LocalityLoadBalancerSettingFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<LocalityLoadBalancerSettingDistributeBuilder> distribute = new ArrayList<LocalityLoadBalancerSettingDistributeBuilder>();
  private Boolean enabled;
  private ArrayList<LocalityLoadBalancerSettingFailoverBuilder> failover = new ArrayList<LocalityLoadBalancerSettingFailoverBuilder>();
  private List<String> failoverPriority = new ArrayList<String>();

  public LocalityLoadBalancerSettingFluent() {
  }
  
  public LocalityLoadBalancerSettingFluent(LocalityLoadBalancerSetting instance) {
    this.copyInstance(instance);
  }

  public A addAllToDistribute(Collection<LocalityLoadBalancerSettingDistribute> items) {
    if (this.distribute == null) {
      this.distribute = new ArrayList();
    }
    for (LocalityLoadBalancerSettingDistribute item : items) {
        LocalityLoadBalancerSettingDistributeBuilder builder = new LocalityLoadBalancerSettingDistributeBuilder(item);
        _visitables.get("distribute").add(builder);
        this.distribute.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToFailover(Collection<LocalityLoadBalancerSettingFailover> items) {
    if (this.failover == null) {
      this.failover = new ArrayList();
    }
    for (LocalityLoadBalancerSettingFailover item : items) {
        LocalityLoadBalancerSettingFailoverBuilder builder = new LocalityLoadBalancerSettingFailoverBuilder(item);
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
  
  public DistributeNested<A> addNewDistribute() {
    return new DistributeNested(-1, null);
  }
  
  public DistributeNested<A> addNewDistributeLike(LocalityLoadBalancerSettingDistribute item) {
    return new DistributeNested(-1, item);
  }
  
  public FailoverNested<A> addNewFailover() {
    return new FailoverNested(-1, null);
  }
  
  public A addNewFailover(String from,String to) {
    return (A) this.addToFailover(new LocalityLoadBalancerSettingFailover(from, to));
  }
  
  public FailoverNested<A> addNewFailoverLike(LocalityLoadBalancerSettingFailover item) {
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
  
  public A addToDistribute(LocalityLoadBalancerSettingDistribute... items) {
    if (this.distribute == null) {
      this.distribute = new ArrayList();
    }
    for (LocalityLoadBalancerSettingDistribute item : items) {
        LocalityLoadBalancerSettingDistributeBuilder builder = new LocalityLoadBalancerSettingDistributeBuilder(item);
        _visitables.get("distribute").add(builder);
        this.distribute.add(builder);
    }
    return (A) this;
  }
  
  public A addToDistribute(int index,LocalityLoadBalancerSettingDistribute item) {
    if (this.distribute == null) {
      this.distribute = new ArrayList();
    }
    LocalityLoadBalancerSettingDistributeBuilder builder = new LocalityLoadBalancerSettingDistributeBuilder(item);
    if (index < 0 || index >= distribute.size()) {
        _visitables.get("distribute").add(builder);
        distribute.add(builder);
    } else {
        _visitables.get("distribute").add(builder);
        distribute.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToFailover(LocalityLoadBalancerSettingFailover... items) {
    if (this.failover == null) {
      this.failover = new ArrayList();
    }
    for (LocalityLoadBalancerSettingFailover item : items) {
        LocalityLoadBalancerSettingFailoverBuilder builder = new LocalityLoadBalancerSettingFailoverBuilder(item);
        _visitables.get("failover").add(builder);
        this.failover.add(builder);
    }
    return (A) this;
  }
  
  public A addToFailover(int index,LocalityLoadBalancerSettingFailover item) {
    if (this.failover == null) {
      this.failover = new ArrayList();
    }
    LocalityLoadBalancerSettingFailoverBuilder builder = new LocalityLoadBalancerSettingFailoverBuilder(item);
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
  
  public List<LocalityLoadBalancerSettingDistribute> buildDistribute() {
    return this.distribute != null ? build(distribute) : null;
  }
  
  public LocalityLoadBalancerSettingDistribute buildDistribute(int index) {
    return this.distribute.get(index).build();
  }
  
  public List<LocalityLoadBalancerSettingFailover> buildFailover() {
    return this.failover != null ? build(failover) : null;
  }
  
  public LocalityLoadBalancerSettingFailover buildFailover(int index) {
    return this.failover.get(index).build();
  }
  
  public LocalityLoadBalancerSettingDistribute buildFirstDistribute() {
    return this.distribute.get(0).build();
  }
  
  public LocalityLoadBalancerSettingFailover buildFirstFailover() {
    return this.failover.get(0).build();
  }
  
  public LocalityLoadBalancerSettingDistribute buildLastDistribute() {
    return this.distribute.get(distribute.size() - 1).build();
  }
  
  public LocalityLoadBalancerSettingFailover buildLastFailover() {
    return this.failover.get(failover.size() - 1).build();
  }
  
  public LocalityLoadBalancerSettingDistribute buildMatchingDistribute(Predicate<LocalityLoadBalancerSettingDistributeBuilder> predicate) {
      for (LocalityLoadBalancerSettingDistributeBuilder item : distribute) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public LocalityLoadBalancerSettingFailover buildMatchingFailover(Predicate<LocalityLoadBalancerSettingFailoverBuilder> predicate) {
      for (LocalityLoadBalancerSettingFailoverBuilder item : failover) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(LocalityLoadBalancerSetting instance) {
    instance = instance != null ? instance : new LocalityLoadBalancerSetting();
    if (instance != null) {
        this.withDistribute(instance.getDistribute());
        this.withEnabled(instance.getEnabled());
        this.withFailover(instance.getFailover());
        this.withFailoverPriority(instance.getFailoverPriority());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public DistributeNested<A> editDistribute(int index) {
    if (distribute.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "distribute"));
    }
    return this.setNewDistributeLike(index, this.buildDistribute(index));
  }
  
  public FailoverNested<A> editFailover(int index) {
    if (failover.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "failover"));
    }
    return this.setNewFailoverLike(index, this.buildFailover(index));
  }
  
  public DistributeNested<A> editFirstDistribute() {
    if (distribute.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "distribute"));
    }
    return this.setNewDistributeLike(0, this.buildDistribute(0));
  }
  
  public FailoverNested<A> editFirstFailover() {
    if (failover.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "failover"));
    }
    return this.setNewFailoverLike(0, this.buildFailover(0));
  }
  
  public DistributeNested<A> editLastDistribute() {
    int index = distribute.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "distribute"));
    }
    return this.setNewDistributeLike(index, this.buildDistribute(index));
  }
  
  public FailoverNested<A> editLastFailover() {
    int index = failover.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "failover"));
    }
    return this.setNewFailoverLike(index, this.buildFailover(index));
  }
  
  public DistributeNested<A> editMatchingDistribute(Predicate<LocalityLoadBalancerSettingDistributeBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < distribute.size();i++) {
      if (predicate.test(distribute.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "distribute"));
    }
    return this.setNewDistributeLike(index, this.buildDistribute(index));
  }
  
  public FailoverNested<A> editMatchingFailover(Predicate<LocalityLoadBalancerSettingFailoverBuilder> predicate) {
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
    LocalityLoadBalancerSettingFluent that = (LocalityLoadBalancerSettingFluent) o;
    if (!(Objects.equals(distribute, that.distribute))) {
      return false;
    }
    if (!(Objects.equals(enabled, that.enabled))) {
      return false;
    }
    if (!(Objects.equals(failover, that.failover))) {
      return false;
    }
    if (!(Objects.equals(failoverPriority, that.failoverPriority))) {
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
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDistribute() {
    return this.distribute != null && !(this.distribute.isEmpty());
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
  
  public boolean hasMatchingDistribute(Predicate<LocalityLoadBalancerSettingDistributeBuilder> predicate) {
      for (LocalityLoadBalancerSettingDistributeBuilder item : distribute) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingFailover(Predicate<LocalityLoadBalancerSettingFailoverBuilder> predicate) {
      for (LocalityLoadBalancerSettingFailoverBuilder item : failover) {
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
  
  public int hashCode() {
    return Objects.hash(distribute, enabled, failover, failoverPriority, additionalProperties);
  }
  
  public A removeAllFromDistribute(Collection<LocalityLoadBalancerSettingDistribute> items) {
    if (this.distribute == null) {
      return (A) this;
    }
    for (LocalityLoadBalancerSettingDistribute item : items) {
        LocalityLoadBalancerSettingDistributeBuilder builder = new LocalityLoadBalancerSettingDistributeBuilder(item);
        _visitables.get("distribute").remove(builder);
        this.distribute.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromFailover(Collection<LocalityLoadBalancerSettingFailover> items) {
    if (this.failover == null) {
      return (A) this;
    }
    for (LocalityLoadBalancerSettingFailover item : items) {
        LocalityLoadBalancerSettingFailoverBuilder builder = new LocalityLoadBalancerSettingFailoverBuilder(item);
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
  
  public A removeFromDistribute(LocalityLoadBalancerSettingDistribute... items) {
    if (this.distribute == null) {
      return (A) this;
    }
    for (LocalityLoadBalancerSettingDistribute item : items) {
        LocalityLoadBalancerSettingDistributeBuilder builder = new LocalityLoadBalancerSettingDistributeBuilder(item);
        _visitables.get("distribute").remove(builder);
        this.distribute.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromFailover(LocalityLoadBalancerSettingFailover... items) {
    if (this.failover == null) {
      return (A) this;
    }
    for (LocalityLoadBalancerSettingFailover item : items) {
        LocalityLoadBalancerSettingFailoverBuilder builder = new LocalityLoadBalancerSettingFailoverBuilder(item);
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
  
  public A removeMatchingFromDistribute(Predicate<LocalityLoadBalancerSettingDistributeBuilder> predicate) {
    if (distribute == null) {
      return (A) this;
    }
    Iterator<LocalityLoadBalancerSettingDistributeBuilder> each = distribute.iterator();
    List visitables = _visitables.get("distribute");
    while (each.hasNext()) {
        LocalityLoadBalancerSettingDistributeBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromFailover(Predicate<LocalityLoadBalancerSettingFailoverBuilder> predicate) {
    if (failover == null) {
      return (A) this;
    }
    Iterator<LocalityLoadBalancerSettingFailoverBuilder> each = failover.iterator();
    List visitables = _visitables.get("failover");
    while (each.hasNext()) {
        LocalityLoadBalancerSettingFailoverBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public DistributeNested<A> setNewDistributeLike(int index,LocalityLoadBalancerSettingDistribute item) {
    return new DistributeNested(index, item);
  }
  
  public FailoverNested<A> setNewFailoverLike(int index,LocalityLoadBalancerSettingFailover item) {
    return new FailoverNested(index, item);
  }
  
  public A setToDistribute(int index,LocalityLoadBalancerSettingDistribute item) {
    if (this.distribute == null) {
      this.distribute = new ArrayList();
    }
    LocalityLoadBalancerSettingDistributeBuilder builder = new LocalityLoadBalancerSettingDistributeBuilder(item);
    if (index < 0 || index >= distribute.size()) {
        _visitables.get("distribute").add(builder);
        distribute.add(builder);
    } else {
        _visitables.get("distribute").add(builder);
        distribute.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToFailover(int index,LocalityLoadBalancerSettingFailover item) {
    if (this.failover == null) {
      this.failover = new ArrayList();
    }
    LocalityLoadBalancerSettingFailoverBuilder builder = new LocalityLoadBalancerSettingFailoverBuilder(item);
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
    if (!(distribute == null) && !(distribute.isEmpty())) {
        sb.append("distribute:");
        sb.append(distribute);
        sb.append(",");
    }
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
  
  public A withDistribute(List<LocalityLoadBalancerSettingDistribute> distribute) {
    if (this.distribute != null) {
      this._visitables.get("distribute").clear();
    }
    if (distribute != null) {
        this.distribute = new ArrayList();
        for (LocalityLoadBalancerSettingDistribute item : distribute) {
          this.addToDistribute(item);
        }
    } else {
      this.distribute = null;
    }
    return (A) this;
  }
  
  public A withDistribute(LocalityLoadBalancerSettingDistribute... distribute) {
    if (this.distribute != null) {
        this.distribute.clear();
        _visitables.remove("distribute");
    }
    if (distribute != null) {
      for (LocalityLoadBalancerSettingDistribute item : distribute) {
        this.addToDistribute(item);
      }
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
  
  public A withFailover(List<LocalityLoadBalancerSettingFailover> failover) {
    if (this.failover != null) {
      this._visitables.get("failover").clear();
    }
    if (failover != null) {
        this.failover = new ArrayList();
        for (LocalityLoadBalancerSettingFailover item : failover) {
          this.addToFailover(item);
        }
    } else {
      this.failover = null;
    }
    return (A) this;
  }
  
  public A withFailover(LocalityLoadBalancerSettingFailover... failover) {
    if (this.failover != null) {
        this.failover.clear();
        _visitables.remove("failover");
    }
    if (failover != null) {
      for (LocalityLoadBalancerSettingFailover item : failover) {
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
  public class DistributeNested<N> extends LocalityLoadBalancerSettingDistributeFluent<DistributeNested<N>> implements Nested<N>{
  
    LocalityLoadBalancerSettingDistributeBuilder builder;
    int index;
  
    DistributeNested(int index,LocalityLoadBalancerSettingDistribute item) {
      this.index = index;
      this.builder = new LocalityLoadBalancerSettingDistributeBuilder(this, item);
    }
  
    public N and() {
      return (N) LocalityLoadBalancerSettingFluent.this.setToDistribute(index, builder.build());
    }
    
    public N endDistribute() {
      return and();
    }
    
  }
  public class FailoverNested<N> extends LocalityLoadBalancerSettingFailoverFluent<FailoverNested<N>> implements Nested<N>{
  
    LocalityLoadBalancerSettingFailoverBuilder builder;
    int index;
  
    FailoverNested(int index,LocalityLoadBalancerSettingFailover item) {
      this.index = index;
      this.builder = new LocalityLoadBalancerSettingFailoverBuilder(this, item);
    }
  
    public N and() {
      return (N) LocalityLoadBalancerSettingFluent.this.setToFailover(index, builder.build());
    }
    
    public N endFailover() {
      return and();
    }
    
  }
}