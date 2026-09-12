
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
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import io.sundr.builder.annotations.Buildable;

/**
 * OwnerReference contains enough information to let you identify an owning object. An owning object must be in the same namespace as the dependent, or be cluster-scoped, so there is no namespace field.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "blockOwnerDeletion",
    "controller",
    "name",
    "uid"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Version("v1")
@Group("")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class OwnerReference implements Editable<OwnerReferenceBuilder>, KubernetesResource
{

    @JsonProperty("apiVersion")
    private String apiVersion = "v1";
    @JsonProperty("blockOwnerDeletion")
    private Boolean blockOwnerDeletion;
    @JsonProperty("controller")
    private Boolean controller;
    @JsonProperty("kind")
    private String kind = "OwnerReference";
    @JsonProperty("name")
    private String name;
    @JsonProperty("uid")
    private String uid;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public OwnerReference() {
    }

    public OwnerReference(String apiVersion, Boolean blockOwnerDeletion, Boolean controller, String kind, String name, String uid) {
        super();
        this.apiVersion = apiVersion;
        this.blockOwnerDeletion = blockOwnerDeletion;
        this.controller = controller;
        this.kind = kind;
        this.name = name;
        this.uid = uid;
    }

    /**
     * API version of the referent.
     */
    @JsonProperty("apiVersion")
    public String getApiVersion() {
        return apiVersion;
    }

    /**
     * API version of the referent.
     */
    @JsonProperty("apiVersion")
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    /**
     * If true, AND if the owner has the "foregroundDeletion" finalizer, then the owner cannot be deleted from the key-value store until this reference is removed. See https://kubernetes.io/docs/concepts/architecture/garbage-collection/#foreground-deletion for how the garbage collector interacts with this field and enforces the foreground deletion. Defaults to false. To set this field, a user needs "delete" permission of the owner, otherwise 422 (Unprocessable Entity) will be returned.
     */
    @JsonProperty("blockOwnerDeletion")
    public Boolean getBlockOwnerDeletion() {
        return blockOwnerDeletion;
    }

    /**
     * If true, AND if the owner has the "foregroundDeletion" finalizer, then the owner cannot be deleted from the key-value store until this reference is removed. See https://kubernetes.io/docs/concepts/architecture/garbage-collection/#foreground-deletion for how the garbage collector interacts with this field and enforces the foreground deletion. Defaults to false. To set this field, a user needs "delete" permission of the owner, otherwise 422 (Unprocessable Entity) will be returned.
     */
    @JsonProperty("blockOwnerDeletion")
    public void setBlockOwnerDeletion(Boolean blockOwnerDeletion) {
        this.blockOwnerDeletion = blockOwnerDeletion;
    }

    /**
     * If true, this reference points to the managing controller.
     */
    @JsonProperty("controller")
    public Boolean getController() {
        return controller;
    }

    /**
     * If true, this reference points to the managing controller.
     */
    @JsonProperty("controller")
    public void setController(Boolean controller) {
        this.controller = controller;
    }

    /**
     * Kind of the referent. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
     */
    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    /**
     * Kind of the referent. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
     */
    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     * Name of the referent. More info: https://kubernetes.io/docs/concepts/overview/working-with-objects/names#names
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name of the referent. More info: https://kubernetes.io/docs/concepts/overview/working-with-objects/names#names
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * UID of the referent. More info: https://kubernetes.io/docs/concepts/overview/working-with-objects/names#uids
     */
    @JsonProperty("uid")
    public String getUid() {
        return uid;
    }

    /**
     * UID of the referent. More info: https://kubernetes.io/docs/concepts/overview/working-with-objects/names#uids
     */
    @JsonProperty("uid")
    public void setUid(String uid) {
        this.uid = uid;
    }

    @JsonIgnore
    public OwnerReferenceBuilder edit() {
        return new OwnerReferenceBuilder(this);
    }

    @JsonIgnore
    public OwnerReferenceBuilder toBuilder() {
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
        if (!(o instanceof OwnerReference)) {
            return false;
        }
        OwnerReference other = (OwnerReference) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$apiVersion = this.getApiVersion();
        Object other$apiVersion = other.getApiVersion();
        if (this$apiVersion == null ? other$apiVersion != null : !this$apiVersion.equals(other$apiVersion)) {
            return false;
        }
        Object this$blockOwnerDeletion = this.getBlockOwnerDeletion();
        Object other$blockOwnerDeletion = other.getBlockOwnerDeletion();
        if (this$blockOwnerDeletion == null ? other$blockOwnerDeletion != null : !this$blockOwnerDeletion.equals(other$blockOwnerDeletion)) {
            return false;
        }
        Object this$controller = this.getController();
        Object other$controller = other.getController();
        if (this$controller == null ? other$controller != null : !this$controller.equals(other$controller)) {
            return false;
        }
        Object this$kind = this.getKind();
        Object other$kind = other.getKind();
        if (this$kind == null ? other$kind != null : !this$kind.equals(other$kind)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
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
        return other instanceof OwnerReference;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $apiVersion = this.getApiVersion();
        result = result * prime + ($apiVersion == null ? 43 : $apiVersion.hashCode());
        Object $blockOwnerDeletion = this.getBlockOwnerDeletion();
        result = result * prime + ($blockOwnerDeletion == null ? 43 : $blockOwnerDeletion.hashCode());
        Object $controller = this.getController();
        result = result * prime + ($controller == null ? 43 : $controller.hashCode());
        Object $kind = this.getKind();
        result = result * prime + ($kind == null ? 43 : $kind.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $uid = this.getUid();
        result = result * prime + ($uid == null ? 43 : $uid.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "OwnerReference(" + "apiVersion=" + this.getApiVersion() + ", blockOwnerDeletion=" + this.getBlockOwnerDeletion() + ", controller=" + this.getController() + ", kind=" + this.getKind() + ", name=" + this.getName() + ", uid=" + this.getUid() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
