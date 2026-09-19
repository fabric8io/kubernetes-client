package io.fabric8.certmanager.api.model.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
public class VenafiIssuerFluent<A extends io.fabric8.certmanager.api.model.v1.VenafiIssuerFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private VenafiCloudBuilder cloud;
  private VenafiNGTSBuilder ngts;
  private VenafiTPPBuilder tpp;
  private String zone;

  public VenafiIssuerFluent() {
  }
  
  public VenafiIssuerFluent(VenafiIssuer instance) {
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
  
  public VenafiCloud buildCloud() {
    return this.cloud != null ? this.cloud.build() : null;
  }
  
  public VenafiNGTS buildNgts() {
    return this.ngts != null ? this.ngts.build() : null;
  }
  
  public VenafiTPP buildTpp() {
    return this.tpp != null ? this.tpp.build() : null;
  }
  
  protected void copyInstance(VenafiIssuer instance) {
    instance = instance != null ? instance : new VenafiIssuer();
    if (instance != null) {
        this.withCloud(instance.getCloud());
        this.withNgts(instance.getNgts());
        this.withTpp(instance.getTpp());
        this.withZone(instance.getZone());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public CloudNested<A> editCloud() {
    return this.withNewCloudLike(Optional.ofNullable(this.buildCloud()).orElse(null));
  }
  
  public NgtsNested<A> editNgts() {
    return this.withNewNgtsLike(Optional.ofNullable(this.buildNgts()).orElse(null));
  }
  
  public CloudNested<A> editOrNewCloud() {
    return this.withNewCloudLike(Optional.ofNullable(this.buildCloud()).orElse(new VenafiCloudBuilder().build()));
  }
  
  public CloudNested<A> editOrNewCloudLike(VenafiCloud item) {
    return this.withNewCloudLike(Optional.ofNullable(this.buildCloud()).orElse(item));
  }
  
  public NgtsNested<A> editOrNewNgts() {
    return this.withNewNgtsLike(Optional.ofNullable(this.buildNgts()).orElse(new VenafiNGTSBuilder().build()));
  }
  
  public NgtsNested<A> editOrNewNgtsLike(VenafiNGTS item) {
    return this.withNewNgtsLike(Optional.ofNullable(this.buildNgts()).orElse(item));
  }
  
  public TppNested<A> editOrNewTpp() {
    return this.withNewTppLike(Optional.ofNullable(this.buildTpp()).orElse(new VenafiTPPBuilder().build()));
  }
  
  public TppNested<A> editOrNewTppLike(VenafiTPP item) {
    return this.withNewTppLike(Optional.ofNullable(this.buildTpp()).orElse(item));
  }
  
  public TppNested<A> editTpp() {
    return this.withNewTppLike(Optional.ofNullable(this.buildTpp()).orElse(null));
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
    VenafiIssuerFluent that = (VenafiIssuerFluent) o;
    if (!(Objects.equals(cloud, that.cloud))) {
      return false;
    }
    if (!(Objects.equals(ngts, that.ngts))) {
      return false;
    }
    if (!(Objects.equals(tpp, that.tpp))) {
      return false;
    }
    if (!(Objects.equals(zone, that.zone))) {
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
  
  public String getZone() {
    return this.zone;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCloud() {
    return this.cloud != null;
  }
  
  public boolean hasNgts() {
    return this.ngts != null;
  }
  
  public boolean hasTpp() {
    return this.tpp != null;
  }
  
  public boolean hasZone() {
    return this.zone != null;
  }
  
  public int hashCode() {
    return Objects.hash(cloud, ngts, tpp, zone, additionalProperties);
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
    if (!(cloud == null)) {
        sb.append("cloud:");
        sb.append(cloud);
        sb.append(",");
    }
    if (!(ngts == null)) {
        sb.append("ngts:");
        sb.append(ngts);
        sb.append(",");
    }
    if (!(tpp == null)) {
        sb.append("tpp:");
        sb.append(tpp);
        sb.append(",");
    }
    if (!(zone == null)) {
        sb.append("zone:");
        sb.append(zone);
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
  
  public A withCloud(VenafiCloud cloud) {
    this._visitables.remove("cloud");
    if (cloud != null) {
        this.cloud = new VenafiCloudBuilder(cloud);
        this._visitables.get("cloud").add(this.cloud);
    } else {
        this.cloud = null;
        this._visitables.get("cloud").remove(this.cloud);
    }
    return (A) this;
  }
  
  public CloudNested<A> withNewCloud() {
    return new CloudNested(null);
  }
  
  public CloudNested<A> withNewCloudLike(VenafiCloud item) {
    return new CloudNested(item);
  }
  
  public NgtsNested<A> withNewNgts() {
    return new NgtsNested(null);
  }
  
  public NgtsNested<A> withNewNgtsLike(VenafiNGTS item) {
    return new NgtsNested(item);
  }
  
  public TppNested<A> withNewTpp() {
    return new TppNested(null);
  }
  
  public TppNested<A> withNewTppLike(VenafiTPP item) {
    return new TppNested(item);
  }
  
  public A withNgts(VenafiNGTS ngts) {
    this._visitables.remove("ngts");
    if (ngts != null) {
        this.ngts = new VenafiNGTSBuilder(ngts);
        this._visitables.get("ngts").add(this.ngts);
    } else {
        this.ngts = null;
        this._visitables.get("ngts").remove(this.ngts);
    }
    return (A) this;
  }
  
  public A withTpp(VenafiTPP tpp) {
    this._visitables.remove("tpp");
    if (tpp != null) {
        this.tpp = new VenafiTPPBuilder(tpp);
        this._visitables.get("tpp").add(this.tpp);
    } else {
        this.tpp = null;
        this._visitables.get("tpp").remove(this.tpp);
    }
    return (A) this;
  }
  
  public A withZone(String zone) {
    this.zone = zone;
    return (A) this;
  }
  public class CloudNested<N> extends VenafiCloudFluent<CloudNested<N>> implements Nested<N>{
  
    VenafiCloudBuilder builder;
  
    CloudNested(VenafiCloud item) {
      this.builder = new VenafiCloudBuilder(this, item);
    }
  
    public N and() {
      return (N) VenafiIssuerFluent.this.withCloud(builder.build());
    }
    
    public N endCloud() {
      return and();
    }
    
  }
  public class NgtsNested<N> extends VenafiNGTSFluent<NgtsNested<N>> implements Nested<N>{
  
    VenafiNGTSBuilder builder;
  
    NgtsNested(VenafiNGTS item) {
      this.builder = new VenafiNGTSBuilder(this, item);
    }
  
    public N and() {
      return (N) VenafiIssuerFluent.this.withNgts(builder.build());
    }
    
    public N endNgts() {
      return and();
    }
    
  }
  public class TppNested<N> extends VenafiTPPFluent<TppNested<N>> implements Nested<N>{
  
    VenafiTPPBuilder builder;
  
    TppNested(VenafiTPP item) {
      this.builder = new VenafiTPPBuilder(this, item);
    }
  
    public N and() {
      return (N) VenafiIssuerFluent.this.withTpp(builder.build());
    }
    
    public N endTpp() {
      return and();
    }
    
  }
}