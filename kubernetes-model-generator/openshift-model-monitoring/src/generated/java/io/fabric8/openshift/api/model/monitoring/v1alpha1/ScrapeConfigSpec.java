
package io.fabric8.openshift.api.model.monitoring.v1alpha1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "authorization",
    "azureSDConfigs",
    "basicAuth",
    "consulSDConfigs",
    "digitalOceanSDConfigs",
    "dnsSDConfigs",
    "dockerSDConfigs",
    "dockerSwarmSDConfigs",
    "ec2SDConfigs",
    "enableCompression",
    "eurekaSDConfigs",
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
@Generated("jsonschema2pojo")
public class ScrapeConfigSpec implements Editable<ScrapeConfigSpecBuilder> , KubernetesResource
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
    @JsonProperty("eurekaSDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<EurekaSDConfig> eurekaSDConfigs = new ArrayList<>();
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
     * 
     */
    public ScrapeConfigSpec() {
    }

    public ScrapeConfigSpec(SafeAuthorization authorization, List<AzureSDConfig> azureSDConfigs, BasicAuth basicAuth, List<ConsulSDConfig> consulSDConfigs, List<DigitalOceanSDConfig> digitalOceanSDConfigs, List<DNSSDConfig> dnsSDConfigs, List<DockerSDConfig> dockerSDConfigs, List<DockerSwarmSDConfig> dockerSwarmSDConfigs, List<EC2SDConfig> ec2SDConfigs, Boolean enableCompression, List<EurekaSDConfig> eurekaSDConfigs, List<FileSDConfig> fileSDConfigs, List<GCESDConfig> gceSDConfigs, List<HetznerSDConfig> hetznerSDConfigs, Boolean honorLabels, Boolean honorTimestamps, List<HTTPSDConfig> httpSDConfigs, List<IonosSDConfig> ionosSDConfigs, String jobName, Long keepDroppedTargets, List<KubernetesSDConfig> kubernetesSDConfigs, List<KumaSDConfig> kumaSDConfigs, Long labelLimit, Long labelNameLengthLimit, Long labelValueLengthLimit, List<LightSailSDConfig> lightSailSDConfigs, List<LinodeSDConfig> linodeSDConfigs, List<RelabelConfig> metricRelabelings, String metricsPath, String noProxy, List<NomadSDConfig> nomadSDConfigs, OAuth2 oauth2, List<OpenStackSDConfig> openstackSDConfigs, List<OVHCloudSDConfig> ovhcloudSDConfigs, Map<String, List<String>> params, Map<String, List<SecretKeySelector>> proxyConnectHeader, Boolean proxyFromEnvironment, String proxyUrl, List<PuppetDBSDConfig> puppetDBSDConfigs, List<RelabelConfig> relabelings, Long sampleLimit, List<ScalewaySDConfig> scalewaySDConfigs, String scheme, String scrapeClass, String scrapeInterval, List<String> scrapeProtocols, String scrapeTimeout, List<StaticConfig> staticConfigs, Long targetLimit, SafeTLSConfig tlsConfig, Boolean trackTimestampsStaleness) {
        super();
        this.authorization = authorization;
        this.azureSDConfigs = azureSDConfigs;
        this.basicAuth = basicAuth;
        this.consulSDConfigs = consulSDConfigs;
        this.digitalOceanSDConfigs = digitalOceanSDConfigs;
        this.dnsSDConfigs = dnsSDConfigs;
        this.dockerSDConfigs = dockerSDConfigs;
        this.dockerSwarmSDConfigs = dockerSwarmSDConfigs;
        this.ec2SDConfigs = ec2SDConfigs;
        this.enableCompression = enableCompression;
        this.eurekaSDConfigs = eurekaSDConfigs;
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
        this.scrapeInterval = scrapeInterval;
        this.scrapeProtocols = scrapeProtocols;
        this.scrapeTimeout = scrapeTimeout;
        this.staticConfigs = staticConfigs;
        this.targetLimit = targetLimit;
        this.tlsConfig = tlsConfig;
        this.trackTimestampsStaleness = trackTimestampsStaleness;
    }

    @JsonProperty("authorization")
    public SafeAuthorization getAuthorization() {
        return authorization;
    }

    @JsonProperty("authorization")
    public void setAuthorization(SafeAuthorization authorization) {
        this.authorization = authorization;
    }

    @JsonProperty("azureSDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<AzureSDConfig> getAzureSDConfigs() {
        return azureSDConfigs;
    }

    @JsonProperty("azureSDConfigs")
    public void setAzureSDConfigs(List<AzureSDConfig> azureSDConfigs) {
        this.azureSDConfigs = azureSDConfigs;
    }

    @JsonProperty("basicAuth")
    public BasicAuth getBasicAuth() {
        return basicAuth;
    }

    @JsonProperty("basicAuth")
    public void setBasicAuth(BasicAuth basicAuth) {
        this.basicAuth = basicAuth;
    }

    @JsonProperty("consulSDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ConsulSDConfig> getConsulSDConfigs() {
        return consulSDConfigs;
    }

    @JsonProperty("consulSDConfigs")
    public void setConsulSDConfigs(List<ConsulSDConfig> consulSDConfigs) {
        this.consulSDConfigs = consulSDConfigs;
    }

    @JsonProperty("digitalOceanSDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<DigitalOceanSDConfig> getDigitalOceanSDConfigs() {
        return digitalOceanSDConfigs;
    }

    @JsonProperty("digitalOceanSDConfigs")
    public void setDigitalOceanSDConfigs(List<DigitalOceanSDConfig> digitalOceanSDConfigs) {
        this.digitalOceanSDConfigs = digitalOceanSDConfigs;
    }

    @JsonProperty("dnsSDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<DNSSDConfig> getDnsSDConfigs() {
        return dnsSDConfigs;
    }

    @JsonProperty("dnsSDConfigs")
    public void setDnsSDConfigs(List<DNSSDConfig> dnsSDConfigs) {
        this.dnsSDConfigs = dnsSDConfigs;
    }

    @JsonProperty("dockerSDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<DockerSDConfig> getDockerSDConfigs() {
        return dockerSDConfigs;
    }

    @JsonProperty("dockerSDConfigs")
    public void setDockerSDConfigs(List<DockerSDConfig> dockerSDConfigs) {
        this.dockerSDConfigs = dockerSDConfigs;
    }

    @JsonProperty("dockerSwarmSDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<DockerSwarmSDConfig> getDockerSwarmSDConfigs() {
        return dockerSwarmSDConfigs;
    }

    @JsonProperty("dockerSwarmSDConfigs")
    public void setDockerSwarmSDConfigs(List<DockerSwarmSDConfig> dockerSwarmSDConfigs) {
        this.dockerSwarmSDConfigs = dockerSwarmSDConfigs;
    }

    @JsonProperty("ec2SDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<EC2SDConfig> getEc2SDConfigs() {
        return ec2SDConfigs;
    }

    @JsonProperty("ec2SDConfigs")
    public void setEc2SDConfigs(List<EC2SDConfig> ec2SDConfigs) {
        this.ec2SDConfigs = ec2SDConfigs;
    }

    @JsonProperty("enableCompression")
    public Boolean getEnableCompression() {
        return enableCompression;
    }

    @JsonProperty("enableCompression")
    public void setEnableCompression(Boolean enableCompression) {
        this.enableCompression = enableCompression;
    }

    @JsonProperty("eurekaSDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<EurekaSDConfig> getEurekaSDConfigs() {
        return eurekaSDConfigs;
    }

    @JsonProperty("eurekaSDConfigs")
    public void setEurekaSDConfigs(List<EurekaSDConfig> eurekaSDConfigs) {
        this.eurekaSDConfigs = eurekaSDConfigs;
    }

    @JsonProperty("fileSDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<FileSDConfig> getFileSDConfigs() {
        return fileSDConfigs;
    }

    @JsonProperty("fileSDConfigs")
    public void setFileSDConfigs(List<FileSDConfig> fileSDConfigs) {
        this.fileSDConfigs = fileSDConfigs;
    }

    @JsonProperty("gceSDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<GCESDConfig> getGceSDConfigs() {
        return gceSDConfigs;
    }

    @JsonProperty("gceSDConfigs")
    public void setGceSDConfigs(List<GCESDConfig> gceSDConfigs) {
        this.gceSDConfigs = gceSDConfigs;
    }

    @JsonProperty("hetznerSDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<HetznerSDConfig> getHetznerSDConfigs() {
        return hetznerSDConfigs;
    }

    @JsonProperty("hetznerSDConfigs")
    public void setHetznerSDConfigs(List<HetznerSDConfig> hetznerSDConfigs) {
        this.hetznerSDConfigs = hetznerSDConfigs;
    }

    @JsonProperty("honorLabels")
    public Boolean getHonorLabels() {
        return honorLabels;
    }

    @JsonProperty("honorLabels")
    public void setHonorLabels(Boolean honorLabels) {
        this.honorLabels = honorLabels;
    }

    @JsonProperty("honorTimestamps")
    public Boolean getHonorTimestamps() {
        return honorTimestamps;
    }

    @JsonProperty("honorTimestamps")
    public void setHonorTimestamps(Boolean honorTimestamps) {
        this.honorTimestamps = honorTimestamps;
    }

    @JsonProperty("httpSDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<HTTPSDConfig> getHttpSDConfigs() {
        return httpSDConfigs;
    }

    @JsonProperty("httpSDConfigs")
    public void setHttpSDConfigs(List<HTTPSDConfig> httpSDConfigs) {
        this.httpSDConfigs = httpSDConfigs;
    }

    @JsonProperty("ionosSDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<IonosSDConfig> getIonosSDConfigs() {
        return ionosSDConfigs;
    }

    @JsonProperty("ionosSDConfigs")
    public void setIonosSDConfigs(List<IonosSDConfig> ionosSDConfigs) {
        this.ionosSDConfigs = ionosSDConfigs;
    }

    @JsonProperty("jobName")
    public String getJobName() {
        return jobName;
    }

    @JsonProperty("jobName")
    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    @JsonProperty("keepDroppedTargets")
    public Long getKeepDroppedTargets() {
        return keepDroppedTargets;
    }

    @JsonProperty("keepDroppedTargets")
    public void setKeepDroppedTargets(Long keepDroppedTargets) {
        this.keepDroppedTargets = keepDroppedTargets;
    }

    @JsonProperty("kubernetesSDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<KubernetesSDConfig> getKubernetesSDConfigs() {
        return kubernetesSDConfigs;
    }

    @JsonProperty("kubernetesSDConfigs")
    public void setKubernetesSDConfigs(List<KubernetesSDConfig> kubernetesSDConfigs) {
        this.kubernetesSDConfigs = kubernetesSDConfigs;
    }

    @JsonProperty("kumaSDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<KumaSDConfig> getKumaSDConfigs() {
        return kumaSDConfigs;
    }

    @JsonProperty("kumaSDConfigs")
    public void setKumaSDConfigs(List<KumaSDConfig> kumaSDConfigs) {
        this.kumaSDConfigs = kumaSDConfigs;
    }

    @JsonProperty("labelLimit")
    public Long getLabelLimit() {
        return labelLimit;
    }

    @JsonProperty("labelLimit")
    public void setLabelLimit(Long labelLimit) {
        this.labelLimit = labelLimit;
    }

    @JsonProperty("labelNameLengthLimit")
    public Long getLabelNameLengthLimit() {
        return labelNameLengthLimit;
    }

    @JsonProperty("labelNameLengthLimit")
    public void setLabelNameLengthLimit(Long labelNameLengthLimit) {
        this.labelNameLengthLimit = labelNameLengthLimit;
    }

    @JsonProperty("labelValueLengthLimit")
    public Long getLabelValueLengthLimit() {
        return labelValueLengthLimit;
    }

    @JsonProperty("labelValueLengthLimit")
    public void setLabelValueLengthLimit(Long labelValueLengthLimit) {
        this.labelValueLengthLimit = labelValueLengthLimit;
    }

    @JsonProperty("lightSailSDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<LightSailSDConfig> getLightSailSDConfigs() {
        return lightSailSDConfigs;
    }

    @JsonProperty("lightSailSDConfigs")
    public void setLightSailSDConfigs(List<LightSailSDConfig> lightSailSDConfigs) {
        this.lightSailSDConfigs = lightSailSDConfigs;
    }

    @JsonProperty("linodeSDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<LinodeSDConfig> getLinodeSDConfigs() {
        return linodeSDConfigs;
    }

    @JsonProperty("linodeSDConfigs")
    public void setLinodeSDConfigs(List<LinodeSDConfig> linodeSDConfigs) {
        this.linodeSDConfigs = linodeSDConfigs;
    }

    @JsonProperty("metricRelabelings")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<RelabelConfig> getMetricRelabelings() {
        return metricRelabelings;
    }

    @JsonProperty("metricRelabelings")
    public void setMetricRelabelings(List<RelabelConfig> metricRelabelings) {
        this.metricRelabelings = metricRelabelings;
    }

    @JsonProperty("metricsPath")
    public String getMetricsPath() {
        return metricsPath;
    }

    @JsonProperty("metricsPath")
    public void setMetricsPath(String metricsPath) {
        this.metricsPath = metricsPath;
    }

    @JsonProperty("noProxy")
    public String getNoProxy() {
        return noProxy;
    }

    @JsonProperty("noProxy")
    public void setNoProxy(String noProxy) {
        this.noProxy = noProxy;
    }

    @JsonProperty("nomadSDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<NomadSDConfig> getNomadSDConfigs() {
        return nomadSDConfigs;
    }

    @JsonProperty("nomadSDConfigs")
    public void setNomadSDConfigs(List<NomadSDConfig> nomadSDConfigs) {
        this.nomadSDConfigs = nomadSDConfigs;
    }

    @JsonProperty("oauth2")
    public OAuth2 getOauth2() {
        return oauth2;
    }

    @JsonProperty("oauth2")
    public void setOauth2(OAuth2 oauth2) {
        this.oauth2 = oauth2;
    }

    @JsonProperty("openstackSDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<OpenStackSDConfig> getOpenstackSDConfigs() {
        return openstackSDConfigs;
    }

    @JsonProperty("openstackSDConfigs")
    public void setOpenstackSDConfigs(List<OpenStackSDConfig> openstackSDConfigs) {
        this.openstackSDConfigs = openstackSDConfigs;
    }

    @JsonProperty("ovhcloudSDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<OVHCloudSDConfig> getOvhcloudSDConfigs() {
        return ovhcloudSDConfigs;
    }

    @JsonProperty("ovhcloudSDConfigs")
    public void setOvhcloudSDConfigs(List<OVHCloudSDConfig> ovhcloudSDConfigs) {
        this.ovhcloudSDConfigs = ovhcloudSDConfigs;
    }

    @JsonProperty("params")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, List<String>> getParams() {
        return params;
    }

    @JsonProperty("params")
    public void setParams(Map<String, List<String>> params) {
        this.params = params;
    }

    @JsonProperty("proxyConnectHeader")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, List<SecretKeySelector>> getProxyConnectHeader() {
        return proxyConnectHeader;
    }

    @JsonProperty("proxyConnectHeader")
    public void setProxyConnectHeader(Map<String, List<SecretKeySelector>> proxyConnectHeader) {
        this.proxyConnectHeader = proxyConnectHeader;
    }

    @JsonProperty("proxyFromEnvironment")
    public Boolean getProxyFromEnvironment() {
        return proxyFromEnvironment;
    }

    @JsonProperty("proxyFromEnvironment")
    public void setProxyFromEnvironment(Boolean proxyFromEnvironment) {
        this.proxyFromEnvironment = proxyFromEnvironment;
    }

    @JsonProperty("proxyUrl")
    public String getProxyUrl() {
        return proxyUrl;
    }

    @JsonProperty("proxyUrl")
    public void setProxyUrl(String proxyUrl) {
        this.proxyUrl = proxyUrl;
    }

    @JsonProperty("puppetDBSDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PuppetDBSDConfig> getPuppetDBSDConfigs() {
        return puppetDBSDConfigs;
    }

    @JsonProperty("puppetDBSDConfigs")
    public void setPuppetDBSDConfigs(List<PuppetDBSDConfig> puppetDBSDConfigs) {
        this.puppetDBSDConfigs = puppetDBSDConfigs;
    }

    @JsonProperty("relabelings")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<RelabelConfig> getRelabelings() {
        return relabelings;
    }

    @JsonProperty("relabelings")
    public void setRelabelings(List<RelabelConfig> relabelings) {
        this.relabelings = relabelings;
    }

    @JsonProperty("sampleLimit")
    public Long getSampleLimit() {
        return sampleLimit;
    }

    @JsonProperty("sampleLimit")
    public void setSampleLimit(Long sampleLimit) {
        this.sampleLimit = sampleLimit;
    }

    @JsonProperty("scalewaySDConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ScalewaySDConfig> getScalewaySDConfigs() {
        return scalewaySDConfigs;
    }

    @JsonProperty("scalewaySDConfigs")
    public void setScalewaySDConfigs(List<ScalewaySDConfig> scalewaySDConfigs) {
        this.scalewaySDConfigs = scalewaySDConfigs;
    }

    @JsonProperty("scheme")
    public String getScheme() {
        return scheme;
    }

    @JsonProperty("scheme")
    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    @JsonProperty("scrapeClass")
    public String getScrapeClass() {
        return scrapeClass;
    }

    @JsonProperty("scrapeClass")
    public void setScrapeClass(String scrapeClass) {
        this.scrapeClass = scrapeClass;
    }

    @JsonProperty("scrapeInterval")
    public String getScrapeInterval() {
        return scrapeInterval;
    }

    @JsonProperty("scrapeInterval")
    public void setScrapeInterval(String scrapeInterval) {
        this.scrapeInterval = scrapeInterval;
    }

    @JsonProperty("scrapeProtocols")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getScrapeProtocols() {
        return scrapeProtocols;
    }

    @JsonProperty("scrapeProtocols")
    public void setScrapeProtocols(List<String> scrapeProtocols) {
        this.scrapeProtocols = scrapeProtocols;
    }

    @JsonProperty("scrapeTimeout")
    public String getScrapeTimeout() {
        return scrapeTimeout;
    }

    @JsonProperty("scrapeTimeout")
    public void setScrapeTimeout(String scrapeTimeout) {
        this.scrapeTimeout = scrapeTimeout;
    }

    @JsonProperty("staticConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<StaticConfig> getStaticConfigs() {
        return staticConfigs;
    }

    @JsonProperty("staticConfigs")
    public void setStaticConfigs(List<StaticConfig> staticConfigs) {
        this.staticConfigs = staticConfigs;
    }

    @JsonProperty("targetLimit")
    public Long getTargetLimit() {
        return targetLimit;
    }

    @JsonProperty("targetLimit")
    public void setTargetLimit(Long targetLimit) {
        this.targetLimit = targetLimit;
    }

    @JsonProperty("tlsConfig")
    public SafeTLSConfig getTlsConfig() {
        return tlsConfig;
    }

    @JsonProperty("tlsConfig")
    public void setTlsConfig(SafeTLSConfig tlsConfig) {
        this.tlsConfig = tlsConfig;
    }

    @JsonProperty("trackTimestampsStaleness")
    public Boolean getTrackTimestampsStaleness() {
        return trackTimestampsStaleness;
    }

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
