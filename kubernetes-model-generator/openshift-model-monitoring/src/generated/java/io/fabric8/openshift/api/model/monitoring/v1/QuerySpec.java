
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
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

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
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
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
     * lookbackDelta defines the delta difference allowed for retrieving metrics during expression evaluations.
     */
    @JsonProperty("lookbackDelta")
    public String getLookbackDelta() {
        return lookbackDelta;
    }

    /**
     * lookbackDelta defines the delta difference allowed for retrieving metrics during expression evaluations.
     */
    @JsonProperty("lookbackDelta")
    public void setLookbackDelta(String lookbackDelta) {
        this.lookbackDelta = lookbackDelta;
    }

    /**
     * maxConcurrency defines the number of concurrent queries that can be run at once.
     */
    @JsonProperty("maxConcurrency")
    public Integer getMaxConcurrency() {
        return maxConcurrency;
    }

    /**
     * maxConcurrency defines the number of concurrent queries that can be run at once.
     */
    @JsonProperty("maxConcurrency")
    public void setMaxConcurrency(Integer maxConcurrency) {
        this.maxConcurrency = maxConcurrency;
    }

    /**
     * maxSamples defines the maximum number of samples a single query can load into memory. Note that queries will fail if they would load more samples than this into memory, so this also limits the number of samples a query can return.
     */
    @JsonProperty("maxSamples")
    public Integer getMaxSamples() {
        return maxSamples;
    }

    /**
     * maxSamples defines the maximum number of samples a single query can load into memory. Note that queries will fail if they would load more samples than this into memory, so this also limits the number of samples a query can return.
     */
    @JsonProperty("maxSamples")
    public void setMaxSamples(Integer maxSamples) {
        this.maxSamples = maxSamples;
    }

    /**
     * timeout defines the maximum time a query may take before being aborted.
     */
    @JsonProperty("timeout")
    public String getTimeout() {
        return timeout;
    }

    /**
     * timeout defines the maximum time a query may take before being aborted.
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
        if (!(o instanceof QuerySpec)) {
            return false;
        }
        QuerySpec other = (QuerySpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$lookbackDelta = this.getLookbackDelta();
        Object other$lookbackDelta = other.getLookbackDelta();
        if (this$lookbackDelta == null ? other$lookbackDelta != null : !this$lookbackDelta.equals(other$lookbackDelta)) {
            return false;
        }
        Object this$maxConcurrency = this.getMaxConcurrency();
        Object other$maxConcurrency = other.getMaxConcurrency();
        if (this$maxConcurrency == null ? other$maxConcurrency != null : !this$maxConcurrency.equals(other$maxConcurrency)) {
            return false;
        }
        Object this$maxSamples = this.getMaxSamples();
        Object other$maxSamples = other.getMaxSamples();
        if (this$maxSamples == null ? other$maxSamples != null : !this$maxSamples.equals(other$maxSamples)) {
            return false;
        }
        Object this$timeout = this.getTimeout();
        Object other$timeout = other.getTimeout();
        if (this$timeout == null ? other$timeout != null : !this$timeout.equals(other$timeout)) {
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
        return other instanceof QuerySpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $lookbackDelta = this.getLookbackDelta();
        result = result * prime + ($lookbackDelta == null ? 43 : $lookbackDelta.hashCode());
        Object $maxConcurrency = this.getMaxConcurrency();
        result = result * prime + ($maxConcurrency == null ? 43 : $maxConcurrency.hashCode());
        Object $maxSamples = this.getMaxSamples();
        result = result * prime + ($maxSamples == null ? 43 : $maxSamples.hashCode());
        Object $timeout = this.getTimeout();
        result = result * prime + ($timeout == null ? 43 : $timeout.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "QuerySpec(" + "lookbackDelta=" + this.getLookbackDelta() + ", maxConcurrency=" + this.getMaxConcurrency() + ", maxSamples=" + this.getMaxSamples() + ", timeout=" + this.getTimeout() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
