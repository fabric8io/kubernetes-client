
package io.fabric8.openshift.api.model.config.v1;

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
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import tools.jackson.databind.annotation.JsonDeserialize;

/**
 * ImageSigstoreVerificationPolicy defines the verification policy for the items in the scopes list.
 */
@JsonDeserialize(using = tools.jackson.databind.ValueDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "rootOfTrust",
    "signedIdentity"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ImageSigstoreVerificationPolicy implements Editable<ImageSigstoreVerificationPolicyBuilder>, KubernetesResource
{

    @JsonProperty("rootOfTrust")
    private PolicyRootOfTrust rootOfTrust;
    @JsonProperty("signedIdentity")
    private PolicyIdentity signedIdentity;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ImageSigstoreVerificationPolicy() {
    }

    public ImageSigstoreVerificationPolicy(PolicyRootOfTrust rootOfTrust, PolicyIdentity signedIdentity) {
        super();
        this.rootOfTrust = rootOfTrust;
        this.signedIdentity = signedIdentity;
    }

    /**
     * ImageSigstoreVerificationPolicy defines the verification policy for the items in the scopes list.
     */
    @JsonProperty("rootOfTrust")
    public PolicyRootOfTrust getRootOfTrust() {
        return rootOfTrust;
    }

    /**
     * ImageSigstoreVerificationPolicy defines the verification policy for the items in the scopes list.
     */
    @JsonProperty("rootOfTrust")
    public void setRootOfTrust(PolicyRootOfTrust rootOfTrust) {
        this.rootOfTrust = rootOfTrust;
    }

    /**
     * ImageSigstoreVerificationPolicy defines the verification policy for the items in the scopes list.
     */
    @JsonProperty("signedIdentity")
    public PolicyIdentity getSignedIdentity() {
        return signedIdentity;
    }

    /**
     * ImageSigstoreVerificationPolicy defines the verification policy for the items in the scopes list.
     */
    @JsonProperty("signedIdentity")
    public void setSignedIdentity(PolicyIdentity signedIdentity) {
        this.signedIdentity = signedIdentity;
    }

    @JsonIgnore
    public ImageSigstoreVerificationPolicyBuilder edit() {
        return new ImageSigstoreVerificationPolicyBuilder(this);
    }

    @JsonIgnore
    public ImageSigstoreVerificationPolicyBuilder toBuilder() {
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
        if (!(o instanceof ImageSigstoreVerificationPolicy)) {
            return false;
        }
        ImageSigstoreVerificationPolicy other = (ImageSigstoreVerificationPolicy) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$rootOfTrust = this.getRootOfTrust();
        Object other$rootOfTrust = other.getRootOfTrust();
        if (this$rootOfTrust == null ? other$rootOfTrust != null : !this$rootOfTrust.equals(other$rootOfTrust)) {
            return false;
        }
        Object this$signedIdentity = this.getSignedIdentity();
        Object other$signedIdentity = other.getSignedIdentity();
        if (this$signedIdentity == null ? other$signedIdentity != null : !this$signedIdentity.equals(other$signedIdentity)) {
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
        return other instanceof ImageSigstoreVerificationPolicy;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $rootOfTrust = this.getRootOfTrust();
        result = result * prime + ($rootOfTrust == null ? 43 : $rootOfTrust.hashCode());
        Object $signedIdentity = this.getSignedIdentity();
        result = result * prime + ($signedIdentity == null ? 43 : $signedIdentity.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ImageSigstoreVerificationPolicy(" + "rootOfTrust=" + this.getRootOfTrust() + ", signedIdentity=" + this.getSignedIdentity() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
