package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Integer;
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
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class IOChaosActionFluent<A extends io.fabric8.chaosmesh.v1alpha1.IOChaosActionFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private TimespecBuilder atime;
  private Long blocks;
  private TimespecBuilder ctime;
  private ArrayList<IoFaultBuilder> faults = new ArrayList<IoFaultBuilder>();
  private Long gid;
  private Long ino;
  private String kind;
  private String latency;
  private List<String> methods = new ArrayList<String>();
  private MistakeSpecBuilder mistake;
  private TimespecBuilder mtime;
  private Long nlink;
  private String path;
  private Integer percent;
  private Integer perm;
  private Long rdev;
  private Long size;
  private String source;
  private String type;
  private Long uid;

  public IOChaosActionFluent() {
  }
  
  public IOChaosActionFluent(IOChaosAction instance) {
    this.copyInstance(instance);
  }

  public A addAllToFaults(Collection<IoFault> items) {
    if (this.faults == null) {
      this.faults = new ArrayList();
    }
    for (IoFault item : items) {
        IoFaultBuilder builder = new IoFaultBuilder(item);
        _visitables.get("faults").add(builder);
        this.faults.add(builder);
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
  
  public FaultsNested<A> addNewFault() {
    return new FaultsNested(-1, null);
  }
  
  public A addNewFault(Long errno,Integer weight) {
    return (A) this.addToFaults(new IoFault(errno, weight));
  }
  
  public FaultsNested<A> addNewFaultLike(IoFault item) {
    return new FaultsNested(-1, item);
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
  
  public A addToFaults(IoFault... items) {
    if (this.faults == null) {
      this.faults = new ArrayList();
    }
    for (IoFault item : items) {
        IoFaultBuilder builder = new IoFaultBuilder(item);
        _visitables.get("faults").add(builder);
        this.faults.add(builder);
    }
    return (A) this;
  }
  
  public A addToFaults(int index,IoFault item) {
    if (this.faults == null) {
      this.faults = new ArrayList();
    }
    IoFaultBuilder builder = new IoFaultBuilder(item);
    if (index < 0 || index >= faults.size()) {
        _visitables.get("faults").add(builder);
        faults.add(builder);
    } else {
        _visitables.get("faults").add(builder);
        faults.add(index, builder);
    }
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
  
  public Timespec buildAtime() {
    return this.atime != null ? this.atime.build() : null;
  }
  
  public Timespec buildCtime() {
    return this.ctime != null ? this.ctime.build() : null;
  }
  
  public IoFault buildFault(int index) {
    return this.faults.get(index).build();
  }
  
  public List<IoFault> buildFaults() {
    return this.faults != null ? build(faults) : null;
  }
  
  public IoFault buildFirstFault() {
    return this.faults.get(0).build();
  }
  
  public IoFault buildLastFault() {
    return this.faults.get(faults.size() - 1).build();
  }
  
  public IoFault buildMatchingFault(Predicate<IoFaultBuilder> predicate) {
      for (IoFaultBuilder item : faults) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public MistakeSpec buildMistake() {
    return this.mistake != null ? this.mistake.build() : null;
  }
  
  public Timespec buildMtime() {
    return this.mtime != null ? this.mtime.build() : null;
  }
  
  protected void copyInstance(IOChaosAction instance) {
    instance = instance != null ? instance : new IOChaosAction();
    if (instance != null) {
        this.withAtime(instance.getAtime());
        this.withBlocks(instance.getBlocks());
        this.withCtime(instance.getCtime());
        this.withFaults(instance.getFaults());
        this.withGid(instance.getGid());
        this.withIno(instance.getIno());
        this.withKind(instance.getKind());
        this.withLatency(instance.getLatency());
        this.withMethods(instance.getMethods());
        this.withMistake(instance.getMistake());
        this.withMtime(instance.getMtime());
        this.withNlink(instance.getNlink());
        this.withPath(instance.getPath());
        this.withPercent(instance.getPercent());
        this.withPerm(instance.getPerm());
        this.withRdev(instance.getRdev());
        this.withSize(instance.getSize());
        this.withSource(instance.getSource());
        this.withType(instance.getType());
        this.withUid(instance.getUid());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AtimeNested<A> editAtime() {
    return this.withNewAtimeLike(Optional.ofNullable(this.buildAtime()).orElse(null));
  }
  
  public CtimeNested<A> editCtime() {
    return this.withNewCtimeLike(Optional.ofNullable(this.buildCtime()).orElse(null));
  }
  
  public FaultsNested<A> editFault(int index) {
    if (faults.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "faults"));
    }
    return this.setNewFaultLike(index, this.buildFault(index));
  }
  
  public FaultsNested<A> editFirstFault() {
    if (faults.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "faults"));
    }
    return this.setNewFaultLike(0, this.buildFault(0));
  }
  
  public FaultsNested<A> editLastFault() {
    int index = faults.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "faults"));
    }
    return this.setNewFaultLike(index, this.buildFault(index));
  }
  
  public FaultsNested<A> editMatchingFault(Predicate<IoFaultBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < faults.size();i++) {
      if (predicate.test(faults.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "faults"));
    }
    return this.setNewFaultLike(index, this.buildFault(index));
  }
  
  public MistakeNested<A> editMistake() {
    return this.withNewMistakeLike(Optional.ofNullable(this.buildMistake()).orElse(null));
  }
  
  public MtimeNested<A> editMtime() {
    return this.withNewMtimeLike(Optional.ofNullable(this.buildMtime()).orElse(null));
  }
  
  public AtimeNested<A> editOrNewAtime() {
    return this.withNewAtimeLike(Optional.ofNullable(this.buildAtime()).orElse(new TimespecBuilder().build()));
  }
  
  public AtimeNested<A> editOrNewAtimeLike(Timespec item) {
    return this.withNewAtimeLike(Optional.ofNullable(this.buildAtime()).orElse(item));
  }
  
  public CtimeNested<A> editOrNewCtime() {
    return this.withNewCtimeLike(Optional.ofNullable(this.buildCtime()).orElse(new TimespecBuilder().build()));
  }
  
  public CtimeNested<A> editOrNewCtimeLike(Timespec item) {
    return this.withNewCtimeLike(Optional.ofNullable(this.buildCtime()).orElse(item));
  }
  
  public MistakeNested<A> editOrNewMistake() {
    return this.withNewMistakeLike(Optional.ofNullable(this.buildMistake()).orElse(new MistakeSpecBuilder().build()));
  }
  
  public MistakeNested<A> editOrNewMistakeLike(MistakeSpec item) {
    return this.withNewMistakeLike(Optional.ofNullable(this.buildMistake()).orElse(item));
  }
  
  public MtimeNested<A> editOrNewMtime() {
    return this.withNewMtimeLike(Optional.ofNullable(this.buildMtime()).orElse(new TimespecBuilder().build()));
  }
  
  public MtimeNested<A> editOrNewMtimeLike(Timespec item) {
    return this.withNewMtimeLike(Optional.ofNullable(this.buildMtime()).orElse(item));
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
    IOChaosActionFluent that = (IOChaosActionFluent) o;
    if (!(Objects.equals(atime, that.atime))) {
      return false;
    }
    if (!(Objects.equals(blocks, that.blocks))) {
      return false;
    }
    if (!(Objects.equals(ctime, that.ctime))) {
      return false;
    }
    if (!(Objects.equals(faults, that.faults))) {
      return false;
    }
    if (!(Objects.equals(gid, that.gid))) {
      return false;
    }
    if (!(Objects.equals(ino, that.ino))) {
      return false;
    }
    if (!(Objects.equals(kind, that.kind))) {
      return false;
    }
    if (!(Objects.equals(latency, that.latency))) {
      return false;
    }
    if (!(Objects.equals(methods, that.methods))) {
      return false;
    }
    if (!(Objects.equals(mistake, that.mistake))) {
      return false;
    }
    if (!(Objects.equals(mtime, that.mtime))) {
      return false;
    }
    if (!(Objects.equals(nlink, that.nlink))) {
      return false;
    }
    if (!(Objects.equals(path, that.path))) {
      return false;
    }
    if (!(Objects.equals(percent, that.percent))) {
      return false;
    }
    if (!(Objects.equals(perm, that.perm))) {
      return false;
    }
    if (!(Objects.equals(rdev, that.rdev))) {
      return false;
    }
    if (!(Objects.equals(size, that.size))) {
      return false;
    }
    if (!(Objects.equals(source, that.source))) {
      return false;
    }
    if (!(Objects.equals(type, that.type))) {
      return false;
    }
    if (!(Objects.equals(uid, that.uid))) {
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
  
  public Long getBlocks() {
    return this.blocks;
  }
  
  public String getFirstMethod() {
    return this.methods.get(0);
  }
  
  public Long getGid() {
    return this.gid;
  }
  
  public Long getIno() {
    return this.ino;
  }
  
  public String getKind() {
    return this.kind;
  }
  
  public String getLastMethod() {
    return this.methods.get(methods.size() - 1);
  }
  
  public String getLatency() {
    return this.latency;
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
  
  public Long getNlink() {
    return this.nlink;
  }
  
  public String getPath() {
    return this.path;
  }
  
  public Integer getPercent() {
    return this.percent;
  }
  
  public Integer getPerm() {
    return this.perm;
  }
  
  public Long getRdev() {
    return this.rdev;
  }
  
  public Long getSize() {
    return this.size;
  }
  
  public String getSource() {
    return this.source;
  }
  
  public String getType() {
    return this.type;
  }
  
  public Long getUid() {
    return this.uid;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAtime() {
    return this.atime != null;
  }
  
  public boolean hasBlocks() {
    return this.blocks != null;
  }
  
  public boolean hasCtime() {
    return this.ctime != null;
  }
  
  public boolean hasFaults() {
    return this.faults != null && !(this.faults.isEmpty());
  }
  
  public boolean hasGid() {
    return this.gid != null;
  }
  
  public boolean hasIno() {
    return this.ino != null;
  }
  
  public boolean hasKind() {
    return this.kind != null;
  }
  
  public boolean hasLatency() {
    return this.latency != null;
  }
  
  public boolean hasMatchingFault(Predicate<IoFaultBuilder> predicate) {
      for (IoFaultBuilder item : faults) {
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
  
  public boolean hasMtime() {
    return this.mtime != null;
  }
  
  public boolean hasNlink() {
    return this.nlink != null;
  }
  
  public boolean hasPath() {
    return this.path != null;
  }
  
  public boolean hasPercent() {
    return this.percent != null;
  }
  
  public boolean hasPerm() {
    return this.perm != null;
  }
  
  public boolean hasRdev() {
    return this.rdev != null;
  }
  
  public boolean hasSize() {
    return this.size != null;
  }
  
  public boolean hasSource() {
    return this.source != null;
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public boolean hasUid() {
    return this.uid != null;
  }
  
  public int hashCode() {
    return Objects.hash(atime, blocks, ctime, faults, gid, ino, kind, latency, methods, mistake, mtime, nlink, path, percent, perm, rdev, size, source, type, uid, additionalProperties);
  }
  
  public A removeAllFromFaults(Collection<IoFault> items) {
    if (this.faults == null) {
      return (A) this;
    }
    for (IoFault item : items) {
        IoFaultBuilder builder = new IoFaultBuilder(item);
        _visitables.get("faults").remove(builder);
        this.faults.remove(builder);
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
  
  public A removeFromFaults(IoFault... items) {
    if (this.faults == null) {
      return (A) this;
    }
    for (IoFault item : items) {
        IoFaultBuilder builder = new IoFaultBuilder(item);
        _visitables.get("faults").remove(builder);
        this.faults.remove(builder);
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
  
  public A removeMatchingFromFaults(Predicate<IoFaultBuilder> predicate) {
    if (faults == null) {
      return (A) this;
    }
    Iterator<IoFaultBuilder> each = faults.iterator();
    List visitables = _visitables.get("faults");
    while (each.hasNext()) {
        IoFaultBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public FaultsNested<A> setNewFaultLike(int index,IoFault item) {
    return new FaultsNested(index, item);
  }
  
  public A setToFaults(int index,IoFault item) {
    if (this.faults == null) {
      this.faults = new ArrayList();
    }
    IoFaultBuilder builder = new IoFaultBuilder(item);
    if (index < 0 || index >= faults.size()) {
        _visitables.get("faults").add(builder);
        faults.add(builder);
    } else {
        _visitables.get("faults").add(builder);
        faults.set(index, builder);
    }
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
    if (!(atime == null)) {
        sb.append("atime:");
        sb.append(atime);
        sb.append(",");
    }
    if (!(blocks == null)) {
        sb.append("blocks:");
        sb.append(blocks);
        sb.append(",");
    }
    if (!(ctime == null)) {
        sb.append("ctime:");
        sb.append(ctime);
        sb.append(",");
    }
    if (!(faults == null) && !(faults.isEmpty())) {
        sb.append("faults:");
        sb.append(faults);
        sb.append(",");
    }
    if (!(gid == null)) {
        sb.append("gid:");
        sb.append(gid);
        sb.append(",");
    }
    if (!(ino == null)) {
        sb.append("ino:");
        sb.append(ino);
        sb.append(",");
    }
    if (!(kind == null)) {
        sb.append("kind:");
        sb.append(kind);
        sb.append(",");
    }
    if (!(latency == null)) {
        sb.append("latency:");
        sb.append(latency);
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
    if (!(mtime == null)) {
        sb.append("mtime:");
        sb.append(mtime);
        sb.append(",");
    }
    if (!(nlink == null)) {
        sb.append("nlink:");
        sb.append(nlink);
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
    if (!(perm == null)) {
        sb.append("perm:");
        sb.append(perm);
        sb.append(",");
    }
    if (!(rdev == null)) {
        sb.append("rdev:");
        sb.append(rdev);
        sb.append(",");
    }
    if (!(size == null)) {
        sb.append("size:");
        sb.append(size);
        sb.append(",");
    }
    if (!(source == null)) {
        sb.append("source:");
        sb.append(source);
        sb.append(",");
    }
    if (!(type == null)) {
        sb.append("type:");
        sb.append(type);
        sb.append(",");
    }
    if (!(uid == null)) {
        sb.append("uid:");
        sb.append(uid);
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
  
  public A withAtime(Timespec atime) {
    this._visitables.remove("atime");
    if (atime != null) {
        this.atime = new TimespecBuilder(atime);
        this._visitables.get("atime").add(this.atime);
    } else {
        this.atime = null;
        this._visitables.get("atime").remove(this.atime);
    }
    return (A) this;
  }
  
  public A withBlocks(Long blocks) {
    this.blocks = blocks;
    return (A) this;
  }
  
  public A withCtime(Timespec ctime) {
    this._visitables.remove("ctime");
    if (ctime != null) {
        this.ctime = new TimespecBuilder(ctime);
        this._visitables.get("ctime").add(this.ctime);
    } else {
        this.ctime = null;
        this._visitables.get("ctime").remove(this.ctime);
    }
    return (A) this;
  }
  
  public A withFaults(List<IoFault> faults) {
    if (this.faults != null) {
      this._visitables.get("faults").clear();
    }
    if (faults != null) {
        this.faults = new ArrayList();
        for (IoFault item : faults) {
          this.addToFaults(item);
        }
    } else {
      this.faults = null;
    }
    return (A) this;
  }
  
  public A withFaults(IoFault... faults) {
    if (this.faults != null) {
        this.faults.clear();
        _visitables.remove("faults");
    }
    if (faults != null) {
      for (IoFault item : faults) {
        this.addToFaults(item);
      }
    }
    return (A) this;
  }
  
  public A withGid(Long gid) {
    this.gid = gid;
    return (A) this;
  }
  
  public A withIno(Long ino) {
    this.ino = ino;
    return (A) this;
  }
  
  public A withKind(String kind) {
    this.kind = kind;
    return (A) this;
  }
  
  public A withLatency(String latency) {
    this.latency = latency;
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
  
  public A withMtime(Timespec mtime) {
    this._visitables.remove("mtime");
    if (mtime != null) {
        this.mtime = new TimespecBuilder(mtime);
        this._visitables.get("mtime").add(this.mtime);
    } else {
        this.mtime = null;
        this._visitables.get("mtime").remove(this.mtime);
    }
    return (A) this;
  }
  
  public AtimeNested<A> withNewAtime() {
    return new AtimeNested(null);
  }
  
  public A withNewAtime(Long nsec,Long sec) {
    return (A) this.withAtime(new Timespec(nsec, sec));
  }
  
  public AtimeNested<A> withNewAtimeLike(Timespec item) {
    return new AtimeNested(item);
  }
  
  public CtimeNested<A> withNewCtime() {
    return new CtimeNested(null);
  }
  
  public A withNewCtime(Long nsec,Long sec) {
    return (A) this.withCtime(new Timespec(nsec, sec));
  }
  
  public CtimeNested<A> withNewCtimeLike(Timespec item) {
    return new CtimeNested(item);
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
  
  public MtimeNested<A> withNewMtime() {
    return new MtimeNested(null);
  }
  
  public A withNewMtime(Long nsec,Long sec) {
    return (A) this.withMtime(new Timespec(nsec, sec));
  }
  
  public MtimeNested<A> withNewMtimeLike(Timespec item) {
    return new MtimeNested(item);
  }
  
  public A withNlink(Long nlink) {
    this.nlink = nlink;
    return (A) this;
  }
  
  public A withPath(String path) {
    this.path = path;
    return (A) this;
  }
  
  public A withPercent(Integer percent) {
    this.percent = percent;
    return (A) this;
  }
  
  public A withPerm(Integer perm) {
    this.perm = perm;
    return (A) this;
  }
  
  public A withRdev(Long rdev) {
    this.rdev = rdev;
    return (A) this;
  }
  
  public A withSize(Long size) {
    this.size = size;
    return (A) this;
  }
  
  public A withSource(String source) {
    this.source = source;
    return (A) this;
  }
  
  public A withType(String type) {
    this.type = type;
    return (A) this;
  }
  
  public A withUid(Long uid) {
    this.uid = uid;
    return (A) this;
  }
  public class AtimeNested<N> extends TimespecFluent<AtimeNested<N>> implements Nested<N>{
  
    TimespecBuilder builder;
  
    AtimeNested(Timespec item) {
      this.builder = new TimespecBuilder(this, item);
    }
  
    public N and() {
      return (N) IOChaosActionFluent.this.withAtime(builder.build());
    }
    
    public N endAtime() {
      return and();
    }
    
  }
  public class CtimeNested<N> extends TimespecFluent<CtimeNested<N>> implements Nested<N>{
  
    TimespecBuilder builder;
  
    CtimeNested(Timespec item) {
      this.builder = new TimespecBuilder(this, item);
    }
  
    public N and() {
      return (N) IOChaosActionFluent.this.withCtime(builder.build());
    }
    
    public N endCtime() {
      return and();
    }
    
  }
  public class FaultsNested<N> extends IoFaultFluent<FaultsNested<N>> implements Nested<N>{
  
    IoFaultBuilder builder;
    int index;
  
    FaultsNested(int index,IoFault item) {
      this.index = index;
      this.builder = new IoFaultBuilder(this, item);
    }
  
    public N and() {
      return (N) IOChaosActionFluent.this.setToFaults(index, builder.build());
    }
    
    public N endFault() {
      return and();
    }
    
  }
  public class MistakeNested<N> extends MistakeSpecFluent<MistakeNested<N>> implements Nested<N>{
  
    MistakeSpecBuilder builder;
  
    MistakeNested(MistakeSpec item) {
      this.builder = new MistakeSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) IOChaosActionFluent.this.withMistake(builder.build());
    }
    
    public N endMistake() {
      return and();
    }
    
  }
  public class MtimeNested<N> extends TimespecFluent<MtimeNested<N>> implements Nested<N>{
  
    TimespecBuilder builder;
  
    MtimeNested(Timespec item) {
      this.builder = new TimespecBuilder(this, item);
    }
  
    public N and() {
      return (N) IOChaosActionFluent.this.withMtime(builder.build());
    }
    
    public N endMtime() {
      return and();
    }
    
  }
}