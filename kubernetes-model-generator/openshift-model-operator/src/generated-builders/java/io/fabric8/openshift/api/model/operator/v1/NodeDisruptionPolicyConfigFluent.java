package io.fabric8.openshift.api.model.operator.v1;

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
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class NodeDisruptionPolicyConfigFluent<A extends io.fabric8.openshift.api.model.operator.v1.NodeDisruptionPolicyConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<NodeDisruptionPolicySpecFileBuilder> files = new ArrayList<NodeDisruptionPolicySpecFileBuilder>();
  private NodeDisruptionPolicySpecSSHKeyBuilder sshkey;
  private ArrayList<NodeDisruptionPolicySpecUnitBuilder> units = new ArrayList<NodeDisruptionPolicySpecUnitBuilder>();

  public NodeDisruptionPolicyConfigFluent() {
  }
  
  public NodeDisruptionPolicyConfigFluent(NodeDisruptionPolicyConfig instance) {
    this.copyInstance(instance);
  }

  public A addAllToFiles(Collection<NodeDisruptionPolicySpecFile> items) {
    if (this.files == null) {
      this.files = new ArrayList();
    }
    for (NodeDisruptionPolicySpecFile item : items) {
        NodeDisruptionPolicySpecFileBuilder builder = new NodeDisruptionPolicySpecFileBuilder(item);
        _visitables.get("files").add(builder);
        this.files.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToUnits(Collection<NodeDisruptionPolicySpecUnit> items) {
    if (this.units == null) {
      this.units = new ArrayList();
    }
    for (NodeDisruptionPolicySpecUnit item : items) {
        NodeDisruptionPolicySpecUnitBuilder builder = new NodeDisruptionPolicySpecUnitBuilder(item);
        _visitables.get("units").add(builder);
        this.units.add(builder);
    }
    return (A) this;
  }
  
  public FilesNested<A> addNewFile() {
    return new FilesNested(-1, null);
  }
  
  public FilesNested<A> addNewFileLike(NodeDisruptionPolicySpecFile item) {
    return new FilesNested(-1, item);
  }
  
  public UnitsNested<A> addNewUnit() {
    return new UnitsNested(-1, null);
  }
  
  public UnitsNested<A> addNewUnitLike(NodeDisruptionPolicySpecUnit item) {
    return new UnitsNested(-1, item);
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
  
  public A addToFiles(NodeDisruptionPolicySpecFile... items) {
    if (this.files == null) {
      this.files = new ArrayList();
    }
    for (NodeDisruptionPolicySpecFile item : items) {
        NodeDisruptionPolicySpecFileBuilder builder = new NodeDisruptionPolicySpecFileBuilder(item);
        _visitables.get("files").add(builder);
        this.files.add(builder);
    }
    return (A) this;
  }
  
  public A addToFiles(int index,NodeDisruptionPolicySpecFile item) {
    if (this.files == null) {
      this.files = new ArrayList();
    }
    NodeDisruptionPolicySpecFileBuilder builder = new NodeDisruptionPolicySpecFileBuilder(item);
    if (index < 0 || index >= files.size()) {
        _visitables.get("files").add(builder);
        files.add(builder);
    } else {
        _visitables.get("files").add(builder);
        files.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToUnits(NodeDisruptionPolicySpecUnit... items) {
    if (this.units == null) {
      this.units = new ArrayList();
    }
    for (NodeDisruptionPolicySpecUnit item : items) {
        NodeDisruptionPolicySpecUnitBuilder builder = new NodeDisruptionPolicySpecUnitBuilder(item);
        _visitables.get("units").add(builder);
        this.units.add(builder);
    }
    return (A) this;
  }
  
  public A addToUnits(int index,NodeDisruptionPolicySpecUnit item) {
    if (this.units == null) {
      this.units = new ArrayList();
    }
    NodeDisruptionPolicySpecUnitBuilder builder = new NodeDisruptionPolicySpecUnitBuilder(item);
    if (index < 0 || index >= units.size()) {
        _visitables.get("units").add(builder);
        units.add(builder);
    } else {
        _visitables.get("units").add(builder);
        units.add(index, builder);
    }
    return (A) this;
  }
  
  public NodeDisruptionPolicySpecFile buildFile(int index) {
    return this.files.get(index).build();
  }
  
  public List<NodeDisruptionPolicySpecFile> buildFiles() {
    return this.files != null ? build(files) : null;
  }
  
  public NodeDisruptionPolicySpecFile buildFirstFile() {
    return this.files.get(0).build();
  }
  
  public NodeDisruptionPolicySpecUnit buildFirstUnit() {
    return this.units.get(0).build();
  }
  
  public NodeDisruptionPolicySpecFile buildLastFile() {
    return this.files.get(files.size() - 1).build();
  }
  
  public NodeDisruptionPolicySpecUnit buildLastUnit() {
    return this.units.get(units.size() - 1).build();
  }
  
  public NodeDisruptionPolicySpecFile buildMatchingFile(Predicate<NodeDisruptionPolicySpecFileBuilder> predicate) {
      for (NodeDisruptionPolicySpecFileBuilder item : files) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public NodeDisruptionPolicySpecUnit buildMatchingUnit(Predicate<NodeDisruptionPolicySpecUnitBuilder> predicate) {
      for (NodeDisruptionPolicySpecUnitBuilder item : units) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public NodeDisruptionPolicySpecSSHKey buildSshkey() {
    return this.sshkey != null ? this.sshkey.build() : null;
  }
  
  public NodeDisruptionPolicySpecUnit buildUnit(int index) {
    return this.units.get(index).build();
  }
  
  public List<NodeDisruptionPolicySpecUnit> buildUnits() {
    return this.units != null ? build(units) : null;
  }
  
  protected void copyInstance(NodeDisruptionPolicyConfig instance) {
    instance = instance != null ? instance : new NodeDisruptionPolicyConfig();
    if (instance != null) {
        this.withFiles(instance.getFiles());
        this.withSshkey(instance.getSshkey());
        this.withUnits(instance.getUnits());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public FilesNested<A> editFile(int index) {
    if (files.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "files"));
    }
    return this.setNewFileLike(index, this.buildFile(index));
  }
  
  public FilesNested<A> editFirstFile() {
    if (files.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "files"));
    }
    return this.setNewFileLike(0, this.buildFile(0));
  }
  
  public UnitsNested<A> editFirstUnit() {
    if (units.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "units"));
    }
    return this.setNewUnitLike(0, this.buildUnit(0));
  }
  
  public FilesNested<A> editLastFile() {
    int index = files.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "files"));
    }
    return this.setNewFileLike(index, this.buildFile(index));
  }
  
  public UnitsNested<A> editLastUnit() {
    int index = units.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "units"));
    }
    return this.setNewUnitLike(index, this.buildUnit(index));
  }
  
  public FilesNested<A> editMatchingFile(Predicate<NodeDisruptionPolicySpecFileBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < files.size();i++) {
      if (predicate.test(files.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "files"));
    }
    return this.setNewFileLike(index, this.buildFile(index));
  }
  
  public UnitsNested<A> editMatchingUnit(Predicate<NodeDisruptionPolicySpecUnitBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < units.size();i++) {
      if (predicate.test(units.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "units"));
    }
    return this.setNewUnitLike(index, this.buildUnit(index));
  }
  
  public SshkeyNested<A> editOrNewSshkey() {
    return this.withNewSshkeyLike(Optional.ofNullable(this.buildSshkey()).orElse(new NodeDisruptionPolicySpecSSHKeyBuilder().build()));
  }
  
  public SshkeyNested<A> editOrNewSshkeyLike(NodeDisruptionPolicySpecSSHKey item) {
    return this.withNewSshkeyLike(Optional.ofNullable(this.buildSshkey()).orElse(item));
  }
  
  public SshkeyNested<A> editSshkey() {
    return this.withNewSshkeyLike(Optional.ofNullable(this.buildSshkey()).orElse(null));
  }
  
  public UnitsNested<A> editUnit(int index) {
    if (units.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "units"));
    }
    return this.setNewUnitLike(index, this.buildUnit(index));
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
    NodeDisruptionPolicyConfigFluent that = (NodeDisruptionPolicyConfigFluent) o;
    if (!(Objects.equals(files, that.files))) {
      return false;
    }
    if (!(Objects.equals(sshkey, that.sshkey))) {
      return false;
    }
    if (!(Objects.equals(units, that.units))) {
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
  
  public boolean hasFiles() {
    return this.files != null && !(this.files.isEmpty());
  }
  
  public boolean hasMatchingFile(Predicate<NodeDisruptionPolicySpecFileBuilder> predicate) {
      for (NodeDisruptionPolicySpecFileBuilder item : files) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingUnit(Predicate<NodeDisruptionPolicySpecUnitBuilder> predicate) {
      for (NodeDisruptionPolicySpecUnitBuilder item : units) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasSshkey() {
    return this.sshkey != null;
  }
  
  public boolean hasUnits() {
    return this.units != null && !(this.units.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(files, sshkey, units, additionalProperties);
  }
  
  public A removeAllFromFiles(Collection<NodeDisruptionPolicySpecFile> items) {
    if (this.files == null) {
      return (A) this;
    }
    for (NodeDisruptionPolicySpecFile item : items) {
        NodeDisruptionPolicySpecFileBuilder builder = new NodeDisruptionPolicySpecFileBuilder(item);
        _visitables.get("files").remove(builder);
        this.files.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromUnits(Collection<NodeDisruptionPolicySpecUnit> items) {
    if (this.units == null) {
      return (A) this;
    }
    for (NodeDisruptionPolicySpecUnit item : items) {
        NodeDisruptionPolicySpecUnitBuilder builder = new NodeDisruptionPolicySpecUnitBuilder(item);
        _visitables.get("units").remove(builder);
        this.units.remove(builder);
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
  
  public A removeFromFiles(NodeDisruptionPolicySpecFile... items) {
    if (this.files == null) {
      return (A) this;
    }
    for (NodeDisruptionPolicySpecFile item : items) {
        NodeDisruptionPolicySpecFileBuilder builder = new NodeDisruptionPolicySpecFileBuilder(item);
        _visitables.get("files").remove(builder);
        this.files.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromUnits(NodeDisruptionPolicySpecUnit... items) {
    if (this.units == null) {
      return (A) this;
    }
    for (NodeDisruptionPolicySpecUnit item : items) {
        NodeDisruptionPolicySpecUnitBuilder builder = new NodeDisruptionPolicySpecUnitBuilder(item);
        _visitables.get("units").remove(builder);
        this.units.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromFiles(Predicate<NodeDisruptionPolicySpecFileBuilder> predicate) {
    if (files == null) {
      return (A) this;
    }
    Iterator<NodeDisruptionPolicySpecFileBuilder> each = files.iterator();
    List visitables = _visitables.get("files");
    while (each.hasNext()) {
        NodeDisruptionPolicySpecFileBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromUnits(Predicate<NodeDisruptionPolicySpecUnitBuilder> predicate) {
    if (units == null) {
      return (A) this;
    }
    Iterator<NodeDisruptionPolicySpecUnitBuilder> each = units.iterator();
    List visitables = _visitables.get("units");
    while (each.hasNext()) {
        NodeDisruptionPolicySpecUnitBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public FilesNested<A> setNewFileLike(int index,NodeDisruptionPolicySpecFile item) {
    return new FilesNested(index, item);
  }
  
  public UnitsNested<A> setNewUnitLike(int index,NodeDisruptionPolicySpecUnit item) {
    return new UnitsNested(index, item);
  }
  
  public A setToFiles(int index,NodeDisruptionPolicySpecFile item) {
    if (this.files == null) {
      this.files = new ArrayList();
    }
    NodeDisruptionPolicySpecFileBuilder builder = new NodeDisruptionPolicySpecFileBuilder(item);
    if (index < 0 || index >= files.size()) {
        _visitables.get("files").add(builder);
        files.add(builder);
    } else {
        _visitables.get("files").add(builder);
        files.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToUnits(int index,NodeDisruptionPolicySpecUnit item) {
    if (this.units == null) {
      this.units = new ArrayList();
    }
    NodeDisruptionPolicySpecUnitBuilder builder = new NodeDisruptionPolicySpecUnitBuilder(item);
    if (index < 0 || index >= units.size()) {
        _visitables.get("units").add(builder);
        units.add(builder);
    } else {
        _visitables.get("units").add(builder);
        units.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(files == null) && !(files.isEmpty())) {
        sb.append("files:");
        sb.append(files);
        sb.append(",");
    }
    if (!(sshkey == null)) {
        sb.append("sshkey:");
        sb.append(sshkey);
        sb.append(",");
    }
    if (!(units == null) && !(units.isEmpty())) {
        sb.append("units:");
        sb.append(units);
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
  
  public A withFiles(List<NodeDisruptionPolicySpecFile> files) {
    if (this.files != null) {
      this._visitables.get("files").clear();
    }
    if (files != null) {
        this.files = new ArrayList();
        for (NodeDisruptionPolicySpecFile item : files) {
          this.addToFiles(item);
        }
    } else {
      this.files = null;
    }
    return (A) this;
  }
  
  public A withFiles(NodeDisruptionPolicySpecFile... files) {
    if (this.files != null) {
        this.files.clear();
        _visitables.remove("files");
    }
    if (files != null) {
      for (NodeDisruptionPolicySpecFile item : files) {
        this.addToFiles(item);
      }
    }
    return (A) this;
  }
  
  public SshkeyNested<A> withNewSshkey() {
    return new SshkeyNested(null);
  }
  
  public SshkeyNested<A> withNewSshkeyLike(NodeDisruptionPolicySpecSSHKey item) {
    return new SshkeyNested(item);
  }
  
  public A withSshkey(NodeDisruptionPolicySpecSSHKey sshkey) {
    this._visitables.remove("sshkey");
    if (sshkey != null) {
        this.sshkey = new NodeDisruptionPolicySpecSSHKeyBuilder(sshkey);
        this._visitables.get("sshkey").add(this.sshkey);
    } else {
        this.sshkey = null;
        this._visitables.get("sshkey").remove(this.sshkey);
    }
    return (A) this;
  }
  
  public A withUnits(List<NodeDisruptionPolicySpecUnit> units) {
    if (this.units != null) {
      this._visitables.get("units").clear();
    }
    if (units != null) {
        this.units = new ArrayList();
        for (NodeDisruptionPolicySpecUnit item : units) {
          this.addToUnits(item);
        }
    } else {
      this.units = null;
    }
    return (A) this;
  }
  
  public A withUnits(NodeDisruptionPolicySpecUnit... units) {
    if (this.units != null) {
        this.units.clear();
        _visitables.remove("units");
    }
    if (units != null) {
      for (NodeDisruptionPolicySpecUnit item : units) {
        this.addToUnits(item);
      }
    }
    return (A) this;
  }
  public class FilesNested<N> extends NodeDisruptionPolicySpecFileFluent<FilesNested<N>> implements Nested<N>{
  
    NodeDisruptionPolicySpecFileBuilder builder;
    int index;
  
    FilesNested(int index,NodeDisruptionPolicySpecFile item) {
      this.index = index;
      this.builder = new NodeDisruptionPolicySpecFileBuilder(this, item);
    }
  
    public N and() {
      return (N) NodeDisruptionPolicyConfigFluent.this.setToFiles(index, builder.build());
    }
    
    public N endFile() {
      return and();
    }
    
  }
  public class SshkeyNested<N> extends NodeDisruptionPolicySpecSSHKeyFluent<SshkeyNested<N>> implements Nested<N>{
  
    NodeDisruptionPolicySpecSSHKeyBuilder builder;
  
    SshkeyNested(NodeDisruptionPolicySpecSSHKey item) {
      this.builder = new NodeDisruptionPolicySpecSSHKeyBuilder(this, item);
    }
  
    public N and() {
      return (N) NodeDisruptionPolicyConfigFluent.this.withSshkey(builder.build());
    }
    
    public N endSshkey() {
      return and();
    }
    
  }
  public class UnitsNested<N> extends NodeDisruptionPolicySpecUnitFluent<UnitsNested<N>> implements Nested<N>{
  
    NodeDisruptionPolicySpecUnitBuilder builder;
    int index;
  
    UnitsNested(int index,NodeDisruptionPolicySpecUnit item) {
      this.index = index;
      this.builder = new NodeDisruptionPolicySpecUnitBuilder(this, item);
    }
  
    public N and() {
      return (N) NodeDisruptionPolicyConfigFluent.this.setToUnits(index, builder.build());
    }
    
    public N endUnit() {
      return and();
    }
    
  }
}