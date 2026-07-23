package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerBuilder;
import io.fabric8.kubernetes.api.model.ContainerFluent;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeBuilder;
import io.fabric8.kubernetes.api.model.VolumeFluent;
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
public class TaskFluent<A extends io.fabric8.chaosmesh.v1alpha1.TaskFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ContainerBuilder container;
  private ArrayList<VolumeBuilder> volumes = new ArrayList<VolumeBuilder>();

  public TaskFluent() {
  }
  
  public TaskFluent(Task instance) {
    this.copyInstance(instance);
  }

  public A addAllToVolumes(Collection<Volume> items) {
    if (this.volumes == null) {
      this.volumes = new ArrayList();
    }
    for (Volume item : items) {
        VolumeBuilder builder = new VolumeBuilder(item);
        _visitables.get("volumes").add(builder);
        this.volumes.add(builder);
    }
    return (A) this;
  }
  
  public VolumesNested<A> addNewVolume() {
    return new VolumesNested(-1, null);
  }
  
  public VolumesNested<A> addNewVolumeLike(Volume item) {
    return new VolumesNested(-1, item);
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
  
  public A addToVolumes(Volume... items) {
    if (this.volumes == null) {
      this.volumes = new ArrayList();
    }
    for (Volume item : items) {
        VolumeBuilder builder = new VolumeBuilder(item);
        _visitables.get("volumes").add(builder);
        this.volumes.add(builder);
    }
    return (A) this;
  }
  
  public A addToVolumes(int index,Volume item) {
    if (this.volumes == null) {
      this.volumes = new ArrayList();
    }
    VolumeBuilder builder = new VolumeBuilder(item);
    if (index < 0 || index >= volumes.size()) {
        _visitables.get("volumes").add(builder);
        volumes.add(builder);
    } else {
        _visitables.get("volumes").add(builder);
        volumes.add(index, builder);
    }
    return (A) this;
  }
  
  public Container buildContainer() {
    return this.container != null ? this.container.build() : null;
  }
  
  public Volume buildFirstVolume() {
    return this.volumes.get(0).build();
  }
  
  public Volume buildLastVolume() {
    return this.volumes.get(volumes.size() - 1).build();
  }
  
  public Volume buildMatchingVolume(Predicate<VolumeBuilder> predicate) {
      for (VolumeBuilder item : volumes) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public Volume buildVolume(int index) {
    return this.volumes.get(index).build();
  }
  
  public List<Volume> buildVolumes() {
    return this.volumes != null ? build(volumes) : null;
  }
  
  protected void copyInstance(Task instance) {
    instance = instance != null ? instance : new Task();
    if (instance != null) {
        this.withContainer(instance.getContainer());
        this.withVolumes(instance.getVolumes());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ContainerNested<A> editContainer() {
    return this.withNewContainerLike(Optional.ofNullable(this.buildContainer()).orElse(null));
  }
  
  public VolumesNested<A> editFirstVolume() {
    if (volumes.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "volumes"));
    }
    return this.setNewVolumeLike(0, this.buildVolume(0));
  }
  
  public VolumesNested<A> editLastVolume() {
    int index = volumes.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "volumes"));
    }
    return this.setNewVolumeLike(index, this.buildVolume(index));
  }
  
  public VolumesNested<A> editMatchingVolume(Predicate<VolumeBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < volumes.size();i++) {
      if (predicate.test(volumes.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "volumes"));
    }
    return this.setNewVolumeLike(index, this.buildVolume(index));
  }
  
  public ContainerNested<A> editOrNewContainer() {
    return this.withNewContainerLike(Optional.ofNullable(this.buildContainer()).orElse(new ContainerBuilder().build()));
  }
  
  public ContainerNested<A> editOrNewContainerLike(Container item) {
    return this.withNewContainerLike(Optional.ofNullable(this.buildContainer()).orElse(item));
  }
  
  public VolumesNested<A> editVolume(int index) {
    if (volumes.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "volumes"));
    }
    return this.setNewVolumeLike(index, this.buildVolume(index));
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
    TaskFluent that = (TaskFluent) o;
    if (!(Objects.equals(container, that.container))) {
      return false;
    }
    if (!(Objects.equals(volumes, that.volumes))) {
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
  
  public boolean hasContainer() {
    return this.container != null;
  }
  
  public boolean hasMatchingVolume(Predicate<VolumeBuilder> predicate) {
      for (VolumeBuilder item : volumes) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasVolumes() {
    return this.volumes != null && !(this.volumes.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(container, volumes, additionalProperties);
  }
  
  public A removeAllFromVolumes(Collection<Volume> items) {
    if (this.volumes == null) {
      return (A) this;
    }
    for (Volume item : items) {
        VolumeBuilder builder = new VolumeBuilder(item);
        _visitables.get("volumes").remove(builder);
        this.volumes.remove(builder);
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
  
  public A removeFromVolumes(Volume... items) {
    if (this.volumes == null) {
      return (A) this;
    }
    for (Volume item : items) {
        VolumeBuilder builder = new VolumeBuilder(item);
        _visitables.get("volumes").remove(builder);
        this.volumes.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromVolumes(Predicate<VolumeBuilder> predicate) {
    if (volumes == null) {
      return (A) this;
    }
    Iterator<VolumeBuilder> each = volumes.iterator();
    List visitables = _visitables.get("volumes");
    while (each.hasNext()) {
        VolumeBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public VolumesNested<A> setNewVolumeLike(int index,Volume item) {
    return new VolumesNested(index, item);
  }
  
  public A setToVolumes(int index,Volume item) {
    if (this.volumes == null) {
      this.volumes = new ArrayList();
    }
    VolumeBuilder builder = new VolumeBuilder(item);
    if (index < 0 || index >= volumes.size()) {
        _visitables.get("volumes").add(builder);
        volumes.add(builder);
    } else {
        _visitables.get("volumes").add(builder);
        volumes.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(container == null)) {
        sb.append("container:");
        sb.append(container);
        sb.append(",");
    }
    if (!(volumes == null) && !(volumes.isEmpty())) {
        sb.append("volumes:");
        sb.append(volumes);
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
  
  public A withContainer(Container container) {
    this._visitables.remove("container");
    if (container != null) {
        this.container = new ContainerBuilder(container);
        this._visitables.get("container").add(this.container);
    } else {
        this.container = null;
        this._visitables.get("container").remove(this.container);
    }
    return (A) this;
  }
  
  public ContainerNested<A> withNewContainer() {
    return new ContainerNested(null);
  }
  
  public ContainerNested<A> withNewContainerLike(Container item) {
    return new ContainerNested(item);
  }
  
  public A withVolumes(List<Volume> volumes) {
    if (this.volumes != null) {
      this._visitables.get("volumes").clear();
    }
    if (volumes != null) {
        this.volumes = new ArrayList();
        for (Volume item : volumes) {
          this.addToVolumes(item);
        }
    } else {
      this.volumes = null;
    }
    return (A) this;
  }
  
  public A withVolumes(Volume... volumes) {
    if (this.volumes != null) {
        this.volumes.clear();
        _visitables.remove("volumes");
    }
    if (volumes != null) {
      for (Volume item : volumes) {
        this.addToVolumes(item);
      }
    }
    return (A) this;
  }
  public class ContainerNested<N> extends ContainerFluent<ContainerNested<N>> implements Nested<N>{
  
    ContainerBuilder builder;
  
    ContainerNested(Container item) {
      this.builder = new ContainerBuilder(this, item);
    }
  
    public N and() {
      return (N) TaskFluent.this.withContainer(builder.build());
    }
    
    public N endContainer() {
      return and();
    }
    
  }
  public class VolumesNested<N> extends VolumeFluent<VolumesNested<N>> implements Nested<N>{
  
    VolumeBuilder builder;
    int index;
  
    VolumesNested(int index,Volume item) {
      this.index = index;
      this.builder = new VolumeBuilder(this, item);
    }
  
    public N and() {
      return (N) TaskFluent.this.setToVolumes(index, builder.build());
    }
    
    public N endVolume() {
      return and();
    }
    
  }
}