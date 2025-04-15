
package io.fabric8.openshift.api.model.monitoring.v1;

import java.util.LinkedHashMap;
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
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * QuerySpec defines the query command line flags when starting Prometheus.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "lookbackDelta",
    "maxConcurrency",
    "maxSamples",
    "timeout"
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
public class QuerySpec implements Editable<QuerySpecBuilder>, KubernetesResource
{

    @JsonProperty("lookbackDelta")
    private String lookbackDelta;
    @JsonProperty("maxConcurrency")
    private Integer maxConcurrency;
    @JsonProperty("maxSamples")
    private Integer maxSamples;
    @JsonProperty("timeout")
    private String timeout;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public QuerySpec() {
    }

    public QuerySpec(String lookbackDelta, Integer maxConcurrency, Integer maxSamples, String timeout) {
        super();
        this.lookbackDelta = lookbackDelta;
        this.maxConcurrency = maxConcurrency;
        this.maxSamples = maxSamples;
        this.timeout = timeout;
    }

    /**
     * The delta difference allowed for retrieving metrics during expression evaluations.
     */
    @JsonProperty("lookbackDelta")
    public String getLookbackDelta() {
        return lookbackDelta;
    }

    /**
     * The delta difference allowed for retrieving metrics during expression evaluations.
     */
    @JsonProperty("lookbackDelta")
    public void setLookbackDelta(String lookbackDelta) {
        this.lookbackDelta = lookbackDelta;
    }

    /**
     * Number of concurrent queries that can be run at once.
     */
    @JsonProperty("maxConcurrency")
    public Integer getMaxConcurrency() {
        return maxConcurrency;
    }

    /**
     * Number of concurrent queries that can be run at once.
     */
    @JsonProperty("maxConcurrency")
    public void setMaxConcurrency(Integer maxConcurrency) {
        this.maxConcurrency = maxConcurrency;
    }

    /**
     * Maximum number of samples a single query can load into memory. Note that queries will fail if they would load more samples than this into memory, so this also limits the number of samples a query can return.
     */
    @JsonProperty("maxSamples")
    public Integer getMaxSamples() {
        return maxSamples;
    }

    /**
     * Maximum number of samples a single query can load into memory. Note that queries will fail if they would load more samples than this into memory, so this also limits the number of samples a query can return.
     */
    @JsonProperty("maxSamples")
    public void setMaxSamples(Integer maxSamples) {
        this.maxSamples = maxSamples;
    }

    /**
     * Maximum time a query may take before being aborted.
     */
    @JsonProperty("timeout")
    public String getTimeout() {
        return timeout;
    }

    /**
     * Maximum time a query may take before being aborted.
     */
    @JsonProperty("timeout")
    public void setTimeout(String timeout) {
        this.timeout = timeout;
    }

    @JsonIgnore
    public QuerySpecBuilder edit() {
        return new QuerySpecBuilder(this);
    }

    @JsonIgnore
    public QuerySpecBuilder toBuilder() {
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
