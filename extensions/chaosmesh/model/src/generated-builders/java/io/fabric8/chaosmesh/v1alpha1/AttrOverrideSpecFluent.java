package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class AttrOverrideSpecFluent<A extends io.fabric8.chaosmesh.v1alpha1.AttrOverrideSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private TimespecBuilder atime;
  private Long blocks;
  private TimespecBuilder ctime;
  private Long gid;
  private Long ino;
  private String kind;
  private TimespecBuilder mtime;
  private Long nlink;
  private Integer perm;
  private Long rdev;
  private Long size;
  private Long uid;

  public AttrOverrideSpecFluent() {
  }
  
  public AttrOverrideSpecFluent(AttrOverrideSpec instance) {
    this.copyInstance(instance);
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
  
  public Timespec buildAtime() {
    return this.atime != null ? this.atime.build() : null;
  }
  
  public Timespec buildCtime() {
    return this.ctime != null ? this.ctime.build() : null;
  }
  
  public Timespec buildMtime() {
    return this.mtime != null ? this.mtime.build() : null;
  }
  
  protected void copyInstance(AttrOverrideSpec instance) {
    instance = instance != null ? instance : new AttrOverrideSpec();
    if (instance != null) {
        this.withAtime(instance.getAtime());
        this.withBlocks(instance.getBlocks());
        this.withCtime(instance.getCtime());
        this.withGid(instance.getGid());
        this.withIno(instance.getIno());
        this.withKind(instance.getKind());
        this.withMtime(instance.getMtime());
        this.withNlink(instance.getNlink());
        this.withPerm(instance.getPerm());
        this.withRdev(instance.getRdev());
        this.withSize(instance.getSize());
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
    AttrOverrideSpecFluent that = (AttrOverrideSpecFluent) o;
    if (!(Objects.equals(atime, that.atime))) {
      return false;
    }
    if (!(Objects.equals(blocks, that.blocks))) {
      return false;
    }
    if (!(Objects.equals(ctime, that.ctime))) {
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
    if (!(Objects.equals(mtime, that.mtime))) {
      return false;
    }
    if (!(Objects.equals(nlink, that.nlink))) {
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
  
  public Long getGid() {
    return this.gid;
  }
  
  public Long getIno() {
    return this.ino;
  }
  
  public String getKind() {
    return this.kind;
  }
  
  public Long getNlink() {
    return this.nlink;
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
  
  public boolean hasGid() {
    return this.gid != null;
  }
  
  public boolean hasIno() {
    return this.ino != null;
  }
  
  public boolean hasKind() {
    return this.kind != null;
  }
  
  public boolean hasMtime() {
    return this.mtime != null;
  }
  
  public boolean hasNlink() {
    return this.nlink != null;
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
  
  public boolean hasUid() {
    return this.uid != null;
  }
  
  public int hashCode() {
    return Objects.hash(atime, blocks, ctime, gid, ino, kind, mtime, nlink, perm, rdev, size, uid, additionalProperties);
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
      return (N) AttrOverrideSpecFluent.this.withAtime(builder.build());
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
      return (N) AttrOverrideSpecFluent.this.withCtime(builder.build());
    }
    
    public N endCtime() {
      return and();
    }
    
  }
  public class MtimeNested<N> extends TimespecFluent<MtimeNested<N>> implements Nested<N>{
  
    TimespecBuilder builder;
  
    MtimeNested(Timespec item) {
      this.builder = new TimespecBuilder(this, item);
    }
  
    public N and() {
      return (N) AttrOverrideSpecFluent.this.withMtime(builder.build());
    }
    
    public N endMtime() {
      return and();
    }
    
  }
}