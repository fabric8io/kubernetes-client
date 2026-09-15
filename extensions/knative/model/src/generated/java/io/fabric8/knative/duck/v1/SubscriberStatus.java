
package io.fabric8.knative.duck.v1;

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

/**
 * SubscriberStatus defines the status of a single subscriber to a Channel.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "auth",
    "message",
    "observedGeneration",
    "ready",
    "uid"
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
public class SubscriberStatus implements Editable<SubscriberStatusBuilder>, KubernetesResource
{

    @JsonProperty("auth")
    private AuthStatus auth;
    @JsonProperty("message")
    private String message;
    @JsonProperty("observedGeneration")
    private Long observedGeneration;
    @JsonProperty("ready")
    private String ready;
    @JsonProperty("uid")
    private String uid;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public SubscriberStatus() {
    }

    public SubscriberStatus(AuthStatus auth, String message, Long observedGeneration, String ready, String uid) {
        super();
        this.auth = auth;
        this.message = message;
        this.observedGeneration = observedGeneration;
        this.ready = ready;
        this.uid = uid;
    }

    /**
     * SubscriberStatus defines the status of a single subscriber to a Channel.
     */
    @JsonProperty("auth")
    public AuthStatus getAuth() {
        return auth;
    }

    /**
     * SubscriberStatus defines the status of a single subscriber to a Channel.
     */
    @JsonProperty("auth")
    public void setAuth(AuthStatus auth) {
        this.auth = auth;
    }

    /**
     * A human readable message indicating details of Ready status.
     */
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    /**
     * A human readable message indicating details of Ready status.
     */
    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Generation of the origin of the subscriber with uid:UID.
     */
    @JsonProperty("observedGeneration")
    public Long getObservedGeneration() {
        return observedGeneration;
    }

    /**
     * Generation of the origin of the subscriber with uid:UID.
     */
    @JsonProperty("observedGeneration")
    public void setObservedGeneration(Long observedGeneration) {
        this.observedGeneration = observedGeneration;
    }

    /**
     * Status of the subscriber.
     */
    @JsonProperty("ready")
    public String getReady() {
        return ready;
    }

    /**
     * Status of the subscriber.
     */
    @JsonProperty("ready")
    public void setReady(String ready) {
        this.ready = ready;
    }

    /**
     * UID is used to understand the origin of the subscriber.
     */
    @JsonProperty("uid")
    public String getUid() {
        return uid;
    }

    /**
     * UID is used to understand the origin of the subscriber.
     */
    @JsonProperty("uid")
    public void setUid(String uid) {
        this.uid = uid;
    }

    @JsonIgnore
    public SubscriberStatusBuilder edit() {
        return new SubscriberStatusBuilder(this);
    }

    @JsonIgnore
    public SubscriberStatusBuilder toBuilder() {
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
        if (!(o instanceof SubscriberStatus)) {
            return false;
        }
        SubscriberStatus other = (SubscriberStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$auth = this.getAuth();
        Object other$auth = other.getAuth();
        if (this$auth == null ? other$auth != null : !this$auth.equals(other$auth)) {
            return false;
        }
        Object this$message = this.getMessage();
        Object other$message = other.getMessage();
        if (this$message == null ? other$message != null : !this$message.equals(other$message)) {
            return false;
        }
        Object this$observedGeneration = this.getObservedGeneration();
        Object other$observedGeneration = other.getObservedGeneration();
        if (this$observedGeneration == null ? other$observedGeneration != null : !this$observedGeneration.equals(other$observedGeneration)) {
            return false;
        }
        Object this$ready = this.getReady();
        Object other$ready = other.getReady();
        if (this$ready == null ? other$ready != null : !this$ready.equals(other$ready)) {
            return false;
        }
        Object this$uid = this.getUid();
        Object other$uid = other.getUid();
        if (this$uid == null ? other$uid != null : !this$uid.equals(other$uid)) {
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
        return other instanceof SubscriberStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $auth = this.getAuth();
        result = result * prime + ($auth == null ? 43 : $auth.hashCode());
        Object $message = this.getMessage();
        result = result * prime + ($message == null ? 43 : $message.hashCode());
        Object $observedGeneration = this.getObservedGeneration();
        result = result * prime + ($observedGeneration == null ? 43 : $observedGeneration.hashCode());
        Object $ready = this.getReady();
        result = result * prime + ($ready == null ? 43 : $ready.hashCode());
        Object $uid = this.getUid();
        result = result * prime + ($uid == null ? 43 : $uid.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "SubscriberStatus(" + "auth=" + this.getAuth() + ", message=" + this.getMessage() + ", observedGeneration=" + this.getObservedGeneration() + ", ready=" + this.getReady() + ", uid=" + this.getUid() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
