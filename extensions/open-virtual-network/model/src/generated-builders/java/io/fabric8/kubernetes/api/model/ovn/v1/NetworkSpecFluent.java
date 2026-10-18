package io.fabric8.kubernetes.api.model.ovn.v1;

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
public class NetworkSpecFluent<A extends io.fabric8.kubernetes.api.model.ovn.v1.NetworkSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private EVPNConfigBuilder evpn;
  private Layer2ConfigBuilder layer2;
  private Layer3ConfigBuilder layer3;
  private LocalnetConfigBuilder localnet;
  private NoOverlayConfigBuilder noOverlay;
  private String topology;
  private String transport;

  public NetworkSpecFluent() {
  }
  
  public NetworkSpecFluent(NetworkSpec instance) {
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
  
  public EVPNConfig buildEvpn() {
    return this.evpn != null ? this.evpn.build() : null;
  }
  
  public Layer2Config buildLayer2() {
    return this.layer2 != null ? this.layer2.build() : null;
  }
  
  public Layer3Config buildLayer3() {
    return this.layer3 != null ? this.layer3.build() : null;
  }
  
  public LocalnetConfig buildLocalnet() {
    return this.localnet != null ? this.localnet.build() : null;
  }
  
  public NoOverlayConfig buildNoOverlay() {
    return this.noOverlay != null ? this.noOverlay.build() : null;
  }
  
  protected void copyInstance(NetworkSpec instance) {
    instance = instance != null ? instance : new NetworkSpec();
    if (instance != null) {
        this.withEvpn(instance.getEvpn());
        this.withLayer2(instance.getLayer2());
        this.withLayer3(instance.getLayer3());
        this.withLocalnet(instance.getLocalnet());
        this.withNoOverlay(instance.getNoOverlay());
        this.withTopology(instance.getTopology());
        this.withTransport(instance.getTransport());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public EvpnNested<A> editEvpn() {
    return this.withNewEvpnLike(Optional.ofNullable(this.buildEvpn()).orElse(null));
  }
  
  public Layer2Nested<A> editLayer2() {
    return this.withNewLayer2Like(Optional.ofNullable(this.buildLayer2()).orElse(null));
  }
  
  public Layer3Nested<A> editLayer3() {
    return this.withNewLayer3Like(Optional.ofNullable(this.buildLayer3()).orElse(null));
  }
  
  public LocalnetNested<A> editLocalnet() {
    return this.withNewLocalnetLike(Optional.ofNullable(this.buildLocalnet()).orElse(null));
  }
  
  public NoOverlayNested<A> editNoOverlay() {
    return this.withNewNoOverlayLike(Optional.ofNullable(this.buildNoOverlay()).orElse(null));
  }
  
  public EvpnNested<A> editOrNewEvpn() {
    return this.withNewEvpnLike(Optional.ofNullable(this.buildEvpn()).orElse(new EVPNConfigBuilder().build()));
  }
  
  public EvpnNested<A> editOrNewEvpnLike(EVPNConfig item) {
    return this.withNewEvpnLike(Optional.ofNullable(this.buildEvpn()).orElse(item));
  }
  
  public Layer2Nested<A> editOrNewLayer2() {
    return this.withNewLayer2Like(Optional.ofNullable(this.buildLayer2()).orElse(new Layer2ConfigBuilder().build()));
  }
  
  public Layer2Nested<A> editOrNewLayer2Like(Layer2Config item) {
    return this.withNewLayer2Like(Optional.ofNullable(this.buildLayer2()).orElse(item));
  }
  
  public Layer3Nested<A> editOrNewLayer3() {
    return this.withNewLayer3Like(Optional.ofNullable(this.buildLayer3()).orElse(new Layer3ConfigBuilder().build()));
  }
  
  public Layer3Nested<A> editOrNewLayer3Like(Layer3Config item) {
    return this.withNewLayer3Like(Optional.ofNullable(this.buildLayer3()).orElse(item));
  }
  
  public LocalnetNested<A> editOrNewLocalnet() {
    return this.withNewLocalnetLike(Optional.ofNullable(this.buildLocalnet()).orElse(new LocalnetConfigBuilder().build()));
  }
  
  public LocalnetNested<A> editOrNewLocalnetLike(LocalnetConfig item) {
    return this.withNewLocalnetLike(Optional.ofNullable(this.buildLocalnet()).orElse(item));
  }
  
  public NoOverlayNested<A> editOrNewNoOverlay() {
    return this.withNewNoOverlayLike(Optional.ofNullable(this.buildNoOverlay()).orElse(new NoOverlayConfigBuilder().build()));
  }
  
  public NoOverlayNested<A> editOrNewNoOverlayLike(NoOverlayConfig item) {
    return this.withNewNoOverlayLike(Optional.ofNullable(this.buildNoOverlay()).orElse(item));
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
    NetworkSpecFluent that = (NetworkSpecFluent) o;
    if (!(Objects.equals(evpn, that.evpn))) {
      return false;
    }
    if (!(Objects.equals(layer2, that.layer2))) {
      return false;
    }
    if (!(Objects.equals(layer3, that.layer3))) {
      return false;
    }
    if (!(Objects.equals(localnet, that.localnet))) {
      return false;
    }
    if (!(Objects.equals(noOverlay, that.noOverlay))) {
      return false;
    }
    if (!(Objects.equals(topology, that.topology))) {
      return false;
    }
    if (!(Objects.equals(transport, that.transport))) {
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
  
  public String getTopology() {
    return this.topology;
  }
  
  public String getTransport() {
    return this.transport;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasEvpn() {
    return this.evpn != null;
  }
  
  public boolean hasLayer2() {
    return this.layer2 != null;
  }
  
  public boolean hasLayer3() {
    return this.layer3 != null;
  }
  
  public boolean hasLocalnet() {
    return this.localnet != null;
  }
  
  public boolean hasNoOverlay() {
    return this.noOverlay != null;
  }
  
  public boolean hasTopology() {
    return this.topology != null;
  }
  
  public boolean hasTransport() {
    return this.transport != null;
  }
  
  public int hashCode() {
    return Objects.hash(evpn, layer2, layer3, localnet, noOverlay, topology, transport, additionalProperties);
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
    if (!(evpn == null)) {
        sb.append("evpn:");
        sb.append(evpn);
        sb.append(",");
    }
    if (!(layer2 == null)) {
        sb.append("layer2:");
        sb.append(layer2);
        sb.append(",");
    }
    if (!(layer3 == null)) {
        sb.append("layer3:");
        sb.append(layer3);
        sb.append(",");
    }
    if (!(localnet == null)) {
        sb.append("localnet:");
        sb.append(localnet);
        sb.append(",");
    }
    if (!(noOverlay == null)) {
        sb.append("noOverlay:");
        sb.append(noOverlay);
        sb.append(",");
    }
    if (!(topology == null)) {
        sb.append("topology:");
        sb.append(topology);
        sb.append(",");
    }
    if (!(transport == null)) {
        sb.append("transport:");
        sb.append(transport);
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
  
  public A withEvpn(EVPNConfig evpn) {
    this._visitables.remove("evpn");
    if (evpn != null) {
        this.evpn = new EVPNConfigBuilder(evpn);
        this._visitables.get("evpn").add(this.evpn);
    } else {
        this.evpn = null;
        this._visitables.get("evpn").remove(this.evpn);
    }
    return (A) this;
  }
  
  public A withLayer2(Layer2Config layer2) {
    this._visitables.remove("layer2");
    if (layer2 != null) {
        this.layer2 = new Layer2ConfigBuilder(layer2);
        this._visitables.get("layer2").add(this.layer2);
    } else {
        this.layer2 = null;
        this._visitables.get("layer2").remove(this.layer2);
    }
    return (A) this;
  }
  
  public A withLayer3(Layer3Config layer3) {
    this._visitables.remove("layer3");
    if (layer3 != null) {
        this.layer3 = new Layer3ConfigBuilder(layer3);
        this._visitables.get("layer3").add(this.layer3);
    } else {
        this.layer3 = null;
        this._visitables.get("layer3").remove(this.layer3);
    }
    return (A) this;
  }
  
  public A withLocalnet(LocalnetConfig localnet) {
    this._visitables.remove("localnet");
    if (localnet != null) {
        this.localnet = new LocalnetConfigBuilder(localnet);
        this._visitables.get("localnet").add(this.localnet);
    } else {
        this.localnet = null;
        this._visitables.get("localnet").remove(this.localnet);
    }
    return (A) this;
  }
  
  public EvpnNested<A> withNewEvpn() {
    return new EvpnNested(null);
  }
  
  public EvpnNested<A> withNewEvpnLike(EVPNConfig item) {
    return new EvpnNested(item);
  }
  
  public Layer2Nested<A> withNewLayer2() {
    return new Layer2Nested(null);
  }
  
  public Layer2Nested<A> withNewLayer2Like(Layer2Config item) {
    return new Layer2Nested(item);
  }
  
  public Layer3Nested<A> withNewLayer3() {
    return new Layer3Nested(null);
  }
  
  public Layer3Nested<A> withNewLayer3Like(Layer3Config item) {
    return new Layer3Nested(item);
  }
  
  public LocalnetNested<A> withNewLocalnet() {
    return new LocalnetNested(null);
  }
  
  public LocalnetNested<A> withNewLocalnetLike(LocalnetConfig item) {
    return new LocalnetNested(item);
  }
  
  public NoOverlayNested<A> withNewNoOverlay() {
    return new NoOverlayNested(null);
  }
  
  public A withNewNoOverlay(String outboundSNAT,String routing) {
    return (A) this.withNoOverlay(new NoOverlayConfig(outboundSNAT, routing));
  }
  
  public NoOverlayNested<A> withNewNoOverlayLike(NoOverlayConfig item) {
    return new NoOverlayNested(item);
  }
  
  public A withNoOverlay(NoOverlayConfig noOverlay) {
    this._visitables.remove("noOverlay");
    if (noOverlay != null) {
        this.noOverlay = new NoOverlayConfigBuilder(noOverlay);
        this._visitables.get("noOverlay").add(this.noOverlay);
    } else {
        this.noOverlay = null;
        this._visitables.get("noOverlay").remove(this.noOverlay);
    }
    return (A) this;
  }
  
  public A withTopology(String topology) {
    this.topology = topology;
    return (A) this;
  }
  
  public A withTransport(String transport) {
    this.transport = transport;
    return (A) this;
  }
  public class EvpnNested<N> extends EVPNConfigFluent<EvpnNested<N>> implements Nested<N>{
  
    EVPNConfigBuilder builder;
  
    EvpnNested(EVPNConfig item) {
      this.builder = new EVPNConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) NetworkSpecFluent.this.withEvpn(builder.build());
    }
    
    public N endEvpn() {
      return and();
    }
    
  }
  public class Layer2Nested<N> extends Layer2ConfigFluent<Layer2Nested<N>> implements Nested<N>{
  
    Layer2ConfigBuilder builder;
  
    Layer2Nested(Layer2Config item) {
      this.builder = new Layer2ConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) NetworkSpecFluent.this.withLayer2(builder.build());
    }
    
    public N endLayer2() {
      return and();
    }
    
  }
  public class Layer3Nested<N> extends Layer3ConfigFluent<Layer3Nested<N>> implements Nested<N>{
  
    Layer3ConfigBuilder builder;
  
    Layer3Nested(Layer3Config item) {
      this.builder = new Layer3ConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) NetworkSpecFluent.this.withLayer3(builder.build());
    }
    
    public N endLayer3() {
      return and();
    }
    
  }
  public class LocalnetNested<N> extends LocalnetConfigFluent<LocalnetNested<N>> implements Nested<N>{
  
    LocalnetConfigBuilder builder;
  
    LocalnetNested(LocalnetConfig item) {
      this.builder = new LocalnetConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) NetworkSpecFluent.this.withLocalnet(builder.build());
    }
    
    public N endLocalnet() {
      return and();
    }
    
  }
  public class NoOverlayNested<N> extends NoOverlayConfigFluent<NoOverlayNested<N>> implements Nested<N>{
  
    NoOverlayConfigBuilder builder;
  
    NoOverlayNested(NoOverlayConfig item) {
      this.builder = new NoOverlayConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) NetworkSpecFluent.this.withNoOverlay(builder.build());
    }
    
    public N endNoOverlay() {
      return and();
    }
    
  }
}