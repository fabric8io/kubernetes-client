
package io.fabric8.tekton.triggers.v1alpha1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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

/**
 * BitbucketInterceptor provides a webhook to intercept and pre-process events
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "eventTypes",
    "secretRef"
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
public class BitbucketInterceptor implements Editable<BitbucketInterceptorBuilder>, KubernetesResource
{

    @JsonProperty("eventTypes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> eventTypes = new ArrayList<>();
    @JsonProperty("secretRef")
    private SecretRef secretRef;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public BitbucketInterceptor() {
    }

    public BitbucketInterceptor(List<String> eventTypes, SecretRef secretRef) {
        super();
        this.eventTypes = eventTypes;
        this.secretRef = secretRef;
    }

    /**
     * BitbucketInterceptor provides a webhook to intercept and pre-process events
     */
    @JsonProperty("eventTypes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getEventTypes() {
        return eventTypes;
    }

    /**
     * BitbucketInterceptor provides a webhook to intercept and pre-process events
     */
    @JsonProperty("eventTypes")
    public void setEventTypes(List<String> eventTypes) {
        this.eventTypes = eventTypes;
    }

    /**
     * BitbucketInterceptor provides a webhook to intercept and pre-process events
     */
    @JsonProperty("secretRef")
    public SecretRef getSecretRef() {
        return secretRef;
    }

    /**
     * BitbucketInterceptor provides a webhook to intercept and pre-process events
     */
    @JsonProperty("secretRef")
    public void setSecretRef(SecretRef secretRef) {
        this.secretRef = secretRef;
    }

    @JsonIgnore
    public BitbucketInterceptorBuilder edit() {
        return new BitbucketInterceptorBuilder(this);
    }

    @JsonIgnore
    public BitbucketInterceptorBuilder toBuilder() {
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
        if (!(o instanceof BitbucketInterceptor)) {
            return false;
        }
        BitbucketInterceptor other = (BitbucketInterceptor) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$eventTypes = this.getEventTypes();
        Object other$eventTypes = other.getEventTypes();
        if (this$eventTypes == null ? other$eventTypes != null : !this$eventTypes.equals(other$eventTypes)) {
            return false;
        }
        Object this$secretRef = this.getSecretRef();
        Object other$secretRef = other.getSecretRef();
        if (this$secretRef == null ? other$secretRef != null : !this$secretRef.equals(other$secretRef)) {
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
        return other instanceof BitbucketInterceptor;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $eventTypes = this.getEventTypes();
        result = result * prime + ($eventTypes == null ? 43 : $eventTypes.hashCode());
        Object $secretRef = this.getSecretRef();
        result = result * prime + ($secretRef == null ? 43 : $secretRef.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "BitbucketInterceptor(" + "eventTypes=" + this.getEventTypes() + ", secretRef=" + this.getSecretRef() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
