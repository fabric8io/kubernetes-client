package io.fabric8.volcano.api.model.flow.v1alpha1;

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
public class JobTemplateStatusFluent<A extends io.fabric8.volcano.api.model.flow.v1alpha1.JobTemplateStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> jobDependsOnList = new ArrayList<String>();

  public JobTemplateStatusFluent() {
  }
  
  public JobTemplateStatusFluent(JobTemplateStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToJobDependsOnList(Collection<String> items) {
    if (this.jobDependsOnList == null) {
      this.jobDependsOnList = new ArrayList();
    }
    for (String item : items) {
      this.jobDependsOnList.add(item);
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
  
  public A addToJobDependsOnList(String... items) {
    if (this.jobDependsOnList == null) {
      this.jobDependsOnList = new ArrayList();
    }
    for (String item : items) {
      this.jobDependsOnList.add(item);
    }
    return (A) this;
  }
  
  public A addToJobDependsOnList(int index,String item) {
    if (this.jobDependsOnList == null) {
      this.jobDependsOnList = new ArrayList();
    }
    this.jobDependsOnList.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(JobTemplateStatus instance) {
    instance = instance != null ? instance : new JobTemplateStatus();
    if (instance != null) {
        this.withJobDependsOnList(instance.getJobDependsOnList());
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
    JobTemplateStatusFluent that = (JobTemplateStatusFluent) o;
    if (!(Objects.equals(jobDependsOnList, that.jobDependsOnList))) {
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
  
  public String getFirstJobDependsOnList() {
    return this.jobDependsOnList.get(0);
  }
  
  public List<String> getJobDependsOnList() {
    return this.jobDependsOnList;
  }
  
  public String getJobDependsOnList(int index) {
    return this.jobDependsOnList.get(index);
  }
  
  public String getLastJobDependsOnList() {
    return this.jobDependsOnList.get(jobDependsOnList.size() - 1);
  }
  
  public String getMatchingJobDependsOnList(Predicate<String> predicate) {
      for (String item : jobDependsOnList) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasJobDependsOnList() {
    return this.jobDependsOnList != null && !(this.jobDependsOnList.isEmpty());
  }
  
  public boolean hasMatchingJobDependsOnList(Predicate<String> predicate) {
      for (String item : jobDependsOnList) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(jobDependsOnList, additionalProperties);
  }
  
  public A removeAllFromJobDependsOnList(Collection<String> items) {
    if (this.jobDependsOnList == null) {
      return (A) this;
    }
    for (String item : items) {
      this.jobDependsOnList.remove(item);
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
  
  public A removeFromJobDependsOnList(String... items) {
    if (this.jobDependsOnList == null) {
      return (A) this;
    }
    for (String item : items) {
      this.jobDependsOnList.remove(item);
    }
    return (A) this;
  }
  
  public A setToJobDependsOnList(int index,String item) {
    if (this.jobDependsOnList == null) {
      this.jobDependsOnList = new ArrayList();
    }
    this.jobDependsOnList.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(jobDependsOnList == null) && !(jobDependsOnList.isEmpty())) {
        sb.append("jobDependsOnList:");
        sb.append(jobDependsOnList);
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
  
  public A withJobDependsOnList(List<String> jobDependsOnList) {
    if (jobDependsOnList != null) {
        this.jobDependsOnList = new ArrayList();
        for (String item : jobDependsOnList) {
          this.addToJobDependsOnList(item);
        }
    } else {
      this.jobDependsOnList = null;
    }
    return (A) this;
  }
  
  public A withJobDependsOnList(String... jobDependsOnList) {
    if (this.jobDependsOnList != null) {
        this.jobDependsOnList.clear();
        _visitables.remove("jobDependsOnList");
    }
    if (jobDependsOnList != null) {
      for (String item : jobDependsOnList) {
        this.addToJobDependsOnList(item);
      }
    }
    return (A) this;
  }
  
}