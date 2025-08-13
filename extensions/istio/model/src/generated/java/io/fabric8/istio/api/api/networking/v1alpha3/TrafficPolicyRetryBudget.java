
package io.fabric8.istio.api.api.networking.v1alpha3;

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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "minRetryConcurrency",
    "percent"
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
public class TrafficPolicyRetryBudget implements Editable<TrafficPolicyRetryBudgetBuilder>, KubernetesResource
{

    @JsonProperty("minRetryConcurrency")
    private Long minRetryConcurrency;
    @JsonProperty("percent")
    private Double percent;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public TrafficPolicyRetryBudget() {
    }

    public TrafficPolicyRetryBudget(Long minRetryConcurrency, Double percent) {
        super();
        this.minRetryConcurrency = minRetryConcurrency;
        this.percent = percent;
    }

    /**
     * Specifies the minimum retry concurrency allowed for the retry budget. For example, a budget of 20% with a minimum retry concurrency of 3 will allow 5 active retries while there are 25 active requests. If there are 2 active requests, there are still 3 active retries allowed because of the minimum retry concurrency.<br><p> <br><p> Defaults to 3.
     */
    @JsonProperty("minRetryConcurrency")
    public Long getMinRetryConcurrency() {
        return minRetryConcurrency;
    }

    /**
     * Specifies the minimum retry concurrency allowed for the retry budget. For example, a budget of 20% with a minimum retry concurrency of 3 will allow 5 active retries while there are 25 active requests. If there are 2 active requests, there are still 3 active retries allowed because of the minimum retry concurrency.<br><p> <br><p> Defaults to 3.
     */
    @JsonProperty("minRetryConcurrency")
    public void setMinRetryConcurrency(Long minRetryConcurrency) {
        this.minRetryConcurrency = minRetryConcurrency;
    }

    @JsonProperty("percent")
    public Double getPercent() {
        return percent;
    }

    @JsonProperty("percent")
    public void setPercent(Double percent) {
        this.percent = percent;
    }

    @JsonIgnore
    public TrafficPolicyRetryBudgetBuilder edit() {
        return new TrafficPolicyRetryBudgetBuilder(this);
    }

    @JsonIgnore
    public TrafficPolicyRetryBudgetBuilder toBuilder() {
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
