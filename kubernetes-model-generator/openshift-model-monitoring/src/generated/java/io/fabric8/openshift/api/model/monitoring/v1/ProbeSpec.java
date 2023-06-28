
package io.fabric8.openshift.api.model.monitoring.v1;

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
import io.fabric8.kubernetes.api.model.Container;
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
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "authorization",
    "basicAuth",
    "bearerTokenSecret",
    "interval",
    "jobName",
    "labelLimit",
    "labelNameLengthLimit",
    "labelValueLengthLimit",
    "metricRelabelings",
    "module",
    "oauth2",
    "prober",
    "sampleLimit",
    "scrapeTimeout",
    "targetLimit",
    "targets",
    "tlsConfig"
})
@ToString
@EqualsAndHashCode
@Setter
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class ProbeSpec implements KubernetesResource
{

    @JsonProperty("authorization")
    private SafeAuthorization authorization;
    @JsonProperty("basicAuth")
    private BasicAuth basicAuth;
    @JsonProperty("bearerTokenSecret")
    private SecretKeySelector bearerTokenSecret;
    @JsonProperty("interval")
    private String interval;
    @JsonProperty("jobName")
    private String jobName;
    @JsonProperty("labelLimit")
    private Long labelLimit;
    @JsonProperty("labelNameLengthLimit")
    private Long labelNameLengthLimit;
    @JsonProperty("labelValueLengthLimit")
    private Long labelValueLengthLimit;
    @JsonProperty("metricRelabelings")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<RelabelConfig> metricRelabelings = new ArrayList<RelabelConfig>();
    @JsonProperty("module")
    private String module;
    @JsonProperty("oauth2")
    private OAuth2 oauth2;
    @JsonProperty("prober")
    private ProberSpec prober;
    @JsonProperty("sampleLimit")
    private Long sampleLimit;
    @JsonProperty("scrapeTimeout")
    private String scrapeTimeout;
    @JsonProperty("targetLimit")
    private Long targetLimit;
    @JsonProperty("targets")
    private ProbeTargets targets;
    @JsonProperty("tlsConfig")
    private ProbeTLSConfig tlsConfig;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ProbeSpec() {
    }

    public ProbeSpec(SafeAuthorization authorization, BasicAuth basicAuth, SecretKeySelector bearerTokenSecret, String interval, String jobName, Long labelLimit, Long labelNameLengthLimit, Long labelValueLengthLimit, List<RelabelConfig> metricRelabelings, String module, OAuth2 oauth2, ProberSpec prober, Long sampleLimit, String scrapeTimeout, Long targetLimit, ProbeTargets targets, ProbeTLSConfig tlsConfig) {
        super();
        this.authorization = authorization;
        this.basicAuth = basicAuth;
        this.bearerTokenSecret = bearerTokenSecret;
        this.interval = interval;
        this.jobName = jobName;
        this.labelLimit = labelLimit;
        this.labelNameLengthLimit = labelNameLengthLimit;
        this.labelValueLengthLimit = labelValueLengthLimit;
        this.metricRelabelings = metricRelabelings;
        this.module = module;
        this.oauth2 = oauth2;
        this.prober = prober;
        this.sampleLimit = sampleLimit;
        this.scrapeTimeout = scrapeTimeout;
        this.targetLimit = targetLimit;
        this.targets = targets;
        this.tlsConfig = tlsConfig;
    }

    @JsonProperty("authorization")
    public SafeAuthorization getAuthorization() {
        return authorization;
    }

    @JsonProperty("authorization")
    public void setAuthorization(SafeAuthorization authorization) {
        this.authorization = authorization;
    }

    @JsonProperty("basicAuth")
    public BasicAuth getBasicAuth() {
        return basicAuth;
    }

    @JsonProperty("basicAuth")
    public void setBasicAuth(BasicAuth basicAuth) {
        this.basicAuth = basicAuth;
    }

    @JsonProperty("bearerTokenSecret")
    public SecretKeySelector getBearerTokenSecret() {
        return bearerTokenSecret;
    }

    @JsonProperty("bearerTokenSecret")
    public void setBearerTokenSecret(SecretKeySelector bearerTokenSecret) {
        this.bearerTokenSecret = bearerTokenSecret;
    }

    @JsonProperty("interval")
    public String getInterval() {
        return interval;
    }

    @JsonProperty("interval")
    public void setInterval(String interval) {
        this.interval = interval;
    }

    @JsonProperty("jobName")
    public String getJobName() {
        return jobName;
    }

    @JsonProperty("jobName")
    public void setJobName(String jobName) {
        this.jobName = jobName;
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

    @JsonProperty("metricRelabelings")
    public List<RelabelConfig> getMetricRelabelings() {
        return metricRelabelings;
    }

    @JsonProperty("metricRelabelings")
    public void setMetricRelabelings(List<RelabelConfig> metricRelabelings) {
        this.metricRelabelings = metricRelabelings;
    }

    @JsonProperty("module")
    public String getModule() {
        return module;
    }

    @JsonProperty("module")
    public void setModule(String module) {
        this.module = module;
    }

    @JsonProperty("oauth2")
    public OAuth2 getOauth2() {
        return oauth2;
    }

    @JsonProperty("oauth2")
    public void setOauth2(OAuth2 oauth2) {
        this.oauth2 = oauth2;
    }

    @JsonProperty("prober")
    public ProberSpec getProber() {
        return prober;
    }

    @JsonProperty("prober")
    public void setProber(ProberSpec prober) {
        this.prober = prober;
    }

    @JsonProperty("sampleLimit")
    public Long getSampleLimit() {
        return sampleLimit;
    }

    @JsonProperty("sampleLimit")
    public void setSampleLimit(Long sampleLimit) {
        this.sampleLimit = sampleLimit;
    }

    @JsonProperty("scrapeTimeout")
    public String getScrapeTimeout() {
        return scrapeTimeout;
    }

    @JsonProperty("scrapeTimeout")
    public void setScrapeTimeout(String scrapeTimeout) {
        this.scrapeTimeout = scrapeTimeout;
    }

    @JsonProperty("targetLimit")
    public Long getTargetLimit() {
        return targetLimit;
    }

    @JsonProperty("targetLimit")
    public void setTargetLimit(Long targetLimit) {
        this.targetLimit = targetLimit;
    }

    @JsonProperty("targets")
    public ProbeTargets getTargets() {
        return targets;
    }

    @JsonProperty("targets")
    public void setTargets(ProbeTargets targets) {
        this.targets = targets;
    }

    @JsonProperty("tlsConfig")
    public ProbeTLSConfig getTlsConfig() {
        return tlsConfig;
    }

    @JsonProperty("tlsConfig")
    public void setTlsConfig(ProbeTLSConfig tlsConfig) {
        this.tlsConfig = tlsConfig;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
