
package io.fabric8.kubernetes.api.model.admission.v1beta1;

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
import io.fabric8.kubernetes.api.model.Status;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "allowed",
    "auditAnnotations",
    "patch",
    "patchType",
    "status",
    "uid",
    "warnings"
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
public class AdmissionResponse implements Editable<AdmissionResponseBuilder>, KubernetesResource
{

    @JsonProperty("allowed")
    private Boolean allowed;
    @JsonProperty("auditAnnotations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> auditAnnotations = new LinkedHashMap<>();
    @JsonProperty("patch")
    private String patch;
    @JsonProperty("patchType")
    private String patchType;
    @JsonProperty("status")
    private Status status;
    @JsonProperty("uid")
    private String uid;
    @JsonProperty("warnings")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> warnings = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AdmissionResponse() {
    }

    public AdmissionResponse(Boolean allowed, Map<String, String> auditAnnotations, String patch, String patchType, Status status, String uid, List<String> warnings) {
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
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getAuditAnnotations() {
        return auditAnnotations;
    }

    @JsonProperty("auditAnnotations")
    public void setAuditAnnotations(Map<String, String> auditAnnotations) {
        this.auditAnnotations = auditAnnotations;
    }

    @JsonProperty("patch")
    public String getPatch() {
        return patch;
    }

    @JsonProperty("patch")
    public void setPatch(String patch) {
        this.patch = patch;
    }

    @JsonProperty("patchType")
    public String getPatchType() {
        return patchType;
    }

    @JsonProperty("patchType")
    public void setPatchType(String patchType) {
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
    public String getUid() {
        return uid;
    }

    @JsonProperty("uid")
    public void setUid(String uid) {
        this.uid = uid;
    }

    @JsonProperty("warnings")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getWarnings() {
        return warnings;
    }

    @JsonProperty("warnings")
    public void setWarnings(List<String> warnings) {
        this.warnings = warnings;
    }

    @JsonIgnore
    public AdmissionResponseBuilder edit() {
        return new AdmissionResponseBuilder(this);
    }

    @JsonIgnore
    public AdmissionResponseBuilder toBuilder() {
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
        if (!(o instanceof AdmissionResponse)) {
            return false;
        }
        AdmissionResponse other = (AdmissionResponse) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$allowed = this.getAllowed();
        Object other$allowed = other.getAllowed();
        if (this$allowed == null ? other$allowed != null : !this$allowed.equals(other$allowed)) {
            return false;
        }
        Object this$auditAnnotations = this.getAuditAnnotations();
        Object other$auditAnnotations = other.getAuditAnnotations();
        if (this$auditAnnotations == null ? other$auditAnnotations != null : !this$auditAnnotations.equals(other$auditAnnotations)) {
            return false;
        }
        Object this$patch = this.getPatch();
        Object other$patch = other.getPatch();
        if (this$patch == null ? other$patch != null : !this$patch.equals(other$patch)) {
            return false;
        }
        Object this$patchType = this.getPatchType();
        Object other$patchType = other.getPatchType();
        if (this$patchType == null ? other$patchType != null : !this$patchType.equals(other$patchType)) {
            return false;
        }
        Object this$status = this.getStatus();
        Object other$status = other.getStatus();
        if (this$status == null ? other$status != null : !this$status.equals(other$status)) {
            return false;
        }
        Object this$uid = this.getUid();
        Object other$uid = other.getUid();
        if (this$uid == null ? other$uid != null : !this$uid.equals(other$uid)) {
            return false;
        }
        Object this$warnings = this.getWarnings();
        Object other$warnings = other.getWarnings();
        if (this$warnings == null ? other$warnings != null : !this$warnings.equals(other$warnings)) {
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
        return other instanceof AdmissionResponse;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $allowed = this.getAllowed();
        result = result * prime + ($allowed == null ? 43 : $allowed.hashCode());
        Object $auditAnnotations = this.getAuditAnnotations();
        result = result * prime + ($auditAnnotations == null ? 43 : $auditAnnotations.hashCode());
        Object $patch = this.getPatch();
        result = result * prime + ($patch == null ? 43 : $patch.hashCode());
        Object $patchType = this.getPatchType();
        result = result * prime + ($patchType == null ? 43 : $patchType.hashCode());
        Object $status = this.getStatus();
        result = result * prime + ($status == null ? 43 : $status.hashCode());
        Object $uid = this.getUid();
        result = result * prime + ($uid == null ? 43 : $uid.hashCode());
        Object $warnings = this.getWarnings();
        result = result * prime + ($warnings == null ? 43 : $warnings.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "AdmissionResponse(" + "allowed=" + this.getAllowed() + ", auditAnnotations=" + this.getAuditAnnotations() + ", patch=" + this.getPatch() + ", patchType=" + this.getPatchType() + ", status=" + this.getStatus() + ", uid=" + this.getUid() + ", warnings=" + this.getWarnings() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
