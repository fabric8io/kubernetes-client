package io.fabric8.openshift.api.model.installer.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.openshift.api.model.installer.gcp.v1.QuotaUsage;
import io.fabric8.openshift.api.model.installer.gcp.v1.QuotaUsageBuilder;
import io.fabric8.openshift.api.model.installer.gcp.v1.QuotaUsageFluent;
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
public class ClusterQuotaFluent<A extends io.fabric8.openshift.api.model.installer.v1.ClusterQuotaFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<QuotaUsageBuilder> gcp = new ArrayList<QuotaUsageBuilder>();

  public ClusterQuotaFluent() {
  }
  
  public ClusterQuotaFluent(ClusterQuota instance) {
    this.copyInstance(instance);
  }

  public A addAllToGcp(Collection<QuotaUsage> items) {
    if (this.gcp == null) {
      this.gcp = new ArrayList();
    }
    for (QuotaUsage item : items) {
        QuotaUsageBuilder builder = new QuotaUsageBuilder(item);
        _visitables.get("gcp").add(builder);
        this.gcp.add(builder);
    }
    return (A) this;
  }
  
  public GcpNested<A> addNewGcp() {
    return new GcpNested(-1, null);
  }
  
  public GcpNested<A> addNewGcpLike(QuotaUsage item) {
    return new GcpNested(-1, item);
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
  
  public A addToGcp(QuotaUsage... items) {
    if (this.gcp == null) {
      this.gcp = new ArrayList();
    }
    for (QuotaUsage item : items) {
        QuotaUsageBuilder builder = new QuotaUsageBuilder(item);
        _visitables.get("gcp").add(builder);
        this.gcp.add(builder);
    }
    return (A) this;
  }
  
  public A addToGcp(int index,QuotaUsage item) {
    if (this.gcp == null) {
      this.gcp = new ArrayList();
    }
    QuotaUsageBuilder builder = new QuotaUsageBuilder(item);
    if (index < 0 || index >= gcp.size()) {
        _visitables.get("gcp").add(builder);
        gcp.add(builder);
    } else {
        _visitables.get("gcp").add(builder);
        gcp.add(index, builder);
    }
    return (A) this;
  }
  
  public QuotaUsage buildFirstGcp() {
    return this.gcp.get(0).build();
  }
  
  public List<QuotaUsage> buildGcp() {
    return this.gcp != null ? build(gcp) : null;
  }
  
  public QuotaUsage buildGcp(int index) {
    return this.gcp.get(index).build();
  }
  
  public QuotaUsage buildLastGcp() {
    return this.gcp.get(gcp.size() - 1).build();
  }
  
  public QuotaUsage buildMatchingGcp(Predicate<QuotaUsageBuilder> predicate) {
      for (QuotaUsageBuilder item : gcp) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(ClusterQuota instance) {
    instance = instance != null ? instance : new ClusterQuota();
    if (instance != null) {
        this.withGcp(instance.getGcp());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public GcpNested<A> editFirstGcp() {
    if (gcp.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "gcp"));
    }
    return this.setNewGcpLike(0, this.buildGcp(0));
  }
  
  public GcpNested<A> editGcp(int index) {
    if (gcp.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "gcp"));
    }
    return this.setNewGcpLike(index, this.buildGcp(index));
  }
  
  public GcpNested<A> editLastGcp() {
    int index = gcp.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "gcp"));
    }
    return this.setNewGcpLike(index, this.buildGcp(index));
  }
  
  public GcpNested<A> editMatchingGcp(Predicate<QuotaUsageBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < gcp.size();i++) {
      if (predicate.test(gcp.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "gcp"));
    }
    return this.setNewGcpLike(index, this.buildGcp(index));
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
    ClusterQuotaFluent that = (ClusterQuotaFluent) o;
    if (!(Objects.equals(gcp, that.gcp))) {
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
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasGcp() {
    return this.gcp != null && !(this.gcp.isEmpty());
  }
  
  public boolean hasMatchingGcp(Predicate<QuotaUsageBuilder> predicate) {
      for (QuotaUsageBuilder item : gcp) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(gcp, additionalProperties);
  }
  
  public A removeAllFromGcp(Collection<QuotaUsage> items) {
    if (this.gcp == null) {
      return (A) this;
    }
    for (QuotaUsage item : items) {
        QuotaUsageBuilder builder = new QuotaUsageBuilder(item);
        _visitables.get("gcp").remove(builder);
        this.gcp.remove(builder);
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
  
  public A removeFromGcp(QuotaUsage... items) {
    if (this.gcp == null) {
      return (A) this;
    }
    for (QuotaUsage item : items) {
        QuotaUsageBuilder builder = new QuotaUsageBuilder(item);
        _visitables.get("gcp").remove(builder);
        this.gcp.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromGcp(Predicate<QuotaUsageBuilder> predicate) {
    if (gcp == null) {
      return (A) this;
    }
    Iterator<QuotaUsageBuilder> each = gcp.iterator();
    List visitables = _visitables.get("gcp");
    while (each.hasNext()) {
        QuotaUsageBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public GcpNested<A> setNewGcpLike(int index,QuotaUsage item) {
    return new GcpNested(index, item);
  }
  
  public A setToGcp(int index,QuotaUsage item) {
    if (this.gcp == null) {
      this.gcp = new ArrayList();
    }
    QuotaUsageBuilder builder = new QuotaUsageBuilder(item);
    if (index < 0 || index >= gcp.size()) {
        _visitables.get("gcp").add(builder);
        gcp.add(builder);
    } else {
        _visitables.get("gcp").add(builder);
        gcp.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(gcp == null) && !(gcp.isEmpty())) {
        sb.append("gcp:");
        sb.append(gcp);
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
  
  public A withGcp(List<QuotaUsage> gcp) {
    if (this.gcp != null) {
      this._visitables.get("gcp").clear();
    }
    if (gcp != null) {
        this.gcp = new ArrayList();
        for (QuotaUsage item : gcp) {
          this.addToGcp(item);
        }
    } else {
      this.gcp = null;
    }
    return (A) this;
  }
  
  public A withGcp(QuotaUsage... gcp) {
    if (this.gcp != null) {
        this.gcp.clear();
        _visitables.remove("gcp");
    }
    if (gcp != null) {
      for (QuotaUsage item : gcp) {
        this.addToGcp(item);
      }
    }
    return (A) this;
  }
  public class GcpNested<N> extends QuotaUsageFluent<GcpNested<N>> implements Nested<N>{
  
    QuotaUsageBuilder builder;
    int index;
  
    GcpNested(int index,QuotaUsage item) {
      this.index = index;
      this.builder = new QuotaUsageBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterQuotaFluent.this.setToGcp(index, builder.build());
    }
    
    public N endGcp() {
      return and();
    }
    
  }
}