package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
public class NetworkChaosSpecFluent<A extends io.fabric8.chaosmesh.v1alpha1.NetworkChaosSpecFluent<A>> extends BaseFluent<A>{

  private String action;
  private Map<String,Object> additionalProperties;
  private BandwidthSpecBuilder bandwidth;
  private CorruptSpecBuilder corrupt;
  private DelaySpecBuilder delay;
  private String device;
  private String direction;
  private DuplicateSpecBuilder duplicate;
  private String duration;
  private List<String> externalTargets = new ArrayList<String>();
  private LossSpecBuilder loss;
  private String mode;
  private RateSpecBuilder rate;
  private String remoteCluster;
  private PodSelectorSpecBuilder selector;
  private PodSelectorBuilder target;
  private String targetDevice;
  private String value;

  public NetworkChaosSpecFluent() {
  }
  
  public NetworkChaosSpecFluent(NetworkChaosSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToExternalTargets(Collection<String> items) {
    if (this.externalTargets == null) {
      this.externalTargets = new ArrayList();
    }
    for (String item : items) {
      this.externalTargets.add(item);
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
  
  public A addToExternalTargets(String... items) {
    if (this.externalTargets == null) {
      this.externalTargets = new ArrayList();
    }
    for (String item : items) {
      this.externalTargets.add(item);
    }
    return (A) this;
  }
  
  public A addToExternalTargets(int index,String item) {
    if (this.externalTargets == null) {
      this.externalTargets = new ArrayList();
    }
    this.externalTargets.add(index, item);
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
  
  public PodSelectorSpec buildSelector() {
    return this.selector != null ? this.selector.build() : null;
  }
  
  public PodSelector buildTarget() {
    return this.target != null ? this.target.build() : null;
  }
  
  protected void copyInstance(NetworkChaosSpec instance) {
    instance = instance != null ? instance : new NetworkChaosSpec();
    if (instance != null) {
        this.withAction(instance.getAction());
        this.withBandwidth(instance.getBandwidth());
        this.withCorrupt(instance.getCorrupt());
        this.withDelay(instance.getDelay());
        this.withDevice(instance.getDevice());
        this.withDirection(instance.getDirection());
        this.withDuplicate(instance.getDuplicate());
        this.withDuration(instance.getDuration());
        this.withExternalTargets(instance.getExternalTargets());
        this.withLoss(instance.getLoss());
        this.withMode(instance.getMode());
        this.withRate(instance.getRate());
        this.withRemoteCluster(instance.getRemoteCluster());
        this.withSelector(instance.getSelector());
        this.withTarget(instance.getTarget());
        this.withTargetDevice(instance.getTargetDevice());
        this.withValue(instance.getValue());
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
  
  public SelectorNested<A> editOrNewSelector() {
    return this.withNewSelectorLike(Optional.ofNullable(this.buildSelector()).orElse(new PodSelectorSpecBuilder().build()));
  }
  
  public SelectorNested<A> editOrNewSelectorLike(PodSelectorSpec item) {
    return this.withNewSelectorLike(Optional.ofNullable(this.buildSelector()).orElse(item));
  }
  
  public TargetNested<A> editOrNewTarget() {
    return this.withNewTargetLike(Optional.ofNullable(this.buildTarget()).orElse(new PodSelectorBuilder().build()));
  }
  
  public TargetNested<A> editOrNewTargetLike(PodSelector item) {
    return this.withNewTargetLike(Optional.ofNullable(this.buildTarget()).orElse(item));
  }
  
  public RateNested<A> editRate() {
    return this.withNewRateLike(Optional.ofNullable(this.buildRate()).orElse(null));
  }
  
  public SelectorNested<A> editSelector() {
    return this.withNewSelectorLike(Optional.ofNullable(this.buildSelector()).orElse(null));
  }
  
  public TargetNested<A> editTarget() {
    return this.withNewTargetLike(Optional.ofNullable(this.buildTarget()).orElse(null));
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
    NetworkChaosSpecFluent that = (NetworkChaosSpecFluent) o;
    if (!(Objects.equals(action, that.action))) {
      return false;
    }
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
    if (!(Objects.equals(direction, that.direction))) {
      return false;
    }
    if (!(Objects.equals(duplicate, that.duplicate))) {
      return false;
    }
    if (!(Objects.equals(duration, that.duration))) {
      return false;
    }
    if (!(Objects.equals(externalTargets, that.externalTargets))) {
      return false;
    }
    if (!(Objects.equals(loss, that.loss))) {
      return false;
    }
    if (!(Objects.equals(mode, that.mode))) {
      return false;
    }
    if (!(Objects.equals(rate, that.rate))) {
      return false;
    }
    if (!(Objects.equals(remoteCluster, that.remoteCluster))) {
      return false;
    }
    if (!(Objects.equals(selector, that.selector))) {
      return false;
    }
    if (!(Objects.equals(target, that.target))) {
      return false;
    }
    if (!(Objects.equals(targetDevice, that.targetDevice))) {
      return false;
    }
    if (!(Objects.equals(value, that.value))) {
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
  
  public String getDevice() {
    return this.device;
  }
  
  public String getDirection() {
    return this.direction;
  }
  
  public String getDuration() {
    return this.duration;
  }
  
  public String getExternalTarget(int index) {
    return this.externalTargets.get(index);
  }
  
  public List<String> getExternalTargets() {
    return this.externalTargets;
  }
  
  public String getFirstExternalTarget() {
    return this.externalTargets.get(0);
  }
  
  public String getLastExternalTarget() {
    return this.externalTargets.get(externalTargets.size() - 1);
  }
  
  public String getMatchingExternalTarget(Predicate<String> predicate) {
      for (String item : externalTargets) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMode() {
    return this.mode;
  }
  
  public String getRemoteCluster() {
    return this.remoteCluster;
  }
  
  public String getTargetDevice() {
    return this.targetDevice;
  }
  
  public String getValue() {
    return this.value;
  }
  
  public boolean hasAction() {
    return this.action != null;
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
  
  public boolean hasDirection() {
    return this.direction != null;
  }
  
  public boolean hasDuplicate() {
    return this.duplicate != null;
  }
  
  public boolean hasDuration() {
    return this.duration != null;
  }
  
  public boolean hasExternalTargets() {
    return this.externalTargets != null && !(this.externalTargets.isEmpty());
  }
  
  public boolean hasLoss() {
    return this.loss != null;
  }
  
  public boolean hasMatchingExternalTarget(Predicate<String> predicate) {
      for (String item : externalTargets) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMode() {
    return this.mode != null;
  }
  
  public boolean hasRate() {
    return this.rate != null;
  }
  
  public boolean hasRemoteCluster() {
    return this.remoteCluster != null;
  }
  
  public boolean hasSelector() {
    return this.selector != null;
  }
  
  public boolean hasTarget() {
    return this.target != null;
  }
  
  public boolean hasTargetDevice() {
    return this.targetDevice != null;
  }
  
  public boolean hasValue() {
    return this.value != null;
  }
  
  public int hashCode() {
    return Objects.hash(action, bandwidth, corrupt, delay, device, direction, duplicate, duration, externalTargets, loss, mode, rate, remoteCluster, selector, target, targetDevice, value, additionalProperties);
  }
  
  public A removeAllFromExternalTargets(Collection<String> items) {
    if (this.externalTargets == null) {
      return (A) this;
    }
    for (String item : items) {
      this.externalTargets.remove(item);
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
  
  public A removeFromExternalTargets(String... items) {
    if (this.externalTargets == null) {
      return (A) this;
    }
    for (String item : items) {
      this.externalTargets.remove(item);
    }
    return (A) this;
  }
  
  public A setToExternalTargets(int index,String item) {
    if (this.externalTargets == null) {
      this.externalTargets = new ArrayList();
    }
    this.externalTargets.set(index, item);
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
    if (!(direction == null)) {
        sb.append("direction:");
        sb.append(direction);
        sb.append(",");
    }
    if (!(duplicate == null)) {
        sb.append("duplicate:");
        sb.append(duplicate);
        sb.append(",");
    }
    if (!(duration == null)) {
        sb.append("duration:");
        sb.append(duration);
        sb.append(",");
    }
    if (!(externalTargets == null) && !(externalTargets.isEmpty())) {
        sb.append("externalTargets:");
        sb.append(externalTargets);
        sb.append(",");
    }
    if (!(loss == null)) {
        sb.append("loss:");
        sb.append(loss);
        sb.append(",");
    }
    if (!(mode == null)) {
        sb.append("mode:");
        sb.append(mode);
        sb.append(",");
    }
    if (!(rate == null)) {
        sb.append("rate:");
        sb.append(rate);
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
    if (!(target == null)) {
        sb.append("target:");
        sb.append(target);
        sb.append(",");
    }
    if (!(targetDevice == null)) {
        sb.append("targetDevice:");
        sb.append(targetDevice);
        sb.append(",");
    }
    if (!(value == null)) {
        sb.append("value:");
        sb.append(value);
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
  
  public A withDirection(String direction) {
    this.direction = direction;
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
  
  public A withDuration(String duration) {
    this.duration = duration;
    return (A) this;
  }
  
  public A withExternalTargets(List<String> externalTargets) {
    if (externalTargets != null) {
        this.externalTargets = new ArrayList();
        for (String item : externalTargets) {
          this.addToExternalTargets(item);
        }
    } else {
      this.externalTargets = null;
    }
    return (A) this;
  }
  
  public A withExternalTargets(String... externalTargets) {
    if (this.externalTargets != null) {
        this.externalTargets.clear();
        _visitables.remove("externalTargets");
    }
    if (externalTargets != null) {
      for (String item : externalTargets) {
        this.addToExternalTargets(item);
      }
    }
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
  
  public A withMode(String mode) {
    this.mode = mode;
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
  
  public SelectorNested<A> withNewSelector() {
    return new SelectorNested(null);
  }
  
  public SelectorNested<A> withNewSelectorLike(PodSelectorSpec item) {
    return new SelectorNested(item);
  }
  
  public TargetNested<A> withNewTarget() {
    return new TargetNested(null);
  }
  
  public TargetNested<A> withNewTargetLike(PodSelector item) {
    return new TargetNested(item);
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
  
  public A withTarget(PodSelector target) {
    this._visitables.remove("target");
    if (target != null) {
        this.target = new PodSelectorBuilder(target);
        this._visitables.get("target").add(this.target);
    } else {
        this.target = null;
        this._visitables.get("target").remove(this.target);
    }
    return (A) this;
  }
  
  public A withTargetDevice(String targetDevice) {
    this.targetDevice = targetDevice;
    return (A) this;
  }
  
  public A withValue(String value) {
    this.value = value;
    return (A) this;
  }
  public class BandwidthNested<N> extends BandwidthSpecFluent<BandwidthNested<N>> implements Nested<N>{
  
    BandwidthSpecBuilder builder;
  
    BandwidthNested(BandwidthSpec item) {
      this.builder = new BandwidthSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) NetworkChaosSpecFluent.this.withBandwidth(builder.build());
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
      return (N) NetworkChaosSpecFluent.this.withCorrupt(builder.build());
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
      return (N) NetworkChaosSpecFluent.this.withDelay(builder.build());
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
      return (N) NetworkChaosSpecFluent.this.withDuplicate(builder.build());
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
      return (N) NetworkChaosSpecFluent.this.withLoss(builder.build());
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
      return (N) NetworkChaosSpecFluent.this.withRate(builder.build());
    }
    
    public N endRate() {
      return and();
    }
    
  }
  public class SelectorNested<N> extends PodSelectorSpecFluent<SelectorNested<N>> implements Nested<N>{
  
    PodSelectorSpecBuilder builder;
  
    SelectorNested(PodSelectorSpec item) {
      this.builder = new PodSelectorSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) NetworkChaosSpecFluent.this.withSelector(builder.build());
    }
    
    public N endSelector() {
      return and();
    }
    
  }
  public class TargetNested<N> extends PodSelectorFluent<TargetNested<N>> implements Nested<N>{
  
    PodSelectorBuilder builder;
  
    TargetNested(PodSelector item) {
      this.builder = new PodSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) NetworkChaosSpecFluent.this.withTarget(builder.build());
    }
    
    public N endTarget() {
      return and();
    }
    
  }
}