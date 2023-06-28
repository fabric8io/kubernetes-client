
package io.fabric8.openshift.api.model.hive.aws.v1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "credentialsAssumeRole",
    "credentialsSecretRef",
    "privateLink",
    "region",
    "userTags"
})
@ToString
@EqualsAndHashCode
@Setter
@Accessors(prefix = {
    "_",
    ""
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class Platform implements KubernetesResource
{

    @JsonProperty("credentialsAssumeRole")
    private AssumeRole credentialsAssumeRole;
    @JsonProperty("credentialsSecretRef")
    private io.fabric8.kubernetes.api.model.LocalObjectReference credentialsSecretRef;
    @JsonProperty("privateLink")
    private PrivateLinkAccess privateLink;
    @JsonProperty("region")
    private java.lang.String region;
    @JsonProperty("userTags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> userTags = new LinkedHashMap<String, String>();
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Platform() {
    }

    public Platform(AssumeRole credentialsAssumeRole, io.fabric8.kubernetes.api.model.LocalObjectReference credentialsSecretRef, PrivateLinkAccess privateLink, java.lang.String region, Map<String, String> userTags) {
        super();
        this.credentialsAssumeRole = credentialsAssumeRole;
        this.credentialsSecretRef = credentialsSecretRef;
        this.privateLink = privateLink;
        this.region = region;
        this.userTags = userTags;
    }

    @JsonProperty("credentialsAssumeRole")
    public AssumeRole getCredentialsAssumeRole() {
        return credentialsAssumeRole;
    }

    @JsonProperty("credentialsAssumeRole")
    public void setCredentialsAssumeRole(AssumeRole credentialsAssumeRole) {
        this.credentialsAssumeRole = credentialsAssumeRole;
    }

    @JsonProperty("credentialsSecretRef")
    public io.fabric8.kubernetes.api.model.LocalObjectReference getCredentialsSecretRef() {
        return credentialsSecretRef;
    }

    @JsonProperty("credentialsSecretRef")
    public void setCredentialsSecretRef(io.fabric8.kubernetes.api.model.LocalObjectReference credentialsSecretRef) {
        this.credentialsSecretRef = credentialsSecretRef;
    }

    @JsonProperty("privateLink")
    public PrivateLinkAccess getPrivateLink() {
        return privateLink;
    }

    @JsonProperty("privateLink")
    public void setPrivateLink(PrivateLinkAccess privateLink) {
        this.privateLink = privateLink;
    }

    @JsonProperty("region")
    public java.lang.String getRegion() {
        return region;
    }

    @JsonProperty("region")
    public void setRegion(java.lang.String region) {
        this.region = region;
    }

    @JsonProperty("userTags")
    public Map<String, String> getUserTags() {
        return userTags;
    }

    @JsonProperty("userTags")
    public void setUserTags(Map<String, String> userTags) {
        this.userTags = userTags;
    }

    @JsonAnyGetter
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
