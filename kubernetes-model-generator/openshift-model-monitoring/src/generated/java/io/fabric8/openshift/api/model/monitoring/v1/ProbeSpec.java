
package io.fabric8.openshift.api.model.monitoring.v1;

import java.util.HashMap;
import java.util.Map;
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
import lombok.ToString;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "basicAuth",
    "bearerTokenSecret",
    "interval",
    "jobName",
    "module",
    "prober",
    "scrapeTimeout",
    "targets",
    "tlsConfig"
})
@ToString
@EqualsAndHashCode
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
public class ProbeSpec implements KubernetesResource
{

    @JsonProperty("basicAuth")
    private BasicAuth basicAuth;
    @JsonProperty("bearerTokenSecret")
    private SecretKeySelector bearerTokenSecret;
    @JsonProperty("interval")
    private String interval;
    @JsonProperty("jobName")
    private String jobName;
    @JsonProperty("module")
    private String module;
    @JsonProperty("prober")
    private ProberSpec prober;
    @JsonProperty("scrapeTimeout")
    private String scrapeTimeout;
    @JsonProperty("targets")
    private ProbeTargets targets;
    @JsonProperty("tlsConfig")
    private ProbeTLSConfig tlsConfig;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ProbeSpec() {
    }

    /**
     * 
     * @param jobName
     * @param bearerTokenSecret
     * @param scrapeTimeout
     * @param basicAuth
     * @param module
     * @param interval
     * @param prober
     * @param targets
     * @param tlsConfig
     */
    public ProbeSpec(BasicAuth basicAuth, SecretKeySelector bearerTokenSecret, String interval, String jobName, String module, ProberSpec prober, String scrapeTimeout, ProbeTargets targets, ProbeTLSConfig tlsConfig) {
        super();
        this.basicAuth = basicAuth;
        this.bearerTokenSecret = bearerTokenSecret;
        this.interval = interval;
        this.jobName = jobName;
        this.module = module;
        this.prober = prober;
        this.scrapeTimeout = scrapeTimeout;
        this.targets = targets;
        this.tlsConfig = tlsConfig;
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

    @JsonProperty("module")
    public String getModule() {
        return module;
    }

    @JsonProperty("module")
    public void setModule(String module) {
        this.module = module;
    }

    @JsonProperty("prober")
    public ProberSpec getProber() {
        return prober;
    }

    @JsonProperty("prober")
    public void setProber(ProberSpec prober) {
        this.prober = prober;
    }

    @JsonProperty("scrapeTimeout")
    public String getScrapeTimeout() {
        return scrapeTimeout;
    }

    @JsonProperty("scrapeTimeout")
    public void setScrapeTimeout(String scrapeTimeout) {
        this.scrapeTimeout = scrapeTimeout;
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
