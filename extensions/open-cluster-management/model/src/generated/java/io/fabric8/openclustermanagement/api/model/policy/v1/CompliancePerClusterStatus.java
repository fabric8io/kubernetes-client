
package io.fabric8.openclustermanagement.api.model.policy.v1;

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
 * CompliancePerClusterStatus reports the name of a managed cluster and its compliance state for this policy.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "clustername",
    "clusternamespace",
    "compliant"
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
public class CompliancePerClusterStatus implements Editable<CompliancePerClusterStatusBuilder>, KubernetesResource
{

    @JsonProperty("clustername")
    private String clustername;
    @JsonProperty("clusternamespace")
    private String clusternamespace;
    @JsonProperty("compliant")
    private String compliant;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public CompliancePerClusterStatus() {
    }

    public CompliancePerClusterStatus(String clustername, String clusternamespace, String compliant) {
        super();
        this.clustername = clustername;
        this.clusternamespace = clusternamespace;
        this.compliant = compliant;
    }

    /**
     * CompliancePerClusterStatus reports the name of a managed cluster and its compliance state for this policy.
     */
    @JsonProperty("clustername")
    public String getClustername() {
        return clustername;
    }

    /**
     * CompliancePerClusterStatus reports the name of a managed cluster and its compliance state for this policy.
     */
    @JsonProperty("clustername")
    public void setClustername(String clustername) {
        this.clustername = clustername;
    }

    /**
     * CompliancePerClusterStatus reports the name of a managed cluster and its compliance state for this policy.
     */
    @JsonProperty("clusternamespace")
    public String getClusternamespace() {
        return clusternamespace;
    }

    /**
     * CompliancePerClusterStatus reports the name of a managed cluster and its compliance state for this policy.
     */
    @JsonProperty("clusternamespace")
    public void setClusternamespace(String clusternamespace) {
        this.clusternamespace = clusternamespace;
    }

    /**
     * CompliancePerClusterStatus reports the name of a managed cluster and its compliance state for this policy.
     */
    @JsonProperty("compliant")
    public String getCompliant() {
        return compliant;
    }

    /**
     * CompliancePerClusterStatus reports the name of a managed cluster and its compliance state for this policy.
     */
    @JsonProperty("compliant")
    public void setCompliant(String compliant) {
        this.compliant = compliant;
    }

    @JsonIgnore
    public CompliancePerClusterStatusBuilder edit() {
        return new CompliancePerClusterStatusBuilder(this);
    }

    @JsonIgnore
    public CompliancePerClusterStatusBuilder toBuilder() {
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
        if (!(o instanceof CompliancePerClusterStatus)) {
            return false;
        }
        CompliancePerClusterStatus other = (CompliancePerClusterStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$clustername = this.getClustername();
        Object other$clustername = other.getClustername();
        if (this$clustername == null ? other$clustername != null : !this$clustername.equals(other$clustername)) {
            return false;
        }
        Object this$clusternamespace = this.getClusternamespace();
        Object other$clusternamespace = other.getClusternamespace();
        if (this$clusternamespace == null ? other$clusternamespace != null : !this$clusternamespace.equals(other$clusternamespace)) {
            return false;
        }
        Object this$compliant = this.getCompliant();
        Object other$compliant = other.getCompliant();
        if (this$compliant == null ? other$compliant != null : !this$compliant.equals(other$compliant)) {
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
        return other instanceof CompliancePerClusterStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $clustername = this.getClustername();
        result = result * prime + ($clustername == null ? 43 : $clustername.hashCode());
        Object $clusternamespace = this.getClusternamespace();
        result = result * prime + ($clusternamespace == null ? 43 : $clusternamespace.hashCode());
        Object $compliant = this.getCompliant();
        result = result * prime + ($compliant == null ? 43 : $compliant.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "CompliancePerClusterStatus(" + "clustername=" + this.getClustername() + ", clusternamespace=" + this.getClusternamespace() + ", compliant=" + this.getCompliant() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
