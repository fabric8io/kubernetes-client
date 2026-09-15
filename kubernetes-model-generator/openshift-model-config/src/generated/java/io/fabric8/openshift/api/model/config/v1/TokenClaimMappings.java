
package io.fabric8.openshift.api.model.config.v1;

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
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "extra",
    "groups",
    "uid",
    "username"
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
public class TokenClaimMappings implements Editable<TokenClaimMappingsBuilder>, KubernetesResource
{

    @JsonProperty("extra")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ExtraMapping> extra = new ArrayList<>();
    @JsonProperty("groups")
    private PrefixedClaimMapping groups;
    @JsonProperty("uid")
    private TokenClaimOrExpressionMapping uid;
    @JsonProperty("username")
    private UsernameClaimMapping username;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public TokenClaimMappings() {
    }

    public TokenClaimMappings(List<ExtraMapping> extra, PrefixedClaimMapping groups, TokenClaimOrExpressionMapping uid, UsernameClaimMapping username) {
        super();
        this.extra = extra;
        this.groups = groups;
        this.uid = uid;
        this.username = username;
    }

    /**
     * extra is an optional field for configuring the mappings used to construct the extra attribute for the cluster identity. When omitted, no extra attributes will be present on the cluster identity. key values for extra mappings must be unique. A maximum of 32 extra attribute mappings may be provided.
     */
    @JsonProperty("extra")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ExtraMapping> getExtra() {
        return extra;
    }

    /**
     * extra is an optional field for configuring the mappings used to construct the extra attribute for the cluster identity. When omitted, no extra attributes will be present on the cluster identity. key values for extra mappings must be unique. A maximum of 32 extra attribute mappings may be provided.
     */
    @JsonProperty("extra")
    public void setExtra(List<ExtraMapping> extra) {
        this.extra = extra;
    }

    @JsonProperty("groups")
    public PrefixedClaimMapping getGroups() {
        return groups;
    }

    @JsonProperty("groups")
    public void setGroups(PrefixedClaimMapping groups) {
        this.groups = groups;
    }

    @JsonProperty("uid")
    public TokenClaimOrExpressionMapping getUid() {
        return uid;
    }

    @JsonProperty("uid")
    public void setUid(TokenClaimOrExpressionMapping uid) {
        this.uid = uid;
    }

    @JsonProperty("username")
    public UsernameClaimMapping getUsername() {
        return username;
    }

    @JsonProperty("username")
    public void setUsername(UsernameClaimMapping username) {
        this.username = username;
    }

    @JsonIgnore
    public TokenClaimMappingsBuilder edit() {
        return new TokenClaimMappingsBuilder(this);
    }

    @JsonIgnore
    public TokenClaimMappingsBuilder toBuilder() {
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
        if (!(o instanceof TokenClaimMappings)) {
            return false;
        }
        TokenClaimMappings other = (TokenClaimMappings) o;
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
        Object this$uid = this.getUid();
        Object other$uid = other.getUid();
        if (this$uid == null ? other$uid != null : !this$uid.equals(other$uid)) {
            return false;
        }
        Object this$username = this.getUsername();
        Object other$username = other.getUsername();
        if (this$username == null ? other$username != null : !this$username.equals(other$username)) {
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
        return other instanceof TokenClaimMappings;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $extra = this.getExtra();
        result = result * prime + ($extra == null ? 43 : $extra.hashCode());
        Object $groups = this.getGroups();
        result = result * prime + ($groups == null ? 43 : $groups.hashCode());
        Object $uid = this.getUid();
        result = result * prime + ($uid == null ? 43 : $uid.hashCode());
        Object $username = this.getUsername();
        result = result * prime + ($username == null ? 43 : $username.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "TokenClaimMappings(" + "extra=" + this.getExtra() + ", groups=" + this.getGroups() + ", uid=" + this.getUid() + ", username=" + this.getUsername() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
