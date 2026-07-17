package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.LocalObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.LocalObjectReferenceFluent;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.ObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.ObjectReferenceFluent;
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
public class ImageSourceFluent<A extends io.fabric8.openshift.api.model.ImageSourceFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> as = new ArrayList<String>();
  private ObjectReferenceBuilder from;
  private ArrayList<ImageSourcePathBuilder> paths = new ArrayList<ImageSourcePathBuilder>();
  private LocalObjectReferenceBuilder pullSecret;

  public ImageSourceFluent() {
  }
  
  public ImageSourceFluent(ImageSource instance) {
    this.copyInstance(instance);
  }

  public A addAllToAs(Collection<String> items) {
    if (this.as == null) {
      this.as = new ArrayList();
    }
    for (String item : items) {
      this.as.add(item);
    }
    return (A) this;
  }
  
  public A addAllToPaths(Collection<ImageSourcePath> items) {
    if (this.paths == null) {
      this.paths = new ArrayList();
    }
    for (ImageSourcePath item : items) {
        ImageSourcePathBuilder builder = new ImageSourcePathBuilder(item);
        _visitables.get("paths").add(builder);
        this.paths.add(builder);
    }
    return (A) this;
  }
  
  public PathsNested<A> addNewPath() {
    return new PathsNested(-1, null);
  }
  
  public A addNewPath(String destinationDir,String sourcePath) {
    return (A) this.addToPaths(new ImageSourcePath(destinationDir, sourcePath));
  }
  
  public PathsNested<A> addNewPathLike(ImageSourcePath item) {
    return new PathsNested(-1, item);
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
  
  public A addToAs(String... items) {
    if (this.as == null) {
      this.as = new ArrayList();
    }
    for (String item : items) {
      this.as.add(item);
    }
    return (A) this;
  }
  
  public A addToAs(int index,String item) {
    if (this.as == null) {
      this.as = new ArrayList();
    }
    this.as.add(index, item);
    return (A) this;
  }
  
  public A addToPaths(ImageSourcePath... items) {
    if (this.paths == null) {
      this.paths = new ArrayList();
    }
    for (ImageSourcePath item : items) {
        ImageSourcePathBuilder builder = new ImageSourcePathBuilder(item);
        _visitables.get("paths").add(builder);
        this.paths.add(builder);
    }
    return (A) this;
  }
  
  public A addToPaths(int index,ImageSourcePath item) {
    if (this.paths == null) {
      this.paths = new ArrayList();
    }
    ImageSourcePathBuilder builder = new ImageSourcePathBuilder(item);
    if (index < 0 || index >= paths.size()) {
        _visitables.get("paths").add(builder);
        paths.add(builder);
    } else {
        _visitables.get("paths").add(builder);
        paths.add(index, builder);
    }
    return (A) this;
  }
  
  public ImageSourcePath buildFirstPath() {
    return this.paths.get(0).build();
  }
  
  public ObjectReference buildFrom() {
    return this.from != null ? this.from.build() : null;
  }
  
  public ImageSourcePath buildLastPath() {
    return this.paths.get(paths.size() - 1).build();
  }
  
  public ImageSourcePath buildMatchingPath(Predicate<ImageSourcePathBuilder> predicate) {
      for (ImageSourcePathBuilder item : paths) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ImageSourcePath buildPath(int index) {
    return this.paths.get(index).build();
  }
  
  public List<ImageSourcePath> buildPaths() {
    return this.paths != null ? build(paths) : null;
  }
  
  public LocalObjectReference buildPullSecret() {
    return this.pullSecret != null ? this.pullSecret.build() : null;
  }
  
  protected void copyInstance(ImageSource instance) {
    instance = instance != null ? instance : new ImageSource();
    if (instance != null) {
        this.withAs(instance.getAs());
        this.withFrom(instance.getFrom());
        this.withPaths(instance.getPaths());
        this.withPullSecret(instance.getPullSecret());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public PathsNested<A> editFirstPath() {
    if (paths.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "paths"));
    }
    return this.setNewPathLike(0, this.buildPath(0));
  }
  
  public FromNested<A> editFrom() {
    return this.withNewFromLike(Optional.ofNullable(this.buildFrom()).orElse(null));
  }
  
  public PathsNested<A> editLastPath() {
    int index = paths.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "paths"));
    }
    return this.setNewPathLike(index, this.buildPath(index));
  }
  
  public PathsNested<A> editMatchingPath(Predicate<ImageSourcePathBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < paths.size();i++) {
      if (predicate.test(paths.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "paths"));
    }
    return this.setNewPathLike(index, this.buildPath(index));
  }
  
  public FromNested<A> editOrNewFrom() {
    return this.withNewFromLike(Optional.ofNullable(this.buildFrom()).orElse(new ObjectReferenceBuilder().build()));
  }
  
  public FromNested<A> editOrNewFromLike(ObjectReference item) {
    return this.withNewFromLike(Optional.ofNullable(this.buildFrom()).orElse(item));
  }
  
  public PullSecretNested<A> editOrNewPullSecret() {
    return this.withNewPullSecretLike(Optional.ofNullable(this.buildPullSecret()).orElse(new LocalObjectReferenceBuilder().build()));
  }
  
  public PullSecretNested<A> editOrNewPullSecretLike(LocalObjectReference item) {
    return this.withNewPullSecretLike(Optional.ofNullable(this.buildPullSecret()).orElse(item));
  }
  
  public PathsNested<A> editPath(int index) {
    if (paths.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "paths"));
    }
    return this.setNewPathLike(index, this.buildPath(index));
  }
  
  public PullSecretNested<A> editPullSecret() {
    return this.withNewPullSecretLike(Optional.ofNullable(this.buildPullSecret()).orElse(null));
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
    ImageSourceFluent that = (ImageSourceFluent) o;
    if (!(Objects.equals(as, that.as))) {
      return false;
    }
    if (!(Objects.equals(from, that.from))) {
      return false;
    }
    if (!(Objects.equals(paths, that.paths))) {
      return false;
    }
    if (!(Objects.equals(pullSecret, that.pullSecret))) {
      return false;
    }
    if (!(Objects.equals(additionalProperties, that.additionalProperties))) {
      return false;
    }
    return true;
  }
  
  public String getA(int index) {
    return this.as.get(index);
  }
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public List<String> getAs() {
    return this.as;
  }
  
  public String getFirstA() {
    return this.as.get(0);
  }
  
  public String getLastA() {
    return this.as.get(as.size() - 1);
  }
  
  public String getMatchingA(Predicate<String> predicate) {
      for (String item : as) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAs() {
    return this.as != null && !(this.as.isEmpty());
  }
  
  public boolean hasFrom() {
    return this.from != null;
  }
  
  public boolean hasMatchingA(Predicate<String> predicate) {
      for (String item : as) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingPath(Predicate<ImageSourcePathBuilder> predicate) {
      for (ImageSourcePathBuilder item : paths) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPaths() {
    return this.paths != null && !(this.paths.isEmpty());
  }
  
  public boolean hasPullSecret() {
    return this.pullSecret != null;
  }
  
  public int hashCode() {
    return Objects.hash(as, from, paths, pullSecret, additionalProperties);
  }
  
  public A removeAllFromAs(Collection<String> items) {
    if (this.as == null) {
      return (A) this;
    }
    for (String item : items) {
      this.as.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromPaths(Collection<ImageSourcePath> items) {
    if (this.paths == null) {
      return (A) this;
    }
    for (ImageSourcePath item : items) {
        ImageSourcePathBuilder builder = new ImageSourcePathBuilder(item);
        _visitables.get("paths").remove(builder);
        this.paths.remove(builder);
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
  
  public A removeFromAs(String... items) {
    if (this.as == null) {
      return (A) this;
    }
    for (String item : items) {
      this.as.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromPaths(ImageSourcePath... items) {
    if (this.paths == null) {
      return (A) this;
    }
    for (ImageSourcePath item : items) {
        ImageSourcePathBuilder builder = new ImageSourcePathBuilder(item);
        _visitables.get("paths").remove(builder);
        this.paths.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromPaths(Predicate<ImageSourcePathBuilder> predicate) {
    if (paths == null) {
      return (A) this;
    }
    Iterator<ImageSourcePathBuilder> each = paths.iterator();
    List visitables = _visitables.get("paths");
    while (each.hasNext()) {
        ImageSourcePathBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public PathsNested<A> setNewPathLike(int index,ImageSourcePath item) {
    return new PathsNested(index, item);
  }
  
  public A setToAs(int index,String item) {
    if (this.as == null) {
      this.as = new ArrayList();
    }
    this.as.set(index, item);
    return (A) this;
  }
  
  public A setToPaths(int index,ImageSourcePath item) {
    if (this.paths == null) {
      this.paths = new ArrayList();
    }
    ImageSourcePathBuilder builder = new ImageSourcePathBuilder(item);
    if (index < 0 || index >= paths.size()) {
        _visitables.get("paths").add(builder);
        paths.add(builder);
    } else {
        _visitables.get("paths").add(builder);
        paths.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(as == null) && !(as.isEmpty())) {
        sb.append("as:");
        sb.append(as);
        sb.append(",");
    }
    if (!(from == null)) {
        sb.append("from:");
        sb.append(from);
        sb.append(",");
    }
    if (!(paths == null) && !(paths.isEmpty())) {
        sb.append("paths:");
        sb.append(paths);
        sb.append(",");
    }
    if (!(pullSecret == null)) {
        sb.append("pullSecret:");
        sb.append(pullSecret);
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
  
  public A withAs(List<String> as) {
    if (as != null) {
        this.as = new ArrayList();
        for (String item : as) {
          this.addToAs(item);
        }
    } else {
      this.as = null;
    }
    return (A) this;
  }
  
  public A withAs(String... as) {
    if (this.as != null) {
        this.as.clear();
        _visitables.remove("as");
    }
    if (as != null) {
      for (String item : as) {
        this.addToAs(item);
      }
    }
    return (A) this;
  }
  
  public A withFrom(ObjectReference from) {
    this._visitables.remove("from");
    if (from != null) {
        this.from = new ObjectReferenceBuilder(from);
        this._visitables.get("from").add(this.from);
    } else {
        this.from = null;
        this._visitables.get("from").remove(this.from);
    }
    return (A) this;
  }
  
  public FromNested<A> withNewFrom() {
    return new FromNested(null);
  }
  
  public FromNested<A> withNewFromLike(ObjectReference item) {
    return new FromNested(item);
  }
  
  public PullSecretNested<A> withNewPullSecret() {
    return new PullSecretNested(null);
  }
  
  public A withNewPullSecret(String name) {
    return (A) this.withPullSecret(new LocalObjectReference(name));
  }
  
  public PullSecretNested<A> withNewPullSecretLike(LocalObjectReference item) {
    return new PullSecretNested(item);
  }
  
  public A withPaths(List<ImageSourcePath> paths) {
    if (this.paths != null) {
      this._visitables.get("paths").clear();
    }
    if (paths != null) {
        this.paths = new ArrayList();
        for (ImageSourcePath item : paths) {
          this.addToPaths(item);
        }
    } else {
      this.paths = null;
    }
    return (A) this;
  }
  
  public A withPaths(ImageSourcePath... paths) {
    if (this.paths != null) {
        this.paths.clear();
        _visitables.remove("paths");
    }
    if (paths != null) {
      for (ImageSourcePath item : paths) {
        this.addToPaths(item);
      }
    }
    return (A) this;
  }
  
  public A withPullSecret(LocalObjectReference pullSecret) {
    this._visitables.remove("pullSecret");
    if (pullSecret != null) {
        this.pullSecret = new LocalObjectReferenceBuilder(pullSecret);
        this._visitables.get("pullSecret").add(this.pullSecret);
    } else {
        this.pullSecret = null;
        this._visitables.get("pullSecret").remove(this.pullSecret);
    }
    return (A) this;
  }
  public class FromNested<N> extends ObjectReferenceFluent<FromNested<N>> implements Nested<N>{
  
    ObjectReferenceBuilder builder;
  
    FromNested(ObjectReference item) {
      this.builder = new ObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) ImageSourceFluent.this.withFrom(builder.build());
    }
    
    public N endFrom() {
      return and();
    }
    
  }
  public class PathsNested<N> extends ImageSourcePathFluent<PathsNested<N>> implements Nested<N>{
  
    ImageSourcePathBuilder builder;
    int index;
  
    PathsNested(int index,ImageSourcePath item) {
      this.index = index;
      this.builder = new ImageSourcePathBuilder(this, item);
    }
  
    public N and() {
      return (N) ImageSourceFluent.this.setToPaths(index, builder.build());
    }
    
    public N endPath() {
      return and();
    }
    
  }
  public class PullSecretNested<N> extends LocalObjectReferenceFluent<PullSecretNested<N>> implements Nested<N>{
  
    LocalObjectReferenceBuilder builder;
  
    PullSecretNested(LocalObjectReference item) {
      this.builder = new LocalObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) ImageSourceFluent.this.withPullSecret(builder.build());
    }
    
    public N endPullSecret() {
      return and();
    }
    
  }
}