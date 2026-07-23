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
public class NodeDisruptionPolicyClusterStatusFluent<A extends io.fabric8.openshift.api.model.operator.v1.NodeDisruptionPolicyClusterStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<NodeDisruptionPolicyStatusFileBuilder> files = new ArrayList<NodeDisruptionPolicyStatusFileBuilder>();
  private NodeDisruptionPolicyStatusSSHKeyBuilder sshkey;
  private ArrayList<NodeDisruptionPolicyStatusUnitBuilder> units = new ArrayList<NodeDisruptionPolicyStatusUnitBuilder>();

  public NodeDisruptionPolicyClusterStatusFluent() {
  }
  
  public NodeDisruptionPolicyClusterStatusFluent(NodeDisruptionPolicyClusterStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToFiles(Collection<NodeDisruptionPolicyStatusFile> items) {
    if (this.files == null) {
      this.files = new ArrayList();
    }
    for (NodeDisruptionPolicyStatusFile item : items) {
        NodeDisruptionPolicyStatusFileBuilder builder = new NodeDisruptionPolicyStatusFileBuilder(item);
        _visitables.get("files").add(builder);
        this.files.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToUnits(Collection<NodeDisruptionPolicyStatusUnit> items) {
    if (this.units == null) {
      this.units = new ArrayList();
    }
    for (NodeDisruptionPolicyStatusUnit item : items) {
        NodeDisruptionPolicyStatusUnitBuilder builder = new NodeDisruptionPolicyStatusUnitBuilder(item);
        _visitables.get("units").add(builder);
        this.units.add(builder);
    }
    return (A) this;
  }
  
  public FilesNested<A> addNewFile() {
    return new FilesNested(-1, null);
  }
  
  public FilesNested<A> addNewFileLike(NodeDisruptionPolicyStatusFile item) {
    return new FilesNested(-1, item);
  }
  
  public UnitsNested<A> addNewUnit() {
    return new UnitsNested(-1, null);
  }
  
  public UnitsNested<A> addNewUnitLike(NodeDisruptionPolicyStatusUnit item) {
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
  
  public A addToFiles(NodeDisruptionPolicyStatusFile... items) {
    if (this.files == null) {
      this.files = new ArrayList();
    }
    for (NodeDisruptionPolicyStatusFile item : items) {
        NodeDisruptionPolicyStatusFileBuilder builder = new NodeDisruptionPolicyStatusFileBuilder(item);
        _visitables.get("files").add(builder);
        this.files.add(builder);
    }
    return (A) this;
  }
  
  public A addToFiles(int index,NodeDisruptionPolicyStatusFile item) {
    if (this.files == null) {
      this.files = new ArrayList();
    }
    NodeDisruptionPolicyStatusFileBuilder builder = new NodeDisruptionPolicyStatusFileBuilder(item);
    if (index < 0 || index >= files.size()) {
        _visitables.get("files").add(builder);
        files.add(builder);
    } else {
        _visitables.get("files").add(builder);
        files.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToUnits(NodeDisruptionPolicyStatusUnit... items) {
    if (this.units == null) {
      this.units = new ArrayList();
    }
    for (NodeDisruptionPolicyStatusUnit item : items) {
        NodeDisruptionPolicyStatusUnitBuilder builder = new NodeDisruptionPolicyStatusUnitBuilder(item);
        _visitables.get("units").add(builder);
        this.units.add(builder);
    }
    return (A) this;
  }
  
  public A addToUnits(int index,NodeDisruptionPolicyStatusUnit item) {
    if (this.units == null) {
      this.units = new ArrayList();
    }
    NodeDisruptionPolicyStatusUnitBuilder builder = new NodeDisruptionPolicyStatusUnitBuilder(item);
    if (index < 0 || index >= units.size()) {
        _visitables.get("units").add(builder);
        units.add(builder);
    } else {
        _visitables.get("units").add(builder);
        units.add(index, builder);
    }
    return (A) this;
  }
  
  public NodeDisruptionPolicyStatusFile buildFile(int index) {
    return this.files.get(index).build();
  }
  
  public List<NodeDisruptionPolicyStatusFile> buildFiles() {
    return this.files != null ? build(files) : null;
  }
  
  public NodeDisruptionPolicyStatusFile buildFirstFile() {
    return this.files.get(0).build();
  }
  
  public NodeDisruptionPolicyStatusUnit buildFirstUnit() {
    return this.units.get(0).build();
  }
  
  public NodeDisruptionPolicyStatusFile buildLastFile() {
    return this.files.get(files.size() - 1).build();
  }
  
  public NodeDisruptionPolicyStatusUnit buildLastUnit() {
    return this.units.get(units.size() - 1).build();
  }
  
  public NodeDisruptionPolicyStatusFile buildMatchingFile(Predicate<NodeDisruptionPolicyStatusFileBuilder> predicate) {
      for (NodeDisruptionPolicyStatusFileBuilder item : files) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public NodeDisruptionPolicyStatusUnit buildMatchingUnit(Predicate<NodeDisruptionPolicyStatusUnitBuilder> predicate) {
      for (NodeDisruptionPolicyStatusUnitBuilder item : units) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public NodeDisruptionPolicyStatusSSHKey buildSshkey() {
    return this.sshkey != null ? this.sshkey.build() : null;
  }
  
  public NodeDisruptionPolicyStatusUnit buildUnit(int index) {
    return this.units.get(index).build();
  }
  
  public List<NodeDisruptionPolicyStatusUnit> buildUnits() {
    return this.units != null ? build(units) : null;
  }
  
  protected void copyInstance(NodeDisruptionPolicyClusterStatus instance) {
    instance = instance != null ? instance : new NodeDisruptionPolicyClusterStatus();
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
  
  public FilesNested<A> editMatchingFile(Predicate<NodeDisruptionPolicyStatusFileBuilder> predicate) {
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
  
  public UnitsNested<A> editMatchingUnit(Predicate<NodeDisruptionPolicyStatusUnitBuilder> predicate) {
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
    return this.withNewSshkeyLike(Optional.ofNullable(this.buildSshkey()).orElse(new NodeDisruptionPolicyStatusSSHKeyBuilder().build()));
  }
  
  public SshkeyNested<A> editOrNewSshkeyLike(NodeDisruptionPolicyStatusSSHKey item) {
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
    NodeDisruptionPolicyClusterStatusFluent that = (NodeDisruptionPolicyClusterStatusFluent) o;
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
  
  public boolean hasMatchingFile(Predicate<NodeDisruptionPolicyStatusFileBuilder> predicate) {
      for (NodeDisruptionPolicyStatusFileBuilder item : files) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingUnit(Predicate<NodeDisruptionPolicyStatusUnitBuilder> predicate) {
      for (NodeDisruptionPolicyStatusUnitBuilder item : units) {
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
  
  public A removeAllFromFiles(Collection<NodeDisruptionPolicyStatusFile> items) {
    if (this.files == null) {
      return (A) this;
    }
    for (NodeDisruptionPolicyStatusFile item : items) {
        NodeDisruptionPolicyStatusFileBuilder builder = new NodeDisruptionPolicyStatusFileBuilder(item);
        _visitables.get("files").remove(builder);
        this.files.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromUnits(Collection<NodeDisruptionPolicyStatusUnit> items) {
    if (this.units == null) {
      return (A) this;
    }
    for (NodeDisruptionPolicyStatusUnit item : items) {
        NodeDisruptionPolicyStatusUnitBuilder builder = new NodeDisruptionPolicyStatusUnitBuilder(item);
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
  
  public A removeFromFiles(NodeDisruptionPolicyStatusFile... items) {
    if (this.files == null) {
      return (A) this;
    }
    for (NodeDisruptionPolicyStatusFile item : items) {
        NodeDisruptionPolicyStatusFileBuilder builder = new NodeDisruptionPolicyStatusFileBuilder(item);
        _visitables.get("files").remove(builder);
        this.files.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromUnits(NodeDisruptionPolicyStatusUnit... items) {
    if (this.units == null) {
      return (A) this;
    }
    for (NodeDisruptionPolicyStatusUnit item : items) {
        NodeDisruptionPolicyStatusUnitBuilder builder = new NodeDisruptionPolicyStatusUnitBuilder(item);
        _visitables.get("units").remove(builder);
        this.units.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromFiles(Predicate<NodeDisruptionPolicyStatusFileBuilder> predicate) {
    if (files == null) {
      return (A) this;
    }
    Iterator<NodeDisruptionPolicyStatusFileBuilder> each = files.iterator();
    List visitables = _visitables.get("files");
    while (each.hasNext()) {
        NodeDisruptionPolicyStatusFileBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromUnits(Predicate<NodeDisruptionPolicyStatusUnitBuilder> predicate) {
    if (units == null) {
      return (A) this;
    }
    Iterator<NodeDisruptionPolicyStatusUnitBuilder> each = units.iterator();
    List visitables = _visitables.get("units");
    while (each.hasNext()) {
        NodeDisruptionPolicyStatusUnitBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public FilesNested<A> setNewFileLike(int index,NodeDisruptionPolicyStatusFile item) {
    return new FilesNested(index, item);
  }
  
  public UnitsNested<A> setNewUnitLike(int index,NodeDisruptionPolicyStatusUnit item) {
    return new UnitsNested(index, item);
  }
  
  public A setToFiles(int index,NodeDisruptionPolicyStatusFile item) {
    if (this.files == null) {
      this.files = new ArrayList();
    }
    NodeDisruptionPolicyStatusFileBuilder builder = new NodeDisruptionPolicyStatusFileBuilder(item);
    if (index < 0 || index >= files.size()) {
        _visitables.get("files").add(builder);
        files.add(builder);
    } else {
        _visitables.get("files").add(builder);
        files.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToUnits(int index,NodeDisruptionPolicyStatusUnit item) {
    if (this.units == null) {
      this.units = new ArrayList();
    }
    NodeDisruptionPolicyStatusUnitBuilder builder = new NodeDisruptionPolicyStatusUnitBuilder(item);
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
  
  public A withFiles(List<NodeDisruptionPolicyStatusFile> files) {
    if (this.files != null) {
      this._visitables.get("files").clear();
    }
    if (files != null) {
        this.files = new ArrayList();
        for (NodeDisruptionPolicyStatusFile item : files) {
          this.addToFiles(item);
        }
    } else {
      this.files = null;
    }
    return (A) this;
  }
  
  public A withFiles(NodeDisruptionPolicyStatusFile... files) {
    if (this.files != null) {
        this.files.clear();
        _visitables.remove("files");
    }
    if (files != null) {
      for (NodeDisruptionPolicyStatusFile item : files) {
        this.addToFiles(item);
      }
    }
    return (A) this;
  }
  
  public SshkeyNested<A> withNewSshkey() {
    return new SshkeyNested(null);
  }
  
  public SshkeyNested<A> withNewSshkeyLike(NodeDisruptionPolicyStatusSSHKey item) {
    return new SshkeyNested(item);
  }
  
  public A withSshkey(NodeDisruptionPolicyStatusSSHKey sshkey) {
    this._visitables.remove("sshkey");
    if (sshkey != null) {
        this.sshkey = new NodeDisruptionPolicyStatusSSHKeyBuilder(sshkey);
        this._visitables.get("sshkey").add(this.sshkey);
    } else {
        this.sshkey = null;
        this._visitables.get("sshkey").remove(this.sshkey);
    }
    return (A) this;
  }
  
  public A withUnits(List<NodeDisruptionPolicyStatusUnit> units) {
    if (this.units != null) {
      this._visitables.get("units").clear();
    }
    if (units != null) {
        this.units = new ArrayList();
        for (NodeDisruptionPolicyStatusUnit item : units) {
          this.addToUnits(item);
        }
    } else {
      this.units = null;
    }
    return (A) this;
  }
  
  public A withUnits(NodeDisruptionPolicyStatusUnit... units) {
    if (this.units != null) {
        this.units.clear();
        _visitables.remove("units");
    }
    if (units != null) {
      for (NodeDisruptionPolicyStatusUnit item : units) {
        this.addToUnits(item);
      }
    }
    return (A) this;
  }
  public class FilesNested<N> extends NodeDisruptionPolicyStatusFileFluent<FilesNested<N>> implements Nested<N>{
  
    NodeDisruptionPolicyStatusFileBuilder builder;
    int index;
  
    FilesNested(int index,NodeDisruptionPolicyStatusFile item) {
      this.index = index;
      this.builder = new NodeDisruptionPolicyStatusFileBuilder(this, item);
    }
  
    public N and() {
      return (N) NodeDisruptionPolicyClusterStatusFluent.this.setToFiles(index, builder.build());
    }
    
    public N endFile() {
      return and();
    }
    
  }
  public class SshkeyNested<N> extends NodeDisruptionPolicyStatusSSHKeyFluent<SshkeyNested<N>> implements Nested<N>{
  
    NodeDisruptionPolicyStatusSSHKeyBuilder builder;
  
    SshkeyNested(NodeDisruptionPolicyStatusSSHKey item) {
      this.builder = new NodeDisruptionPolicyStatusSSHKeyBuilder(this, item);
    }
  
    public N and() {
      return (N) NodeDisruptionPolicyClusterStatusFluent.this.withSshkey(builder.build());
    }
    
    public N endSshkey() {
      return and();
    }
    
  }
  public class UnitsNested<N> extends NodeDisruptionPolicyStatusUnitFluent<UnitsNested<N>> implements Nested<N>{
  
    NodeDisruptionPolicyStatusUnitBuilder builder;
    int index;
  
    UnitsNested(int index,NodeDisruptionPolicyStatusUnit item) {
      this.index = index;
      this.builder = new NodeDisruptionPolicyStatusUnitBuilder(this, item);
    }
  
    public N and() {
      return (N) NodeDisruptionPolicyClusterStatusFluent.this.setToUnits(index, builder.build());
    }
    
    public N endUnit() {
      return and();
    }
    
  }
}