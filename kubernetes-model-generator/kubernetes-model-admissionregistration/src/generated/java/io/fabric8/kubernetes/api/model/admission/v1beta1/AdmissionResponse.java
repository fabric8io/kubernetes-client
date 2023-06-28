
package io.fabric8.kubernetes.api.model.admission.v1beta1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Status;
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
    "allowed",
    "auditAnnotations",
    "patch",
    "patchType",
    "status",
    "uid",
    "warnings"
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
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class AdmissionResponse implements KubernetesResource
{

    @JsonProperty("allowed")
    private Boolean allowed;
    @JsonProperty("auditAnnotations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> auditAnnotations = new LinkedHashMap<String, String>();
    @JsonProperty("patch")
    private java.lang.String patch;
    @JsonProperty("patchType")
    private java.lang.String patchType;
    @JsonProperty("status")
    private Status status;
    @JsonProperty("uid")
    private java.lang.String uid;
    @JsonProperty("warnings")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<java.lang.String> warnings = new ArrayList<java.lang.String>();
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public AdmissionResponse() {
    }

    public AdmissionResponse(Boolean allowed, Map<String, String> auditAnnotations, java.lang.String patch, java.lang.String patchType, Status status, java.lang.String uid, List<java.lang.String> warnings) {
        super();
        this.allowed = allowed;
        this.auditAnnotations = auditAnnotations;
        this.patch = patch;
        this.patchType = patchType;
        this.status = status;
        this.uid = uid;
        this.warnings = warnings;
    }

    @JsonProperty("allowed")
    public Boolean getAllowed() {
        return allowed;
    }

    @JsonProperty("allowed")
    public void setAllowed(Boolean allowed) {
        this.allowed = allowed;
    }

    @JsonProperty("auditAnnotations")
    public Map<String, String> getAuditAnnotations() {
        return auditAnnotations;
    }

    @JsonProperty("auditAnnotations")
    public void setAuditAnnotations(Map<String, String> auditAnnotations) {
        this.auditAnnotations = auditAnnotations;
    }

    @JsonProperty("patch")
    public java.lang.String getPatch() {
        return patch;
    }

    @JsonProperty("patch")
    public void setPatch(java.lang.String patch) {
        this.patch = patch;
    }

    @JsonProperty("patchType")
    public java.lang.String getPatchType() {
        return patchType;
    }

    @JsonProperty("patchType")
    public void setPatchType(java.lang.String patchType) {
        this.patchType = patchType;
    }

    @JsonProperty("status")
    public Status getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(Status status) {
        this.status = status;
    }

    @JsonProperty("uid")
    public java.lang.String getUid() {
        return uid;
    }

    @JsonProperty("uid")
    public void setUid(java.lang.String uid) {
        this.uid = uid;
    }

    @JsonProperty("warnings")
    public List<java.lang.String> getWarnings() {
        return warnings;
    }

    @JsonProperty("warnings")
    public void setWarnings(List<java.lang.String> warnings) {
        this.warnings = warnings;
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
