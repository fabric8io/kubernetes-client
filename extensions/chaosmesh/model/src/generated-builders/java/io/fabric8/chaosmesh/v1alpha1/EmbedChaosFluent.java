package io.fabric8.chaosmesh.v1alpha1;

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
public class EmbedChaosFluent<A extends io.fabric8.chaosmesh.v1alpha1.EmbedChaosFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private AWSChaosSpecBuilder awsChaos;
  private AzureChaosSpecBuilder azureChaos;
  private BlockChaosSpecBuilder blockChaos;
  private DNSChaosSpecBuilder dnsChaos;
  private GCPChaosSpecBuilder gcpChaos;
  private HTTPChaosSpecBuilder httpChaos;
  private IOChaosSpecBuilder ioChaos;
  private JVMChaosSpecBuilder jvmChaos;
  private KernelChaosSpecBuilder kernelChaos;
  private NetworkChaosSpecBuilder networkChaos;
  private PhysicalMachineChaosSpecBuilder physicalmachineChaos;
  private PodChaosSpecBuilder podChaos;
  private StressChaosSpecBuilder stressChaos;
  private TimeChaosSpecBuilder timeChaos;

  public EmbedChaosFluent() {
  }
  
  public EmbedChaosFluent(EmbedChaos instance) {
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
  
  public AWSChaosSpec buildAwsChaos() {
    return this.awsChaos != null ? this.awsChaos.build() : null;
  }
  
  public AzureChaosSpec buildAzureChaos() {
    return this.azureChaos != null ? this.azureChaos.build() : null;
  }
  
  public BlockChaosSpec buildBlockChaos() {
    return this.blockChaos != null ? this.blockChaos.build() : null;
  }
  
  public DNSChaosSpec buildDnsChaos() {
    return this.dnsChaos != null ? this.dnsChaos.build() : null;
  }
  
  public GCPChaosSpec buildGcpChaos() {
    return this.gcpChaos != null ? this.gcpChaos.build() : null;
  }
  
  public HTTPChaosSpec buildHttpChaos() {
    return this.httpChaos != null ? this.httpChaos.build() : null;
  }
  
  public IOChaosSpec buildIoChaos() {
    return this.ioChaos != null ? this.ioChaos.build() : null;
  }
  
  public JVMChaosSpec buildJvmChaos() {
    return this.jvmChaos != null ? this.jvmChaos.build() : null;
  }
  
  public KernelChaosSpec buildKernelChaos() {
    return this.kernelChaos != null ? this.kernelChaos.build() : null;
  }
  
  public NetworkChaosSpec buildNetworkChaos() {
    return this.networkChaos != null ? this.networkChaos.build() : null;
  }
  
  public PhysicalMachineChaosSpec buildPhysicalmachineChaos() {
    return this.physicalmachineChaos != null ? this.physicalmachineChaos.build() : null;
  }
  
  public PodChaosSpec buildPodChaos() {
    return this.podChaos != null ? this.podChaos.build() : null;
  }
  
  public StressChaosSpec buildStressChaos() {
    return this.stressChaos != null ? this.stressChaos.build() : null;
  }
  
  public TimeChaosSpec buildTimeChaos() {
    return this.timeChaos != null ? this.timeChaos.build() : null;
  }
  
  protected void copyInstance(EmbedChaos instance) {
    instance = instance != null ? instance : new EmbedChaos();
    if (instance != null) {
        this.withAwsChaos(instance.getAwsChaos());
        this.withAzureChaos(instance.getAzureChaos());
        this.withBlockChaos(instance.getBlockChaos());
        this.withDnsChaos(instance.getDnsChaos());
        this.withGcpChaos(instance.getGcpChaos());
        this.withHttpChaos(instance.getHttpChaos());
        this.withIoChaos(instance.getIoChaos());
        this.withJvmChaos(instance.getJvmChaos());
        this.withKernelChaos(instance.getKernelChaos());
        this.withNetworkChaos(instance.getNetworkChaos());
        this.withPhysicalmachineChaos(instance.getPhysicalmachineChaos());
        this.withPodChaos(instance.getPodChaos());
        this.withStressChaos(instance.getStressChaos());
        this.withTimeChaos(instance.getTimeChaos());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AwsChaosNested<A> editAwsChaos() {
    return this.withNewAwsChaosLike(Optional.ofNullable(this.buildAwsChaos()).orElse(null));
  }
  
  public AzureChaosNested<A> editAzureChaos() {
    return this.withNewAzureChaosLike(Optional.ofNullable(this.buildAzureChaos()).orElse(null));
  }
  
  public BlockChaosNested<A> editBlockChaos() {
    return this.withNewBlockChaosLike(Optional.ofNullable(this.buildBlockChaos()).orElse(null));
  }
  
  public DnsChaosNested<A> editDnsChaos() {
    return this.withNewDnsChaosLike(Optional.ofNullable(this.buildDnsChaos()).orElse(null));
  }
  
  public GcpChaosNested<A> editGcpChaos() {
    return this.withNewGcpChaosLike(Optional.ofNullable(this.buildGcpChaos()).orElse(null));
  }
  
  public HttpChaosNested<A> editHttpChaos() {
    return this.withNewHttpChaosLike(Optional.ofNullable(this.buildHttpChaos()).orElse(null));
  }
  
  public IoChaosNested<A> editIoChaos() {
    return this.withNewIoChaosLike(Optional.ofNullable(this.buildIoChaos()).orElse(null));
  }
  
  public JvmChaosNested<A> editJvmChaos() {
    return this.withNewJvmChaosLike(Optional.ofNullable(this.buildJvmChaos()).orElse(null));
  }
  
  public KernelChaosNested<A> editKernelChaos() {
    return this.withNewKernelChaosLike(Optional.ofNullable(this.buildKernelChaos()).orElse(null));
  }
  
  public NetworkChaosNested<A> editNetworkChaos() {
    return this.withNewNetworkChaosLike(Optional.ofNullable(this.buildNetworkChaos()).orElse(null));
  }
  
  public AwsChaosNested<A> editOrNewAwsChaos() {
    return this.withNewAwsChaosLike(Optional.ofNullable(this.buildAwsChaos()).orElse(new AWSChaosSpecBuilder().build()));
  }
  
  public AwsChaosNested<A> editOrNewAwsChaosLike(AWSChaosSpec item) {
    return this.withNewAwsChaosLike(Optional.ofNullable(this.buildAwsChaos()).orElse(item));
  }
  
  public AzureChaosNested<A> editOrNewAzureChaos() {
    return this.withNewAzureChaosLike(Optional.ofNullable(this.buildAzureChaos()).orElse(new AzureChaosSpecBuilder().build()));
  }
  
  public AzureChaosNested<A> editOrNewAzureChaosLike(AzureChaosSpec item) {
    return this.withNewAzureChaosLike(Optional.ofNullable(this.buildAzureChaos()).orElse(item));
  }
  
  public BlockChaosNested<A> editOrNewBlockChaos() {
    return this.withNewBlockChaosLike(Optional.ofNullable(this.buildBlockChaos()).orElse(new BlockChaosSpecBuilder().build()));
  }
  
  public BlockChaosNested<A> editOrNewBlockChaosLike(BlockChaosSpec item) {
    return this.withNewBlockChaosLike(Optional.ofNullable(this.buildBlockChaos()).orElse(item));
  }
  
  public DnsChaosNested<A> editOrNewDnsChaos() {
    return this.withNewDnsChaosLike(Optional.ofNullable(this.buildDnsChaos()).orElse(new DNSChaosSpecBuilder().build()));
  }
  
  public DnsChaosNested<A> editOrNewDnsChaosLike(DNSChaosSpec item) {
    return this.withNewDnsChaosLike(Optional.ofNullable(this.buildDnsChaos()).orElse(item));
  }
  
  public GcpChaosNested<A> editOrNewGcpChaos() {
    return this.withNewGcpChaosLike(Optional.ofNullable(this.buildGcpChaos()).orElse(new GCPChaosSpecBuilder().build()));
  }
  
  public GcpChaosNested<A> editOrNewGcpChaosLike(GCPChaosSpec item) {
    return this.withNewGcpChaosLike(Optional.ofNullable(this.buildGcpChaos()).orElse(item));
  }
  
  public HttpChaosNested<A> editOrNewHttpChaos() {
    return this.withNewHttpChaosLike(Optional.ofNullable(this.buildHttpChaos()).orElse(new HTTPChaosSpecBuilder().build()));
  }
  
  public HttpChaosNested<A> editOrNewHttpChaosLike(HTTPChaosSpec item) {
    return this.withNewHttpChaosLike(Optional.ofNullable(this.buildHttpChaos()).orElse(item));
  }
  
  public IoChaosNested<A> editOrNewIoChaos() {
    return this.withNewIoChaosLike(Optional.ofNullable(this.buildIoChaos()).orElse(new IOChaosSpecBuilder().build()));
  }
  
  public IoChaosNested<A> editOrNewIoChaosLike(IOChaosSpec item) {
    return this.withNewIoChaosLike(Optional.ofNullable(this.buildIoChaos()).orElse(item));
  }
  
  public JvmChaosNested<A> editOrNewJvmChaos() {
    return this.withNewJvmChaosLike(Optional.ofNullable(this.buildJvmChaos()).orElse(new JVMChaosSpecBuilder().build()));
  }
  
  public JvmChaosNested<A> editOrNewJvmChaosLike(JVMChaosSpec item) {
    return this.withNewJvmChaosLike(Optional.ofNullable(this.buildJvmChaos()).orElse(item));
  }
  
  public KernelChaosNested<A> editOrNewKernelChaos() {
    return this.withNewKernelChaosLike(Optional.ofNullable(this.buildKernelChaos()).orElse(new KernelChaosSpecBuilder().build()));
  }
  
  public KernelChaosNested<A> editOrNewKernelChaosLike(KernelChaosSpec item) {
    return this.withNewKernelChaosLike(Optional.ofNullable(this.buildKernelChaos()).orElse(item));
  }
  
  public NetworkChaosNested<A> editOrNewNetworkChaos() {
    return this.withNewNetworkChaosLike(Optional.ofNullable(this.buildNetworkChaos()).orElse(new NetworkChaosSpecBuilder().build()));
  }
  
  public NetworkChaosNested<A> editOrNewNetworkChaosLike(NetworkChaosSpec item) {
    return this.withNewNetworkChaosLike(Optional.ofNullable(this.buildNetworkChaos()).orElse(item));
  }
  
  public PhysicalmachineChaosNested<A> editOrNewPhysicalmachineChaos() {
    return this.withNewPhysicalmachineChaosLike(Optional.ofNullable(this.buildPhysicalmachineChaos()).orElse(new PhysicalMachineChaosSpecBuilder().build()));
  }
  
  public PhysicalmachineChaosNested<A> editOrNewPhysicalmachineChaosLike(PhysicalMachineChaosSpec item) {
    return this.withNewPhysicalmachineChaosLike(Optional.ofNullable(this.buildPhysicalmachineChaos()).orElse(item));
  }
  
  public PodChaosNested<A> editOrNewPodChaos() {
    return this.withNewPodChaosLike(Optional.ofNullable(this.buildPodChaos()).orElse(new PodChaosSpecBuilder().build()));
  }
  
  public PodChaosNested<A> editOrNewPodChaosLike(PodChaosSpec item) {
    return this.withNewPodChaosLike(Optional.ofNullable(this.buildPodChaos()).orElse(item));
  }
  
  public StressChaosNested<A> editOrNewStressChaos() {
    return this.withNewStressChaosLike(Optional.ofNullable(this.buildStressChaos()).orElse(new StressChaosSpecBuilder().build()));
  }
  
  public StressChaosNested<A> editOrNewStressChaosLike(StressChaosSpec item) {
    return this.withNewStressChaosLike(Optional.ofNullable(this.buildStressChaos()).orElse(item));
  }
  
  public TimeChaosNested<A> editOrNewTimeChaos() {
    return this.withNewTimeChaosLike(Optional.ofNullable(this.buildTimeChaos()).orElse(new TimeChaosSpecBuilder().build()));
  }
  
  public TimeChaosNested<A> editOrNewTimeChaosLike(TimeChaosSpec item) {
    return this.withNewTimeChaosLike(Optional.ofNullable(this.buildTimeChaos()).orElse(item));
  }
  
  public PhysicalmachineChaosNested<A> editPhysicalmachineChaos() {
    return this.withNewPhysicalmachineChaosLike(Optional.ofNullable(this.buildPhysicalmachineChaos()).orElse(null));
  }
  
  public PodChaosNested<A> editPodChaos() {
    return this.withNewPodChaosLike(Optional.ofNullable(this.buildPodChaos()).orElse(null));
  }
  
  public StressChaosNested<A> editStressChaos() {
    return this.withNewStressChaosLike(Optional.ofNullable(this.buildStressChaos()).orElse(null));
  }
  
  public TimeChaosNested<A> editTimeChaos() {
    return this.withNewTimeChaosLike(Optional.ofNullable(this.buildTimeChaos()).orElse(null));
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
    EmbedChaosFluent that = (EmbedChaosFluent) o;
    if (!(Objects.equals(awsChaos, that.awsChaos))) {
      return false;
    }
    if (!(Objects.equals(azureChaos, that.azureChaos))) {
      return false;
    }
    if (!(Objects.equals(blockChaos, that.blockChaos))) {
      return false;
    }
    if (!(Objects.equals(dnsChaos, that.dnsChaos))) {
      return false;
    }
    if (!(Objects.equals(gcpChaos, that.gcpChaos))) {
      return false;
    }
    if (!(Objects.equals(httpChaos, that.httpChaos))) {
      return false;
    }
    if (!(Objects.equals(ioChaos, that.ioChaos))) {
      return false;
    }
    if (!(Objects.equals(jvmChaos, that.jvmChaos))) {
      return false;
    }
    if (!(Objects.equals(kernelChaos, that.kernelChaos))) {
      return false;
    }
    if (!(Objects.equals(networkChaos, that.networkChaos))) {
      return false;
    }
    if (!(Objects.equals(physicalmachineChaos, that.physicalmachineChaos))) {
      return false;
    }
    if (!(Objects.equals(podChaos, that.podChaos))) {
      return false;
    }
    if (!(Objects.equals(stressChaos, that.stressChaos))) {
      return false;
    }
    if (!(Objects.equals(timeChaos, that.timeChaos))) {
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
  
  public boolean hasAwsChaos() {
    return this.awsChaos != null;
  }
  
  public boolean hasAzureChaos() {
    return this.azureChaos != null;
  }
  
  public boolean hasBlockChaos() {
    return this.blockChaos != null;
  }
  
  public boolean hasDnsChaos() {
    return this.dnsChaos != null;
  }
  
  public boolean hasGcpChaos() {
    return this.gcpChaos != null;
  }
  
  public boolean hasHttpChaos() {
    return this.httpChaos != null;
  }
  
  public boolean hasIoChaos() {
    return this.ioChaos != null;
  }
  
  public boolean hasJvmChaos() {
    return this.jvmChaos != null;
  }
  
  public boolean hasKernelChaos() {
    return this.kernelChaos != null;
  }
  
  public boolean hasNetworkChaos() {
    return this.networkChaos != null;
  }
  
  public boolean hasPhysicalmachineChaos() {
    return this.physicalmachineChaos != null;
  }
  
  public boolean hasPodChaos() {
    return this.podChaos != null;
  }
  
  public boolean hasStressChaos() {
    return this.stressChaos != null;
  }
  
  public boolean hasTimeChaos() {
    return this.timeChaos != null;
  }
  
  public int hashCode() {
    return Objects.hash(awsChaos, azureChaos, blockChaos, dnsChaos, gcpChaos, httpChaos, ioChaos, jvmChaos, kernelChaos, networkChaos, physicalmachineChaos, podChaos, stressChaos, timeChaos, additionalProperties);
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
    if (!(awsChaos == null)) {
        sb.append("awsChaos:");
        sb.append(awsChaos);
        sb.append(",");
    }
    if (!(azureChaos == null)) {
        sb.append("azureChaos:");
        sb.append(azureChaos);
        sb.append(",");
    }
    if (!(blockChaos == null)) {
        sb.append("blockChaos:");
        sb.append(blockChaos);
        sb.append(",");
    }
    if (!(dnsChaos == null)) {
        sb.append("dnsChaos:");
        sb.append(dnsChaos);
        sb.append(",");
    }
    if (!(gcpChaos == null)) {
        sb.append("gcpChaos:");
        sb.append(gcpChaos);
        sb.append(",");
    }
    if (!(httpChaos == null)) {
        sb.append("httpChaos:");
        sb.append(httpChaos);
        sb.append(",");
    }
    if (!(ioChaos == null)) {
        sb.append("ioChaos:");
        sb.append(ioChaos);
        sb.append(",");
    }
    if (!(jvmChaos == null)) {
        sb.append("jvmChaos:");
        sb.append(jvmChaos);
        sb.append(",");
    }
    if (!(kernelChaos == null)) {
        sb.append("kernelChaos:");
        sb.append(kernelChaos);
        sb.append(",");
    }
    if (!(networkChaos == null)) {
        sb.append("networkChaos:");
        sb.append(networkChaos);
        sb.append(",");
    }
    if (!(physicalmachineChaos == null)) {
        sb.append("physicalmachineChaos:");
        sb.append(physicalmachineChaos);
        sb.append(",");
    }
    if (!(podChaos == null)) {
        sb.append("podChaos:");
        sb.append(podChaos);
        sb.append(",");
    }
    if (!(stressChaos == null)) {
        sb.append("stressChaos:");
        sb.append(stressChaos);
        sb.append(",");
    }
    if (!(timeChaos == null)) {
        sb.append("timeChaos:");
        sb.append(timeChaos);
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
  
  public A withAwsChaos(AWSChaosSpec awsChaos) {
    this._visitables.remove("awsChaos");
    if (awsChaos != null) {
        this.awsChaos = new AWSChaosSpecBuilder(awsChaos);
        this._visitables.get("awsChaos").add(this.awsChaos);
    } else {
        this.awsChaos = null;
        this._visitables.get("awsChaos").remove(this.awsChaos);
    }
    return (A) this;
  }
  
  public A withAzureChaos(AzureChaosSpec azureChaos) {
    this._visitables.remove("azureChaos");
    if (azureChaos != null) {
        this.azureChaos = new AzureChaosSpecBuilder(azureChaos);
        this._visitables.get("azureChaos").add(this.azureChaos);
    } else {
        this.azureChaos = null;
        this._visitables.get("azureChaos").remove(this.azureChaos);
    }
    return (A) this;
  }
  
  public A withBlockChaos(BlockChaosSpec blockChaos) {
    this._visitables.remove("blockChaos");
    if (blockChaos != null) {
        this.blockChaos = new BlockChaosSpecBuilder(blockChaos);
        this._visitables.get("blockChaos").add(this.blockChaos);
    } else {
        this.blockChaos = null;
        this._visitables.get("blockChaos").remove(this.blockChaos);
    }
    return (A) this;
  }
  
  public A withDnsChaos(DNSChaosSpec dnsChaos) {
    this._visitables.remove("dnsChaos");
    if (dnsChaos != null) {
        this.dnsChaos = new DNSChaosSpecBuilder(dnsChaos);
        this._visitables.get("dnsChaos").add(this.dnsChaos);
    } else {
        this.dnsChaos = null;
        this._visitables.get("dnsChaos").remove(this.dnsChaos);
    }
    return (A) this;
  }
  
  public A withGcpChaos(GCPChaosSpec gcpChaos) {
    this._visitables.remove("gcpChaos");
    if (gcpChaos != null) {
        this.gcpChaos = new GCPChaosSpecBuilder(gcpChaos);
        this._visitables.get("gcpChaos").add(this.gcpChaos);
    } else {
        this.gcpChaos = null;
        this._visitables.get("gcpChaos").remove(this.gcpChaos);
    }
    return (A) this;
  }
  
  public A withHttpChaos(HTTPChaosSpec httpChaos) {
    this._visitables.remove("httpChaos");
    if (httpChaos != null) {
        this.httpChaos = new HTTPChaosSpecBuilder(httpChaos);
        this._visitables.get("httpChaos").add(this.httpChaos);
    } else {
        this.httpChaos = null;
        this._visitables.get("httpChaos").remove(this.httpChaos);
    }
    return (A) this;
  }
  
  public A withIoChaos(IOChaosSpec ioChaos) {
    this._visitables.remove("ioChaos");
    if (ioChaos != null) {
        this.ioChaos = new IOChaosSpecBuilder(ioChaos);
        this._visitables.get("ioChaos").add(this.ioChaos);
    } else {
        this.ioChaos = null;
        this._visitables.get("ioChaos").remove(this.ioChaos);
    }
    return (A) this;
  }
  
  public A withJvmChaos(JVMChaosSpec jvmChaos) {
    this._visitables.remove("jvmChaos");
    if (jvmChaos != null) {
        this.jvmChaos = new JVMChaosSpecBuilder(jvmChaos);
        this._visitables.get("jvmChaos").add(this.jvmChaos);
    } else {
        this.jvmChaos = null;
        this._visitables.get("jvmChaos").remove(this.jvmChaos);
    }
    return (A) this;
  }
  
  public A withKernelChaos(KernelChaosSpec kernelChaos) {
    this._visitables.remove("kernelChaos");
    if (kernelChaos != null) {
        this.kernelChaos = new KernelChaosSpecBuilder(kernelChaos);
        this._visitables.get("kernelChaos").add(this.kernelChaos);
    } else {
        this.kernelChaos = null;
        this._visitables.get("kernelChaos").remove(this.kernelChaos);
    }
    return (A) this;
  }
  
  public A withNetworkChaos(NetworkChaosSpec networkChaos) {
    this._visitables.remove("networkChaos");
    if (networkChaos != null) {
        this.networkChaos = new NetworkChaosSpecBuilder(networkChaos);
        this._visitables.get("networkChaos").add(this.networkChaos);
    } else {
        this.networkChaos = null;
        this._visitables.get("networkChaos").remove(this.networkChaos);
    }
    return (A) this;
  }
  
  public AwsChaosNested<A> withNewAwsChaos() {
    return new AwsChaosNested(null);
  }
  
  public AwsChaosNested<A> withNewAwsChaosLike(AWSChaosSpec item) {
    return new AwsChaosNested(item);
  }
  
  public AzureChaosNested<A> withNewAzureChaos() {
    return new AzureChaosNested(null);
  }
  
  public AzureChaosNested<A> withNewAzureChaosLike(AzureChaosSpec item) {
    return new AzureChaosNested(item);
  }
  
  public BlockChaosNested<A> withNewBlockChaos() {
    return new BlockChaosNested(null);
  }
  
  public BlockChaosNested<A> withNewBlockChaosLike(BlockChaosSpec item) {
    return new BlockChaosNested(item);
  }
  
  public DnsChaosNested<A> withNewDnsChaos() {
    return new DnsChaosNested(null);
  }
  
  public DnsChaosNested<A> withNewDnsChaosLike(DNSChaosSpec item) {
    return new DnsChaosNested(item);
  }
  
  public GcpChaosNested<A> withNewGcpChaos() {
    return new GcpChaosNested(null);
  }
  
  public GcpChaosNested<A> withNewGcpChaosLike(GCPChaosSpec item) {
    return new GcpChaosNested(item);
  }
  
  public HttpChaosNested<A> withNewHttpChaos() {
    return new HttpChaosNested(null);
  }
  
  public HttpChaosNested<A> withNewHttpChaosLike(HTTPChaosSpec item) {
    return new HttpChaosNested(item);
  }
  
  public IoChaosNested<A> withNewIoChaos() {
    return new IoChaosNested(null);
  }
  
  public IoChaosNested<A> withNewIoChaosLike(IOChaosSpec item) {
    return new IoChaosNested(item);
  }
  
  public JvmChaosNested<A> withNewJvmChaos() {
    return new JvmChaosNested(null);
  }
  
  public JvmChaosNested<A> withNewJvmChaosLike(JVMChaosSpec item) {
    return new JvmChaosNested(item);
  }
  
  public KernelChaosNested<A> withNewKernelChaos() {
    return new KernelChaosNested(null);
  }
  
  public KernelChaosNested<A> withNewKernelChaosLike(KernelChaosSpec item) {
    return new KernelChaosNested(item);
  }
  
  public NetworkChaosNested<A> withNewNetworkChaos() {
    return new NetworkChaosNested(null);
  }
  
  public NetworkChaosNested<A> withNewNetworkChaosLike(NetworkChaosSpec item) {
    return new NetworkChaosNested(item);
  }
  
  public PhysicalmachineChaosNested<A> withNewPhysicalmachineChaos() {
    return new PhysicalmachineChaosNested(null);
  }
  
  public PhysicalmachineChaosNested<A> withNewPhysicalmachineChaosLike(PhysicalMachineChaosSpec item) {
    return new PhysicalmachineChaosNested(item);
  }
  
  public PodChaosNested<A> withNewPodChaos() {
    return new PodChaosNested(null);
  }
  
  public PodChaosNested<A> withNewPodChaosLike(PodChaosSpec item) {
    return new PodChaosNested(item);
  }
  
  public StressChaosNested<A> withNewStressChaos() {
    return new StressChaosNested(null);
  }
  
  public StressChaosNested<A> withNewStressChaosLike(StressChaosSpec item) {
    return new StressChaosNested(item);
  }
  
  public TimeChaosNested<A> withNewTimeChaos() {
    return new TimeChaosNested(null);
  }
  
  public TimeChaosNested<A> withNewTimeChaosLike(TimeChaosSpec item) {
    return new TimeChaosNested(item);
  }
  
  public A withPhysicalmachineChaos(PhysicalMachineChaosSpec physicalmachineChaos) {
    this._visitables.remove("physicalmachineChaos");
    if (physicalmachineChaos != null) {
        this.physicalmachineChaos = new PhysicalMachineChaosSpecBuilder(physicalmachineChaos);
        this._visitables.get("physicalmachineChaos").add(this.physicalmachineChaos);
    } else {
        this.physicalmachineChaos = null;
        this._visitables.get("physicalmachineChaos").remove(this.physicalmachineChaos);
    }
    return (A) this;
  }
  
  public A withPodChaos(PodChaosSpec podChaos) {
    this._visitables.remove("podChaos");
    if (podChaos != null) {
        this.podChaos = new PodChaosSpecBuilder(podChaos);
        this._visitables.get("podChaos").add(this.podChaos);
    } else {
        this.podChaos = null;
        this._visitables.get("podChaos").remove(this.podChaos);
    }
    return (A) this;
  }
  
  public A withStressChaos(StressChaosSpec stressChaos) {
    this._visitables.remove("stressChaos");
    if (stressChaos != null) {
        this.stressChaos = new StressChaosSpecBuilder(stressChaos);
        this._visitables.get("stressChaos").add(this.stressChaos);
    } else {
        this.stressChaos = null;
        this._visitables.get("stressChaos").remove(this.stressChaos);
    }
    return (A) this;
  }
  
  public A withTimeChaos(TimeChaosSpec timeChaos) {
    this._visitables.remove("timeChaos");
    if (timeChaos != null) {
        this.timeChaos = new TimeChaosSpecBuilder(timeChaos);
        this._visitables.get("timeChaos").add(this.timeChaos);
    } else {
        this.timeChaos = null;
        this._visitables.get("timeChaos").remove(this.timeChaos);
    }
    return (A) this;
  }
  public class AwsChaosNested<N> extends AWSChaosSpecFluent<AwsChaosNested<N>> implements Nested<N>{
  
    AWSChaosSpecBuilder builder;
  
    AwsChaosNested(AWSChaosSpec item) {
      this.builder = new AWSChaosSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) EmbedChaosFluent.this.withAwsChaos(builder.build());
    }
    
    public N endAwsChaos() {
      return and();
    }
    
  }
  public class AzureChaosNested<N> extends AzureChaosSpecFluent<AzureChaosNested<N>> implements Nested<N>{
  
    AzureChaosSpecBuilder builder;
  
    AzureChaosNested(AzureChaosSpec item) {
      this.builder = new AzureChaosSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) EmbedChaosFluent.this.withAzureChaos(builder.build());
    }
    
    public N endAzureChaos() {
      return and();
    }
    
  }
  public class BlockChaosNested<N> extends BlockChaosSpecFluent<BlockChaosNested<N>> implements Nested<N>{
  
    BlockChaosSpecBuilder builder;
  
    BlockChaosNested(BlockChaosSpec item) {
      this.builder = new BlockChaosSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) EmbedChaosFluent.this.withBlockChaos(builder.build());
    }
    
    public N endBlockChaos() {
      return and();
    }
    
  }
  public class DnsChaosNested<N> extends DNSChaosSpecFluent<DnsChaosNested<N>> implements Nested<N>{
  
    DNSChaosSpecBuilder builder;
  
    DnsChaosNested(DNSChaosSpec item) {
      this.builder = new DNSChaosSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) EmbedChaosFluent.this.withDnsChaos(builder.build());
    }
    
    public N endDnsChaos() {
      return and();
    }
    
  }
  public class GcpChaosNested<N> extends GCPChaosSpecFluent<GcpChaosNested<N>> implements Nested<N>{
  
    GCPChaosSpecBuilder builder;
  
    GcpChaosNested(GCPChaosSpec item) {
      this.builder = new GCPChaosSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) EmbedChaosFluent.this.withGcpChaos(builder.build());
    }
    
    public N endGcpChaos() {
      return and();
    }
    
  }
  public class HttpChaosNested<N> extends HTTPChaosSpecFluent<HttpChaosNested<N>> implements Nested<N>{
  
    HTTPChaosSpecBuilder builder;
  
    HttpChaosNested(HTTPChaosSpec item) {
      this.builder = new HTTPChaosSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) EmbedChaosFluent.this.withHttpChaos(builder.build());
    }
    
    public N endHttpChaos() {
      return and();
    }
    
  }
  public class IoChaosNested<N> extends IOChaosSpecFluent<IoChaosNested<N>> implements Nested<N>{
  
    IOChaosSpecBuilder builder;
  
    IoChaosNested(IOChaosSpec item) {
      this.builder = new IOChaosSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) EmbedChaosFluent.this.withIoChaos(builder.build());
    }
    
    public N endIoChaos() {
      return and();
    }
    
  }
  public class JvmChaosNested<N> extends JVMChaosSpecFluent<JvmChaosNested<N>> implements Nested<N>{
  
    JVMChaosSpecBuilder builder;
  
    JvmChaosNested(JVMChaosSpec item) {
      this.builder = new JVMChaosSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) EmbedChaosFluent.this.withJvmChaos(builder.build());
    }
    
    public N endJvmChaos() {
      return and();
    }
    
  }
  public class KernelChaosNested<N> extends KernelChaosSpecFluent<KernelChaosNested<N>> implements Nested<N>{
  
    KernelChaosSpecBuilder builder;
  
    KernelChaosNested(KernelChaosSpec item) {
      this.builder = new KernelChaosSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) EmbedChaosFluent.this.withKernelChaos(builder.build());
    }
    
    public N endKernelChaos() {
      return and();
    }
    
  }
  public class NetworkChaosNested<N> extends NetworkChaosSpecFluent<NetworkChaosNested<N>> implements Nested<N>{
  
    NetworkChaosSpecBuilder builder;
  
    NetworkChaosNested(NetworkChaosSpec item) {
      this.builder = new NetworkChaosSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) EmbedChaosFluent.this.withNetworkChaos(builder.build());
    }
    
    public N endNetworkChaos() {
      return and();
    }
    
  }
  public class PhysicalmachineChaosNested<N> extends PhysicalMachineChaosSpecFluent<PhysicalmachineChaosNested<N>> implements Nested<N>{
  
    PhysicalMachineChaosSpecBuilder builder;
  
    PhysicalmachineChaosNested(PhysicalMachineChaosSpec item) {
      this.builder = new PhysicalMachineChaosSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) EmbedChaosFluent.this.withPhysicalmachineChaos(builder.build());
    }
    
    public N endPhysicalmachineChaos() {
      return and();
    }
    
  }
  public class PodChaosNested<N> extends PodChaosSpecFluent<PodChaosNested<N>> implements Nested<N>{
  
    PodChaosSpecBuilder builder;
  
    PodChaosNested(PodChaosSpec item) {
      this.builder = new PodChaosSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) EmbedChaosFluent.this.withPodChaos(builder.build());
    }
    
    public N endPodChaos() {
      return and();
    }
    
  }
  public class StressChaosNested<N> extends StressChaosSpecFluent<StressChaosNested<N>> implements Nested<N>{
  
    StressChaosSpecBuilder builder;
  
    StressChaosNested(StressChaosSpec item) {
      this.builder = new StressChaosSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) EmbedChaosFluent.this.withStressChaos(builder.build());
    }
    
    public N endStressChaos() {
      return and();
    }
    
  }
  public class TimeChaosNested<N> extends TimeChaosSpecFluent<TimeChaosNested<N>> implements Nested<N>{
  
    TimeChaosSpecBuilder builder;
  
    TimeChaosNested(TimeChaosSpec item) {
      this.builder = new TimeChaosSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) EmbedChaosFluent.this.withTimeChaos(builder.build());
    }
    
    public N endTimeChaos() {
      return and();
    }
    
  }
}