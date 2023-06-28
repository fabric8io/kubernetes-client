
package io.fabric8.kubernetes.api.model.storage.v1beta1;

import java.util.LinkedHashMap;
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
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.Namespaced;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.Quantity;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import io.sundr.transform.annotations.TemplateTransformation;
import io.sundr.transform.annotations.TemplateTransformations;
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
    "capacity",
    "maximumVolumeSize",
    "nodeTopology",
    "storageClassName"
})
@ToString
@EqualsAndHashCode
@Setter
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectMeta.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
@TemplateTransformations({
    @TemplateTransformation(value = "/manifest.vm", outputPath = "META-INF/services/io.fabric8.kubernetes.api.model.KubernetesResource", gather = true)
})
@Version("v1beta1")
@Group("storage.k8s.io")
@Generated("jsonschema2pojo")
public class CSIStorageCapacity implements HasMetadata, Namespaced
{

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("apiVersion")
    private String apiVersion = "storage.k8s.io/v1beta1";
    @JsonProperty("capacity")
    private Quantity capacity;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("kind")
    private String kind = "CSIStorageCapacity";
    @JsonProperty("maximumVolumeSize")
    private Quantity maximumVolumeSize;
    @JsonProperty("metadata")
    private io.fabric8.kubernetes.api.model.ObjectMeta metadata;
    @JsonProperty("nodeTopology")
    private io.fabric8.kubernetes.api.model.LabelSelector nodeTopology;
    @JsonProperty("storageClassName")
    private String storageClassName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public CSIStorageCapacity() {
    }

    public CSIStorageCapacity(String apiVersion, Quantity capacity, String kind, Quantity maximumVolumeSize, io.fabric8.kubernetes.api.model.ObjectMeta metadata, io.fabric8.kubernetes.api.model.LabelSelector nodeTopology, String storageClassName) {
        super();
        this.apiVersion = apiVersion;
        this.capacity = capacity;
        this.kind = kind;
        this.maximumVolumeSize = maximumVolumeSize;
        this.metadata = metadata;
        this.nodeTopology = nodeTopology;
        this.storageClassName = storageClassName;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("apiVersion")
    public String getApiVersion() {
        return apiVersion;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("apiVersion")
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    @JsonProperty("capacity")
    public Quantity getCapacity() {
        return capacity;
    }

    @JsonProperty("capacity")
    public void setCapacity(Quantity capacity) {
        this.capacity = capacity;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    @JsonProperty("maximumVolumeSize")
    public Quantity getMaximumVolumeSize() {
        return maximumVolumeSize;
    }

    @JsonProperty("maximumVolumeSize")
    public void setMaximumVolumeSize(Quantity maximumVolumeSize) {
        this.maximumVolumeSize = maximumVolumeSize;
    }

    @JsonProperty("metadata")
    public io.fabric8.kubernetes.api.model.ObjectMeta getMetadata() {
        return metadata;
    }

    @JsonProperty("metadata")
    public void setMetadata(io.fabric8.kubernetes.api.model.ObjectMeta metadata) {
        this.metadata = metadata;
    }

    @JsonProperty("nodeTopology")
    public io.fabric8.kubernetes.api.model.LabelSelector getNodeTopology() {
        return nodeTopology;
    }

    @JsonProperty("nodeTopology")
    public void setNodeTopology(io.fabric8.kubernetes.api.model.LabelSelector nodeTopology) {
        this.nodeTopology = nodeTopology;
    }

    @JsonProperty("storageClassName")
    public String getStorageClassName() {
        return storageClassName;
    }

    @JsonProperty("storageClassName")
    public void setStorageClassName(String storageClassName) {
        this.storageClassName = storageClassName;
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
