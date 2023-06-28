
package io.fabric8.openshift.api.model;

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
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import io.sundr.transform.annotations.TemplateTransformation;
import io.sundr.transform.annotations.TemplateTransformations;
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
    "extra",
    "providerName",
    "providerUserName",
    "user"
})
@ToString
@EqualsAndHashCode
@Setter
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
@TemplateTransformations({
    @TemplateTransformation(value = "/manifest.vm", outputPath = "META-INF/services/io.fabric8.kubernetes.api.model.KubernetesResource", gather = true)
})
@Version("v1")
@Group("user.openshift.io")
@Generated("jsonschema2pojo")
public class Identity implements HasMetadata
{

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("apiVersion")
    private java.lang.String apiVersion = "user.openshift.io/v1";
    @JsonProperty("extra")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> extra = new LinkedHashMap<String, String>();
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("kind")
    private java.lang.String kind = "Identity";
    @JsonProperty("metadata")
    private io.fabric8.kubernetes.api.model.ObjectMeta metadata;
    @JsonProperty("providerName")
    private java.lang.String providerName;
    @JsonProperty("providerUserName")
    private java.lang.String providerUserName;
    @JsonProperty("user")
    private io.fabric8.kubernetes.api.model.ObjectReference user;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Identity() {
    }

    public Identity(java.lang.String apiVersion, Map<String, String> extra, java.lang.String kind, io.fabric8.kubernetes.api.model.ObjectMeta metadata, java.lang.String providerName, java.lang.String providerUserName, io.fabric8.kubernetes.api.model.ObjectReference user) {
        super();
        this.apiVersion = apiVersion;
        this.extra = extra;
        this.kind = kind;
        this.metadata = metadata;
        this.providerName = providerName;
        this.providerUserName = providerUserName;
        this.user = user;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("apiVersion")
    public java.lang.String getApiVersion() {
        return apiVersion;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("apiVersion")
    public void setApiVersion(java.lang.String apiVersion) {
        this.apiVersion = apiVersion;
    }

    @JsonProperty("extra")
    public Map<String, String> getExtra() {
        return extra;
    }

    @JsonProperty("extra")
    public void setExtra(Map<String, String> extra) {
        this.extra = extra;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("kind")
    public java.lang.String getKind() {
        return kind;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("kind")
    public void setKind(java.lang.String kind) {
        this.kind = kind;
    }

    @JsonProperty("metadata")
    public io.fabric8.kubernetes.api.model.ObjectMeta getMetadata() {
        return metadata;
    }

    @JsonProperty("metadata")
    public void setMetadata(io.fabric8.kubernetes.api.model.ObjectMeta metadata) {
        this.metadata = metadata;
    }

    @JsonProperty("providerName")
    public java.lang.String getProviderName() {
        return providerName;
    }

    @JsonProperty("providerName")
    public void setProviderName(java.lang.String providerName) {
        this.providerName = providerName;
    }

    @JsonProperty("providerUserName")
    public java.lang.String getProviderUserName() {
        return providerUserName;
    }

    @JsonProperty("providerUserName")
    public void setProviderUserName(java.lang.String providerUserName) {
        this.providerUserName = providerUserName;
    }

    @JsonProperty("user")
    public io.fabric8.kubernetes.api.model.ObjectReference getUser() {
        return user;
    }

    @JsonProperty("user")
    public void setUser(io.fabric8.kubernetes.api.model.ObjectReference user) {
        this.user = user;
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
