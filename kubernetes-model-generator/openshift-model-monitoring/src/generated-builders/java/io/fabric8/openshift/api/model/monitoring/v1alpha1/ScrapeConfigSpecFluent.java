package io.fabric8.openshift.api.model.monitoring.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.Quantity;
import io.fabric8.kubernetes.api.model.SecretKeySelector;
import io.fabric8.openshift.api.model.monitoring.v1.BasicAuth;
import io.fabric8.openshift.api.model.monitoring.v1.BasicAuthBuilder;
import io.fabric8.openshift.api.model.monitoring.v1.BasicAuthFluent;
import io.fabric8.openshift.api.model.monitoring.v1.OAuth2;
import io.fabric8.openshift.api.model.monitoring.v1.OAuth2Builder;
import io.fabric8.openshift.api.model.monitoring.v1.OAuth2Fluent;
import io.fabric8.openshift.api.model.monitoring.v1.RelabelConfig;
import io.fabric8.openshift.api.model.monitoring.v1.RelabelConfigBuilder;
import io.fabric8.openshift.api.model.monitoring.v1.RelabelConfigFluent;
import io.fabric8.openshift.api.model.monitoring.v1.SafeAuthorization;
import io.fabric8.openshift.api.model.monitoring.v1.SafeAuthorizationBuilder;
import io.fabric8.openshift.api.model.monitoring.v1.SafeAuthorizationFluent;
import io.fabric8.openshift.api.model.monitoring.v1.SafeTLSConfig;
import io.fabric8.openshift.api.model.monitoring.v1.SafeTLSConfigBuilder;
import io.fabric8.openshift.api.model.monitoring.v1.SafeTLSConfigFluent;
import java.lang.Boolean;
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
public class ScrapeConfigSpecFluent<A extends io.fabric8.openshift.api.model.monitoring.v1alpha1.ScrapeConfigSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private SafeAuthorizationBuilder authorization;
  private ArrayList<AzureSDConfigBuilder> azureSDConfigs = new ArrayList<AzureSDConfigBuilder>();
  private BasicAuthBuilder basicAuth;
  private String bodySizeLimit;
  private ArrayList<ConsulSDConfigBuilder> consulSDConfigs = new ArrayList<ConsulSDConfigBuilder>();
  private Boolean convertClassicHistogramsToNHCB;
  private ArrayList<DigitalOceanSDConfigBuilder> digitalOceanSDConfigs = new ArrayList<DigitalOceanSDConfigBuilder>();
  private ArrayList<DNSSDConfigBuilder> dnsSDConfigs = new ArrayList<DNSSDConfigBuilder>();
  private ArrayList<DockerSDConfigBuilder> dockerSDConfigs = new ArrayList<DockerSDConfigBuilder>();
  private ArrayList<DockerSwarmSDConfigBuilder> dockerSwarmSDConfigs = new ArrayList<DockerSwarmSDConfigBuilder>();
  private ArrayList<EC2SDConfigBuilder> ec2SDConfigs = new ArrayList<EC2SDConfigBuilder>();
  private Boolean enableCompression;
  private Boolean enableHTTP2;
  private ArrayList<EurekaSDConfigBuilder> eurekaSDConfigs = new ArrayList<EurekaSDConfigBuilder>();
  private String fallbackScrapeProtocol;
  private ArrayList<FileSDConfigBuilder> fileSDConfigs = new ArrayList<FileSDConfigBuilder>();
  private ArrayList<GCESDConfigBuilder> gceSDConfigs = new ArrayList<GCESDConfigBuilder>();
  private ArrayList<HetznerSDConfigBuilder> hetznerSDConfigs = new ArrayList<HetznerSDConfigBuilder>();
  private Boolean honorLabels;
  private Boolean honorTimestamps;
  private ArrayList<HTTPSDConfigBuilder> httpSDConfigs = new ArrayList<HTTPSDConfigBuilder>();
  private ArrayList<IonosSDConfigBuilder> ionosSDConfigs = new ArrayList<IonosSDConfigBuilder>();
  private String jobName;
  private Long keepDroppedTargets;
  private ArrayList<KubernetesSDConfigBuilder> kubernetesSDConfigs = new ArrayList<KubernetesSDConfigBuilder>();
  private ArrayList<KumaSDConfigBuilder> kumaSDConfigs = new ArrayList<KumaSDConfigBuilder>();
  private Long labelLimit;
  private Long labelNameLengthLimit;
  private Long labelValueLengthLimit;
  private ArrayList<LightSailSDConfigBuilder> lightSailSDConfigs = new ArrayList<LightSailSDConfigBuilder>();
  private ArrayList<LinodeSDConfigBuilder> linodeSDConfigs = new ArrayList<LinodeSDConfigBuilder>();
  private ArrayList<RelabelConfigBuilder> metricRelabelings = new ArrayList<RelabelConfigBuilder>();
  private String metricsPath;
  private String nameEscapingScheme;
  private String nameValidationScheme;
  private Long nativeHistogramBucketLimit;
  private Quantity nativeHistogramMinBucketFactor;
  private String noProxy;
  private ArrayList<NomadSDConfigBuilder> nomadSDConfigs = new ArrayList<NomadSDConfigBuilder>();
  private OAuth2Builder oauth2;
  private ArrayList<OpenStackSDConfigBuilder> openstackSDConfigs = new ArrayList<OpenStackSDConfigBuilder>();
  private ArrayList<OVHCloudSDConfigBuilder> ovhcloudSDConfigs = new ArrayList<OVHCloudSDConfigBuilder>();
  private Map<String,List<String>> params;
  private Map<String,List<SecretKeySelector>> proxyConnectHeader;
  private Boolean proxyFromEnvironment;
  private String proxyUrl;
  private ArrayList<PuppetDBSDConfigBuilder> puppetDBSDConfigs = new ArrayList<PuppetDBSDConfigBuilder>();
  private ArrayList<RelabelConfigBuilder> relabelings = new ArrayList<RelabelConfigBuilder>();
  private Long sampleLimit;
  private ArrayList<ScalewaySDConfigBuilder> scalewaySDConfigs = new ArrayList<ScalewaySDConfigBuilder>();
  private String scheme;
  private String scrapeClass;
  private Boolean scrapeClassicHistograms;
  private String scrapeInterval;
  private Boolean scrapeNativeHistograms;
  private List<String> scrapeProtocols = new ArrayList<String>();
  private String scrapeTimeout;
  private ArrayList<StaticConfigBuilder> staticConfigs = new ArrayList<StaticConfigBuilder>();
  private Long targetLimit;
  private SafeTLSConfigBuilder tlsConfig;
  private Boolean trackTimestampsStaleness;

  public ScrapeConfigSpecFluent() {
  }
  
  public ScrapeConfigSpecFluent(ScrapeConfigSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToAzureSDConfigs(Collection<AzureSDConfig> items) {
    if (this.azureSDConfigs == null) {
      this.azureSDConfigs = new ArrayList();
    }
    for (AzureSDConfig item : items) {
        AzureSDConfigBuilder builder = new AzureSDConfigBuilder(item);
        _visitables.get("azureSDConfigs").add(builder);
        this.azureSDConfigs.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToConsulSDConfigs(Collection<ConsulSDConfig> items) {
    if (this.consulSDConfigs == null) {
      this.consulSDConfigs = new ArrayList();
    }
    for (ConsulSDConfig item : items) {
        ConsulSDConfigBuilder builder = new ConsulSDConfigBuilder(item);
        _visitables.get("consulSDConfigs").add(builder);
        this.consulSDConfigs.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToDigitalOceanSDConfigs(Collection<DigitalOceanSDConfig> items) {
    if (this.digitalOceanSDConfigs == null) {
      this.digitalOceanSDConfigs = new ArrayList();
    }
    for (DigitalOceanSDConfig item : items) {
        DigitalOceanSDConfigBuilder builder = new DigitalOceanSDConfigBuilder(item);
        _visitables.get("digitalOceanSDConfigs").add(builder);
        this.digitalOceanSDConfigs.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToDnsSDConfigs(Collection<DNSSDConfig> items) {
    if (this.dnsSDConfigs == null) {
      this.dnsSDConfigs = new ArrayList();
    }
    for (DNSSDConfig item : items) {
        DNSSDConfigBuilder builder = new DNSSDConfigBuilder(item);
        _visitables.get("dnsSDConfigs").add(builder);
        this.dnsSDConfigs.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToDockerSDConfigs(Collection<DockerSDConfig> items) {
    if (this.dockerSDConfigs == null) {
      this.dockerSDConfigs = new ArrayList();
    }
    for (DockerSDConfig item : items) {
        DockerSDConfigBuilder builder = new DockerSDConfigBuilder(item);
        _visitables.get("dockerSDConfigs").add(builder);
        this.dockerSDConfigs.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToDockerSwarmSDConfigs(Collection<DockerSwarmSDConfig> items) {
    if (this.dockerSwarmSDConfigs == null) {
      this.dockerSwarmSDConfigs = new ArrayList();
    }
    for (DockerSwarmSDConfig item : items) {
        DockerSwarmSDConfigBuilder builder = new DockerSwarmSDConfigBuilder(item);
        _visitables.get("dockerSwarmSDConfigs").add(builder);
        this.dockerSwarmSDConfigs.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToEc2SDConfigs(Collection<EC2SDConfig> items) {
    if (this.ec2SDConfigs == null) {
      this.ec2SDConfigs = new ArrayList();
    }
    for (EC2SDConfig item : items) {
        EC2SDConfigBuilder builder = new EC2SDConfigBuilder(item);
        _visitables.get("ec2SDConfigs").add(builder);
        this.ec2SDConfigs.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToEurekaSDConfigs(Collection<EurekaSDConfig> items) {
    if (this.eurekaSDConfigs == null) {
      this.eurekaSDConfigs = new ArrayList();
    }
    for (EurekaSDConfig item : items) {
        EurekaSDConfigBuilder builder = new EurekaSDConfigBuilder(item);
        _visitables.get("eurekaSDConfigs").add(builder);
        this.eurekaSDConfigs.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToFileSDConfigs(Collection<FileSDConfig> items) {
    if (this.fileSDConfigs == null) {
      this.fileSDConfigs = new ArrayList();
    }
    for (FileSDConfig item : items) {
        FileSDConfigBuilder builder = new FileSDConfigBuilder(item);
        _visitables.get("fileSDConfigs").add(builder);
        this.fileSDConfigs.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToGceSDConfigs(Collection<GCESDConfig> items) {
    if (this.gceSDConfigs == null) {
      this.gceSDConfigs = new ArrayList();
    }
    for (GCESDConfig item : items) {
        GCESDConfigBuilder builder = new GCESDConfigBuilder(item);
        _visitables.get("gceSDConfigs").add(builder);
        this.gceSDConfigs.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToHetznerSDConfigs(Collection<HetznerSDConfig> items) {
    if (this.hetznerSDConfigs == null) {
      this.hetznerSDConfigs = new ArrayList();
    }
    for (HetznerSDConfig item : items) {
        HetznerSDConfigBuilder builder = new HetznerSDConfigBuilder(item);
        _visitables.get("hetznerSDConfigs").add(builder);
        this.hetznerSDConfigs.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToHttpSDConfigs(Collection<HTTPSDConfig> items) {
    if (this.httpSDConfigs == null) {
      this.httpSDConfigs = new ArrayList();
    }
    for (HTTPSDConfig item : items) {
        HTTPSDConfigBuilder builder = new HTTPSDConfigBuilder(item);
        _visitables.get("httpSDConfigs").add(builder);
        this.httpSDConfigs.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToIonosSDConfigs(Collection<IonosSDConfig> items) {
    if (this.ionosSDConfigs == null) {
      this.ionosSDConfigs = new ArrayList();
    }
    for (IonosSDConfig item : items) {
        IonosSDConfigBuilder builder = new IonosSDConfigBuilder(item);
        _visitables.get("ionosSDConfigs").add(builder);
        this.ionosSDConfigs.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToKubernetesSDConfigs(Collection<KubernetesSDConfig> items) {
    if (this.kubernetesSDConfigs == null) {
      this.kubernetesSDConfigs = new ArrayList();
    }
    for (KubernetesSDConfig item : items) {
        KubernetesSDConfigBuilder builder = new KubernetesSDConfigBuilder(item);
        _visitables.get("kubernetesSDConfigs").add(builder);
        this.kubernetesSDConfigs.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToKumaSDConfigs(Collection<KumaSDConfig> items) {
    if (this.kumaSDConfigs == null) {
      this.kumaSDConfigs = new ArrayList();
    }
    for (KumaSDConfig item : items) {
        KumaSDConfigBuilder builder = new KumaSDConfigBuilder(item);
        _visitables.get("kumaSDConfigs").add(builder);
        this.kumaSDConfigs.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToLightSailSDConfigs(Collection<LightSailSDConfig> items) {
    if (this.lightSailSDConfigs == null) {
      this.lightSailSDConfigs = new ArrayList();
    }
    for (LightSailSDConfig item : items) {
        LightSailSDConfigBuilder builder = new LightSailSDConfigBuilder(item);
        _visitables.get("lightSailSDConfigs").add(builder);
        this.lightSailSDConfigs.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToLinodeSDConfigs(Collection<LinodeSDConfig> items) {
    if (this.linodeSDConfigs == null) {
      this.linodeSDConfigs = new ArrayList();
    }
    for (LinodeSDConfig item : items) {
        LinodeSDConfigBuilder builder = new LinodeSDConfigBuilder(item);
        _visitables.get("linodeSDConfigs").add(builder);
        this.linodeSDConfigs.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToMetricRelabelings(Collection<RelabelConfig> items) {
    if (this.metricRelabelings == null) {
      this.metricRelabelings = new ArrayList();
    }
    for (RelabelConfig item : items) {
        RelabelConfigBuilder builder = new RelabelConfigBuilder(item);
        _visitables.get("metricRelabelings").add(builder);
        this.metricRelabelings.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToNomadSDConfigs(Collection<NomadSDConfig> items) {
    if (this.nomadSDConfigs == null) {
      this.nomadSDConfigs = new ArrayList();
    }
    for (NomadSDConfig item : items) {
        NomadSDConfigBuilder builder = new NomadSDConfigBuilder(item);
        _visitables.get("nomadSDConfigs").add(builder);
        this.nomadSDConfigs.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToOpenstackSDConfigs(Collection<OpenStackSDConfig> items) {
    if (this.openstackSDConfigs == null) {
      this.openstackSDConfigs = new ArrayList();
    }
    for (OpenStackSDConfig item : items) {
        OpenStackSDConfigBuilder builder = new OpenStackSDConfigBuilder(item);
        _visitables.get("openstackSDConfigs").add(builder);
        this.openstackSDConfigs.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToOvhcloudSDConfigs(Collection<OVHCloudSDConfig> items) {
    if (this.ovhcloudSDConfigs == null) {
      this.ovhcloudSDConfigs = new ArrayList();
    }
    for (OVHCloudSDConfig item : items) {
        OVHCloudSDConfigBuilder builder = new OVHCloudSDConfigBuilder(item);
        _visitables.get("ovhcloudSDConfigs").add(builder);
        this.ovhcloudSDConfigs.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToPuppetDBSDConfigs(Collection<PuppetDBSDConfig> items) {
    if (this.puppetDBSDConfigs == null) {
      this.puppetDBSDConfigs = new ArrayList();
    }
    for (PuppetDBSDConfig item : items) {
        PuppetDBSDConfigBuilder builder = new PuppetDBSDConfigBuilder(item);
        _visitables.get("puppetDBSDConfigs").add(builder);
        this.puppetDBSDConfigs.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToRelabelings(Collection<RelabelConfig> items) {
    if (this.relabelings == null) {
      this.relabelings = new ArrayList();
    }
    for (RelabelConfig item : items) {
        RelabelConfigBuilder builder = new RelabelConfigBuilder(item);
        _visitables.get("relabelings").add(builder);
        this.relabelings.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToScalewaySDConfigs(Collection<ScalewaySDConfig> items) {
    if (this.scalewaySDConfigs == null) {
      this.scalewaySDConfigs = new ArrayList();
    }
    for (ScalewaySDConfig item : items) {
        ScalewaySDConfigBuilder builder = new ScalewaySDConfigBuilder(item);
        _visitables.get("scalewaySDConfigs").add(builder);
        this.scalewaySDConfigs.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToScrapeProtocols(Collection<String> items) {
    if (this.scrapeProtocols == null) {
      this.scrapeProtocols = new ArrayList();
    }
    for (String item : items) {
      this.scrapeProtocols.add(item);
    }
    return (A) this;
  }
  
  public A addAllToStaticConfigs(Collection<StaticConfig> items) {
    if (this.staticConfigs == null) {
      this.staticConfigs = new ArrayList();
    }
    for (StaticConfig item : items) {
        StaticConfigBuilder builder = new StaticConfigBuilder(item);
        _visitables.get("staticConfigs").add(builder);
        this.staticConfigs.add(builder);
    }
    return (A) this;
  }
  
  public AzureSDConfigsNested<A> addNewAzureSDConfig() {
    return new AzureSDConfigsNested(-1, null);
  }
  
  public AzureSDConfigsNested<A> addNewAzureSDConfigLike(AzureSDConfig item) {
    return new AzureSDConfigsNested(-1, item);
  }
  
  public ConsulSDConfigsNested<A> addNewConsulSDConfig() {
    return new ConsulSDConfigsNested(-1, null);
  }
  
  public ConsulSDConfigsNested<A> addNewConsulSDConfigLike(ConsulSDConfig item) {
    return new ConsulSDConfigsNested(-1, item);
  }
  
  public DigitalOceanSDConfigsNested<A> addNewDigitalOceanSDConfig() {
    return new DigitalOceanSDConfigsNested(-1, null);
  }
  
  public DigitalOceanSDConfigsNested<A> addNewDigitalOceanSDConfigLike(DigitalOceanSDConfig item) {
    return new DigitalOceanSDConfigsNested(-1, item);
  }
  
  public DnsSDConfigsNested<A> addNewDnsSDConfig() {
    return new DnsSDConfigsNested(-1, null);
  }
  
  public DnsSDConfigsNested<A> addNewDnsSDConfigLike(DNSSDConfig item) {
    return new DnsSDConfigsNested(-1, item);
  }
  
  public DockerSDConfigsNested<A> addNewDockerSDConfig() {
    return new DockerSDConfigsNested(-1, null);
  }
  
  public DockerSDConfigsNested<A> addNewDockerSDConfigLike(DockerSDConfig item) {
    return new DockerSDConfigsNested(-1, item);
  }
  
  public DockerSwarmSDConfigsNested<A> addNewDockerSwarmSDConfig() {
    return new DockerSwarmSDConfigsNested(-1, null);
  }
  
  public DockerSwarmSDConfigsNested<A> addNewDockerSwarmSDConfigLike(DockerSwarmSDConfig item) {
    return new DockerSwarmSDConfigsNested(-1, item);
  }
  
  public Ec2SDConfigsNested<A> addNewEc2SDConfig() {
    return new Ec2SDConfigsNested(-1, null);
  }
  
  public Ec2SDConfigsNested<A> addNewEc2SDConfigLike(EC2SDConfig item) {
    return new Ec2SDConfigsNested(-1, item);
  }
  
  public EurekaSDConfigsNested<A> addNewEurekaSDConfig() {
    return new EurekaSDConfigsNested(-1, null);
  }
  
  public EurekaSDConfigsNested<A> addNewEurekaSDConfigLike(EurekaSDConfig item) {
    return new EurekaSDConfigsNested(-1, item);
  }
  
  public FileSDConfigsNested<A> addNewFileSDConfig() {
    return new FileSDConfigsNested(-1, null);
  }
  
  public FileSDConfigsNested<A> addNewFileSDConfigLike(FileSDConfig item) {
    return new FileSDConfigsNested(-1, item);
  }
  
  public GceSDConfigsNested<A> addNewGceSDConfig() {
    return new GceSDConfigsNested(-1, null);
  }
  
  public GceSDConfigsNested<A> addNewGceSDConfigLike(GCESDConfig item) {
    return new GceSDConfigsNested(-1, item);
  }
  
  public HetznerSDConfigsNested<A> addNewHetznerSDConfig() {
    return new HetznerSDConfigsNested(-1, null);
  }
  
  public HetznerSDConfigsNested<A> addNewHetznerSDConfigLike(HetznerSDConfig item) {
    return new HetznerSDConfigsNested(-1, item);
  }
  
  public HttpSDConfigsNested<A> addNewHttpSDConfig() {
    return new HttpSDConfigsNested(-1, null);
  }
  
  public HttpSDConfigsNested<A> addNewHttpSDConfigLike(HTTPSDConfig item) {
    return new HttpSDConfigsNested(-1, item);
  }
  
  public IonosSDConfigsNested<A> addNewIonosSDConfig() {
    return new IonosSDConfigsNested(-1, null);
  }
  
  public IonosSDConfigsNested<A> addNewIonosSDConfigLike(IonosSDConfig item) {
    return new IonosSDConfigsNested(-1, item);
  }
  
  public KubernetesSDConfigsNested<A> addNewKubernetesSDConfig() {
    return new KubernetesSDConfigsNested(-1, null);
  }
  
  public KubernetesSDConfigsNested<A> addNewKubernetesSDConfigLike(KubernetesSDConfig item) {
    return new KubernetesSDConfigsNested(-1, item);
  }
  
  public KumaSDConfigsNested<A> addNewKumaSDConfig() {
    return new KumaSDConfigsNested(-1, null);
  }
  
  public KumaSDConfigsNested<A> addNewKumaSDConfigLike(KumaSDConfig item) {
    return new KumaSDConfigsNested(-1, item);
  }
  
  public LightSailSDConfigsNested<A> addNewLightSailSDConfig() {
    return new LightSailSDConfigsNested(-1, null);
  }
  
  public LightSailSDConfigsNested<A> addNewLightSailSDConfigLike(LightSailSDConfig item) {
    return new LightSailSDConfigsNested(-1, item);
  }
  
  public LinodeSDConfigsNested<A> addNewLinodeSDConfig() {
    return new LinodeSDConfigsNested(-1, null);
  }
  
  public LinodeSDConfigsNested<A> addNewLinodeSDConfigLike(LinodeSDConfig item) {
    return new LinodeSDConfigsNested(-1, item);
  }
  
  public MetricRelabelingsNested<A> addNewMetricRelabeling() {
    return new MetricRelabelingsNested(-1, null);
  }
  
  public MetricRelabelingsNested<A> addNewMetricRelabelingLike(RelabelConfig item) {
    return new MetricRelabelingsNested(-1, item);
  }
  
  public NomadSDConfigsNested<A> addNewNomadSDConfig() {
    return new NomadSDConfigsNested(-1, null);
  }
  
  public NomadSDConfigsNested<A> addNewNomadSDConfigLike(NomadSDConfig item) {
    return new NomadSDConfigsNested(-1, item);
  }
  
  public OpenstackSDConfigsNested<A> addNewOpenstackSDConfig() {
    return new OpenstackSDConfigsNested(-1, null);
  }
  
  public OpenstackSDConfigsNested<A> addNewOpenstackSDConfigLike(OpenStackSDConfig item) {
    return new OpenstackSDConfigsNested(-1, item);
  }
  
  public OvhcloudSDConfigsNested<A> addNewOvhcloudSDConfig() {
    return new OvhcloudSDConfigsNested(-1, null);
  }
  
  public OvhcloudSDConfigsNested<A> addNewOvhcloudSDConfigLike(OVHCloudSDConfig item) {
    return new OvhcloudSDConfigsNested(-1, item);
  }
  
  public PuppetDBSDConfigsNested<A> addNewPuppetDBSDConfig() {
    return new PuppetDBSDConfigsNested(-1, null);
  }
  
  public PuppetDBSDConfigsNested<A> addNewPuppetDBSDConfigLike(PuppetDBSDConfig item) {
    return new PuppetDBSDConfigsNested(-1, item);
  }
  
  public RelabelingsNested<A> addNewRelabeling() {
    return new RelabelingsNested(-1, null);
  }
  
  public RelabelingsNested<A> addNewRelabelingLike(RelabelConfig item) {
    return new RelabelingsNested(-1, item);
  }
  
  public ScalewaySDConfigsNested<A> addNewScalewaySDConfig() {
    return new ScalewaySDConfigsNested(-1, null);
  }
  
  public ScalewaySDConfigsNested<A> addNewScalewaySDConfigLike(ScalewaySDConfig item) {
    return new ScalewaySDConfigsNested(-1, item);
  }
  
  public StaticConfigsNested<A> addNewStaticConfig() {
    return new StaticConfigsNested(-1, null);
  }
  
  public StaticConfigsNested<A> addNewStaticConfigLike(StaticConfig item) {
    return new StaticConfigsNested(-1, item);
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
  
  public A addToAzureSDConfigs(AzureSDConfig... items) {
    if (this.azureSDConfigs == null) {
      this.azureSDConfigs = new ArrayList();
    }
    for (AzureSDConfig item : items) {
        AzureSDConfigBuilder builder = new AzureSDConfigBuilder(item);
        _visitables.get("azureSDConfigs").add(builder);
        this.azureSDConfigs.add(builder);
    }
    return (A) this;
  }
  
  public A addToAzureSDConfigs(int index,AzureSDConfig item) {
    if (this.azureSDConfigs == null) {
      this.azureSDConfigs = new ArrayList();
    }
    AzureSDConfigBuilder builder = new AzureSDConfigBuilder(item);
    if (index < 0 || index >= azureSDConfigs.size()) {
        _visitables.get("azureSDConfigs").add(builder);
        azureSDConfigs.add(builder);
    } else {
        _visitables.get("azureSDConfigs").add(builder);
        azureSDConfigs.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToConsulSDConfigs(ConsulSDConfig... items) {
    if (this.consulSDConfigs == null) {
      this.consulSDConfigs = new ArrayList();
    }
    for (ConsulSDConfig item : items) {
        ConsulSDConfigBuilder builder = new ConsulSDConfigBuilder(item);
        _visitables.get("consulSDConfigs").add(builder);
        this.consulSDConfigs.add(builder);
    }
    return (A) this;
  }
  
  public A addToConsulSDConfigs(int index,ConsulSDConfig item) {
    if (this.consulSDConfigs == null) {
      this.consulSDConfigs = new ArrayList();
    }
    ConsulSDConfigBuilder builder = new ConsulSDConfigBuilder(item);
    if (index < 0 || index >= consulSDConfigs.size()) {
        _visitables.get("consulSDConfigs").add(builder);
        consulSDConfigs.add(builder);
    } else {
        _visitables.get("consulSDConfigs").add(builder);
        consulSDConfigs.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToDigitalOceanSDConfigs(DigitalOceanSDConfig... items) {
    if (this.digitalOceanSDConfigs == null) {
      this.digitalOceanSDConfigs = new ArrayList();
    }
    for (DigitalOceanSDConfig item : items) {
        DigitalOceanSDConfigBuilder builder = new DigitalOceanSDConfigBuilder(item);
        _visitables.get("digitalOceanSDConfigs").add(builder);
        this.digitalOceanSDConfigs.add(builder);
    }
    return (A) this;
  }
  
  public A addToDigitalOceanSDConfigs(int index,DigitalOceanSDConfig item) {
    if (this.digitalOceanSDConfigs == null) {
      this.digitalOceanSDConfigs = new ArrayList();
    }
    DigitalOceanSDConfigBuilder builder = new DigitalOceanSDConfigBuilder(item);
    if (index < 0 || index >= digitalOceanSDConfigs.size()) {
        _visitables.get("digitalOceanSDConfigs").add(builder);
        digitalOceanSDConfigs.add(builder);
    } else {
        _visitables.get("digitalOceanSDConfigs").add(builder);
        digitalOceanSDConfigs.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToDnsSDConfigs(DNSSDConfig... items) {
    if (this.dnsSDConfigs == null) {
      this.dnsSDConfigs = new ArrayList();
    }
    for (DNSSDConfig item : items) {
        DNSSDConfigBuilder builder = new DNSSDConfigBuilder(item);
        _visitables.get("dnsSDConfigs").add(builder);
        this.dnsSDConfigs.add(builder);
    }
    return (A) this;
  }
  
  public A addToDnsSDConfigs(int index,DNSSDConfig item) {
    if (this.dnsSDConfigs == null) {
      this.dnsSDConfigs = new ArrayList();
    }
    DNSSDConfigBuilder builder = new DNSSDConfigBuilder(item);
    if (index < 0 || index >= dnsSDConfigs.size()) {
        _visitables.get("dnsSDConfigs").add(builder);
        dnsSDConfigs.add(builder);
    } else {
        _visitables.get("dnsSDConfigs").add(builder);
        dnsSDConfigs.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToDockerSDConfigs(DockerSDConfig... items) {
    if (this.dockerSDConfigs == null) {
      this.dockerSDConfigs = new ArrayList();
    }
    for (DockerSDConfig item : items) {
        DockerSDConfigBuilder builder = new DockerSDConfigBuilder(item);
        _visitables.get("dockerSDConfigs").add(builder);
        this.dockerSDConfigs.add(builder);
    }
    return (A) this;
  }
  
  public A addToDockerSDConfigs(int index,DockerSDConfig item) {
    if (this.dockerSDConfigs == null) {
      this.dockerSDConfigs = new ArrayList();
    }
    DockerSDConfigBuilder builder = new DockerSDConfigBuilder(item);
    if (index < 0 || index >= dockerSDConfigs.size()) {
        _visitables.get("dockerSDConfigs").add(builder);
        dockerSDConfigs.add(builder);
    } else {
        _visitables.get("dockerSDConfigs").add(builder);
        dockerSDConfigs.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToDockerSwarmSDConfigs(DockerSwarmSDConfig... items) {
    if (this.dockerSwarmSDConfigs == null) {
      this.dockerSwarmSDConfigs = new ArrayList();
    }
    for (DockerSwarmSDConfig item : items) {
        DockerSwarmSDConfigBuilder builder = new DockerSwarmSDConfigBuilder(item);
        _visitables.get("dockerSwarmSDConfigs").add(builder);
        this.dockerSwarmSDConfigs.add(builder);
    }
    return (A) this;
  }
  
  public A addToDockerSwarmSDConfigs(int index,DockerSwarmSDConfig item) {
    if (this.dockerSwarmSDConfigs == null) {
      this.dockerSwarmSDConfigs = new ArrayList();
    }
    DockerSwarmSDConfigBuilder builder = new DockerSwarmSDConfigBuilder(item);
    if (index < 0 || index >= dockerSwarmSDConfigs.size()) {
        _visitables.get("dockerSwarmSDConfigs").add(builder);
        dockerSwarmSDConfigs.add(builder);
    } else {
        _visitables.get("dockerSwarmSDConfigs").add(builder);
        dockerSwarmSDConfigs.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToEc2SDConfigs(EC2SDConfig... items) {
    if (this.ec2SDConfigs == null) {
      this.ec2SDConfigs = new ArrayList();
    }
    for (EC2SDConfig item : items) {
        EC2SDConfigBuilder builder = new EC2SDConfigBuilder(item);
        _visitables.get("ec2SDConfigs").add(builder);
        this.ec2SDConfigs.add(builder);
    }
    return (A) this;
  }
  
  public A addToEc2SDConfigs(int index,EC2SDConfig item) {
    if (this.ec2SDConfigs == null) {
      this.ec2SDConfigs = new ArrayList();
    }
    EC2SDConfigBuilder builder = new EC2SDConfigBuilder(item);
    if (index < 0 || index >= ec2SDConfigs.size()) {
        _visitables.get("ec2SDConfigs").add(builder);
        ec2SDConfigs.add(builder);
    } else {
        _visitables.get("ec2SDConfigs").add(builder);
        ec2SDConfigs.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToEurekaSDConfigs(EurekaSDConfig... items) {
    if (this.eurekaSDConfigs == null) {
      this.eurekaSDConfigs = new ArrayList();
    }
    for (EurekaSDConfig item : items) {
        EurekaSDConfigBuilder builder = new EurekaSDConfigBuilder(item);
        _visitables.get("eurekaSDConfigs").add(builder);
        this.eurekaSDConfigs.add(builder);
    }
    return (A) this;
  }
  
  public A addToEurekaSDConfigs(int index,EurekaSDConfig item) {
    if (this.eurekaSDConfigs == null) {
      this.eurekaSDConfigs = new ArrayList();
    }
    EurekaSDConfigBuilder builder = new EurekaSDConfigBuilder(item);
    if (index < 0 || index >= eurekaSDConfigs.size()) {
        _visitables.get("eurekaSDConfigs").add(builder);
        eurekaSDConfigs.add(builder);
    } else {
        _visitables.get("eurekaSDConfigs").add(builder);
        eurekaSDConfigs.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToFileSDConfigs(FileSDConfig... items) {
    if (this.fileSDConfigs == null) {
      this.fileSDConfigs = new ArrayList();
    }
    for (FileSDConfig item : items) {
        FileSDConfigBuilder builder = new FileSDConfigBuilder(item);
        _visitables.get("fileSDConfigs").add(builder);
        this.fileSDConfigs.add(builder);
    }
    return (A) this;
  }
  
  public A addToFileSDConfigs(int index,FileSDConfig item) {
    if (this.fileSDConfigs == null) {
      this.fileSDConfigs = new ArrayList();
    }
    FileSDConfigBuilder builder = new FileSDConfigBuilder(item);
    if (index < 0 || index >= fileSDConfigs.size()) {
        _visitables.get("fileSDConfigs").add(builder);
        fileSDConfigs.add(builder);
    } else {
        _visitables.get("fileSDConfigs").add(builder);
        fileSDConfigs.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToGceSDConfigs(GCESDConfig... items) {
    if (this.gceSDConfigs == null) {
      this.gceSDConfigs = new ArrayList();
    }
    for (GCESDConfig item : items) {
        GCESDConfigBuilder builder = new GCESDConfigBuilder(item);
        _visitables.get("gceSDConfigs").add(builder);
        this.gceSDConfigs.add(builder);
    }
    return (A) this;
  }
  
  public A addToGceSDConfigs(int index,GCESDConfig item) {
    if (this.gceSDConfigs == null) {
      this.gceSDConfigs = new ArrayList();
    }
    GCESDConfigBuilder builder = new GCESDConfigBuilder(item);
    if (index < 0 || index >= gceSDConfigs.size()) {
        _visitables.get("gceSDConfigs").add(builder);
        gceSDConfigs.add(builder);
    } else {
        _visitables.get("gceSDConfigs").add(builder);
        gceSDConfigs.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToHetznerSDConfigs(HetznerSDConfig... items) {
    if (this.hetznerSDConfigs == null) {
      this.hetznerSDConfigs = new ArrayList();
    }
    for (HetznerSDConfig item : items) {
        HetznerSDConfigBuilder builder = new HetznerSDConfigBuilder(item);
        _visitables.get("hetznerSDConfigs").add(builder);
        this.hetznerSDConfigs.add(builder);
    }
    return (A) this;
  }
  
  public A addToHetznerSDConfigs(int index,HetznerSDConfig item) {
    if (this.hetznerSDConfigs == null) {
      this.hetznerSDConfigs = new ArrayList();
    }
    HetznerSDConfigBuilder builder = new HetznerSDConfigBuilder(item);
    if (index < 0 || index >= hetznerSDConfigs.size()) {
        _visitables.get("hetznerSDConfigs").add(builder);
        hetznerSDConfigs.add(builder);
    } else {
        _visitables.get("hetznerSDConfigs").add(builder);
        hetznerSDConfigs.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToHttpSDConfigs(HTTPSDConfig... items) {
    if (this.httpSDConfigs == null) {
      this.httpSDConfigs = new ArrayList();
    }
    for (HTTPSDConfig item : items) {
        HTTPSDConfigBuilder builder = new HTTPSDConfigBuilder(item);
        _visitables.get("httpSDConfigs").add(builder);
        this.httpSDConfigs.add(builder);
    }
    return (A) this;
  }
  
  public A addToHttpSDConfigs(int index,HTTPSDConfig item) {
    if (this.httpSDConfigs == null) {
      this.httpSDConfigs = new ArrayList();
    }
    HTTPSDConfigBuilder builder = new HTTPSDConfigBuilder(item);
    if (index < 0 || index >= httpSDConfigs.size()) {
        _visitables.get("httpSDConfigs").add(builder);
        httpSDConfigs.add(builder);
    } else {
        _visitables.get("httpSDConfigs").add(builder);
        httpSDConfigs.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToIonosSDConfigs(IonosSDConfig... items) {
    if (this.ionosSDConfigs == null) {
      this.ionosSDConfigs = new ArrayList();
    }
    for (IonosSDConfig item : items) {
        IonosSDConfigBuilder builder = new IonosSDConfigBuilder(item);
        _visitables.get("ionosSDConfigs").add(builder);
        this.ionosSDConfigs.add(builder);
    }
    return (A) this;
  }
  
  public A addToIonosSDConfigs(int index,IonosSDConfig item) {
    if (this.ionosSDConfigs == null) {
      this.ionosSDConfigs = new ArrayList();
    }
    IonosSDConfigBuilder builder = new IonosSDConfigBuilder(item);
    if (index < 0 || index >= ionosSDConfigs.size()) {
        _visitables.get("ionosSDConfigs").add(builder);
        ionosSDConfigs.add(builder);
    } else {
        _visitables.get("ionosSDConfigs").add(builder);
        ionosSDConfigs.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToKubernetesSDConfigs(KubernetesSDConfig... items) {
    if (this.kubernetesSDConfigs == null) {
      this.kubernetesSDConfigs = new ArrayList();
    }
    for (KubernetesSDConfig item : items) {
        KubernetesSDConfigBuilder builder = new KubernetesSDConfigBuilder(item);
        _visitables.get("kubernetesSDConfigs").add(builder);
        this.kubernetesSDConfigs.add(builder);
    }
    return (A) this;
  }
  
  public A addToKubernetesSDConfigs(int index,KubernetesSDConfig item) {
    if (this.kubernetesSDConfigs == null) {
      this.kubernetesSDConfigs = new ArrayList();
    }
    KubernetesSDConfigBuilder builder = new KubernetesSDConfigBuilder(item);
    if (index < 0 || index >= kubernetesSDConfigs.size()) {
        _visitables.get("kubernetesSDConfigs").add(builder);
        kubernetesSDConfigs.add(builder);
    } else {
        _visitables.get("kubernetesSDConfigs").add(builder);
        kubernetesSDConfigs.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToKumaSDConfigs(KumaSDConfig... items) {
    if (this.kumaSDConfigs == null) {
      this.kumaSDConfigs = new ArrayList();
    }
    for (KumaSDConfig item : items) {
        KumaSDConfigBuilder builder = new KumaSDConfigBuilder(item);
        _visitables.get("kumaSDConfigs").add(builder);
        this.kumaSDConfigs.add(builder);
    }
    return (A) this;
  }
  
  public A addToKumaSDConfigs(int index,KumaSDConfig item) {
    if (this.kumaSDConfigs == null) {
      this.kumaSDConfigs = new ArrayList();
    }
    KumaSDConfigBuilder builder = new KumaSDConfigBuilder(item);
    if (index < 0 || index >= kumaSDConfigs.size()) {
        _visitables.get("kumaSDConfigs").add(builder);
        kumaSDConfigs.add(builder);
    } else {
        _visitables.get("kumaSDConfigs").add(builder);
        kumaSDConfigs.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToLightSailSDConfigs(LightSailSDConfig... items) {
    if (this.lightSailSDConfigs == null) {
      this.lightSailSDConfigs = new ArrayList();
    }
    for (LightSailSDConfig item : items) {
        LightSailSDConfigBuilder builder = new LightSailSDConfigBuilder(item);
        _visitables.get("lightSailSDConfigs").add(builder);
        this.lightSailSDConfigs.add(builder);
    }
    return (A) this;
  }
  
  public A addToLightSailSDConfigs(int index,LightSailSDConfig item) {
    if (this.lightSailSDConfigs == null) {
      this.lightSailSDConfigs = new ArrayList();
    }
    LightSailSDConfigBuilder builder = new LightSailSDConfigBuilder(item);
    if (index < 0 || index >= lightSailSDConfigs.size()) {
        _visitables.get("lightSailSDConfigs").add(builder);
        lightSailSDConfigs.add(builder);
    } else {
        _visitables.get("lightSailSDConfigs").add(builder);
        lightSailSDConfigs.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToLinodeSDConfigs(LinodeSDConfig... items) {
    if (this.linodeSDConfigs == null) {
      this.linodeSDConfigs = new ArrayList();
    }
    for (LinodeSDConfig item : items) {
        LinodeSDConfigBuilder builder = new LinodeSDConfigBuilder(item);
        _visitables.get("linodeSDConfigs").add(builder);
        this.linodeSDConfigs.add(builder);
    }
    return (A) this;
  }
  
  public A addToLinodeSDConfigs(int index,LinodeSDConfig item) {
    if (this.linodeSDConfigs == null) {
      this.linodeSDConfigs = new ArrayList();
    }
    LinodeSDConfigBuilder builder = new LinodeSDConfigBuilder(item);
    if (index < 0 || index >= linodeSDConfigs.size()) {
        _visitables.get("linodeSDConfigs").add(builder);
        linodeSDConfigs.add(builder);
    } else {
        _visitables.get("linodeSDConfigs").add(builder);
        linodeSDConfigs.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToMetricRelabelings(RelabelConfig... items) {
    if (this.metricRelabelings == null) {
      this.metricRelabelings = new ArrayList();
    }
    for (RelabelConfig item : items) {
        RelabelConfigBuilder builder = new RelabelConfigBuilder(item);
        _visitables.get("metricRelabelings").add(builder);
        this.metricRelabelings.add(builder);
    }
    return (A) this;
  }
  
  public A addToMetricRelabelings(int index,RelabelConfig item) {
    if (this.metricRelabelings == null) {
      this.metricRelabelings = new ArrayList();
    }
    RelabelConfigBuilder builder = new RelabelConfigBuilder(item);
    if (index < 0 || index >= metricRelabelings.size()) {
        _visitables.get("metricRelabelings").add(builder);
        metricRelabelings.add(builder);
    } else {
        _visitables.get("metricRelabelings").add(builder);
        metricRelabelings.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToNomadSDConfigs(NomadSDConfig... items) {
    if (this.nomadSDConfigs == null) {
      this.nomadSDConfigs = new ArrayList();
    }
    for (NomadSDConfig item : items) {
        NomadSDConfigBuilder builder = new NomadSDConfigBuilder(item);
        _visitables.get("nomadSDConfigs").add(builder);
        this.nomadSDConfigs.add(builder);
    }
    return (A) this;
  }
  
  public A addToNomadSDConfigs(int index,NomadSDConfig item) {
    if (this.nomadSDConfigs == null) {
      this.nomadSDConfigs = new ArrayList();
    }
    NomadSDConfigBuilder builder = new NomadSDConfigBuilder(item);
    if (index < 0 || index >= nomadSDConfigs.size()) {
        _visitables.get("nomadSDConfigs").add(builder);
        nomadSDConfigs.add(builder);
    } else {
        _visitables.get("nomadSDConfigs").add(builder);
        nomadSDConfigs.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToOpenstackSDConfigs(OpenStackSDConfig... items) {
    if (this.openstackSDConfigs == null) {
      this.openstackSDConfigs = new ArrayList();
    }
    for (OpenStackSDConfig item : items) {
        OpenStackSDConfigBuilder builder = new OpenStackSDConfigBuilder(item);
        _visitables.get("openstackSDConfigs").add(builder);
        this.openstackSDConfigs.add(builder);
    }
    return (A) this;
  }
  
  public A addToOpenstackSDConfigs(int index,OpenStackSDConfig item) {
    if (this.openstackSDConfigs == null) {
      this.openstackSDConfigs = new ArrayList();
    }
    OpenStackSDConfigBuilder builder = new OpenStackSDConfigBuilder(item);
    if (index < 0 || index >= openstackSDConfigs.size()) {
        _visitables.get("openstackSDConfigs").add(builder);
        openstackSDConfigs.add(builder);
    } else {
        _visitables.get("openstackSDConfigs").add(builder);
        openstackSDConfigs.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToOvhcloudSDConfigs(OVHCloudSDConfig... items) {
    if (this.ovhcloudSDConfigs == null) {
      this.ovhcloudSDConfigs = new ArrayList();
    }
    for (OVHCloudSDConfig item : items) {
        OVHCloudSDConfigBuilder builder = new OVHCloudSDConfigBuilder(item);
        _visitables.get("ovhcloudSDConfigs").add(builder);
        this.ovhcloudSDConfigs.add(builder);
    }
    return (A) this;
  }
  
  public A addToOvhcloudSDConfigs(int index,OVHCloudSDConfig item) {
    if (this.ovhcloudSDConfigs == null) {
      this.ovhcloudSDConfigs = new ArrayList();
    }
    OVHCloudSDConfigBuilder builder = new OVHCloudSDConfigBuilder(item);
    if (index < 0 || index >= ovhcloudSDConfigs.size()) {
        _visitables.get("ovhcloudSDConfigs").add(builder);
        ovhcloudSDConfigs.add(builder);
    } else {
        _visitables.get("ovhcloudSDConfigs").add(builder);
        ovhcloudSDConfigs.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToParams(Map<String,List<String>> map) {
    if (this.params == null && map != null) {
      this.params = new LinkedHashMap();
    }
    if (map != null) {
      this.params.putAll(map);
    }
    return (A) this;
  }
  
  public A addToParams(String key,List<String> value) {
    if (this.params == null && key != null && value != null) {
      this.params = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.params.put(key, value);
    }
    return (A) this;
  }
  
  public A addToProxyConnectHeader(Map<String,List<SecretKeySelector>> map) {
    if (this.proxyConnectHeader == null && map != null) {
      this.proxyConnectHeader = new LinkedHashMap();
    }
    if (map != null) {
      this.proxyConnectHeader.putAll(map);
    }
    return (A) this;
  }
  
  public A addToProxyConnectHeader(String key,List<SecretKeySelector> value) {
    if (this.proxyConnectHeader == null && key != null && value != null) {
      this.proxyConnectHeader = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.proxyConnectHeader.put(key, value);
    }
    return (A) this;
  }
  
  public A addToPuppetDBSDConfigs(PuppetDBSDConfig... items) {
    if (this.puppetDBSDConfigs == null) {
      this.puppetDBSDConfigs = new ArrayList();
    }
    for (PuppetDBSDConfig item : items) {
        PuppetDBSDConfigBuilder builder = new PuppetDBSDConfigBuilder(item);
        _visitables.get("puppetDBSDConfigs").add(builder);
        this.puppetDBSDConfigs.add(builder);
    }
    return (A) this;
  }
  
  public A addToPuppetDBSDConfigs(int index,PuppetDBSDConfig item) {
    if (this.puppetDBSDConfigs == null) {
      this.puppetDBSDConfigs = new ArrayList();
    }
    PuppetDBSDConfigBuilder builder = new PuppetDBSDConfigBuilder(item);
    if (index < 0 || index >= puppetDBSDConfigs.size()) {
        _visitables.get("puppetDBSDConfigs").add(builder);
        puppetDBSDConfigs.add(builder);
    } else {
        _visitables.get("puppetDBSDConfigs").add(builder);
        puppetDBSDConfigs.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToRelabelings(RelabelConfig... items) {
    if (this.relabelings == null) {
      this.relabelings = new ArrayList();
    }
    for (RelabelConfig item : items) {
        RelabelConfigBuilder builder = new RelabelConfigBuilder(item);
        _visitables.get("relabelings").add(builder);
        this.relabelings.add(builder);
    }
    return (A) this;
  }
  
  public A addToRelabelings(int index,RelabelConfig item) {
    if (this.relabelings == null) {
      this.relabelings = new ArrayList();
    }
    RelabelConfigBuilder builder = new RelabelConfigBuilder(item);
    if (index < 0 || index >= relabelings.size()) {
        _visitables.get("relabelings").add(builder);
        relabelings.add(builder);
    } else {
        _visitables.get("relabelings").add(builder);
        relabelings.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToScalewaySDConfigs(ScalewaySDConfig... items) {
    if (this.scalewaySDConfigs == null) {
      this.scalewaySDConfigs = new ArrayList();
    }
    for (ScalewaySDConfig item : items) {
        ScalewaySDConfigBuilder builder = new ScalewaySDConfigBuilder(item);
        _visitables.get("scalewaySDConfigs").add(builder);
        this.scalewaySDConfigs.add(builder);
    }
    return (A) this;
  }
  
  public A addToScalewaySDConfigs(int index,ScalewaySDConfig item) {
    if (this.scalewaySDConfigs == null) {
      this.scalewaySDConfigs = new ArrayList();
    }
    ScalewaySDConfigBuilder builder = new ScalewaySDConfigBuilder(item);
    if (index < 0 || index >= scalewaySDConfigs.size()) {
        _visitables.get("scalewaySDConfigs").add(builder);
        scalewaySDConfigs.add(builder);
    } else {
        _visitables.get("scalewaySDConfigs").add(builder);
        scalewaySDConfigs.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToScrapeProtocols(String... items) {
    if (this.scrapeProtocols == null) {
      this.scrapeProtocols = new ArrayList();
    }
    for (String item : items) {
      this.scrapeProtocols.add(item);
    }
    return (A) this;
  }
  
  public A addToScrapeProtocols(int index,String item) {
    if (this.scrapeProtocols == null) {
      this.scrapeProtocols = new ArrayList();
    }
    this.scrapeProtocols.add(index, item);
    return (A) this;
  }
  
  public A addToStaticConfigs(StaticConfig... items) {
    if (this.staticConfigs == null) {
      this.staticConfigs = new ArrayList();
    }
    for (StaticConfig item : items) {
        StaticConfigBuilder builder = new StaticConfigBuilder(item);
        _visitables.get("staticConfigs").add(builder);
        this.staticConfigs.add(builder);
    }
    return (A) this;
  }
  
  public A addToStaticConfigs(int index,StaticConfig item) {
    if (this.staticConfigs == null) {
      this.staticConfigs = new ArrayList();
    }
    StaticConfigBuilder builder = new StaticConfigBuilder(item);
    if (index < 0 || index >= staticConfigs.size()) {
        _visitables.get("staticConfigs").add(builder);
        staticConfigs.add(builder);
    } else {
        _visitables.get("staticConfigs").add(builder);
        staticConfigs.add(index, builder);
    }
    return (A) this;
  }
  
  public SafeAuthorization buildAuthorization() {
    return this.authorization != null ? this.authorization.build() : null;
  }
  
  public AzureSDConfig buildAzureSDConfig(int index) {
    return this.azureSDConfigs.get(index).build();
  }
  
  public List<AzureSDConfig> buildAzureSDConfigs() {
    return this.azureSDConfigs != null ? build(azureSDConfigs) : null;
  }
  
  public BasicAuth buildBasicAuth() {
    return this.basicAuth != null ? this.basicAuth.build() : null;
  }
  
  public ConsulSDConfig buildConsulSDConfig(int index) {
    return this.consulSDConfigs.get(index).build();
  }
  
  public List<ConsulSDConfig> buildConsulSDConfigs() {
    return this.consulSDConfigs != null ? build(consulSDConfigs) : null;
  }
  
  public DigitalOceanSDConfig buildDigitalOceanSDConfig(int index) {
    return this.digitalOceanSDConfigs.get(index).build();
  }
  
  public List<DigitalOceanSDConfig> buildDigitalOceanSDConfigs() {
    return this.digitalOceanSDConfigs != null ? build(digitalOceanSDConfigs) : null;
  }
  
  public DNSSDConfig buildDnsSDConfig(int index) {
    return this.dnsSDConfigs.get(index).build();
  }
  
  public List<DNSSDConfig> buildDnsSDConfigs() {
    return this.dnsSDConfigs != null ? build(dnsSDConfigs) : null;
  }
  
  public DockerSDConfig buildDockerSDConfig(int index) {
    return this.dockerSDConfigs.get(index).build();
  }
  
  public List<DockerSDConfig> buildDockerSDConfigs() {
    return this.dockerSDConfigs != null ? build(dockerSDConfigs) : null;
  }
  
  public DockerSwarmSDConfig buildDockerSwarmSDConfig(int index) {
    return this.dockerSwarmSDConfigs.get(index).build();
  }
  
  public List<DockerSwarmSDConfig> buildDockerSwarmSDConfigs() {
    return this.dockerSwarmSDConfigs != null ? build(dockerSwarmSDConfigs) : null;
  }
  
  public EC2SDConfig buildEc2SDConfig(int index) {
    return this.ec2SDConfigs.get(index).build();
  }
  
  public List<EC2SDConfig> buildEc2SDConfigs() {
    return this.ec2SDConfigs != null ? build(ec2SDConfigs) : null;
  }
  
  public EurekaSDConfig buildEurekaSDConfig(int index) {
    return this.eurekaSDConfigs.get(index).build();
  }
  
  public List<EurekaSDConfig> buildEurekaSDConfigs() {
    return this.eurekaSDConfigs != null ? build(eurekaSDConfigs) : null;
  }
  
  public FileSDConfig buildFileSDConfig(int index) {
    return this.fileSDConfigs.get(index).build();
  }
  
  public List<FileSDConfig> buildFileSDConfigs() {
    return this.fileSDConfigs != null ? build(fileSDConfigs) : null;
  }
  
  public AzureSDConfig buildFirstAzureSDConfig() {
    return this.azureSDConfigs.get(0).build();
  }
  
  public ConsulSDConfig buildFirstConsulSDConfig() {
    return this.consulSDConfigs.get(0).build();
  }
  
  public DigitalOceanSDConfig buildFirstDigitalOceanSDConfig() {
    return this.digitalOceanSDConfigs.get(0).build();
  }
  
  public DNSSDConfig buildFirstDnsSDConfig() {
    return this.dnsSDConfigs.get(0).build();
  }
  
  public DockerSDConfig buildFirstDockerSDConfig() {
    return this.dockerSDConfigs.get(0).build();
  }
  
  public DockerSwarmSDConfig buildFirstDockerSwarmSDConfig() {
    return this.dockerSwarmSDConfigs.get(0).build();
  }
  
  public EC2SDConfig buildFirstEc2SDConfig() {
    return this.ec2SDConfigs.get(0).build();
  }
  
  public EurekaSDConfig buildFirstEurekaSDConfig() {
    return this.eurekaSDConfigs.get(0).build();
  }
  
  public FileSDConfig buildFirstFileSDConfig() {
    return this.fileSDConfigs.get(0).build();
  }
  
  public GCESDConfig buildFirstGceSDConfig() {
    return this.gceSDConfigs.get(0).build();
  }
  
  public HetznerSDConfig buildFirstHetznerSDConfig() {
    return this.hetznerSDConfigs.get(0).build();
  }
  
  public HTTPSDConfig buildFirstHttpSDConfig() {
    return this.httpSDConfigs.get(0).build();
  }
  
  public IonosSDConfig buildFirstIonosSDConfig() {
    return this.ionosSDConfigs.get(0).build();
  }
  
  public KubernetesSDConfig buildFirstKubernetesSDConfig() {
    return this.kubernetesSDConfigs.get(0).build();
  }
  
  public KumaSDConfig buildFirstKumaSDConfig() {
    return this.kumaSDConfigs.get(0).build();
  }
  
  public LightSailSDConfig buildFirstLightSailSDConfig() {
    return this.lightSailSDConfigs.get(0).build();
  }
  
  public LinodeSDConfig buildFirstLinodeSDConfig() {
    return this.linodeSDConfigs.get(0).build();
  }
  
  public RelabelConfig buildFirstMetricRelabeling() {
    return this.metricRelabelings.get(0).build();
  }
  
  public NomadSDConfig buildFirstNomadSDConfig() {
    return this.nomadSDConfigs.get(0).build();
  }
  
  public OpenStackSDConfig buildFirstOpenstackSDConfig() {
    return this.openstackSDConfigs.get(0).build();
  }
  
  public OVHCloudSDConfig buildFirstOvhcloudSDConfig() {
    return this.ovhcloudSDConfigs.get(0).build();
  }
  
  public PuppetDBSDConfig buildFirstPuppetDBSDConfig() {
    return this.puppetDBSDConfigs.get(0).build();
  }
  
  public RelabelConfig buildFirstRelabeling() {
    return this.relabelings.get(0).build();
  }
  
  public ScalewaySDConfig buildFirstScalewaySDConfig() {
    return this.scalewaySDConfigs.get(0).build();
  }
  
  public StaticConfig buildFirstStaticConfig() {
    return this.staticConfigs.get(0).build();
  }
  
  public GCESDConfig buildGceSDConfig(int index) {
    return this.gceSDConfigs.get(index).build();
  }
  
  public List<GCESDConfig> buildGceSDConfigs() {
    return this.gceSDConfigs != null ? build(gceSDConfigs) : null;
  }
  
  public HetznerSDConfig buildHetznerSDConfig(int index) {
    return this.hetznerSDConfigs.get(index).build();
  }
  
  public List<HetznerSDConfig> buildHetznerSDConfigs() {
    return this.hetznerSDConfigs != null ? build(hetznerSDConfigs) : null;
  }
  
  public HTTPSDConfig buildHttpSDConfig(int index) {
    return this.httpSDConfigs.get(index).build();
  }
  
  public List<HTTPSDConfig> buildHttpSDConfigs() {
    return this.httpSDConfigs != null ? build(httpSDConfigs) : null;
  }
  
  public IonosSDConfig buildIonosSDConfig(int index) {
    return this.ionosSDConfigs.get(index).build();
  }
  
  public List<IonosSDConfig> buildIonosSDConfigs() {
    return this.ionosSDConfigs != null ? build(ionosSDConfigs) : null;
  }
  
  public KubernetesSDConfig buildKubernetesSDConfig(int index) {
    return this.kubernetesSDConfigs.get(index).build();
  }
  
  public List<KubernetesSDConfig> buildKubernetesSDConfigs() {
    return this.kubernetesSDConfigs != null ? build(kubernetesSDConfigs) : null;
  }
  
  public KumaSDConfig buildKumaSDConfig(int index) {
    return this.kumaSDConfigs.get(index).build();
  }
  
  public List<KumaSDConfig> buildKumaSDConfigs() {
    return this.kumaSDConfigs != null ? build(kumaSDConfigs) : null;
  }
  
  public AzureSDConfig buildLastAzureSDConfig() {
    return this.azureSDConfigs.get(azureSDConfigs.size() - 1).build();
  }
  
  public ConsulSDConfig buildLastConsulSDConfig() {
    return this.consulSDConfigs.get(consulSDConfigs.size() - 1).build();
  }
  
  public DigitalOceanSDConfig buildLastDigitalOceanSDConfig() {
    return this.digitalOceanSDConfigs.get(digitalOceanSDConfigs.size() - 1).build();
  }
  
  public DNSSDConfig buildLastDnsSDConfig() {
    return this.dnsSDConfigs.get(dnsSDConfigs.size() - 1).build();
  }
  
  public DockerSDConfig buildLastDockerSDConfig() {
    return this.dockerSDConfigs.get(dockerSDConfigs.size() - 1).build();
  }
  
  public DockerSwarmSDConfig buildLastDockerSwarmSDConfig() {
    return this.dockerSwarmSDConfigs.get(dockerSwarmSDConfigs.size() - 1).build();
  }
  
  public EC2SDConfig buildLastEc2SDConfig() {
    return this.ec2SDConfigs.get(ec2SDConfigs.size() - 1).build();
  }
  
  public EurekaSDConfig buildLastEurekaSDConfig() {
    return this.eurekaSDConfigs.get(eurekaSDConfigs.size() - 1).build();
  }
  
  public FileSDConfig buildLastFileSDConfig() {
    return this.fileSDConfigs.get(fileSDConfigs.size() - 1).build();
  }
  
  public GCESDConfig buildLastGceSDConfig() {
    return this.gceSDConfigs.get(gceSDConfigs.size() - 1).build();
  }
  
  public HetznerSDConfig buildLastHetznerSDConfig() {
    return this.hetznerSDConfigs.get(hetznerSDConfigs.size() - 1).build();
  }
  
  public HTTPSDConfig buildLastHttpSDConfig() {
    return this.httpSDConfigs.get(httpSDConfigs.size() - 1).build();
  }
  
  public IonosSDConfig buildLastIonosSDConfig() {
    return this.ionosSDConfigs.get(ionosSDConfigs.size() - 1).build();
  }
  
  public KubernetesSDConfig buildLastKubernetesSDConfig() {
    return this.kubernetesSDConfigs.get(kubernetesSDConfigs.size() - 1).build();
  }
  
  public KumaSDConfig buildLastKumaSDConfig() {
    return this.kumaSDConfigs.get(kumaSDConfigs.size() - 1).build();
  }
  
  public LightSailSDConfig buildLastLightSailSDConfig() {
    return this.lightSailSDConfigs.get(lightSailSDConfigs.size() - 1).build();
  }
  
  public LinodeSDConfig buildLastLinodeSDConfig() {
    return this.linodeSDConfigs.get(linodeSDConfigs.size() - 1).build();
  }
  
  public RelabelConfig buildLastMetricRelabeling() {
    return this.metricRelabelings.get(metricRelabelings.size() - 1).build();
  }
  
  public NomadSDConfig buildLastNomadSDConfig() {
    return this.nomadSDConfigs.get(nomadSDConfigs.size() - 1).build();
  }
  
  public OpenStackSDConfig buildLastOpenstackSDConfig() {
    return this.openstackSDConfigs.get(openstackSDConfigs.size() - 1).build();
  }
  
  public OVHCloudSDConfig buildLastOvhcloudSDConfig() {
    return this.ovhcloudSDConfigs.get(ovhcloudSDConfigs.size() - 1).build();
  }
  
  public PuppetDBSDConfig buildLastPuppetDBSDConfig() {
    return this.puppetDBSDConfigs.get(puppetDBSDConfigs.size() - 1).build();
  }
  
  public RelabelConfig buildLastRelabeling() {
    return this.relabelings.get(relabelings.size() - 1).build();
  }
  
  public ScalewaySDConfig buildLastScalewaySDConfig() {
    return this.scalewaySDConfigs.get(scalewaySDConfigs.size() - 1).build();
  }
  
  public StaticConfig buildLastStaticConfig() {
    return this.staticConfigs.get(staticConfigs.size() - 1).build();
  }
  
  public LightSailSDConfig buildLightSailSDConfig(int index) {
    return this.lightSailSDConfigs.get(index).build();
  }
  
  public List<LightSailSDConfig> buildLightSailSDConfigs() {
    return this.lightSailSDConfigs != null ? build(lightSailSDConfigs) : null;
  }
  
  public LinodeSDConfig buildLinodeSDConfig(int index) {
    return this.linodeSDConfigs.get(index).build();
  }
  
  public List<LinodeSDConfig> buildLinodeSDConfigs() {
    return this.linodeSDConfigs != null ? build(linodeSDConfigs) : null;
  }
  
  public AzureSDConfig buildMatchingAzureSDConfig(Predicate<AzureSDConfigBuilder> predicate) {
      for (AzureSDConfigBuilder item : azureSDConfigs) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ConsulSDConfig buildMatchingConsulSDConfig(Predicate<ConsulSDConfigBuilder> predicate) {
      for (ConsulSDConfigBuilder item : consulSDConfigs) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public DigitalOceanSDConfig buildMatchingDigitalOceanSDConfig(Predicate<DigitalOceanSDConfigBuilder> predicate) {
      for (DigitalOceanSDConfigBuilder item : digitalOceanSDConfigs) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public DNSSDConfig buildMatchingDnsSDConfig(Predicate<DNSSDConfigBuilder> predicate) {
      for (DNSSDConfigBuilder item : dnsSDConfigs) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public DockerSDConfig buildMatchingDockerSDConfig(Predicate<DockerSDConfigBuilder> predicate) {
      for (DockerSDConfigBuilder item : dockerSDConfigs) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public DockerSwarmSDConfig buildMatchingDockerSwarmSDConfig(Predicate<DockerSwarmSDConfigBuilder> predicate) {
      for (DockerSwarmSDConfigBuilder item : dockerSwarmSDConfigs) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public EC2SDConfig buildMatchingEc2SDConfig(Predicate<EC2SDConfigBuilder> predicate) {
      for (EC2SDConfigBuilder item : ec2SDConfigs) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public EurekaSDConfig buildMatchingEurekaSDConfig(Predicate<EurekaSDConfigBuilder> predicate) {
      for (EurekaSDConfigBuilder item : eurekaSDConfigs) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public FileSDConfig buildMatchingFileSDConfig(Predicate<FileSDConfigBuilder> predicate) {
      for (FileSDConfigBuilder item : fileSDConfigs) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public GCESDConfig buildMatchingGceSDConfig(Predicate<GCESDConfigBuilder> predicate) {
      for (GCESDConfigBuilder item : gceSDConfigs) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public HetznerSDConfig buildMatchingHetznerSDConfig(Predicate<HetznerSDConfigBuilder> predicate) {
      for (HetznerSDConfigBuilder item : hetznerSDConfigs) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public HTTPSDConfig buildMatchingHttpSDConfig(Predicate<HTTPSDConfigBuilder> predicate) {
      for (HTTPSDConfigBuilder item : httpSDConfigs) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public IonosSDConfig buildMatchingIonosSDConfig(Predicate<IonosSDConfigBuilder> predicate) {
      for (IonosSDConfigBuilder item : ionosSDConfigs) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public KubernetesSDConfig buildMatchingKubernetesSDConfig(Predicate<KubernetesSDConfigBuilder> predicate) {
      for (KubernetesSDConfigBuilder item : kubernetesSDConfigs) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public KumaSDConfig buildMatchingKumaSDConfig(Predicate<KumaSDConfigBuilder> predicate) {
      for (KumaSDConfigBuilder item : kumaSDConfigs) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public LightSailSDConfig buildMatchingLightSailSDConfig(Predicate<LightSailSDConfigBuilder> predicate) {
      for (LightSailSDConfigBuilder item : lightSailSDConfigs) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public LinodeSDConfig buildMatchingLinodeSDConfig(Predicate<LinodeSDConfigBuilder> predicate) {
      for (LinodeSDConfigBuilder item : linodeSDConfigs) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public RelabelConfig buildMatchingMetricRelabeling(Predicate<RelabelConfigBuilder> predicate) {
      for (RelabelConfigBuilder item : metricRelabelings) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public NomadSDConfig buildMatchingNomadSDConfig(Predicate<NomadSDConfigBuilder> predicate) {
      for (NomadSDConfigBuilder item : nomadSDConfigs) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public OpenStackSDConfig buildMatchingOpenstackSDConfig(Predicate<OpenStackSDConfigBuilder> predicate) {
      for (OpenStackSDConfigBuilder item : openstackSDConfigs) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public OVHCloudSDConfig buildMatchingOvhcloudSDConfig(Predicate<OVHCloudSDConfigBuilder> predicate) {
      for (OVHCloudSDConfigBuilder item : ovhcloudSDConfigs) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public PuppetDBSDConfig buildMatchingPuppetDBSDConfig(Predicate<PuppetDBSDConfigBuilder> predicate) {
      for (PuppetDBSDConfigBuilder item : puppetDBSDConfigs) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public RelabelConfig buildMatchingRelabeling(Predicate<RelabelConfigBuilder> predicate) {
      for (RelabelConfigBuilder item : relabelings) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ScalewaySDConfig buildMatchingScalewaySDConfig(Predicate<ScalewaySDConfigBuilder> predicate) {
      for (ScalewaySDConfigBuilder item : scalewaySDConfigs) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public StaticConfig buildMatchingStaticConfig(Predicate<StaticConfigBuilder> predicate) {
      for (StaticConfigBuilder item : staticConfigs) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public RelabelConfig buildMetricRelabeling(int index) {
    return this.metricRelabelings.get(index).build();
  }
  
  public List<RelabelConfig> buildMetricRelabelings() {
    return this.metricRelabelings != null ? build(metricRelabelings) : null;
  }
  
  public NomadSDConfig buildNomadSDConfig(int index) {
    return this.nomadSDConfigs.get(index).build();
  }
  
  public List<NomadSDConfig> buildNomadSDConfigs() {
    return this.nomadSDConfigs != null ? build(nomadSDConfigs) : null;
  }
  
  public OAuth2 buildOauth2() {
    return this.oauth2 != null ? this.oauth2.build() : null;
  }
  
  public OpenStackSDConfig buildOpenstackSDConfig(int index) {
    return this.openstackSDConfigs.get(index).build();
  }
  
  public List<OpenStackSDConfig> buildOpenstackSDConfigs() {
    return this.openstackSDConfigs != null ? build(openstackSDConfigs) : null;
  }
  
  public OVHCloudSDConfig buildOvhcloudSDConfig(int index) {
    return this.ovhcloudSDConfigs.get(index).build();
  }
  
  public List<OVHCloudSDConfig> buildOvhcloudSDConfigs() {
    return this.ovhcloudSDConfigs != null ? build(ovhcloudSDConfigs) : null;
  }
  
  public PuppetDBSDConfig buildPuppetDBSDConfig(int index) {
    return this.puppetDBSDConfigs.get(index).build();
  }
  
  public List<PuppetDBSDConfig> buildPuppetDBSDConfigs() {
    return this.puppetDBSDConfigs != null ? build(puppetDBSDConfigs) : null;
  }
  
  public RelabelConfig buildRelabeling(int index) {
    return this.relabelings.get(index).build();
  }
  
  public List<RelabelConfig> buildRelabelings() {
    return this.relabelings != null ? build(relabelings) : null;
  }
  
  public ScalewaySDConfig buildScalewaySDConfig(int index) {
    return this.scalewaySDConfigs.get(index).build();
  }
  
  public List<ScalewaySDConfig> buildScalewaySDConfigs() {
    return this.scalewaySDConfigs != null ? build(scalewaySDConfigs) : null;
  }
  
  public StaticConfig buildStaticConfig(int index) {
    return this.staticConfigs.get(index).build();
  }
  
  public List<StaticConfig> buildStaticConfigs() {
    return this.staticConfigs != null ? build(staticConfigs) : null;
  }
  
  public SafeTLSConfig buildTlsConfig() {
    return this.tlsConfig != null ? this.tlsConfig.build() : null;
  }
  
  protected void copyInstance(ScrapeConfigSpec instance) {
    instance = instance != null ? instance : new ScrapeConfigSpec();
    if (instance != null) {
        this.withAuthorization(instance.getAuthorization());
        this.withAzureSDConfigs(instance.getAzureSDConfigs());
        this.withBasicAuth(instance.getBasicAuth());
        this.withBodySizeLimit(instance.getBodySizeLimit());
        this.withConsulSDConfigs(instance.getConsulSDConfigs());
        this.withConvertClassicHistogramsToNHCB(instance.getConvertClassicHistogramsToNHCB());
        this.withDigitalOceanSDConfigs(instance.getDigitalOceanSDConfigs());
        this.withDnsSDConfigs(instance.getDnsSDConfigs());
        this.withDockerSDConfigs(instance.getDockerSDConfigs());
        this.withDockerSwarmSDConfigs(instance.getDockerSwarmSDConfigs());
        this.withEc2SDConfigs(instance.getEc2SDConfigs());
        this.withEnableCompression(instance.getEnableCompression());
        this.withEnableHTTP2(instance.getEnableHTTP2());
        this.withEurekaSDConfigs(instance.getEurekaSDConfigs());
        this.withFallbackScrapeProtocol(instance.getFallbackScrapeProtocol());
        this.withFileSDConfigs(instance.getFileSDConfigs());
        this.withGceSDConfigs(instance.getGceSDConfigs());
        this.withHetznerSDConfigs(instance.getHetznerSDConfigs());
        this.withHonorLabels(instance.getHonorLabels());
        this.withHonorTimestamps(instance.getHonorTimestamps());
        this.withHttpSDConfigs(instance.getHttpSDConfigs());
        this.withIonosSDConfigs(instance.getIonosSDConfigs());
        this.withJobName(instance.getJobName());
        this.withKeepDroppedTargets(instance.getKeepDroppedTargets());
        this.withKubernetesSDConfigs(instance.getKubernetesSDConfigs());
        this.withKumaSDConfigs(instance.getKumaSDConfigs());
        this.withLabelLimit(instance.getLabelLimit());
        this.withLabelNameLengthLimit(instance.getLabelNameLengthLimit());
        this.withLabelValueLengthLimit(instance.getLabelValueLengthLimit());
        this.withLightSailSDConfigs(instance.getLightSailSDConfigs());
        this.withLinodeSDConfigs(instance.getLinodeSDConfigs());
        this.withMetricRelabelings(instance.getMetricRelabelings());
        this.withMetricsPath(instance.getMetricsPath());
        this.withNameEscapingScheme(instance.getNameEscapingScheme());
        this.withNameValidationScheme(instance.getNameValidationScheme());
        this.withNativeHistogramBucketLimit(instance.getNativeHistogramBucketLimit());
        this.withNativeHistogramMinBucketFactor(instance.getNativeHistogramMinBucketFactor());
        this.withNoProxy(instance.getNoProxy());
        this.withNomadSDConfigs(instance.getNomadSDConfigs());
        this.withOauth2(instance.getOauth2());
        this.withOpenstackSDConfigs(instance.getOpenstackSDConfigs());
        this.withOvhcloudSDConfigs(instance.getOvhcloudSDConfigs());
        this.withParams(instance.getParams());
        this.withProxyConnectHeader(instance.getProxyConnectHeader());
        this.withProxyFromEnvironment(instance.getProxyFromEnvironment());
        this.withProxyUrl(instance.getProxyUrl());
        this.withPuppetDBSDConfigs(instance.getPuppetDBSDConfigs());
        this.withRelabelings(instance.getRelabelings());
        this.withSampleLimit(instance.getSampleLimit());
        this.withScalewaySDConfigs(instance.getScalewaySDConfigs());
        this.withScheme(instance.getScheme());
        this.withScrapeClass(instance.getScrapeClass());
        this.withScrapeClassicHistograms(instance.getScrapeClassicHistograms());
        this.withScrapeInterval(instance.getScrapeInterval());
        this.withScrapeNativeHistograms(instance.getScrapeNativeHistograms());
        this.withScrapeProtocols(instance.getScrapeProtocols());
        this.withScrapeTimeout(instance.getScrapeTimeout());
        this.withStaticConfigs(instance.getStaticConfigs());
        this.withTargetLimit(instance.getTargetLimit());
        this.withTlsConfig(instance.getTlsConfig());
        this.withTrackTimestampsStaleness(instance.getTrackTimestampsStaleness());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AuthorizationNested<A> editAuthorization() {
    return this.withNewAuthorizationLike(Optional.ofNullable(this.buildAuthorization()).orElse(null));
  }
  
  public AzureSDConfigsNested<A> editAzureSDConfig(int index) {
    if (azureSDConfigs.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "azureSDConfigs"));
    }
    return this.setNewAzureSDConfigLike(index, this.buildAzureSDConfig(index));
  }
  
  public BasicAuthNested<A> editBasicAuth() {
    return this.withNewBasicAuthLike(Optional.ofNullable(this.buildBasicAuth()).orElse(null));
  }
  
  public ConsulSDConfigsNested<A> editConsulSDConfig(int index) {
    if (consulSDConfigs.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "consulSDConfigs"));
    }
    return this.setNewConsulSDConfigLike(index, this.buildConsulSDConfig(index));
  }
  
  public DigitalOceanSDConfigsNested<A> editDigitalOceanSDConfig(int index) {
    if (digitalOceanSDConfigs.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "digitalOceanSDConfigs"));
    }
    return this.setNewDigitalOceanSDConfigLike(index, this.buildDigitalOceanSDConfig(index));
  }
  
  public DnsSDConfigsNested<A> editDnsSDConfig(int index) {
    if (dnsSDConfigs.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "dnsSDConfigs"));
    }
    return this.setNewDnsSDConfigLike(index, this.buildDnsSDConfig(index));
  }
  
  public DockerSDConfigsNested<A> editDockerSDConfig(int index) {
    if (dockerSDConfigs.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "dockerSDConfigs"));
    }
    return this.setNewDockerSDConfigLike(index, this.buildDockerSDConfig(index));
  }
  
  public DockerSwarmSDConfigsNested<A> editDockerSwarmSDConfig(int index) {
    if (dockerSwarmSDConfigs.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "dockerSwarmSDConfigs"));
    }
    return this.setNewDockerSwarmSDConfigLike(index, this.buildDockerSwarmSDConfig(index));
  }
  
  public Ec2SDConfigsNested<A> editEc2SDConfig(int index) {
    if (ec2SDConfigs.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "ec2SDConfigs"));
    }
    return this.setNewEc2SDConfigLike(index, this.buildEc2SDConfig(index));
  }
  
  public EurekaSDConfigsNested<A> editEurekaSDConfig(int index) {
    if (eurekaSDConfigs.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "eurekaSDConfigs"));
    }
    return this.setNewEurekaSDConfigLike(index, this.buildEurekaSDConfig(index));
  }
  
  public FileSDConfigsNested<A> editFileSDConfig(int index) {
    if (fileSDConfigs.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "fileSDConfigs"));
    }
    return this.setNewFileSDConfigLike(index, this.buildFileSDConfig(index));
  }
  
  public AzureSDConfigsNested<A> editFirstAzureSDConfig() {
    if (azureSDConfigs.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "azureSDConfigs"));
    }
    return this.setNewAzureSDConfigLike(0, this.buildAzureSDConfig(0));
  }
  
  public ConsulSDConfigsNested<A> editFirstConsulSDConfig() {
    if (consulSDConfigs.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "consulSDConfigs"));
    }
    return this.setNewConsulSDConfigLike(0, this.buildConsulSDConfig(0));
  }
  
  public DigitalOceanSDConfigsNested<A> editFirstDigitalOceanSDConfig() {
    if (digitalOceanSDConfigs.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "digitalOceanSDConfigs"));
    }
    return this.setNewDigitalOceanSDConfigLike(0, this.buildDigitalOceanSDConfig(0));
  }
  
  public DnsSDConfigsNested<A> editFirstDnsSDConfig() {
    if (dnsSDConfigs.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "dnsSDConfigs"));
    }
    return this.setNewDnsSDConfigLike(0, this.buildDnsSDConfig(0));
  }
  
  public DockerSDConfigsNested<A> editFirstDockerSDConfig() {
    if (dockerSDConfigs.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "dockerSDConfigs"));
    }
    return this.setNewDockerSDConfigLike(0, this.buildDockerSDConfig(0));
  }
  
  public DockerSwarmSDConfigsNested<A> editFirstDockerSwarmSDConfig() {
    if (dockerSwarmSDConfigs.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "dockerSwarmSDConfigs"));
    }
    return this.setNewDockerSwarmSDConfigLike(0, this.buildDockerSwarmSDConfig(0));
  }
  
  public Ec2SDConfigsNested<A> editFirstEc2SDConfig() {
    if (ec2SDConfigs.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "ec2SDConfigs"));
    }
    return this.setNewEc2SDConfigLike(0, this.buildEc2SDConfig(0));
  }
  
  public EurekaSDConfigsNested<A> editFirstEurekaSDConfig() {
    if (eurekaSDConfigs.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "eurekaSDConfigs"));
    }
    return this.setNewEurekaSDConfigLike(0, this.buildEurekaSDConfig(0));
  }
  
  public FileSDConfigsNested<A> editFirstFileSDConfig() {
    if (fileSDConfigs.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "fileSDConfigs"));
    }
    return this.setNewFileSDConfigLike(0, this.buildFileSDConfig(0));
  }
  
  public GceSDConfigsNested<A> editFirstGceSDConfig() {
    if (gceSDConfigs.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "gceSDConfigs"));
    }
    return this.setNewGceSDConfigLike(0, this.buildGceSDConfig(0));
  }
  
  public HetznerSDConfigsNested<A> editFirstHetznerSDConfig() {
    if (hetznerSDConfigs.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "hetznerSDConfigs"));
    }
    return this.setNewHetznerSDConfigLike(0, this.buildHetznerSDConfig(0));
  }
  
  public HttpSDConfigsNested<A> editFirstHttpSDConfig() {
    if (httpSDConfigs.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "httpSDConfigs"));
    }
    return this.setNewHttpSDConfigLike(0, this.buildHttpSDConfig(0));
  }
  
  public IonosSDConfigsNested<A> editFirstIonosSDConfig() {
    if (ionosSDConfigs.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "ionosSDConfigs"));
    }
    return this.setNewIonosSDConfigLike(0, this.buildIonosSDConfig(0));
  }
  
  public KubernetesSDConfigsNested<A> editFirstKubernetesSDConfig() {
    if (kubernetesSDConfigs.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "kubernetesSDConfigs"));
    }
    return this.setNewKubernetesSDConfigLike(0, this.buildKubernetesSDConfig(0));
  }
  
  public KumaSDConfigsNested<A> editFirstKumaSDConfig() {
    if (kumaSDConfigs.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "kumaSDConfigs"));
    }
    return this.setNewKumaSDConfigLike(0, this.buildKumaSDConfig(0));
  }
  
  public LightSailSDConfigsNested<A> editFirstLightSailSDConfig() {
    if (lightSailSDConfigs.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "lightSailSDConfigs"));
    }
    return this.setNewLightSailSDConfigLike(0, this.buildLightSailSDConfig(0));
  }
  
  public LinodeSDConfigsNested<A> editFirstLinodeSDConfig() {
    if (linodeSDConfigs.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "linodeSDConfigs"));
    }
    return this.setNewLinodeSDConfigLike(0, this.buildLinodeSDConfig(0));
  }
  
  public MetricRelabelingsNested<A> editFirstMetricRelabeling() {
    if (metricRelabelings.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "metricRelabelings"));
    }
    return this.setNewMetricRelabelingLike(0, this.buildMetricRelabeling(0));
  }
  
  public NomadSDConfigsNested<A> editFirstNomadSDConfig() {
    if (nomadSDConfigs.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "nomadSDConfigs"));
    }
    return this.setNewNomadSDConfigLike(0, this.buildNomadSDConfig(0));
  }
  
  public OpenstackSDConfigsNested<A> editFirstOpenstackSDConfig() {
    if (openstackSDConfigs.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "openstackSDConfigs"));
    }
    return this.setNewOpenstackSDConfigLike(0, this.buildOpenstackSDConfig(0));
  }
  
  public OvhcloudSDConfigsNested<A> editFirstOvhcloudSDConfig() {
    if (ovhcloudSDConfigs.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "ovhcloudSDConfigs"));
    }
    return this.setNewOvhcloudSDConfigLike(0, this.buildOvhcloudSDConfig(0));
  }
  
  public PuppetDBSDConfigsNested<A> editFirstPuppetDBSDConfig() {
    if (puppetDBSDConfigs.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "puppetDBSDConfigs"));
    }
    return this.setNewPuppetDBSDConfigLike(0, this.buildPuppetDBSDConfig(0));
  }
  
  public RelabelingsNested<A> editFirstRelabeling() {
    if (relabelings.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "relabelings"));
    }
    return this.setNewRelabelingLike(0, this.buildRelabeling(0));
  }
  
  public ScalewaySDConfigsNested<A> editFirstScalewaySDConfig() {
    if (scalewaySDConfigs.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "scalewaySDConfigs"));
    }
    return this.setNewScalewaySDConfigLike(0, this.buildScalewaySDConfig(0));
  }
  
  public StaticConfigsNested<A> editFirstStaticConfig() {
    if (staticConfigs.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "staticConfigs"));
    }
    return this.setNewStaticConfigLike(0, this.buildStaticConfig(0));
  }
  
  public GceSDConfigsNested<A> editGceSDConfig(int index) {
    if (gceSDConfigs.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "gceSDConfigs"));
    }
    return this.setNewGceSDConfigLike(index, this.buildGceSDConfig(index));
  }
  
  public HetznerSDConfigsNested<A> editHetznerSDConfig(int index) {
    if (hetznerSDConfigs.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "hetznerSDConfigs"));
    }
    return this.setNewHetznerSDConfigLike(index, this.buildHetznerSDConfig(index));
  }
  
  public HttpSDConfigsNested<A> editHttpSDConfig(int index) {
    if (httpSDConfigs.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "httpSDConfigs"));
    }
    return this.setNewHttpSDConfigLike(index, this.buildHttpSDConfig(index));
  }
  
  public IonosSDConfigsNested<A> editIonosSDConfig(int index) {
    if (ionosSDConfigs.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "ionosSDConfigs"));
    }
    return this.setNewIonosSDConfigLike(index, this.buildIonosSDConfig(index));
  }
  
  public KubernetesSDConfigsNested<A> editKubernetesSDConfig(int index) {
    if (kubernetesSDConfigs.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "kubernetesSDConfigs"));
    }
    return this.setNewKubernetesSDConfigLike(index, this.buildKubernetesSDConfig(index));
  }
  
  public KumaSDConfigsNested<A> editKumaSDConfig(int index) {
    if (kumaSDConfigs.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "kumaSDConfigs"));
    }
    return this.setNewKumaSDConfigLike(index, this.buildKumaSDConfig(index));
  }
  
  public AzureSDConfigsNested<A> editLastAzureSDConfig() {
    int index = azureSDConfigs.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "azureSDConfigs"));
    }
    return this.setNewAzureSDConfigLike(index, this.buildAzureSDConfig(index));
  }
  
  public ConsulSDConfigsNested<A> editLastConsulSDConfig() {
    int index = consulSDConfigs.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "consulSDConfigs"));
    }
    return this.setNewConsulSDConfigLike(index, this.buildConsulSDConfig(index));
  }
  
  public DigitalOceanSDConfigsNested<A> editLastDigitalOceanSDConfig() {
    int index = digitalOceanSDConfigs.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "digitalOceanSDConfigs"));
    }
    return this.setNewDigitalOceanSDConfigLike(index, this.buildDigitalOceanSDConfig(index));
  }
  
  public DnsSDConfigsNested<A> editLastDnsSDConfig() {
    int index = dnsSDConfigs.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "dnsSDConfigs"));
    }
    return this.setNewDnsSDConfigLike(index, this.buildDnsSDConfig(index));
  }
  
  public DockerSDConfigsNested<A> editLastDockerSDConfig() {
    int index = dockerSDConfigs.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "dockerSDConfigs"));
    }
    return this.setNewDockerSDConfigLike(index, this.buildDockerSDConfig(index));
  }
  
  public DockerSwarmSDConfigsNested<A> editLastDockerSwarmSDConfig() {
    int index = dockerSwarmSDConfigs.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "dockerSwarmSDConfigs"));
    }
    return this.setNewDockerSwarmSDConfigLike(index, this.buildDockerSwarmSDConfig(index));
  }
  
  public Ec2SDConfigsNested<A> editLastEc2SDConfig() {
    int index = ec2SDConfigs.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "ec2SDConfigs"));
    }
    return this.setNewEc2SDConfigLike(index, this.buildEc2SDConfig(index));
  }
  
  public EurekaSDConfigsNested<A> editLastEurekaSDConfig() {
    int index = eurekaSDConfigs.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "eurekaSDConfigs"));
    }
    return this.setNewEurekaSDConfigLike(index, this.buildEurekaSDConfig(index));
  }
  
  public FileSDConfigsNested<A> editLastFileSDConfig() {
    int index = fileSDConfigs.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "fileSDConfigs"));
    }
    return this.setNewFileSDConfigLike(index, this.buildFileSDConfig(index));
  }
  
  public GceSDConfigsNested<A> editLastGceSDConfig() {
    int index = gceSDConfigs.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "gceSDConfigs"));
    }
    return this.setNewGceSDConfigLike(index, this.buildGceSDConfig(index));
  }
  
  public HetznerSDConfigsNested<A> editLastHetznerSDConfig() {
    int index = hetznerSDConfigs.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "hetznerSDConfigs"));
    }
    return this.setNewHetznerSDConfigLike(index, this.buildHetznerSDConfig(index));
  }
  
  public HttpSDConfigsNested<A> editLastHttpSDConfig() {
    int index = httpSDConfigs.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "httpSDConfigs"));
    }
    return this.setNewHttpSDConfigLike(index, this.buildHttpSDConfig(index));
  }
  
  public IonosSDConfigsNested<A> editLastIonosSDConfig() {
    int index = ionosSDConfigs.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "ionosSDConfigs"));
    }
    return this.setNewIonosSDConfigLike(index, this.buildIonosSDConfig(index));
  }
  
  public KubernetesSDConfigsNested<A> editLastKubernetesSDConfig() {
    int index = kubernetesSDConfigs.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "kubernetesSDConfigs"));
    }
    return this.setNewKubernetesSDConfigLike(index, this.buildKubernetesSDConfig(index));
  }
  
  public KumaSDConfigsNested<A> editLastKumaSDConfig() {
    int index = kumaSDConfigs.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "kumaSDConfigs"));
    }
    return this.setNewKumaSDConfigLike(index, this.buildKumaSDConfig(index));
  }
  
  public LightSailSDConfigsNested<A> editLastLightSailSDConfig() {
    int index = lightSailSDConfigs.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "lightSailSDConfigs"));
    }
    return this.setNewLightSailSDConfigLike(index, this.buildLightSailSDConfig(index));
  }
  
  public LinodeSDConfigsNested<A> editLastLinodeSDConfig() {
    int index = linodeSDConfigs.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "linodeSDConfigs"));
    }
    return this.setNewLinodeSDConfigLike(index, this.buildLinodeSDConfig(index));
  }
  
  public MetricRelabelingsNested<A> editLastMetricRelabeling() {
    int index = metricRelabelings.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "metricRelabelings"));
    }
    return this.setNewMetricRelabelingLike(index, this.buildMetricRelabeling(index));
  }
  
  public NomadSDConfigsNested<A> editLastNomadSDConfig() {
    int index = nomadSDConfigs.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "nomadSDConfigs"));
    }
    return this.setNewNomadSDConfigLike(index, this.buildNomadSDConfig(index));
  }
  
  public OpenstackSDConfigsNested<A> editLastOpenstackSDConfig() {
    int index = openstackSDConfigs.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "openstackSDConfigs"));
    }
    return this.setNewOpenstackSDConfigLike(index, this.buildOpenstackSDConfig(index));
  }
  
  public OvhcloudSDConfigsNested<A> editLastOvhcloudSDConfig() {
    int index = ovhcloudSDConfigs.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "ovhcloudSDConfigs"));
    }
    return this.setNewOvhcloudSDConfigLike(index, this.buildOvhcloudSDConfig(index));
  }
  
  public PuppetDBSDConfigsNested<A> editLastPuppetDBSDConfig() {
    int index = puppetDBSDConfigs.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "puppetDBSDConfigs"));
    }
    return this.setNewPuppetDBSDConfigLike(index, this.buildPuppetDBSDConfig(index));
  }
  
  public RelabelingsNested<A> editLastRelabeling() {
    int index = relabelings.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "relabelings"));
    }
    return this.setNewRelabelingLike(index, this.buildRelabeling(index));
  }
  
  public ScalewaySDConfigsNested<A> editLastScalewaySDConfig() {
    int index = scalewaySDConfigs.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "scalewaySDConfigs"));
    }
    return this.setNewScalewaySDConfigLike(index, this.buildScalewaySDConfig(index));
  }
  
  public StaticConfigsNested<A> editLastStaticConfig() {
    int index = staticConfigs.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "staticConfigs"));
    }
    return this.setNewStaticConfigLike(index, this.buildStaticConfig(index));
  }
  
  public LightSailSDConfigsNested<A> editLightSailSDConfig(int index) {
    if (lightSailSDConfigs.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "lightSailSDConfigs"));
    }
    return this.setNewLightSailSDConfigLike(index, this.buildLightSailSDConfig(index));
  }
  
  public LinodeSDConfigsNested<A> editLinodeSDConfig(int index) {
    if (linodeSDConfigs.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "linodeSDConfigs"));
    }
    return this.setNewLinodeSDConfigLike(index, this.buildLinodeSDConfig(index));
  }
  
  public AzureSDConfigsNested<A> editMatchingAzureSDConfig(Predicate<AzureSDConfigBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < azureSDConfigs.size();i++) {
      if (predicate.test(azureSDConfigs.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "azureSDConfigs"));
    }
    return this.setNewAzureSDConfigLike(index, this.buildAzureSDConfig(index));
  }
  
  public ConsulSDConfigsNested<A> editMatchingConsulSDConfig(Predicate<ConsulSDConfigBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < consulSDConfigs.size();i++) {
      if (predicate.test(consulSDConfigs.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "consulSDConfigs"));
    }
    return this.setNewConsulSDConfigLike(index, this.buildConsulSDConfig(index));
  }
  
  public DigitalOceanSDConfigsNested<A> editMatchingDigitalOceanSDConfig(Predicate<DigitalOceanSDConfigBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < digitalOceanSDConfigs.size();i++) {
      if (predicate.test(digitalOceanSDConfigs.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "digitalOceanSDConfigs"));
    }
    return this.setNewDigitalOceanSDConfigLike(index, this.buildDigitalOceanSDConfig(index));
  }
  
  public DnsSDConfigsNested<A> editMatchingDnsSDConfig(Predicate<DNSSDConfigBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < dnsSDConfigs.size();i++) {
      if (predicate.test(dnsSDConfigs.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "dnsSDConfigs"));
    }
    return this.setNewDnsSDConfigLike(index, this.buildDnsSDConfig(index));
  }
  
  public DockerSDConfigsNested<A> editMatchingDockerSDConfig(Predicate<DockerSDConfigBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < dockerSDConfigs.size();i++) {
      if (predicate.test(dockerSDConfigs.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "dockerSDConfigs"));
    }
    return this.setNewDockerSDConfigLike(index, this.buildDockerSDConfig(index));
  }
  
  public DockerSwarmSDConfigsNested<A> editMatchingDockerSwarmSDConfig(Predicate<DockerSwarmSDConfigBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < dockerSwarmSDConfigs.size();i++) {
      if (predicate.test(dockerSwarmSDConfigs.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "dockerSwarmSDConfigs"));
    }
    return this.setNewDockerSwarmSDConfigLike(index, this.buildDockerSwarmSDConfig(index));
  }
  
  public Ec2SDConfigsNested<A> editMatchingEc2SDConfig(Predicate<EC2SDConfigBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < ec2SDConfigs.size();i++) {
      if (predicate.test(ec2SDConfigs.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "ec2SDConfigs"));
    }
    return this.setNewEc2SDConfigLike(index, this.buildEc2SDConfig(index));
  }
  
  public EurekaSDConfigsNested<A> editMatchingEurekaSDConfig(Predicate<EurekaSDConfigBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < eurekaSDConfigs.size();i++) {
      if (predicate.test(eurekaSDConfigs.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "eurekaSDConfigs"));
    }
    return this.setNewEurekaSDConfigLike(index, this.buildEurekaSDConfig(index));
  }
  
  public FileSDConfigsNested<A> editMatchingFileSDConfig(Predicate<FileSDConfigBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < fileSDConfigs.size();i++) {
      if (predicate.test(fileSDConfigs.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "fileSDConfigs"));
    }
    return this.setNewFileSDConfigLike(index, this.buildFileSDConfig(index));
  }
  
  public GceSDConfigsNested<A> editMatchingGceSDConfig(Predicate<GCESDConfigBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < gceSDConfigs.size();i++) {
      if (predicate.test(gceSDConfigs.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "gceSDConfigs"));
    }
    return this.setNewGceSDConfigLike(index, this.buildGceSDConfig(index));
  }
  
  public HetznerSDConfigsNested<A> editMatchingHetznerSDConfig(Predicate<HetznerSDConfigBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < hetznerSDConfigs.size();i++) {
      if (predicate.test(hetznerSDConfigs.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "hetznerSDConfigs"));
    }
    return this.setNewHetznerSDConfigLike(index, this.buildHetznerSDConfig(index));
  }
  
  public HttpSDConfigsNested<A> editMatchingHttpSDConfig(Predicate<HTTPSDConfigBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < httpSDConfigs.size();i++) {
      if (predicate.test(httpSDConfigs.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "httpSDConfigs"));
    }
    return this.setNewHttpSDConfigLike(index, this.buildHttpSDConfig(index));
  }
  
  public IonosSDConfigsNested<A> editMatchingIonosSDConfig(Predicate<IonosSDConfigBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < ionosSDConfigs.size();i++) {
      if (predicate.test(ionosSDConfigs.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "ionosSDConfigs"));
    }
    return this.setNewIonosSDConfigLike(index, this.buildIonosSDConfig(index));
  }
  
  public KubernetesSDConfigsNested<A> editMatchingKubernetesSDConfig(Predicate<KubernetesSDConfigBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < kubernetesSDConfigs.size();i++) {
      if (predicate.test(kubernetesSDConfigs.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "kubernetesSDConfigs"));
    }
    return this.setNewKubernetesSDConfigLike(index, this.buildKubernetesSDConfig(index));
  }
  
  public KumaSDConfigsNested<A> editMatchingKumaSDConfig(Predicate<KumaSDConfigBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < kumaSDConfigs.size();i++) {
      if (predicate.test(kumaSDConfigs.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "kumaSDConfigs"));
    }
    return this.setNewKumaSDConfigLike(index, this.buildKumaSDConfig(index));
  }
  
  public LightSailSDConfigsNested<A> editMatchingLightSailSDConfig(Predicate<LightSailSDConfigBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < lightSailSDConfigs.size();i++) {
      if (predicate.test(lightSailSDConfigs.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "lightSailSDConfigs"));
    }
    return this.setNewLightSailSDConfigLike(index, this.buildLightSailSDConfig(index));
  }
  
  public LinodeSDConfigsNested<A> editMatchingLinodeSDConfig(Predicate<LinodeSDConfigBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < linodeSDConfigs.size();i++) {
      if (predicate.test(linodeSDConfigs.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "linodeSDConfigs"));
    }
    return this.setNewLinodeSDConfigLike(index, this.buildLinodeSDConfig(index));
  }
  
  public MetricRelabelingsNested<A> editMatchingMetricRelabeling(Predicate<RelabelConfigBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < metricRelabelings.size();i++) {
      if (predicate.test(metricRelabelings.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "metricRelabelings"));
    }
    return this.setNewMetricRelabelingLike(index, this.buildMetricRelabeling(index));
  }
  
  public NomadSDConfigsNested<A> editMatchingNomadSDConfig(Predicate<NomadSDConfigBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < nomadSDConfigs.size();i++) {
      if (predicate.test(nomadSDConfigs.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "nomadSDConfigs"));
    }
    return this.setNewNomadSDConfigLike(index, this.buildNomadSDConfig(index));
  }
  
  public OpenstackSDConfigsNested<A> editMatchingOpenstackSDConfig(Predicate<OpenStackSDConfigBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < openstackSDConfigs.size();i++) {
      if (predicate.test(openstackSDConfigs.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "openstackSDConfigs"));
    }
    return this.setNewOpenstackSDConfigLike(index, this.buildOpenstackSDConfig(index));
  }
  
  public OvhcloudSDConfigsNested<A> editMatchingOvhcloudSDConfig(Predicate<OVHCloudSDConfigBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < ovhcloudSDConfigs.size();i++) {
      if (predicate.test(ovhcloudSDConfigs.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "ovhcloudSDConfigs"));
    }
    return this.setNewOvhcloudSDConfigLike(index, this.buildOvhcloudSDConfig(index));
  }
  
  public PuppetDBSDConfigsNested<A> editMatchingPuppetDBSDConfig(Predicate<PuppetDBSDConfigBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < puppetDBSDConfigs.size();i++) {
      if (predicate.test(puppetDBSDConfigs.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "puppetDBSDConfigs"));
    }
    return this.setNewPuppetDBSDConfigLike(index, this.buildPuppetDBSDConfig(index));
  }
  
  public RelabelingsNested<A> editMatchingRelabeling(Predicate<RelabelConfigBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < relabelings.size();i++) {
      if (predicate.test(relabelings.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "relabelings"));
    }
    return this.setNewRelabelingLike(index, this.buildRelabeling(index));
  }
  
  public ScalewaySDConfigsNested<A> editMatchingScalewaySDConfig(Predicate<ScalewaySDConfigBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < scalewaySDConfigs.size();i++) {
      if (predicate.test(scalewaySDConfigs.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "scalewaySDConfigs"));
    }
    return this.setNewScalewaySDConfigLike(index, this.buildScalewaySDConfig(index));
  }
  
  public StaticConfigsNested<A> editMatchingStaticConfig(Predicate<StaticConfigBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < staticConfigs.size();i++) {
      if (predicate.test(staticConfigs.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "staticConfigs"));
    }
    return this.setNewStaticConfigLike(index, this.buildStaticConfig(index));
  }
  
  public MetricRelabelingsNested<A> editMetricRelabeling(int index) {
    if (metricRelabelings.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "metricRelabelings"));
    }
    return this.setNewMetricRelabelingLike(index, this.buildMetricRelabeling(index));
  }
  
  public NomadSDConfigsNested<A> editNomadSDConfig(int index) {
    if (nomadSDConfigs.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "nomadSDConfigs"));
    }
    return this.setNewNomadSDConfigLike(index, this.buildNomadSDConfig(index));
  }
  
  public Oauth2Nested<A> editOauth2() {
    return this.withNewOauth2Like(Optional.ofNullable(this.buildOauth2()).orElse(null));
  }
  
  public OpenstackSDConfigsNested<A> editOpenstackSDConfig(int index) {
    if (openstackSDConfigs.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "openstackSDConfigs"));
    }
    return this.setNewOpenstackSDConfigLike(index, this.buildOpenstackSDConfig(index));
  }
  
  public AuthorizationNested<A> editOrNewAuthorization() {
    return this.withNewAuthorizationLike(Optional.ofNullable(this.buildAuthorization()).orElse(new SafeAuthorizationBuilder().build()));
  }
  
  public AuthorizationNested<A> editOrNewAuthorizationLike(SafeAuthorization item) {
    return this.withNewAuthorizationLike(Optional.ofNullable(this.buildAuthorization()).orElse(item));
  }
  
  public BasicAuthNested<A> editOrNewBasicAuth() {
    return this.withNewBasicAuthLike(Optional.ofNullable(this.buildBasicAuth()).orElse(new BasicAuthBuilder().build()));
  }
  
  public BasicAuthNested<A> editOrNewBasicAuthLike(BasicAuth item) {
    return this.withNewBasicAuthLike(Optional.ofNullable(this.buildBasicAuth()).orElse(item));
  }
  
  public Oauth2Nested<A> editOrNewOauth2() {
    return this.withNewOauth2Like(Optional.ofNullable(this.buildOauth2()).orElse(new OAuth2Builder().build()));
  }
  
  public Oauth2Nested<A> editOrNewOauth2Like(OAuth2 item) {
    return this.withNewOauth2Like(Optional.ofNullable(this.buildOauth2()).orElse(item));
  }
  
  public TlsConfigNested<A> editOrNewTlsConfig() {
    return this.withNewTlsConfigLike(Optional.ofNullable(this.buildTlsConfig()).orElse(new SafeTLSConfigBuilder().build()));
  }
  
  public TlsConfigNested<A> editOrNewTlsConfigLike(SafeTLSConfig item) {
    return this.withNewTlsConfigLike(Optional.ofNullable(this.buildTlsConfig()).orElse(item));
  }
  
  public OvhcloudSDConfigsNested<A> editOvhcloudSDConfig(int index) {
    if (ovhcloudSDConfigs.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "ovhcloudSDConfigs"));
    }
    return this.setNewOvhcloudSDConfigLike(index, this.buildOvhcloudSDConfig(index));
  }
  
  public PuppetDBSDConfigsNested<A> editPuppetDBSDConfig(int index) {
    if (puppetDBSDConfigs.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "puppetDBSDConfigs"));
    }
    return this.setNewPuppetDBSDConfigLike(index, this.buildPuppetDBSDConfig(index));
  }
  
  public RelabelingsNested<A> editRelabeling(int index) {
    if (relabelings.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "relabelings"));
    }
    return this.setNewRelabelingLike(index, this.buildRelabeling(index));
  }
  
  public ScalewaySDConfigsNested<A> editScalewaySDConfig(int index) {
    if (scalewaySDConfigs.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "scalewaySDConfigs"));
    }
    return this.setNewScalewaySDConfigLike(index, this.buildScalewaySDConfig(index));
  }
  
  public StaticConfigsNested<A> editStaticConfig(int index) {
    if (staticConfigs.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "staticConfigs"));
    }
    return this.setNewStaticConfigLike(index, this.buildStaticConfig(index));
  }
  
  public TlsConfigNested<A> editTlsConfig() {
    return this.withNewTlsConfigLike(Optional.ofNullable(this.buildTlsConfig()).orElse(null));
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
    ScrapeConfigSpecFluent that = (ScrapeConfigSpecFluent) o;
    if (!(Objects.equals(authorization, that.authorization))) {
      return false;
    }
    if (!(Objects.equals(azureSDConfigs, that.azureSDConfigs))) {
      return false;
    }
    if (!(Objects.equals(basicAuth, that.basicAuth))) {
      return false;
    }
    if (!(Objects.equals(bodySizeLimit, that.bodySizeLimit))) {
      return false;
    }
    if (!(Objects.equals(consulSDConfigs, that.consulSDConfigs))) {
      return false;
    }
    if (!(Objects.equals(convertClassicHistogramsToNHCB, that.convertClassicHistogramsToNHCB))) {
      return false;
    }
    if (!(Objects.equals(digitalOceanSDConfigs, that.digitalOceanSDConfigs))) {
      return false;
    }
    if (!(Objects.equals(dnsSDConfigs, that.dnsSDConfigs))) {
      return false;
    }
    if (!(Objects.equals(dockerSDConfigs, that.dockerSDConfigs))) {
      return false;
    }
    if (!(Objects.equals(dockerSwarmSDConfigs, that.dockerSwarmSDConfigs))) {
      return false;
    }
    if (!(Objects.equals(ec2SDConfigs, that.ec2SDConfigs))) {
      return false;
    }
    if (!(Objects.equals(enableCompression, that.enableCompression))) {
      return false;
    }
    if (!(Objects.equals(enableHTTP2, that.enableHTTP2))) {
      return false;
    }
    if (!(Objects.equals(eurekaSDConfigs, that.eurekaSDConfigs))) {
      return false;
    }
    if (!(Objects.equals(fallbackScrapeProtocol, that.fallbackScrapeProtocol))) {
      return false;
    }
    if (!(Objects.equals(fileSDConfigs, that.fileSDConfigs))) {
      return false;
    }
    if (!(Objects.equals(gceSDConfigs, that.gceSDConfigs))) {
      return false;
    }
    if (!(Objects.equals(hetznerSDConfigs, that.hetznerSDConfigs))) {
      return false;
    }
    if (!(Objects.equals(honorLabels, that.honorLabels))) {
      return false;
    }
    if (!(Objects.equals(honorTimestamps, that.honorTimestamps))) {
      return false;
    }
    if (!(Objects.equals(httpSDConfigs, that.httpSDConfigs))) {
      return false;
    }
    if (!(Objects.equals(ionosSDConfigs, that.ionosSDConfigs))) {
      return false;
    }
    if (!(Objects.equals(jobName, that.jobName))) {
      return false;
    }
    if (!(Objects.equals(keepDroppedTargets, that.keepDroppedTargets))) {
      return false;
    }
    if (!(Objects.equals(kubernetesSDConfigs, that.kubernetesSDConfigs))) {
      return false;
    }
    if (!(Objects.equals(kumaSDConfigs, that.kumaSDConfigs))) {
      return false;
    }
    if (!(Objects.equals(labelLimit, that.labelLimit))) {
      return false;
    }
    if (!(Objects.equals(labelNameLengthLimit, that.labelNameLengthLimit))) {
      return false;
    }
    if (!(Objects.equals(labelValueLengthLimit, that.labelValueLengthLimit))) {
      return false;
    }
    if (!(Objects.equals(lightSailSDConfigs, that.lightSailSDConfigs))) {
      return false;
    }
    if (!(Objects.equals(linodeSDConfigs, that.linodeSDConfigs))) {
      return false;
    }
    if (!(Objects.equals(metricRelabelings, that.metricRelabelings))) {
      return false;
    }
    if (!(Objects.equals(metricsPath, that.metricsPath))) {
      return false;
    }
    if (!(Objects.equals(nameEscapingScheme, that.nameEscapingScheme))) {
      return false;
    }
    if (!(Objects.equals(nameValidationScheme, that.nameValidationScheme))) {
      return false;
    }
    if (!(Objects.equals(nativeHistogramBucketLimit, that.nativeHistogramBucketLimit))) {
      return false;
    }
    if (!(Objects.equals(nativeHistogramMinBucketFactor, that.nativeHistogramMinBucketFactor))) {
      return false;
    }
    if (!(Objects.equals(noProxy, that.noProxy))) {
      return false;
    }
    if (!(Objects.equals(nomadSDConfigs, that.nomadSDConfigs))) {
      return false;
    }
    if (!(Objects.equals(oauth2, that.oauth2))) {
      return false;
    }
    if (!(Objects.equals(openstackSDConfigs, that.openstackSDConfigs))) {
      return false;
    }
    if (!(Objects.equals(ovhcloudSDConfigs, that.ovhcloudSDConfigs))) {
      return false;
    }
    if (!(Objects.equals(params, that.params))) {
      return false;
    }
    if (!(Objects.equals(proxyConnectHeader, that.proxyConnectHeader))) {
      return false;
    }
    if (!(Objects.equals(proxyFromEnvironment, that.proxyFromEnvironment))) {
      return false;
    }
    if (!(Objects.equals(proxyUrl, that.proxyUrl))) {
      return false;
    }
    if (!(Objects.equals(puppetDBSDConfigs, that.puppetDBSDConfigs))) {
      return false;
    }
    if (!(Objects.equals(relabelings, that.relabelings))) {
      return false;
    }
    if (!(Objects.equals(sampleLimit, that.sampleLimit))) {
      return false;
    }
    if (!(Objects.equals(scalewaySDConfigs, that.scalewaySDConfigs))) {
      return false;
    }
    if (!(Objects.equals(scheme, that.scheme))) {
      return false;
    }
    if (!(Objects.equals(scrapeClass, that.scrapeClass))) {
      return false;
    }
    if (!(Objects.equals(scrapeClassicHistograms, that.scrapeClassicHistograms))) {
      return false;
    }
    if (!(Objects.equals(scrapeInterval, that.scrapeInterval))) {
      return false;
    }
    if (!(Objects.equals(scrapeNativeHistograms, that.scrapeNativeHistograms))) {
      return false;
    }
    if (!(Objects.equals(scrapeProtocols, that.scrapeProtocols))) {
      return false;
    }
    if (!(Objects.equals(scrapeTimeout, that.scrapeTimeout))) {
      return false;
    }
    if (!(Objects.equals(staticConfigs, that.staticConfigs))) {
      return false;
    }
    if (!(Objects.equals(targetLimit, that.targetLimit))) {
      return false;
    }
    if (!(Objects.equals(tlsConfig, that.tlsConfig))) {
      return false;
    }
    if (!(Objects.equals(trackTimestampsStaleness, that.trackTimestampsStaleness))) {
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
  
  public String getBodySizeLimit() {
    return this.bodySizeLimit;
  }
  
  public Boolean getConvertClassicHistogramsToNHCB() {
    return this.convertClassicHistogramsToNHCB;
  }
  
  public Boolean getEnableCompression() {
    return this.enableCompression;
  }
  
  public Boolean getEnableHTTP2() {
    return this.enableHTTP2;
  }
  
  public String getFallbackScrapeProtocol() {
    return this.fallbackScrapeProtocol;
  }
  
  public String getFirstScrapeProtocol() {
    return this.scrapeProtocols.get(0);
  }
  
  public Boolean getHonorLabels() {
    return this.honorLabels;
  }
  
  public Boolean getHonorTimestamps() {
    return this.honorTimestamps;
  }
  
  public String getJobName() {
    return this.jobName;
  }
  
  public Long getKeepDroppedTargets() {
    return this.keepDroppedTargets;
  }
  
  public Long getLabelLimit() {
    return this.labelLimit;
  }
  
  public Long getLabelNameLengthLimit() {
    return this.labelNameLengthLimit;
  }
  
  public Long getLabelValueLengthLimit() {
    return this.labelValueLengthLimit;
  }
  
  public String getLastScrapeProtocol() {
    return this.scrapeProtocols.get(scrapeProtocols.size() - 1);
  }
  
  public String getMatchingScrapeProtocol(Predicate<String> predicate) {
      for (String item : scrapeProtocols) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMetricsPath() {
    return this.metricsPath;
  }
  
  public String getNameEscapingScheme() {
    return this.nameEscapingScheme;
  }
  
  public String getNameValidationScheme() {
    return this.nameValidationScheme;
  }
  
  public Long getNativeHistogramBucketLimit() {
    return this.nativeHistogramBucketLimit;
  }
  
  public Quantity getNativeHistogramMinBucketFactor() {
    return this.nativeHistogramMinBucketFactor;
  }
  
  public String getNoProxy() {
    return this.noProxy;
  }
  
  public Map<String,List<String>> getParams() {
    return this.params;
  }
  
  public Map<String,List<SecretKeySelector>> getProxyConnectHeader() {
    return this.proxyConnectHeader;
  }
  
  public Boolean getProxyFromEnvironment() {
    return this.proxyFromEnvironment;
  }
  
  public String getProxyUrl() {
    return this.proxyUrl;
  }
  
  public Long getSampleLimit() {
    return this.sampleLimit;
  }
  
  public String getScheme() {
    return this.scheme;
  }
  
  public String getScrapeClass() {
    return this.scrapeClass;
  }
  
  public Boolean getScrapeClassicHistograms() {
    return this.scrapeClassicHistograms;
  }
  
  public String getScrapeInterval() {
    return this.scrapeInterval;
  }
  
  public Boolean getScrapeNativeHistograms() {
    return this.scrapeNativeHistograms;
  }
  
  public String getScrapeProtocol(int index) {
    return this.scrapeProtocols.get(index);
  }
  
  public List<String> getScrapeProtocols() {
    return this.scrapeProtocols;
  }
  
  public String getScrapeTimeout() {
    return this.scrapeTimeout;
  }
  
  public Long getTargetLimit() {
    return this.targetLimit;
  }
  
  public Boolean getTrackTimestampsStaleness() {
    return this.trackTimestampsStaleness;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAuthorization() {
    return this.authorization != null;
  }
  
  public boolean hasAzureSDConfigs() {
    return this.azureSDConfigs != null && !(this.azureSDConfigs.isEmpty());
  }
  
  public boolean hasBasicAuth() {
    return this.basicAuth != null;
  }
  
  public boolean hasBodySizeLimit() {
    return this.bodySizeLimit != null;
  }
  
  public boolean hasConsulSDConfigs() {
    return this.consulSDConfigs != null && !(this.consulSDConfigs.isEmpty());
  }
  
  public boolean hasConvertClassicHistogramsToNHCB() {
    return this.convertClassicHistogramsToNHCB != null;
  }
  
  public boolean hasDigitalOceanSDConfigs() {
    return this.digitalOceanSDConfigs != null && !(this.digitalOceanSDConfigs.isEmpty());
  }
  
  public boolean hasDnsSDConfigs() {
    return this.dnsSDConfigs != null && !(this.dnsSDConfigs.isEmpty());
  }
  
  public boolean hasDockerSDConfigs() {
    return this.dockerSDConfigs != null && !(this.dockerSDConfigs.isEmpty());
  }
  
  public boolean hasDockerSwarmSDConfigs() {
    return this.dockerSwarmSDConfigs != null && !(this.dockerSwarmSDConfigs.isEmpty());
  }
  
  public boolean hasEc2SDConfigs() {
    return this.ec2SDConfigs != null && !(this.ec2SDConfigs.isEmpty());
  }
  
  public boolean hasEnableCompression() {
    return this.enableCompression != null;
  }
  
  public boolean hasEnableHTTP2() {
    return this.enableHTTP2 != null;
  }
  
  public boolean hasEurekaSDConfigs() {
    return this.eurekaSDConfigs != null && !(this.eurekaSDConfigs.isEmpty());
  }
  
  public boolean hasFallbackScrapeProtocol() {
    return this.fallbackScrapeProtocol != null;
  }
  
  public boolean hasFileSDConfigs() {
    return this.fileSDConfigs != null && !(this.fileSDConfigs.isEmpty());
  }
  
  public boolean hasGceSDConfigs() {
    return this.gceSDConfigs != null && !(this.gceSDConfigs.isEmpty());
  }
  
  public boolean hasHetznerSDConfigs() {
    return this.hetznerSDConfigs != null && !(this.hetznerSDConfigs.isEmpty());
  }
  
  public boolean hasHonorLabels() {
    return this.honorLabels != null;
  }
  
  public boolean hasHonorTimestamps() {
    return this.honorTimestamps != null;
  }
  
  public boolean hasHttpSDConfigs() {
    return this.httpSDConfigs != null && !(this.httpSDConfigs.isEmpty());
  }
  
  public boolean hasIonosSDConfigs() {
    return this.ionosSDConfigs != null && !(this.ionosSDConfigs.isEmpty());
  }
  
  public boolean hasJobName() {
    return this.jobName != null;
  }
  
  public boolean hasKeepDroppedTargets() {
    return this.keepDroppedTargets != null;
  }
  
  public boolean hasKubernetesSDConfigs() {
    return this.kubernetesSDConfigs != null && !(this.kubernetesSDConfigs.isEmpty());
  }
  
  public boolean hasKumaSDConfigs() {
    return this.kumaSDConfigs != null && !(this.kumaSDConfigs.isEmpty());
  }
  
  public boolean hasLabelLimit() {
    return this.labelLimit != null;
  }
  
  public boolean hasLabelNameLengthLimit() {
    return this.labelNameLengthLimit != null;
  }
  
  public boolean hasLabelValueLengthLimit() {
    return this.labelValueLengthLimit != null;
  }
  
  public boolean hasLightSailSDConfigs() {
    return this.lightSailSDConfigs != null && !(this.lightSailSDConfigs.isEmpty());
  }
  
  public boolean hasLinodeSDConfigs() {
    return this.linodeSDConfigs != null && !(this.linodeSDConfigs.isEmpty());
  }
  
  public boolean hasMatchingAzureSDConfig(Predicate<AzureSDConfigBuilder> predicate) {
      for (AzureSDConfigBuilder item : azureSDConfigs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingConsulSDConfig(Predicate<ConsulSDConfigBuilder> predicate) {
      for (ConsulSDConfigBuilder item : consulSDConfigs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingDigitalOceanSDConfig(Predicate<DigitalOceanSDConfigBuilder> predicate) {
      for (DigitalOceanSDConfigBuilder item : digitalOceanSDConfigs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingDnsSDConfig(Predicate<DNSSDConfigBuilder> predicate) {
      for (DNSSDConfigBuilder item : dnsSDConfigs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingDockerSDConfig(Predicate<DockerSDConfigBuilder> predicate) {
      for (DockerSDConfigBuilder item : dockerSDConfigs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingDockerSwarmSDConfig(Predicate<DockerSwarmSDConfigBuilder> predicate) {
      for (DockerSwarmSDConfigBuilder item : dockerSwarmSDConfigs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingEc2SDConfig(Predicate<EC2SDConfigBuilder> predicate) {
      for (EC2SDConfigBuilder item : ec2SDConfigs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingEurekaSDConfig(Predicate<EurekaSDConfigBuilder> predicate) {
      for (EurekaSDConfigBuilder item : eurekaSDConfigs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingFileSDConfig(Predicate<FileSDConfigBuilder> predicate) {
      for (FileSDConfigBuilder item : fileSDConfigs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingGceSDConfig(Predicate<GCESDConfigBuilder> predicate) {
      for (GCESDConfigBuilder item : gceSDConfigs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingHetznerSDConfig(Predicate<HetznerSDConfigBuilder> predicate) {
      for (HetznerSDConfigBuilder item : hetznerSDConfigs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingHttpSDConfig(Predicate<HTTPSDConfigBuilder> predicate) {
      for (HTTPSDConfigBuilder item : httpSDConfigs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingIonosSDConfig(Predicate<IonosSDConfigBuilder> predicate) {
      for (IonosSDConfigBuilder item : ionosSDConfigs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingKubernetesSDConfig(Predicate<KubernetesSDConfigBuilder> predicate) {
      for (KubernetesSDConfigBuilder item : kubernetesSDConfigs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingKumaSDConfig(Predicate<KumaSDConfigBuilder> predicate) {
      for (KumaSDConfigBuilder item : kumaSDConfigs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingLightSailSDConfig(Predicate<LightSailSDConfigBuilder> predicate) {
      for (LightSailSDConfigBuilder item : lightSailSDConfigs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingLinodeSDConfig(Predicate<LinodeSDConfigBuilder> predicate) {
      for (LinodeSDConfigBuilder item : linodeSDConfigs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingMetricRelabeling(Predicate<RelabelConfigBuilder> predicate) {
      for (RelabelConfigBuilder item : metricRelabelings) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingNomadSDConfig(Predicate<NomadSDConfigBuilder> predicate) {
      for (NomadSDConfigBuilder item : nomadSDConfigs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingOpenstackSDConfig(Predicate<OpenStackSDConfigBuilder> predicate) {
      for (OpenStackSDConfigBuilder item : openstackSDConfigs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingOvhcloudSDConfig(Predicate<OVHCloudSDConfigBuilder> predicate) {
      for (OVHCloudSDConfigBuilder item : ovhcloudSDConfigs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingPuppetDBSDConfig(Predicate<PuppetDBSDConfigBuilder> predicate) {
      for (PuppetDBSDConfigBuilder item : puppetDBSDConfigs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingRelabeling(Predicate<RelabelConfigBuilder> predicate) {
      for (RelabelConfigBuilder item : relabelings) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingScalewaySDConfig(Predicate<ScalewaySDConfigBuilder> predicate) {
      for (ScalewaySDConfigBuilder item : scalewaySDConfigs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingScrapeProtocol(Predicate<String> predicate) {
      for (String item : scrapeProtocols) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingStaticConfig(Predicate<StaticConfigBuilder> predicate) {
      for (StaticConfigBuilder item : staticConfigs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMetricRelabelings() {
    return this.metricRelabelings != null && !(this.metricRelabelings.isEmpty());
  }
  
  public boolean hasMetricsPath() {
    return this.metricsPath != null;
  }
  
  public boolean hasNameEscapingScheme() {
    return this.nameEscapingScheme != null;
  }
  
  public boolean hasNameValidationScheme() {
    return this.nameValidationScheme != null;
  }
  
  public boolean hasNativeHistogramBucketLimit() {
    return this.nativeHistogramBucketLimit != null;
  }
  
  public boolean hasNativeHistogramMinBucketFactor() {
    return this.nativeHistogramMinBucketFactor != null;
  }
  
  public boolean hasNoProxy() {
    return this.noProxy != null;
  }
  
  public boolean hasNomadSDConfigs() {
    return this.nomadSDConfigs != null && !(this.nomadSDConfigs.isEmpty());
  }
  
  public boolean hasOauth2() {
    return this.oauth2 != null;
  }
  
  public boolean hasOpenstackSDConfigs() {
    return this.openstackSDConfigs != null && !(this.openstackSDConfigs.isEmpty());
  }
  
  public boolean hasOvhcloudSDConfigs() {
    return this.ovhcloudSDConfigs != null && !(this.ovhcloudSDConfigs.isEmpty());
  }
  
  public boolean hasParams() {
    return this.params != null;
  }
  
  public boolean hasProxyConnectHeader() {
    return this.proxyConnectHeader != null;
  }
  
  public boolean hasProxyFromEnvironment() {
    return this.proxyFromEnvironment != null;
  }
  
  public boolean hasProxyUrl() {
    return this.proxyUrl != null;
  }
  
  public boolean hasPuppetDBSDConfigs() {
    return this.puppetDBSDConfigs != null && !(this.puppetDBSDConfigs.isEmpty());
  }
  
  public boolean hasRelabelings() {
    return this.relabelings != null && !(this.relabelings.isEmpty());
  }
  
  public boolean hasSampleLimit() {
    return this.sampleLimit != null;
  }
  
  public boolean hasScalewaySDConfigs() {
    return this.scalewaySDConfigs != null && !(this.scalewaySDConfigs.isEmpty());
  }
  
  public boolean hasScheme() {
    return this.scheme != null;
  }
  
  public boolean hasScrapeClass() {
    return this.scrapeClass != null;
  }
  
  public boolean hasScrapeClassicHistograms() {
    return this.scrapeClassicHistograms != null;
  }
  
  public boolean hasScrapeInterval() {
    return this.scrapeInterval != null;
  }
  
  public boolean hasScrapeNativeHistograms() {
    return this.scrapeNativeHistograms != null;
  }
  
  public boolean hasScrapeProtocols() {
    return this.scrapeProtocols != null && !(this.scrapeProtocols.isEmpty());
  }
  
  public boolean hasScrapeTimeout() {
    return this.scrapeTimeout != null;
  }
  
  public boolean hasStaticConfigs() {
    return this.staticConfigs != null && !(this.staticConfigs.isEmpty());
  }
  
  public boolean hasTargetLimit() {
    return this.targetLimit != null;
  }
  
  public boolean hasTlsConfig() {
    return this.tlsConfig != null;
  }
  
  public boolean hasTrackTimestampsStaleness() {
    return this.trackTimestampsStaleness != null;
  }
  
  public int hashCode() {
    return Objects.hash(authorization, azureSDConfigs, basicAuth, bodySizeLimit, consulSDConfigs, convertClassicHistogramsToNHCB, digitalOceanSDConfigs, dnsSDConfigs, dockerSDConfigs, dockerSwarmSDConfigs, ec2SDConfigs, enableCompression, enableHTTP2, eurekaSDConfigs, fallbackScrapeProtocol, fileSDConfigs, gceSDConfigs, hetznerSDConfigs, honorLabels, honorTimestamps, httpSDConfigs, ionosSDConfigs, jobName, keepDroppedTargets, kubernetesSDConfigs, kumaSDConfigs, labelLimit, labelNameLengthLimit, labelValueLengthLimit, lightSailSDConfigs, linodeSDConfigs, metricRelabelings, metricsPath, nameEscapingScheme, nameValidationScheme, nativeHistogramBucketLimit, nativeHistogramMinBucketFactor, noProxy, nomadSDConfigs, oauth2, openstackSDConfigs, ovhcloudSDConfigs, params, proxyConnectHeader, proxyFromEnvironment, proxyUrl, puppetDBSDConfigs, relabelings, sampleLimit, scalewaySDConfigs, scheme, scrapeClass, scrapeClassicHistograms, scrapeInterval, scrapeNativeHistograms, scrapeProtocols, scrapeTimeout, staticConfigs, targetLimit, tlsConfig, trackTimestampsStaleness, additionalProperties);
  }
  
  public A removeAllFromAzureSDConfigs(Collection<AzureSDConfig> items) {
    if (this.azureSDConfigs == null) {
      return (A) this;
    }
    for (AzureSDConfig item : items) {
        AzureSDConfigBuilder builder = new AzureSDConfigBuilder(item);
        _visitables.get("azureSDConfigs").remove(builder);
        this.azureSDConfigs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromConsulSDConfigs(Collection<ConsulSDConfig> items) {
    if (this.consulSDConfigs == null) {
      return (A) this;
    }
    for (ConsulSDConfig item : items) {
        ConsulSDConfigBuilder builder = new ConsulSDConfigBuilder(item);
        _visitables.get("consulSDConfigs").remove(builder);
        this.consulSDConfigs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromDigitalOceanSDConfigs(Collection<DigitalOceanSDConfig> items) {
    if (this.digitalOceanSDConfigs == null) {
      return (A) this;
    }
    for (DigitalOceanSDConfig item : items) {
        DigitalOceanSDConfigBuilder builder = new DigitalOceanSDConfigBuilder(item);
        _visitables.get("digitalOceanSDConfigs").remove(builder);
        this.digitalOceanSDConfigs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromDnsSDConfigs(Collection<DNSSDConfig> items) {
    if (this.dnsSDConfigs == null) {
      return (A) this;
    }
    for (DNSSDConfig item : items) {
        DNSSDConfigBuilder builder = new DNSSDConfigBuilder(item);
        _visitables.get("dnsSDConfigs").remove(builder);
        this.dnsSDConfigs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromDockerSDConfigs(Collection<DockerSDConfig> items) {
    if (this.dockerSDConfigs == null) {
      return (A) this;
    }
    for (DockerSDConfig item : items) {
        DockerSDConfigBuilder builder = new DockerSDConfigBuilder(item);
        _visitables.get("dockerSDConfigs").remove(builder);
        this.dockerSDConfigs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromDockerSwarmSDConfigs(Collection<DockerSwarmSDConfig> items) {
    if (this.dockerSwarmSDConfigs == null) {
      return (A) this;
    }
    for (DockerSwarmSDConfig item : items) {
        DockerSwarmSDConfigBuilder builder = new DockerSwarmSDConfigBuilder(item);
        _visitables.get("dockerSwarmSDConfigs").remove(builder);
        this.dockerSwarmSDConfigs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromEc2SDConfigs(Collection<EC2SDConfig> items) {
    if (this.ec2SDConfigs == null) {
      return (A) this;
    }
    for (EC2SDConfig item : items) {
        EC2SDConfigBuilder builder = new EC2SDConfigBuilder(item);
        _visitables.get("ec2SDConfigs").remove(builder);
        this.ec2SDConfigs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromEurekaSDConfigs(Collection<EurekaSDConfig> items) {
    if (this.eurekaSDConfigs == null) {
      return (A) this;
    }
    for (EurekaSDConfig item : items) {
        EurekaSDConfigBuilder builder = new EurekaSDConfigBuilder(item);
        _visitables.get("eurekaSDConfigs").remove(builder);
        this.eurekaSDConfigs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromFileSDConfigs(Collection<FileSDConfig> items) {
    if (this.fileSDConfigs == null) {
      return (A) this;
    }
    for (FileSDConfig item : items) {
        FileSDConfigBuilder builder = new FileSDConfigBuilder(item);
        _visitables.get("fileSDConfigs").remove(builder);
        this.fileSDConfigs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromGceSDConfigs(Collection<GCESDConfig> items) {
    if (this.gceSDConfigs == null) {
      return (A) this;
    }
    for (GCESDConfig item : items) {
        GCESDConfigBuilder builder = new GCESDConfigBuilder(item);
        _visitables.get("gceSDConfigs").remove(builder);
        this.gceSDConfigs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromHetznerSDConfigs(Collection<HetznerSDConfig> items) {
    if (this.hetznerSDConfigs == null) {
      return (A) this;
    }
    for (HetznerSDConfig item : items) {
        HetznerSDConfigBuilder builder = new HetznerSDConfigBuilder(item);
        _visitables.get("hetznerSDConfigs").remove(builder);
        this.hetznerSDConfigs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromHttpSDConfigs(Collection<HTTPSDConfig> items) {
    if (this.httpSDConfigs == null) {
      return (A) this;
    }
    for (HTTPSDConfig item : items) {
        HTTPSDConfigBuilder builder = new HTTPSDConfigBuilder(item);
        _visitables.get("httpSDConfigs").remove(builder);
        this.httpSDConfigs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromIonosSDConfigs(Collection<IonosSDConfig> items) {
    if (this.ionosSDConfigs == null) {
      return (A) this;
    }
    for (IonosSDConfig item : items) {
        IonosSDConfigBuilder builder = new IonosSDConfigBuilder(item);
        _visitables.get("ionosSDConfigs").remove(builder);
        this.ionosSDConfigs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromKubernetesSDConfigs(Collection<KubernetesSDConfig> items) {
    if (this.kubernetesSDConfigs == null) {
      return (A) this;
    }
    for (KubernetesSDConfig item : items) {
        KubernetesSDConfigBuilder builder = new KubernetesSDConfigBuilder(item);
        _visitables.get("kubernetesSDConfigs").remove(builder);
        this.kubernetesSDConfigs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromKumaSDConfigs(Collection<KumaSDConfig> items) {
    if (this.kumaSDConfigs == null) {
      return (A) this;
    }
    for (KumaSDConfig item : items) {
        KumaSDConfigBuilder builder = new KumaSDConfigBuilder(item);
        _visitables.get("kumaSDConfigs").remove(builder);
        this.kumaSDConfigs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromLightSailSDConfigs(Collection<LightSailSDConfig> items) {
    if (this.lightSailSDConfigs == null) {
      return (A) this;
    }
    for (LightSailSDConfig item : items) {
        LightSailSDConfigBuilder builder = new LightSailSDConfigBuilder(item);
        _visitables.get("lightSailSDConfigs").remove(builder);
        this.lightSailSDConfigs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromLinodeSDConfigs(Collection<LinodeSDConfig> items) {
    if (this.linodeSDConfigs == null) {
      return (A) this;
    }
    for (LinodeSDConfig item : items) {
        LinodeSDConfigBuilder builder = new LinodeSDConfigBuilder(item);
        _visitables.get("linodeSDConfigs").remove(builder);
        this.linodeSDConfigs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromMetricRelabelings(Collection<RelabelConfig> items) {
    if (this.metricRelabelings == null) {
      return (A) this;
    }
    for (RelabelConfig item : items) {
        RelabelConfigBuilder builder = new RelabelConfigBuilder(item);
        _visitables.get("metricRelabelings").remove(builder);
        this.metricRelabelings.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromNomadSDConfigs(Collection<NomadSDConfig> items) {
    if (this.nomadSDConfigs == null) {
      return (A) this;
    }
    for (NomadSDConfig item : items) {
        NomadSDConfigBuilder builder = new NomadSDConfigBuilder(item);
        _visitables.get("nomadSDConfigs").remove(builder);
        this.nomadSDConfigs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromOpenstackSDConfigs(Collection<OpenStackSDConfig> items) {
    if (this.openstackSDConfigs == null) {
      return (A) this;
    }
    for (OpenStackSDConfig item : items) {
        OpenStackSDConfigBuilder builder = new OpenStackSDConfigBuilder(item);
        _visitables.get("openstackSDConfigs").remove(builder);
        this.openstackSDConfigs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromOvhcloudSDConfigs(Collection<OVHCloudSDConfig> items) {
    if (this.ovhcloudSDConfigs == null) {
      return (A) this;
    }
    for (OVHCloudSDConfig item : items) {
        OVHCloudSDConfigBuilder builder = new OVHCloudSDConfigBuilder(item);
        _visitables.get("ovhcloudSDConfigs").remove(builder);
        this.ovhcloudSDConfigs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromPuppetDBSDConfigs(Collection<PuppetDBSDConfig> items) {
    if (this.puppetDBSDConfigs == null) {
      return (A) this;
    }
    for (PuppetDBSDConfig item : items) {
        PuppetDBSDConfigBuilder builder = new PuppetDBSDConfigBuilder(item);
        _visitables.get("puppetDBSDConfigs").remove(builder);
        this.puppetDBSDConfigs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromRelabelings(Collection<RelabelConfig> items) {
    if (this.relabelings == null) {
      return (A) this;
    }
    for (RelabelConfig item : items) {
        RelabelConfigBuilder builder = new RelabelConfigBuilder(item);
        _visitables.get("relabelings").remove(builder);
        this.relabelings.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromScalewaySDConfigs(Collection<ScalewaySDConfig> items) {
    if (this.scalewaySDConfigs == null) {
      return (A) this;
    }
    for (ScalewaySDConfig item : items) {
        ScalewaySDConfigBuilder builder = new ScalewaySDConfigBuilder(item);
        _visitables.get("scalewaySDConfigs").remove(builder);
        this.scalewaySDConfigs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromScrapeProtocols(Collection<String> items) {
    if (this.scrapeProtocols == null) {
      return (A) this;
    }
    for (String item : items) {
      this.scrapeProtocols.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromStaticConfigs(Collection<StaticConfig> items) {
    if (this.staticConfigs == null) {
      return (A) this;
    }
    for (StaticConfig item : items) {
        StaticConfigBuilder builder = new StaticConfigBuilder(item);
        _visitables.get("staticConfigs").remove(builder);
        this.staticConfigs.remove(builder);
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
  
  public A removeFromAzureSDConfigs(AzureSDConfig... items) {
    if (this.azureSDConfigs == null) {
      return (A) this;
    }
    for (AzureSDConfig item : items) {
        AzureSDConfigBuilder builder = new AzureSDConfigBuilder(item);
        _visitables.get("azureSDConfigs").remove(builder);
        this.azureSDConfigs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromConsulSDConfigs(ConsulSDConfig... items) {
    if (this.consulSDConfigs == null) {
      return (A) this;
    }
    for (ConsulSDConfig item : items) {
        ConsulSDConfigBuilder builder = new ConsulSDConfigBuilder(item);
        _visitables.get("consulSDConfigs").remove(builder);
        this.consulSDConfigs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromDigitalOceanSDConfigs(DigitalOceanSDConfig... items) {
    if (this.digitalOceanSDConfigs == null) {
      return (A) this;
    }
    for (DigitalOceanSDConfig item : items) {
        DigitalOceanSDConfigBuilder builder = new DigitalOceanSDConfigBuilder(item);
        _visitables.get("digitalOceanSDConfigs").remove(builder);
        this.digitalOceanSDConfigs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromDnsSDConfigs(DNSSDConfig... items) {
    if (this.dnsSDConfigs == null) {
      return (A) this;
    }
    for (DNSSDConfig item : items) {
        DNSSDConfigBuilder builder = new DNSSDConfigBuilder(item);
        _visitables.get("dnsSDConfigs").remove(builder);
        this.dnsSDConfigs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromDockerSDConfigs(DockerSDConfig... items) {
    if (this.dockerSDConfigs == null) {
      return (A) this;
    }
    for (DockerSDConfig item : items) {
        DockerSDConfigBuilder builder = new DockerSDConfigBuilder(item);
        _visitables.get("dockerSDConfigs").remove(builder);
        this.dockerSDConfigs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromDockerSwarmSDConfigs(DockerSwarmSDConfig... items) {
    if (this.dockerSwarmSDConfigs == null) {
      return (A) this;
    }
    for (DockerSwarmSDConfig item : items) {
        DockerSwarmSDConfigBuilder builder = new DockerSwarmSDConfigBuilder(item);
        _visitables.get("dockerSwarmSDConfigs").remove(builder);
        this.dockerSwarmSDConfigs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromEc2SDConfigs(EC2SDConfig... items) {
    if (this.ec2SDConfigs == null) {
      return (A) this;
    }
    for (EC2SDConfig item : items) {
        EC2SDConfigBuilder builder = new EC2SDConfigBuilder(item);
        _visitables.get("ec2SDConfigs").remove(builder);
        this.ec2SDConfigs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromEurekaSDConfigs(EurekaSDConfig... items) {
    if (this.eurekaSDConfigs == null) {
      return (A) this;
    }
    for (EurekaSDConfig item : items) {
        EurekaSDConfigBuilder builder = new EurekaSDConfigBuilder(item);
        _visitables.get("eurekaSDConfigs").remove(builder);
        this.eurekaSDConfigs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromFileSDConfigs(FileSDConfig... items) {
    if (this.fileSDConfigs == null) {
      return (A) this;
    }
    for (FileSDConfig item : items) {
        FileSDConfigBuilder builder = new FileSDConfigBuilder(item);
        _visitables.get("fileSDConfigs").remove(builder);
        this.fileSDConfigs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromGceSDConfigs(GCESDConfig... items) {
    if (this.gceSDConfigs == null) {
      return (A) this;
    }
    for (GCESDConfig item : items) {
        GCESDConfigBuilder builder = new GCESDConfigBuilder(item);
        _visitables.get("gceSDConfigs").remove(builder);
        this.gceSDConfigs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromHetznerSDConfigs(HetznerSDConfig... items) {
    if (this.hetznerSDConfigs == null) {
      return (A) this;
    }
    for (HetznerSDConfig item : items) {
        HetznerSDConfigBuilder builder = new HetznerSDConfigBuilder(item);
        _visitables.get("hetznerSDConfigs").remove(builder);
        this.hetznerSDConfigs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromHttpSDConfigs(HTTPSDConfig... items) {
    if (this.httpSDConfigs == null) {
      return (A) this;
    }
    for (HTTPSDConfig item : items) {
        HTTPSDConfigBuilder builder = new HTTPSDConfigBuilder(item);
        _visitables.get("httpSDConfigs").remove(builder);
        this.httpSDConfigs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromIonosSDConfigs(IonosSDConfig... items) {
    if (this.ionosSDConfigs == null) {
      return (A) this;
    }
    for (IonosSDConfig item : items) {
        IonosSDConfigBuilder builder = new IonosSDConfigBuilder(item);
        _visitables.get("ionosSDConfigs").remove(builder);
        this.ionosSDConfigs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromKubernetesSDConfigs(KubernetesSDConfig... items) {
    if (this.kubernetesSDConfigs == null) {
      return (A) this;
    }
    for (KubernetesSDConfig item : items) {
        KubernetesSDConfigBuilder builder = new KubernetesSDConfigBuilder(item);
        _visitables.get("kubernetesSDConfigs").remove(builder);
        this.kubernetesSDConfigs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromKumaSDConfigs(KumaSDConfig... items) {
    if (this.kumaSDConfigs == null) {
      return (A) this;
    }
    for (KumaSDConfig item : items) {
        KumaSDConfigBuilder builder = new KumaSDConfigBuilder(item);
        _visitables.get("kumaSDConfigs").remove(builder);
        this.kumaSDConfigs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromLightSailSDConfigs(LightSailSDConfig... items) {
    if (this.lightSailSDConfigs == null) {
      return (A) this;
    }
    for (LightSailSDConfig item : items) {
        LightSailSDConfigBuilder builder = new LightSailSDConfigBuilder(item);
        _visitables.get("lightSailSDConfigs").remove(builder);
        this.lightSailSDConfigs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromLinodeSDConfigs(LinodeSDConfig... items) {
    if (this.linodeSDConfigs == null) {
      return (A) this;
    }
    for (LinodeSDConfig item : items) {
        LinodeSDConfigBuilder builder = new LinodeSDConfigBuilder(item);
        _visitables.get("linodeSDConfigs").remove(builder);
        this.linodeSDConfigs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromMetricRelabelings(RelabelConfig... items) {
    if (this.metricRelabelings == null) {
      return (A) this;
    }
    for (RelabelConfig item : items) {
        RelabelConfigBuilder builder = new RelabelConfigBuilder(item);
        _visitables.get("metricRelabelings").remove(builder);
        this.metricRelabelings.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromNomadSDConfigs(NomadSDConfig... items) {
    if (this.nomadSDConfigs == null) {
      return (A) this;
    }
    for (NomadSDConfig item : items) {
        NomadSDConfigBuilder builder = new NomadSDConfigBuilder(item);
        _visitables.get("nomadSDConfigs").remove(builder);
        this.nomadSDConfigs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromOpenstackSDConfigs(OpenStackSDConfig... items) {
    if (this.openstackSDConfigs == null) {
      return (A) this;
    }
    for (OpenStackSDConfig item : items) {
        OpenStackSDConfigBuilder builder = new OpenStackSDConfigBuilder(item);
        _visitables.get("openstackSDConfigs").remove(builder);
        this.openstackSDConfigs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromOvhcloudSDConfigs(OVHCloudSDConfig... items) {
    if (this.ovhcloudSDConfigs == null) {
      return (A) this;
    }
    for (OVHCloudSDConfig item : items) {
        OVHCloudSDConfigBuilder builder = new OVHCloudSDConfigBuilder(item);
        _visitables.get("ovhcloudSDConfigs").remove(builder);
        this.ovhcloudSDConfigs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromParams(String key) {
    if (this.params == null) {
      return (A) this;
    }
    if (key != null && this.params != null) {
      this.params.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromParams(Map<String,List<String>> map) {
    if (this.params == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.params != null) {
          this.params.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromProxyConnectHeader(String key) {
    if (this.proxyConnectHeader == null) {
      return (A) this;
    }
    if (key != null && this.proxyConnectHeader != null) {
      this.proxyConnectHeader.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromProxyConnectHeader(Map<String,List<SecretKeySelector>> map) {
    if (this.proxyConnectHeader == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.proxyConnectHeader != null) {
          this.proxyConnectHeader.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromPuppetDBSDConfigs(PuppetDBSDConfig... items) {
    if (this.puppetDBSDConfigs == null) {
      return (A) this;
    }
    for (PuppetDBSDConfig item : items) {
        PuppetDBSDConfigBuilder builder = new PuppetDBSDConfigBuilder(item);
        _visitables.get("puppetDBSDConfigs").remove(builder);
        this.puppetDBSDConfigs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromRelabelings(RelabelConfig... items) {
    if (this.relabelings == null) {
      return (A) this;
    }
    for (RelabelConfig item : items) {
        RelabelConfigBuilder builder = new RelabelConfigBuilder(item);
        _visitables.get("relabelings").remove(builder);
        this.relabelings.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromScalewaySDConfigs(ScalewaySDConfig... items) {
    if (this.scalewaySDConfigs == null) {
      return (A) this;
    }
    for (ScalewaySDConfig item : items) {
        ScalewaySDConfigBuilder builder = new ScalewaySDConfigBuilder(item);
        _visitables.get("scalewaySDConfigs").remove(builder);
        this.scalewaySDConfigs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromScrapeProtocols(String... items) {
    if (this.scrapeProtocols == null) {
      return (A) this;
    }
    for (String item : items) {
      this.scrapeProtocols.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromStaticConfigs(StaticConfig... items) {
    if (this.staticConfigs == null) {
      return (A) this;
    }
    for (StaticConfig item : items) {
        StaticConfigBuilder builder = new StaticConfigBuilder(item);
        _visitables.get("staticConfigs").remove(builder);
        this.staticConfigs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromAzureSDConfigs(Predicate<AzureSDConfigBuilder> predicate) {
    if (azureSDConfigs == null) {
      return (A) this;
    }
    Iterator<AzureSDConfigBuilder> each = azureSDConfigs.iterator();
    List visitables = _visitables.get("azureSDConfigs");
    while (each.hasNext()) {
        AzureSDConfigBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromConsulSDConfigs(Predicate<ConsulSDConfigBuilder> predicate) {
    if (consulSDConfigs == null) {
      return (A) this;
    }
    Iterator<ConsulSDConfigBuilder> each = consulSDConfigs.iterator();
    List visitables = _visitables.get("consulSDConfigs");
    while (each.hasNext()) {
        ConsulSDConfigBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromDigitalOceanSDConfigs(Predicate<DigitalOceanSDConfigBuilder> predicate) {
    if (digitalOceanSDConfigs == null) {
      return (A) this;
    }
    Iterator<DigitalOceanSDConfigBuilder> each = digitalOceanSDConfigs.iterator();
    List visitables = _visitables.get("digitalOceanSDConfigs");
    while (each.hasNext()) {
        DigitalOceanSDConfigBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromDnsSDConfigs(Predicate<DNSSDConfigBuilder> predicate) {
    if (dnsSDConfigs == null) {
      return (A) this;
    }
    Iterator<DNSSDConfigBuilder> each = dnsSDConfigs.iterator();
    List visitables = _visitables.get("dnsSDConfigs");
    while (each.hasNext()) {
        DNSSDConfigBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromDockerSDConfigs(Predicate<DockerSDConfigBuilder> predicate) {
    if (dockerSDConfigs == null) {
      return (A) this;
    }
    Iterator<DockerSDConfigBuilder> each = dockerSDConfigs.iterator();
    List visitables = _visitables.get("dockerSDConfigs");
    while (each.hasNext()) {
        DockerSDConfigBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromDockerSwarmSDConfigs(Predicate<DockerSwarmSDConfigBuilder> predicate) {
    if (dockerSwarmSDConfigs == null) {
      return (A) this;
    }
    Iterator<DockerSwarmSDConfigBuilder> each = dockerSwarmSDConfigs.iterator();
    List visitables = _visitables.get("dockerSwarmSDConfigs");
    while (each.hasNext()) {
        DockerSwarmSDConfigBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromEc2SDConfigs(Predicate<EC2SDConfigBuilder> predicate) {
    if (ec2SDConfigs == null) {
      return (A) this;
    }
    Iterator<EC2SDConfigBuilder> each = ec2SDConfigs.iterator();
    List visitables = _visitables.get("ec2SDConfigs");
    while (each.hasNext()) {
        EC2SDConfigBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromEurekaSDConfigs(Predicate<EurekaSDConfigBuilder> predicate) {
    if (eurekaSDConfigs == null) {
      return (A) this;
    }
    Iterator<EurekaSDConfigBuilder> each = eurekaSDConfigs.iterator();
    List visitables = _visitables.get("eurekaSDConfigs");
    while (each.hasNext()) {
        EurekaSDConfigBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromFileSDConfigs(Predicate<FileSDConfigBuilder> predicate) {
    if (fileSDConfigs == null) {
      return (A) this;
    }
    Iterator<FileSDConfigBuilder> each = fileSDConfigs.iterator();
    List visitables = _visitables.get("fileSDConfigs");
    while (each.hasNext()) {
        FileSDConfigBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromGceSDConfigs(Predicate<GCESDConfigBuilder> predicate) {
    if (gceSDConfigs == null) {
      return (A) this;
    }
    Iterator<GCESDConfigBuilder> each = gceSDConfigs.iterator();
    List visitables = _visitables.get("gceSDConfigs");
    while (each.hasNext()) {
        GCESDConfigBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromHetznerSDConfigs(Predicate<HetznerSDConfigBuilder> predicate) {
    if (hetznerSDConfigs == null) {
      return (A) this;
    }
    Iterator<HetznerSDConfigBuilder> each = hetznerSDConfigs.iterator();
    List visitables = _visitables.get("hetznerSDConfigs");
    while (each.hasNext()) {
        HetznerSDConfigBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromHttpSDConfigs(Predicate<HTTPSDConfigBuilder> predicate) {
    if (httpSDConfigs == null) {
      return (A) this;
    }
    Iterator<HTTPSDConfigBuilder> each = httpSDConfigs.iterator();
    List visitables = _visitables.get("httpSDConfigs");
    while (each.hasNext()) {
        HTTPSDConfigBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromIonosSDConfigs(Predicate<IonosSDConfigBuilder> predicate) {
    if (ionosSDConfigs == null) {
      return (A) this;
    }
    Iterator<IonosSDConfigBuilder> each = ionosSDConfigs.iterator();
    List visitables = _visitables.get("ionosSDConfigs");
    while (each.hasNext()) {
        IonosSDConfigBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromKubernetesSDConfigs(Predicate<KubernetesSDConfigBuilder> predicate) {
    if (kubernetesSDConfigs == null) {
      return (A) this;
    }
    Iterator<KubernetesSDConfigBuilder> each = kubernetesSDConfigs.iterator();
    List visitables = _visitables.get("kubernetesSDConfigs");
    while (each.hasNext()) {
        KubernetesSDConfigBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromKumaSDConfigs(Predicate<KumaSDConfigBuilder> predicate) {
    if (kumaSDConfigs == null) {
      return (A) this;
    }
    Iterator<KumaSDConfigBuilder> each = kumaSDConfigs.iterator();
    List visitables = _visitables.get("kumaSDConfigs");
    while (each.hasNext()) {
        KumaSDConfigBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromLightSailSDConfigs(Predicate<LightSailSDConfigBuilder> predicate) {
    if (lightSailSDConfigs == null) {
      return (A) this;
    }
    Iterator<LightSailSDConfigBuilder> each = lightSailSDConfigs.iterator();
    List visitables = _visitables.get("lightSailSDConfigs");
    while (each.hasNext()) {
        LightSailSDConfigBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromLinodeSDConfigs(Predicate<LinodeSDConfigBuilder> predicate) {
    if (linodeSDConfigs == null) {
      return (A) this;
    }
    Iterator<LinodeSDConfigBuilder> each = linodeSDConfigs.iterator();
    List visitables = _visitables.get("linodeSDConfigs");
    while (each.hasNext()) {
        LinodeSDConfigBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromMetricRelabelings(Predicate<RelabelConfigBuilder> predicate) {
    if (metricRelabelings == null) {
      return (A) this;
    }
    Iterator<RelabelConfigBuilder> each = metricRelabelings.iterator();
    List visitables = _visitables.get("metricRelabelings");
    while (each.hasNext()) {
        RelabelConfigBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromNomadSDConfigs(Predicate<NomadSDConfigBuilder> predicate) {
    if (nomadSDConfigs == null) {
      return (A) this;
    }
    Iterator<NomadSDConfigBuilder> each = nomadSDConfigs.iterator();
    List visitables = _visitables.get("nomadSDConfigs");
    while (each.hasNext()) {
        NomadSDConfigBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromOpenstackSDConfigs(Predicate<OpenStackSDConfigBuilder> predicate) {
    if (openstackSDConfigs == null) {
      return (A) this;
    }
    Iterator<OpenStackSDConfigBuilder> each = openstackSDConfigs.iterator();
    List visitables = _visitables.get("openstackSDConfigs");
    while (each.hasNext()) {
        OpenStackSDConfigBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromOvhcloudSDConfigs(Predicate<OVHCloudSDConfigBuilder> predicate) {
    if (ovhcloudSDConfigs == null) {
      return (A) this;
    }
    Iterator<OVHCloudSDConfigBuilder> each = ovhcloudSDConfigs.iterator();
    List visitables = _visitables.get("ovhcloudSDConfigs");
    while (each.hasNext()) {
        OVHCloudSDConfigBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromPuppetDBSDConfigs(Predicate<PuppetDBSDConfigBuilder> predicate) {
    if (puppetDBSDConfigs == null) {
      return (A) this;
    }
    Iterator<PuppetDBSDConfigBuilder> each = puppetDBSDConfigs.iterator();
    List visitables = _visitables.get("puppetDBSDConfigs");
    while (each.hasNext()) {
        PuppetDBSDConfigBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromRelabelings(Predicate<RelabelConfigBuilder> predicate) {
    if (relabelings == null) {
      return (A) this;
    }
    Iterator<RelabelConfigBuilder> each = relabelings.iterator();
    List visitables = _visitables.get("relabelings");
    while (each.hasNext()) {
        RelabelConfigBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromScalewaySDConfigs(Predicate<ScalewaySDConfigBuilder> predicate) {
    if (scalewaySDConfigs == null) {
      return (A) this;
    }
    Iterator<ScalewaySDConfigBuilder> each = scalewaySDConfigs.iterator();
    List visitables = _visitables.get("scalewaySDConfigs");
    while (each.hasNext()) {
        ScalewaySDConfigBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromStaticConfigs(Predicate<StaticConfigBuilder> predicate) {
    if (staticConfigs == null) {
      return (A) this;
    }
    Iterator<StaticConfigBuilder> each = staticConfigs.iterator();
    List visitables = _visitables.get("staticConfigs");
    while (each.hasNext()) {
        StaticConfigBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public AzureSDConfigsNested<A> setNewAzureSDConfigLike(int index,AzureSDConfig item) {
    return new AzureSDConfigsNested(index, item);
  }
  
  public ConsulSDConfigsNested<A> setNewConsulSDConfigLike(int index,ConsulSDConfig item) {
    return new ConsulSDConfigsNested(index, item);
  }
  
  public DigitalOceanSDConfigsNested<A> setNewDigitalOceanSDConfigLike(int index,DigitalOceanSDConfig item) {
    return new DigitalOceanSDConfigsNested(index, item);
  }
  
  public DnsSDConfigsNested<A> setNewDnsSDConfigLike(int index,DNSSDConfig item) {
    return new DnsSDConfigsNested(index, item);
  }
  
  public DockerSDConfigsNested<A> setNewDockerSDConfigLike(int index,DockerSDConfig item) {
    return new DockerSDConfigsNested(index, item);
  }
  
  public DockerSwarmSDConfigsNested<A> setNewDockerSwarmSDConfigLike(int index,DockerSwarmSDConfig item) {
    return new DockerSwarmSDConfigsNested(index, item);
  }
  
  public Ec2SDConfigsNested<A> setNewEc2SDConfigLike(int index,EC2SDConfig item) {
    return new Ec2SDConfigsNested(index, item);
  }
  
  public EurekaSDConfigsNested<A> setNewEurekaSDConfigLike(int index,EurekaSDConfig item) {
    return new EurekaSDConfigsNested(index, item);
  }
  
  public FileSDConfigsNested<A> setNewFileSDConfigLike(int index,FileSDConfig item) {
    return new FileSDConfigsNested(index, item);
  }
  
  public GceSDConfigsNested<A> setNewGceSDConfigLike(int index,GCESDConfig item) {
    return new GceSDConfigsNested(index, item);
  }
  
  public HetznerSDConfigsNested<A> setNewHetznerSDConfigLike(int index,HetznerSDConfig item) {
    return new HetznerSDConfigsNested(index, item);
  }
  
  public HttpSDConfigsNested<A> setNewHttpSDConfigLike(int index,HTTPSDConfig item) {
    return new HttpSDConfigsNested(index, item);
  }
  
  public IonosSDConfigsNested<A> setNewIonosSDConfigLike(int index,IonosSDConfig item) {
    return new IonosSDConfigsNested(index, item);
  }
  
  public KubernetesSDConfigsNested<A> setNewKubernetesSDConfigLike(int index,KubernetesSDConfig item) {
    return new KubernetesSDConfigsNested(index, item);
  }
  
  public KumaSDConfigsNested<A> setNewKumaSDConfigLike(int index,KumaSDConfig item) {
    return new KumaSDConfigsNested(index, item);
  }
  
  public LightSailSDConfigsNested<A> setNewLightSailSDConfigLike(int index,LightSailSDConfig item) {
    return new LightSailSDConfigsNested(index, item);
  }
  
  public LinodeSDConfigsNested<A> setNewLinodeSDConfigLike(int index,LinodeSDConfig item) {
    return new LinodeSDConfigsNested(index, item);
  }
  
  public MetricRelabelingsNested<A> setNewMetricRelabelingLike(int index,RelabelConfig item) {
    return new MetricRelabelingsNested(index, item);
  }
  
  public NomadSDConfigsNested<A> setNewNomadSDConfigLike(int index,NomadSDConfig item) {
    return new NomadSDConfigsNested(index, item);
  }
  
  public OpenstackSDConfigsNested<A> setNewOpenstackSDConfigLike(int index,OpenStackSDConfig item) {
    return new OpenstackSDConfigsNested(index, item);
  }
  
  public OvhcloudSDConfigsNested<A> setNewOvhcloudSDConfigLike(int index,OVHCloudSDConfig item) {
    return new OvhcloudSDConfigsNested(index, item);
  }
  
  public PuppetDBSDConfigsNested<A> setNewPuppetDBSDConfigLike(int index,PuppetDBSDConfig item) {
    return new PuppetDBSDConfigsNested(index, item);
  }
  
  public RelabelingsNested<A> setNewRelabelingLike(int index,RelabelConfig item) {
    return new RelabelingsNested(index, item);
  }
  
  public ScalewaySDConfigsNested<A> setNewScalewaySDConfigLike(int index,ScalewaySDConfig item) {
    return new ScalewaySDConfigsNested(index, item);
  }
  
  public StaticConfigsNested<A> setNewStaticConfigLike(int index,StaticConfig item) {
    return new StaticConfigsNested(index, item);
  }
  
  public A setToAzureSDConfigs(int index,AzureSDConfig item) {
    if (this.azureSDConfigs == null) {
      this.azureSDConfigs = new ArrayList();
    }
    AzureSDConfigBuilder builder = new AzureSDConfigBuilder(item);
    if (index < 0 || index >= azureSDConfigs.size()) {
        _visitables.get("azureSDConfigs").add(builder);
        azureSDConfigs.add(builder);
    } else {
        _visitables.get("azureSDConfigs").add(builder);
        azureSDConfigs.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToConsulSDConfigs(int index,ConsulSDConfig item) {
    if (this.consulSDConfigs == null) {
      this.consulSDConfigs = new ArrayList();
    }
    ConsulSDConfigBuilder builder = new ConsulSDConfigBuilder(item);
    if (index < 0 || index >= consulSDConfigs.size()) {
        _visitables.get("consulSDConfigs").add(builder);
        consulSDConfigs.add(builder);
    } else {
        _visitables.get("consulSDConfigs").add(builder);
        consulSDConfigs.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToDigitalOceanSDConfigs(int index,DigitalOceanSDConfig item) {
    if (this.digitalOceanSDConfigs == null) {
      this.digitalOceanSDConfigs = new ArrayList();
    }
    DigitalOceanSDConfigBuilder builder = new DigitalOceanSDConfigBuilder(item);
    if (index < 0 || index >= digitalOceanSDConfigs.size()) {
        _visitables.get("digitalOceanSDConfigs").add(builder);
        digitalOceanSDConfigs.add(builder);
    } else {
        _visitables.get("digitalOceanSDConfigs").add(builder);
        digitalOceanSDConfigs.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToDnsSDConfigs(int index,DNSSDConfig item) {
    if (this.dnsSDConfigs == null) {
      this.dnsSDConfigs = new ArrayList();
    }
    DNSSDConfigBuilder builder = new DNSSDConfigBuilder(item);
    if (index < 0 || index >= dnsSDConfigs.size()) {
        _visitables.get("dnsSDConfigs").add(builder);
        dnsSDConfigs.add(builder);
    } else {
        _visitables.get("dnsSDConfigs").add(builder);
        dnsSDConfigs.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToDockerSDConfigs(int index,DockerSDConfig item) {
    if (this.dockerSDConfigs == null) {
      this.dockerSDConfigs = new ArrayList();
    }
    DockerSDConfigBuilder builder = new DockerSDConfigBuilder(item);
    if (index < 0 || index >= dockerSDConfigs.size()) {
        _visitables.get("dockerSDConfigs").add(builder);
        dockerSDConfigs.add(builder);
    } else {
        _visitables.get("dockerSDConfigs").add(builder);
        dockerSDConfigs.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToDockerSwarmSDConfigs(int index,DockerSwarmSDConfig item) {
    if (this.dockerSwarmSDConfigs == null) {
      this.dockerSwarmSDConfigs = new ArrayList();
    }
    DockerSwarmSDConfigBuilder builder = new DockerSwarmSDConfigBuilder(item);
    if (index < 0 || index >= dockerSwarmSDConfigs.size()) {
        _visitables.get("dockerSwarmSDConfigs").add(builder);
        dockerSwarmSDConfigs.add(builder);
    } else {
        _visitables.get("dockerSwarmSDConfigs").add(builder);
        dockerSwarmSDConfigs.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToEc2SDConfigs(int index,EC2SDConfig item) {
    if (this.ec2SDConfigs == null) {
      this.ec2SDConfigs = new ArrayList();
    }
    EC2SDConfigBuilder builder = new EC2SDConfigBuilder(item);
    if (index < 0 || index >= ec2SDConfigs.size()) {
        _visitables.get("ec2SDConfigs").add(builder);
        ec2SDConfigs.add(builder);
    } else {
        _visitables.get("ec2SDConfigs").add(builder);
        ec2SDConfigs.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToEurekaSDConfigs(int index,EurekaSDConfig item) {
    if (this.eurekaSDConfigs == null) {
      this.eurekaSDConfigs = new ArrayList();
    }
    EurekaSDConfigBuilder builder = new EurekaSDConfigBuilder(item);
    if (index < 0 || index >= eurekaSDConfigs.size()) {
        _visitables.get("eurekaSDConfigs").add(builder);
        eurekaSDConfigs.add(builder);
    } else {
        _visitables.get("eurekaSDConfigs").add(builder);
        eurekaSDConfigs.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToFileSDConfigs(int index,FileSDConfig item) {
    if (this.fileSDConfigs == null) {
      this.fileSDConfigs = new ArrayList();
    }
    FileSDConfigBuilder builder = new FileSDConfigBuilder(item);
    if (index < 0 || index >= fileSDConfigs.size()) {
        _visitables.get("fileSDConfigs").add(builder);
        fileSDConfigs.add(builder);
    } else {
        _visitables.get("fileSDConfigs").add(builder);
        fileSDConfigs.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToGceSDConfigs(int index,GCESDConfig item) {
    if (this.gceSDConfigs == null) {
      this.gceSDConfigs = new ArrayList();
    }
    GCESDConfigBuilder builder = new GCESDConfigBuilder(item);
    if (index < 0 || index >= gceSDConfigs.size()) {
        _visitables.get("gceSDConfigs").add(builder);
        gceSDConfigs.add(builder);
    } else {
        _visitables.get("gceSDConfigs").add(builder);
        gceSDConfigs.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToHetznerSDConfigs(int index,HetznerSDConfig item) {
    if (this.hetznerSDConfigs == null) {
      this.hetznerSDConfigs = new ArrayList();
    }
    HetznerSDConfigBuilder builder = new HetznerSDConfigBuilder(item);
    if (index < 0 || index >= hetznerSDConfigs.size()) {
        _visitables.get("hetznerSDConfigs").add(builder);
        hetznerSDConfigs.add(builder);
    } else {
        _visitables.get("hetznerSDConfigs").add(builder);
        hetznerSDConfigs.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToHttpSDConfigs(int index,HTTPSDConfig item) {
    if (this.httpSDConfigs == null) {
      this.httpSDConfigs = new ArrayList();
    }
    HTTPSDConfigBuilder builder = new HTTPSDConfigBuilder(item);
    if (index < 0 || index >= httpSDConfigs.size()) {
        _visitables.get("httpSDConfigs").add(builder);
        httpSDConfigs.add(builder);
    } else {
        _visitables.get("httpSDConfigs").add(builder);
        httpSDConfigs.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToIonosSDConfigs(int index,IonosSDConfig item) {
    if (this.ionosSDConfigs == null) {
      this.ionosSDConfigs = new ArrayList();
    }
    IonosSDConfigBuilder builder = new IonosSDConfigBuilder(item);
    if (index < 0 || index >= ionosSDConfigs.size()) {
        _visitables.get("ionosSDConfigs").add(builder);
        ionosSDConfigs.add(builder);
    } else {
        _visitables.get("ionosSDConfigs").add(builder);
        ionosSDConfigs.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToKubernetesSDConfigs(int index,KubernetesSDConfig item) {
    if (this.kubernetesSDConfigs == null) {
      this.kubernetesSDConfigs = new ArrayList();
    }
    KubernetesSDConfigBuilder builder = new KubernetesSDConfigBuilder(item);
    if (index < 0 || index >= kubernetesSDConfigs.size()) {
        _visitables.get("kubernetesSDConfigs").add(builder);
        kubernetesSDConfigs.add(builder);
    } else {
        _visitables.get("kubernetesSDConfigs").add(builder);
        kubernetesSDConfigs.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToKumaSDConfigs(int index,KumaSDConfig item) {
    if (this.kumaSDConfigs == null) {
      this.kumaSDConfigs = new ArrayList();
    }
    KumaSDConfigBuilder builder = new KumaSDConfigBuilder(item);
    if (index < 0 || index >= kumaSDConfigs.size()) {
        _visitables.get("kumaSDConfigs").add(builder);
        kumaSDConfigs.add(builder);
    } else {
        _visitables.get("kumaSDConfigs").add(builder);
        kumaSDConfigs.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToLightSailSDConfigs(int index,LightSailSDConfig item) {
    if (this.lightSailSDConfigs == null) {
      this.lightSailSDConfigs = new ArrayList();
    }
    LightSailSDConfigBuilder builder = new LightSailSDConfigBuilder(item);
    if (index < 0 || index >= lightSailSDConfigs.size()) {
        _visitables.get("lightSailSDConfigs").add(builder);
        lightSailSDConfigs.add(builder);
    } else {
        _visitables.get("lightSailSDConfigs").add(builder);
        lightSailSDConfigs.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToLinodeSDConfigs(int index,LinodeSDConfig item) {
    if (this.linodeSDConfigs == null) {
      this.linodeSDConfigs = new ArrayList();
    }
    LinodeSDConfigBuilder builder = new LinodeSDConfigBuilder(item);
    if (index < 0 || index >= linodeSDConfigs.size()) {
        _visitables.get("linodeSDConfigs").add(builder);
        linodeSDConfigs.add(builder);
    } else {
        _visitables.get("linodeSDConfigs").add(builder);
        linodeSDConfigs.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToMetricRelabelings(int index,RelabelConfig item) {
    if (this.metricRelabelings == null) {
      this.metricRelabelings = new ArrayList();
    }
    RelabelConfigBuilder builder = new RelabelConfigBuilder(item);
    if (index < 0 || index >= metricRelabelings.size()) {
        _visitables.get("metricRelabelings").add(builder);
        metricRelabelings.add(builder);
    } else {
        _visitables.get("metricRelabelings").add(builder);
        metricRelabelings.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToNomadSDConfigs(int index,NomadSDConfig item) {
    if (this.nomadSDConfigs == null) {
      this.nomadSDConfigs = new ArrayList();
    }
    NomadSDConfigBuilder builder = new NomadSDConfigBuilder(item);
    if (index < 0 || index >= nomadSDConfigs.size()) {
        _visitables.get("nomadSDConfigs").add(builder);
        nomadSDConfigs.add(builder);
    } else {
        _visitables.get("nomadSDConfigs").add(builder);
        nomadSDConfigs.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToOpenstackSDConfigs(int index,OpenStackSDConfig item) {
    if (this.openstackSDConfigs == null) {
      this.openstackSDConfigs = new ArrayList();
    }
    OpenStackSDConfigBuilder builder = new OpenStackSDConfigBuilder(item);
    if (index < 0 || index >= openstackSDConfigs.size()) {
        _visitables.get("openstackSDConfigs").add(builder);
        openstackSDConfigs.add(builder);
    } else {
        _visitables.get("openstackSDConfigs").add(builder);
        openstackSDConfigs.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToOvhcloudSDConfigs(int index,OVHCloudSDConfig item) {
    if (this.ovhcloudSDConfigs == null) {
      this.ovhcloudSDConfigs = new ArrayList();
    }
    OVHCloudSDConfigBuilder builder = new OVHCloudSDConfigBuilder(item);
    if (index < 0 || index >= ovhcloudSDConfigs.size()) {
        _visitables.get("ovhcloudSDConfigs").add(builder);
        ovhcloudSDConfigs.add(builder);
    } else {
        _visitables.get("ovhcloudSDConfigs").add(builder);
        ovhcloudSDConfigs.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToPuppetDBSDConfigs(int index,PuppetDBSDConfig item) {
    if (this.puppetDBSDConfigs == null) {
      this.puppetDBSDConfigs = new ArrayList();
    }
    PuppetDBSDConfigBuilder builder = new PuppetDBSDConfigBuilder(item);
    if (index < 0 || index >= puppetDBSDConfigs.size()) {
        _visitables.get("puppetDBSDConfigs").add(builder);
        puppetDBSDConfigs.add(builder);
    } else {
        _visitables.get("puppetDBSDConfigs").add(builder);
        puppetDBSDConfigs.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToRelabelings(int index,RelabelConfig item) {
    if (this.relabelings == null) {
      this.relabelings = new ArrayList();
    }
    RelabelConfigBuilder builder = new RelabelConfigBuilder(item);
    if (index < 0 || index >= relabelings.size()) {
        _visitables.get("relabelings").add(builder);
        relabelings.add(builder);
    } else {
        _visitables.get("relabelings").add(builder);
        relabelings.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToScalewaySDConfigs(int index,ScalewaySDConfig item) {
    if (this.scalewaySDConfigs == null) {
      this.scalewaySDConfigs = new ArrayList();
    }
    ScalewaySDConfigBuilder builder = new ScalewaySDConfigBuilder(item);
    if (index < 0 || index >= scalewaySDConfigs.size()) {
        _visitables.get("scalewaySDConfigs").add(builder);
        scalewaySDConfigs.add(builder);
    } else {
        _visitables.get("scalewaySDConfigs").add(builder);
        scalewaySDConfigs.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToScrapeProtocols(int index,String item) {
    if (this.scrapeProtocols == null) {
      this.scrapeProtocols = new ArrayList();
    }
    this.scrapeProtocols.set(index, item);
    return (A) this;
  }
  
  public A setToStaticConfigs(int index,StaticConfig item) {
    if (this.staticConfigs == null) {
      this.staticConfigs = new ArrayList();
    }
    StaticConfigBuilder builder = new StaticConfigBuilder(item);
    if (index < 0 || index >= staticConfigs.size()) {
        _visitables.get("staticConfigs").add(builder);
        staticConfigs.add(builder);
    } else {
        _visitables.get("staticConfigs").add(builder);
        staticConfigs.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(authorization == null)) {
        sb.append("authorization:");
        sb.append(authorization);
        sb.append(",");
    }
    if (!(azureSDConfigs == null) && !(azureSDConfigs.isEmpty())) {
        sb.append("azureSDConfigs:");
        sb.append(azureSDConfigs);
        sb.append(",");
    }
    if (!(basicAuth == null)) {
        sb.append("basicAuth:");
        sb.append(basicAuth);
        sb.append(",");
    }
    if (!(bodySizeLimit == null)) {
        sb.append("bodySizeLimit:");
        sb.append(bodySizeLimit);
        sb.append(",");
    }
    if (!(consulSDConfigs == null) && !(consulSDConfigs.isEmpty())) {
        sb.append("consulSDConfigs:");
        sb.append(consulSDConfigs);
        sb.append(",");
    }
    if (!(convertClassicHistogramsToNHCB == null)) {
        sb.append("convertClassicHistogramsToNHCB:");
        sb.append(convertClassicHistogramsToNHCB);
        sb.append(",");
    }
    if (!(digitalOceanSDConfigs == null) && !(digitalOceanSDConfigs.isEmpty())) {
        sb.append("digitalOceanSDConfigs:");
        sb.append(digitalOceanSDConfigs);
        sb.append(",");
    }
    if (!(dnsSDConfigs == null) && !(dnsSDConfigs.isEmpty())) {
        sb.append("dnsSDConfigs:");
        sb.append(dnsSDConfigs);
        sb.append(",");
    }
    if (!(dockerSDConfigs == null) && !(dockerSDConfigs.isEmpty())) {
        sb.append("dockerSDConfigs:");
        sb.append(dockerSDConfigs);
        sb.append(",");
    }
    if (!(dockerSwarmSDConfigs == null) && !(dockerSwarmSDConfigs.isEmpty())) {
        sb.append("dockerSwarmSDConfigs:");
        sb.append(dockerSwarmSDConfigs);
        sb.append(",");
    }
    if (!(ec2SDConfigs == null) && !(ec2SDConfigs.isEmpty())) {
        sb.append("ec2SDConfigs:");
        sb.append(ec2SDConfigs);
        sb.append(",");
    }
    if (!(enableCompression == null)) {
        sb.append("enableCompression:");
        sb.append(enableCompression);
        sb.append(",");
    }
    if (!(enableHTTP2 == null)) {
        sb.append("enableHTTP2:");
        sb.append(enableHTTP2);
        sb.append(",");
    }
    if (!(eurekaSDConfigs == null) && !(eurekaSDConfigs.isEmpty())) {
        sb.append("eurekaSDConfigs:");
        sb.append(eurekaSDConfigs);
        sb.append(",");
    }
    if (!(fallbackScrapeProtocol == null)) {
        sb.append("fallbackScrapeProtocol:");
        sb.append(fallbackScrapeProtocol);
        sb.append(",");
    }
    if (!(fileSDConfigs == null) && !(fileSDConfigs.isEmpty())) {
        sb.append("fileSDConfigs:");
        sb.append(fileSDConfigs);
        sb.append(",");
    }
    if (!(gceSDConfigs == null) && !(gceSDConfigs.isEmpty())) {
        sb.append("gceSDConfigs:");
        sb.append(gceSDConfigs);
        sb.append(",");
    }
    if (!(hetznerSDConfigs == null) && !(hetznerSDConfigs.isEmpty())) {
        sb.append("hetznerSDConfigs:");
        sb.append(hetznerSDConfigs);
        sb.append(",");
    }
    if (!(honorLabels == null)) {
        sb.append("honorLabels:");
        sb.append(honorLabels);
        sb.append(",");
    }
    if (!(honorTimestamps == null)) {
        sb.append("honorTimestamps:");
        sb.append(honorTimestamps);
        sb.append(",");
    }
    if (!(httpSDConfigs == null) && !(httpSDConfigs.isEmpty())) {
        sb.append("httpSDConfigs:");
        sb.append(httpSDConfigs);
        sb.append(",");
    }
    if (!(ionosSDConfigs == null) && !(ionosSDConfigs.isEmpty())) {
        sb.append("ionosSDConfigs:");
        sb.append(ionosSDConfigs);
        sb.append(",");
    }
    if (!(jobName == null)) {
        sb.append("jobName:");
        sb.append(jobName);
        sb.append(",");
    }
    if (!(keepDroppedTargets == null)) {
        sb.append("keepDroppedTargets:");
        sb.append(keepDroppedTargets);
        sb.append(",");
    }
    if (!(kubernetesSDConfigs == null) && !(kubernetesSDConfigs.isEmpty())) {
        sb.append("kubernetesSDConfigs:");
        sb.append(kubernetesSDConfigs);
        sb.append(",");
    }
    if (!(kumaSDConfigs == null) && !(kumaSDConfigs.isEmpty())) {
        sb.append("kumaSDConfigs:");
        sb.append(kumaSDConfigs);
        sb.append(",");
    }
    if (!(labelLimit == null)) {
        sb.append("labelLimit:");
        sb.append(labelLimit);
        sb.append(",");
    }
    if (!(labelNameLengthLimit == null)) {
        sb.append("labelNameLengthLimit:");
        sb.append(labelNameLengthLimit);
        sb.append(",");
    }
    if (!(labelValueLengthLimit == null)) {
        sb.append("labelValueLengthLimit:");
        sb.append(labelValueLengthLimit);
        sb.append(",");
    }
    if (!(lightSailSDConfigs == null) && !(lightSailSDConfigs.isEmpty())) {
        sb.append("lightSailSDConfigs:");
        sb.append(lightSailSDConfigs);
        sb.append(",");
    }
    if (!(linodeSDConfigs == null) && !(linodeSDConfigs.isEmpty())) {
        sb.append("linodeSDConfigs:");
        sb.append(linodeSDConfigs);
        sb.append(",");
    }
    if (!(metricRelabelings == null) && !(metricRelabelings.isEmpty())) {
        sb.append("metricRelabelings:");
        sb.append(metricRelabelings);
        sb.append(",");
    }
    if (!(metricsPath == null)) {
        sb.append("metricsPath:");
        sb.append(metricsPath);
        sb.append(",");
    }
    if (!(nameEscapingScheme == null)) {
        sb.append("nameEscapingScheme:");
        sb.append(nameEscapingScheme);
        sb.append(",");
    }
    if (!(nameValidationScheme == null)) {
        sb.append("nameValidationScheme:");
        sb.append(nameValidationScheme);
        sb.append(",");
    }
    if (!(nativeHistogramBucketLimit == null)) {
        sb.append("nativeHistogramBucketLimit:");
        sb.append(nativeHistogramBucketLimit);
        sb.append(",");
    }
    if (!(nativeHistogramMinBucketFactor == null)) {
        sb.append("nativeHistogramMinBucketFactor:");
        sb.append(nativeHistogramMinBucketFactor);
        sb.append(",");
    }
    if (!(noProxy == null)) {
        sb.append("noProxy:");
        sb.append(noProxy);
        sb.append(",");
    }
    if (!(nomadSDConfigs == null) && !(nomadSDConfigs.isEmpty())) {
        sb.append("nomadSDConfigs:");
        sb.append(nomadSDConfigs);
        sb.append(",");
    }
    if (!(oauth2 == null)) {
        sb.append("oauth2:");
        sb.append(oauth2);
        sb.append(",");
    }
    if (!(openstackSDConfigs == null) && !(openstackSDConfigs.isEmpty())) {
        sb.append("openstackSDConfigs:");
        sb.append(openstackSDConfigs);
        sb.append(",");
    }
    if (!(ovhcloudSDConfigs == null) && !(ovhcloudSDConfigs.isEmpty())) {
        sb.append("ovhcloudSDConfigs:");
        sb.append(ovhcloudSDConfigs);
        sb.append(",");
    }
    if (!(params == null) && !(params.isEmpty())) {
        sb.append("params:");
        sb.append(params);
        sb.append(",");
    }
    if (!(proxyConnectHeader == null) && !(proxyConnectHeader.isEmpty())) {
        sb.append("proxyConnectHeader:");
        sb.append(proxyConnectHeader);
        sb.append(",");
    }
    if (!(proxyFromEnvironment == null)) {
        sb.append("proxyFromEnvironment:");
        sb.append(proxyFromEnvironment);
        sb.append(",");
    }
    if (!(proxyUrl == null)) {
        sb.append("proxyUrl:");
        sb.append(proxyUrl);
        sb.append(",");
    }
    if (!(puppetDBSDConfigs == null) && !(puppetDBSDConfigs.isEmpty())) {
        sb.append("puppetDBSDConfigs:");
        sb.append(puppetDBSDConfigs);
        sb.append(",");
    }
    if (!(relabelings == null) && !(relabelings.isEmpty())) {
        sb.append("relabelings:");
        sb.append(relabelings);
        sb.append(",");
    }
    if (!(sampleLimit == null)) {
        sb.append("sampleLimit:");
        sb.append(sampleLimit);
        sb.append(",");
    }
    if (!(scalewaySDConfigs == null) && !(scalewaySDConfigs.isEmpty())) {
        sb.append("scalewaySDConfigs:");
        sb.append(scalewaySDConfigs);
        sb.append(",");
    }
    if (!(scheme == null)) {
        sb.append("scheme:");
        sb.append(scheme);
        sb.append(",");
    }
    if (!(scrapeClass == null)) {
        sb.append("scrapeClass:");
        sb.append(scrapeClass);
        sb.append(",");
    }
    if (!(scrapeClassicHistograms == null)) {
        sb.append("scrapeClassicHistograms:");
        sb.append(scrapeClassicHistograms);
        sb.append(",");
    }
    if (!(scrapeInterval == null)) {
        sb.append("scrapeInterval:");
        sb.append(scrapeInterval);
        sb.append(",");
    }
    if (!(scrapeNativeHistograms == null)) {
        sb.append("scrapeNativeHistograms:");
        sb.append(scrapeNativeHistograms);
        sb.append(",");
    }
    if (!(scrapeProtocols == null) && !(scrapeProtocols.isEmpty())) {
        sb.append("scrapeProtocols:");
        sb.append(scrapeProtocols);
        sb.append(",");
    }
    if (!(scrapeTimeout == null)) {
        sb.append("scrapeTimeout:");
        sb.append(scrapeTimeout);
        sb.append(",");
    }
    if (!(staticConfigs == null) && !(staticConfigs.isEmpty())) {
        sb.append("staticConfigs:");
        sb.append(staticConfigs);
        sb.append(",");
    }
    if (!(targetLimit == null)) {
        sb.append("targetLimit:");
        sb.append(targetLimit);
        sb.append(",");
    }
    if (!(tlsConfig == null)) {
        sb.append("tlsConfig:");
        sb.append(tlsConfig);
        sb.append(",");
    }
    if (!(trackTimestampsStaleness == null)) {
        sb.append("trackTimestampsStaleness:");
        sb.append(trackTimestampsStaleness);
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
  
  public A withAuthorization(SafeAuthorization authorization) {
    this._visitables.remove("authorization");
    if (authorization != null) {
        this.authorization = new SafeAuthorizationBuilder(authorization);
        this._visitables.get("authorization").add(this.authorization);
    } else {
        this.authorization = null;
        this._visitables.get("authorization").remove(this.authorization);
    }
    return (A) this;
  }
  
  public A withAzureSDConfigs(List<AzureSDConfig> azureSDConfigs) {
    if (this.azureSDConfigs != null) {
      this._visitables.get("azureSDConfigs").clear();
    }
    if (azureSDConfigs != null) {
        this.azureSDConfigs = new ArrayList();
        for (AzureSDConfig item : azureSDConfigs) {
          this.addToAzureSDConfigs(item);
        }
    } else {
      this.azureSDConfigs = null;
    }
    return (A) this;
  }
  
  public A withAzureSDConfigs(AzureSDConfig... azureSDConfigs) {
    if (this.azureSDConfigs != null) {
        this.azureSDConfigs.clear();
        _visitables.remove("azureSDConfigs");
    }
    if (azureSDConfigs != null) {
      for (AzureSDConfig item : azureSDConfigs) {
        this.addToAzureSDConfigs(item);
      }
    }
    return (A) this;
  }
  
  public A withBasicAuth(BasicAuth basicAuth) {
    this._visitables.remove("basicAuth");
    if (basicAuth != null) {
        this.basicAuth = new BasicAuthBuilder(basicAuth);
        this._visitables.get("basicAuth").add(this.basicAuth);
    } else {
        this.basicAuth = null;
        this._visitables.get("basicAuth").remove(this.basicAuth);
    }
    return (A) this;
  }
  
  public A withBodySizeLimit(String bodySizeLimit) {
    this.bodySizeLimit = bodySizeLimit;
    return (A) this;
  }
  
  public A withConsulSDConfigs(List<ConsulSDConfig> consulSDConfigs) {
    if (this.consulSDConfigs != null) {
      this._visitables.get("consulSDConfigs").clear();
    }
    if (consulSDConfigs != null) {
        this.consulSDConfigs = new ArrayList();
        for (ConsulSDConfig item : consulSDConfigs) {
          this.addToConsulSDConfigs(item);
        }
    } else {
      this.consulSDConfigs = null;
    }
    return (A) this;
  }
  
  public A withConsulSDConfigs(ConsulSDConfig... consulSDConfigs) {
    if (this.consulSDConfigs != null) {
        this.consulSDConfigs.clear();
        _visitables.remove("consulSDConfigs");
    }
    if (consulSDConfigs != null) {
      for (ConsulSDConfig item : consulSDConfigs) {
        this.addToConsulSDConfigs(item);
      }
    }
    return (A) this;
  }
  
  public A withConvertClassicHistogramsToNHCB() {
    return withConvertClassicHistogramsToNHCB(true);
  }
  
  public A withConvertClassicHistogramsToNHCB(Boolean convertClassicHistogramsToNHCB) {
    this.convertClassicHistogramsToNHCB = convertClassicHistogramsToNHCB;
    return (A) this;
  }
  
  public A withDigitalOceanSDConfigs(List<DigitalOceanSDConfig> digitalOceanSDConfigs) {
    if (this.digitalOceanSDConfigs != null) {
      this._visitables.get("digitalOceanSDConfigs").clear();
    }
    if (digitalOceanSDConfigs != null) {
        this.digitalOceanSDConfigs = new ArrayList();
        for (DigitalOceanSDConfig item : digitalOceanSDConfigs) {
          this.addToDigitalOceanSDConfigs(item);
        }
    } else {
      this.digitalOceanSDConfigs = null;
    }
    return (A) this;
  }
  
  public A withDigitalOceanSDConfigs(DigitalOceanSDConfig... digitalOceanSDConfigs) {
    if (this.digitalOceanSDConfigs != null) {
        this.digitalOceanSDConfigs.clear();
        _visitables.remove("digitalOceanSDConfigs");
    }
    if (digitalOceanSDConfigs != null) {
      for (DigitalOceanSDConfig item : digitalOceanSDConfigs) {
        this.addToDigitalOceanSDConfigs(item);
      }
    }
    return (A) this;
  }
  
  public A withDnsSDConfigs(List<DNSSDConfig> dnsSDConfigs) {
    if (this.dnsSDConfigs != null) {
      this._visitables.get("dnsSDConfigs").clear();
    }
    if (dnsSDConfigs != null) {
        this.dnsSDConfigs = new ArrayList();
        for (DNSSDConfig item : dnsSDConfigs) {
          this.addToDnsSDConfigs(item);
        }
    } else {
      this.dnsSDConfigs = null;
    }
    return (A) this;
  }
  
  public A withDnsSDConfigs(DNSSDConfig... dnsSDConfigs) {
    if (this.dnsSDConfigs != null) {
        this.dnsSDConfigs.clear();
        _visitables.remove("dnsSDConfigs");
    }
    if (dnsSDConfigs != null) {
      for (DNSSDConfig item : dnsSDConfigs) {
        this.addToDnsSDConfigs(item);
      }
    }
    return (A) this;
  }
  
  public A withDockerSDConfigs(List<DockerSDConfig> dockerSDConfigs) {
    if (this.dockerSDConfigs != null) {
      this._visitables.get("dockerSDConfigs").clear();
    }
    if (dockerSDConfigs != null) {
        this.dockerSDConfigs = new ArrayList();
        for (DockerSDConfig item : dockerSDConfigs) {
          this.addToDockerSDConfigs(item);
        }
    } else {
      this.dockerSDConfigs = null;
    }
    return (A) this;
  }
  
  public A withDockerSDConfigs(DockerSDConfig... dockerSDConfigs) {
    if (this.dockerSDConfigs != null) {
        this.dockerSDConfigs.clear();
        _visitables.remove("dockerSDConfigs");
    }
    if (dockerSDConfigs != null) {
      for (DockerSDConfig item : dockerSDConfigs) {
        this.addToDockerSDConfigs(item);
      }
    }
    return (A) this;
  }
  
  public A withDockerSwarmSDConfigs(List<DockerSwarmSDConfig> dockerSwarmSDConfigs) {
    if (this.dockerSwarmSDConfigs != null) {
      this._visitables.get("dockerSwarmSDConfigs").clear();
    }
    if (dockerSwarmSDConfigs != null) {
        this.dockerSwarmSDConfigs = new ArrayList();
        for (DockerSwarmSDConfig item : dockerSwarmSDConfigs) {
          this.addToDockerSwarmSDConfigs(item);
        }
    } else {
      this.dockerSwarmSDConfigs = null;
    }
    return (A) this;
  }
  
  public A withDockerSwarmSDConfigs(DockerSwarmSDConfig... dockerSwarmSDConfigs) {
    if (this.dockerSwarmSDConfigs != null) {
        this.dockerSwarmSDConfigs.clear();
        _visitables.remove("dockerSwarmSDConfigs");
    }
    if (dockerSwarmSDConfigs != null) {
      for (DockerSwarmSDConfig item : dockerSwarmSDConfigs) {
        this.addToDockerSwarmSDConfigs(item);
      }
    }
    return (A) this;
  }
  
  public A withEc2SDConfigs(List<EC2SDConfig> ec2SDConfigs) {
    if (this.ec2SDConfigs != null) {
      this._visitables.get("ec2SDConfigs").clear();
    }
    if (ec2SDConfigs != null) {
        this.ec2SDConfigs = new ArrayList();
        for (EC2SDConfig item : ec2SDConfigs) {
          this.addToEc2SDConfigs(item);
        }
    } else {
      this.ec2SDConfigs = null;
    }
    return (A) this;
  }
  
  public A withEc2SDConfigs(EC2SDConfig... ec2SDConfigs) {
    if (this.ec2SDConfigs != null) {
        this.ec2SDConfigs.clear();
        _visitables.remove("ec2SDConfigs");
    }
    if (ec2SDConfigs != null) {
      for (EC2SDConfig item : ec2SDConfigs) {
        this.addToEc2SDConfigs(item);
      }
    }
    return (A) this;
  }
  
  public A withEnableCompression() {
    return withEnableCompression(true);
  }
  
  public A withEnableCompression(Boolean enableCompression) {
    this.enableCompression = enableCompression;
    return (A) this;
  }
  
  public A withEnableHTTP2() {
    return withEnableHTTP2(true);
  }
  
  public A withEnableHTTP2(Boolean enableHTTP2) {
    this.enableHTTP2 = enableHTTP2;
    return (A) this;
  }
  
  public A withEurekaSDConfigs(List<EurekaSDConfig> eurekaSDConfigs) {
    if (this.eurekaSDConfigs != null) {
      this._visitables.get("eurekaSDConfigs").clear();
    }
    if (eurekaSDConfigs != null) {
        this.eurekaSDConfigs = new ArrayList();
        for (EurekaSDConfig item : eurekaSDConfigs) {
          this.addToEurekaSDConfigs(item);
        }
    } else {
      this.eurekaSDConfigs = null;
    }
    return (A) this;
  }
  
  public A withEurekaSDConfigs(EurekaSDConfig... eurekaSDConfigs) {
    if (this.eurekaSDConfigs != null) {
        this.eurekaSDConfigs.clear();
        _visitables.remove("eurekaSDConfigs");
    }
    if (eurekaSDConfigs != null) {
      for (EurekaSDConfig item : eurekaSDConfigs) {
        this.addToEurekaSDConfigs(item);
      }
    }
    return (A) this;
  }
  
  public A withFallbackScrapeProtocol(String fallbackScrapeProtocol) {
    this.fallbackScrapeProtocol = fallbackScrapeProtocol;
    return (A) this;
  }
  
  public A withFileSDConfigs(List<FileSDConfig> fileSDConfigs) {
    if (this.fileSDConfigs != null) {
      this._visitables.get("fileSDConfigs").clear();
    }
    if (fileSDConfigs != null) {
        this.fileSDConfigs = new ArrayList();
        for (FileSDConfig item : fileSDConfigs) {
          this.addToFileSDConfigs(item);
        }
    } else {
      this.fileSDConfigs = null;
    }
    return (A) this;
  }
  
  public A withFileSDConfigs(FileSDConfig... fileSDConfigs) {
    if (this.fileSDConfigs != null) {
        this.fileSDConfigs.clear();
        _visitables.remove("fileSDConfigs");
    }
    if (fileSDConfigs != null) {
      for (FileSDConfig item : fileSDConfigs) {
        this.addToFileSDConfigs(item);
      }
    }
    return (A) this;
  }
  
  public A withGceSDConfigs(List<GCESDConfig> gceSDConfigs) {
    if (this.gceSDConfigs != null) {
      this._visitables.get("gceSDConfigs").clear();
    }
    if (gceSDConfigs != null) {
        this.gceSDConfigs = new ArrayList();
        for (GCESDConfig item : gceSDConfigs) {
          this.addToGceSDConfigs(item);
        }
    } else {
      this.gceSDConfigs = null;
    }
    return (A) this;
  }
  
  public A withGceSDConfigs(GCESDConfig... gceSDConfigs) {
    if (this.gceSDConfigs != null) {
        this.gceSDConfigs.clear();
        _visitables.remove("gceSDConfigs");
    }
    if (gceSDConfigs != null) {
      for (GCESDConfig item : gceSDConfigs) {
        this.addToGceSDConfigs(item);
      }
    }
    return (A) this;
  }
  
  public A withHetznerSDConfigs(List<HetznerSDConfig> hetznerSDConfigs) {
    if (this.hetznerSDConfigs != null) {
      this._visitables.get("hetznerSDConfigs").clear();
    }
    if (hetznerSDConfigs != null) {
        this.hetznerSDConfigs = new ArrayList();
        for (HetznerSDConfig item : hetznerSDConfigs) {
          this.addToHetznerSDConfigs(item);
        }
    } else {
      this.hetznerSDConfigs = null;
    }
    return (A) this;
  }
  
  public A withHetznerSDConfigs(HetznerSDConfig... hetznerSDConfigs) {
    if (this.hetznerSDConfigs != null) {
        this.hetznerSDConfigs.clear();
        _visitables.remove("hetznerSDConfigs");
    }
    if (hetznerSDConfigs != null) {
      for (HetznerSDConfig item : hetznerSDConfigs) {
        this.addToHetznerSDConfigs(item);
      }
    }
    return (A) this;
  }
  
  public A withHonorLabels() {
    return withHonorLabels(true);
  }
  
  public A withHonorLabels(Boolean honorLabels) {
    this.honorLabels = honorLabels;
    return (A) this;
  }
  
  public A withHonorTimestamps() {
    return withHonorTimestamps(true);
  }
  
  public A withHonorTimestamps(Boolean honorTimestamps) {
    this.honorTimestamps = honorTimestamps;
    return (A) this;
  }
  
  public A withHttpSDConfigs(List<HTTPSDConfig> httpSDConfigs) {
    if (this.httpSDConfigs != null) {
      this._visitables.get("httpSDConfigs").clear();
    }
    if (httpSDConfigs != null) {
        this.httpSDConfigs = new ArrayList();
        for (HTTPSDConfig item : httpSDConfigs) {
          this.addToHttpSDConfigs(item);
        }
    } else {
      this.httpSDConfigs = null;
    }
    return (A) this;
  }
  
  public A withHttpSDConfigs(HTTPSDConfig... httpSDConfigs) {
    if (this.httpSDConfigs != null) {
        this.httpSDConfigs.clear();
        _visitables.remove("httpSDConfigs");
    }
    if (httpSDConfigs != null) {
      for (HTTPSDConfig item : httpSDConfigs) {
        this.addToHttpSDConfigs(item);
      }
    }
    return (A) this;
  }
  
  public A withIonosSDConfigs(List<IonosSDConfig> ionosSDConfigs) {
    if (this.ionosSDConfigs != null) {
      this._visitables.get("ionosSDConfigs").clear();
    }
    if (ionosSDConfigs != null) {
        this.ionosSDConfigs = new ArrayList();
        for (IonosSDConfig item : ionosSDConfigs) {
          this.addToIonosSDConfigs(item);
        }
    } else {
      this.ionosSDConfigs = null;
    }
    return (A) this;
  }
  
  public A withIonosSDConfigs(IonosSDConfig... ionosSDConfigs) {
    if (this.ionosSDConfigs != null) {
        this.ionosSDConfigs.clear();
        _visitables.remove("ionosSDConfigs");
    }
    if (ionosSDConfigs != null) {
      for (IonosSDConfig item : ionosSDConfigs) {
        this.addToIonosSDConfigs(item);
      }
    }
    return (A) this;
  }
  
  public A withJobName(String jobName) {
    this.jobName = jobName;
    return (A) this;
  }
  
  public A withKeepDroppedTargets(Long keepDroppedTargets) {
    this.keepDroppedTargets = keepDroppedTargets;
    return (A) this;
  }
  
  public A withKubernetesSDConfigs(List<KubernetesSDConfig> kubernetesSDConfigs) {
    if (this.kubernetesSDConfigs != null) {
      this._visitables.get("kubernetesSDConfigs").clear();
    }
    if (kubernetesSDConfigs != null) {
        this.kubernetesSDConfigs = new ArrayList();
        for (KubernetesSDConfig item : kubernetesSDConfigs) {
          this.addToKubernetesSDConfigs(item);
        }
    } else {
      this.kubernetesSDConfigs = null;
    }
    return (A) this;
  }
  
  public A withKubernetesSDConfigs(KubernetesSDConfig... kubernetesSDConfigs) {
    if (this.kubernetesSDConfigs != null) {
        this.kubernetesSDConfigs.clear();
        _visitables.remove("kubernetesSDConfigs");
    }
    if (kubernetesSDConfigs != null) {
      for (KubernetesSDConfig item : kubernetesSDConfigs) {
        this.addToKubernetesSDConfigs(item);
      }
    }
    return (A) this;
  }
  
  public A withKumaSDConfigs(List<KumaSDConfig> kumaSDConfigs) {
    if (this.kumaSDConfigs != null) {
      this._visitables.get("kumaSDConfigs").clear();
    }
    if (kumaSDConfigs != null) {
        this.kumaSDConfigs = new ArrayList();
        for (KumaSDConfig item : kumaSDConfigs) {
          this.addToKumaSDConfigs(item);
        }
    } else {
      this.kumaSDConfigs = null;
    }
    return (A) this;
  }
  
  public A withKumaSDConfigs(KumaSDConfig... kumaSDConfigs) {
    if (this.kumaSDConfigs != null) {
        this.kumaSDConfigs.clear();
        _visitables.remove("kumaSDConfigs");
    }
    if (kumaSDConfigs != null) {
      for (KumaSDConfig item : kumaSDConfigs) {
        this.addToKumaSDConfigs(item);
      }
    }
    return (A) this;
  }
  
  public A withLabelLimit(Long labelLimit) {
    this.labelLimit = labelLimit;
    return (A) this;
  }
  
  public A withLabelNameLengthLimit(Long labelNameLengthLimit) {
    this.labelNameLengthLimit = labelNameLengthLimit;
    return (A) this;
  }
  
  public A withLabelValueLengthLimit(Long labelValueLengthLimit) {
    this.labelValueLengthLimit = labelValueLengthLimit;
    return (A) this;
  }
  
  public A withLightSailSDConfigs(List<LightSailSDConfig> lightSailSDConfigs) {
    if (this.lightSailSDConfigs != null) {
      this._visitables.get("lightSailSDConfigs").clear();
    }
    if (lightSailSDConfigs != null) {
        this.lightSailSDConfigs = new ArrayList();
        for (LightSailSDConfig item : lightSailSDConfigs) {
          this.addToLightSailSDConfigs(item);
        }
    } else {
      this.lightSailSDConfigs = null;
    }
    return (A) this;
  }
  
  public A withLightSailSDConfigs(LightSailSDConfig... lightSailSDConfigs) {
    if (this.lightSailSDConfigs != null) {
        this.lightSailSDConfigs.clear();
        _visitables.remove("lightSailSDConfigs");
    }
    if (lightSailSDConfigs != null) {
      for (LightSailSDConfig item : lightSailSDConfigs) {
        this.addToLightSailSDConfigs(item);
      }
    }
    return (A) this;
  }
  
  public A withLinodeSDConfigs(List<LinodeSDConfig> linodeSDConfigs) {
    if (this.linodeSDConfigs != null) {
      this._visitables.get("linodeSDConfigs").clear();
    }
    if (linodeSDConfigs != null) {
        this.linodeSDConfigs = new ArrayList();
        for (LinodeSDConfig item : linodeSDConfigs) {
          this.addToLinodeSDConfigs(item);
        }
    } else {
      this.linodeSDConfigs = null;
    }
    return (A) this;
  }
  
  public A withLinodeSDConfigs(LinodeSDConfig... linodeSDConfigs) {
    if (this.linodeSDConfigs != null) {
        this.linodeSDConfigs.clear();
        _visitables.remove("linodeSDConfigs");
    }
    if (linodeSDConfigs != null) {
      for (LinodeSDConfig item : linodeSDConfigs) {
        this.addToLinodeSDConfigs(item);
      }
    }
    return (A) this;
  }
  
  public A withMetricRelabelings(List<RelabelConfig> metricRelabelings) {
    if (this.metricRelabelings != null) {
      this._visitables.get("metricRelabelings").clear();
    }
    if (metricRelabelings != null) {
        this.metricRelabelings = new ArrayList();
        for (RelabelConfig item : metricRelabelings) {
          this.addToMetricRelabelings(item);
        }
    } else {
      this.metricRelabelings = null;
    }
    return (A) this;
  }
  
  public A withMetricRelabelings(RelabelConfig... metricRelabelings) {
    if (this.metricRelabelings != null) {
        this.metricRelabelings.clear();
        _visitables.remove("metricRelabelings");
    }
    if (metricRelabelings != null) {
      for (RelabelConfig item : metricRelabelings) {
        this.addToMetricRelabelings(item);
      }
    }
    return (A) this;
  }
  
  public A withMetricsPath(String metricsPath) {
    this.metricsPath = metricsPath;
    return (A) this;
  }
  
  public A withNameEscapingScheme(String nameEscapingScheme) {
    this.nameEscapingScheme = nameEscapingScheme;
    return (A) this;
  }
  
  public A withNameValidationScheme(String nameValidationScheme) {
    this.nameValidationScheme = nameValidationScheme;
    return (A) this;
  }
  
  public A withNativeHistogramBucketLimit(Long nativeHistogramBucketLimit) {
    this.nativeHistogramBucketLimit = nativeHistogramBucketLimit;
    return (A) this;
  }
  
  public A withNativeHistogramMinBucketFactor(Quantity nativeHistogramMinBucketFactor) {
    this.nativeHistogramMinBucketFactor = nativeHistogramMinBucketFactor;
    return (A) this;
  }
  
  public AuthorizationNested<A> withNewAuthorization() {
    return new AuthorizationNested(null);
  }
  
  public AuthorizationNested<A> withNewAuthorizationLike(SafeAuthorization item) {
    return new AuthorizationNested(item);
  }
  
  public BasicAuthNested<A> withNewBasicAuth() {
    return new BasicAuthNested(null);
  }
  
  public BasicAuthNested<A> withNewBasicAuthLike(BasicAuth item) {
    return new BasicAuthNested(item);
  }
  
  public A withNewNativeHistogramMinBucketFactor(String amount) {
    return (A) this.withNativeHistogramMinBucketFactor(new Quantity(amount));
  }
  
  public A withNewNativeHistogramMinBucketFactor(String amount,String format) {
    return (A) this.withNativeHistogramMinBucketFactor(new Quantity(amount, format));
  }
  
  public Oauth2Nested<A> withNewOauth2() {
    return new Oauth2Nested(null);
  }
  
  public Oauth2Nested<A> withNewOauth2Like(OAuth2 item) {
    return new Oauth2Nested(item);
  }
  
  public TlsConfigNested<A> withNewTlsConfig() {
    return new TlsConfigNested(null);
  }
  
  public TlsConfigNested<A> withNewTlsConfigLike(SafeTLSConfig item) {
    return new TlsConfigNested(item);
  }
  
  public A withNoProxy(String noProxy) {
    this.noProxy = noProxy;
    return (A) this;
  }
  
  public A withNomadSDConfigs(List<NomadSDConfig> nomadSDConfigs) {
    if (this.nomadSDConfigs != null) {
      this._visitables.get("nomadSDConfigs").clear();
    }
    if (nomadSDConfigs != null) {
        this.nomadSDConfigs = new ArrayList();
        for (NomadSDConfig item : nomadSDConfigs) {
          this.addToNomadSDConfigs(item);
        }
    } else {
      this.nomadSDConfigs = null;
    }
    return (A) this;
  }
  
  public A withNomadSDConfigs(NomadSDConfig... nomadSDConfigs) {
    if (this.nomadSDConfigs != null) {
        this.nomadSDConfigs.clear();
        _visitables.remove("nomadSDConfigs");
    }
    if (nomadSDConfigs != null) {
      for (NomadSDConfig item : nomadSDConfigs) {
        this.addToNomadSDConfigs(item);
      }
    }
    return (A) this;
  }
  
  public A withOauth2(OAuth2 oauth2) {
    this._visitables.remove("oauth2");
    if (oauth2 != null) {
        this.oauth2 = new OAuth2Builder(oauth2);
        this._visitables.get("oauth2").add(this.oauth2);
    } else {
        this.oauth2 = null;
        this._visitables.get("oauth2").remove(this.oauth2);
    }
    return (A) this;
  }
  
  public A withOpenstackSDConfigs(List<OpenStackSDConfig> openstackSDConfigs) {
    if (this.openstackSDConfigs != null) {
      this._visitables.get("openstackSDConfigs").clear();
    }
    if (openstackSDConfigs != null) {
        this.openstackSDConfigs = new ArrayList();
        for (OpenStackSDConfig item : openstackSDConfigs) {
          this.addToOpenstackSDConfigs(item);
        }
    } else {
      this.openstackSDConfigs = null;
    }
    return (A) this;
  }
  
  public A withOpenstackSDConfigs(OpenStackSDConfig... openstackSDConfigs) {
    if (this.openstackSDConfigs != null) {
        this.openstackSDConfigs.clear();
        _visitables.remove("openstackSDConfigs");
    }
    if (openstackSDConfigs != null) {
      for (OpenStackSDConfig item : openstackSDConfigs) {
        this.addToOpenstackSDConfigs(item);
      }
    }
    return (A) this;
  }
  
  public A withOvhcloudSDConfigs(List<OVHCloudSDConfig> ovhcloudSDConfigs) {
    if (this.ovhcloudSDConfigs != null) {
      this._visitables.get("ovhcloudSDConfigs").clear();
    }
    if (ovhcloudSDConfigs != null) {
        this.ovhcloudSDConfigs = new ArrayList();
        for (OVHCloudSDConfig item : ovhcloudSDConfigs) {
          this.addToOvhcloudSDConfigs(item);
        }
    } else {
      this.ovhcloudSDConfigs = null;
    }
    return (A) this;
  }
  
  public A withOvhcloudSDConfigs(OVHCloudSDConfig... ovhcloudSDConfigs) {
    if (this.ovhcloudSDConfigs != null) {
        this.ovhcloudSDConfigs.clear();
        _visitables.remove("ovhcloudSDConfigs");
    }
    if (ovhcloudSDConfigs != null) {
      for (OVHCloudSDConfig item : ovhcloudSDConfigs) {
        this.addToOvhcloudSDConfigs(item);
      }
    }
    return (A) this;
  }
  
  public <K,V>A withParams(Map<String,List<String>> params) {
    if (params == null) {
      this.params = null;
    } else {
      this.params = new LinkedHashMap(params);
    }
    return (A) this;
  }
  
  public <K,V>A withProxyConnectHeader(Map<String,List<SecretKeySelector>> proxyConnectHeader) {
    if (proxyConnectHeader == null) {
      this.proxyConnectHeader = null;
    } else {
      this.proxyConnectHeader = new LinkedHashMap(proxyConnectHeader);
    }
    return (A) this;
  }
  
  public A withProxyFromEnvironment() {
    return withProxyFromEnvironment(true);
  }
  
  public A withProxyFromEnvironment(Boolean proxyFromEnvironment) {
    this.proxyFromEnvironment = proxyFromEnvironment;
    return (A) this;
  }
  
  public A withProxyUrl(String proxyUrl) {
    this.proxyUrl = proxyUrl;
    return (A) this;
  }
  
  public A withPuppetDBSDConfigs(List<PuppetDBSDConfig> puppetDBSDConfigs) {
    if (this.puppetDBSDConfigs != null) {
      this._visitables.get("puppetDBSDConfigs").clear();
    }
    if (puppetDBSDConfigs != null) {
        this.puppetDBSDConfigs = new ArrayList();
        for (PuppetDBSDConfig item : puppetDBSDConfigs) {
          this.addToPuppetDBSDConfigs(item);
        }
    } else {
      this.puppetDBSDConfigs = null;
    }
    return (A) this;
  }
  
  public A withPuppetDBSDConfigs(PuppetDBSDConfig... puppetDBSDConfigs) {
    if (this.puppetDBSDConfigs != null) {
        this.puppetDBSDConfigs.clear();
        _visitables.remove("puppetDBSDConfigs");
    }
    if (puppetDBSDConfigs != null) {
      for (PuppetDBSDConfig item : puppetDBSDConfigs) {
        this.addToPuppetDBSDConfigs(item);
      }
    }
    return (A) this;
  }
  
  public A withRelabelings(List<RelabelConfig> relabelings) {
    if (this.relabelings != null) {
      this._visitables.get("relabelings").clear();
    }
    if (relabelings != null) {
        this.relabelings = new ArrayList();
        for (RelabelConfig item : relabelings) {
          this.addToRelabelings(item);
        }
    } else {
      this.relabelings = null;
    }
    return (A) this;
  }
  
  public A withRelabelings(RelabelConfig... relabelings) {
    if (this.relabelings != null) {
        this.relabelings.clear();
        _visitables.remove("relabelings");
    }
    if (relabelings != null) {
      for (RelabelConfig item : relabelings) {
        this.addToRelabelings(item);
      }
    }
    return (A) this;
  }
  
  public A withSampleLimit(Long sampleLimit) {
    this.sampleLimit = sampleLimit;
    return (A) this;
  }
  
  public A withScalewaySDConfigs(List<ScalewaySDConfig> scalewaySDConfigs) {
    if (this.scalewaySDConfigs != null) {
      this._visitables.get("scalewaySDConfigs").clear();
    }
    if (scalewaySDConfigs != null) {
        this.scalewaySDConfigs = new ArrayList();
        for (ScalewaySDConfig item : scalewaySDConfigs) {
          this.addToScalewaySDConfigs(item);
        }
    } else {
      this.scalewaySDConfigs = null;
    }
    return (A) this;
  }
  
  public A withScalewaySDConfigs(ScalewaySDConfig... scalewaySDConfigs) {
    if (this.scalewaySDConfigs != null) {
        this.scalewaySDConfigs.clear();
        _visitables.remove("scalewaySDConfigs");
    }
    if (scalewaySDConfigs != null) {
      for (ScalewaySDConfig item : scalewaySDConfigs) {
        this.addToScalewaySDConfigs(item);
      }
    }
    return (A) this;
  }
  
  public A withScheme(String scheme) {
    this.scheme = scheme;
    return (A) this;
  }
  
  public A withScrapeClass(String scrapeClass) {
    this.scrapeClass = scrapeClass;
    return (A) this;
  }
  
  public A withScrapeClassicHistograms() {
    return withScrapeClassicHistograms(true);
  }
  
  public A withScrapeClassicHistograms(Boolean scrapeClassicHistograms) {
    this.scrapeClassicHistograms = scrapeClassicHistograms;
    return (A) this;
  }
  
  public A withScrapeInterval(String scrapeInterval) {
    this.scrapeInterval = scrapeInterval;
    return (A) this;
  }
  
  public A withScrapeNativeHistograms() {
    return withScrapeNativeHistograms(true);
  }
  
  public A withScrapeNativeHistograms(Boolean scrapeNativeHistograms) {
    this.scrapeNativeHistograms = scrapeNativeHistograms;
    return (A) this;
  }
  
  public A withScrapeProtocols(List<String> scrapeProtocols) {
    if (scrapeProtocols != null) {
        this.scrapeProtocols = new ArrayList();
        for (String item : scrapeProtocols) {
          this.addToScrapeProtocols(item);
        }
    } else {
      this.scrapeProtocols = null;
    }
    return (A) this;
  }
  
  public A withScrapeProtocols(String... scrapeProtocols) {
    if (this.scrapeProtocols != null) {
        this.scrapeProtocols.clear();
        _visitables.remove("scrapeProtocols");
    }
    if (scrapeProtocols != null) {
      for (String item : scrapeProtocols) {
        this.addToScrapeProtocols(item);
      }
    }
    return (A) this;
  }
  
  public A withScrapeTimeout(String scrapeTimeout) {
    this.scrapeTimeout = scrapeTimeout;
    return (A) this;
  }
  
  public A withStaticConfigs(List<StaticConfig> staticConfigs) {
    if (this.staticConfigs != null) {
      this._visitables.get("staticConfigs").clear();
    }
    if (staticConfigs != null) {
        this.staticConfigs = new ArrayList();
        for (StaticConfig item : staticConfigs) {
          this.addToStaticConfigs(item);
        }
    } else {
      this.staticConfigs = null;
    }
    return (A) this;
  }
  
  public A withStaticConfigs(StaticConfig... staticConfigs) {
    if (this.staticConfigs != null) {
        this.staticConfigs.clear();
        _visitables.remove("staticConfigs");
    }
    if (staticConfigs != null) {
      for (StaticConfig item : staticConfigs) {
        this.addToStaticConfigs(item);
      }
    }
    return (A) this;
  }
  
  public A withTargetLimit(Long targetLimit) {
    this.targetLimit = targetLimit;
    return (A) this;
  }
  
  public A withTlsConfig(SafeTLSConfig tlsConfig) {
    this._visitables.remove("tlsConfig");
    if (tlsConfig != null) {
        this.tlsConfig = new SafeTLSConfigBuilder(tlsConfig);
        this._visitables.get("tlsConfig").add(this.tlsConfig);
    } else {
        this.tlsConfig = null;
        this._visitables.get("tlsConfig").remove(this.tlsConfig);
    }
    return (A) this;
  }
  
  public A withTrackTimestampsStaleness() {
    return withTrackTimestampsStaleness(true);
  }
  
  public A withTrackTimestampsStaleness(Boolean trackTimestampsStaleness) {
    this.trackTimestampsStaleness = trackTimestampsStaleness;
    return (A) this;
  }
  public class AuthorizationNested<N> extends SafeAuthorizationFluent<AuthorizationNested<N>> implements Nested<N>{
  
    SafeAuthorizationBuilder builder;
  
    AuthorizationNested(SafeAuthorization item) {
      this.builder = new SafeAuthorizationBuilder(this, item);
    }
  
    public N and() {
      return (N) ScrapeConfigSpecFluent.this.withAuthorization(builder.build());
    }
    
    public N endAuthorization() {
      return and();
    }
    
  }
  public class AzureSDConfigsNested<N> extends AzureSDConfigFluent<AzureSDConfigsNested<N>> implements Nested<N>{
  
    AzureSDConfigBuilder builder;
    int index;
  
    AzureSDConfigsNested(int index,AzureSDConfig item) {
      this.index = index;
      this.builder = new AzureSDConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) ScrapeConfigSpecFluent.this.setToAzureSDConfigs(index, builder.build());
    }
    
    public N endAzureSDConfig() {
      return and();
    }
    
  }
  public class BasicAuthNested<N> extends BasicAuthFluent<BasicAuthNested<N>> implements Nested<N>{
  
    BasicAuthBuilder builder;
  
    BasicAuthNested(BasicAuth item) {
      this.builder = new BasicAuthBuilder(this, item);
    }
  
    public N and() {
      return (N) ScrapeConfigSpecFluent.this.withBasicAuth(builder.build());
    }
    
    public N endBasicAuth() {
      return and();
    }
    
  }
  public class ConsulSDConfigsNested<N> extends ConsulSDConfigFluent<ConsulSDConfigsNested<N>> implements Nested<N>{
  
    ConsulSDConfigBuilder builder;
    int index;
  
    ConsulSDConfigsNested(int index,ConsulSDConfig item) {
      this.index = index;
      this.builder = new ConsulSDConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) ScrapeConfigSpecFluent.this.setToConsulSDConfigs(index, builder.build());
    }
    
    public N endConsulSDConfig() {
      return and();
    }
    
  }
  public class DigitalOceanSDConfigsNested<N> extends DigitalOceanSDConfigFluent<DigitalOceanSDConfigsNested<N>> implements Nested<N>{
  
    DigitalOceanSDConfigBuilder builder;
    int index;
  
    DigitalOceanSDConfigsNested(int index,DigitalOceanSDConfig item) {
      this.index = index;
      this.builder = new DigitalOceanSDConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) ScrapeConfigSpecFluent.this.setToDigitalOceanSDConfigs(index, builder.build());
    }
    
    public N endDigitalOceanSDConfig() {
      return and();
    }
    
  }
  public class DnsSDConfigsNested<N> extends DNSSDConfigFluent<DnsSDConfigsNested<N>> implements Nested<N>{
  
    DNSSDConfigBuilder builder;
    int index;
  
    DnsSDConfigsNested(int index,DNSSDConfig item) {
      this.index = index;
      this.builder = new DNSSDConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) ScrapeConfigSpecFluent.this.setToDnsSDConfigs(index, builder.build());
    }
    
    public N endDnsSDConfig() {
      return and();
    }
    
  }
  public class DockerSDConfigsNested<N> extends DockerSDConfigFluent<DockerSDConfigsNested<N>> implements Nested<N>{
  
    DockerSDConfigBuilder builder;
    int index;
  
    DockerSDConfigsNested(int index,DockerSDConfig item) {
      this.index = index;
      this.builder = new DockerSDConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) ScrapeConfigSpecFluent.this.setToDockerSDConfigs(index, builder.build());
    }
    
    public N endDockerSDConfig() {
      return and();
    }
    
  }
  public class DockerSwarmSDConfigsNested<N> extends DockerSwarmSDConfigFluent<DockerSwarmSDConfigsNested<N>> implements Nested<N>{
  
    DockerSwarmSDConfigBuilder builder;
    int index;
  
    DockerSwarmSDConfigsNested(int index,DockerSwarmSDConfig item) {
      this.index = index;
      this.builder = new DockerSwarmSDConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) ScrapeConfigSpecFluent.this.setToDockerSwarmSDConfigs(index, builder.build());
    }
    
    public N endDockerSwarmSDConfig() {
      return and();
    }
    
  }
  public class Ec2SDConfigsNested<N> extends EC2SDConfigFluent<Ec2SDConfigsNested<N>> implements Nested<N>{
  
    EC2SDConfigBuilder builder;
    int index;
  
    Ec2SDConfigsNested(int index,EC2SDConfig item) {
      this.index = index;
      this.builder = new EC2SDConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) ScrapeConfigSpecFluent.this.setToEc2SDConfigs(index, builder.build());
    }
    
    public N endEc2SDConfig() {
      return and();
    }
    
  }
  public class EurekaSDConfigsNested<N> extends EurekaSDConfigFluent<EurekaSDConfigsNested<N>> implements Nested<N>{
  
    EurekaSDConfigBuilder builder;
    int index;
  
    EurekaSDConfigsNested(int index,EurekaSDConfig item) {
      this.index = index;
      this.builder = new EurekaSDConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) ScrapeConfigSpecFluent.this.setToEurekaSDConfigs(index, builder.build());
    }
    
    public N endEurekaSDConfig() {
      return and();
    }
    
  }
  public class FileSDConfigsNested<N> extends FileSDConfigFluent<FileSDConfigsNested<N>> implements Nested<N>{
  
    FileSDConfigBuilder builder;
    int index;
  
    FileSDConfigsNested(int index,FileSDConfig item) {
      this.index = index;
      this.builder = new FileSDConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) ScrapeConfigSpecFluent.this.setToFileSDConfigs(index, builder.build());
    }
    
    public N endFileSDConfig() {
      return and();
    }
    
  }
  public class GceSDConfigsNested<N> extends GCESDConfigFluent<GceSDConfigsNested<N>> implements Nested<N>{
  
    GCESDConfigBuilder builder;
    int index;
  
    GceSDConfigsNested(int index,GCESDConfig item) {
      this.index = index;
      this.builder = new GCESDConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) ScrapeConfigSpecFluent.this.setToGceSDConfigs(index, builder.build());
    }
    
    public N endGceSDConfig() {
      return and();
    }
    
  }
  public class HetznerSDConfigsNested<N> extends HetznerSDConfigFluent<HetznerSDConfigsNested<N>> implements Nested<N>{
  
    HetznerSDConfigBuilder builder;
    int index;
  
    HetznerSDConfigsNested(int index,HetznerSDConfig item) {
      this.index = index;
      this.builder = new HetznerSDConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) ScrapeConfigSpecFluent.this.setToHetznerSDConfigs(index, builder.build());
    }
    
    public N endHetznerSDConfig() {
      return and();
    }
    
  }
  public class HttpSDConfigsNested<N> extends HTTPSDConfigFluent<HttpSDConfigsNested<N>> implements Nested<N>{
  
    HTTPSDConfigBuilder builder;
    int index;
  
    HttpSDConfigsNested(int index,HTTPSDConfig item) {
      this.index = index;
      this.builder = new HTTPSDConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) ScrapeConfigSpecFluent.this.setToHttpSDConfigs(index, builder.build());
    }
    
    public N endHttpSDConfig() {
      return and();
    }
    
  }
  public class IonosSDConfigsNested<N> extends IonosSDConfigFluent<IonosSDConfigsNested<N>> implements Nested<N>{
  
    IonosSDConfigBuilder builder;
    int index;
  
    IonosSDConfigsNested(int index,IonosSDConfig item) {
      this.index = index;
      this.builder = new IonosSDConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) ScrapeConfigSpecFluent.this.setToIonosSDConfigs(index, builder.build());
    }
    
    public N endIonosSDConfig() {
      return and();
    }
    
  }
  public class KubernetesSDConfigsNested<N> extends KubernetesSDConfigFluent<KubernetesSDConfigsNested<N>> implements Nested<N>{
  
    KubernetesSDConfigBuilder builder;
    int index;
  
    KubernetesSDConfigsNested(int index,KubernetesSDConfig item) {
      this.index = index;
      this.builder = new KubernetesSDConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) ScrapeConfigSpecFluent.this.setToKubernetesSDConfigs(index, builder.build());
    }
    
    public N endKubernetesSDConfig() {
      return and();
    }
    
  }
  public class KumaSDConfigsNested<N> extends KumaSDConfigFluent<KumaSDConfigsNested<N>> implements Nested<N>{
  
    KumaSDConfigBuilder builder;
    int index;
  
    KumaSDConfigsNested(int index,KumaSDConfig item) {
      this.index = index;
      this.builder = new KumaSDConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) ScrapeConfigSpecFluent.this.setToKumaSDConfigs(index, builder.build());
    }
    
    public N endKumaSDConfig() {
      return and();
    }
    
  }
  public class LightSailSDConfigsNested<N> extends LightSailSDConfigFluent<LightSailSDConfigsNested<N>> implements Nested<N>{
  
    LightSailSDConfigBuilder builder;
    int index;
  
    LightSailSDConfigsNested(int index,LightSailSDConfig item) {
      this.index = index;
      this.builder = new LightSailSDConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) ScrapeConfigSpecFluent.this.setToLightSailSDConfigs(index, builder.build());
    }
    
    public N endLightSailSDConfig() {
      return and();
    }
    
  }
  public class LinodeSDConfigsNested<N> extends LinodeSDConfigFluent<LinodeSDConfigsNested<N>> implements Nested<N>{
  
    LinodeSDConfigBuilder builder;
    int index;
  
    LinodeSDConfigsNested(int index,LinodeSDConfig item) {
      this.index = index;
      this.builder = new LinodeSDConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) ScrapeConfigSpecFluent.this.setToLinodeSDConfigs(index, builder.build());
    }
    
    public N endLinodeSDConfig() {
      return and();
    }
    
  }
  public class MetricRelabelingsNested<N> extends RelabelConfigFluent<MetricRelabelingsNested<N>> implements Nested<N>{
  
    RelabelConfigBuilder builder;
    int index;
  
    MetricRelabelingsNested(int index,RelabelConfig item) {
      this.index = index;
      this.builder = new RelabelConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) ScrapeConfigSpecFluent.this.setToMetricRelabelings(index, builder.build());
    }
    
    public N endMetricRelabeling() {
      return and();
    }
    
  }
  public class NomadSDConfigsNested<N> extends NomadSDConfigFluent<NomadSDConfigsNested<N>> implements Nested<N>{
  
    NomadSDConfigBuilder builder;
    int index;
  
    NomadSDConfigsNested(int index,NomadSDConfig item) {
      this.index = index;
      this.builder = new NomadSDConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) ScrapeConfigSpecFluent.this.setToNomadSDConfigs(index, builder.build());
    }
    
    public N endNomadSDConfig() {
      return and();
    }
    
  }
  public class Oauth2Nested<N> extends OAuth2Fluent<Oauth2Nested<N>> implements Nested<N>{
  
    OAuth2Builder builder;
  
    Oauth2Nested(OAuth2 item) {
      this.builder = new OAuth2Builder(this, item);
    }
  
    public N and() {
      return (N) ScrapeConfigSpecFluent.this.withOauth2(builder.build());
    }
    
    public N endOauth2() {
      return and();
    }
    
  }
  public class OpenstackSDConfigsNested<N> extends OpenStackSDConfigFluent<OpenstackSDConfigsNested<N>> implements Nested<N>{
  
    OpenStackSDConfigBuilder builder;
    int index;
  
    OpenstackSDConfigsNested(int index,OpenStackSDConfig item) {
      this.index = index;
      this.builder = new OpenStackSDConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) ScrapeConfigSpecFluent.this.setToOpenstackSDConfigs(index, builder.build());
    }
    
    public N endOpenstackSDConfig() {
      return and();
    }
    
  }
  public class OvhcloudSDConfigsNested<N> extends OVHCloudSDConfigFluent<OvhcloudSDConfigsNested<N>> implements Nested<N>{
  
    OVHCloudSDConfigBuilder builder;
    int index;
  
    OvhcloudSDConfigsNested(int index,OVHCloudSDConfig item) {
      this.index = index;
      this.builder = new OVHCloudSDConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) ScrapeConfigSpecFluent.this.setToOvhcloudSDConfigs(index, builder.build());
    }
    
    public N endOvhcloudSDConfig() {
      return and();
    }
    
  }
  public class PuppetDBSDConfigsNested<N> extends PuppetDBSDConfigFluent<PuppetDBSDConfigsNested<N>> implements Nested<N>{
  
    PuppetDBSDConfigBuilder builder;
    int index;
  
    PuppetDBSDConfigsNested(int index,PuppetDBSDConfig item) {
      this.index = index;
      this.builder = new PuppetDBSDConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) ScrapeConfigSpecFluent.this.setToPuppetDBSDConfigs(index, builder.build());
    }
    
    public N endPuppetDBSDConfig() {
      return and();
    }
    
  }
  public class RelabelingsNested<N> extends RelabelConfigFluent<RelabelingsNested<N>> implements Nested<N>{
  
    RelabelConfigBuilder builder;
    int index;
  
    RelabelingsNested(int index,RelabelConfig item) {
      this.index = index;
      this.builder = new RelabelConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) ScrapeConfigSpecFluent.this.setToRelabelings(index, builder.build());
    }
    
    public N endRelabeling() {
      return and();
    }
    
  }
  public class ScalewaySDConfigsNested<N> extends ScalewaySDConfigFluent<ScalewaySDConfigsNested<N>> implements Nested<N>{
  
    ScalewaySDConfigBuilder builder;
    int index;
  
    ScalewaySDConfigsNested(int index,ScalewaySDConfig item) {
      this.index = index;
      this.builder = new ScalewaySDConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) ScrapeConfigSpecFluent.this.setToScalewaySDConfigs(index, builder.build());
    }
    
    public N endScalewaySDConfig() {
      return and();
    }
    
  }
  public class StaticConfigsNested<N> extends StaticConfigFluent<StaticConfigsNested<N>> implements Nested<N>{
  
    StaticConfigBuilder builder;
    int index;
  
    StaticConfigsNested(int index,StaticConfig item) {
      this.index = index;
      this.builder = new StaticConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) ScrapeConfigSpecFluent.this.setToStaticConfigs(index, builder.build());
    }
    
    public N endStaticConfig() {
      return and();
    }
    
  }
  public class TlsConfigNested<N> extends SafeTLSConfigFluent<TlsConfigNested<N>> implements Nested<N>{
  
    SafeTLSConfigBuilder builder;
  
    TlsConfigNested(SafeTLSConfig item) {
      this.builder = new SafeTLSConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) ScrapeConfigSpecFluent.this.withTlsConfig(builder.build());
    }
    
    public N endTlsConfig() {
      return and();
    }
    
  }
}