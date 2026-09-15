
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

/**
 * ScrapeConfigSpec is a specification of the desired configuration for a scrape configuration.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "authorization",
    "azureSDConfigs",
    "basicAuth",
    "bodySizeLimit",
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
    "scrapeNativeHistograms",
    "scrapeProtocols",
    "scrapeTimeout",
    "staticConfigs",
    "targetLimit",
    "tlsConfig",
    "trackTimestampsStaleness"
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
    @JsonProperty("bodySizeLimit")
    private String bodySizeLimit;
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
    @JsonProperty("scrapeNativeHistograms")
    private Boolean scrapeNativeHistograms;
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

    public ScrapeConfigSpec(SafeAuthorization authorization, List<AzureSDConfig> azureSDConfigs, BasicAuth basicAuth, String bodySizeLimit, List<ConsulSDConfig> consulSDConfigs, Boolean convertClassicHistogramsToNHCB, List<DigitalOceanSDConfig> digitalOceanSDConfigs, List<DNSSDConfig> dnsSDConfigs, List<DockerSDConfig> dockerSDConfigs, List<DockerSwarmSDConfig> dockerSwarmSDConfigs, List<EC2SDConfig> ec2SDConfigs, Boolean enableCompression, Boolean enableHTTP2, List<EurekaSDConfig> eurekaSDConfigs, String fallbackScrapeProtocol, List<FileSDConfig> fileSDConfigs, List<GCESDConfig> gceSDConfigs, List<HetznerSDConfig> hetznerSDConfigs, Boolean honorLabels, Boolean honorTimestamps, List<HTTPSDConfig> httpSDConfigs, List<IonosSDConfig> ionosSDConfigs, String jobName, Long keepDroppedTargets, List<KubernetesSDConfig> kubernetesSDConfigs, List<KumaSDConfig> kumaSDConfigs, Long labelLimit, Long labelNameLengthLimit, Long labelValueLengthLimit, List<LightSailSDConfig> lightSailSDConfigs, List<LinodeSDConfig> linodeSDConfigs, List<RelabelConfig> metricRelabelings, String metricsPath, String nameEscapingScheme, String nameValidationScheme, Long nativeHistogramBucketLimit, Quantity nativeHistogramMinBucketFactor, String noProxy, List<NomadSDConfig> nomadSDConfigs, OAuth2 oauth2, List<OpenStackSDConfig> openstackSDConfigs, List<OVHCloudSDConfig> ovhcloudSDConfigs, Map<String, List<String>> params, Map<String, List<SecretKeySelector>> proxyConnectHeader, Boolean proxyFromEnvironment, String proxyUrl, List<PuppetDBSDConfig> puppetDBSDConfigs, List<RelabelConfig> relabelings, Long sampleLimit, List<ScalewaySDConfig> scalewaySDConfigs, String scheme, String scrapeClass, Boolean scrapeClassicHistograms, String scrapeInterval, Boolean scrapeNativeHistograms, List<String> scrapeProtocols, String scrapeTimeout, List<StaticConfig> staticConfigs, Long targetLimit, SafeTLSConfig tlsConfig, Boolean trackTimestampsStaleness) {
        super();
        this.authorization = authorization;
        this.azureSDConfigs = azureSDConfigs;
        this.basicAuth = basicAuth;
        this.bodySizeLimit = bodySizeLimit;
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
        this.scrapeNativeHistograms = scrapeNativeHistograms;
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
     * azureSDConfigs defines a list of Azure service discovery configurations.
     */
    @JsonProperty("azureSDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<AzureSDConfig> getAzureSDConfigs() {
        return azureSDConfigs;
    }

    /**
     * azureSDConfigs defines a list of Azure service discovery configurations.
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
     * bodySizeLimit defines a per-scrape limit on the size of the uncompressed response body that will be accepted by Prometheus. Targets responding with a body larger than this many bytes will cause the scrape to fail.<br><p> <br><p> It requires Prometheus &gt;= v2.28.0.
     */
    @JsonProperty("bodySizeLimit")
    public String getBodySizeLimit() {
        return bodySizeLimit;
    }

    /**
     * bodySizeLimit defines a per-scrape limit on the size of the uncompressed response body that will be accepted by Prometheus. Targets responding with a body larger than this many bytes will cause the scrape to fail.<br><p> <br><p> It requires Prometheus &gt;= v2.28.0.
     */
    @JsonProperty("bodySizeLimit")
    public void setBodySizeLimit(String bodySizeLimit) {
        this.bodySizeLimit = bodySizeLimit;
    }

    /**
     * consulSDConfigs defines a list of Consul service discovery configurations.
     */
    @JsonProperty("consulSDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ConsulSDConfig> getConsulSDConfigs() {
        return consulSDConfigs;
    }

    /**
     * consulSDConfigs defines a list of Consul service discovery configurations.
     */
    @JsonProperty("consulSDConfigs")
    public void setConsulSDConfigs(List<ConsulSDConfig> consulSDConfigs) {
        this.consulSDConfigs = consulSDConfigs;
    }

    /**
     * convertClassicHistogramsToNHCB defines whether to convert all scraped classic histograms into a native histogram with custom buckets. It requires Prometheus &gt;= v3.0.0.
     */
    @JsonProperty("convertClassicHistogramsToNHCB")
    public Boolean getConvertClassicHistogramsToNHCB() {
        return convertClassicHistogramsToNHCB;
    }

    /**
     * convertClassicHistogramsToNHCB defines whether to convert all scraped classic histograms into a native histogram with custom buckets. It requires Prometheus &gt;= v3.0.0.
     */
    @JsonProperty("convertClassicHistogramsToNHCB")
    public void setConvertClassicHistogramsToNHCB(Boolean convertClassicHistogramsToNHCB) {
        this.convertClassicHistogramsToNHCB = convertClassicHistogramsToNHCB;
    }

    /**
     * digitalOceanSDConfigs defines a list of DigitalOcean service discovery configurations.
     */
    @JsonProperty("digitalOceanSDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<DigitalOceanSDConfig> getDigitalOceanSDConfigs() {
        return digitalOceanSDConfigs;
    }

    /**
     * digitalOceanSDConfigs defines a list of DigitalOcean service discovery configurations.
     */
    @JsonProperty("digitalOceanSDConfigs")
    public void setDigitalOceanSDConfigs(List<DigitalOceanSDConfig> digitalOceanSDConfigs) {
        this.digitalOceanSDConfigs = digitalOceanSDConfigs;
    }

    /**
     * dnsSDConfigs defines a list of DNS service discovery configurations.
     */
    @JsonProperty("dnsSDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<DNSSDConfig> getDnsSDConfigs() {
        return dnsSDConfigs;
    }

    /**
     * dnsSDConfigs defines a list of DNS service discovery configurations.
     */
    @JsonProperty("dnsSDConfigs")
    public void setDnsSDConfigs(List<DNSSDConfig> dnsSDConfigs) {
        this.dnsSDConfigs = dnsSDConfigs;
    }

    /**
     * dockerSDConfigs defines a list of Docker service discovery configurations.
     */
    @JsonProperty("dockerSDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<DockerSDConfig> getDockerSDConfigs() {
        return dockerSDConfigs;
    }

    /**
     * dockerSDConfigs defines a list of Docker service discovery configurations.
     */
    @JsonProperty("dockerSDConfigs")
    public void setDockerSDConfigs(List<DockerSDConfig> dockerSDConfigs) {
        this.dockerSDConfigs = dockerSDConfigs;
    }

    /**
     * dockerSwarmSDConfigs defines a list of Dockerswarm service discovery configurations.
     */
    @JsonProperty("dockerSwarmSDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<DockerSwarmSDConfig> getDockerSwarmSDConfigs() {
        return dockerSwarmSDConfigs;
    }

    /**
     * dockerSwarmSDConfigs defines a list of Dockerswarm service discovery configurations.
     */
    @JsonProperty("dockerSwarmSDConfigs")
    public void setDockerSwarmSDConfigs(List<DockerSwarmSDConfig> dockerSwarmSDConfigs) {
        this.dockerSwarmSDConfigs = dockerSwarmSDConfigs;
    }

    /**
     * ec2SDConfigs defines a list of EC2 service discovery configurations.
     */
    @JsonProperty("ec2SDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<EC2SDConfig> getEc2SDConfigs() {
        return ec2SDConfigs;
    }

    /**
     * ec2SDConfigs defines a list of EC2 service discovery configurations.
     */
    @JsonProperty("ec2SDConfigs")
    public void setEc2SDConfigs(List<EC2SDConfig> ec2SDConfigs) {
        this.ec2SDConfigs = ec2SDConfigs;
    }

    /**
     * enableCompression when false, Prometheus will request uncompressed response from the scraped target.<br><p> <br><p> It requires Prometheus &gt;= v2.49.0.<br><p> <br><p> If unset, Prometheus uses true by default.
     */
    @JsonProperty("enableCompression")
    public Boolean getEnableCompression() {
        return enableCompression;
    }

    /**
     * enableCompression when false, Prometheus will request uncompressed response from the scraped target.<br><p> <br><p> It requires Prometheus &gt;= v2.49.0.<br><p> <br><p> If unset, Prometheus uses true by default.
     */
    @JsonProperty("enableCompression")
    public void setEnableCompression(Boolean enableCompression) {
        this.enableCompression = enableCompression;
    }

    /**
     * enableHTTP2 defines whether to enable HTTP2.
     */
    @JsonProperty("enableHTTP2")
    public Boolean getEnableHTTP2() {
        return enableHTTP2;
    }

    /**
     * enableHTTP2 defines whether to enable HTTP2.
     */
    @JsonProperty("enableHTTP2")
    public void setEnableHTTP2(Boolean enableHTTP2) {
        this.enableHTTP2 = enableHTTP2;
    }

    /**
     * eurekaSDConfigs defines a list of Eureka service discovery configurations.
     */
    @JsonProperty("eurekaSDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<EurekaSDConfig> getEurekaSDConfigs() {
        return eurekaSDConfigs;
    }

    /**
     * eurekaSDConfigs defines a list of Eureka service discovery configurations.
     */
    @JsonProperty("eurekaSDConfigs")
    public void setEurekaSDConfigs(List<EurekaSDConfig> eurekaSDConfigs) {
        this.eurekaSDConfigs = eurekaSDConfigs;
    }

    /**
     * fallbackScrapeProtocol defines the protocol to use if a scrape returns blank, unparseable, or otherwise invalid Content-Type.<br><p> <br><p> It requires Prometheus &gt;= v3.0.0.
     */
    @JsonProperty("fallbackScrapeProtocol")
    public String getFallbackScrapeProtocol() {
        return fallbackScrapeProtocol;
    }

    /**
     * fallbackScrapeProtocol defines the protocol to use if a scrape returns blank, unparseable, or otherwise invalid Content-Type.<br><p> <br><p> It requires Prometheus &gt;= v3.0.0.
     */
    @JsonProperty("fallbackScrapeProtocol")
    public void setFallbackScrapeProtocol(String fallbackScrapeProtocol) {
        this.fallbackScrapeProtocol = fallbackScrapeProtocol;
    }

    /**
     * fileSDConfigs defines a list of file service discovery configurations.
     */
    @JsonProperty("fileSDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<FileSDConfig> getFileSDConfigs() {
        return fileSDConfigs;
    }

    /**
     * fileSDConfigs defines a list of file service discovery configurations.
     */
    @JsonProperty("fileSDConfigs")
    public void setFileSDConfigs(List<FileSDConfig> fileSDConfigs) {
        this.fileSDConfigs = fileSDConfigs;
    }

    /**
     * gceSDConfigs defines a list of GCE service discovery configurations.
     */
    @JsonProperty("gceSDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<GCESDConfig> getGceSDConfigs() {
        return gceSDConfigs;
    }

    /**
     * gceSDConfigs defines a list of GCE service discovery configurations.
     */
    @JsonProperty("gceSDConfigs")
    public void setGceSDConfigs(List<GCESDConfig> gceSDConfigs) {
        this.gceSDConfigs = gceSDConfigs;
    }

    /**
     * hetznerSDConfigs defines a list of Hetzner service discovery configurations.
     */
    @JsonProperty("hetznerSDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<HetznerSDConfig> getHetznerSDConfigs() {
        return hetznerSDConfigs;
    }

    /**
     * hetznerSDConfigs defines a list of Hetzner service discovery configurations.
     */
    @JsonProperty("hetznerSDConfigs")
    public void setHetznerSDConfigs(List<HetznerSDConfig> hetznerSDConfigs) {
        this.hetznerSDConfigs = hetznerSDConfigs;
    }

    /**
     * honorLabels defines when true the metric's labels when they collide with the target's labels.
     */
    @JsonProperty("honorLabels")
    public Boolean getHonorLabels() {
        return honorLabels;
    }

    /**
     * honorLabels defines when true the metric's labels when they collide with the target's labels.
     */
    @JsonProperty("honorLabels")
    public void setHonorLabels(Boolean honorLabels) {
        this.honorLabels = honorLabels;
    }

    /**
     * honorTimestamps defines whether Prometheus preserves the timestamps when exposed by the target.
     */
    @JsonProperty("honorTimestamps")
    public Boolean getHonorTimestamps() {
        return honorTimestamps;
    }

    /**
     * honorTimestamps defines whether Prometheus preserves the timestamps when exposed by the target.
     */
    @JsonProperty("honorTimestamps")
    public void setHonorTimestamps(Boolean honorTimestamps) {
        this.honorTimestamps = honorTimestamps;
    }

    /**
     * httpSDConfigs defines a list of HTTP service discovery configurations.
     */
    @JsonProperty("httpSDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<HTTPSDConfig> getHttpSDConfigs() {
        return httpSDConfigs;
    }

    /**
     * httpSDConfigs defines a list of HTTP service discovery configurations.
     */
    @JsonProperty("httpSDConfigs")
    public void setHttpSDConfigs(List<HTTPSDConfig> httpSDConfigs) {
        this.httpSDConfigs = httpSDConfigs;
    }

    /**
     * ionosSDConfigs defines a list of IONOS service discovery configurations.
     */
    @JsonProperty("ionosSDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<IonosSDConfig> getIonosSDConfigs() {
        return ionosSDConfigs;
    }

    /**
     * ionosSDConfigs defines a list of IONOS service discovery configurations.
     */
    @JsonProperty("ionosSDConfigs")
    public void setIonosSDConfigs(List<IonosSDConfig> ionosSDConfigs) {
        this.ionosSDConfigs = ionosSDConfigs;
    }

    /**
     * jobName defines the value of the `job` label assigned to the scraped metrics by default.<br><p> <br><p> The `job_name` field in the rendered scrape configuration is always controlled by the operator to prevent duplicate job names, which Prometheus does not allow. Instead the `job` label is set by means of relabeling configs.
     */
    @JsonProperty("jobName")
    public String getJobName() {
        return jobName;
    }

    /**
     * jobName defines the value of the `job` label assigned to the scraped metrics by default.<br><p> <br><p> The `job_name` field in the rendered scrape configuration is always controlled by the operator to prevent duplicate job names, which Prometheus does not allow. Instead the `job` label is set by means of relabeling configs.
     */
    @JsonProperty("jobName")
    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    /**
     * keepDroppedTargets defines the per-scrape limit on the number of targets dropped by relabeling that will be kept in memory. 0 means no limit.<br><p> <br><p> It requires Prometheus &gt;= v2.47.0.
     */
    @JsonProperty("keepDroppedTargets")
    public Long getKeepDroppedTargets() {
        return keepDroppedTargets;
    }

    /**
     * keepDroppedTargets defines the per-scrape limit on the number of targets dropped by relabeling that will be kept in memory. 0 means no limit.<br><p> <br><p> It requires Prometheus &gt;= v2.47.0.
     */
    @JsonProperty("keepDroppedTargets")
    public void setKeepDroppedTargets(Long keepDroppedTargets) {
        this.keepDroppedTargets = keepDroppedTargets;
    }

    /**
     * kubernetesSDConfigs defines a list of Kubernetes service discovery configurations.
     */
    @JsonProperty("kubernetesSDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<KubernetesSDConfig> getKubernetesSDConfigs() {
        return kubernetesSDConfigs;
    }

    /**
     * kubernetesSDConfigs defines a list of Kubernetes service discovery configurations.
     */
    @JsonProperty("kubernetesSDConfigs")
    public void setKubernetesSDConfigs(List<KubernetesSDConfig> kubernetesSDConfigs) {
        this.kubernetesSDConfigs = kubernetesSDConfigs;
    }

    /**
     * kumaSDConfigs defines a list of Kuma service discovery configurations.
     */
    @JsonProperty("kumaSDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<KumaSDConfig> getKumaSDConfigs() {
        return kumaSDConfigs;
    }

    /**
     * kumaSDConfigs defines a list of Kuma service discovery configurations.
     */
    @JsonProperty("kumaSDConfigs")
    public void setKumaSDConfigs(List<KumaSDConfig> kumaSDConfigs) {
        this.kumaSDConfigs = kumaSDConfigs;
    }

    /**
     * labelLimit defines the per-scrape limit on number of labels that will be accepted for a sample. Only valid in Prometheus versions 2.27.0 and newer.
     */
    @JsonProperty("labelLimit")
    public Long getLabelLimit() {
        return labelLimit;
    }

    /**
     * labelLimit defines the per-scrape limit on number of labels that will be accepted for a sample. Only valid in Prometheus versions 2.27.0 and newer.
     */
    @JsonProperty("labelLimit")
    public void setLabelLimit(Long labelLimit) {
        this.labelLimit = labelLimit;
    }

    /**
     * labelNameLengthLimit defines the per-scrape limit on length of labels name that will be accepted for a sample. Only valid in Prometheus versions 2.27.0 and newer.
     */
    @JsonProperty("labelNameLengthLimit")
    public Long getLabelNameLengthLimit() {
        return labelNameLengthLimit;
    }

    /**
     * labelNameLengthLimit defines the per-scrape limit on length of labels name that will be accepted for a sample. Only valid in Prometheus versions 2.27.0 and newer.
     */
    @JsonProperty("labelNameLengthLimit")
    public void setLabelNameLengthLimit(Long labelNameLengthLimit) {
        this.labelNameLengthLimit = labelNameLengthLimit;
    }

    /**
     * labelValueLengthLimit defines the per-scrape limit on length of labels value that will be accepted for a sample. Only valid in Prometheus versions 2.27.0 and newer.
     */
    @JsonProperty("labelValueLengthLimit")
    public Long getLabelValueLengthLimit() {
        return labelValueLengthLimit;
    }

    /**
     * labelValueLengthLimit defines the per-scrape limit on length of labels value that will be accepted for a sample. Only valid in Prometheus versions 2.27.0 and newer.
     */
    @JsonProperty("labelValueLengthLimit")
    public void setLabelValueLengthLimit(Long labelValueLengthLimit) {
        this.labelValueLengthLimit = labelValueLengthLimit;
    }

    /**
     * lightSailSDConfigs defines a list of Lightsail service discovery configurations.
     */
    @JsonProperty("lightSailSDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<LightSailSDConfig> getLightSailSDConfigs() {
        return lightSailSDConfigs;
    }

    /**
     * lightSailSDConfigs defines a list of Lightsail service discovery configurations.
     */
    @JsonProperty("lightSailSDConfigs")
    public void setLightSailSDConfigs(List<LightSailSDConfig> lightSailSDConfigs) {
        this.lightSailSDConfigs = lightSailSDConfigs;
    }

    /**
     * linodeSDConfigs defines a list of Linode service discovery configurations.
     */
    @JsonProperty("linodeSDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<LinodeSDConfig> getLinodeSDConfigs() {
        return linodeSDConfigs;
    }

    /**
     * linodeSDConfigs defines a list of Linode service discovery configurations.
     */
    @JsonProperty("linodeSDConfigs")
    public void setLinodeSDConfigs(List<LinodeSDConfig> linodeSDConfigs) {
        this.linodeSDConfigs = linodeSDConfigs;
    }

    /**
     * metricRelabelings defines the metricRelabelings to apply to samples before ingestion.
     */
    @JsonProperty("metricRelabelings")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<RelabelConfig> getMetricRelabelings() {
        return metricRelabelings;
    }

    /**
     * metricRelabelings defines the metricRelabelings to apply to samples before ingestion.
     */
    @JsonProperty("metricRelabelings")
    public void setMetricRelabelings(List<RelabelConfig> metricRelabelings) {
        this.metricRelabelings = metricRelabelings;
    }

    /**
     * metricsPath defines the HTTP path to scrape for metrics. If empty, Prometheus uses the default value (e.g. /metrics).
     */
    @JsonProperty("metricsPath")
    public String getMetricsPath() {
        return metricsPath;
    }

    /**
     * metricsPath defines the HTTP path to scrape for metrics. If empty, Prometheus uses the default value (e.g. /metrics).
     */
    @JsonProperty("metricsPath")
    public void setMetricsPath(String metricsPath) {
        this.metricsPath = metricsPath;
    }

    /**
     * nameEscapingScheme defines the metric name escaping mode to request through content negotiation.<br><p> <br><p> It requires Prometheus &gt;= v3.4.0.
     */
    @JsonProperty("nameEscapingScheme")
    public String getNameEscapingScheme() {
        return nameEscapingScheme;
    }

    /**
     * nameEscapingScheme defines the metric name escaping mode to request through content negotiation.<br><p> <br><p> It requires Prometheus &gt;= v3.4.0.
     */
    @JsonProperty("nameEscapingScheme")
    public void setNameEscapingScheme(String nameEscapingScheme) {
        this.nameEscapingScheme = nameEscapingScheme;
    }

    /**
     * nameValidationScheme defines the validation scheme for metric and label names.<br><p> <br><p> It requires Prometheus &gt;= v3.0.0.
     */
    @JsonProperty("nameValidationScheme")
    public String getNameValidationScheme() {
        return nameValidationScheme;
    }

    /**
     * nameValidationScheme defines the validation scheme for metric and label names.<br><p> <br><p> It requires Prometheus &gt;= v3.0.0.
     */
    @JsonProperty("nameValidationScheme")
    public void setNameValidationScheme(String nameValidationScheme) {
        this.nameValidationScheme = nameValidationScheme;
    }

    /**
     * nativeHistogramBucketLimit defines ff there are more than this many buckets in a native histogram, buckets will be merged to stay within the limit. It requires Prometheus &gt;= v2.45.0.
     */
    @JsonProperty("nativeHistogramBucketLimit")
    public Long getNativeHistogramBucketLimit() {
        return nativeHistogramBucketLimit;
    }

    /**
     * nativeHistogramBucketLimit defines ff there are more than this many buckets in a native histogram, buckets will be merged to stay within the limit. It requires Prometheus &gt;= v2.45.0.
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
     * noProxy defines a comma-separated string that can contain IPs, CIDR notation, domain names that should be excluded from proxying. IP and domain names can contain port numbers.<br><p> <br><p> It requires Prometheus &gt;= v2.43.0, Alertmanager &gt;= v0.25.0 or Thanos &gt;= v0.32.0.
     */
    @JsonProperty("noProxy")
    public String getNoProxy() {
        return noProxy;
    }

    /**
     * noProxy defines a comma-separated string that can contain IPs, CIDR notation, domain names that should be excluded from proxying. IP and domain names can contain port numbers.<br><p> <br><p> It requires Prometheus &gt;= v2.43.0, Alertmanager &gt;= v0.25.0 or Thanos &gt;= v0.32.0.
     */
    @JsonProperty("noProxy")
    public void setNoProxy(String noProxy) {
        this.noProxy = noProxy;
    }

    /**
     * nomadSDConfigs defines a list of Nomad service discovery configurations.
     */
    @JsonProperty("nomadSDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<NomadSDConfig> getNomadSDConfigs() {
        return nomadSDConfigs;
    }

    /**
     * nomadSDConfigs defines a list of Nomad service discovery configurations.
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
     * openstackSDConfigs defines a list of OpenStack service discovery configurations.
     */
    @JsonProperty("openstackSDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<OpenStackSDConfig> getOpenstackSDConfigs() {
        return openstackSDConfigs;
    }

    /**
     * openstackSDConfigs defines a list of OpenStack service discovery configurations.
     */
    @JsonProperty("openstackSDConfigs")
    public void setOpenstackSDConfigs(List<OpenStackSDConfig> openstackSDConfigs) {
        this.openstackSDConfigs = openstackSDConfigs;
    }

    /**
     * ovhcloudSDConfigs defines a list of OVHcloud service discovery configurations.
     */
    @JsonProperty("ovhcloudSDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<OVHCloudSDConfig> getOvhcloudSDConfigs() {
        return ovhcloudSDConfigs;
    }

    /**
     * ovhcloudSDConfigs defines a list of OVHcloud service discovery configurations.
     */
    @JsonProperty("ovhcloudSDConfigs")
    public void setOvhcloudSDConfigs(List<OVHCloudSDConfig> ovhcloudSDConfigs) {
        this.ovhcloudSDConfigs = ovhcloudSDConfigs;
    }

    /**
     * params defines optional HTTP URL parameters
     */
    @JsonProperty("params")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, List<String>> getParams() {
        return params;
    }

    /**
     * params defines optional HTTP URL parameters
     */
    @JsonProperty("params")
    public void setParams(Map<String, List<String>> params) {
        this.params = params;
    }

    /**
     * proxyConnectHeader optionally specifies headers to send to proxies during CONNECT requests.<br><p> <br><p> It requires Prometheus &gt;= v2.43.0, Alertmanager &gt;= v0.25.0 or Thanos &gt;= v0.32.0.
     */
    @JsonProperty("proxyConnectHeader")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, List<SecretKeySelector>> getProxyConnectHeader() {
        return proxyConnectHeader;
    }

    /**
     * proxyConnectHeader optionally specifies headers to send to proxies during CONNECT requests.<br><p> <br><p> It requires Prometheus &gt;= v2.43.0, Alertmanager &gt;= v0.25.0 or Thanos &gt;= v0.32.0.
     */
    @JsonProperty("proxyConnectHeader")
    public void setProxyConnectHeader(Map<String, List<SecretKeySelector>> proxyConnectHeader) {
        this.proxyConnectHeader = proxyConnectHeader;
    }

    /**
     * proxyFromEnvironment defines whether to use the proxy configuration defined by environment variables (HTTP_PROXY, HTTPS_PROXY, and NO_PROXY).<br><p> <br><p> It requires Prometheus &gt;= v2.43.0, Alertmanager &gt;= v0.25.0 or Thanos &gt;= v0.32.0.
     */
    @JsonProperty("proxyFromEnvironment")
    public Boolean getProxyFromEnvironment() {
        return proxyFromEnvironment;
    }

    /**
     * proxyFromEnvironment defines whether to use the proxy configuration defined by environment variables (HTTP_PROXY, HTTPS_PROXY, and NO_PROXY).<br><p> <br><p> It requires Prometheus &gt;= v2.43.0, Alertmanager &gt;= v0.25.0 or Thanos &gt;= v0.32.0.
     */
    @JsonProperty("proxyFromEnvironment")
    public void setProxyFromEnvironment(Boolean proxyFromEnvironment) {
        this.proxyFromEnvironment = proxyFromEnvironment;
    }

    /**
     * proxyUrl defines the HTTP proxy server to use.
     */
    @JsonProperty("proxyUrl")
    public String getProxyUrl() {
        return proxyUrl;
    }

    /**
     * proxyUrl defines the HTTP proxy server to use.
     */
    @JsonProperty("proxyUrl")
    public void setProxyUrl(String proxyUrl) {
        this.proxyUrl = proxyUrl;
    }

    /**
     * puppetDBSDConfigs defines a list of PuppetDB service discovery configurations.
     */
    @JsonProperty("puppetDBSDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PuppetDBSDConfig> getPuppetDBSDConfigs() {
        return puppetDBSDConfigs;
    }

    /**
     * puppetDBSDConfigs defines a list of PuppetDB service discovery configurations.
     */
    @JsonProperty("puppetDBSDConfigs")
    public void setPuppetDBSDConfigs(List<PuppetDBSDConfig> puppetDBSDConfigs) {
        this.puppetDBSDConfigs = puppetDBSDConfigs;
    }

    /**
     * relabelings defines how to rewrite the target's labels before scraping. Prometheus Operator automatically adds relabelings for a few standard Kubernetes fields. The original scrape job's name is available via the `__tmp_prometheus_job_name` label. More info: https://prometheus.io/docs/prometheus/latest/configuration/configuration/#relabel_config
     */
    @JsonProperty("relabelings")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<RelabelConfig> getRelabelings() {
        return relabelings;
    }

    /**
     * relabelings defines how to rewrite the target's labels before scraping. Prometheus Operator automatically adds relabelings for a few standard Kubernetes fields. The original scrape job's name is available via the `__tmp_prometheus_job_name` label. More info: https://prometheus.io/docs/prometheus/latest/configuration/configuration/#relabel_config
     */
    @JsonProperty("relabelings")
    public void setRelabelings(List<RelabelConfig> relabelings) {
        this.relabelings = relabelings;
    }

    /**
     * sampleLimit defines per-scrape limit on number of scraped samples that will be accepted.
     */
    @JsonProperty("sampleLimit")
    public Long getSampleLimit() {
        return sampleLimit;
    }

    /**
     * sampleLimit defines per-scrape limit on number of scraped samples that will be accepted.
     */
    @JsonProperty("sampleLimit")
    public void setSampleLimit(Long sampleLimit) {
        this.sampleLimit = sampleLimit;
    }

    /**
     * scalewaySDConfigs defines a list of Scaleway instances and baremetal service discovery configurations.
     */
    @JsonProperty("scalewaySDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ScalewaySDConfig> getScalewaySDConfigs() {
        return scalewaySDConfigs;
    }

    /**
     * scalewaySDConfigs defines a list of Scaleway instances and baremetal service discovery configurations.
     */
    @JsonProperty("scalewaySDConfigs")
    public void setScalewaySDConfigs(List<ScalewaySDConfig> scalewaySDConfigs) {
        this.scalewaySDConfigs = scalewaySDConfigs;
    }

    /**
     * scheme defines the protocol scheme used for requests.
     */
    @JsonProperty("scheme")
    public String getScheme() {
        return scheme;
    }

    /**
     * scheme defines the protocol scheme used for requests.
     */
    @JsonProperty("scheme")
    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    /**
     * scrapeClass defines the scrape class to apply.
     */
    @JsonProperty("scrapeClass")
    public String getScrapeClass() {
        return scrapeClass;
    }

    /**
     * scrapeClass defines the scrape class to apply.
     */
    @JsonProperty("scrapeClass")
    public void setScrapeClass(String scrapeClass) {
        this.scrapeClass = scrapeClass;
    }

    /**
     * scrapeClassicHistograms defines whether to scrape a classic histogram that is also exposed as a native histogram. It requires Prometheus &gt;= v2.45.0.<br><p> <br><p> Notice: `scrapeClassicHistograms` corresponds to the `always_scrape_classic_histograms` field in the Prometheus configuration.
     */
    @JsonProperty("scrapeClassicHistograms")
    public Boolean getScrapeClassicHistograms() {
        return scrapeClassicHistograms;
    }

    /**
     * scrapeClassicHistograms defines whether to scrape a classic histogram that is also exposed as a native histogram. It requires Prometheus &gt;= v2.45.0.<br><p> <br><p> Notice: `scrapeClassicHistograms` corresponds to the `always_scrape_classic_histograms` field in the Prometheus configuration.
     */
    @JsonProperty("scrapeClassicHistograms")
    public void setScrapeClassicHistograms(Boolean scrapeClassicHistograms) {
        this.scrapeClassicHistograms = scrapeClassicHistograms;
    }

    /**
     * scrapeInterval defines the interval between consecutive scrapes.
     */
    @JsonProperty("scrapeInterval")
    public String getScrapeInterval() {
        return scrapeInterval;
    }

    /**
     * scrapeInterval defines the interval between consecutive scrapes.
     */
    @JsonProperty("scrapeInterval")
    public void setScrapeInterval(String scrapeInterval) {
        this.scrapeInterval = scrapeInterval;
    }

    /**
     * scrapeNativeHistograms defines whether to enable scraping of native histograms. It requires Prometheus &gt;= v3.8.0.
     */
    @JsonProperty("scrapeNativeHistograms")
    public Boolean getScrapeNativeHistograms() {
        return scrapeNativeHistograms;
    }

    /**
     * scrapeNativeHistograms defines whether to enable scraping of native histograms. It requires Prometheus &gt;= v3.8.0.
     */
    @JsonProperty("scrapeNativeHistograms")
    public void setScrapeNativeHistograms(Boolean scrapeNativeHistograms) {
        this.scrapeNativeHistograms = scrapeNativeHistograms;
    }

    /**
     * scrapeProtocols defines the protocols to negotiate during a scrape. It tells clients the protocols supported by Prometheus in order of preference (from most to least preferred).<br><p> <br><p> If unset, Prometheus uses its default value.<br><p> <br><p> It requires Prometheus &gt;= v2.49.0.
     */
    @JsonProperty("scrapeProtocols")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getScrapeProtocols() {
        return scrapeProtocols;
    }

    /**
     * scrapeProtocols defines the protocols to negotiate during a scrape. It tells clients the protocols supported by Prometheus in order of preference (from most to least preferred).<br><p> <br><p> If unset, Prometheus uses its default value.<br><p> <br><p> It requires Prometheus &gt;= v2.49.0.
     */
    @JsonProperty("scrapeProtocols")
    public void setScrapeProtocols(List<String> scrapeProtocols) {
        this.scrapeProtocols = scrapeProtocols;
    }

    /**
     * scrapeTimeout defines the number of seconds to wait until a scrape request times out. The value cannot be greater than the scrape interval otherwise the operator will reject the resource.
     */
    @JsonProperty("scrapeTimeout")
    public String getScrapeTimeout() {
        return scrapeTimeout;
    }

    /**
     * scrapeTimeout defines the number of seconds to wait until a scrape request times out. The value cannot be greater than the scrape interval otherwise the operator will reject the resource.
     */
    @JsonProperty("scrapeTimeout")
    public void setScrapeTimeout(String scrapeTimeout) {
        this.scrapeTimeout = scrapeTimeout;
    }

    /**
     * staticConfigs defines a list of static targets with a common label set.
     */
    @JsonProperty("staticConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<StaticConfig> getStaticConfigs() {
        return staticConfigs;
    }

    /**
     * staticConfigs defines a list of static targets with a common label set.
     */
    @JsonProperty("staticConfigs")
    public void setStaticConfigs(List<StaticConfig> staticConfigs) {
        this.staticConfigs = staticConfigs;
    }

    /**
     * targetLimit defines a limit on the number of scraped targets that will be accepted.
     */
    @JsonProperty("targetLimit")
    public Long getTargetLimit() {
        return targetLimit;
    }

    /**
     * targetLimit defines a limit on the number of scraped targets that will be accepted.
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
     * trackTimestampsStaleness defines whether Prometheus tracks staleness of the metrics that have an explicit timestamp present in scraped data. Has no effect if `honorTimestamps` is false. It requires Prometheus &gt;= v2.48.0.
     */
    @JsonProperty("trackTimestampsStaleness")
    public Boolean getTrackTimestampsStaleness() {
        return trackTimestampsStaleness;
    }

    /**
     * trackTimestampsStaleness defines whether Prometheus tracks staleness of the metrics that have an explicit timestamp present in scraped data. Has no effect if `honorTimestamps` is false. It requires Prometheus &gt;= v2.48.0.
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ScrapeConfigSpec)) {
            return false;
        }
        ScrapeConfigSpec other = (ScrapeConfigSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$authorization = this.getAuthorization();
        Object other$authorization = other.getAuthorization();
        if (this$authorization == null ? other$authorization != null : !this$authorization.equals(other$authorization)) {
            return false;
        }
        Object this$azureSDConfigs = this.getAzureSDConfigs();
        Object other$azureSDConfigs = other.getAzureSDConfigs();
        if (this$azureSDConfigs == null ? other$azureSDConfigs != null : !this$azureSDConfigs.equals(other$azureSDConfigs)) {
            return false;
        }
        Object this$basicAuth = this.getBasicAuth();
        Object other$basicAuth = other.getBasicAuth();
        if (this$basicAuth == null ? other$basicAuth != null : !this$basicAuth.equals(other$basicAuth)) {
            return false;
        }
        Object this$bodySizeLimit = this.getBodySizeLimit();
        Object other$bodySizeLimit = other.getBodySizeLimit();
        if (this$bodySizeLimit == null ? other$bodySizeLimit != null : !this$bodySizeLimit.equals(other$bodySizeLimit)) {
            return false;
        }
        Object this$consulSDConfigs = this.getConsulSDConfigs();
        Object other$consulSDConfigs = other.getConsulSDConfigs();
        if (this$consulSDConfigs == null ? other$consulSDConfigs != null : !this$consulSDConfigs.equals(other$consulSDConfigs)) {
            return false;
        }
        Object this$convertClassicHistogramsToNHCB = this.getConvertClassicHistogramsToNHCB();
        Object other$convertClassicHistogramsToNHCB = other.getConvertClassicHistogramsToNHCB();
        if (this$convertClassicHistogramsToNHCB == null ? other$convertClassicHistogramsToNHCB != null : !this$convertClassicHistogramsToNHCB.equals(other$convertClassicHistogramsToNHCB)) {
            return false;
        }
        Object this$digitalOceanSDConfigs = this.getDigitalOceanSDConfigs();
        Object other$digitalOceanSDConfigs = other.getDigitalOceanSDConfigs();
        if (this$digitalOceanSDConfigs == null ? other$digitalOceanSDConfigs != null : !this$digitalOceanSDConfigs.equals(other$digitalOceanSDConfigs)) {
            return false;
        }
        Object this$dnsSDConfigs = this.getDnsSDConfigs();
        Object other$dnsSDConfigs = other.getDnsSDConfigs();
        if (this$dnsSDConfigs == null ? other$dnsSDConfigs != null : !this$dnsSDConfigs.equals(other$dnsSDConfigs)) {
            return false;
        }
        Object this$dockerSDConfigs = this.getDockerSDConfigs();
        Object other$dockerSDConfigs = other.getDockerSDConfigs();
        if (this$dockerSDConfigs == null ? other$dockerSDConfigs != null : !this$dockerSDConfigs.equals(other$dockerSDConfigs)) {
            return false;
        }
        Object this$dockerSwarmSDConfigs = this.getDockerSwarmSDConfigs();
        Object other$dockerSwarmSDConfigs = other.getDockerSwarmSDConfigs();
        if (this$dockerSwarmSDConfigs == null ? other$dockerSwarmSDConfigs != null : !this$dockerSwarmSDConfigs.equals(other$dockerSwarmSDConfigs)) {
            return false;
        }
        Object this$ec2SDConfigs = this.getEc2SDConfigs();
        Object other$ec2SDConfigs = other.getEc2SDConfigs();
        if (this$ec2SDConfigs == null ? other$ec2SDConfigs != null : !this$ec2SDConfigs.equals(other$ec2SDConfigs)) {
            return false;
        }
        Object this$enableCompression = this.getEnableCompression();
        Object other$enableCompression = other.getEnableCompression();
        if (this$enableCompression == null ? other$enableCompression != null : !this$enableCompression.equals(other$enableCompression)) {
            return false;
        }
        Object this$enableHTTP2 = this.getEnableHTTP2();
        Object other$enableHTTP2 = other.getEnableHTTP2();
        if (this$enableHTTP2 == null ? other$enableHTTP2 != null : !this$enableHTTP2.equals(other$enableHTTP2)) {
            return false;
        }
        Object this$eurekaSDConfigs = this.getEurekaSDConfigs();
        Object other$eurekaSDConfigs = other.getEurekaSDConfigs();
        if (this$eurekaSDConfigs == null ? other$eurekaSDConfigs != null : !this$eurekaSDConfigs.equals(other$eurekaSDConfigs)) {
            return false;
        }
        Object this$fallbackScrapeProtocol = this.getFallbackScrapeProtocol();
        Object other$fallbackScrapeProtocol = other.getFallbackScrapeProtocol();
        if (this$fallbackScrapeProtocol == null ? other$fallbackScrapeProtocol != null : !this$fallbackScrapeProtocol.equals(other$fallbackScrapeProtocol)) {
            return false;
        }
        Object this$fileSDConfigs = this.getFileSDConfigs();
        Object other$fileSDConfigs = other.getFileSDConfigs();
        if (this$fileSDConfigs == null ? other$fileSDConfigs != null : !this$fileSDConfigs.equals(other$fileSDConfigs)) {
            return false;
        }
        Object this$gceSDConfigs = this.getGceSDConfigs();
        Object other$gceSDConfigs = other.getGceSDConfigs();
        if (this$gceSDConfigs == null ? other$gceSDConfigs != null : !this$gceSDConfigs.equals(other$gceSDConfigs)) {
            return false;
        }
        Object this$hetznerSDConfigs = this.getHetznerSDConfigs();
        Object other$hetznerSDConfigs = other.getHetznerSDConfigs();
        if (this$hetznerSDConfigs == null ? other$hetznerSDConfigs != null : !this$hetznerSDConfigs.equals(other$hetznerSDConfigs)) {
            return false;
        }
        Object this$honorLabels = this.getHonorLabels();
        Object other$honorLabels = other.getHonorLabels();
        if (this$honorLabels == null ? other$honorLabels != null : !this$honorLabels.equals(other$honorLabels)) {
            return false;
        }
        Object this$honorTimestamps = this.getHonorTimestamps();
        Object other$honorTimestamps = other.getHonorTimestamps();
        if (this$honorTimestamps == null ? other$honorTimestamps != null : !this$honorTimestamps.equals(other$honorTimestamps)) {
            return false;
        }
        Object this$httpSDConfigs = this.getHttpSDConfigs();
        Object other$httpSDConfigs = other.getHttpSDConfigs();
        if (this$httpSDConfigs == null ? other$httpSDConfigs != null : !this$httpSDConfigs.equals(other$httpSDConfigs)) {
            return false;
        }
        Object this$ionosSDConfigs = this.getIonosSDConfigs();
        Object other$ionosSDConfigs = other.getIonosSDConfigs();
        if (this$ionosSDConfigs == null ? other$ionosSDConfigs != null : !this$ionosSDConfigs.equals(other$ionosSDConfigs)) {
            return false;
        }
        Object this$jobName = this.getJobName();
        Object other$jobName = other.getJobName();
        if (this$jobName == null ? other$jobName != null : !this$jobName.equals(other$jobName)) {
            return false;
        }
        Object this$keepDroppedTargets = this.getKeepDroppedTargets();
        Object other$keepDroppedTargets = other.getKeepDroppedTargets();
        if (this$keepDroppedTargets == null ? other$keepDroppedTargets != null : !this$keepDroppedTargets.equals(other$keepDroppedTargets)) {
            return false;
        }
        Object this$kubernetesSDConfigs = this.getKubernetesSDConfigs();
        Object other$kubernetesSDConfigs = other.getKubernetesSDConfigs();
        if (this$kubernetesSDConfigs == null ? other$kubernetesSDConfigs != null : !this$kubernetesSDConfigs.equals(other$kubernetesSDConfigs)) {
            return false;
        }
        Object this$kumaSDConfigs = this.getKumaSDConfigs();
        Object other$kumaSDConfigs = other.getKumaSDConfigs();
        if (this$kumaSDConfigs == null ? other$kumaSDConfigs != null : !this$kumaSDConfigs.equals(other$kumaSDConfigs)) {
            return false;
        }
        Object this$labelLimit = this.getLabelLimit();
        Object other$labelLimit = other.getLabelLimit();
        if (this$labelLimit == null ? other$labelLimit != null : !this$labelLimit.equals(other$labelLimit)) {
            return false;
        }
        Object this$labelNameLengthLimit = this.getLabelNameLengthLimit();
        Object other$labelNameLengthLimit = other.getLabelNameLengthLimit();
        if (this$labelNameLengthLimit == null ? other$labelNameLengthLimit != null : !this$labelNameLengthLimit.equals(other$labelNameLengthLimit)) {
            return false;
        }
        Object this$labelValueLengthLimit = this.getLabelValueLengthLimit();
        Object other$labelValueLengthLimit = other.getLabelValueLengthLimit();
        if (this$labelValueLengthLimit == null ? other$labelValueLengthLimit != null : !this$labelValueLengthLimit.equals(other$labelValueLengthLimit)) {
            return false;
        }
        Object this$lightSailSDConfigs = this.getLightSailSDConfigs();
        Object other$lightSailSDConfigs = other.getLightSailSDConfigs();
        if (this$lightSailSDConfigs == null ? other$lightSailSDConfigs != null : !this$lightSailSDConfigs.equals(other$lightSailSDConfigs)) {
            return false;
        }
        Object this$linodeSDConfigs = this.getLinodeSDConfigs();
        Object other$linodeSDConfigs = other.getLinodeSDConfigs();
        if (this$linodeSDConfigs == null ? other$linodeSDConfigs != null : !this$linodeSDConfigs.equals(other$linodeSDConfigs)) {
            return false;
        }
        Object this$metricRelabelings = this.getMetricRelabelings();
        Object other$metricRelabelings = other.getMetricRelabelings();
        if (this$metricRelabelings == null ? other$metricRelabelings != null : !this$metricRelabelings.equals(other$metricRelabelings)) {
            return false;
        }
        Object this$metricsPath = this.getMetricsPath();
        Object other$metricsPath = other.getMetricsPath();
        if (this$metricsPath == null ? other$metricsPath != null : !this$metricsPath.equals(other$metricsPath)) {
            return false;
        }
        Object this$nameEscapingScheme = this.getNameEscapingScheme();
        Object other$nameEscapingScheme = other.getNameEscapingScheme();
        if (this$nameEscapingScheme == null ? other$nameEscapingScheme != null : !this$nameEscapingScheme.equals(other$nameEscapingScheme)) {
            return false;
        }
        Object this$nameValidationScheme = this.getNameValidationScheme();
        Object other$nameValidationScheme = other.getNameValidationScheme();
        if (this$nameValidationScheme == null ? other$nameValidationScheme != null : !this$nameValidationScheme.equals(other$nameValidationScheme)) {
            return false;
        }
        Object this$nativeHistogramBucketLimit = this.getNativeHistogramBucketLimit();
        Object other$nativeHistogramBucketLimit = other.getNativeHistogramBucketLimit();
        if (this$nativeHistogramBucketLimit == null ? other$nativeHistogramBucketLimit != null : !this$nativeHistogramBucketLimit.equals(other$nativeHistogramBucketLimit)) {
            return false;
        }
        Object this$nativeHistogramMinBucketFactor = this.getNativeHistogramMinBucketFactor();
        Object other$nativeHistogramMinBucketFactor = other.getNativeHistogramMinBucketFactor();
        if (this$nativeHistogramMinBucketFactor == null ? other$nativeHistogramMinBucketFactor != null : !this$nativeHistogramMinBucketFactor.equals(other$nativeHistogramMinBucketFactor)) {
            return false;
        }
        Object this$noProxy = this.getNoProxy();
        Object other$noProxy = other.getNoProxy();
        if (this$noProxy == null ? other$noProxy != null : !this$noProxy.equals(other$noProxy)) {
            return false;
        }
        Object this$nomadSDConfigs = this.getNomadSDConfigs();
        Object other$nomadSDConfigs = other.getNomadSDConfigs();
        if (this$nomadSDConfigs == null ? other$nomadSDConfigs != null : !this$nomadSDConfigs.equals(other$nomadSDConfigs)) {
            return false;
        }
        Object this$oauth2 = this.getOauth2();
        Object other$oauth2 = other.getOauth2();
        if (this$oauth2 == null ? other$oauth2 != null : !this$oauth2.equals(other$oauth2)) {
            return false;
        }
        Object this$openstackSDConfigs = this.getOpenstackSDConfigs();
        Object other$openstackSDConfigs = other.getOpenstackSDConfigs();
        if (this$openstackSDConfigs == null ? other$openstackSDConfigs != null : !this$openstackSDConfigs.equals(other$openstackSDConfigs)) {
            return false;
        }
        Object this$ovhcloudSDConfigs = this.getOvhcloudSDConfigs();
        Object other$ovhcloudSDConfigs = other.getOvhcloudSDConfigs();
        if (this$ovhcloudSDConfigs == null ? other$ovhcloudSDConfigs != null : !this$ovhcloudSDConfigs.equals(other$ovhcloudSDConfigs)) {
            return false;
        }
        Object this$params = this.getParams();
        Object other$params = other.getParams();
        if (this$params == null ? other$params != null : !this$params.equals(other$params)) {
            return false;
        }
        Object this$proxyConnectHeader = this.getProxyConnectHeader();
        Object other$proxyConnectHeader = other.getProxyConnectHeader();
        if (this$proxyConnectHeader == null ? other$proxyConnectHeader != null : !this$proxyConnectHeader.equals(other$proxyConnectHeader)) {
            return false;
        }
        Object this$proxyFromEnvironment = this.getProxyFromEnvironment();
        Object other$proxyFromEnvironment = other.getProxyFromEnvironment();
        if (this$proxyFromEnvironment == null ? other$proxyFromEnvironment != null : !this$proxyFromEnvironment.equals(other$proxyFromEnvironment)) {
            return false;
        }
        Object this$proxyUrl = this.getProxyUrl();
        Object other$proxyUrl = other.getProxyUrl();
        if (this$proxyUrl == null ? other$proxyUrl != null : !this$proxyUrl.equals(other$proxyUrl)) {
            return false;
        }
        Object this$puppetDBSDConfigs = this.getPuppetDBSDConfigs();
        Object other$puppetDBSDConfigs = other.getPuppetDBSDConfigs();
        if (this$puppetDBSDConfigs == null ? other$puppetDBSDConfigs != null : !this$puppetDBSDConfigs.equals(other$puppetDBSDConfigs)) {
            return false;
        }
        Object this$relabelings = this.getRelabelings();
        Object other$relabelings = other.getRelabelings();
        if (this$relabelings == null ? other$relabelings != null : !this$relabelings.equals(other$relabelings)) {
            return false;
        }
        Object this$sampleLimit = this.getSampleLimit();
        Object other$sampleLimit = other.getSampleLimit();
        if (this$sampleLimit == null ? other$sampleLimit != null : !this$sampleLimit.equals(other$sampleLimit)) {
            return false;
        }
        Object this$scalewaySDConfigs = this.getScalewaySDConfigs();
        Object other$scalewaySDConfigs = other.getScalewaySDConfigs();
        if (this$scalewaySDConfigs == null ? other$scalewaySDConfigs != null : !this$scalewaySDConfigs.equals(other$scalewaySDConfigs)) {
            return false;
        }
        Object this$scheme = this.getScheme();
        Object other$scheme = other.getScheme();
        if (this$scheme == null ? other$scheme != null : !this$scheme.equals(other$scheme)) {
            return false;
        }
        Object this$scrapeClass = this.getScrapeClass();
        Object other$scrapeClass = other.getScrapeClass();
        if (this$scrapeClass == null ? other$scrapeClass != null : !this$scrapeClass.equals(other$scrapeClass)) {
            return false;
        }
        Object this$scrapeClassicHistograms = this.getScrapeClassicHistograms();
        Object other$scrapeClassicHistograms = other.getScrapeClassicHistograms();
        if (this$scrapeClassicHistograms == null ? other$scrapeClassicHistograms != null : !this$scrapeClassicHistograms.equals(other$scrapeClassicHistograms)) {
            return false;
        }
        Object this$scrapeInterval = this.getScrapeInterval();
        Object other$scrapeInterval = other.getScrapeInterval();
        if (this$scrapeInterval == null ? other$scrapeInterval != null : !this$scrapeInterval.equals(other$scrapeInterval)) {
            return false;
        }
        Object this$scrapeNativeHistograms = this.getScrapeNativeHistograms();
        Object other$scrapeNativeHistograms = other.getScrapeNativeHistograms();
        if (this$scrapeNativeHistograms == null ? other$scrapeNativeHistograms != null : !this$scrapeNativeHistograms.equals(other$scrapeNativeHistograms)) {
            return false;
        }
        Object this$scrapeProtocols = this.getScrapeProtocols();
        Object other$scrapeProtocols = other.getScrapeProtocols();
        if (this$scrapeProtocols == null ? other$scrapeProtocols != null : !this$scrapeProtocols.equals(other$scrapeProtocols)) {
            return false;
        }
        Object this$scrapeTimeout = this.getScrapeTimeout();
        Object other$scrapeTimeout = other.getScrapeTimeout();
        if (this$scrapeTimeout == null ? other$scrapeTimeout != null : !this$scrapeTimeout.equals(other$scrapeTimeout)) {
            return false;
        }
        Object this$staticConfigs = this.getStaticConfigs();
        Object other$staticConfigs = other.getStaticConfigs();
        if (this$staticConfigs == null ? other$staticConfigs != null : !this$staticConfigs.equals(other$staticConfigs)) {
            return false;
        }
        Object this$targetLimit = this.getTargetLimit();
        Object other$targetLimit = other.getTargetLimit();
        if (this$targetLimit == null ? other$targetLimit != null : !this$targetLimit.equals(other$targetLimit)) {
            return false;
        }
        Object this$tlsConfig = this.getTlsConfig();
        Object other$tlsConfig = other.getTlsConfig();
        if (this$tlsConfig == null ? other$tlsConfig != null : !this$tlsConfig.equals(other$tlsConfig)) {
            return false;
        }
        Object this$trackTimestampsStaleness = this.getTrackTimestampsStaleness();
        Object other$trackTimestampsStaleness = other.getTrackTimestampsStaleness();
        if (this$trackTimestampsStaleness == null ? other$trackTimestampsStaleness != null : !this$trackTimestampsStaleness.equals(other$trackTimestampsStaleness)) {
            return false;
        }
        Object this$additionalProperties = this.getAdditionalProperties();
        Object other$additionalProperties = other.getAdditionalProperties();
        if (this$additionalProperties == null ? other$additionalProperties != null : !this$additionalProperties.equals(other$additionalProperties)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(Object other) {
        return other instanceof ScrapeConfigSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $authorization = this.getAuthorization();
        result = result * prime + ($authorization == null ? 43 : $authorization.hashCode());
        Object $azureSDConfigs = this.getAzureSDConfigs();
        result = result * prime + ($azureSDConfigs == null ? 43 : $azureSDConfigs.hashCode());
        Object $basicAuth = this.getBasicAuth();
        result = result * prime + ($basicAuth == null ? 43 : $basicAuth.hashCode());
        Object $bodySizeLimit = this.getBodySizeLimit();
        result = result * prime + ($bodySizeLimit == null ? 43 : $bodySizeLimit.hashCode());
        Object $consulSDConfigs = this.getConsulSDConfigs();
        result = result * prime + ($consulSDConfigs == null ? 43 : $consulSDConfigs.hashCode());
        Object $convertClassicHistogramsToNHCB = this.getConvertClassicHistogramsToNHCB();
        result = result * prime + ($convertClassicHistogramsToNHCB == null ? 43 : $convertClassicHistogramsToNHCB.hashCode());
        Object $digitalOceanSDConfigs = this.getDigitalOceanSDConfigs();
        result = result * prime + ($digitalOceanSDConfigs == null ? 43 : $digitalOceanSDConfigs.hashCode());
        Object $dnsSDConfigs = this.getDnsSDConfigs();
        result = result * prime + ($dnsSDConfigs == null ? 43 : $dnsSDConfigs.hashCode());
        Object $dockerSDConfigs = this.getDockerSDConfigs();
        result = result * prime + ($dockerSDConfigs == null ? 43 : $dockerSDConfigs.hashCode());
        Object $dockerSwarmSDConfigs = this.getDockerSwarmSDConfigs();
        result = result * prime + ($dockerSwarmSDConfigs == null ? 43 : $dockerSwarmSDConfigs.hashCode());
        Object $ec2SDConfigs = this.getEc2SDConfigs();
        result = result * prime + ($ec2SDConfigs == null ? 43 : $ec2SDConfigs.hashCode());
        Object $enableCompression = this.getEnableCompression();
        result = result * prime + ($enableCompression == null ? 43 : $enableCompression.hashCode());
        Object $enableHTTP2 = this.getEnableHTTP2();
        result = result * prime + ($enableHTTP2 == null ? 43 : $enableHTTP2.hashCode());
        Object $eurekaSDConfigs = this.getEurekaSDConfigs();
        result = result * prime + ($eurekaSDConfigs == null ? 43 : $eurekaSDConfigs.hashCode());
        Object $fallbackScrapeProtocol = this.getFallbackScrapeProtocol();
        result = result * prime + ($fallbackScrapeProtocol == null ? 43 : $fallbackScrapeProtocol.hashCode());
        Object $fileSDConfigs = this.getFileSDConfigs();
        result = result * prime + ($fileSDConfigs == null ? 43 : $fileSDConfigs.hashCode());
        Object $gceSDConfigs = this.getGceSDConfigs();
        result = result * prime + ($gceSDConfigs == null ? 43 : $gceSDConfigs.hashCode());
        Object $hetznerSDConfigs = this.getHetznerSDConfigs();
        result = result * prime + ($hetznerSDConfigs == null ? 43 : $hetznerSDConfigs.hashCode());
        Object $honorLabels = this.getHonorLabels();
        result = result * prime + ($honorLabels == null ? 43 : $honorLabels.hashCode());
        Object $honorTimestamps = this.getHonorTimestamps();
        result = result * prime + ($honorTimestamps == null ? 43 : $honorTimestamps.hashCode());
        Object $httpSDConfigs = this.getHttpSDConfigs();
        result = result * prime + ($httpSDConfigs == null ? 43 : $httpSDConfigs.hashCode());
        Object $ionosSDConfigs = this.getIonosSDConfigs();
        result = result * prime + ($ionosSDConfigs == null ? 43 : $ionosSDConfigs.hashCode());
        Object $jobName = this.getJobName();
        result = result * prime + ($jobName == null ? 43 : $jobName.hashCode());
        Object $keepDroppedTargets = this.getKeepDroppedTargets();
        result = result * prime + ($keepDroppedTargets == null ? 43 : $keepDroppedTargets.hashCode());
        Object $kubernetesSDConfigs = this.getKubernetesSDConfigs();
        result = result * prime + ($kubernetesSDConfigs == null ? 43 : $kubernetesSDConfigs.hashCode());
        Object $kumaSDConfigs = this.getKumaSDConfigs();
        result = result * prime + ($kumaSDConfigs == null ? 43 : $kumaSDConfigs.hashCode());
        Object $labelLimit = this.getLabelLimit();
        result = result * prime + ($labelLimit == null ? 43 : $labelLimit.hashCode());
        Object $labelNameLengthLimit = this.getLabelNameLengthLimit();
        result = result * prime + ($labelNameLengthLimit == null ? 43 : $labelNameLengthLimit.hashCode());
        Object $labelValueLengthLimit = this.getLabelValueLengthLimit();
        result = result * prime + ($labelValueLengthLimit == null ? 43 : $labelValueLengthLimit.hashCode());
        Object $lightSailSDConfigs = this.getLightSailSDConfigs();
        result = result * prime + ($lightSailSDConfigs == null ? 43 : $lightSailSDConfigs.hashCode());
        Object $linodeSDConfigs = this.getLinodeSDConfigs();
        result = result * prime + ($linodeSDConfigs == null ? 43 : $linodeSDConfigs.hashCode());
        Object $metricRelabelings = this.getMetricRelabelings();
        result = result * prime + ($metricRelabelings == null ? 43 : $metricRelabelings.hashCode());
        Object $metricsPath = this.getMetricsPath();
        result = result * prime + ($metricsPath == null ? 43 : $metricsPath.hashCode());
        Object $nameEscapingScheme = this.getNameEscapingScheme();
        result = result * prime + ($nameEscapingScheme == null ? 43 : $nameEscapingScheme.hashCode());
        Object $nameValidationScheme = this.getNameValidationScheme();
        result = result * prime + ($nameValidationScheme == null ? 43 : $nameValidationScheme.hashCode());
        Object $nativeHistogramBucketLimit = this.getNativeHistogramBucketLimit();
        result = result * prime + ($nativeHistogramBucketLimit == null ? 43 : $nativeHistogramBucketLimit.hashCode());
        Object $nativeHistogramMinBucketFactor = this.getNativeHistogramMinBucketFactor();
        result = result * prime + ($nativeHistogramMinBucketFactor == null ? 43 : $nativeHistogramMinBucketFactor.hashCode());
        Object $noProxy = this.getNoProxy();
        result = result * prime + ($noProxy == null ? 43 : $noProxy.hashCode());
        Object $nomadSDConfigs = this.getNomadSDConfigs();
        result = result * prime + ($nomadSDConfigs == null ? 43 : $nomadSDConfigs.hashCode());
        Object $oauth2 = this.getOauth2();
        result = result * prime + ($oauth2 == null ? 43 : $oauth2.hashCode());
        Object $openstackSDConfigs = this.getOpenstackSDConfigs();
        result = result * prime + ($openstackSDConfigs == null ? 43 : $openstackSDConfigs.hashCode());
        Object $ovhcloudSDConfigs = this.getOvhcloudSDConfigs();
        result = result * prime + ($ovhcloudSDConfigs == null ? 43 : $ovhcloudSDConfigs.hashCode());
        Object $params = this.getParams();
        result = result * prime + ($params == null ? 43 : $params.hashCode());
        Object $proxyConnectHeader = this.getProxyConnectHeader();
        result = result * prime + ($proxyConnectHeader == null ? 43 : $proxyConnectHeader.hashCode());
        Object $proxyFromEnvironment = this.getProxyFromEnvironment();
        result = result * prime + ($proxyFromEnvironment == null ? 43 : $proxyFromEnvironment.hashCode());
        Object $proxyUrl = this.getProxyUrl();
        result = result * prime + ($proxyUrl == null ? 43 : $proxyUrl.hashCode());
        Object $puppetDBSDConfigs = this.getPuppetDBSDConfigs();
        result = result * prime + ($puppetDBSDConfigs == null ? 43 : $puppetDBSDConfigs.hashCode());
        Object $relabelings = this.getRelabelings();
        result = result * prime + ($relabelings == null ? 43 : $relabelings.hashCode());
        Object $sampleLimit = this.getSampleLimit();
        result = result * prime + ($sampleLimit == null ? 43 : $sampleLimit.hashCode());
        Object $scalewaySDConfigs = this.getScalewaySDConfigs();
        result = result * prime + ($scalewaySDConfigs == null ? 43 : $scalewaySDConfigs.hashCode());
        Object $scheme = this.getScheme();
        result = result * prime + ($scheme == null ? 43 : $scheme.hashCode());
        Object $scrapeClass = this.getScrapeClass();
        result = result * prime + ($scrapeClass == null ? 43 : $scrapeClass.hashCode());
        Object $scrapeClassicHistograms = this.getScrapeClassicHistograms();
        result = result * prime + ($scrapeClassicHistograms == null ? 43 : $scrapeClassicHistograms.hashCode());
        Object $scrapeInterval = this.getScrapeInterval();
        result = result * prime + ($scrapeInterval == null ? 43 : $scrapeInterval.hashCode());
        Object $scrapeNativeHistograms = this.getScrapeNativeHistograms();
        result = result * prime + ($scrapeNativeHistograms == null ? 43 : $scrapeNativeHistograms.hashCode());
        Object $scrapeProtocols = this.getScrapeProtocols();
        result = result * prime + ($scrapeProtocols == null ? 43 : $scrapeProtocols.hashCode());
        Object $scrapeTimeout = this.getScrapeTimeout();
        result = result * prime + ($scrapeTimeout == null ? 43 : $scrapeTimeout.hashCode());
        Object $staticConfigs = this.getStaticConfigs();
        result = result * prime + ($staticConfigs == null ? 43 : $staticConfigs.hashCode());
        Object $targetLimit = this.getTargetLimit();
        result = result * prime + ($targetLimit == null ? 43 : $targetLimit.hashCode());
        Object $tlsConfig = this.getTlsConfig();
        result = result * prime + ($tlsConfig == null ? 43 : $tlsConfig.hashCode());
        Object $trackTimestampsStaleness = this.getTrackTimestampsStaleness();
        result = result * prime + ($trackTimestampsStaleness == null ? 43 : $trackTimestampsStaleness.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ScrapeConfigSpec(" + "authorization=" + this.getAuthorization() + ", azureSDConfigs=" + this.getAzureSDConfigs() + ", basicAuth=" + this.getBasicAuth() + ", bodySizeLimit=" + this.getBodySizeLimit() + ", consulSDConfigs=" + this.getConsulSDConfigs() + ", convertClassicHistogramsToNHCB=" + this.getConvertClassicHistogramsToNHCB() + ", digitalOceanSDConfigs=" + this.getDigitalOceanSDConfigs() + ", dnsSDConfigs=" + this.getDnsSDConfigs() + ", dockerSDConfigs=" + this.getDockerSDConfigs() + ", dockerSwarmSDConfigs=" + this.getDockerSwarmSDConfigs() + ", ec2SDConfigs=" + this.getEc2SDConfigs() + ", enableCompression=" + this.getEnableCompression() + ", enableHTTP2=" + this.getEnableHTTP2() + ", eurekaSDConfigs=" + this.getEurekaSDConfigs() + ", fallbackScrapeProtocol=" + this.getFallbackScrapeProtocol() + ", fileSDConfigs=" + this.getFileSDConfigs() + ", gceSDConfigs=" + this.getGceSDConfigs() + ", hetznerSDConfigs=" + this.getHetznerSDConfigs() + ", honorLabels=" + this.getHonorLabels() + ", honorTimestamps=" + this.getHonorTimestamps() + ", httpSDConfigs=" + this.getHttpSDConfigs() + ", ionosSDConfigs=" + this.getIonosSDConfigs() + ", jobName=" + this.getJobName() + ", keepDroppedTargets=" + this.getKeepDroppedTargets() + ", kubernetesSDConfigs=" + this.getKubernetesSDConfigs() + ", kumaSDConfigs=" + this.getKumaSDConfigs() + ", labelLimit=" + this.getLabelLimit() + ", labelNameLengthLimit=" + this.getLabelNameLengthLimit() + ", labelValueLengthLimit=" + this.getLabelValueLengthLimit() + ", lightSailSDConfigs=" + this.getLightSailSDConfigs() + ", linodeSDConfigs=" + this.getLinodeSDConfigs() + ", metricRelabelings=" + this.getMetricRelabelings() + ", metricsPath=" + this.getMetricsPath() + ", nameEscapingScheme=" + this.getNameEscapingScheme() + ", nameValidationScheme=" + this.getNameValidationScheme() + ", nativeHistogramBucketLimit=" + this.getNativeHistogramBucketLimit() + ", nativeHistogramMinBucketFactor=" + this.getNativeHistogramMinBucketFactor() + ", noProxy=" + this.getNoProxy() + ", nomadSDConfigs=" + this.getNomadSDConfigs() + ", oauth2=" + this.getOauth2() + ", openstackSDConfigs=" + this.getOpenstackSDConfigs() + ", ovhcloudSDConfigs=" + this.getOvhcloudSDConfigs() + ", params=" + this.getParams() + ", proxyConnectHeader=" + this.getProxyConnectHeader() + ", proxyFromEnvironment=" + this.getProxyFromEnvironment() + ", proxyUrl=" + this.getProxyUrl() + ", puppetDBSDConfigs=" + this.getPuppetDBSDConfigs() + ", relabelings=" + this.getRelabelings() + ", sampleLimit=" + this.getSampleLimit() + ", scalewaySDConfigs=" + this.getScalewaySDConfigs() + ", scheme=" + this.getScheme() + ", scrapeClass=" + this.getScrapeClass() + ", scrapeClassicHistograms=" + this.getScrapeClassicHistograms() + ", scrapeInterval=" + this.getScrapeInterval() + ", scrapeNativeHistograms=" + this.getScrapeNativeHistograms() + ", scrapeProtocols=" + this.getScrapeProtocols() + ", scrapeTimeout=" + this.getScrapeTimeout() + ", staticConfigs=" + this.getStaticConfigs() + ", targetLimit=" + this.getTargetLimit() + ", tlsConfig=" + this.getTlsConfig() + ", trackTimestampsStaleness=" + this.getTrackTimestampsStaleness() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
