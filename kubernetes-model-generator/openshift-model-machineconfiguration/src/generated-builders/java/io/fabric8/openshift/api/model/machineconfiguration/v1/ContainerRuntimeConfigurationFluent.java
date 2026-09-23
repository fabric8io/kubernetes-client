package io.fabric8.openshift.api.model.machineconfiguration.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.Quantity;
import java.lang.Long;
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
public class ContainerRuntimeConfigurationFluent<A extends io.fabric8.openshift.api.model.machineconfiguration.v1.ContainerRuntimeConfigurationFluent<A>> extends BaseFluent<A>{

  private ArrayList<AdditionalArtifactStoreBuilder> additionalArtifactStores = new ArrayList<AdditionalArtifactStoreBuilder>();
  private ArrayList<AdditionalImageStoreBuilder> additionalImageStores = new ArrayList<AdditionalImageStoreBuilder>();
  private ArrayList<AdditionalLayerStoreBuilder> additionalLayerStores = new ArrayList<AdditionalLayerStoreBuilder>();
  private Map<String,Object> additionalProperties;
  private String defaultRuntime;
  private String logLevel;
  private Quantity logSizeMax;
  private Quantity overlaySize;
  private Long pidsLimit;

  public ContainerRuntimeConfigurationFluent() {
  }
  
  public ContainerRuntimeConfigurationFluent(ContainerRuntimeConfiguration instance) {
    this.copyInstance(instance);
  }

  public A addAllToAdditionalArtifactStores(Collection<AdditionalArtifactStore> items) {
    if (this.additionalArtifactStores == null) {
      this.additionalArtifactStores = new ArrayList();
    }
    for (AdditionalArtifactStore item : items) {
        AdditionalArtifactStoreBuilder builder = new AdditionalArtifactStoreBuilder(item);
        _visitables.get("additionalArtifactStores").add(builder);
        this.additionalArtifactStores.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToAdditionalImageStores(Collection<AdditionalImageStore> items) {
    if (this.additionalImageStores == null) {
      this.additionalImageStores = new ArrayList();
    }
    for (AdditionalImageStore item : items) {
        AdditionalImageStoreBuilder builder = new AdditionalImageStoreBuilder(item);
        _visitables.get("additionalImageStores").add(builder);
        this.additionalImageStores.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToAdditionalLayerStores(Collection<AdditionalLayerStore> items) {
    if (this.additionalLayerStores == null) {
      this.additionalLayerStores = new ArrayList();
    }
    for (AdditionalLayerStore item : items) {
        AdditionalLayerStoreBuilder builder = new AdditionalLayerStoreBuilder(item);
        _visitables.get("additionalLayerStores").add(builder);
        this.additionalLayerStores.add(builder);
    }
    return (A) this;
  }
  
  public AdditionalArtifactStoresNested<A> addNewAdditionalArtifactStore() {
    return new AdditionalArtifactStoresNested(-1, null);
  }
  
  public A addNewAdditionalArtifactStore(String path) {
    return (A) this.addToAdditionalArtifactStores(new AdditionalArtifactStore(path));
  }
  
  public AdditionalArtifactStoresNested<A> addNewAdditionalArtifactStoreLike(AdditionalArtifactStore item) {
    return new AdditionalArtifactStoresNested(-1, item);
  }
  
  public AdditionalImageStoresNested<A> addNewAdditionalImageStore() {
    return new AdditionalImageStoresNested(-1, null);
  }
  
  public A addNewAdditionalImageStore(String path) {
    return (A) this.addToAdditionalImageStores(new AdditionalImageStore(path));
  }
  
  public AdditionalImageStoresNested<A> addNewAdditionalImageStoreLike(AdditionalImageStore item) {
    return new AdditionalImageStoresNested(-1, item);
  }
  
  public AdditionalLayerStoresNested<A> addNewAdditionalLayerStore() {
    return new AdditionalLayerStoresNested(-1, null);
  }
  
  public A addNewAdditionalLayerStore(String path) {
    return (A) this.addToAdditionalLayerStores(new AdditionalLayerStore(path));
  }
  
  public AdditionalLayerStoresNested<A> addNewAdditionalLayerStoreLike(AdditionalLayerStore item) {
    return new AdditionalLayerStoresNested(-1, item);
  }
  
  public A addToAdditionalArtifactStores(AdditionalArtifactStore... items) {
    if (this.additionalArtifactStores == null) {
      this.additionalArtifactStores = new ArrayList();
    }
    for (AdditionalArtifactStore item : items) {
        AdditionalArtifactStoreBuilder builder = new AdditionalArtifactStoreBuilder(item);
        _visitables.get("additionalArtifactStores").add(builder);
        this.additionalArtifactStores.add(builder);
    }
    return (A) this;
  }
  
  public A addToAdditionalArtifactStores(int index,AdditionalArtifactStore item) {
    if (this.additionalArtifactStores == null) {
      this.additionalArtifactStores = new ArrayList();
    }
    AdditionalArtifactStoreBuilder builder = new AdditionalArtifactStoreBuilder(item);
    if (index < 0 || index >= additionalArtifactStores.size()) {
        _visitables.get("additionalArtifactStores").add(builder);
        additionalArtifactStores.add(builder);
    } else {
        _visitables.get("additionalArtifactStores").add(builder);
        additionalArtifactStores.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToAdditionalImageStores(AdditionalImageStore... items) {
    if (this.additionalImageStores == null) {
      this.additionalImageStores = new ArrayList();
    }
    for (AdditionalImageStore item : items) {
        AdditionalImageStoreBuilder builder = new AdditionalImageStoreBuilder(item);
        _visitables.get("additionalImageStores").add(builder);
        this.additionalImageStores.add(builder);
    }
    return (A) this;
  }
  
  public A addToAdditionalImageStores(int index,AdditionalImageStore item) {
    if (this.additionalImageStores == null) {
      this.additionalImageStores = new ArrayList();
    }
    AdditionalImageStoreBuilder builder = new AdditionalImageStoreBuilder(item);
    if (index < 0 || index >= additionalImageStores.size()) {
        _visitables.get("additionalImageStores").add(builder);
        additionalImageStores.add(builder);
    } else {
        _visitables.get("additionalImageStores").add(builder);
        additionalImageStores.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToAdditionalLayerStores(AdditionalLayerStore... items) {
    if (this.additionalLayerStores == null) {
      this.additionalLayerStores = new ArrayList();
    }
    for (AdditionalLayerStore item : items) {
        AdditionalLayerStoreBuilder builder = new AdditionalLayerStoreBuilder(item);
        _visitables.get("additionalLayerStores").add(builder);
        this.additionalLayerStores.add(builder);
    }
    return (A) this;
  }
  
  public A addToAdditionalLayerStores(int index,AdditionalLayerStore item) {
    if (this.additionalLayerStores == null) {
      this.additionalLayerStores = new ArrayList();
    }
    AdditionalLayerStoreBuilder builder = new AdditionalLayerStoreBuilder(item);
    if (index < 0 || index >= additionalLayerStores.size()) {
        _visitables.get("additionalLayerStores").add(builder);
        additionalLayerStores.add(builder);
    } else {
        _visitables.get("additionalLayerStores").add(builder);
        additionalLayerStores.add(index, builder);
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
  
  public AdditionalArtifactStore buildAdditionalArtifactStore(int index) {
    return this.additionalArtifactStores.get(index).build();
  }
  
  public List<AdditionalArtifactStore> buildAdditionalArtifactStores() {
    return this.additionalArtifactStores != null ? build(additionalArtifactStores) : null;
  }
  
  public AdditionalImageStore buildAdditionalImageStore(int index) {
    return this.additionalImageStores.get(index).build();
  }
  
  public List<AdditionalImageStore> buildAdditionalImageStores() {
    return this.additionalImageStores != null ? build(additionalImageStores) : null;
  }
  
  public AdditionalLayerStore buildAdditionalLayerStore(int index) {
    return this.additionalLayerStores.get(index).build();
  }
  
  public List<AdditionalLayerStore> buildAdditionalLayerStores() {
    return this.additionalLayerStores != null ? build(additionalLayerStores) : null;
  }
  
  public AdditionalArtifactStore buildFirstAdditionalArtifactStore() {
    return this.additionalArtifactStores.get(0).build();
  }
  
  public AdditionalImageStore buildFirstAdditionalImageStore() {
    return this.additionalImageStores.get(0).build();
  }
  
  public AdditionalLayerStore buildFirstAdditionalLayerStore() {
    return this.additionalLayerStores.get(0).build();
  }
  
  public AdditionalArtifactStore buildLastAdditionalArtifactStore() {
    return this.additionalArtifactStores.get(additionalArtifactStores.size() - 1).build();
  }
  
  public AdditionalImageStore buildLastAdditionalImageStore() {
    return this.additionalImageStores.get(additionalImageStores.size() - 1).build();
  }
  
  public AdditionalLayerStore buildLastAdditionalLayerStore() {
    return this.additionalLayerStores.get(additionalLayerStores.size() - 1).build();
  }
  
  public AdditionalArtifactStore buildMatchingAdditionalArtifactStore(Predicate<AdditionalArtifactStoreBuilder> predicate) {
      for (AdditionalArtifactStoreBuilder item : additionalArtifactStores) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public AdditionalImageStore buildMatchingAdditionalImageStore(Predicate<AdditionalImageStoreBuilder> predicate) {
      for (AdditionalImageStoreBuilder item : additionalImageStores) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public AdditionalLayerStore buildMatchingAdditionalLayerStore(Predicate<AdditionalLayerStoreBuilder> predicate) {
      for (AdditionalLayerStoreBuilder item : additionalLayerStores) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(ContainerRuntimeConfiguration instance) {
    instance = instance != null ? instance : new ContainerRuntimeConfiguration();
    if (instance != null) {
        this.withAdditionalArtifactStores(instance.getAdditionalArtifactStores());
        this.withAdditionalImageStores(instance.getAdditionalImageStores());
        this.withAdditionalLayerStores(instance.getAdditionalLayerStores());
        this.withDefaultRuntime(instance.getDefaultRuntime());
        this.withLogLevel(instance.getLogLevel());
        this.withLogSizeMax(instance.getLogSizeMax());
        this.withOverlaySize(instance.getOverlaySize());
        this.withPidsLimit(instance.getPidsLimit());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AdditionalArtifactStoresNested<A> editAdditionalArtifactStore(int index) {
    if (additionalArtifactStores.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "additionalArtifactStores"));
    }
    return this.setNewAdditionalArtifactStoreLike(index, this.buildAdditionalArtifactStore(index));
  }
  
  public AdditionalImageStoresNested<A> editAdditionalImageStore(int index) {
    if (additionalImageStores.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "additionalImageStores"));
    }
    return this.setNewAdditionalImageStoreLike(index, this.buildAdditionalImageStore(index));
  }
  
  public AdditionalLayerStoresNested<A> editAdditionalLayerStore(int index) {
    if (additionalLayerStores.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "additionalLayerStores"));
    }
    return this.setNewAdditionalLayerStoreLike(index, this.buildAdditionalLayerStore(index));
  }
  
  public AdditionalArtifactStoresNested<A> editFirstAdditionalArtifactStore() {
    if (additionalArtifactStores.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "additionalArtifactStores"));
    }
    return this.setNewAdditionalArtifactStoreLike(0, this.buildAdditionalArtifactStore(0));
  }
  
  public AdditionalImageStoresNested<A> editFirstAdditionalImageStore() {
    if (additionalImageStores.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "additionalImageStores"));
    }
    return this.setNewAdditionalImageStoreLike(0, this.buildAdditionalImageStore(0));
  }
  
  public AdditionalLayerStoresNested<A> editFirstAdditionalLayerStore() {
    if (additionalLayerStores.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "additionalLayerStores"));
    }
    return this.setNewAdditionalLayerStoreLike(0, this.buildAdditionalLayerStore(0));
  }
  
  public AdditionalArtifactStoresNested<A> editLastAdditionalArtifactStore() {
    int index = additionalArtifactStores.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "additionalArtifactStores"));
    }
    return this.setNewAdditionalArtifactStoreLike(index, this.buildAdditionalArtifactStore(index));
  }
  
  public AdditionalImageStoresNested<A> editLastAdditionalImageStore() {
    int index = additionalImageStores.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "additionalImageStores"));
    }
    return this.setNewAdditionalImageStoreLike(index, this.buildAdditionalImageStore(index));
  }
  
  public AdditionalLayerStoresNested<A> editLastAdditionalLayerStore() {
    int index = additionalLayerStores.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "additionalLayerStores"));
    }
    return this.setNewAdditionalLayerStoreLike(index, this.buildAdditionalLayerStore(index));
  }
  
  public AdditionalArtifactStoresNested<A> editMatchingAdditionalArtifactStore(Predicate<AdditionalArtifactStoreBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < additionalArtifactStores.size();i++) {
      if (predicate.test(additionalArtifactStores.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "additionalArtifactStores"));
    }
    return this.setNewAdditionalArtifactStoreLike(index, this.buildAdditionalArtifactStore(index));
  }
  
  public AdditionalImageStoresNested<A> editMatchingAdditionalImageStore(Predicate<AdditionalImageStoreBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < additionalImageStores.size();i++) {
      if (predicate.test(additionalImageStores.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "additionalImageStores"));
    }
    return this.setNewAdditionalImageStoreLike(index, this.buildAdditionalImageStore(index));
  }
  
  public AdditionalLayerStoresNested<A> editMatchingAdditionalLayerStore(Predicate<AdditionalLayerStoreBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < additionalLayerStores.size();i++) {
      if (predicate.test(additionalLayerStores.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "additionalLayerStores"));
    }
    return this.setNewAdditionalLayerStoreLike(index, this.buildAdditionalLayerStore(index));
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
    ContainerRuntimeConfigurationFluent that = (ContainerRuntimeConfigurationFluent) o;
    if (!(Objects.equals(additionalArtifactStores, that.additionalArtifactStores))) {
      return false;
    }
    if (!(Objects.equals(additionalImageStores, that.additionalImageStores))) {
      return false;
    }
    if (!(Objects.equals(additionalLayerStores, that.additionalLayerStores))) {
      return false;
    }
    if (!(Objects.equals(defaultRuntime, that.defaultRuntime))) {
      return false;
    }
    if (!(Objects.equals(logLevel, that.logLevel))) {
      return false;
    }
    if (!(Objects.equals(logSizeMax, that.logSizeMax))) {
      return false;
    }
    if (!(Objects.equals(overlaySize, that.overlaySize))) {
      return false;
    }
    if (!(Objects.equals(pidsLimit, that.pidsLimit))) {
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
  
  public String getDefaultRuntime() {
    return this.defaultRuntime;
  }
  
  public String getLogLevel() {
    return this.logLevel;
  }
  
  public Quantity getLogSizeMax() {
    return this.logSizeMax;
  }
  
  public Quantity getOverlaySize() {
    return this.overlaySize;
  }
  
  public Long getPidsLimit() {
    return this.pidsLimit;
  }
  
  public boolean hasAdditionalArtifactStores() {
    return this.additionalArtifactStores != null && !(this.additionalArtifactStores.isEmpty());
  }
  
  public boolean hasAdditionalImageStores() {
    return this.additionalImageStores != null && !(this.additionalImageStores.isEmpty());
  }
  
  public boolean hasAdditionalLayerStores() {
    return this.additionalLayerStores != null && !(this.additionalLayerStores.isEmpty());
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDefaultRuntime() {
    return this.defaultRuntime != null;
  }
  
  public boolean hasLogLevel() {
    return this.logLevel != null;
  }
  
  public boolean hasLogSizeMax() {
    return this.logSizeMax != null;
  }
  
  public boolean hasMatchingAdditionalArtifactStore(Predicate<AdditionalArtifactStoreBuilder> predicate) {
      for (AdditionalArtifactStoreBuilder item : additionalArtifactStores) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingAdditionalImageStore(Predicate<AdditionalImageStoreBuilder> predicate) {
      for (AdditionalImageStoreBuilder item : additionalImageStores) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingAdditionalLayerStore(Predicate<AdditionalLayerStoreBuilder> predicate) {
      for (AdditionalLayerStoreBuilder item : additionalLayerStores) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasOverlaySize() {
    return this.overlaySize != null;
  }
  
  public boolean hasPidsLimit() {
    return this.pidsLimit != null;
  }
  
  public int hashCode() {
    return Objects.hash(additionalArtifactStores, additionalImageStores, additionalLayerStores, defaultRuntime, logLevel, logSizeMax, overlaySize, pidsLimit, additionalProperties);
  }
  
  public A removeAllFromAdditionalArtifactStores(Collection<AdditionalArtifactStore> items) {
    if (this.additionalArtifactStores == null) {
      return (A) this;
    }
    for (AdditionalArtifactStore item : items) {
        AdditionalArtifactStoreBuilder builder = new AdditionalArtifactStoreBuilder(item);
        _visitables.get("additionalArtifactStores").remove(builder);
        this.additionalArtifactStores.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromAdditionalImageStores(Collection<AdditionalImageStore> items) {
    if (this.additionalImageStores == null) {
      return (A) this;
    }
    for (AdditionalImageStore item : items) {
        AdditionalImageStoreBuilder builder = new AdditionalImageStoreBuilder(item);
        _visitables.get("additionalImageStores").remove(builder);
        this.additionalImageStores.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromAdditionalLayerStores(Collection<AdditionalLayerStore> items) {
    if (this.additionalLayerStores == null) {
      return (A) this;
    }
    for (AdditionalLayerStore item : items) {
        AdditionalLayerStoreBuilder builder = new AdditionalLayerStoreBuilder(item);
        _visitables.get("additionalLayerStores").remove(builder);
        this.additionalLayerStores.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromAdditionalArtifactStores(AdditionalArtifactStore... items) {
    if (this.additionalArtifactStores == null) {
      return (A) this;
    }
    for (AdditionalArtifactStore item : items) {
        AdditionalArtifactStoreBuilder builder = new AdditionalArtifactStoreBuilder(item);
        _visitables.get("additionalArtifactStores").remove(builder);
        this.additionalArtifactStores.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromAdditionalImageStores(AdditionalImageStore... items) {
    if (this.additionalImageStores == null) {
      return (A) this;
    }
    for (AdditionalImageStore item : items) {
        AdditionalImageStoreBuilder builder = new AdditionalImageStoreBuilder(item);
        _visitables.get("additionalImageStores").remove(builder);
        this.additionalImageStores.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromAdditionalLayerStores(AdditionalLayerStore... items) {
    if (this.additionalLayerStores == null) {
      return (A) this;
    }
    for (AdditionalLayerStore item : items) {
        AdditionalLayerStoreBuilder builder = new AdditionalLayerStoreBuilder(item);
        _visitables.get("additionalLayerStores").remove(builder);
        this.additionalLayerStores.remove(builder);
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
  
  public A removeMatchingFromAdditionalArtifactStores(Predicate<AdditionalArtifactStoreBuilder> predicate) {
    if (additionalArtifactStores == null) {
      return (A) this;
    }
    Iterator<AdditionalArtifactStoreBuilder> each = additionalArtifactStores.iterator();
    List visitables = _visitables.get("additionalArtifactStores");
    while (each.hasNext()) {
        AdditionalArtifactStoreBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromAdditionalImageStores(Predicate<AdditionalImageStoreBuilder> predicate) {
    if (additionalImageStores == null) {
      return (A) this;
    }
    Iterator<AdditionalImageStoreBuilder> each = additionalImageStores.iterator();
    List visitables = _visitables.get("additionalImageStores");
    while (each.hasNext()) {
        AdditionalImageStoreBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromAdditionalLayerStores(Predicate<AdditionalLayerStoreBuilder> predicate) {
    if (additionalLayerStores == null) {
      return (A) this;
    }
    Iterator<AdditionalLayerStoreBuilder> each = additionalLayerStores.iterator();
    List visitables = _visitables.get("additionalLayerStores");
    while (each.hasNext()) {
        AdditionalLayerStoreBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public AdditionalArtifactStoresNested<A> setNewAdditionalArtifactStoreLike(int index,AdditionalArtifactStore item) {
    return new AdditionalArtifactStoresNested(index, item);
  }
  
  public AdditionalImageStoresNested<A> setNewAdditionalImageStoreLike(int index,AdditionalImageStore item) {
    return new AdditionalImageStoresNested(index, item);
  }
  
  public AdditionalLayerStoresNested<A> setNewAdditionalLayerStoreLike(int index,AdditionalLayerStore item) {
    return new AdditionalLayerStoresNested(index, item);
  }
  
  public A setToAdditionalArtifactStores(int index,AdditionalArtifactStore item) {
    if (this.additionalArtifactStores == null) {
      this.additionalArtifactStores = new ArrayList();
    }
    AdditionalArtifactStoreBuilder builder = new AdditionalArtifactStoreBuilder(item);
    if (index < 0 || index >= additionalArtifactStores.size()) {
        _visitables.get("additionalArtifactStores").add(builder);
        additionalArtifactStores.add(builder);
    } else {
        _visitables.get("additionalArtifactStores").add(builder);
        additionalArtifactStores.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToAdditionalImageStores(int index,AdditionalImageStore item) {
    if (this.additionalImageStores == null) {
      this.additionalImageStores = new ArrayList();
    }
    AdditionalImageStoreBuilder builder = new AdditionalImageStoreBuilder(item);
    if (index < 0 || index >= additionalImageStores.size()) {
        _visitables.get("additionalImageStores").add(builder);
        additionalImageStores.add(builder);
    } else {
        _visitables.get("additionalImageStores").add(builder);
        additionalImageStores.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToAdditionalLayerStores(int index,AdditionalLayerStore item) {
    if (this.additionalLayerStores == null) {
      this.additionalLayerStores = new ArrayList();
    }
    AdditionalLayerStoreBuilder builder = new AdditionalLayerStoreBuilder(item);
    if (index < 0 || index >= additionalLayerStores.size()) {
        _visitables.get("additionalLayerStores").add(builder);
        additionalLayerStores.add(builder);
    } else {
        _visitables.get("additionalLayerStores").add(builder);
        additionalLayerStores.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(additionalArtifactStores == null) && !(additionalArtifactStores.isEmpty())) {
        sb.append("additionalArtifactStores:");
        sb.append(additionalArtifactStores);
        sb.append(",");
    }
    if (!(additionalImageStores == null) && !(additionalImageStores.isEmpty())) {
        sb.append("additionalImageStores:");
        sb.append(additionalImageStores);
        sb.append(",");
    }
    if (!(additionalLayerStores == null) && !(additionalLayerStores.isEmpty())) {
        sb.append("additionalLayerStores:");
        sb.append(additionalLayerStores);
        sb.append(",");
    }
    if (!(defaultRuntime == null)) {
        sb.append("defaultRuntime:");
        sb.append(defaultRuntime);
        sb.append(",");
    }
    if (!(logLevel == null)) {
        sb.append("logLevel:");
        sb.append(logLevel);
        sb.append(",");
    }
    if (!(logSizeMax == null)) {
        sb.append("logSizeMax:");
        sb.append(logSizeMax);
        sb.append(",");
    }
    if (!(overlaySize == null)) {
        sb.append("overlaySize:");
        sb.append(overlaySize);
        sb.append(",");
    }
    if (!(pidsLimit == null)) {
        sb.append("pidsLimit:");
        sb.append(pidsLimit);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public A withAdditionalArtifactStores(List<AdditionalArtifactStore> additionalArtifactStores) {
    if (this.additionalArtifactStores != null) {
      this._visitables.get("additionalArtifactStores").clear();
    }
    if (additionalArtifactStores != null) {
        this.additionalArtifactStores = new ArrayList();
        for (AdditionalArtifactStore item : additionalArtifactStores) {
          this.addToAdditionalArtifactStores(item);
        }
    } else {
      this.additionalArtifactStores = null;
    }
    return (A) this;
  }
  
  public A withAdditionalArtifactStores(AdditionalArtifactStore... additionalArtifactStores) {
    if (this.additionalArtifactStores != null) {
        this.additionalArtifactStores.clear();
        _visitables.remove("additionalArtifactStores");
    }
    if (additionalArtifactStores != null) {
      for (AdditionalArtifactStore item : additionalArtifactStores) {
        this.addToAdditionalArtifactStores(item);
      }
    }
    return (A) this;
  }
  
  public A withAdditionalImageStores(List<AdditionalImageStore> additionalImageStores) {
    if (this.additionalImageStores != null) {
      this._visitables.get("additionalImageStores").clear();
    }
    if (additionalImageStores != null) {
        this.additionalImageStores = new ArrayList();
        for (AdditionalImageStore item : additionalImageStores) {
          this.addToAdditionalImageStores(item);
        }
    } else {
      this.additionalImageStores = null;
    }
    return (A) this;
  }
  
  public A withAdditionalImageStores(AdditionalImageStore... additionalImageStores) {
    if (this.additionalImageStores != null) {
        this.additionalImageStores.clear();
        _visitables.remove("additionalImageStores");
    }
    if (additionalImageStores != null) {
      for (AdditionalImageStore item : additionalImageStores) {
        this.addToAdditionalImageStores(item);
      }
    }
    return (A) this;
  }
  
  public A withAdditionalLayerStores(List<AdditionalLayerStore> additionalLayerStores) {
    if (this.additionalLayerStores != null) {
      this._visitables.get("additionalLayerStores").clear();
    }
    if (additionalLayerStores != null) {
        this.additionalLayerStores = new ArrayList();
        for (AdditionalLayerStore item : additionalLayerStores) {
          this.addToAdditionalLayerStores(item);
        }
    } else {
      this.additionalLayerStores = null;
    }
    return (A) this;
  }
  
  public A withAdditionalLayerStores(AdditionalLayerStore... additionalLayerStores) {
    if (this.additionalLayerStores != null) {
        this.additionalLayerStores.clear();
        _visitables.remove("additionalLayerStores");
    }
    if (additionalLayerStores != null) {
      for (AdditionalLayerStore item : additionalLayerStores) {
        this.addToAdditionalLayerStores(item);
      }
    }
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
  
  public A withDefaultRuntime(String defaultRuntime) {
    this.defaultRuntime = defaultRuntime;
    return (A) this;
  }
  
  public A withLogLevel(String logLevel) {
    this.logLevel = logLevel;
    return (A) this;
  }
  
  public A withLogSizeMax(Quantity logSizeMax) {
    this.logSizeMax = logSizeMax;
    return (A) this;
  }
  
  public A withNewLogSizeMax(String amount) {
    return (A) this.withLogSizeMax(new Quantity(amount));
  }
  
  public A withNewLogSizeMax(String amount,String format) {
    return (A) this.withLogSizeMax(new Quantity(amount, format));
  }
  
  public A withNewOverlaySize(String amount) {
    return (A) this.withOverlaySize(new Quantity(amount));
  }
  
  public A withNewOverlaySize(String amount,String format) {
    return (A) this.withOverlaySize(new Quantity(amount, format));
  }
  
  public A withOverlaySize(Quantity overlaySize) {
    this.overlaySize = overlaySize;
    return (A) this;
  }
  
  public A withPidsLimit(Long pidsLimit) {
    this.pidsLimit = pidsLimit;
    return (A) this;
  }
  public class AdditionalArtifactStoresNested<N> extends AdditionalArtifactStoreFluent<AdditionalArtifactStoresNested<N>> implements Nested<N>{
  
    AdditionalArtifactStoreBuilder builder;
    int index;
  
    AdditionalArtifactStoresNested(int index,AdditionalArtifactStore item) {
      this.index = index;
      this.builder = new AdditionalArtifactStoreBuilder(this, item);
    }
  
    public N and() {
      return (N) ContainerRuntimeConfigurationFluent.this.setToAdditionalArtifactStores(index, builder.build());
    }
    
    public N endAdditionalArtifactStore() {
      return and();
    }
    
  }
  public class AdditionalImageStoresNested<N> extends AdditionalImageStoreFluent<AdditionalImageStoresNested<N>> implements Nested<N>{
  
    AdditionalImageStoreBuilder builder;
    int index;
  
    AdditionalImageStoresNested(int index,AdditionalImageStore item) {
      this.index = index;
      this.builder = new AdditionalImageStoreBuilder(this, item);
    }
  
    public N and() {
      return (N) ContainerRuntimeConfigurationFluent.this.setToAdditionalImageStores(index, builder.build());
    }
    
    public N endAdditionalImageStore() {
      return and();
    }
    
  }
  public class AdditionalLayerStoresNested<N> extends AdditionalLayerStoreFluent<AdditionalLayerStoresNested<N>> implements Nested<N>{
  
    AdditionalLayerStoreBuilder builder;
    int index;
  
    AdditionalLayerStoresNested(int index,AdditionalLayerStore item) {
      this.index = index;
      this.builder = new AdditionalLayerStoreBuilder(this, item);
    }
  
    public N and() {
      return (N) ContainerRuntimeConfigurationFluent.this.setToAdditionalLayerStores(index, builder.build());
    }
    
    public N endAdditionalLayerStore() {
      return and();
    }
    
  }
}