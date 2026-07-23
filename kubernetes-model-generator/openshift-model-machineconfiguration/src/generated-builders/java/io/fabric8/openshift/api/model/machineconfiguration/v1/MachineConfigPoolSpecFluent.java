package io.fabric8.openshift.api.model.machineconfiguration.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.IntOrStringBuilder;
import io.fabric8.kubernetes.api.model.IntOrStringFluent;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LabelSelectorBuilder;
import io.fabric8.kubernetes.api.model.LabelSelectorFluent;
import java.lang.Boolean;
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
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class MachineConfigPoolSpecFluent<A extends io.fabric8.openshift.api.model.machineconfiguration.v1.MachineConfigPoolSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private MachineConfigPoolStatusConfigurationBuilder configuration;
  private LabelSelectorBuilder machineConfigSelector;
  private IntOrStringBuilder maxUnavailable;
  private LabelSelectorBuilder nodeSelector;
  private Boolean paused;
  private ArrayList<PinnedImageSetRefBuilder> pinnedImageSets = new ArrayList<PinnedImageSetRefBuilder>();

  public MachineConfigPoolSpecFluent() {
  }
  
  public MachineConfigPoolSpecFluent(MachineConfigPoolSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToPinnedImageSets(Collection<PinnedImageSetRef> items) {
    if (this.pinnedImageSets == null) {
      this.pinnedImageSets = new ArrayList();
    }
    for (PinnedImageSetRef item : items) {
        PinnedImageSetRefBuilder builder = new PinnedImageSetRefBuilder(item);
        _visitables.get("pinnedImageSets").add(builder);
        this.pinnedImageSets.add(builder);
    }
    return (A) this;
  }
  
  public PinnedImageSetsNested<A> addNewPinnedImageSet() {
    return new PinnedImageSetsNested(-1, null);
  }
  
  public A addNewPinnedImageSet(String name) {
    return (A) this.addToPinnedImageSets(new PinnedImageSetRef(name));
  }
  
  public PinnedImageSetsNested<A> addNewPinnedImageSetLike(PinnedImageSetRef item) {
    return new PinnedImageSetsNested(-1, item);
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
  
  public A addToPinnedImageSets(PinnedImageSetRef... items) {
    if (this.pinnedImageSets == null) {
      this.pinnedImageSets = new ArrayList();
    }
    for (PinnedImageSetRef item : items) {
        PinnedImageSetRefBuilder builder = new PinnedImageSetRefBuilder(item);
        _visitables.get("pinnedImageSets").add(builder);
        this.pinnedImageSets.add(builder);
    }
    return (A) this;
  }
  
  public A addToPinnedImageSets(int index,PinnedImageSetRef item) {
    if (this.pinnedImageSets == null) {
      this.pinnedImageSets = new ArrayList();
    }
    PinnedImageSetRefBuilder builder = new PinnedImageSetRefBuilder(item);
    if (index < 0 || index >= pinnedImageSets.size()) {
        _visitables.get("pinnedImageSets").add(builder);
        pinnedImageSets.add(builder);
    } else {
        _visitables.get("pinnedImageSets").add(builder);
        pinnedImageSets.add(index, builder);
    }
    return (A) this;
  }
  
  public MachineConfigPoolStatusConfiguration buildConfiguration() {
    return this.configuration != null ? this.configuration.build() : null;
  }
  
  public PinnedImageSetRef buildFirstPinnedImageSet() {
    return this.pinnedImageSets.get(0).build();
  }
  
  public PinnedImageSetRef buildLastPinnedImageSet() {
    return this.pinnedImageSets.get(pinnedImageSets.size() - 1).build();
  }
  
  public LabelSelector buildMachineConfigSelector() {
    return this.machineConfigSelector != null ? this.machineConfigSelector.build() : null;
  }
  
  public PinnedImageSetRef buildMatchingPinnedImageSet(Predicate<PinnedImageSetRefBuilder> predicate) {
      for (PinnedImageSetRefBuilder item : pinnedImageSets) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public IntOrString buildMaxUnavailable() {
    return this.maxUnavailable != null ? this.maxUnavailable.build() : null;
  }
  
  public LabelSelector buildNodeSelector() {
    return this.nodeSelector != null ? this.nodeSelector.build() : null;
  }
  
  public PinnedImageSetRef buildPinnedImageSet(int index) {
    return this.pinnedImageSets.get(index).build();
  }
  
  public List<PinnedImageSetRef> buildPinnedImageSets() {
    return this.pinnedImageSets != null ? build(pinnedImageSets) : null;
  }
  
  protected void copyInstance(MachineConfigPoolSpec instance) {
    instance = instance != null ? instance : new MachineConfigPoolSpec();
    if (instance != null) {
        this.withConfiguration(instance.getConfiguration());
        this.withMachineConfigSelector(instance.getMachineConfigSelector());
        this.withMaxUnavailable(instance.getMaxUnavailable());
        this.withNodeSelector(instance.getNodeSelector());
        this.withPaused(instance.getPaused());
        this.withPinnedImageSets(instance.getPinnedImageSets());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ConfigurationNested<A> editConfiguration() {
    return this.withNewConfigurationLike(Optional.ofNullable(this.buildConfiguration()).orElse(null));
  }
  
  public PinnedImageSetsNested<A> editFirstPinnedImageSet() {
    if (pinnedImageSets.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "pinnedImageSets"));
    }
    return this.setNewPinnedImageSetLike(0, this.buildPinnedImageSet(0));
  }
  
  public PinnedImageSetsNested<A> editLastPinnedImageSet() {
    int index = pinnedImageSets.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "pinnedImageSets"));
    }
    return this.setNewPinnedImageSetLike(index, this.buildPinnedImageSet(index));
  }
  
  public MachineConfigSelectorNested<A> editMachineConfigSelector() {
    return this.withNewMachineConfigSelectorLike(Optional.ofNullable(this.buildMachineConfigSelector()).orElse(null));
  }
  
  public PinnedImageSetsNested<A> editMatchingPinnedImageSet(Predicate<PinnedImageSetRefBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < pinnedImageSets.size();i++) {
      if (predicate.test(pinnedImageSets.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "pinnedImageSets"));
    }
    return this.setNewPinnedImageSetLike(index, this.buildPinnedImageSet(index));
  }
  
  public MaxUnavailableNested<A> editMaxUnavailable() {
    return this.withNewMaxUnavailableLike(Optional.ofNullable(this.buildMaxUnavailable()).orElse(null));
  }
  
  public NodeSelectorNested<A> editNodeSelector() {
    return this.withNewNodeSelectorLike(Optional.ofNullable(this.buildNodeSelector()).orElse(null));
  }
  
  public ConfigurationNested<A> editOrNewConfiguration() {
    return this.withNewConfigurationLike(Optional.ofNullable(this.buildConfiguration()).orElse(new MachineConfigPoolStatusConfigurationBuilder().build()));
  }
  
  public ConfigurationNested<A> editOrNewConfigurationLike(MachineConfigPoolStatusConfiguration item) {
    return this.withNewConfigurationLike(Optional.ofNullable(this.buildConfiguration()).orElse(item));
  }
  
  public MachineConfigSelectorNested<A> editOrNewMachineConfigSelector() {
    return this.withNewMachineConfigSelectorLike(Optional.ofNullable(this.buildMachineConfigSelector()).orElse(new LabelSelectorBuilder().build()));
  }
  
  public MachineConfigSelectorNested<A> editOrNewMachineConfigSelectorLike(LabelSelector item) {
    return this.withNewMachineConfigSelectorLike(Optional.ofNullable(this.buildMachineConfigSelector()).orElse(item));
  }
  
  public MaxUnavailableNested<A> editOrNewMaxUnavailable() {
    return this.withNewMaxUnavailableLike(Optional.ofNullable(this.buildMaxUnavailable()).orElse(new IntOrStringBuilder().build()));
  }
  
  public MaxUnavailableNested<A> editOrNewMaxUnavailableLike(IntOrString item) {
    return this.withNewMaxUnavailableLike(Optional.ofNullable(this.buildMaxUnavailable()).orElse(item));
  }
  
  public NodeSelectorNested<A> editOrNewNodeSelector() {
    return this.withNewNodeSelectorLike(Optional.ofNullable(this.buildNodeSelector()).orElse(new LabelSelectorBuilder().build()));
  }
  
  public NodeSelectorNested<A> editOrNewNodeSelectorLike(LabelSelector item) {
    return this.withNewNodeSelectorLike(Optional.ofNullable(this.buildNodeSelector()).orElse(item));
  }
  
  public PinnedImageSetsNested<A> editPinnedImageSet(int index) {
    if (pinnedImageSets.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "pinnedImageSets"));
    }
    return this.setNewPinnedImageSetLike(index, this.buildPinnedImageSet(index));
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
    MachineConfigPoolSpecFluent that = (MachineConfigPoolSpecFluent) o;
    if (!(Objects.equals(configuration, that.configuration))) {
      return false;
    }
    if (!(Objects.equals(machineConfigSelector, that.machineConfigSelector))) {
      return false;
    }
    if (!(Objects.equals(maxUnavailable, that.maxUnavailable))) {
      return false;
    }
    if (!(Objects.equals(nodeSelector, that.nodeSelector))) {
      return false;
    }
    if (!(Objects.equals(paused, that.paused))) {
      return false;
    }
    if (!(Objects.equals(pinnedImageSets, that.pinnedImageSets))) {
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
  
  public Boolean getPaused() {
    return this.paused;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasConfiguration() {
    return this.configuration != null;
  }
  
  public boolean hasMachineConfigSelector() {
    return this.machineConfigSelector != null;
  }
  
  public boolean hasMatchingPinnedImageSet(Predicate<PinnedImageSetRefBuilder> predicate) {
      for (PinnedImageSetRefBuilder item : pinnedImageSets) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMaxUnavailable() {
    return this.maxUnavailable != null;
  }
  
  public boolean hasNodeSelector() {
    return this.nodeSelector != null;
  }
  
  public boolean hasPaused() {
    return this.paused != null;
  }
  
  public boolean hasPinnedImageSets() {
    return this.pinnedImageSets != null && !(this.pinnedImageSets.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(configuration, machineConfigSelector, maxUnavailable, nodeSelector, paused, pinnedImageSets, additionalProperties);
  }
  
  public A removeAllFromPinnedImageSets(Collection<PinnedImageSetRef> items) {
    if (this.pinnedImageSets == null) {
      return (A) this;
    }
    for (PinnedImageSetRef item : items) {
        PinnedImageSetRefBuilder builder = new PinnedImageSetRefBuilder(item);
        _visitables.get("pinnedImageSets").remove(builder);
        this.pinnedImageSets.remove(builder);
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
  
  public A removeFromPinnedImageSets(PinnedImageSetRef... items) {
    if (this.pinnedImageSets == null) {
      return (A) this;
    }
    for (PinnedImageSetRef item : items) {
        PinnedImageSetRefBuilder builder = new PinnedImageSetRefBuilder(item);
        _visitables.get("pinnedImageSets").remove(builder);
        this.pinnedImageSets.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromPinnedImageSets(Predicate<PinnedImageSetRefBuilder> predicate) {
    if (pinnedImageSets == null) {
      return (A) this;
    }
    Iterator<PinnedImageSetRefBuilder> each = pinnedImageSets.iterator();
    List visitables = _visitables.get("pinnedImageSets");
    while (each.hasNext()) {
        PinnedImageSetRefBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public PinnedImageSetsNested<A> setNewPinnedImageSetLike(int index,PinnedImageSetRef item) {
    return new PinnedImageSetsNested(index, item);
  }
  
  public A setToPinnedImageSets(int index,PinnedImageSetRef item) {
    if (this.pinnedImageSets == null) {
      this.pinnedImageSets = new ArrayList();
    }
    PinnedImageSetRefBuilder builder = new PinnedImageSetRefBuilder(item);
    if (index < 0 || index >= pinnedImageSets.size()) {
        _visitables.get("pinnedImageSets").add(builder);
        pinnedImageSets.add(builder);
    } else {
        _visitables.get("pinnedImageSets").add(builder);
        pinnedImageSets.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(configuration == null)) {
        sb.append("configuration:");
        sb.append(configuration);
        sb.append(",");
    }
    if (!(machineConfigSelector == null)) {
        sb.append("machineConfigSelector:");
        sb.append(machineConfigSelector);
        sb.append(",");
    }
    if (!(maxUnavailable == null)) {
        sb.append("maxUnavailable:");
        sb.append(maxUnavailable);
        sb.append(",");
    }
    if (!(nodeSelector == null)) {
        sb.append("nodeSelector:");
        sb.append(nodeSelector);
        sb.append(",");
    }
    if (!(paused == null)) {
        sb.append("paused:");
        sb.append(paused);
        sb.append(",");
    }
    if (!(pinnedImageSets == null) && !(pinnedImageSets.isEmpty())) {
        sb.append("pinnedImageSets:");
        sb.append(pinnedImageSets);
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
  
  public A withConfiguration(MachineConfigPoolStatusConfiguration configuration) {
    this._visitables.remove("configuration");
    if (configuration != null) {
        this.configuration = new MachineConfigPoolStatusConfigurationBuilder(configuration);
        this._visitables.get("configuration").add(this.configuration);
    } else {
        this.configuration = null;
        this._visitables.get("configuration").remove(this.configuration);
    }
    return (A) this;
  }
  
  public A withMachineConfigSelector(LabelSelector machineConfigSelector) {
    this._visitables.remove("machineConfigSelector");
    if (machineConfigSelector != null) {
        this.machineConfigSelector = new LabelSelectorBuilder(machineConfigSelector);
        this._visitables.get("machineConfigSelector").add(this.machineConfigSelector);
    } else {
        this.machineConfigSelector = null;
        this._visitables.get("machineConfigSelector").remove(this.machineConfigSelector);
    }
    return (A) this;
  }
  
  public A withMaxUnavailable(IntOrString maxUnavailable) {
    this._visitables.remove("maxUnavailable");
    if (maxUnavailable != null) {
        this.maxUnavailable = new IntOrStringBuilder(maxUnavailable);
        this._visitables.get("maxUnavailable").add(this.maxUnavailable);
    } else {
        this.maxUnavailable = null;
        this._visitables.get("maxUnavailable").remove(this.maxUnavailable);
    }
    return (A) this;
  }
  
  public ConfigurationNested<A> withNewConfiguration() {
    return new ConfigurationNested(null);
  }
  
  public ConfigurationNested<A> withNewConfigurationLike(MachineConfigPoolStatusConfiguration item) {
    return new ConfigurationNested(item);
  }
  
  public MachineConfigSelectorNested<A> withNewMachineConfigSelector() {
    return new MachineConfigSelectorNested(null);
  }
  
  public MachineConfigSelectorNested<A> withNewMachineConfigSelectorLike(LabelSelector item) {
    return new MachineConfigSelectorNested(item);
  }
  
  public MaxUnavailableNested<A> withNewMaxUnavailable() {
    return new MaxUnavailableNested(null);
  }
  
  public A withNewMaxUnavailable(Object value) {
    return (A) this.withMaxUnavailable(new IntOrString(value));
  }
  
  public MaxUnavailableNested<A> withNewMaxUnavailableLike(IntOrString item) {
    return new MaxUnavailableNested(item);
  }
  
  public NodeSelectorNested<A> withNewNodeSelector() {
    return new NodeSelectorNested(null);
  }
  
  public NodeSelectorNested<A> withNewNodeSelectorLike(LabelSelector item) {
    return new NodeSelectorNested(item);
  }
  
  public A withNodeSelector(LabelSelector nodeSelector) {
    this._visitables.remove("nodeSelector");
    if (nodeSelector != null) {
        this.nodeSelector = new LabelSelectorBuilder(nodeSelector);
        this._visitables.get("nodeSelector").add(this.nodeSelector);
    } else {
        this.nodeSelector = null;
        this._visitables.get("nodeSelector").remove(this.nodeSelector);
    }
    return (A) this;
  }
  
  public A withPaused() {
    return withPaused(true);
  }
  
  public A withPaused(Boolean paused) {
    this.paused = paused;
    return (A) this;
  }
  
  public A withPinnedImageSets(List<PinnedImageSetRef> pinnedImageSets) {
    if (this.pinnedImageSets != null) {
      this._visitables.get("pinnedImageSets").clear();
    }
    if (pinnedImageSets != null) {
        this.pinnedImageSets = new ArrayList();
        for (PinnedImageSetRef item : pinnedImageSets) {
          this.addToPinnedImageSets(item);
        }
    } else {
      this.pinnedImageSets = null;
    }
    return (A) this;
  }
  
  public A withPinnedImageSets(PinnedImageSetRef... pinnedImageSets) {
    if (this.pinnedImageSets != null) {
        this.pinnedImageSets.clear();
        _visitables.remove("pinnedImageSets");
    }
    if (pinnedImageSets != null) {
      for (PinnedImageSetRef item : pinnedImageSets) {
        this.addToPinnedImageSets(item);
      }
    }
    return (A) this;
  }
  public class ConfigurationNested<N> extends MachineConfigPoolStatusConfigurationFluent<ConfigurationNested<N>> implements Nested<N>{
  
    MachineConfigPoolStatusConfigurationBuilder builder;
  
    ConfigurationNested(MachineConfigPoolStatusConfiguration item) {
      this.builder = new MachineConfigPoolStatusConfigurationBuilder(this, item);
    }
  
    public N and() {
      return (N) MachineConfigPoolSpecFluent.this.withConfiguration(builder.build());
    }
    
    public N endConfiguration() {
      return and();
    }
    
  }
  public class MachineConfigSelectorNested<N> extends LabelSelectorFluent<MachineConfigSelectorNested<N>> implements Nested<N>{
  
    LabelSelectorBuilder builder;
  
    MachineConfigSelectorNested(LabelSelector item) {
      this.builder = new LabelSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) MachineConfigPoolSpecFluent.this.withMachineConfigSelector(builder.build());
    }
    
    public N endMachineConfigSelector() {
      return and();
    }
    
  }
  public class MaxUnavailableNested<N> extends IntOrStringFluent<MaxUnavailableNested<N>> implements Nested<N>{
  
    IntOrStringBuilder builder;
  
    MaxUnavailableNested(IntOrString item) {
      this.builder = new IntOrStringBuilder(this, item);
    }
  
    public N and() {
      return (N) MachineConfigPoolSpecFluent.this.withMaxUnavailable(builder.build());
    }
    
    public N endMaxUnavailable() {
      return and();
    }
    
  }
  public class NodeSelectorNested<N> extends LabelSelectorFluent<NodeSelectorNested<N>> implements Nested<N>{
  
    LabelSelectorBuilder builder;
  
    NodeSelectorNested(LabelSelector item) {
      this.builder = new LabelSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) MachineConfigPoolSpecFluent.this.withNodeSelector(builder.build());
    }
    
    public N endNodeSelector() {
      return and();
    }
    
  }
  public class PinnedImageSetsNested<N> extends PinnedImageSetRefFluent<PinnedImageSetsNested<N>> implements Nested<N>{
  
    PinnedImageSetRefBuilder builder;
    int index;
  
    PinnedImageSetsNested(int index,PinnedImageSetRef item) {
      this.index = index;
      this.builder = new PinnedImageSetRefBuilder(this, item);
    }
  
    public N and() {
      return (N) MachineConfigPoolSpecFluent.this.setToPinnedImageSets(index, builder.build());
    }
    
    public N endPinnedImageSet() {
      return and();
    }
    
  }
}