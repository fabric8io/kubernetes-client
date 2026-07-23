package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
public class RawTrafficControlFluent<A extends io.fabric8.chaosmesh.v1alpha1.RawTrafficControlFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private BandwidthSpecBuilder bandwidth;
  private CorruptSpecBuilder corrupt;
  private DelaySpecBuilder delay;
  private String device;
  private DuplicateSpecBuilder duplicate;
  private String ipset;
  private LossSpecBuilder loss;
  private RateSpecBuilder rate;
  private String source;
  private String type;

  public RawTrafficControlFluent() {
  }
  
  public RawTrafficControlFluent(RawTrafficControl instance) {
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
  
  public BandwidthSpec buildBandwidth() {
    return this.bandwidth != null ? this.bandwidth.build() : null;
  }
  
  public CorruptSpec buildCorrupt() {
    return this.corrupt != null ? this.corrupt.build() : null;
  }
  
  public DelaySpec buildDelay() {
    return this.delay != null ? this.delay.build() : null;
  }
  
  public DuplicateSpec buildDuplicate() {
    return this.duplicate != null ? this.duplicate.build() : null;
  }
  
  public LossSpec buildLoss() {
    return this.loss != null ? this.loss.build() : null;
  }
  
  public RateSpec buildRate() {
    return this.rate != null ? this.rate.build() : null;
  }
  
  protected void copyInstance(RawTrafficControl instance) {
    instance = instance != null ? instance : new RawTrafficControl();
    if (instance != null) {
        this.withBandwidth(instance.getBandwidth());
        this.withCorrupt(instance.getCorrupt());
        this.withDelay(instance.getDelay());
        this.withDevice(instance.getDevice());
        this.withDuplicate(instance.getDuplicate());
        this.withIpset(instance.getIpset());
        this.withLoss(instance.getLoss());
        this.withRate(instance.getRate());
        this.withSource(instance.getSource());
        this.withType(instance.getType());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public BandwidthNested<A> editBandwidth() {
    return this.withNewBandwidthLike(Optional.ofNullable(this.buildBandwidth()).orElse(null));
  }
  
  public CorruptNested<A> editCorrupt() {
    return this.withNewCorruptLike(Optional.ofNullable(this.buildCorrupt()).orElse(null));
  }
  
  public DelayNested<A> editDelay() {
    return this.withNewDelayLike(Optional.ofNullable(this.buildDelay()).orElse(null));
  }
  
  public DuplicateNested<A> editDuplicate() {
    return this.withNewDuplicateLike(Optional.ofNullable(this.buildDuplicate()).orElse(null));
  }
  
  public LossNested<A> editLoss() {
    return this.withNewLossLike(Optional.ofNullable(this.buildLoss()).orElse(null));
  }
  
  public BandwidthNested<A> editOrNewBandwidth() {
    return this.withNewBandwidthLike(Optional.ofNullable(this.buildBandwidth()).orElse(new BandwidthSpecBuilder().build()));
  }
  
  public BandwidthNested<A> editOrNewBandwidthLike(BandwidthSpec item) {
    return this.withNewBandwidthLike(Optional.ofNullable(this.buildBandwidth()).orElse(item));
  }
  
  public CorruptNested<A> editOrNewCorrupt() {
    return this.withNewCorruptLike(Optional.ofNullable(this.buildCorrupt()).orElse(new CorruptSpecBuilder().build()));
  }
  
  public CorruptNested<A> editOrNewCorruptLike(CorruptSpec item) {
    return this.withNewCorruptLike(Optional.ofNullable(this.buildCorrupt()).orElse(item));
  }
  
  public DelayNested<A> editOrNewDelay() {
    return this.withNewDelayLike(Optional.ofNullable(this.buildDelay()).orElse(new DelaySpecBuilder().build()));
  }
  
  public DelayNested<A> editOrNewDelayLike(DelaySpec item) {
    return this.withNewDelayLike(Optional.ofNullable(this.buildDelay()).orElse(item));
  }
  
  public DuplicateNested<A> editOrNewDuplicate() {
    return this.withNewDuplicateLike(Optional.ofNullable(this.buildDuplicate()).orElse(new DuplicateSpecBuilder().build()));
  }
  
  public DuplicateNested<A> editOrNewDuplicateLike(DuplicateSpec item) {
    return this.withNewDuplicateLike(Optional.ofNullable(this.buildDuplicate()).orElse(item));
  }
  
  public LossNested<A> editOrNewLoss() {
    return this.withNewLossLike(Optional.ofNullable(this.buildLoss()).orElse(new LossSpecBuilder().build()));
  }
  
  public LossNested<A> editOrNewLossLike(LossSpec item) {
    return this.withNewLossLike(Optional.ofNullable(this.buildLoss()).orElse(item));
  }
  
  public RateNested<A> editOrNewRate() {
    return this.withNewRateLike(Optional.ofNullable(this.buildRate()).orElse(new RateSpecBuilder().build()));
  }
  
  public RateNested<A> editOrNewRateLike(RateSpec item) {
    return this.withNewRateLike(Optional.ofNullable(this.buildRate()).orElse(item));
  }
  
  public RateNested<A> editRate() {
    return this.withNewRateLike(Optional.ofNullable(this.buildRate()).orElse(null));
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
    RawTrafficControlFluent that = (RawTrafficControlFluent) o;
    if (!(Objects.equals(bandwidth, that.bandwidth))) {
      return false;
    }
    if (!(Objects.equals(corrupt, that.corrupt))) {
      return false;
    }
    if (!(Objects.equals(delay, that.delay))) {
      return false;
    }
    if (!(Objects.equals(device, that.device))) {
      return false;
    }
    if (!(Objects.equals(duplicate, that.duplicate))) {
      return false;
    }
    if (!(Objects.equals(ipset, that.ipset))) {
      return false;
    }
    if (!(Objects.equals(loss, that.loss))) {
      return false;
    }
    if (!(Objects.equals(rate, that.rate))) {
      return false;
    }
    if (!(Objects.equals(source, that.source))) {
      return false;
    }
    if (!(Objects.equals(type, that.type))) {
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
  
  public String getDevice() {
    return this.device;
  }
  
  public String getIpset() {
    return this.ipset;
  }
  
  public String getSource() {
    return this.source;
  }
  
  public String getType() {
    return this.type;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasBandwidth() {
    return this.bandwidth != null;
  }
  
  public boolean hasCorrupt() {
    return this.corrupt != null;
  }
  
  public boolean hasDelay() {
    return this.delay != null;
  }
  
  public boolean hasDevice() {
    return this.device != null;
  }
  
  public boolean hasDuplicate() {
    return this.duplicate != null;
  }
  
  public boolean hasIpset() {
    return this.ipset != null;
  }
  
  public boolean hasLoss() {
    return this.loss != null;
  }
  
  public boolean hasRate() {
    return this.rate != null;
  }
  
  public boolean hasSource() {
    return this.source != null;
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public int hashCode() {
    return Objects.hash(bandwidth, corrupt, delay, device, duplicate, ipset, loss, rate, source, type, additionalProperties);
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
    if (!(bandwidth == null)) {
        sb.append("bandwidth:");
        sb.append(bandwidth);
        sb.append(",");
    }
    if (!(corrupt == null)) {
        sb.append("corrupt:");
        sb.append(corrupt);
        sb.append(",");
    }
    if (!(delay == null)) {
        sb.append("delay:");
        sb.append(delay);
        sb.append(",");
    }
    if (!(device == null)) {
        sb.append("device:");
        sb.append(device);
        sb.append(",");
    }
    if (!(duplicate == null)) {
        sb.append("duplicate:");
        sb.append(duplicate);
        sb.append(",");
    }
    if (!(ipset == null)) {
        sb.append("ipset:");
        sb.append(ipset);
        sb.append(",");
    }
    if (!(loss == null)) {
        sb.append("loss:");
        sb.append(loss);
        sb.append(",");
    }
    if (!(rate == null)) {
        sb.append("rate:");
        sb.append(rate);
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
  
  public A withBandwidth(BandwidthSpec bandwidth) {
    this._visitables.remove("bandwidth");
    if (bandwidth != null) {
        this.bandwidth = new BandwidthSpecBuilder(bandwidth);
        this._visitables.get("bandwidth").add(this.bandwidth);
    } else {
        this.bandwidth = null;
        this._visitables.get("bandwidth").remove(this.bandwidth);
    }
    return (A) this;
  }
  
  public A withCorrupt(CorruptSpec corrupt) {
    this._visitables.remove("corrupt");
    if (corrupt != null) {
        this.corrupt = new CorruptSpecBuilder(corrupt);
        this._visitables.get("corrupt").add(this.corrupt);
    } else {
        this.corrupt = null;
        this._visitables.get("corrupt").remove(this.corrupt);
    }
    return (A) this;
  }
  
  public A withDelay(DelaySpec delay) {
    this._visitables.remove("delay");
    if (delay != null) {
        this.delay = new DelaySpecBuilder(delay);
        this._visitables.get("delay").add(this.delay);
    } else {
        this.delay = null;
        this._visitables.get("delay").remove(this.delay);
    }
    return (A) this;
  }
  
  public A withDevice(String device) {
    this.device = device;
    return (A) this;
  }
  
  public A withDuplicate(DuplicateSpec duplicate) {
    this._visitables.remove("duplicate");
    if (duplicate != null) {
        this.duplicate = new DuplicateSpecBuilder(duplicate);
        this._visitables.get("duplicate").add(this.duplicate);
    } else {
        this.duplicate = null;
        this._visitables.get("duplicate").remove(this.duplicate);
    }
    return (A) this;
  }
  
  public A withIpset(String ipset) {
    this.ipset = ipset;
    return (A) this;
  }
  
  public A withLoss(LossSpec loss) {
    this._visitables.remove("loss");
    if (loss != null) {
        this.loss = new LossSpecBuilder(loss);
        this._visitables.get("loss").add(this.loss);
    } else {
        this.loss = null;
        this._visitables.get("loss").remove(this.loss);
    }
    return (A) this;
  }
  
  public BandwidthNested<A> withNewBandwidth() {
    return new BandwidthNested(null);
  }
  
  public A withNewBandwidth(Long buffer,Long limit,Long minburst,Long peakrate,String rate) {
    return (A) this.withBandwidth(new BandwidthSpec(buffer, limit, minburst, peakrate, rate));
  }
  
  public BandwidthNested<A> withNewBandwidthLike(BandwidthSpec item) {
    return new BandwidthNested(item);
  }
  
  public CorruptNested<A> withNewCorrupt() {
    return new CorruptNested(null);
  }
  
  public A withNewCorrupt(String correlation,String corrupt) {
    return (A) this.withCorrupt(new CorruptSpec(correlation, corrupt));
  }
  
  public CorruptNested<A> withNewCorruptLike(CorruptSpec item) {
    return new CorruptNested(item);
  }
  
  public DelayNested<A> withNewDelay() {
    return new DelayNested(null);
  }
  
  public DelayNested<A> withNewDelayLike(DelaySpec item) {
    return new DelayNested(item);
  }
  
  public DuplicateNested<A> withNewDuplicate() {
    return new DuplicateNested(null);
  }
  
  public A withNewDuplicate(String correlation,String duplicate) {
    return (A) this.withDuplicate(new DuplicateSpec(correlation, duplicate));
  }
  
  public DuplicateNested<A> withNewDuplicateLike(DuplicateSpec item) {
    return new DuplicateNested(item);
  }
  
  public LossNested<A> withNewLoss() {
    return new LossNested(null);
  }
  
  public A withNewLoss(String correlation,String loss) {
    return (A) this.withLoss(new LossSpec(correlation, loss));
  }
  
  public LossNested<A> withNewLossLike(LossSpec item) {
    return new LossNested(item);
  }
  
  public RateNested<A> withNewRate() {
    return new RateNested(null);
  }
  
  public A withNewRate(String rate) {
    return (A) this.withRate(new RateSpec(rate));
  }
  
  public RateNested<A> withNewRateLike(RateSpec item) {
    return new RateNested(item);
  }
  
  public A withRate(RateSpec rate) {
    this._visitables.remove("rate");
    if (rate != null) {
        this.rate = new RateSpecBuilder(rate);
        this._visitables.get("rate").add(this.rate);
    } else {
        this.rate = null;
        this._visitables.get("rate").remove(this.rate);
    }
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
  public class BandwidthNested<N> extends BandwidthSpecFluent<BandwidthNested<N>> implements Nested<N>{
  
    BandwidthSpecBuilder builder;
  
    BandwidthNested(BandwidthSpec item) {
      this.builder = new BandwidthSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) RawTrafficControlFluent.this.withBandwidth(builder.build());
    }
    
    public N endBandwidth() {
      return and();
    }
    
  }
  public class CorruptNested<N> extends CorruptSpecFluent<CorruptNested<N>> implements Nested<N>{
  
    CorruptSpecBuilder builder;
  
    CorruptNested(CorruptSpec item) {
      this.builder = new CorruptSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) RawTrafficControlFluent.this.withCorrupt(builder.build());
    }
    
    public N endCorrupt() {
      return and();
    }
    
  }
  public class DelayNested<N> extends DelaySpecFluent<DelayNested<N>> implements Nested<N>{
  
    DelaySpecBuilder builder;
  
    DelayNested(DelaySpec item) {
      this.builder = new DelaySpecBuilder(this, item);
    }
  
    public N and() {
      return (N) RawTrafficControlFluent.this.withDelay(builder.build());
    }
    
    public N endDelay() {
      return and();
    }
    
  }
  public class DuplicateNested<N> extends DuplicateSpecFluent<DuplicateNested<N>> implements Nested<N>{
  
    DuplicateSpecBuilder builder;
  
    DuplicateNested(DuplicateSpec item) {
      this.builder = new DuplicateSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) RawTrafficControlFluent.this.withDuplicate(builder.build());
    }
    
    public N endDuplicate() {
      return and();
    }
    
  }
  public class LossNested<N> extends LossSpecFluent<LossNested<N>> implements Nested<N>{
  
    LossSpecBuilder builder;
  
    LossNested(LossSpec item) {
      this.builder = new LossSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) RawTrafficControlFluent.this.withLoss(builder.build());
    }
    
    public N endLoss() {
      return and();
    }
    
  }
  public class RateNested<N> extends RateSpecFluent<RateNested<N>> implements Nested<N>{
  
    RateSpecBuilder builder;
  
    RateNested(RateSpec item) {
      this.builder = new RateSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) RawTrafficControlFluent.this.withRate(builder.build());
    }
    
    public N endRate() {
      return and();
    }
    
  }
}