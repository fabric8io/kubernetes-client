package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
public class AlertingSpecFluent<A extends io.fabric8.openshift.api.model.monitoring.v1.AlertingSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<AlertmanagerEndpointsBuilder> alertmanagers = new ArrayList<AlertmanagerEndpointsBuilder>();

  public AlertingSpecFluent() {
  }
  
  public AlertingSpecFluent(AlertingSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToAlertmanagers(Collection<AlertmanagerEndpoints> items) {
    if (this.alertmanagers == null) {
      this.alertmanagers = new ArrayList();
    }
    for (AlertmanagerEndpoints item : items) {
        AlertmanagerEndpointsBuilder builder = new AlertmanagerEndpointsBuilder(item);
        _visitables.get("alertmanagers").add(builder);
        this.alertmanagers.add(builder);
    }
    return (A) this;
  }
  
  public AlertmanagersNested<A> addNewAlertmanager() {
    return new AlertmanagersNested(-1, null);
  }
  
  public AlertmanagersNested<A> addNewAlertmanagerLike(AlertmanagerEndpoints item) {
    return new AlertmanagersNested(-1, item);
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
  
  public A addToAlertmanagers(AlertmanagerEndpoints... items) {
    if (this.alertmanagers == null) {
      this.alertmanagers = new ArrayList();
    }
    for (AlertmanagerEndpoints item : items) {
        AlertmanagerEndpointsBuilder builder = new AlertmanagerEndpointsBuilder(item);
        _visitables.get("alertmanagers").add(builder);
        this.alertmanagers.add(builder);
    }
    return (A) this;
  }
  
  public A addToAlertmanagers(int index,AlertmanagerEndpoints item) {
    if (this.alertmanagers == null) {
      this.alertmanagers = new ArrayList();
    }
    AlertmanagerEndpointsBuilder builder = new AlertmanagerEndpointsBuilder(item);
    if (index < 0 || index >= alertmanagers.size()) {
        _visitables.get("alertmanagers").add(builder);
        alertmanagers.add(builder);
    } else {
        _visitables.get("alertmanagers").add(builder);
        alertmanagers.add(index, builder);
    }
    return (A) this;
  }
  
  public AlertmanagerEndpoints buildAlertmanager(int index) {
    return this.alertmanagers.get(index).build();
  }
  
  public List<AlertmanagerEndpoints> buildAlertmanagers() {
    return this.alertmanagers != null ? build(alertmanagers) : null;
  }
  
  public AlertmanagerEndpoints buildFirstAlertmanager() {
    return this.alertmanagers.get(0).build();
  }
  
  public AlertmanagerEndpoints buildLastAlertmanager() {
    return this.alertmanagers.get(alertmanagers.size() - 1).build();
  }
  
  public AlertmanagerEndpoints buildMatchingAlertmanager(Predicate<AlertmanagerEndpointsBuilder> predicate) {
      for (AlertmanagerEndpointsBuilder item : alertmanagers) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(AlertingSpec instance) {
    instance = instance != null ? instance : new AlertingSpec();
    if (instance != null) {
        this.withAlertmanagers(instance.getAlertmanagers());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AlertmanagersNested<A> editAlertmanager(int index) {
    if (alertmanagers.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "alertmanagers"));
    }
    return this.setNewAlertmanagerLike(index, this.buildAlertmanager(index));
  }
  
  public AlertmanagersNested<A> editFirstAlertmanager() {
    if (alertmanagers.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "alertmanagers"));
    }
    return this.setNewAlertmanagerLike(0, this.buildAlertmanager(0));
  }
  
  public AlertmanagersNested<A> editLastAlertmanager() {
    int index = alertmanagers.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "alertmanagers"));
    }
    return this.setNewAlertmanagerLike(index, this.buildAlertmanager(index));
  }
  
  public AlertmanagersNested<A> editMatchingAlertmanager(Predicate<AlertmanagerEndpointsBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < alertmanagers.size();i++) {
      if (predicate.test(alertmanagers.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "alertmanagers"));
    }
    return this.setNewAlertmanagerLike(index, this.buildAlertmanager(index));
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
    AlertingSpecFluent that = (AlertingSpecFluent) o;
    if (!(Objects.equals(alertmanagers, that.alertmanagers))) {
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
  
  public boolean hasAlertmanagers() {
    return this.alertmanagers != null && !(this.alertmanagers.isEmpty());
  }
  
  public boolean hasMatchingAlertmanager(Predicate<AlertmanagerEndpointsBuilder> predicate) {
      for (AlertmanagerEndpointsBuilder item : alertmanagers) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(alertmanagers, additionalProperties);
  }
  
  public A removeAllFromAlertmanagers(Collection<AlertmanagerEndpoints> items) {
    if (this.alertmanagers == null) {
      return (A) this;
    }
    for (AlertmanagerEndpoints item : items) {
        AlertmanagerEndpointsBuilder builder = new AlertmanagerEndpointsBuilder(item);
        _visitables.get("alertmanagers").remove(builder);
        this.alertmanagers.remove(builder);
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
  
  public A removeFromAlertmanagers(AlertmanagerEndpoints... items) {
    if (this.alertmanagers == null) {
      return (A) this;
    }
    for (AlertmanagerEndpoints item : items) {
        AlertmanagerEndpointsBuilder builder = new AlertmanagerEndpointsBuilder(item);
        _visitables.get("alertmanagers").remove(builder);
        this.alertmanagers.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromAlertmanagers(Predicate<AlertmanagerEndpointsBuilder> predicate) {
    if (alertmanagers == null) {
      return (A) this;
    }
    Iterator<AlertmanagerEndpointsBuilder> each = alertmanagers.iterator();
    List visitables = _visitables.get("alertmanagers");
    while (each.hasNext()) {
        AlertmanagerEndpointsBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public AlertmanagersNested<A> setNewAlertmanagerLike(int index,AlertmanagerEndpoints item) {
    return new AlertmanagersNested(index, item);
  }
  
  public A setToAlertmanagers(int index,AlertmanagerEndpoints item) {
    if (this.alertmanagers == null) {
      this.alertmanagers = new ArrayList();
    }
    AlertmanagerEndpointsBuilder builder = new AlertmanagerEndpointsBuilder(item);
    if (index < 0 || index >= alertmanagers.size()) {
        _visitables.get("alertmanagers").add(builder);
        alertmanagers.add(builder);
    } else {
        _visitables.get("alertmanagers").add(builder);
        alertmanagers.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(alertmanagers == null) && !(alertmanagers.isEmpty())) {
        sb.append("alertmanagers:");
        sb.append(alertmanagers);
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
  
  public A withAlertmanagers(List<AlertmanagerEndpoints> alertmanagers) {
    if (this.alertmanagers != null) {
      this._visitables.get("alertmanagers").clear();
    }
    if (alertmanagers != null) {
        this.alertmanagers = new ArrayList();
        for (AlertmanagerEndpoints item : alertmanagers) {
          this.addToAlertmanagers(item);
        }
    } else {
      this.alertmanagers = null;
    }
    return (A) this;
  }
  
  public A withAlertmanagers(AlertmanagerEndpoints... alertmanagers) {
    if (this.alertmanagers != null) {
        this.alertmanagers.clear();
        _visitables.remove("alertmanagers");
    }
    if (alertmanagers != null) {
      for (AlertmanagerEndpoints item : alertmanagers) {
        this.addToAlertmanagers(item);
      }
    }
    return (A) this;
  }
  public class AlertmanagersNested<N> extends AlertmanagerEndpointsFluent<AlertmanagersNested<N>> implements Nested<N>{
  
    AlertmanagerEndpointsBuilder builder;
    int index;
  
    AlertmanagersNested(int index,AlertmanagerEndpoints item) {
      this.index = index;
      this.builder = new AlertmanagerEndpointsBuilder(this, item);
    }
  
    public N and() {
      return (N) AlertingSpecFluent.this.setToAlertmanagers(index, builder.build());
    }
    
    public N endAlertmanager() {
      return and();
    }
    
  }
}