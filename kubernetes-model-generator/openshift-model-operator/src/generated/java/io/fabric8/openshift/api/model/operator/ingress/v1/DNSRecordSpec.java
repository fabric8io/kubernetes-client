
package io.fabric8.openshift.api.model.operator.ingress.v1;

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
 * DNSRecordSpec contains the details of a DNS record.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "dnsManagementPolicy",
    "dnsName",
    "recordTTL",
    "recordType",
    "targets"
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
public class DNSRecordSpec implements Editable<DNSRecordSpecBuilder>, KubernetesResource
{

    @JsonProperty("dnsManagementPolicy")
    private String dnsManagementPolicy;
    @JsonProperty("dnsName")
    private String dnsName;
    @JsonProperty("recordTTL")
    private Long recordTTL;
    @JsonProperty("recordType")
    private String recordType;
    @JsonProperty("targets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> targets = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public DNSRecordSpec() {
    }

    public DNSRecordSpec(String dnsManagementPolicy, String dnsName, Long recordTTL, String recordType, List<String> targets) {
        super();
        this.dnsManagementPolicy = dnsManagementPolicy;
        this.dnsName = dnsName;
        this.recordTTL = recordTTL;
        this.recordType = recordType;
        this.targets = targets;
    }

    /**
     * dnsManagementPolicy denotes the current policy applied on the DNS record. Records that have policy set as "Unmanaged" are ignored by the ingress operator.  This means that the DNS record on the cloud provider is not managed by the operator, and the "Published" status condition will be updated to "Unknown" status, since it is externally managed. Any existing record on the cloud provider can be deleted at the discretion of the cluster admin.<br><p> <br><p> This field defaults to Managed. Valid values are "Managed" and "Unmanaged".
     */
    @JsonProperty("dnsManagementPolicy")
    public String getDnsManagementPolicy() {
        return dnsManagementPolicy;
    }

    /**
     * dnsManagementPolicy denotes the current policy applied on the DNS record. Records that have policy set as "Unmanaged" are ignored by the ingress operator.  This means that the DNS record on the cloud provider is not managed by the operator, and the "Published" status condition will be updated to "Unknown" status, since it is externally managed. Any existing record on the cloud provider can be deleted at the discretion of the cluster admin.<br><p> <br><p> This field defaults to Managed. Valid values are "Managed" and "Unmanaged".
     */
    @JsonProperty("dnsManagementPolicy")
    public void setDnsManagementPolicy(String dnsManagementPolicy) {
        this.dnsManagementPolicy = dnsManagementPolicy;
    }

    /**
     * dnsName is the hostname of the DNS record
     */
    @JsonProperty("dnsName")
    public String getDnsName() {
        return dnsName;
    }

    /**
     * dnsName is the hostname of the DNS record
     */
    @JsonProperty("dnsName")
    public void setDnsName(String dnsName) {
        this.dnsName = dnsName;
    }

    /**
     * recordTTL is the record TTL in seconds. If zero, the default is 30. RecordTTL will not be used in AWS regions Alias targets, but will be used in CNAME targets, per AWS API contract.
     */
    @JsonProperty("recordTTL")
    public Long getRecordTTL() {
        return recordTTL;
    }

    /**
     * recordTTL is the record TTL in seconds. If zero, the default is 30. RecordTTL will not be used in AWS regions Alias targets, but will be used in CNAME targets, per AWS API contract.
     */
    @JsonProperty("recordTTL")
    public void setRecordTTL(Long recordTTL) {
        this.recordTTL = recordTTL;
    }

    /**
     * recordType is the DNS record type. For example, "A" or "CNAME".
     */
    @JsonProperty("recordType")
    public String getRecordType() {
        return recordType;
    }

    /**
     * recordType is the DNS record type. For example, "A" or "CNAME".
     */
    @JsonProperty("recordType")
    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    /**
     * targets are record targets.
     */
    @JsonProperty("targets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getTargets() {
        return targets;
    }

    /**
     * targets are record targets.
     */
    @JsonProperty("targets")
    public void setTargets(List<String> targets) {
        this.targets = targets;
    }

    @JsonIgnore
    public DNSRecordSpecBuilder edit() {
        return new DNSRecordSpecBuilder(this);
    }

    @JsonIgnore
    public DNSRecordSpecBuilder toBuilder() {
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
        if (!(o instanceof DNSRecordSpec)) {
            return false;
        }
        DNSRecordSpec other = (DNSRecordSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$dnsManagementPolicy = this.getDnsManagementPolicy();
        Object other$dnsManagementPolicy = other.getDnsManagementPolicy();
        if (this$dnsManagementPolicy == null ? other$dnsManagementPolicy != null : !this$dnsManagementPolicy.equals(other$dnsManagementPolicy)) {
            return false;
        }
        Object this$dnsName = this.getDnsName();
        Object other$dnsName = other.getDnsName();
        if (this$dnsName == null ? other$dnsName != null : !this$dnsName.equals(other$dnsName)) {
            return false;
        }
        Object this$recordTTL = this.getRecordTTL();
        Object other$recordTTL = other.getRecordTTL();
        if (this$recordTTL == null ? other$recordTTL != null : !this$recordTTL.equals(other$recordTTL)) {
            return false;
        }
        Object this$recordType = this.getRecordType();
        Object other$recordType = other.getRecordType();
        if (this$recordType == null ? other$recordType != null : !this$recordType.equals(other$recordType)) {
            return false;
        }
        Object this$targets = this.getTargets();
        Object other$targets = other.getTargets();
        if (this$targets == null ? other$targets != null : !this$targets.equals(other$targets)) {
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
        return other instanceof DNSRecordSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $dnsManagementPolicy = this.getDnsManagementPolicy();
        result = result * prime + ($dnsManagementPolicy == null ? 43 : $dnsManagementPolicy.hashCode());
        Object $dnsName = this.getDnsName();
        result = result * prime + ($dnsName == null ? 43 : $dnsName.hashCode());
        Object $recordTTL = this.getRecordTTL();
        result = result * prime + ($recordTTL == null ? 43 : $recordTTL.hashCode());
        Object $recordType = this.getRecordType();
        result = result * prime + ($recordType == null ? 43 : $recordType.hashCode());
        Object $targets = this.getTargets();
        result = result * prime + ($targets == null ? 43 : $targets.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "DNSRecordSpec(" + "dnsManagementPolicy=" + this.getDnsManagementPolicy() + ", dnsName=" + this.getDnsName() + ", recordTTL=" + this.getRecordTTL() + ", recordType=" + this.getRecordType() + ", targets=" + this.getTargets() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
