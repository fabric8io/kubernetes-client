package io.fabric8.kubernetes.api.model.resource.v1beta2;

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
public class DeviceClassSpecFluent<A extends io.fabric8.kubernetes.api.model.resource.v1beta2.DeviceClassSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<DeviceClassConfigurationBuilder> config = new ArrayList<DeviceClassConfigurationBuilder>();
  private String extendedResourceName;
  private ArrayList<DeviceSelectorBuilder> selectors = new ArrayList<DeviceSelectorBuilder>();

  public DeviceClassSpecFluent() {
  }
  
  public DeviceClassSpecFluent(DeviceClassSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToConfig(Collection<DeviceClassConfiguration> items) {
    if (this.config == null) {
      this.config = new ArrayList();
    }
    for (DeviceClassConfiguration item : items) {
        DeviceClassConfigurationBuilder builder = new DeviceClassConfigurationBuilder(item);
        _visitables.get("config").add(builder);
        this.config.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToSelectors(Collection<DeviceSelector> items) {
    if (this.selectors == null) {
      this.selectors = new ArrayList();
    }
    for (DeviceSelector item : items) {
        DeviceSelectorBuilder builder = new DeviceSelectorBuilder(item);
        _visitables.get("selectors").add(builder);
        this.selectors.add(builder);
    }
    return (A) this;
  }
  
  public ConfigNested<A> addNewConfig() {
    return new ConfigNested(-1, null);
  }
  
  public ConfigNested<A> addNewConfigLike(DeviceClassConfiguration item) {
    return new ConfigNested(-1, item);
  }
  
  public SelectorsNested<A> addNewSelector() {
    return new SelectorsNested(-1, null);
  }
  
  public SelectorsNested<A> addNewSelectorLike(DeviceSelector item) {
    return new SelectorsNested(-1, item);
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
  
  public A addToConfig(DeviceClassConfiguration... items) {
    if (this.config == null) {
      this.config = new ArrayList();
    }
    for (DeviceClassConfiguration item : items) {
        DeviceClassConfigurationBuilder builder = new DeviceClassConfigurationBuilder(item);
        _visitables.get("config").add(builder);
        this.config.add(builder);
    }
    return (A) this;
  }
  
  public A addToConfig(int index,DeviceClassConfiguration item) {
    if (this.config == null) {
      this.config = new ArrayList();
    }
    DeviceClassConfigurationBuilder builder = new DeviceClassConfigurationBuilder(item);
    if (index < 0 || index >= config.size()) {
        _visitables.get("config").add(builder);
        config.add(builder);
    } else {
        _visitables.get("config").add(builder);
        config.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToSelectors(DeviceSelector... items) {
    if (this.selectors == null) {
      this.selectors = new ArrayList();
    }
    for (DeviceSelector item : items) {
        DeviceSelectorBuilder builder = new DeviceSelectorBuilder(item);
        _visitables.get("selectors").add(builder);
        this.selectors.add(builder);
    }
    return (A) this;
  }
  
  public A addToSelectors(int index,DeviceSelector item) {
    if (this.selectors == null) {
      this.selectors = new ArrayList();
    }
    DeviceSelectorBuilder builder = new DeviceSelectorBuilder(item);
    if (index < 0 || index >= selectors.size()) {
        _visitables.get("selectors").add(builder);
        selectors.add(builder);
    } else {
        _visitables.get("selectors").add(builder);
        selectors.add(index, builder);
    }
    return (A) this;
  }
  
  public List<DeviceClassConfiguration> buildConfig() {
    return this.config != null ? build(config) : null;
  }
  
  public DeviceClassConfiguration buildConfig(int index) {
    return this.config.get(index).build();
  }
  
  public DeviceClassConfiguration buildFirstConfig() {
    return this.config.get(0).build();
  }
  
  public DeviceSelector buildFirstSelector() {
    return this.selectors.get(0).build();
  }
  
  public DeviceClassConfiguration buildLastConfig() {
    return this.config.get(config.size() - 1).build();
  }
  
  public DeviceSelector buildLastSelector() {
    return this.selectors.get(selectors.size() - 1).build();
  }
  
  public DeviceClassConfiguration buildMatchingConfig(Predicate<DeviceClassConfigurationBuilder> predicate) {
      for (DeviceClassConfigurationBuilder item : config) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public DeviceSelector buildMatchingSelector(Predicate<DeviceSelectorBuilder> predicate) {
      for (DeviceSelectorBuilder item : selectors) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public DeviceSelector buildSelector(int index) {
    return this.selectors.get(index).build();
  }
  
  public List<DeviceSelector> buildSelectors() {
    return this.selectors != null ? build(selectors) : null;
  }
  
  protected void copyInstance(DeviceClassSpec instance) {
    instance = instance != null ? instance : new DeviceClassSpec();
    if (instance != null) {
        this.withConfig(instance.getConfig());
        this.withExtendedResourceName(instance.getExtendedResourceName());
        this.withSelectors(instance.getSelectors());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ConfigNested<A> editConfig(int index) {
    if (config.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "config"));
    }
    return this.setNewConfigLike(index, this.buildConfig(index));
  }
  
  public ConfigNested<A> editFirstConfig() {
    if (config.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "config"));
    }
    return this.setNewConfigLike(0, this.buildConfig(0));
  }
  
  public SelectorsNested<A> editFirstSelector() {
    if (selectors.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "selectors"));
    }
    return this.setNewSelectorLike(0, this.buildSelector(0));
  }
  
  public ConfigNested<A> editLastConfig() {
    int index = config.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "config"));
    }
    return this.setNewConfigLike(index, this.buildConfig(index));
  }
  
  public SelectorsNested<A> editLastSelector() {
    int index = selectors.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "selectors"));
    }
    return this.setNewSelectorLike(index, this.buildSelector(index));
  }
  
  public ConfigNested<A> editMatchingConfig(Predicate<DeviceClassConfigurationBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < config.size();i++) {
      if (predicate.test(config.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "config"));
    }
    return this.setNewConfigLike(index, this.buildConfig(index));
  }
  
  public SelectorsNested<A> editMatchingSelector(Predicate<DeviceSelectorBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < selectors.size();i++) {
      if (predicate.test(selectors.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "selectors"));
    }
    return this.setNewSelectorLike(index, this.buildSelector(index));
  }
  
  public SelectorsNested<A> editSelector(int index) {
    if (selectors.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "selectors"));
    }
    return this.setNewSelectorLike(index, this.buildSelector(index));
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
    DeviceClassSpecFluent that = (DeviceClassSpecFluent) o;
    if (!(Objects.equals(config, that.config))) {
      return false;
    }
    if (!(Objects.equals(extendedResourceName, that.extendedResourceName))) {
      return false;
    }
    if (!(Objects.equals(selectors, that.selectors))) {
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
  
  public String getExtendedResourceName() {
    return this.extendedResourceName;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasConfig() {
    return this.config != null && !(this.config.isEmpty());
  }
  
  public boolean hasExtendedResourceName() {
    return this.extendedResourceName != null;
  }
  
  public boolean hasMatchingConfig(Predicate<DeviceClassConfigurationBuilder> predicate) {
      for (DeviceClassConfigurationBuilder item : config) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingSelector(Predicate<DeviceSelectorBuilder> predicate) {
      for (DeviceSelectorBuilder item : selectors) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasSelectors() {
    return this.selectors != null && !(this.selectors.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(config, extendedResourceName, selectors, additionalProperties);
  }
  
  public A removeAllFromConfig(Collection<DeviceClassConfiguration> items) {
    if (this.config == null) {
      return (A) this;
    }
    for (DeviceClassConfiguration item : items) {
        DeviceClassConfigurationBuilder builder = new DeviceClassConfigurationBuilder(item);
        _visitables.get("config").remove(builder);
        this.config.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromSelectors(Collection<DeviceSelector> items) {
    if (this.selectors == null) {
      return (A) this;
    }
    for (DeviceSelector item : items) {
        DeviceSelectorBuilder builder = new DeviceSelectorBuilder(item);
        _visitables.get("selectors").remove(builder);
        this.selectors.remove(builder);
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
  
  public A removeFromConfig(DeviceClassConfiguration... items) {
    if (this.config == null) {
      return (A) this;
    }
    for (DeviceClassConfiguration item : items) {
        DeviceClassConfigurationBuilder builder = new DeviceClassConfigurationBuilder(item);
        _visitables.get("config").remove(builder);
        this.config.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromSelectors(DeviceSelector... items) {
    if (this.selectors == null) {
      return (A) this;
    }
    for (DeviceSelector item : items) {
        DeviceSelectorBuilder builder = new DeviceSelectorBuilder(item);
        _visitables.get("selectors").remove(builder);
        this.selectors.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromConfig(Predicate<DeviceClassConfigurationBuilder> predicate) {
    if (config == null) {
      return (A) this;
    }
    Iterator<DeviceClassConfigurationBuilder> each = config.iterator();
    List visitables = _visitables.get("config");
    while (each.hasNext()) {
        DeviceClassConfigurationBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromSelectors(Predicate<DeviceSelectorBuilder> predicate) {
    if (selectors == null) {
      return (A) this;
    }
    Iterator<DeviceSelectorBuilder> each = selectors.iterator();
    List visitables = _visitables.get("selectors");
    while (each.hasNext()) {
        DeviceSelectorBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ConfigNested<A> setNewConfigLike(int index,DeviceClassConfiguration item) {
    return new ConfigNested(index, item);
  }
  
  public SelectorsNested<A> setNewSelectorLike(int index,DeviceSelector item) {
    return new SelectorsNested(index, item);
  }
  
  public A setToConfig(int index,DeviceClassConfiguration item) {
    if (this.config == null) {
      this.config = new ArrayList();
    }
    DeviceClassConfigurationBuilder builder = new DeviceClassConfigurationBuilder(item);
    if (index < 0 || index >= config.size()) {
        _visitables.get("config").add(builder);
        config.add(builder);
    } else {
        _visitables.get("config").add(builder);
        config.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToSelectors(int index,DeviceSelector item) {
    if (this.selectors == null) {
      this.selectors = new ArrayList();
    }
    DeviceSelectorBuilder builder = new DeviceSelectorBuilder(item);
    if (index < 0 || index >= selectors.size()) {
        _visitables.get("selectors").add(builder);
        selectors.add(builder);
    } else {
        _visitables.get("selectors").add(builder);
        selectors.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(config == null) && !(config.isEmpty())) {
        sb.append("config:");
        sb.append(config);
        sb.append(",");
    }
    if (!(extendedResourceName == null)) {
        sb.append("extendedResourceName:");
        sb.append(extendedResourceName);
        sb.append(",");
    }
    if (!(selectors == null) && !(selectors.isEmpty())) {
        sb.append("selectors:");
        sb.append(selectors);
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
  
  public A withConfig(List<DeviceClassConfiguration> config) {
    if (this.config != null) {
      this._visitables.get("config").clear();
    }
    if (config != null) {
        this.config = new ArrayList();
        for (DeviceClassConfiguration item : config) {
          this.addToConfig(item);
        }
    } else {
      this.config = null;
    }
    return (A) this;
  }
  
  public A withConfig(DeviceClassConfiguration... config) {
    if (this.config != null) {
        this.config.clear();
        _visitables.remove("config");
    }
    if (config != null) {
      for (DeviceClassConfiguration item : config) {
        this.addToConfig(item);
      }
    }
    return (A) this;
  }
  
  public A withExtendedResourceName(String extendedResourceName) {
    this.extendedResourceName = extendedResourceName;
    return (A) this;
  }
  
  public A withSelectors(List<DeviceSelector> selectors) {
    if (this.selectors != null) {
      this._visitables.get("selectors").clear();
    }
    if (selectors != null) {
        this.selectors = new ArrayList();
        for (DeviceSelector item : selectors) {
          this.addToSelectors(item);
        }
    } else {
      this.selectors = null;
    }
    return (A) this;
  }
  
  public A withSelectors(DeviceSelector... selectors) {
    if (this.selectors != null) {
        this.selectors.clear();
        _visitables.remove("selectors");
    }
    if (selectors != null) {
      for (DeviceSelector item : selectors) {
        this.addToSelectors(item);
      }
    }
    return (A) this;
  }
  public class ConfigNested<N> extends DeviceClassConfigurationFluent<ConfigNested<N>> implements Nested<N>{
  
    DeviceClassConfigurationBuilder builder;
    int index;
  
    ConfigNested(int index,DeviceClassConfiguration item) {
      this.index = index;
      this.builder = new DeviceClassConfigurationBuilder(this, item);
    }
  
    public N and() {
      return (N) DeviceClassSpecFluent.this.setToConfig(index, builder.build());
    }
    
    public N endConfig() {
      return and();
    }
    
  }
  public class SelectorsNested<N> extends DeviceSelectorFluent<SelectorsNested<N>> implements Nested<N>{
  
    DeviceSelectorBuilder builder;
    int index;
  
    SelectorsNested(int index,DeviceSelector item) {
      this.index = index;
      this.builder = new DeviceSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) DeviceClassSpecFluent.this.setToSelectors(index, builder.build());
    }
    
    public N endSelector() {
      return and();
    }
    
  }
}