package io.fabric8.openclustermanagement.api.model.apps.v1;

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
public class AnsibleJobsStatusFluent<A extends io.fabric8.openclustermanagement.api.model.apps.v1.AnsibleJobsStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String lastposthookjob;
  private String lastprehookjob;
  private List<String> posthookjobshistory = new ArrayList<String>();
  private List<String> prehookjobshistory = new ArrayList<String>();

  public AnsibleJobsStatusFluent() {
  }
  
  public AnsibleJobsStatusFluent(AnsibleJobsStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToPosthookjobshistory(Collection<String> items) {
    if (this.posthookjobshistory == null) {
      this.posthookjobshistory = new ArrayList();
    }
    for (String item : items) {
      this.posthookjobshistory.add(item);
    }
    return (A) this;
  }
  
  public A addAllToPrehookjobshistory(Collection<String> items) {
    if (this.prehookjobshistory == null) {
      this.prehookjobshistory = new ArrayList();
    }
    for (String item : items) {
      this.prehookjobshistory.add(item);
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
  
  public A addToPosthookjobshistory(String... items) {
    if (this.posthookjobshistory == null) {
      this.posthookjobshistory = new ArrayList();
    }
    for (String item : items) {
      this.posthookjobshistory.add(item);
    }
    return (A) this;
  }
  
  public A addToPosthookjobshistory(int index,String item) {
    if (this.posthookjobshistory == null) {
      this.posthookjobshistory = new ArrayList();
    }
    this.posthookjobshistory.add(index, item);
    return (A) this;
  }
  
  public A addToPrehookjobshistory(String... items) {
    if (this.prehookjobshistory == null) {
      this.prehookjobshistory = new ArrayList();
    }
    for (String item : items) {
      this.prehookjobshistory.add(item);
    }
    return (A) this;
  }
  
  public A addToPrehookjobshistory(int index,String item) {
    if (this.prehookjobshistory == null) {
      this.prehookjobshistory = new ArrayList();
    }
    this.prehookjobshistory.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(AnsibleJobsStatus instance) {
    instance = instance != null ? instance : new AnsibleJobsStatus();
    if (instance != null) {
        this.withLastposthookjob(instance.getLastposthookjob());
        this.withLastprehookjob(instance.getLastprehookjob());
        this.withPosthookjobshistory(instance.getPosthookjobshistory());
        this.withPrehookjobshistory(instance.getPrehookjobshistory());
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
    AnsibleJobsStatusFluent that = (AnsibleJobsStatusFluent) o;
    if (!(Objects.equals(lastposthookjob, that.lastposthookjob))) {
      return false;
    }
    if (!(Objects.equals(lastprehookjob, that.lastprehookjob))) {
      return false;
    }
    if (!(Objects.equals(posthookjobshistory, that.posthookjobshistory))) {
      return false;
    }
    if (!(Objects.equals(prehookjobshistory, that.prehookjobshistory))) {
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
  
  public String getFirstPosthookjobshistory() {
    return this.posthookjobshistory.get(0);
  }
  
  public String getFirstPrehookjobshistory() {
    return this.prehookjobshistory.get(0);
  }
  
  public String getLastPosthookjobshistory() {
    return this.posthookjobshistory.get(posthookjobshistory.size() - 1);
  }
  
  public String getLastPrehookjobshistory() {
    return this.prehookjobshistory.get(prehookjobshistory.size() - 1);
  }
  
  public String getLastposthookjob() {
    return this.lastposthookjob;
  }
  
  public String getLastprehookjob() {
    return this.lastprehookjob;
  }
  
  public String getMatchingPosthookjobshistory(Predicate<String> predicate) {
      for (String item : posthookjobshistory) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingPrehookjobshistory(Predicate<String> predicate) {
      for (String item : prehookjobshistory) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public List<String> getPosthookjobshistory() {
    return this.posthookjobshistory;
  }
  
  public String getPosthookjobshistory(int index) {
    return this.posthookjobshistory.get(index);
  }
  
  public List<String> getPrehookjobshistory() {
    return this.prehookjobshistory;
  }
  
  public String getPrehookjobshistory(int index) {
    return this.prehookjobshistory.get(index);
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasLastposthookjob() {
    return this.lastposthookjob != null;
  }
  
  public boolean hasLastprehookjob() {
    return this.lastprehookjob != null;
  }
  
  public boolean hasMatchingPosthookjobshistory(Predicate<String> predicate) {
      for (String item : posthookjobshistory) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingPrehookjobshistory(Predicate<String> predicate) {
      for (String item : prehookjobshistory) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPosthookjobshistory() {
    return this.posthookjobshistory != null && !(this.posthookjobshistory.isEmpty());
  }
  
  public boolean hasPrehookjobshistory() {
    return this.prehookjobshistory != null && !(this.prehookjobshistory.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(lastposthookjob, lastprehookjob, posthookjobshistory, prehookjobshistory, additionalProperties);
  }
  
  public A removeAllFromPosthookjobshistory(Collection<String> items) {
    if (this.posthookjobshistory == null) {
      return (A) this;
    }
    for (String item : items) {
      this.posthookjobshistory.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromPrehookjobshistory(Collection<String> items) {
    if (this.prehookjobshistory == null) {
      return (A) this;
    }
    for (String item : items) {
      this.prehookjobshistory.remove(item);
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
  
  public A removeFromPosthookjobshistory(String... items) {
    if (this.posthookjobshistory == null) {
      return (A) this;
    }
    for (String item : items) {
      this.posthookjobshistory.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromPrehookjobshistory(String... items) {
    if (this.prehookjobshistory == null) {
      return (A) this;
    }
    for (String item : items) {
      this.prehookjobshistory.remove(item);
    }
    return (A) this;
  }
  
  public A setToPosthookjobshistory(int index,String item) {
    if (this.posthookjobshistory == null) {
      this.posthookjobshistory = new ArrayList();
    }
    this.posthookjobshistory.set(index, item);
    return (A) this;
  }
  
  public A setToPrehookjobshistory(int index,String item) {
    if (this.prehookjobshistory == null) {
      this.prehookjobshistory = new ArrayList();
    }
    this.prehookjobshistory.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(lastposthookjob == null)) {
        sb.append("lastposthookjob:");
        sb.append(lastposthookjob);
        sb.append(",");
    }
    if (!(lastprehookjob == null)) {
        sb.append("lastprehookjob:");
        sb.append(lastprehookjob);
        sb.append(",");
    }
    if (!(posthookjobshistory == null) && !(posthookjobshistory.isEmpty())) {
        sb.append("posthookjobshistory:");
        sb.append(posthookjobshistory);
        sb.append(",");
    }
    if (!(prehookjobshistory == null) && !(prehookjobshistory.isEmpty())) {
        sb.append("prehookjobshistory:");
        sb.append(prehookjobshistory);
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
  
  public A withLastposthookjob(String lastposthookjob) {
    this.lastposthookjob = lastposthookjob;
    return (A) this;
  }
  
  public A withLastprehookjob(String lastprehookjob) {
    this.lastprehookjob = lastprehookjob;
    return (A) this;
  }
  
  public A withPosthookjobshistory(List<String> posthookjobshistory) {
    if (posthookjobshistory != null) {
        this.posthookjobshistory = new ArrayList();
        for (String item : posthookjobshistory) {
          this.addToPosthookjobshistory(item);
        }
    } else {
      this.posthookjobshistory = null;
    }
    return (A) this;
  }
  
  public A withPosthookjobshistory(String... posthookjobshistory) {
    if (this.posthookjobshistory != null) {
        this.posthookjobshistory.clear();
        _visitables.remove("posthookjobshistory");
    }
    if (posthookjobshistory != null) {
      for (String item : posthookjobshistory) {
        this.addToPosthookjobshistory(item);
      }
    }
    return (A) this;
  }
  
  public A withPrehookjobshistory(List<String> prehookjobshistory) {
    if (prehookjobshistory != null) {
        this.prehookjobshistory = new ArrayList();
        for (String item : prehookjobshistory) {
          this.addToPrehookjobshistory(item);
        }
    } else {
      this.prehookjobshistory = null;
    }
    return (A) this;
  }
  
  public A withPrehookjobshistory(String... prehookjobshistory) {
    if (this.prehookjobshistory != null) {
        this.prehookjobshistory.clear();
        _visitables.remove("prehookjobshistory");
    }
    if (prehookjobshistory != null) {
      for (String item : prehookjobshistory) {
        this.addToPrehookjobshistory(item);
      }
    }
    return (A) this;
  }
  
}