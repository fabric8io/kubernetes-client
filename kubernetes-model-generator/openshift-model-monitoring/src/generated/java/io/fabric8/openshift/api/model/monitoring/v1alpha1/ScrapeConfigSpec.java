
package io.fabric8.openshift.api.model.monitoring.v1alpha1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.Quantity;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.SecretKeySelector;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.fabric8.openshift.api.model.monitoring.v1.BasicAuth;
import io.fabric8.openshift.api.model.monitoring.v1.OAuth2;
import io.fabric8.openshift.api.model.monitoring.v1.RelabelConfig;
import io.fabric8.openshift.api.model.monitoring.v1.SafeAuthorization;
import io.fabric8.openshift.api.model.monitoring.v1.SafeTLSConfig;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * ScrapeConfigSpec is a specification of the desired configuration for a scrape configuration.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "authorization",
    "azureSDConfigs",
    "basicAuth",
    "consulSDConfigs",
    "convertClassicHistogramsToNHCB",
    "digitalOceanSDConfigs",
    "dnsSDConfigs",
    "dockerSDConfigs",
    "dockerSwarmSDConfigs",
    "ec2SDConfigs",
    "enableCompression",
    "enableHTTP2",
    "eurekaSDConfigs",
    "fallbackScrapeProtocol",
    "fileSDConfigs",
    "gceSDConfigs",
    "hetznerSDConfigs",
    "honorLabels",
    "honorTimestamps",
    "httpSDConfigs",
    "ionosSDConfigs",
    "jobName",
    "keepDroppedTargets",
    "kubernetesSDConfigs",
    "kumaSDConfigs",
    "labelLimit",
    "labelNameLengthLimit",
    "labelValueLengthLimit",
    "lightSailSDConfigs",
    "linodeSDConfigs",
    "metricRelabelings",
    "metricsPath",
    "nameEscapingScheme",
    "nameValidationScheme",
    "nativeHistogramBucketLimit",
    "nativeHistogramMinBucketFactor",
    "noProxy",
    "nomadSDConfigs",
    "oauth2",
    "openstackSDConfigs",
    "ovhcloudSDConfigs",
    "params",
    "proxyConnectHeader",
    "proxyFromEnvironment",
    "proxyUrl",
    "puppetDBSDConfigs",
    "relabelings",
    "sampleLimit",
    "scalewaySDConfigs",
    "scheme",
    "scrapeClass",
    "scrapeClassicHistograms",
    "scrapeInterval",
    "scrapeProtocols",
    "scrapeTimeout",
    "staticConfigs",
    "targetLimit",
    "tlsConfig",
    "trackTimestampsStaleness"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ScrapeConfigSpec implements Editable<ScrapeConfigSpecBuilder>, KubernetesResource
{

    @JsonProperty("authorization")
    private SafeAuthorization authorization;
    @JsonProperty("azureSDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AzureSDConfig> azureSDConfigs = new ArrayList<>();
    @JsonProperty("basicAuth")
    private BasicAuth basicAuth;
    @JsonProperty("consulSDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ConsulSDConfig> consulSDConfigs = new ArrayList<>();
    @JsonProperty("convertClassicHistogramsToNHCB")
    private Boolean convertClassicHistogramsToNHCB;
    @JsonProperty("digitalOceanSDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<DigitalOceanSDConfig> digitalOceanSDConfigs = new ArrayList<>();
    @JsonProperty("dnsSDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<DNSSDConfig> dnsSDConfigs = new ArrayList<>();
    @JsonProperty("dockerSDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<DockerSDConfig> dockerSDConfigs = new ArrayList<>();
    @JsonProperty("dockerSwarmSDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<DockerSwarmSDConfig> dockerSwarmSDConfigs = new ArrayList<>();
    @JsonProperty("ec2SDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<EC2SDConfig> ec2SDConfigs = new ArrayList<>();
    @JsonProperty("enableCompression")
    private Boolean enableCompression;
    @JsonProperty("enableHTTP2")
    private Boolean enableHTTP2;
    @JsonProperty("eurekaSDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<EurekaSDConfig> eurekaSDConfigs = new ArrayList<>();
    @JsonProperty("fallbackScrapeProtocol")
    private String fallbackScrapeProtocol;
    @JsonProperty("fileSDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<FileSDConfig> fileSDConfigs = new ArrayList<>();
    @JsonProperty("gceSDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<GCESDConfig> gceSDConfigs = new ArrayList<>();
    @JsonProperty("hetznerSDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<HetznerSDConfig> hetznerSDConfigs = new ArrayList<>();
    @JsonProperty("honorLabels")
    private Boolean honorLabels;
    @JsonProperty("honorTimestamps")
    private Boolean honorTimestamps;
    @JsonProperty("httpSDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<HTTPSDConfig> httpSDConfigs = new ArrayList<>();
    @JsonProperty("ionosSDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<IonosSDConfig> ionosSDConfigs = new ArrayList<>();
    @JsonProperty("jobName")
    private String jobName;
    @JsonProperty("keepDroppedTargets")
    private Long keepDroppedTargets;
    @JsonProperty("kubernetesSDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<KubernetesSDConfig> kubernetesSDConfigs = new ArrayList<>();
    @JsonProperty("kumaSDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<KumaSDConfig> kumaSDConfigs = new ArrayList<>();
    @JsonProperty("labelLimit")
    private Long labelLimit;
    @JsonProperty("labelNameLengthLimit")
    private Long labelNameLengthLimit;
    @JsonProperty("labelValueLengthLimit")
    private Long labelValueLengthLimit;
    @JsonProperty("lightSailSDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<LightSailSDConfig> lightSailSDConfigs = new ArrayList<>();
    @JsonProperty("linodeSDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<LinodeSDConfig> linodeSDConfigs = new ArrayList<>();
    @JsonProperty("metricRelabelings")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<RelabelConfig> metricRelabelings = new ArrayList<>();
    @JsonProperty("metricsPath")
    private String metricsPath;
    @JsonProperty("nameEscapingScheme")
    private String nameEscapingScheme;
    @JsonProperty("nameValidationScheme")
    private String nameValidationScheme;
    @JsonProperty("nativeHistogramBucketLimit")
    private Long nativeHistogramBucketLimit;
    @JsonProperty("nativeHistogramMinBucketFactor")
    private Quantity nativeHistogramMinBucketFactor;
    @JsonProperty("noProxy")
    private String noProxy;
    @JsonProperty("nomadSDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NomadSDConfig> nomadSDConfigs = new ArrayList<>();
    @JsonProperty("oauth2")
    private OAuth2 oauth2;
    @JsonProperty("openstackSDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<OpenStackSDConfig> openstackSDConfigs = new ArrayList<>();
    @JsonProperty("ovhcloudSDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<OVHCloudSDConfig> ovhcloudSDConfigs = new ArrayList<>();
    @JsonProperty("params")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, List<String>> params = new LinkedHashMap<>();
    @JsonProperty("proxyConnectHeader")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, List<SecretKeySelector>> proxyConnectHeader = new LinkedHashMap<>();
    @JsonProperty("proxyFromEnvironment")
    private Boolean proxyFromEnvironment;
    @JsonProperty("proxyUrl")
    private String proxyUrl;
    @JsonProperty("puppetDBSDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PuppetDBSDConfig> puppetDBSDConfigs = new ArrayList<>();
    @JsonProperty("relabelings")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<RelabelConfig> relabelings = new ArrayList<>();
    @JsonProperty("sampleLimit")
    private Long sampleLimit;
    @JsonProperty("scalewaySDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ScalewaySDConfig> scalewaySDConfigs = new ArrayList<>();
    @JsonProperty("scheme")
    private String scheme;
    @JsonProperty("scrapeClass")
    private String scrapeClass;
    @JsonProperty("scrapeClassicHistograms")
    private Boolean scrapeClassicHistograms;
    @JsonProperty("scrapeInterval")
    private String scrapeInterval;
    @JsonProperty("scrapeProtocols")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> scrapeProtocols = new ArrayList<>();
    @JsonProperty("scrapeTimeout")
    private String scrapeTimeout;
    @JsonProperty("staticConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<StaticConfig> staticConfigs = new ArrayList<>();
    @JsonProperty("targetLimit")
    private Long targetLimit;
    @JsonProperty("tlsConfig")
    private SafeTLSConfig tlsConfig;
    @JsonProperty("trackTimestampsStaleness")
    private Boolean trackTimestampsStaleness;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ScrapeConfigSpec() {
    }

    public ScrapeConfigSpec(SafeAuthorization authorization, List<AzureSDConfig> azureSDConfigs, BasicAuth basicAuth, List<ConsulSDConfig> consulSDConfigs, Boolean convertClassicHistogramsToNHCB, List<DigitalOceanSDConfig> digitalOceanSDConfigs, List<DNSSDConfig> dnsSDConfigs, List<DockerSDConfig> dockerSDConfigs, List<DockerSwarmSDConfig> dockerSwarmSDConfigs, List<EC2SDConfig> ec2SDConfigs, Boolean enableCompression, Boolean enableHTTP2, List<EurekaSDConfig> eurekaSDConfigs, String fallbackScrapeProtocol, List<FileSDConfig> fileSDConfigs, List<GCESDConfig> gceSDConfigs, List<HetznerSDConfig> hetznerSDConfigs, Boolean honorLabels, Boolean honorTimestamps, List<HTTPSDConfig> httpSDConfigs, List<IonosSDConfig> ionosSDConfigs, String jobName, Long keepDroppedTargets, List<KubernetesSDConfig> kubernetesSDConfigs, List<KumaSDConfig> kumaSDConfigs, Long labelLimit, Long labelNameLengthLimit, Long labelValueLengthLimit, List<LightSailSDConfig> lightSailSDConfigs, List<LinodeSDConfig> linodeSDConfigs, List<RelabelConfig> metricRelabelings, String metricsPath, String nameEscapingScheme, String nameValidationScheme, Long nativeHistogramBucketLimit, Quantity nativeHistogramMinBucketFactor, String noProxy, List<NomadSDConfig> nomadSDConfigs, OAuth2 oauth2, List<OpenStackSDConfig> openstackSDConfigs, List<OVHCloudSDConfig> ovhcloudSDConfigs, Map<String, List<String>> params, Map<String, List<SecretKeySelector>> proxyConnectHeader, Boolean proxyFromEnvironment, String proxyUrl, List<PuppetDBSDConfig> puppetDBSDConfigs, List<RelabelConfig> relabelings, Long sampleLimit, List<ScalewaySDConfig> scalewaySDConfigs, String scheme, String scrapeClass, Boolean scrapeClassicHistograms, String scrapeInterval, List<String> scrapeProtocols, String scrapeTimeout, List<StaticConfig> staticConfigs, Long targetLimit, SafeTLSConfig tlsConfig, Boolean trackTimestampsStaleness) {
        super();
        this.authorization = authorization;
        this.azureSDConfigs = azureSDConfigs;
        this.basicAuth = basicAuth;
        this.consulSDConfigs = consulSDConfigs;
        this.convertClassicHistogramsToNHCB = convertClassicHistogramsToNHCB;
        this.digitalOceanSDConfigs = digitalOceanSDConfigs;
        this.dnsSDConfigs = dnsSDConfigs;
        this.dockerSDConfigs = dockerSDConfigs;
        this.dockerSwarmSDConfigs = dockerSwarmSDConfigs;
        this.ec2SDConfigs = ec2SDConfigs;
        this.enableCompression = enableCompression;
        this.enableHTTP2 = enableHTTP2;
        this.eurekaSDConfigs = eurekaSDConfigs;
        this.fallbackScrapeProtocol = fallbackScrapeProtocol;
        this.fileSDConfigs = fileSDConfigs;
        this.gceSDConfigs = gceSDConfigs;
        this.hetznerSDConfigs = hetznerSDConfigs;
        this.honorLabels = honorLabels;
        this.honorTimestamps = honorTimestamps;
        this.httpSDConfigs = httpSDConfigs;
        this.ionosSDConfigs = ionosSDConfigs;
        this.jobName = jobName;
        this.keepDroppedTargets = keepDroppedTargets;
        this.kubernetesSDConfigs = kubernetesSDConfigs;
        this.kumaSDConfigs = kumaSDConfigs;
        this.labelLimit = labelLimit;
        this.labelNameLengthLimit = labelNameLengthLimit;
        this.labelValueLengthLimit = labelValueLengthLimit;
        this.lightSailSDConfigs = lightSailSDConfigs;
        this.linodeSDConfigs = linodeSDConfigs;
        this.metricRelabelings = metricRelabelings;
        this.metricsPath = metricsPath;
        this.nameEscapingScheme = nameEscapingScheme;
        this.nameValidationScheme = nameValidationScheme;
        this.nativeHistogramBucketLimit = nativeHistogramBucketLimit;
        this.nativeHistogramMinBucketFactor = nativeHistogramMinBucketFactor;
        this.noProxy = noProxy;
        this.nomadSDConfigs = nomadSDConfigs;
        this.oauth2 = oauth2;
        this.openstackSDConfigs = openstackSDConfigs;
        this.ovhcloudSDConfigs = ovhcloudSDConfigs;
        this.params = params;
        this.proxyConnectHeader = proxyConnectHeader;
        this.proxyFromEnvironment = proxyFromEnvironment;
        this.proxyUrl = proxyUrl;
        this.puppetDBSDConfigs = puppetDBSDConfigs;
        this.relabelings = relabelings;
        this.sampleLimit = sampleLimit;
        this.scalewaySDConfigs = scalewaySDConfigs;
        this.scheme = scheme;
        this.scrapeClass = scrapeClass;
        this.scrapeClassicHistograms = scrapeClassicHistograms;
        this.scrapeInterval = scrapeInterval;
        this.scrapeProtocols = scrapeProtocols;
        this.scrapeTimeout = scrapeTimeout;
        this.staticConfigs = staticConfigs;
        this.targetLimit = targetLimit;
        this.tlsConfig = tlsConfig;
        this.trackTimestampsStaleness = trackTimestampsStaleness;
    }

    /**
     * ScrapeConfigSpec is a specification of the desired configuration for a scrape configuration.
     */
    @JsonProperty("authorization")
    public SafeAuthorization getAuthorization() {
        return authorization;
    }

    /**
     * ScrapeConfigSpec is a specification of the desired configuration for a scrape configuration.
     */
    @JsonProperty("authorization")
    public void setAuthorization(SafeAuthorization authorization) {
        this.authorization = authorization;
    }

    /**
     * AzureSDConfigs defines a list of Azure service discovery configurations.
     */
    @JsonProperty("azureSDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<AzureSDConfig> getAzureSDConfigs() {
        return azureSDConfigs;
    }

    /**
     * AzureSDConfigs defines a list of Azure service discovery configurations.
     */
    @JsonProperty("azureSDConfigs")
    public void setAzureSDConfigs(List<AzureSDConfig> azureSDConfigs) {
        this.azureSDConfigs = azureSDConfigs;
    }

    /**
     * ScrapeConfigSpec is a specification of the desired configuration for a scrape configuration.
     */
    @JsonProperty("basicAuth")
    public BasicAuth getBasicAuth() {
        return basicAuth;
    }

    /**
     * ScrapeConfigSpec is a specification of the desired configuration for a scrape configuration.
     */
    @JsonProperty("basicAuth")
    public void setBasicAuth(BasicAuth basicAuth) {
        this.basicAuth = basicAuth;
    }

    /**
     * ConsulSDConfigs defines a list of Consul service discovery configurations.
     */
    @JsonProperty("consulSDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ConsulSDConfig> getConsulSDConfigs() {
        return consulSDConfigs;
    }

    /**
     * ConsulSDConfigs defines a list of Consul service discovery configurations.
     */
    @JsonProperty("consulSDConfigs")
    public void setConsulSDConfigs(List<ConsulSDConfig> consulSDConfigs) {
        this.consulSDConfigs = consulSDConfigs;
    }

    /**
     * Whether to convert all scraped classic histograms into a native histogram with custom buckets. It requires Prometheus &gt;= v3.0.0.
     */
    @JsonProperty("convertClassicHistogramsToNHCB")
    public Boolean getConvertClassicHistogramsToNHCB() {
        return convertClassicHistogramsToNHCB;
    }

    /**
     * Whether to convert all scraped classic histograms into a native histogram with custom buckets. It requires Prometheus &gt;= v3.0.0.
     */
    @JsonProperty("convertClassicHistogramsToNHCB")
    public void setConvertClassicHistogramsToNHCB(Boolean convertClassicHistogramsToNHCB) {
        this.convertClassicHistogramsToNHCB = convertClassicHistogramsToNHCB;
    }

    /**
     * DigitalOceanSDConfigs defines a list of DigitalOcean service discovery configurations.
     */
    @JsonProperty("digitalOceanSDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<DigitalOceanSDConfig> getDigitalOceanSDConfigs() {
        return digitalOceanSDConfigs;
    }

    /**
     * DigitalOceanSDConfigs defines a list of DigitalOcean service discovery configurations.
     */
    @JsonProperty("digitalOceanSDConfigs")
    public void setDigitalOceanSDConfigs(List<DigitalOceanSDConfig> digitalOceanSDConfigs) {
        this.digitalOceanSDConfigs = digitalOceanSDConfigs;
    }

    /**
     * DNSSDConfigs defines a list of DNS service discovery configurations.
     */
    @JsonProperty("dnsSDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<DNSSDConfig> getDnsSDConfigs() {
        return dnsSDConfigs;
    }

    /**
     * DNSSDConfigs defines a list of DNS service discovery configurations.
     */
    @JsonProperty("dnsSDConfigs")
    public void setDnsSDConfigs(List<DNSSDConfig> dnsSDConfigs) {
        this.dnsSDConfigs = dnsSDConfigs;
    }

    /**
     * DockerSDConfigs defines a list of Docker service discovery configurations.
     */
    @JsonProperty("dockerSDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<DockerSDConfig> getDockerSDConfigs() {
        return dockerSDConfigs;
    }

    /**
     * DockerSDConfigs defines a list of Docker service discovery configurations.
     */
    @JsonProperty("dockerSDConfigs")
    public void setDockerSDConfigs(List<DockerSDConfig> dockerSDConfigs) {
        this.dockerSDConfigs = dockerSDConfigs;
    }

    /**
     * DockerswarmSDConfigs defines a list of Dockerswarm service discovery configurations.
     */
    @JsonProperty("dockerSwarmSDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<DockerSwarmSDConfig> getDockerSwarmSDConfigs() {
        return dockerSwarmSDConfigs;
    }

    /**
     * DockerswarmSDConfigs defines a list of Dockerswarm service discovery configurations.
     */
    @JsonProperty("dockerSwarmSDConfigs")
    public void setDockerSwarmSDConfigs(List<DockerSwarmSDConfig> dockerSwarmSDConfigs) {
        this.dockerSwarmSDConfigs = dockerSwarmSDConfigs;
    }

    /**
     * EC2SDConfigs defines a list of EC2 service discovery configurations.
     */
    @JsonProperty("ec2SDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<EC2SDConfig> getEc2SDConfigs() {
        return ec2SDConfigs;
    }

    /**
     * EC2SDConfigs defines a list of EC2 service discovery configurations.
     */
    @JsonProperty("ec2SDConfigs")
    public void setEc2SDConfigs(List<EC2SDConfig> ec2SDConfigs) {
        this.ec2SDConfigs = ec2SDConfigs;
    }

    /**
     * When false, Prometheus will request uncompressed response from the scraped target.<br><p> <br><p> It requires Prometheus &gt;= v2.49.0.<br><p> <br><p> If unset, Prometheus uses true by default.
     */
    @JsonProperty("enableCompression")
    public Boolean getEnableCompression() {
        return enableCompression;
    }

    /**
     * When false, Prometheus will request uncompressed response from the scraped target.<br><p> <br><p> It requires Prometheus &gt;= v2.49.0.<br><p> <br><p> If unset, Prometheus uses true by default.
     */
    @JsonProperty("enableCompression")
    public void setEnableCompression(Boolean enableCompression) {
        this.enableCompression = enableCompression;
    }

    /**
     * Whether to enable HTTP2.
     */
    @JsonProperty("enableHTTP2")
    public Boolean getEnableHTTP2() {
        return enableHTTP2;
    }

    /**
     * Whether to enable HTTP2.
     */
    @JsonProperty("enableHTTP2")
    public void setEnableHTTP2(Boolean enableHTTP2) {
        this.enableHTTP2 = enableHTTP2;
    }

    /**
     * EurekaSDConfigs defines a list of Eureka service discovery configurations.
     */
    @JsonProperty("eurekaSDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<EurekaSDConfig> getEurekaSDConfigs() {
        return eurekaSDConfigs;
    }

    /**
     * EurekaSDConfigs defines a list of Eureka service discovery configurations.
     */
    @JsonProperty("eurekaSDConfigs")
    public void setEurekaSDConfigs(List<EurekaSDConfig> eurekaSDConfigs) {
        this.eurekaSDConfigs = eurekaSDConfigs;
    }

    /**
     * The protocol to use if a scrape returns blank, unparseable, or otherwise invalid Content-Type.<br><p> <br><p> It requires Prometheus &gt;= v3.0.0.
     */
    @JsonProperty("fallbackScrapeProtocol")
    public String getFallbackScrapeProtocol() {
        return fallbackScrapeProtocol;
    }

    /**
     * The protocol to use if a scrape returns blank, unparseable, or otherwise invalid Content-Type.<br><p> <br><p> It requires Prometheus &gt;= v3.0.0.
     */
    @JsonProperty("fallbackScrapeProtocol")
    public void setFallbackScrapeProtocol(String fallbackScrapeProtocol) {
        this.fallbackScrapeProtocol = fallbackScrapeProtocol;
    }

    /**
     * FileSDConfigs defines a list of file service discovery configurations.
     */
    @JsonProperty("fileSDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<FileSDConfig> getFileSDConfigs() {
        return fileSDConfigs;
    }

    /**
     * FileSDConfigs defines a list of file service discovery configurations.
     */
    @JsonProperty("fileSDConfigs")
    public void setFileSDConfigs(List<FileSDConfig> fileSDConfigs) {
        this.fileSDConfigs = fileSDConfigs;
    }

    /**
     * GCESDConfigs defines a list of GCE service discovery configurations.
     */
    @JsonProperty("gceSDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<GCESDConfig> getGceSDConfigs() {
        return gceSDConfigs;
    }

    /**
     * GCESDConfigs defines a list of GCE service discovery configurations.
     */
    @JsonProperty("gceSDConfigs")
    public void setGceSDConfigs(List<GCESDConfig> gceSDConfigs) {
        this.gceSDConfigs = gceSDConfigs;
    }

    /**
     * HetznerSDConfigs defines a list of Hetzner service discovery configurations.
     */
    @JsonProperty("hetznerSDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<HetznerSDConfig> getHetznerSDConfigs() {
        return hetznerSDConfigs;
    }

    /**
     * HetznerSDConfigs defines a list of Hetzner service discovery configurations.
     */
    @JsonProperty("hetznerSDConfigs")
    public void setHetznerSDConfigs(List<HetznerSDConfig> hetznerSDConfigs) {
        this.hetznerSDConfigs = hetznerSDConfigs;
    }

    /**
     * HonorLabels chooses the metric's labels on collisions with target labels.
     */
    @JsonProperty("honorLabels")
    public Boolean getHonorLabels() {
        return honorLabels;
    }

    /**
     * HonorLabels chooses the metric's labels on collisions with target labels.
     */
    @JsonProperty("honorLabels")
    public void setHonorLabels(Boolean honorLabels) {
        this.honorLabels = honorLabels;
    }

    /**
     * HonorTimestamps controls whether Prometheus respects the timestamps present in scraped data.
     */
    @JsonProperty("honorTimestamps")
    public Boolean getHonorTimestamps() {
        return honorTimestamps;
    }

    /**
     * HonorTimestamps controls whether Prometheus respects the timestamps present in scraped data.
     */
    @JsonProperty("honorTimestamps")
    public void setHonorTimestamps(Boolean honorTimestamps) {
        this.honorTimestamps = honorTimestamps;
    }

    /**
     * HTTPSDConfigs defines a list of HTTP service discovery configurations.
     */
    @JsonProperty("httpSDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<HTTPSDConfig> getHttpSDConfigs() {
        return httpSDConfigs;
    }

    /**
     * HTTPSDConfigs defines a list of HTTP service discovery configurations.
     */
    @JsonProperty("httpSDConfigs")
    public void setHttpSDConfigs(List<HTTPSDConfig> httpSDConfigs) {
        this.httpSDConfigs = httpSDConfigs;
    }

    /**
     * IonosSDConfigs defines a list of IONOS service discovery configurations.
     */
    @JsonProperty("ionosSDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<IonosSDConfig> getIonosSDConfigs() {
        return ionosSDConfigs;
    }

    /**
     * IonosSDConfigs defines a list of IONOS service discovery configurations.
     */
    @JsonProperty("ionosSDConfigs")
    public void setIonosSDConfigs(List<IonosSDConfig> ionosSDConfigs) {
        this.ionosSDConfigs = ionosSDConfigs;
    }

    /**
     * The value of the `job` label assigned to the scraped metrics by default.<br><p> <br><p> The `job_name` field in the rendered scrape configuration is always controlled by the operator to prevent duplicate job names, which Prometheus does not allow. Instead the `job` label is set by means of relabeling configs.
     */
    @JsonProperty("jobName")
    public String getJobName() {
        return jobName;
    }

    /**
     * The value of the `job` label assigned to the scraped metrics by default.<br><p> <br><p> The `job_name` field in the rendered scrape configuration is always controlled by the operator to prevent duplicate job names, which Prometheus does not allow. Instead the `job` label is set by means of relabeling configs.
     */
    @JsonProperty("jobName")
    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    /**
     * Per-scrape limit on the number of targets dropped by relabeling that will be kept in memory. 0 means no limit.<br><p> <br><p> It requires Prometheus &gt;= v2.47.0.
     */
    @JsonProperty("keepDroppedTargets")
    public Long getKeepDroppedTargets() {
        return keepDroppedTargets;
    }

    /**
     * Per-scrape limit on the number of targets dropped by relabeling that will be kept in memory. 0 means no limit.<br><p> <br><p> It requires Prometheus &gt;= v2.47.0.
     */
    @JsonProperty("keepDroppedTargets")
    public void setKeepDroppedTargets(Long keepDroppedTargets) {
        this.keepDroppedTargets = keepDroppedTargets;
    }

    /**
     * KubernetesSDConfigs defines a list of Kubernetes service discovery configurations.
     */
    @JsonProperty("kubernetesSDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<KubernetesSDConfig> getKubernetesSDConfigs() {
        return kubernetesSDConfigs;
    }

    /**
     * KubernetesSDConfigs defines a list of Kubernetes service discovery configurations.
     */
    @JsonProperty("kubernetesSDConfigs")
    public void setKubernetesSDConfigs(List<KubernetesSDConfig> kubernetesSDConfigs) {
        this.kubernetesSDConfigs = kubernetesSDConfigs;
    }

    /**
     * KumaSDConfigs defines a list of Kuma service discovery configurations.
     */
    @JsonProperty("kumaSDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<KumaSDConfig> getKumaSDConfigs() {
        return kumaSDConfigs;
    }

    /**
     * KumaSDConfigs defines a list of Kuma service discovery configurations.
     */
    @JsonProperty("kumaSDConfigs")
    public void setKumaSDConfigs(List<KumaSDConfig> kumaSDConfigs) {
        this.kumaSDConfigs = kumaSDConfigs;
    }

    /**
     * Per-scrape limit on number of labels that will be accepted for a sample. Only valid in Prometheus versions 2.27.0 and newer.
     */
    @JsonProperty("labelLimit")
    public Long getLabelLimit() {
        return labelLimit;
    }

    /**
     * Per-scrape limit on number of labels that will be accepted for a sample. Only valid in Prometheus versions 2.27.0 and newer.
     */
    @JsonProperty("labelLimit")
    public void setLabelLimit(Long labelLimit) {
        this.labelLimit = labelLimit;
    }

    /**
     * Per-scrape limit on length of labels name that will be accepted for a sample. Only valid in Prometheus versions 2.27.0 and newer.
     */
    @JsonProperty("labelNameLengthLimit")
    public Long getLabelNameLengthLimit() {
        return labelNameLengthLimit;
    }

    /**
     * Per-scrape limit on length of labels name that will be accepted for a sample. Only valid in Prometheus versions 2.27.0 and newer.
     */
    @JsonProperty("labelNameLengthLimit")
    public void setLabelNameLengthLimit(Long labelNameLengthLimit) {
        this.labelNameLengthLimit = labelNameLengthLimit;
    }

    /**
     * Per-scrape limit on length of labels value that will be accepted for a sample. Only valid in Prometheus versions 2.27.0 and newer.
     */
    @JsonProperty("labelValueLengthLimit")
    public Long getLabelValueLengthLimit() {
        return labelValueLengthLimit;
    }

    /**
     * Per-scrape limit on length of labels value that will be accepted for a sample. Only valid in Prometheus versions 2.27.0 and newer.
     */
    @JsonProperty("labelValueLengthLimit")
    public void setLabelValueLengthLimit(Long labelValueLengthLimit) {
        this.labelValueLengthLimit = labelValueLengthLimit;
    }

    /**
     * LightsailSDConfigs defines a list of Lightsail service discovery configurations.
     */
    @JsonProperty("lightSailSDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<LightSailSDConfig> getLightSailSDConfigs() {
        return lightSailSDConfigs;
    }

    /**
     * LightsailSDConfigs defines a list of Lightsail service discovery configurations.
     */
    @JsonProperty("lightSailSDConfigs")
    public void setLightSailSDConfigs(List<LightSailSDConfig> lightSailSDConfigs) {
        this.lightSailSDConfigs = lightSailSDConfigs;
    }

    /**
     * LinodeSDConfigs defines a list of Linode service discovery configurations.
     */
    @JsonProperty("linodeSDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<LinodeSDConfig> getLinodeSDConfigs() {
        return linodeSDConfigs;
    }

    /**
     * LinodeSDConfigs defines a list of Linode service discovery configurations.
     */
    @JsonProperty("linodeSDConfigs")
    public void setLinodeSDConfigs(List<LinodeSDConfig> linodeSDConfigs) {
        this.linodeSDConfigs = linodeSDConfigs;
    }

    /**
     * MetricRelabelConfigs to apply to samples before ingestion.
     */
    @JsonProperty("metricRelabelings")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<RelabelConfig> getMetricRelabelings() {
        return metricRelabelings;
    }

    /**
     * MetricRelabelConfigs to apply to samples before ingestion.
     */
    @JsonProperty("metricRelabelings")
    public void setMetricRelabelings(List<RelabelConfig> metricRelabelings) {
        this.metricRelabelings = metricRelabelings;
    }

    /**
     * MetricsPath HTTP path to scrape for metrics. If empty, Prometheus uses the default value (e.g. /metrics).
     */
    @JsonProperty("metricsPath")
    public String getMetricsPath() {
        return metricsPath;
    }

    /**
     * MetricsPath HTTP path to scrape for metrics. If empty, Prometheus uses the default value (e.g. /metrics).
     */
    @JsonProperty("metricsPath")
    public void setMetricsPath(String metricsPath) {
        this.metricsPath = metricsPath;
    }

    /**
     * Metric name escaping mode to request through content negotiation.<br><p> <br><p> It requires Prometheus &gt;= v3.4.0.
     */
    @JsonProperty("nameEscapingScheme")
    public String getNameEscapingScheme() {
        return nameEscapingScheme;
    }

    /**
     * Metric name escaping mode to request through content negotiation.<br><p> <br><p> It requires Prometheus &gt;= v3.4.0.
     */
    @JsonProperty("nameEscapingScheme")
    public void setNameEscapingScheme(String nameEscapingScheme) {
        this.nameEscapingScheme = nameEscapingScheme;
    }

    /**
     * Specifies the validation scheme for metric and label names.<br><p> <br><p> It requires Prometheus &gt;= v3.0.0.
     */
    @JsonProperty("nameValidationScheme")
    public String getNameValidationScheme() {
        return nameValidationScheme;
    }

    /**
     * Specifies the validation scheme for metric and label names.<br><p> <br><p> It requires Prometheus &gt;= v3.0.0.
     */
    @JsonProperty("nameValidationScheme")
    public void setNameValidationScheme(String nameValidationScheme) {
        this.nameValidationScheme = nameValidationScheme;
    }

    /**
     * If there are more than this many buckets in a native histogram, buckets will be merged to stay within the limit. It requires Prometheus &gt;= v2.45.0.
     */
    @JsonProperty("nativeHistogramBucketLimit")
    public Long getNativeHistogramBucketLimit() {
        return nativeHistogramBucketLimit;
    }

    /**
     * If there are more than this many buckets in a native histogram, buckets will be merged to stay within the limit. It requires Prometheus &gt;= v2.45.0.
     */
    @JsonProperty("nativeHistogramBucketLimit")
    public void setNativeHistogramBucketLimit(Long nativeHistogramBucketLimit) {
        this.nativeHistogramBucketLimit = nativeHistogramBucketLimit;
    }

    /**
     * ScrapeConfigSpec is a specification of the desired configuration for a scrape configuration.
     */
    @JsonProperty("nativeHistogramMinBucketFactor")
    public Quantity getNativeHistogramMinBucketFactor() {
        return nativeHistogramMinBucketFactor;
    }

    /**
     * ScrapeConfigSpec is a specification of the desired configuration for a scrape configuration.
     */
    @JsonProperty("nativeHistogramMinBucketFactor")
    public void setNativeHistogramMinBucketFactor(Quantity nativeHistogramMinBucketFactor) {
        this.nativeHistogramMinBucketFactor = nativeHistogramMinBucketFactor;
    }

    /**
     * `noProxy` is a comma-separated string that can contain IPs, CIDR notation, domain names that should be excluded from proxying. IP and domain names can contain port numbers.<br><p> <br><p> It requires Prometheus &gt;= v2.43.0, Alertmanager &gt;= v0.25.0 or Thanos &gt;= v0.32.0.
     */
    @JsonProperty("noProxy")
    public String getNoProxy() {
        return noProxy;
    }

    /**
     * `noProxy` is a comma-separated string that can contain IPs, CIDR notation, domain names that should be excluded from proxying. IP and domain names can contain port numbers.<br><p> <br><p> It requires Prometheus &gt;= v2.43.0, Alertmanager &gt;= v0.25.0 or Thanos &gt;= v0.32.0.
     */
    @JsonProperty("noProxy")
    public void setNoProxy(String noProxy) {
        this.noProxy = noProxy;
    }

    /**
     * NomadSDConfigs defines a list of Nomad service discovery configurations.
     */
    @JsonProperty("nomadSDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<NomadSDConfig> getNomadSDConfigs() {
        return nomadSDConfigs;
    }

    /**
     * NomadSDConfigs defines a list of Nomad service discovery configurations.
     */
    @JsonProperty("nomadSDConfigs")
    public void setNomadSDConfigs(List<NomadSDConfig> nomadSDConfigs) {
        this.nomadSDConfigs = nomadSDConfigs;
    }

    /**
     * ScrapeConfigSpec is a specification of the desired configuration for a scrape configuration.
     */
    @JsonProperty("oauth2")
    public OAuth2 getOauth2() {
        return oauth2;
    }

    /**
     * ScrapeConfigSpec is a specification of the desired configuration for a scrape configuration.
     */
    @JsonProperty("oauth2")
    public void setOauth2(OAuth2 oauth2) {
        this.oauth2 = oauth2;
    }

    /**
     * OpenStackSDConfigs defines a list of OpenStack service discovery configurations.
     */
    @JsonProperty("openstackSDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<OpenStackSDConfig> getOpenstackSDConfigs() {
        return openstackSDConfigs;
    }

    /**
     * OpenStackSDConfigs defines a list of OpenStack service discovery configurations.
     */
    @JsonProperty("openstackSDConfigs")
    public void setOpenstackSDConfigs(List<OpenStackSDConfig> openstackSDConfigs) {
        this.openstackSDConfigs = openstackSDConfigs;
    }

    /**
     * OVHCloudSDConfigs defines a list of OVHcloud service discovery configurations.
     */
    @JsonProperty("ovhcloudSDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<OVHCloudSDConfig> getOvhcloudSDConfigs() {
        return ovhcloudSDConfigs;
    }

    /**
     * OVHCloudSDConfigs defines a list of OVHcloud service discovery configurations.
     */
    @JsonProperty("ovhcloudSDConfigs")
    public void setOvhcloudSDConfigs(List<OVHCloudSDConfig> ovhcloudSDConfigs) {
        this.ovhcloudSDConfigs = ovhcloudSDConfigs;
    }

    /**
     * Optional HTTP URL parameters
     */
    @JsonProperty("params")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, List<String>> getParams() {
        return params;
    }

    /**
     * Optional HTTP URL parameters
     */
    @JsonProperty("params")
    public void setParams(Map<String, List<String>> params) {
        this.params = params;
    }

    /**
     * ProxyConnectHeader optionally specifies headers to send to proxies during CONNECT requests.<br><p> <br><p> It requires Prometheus &gt;= v2.43.0, Alertmanager &gt;= v0.25.0 or Thanos &gt;= v0.32.0.
     */
    @JsonProperty("proxyConnectHeader")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, List<SecretKeySelector>> getProxyConnectHeader() {
        return proxyConnectHeader;
    }

    /**
     * ProxyConnectHeader optionally specifies headers to send to proxies during CONNECT requests.<br><p> <br><p> It requires Prometheus &gt;= v2.43.0, Alertmanager &gt;= v0.25.0 or Thanos &gt;= v0.32.0.
     */
    @JsonProperty("proxyConnectHeader")
    public void setProxyConnectHeader(Map<String, List<SecretKeySelector>> proxyConnectHeader) {
        this.proxyConnectHeader = proxyConnectHeader;
    }

    /**
     * Whether to use the proxy configuration defined by environment variables (HTTP_PROXY, HTTPS_PROXY, and NO_PROXY).<br><p> <br><p> It requires Prometheus &gt;= v2.43.0, Alertmanager &gt;= v0.25.0 or Thanos &gt;= v0.32.0.
     */
    @JsonProperty("proxyFromEnvironment")
    public Boolean getProxyFromEnvironment() {
        return proxyFromEnvironment;
    }

    /**
     * Whether to use the proxy configuration defined by environment variables (HTTP_PROXY, HTTPS_PROXY, and NO_PROXY).<br><p> <br><p> It requires Prometheus &gt;= v2.43.0, Alertmanager &gt;= v0.25.0 or Thanos &gt;= v0.32.0.
     */
    @JsonProperty("proxyFromEnvironment")
    public void setProxyFromEnvironment(Boolean proxyFromEnvironment) {
        this.proxyFromEnvironment = proxyFromEnvironment;
    }

    /**
     * `proxyURL` defines the HTTP proxy server to use.
     */
    @JsonProperty("proxyUrl")
    public String getProxyUrl() {
        return proxyUrl;
    }

    /**
     * `proxyURL` defines the HTTP proxy server to use.
     */
    @JsonProperty("proxyUrl")
    public void setProxyUrl(String proxyUrl) {
        this.proxyUrl = proxyUrl;
    }

    /**
     * PuppetDBSDConfigs defines a list of PuppetDB service discovery configurations.
     */
    @JsonProperty("puppetDBSDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PuppetDBSDConfig> getPuppetDBSDConfigs() {
        return puppetDBSDConfigs;
    }

    /**
     * PuppetDBSDConfigs defines a list of PuppetDB service discovery configurations.
     */
    @JsonProperty("puppetDBSDConfigs")
    public void setPuppetDBSDConfigs(List<PuppetDBSDConfig> puppetDBSDConfigs) {
        this.puppetDBSDConfigs = puppetDBSDConfigs;
    }

    /**
     * RelabelConfigs defines how to rewrite the target's labels before scraping. Prometheus Operator automatically adds relabelings for a few standard Kubernetes fields. The original scrape job's name is available via the `__tmp_prometheus_job_name` label. More info: https://prometheus.io/docs/prometheus/latest/configuration/configuration/#relabel_config
     */
    @JsonProperty("relabelings")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<RelabelConfig> getRelabelings() {
        return relabelings;
    }

    /**
     * RelabelConfigs defines how to rewrite the target's labels before scraping. Prometheus Operator automatically adds relabelings for a few standard Kubernetes fields. The original scrape job's name is available via the `__tmp_prometheus_job_name` label. More info: https://prometheus.io/docs/prometheus/latest/configuration/configuration/#relabel_config
     */
    @JsonProperty("relabelings")
    public void setRelabelings(List<RelabelConfig> relabelings) {
        this.relabelings = relabelings;
    }

    /**
     * SampleLimit defines per-scrape limit on number of scraped samples that will be accepted.
     */
    @JsonProperty("sampleLimit")
    public Long getSampleLimit() {
        return sampleLimit;
    }

    /**
     * SampleLimit defines per-scrape limit on number of scraped samples that will be accepted.
     */
    @JsonProperty("sampleLimit")
    public void setSampleLimit(Long sampleLimit) {
        this.sampleLimit = sampleLimit;
    }

    /**
     * ScalewaySDConfigs defines a list of Scaleway instances and baremetal service discovery configurations.
     */
    @JsonProperty("scalewaySDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ScalewaySDConfig> getScalewaySDConfigs() {
        return scalewaySDConfigs;
    }

    /**
     * ScalewaySDConfigs defines a list of Scaleway instances and baremetal service discovery configurations.
     */
    @JsonProperty("scalewaySDConfigs")
    public void setScalewaySDConfigs(List<ScalewaySDConfig> scalewaySDConfigs) {
        this.scalewaySDConfigs = scalewaySDConfigs;
    }

    /**
     * Configures the protocol scheme used for requests. If empty, Prometheus uses HTTP by default.
     */
    @JsonProperty("scheme")
    public String getScheme() {
        return scheme;
    }

    /**
     * Configures the protocol scheme used for requests. If empty, Prometheus uses HTTP by default.
     */
    @JsonProperty("scheme")
    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    /**
     * The scrape class to apply.
     */
    @JsonProperty("scrapeClass")
    public String getScrapeClass() {
        return scrapeClass;
    }

    /**
     * The scrape class to apply.
     */
    @JsonProperty("scrapeClass")
    public void setScrapeClass(String scrapeClass) {
        this.scrapeClass = scrapeClass;
    }

    /**
     * Whether to scrape a classic histogram that is also exposed as a native histogram. It requires Prometheus &gt;= v2.45.0.
     */
    @JsonProperty("scrapeClassicHistograms")
    public Boolean getScrapeClassicHistograms() {
        return scrapeClassicHistograms;
    }

    /**
     * Whether to scrape a classic histogram that is also exposed as a native histogram. It requires Prometheus &gt;= v2.45.0.
     */
    @JsonProperty("scrapeClassicHistograms")
    public void setScrapeClassicHistograms(Boolean scrapeClassicHistograms) {
        this.scrapeClassicHistograms = scrapeClassicHistograms;
    }

    /**
     * ScrapeInterval is the interval between consecutive scrapes.
     */
    @JsonProperty("scrapeInterval")
    public String getScrapeInterval() {
        return scrapeInterval;
    }

    /**
     * ScrapeInterval is the interval between consecutive scrapes.
     */
    @JsonProperty("scrapeInterval")
    public void setScrapeInterval(String scrapeInterval) {
        this.scrapeInterval = scrapeInterval;
    }

    /**
     * The protocols to negotiate during a scrape. It tells clients the protocols supported by Prometheus in order of preference (from most to least preferred).<br><p> <br><p> If unset, Prometheus uses its default value.<br><p> <br><p> It requires Prometheus &gt;= v2.49.0.
     */
    @JsonProperty("scrapeProtocols")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getScrapeProtocols() {
        return scrapeProtocols;
    }

    /**
     * The protocols to negotiate during a scrape. It tells clients the protocols supported by Prometheus in order of preference (from most to least preferred).<br><p> <br><p> If unset, Prometheus uses its default value.<br><p> <br><p> It requires Prometheus &gt;= v2.49.0.
     */
    @JsonProperty("scrapeProtocols")
    public void setScrapeProtocols(List<String> scrapeProtocols) {
        this.scrapeProtocols = scrapeProtocols;
    }

    /**
     * ScrapeTimeout is the number of seconds to wait until a scrape request times out. The value cannot be greater than the scrape interval otherwise the operator will reject the resource.
     */
    @JsonProperty("scrapeTimeout")
    public String getScrapeTimeout() {
        return scrapeTimeout;
    }

    /**
     * ScrapeTimeout is the number of seconds to wait until a scrape request times out. The value cannot be greater than the scrape interval otherwise the operator will reject the resource.
     */
    @JsonProperty("scrapeTimeout")
    public void setScrapeTimeout(String scrapeTimeout) {
        this.scrapeTimeout = scrapeTimeout;
    }

    /**
     * StaticConfigs defines a list of static targets with a common label set.
     */
    @JsonProperty("staticConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<StaticConfig> getStaticConfigs() {
        return staticConfigs;
    }

    /**
     * StaticConfigs defines a list of static targets with a common label set.
     */
    @JsonProperty("staticConfigs")
    public void setStaticConfigs(List<StaticConfig> staticConfigs) {
        this.staticConfigs = staticConfigs;
    }

    /**
     * TargetLimit defines a limit on the number of scraped targets that will be accepted.
     */
    @JsonProperty("targetLimit")
    public Long getTargetLimit() {
        return targetLimit;
    }

    /**
     * TargetLimit defines a limit on the number of scraped targets that will be accepted.
     */
    @JsonProperty("targetLimit")
    public void setTargetLimit(Long targetLimit) {
        this.targetLimit = targetLimit;
    }

    /**
     * ScrapeConfigSpec is a specification of the desired configuration for a scrape configuration.
     */
    @JsonProperty("tlsConfig")
    public SafeTLSConfig getTlsConfig() {
        return tlsConfig;
    }

    /**
     * ScrapeConfigSpec is a specification of the desired configuration for a scrape configuration.
     */
    @JsonProperty("tlsConfig")
    public void setTlsConfig(SafeTLSConfig tlsConfig) {
        this.tlsConfig = tlsConfig;
    }

    /**
     * TrackTimestampsStaleness whether Prometheus tracks staleness of the metrics that have an explicit timestamp present in scraped data. Has no effect if `honorTimestamps` is false. It requires Prometheus &gt;= v2.48.0.
     */
    @JsonProperty("trackTimestampsStaleness")
    public Boolean getTrackTimestampsStaleness() {
        return trackTimestampsStaleness;
    }

    /**
     * TrackTimestampsStaleness whether Prometheus tracks staleness of the metrics that have an explicit timestamp present in scraped data. Has no effect if `honorTimestamps` is false. It requires Prometheus &gt;= v2.48.0.
     */
    @JsonProperty("trackTimestampsStaleness")
    public void setTrackTimestampsStaleness(Boolean trackTimestampsStaleness) {
        this.trackTimestampsStaleness = trackTimestampsStaleness;
    }

    @JsonIgnore
    public ScrapeConfigSpecBuilder edit() {
        return new ScrapeConfigSpecBuilder(this);
    }

    @JsonIgnore
    public ScrapeConfigSpecBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
    @JsonIgnore
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

}
