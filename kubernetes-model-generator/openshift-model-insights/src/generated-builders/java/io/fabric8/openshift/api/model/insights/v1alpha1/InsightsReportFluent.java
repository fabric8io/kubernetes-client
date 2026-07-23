package io.fabric8.openshift.api.model.insights.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
public class InsightsReportFluent<A extends io.fabric8.openshift.api.model.insights.v1alpha1.InsightsReportFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String downloadedAt;
  private ArrayList<HealthCheckBuilder> healthChecks = new ArrayList<HealthCheckBuilder>();
  private String uri;

  public InsightsReportFluent() {
  }
  
  public InsightsReportFluent(InsightsReport instance) {
    this.copyInstance(instance);
  }

  public A addAllToHealthChecks(Collection<HealthCheck> items) {
    if (this.healthChecks == null) {
      this.healthChecks = new ArrayList();
    }
    for (HealthCheck item : items) {
        HealthCheckBuilder builder = new HealthCheckBuilder(item);
        _visitables.get("healthChecks").add(builder);
        this.healthChecks.add(builder);
    }
    return (A) this;
  }
  
  public HealthChecksNested<A> addNewHealthCheck() {
    return new HealthChecksNested(-1, null);
  }
  
  public A addNewHealthCheck(String advisorURI,String description,String state,Integer totalRisk) {
    return (A) this.addToHealthChecks(new HealthCheck(advisorURI, description, state, totalRisk));
  }
  
  public HealthChecksNested<A> addNewHealthCheckLike(HealthCheck item) {
    return new HealthChecksNested(-1, item);
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
  
  public A addToHealthChecks(HealthCheck... items) {
    if (this.healthChecks == null) {
      this.healthChecks = new ArrayList();
    }
    for (HealthCheck item : items) {
        HealthCheckBuilder builder = new HealthCheckBuilder(item);
        _visitables.get("healthChecks").add(builder);
        this.healthChecks.add(builder);
    }
    return (A) this;
  }
  
  public A addToHealthChecks(int index,HealthCheck item) {
    if (this.healthChecks == null) {
      this.healthChecks = new ArrayList();
    }
    HealthCheckBuilder builder = new HealthCheckBuilder(item);
    if (index < 0 || index >= healthChecks.size()) {
        _visitables.get("healthChecks").add(builder);
        healthChecks.add(builder);
    } else {
        _visitables.get("healthChecks").add(builder);
        healthChecks.add(index, builder);
    }
    return (A) this;
  }
  
  public HealthCheck buildFirstHealthCheck() {
    return this.healthChecks.get(0).build();
  }
  
  public HealthCheck buildHealthCheck(int index) {
    return this.healthChecks.get(index).build();
  }
  
  public List<HealthCheck> buildHealthChecks() {
    return this.healthChecks != null ? build(healthChecks) : null;
  }
  
  public HealthCheck buildLastHealthCheck() {
    return this.healthChecks.get(healthChecks.size() - 1).build();
  }
  
  public HealthCheck buildMatchingHealthCheck(Predicate<HealthCheckBuilder> predicate) {
      for (HealthCheckBuilder item : healthChecks) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(InsightsReport instance) {
    instance = instance != null ? instance : new InsightsReport();
    if (instance != null) {
        this.withDownloadedAt(instance.getDownloadedAt());
        this.withHealthChecks(instance.getHealthChecks());
        this.withUri(instance.getUri());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public HealthChecksNested<A> editFirstHealthCheck() {
    if (healthChecks.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "healthChecks"));
    }
    return this.setNewHealthCheckLike(0, this.buildHealthCheck(0));
  }
  
  public HealthChecksNested<A> editHealthCheck(int index) {
    if (healthChecks.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "healthChecks"));
    }
    return this.setNewHealthCheckLike(index, this.buildHealthCheck(index));
  }
  
  public HealthChecksNested<A> editLastHealthCheck() {
    int index = healthChecks.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "healthChecks"));
    }
    return this.setNewHealthCheckLike(index, this.buildHealthCheck(index));
  }
  
  public HealthChecksNested<A> editMatchingHealthCheck(Predicate<HealthCheckBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < healthChecks.size();i++) {
      if (predicate.test(healthChecks.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "healthChecks"));
    }
    return this.setNewHealthCheckLike(index, this.buildHealthCheck(index));
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
    InsightsReportFluent that = (InsightsReportFluent) o;
    if (!(Objects.equals(downloadedAt, that.downloadedAt))) {
      return false;
    }
    if (!(Objects.equals(healthChecks, that.healthChecks))) {
      return false;
    }
    if (!(Objects.equals(uri, that.uri))) {
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
  
  public String getDownloadedAt() {
    return this.downloadedAt;
  }
  
  public String getUri() {
    return this.uri;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDownloadedAt() {
    return this.downloadedAt != null;
  }
  
  public boolean hasHealthChecks() {
    return this.healthChecks != null && !(this.healthChecks.isEmpty());
  }
  
  public boolean hasMatchingHealthCheck(Predicate<HealthCheckBuilder> predicate) {
      for (HealthCheckBuilder item : healthChecks) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasUri() {
    return this.uri != null;
  }
  
  public int hashCode() {
    return Objects.hash(downloadedAt, healthChecks, uri, additionalProperties);
  }
  
  public A removeAllFromHealthChecks(Collection<HealthCheck> items) {
    if (this.healthChecks == null) {
      return (A) this;
    }
    for (HealthCheck item : items) {
        HealthCheckBuilder builder = new HealthCheckBuilder(item);
        _visitables.get("healthChecks").remove(builder);
        this.healthChecks.remove(builder);
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
  
  public A removeFromHealthChecks(HealthCheck... items) {
    if (this.healthChecks == null) {
      return (A) this;
    }
    for (HealthCheck item : items) {
        HealthCheckBuilder builder = new HealthCheckBuilder(item);
        _visitables.get("healthChecks").remove(builder);
        this.healthChecks.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromHealthChecks(Predicate<HealthCheckBuilder> predicate) {
    if (healthChecks == null) {
      return (A) this;
    }
    Iterator<HealthCheckBuilder> each = healthChecks.iterator();
    List visitables = _visitables.get("healthChecks");
    while (each.hasNext()) {
        HealthCheckBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public HealthChecksNested<A> setNewHealthCheckLike(int index,HealthCheck item) {
    return new HealthChecksNested(index, item);
  }
  
  public A setToHealthChecks(int index,HealthCheck item) {
    if (this.healthChecks == null) {
      this.healthChecks = new ArrayList();
    }
    HealthCheckBuilder builder = new HealthCheckBuilder(item);
    if (index < 0 || index >= healthChecks.size()) {
        _visitables.get("healthChecks").add(builder);
        healthChecks.add(builder);
    } else {
        _visitables.get("healthChecks").add(builder);
        healthChecks.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(downloadedAt == null)) {
        sb.append("downloadedAt:");
        sb.append(downloadedAt);
        sb.append(",");
    }
    if (!(healthChecks == null) && !(healthChecks.isEmpty())) {
        sb.append("healthChecks:");
        sb.append(healthChecks);
        sb.append(",");
    }
    if (!(uri == null)) {
        sb.append("uri:");
        sb.append(uri);
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
  
  public A withDownloadedAt(String downloadedAt) {
    this.downloadedAt = downloadedAt;
    return (A) this;
  }
  
  public A withHealthChecks(List<HealthCheck> healthChecks) {
    if (this.healthChecks != null) {
      this._visitables.get("healthChecks").clear();
    }
    if (healthChecks != null) {
        this.healthChecks = new ArrayList();
        for (HealthCheck item : healthChecks) {
          this.addToHealthChecks(item);
        }
    } else {
      this.healthChecks = null;
    }
    return (A) this;
  }
  
  public A withHealthChecks(HealthCheck... healthChecks) {
    if (this.healthChecks != null) {
        this.healthChecks.clear();
        _visitables.remove("healthChecks");
    }
    if (healthChecks != null) {
      for (HealthCheck item : healthChecks) {
        this.addToHealthChecks(item);
      }
    }
    return (A) this;
  }
  
  public A withUri(String uri) {
    this.uri = uri;
    return (A) this;
  }
  public class HealthChecksNested<N> extends HealthCheckFluent<HealthChecksNested<N>> implements Nested<N>{
  
    HealthCheckBuilder builder;
    int index;
  
    HealthChecksNested(int index,HealthCheck item) {
      this.index = index;
      this.builder = new HealthCheckBuilder(this, item);
    }
  
    public N and() {
      return (N) InsightsReportFluent.this.setToHealthChecks(index, builder.build());
    }
    
    public N endHealthCheck() {
      return and();
    }
    
  }
}