package io.fabric8.openshift.api.model.config.v1;

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
public class AdmissionConfigFluent<A extends io.fabric8.openshift.api.model.config.v1.AdmissionConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> disabledPlugins = new ArrayList<String>();
  private List<String> enabledPlugins = new ArrayList<String>();
  private Map<String,AdmissionPluginConfig> pluginConfig;

  public AdmissionConfigFluent() {
  }
  
  public AdmissionConfigFluent(AdmissionConfig instance) {
    this.copyInstance(instance);
  }

  public A addAllToDisabledPlugins(Collection<String> items) {
    if (this.disabledPlugins == null) {
      this.disabledPlugins = new ArrayList();
    }
    for (String item : items) {
      this.disabledPlugins.add(item);
    }
    return (A) this;
  }
  
  public A addAllToEnabledPlugins(Collection<String> items) {
    if (this.enabledPlugins == null) {
      this.enabledPlugins = new ArrayList();
    }
    for (String item : items) {
      this.enabledPlugins.add(item);
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
  
  public A addToDisabledPlugins(String... items) {
    if (this.disabledPlugins == null) {
      this.disabledPlugins = new ArrayList();
    }
    for (String item : items) {
      this.disabledPlugins.add(item);
    }
    return (A) this;
  }
  
  public A addToDisabledPlugins(int index,String item) {
    if (this.disabledPlugins == null) {
      this.disabledPlugins = new ArrayList();
    }
    this.disabledPlugins.add(index, item);
    return (A) this;
  }
  
  public A addToEnabledPlugins(String... items) {
    if (this.enabledPlugins == null) {
      this.enabledPlugins = new ArrayList();
    }
    for (String item : items) {
      this.enabledPlugins.add(item);
    }
    return (A) this;
  }
  
  public A addToEnabledPlugins(int index,String item) {
    if (this.enabledPlugins == null) {
      this.enabledPlugins = new ArrayList();
    }
    this.enabledPlugins.add(index, item);
    return (A) this;
  }
  
  public A addToPluginConfig(Map<String,AdmissionPluginConfig> map) {
    if (this.pluginConfig == null && map != null) {
      this.pluginConfig = new LinkedHashMap();
    }
    if (map != null) {
      this.pluginConfig.putAll(map);
    }
    return (A) this;
  }
  
  public A addToPluginConfig(String key,AdmissionPluginConfig value) {
    if (this.pluginConfig == null && key != null && value != null) {
      this.pluginConfig = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.pluginConfig.put(key, value);
    }
    return (A) this;
  }
  
  protected void copyInstance(AdmissionConfig instance) {
    instance = instance != null ? instance : new AdmissionConfig();
    if (instance != null) {
        this.withDisabledPlugins(instance.getDisabledPlugins());
        this.withEnabledPlugins(instance.getEnabledPlugins());
        this.withPluginConfig(instance.getPluginConfig());
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
    AdmissionConfigFluent that = (AdmissionConfigFluent) o;
    if (!(Objects.equals(disabledPlugins, that.disabledPlugins))) {
      return false;
    }
    if (!(Objects.equals(enabledPlugins, that.enabledPlugins))) {
      return false;
    }
    if (!(Objects.equals(pluginConfig, that.pluginConfig))) {
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
  
  public String getDisabledPlugin(int index) {
    return this.disabledPlugins.get(index);
  }
  
  public List<String> getDisabledPlugins() {
    return this.disabledPlugins;
  }
  
  public String getEnabledPlugin(int index) {
    return this.enabledPlugins.get(index);
  }
  
  public List<String> getEnabledPlugins() {
    return this.enabledPlugins;
  }
  
  public String getFirstDisabledPlugin() {
    return this.disabledPlugins.get(0);
  }
  
  public String getFirstEnabledPlugin() {
    return this.enabledPlugins.get(0);
  }
  
  public String getLastDisabledPlugin() {
    return this.disabledPlugins.get(disabledPlugins.size() - 1);
  }
  
  public String getLastEnabledPlugin() {
    return this.enabledPlugins.get(enabledPlugins.size() - 1);
  }
  
  public String getMatchingDisabledPlugin(Predicate<String> predicate) {
      for (String item : disabledPlugins) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingEnabledPlugin(Predicate<String> predicate) {
      for (String item : enabledPlugins) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public Map<String,AdmissionPluginConfig> getPluginConfig() {
    return this.pluginConfig;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDisabledPlugins() {
    return this.disabledPlugins != null && !(this.disabledPlugins.isEmpty());
  }
  
  public boolean hasEnabledPlugins() {
    return this.enabledPlugins != null && !(this.enabledPlugins.isEmpty());
  }
  
  public boolean hasMatchingDisabledPlugin(Predicate<String> predicate) {
      for (String item : disabledPlugins) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingEnabledPlugin(Predicate<String> predicate) {
      for (String item : enabledPlugins) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPluginConfig() {
    return this.pluginConfig != null;
  }
  
  public int hashCode() {
    return Objects.hash(disabledPlugins, enabledPlugins, pluginConfig, additionalProperties);
  }
  
  public A removeAllFromDisabledPlugins(Collection<String> items) {
    if (this.disabledPlugins == null) {
      return (A) this;
    }
    for (String item : items) {
      this.disabledPlugins.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromEnabledPlugins(Collection<String> items) {
    if (this.enabledPlugins == null) {
      return (A) this;
    }
    for (String item : items) {
      this.enabledPlugins.remove(item);
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
  
  public A removeFromDisabledPlugins(String... items) {
    if (this.disabledPlugins == null) {
      return (A) this;
    }
    for (String item : items) {
      this.disabledPlugins.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromEnabledPlugins(String... items) {
    if (this.enabledPlugins == null) {
      return (A) this;
    }
    for (String item : items) {
      this.enabledPlugins.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromPluginConfig(String key) {
    if (this.pluginConfig == null) {
      return (A) this;
    }
    if (key != null && this.pluginConfig != null) {
      this.pluginConfig.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromPluginConfig(Map<String,AdmissionPluginConfig> map) {
    if (this.pluginConfig == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.pluginConfig != null) {
          this.pluginConfig.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A setToDisabledPlugins(int index,String item) {
    if (this.disabledPlugins == null) {
      this.disabledPlugins = new ArrayList();
    }
    this.disabledPlugins.set(index, item);
    return (A) this;
  }
  
  public A setToEnabledPlugins(int index,String item) {
    if (this.enabledPlugins == null) {
      this.enabledPlugins = new ArrayList();
    }
    this.enabledPlugins.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(disabledPlugins == null) && !(disabledPlugins.isEmpty())) {
        sb.append("disabledPlugins:");
        sb.append(disabledPlugins);
        sb.append(",");
    }
    if (!(enabledPlugins == null) && !(enabledPlugins.isEmpty())) {
        sb.append("enabledPlugins:");
        sb.append(enabledPlugins);
        sb.append(",");
    }
    if (!(pluginConfig == null) && !(pluginConfig.isEmpty())) {
        sb.append("pluginConfig:");
        sb.append(pluginConfig);
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
  
  public A withDisabledPlugins(List<String> disabledPlugins) {
    if (disabledPlugins != null) {
        this.disabledPlugins = new ArrayList();
        for (String item : disabledPlugins) {
          this.addToDisabledPlugins(item);
        }
    } else {
      this.disabledPlugins = null;
    }
    return (A) this;
  }
  
  public A withDisabledPlugins(String... disabledPlugins) {
    if (this.disabledPlugins != null) {
        this.disabledPlugins.clear();
        _visitables.remove("disabledPlugins");
    }
    if (disabledPlugins != null) {
      for (String item : disabledPlugins) {
        this.addToDisabledPlugins(item);
      }
    }
    return (A) this;
  }
  
  public A withEnabledPlugins(List<String> enabledPlugins) {
    if (enabledPlugins != null) {
        this.enabledPlugins = new ArrayList();
        for (String item : enabledPlugins) {
          this.addToEnabledPlugins(item);
        }
    } else {
      this.enabledPlugins = null;
    }
    return (A) this;
  }
  
  public A withEnabledPlugins(String... enabledPlugins) {
    if (this.enabledPlugins != null) {
        this.enabledPlugins.clear();
        _visitables.remove("enabledPlugins");
    }
    if (enabledPlugins != null) {
      for (String item : enabledPlugins) {
        this.addToEnabledPlugins(item);
      }
    }
    return (A) this;
  }
  
  public <K,V>A withPluginConfig(Map<String,AdmissionPluginConfig> pluginConfig) {
    if (pluginConfig == null) {
      this.pluginConfig = null;
    } else {
      this.pluginConfig = new LinkedHashMap(pluginConfig);
    }
    return (A) this;
  }
  
}