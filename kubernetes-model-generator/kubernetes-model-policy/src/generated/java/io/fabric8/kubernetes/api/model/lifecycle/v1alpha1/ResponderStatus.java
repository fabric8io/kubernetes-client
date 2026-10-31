
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
import tools.jackson.databind.annotation.JsonDeserialize;

/**
 * ResponderStatus represents the last observed status of the eviction process of the responder. It should be only updated by the designated responder whose name is .name field.
 */
@JsonDeserialize(using = tools.jackson.databind.ValueDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "completionTime",
    "expectedCompletionTime",
    "heartbeatTime",
    "message",
    "name",
    "startTime"
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
public class ResponderStatus implements Editable<ResponderStatusBuilder>, KubernetesResource
{

    @JsonProperty("completionTime")
    private String completionTime;
    @JsonProperty("expectedCompletionTime")
    private String expectedCompletionTime;
    @JsonProperty("heartbeatTime")
    private String heartbeatTime;
    @JsonProperty("message")
    private String message;
    @JsonProperty("name")
    private String name;
    @JsonProperty("startTime")
    private String startTime;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ResponderStatus() {
    }

    public ResponderStatus(String completionTime, String expectedCompletionTime, String heartbeatTime, String message, String name, String startTime) {
        super();
        this.completionTime = completionTime;
        this.expectedCompletionTime = expectedCompletionTime;
        this.heartbeatTime = heartbeatTime;
        this.message = message;
        this.name = name;
        this.startTime = startTime;
    }

    /**
     * ResponderStatus represents the last observed status of the eviction process of the responder. It should be only updated by the designated responder whose name is .name field.
     */
    @JsonProperty("completionTime")
    public String getCompletionTime() {
        return completionTime;
    }

    /**
     * ResponderStatus represents the last observed status of the eviction process of the responder. It should be only updated by the designated responder whose name is .name field.
     */
    @JsonProperty("completionTime")
    public void setCompletionTime(String completionTime) {
        this.completionTime = completionTime;
    }

    /**
     * ResponderStatus represents the last observed status of the eviction process of the responder. It should be only updated by the designated responder whose name is .name field.
     */
    @JsonProperty("expectedCompletionTime")
    public String getExpectedCompletionTime() {
        return expectedCompletionTime;
    }

    /**
     * ResponderStatus represents the last observed status of the eviction process of the responder. It should be only updated by the designated responder whose name is .name field.
     */
    @JsonProperty("expectedCompletionTime")
    public void setExpectedCompletionTime(String expectedCompletionTime) {
        this.expectedCompletionTime = expectedCompletionTime;
    }

    /**
     * ResponderStatus represents the last observed status of the eviction process of the responder. It should be only updated by the designated responder whose name is .name field.
     */
    @JsonProperty("heartbeatTime")
    public String getHeartbeatTime() {
        return heartbeatTime;
    }

    /**
     * ResponderStatus represents the last observed status of the eviction process of the responder. It should be only updated by the designated responder whose name is .name field.
     */
    @JsonProperty("heartbeatTime")
    public void setHeartbeatTime(String heartbeatTime) {
        this.heartbeatTime = heartbeatTime;
    }

    /**
     * message provides human-readable details about the state of the responder and the eviction process. Maximum length is 4000 characters.
     */
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    /**
     * message provides human-readable details about the state of the responder and the eviction process. Maximum length is 4000 characters.
     */
    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * name allows you to identify the responder reacting to the Eviction.<br><p> <br><p> It must be a valid domain-prefixed key (such as "acme.io/foo"). This field is initialized by Kubernetes and must be unique for each responder. This field is required.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * name allows you to identify the responder reacting to the Eviction.<br><p> <br><p> It must be a valid domain-prefixed key (such as "acme.io/foo"). This field is initialized by Kubernetes and must be unique for each responder. This field is required.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * ResponderStatus represents the last observed status of the eviction process of the responder. It should be only updated by the designated responder whose name is .name field.
     */
    @JsonProperty("startTime")
    public String getStartTime() {
        return startTime;
    }

    /**
     * ResponderStatus represents the last observed status of the eviction process of the responder. It should be only updated by the designated responder whose name is .name field.
     */
    @JsonProperty("startTime")
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    @JsonIgnore
    public ResponderStatusBuilder edit() {
        return new ResponderStatusBuilder(this);
    }

    @JsonIgnore
    public ResponderStatusBuilder toBuilder() {
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
