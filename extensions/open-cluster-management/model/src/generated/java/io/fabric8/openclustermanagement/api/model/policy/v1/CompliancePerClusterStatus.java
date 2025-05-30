
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

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
@ToString
@EqualsAndHashCode
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

}
