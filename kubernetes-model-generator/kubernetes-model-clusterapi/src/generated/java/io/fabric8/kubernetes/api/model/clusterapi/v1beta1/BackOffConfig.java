
package io.fabric8.kubernetes.api.model.clusterapi.v1beta1;

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
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.Quantity;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * BackOffConfig indicates the back-off config options.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "cloudProviderBackoff",
    "cloudProviderBackoffDuration",
    "cloudProviderBackoffExponent",
    "cloudProviderBackoffJitter",
    "cloudProviderBackoffRetries"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectMeta.class),
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
public class BackOffConfig implements Editable<BackOffConfigBuilder>, KubernetesResource
{

    @JsonProperty("cloudProviderBackoff")
    private Boolean cloudProviderBackoff;
    @JsonProperty("cloudProviderBackoffDuration")
    private Integer cloudProviderBackoffDuration;
    @JsonProperty("cloudProviderBackoffExponent")
    private Quantity cloudProviderBackoffExponent;
    @JsonProperty("cloudProviderBackoffJitter")
    private Quantity cloudProviderBackoffJitter;
    @JsonProperty("cloudProviderBackoffRetries")
    private Integer cloudProviderBackoffRetries;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public BackOffConfig() {
    }

    public BackOffConfig(Boolean cloudProviderBackoff, Integer cloudProviderBackoffDuration, Quantity cloudProviderBackoffExponent, Quantity cloudProviderBackoffJitter, Integer cloudProviderBackoffRetries) {
        super();
        this.cloudProviderBackoff = cloudProviderBackoff;
        this.cloudProviderBackoffDuration = cloudProviderBackoffDuration;
        this.cloudProviderBackoffExponent = cloudProviderBackoffExponent;
        this.cloudProviderBackoffJitter = cloudProviderBackoffJitter;
        this.cloudProviderBackoffRetries = cloudProviderBackoffRetries;
    }

    /**
     * BackOffConfig indicates the back-off config options.
     */
    @JsonProperty("cloudProviderBackoff")
    public Boolean getCloudProviderBackoff() {
        return cloudProviderBackoff;
    }

    /**
     * BackOffConfig indicates the back-off config options.
     */
    @JsonProperty("cloudProviderBackoff")
    public void setCloudProviderBackoff(Boolean cloudProviderBackoff) {
        this.cloudProviderBackoff = cloudProviderBackoff;
    }

    /**
     * BackOffConfig indicates the back-off config options.
     */
    @JsonProperty("cloudProviderBackoffDuration")
    public Integer getCloudProviderBackoffDuration() {
        return cloudProviderBackoffDuration;
    }

    /**
     * BackOffConfig indicates the back-off config options.
     */
    @JsonProperty("cloudProviderBackoffDuration")
    public void setCloudProviderBackoffDuration(Integer cloudProviderBackoffDuration) {
        this.cloudProviderBackoffDuration = cloudProviderBackoffDuration;
    }

    /**
     * BackOffConfig indicates the back-off config options.
     */
    @JsonProperty("cloudProviderBackoffExponent")
    public Quantity getCloudProviderBackoffExponent() {
        return cloudProviderBackoffExponent;
    }

    /**
     * BackOffConfig indicates the back-off config options.
     */
    @JsonProperty("cloudProviderBackoffExponent")
    public void setCloudProviderBackoffExponent(Quantity cloudProviderBackoffExponent) {
        this.cloudProviderBackoffExponent = cloudProviderBackoffExponent;
    }

    /**
     * BackOffConfig indicates the back-off config options.
     */
    @JsonProperty("cloudProviderBackoffJitter")
    public Quantity getCloudProviderBackoffJitter() {
        return cloudProviderBackoffJitter;
    }

    /**
     * BackOffConfig indicates the back-off config options.
     */
    @JsonProperty("cloudProviderBackoffJitter")
    public void setCloudProviderBackoffJitter(Quantity cloudProviderBackoffJitter) {
        this.cloudProviderBackoffJitter = cloudProviderBackoffJitter;
    }

    /**
     * BackOffConfig indicates the back-off config options.
     */
    @JsonProperty("cloudProviderBackoffRetries")
    public Integer getCloudProviderBackoffRetries() {
        return cloudProviderBackoffRetries;
    }

    /**
     * BackOffConfig indicates the back-off config options.
     */
    @JsonProperty("cloudProviderBackoffRetries")
    public void setCloudProviderBackoffRetries(Integer cloudProviderBackoffRetries) {
        this.cloudProviderBackoffRetries = cloudProviderBackoffRetries;
    }

    @JsonIgnore
    public BackOffConfigBuilder edit() {
        return new BackOffConfigBuilder(this);
    }

    @JsonIgnore
    public BackOffConfigBuilder toBuilder() {
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
