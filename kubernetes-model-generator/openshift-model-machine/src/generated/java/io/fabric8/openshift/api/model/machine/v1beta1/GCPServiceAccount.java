
package io.fabric8.openshift.api.model.machine.v1beta1;

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
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * GCPServiceAccount describes service accounts for GCP.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "email",
    "scopes"
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
public class GCPServiceAccount implements Editable<GCPServiceAccountBuilder>, KubernetesResource
{

    @JsonProperty("email")
    private String email;
    @JsonProperty("scopes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> scopes = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public GCPServiceAccount() {
    }

    public GCPServiceAccount(String email, List<String> scopes) {
        super();
        this.email = email;
        this.scopes = scopes;
    }

    /**
     * email is the service account email.
     */
    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    /**
     * email is the service account email.
     */
    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * scopes list of scopes to be assigned to the service account.
     */
    @JsonProperty("scopes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getScopes() {
        return scopes;
    }

    /**
     * scopes list of scopes to be assigned to the service account.
     */
    @JsonProperty("scopes")
    public void setScopes(List<String> scopes) {
        this.scopes = scopes;
    }

    @JsonIgnore
    public GCPServiceAccountBuilder edit() {
        return new GCPServiceAccountBuilder(this);
    }

    @JsonIgnore
    public GCPServiceAccountBuilder toBuilder() {
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
        if (!(o instanceof GCPServiceAccount)) {
            return false;
        }
        GCPServiceAccount other = (GCPServiceAccount) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$email = this.getEmail();
        Object other$email = other.getEmail();
        if (this$email == null ? other$email != null : !this$email.equals(other$email)) {
            return false;
        }
        Object this$scopes = this.getScopes();
        Object other$scopes = other.getScopes();
        if (this$scopes == null ? other$scopes != null : !this$scopes.equals(other$scopes)) {
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
        return other instanceof GCPServiceAccount;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $email = this.getEmail();
        result = result * prime + ($email == null ? 43 : $email.hashCode());
        Object $scopes = this.getScopes();
        result = result * prime + ($scopes == null ? 43 : $scopes.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "GCPServiceAccount(" + "email=" + this.getEmail() + ", scopes=" + this.getScopes() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
