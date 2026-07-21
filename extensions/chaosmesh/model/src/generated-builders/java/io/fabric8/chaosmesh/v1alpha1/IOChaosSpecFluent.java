package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Integer;
import java.lang.Long;
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
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class IOChaosSpecFluent<A extends io.fabric8.chaosmesh.v1alpha1.IOChaosSpecFluent<A>> extends BaseFluent<A>{

  private String action;
  private Map<String,Object> additionalProperties;
  private AttrOverrideSpecBuilder attr;
  private List<String> containerNames = new ArrayList<String>();
  private String delay;
  private String duration;
  private Long errno;
  private List<String> methods = new ArrayList<String>();
  private MistakeSpecBuilder mistake;
  private String mode;
  private String path;
  private Integer percent;
  private String remoteCluster;
  private PodSelectorSpecBuilder selector;
  private String value;
  private String volumePath;

  public IOChaosSpecFluent() {
  }
  
  public IOChaosSpecFluent(IOChaosSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToContainerNames(Collection<String> items) {
    if (this.containerNames == null) {
      this.containerNames = new ArrayList();
    }
    for (String item : items) {
      this.containerNames.add(item);
    }
    return (A) this;
  }
  
  public A addAllToMethods(Collection<String> items) {
    if (this.methods == null) {
      this.methods = new ArrayList();
    }
    for (String item : items) {
      this.methods.add(item);
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
  
  public A addToContainerNames(String... items) {
    if (this.containerNames == null) {
      this.containerNames = new ArrayList();
    }
    for (String item : items) {
      this.containerNames.add(item);
    }
    return (A) this;
  }
  
  public A addToContainerNames(int index,String item) {
    if (this.containerNames == null) {
      this.containerNames = new ArrayList();
    }
    this.containerNames.add(index, item);
    return (A) this;
  }
  
  public A addToMethods(String... items) {
    if (this.methods == null) {
      this.methods = new ArrayList();
    }
    for (String item : items) {
      this.methods.add(item);
    }
    return (A) this;
  }
  
  public A addToMethods(int index,String item) {
    if (this.methods == null) {
      this.methods = new ArrayList();
    }
    this.methods.add(index, item);
    return (A) this;
  }
  
  public AttrOverrideSpec buildAttr() {
    return this.attr != null ? this.attr.build() : null;
  }
  
  public MistakeSpec buildMistake() {
    return this.mistake != null ? this.mistake.build() : null;
  }
  
  public PodSelectorSpec buildSelector() {
    return this.selector != null ? this.selector.build() : null;
  }
  
  protected void copyInstance(IOChaosSpec instance) {
    instance = instance != null ? instance : new IOChaosSpec();
    if (instance != null) {
        this.withAction(instance.getAction());
        this.withAttr(instance.getAttr());
        this.withContainerNames(instance.getContainerNames());
        this.withDelay(instance.getDelay());
        this.withDuration(instance.getDuration());
        this.withErrno(instance.getErrno());
        this.withMethods(instance.getMethods());
        this.withMistake(instance.getMistake());
        this.withMode(instance.getMode());
        this.withPath(instance.getPath());
        this.withPercent(instance.getPercent());
        this.withRemoteCluster(instance.getRemoteCluster());
        this.withSelector(instance.getSelector());
        this.withValue(instance.getValue());
        this.withVolumePath(instance.getVolumePath());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AttrNested<A> editAttr() {
    return this.withNewAttrLike(Optional.ofNullable(this.buildAttr()).orElse(null));
  }
  
  public MistakeNested<A> editMistake() {
    return this.withNewMistakeLike(Optional.ofNullable(this.buildMistake()).orElse(null));
  }
  
  public AttrNested<A> editOrNewAttr() {
    return this.withNewAttrLike(Optional.ofNullable(this.buildAttr()).orElse(new AttrOverrideSpecBuilder().build()));
  }
  
  public AttrNested<A> editOrNewAttrLike(AttrOverrideSpec item) {
    return this.withNewAttrLike(Optional.ofNullable(this.buildAttr()).orElse(item));
  }
  
  public MistakeNested<A> editOrNewMistake() {
    return this.withNewMistakeLike(Optional.ofNullable(this.buildMistake()).orElse(new MistakeSpecBuilder().build()));
  }
  
  public MistakeNested<A> editOrNewMistakeLike(MistakeSpec item) {
    return this.withNewMistakeLike(Optional.ofNullable(this.buildMistake()).orElse(item));
  }
  
  public SelectorNested<A> editOrNewSelector() {
    return this.withNewSelectorLike(Optional.ofNullable(this.buildSelector()).orElse(new PodSelectorSpecBuilder().build()));
  }
  
  public SelectorNested<A> editOrNewSelectorLike(PodSelectorSpec item) {
    return this.withNewSelectorLike(Optional.ofNullable(this.buildSelector()).orElse(item));
  }
  
  public SelectorNested<A> editSelector() {
    return this.withNewSelectorLike(Optional.ofNullable(this.buildSelector()).orElse(null));
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
    IOChaosSpecFluent that = (IOChaosSpecFluent) o;
    if (!(Objects.equals(action, that.action))) {
      return false;
    }
    if (!(Objects.equals(attr, that.attr))) {
      return false;
    }
    if (!(Objects.equals(containerNames, that.containerNames))) {
      return false;
    }
    if (!(Objects.equals(delay, that.delay))) {
      return false;
    }
    if (!(Objects.equals(duration, that.duration))) {
      return false;
    }
    if (!(Objects.equals(errno, that.errno))) {
      return false;
    }
    if (!(Objects.equals(methods, that.methods))) {
      return false;
    }
    if (!(Objects.equals(mistake, that.mistake))) {
      return false;
    }
    if (!(Objects.equals(mode, that.mode))) {
      return false;
    }
    if (!(Objects.equals(path, that.path))) {
      return false;
    }
    if (!(Objects.equals(percent, that.percent))) {
      return false;
    }
    if (!(Objects.equals(remoteCluster, that.remoteCluster))) {
      return false;
    }
    if (!(Objects.equals(selector, that.selector))) {
      return false;
    }
    if (!(Objects.equals(value, that.value))) {
      return false;
    }
    if (!(Objects.equals(volumePath, that.volumePath))) {
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
  
  public String getContainerName(int index) {
    return this.containerNames.get(index);
  }
  
  public List<String> getContainerNames() {
    return this.containerNames;
  }
  
  public String getDelay() {
    return this.delay;
  }
  
  public String getDuration() {
    return this.duration;
  }
  
  public Long getErrno() {
    return this.errno;
  }
  
  public String getFirstContainerName() {
    return this.containerNames.get(0);
  }
  
  public String getFirstMethod() {
    return this.methods.get(0);
  }
  
  public String getLastContainerName() {
    return this.containerNames.get(containerNames.size() - 1);
  }
  
  public String getLastMethod() {
    return this.methods.get(methods.size() - 1);
  }
  
  public String getMatchingContainerName(Predicate<String> predicate) {
      for (String item : containerNames) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingMethod(Predicate<String> predicate) {
      for (String item : methods) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMethod(int index) {
    return this.methods.get(index);
  }
  
  public List<String> getMethods() {
    return this.methods;
  }
  
  public String getMode() {
    return this.mode;
  }
  
  public String getPath() {
    return this.path;
  }
  
  public Integer getPercent() {
    return this.percent;
  }
  
  public String getRemoteCluster() {
    return this.remoteCluster;
  }
  
  public String getValue() {
    return this.value;
  }
  
  public String getVolumePath() {
    return this.volumePath;
  }
  
  public boolean hasAction() {
    return this.action != null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAttr() {
    return this.attr != null;
  }
  
  public boolean hasContainerNames() {
    return this.containerNames != null && !(this.containerNames.isEmpty());
  }
  
  public boolean hasDelay() {
    return this.delay != null;
  }
  
  public boolean hasDuration() {
    return this.duration != null;
  }
  
  public boolean hasErrno() {
    return this.errno != null;
  }
  
  public boolean hasMatchingContainerName(Predicate<String> predicate) {
      for (String item : containerNames) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingMethod(Predicate<String> predicate) {
      for (String item : methods) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMethods() {
    return this.methods != null && !(this.methods.isEmpty());
  }
  
  public boolean hasMistake() {
    return this.mistake != null;
  }
  
  public boolean hasMode() {
    return this.mode != null;
  }
  
  public boolean hasPath() {
    return this.path != null;
  }
  
  public boolean hasPercent() {
    return this.percent != null;
  }
  
  public boolean hasRemoteCluster() {
    return this.remoteCluster != null;
  }
  
  public boolean hasSelector() {
    return this.selector != null;
  }
  
  public boolean hasValue() {
    return this.value != null;
  }
  
  public boolean hasVolumePath() {
    return this.volumePath != null;
  }
  
  public int hashCode() {
    return Objects.hash(action, attr, containerNames, delay, duration, errno, methods, mistake, mode, path, percent, remoteCluster, selector, value, volumePath, additionalProperties);
  }
  
  public A removeAllFromContainerNames(Collection<String> items) {
    if (this.containerNames == null) {
      return (A) this;
    }
    for (String item : items) {
      this.containerNames.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromMethods(Collection<String> items) {
    if (this.methods == null) {
      return (A) this;
    }
    for (String item : items) {
      this.methods.remove(item);
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
  
  public A removeFromContainerNames(String... items) {
    if (this.containerNames == null) {
      return (A) this;
    }
    for (String item : items) {
      this.containerNames.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromMethods(String... items) {
    if (this.methods == null) {
      return (A) this;
    }
    for (String item : items) {
      this.methods.remove(item);
    }
    return (A) this;
  }
  
  public A setToContainerNames(int index,String item) {
    if (this.containerNames == null) {
      this.containerNames = new ArrayList();
    }
    this.containerNames.set(index, item);
    return (A) this;
  }
  
  public A setToMethods(int index,String item) {
    if (this.methods == null) {
      this.methods = new ArrayList();
    }
    this.methods.set(index, item);
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
    if (!(attr == null)) {
        sb.append("attr:");
        sb.append(attr);
        sb.append(",");
    }
    if (!(containerNames == null) && !(containerNames.isEmpty())) {
        sb.append("containerNames:");
        sb.append(containerNames);
        sb.append(",");
    }
    if (!(delay == null)) {
        sb.append("delay:");
        sb.append(delay);
        sb.append(",");
    }
    if (!(duration == null)) {
        sb.append("duration:");
        sb.append(duration);
        sb.append(",");
    }
    if (!(errno == null)) {
        sb.append("errno:");
        sb.append(errno);
        sb.append(",");
    }
    if (!(methods == null) && !(methods.isEmpty())) {
        sb.append("methods:");
        sb.append(methods);
        sb.append(",");
    }
    if (!(mistake == null)) {
        sb.append("mistake:");
        sb.append(mistake);
        sb.append(",");
    }
    if (!(mode == null)) {
        sb.append("mode:");
        sb.append(mode);
        sb.append(",");
    }
    if (!(path == null)) {
        sb.append("path:");
        sb.append(path);
        sb.append(",");
    }
    if (!(percent == null)) {
        sb.append("percent:");
        sb.append(percent);
        sb.append(",");
    }
    if (!(remoteCluster == null)) {
        sb.append("remoteCluster:");
        sb.append(remoteCluster);
        sb.append(",");
    }
    if (!(selector == null)) {
        sb.append("selector:");
        sb.append(selector);
        sb.append(",");
    }
    if (!(value == null)) {
        sb.append("value:");
        sb.append(value);
        sb.append(",");
    }
    if (!(volumePath == null)) {
        sb.append("volumePath:");
        sb.append(volumePath);
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
  
  public A withAttr(AttrOverrideSpec attr) {
    this._visitables.remove("attr");
    if (attr != null) {
        this.attr = new AttrOverrideSpecBuilder(attr);
        this._visitables.get("attr").add(this.attr);
    } else {
        this.attr = null;
        this._visitables.get("attr").remove(this.attr);
    }
    return (A) this;
  }
  
  public A withContainerNames(List<String> containerNames) {
    if (containerNames != null) {
        this.containerNames = new ArrayList();
        for (String item : containerNames) {
          this.addToContainerNames(item);
        }
    } else {
      this.containerNames = null;
    }
    return (A) this;
  }
  
  public A withContainerNames(String... containerNames) {
    if (this.containerNames != null) {
        this.containerNames.clear();
        _visitables.remove("containerNames");
    }
    if (containerNames != null) {
      for (String item : containerNames) {
        this.addToContainerNames(item);
      }
    }
    return (A) this;
  }
  
  public A withDelay(String delay) {
    this.delay = delay;
    return (A) this;
  }
  
  public A withDuration(String duration) {
    this.duration = duration;
    return (A) this;
  }
  
  public A withErrno(Long errno) {
    this.errno = errno;
    return (A) this;
  }
  
  public A withMethods(List<String> methods) {
    if (methods != null) {
        this.methods = new ArrayList();
        for (String item : methods) {
          this.addToMethods(item);
        }
    } else {
      this.methods = null;
    }
    return (A) this;
  }
  
  public A withMethods(String... methods) {
    if (this.methods != null) {
        this.methods.clear();
        _visitables.remove("methods");
    }
    if (methods != null) {
      for (String item : methods) {
        this.addToMethods(item);
      }
    }
    return (A) this;
  }
  
  public A withMistake(MistakeSpec mistake) {
    this._visitables.remove("mistake");
    if (mistake != null) {
        this.mistake = new MistakeSpecBuilder(mistake);
        this._visitables.get("mistake").add(this.mistake);
    } else {
        this.mistake = null;
        this._visitables.get("mistake").remove(this.mistake);
    }
    return (A) this;
  }
  
  public A withMode(String mode) {
    this.mode = mode;
    return (A) this;
  }
  
  public AttrNested<A> withNewAttr() {
    return new AttrNested(null);
  }
  
  public AttrNested<A> withNewAttrLike(AttrOverrideSpec item) {
    return new AttrNested(item);
  }
  
  public MistakeNested<A> withNewMistake() {
    return new MistakeNested(null);
  }
  
  public A withNewMistake(String filling,Long maxLength,Long maxOccurrences) {
    return (A) this.withMistake(new MistakeSpec(filling, maxLength, maxOccurrences));
  }
  
  public MistakeNested<A> withNewMistakeLike(MistakeSpec item) {
    return new MistakeNested(item);
  }
  
  public SelectorNested<A> withNewSelector() {
    return new SelectorNested(null);
  }
  
  public SelectorNested<A> withNewSelectorLike(PodSelectorSpec item) {
    return new SelectorNested(item);
  }
  
  public A withPath(String path) {
    this.path = path;
    return (A) this;
  }
  
  public A withPercent(Integer percent) {
    this.percent = percent;
    return (A) this;
  }
  
  public A withRemoteCluster(String remoteCluster) {
    this.remoteCluster = remoteCluster;
    return (A) this;
  }
  
  public A withSelector(PodSelectorSpec selector) {
    this._visitables.remove("selector");
    if (selector != null) {
        this.selector = new PodSelectorSpecBuilder(selector);
        this._visitables.get("selector").add(this.selector);
    } else {
        this.selector = null;
        this._visitables.get("selector").remove(this.selector);
    }
    return (A) this;
  }
  
  public A withValue(String value) {
    this.value = value;
    return (A) this;
  }
  
  public A withVolumePath(String volumePath) {
    this.volumePath = volumePath;
    return (A) this;
  }
  public class AttrNested<N> extends AttrOverrideSpecFluent<AttrNested<N>> implements Nested<N>{
  
    AttrOverrideSpecBuilder builder;
  
    AttrNested(AttrOverrideSpec item) {
      this.builder = new AttrOverrideSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) IOChaosSpecFluent.this.withAttr(builder.build());
    }
    
    public N endAttr() {
      return and();
    }
    
  }
  public class MistakeNested<N> extends MistakeSpecFluent<MistakeNested<N>> implements Nested<N>{
  
    MistakeSpecBuilder builder;
  
    MistakeNested(MistakeSpec item) {
      this.builder = new MistakeSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) IOChaosSpecFluent.this.withMistake(builder.build());
    }
    
    public N endMistake() {
      return and();
    }
    
  }
  public class SelectorNested<N> extends PodSelectorSpecFluent<SelectorNested<N>> implements Nested<N>{
  
    PodSelectorSpecBuilder builder;
  
    SelectorNested(PodSelectorSpec item) {
      this.builder = new PodSelectorSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) IOChaosSpecFluent.this.withSelector(builder.build());
    }
    
    public N endSelector() {
      return and();
    }
    
  }
}