
package io.fabric8.kubernetes.api.model.lifecycle.v1alpha1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.Namespaced;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;
import tools.jackson.databind.annotation.JsonDeserialize;

/**
 * EvictionRequest defines a request that should ideally result in a graceful eviction of a .spec.target (e.g. termination of a pod).<br><p> <br><p> The evictionrequest-controller observes intents of all EvictionRequests and transforms them into Evictions.<br><p>   - .spec.requester is set as a label on the Eviction for easier lookup.<br><p>   - Each target can have a set of responders assigned to it. Eviction objects are observed by<br><p>     these responders, who implement the eviction logic and update the Eviction's status with<br><p>     progress.<br><p> <br><p> There is many-to-many relationship between EvictionRequests and Evictions in general. And many-to-one if the target is a  pod.<br><p> <br><p> If all requesters withdraw their eviction intent for a common target, the eviction will be canceled. Deleting an EvictionRequest also counts as a withdrawal. Once all EvictionRequest of a target are removed, the corresponding Evictions are eventually garbage collected.
 */
@JsonDeserialize(using = tools.jackson.databind.ValueDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "spec",
    "status"
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
@Version("v1alpha1")
@Group("lifecycle.k8s.io")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class EvictionRequest implements Editable<EvictionRequestBuilder>, HasMetadata, Namespaced
{

    @JsonProperty("apiVersion")
    private String apiVersion = "lifecycle.k8s.io/v1alpha1";
    @JsonProperty("kind")
    private String kind = "EvictionRequest";
    @JsonProperty("metadata")
    private ObjectMeta metadata;
    @JsonProperty("spec")
    private EvictionRequestSpec spec;
    @JsonProperty("status")
    private EvictionRequestStatus status;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public EvictionRequest() {
    }

    public EvictionRequest(String apiVersion, String kind, ObjectMeta metadata, EvictionRequestSpec spec, EvictionRequestStatus status) {
        super();
        this.apiVersion = apiVersion;
        this.kind = kind;
        this.metadata = metadata;
        this.spec = spec;
        this.status = status;
    }

    /**
     * APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
     */
    @JsonProperty("apiVersion")
    public String getApiVersion() {
        return apiVersion;
    }

    /**
     * APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
     */
    @JsonProperty("apiVersion")
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    /**
     * Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
     */
    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    /**
     * Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
     */
    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     * EvictionRequest defines a request that should ideally result in a graceful eviction of a .spec.target (e.g. termination of a pod).<br><p> <br><p> The evictionrequest-controller observes intents of all EvictionRequests and transforms them into Evictions.<br><p>   - .spec.requester is set as a label on the Eviction for easier lookup.<br><p>   - Each target can have a set of responders assigned to it. Eviction objects are observed by<br><p>     these responders, who implement the eviction logic and update the Eviction's status with<br><p>     progress.<br><p> <br><p> There is many-to-many relationship between EvictionRequests and Evictions in general. And many-to-one if the target is a  pod.<br><p> <br><p> If all requesters withdraw their eviction intent for a common target, the eviction will be canceled. Deleting an EvictionRequest also counts as a withdrawal. Once all EvictionRequest of a target are removed, the corresponding Evictions are eventually garbage collected.
     */
    @JsonProperty("metadata")
    public ObjectMeta getMetadata() {
        return metadata;
    }

    /**
     * EvictionRequest defines a request that should ideally result in a graceful eviction of a .spec.target (e.g. termination of a pod).<br><p> <br><p> The evictionrequest-controller observes intents of all EvictionRequests and transforms them into Evictions.<br><p>   - .spec.requester is set as a label on the Eviction for easier lookup.<br><p>   - Each target can have a set of responders assigned to it. Eviction objects are observed by<br><p>     these responders, who implement the eviction logic and update the Eviction's status with<br><p>     progress.<br><p> <br><p> There is many-to-many relationship between EvictionRequests and Evictions in general. And many-to-one if the target is a  pod.<br><p> <br><p> If all requesters withdraw their eviction intent for a common target, the eviction will be canceled. Deleting an EvictionRequest also counts as a withdrawal. Once all EvictionRequest of a target are removed, the corresponding Evictions are eventually garbage collected.
     */
    @JsonProperty("metadata")
    public void setMetadata(ObjectMeta metadata) {
        this.metadata = metadata;
    }

    /**
     * EvictionRequest defines a request that should ideally result in a graceful eviction of a .spec.target (e.g. termination of a pod).<br><p> <br><p> The evictionrequest-controller observes intents of all EvictionRequests and transforms them into Evictions.<br><p>   - .spec.requester is set as a label on the Eviction for easier lookup.<br><p>   - Each target can have a set of responders assigned to it. Eviction objects are observed by<br><p>     these responders, who implement the eviction logic and update the Eviction's status with<br><p>     progress.<br><p> <br><p> There is many-to-many relationship between EvictionRequests and Evictions in general. And many-to-one if the target is a  pod.<br><p> <br><p> If all requesters withdraw their eviction intent for a common target, the eviction will be canceled. Deleting an EvictionRequest also counts as a withdrawal. Once all EvictionRequest of a target are removed, the corresponding Evictions are eventually garbage collected.
     */
    @JsonProperty("spec")
    public EvictionRequestSpec getSpec() {
        return spec;
    }

    /**
     * EvictionRequest defines a request that should ideally result in a graceful eviction of a .spec.target (e.g. termination of a pod).<br><p> <br><p> The evictionrequest-controller observes intents of all EvictionRequests and transforms them into Evictions.<br><p>   - .spec.requester is set as a label on the Eviction for easier lookup.<br><p>   - Each target can have a set of responders assigned to it. Eviction objects are observed by<br><p>     these responders, who implement the eviction logic and update the Eviction's status with<br><p>     progress.<br><p> <br><p> There is many-to-many relationship between EvictionRequests and Evictions in general. And many-to-one if the target is a  pod.<br><p> <br><p> If all requesters withdraw their eviction intent for a common target, the eviction will be canceled. Deleting an EvictionRequest also counts as a withdrawal. Once all EvictionRequest of a target are removed, the corresponding Evictions are eventually garbage collected.
     */
    @JsonProperty("spec")
    public void setSpec(EvictionRequestSpec spec) {
        this.spec = spec;
    }

    /**
     * EvictionRequest defines a request that should ideally result in a graceful eviction of a .spec.target (e.g. termination of a pod).<br><p> <br><p> The evictionrequest-controller observes intents of all EvictionRequests and transforms them into Evictions.<br><p>   - .spec.requester is set as a label on the Eviction for easier lookup.<br><p>   - Each target can have a set of responders assigned to it. Eviction objects are observed by<br><p>     these responders, who implement the eviction logic and update the Eviction's status with<br><p>     progress.<br><p> <br><p> There is many-to-many relationship between EvictionRequests and Evictions in general. And many-to-one if the target is a  pod.<br><p> <br><p> If all requesters withdraw their eviction intent for a common target, the eviction will be canceled. Deleting an EvictionRequest also counts as a withdrawal. Once all EvictionRequest of a target are removed, the corresponding Evictions are eventually garbage collected.
     */
    @JsonProperty("status")
    public EvictionRequestStatus getStatus() {
        return status;
    }

    /**
     * EvictionRequest defines a request that should ideally result in a graceful eviction of a .spec.target (e.g. termination of a pod).<br><p> <br><p> The evictionrequest-controller observes intents of all EvictionRequests and transforms them into Evictions.<br><p>   - .spec.requester is set as a label on the Eviction for easier lookup.<br><p>   - Each target can have a set of responders assigned to it. Eviction objects are observed by<br><p>     these responders, who implement the eviction logic and update the Eviction's status with<br><p>     progress.<br><p> <br><p> There is many-to-many relationship between EvictionRequests and Evictions in general. And many-to-one if the target is a  pod.<br><p> <br><p> If all requesters withdraw their eviction intent for a common target, the eviction will be canceled. Deleting an EvictionRequest also counts as a withdrawal. Once all EvictionRequest of a target are removed, the corresponding Evictions are eventually garbage collected.
     */
    @JsonProperty("status")
    public void setStatus(EvictionRequestStatus status) {
        this.status = status;
    }

    @JsonIgnore
    public EvictionRequestBuilder edit() {
        return new EvictionRequestBuilder(this);
    }

    @JsonIgnore
    public EvictionRequestBuilder toBuilder() {
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
