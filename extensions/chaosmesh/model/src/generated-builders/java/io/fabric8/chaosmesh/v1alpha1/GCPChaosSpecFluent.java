package io.fabric8.chaosmesh.v1alpha1;

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
public class GCPChaosSpecFluent<A extends io.fabric8.chaosmesh.v1alpha1.GCPChaosSpecFluent<A>> extends BaseFluent<A>{

  private String action;
  private Map<String,Object> additionalProperties;
  private List<String> deviceNames = new ArrayList<String>();
  private String duration;
  private String instance;
  private String project;
  private String remoteCluster;
  private String secretName;
  private String zone;

  public GCPChaosSpecFluent() {
  }
  
  public GCPChaosSpecFluent(GCPChaosSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToDeviceNames(Collection<String> items) {
    if (this.deviceNames == null) {
      this.deviceNames = new ArrayList();
    }
    for (String item : items) {
      this.deviceNames.add(item);
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
  
  public A addToDeviceNames(String... items) {
    if (this.deviceNames == null) {
      this.deviceNames = new ArrayList();
    }
    for (String item : items) {
      this.deviceNames.add(item);
    }
    return (A) this;
  }
  
  public A addToDeviceNames(int index,String item) {
    if (this.deviceNames == null) {
      this.deviceNames = new ArrayList();
    }
    this.deviceNames.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(GCPChaosSpec instance) {
    instance = instance != null ? instance : new GCPChaosSpec();
    if (instance != null) {
        this.withAction(instance.getAction());
        this.withDeviceNames(instance.getDeviceNames());
        this.withDuration(instance.getDuration());
        this.withInstance(instance.getInstance());
        this.withProject(instance.getProject());
        this.withRemoteCluster(instance.getRemoteCluster());
        this.withSecretName(instance.getSecretName());
        this.withZone(instance.getZone());
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
    GCPChaosSpecFluent that = (GCPChaosSpecFluent) o;
    if (!(Objects.equals(action, that.action))) {
      return false;
    }
    if (!(Objects.equals(deviceNames, that.deviceNames))) {
      return false;
    }
    if (!(Objects.equals(duration, that.duration))) {
      return false;
    }
    if (!(Objects.equals(instance, that.instance))) {
      return false;
    }
    if (!(Objects.equals(project, that.project))) {
      return false;
    }
    if (!(Objects.equals(remoteCluster, that.remoteCluster))) {
      return false;
    }
    if (!(Objects.equals(secretName, that.secretName))) {
      return false;
    }
    if (!(Objects.equals(zone, that.zone))) {
      return false;
    }
    if (!(Objects.equals(additionalProperties, that.additionalProperties))) {
      return false;
    }
    return true;
  }
  
  public String getAction() {
    return this.action;
  }
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public String getDeviceName(int index) {
    return this.deviceNames.get(index);
  }
  
  public List<String> getDeviceNames() {
    return this.deviceNames;
  }
  
  public String getDuration() {
    return this.duration;
  }
  
  public String getFirstDeviceName() {
    return this.deviceNames.get(0);
  }
  
  public String getInstance() {
    return this.instance;
  }
  
  public String getLastDeviceName() {
    return this.deviceNames.get(deviceNames.size() - 1);
  }
  
  public String getMatchingDeviceName(Predicate<String> predicate) {
      for (String item : deviceNames) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getProject() {
    return this.project;
  }
  
  public String getRemoteCluster() {
    return this.remoteCluster;
  }
  
  public String getSecretName() {
    return this.secretName;
  }
  
  public String getZone() {
    return this.zone;
  }
  
  public boolean hasAction() {
    return this.action != null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDeviceNames() {
    return this.deviceNames != null && !(this.deviceNames.isEmpty());
  }
  
  public boolean hasDuration() {
    return this.duration != null;
  }
  
  public boolean hasInstance() {
    return this.instance != null;
  }
  
  public boolean hasMatchingDeviceName(Predicate<String> predicate) {
      for (String item : deviceNames) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasProject() {
    return this.project != null;
  }
  
  public boolean hasRemoteCluster() {
    return this.remoteCluster != null;
  }
  
  public boolean hasSecretName() {
    return this.secretName != null;
  }
  
  public boolean hasZone() {
    return this.zone != null;
  }
  
  public int hashCode() {
    return Objects.hash(action, deviceNames, duration, instance, project, remoteCluster, secretName, zone, additionalProperties);
  }
  
  public A removeAllFromDeviceNames(Collection<String> items) {
    if (this.deviceNames == null) {
      return (A) this;
    }
    for (String item : items) {
      this.deviceNames.remove(item);
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
  
  public A removeFromDeviceNames(String... items) {
    if (this.deviceNames == null) {
      return (A) this;
    }
    for (String item : items) {
      this.deviceNames.remove(item);
    }
    return (A) this;
  }
  
  public A setToDeviceNames(int index,String item) {
    if (this.deviceNames == null) {
      this.deviceNames = new ArrayList();
    }
    this.deviceNames.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(action == null)) {
        sb.append("action:");
        sb.append(action);
        sb.append(",");
    }
    if (!(deviceNames == null) && !(deviceNames.isEmpty())) {
        sb.append("deviceNames:");
        sb.append(deviceNames);
        sb.append(",");
    }
    if (!(duration == null)) {
        sb.append("duration:");
        sb.append(duration);
        sb.append(",");
    }
    if (!(instance == null)) {
        sb.append("instance:");
        sb.append(instance);
        sb.append(",");
    }
    if (!(project == null)) {
        sb.append("project:");
        sb.append(project);
        sb.append(",");
    }
    if (!(remoteCluster == null)) {
        sb.append("remoteCluster:");
        sb.append(remoteCluster);
        sb.append(",");
    }
    if (!(secretName == null)) {
        sb.append("secretName:");
        sb.append(secretName);
        sb.append(",");
    }
    if (!(zone == null)) {
        sb.append("zone:");
        sb.append(zone);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public A withAction(String action) {
    this.action = action;
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
  
  public A withDeviceNames(List<String> deviceNames) {
    if (deviceNames != null) {
        this.deviceNames = new ArrayList();
        for (String item : deviceNames) {
          this.addToDeviceNames(item);
        }
    } else {
      this.deviceNames = null;
    }
    return (A) this;
  }
  
  public A withDeviceNames(String... deviceNames) {
    if (this.deviceNames != null) {
        this.deviceNames.clear();
        _visitables.remove("deviceNames");
    }
    if (deviceNames != null) {
      for (String item : deviceNames) {
        this.addToDeviceNames(item);
      }
    }
    return (A) this;
  }
  
  public A withDuration(String duration) {
    this.duration = duration;
    return (A) this;
  }
  
  public A withInstance(String instance) {
    this.instance = instance;
    return (A) this;
  }
  
  public A withProject(String project) {
    this.project = project;
    return (A) this;
  }
  
  public A withRemoteCluster(String remoteCluster) {
    this.remoteCluster = remoteCluster;
    return (A) this;
  }
  
  public A withSecretName(String secretName) {
    this.secretName = secretName;
    return (A) this;
  }
  
  public A withZone(String zone) {
    this.zone = zone;
    return (A) this;
  }
  
}