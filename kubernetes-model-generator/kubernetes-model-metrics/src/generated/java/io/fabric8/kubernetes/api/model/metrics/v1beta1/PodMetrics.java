
package io.fabric8.kubernetes.api.model.metrics.v1beta1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.Duration;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.Namespaced;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.PackageSuffix;
import io.fabric8.kubernetes.model.annotation.Version;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import io.sundr.transform.annotations.VelocityTransformation;
import io.sundr.transform.annotations.VelocityTransformations;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "containers",
    "timestamp",
    "window"
})
@ToString
@EqualsAndHashCode
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
@Version("v1beta1")
@Group("metrics.k8s.io")
@PackageSuffix(".metrics.v1beta1")
@VelocityTransformations({
    @VelocityTransformation(value = "/manifest.vm", outputPath = "metrics.properties", gather = true)
})
public class PodMetrics implements HasMetadata, Namespaced
{

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("apiVersion")
    private java.lang.String apiVersion = "metrics.k8s.io/v1beta1";
    @JsonProperty("containers")
    private List<ContainerMetrics> containers = new ArrayList<ContainerMetrics>();
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("kind")
    private java.lang.String kind = "PodMetrics";
    @JsonProperty("metadata")
    private io.fabric8.kubernetes.api.model.ObjectMeta metadata;
    @JsonProperty("timestamp")
    private String timestamp;
    @JsonProperty("window")
    private Duration window;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new HashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public PodMetrics() {
    }

    /**
     * 
     * @param metadata
     * @param apiVersion
     * @param kind
     * @param containers
     * @param window
     * @param timestamp
     */
    public PodMetrics(java.lang.String apiVersion, List<ContainerMetrics> containers, java.lang.String kind, io.fabric8.kubernetes.api.model.ObjectMeta metadata, String timestamp, Duration window) {
        super();
        this.apiVersion = apiVersion;
        this.containers = containers;
        this.kind = kind;
        this.metadata = metadata;
        this.timestamp = timestamp;
        this.window = window;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("apiVersion")
    public java.lang.String getApiVersion() {
        return apiVersion;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("apiVersion")
    public void setApiVersion(java.lang.String apiVersion) {
        this.apiVersion = apiVersion;
    }

    @JsonProperty("containers")
    public List<ContainerMetrics> getContainers() {
        return containers;
    }

    @JsonProperty("containers")
    public void setContainers(List<ContainerMetrics> containers) {
        this.containers = containers;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("kind")
    public java.lang.String getKind() {
        return kind;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("kind")
    public void setKind(java.lang.String kind) {
        this.kind = kind;
    }

    @JsonProperty("metadata")
    public io.fabric8.kubernetes.api.model.ObjectMeta getMetadata() {
        return metadata;
    }

    @JsonProperty("metadata")
    public void setMetadata(io.fabric8.kubernetes.api.model.ObjectMeta metadata) {
        this.metadata = metadata;
    }

    @JsonProperty("timestamp")
    public String getTimestamp() {
        return timestamp;
    }

    @JsonProperty("timestamp")
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @JsonProperty("window")
    public Duration getWindow() {
        return window;
    }

    @JsonProperty("window")
    public void setWindow(Duration window) {
        this.window = window;
    }

    @JsonAnyGetter
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
