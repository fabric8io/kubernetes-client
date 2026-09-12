
package io.fabric8.knative.bindings.v1alpha1;

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
import io.fabric8.knative.pkg.tracker.Reference;
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
 * GitLabBindingSpec holds the desired state of the GitLabBinding (from the client).
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "accessToken",
    "subject"
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
public class GitLabBindingSpec implements Editable<GitLabBindingSpecBuilder>, KubernetesResource
{

    @JsonProperty("accessToken")
    private SecretValueFromSource accessToken;
    @JsonProperty("subject")
    private Reference subject;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public GitLabBindingSpec() {
    }

    public GitLabBindingSpec(SecretValueFromSource accessToken, Reference subject) {
        super();
        this.accessToken = accessToken;
        this.subject = subject;
    }

    /**
     * GitLabBindingSpec holds the desired state of the GitLabBinding (from the client).
     */
    @JsonProperty("accessToken")
    public SecretValueFromSource getAccessToken() {
        return accessToken;
    }

    /**
     * GitLabBindingSpec holds the desired state of the GitLabBinding (from the client).
     */
    @JsonProperty("accessToken")
    public void setAccessToken(SecretValueFromSource accessToken) {
        this.accessToken = accessToken;
    }

    /**
     * GitLabBindingSpec holds the desired state of the GitLabBinding (from the client).
     */
    @JsonProperty("subject")
    public Reference getSubject() {
        return subject;
    }

    /**
     * GitLabBindingSpec holds the desired state of the GitLabBinding (from the client).
     */
    @JsonProperty("subject")
    public void setSubject(Reference subject) {
        this.subject = subject;
    }

    @JsonIgnore
    public GitLabBindingSpecBuilder edit() {
        return new GitLabBindingSpecBuilder(this);
    }

    @JsonIgnore
    public GitLabBindingSpecBuilder toBuilder() {
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
        if (!(o instanceof GitLabBindingSpec)) {
            return false;
        }
        GitLabBindingSpec other = (GitLabBindingSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$accessToken = this.getAccessToken();
        Object other$accessToken = other.getAccessToken();
        if (this$accessToken == null ? other$accessToken != null : !this$accessToken.equals(other$accessToken)) {
            return false;
        }
        Object this$subject = this.getSubject();
        Object other$subject = other.getSubject();
        if (this$subject == null ? other$subject != null : !this$subject.equals(other$subject)) {
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
        return other instanceof GitLabBindingSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $accessToken = this.getAccessToken();
        result = result * prime + ($accessToken == null ? 43 : $accessToken.hashCode());
        Object $subject = this.getSubject();
        result = result * prime + ($subject == null ? 43 : $subject.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "GitLabBindingSpec(" + "accessToken=" + this.getAccessToken() + ", subject=" + this.getSubject() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
