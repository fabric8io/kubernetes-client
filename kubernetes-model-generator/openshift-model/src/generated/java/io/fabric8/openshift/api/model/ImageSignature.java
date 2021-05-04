
package io.fabric8.openshift.api.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import io.fabric8.kubernetes.api.model.Namespaced;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "conditions",
    "content",
    "created",
    "imageIdentity",
    "issuedBy",
    "issuedTo",
    "signedClaims",
    "type"
})
@ToString
@EqualsAndHashCode
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
public class ImageSignature implements HasMetadata, Namespaced
{

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("apiVersion")
    private java.lang.String apiVersion = "image.openshift.io/v1";
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<SignatureCondition> conditions = new ArrayList<SignatureCondition>();
    @JsonProperty("content")
    private java.lang.String content;
    @JsonProperty("created")
    private String created;
    @JsonProperty("imageIdentity")
    private java.lang.String imageIdentity;
    @JsonProperty("issuedBy")
    private SignatureIssuer issuedBy;
    @JsonProperty("issuedTo")
    private SignatureSubject issuedTo;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("kind")
    private java.lang.String kind = "ImageSignature";
    @JsonProperty("metadata")
    private io.fabric8.kubernetes.api.model.ObjectMeta metadata;
    @JsonProperty("signedClaims")
    private Map<String, String> signedClaims;
    @JsonProperty("type")
    private java.lang.String type;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new HashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ImageSignature() {
    }

    /**
     * 
     * @param metadata
     * @param apiVersion
     * @param issuedTo
     * @param created
     * @param kind
     * @param issuedBy
     * @param signedClaims
     * @param conditions
     * @param type
     * @param content
     * @param imageIdentity
     */
    public ImageSignature(java.lang.String apiVersion, List<SignatureCondition> conditions, java.lang.String content, String created, java.lang.String imageIdentity, SignatureIssuer issuedBy, SignatureSubject issuedTo, java.lang.String kind, io.fabric8.kubernetes.api.model.ObjectMeta metadata, Map<String, String> signedClaims, java.lang.String type) {
        super();
        this.apiVersion = apiVersion;
        this.conditions = conditions;
        this.content = content;
        this.created = created;
        this.imageIdentity = imageIdentity;
        this.issuedBy = issuedBy;
        this.issuedTo = issuedTo;
        this.kind = kind;
        this.metadata = metadata;
        this.signedClaims = signedClaims;
        this.type = type;
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

    @JsonProperty("conditions")
    public List<SignatureCondition> getConditions() {
        return conditions;
    }

    @JsonProperty("conditions")
    public void setConditions(List<SignatureCondition> conditions) {
        this.conditions = conditions;
    }

    @JsonProperty("content")
    public java.lang.String getContent() {
        return content;
    }

    @JsonProperty("content")
    public void setContent(java.lang.String content) {
        this.content = content;
    }

    @JsonProperty("created")
    public String getCreated() {
        return created;
    }

    @JsonProperty("created")
    public void setCreated(String created) {
        this.created = created;
    }

    @JsonProperty("imageIdentity")
    public java.lang.String getImageIdentity() {
        return imageIdentity;
    }

    @JsonProperty("imageIdentity")
    public void setImageIdentity(java.lang.String imageIdentity) {
        this.imageIdentity = imageIdentity;
    }

    @JsonProperty("issuedBy")
    public SignatureIssuer getIssuedBy() {
        return issuedBy;
    }

    @JsonProperty("issuedBy")
    public void setIssuedBy(SignatureIssuer issuedBy) {
        this.issuedBy = issuedBy;
    }

    @JsonProperty("issuedTo")
    public SignatureSubject getIssuedTo() {
        return issuedTo;
    }

    @JsonProperty("issuedTo")
    public void setIssuedTo(SignatureSubject issuedTo) {
        this.issuedTo = issuedTo;
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

    @JsonProperty("signedClaims")
    public Map<String, String> getSignedClaims() {
        return signedClaims;
    }

    @JsonProperty("signedClaims")
    public void setSignedClaims(Map<String, String> signedClaims) {
        this.signedClaims = signedClaims;
    }

    @JsonProperty("type")
    public java.lang.String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(java.lang.String type) {
        this.type = type;
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
