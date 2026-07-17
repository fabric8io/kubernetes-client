package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.model.rbac.Subject;
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
public class ClusterClaimSpecFluent<A extends io.fabric8.openshift.api.model.hive.v1.ClusterClaimSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String clusterPoolName;
  private String lifetime;
  private String namespace;
  private List<Subject> subjects = new ArrayList<Subject>();

  public ClusterClaimSpecFluent() {
  }
  
  public ClusterClaimSpecFluent(ClusterClaimSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToSubjects(Collection<Subject> items) {
    if (this.subjects == null) {
      this.subjects = new ArrayList();
    }
    for (Subject item : items) {
      this.subjects.add(item);
    }
    return (A) this;
  }
  
  public A addNewSubject(String apiGroup,String kind,String name,String namespace) {
    return (A) this.addToSubjects(new Subject(apiGroup, kind, name, namespace));
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
  
  public A addToSubjects(Subject... items) {
    if (this.subjects == null) {
      this.subjects = new ArrayList();
    }
    for (Subject item : items) {
      this.subjects.add(item);
    }
    return (A) this;
  }
  
  public A addToSubjects(int index,Subject item) {
    if (this.subjects == null) {
      this.subjects = new ArrayList();
    }
    this.subjects.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(ClusterClaimSpec instance) {
    instance = instance != null ? instance : new ClusterClaimSpec();
    if (instance != null) {
        this.withClusterPoolName(instance.getClusterPoolName());
        this.withLifetime(instance.getLifetime());
        this.withNamespace(instance.getNamespace());
        this.withSubjects(instance.getSubjects());
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
    ClusterClaimSpecFluent that = (ClusterClaimSpecFluent) o;
    if (!(Objects.equals(clusterPoolName, that.clusterPoolName))) {
      return false;
    }
    if (!(Objects.equals(lifetime, that.lifetime))) {
      return false;
    }
    if (!(Objects.equals(namespace, that.namespace))) {
      return false;
    }
    if (!(Objects.equals(subjects, that.subjects))) {
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
  
  public String getClusterPoolName() {
    return this.clusterPoolName;
  }
  
  public Subject getFirstSubject() {
    return this.subjects.get(0);
  }
  
  public Subject getLastSubject() {
    return this.subjects.get(subjects.size() - 1);
  }
  
  public String getLifetime() {
    return this.lifetime;
  }
  
  public Subject getMatchingSubject(Predicate<Subject> predicate) {
      for (Subject item : subjects) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getNamespace() {
    return this.namespace;
  }
  
  public Subject getSubject(int index) {
    return this.subjects.get(index);
  }
  
  public List<Subject> getSubjects() {
    return this.subjects;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasClusterPoolName() {
    return this.clusterPoolName != null;
  }
  
  public boolean hasLifetime() {
    return this.lifetime != null;
  }
  
  public boolean hasMatchingSubject(Predicate<Subject> predicate) {
      for (Subject item : subjects) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNamespace() {
    return this.namespace != null;
  }
  
  public boolean hasSubjects() {
    return this.subjects != null && !(this.subjects.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(clusterPoolName, lifetime, namespace, subjects, additionalProperties);
  }
  
  public A removeAllFromSubjects(Collection<Subject> items) {
    if (this.subjects == null) {
      return (A) this;
    }
    for (Subject item : items) {
      this.subjects.remove(item);
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
  
  public A removeFromSubjects(Subject... items) {
    if (this.subjects == null) {
      return (A) this;
    }
    for (Subject item : items) {
      this.subjects.remove(item);
    }
    return (A) this;
  }
  
  public A setToSubjects(int index,Subject item) {
    if (this.subjects == null) {
      this.subjects = new ArrayList();
    }
    this.subjects.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(clusterPoolName == null)) {
        sb.append("clusterPoolName:");
        sb.append(clusterPoolName);
        sb.append(",");
    }
    if (!(lifetime == null)) {
        sb.append("lifetime:");
        sb.append(lifetime);
        sb.append(",");
    }
    if (!(namespace == null)) {
        sb.append("namespace:");
        sb.append(namespace);
        sb.append(",");
    }
    if (!(subjects == null) && !(subjects.isEmpty())) {
        sb.append("subjects:");
        sb.append(subjects);
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
  
  public A withClusterPoolName(String clusterPoolName) {
    this.clusterPoolName = clusterPoolName;
    return (A) this;
  }
  
  public A withLifetime(String lifetime) {
    this.lifetime = lifetime;
    return (A) this;
  }
  
  public A withNamespace(String namespace) {
    this.namespace = namespace;
    return (A) this;
  }
  
  public A withSubjects(List<Subject> subjects) {
    if (subjects != null) {
        this.subjects = new ArrayList();
        for (Subject item : subjects) {
          this.addToSubjects(item);
        }
    } else {
      this.subjects = null;
    }
    return (A) this;
  }
  
  public A withSubjects(Subject... subjects) {
    if (this.subjects != null) {
        this.subjects.clear();
        _visitables.remove("subjects");
    }
    if (subjects != null) {
      for (Subject item : subjects) {
        this.addToSubjects(item);
      }
    }
    return (A) this;
  }
  
}