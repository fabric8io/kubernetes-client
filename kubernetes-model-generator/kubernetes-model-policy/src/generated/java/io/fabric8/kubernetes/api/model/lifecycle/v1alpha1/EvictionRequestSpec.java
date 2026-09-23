
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
 * EvictionRequestSpec is a specification of an EvictionRequest.
 */
@JsonDeserialize(using = tools.jackson.databind.ValueDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "intent",
    "requester",
    "target"
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
public class EvictionRequestSpec implements Editable<EvictionRequestSpecBuilder>, KubernetesResource
{

    @JsonProperty("intent")
    private String intent;
    @JsonProperty("requester")
    private String requester;
    @JsonProperty("target")
    private EvictionRequestTarget target;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public EvictionRequestSpec() {
    }

    public EvictionRequestSpec(String intent, String requester, EvictionRequestTarget target) {
        super();
        this.intent = intent;
        this.requester = requester;
        this.target = target;
    }

    /**
     * intent specifies the action that should be taken for the specified target.<br><p> <br><p> - Eviction means that the requester is interested in the eviction of the target. - Withdrawn means that the requester is no longer interested in the eviction of the target.<br><p>   If all requesters' intents are withdrawn for a common target, the eviction will be canceled.<br><p>   Cancellation consequences:<br><p>   - Inactive responders will never run.<br><p>   - Active responders are expected to cancel the eviction.<br><p>   - Completed or Interrupted responders should not take any action.
     */
    @JsonProperty("intent")
    public String getIntent() {
        return intent;
    }

    /**
     * intent specifies the action that should be taken for the specified target.<br><p> <br><p> - Eviction means that the requester is interested in the eviction of the target. - Withdrawn means that the requester is no longer interested in the eviction of the target.<br><p>   If all requesters' intents are withdrawn for a common target, the eviction will be canceled.<br><p>   Cancellation consequences:<br><p>   - Inactive responders will never run.<br><p>   - Active responders are expected to cancel the eviction.<br><p>   - Completed or Interrupted responders should not take any action.
     */
    @JsonProperty("intent")
    public void setIntent(String intent) {
        this.intent = intent;
    }

    /**
     * requester allows you to identify the entity, that requested the eviction of the target.<br><p> <br><p> It must be a valid domain-prefixed key (such as "acme.io/foo"). Domain names &#42;.k8s.io and &#42;.kubernetes.io are reserved. This field is required and immutable.
     */
    @JsonProperty("requester")
    public String getRequester() {
        return requester;
    }

    /**
     * requester allows you to identify the entity, that requested the eviction of the target.<br><p> <br><p> It must be a valid domain-prefixed key (such as "acme.io/foo"). Domain names &#42;.k8s.io and &#42;.kubernetes.io are reserved. This field is required and immutable.
     */
    @JsonProperty("requester")
    public void setRequester(String requester) {
        this.requester = requester;
    }

    /**
     * EvictionRequestSpec is a specification of an EvictionRequest.
     */
    @JsonProperty("target")
    public EvictionRequestTarget getTarget() {
        return target;
    }

    /**
     * EvictionRequestSpec is a specification of an EvictionRequest.
     */
    @JsonProperty("target")
    public void setTarget(EvictionRequestTarget target) {
        this.target = target;
    }

    @JsonIgnore
    public EvictionRequestSpecBuilder edit() {
        return new EvictionRequestSpecBuilder(this);
    }

    @JsonIgnore
    public EvictionRequestSpecBuilder toBuilder() {
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
