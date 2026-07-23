package io.fabric8.tekton.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class InternalTaskModifierFluent<A extends io.fabric8.tekton.v1beta1.InternalTaskModifierFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<StepBuilder> stepsToAppend = new ArrayList<StepBuilder>();
  private ArrayList<StepBuilder> stepsToPrepend = new ArrayList<StepBuilder>();
  private ArrayList<VolumeBuilder> volumes = new ArrayList<VolumeBuilder>();

  public InternalTaskModifierFluent() {
  }
  
  public InternalTaskModifierFluent(InternalTaskModifier instance) {
    this.copyInstance(instance);
  }

  public A addAllToStepsToAppend(Collection<Step> items) {
    if (this.stepsToAppend == null) {
      this.stepsToAppend = new ArrayList();
    }
    for (Step item : items) {
        StepBuilder builder = new StepBuilder(item);
        _visitables.get("stepsToAppend").add(builder);
        this.stepsToAppend.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToStepsToPrepend(Collection<Step> items) {
    if (this.stepsToPrepend == null) {
      this.stepsToPrepend = new ArrayList();
    }
    for (Step item : items) {
        StepBuilder builder = new StepBuilder(item);
        _visitables.get("stepsToPrepend").add(builder);
        this.stepsToPrepend.add(builder);
    }
    return (A) this;
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
  
  public StepsToAppendNested<A> addNewStepsToAppend() {
    return new StepsToAppendNested(-1, null);
  }
  
  public StepsToAppendNested<A> addNewStepsToAppendLike(Step item) {
    return new StepsToAppendNested(-1, item);
  }
  
  public StepsToPrependNested<A> addNewStepsToPrepend() {
    return new StepsToPrependNested(-1, null);
  }
  
  public StepsToPrependNested<A> addNewStepsToPrependLike(Step item) {
    return new StepsToPrependNested(-1, item);
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
  
  public A addToStepsToAppend(Step... items) {
    if (this.stepsToAppend == null) {
      this.stepsToAppend = new ArrayList();
    }
    for (Step item : items) {
        StepBuilder builder = new StepBuilder(item);
        _visitables.get("stepsToAppend").add(builder);
        this.stepsToAppend.add(builder);
    }
    return (A) this;
  }
  
  public A addToStepsToAppend(int index,Step item) {
    if (this.stepsToAppend == null) {
      this.stepsToAppend = new ArrayList();
    }
    StepBuilder builder = new StepBuilder(item);
    if (index < 0 || index >= stepsToAppend.size()) {
        _visitables.get("stepsToAppend").add(builder);
        stepsToAppend.add(builder);
    } else {
        _visitables.get("stepsToAppend").add(builder);
        stepsToAppend.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToStepsToPrepend(Step... items) {
    if (this.stepsToPrepend == null) {
      this.stepsToPrepend = new ArrayList();
    }
    for (Step item : items) {
        StepBuilder builder = new StepBuilder(item);
        _visitables.get("stepsToPrepend").add(builder);
        this.stepsToPrepend.add(builder);
    }
    return (A) this;
  }
  
  public A addToStepsToPrepend(int index,Step item) {
    if (this.stepsToPrepend == null) {
      this.stepsToPrepend = new ArrayList();
    }
    StepBuilder builder = new StepBuilder(item);
    if (index < 0 || index >= stepsToPrepend.size()) {
        _visitables.get("stepsToPrepend").add(builder);
        stepsToPrepend.add(builder);
    } else {
        _visitables.get("stepsToPrepend").add(builder);
        stepsToPrepend.add(index, builder);
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
  
  public Step buildFirstStepsToAppend() {
    return this.stepsToAppend.get(0).build();
  }
  
  public Step buildFirstStepsToPrepend() {
    return this.stepsToPrepend.get(0).build();
  }
  
  public Volume buildFirstVolume() {
    return this.volumes.get(0).build();
  }
  
  public Step buildLastStepsToAppend() {
    return this.stepsToAppend.get(stepsToAppend.size() - 1).build();
  }
  
  public Step buildLastStepsToPrepend() {
    return this.stepsToPrepend.get(stepsToPrepend.size() - 1).build();
  }
  
  public Volume buildLastVolume() {
    return this.volumes.get(volumes.size() - 1).build();
  }
  
  public Step buildMatchingStepsToAppend(Predicate<StepBuilder> predicate) {
      for (StepBuilder item : stepsToAppend) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public Step buildMatchingStepsToPrepend(Predicate<StepBuilder> predicate) {
      for (StepBuilder item : stepsToPrepend) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public Volume buildMatchingVolume(Predicate<VolumeBuilder> predicate) {
      for (VolumeBuilder item : volumes) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public List<Step> buildStepsToAppend() {
    return this.stepsToAppend != null ? build(stepsToAppend) : null;
  }
  
  public Step buildStepsToAppend(int index) {
    return this.stepsToAppend.get(index).build();
  }
  
  public List<Step> buildStepsToPrepend() {
    return this.stepsToPrepend != null ? build(stepsToPrepend) : null;
  }
  
  public Step buildStepsToPrepend(int index) {
    return this.stepsToPrepend.get(index).build();
  }
  
  public Volume buildVolume(int index) {
    return this.volumes.get(index).build();
  }
  
  public List<Volume> buildVolumes() {
    return this.volumes != null ? build(volumes) : null;
  }
  
  protected void copyInstance(InternalTaskModifier instance) {
    instance = instance != null ? instance : new InternalTaskModifier();
    if (instance != null) {
        this.withStepsToAppend(instance.getStepsToAppend());
        this.withStepsToPrepend(instance.getStepsToPrepend());
        this.withVolumes(instance.getVolumes());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public StepsToAppendNested<A> editFirstStepsToAppend() {
    if (stepsToAppend.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "stepsToAppend"));
    }
    return this.setNewStepsToAppendLike(0, this.buildStepsToAppend(0));
  }
  
  public StepsToPrependNested<A> editFirstStepsToPrepend() {
    if (stepsToPrepend.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "stepsToPrepend"));
    }
    return this.setNewStepsToPrependLike(0, this.buildStepsToPrepend(0));
  }
  
  public VolumesNested<A> editFirstVolume() {
    if (volumes.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "volumes"));
    }
    return this.setNewVolumeLike(0, this.buildVolume(0));
  }
  
  public StepsToAppendNested<A> editLastStepsToAppend() {
    int index = stepsToAppend.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "stepsToAppend"));
    }
    return this.setNewStepsToAppendLike(index, this.buildStepsToAppend(index));
  }
  
  public StepsToPrependNested<A> editLastStepsToPrepend() {
    int index = stepsToPrepend.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "stepsToPrepend"));
    }
    return this.setNewStepsToPrependLike(index, this.buildStepsToPrepend(index));
  }
  
  public VolumesNested<A> editLastVolume() {
    int index = volumes.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "volumes"));
    }
    return this.setNewVolumeLike(index, this.buildVolume(index));
  }
  
  public StepsToAppendNested<A> editMatchingStepsToAppend(Predicate<StepBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < stepsToAppend.size();i++) {
      if (predicate.test(stepsToAppend.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "stepsToAppend"));
    }
    return this.setNewStepsToAppendLike(index, this.buildStepsToAppend(index));
  }
  
  public StepsToPrependNested<A> editMatchingStepsToPrepend(Predicate<StepBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < stepsToPrepend.size();i++) {
      if (predicate.test(stepsToPrepend.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "stepsToPrepend"));
    }
    return this.setNewStepsToPrependLike(index, this.buildStepsToPrepend(index));
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
  
  public StepsToAppendNested<A> editStepsToAppend(int index) {
    if (stepsToAppend.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "stepsToAppend"));
    }
    return this.setNewStepsToAppendLike(index, this.buildStepsToAppend(index));
  }
  
  public StepsToPrependNested<A> editStepsToPrepend(int index) {
    if (stepsToPrepend.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "stepsToPrepend"));
    }
    return this.setNewStepsToPrependLike(index, this.buildStepsToPrepend(index));
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
    InternalTaskModifierFluent that = (InternalTaskModifierFluent) o;
    if (!(Objects.equals(stepsToAppend, that.stepsToAppend))) {
      return false;
    }
    if (!(Objects.equals(stepsToPrepend, that.stepsToPrepend))) {
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
  
  public boolean hasMatchingStepsToAppend(Predicate<StepBuilder> predicate) {
      for (StepBuilder item : stepsToAppend) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingStepsToPrepend(Predicate<StepBuilder> predicate) {
      for (StepBuilder item : stepsToPrepend) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingVolume(Predicate<VolumeBuilder> predicate) {
      for (VolumeBuilder item : volumes) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasStepsToAppend() {
    return this.stepsToAppend != null && !(this.stepsToAppend.isEmpty());
  }
  
  public boolean hasStepsToPrepend() {
    return this.stepsToPrepend != null && !(this.stepsToPrepend.isEmpty());
  }
  
  public boolean hasVolumes() {
    return this.volumes != null && !(this.volumes.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(stepsToAppend, stepsToPrepend, volumes, additionalProperties);
  }
  
  public A removeAllFromStepsToAppend(Collection<Step> items) {
    if (this.stepsToAppend == null) {
      return (A) this;
    }
    for (Step item : items) {
        StepBuilder builder = new StepBuilder(item);
        _visitables.get("stepsToAppend").remove(builder);
        this.stepsToAppend.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromStepsToPrepend(Collection<Step> items) {
    if (this.stepsToPrepend == null) {
      return (A) this;
    }
    for (Step item : items) {
        StepBuilder builder = new StepBuilder(item);
        _visitables.get("stepsToPrepend").remove(builder);
        this.stepsToPrepend.remove(builder);
    }
    return (A) this;
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
  
  public A removeFromStepsToAppend(Step... items) {
    if (this.stepsToAppend == null) {
      return (A) this;
    }
    for (Step item : items) {
        StepBuilder builder = new StepBuilder(item);
        _visitables.get("stepsToAppend").remove(builder);
        this.stepsToAppend.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromStepsToPrepend(Step... items) {
    if (this.stepsToPrepend == null) {
      return (A) this;
    }
    for (Step item : items) {
        StepBuilder builder = new StepBuilder(item);
        _visitables.get("stepsToPrepend").remove(builder);
        this.stepsToPrepend.remove(builder);
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
  
  public A removeMatchingFromStepsToAppend(Predicate<StepBuilder> predicate) {
    if (stepsToAppend == null) {
      return (A) this;
    }
    Iterator<StepBuilder> each = stepsToAppend.iterator();
    List visitables = _visitables.get("stepsToAppend");
    while (each.hasNext()) {
        StepBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromStepsToPrepend(Predicate<StepBuilder> predicate) {
    if (stepsToPrepend == null) {
      return (A) this;
    }
    Iterator<StepBuilder> each = stepsToPrepend.iterator();
    List visitables = _visitables.get("stepsToPrepend");
    while (each.hasNext()) {
        StepBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
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
  
  public StepsToAppendNested<A> setNewStepsToAppendLike(int index,Step item) {
    return new StepsToAppendNested(index, item);
  }
  
  public StepsToPrependNested<A> setNewStepsToPrependLike(int index,Step item) {
    return new StepsToPrependNested(index, item);
  }
  
  public VolumesNested<A> setNewVolumeLike(int index,Volume item) {
    return new VolumesNested(index, item);
  }
  
  public A setToStepsToAppend(int index,Step item) {
    if (this.stepsToAppend == null) {
      this.stepsToAppend = new ArrayList();
    }
    StepBuilder builder = new StepBuilder(item);
    if (index < 0 || index >= stepsToAppend.size()) {
        _visitables.get("stepsToAppend").add(builder);
        stepsToAppend.add(builder);
    } else {
        _visitables.get("stepsToAppend").add(builder);
        stepsToAppend.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToStepsToPrepend(int index,Step item) {
    if (this.stepsToPrepend == null) {
      this.stepsToPrepend = new ArrayList();
    }
    StepBuilder builder = new StepBuilder(item);
    if (index < 0 || index >= stepsToPrepend.size()) {
        _visitables.get("stepsToPrepend").add(builder);
        stepsToPrepend.add(builder);
    } else {
        _visitables.get("stepsToPrepend").add(builder);
        stepsToPrepend.set(index, builder);
    }
    return (A) this;
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
    if (!(stepsToAppend == null) && !(stepsToAppend.isEmpty())) {
        sb.append("stepsToAppend:");
        sb.append(stepsToAppend);
        sb.append(",");
    }
    if (!(stepsToPrepend == null) && !(stepsToPrepend.isEmpty())) {
        sb.append("stepsToPrepend:");
        sb.append(stepsToPrepend);
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
  
  public A withStepsToAppend(List<Step> stepsToAppend) {
    if (this.stepsToAppend != null) {
      this._visitables.get("stepsToAppend").clear();
    }
    if (stepsToAppend != null) {
        this.stepsToAppend = new ArrayList();
        for (Step item : stepsToAppend) {
          this.addToStepsToAppend(item);
        }
    } else {
      this.stepsToAppend = null;
    }
    return (A) this;
  }
  
  public A withStepsToAppend(Step... stepsToAppend) {
    if (this.stepsToAppend != null) {
        this.stepsToAppend.clear();
        _visitables.remove("stepsToAppend");
    }
    if (stepsToAppend != null) {
      for (Step item : stepsToAppend) {
        this.addToStepsToAppend(item);
      }
    }
    return (A) this;
  }
  
  public A withStepsToPrepend(List<Step> stepsToPrepend) {
    if (this.stepsToPrepend != null) {
      this._visitables.get("stepsToPrepend").clear();
    }
    if (stepsToPrepend != null) {
        this.stepsToPrepend = new ArrayList();
        for (Step item : stepsToPrepend) {
          this.addToStepsToPrepend(item);
        }
    } else {
      this.stepsToPrepend = null;
    }
    return (A) this;
  }
  
  public A withStepsToPrepend(Step... stepsToPrepend) {
    if (this.stepsToPrepend != null) {
        this.stepsToPrepend.clear();
        _visitables.remove("stepsToPrepend");
    }
    if (stepsToPrepend != null) {
      for (Step item : stepsToPrepend) {
        this.addToStepsToPrepend(item);
      }
    }
    return (A) this;
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
  public class StepsToAppendNested<N> extends StepFluent<StepsToAppendNested<N>> implements Nested<N>{
  
    StepBuilder builder;
    int index;
  
    StepsToAppendNested(int index,Step item) {
      this.index = index;
      this.builder = new StepBuilder(this, item);
    }
  
    public N and() {
      return (N) InternalTaskModifierFluent.this.setToStepsToAppend(index, builder.build());
    }
    
    public N endStepsToAppend() {
      return and();
    }
    
  }
  public class StepsToPrependNested<N> extends StepFluent<StepsToPrependNested<N>> implements Nested<N>{
  
    StepBuilder builder;
    int index;
  
    StepsToPrependNested(int index,Step item) {
      this.index = index;
      this.builder = new StepBuilder(this, item);
    }
  
    public N and() {
      return (N) InternalTaskModifierFluent.this.setToStepsToPrepend(index, builder.build());
    }
    
    public N endStepsToPrepend() {
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
      return (N) InternalTaskModifierFluent.this.setToVolumes(index, builder.build());
    }
    
    public N endVolume() {
      return and();
    }
    
  }
}