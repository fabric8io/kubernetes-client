
package io.fabric8.openshift.api.model;

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
 * SubjectRulesReviewSpec adds information about how to conduct the check
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "groups",
    "scopes",
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
    @BuildableReference(io.fabric8.kubernetes.api.model.LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class SubjectRulesReviewSpec implements Editable<SubjectRulesReviewSpecBuilder>, KubernetesResource
{

    @JsonProperty("groups")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> groups = new ArrayList<>();
    @JsonProperty("scopes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> scopes = new ArrayList<>();
    @JsonProperty("user")
    private String user;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public SubjectRulesReviewSpec() {
    }

    public SubjectRulesReviewSpec(List<String> groups, List<String> scopes, String user) {
        super();
        this.groups = groups;
        this.scopes = scopes;
        this.user = user;
    }

    /**
     * groups is optional.  Groups is the list of groups to which the User belongs.  At least one of User and Groups must be specified.
     */
    @JsonProperty("groups")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getGroups() {
        return groups;
    }

    /**
     * groups is optional.  Groups is the list of groups to which the User belongs.  At least one of User and Groups must be specified.
     */
    @JsonProperty("groups")
    public void setGroups(List<String> groups) {
        this.groups = groups;
    }

    /**
     * scopes to use for the evaluation.  Empty means "use the unscoped (full) permissions of the user/groups".
     */
    @JsonProperty("scopes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getScopes() {
        return scopes;
    }

    /**
     * scopes to use for the evaluation.  Empty means "use the unscoped (full) permissions of the user/groups".
     */
    @JsonProperty("scopes")
    public void setScopes(List<String> scopes) {
        this.scopes = scopes;
    }

    /**
     * user is optional.  At least one of User and Groups must be specified.
     */
    @JsonProperty("user")
    public String getUser() {
        return user;
    }

    /**
     * user is optional.  At least one of User and Groups must be specified.
     */
    @JsonProperty("user")
    public void setUser(String user) {
        this.user = user;
    }

    @JsonIgnore
    public SubjectRulesReviewSpecBuilder edit() {
        return new SubjectRulesReviewSpecBuilder(this);
    }

    @JsonIgnore
    public SubjectRulesReviewSpecBuilder toBuilder() {
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
        if (!(o instanceof SubjectRulesReviewSpec)) {
            return false;
        }
        SubjectRulesReviewSpec other = (SubjectRulesReviewSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$groups = this.getGroups();
        Object other$groups = other.getGroups();
        if (this$groups == null ? other$groups != null : !this$groups.equals(other$groups)) {
            return false;
        }
        Object this$scopes = this.getScopes();
        Object other$scopes = other.getScopes();
        if (this$scopes == null ? other$scopes != null : !this$scopes.equals(other$scopes)) {
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
        return other instanceof SubjectRulesReviewSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $groups = this.getGroups();
        result = result * prime + ($groups == null ? 43 : $groups.hashCode());
        Object $scopes = this.getScopes();
        result = result * prime + ($scopes == null ? 43 : $scopes.hashCode());
        Object $user = this.getUser();
        result = result * prime + ($user == null ? 43 : $user.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "SubjectRulesReviewSpec(" + "groups=" + this.getGroups() + ", scopes=" + this.getScopes() + ", user=" + this.getUser() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
