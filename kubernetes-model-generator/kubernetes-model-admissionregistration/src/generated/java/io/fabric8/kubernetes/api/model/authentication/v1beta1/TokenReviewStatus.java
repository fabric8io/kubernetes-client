
package io.fabric8.kubernetes.api.model.authentication.v1beta1;

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
 * TokenReviewStatus is the result of the token authentication request.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "audiences",
    "authenticated",
    "error",
    "user"
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
public class TokenReviewStatus implements Editable<TokenReviewStatusBuilder>, KubernetesResource
{

    @JsonProperty("audiences")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> audiences = new ArrayList<>();
    @JsonProperty("authenticated")
    private Boolean authenticated;
    @JsonProperty("error")
    private String error;
    @JsonProperty("user")
    private UserInfo user;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public TokenReviewStatus() {
    }

    public TokenReviewStatus(List<String> audiences, Boolean authenticated, String error, UserInfo user) {
        super();
        this.audiences = audiences;
        this.authenticated = authenticated;
        this.error = error;
        this.user = user;
    }

    /**
     * Audiences are audience identifiers chosen by the authenticator that are compatible with both the TokenReview and token. An identifier is any identifier in the intersection of the TokenReviewSpec audiences and the token's audiences. A client of the TokenReview API that sets the spec.audiences field should validate that a compatible audience identifier is returned in the status.audiences field to ensure that the TokenReview server is audience aware. If a TokenReview returns an empty status.audience field where status.authenticated is "true", the token is valid against the audience of the Kubernetes API server.
     */
    @JsonProperty("audiences")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getAudiences() {
        return audiences;
    }

    /**
     * Audiences are audience identifiers chosen by the authenticator that are compatible with both the TokenReview and token. An identifier is any identifier in the intersection of the TokenReviewSpec audiences and the token's audiences. A client of the TokenReview API that sets the spec.audiences field should validate that a compatible audience identifier is returned in the status.audiences field to ensure that the TokenReview server is audience aware. If a TokenReview returns an empty status.audience field where status.authenticated is "true", the token is valid against the audience of the Kubernetes API server.
     */
    @JsonProperty("audiences")
    public void setAudiences(List<String> audiences) {
        this.audiences = audiences;
    }

    /**
     * Authenticated indicates that the token was associated with a known user.
     */
    @JsonProperty("authenticated")
    public Boolean getAuthenticated() {
        return authenticated;
    }

    /**
     * Authenticated indicates that the token was associated with a known user.
     */
    @JsonProperty("authenticated")
    public void setAuthenticated(Boolean authenticated) {
        this.authenticated = authenticated;
    }

    /**
     * Error indicates that the token couldn't be checked
     */
    @JsonProperty("error")
    public String getError() {
        return error;
    }

    /**
     * Error indicates that the token couldn't be checked
     */
    @JsonProperty("error")
    public void setError(String error) {
        this.error = error;
    }

    /**
     * TokenReviewStatus is the result of the token authentication request.
     */
    @JsonProperty("user")
    public UserInfo getUser() {
        return user;
    }

    /**
     * TokenReviewStatus is the result of the token authentication request.
     */
    @JsonProperty("user")
    public void setUser(UserInfo user) {
        this.user = user;
    }

    @JsonIgnore
    public TokenReviewStatusBuilder edit() {
        return new TokenReviewStatusBuilder(this);
    }

    @JsonIgnore
    public TokenReviewStatusBuilder toBuilder() {
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
        if (!(o instanceof TokenReviewStatus)) {
            return false;
        }
        TokenReviewStatus other = (TokenReviewStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$audiences = this.getAudiences();
        Object other$audiences = other.getAudiences();
        if (this$audiences == null ? other$audiences != null : !this$audiences.equals(other$audiences)) {
            return false;
        }
        Object this$authenticated = this.getAuthenticated();
        Object other$authenticated = other.getAuthenticated();
        if (this$authenticated == null ? other$authenticated != null : !this$authenticated.equals(other$authenticated)) {
            return false;
        }
        Object this$error = this.getError();
        Object other$error = other.getError();
        if (this$error == null ? other$error != null : !this$error.equals(other$error)) {
            return false;
        }
        Object this$user = this.getUser();
        Object other$user = other.getUser();
        if (this$user == null ? other$user != null : !this$user.equals(other$user)) {
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
        return other instanceof TokenReviewStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $audiences = this.getAudiences();
        result = result * prime + ($audiences == null ? 43 : $audiences.hashCode());
        Object $authenticated = this.getAuthenticated();
        result = result * prime + ($authenticated == null ? 43 : $authenticated.hashCode());
        Object $error = this.getError();
        result = result * prime + ($error == null ? 43 : $error.hashCode());
        Object $user = this.getUser();
        result = result * prime + ($user == null ? 43 : $user.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "TokenReviewStatus(" + "audiences=" + this.getAudiences() + ", authenticated=" + this.getAuthenticated() + ", error=" + this.getError() + ", user=" + this.getUser() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
