
package io.fabric8.kubernetes.api.model;

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
import io.sundr.builder.annotations.Buildable;

/**
 * ServiceAccountTokenProjection represents a projected service account token volume. This projection can be used to insert a service account token into the pods runtime filesystem for use against APIs (Kubernetes API Server or otherwise).
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "audience",
    "expirationSeconds",
    "path",
    "user"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ServiceAccountTokenProjection implements Editable<ServiceAccountTokenProjectionBuilder>, KubernetesResource
{

    @JsonProperty("audience")
    private String audience;
    @JsonProperty("expirationSeconds")
    private Long expirationSeconds;
    @JsonProperty("path")
    private String path;
    @JsonProperty("user")
    private Long user;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ServiceAccountTokenProjection() {
    }

    public ServiceAccountTokenProjection(String audience, Long expirationSeconds, String path, Long user) {
        super();
        this.audience = audience;
        this.expirationSeconds = expirationSeconds;
        this.path = path;
        this.user = user;
    }

    /**
     * audience is the intended audience of the token. A recipient of a token must identify itself with an identifier specified in the audience of the token, and otherwise should reject the token. The audience defaults to the identifier of the apiserver.
     */
    @JsonProperty("audience")
    public String getAudience() {
        return audience;
    }

    /**
     * audience is the intended audience of the token. A recipient of a token must identify itself with an identifier specified in the audience of the token, and otherwise should reject the token. The audience defaults to the identifier of the apiserver.
     */
    @JsonProperty("audience")
    public void setAudience(String audience) {
        this.audience = audience;
    }

    /**
     * expirationSeconds is the requested duration of validity of the service account token. As the token approaches expiration, the kubelet volume plugin will proactively rotate the service account token. The kubelet will start trying to rotate the token if the token is older than 80 percent of its time to live or if the token is older than 24 hours.Defaults to 1 hour and must be at least 10 minutes.
     */
    @JsonProperty("expirationSeconds")
    public Long getExpirationSeconds() {
        return expirationSeconds;
    }

    /**
     * expirationSeconds is the requested duration of validity of the service account token. As the token approaches expiration, the kubelet volume plugin will proactively rotate the service account token. The kubelet will start trying to rotate the token if the token is older than 80 percent of its time to live or if the token is older than 24 hours.Defaults to 1 hour and must be at least 10 minutes.
     */
    @JsonProperty("expirationSeconds")
    public void setExpirationSeconds(Long expirationSeconds) {
        this.expirationSeconds = expirationSeconds;
    }

    /**
     * path is the path relative to the mount point of the file to project the token into.
     */
    @JsonProperty("path")
    public String getPath() {
        return path;
    }

    /**
     * path is the path relative to the mount point of the file to project the token into.
     */
    @JsonProperty("path")
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * user is Optional: The owner UID of the created file. If specified, the item-level user field takes precedence over defaultUser. (Alpha) This field requires the AtomicWriteVolumeUserFields feature gate to be enabled.
     */
    @JsonProperty("user")
    public Long getUser() {
        return user;
    }

    /**
     * user is Optional: The owner UID of the created file. If specified, the item-level user field takes precedence over defaultUser. (Alpha) This field requires the AtomicWriteVolumeUserFields feature gate to be enabled.
     */
    @JsonProperty("user")
    public void setUser(Long user) {
        this.user = user;
    }

    @JsonIgnore
    public ServiceAccountTokenProjectionBuilder edit() {
        return new ServiceAccountTokenProjectionBuilder(this);
    }

    @JsonIgnore
    public ServiceAccountTokenProjectionBuilder toBuilder() {
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
        if (!(o instanceof ServiceAccountTokenProjection)) {
            return false;
        }
        ServiceAccountTokenProjection other = (ServiceAccountTokenProjection) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$audience = this.getAudience();
        Object other$audience = other.getAudience();
        if (this$audience == null ? other$audience != null : !this$audience.equals(other$audience)) {
            return false;
        }
        Object this$expirationSeconds = this.getExpirationSeconds();
        Object other$expirationSeconds = other.getExpirationSeconds();
        if (this$expirationSeconds == null ? other$expirationSeconds != null : !this$expirationSeconds.equals(other$expirationSeconds)) {
            return false;
        }
        Object this$path = this.getPath();
        Object other$path = other.getPath();
        if (this$path == null ? other$path != null : !this$path.equals(other$path)) {
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
        return other instanceof ServiceAccountTokenProjection;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $audience = this.getAudience();
        result = result * prime + ($audience == null ? 43 : $audience.hashCode());
        Object $expirationSeconds = this.getExpirationSeconds();
        result = result * prime + ($expirationSeconds == null ? 43 : $expirationSeconds.hashCode());
        Object $path = this.getPath();
        result = result * prime + ($path == null ? 43 : $path.hashCode());
        Object $user = this.getUser();
        result = result * prime + ($user == null ? 43 : $user.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ServiceAccountTokenProjection(" + "audience=" + this.getAudience() + ", expirationSeconds=" + this.getExpirationSeconds() + ", path=" + this.getPath() + ", user=" + this.getUser() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
