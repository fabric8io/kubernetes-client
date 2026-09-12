
package io.fabric8.kubernetes.api.model.authorization.v1;

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
 * SubjectAccessReviewSpec is a description of the access request.  Exactly one of resourceAttributes and nonResourceAttributes must be set
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "extra",
    "groups",
    "nonResourceAttributes",
    "resourceAttributes",
    "uid",
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
public class SubjectAccessReviewSpec implements Editable<SubjectAccessReviewSpecBuilder>, KubernetesResource
{

    @JsonProperty("extra")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, List<String>> extra = new LinkedHashMap<>();
    @JsonProperty("groups")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> groups = new ArrayList<>();
    @JsonProperty("nonResourceAttributes")
    private NonResourceAttributes nonResourceAttributes;
    @JsonProperty("resourceAttributes")
    private ResourceAttributes resourceAttributes;
    @JsonProperty("uid")
    private String uid;
    @JsonProperty("user")
    private String user;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public SubjectAccessReviewSpec() {
    }

    public SubjectAccessReviewSpec(Map<String, List<String>> extra, List<String> groups, NonResourceAttributes nonResourceAttributes, ResourceAttributes resourceAttributes, String uid, String user) {
        super();
        this.extra = extra;
        this.groups = groups;
        this.nonResourceAttributes = nonResourceAttributes;
        this.resourceAttributes = resourceAttributes;
        this.uid = uid;
        this.user = user;
    }

    /**
     * extra corresponds to the user.Info.GetExtra() method from the authenticator.  Since that is input to the authorizer it needs a reflection here.
     */
    @JsonProperty("extra")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, List<String>> getExtra() {
        return extra;
    }

    /**
     * extra corresponds to the user.Info.GetExtra() method from the authenticator.  Since that is input to the authorizer it needs a reflection here.
     */
    @JsonProperty("extra")
    public void setExtra(Map<String, List<String>> extra) {
        this.extra = extra;
    }

    /**
     * groups is the groups you're testing for.
     */
    @JsonProperty("groups")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getGroups() {
        return groups;
    }

    /**
     * groups is the groups you're testing for.
     */
    @JsonProperty("groups")
    public void setGroups(List<String> groups) {
        this.groups = groups;
    }

    /**
     * SubjectAccessReviewSpec is a description of the access request.  Exactly one of resourceAttributes and nonResourceAttributes must be set
     */
    @JsonProperty("nonResourceAttributes")
    public NonResourceAttributes getNonResourceAttributes() {
        return nonResourceAttributes;
    }

    /**
     * SubjectAccessReviewSpec is a description of the access request.  Exactly one of resourceAttributes and nonResourceAttributes must be set
     */
    @JsonProperty("nonResourceAttributes")
    public void setNonResourceAttributes(NonResourceAttributes nonResourceAttributes) {
        this.nonResourceAttributes = nonResourceAttributes;
    }

    /**
     * SubjectAccessReviewSpec is a description of the access request.  Exactly one of resourceAttributes and nonResourceAttributes must be set
     */
    @JsonProperty("resourceAttributes")
    public ResourceAttributes getResourceAttributes() {
        return resourceAttributes;
    }

    /**
     * SubjectAccessReviewSpec is a description of the access request.  Exactly one of resourceAttributes and nonResourceAttributes must be set
     */
    @JsonProperty("resourceAttributes")
    public void setResourceAttributes(ResourceAttributes resourceAttributes) {
        this.resourceAttributes = resourceAttributes;
    }

    /**
     * uid information about the requesting user.
     */
    @JsonProperty("uid")
    public String getUid() {
        return uid;
    }

    /**
     * uid information about the requesting user.
     */
    @JsonProperty("uid")
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * user is the user you're testing for. If you specify "User" but not "Groups", then is it interpreted as "What if User were not a member of any groups
     */
    @JsonProperty("user")
    public String getUser() {
        return user;
    }

    /**
     * user is the user you're testing for. If you specify "User" but not "Groups", then is it interpreted as "What if User were not a member of any groups
     */
    @JsonProperty("user")
    public void setUser(String user) {
        this.user = user;
    }

    @JsonIgnore
    public SubjectAccessReviewSpecBuilder edit() {
        return new SubjectAccessReviewSpecBuilder(this);
    }

    @JsonIgnore
    public SubjectAccessReviewSpecBuilder toBuilder() {
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
        if (!(o instanceof SubjectAccessReviewSpec)) {
            return false;
        }
        SubjectAccessReviewSpec other = (SubjectAccessReviewSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$extra = this.getExtra();
        Object other$extra = other.getExtra();
        if (this$extra == null ? other$extra != null : !this$extra.equals(other$extra)) {
            return false;
        }
        Object this$groups = this.getGroups();
        Object other$groups = other.getGroups();
        if (this$groups == null ? other$groups != null : !this$groups.equals(other$groups)) {
            return false;
        }
        Object this$nonResourceAttributes = this.getNonResourceAttributes();
        Object other$nonResourceAttributes = other.getNonResourceAttributes();
        if (this$nonResourceAttributes == null ? other$nonResourceAttributes != null : !this$nonResourceAttributes.equals(other$nonResourceAttributes)) {
            return false;
        }
        Object this$resourceAttributes = this.getResourceAttributes();
        Object other$resourceAttributes = other.getResourceAttributes();
        if (this$resourceAttributes == null ? other$resourceAttributes != null : !this$resourceAttributes.equals(other$resourceAttributes)) {
            return false;
        }
        Object this$uid = this.getUid();
        Object other$uid = other.getUid();
        if (this$uid == null ? other$uid != null : !this$uid.equals(other$uid)) {
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
        return other instanceof SubjectAccessReviewSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $extra = this.getExtra();
        result = result * prime + ($extra == null ? 43 : $extra.hashCode());
        Object $groups = this.getGroups();
        result = result * prime + ($groups == null ? 43 : $groups.hashCode());
        Object $nonResourceAttributes = this.getNonResourceAttributes();
        result = result * prime + ($nonResourceAttributes == null ? 43 : $nonResourceAttributes.hashCode());
        Object $resourceAttributes = this.getResourceAttributes();
        result = result * prime + ($resourceAttributes == null ? 43 : $resourceAttributes.hashCode());
        Object $uid = this.getUid();
        result = result * prime + ($uid == null ? 43 : $uid.hashCode());
        Object $user = this.getUser();
        result = result * prime + ($user == null ? 43 : $user.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "SubjectAccessReviewSpec(" + "extra=" + this.getExtra() + ", groups=" + this.getGroups() + ", nonResourceAttributes=" + this.getNonResourceAttributes() + ", resourceAttributes=" + this.getResourceAttributes() + ", uid=" + this.getUid() + ", user=" + this.getUser() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
