
package io.fabric8.openshift.api.model.hive.v1;

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
import io.fabric8.kubernetes.api.model.rbac.Subject;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * ClusterClaimSpec defines the desired state of the ClusterClaim.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "clusterPoolName",
    "lifetime",
    "namespace",
    "subjects"
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
public class ClusterClaimSpec implements Editable<ClusterClaimSpecBuilder>, KubernetesResource
{

    @JsonProperty("clusterPoolName")
    private String clusterPoolName;
    @JsonProperty("lifetime")
    private String lifetime;
    @JsonProperty("namespace")
    private String namespace;
    @JsonProperty("subjects")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Subject> subjects = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ClusterClaimSpec() {
    }

    public ClusterClaimSpec(String clusterPoolName, String lifetime, String namespace, List<Subject> subjects) {
        super();
        this.clusterPoolName = clusterPoolName;
        this.lifetime = lifetime;
        this.namespace = namespace;
        this.subjects = subjects;
    }

    /**
     * ClusterPoolName is the name of the cluster pool from which to claim a cluster.
     */
    @JsonProperty("clusterPoolName")
    public String getClusterPoolName() {
        return clusterPoolName;
    }

    /**
     * ClusterPoolName is the name of the cluster pool from which to claim a cluster.
     */
    @JsonProperty("clusterPoolName")
    public void setClusterPoolName(String clusterPoolName) {
        this.clusterPoolName = clusterPoolName;
    }

    /**
     * ClusterClaimSpec defines the desired state of the ClusterClaim.
     */
    @JsonProperty("lifetime")
    public String getLifetime() {
        return lifetime;
    }

    /**
     * ClusterClaimSpec defines the desired state of the ClusterClaim.
     */
    @JsonProperty("lifetime")
    public void setLifetime(String lifetime) {
        this.lifetime = lifetime;
    }

    /**
     * Namespace is the namespace containing the ClusterDeployment (name will match the namespace) of the claimed cluster. This field will be set as soon as a suitable cluster can be found, however that cluster may still be resuming and not yet ready for use. Wait for the ClusterRunning condition to be true to avoid this issue.
     */
    @JsonProperty("namespace")
    public String getNamespace() {
        return namespace;
    }

    /**
     * Namespace is the namespace containing the ClusterDeployment (name will match the namespace) of the claimed cluster. This field will be set as soon as a suitable cluster can be found, however that cluster may still be resuming and not yet ready for use. Wait for the ClusterRunning condition to be true to avoid this issue.
     */
    @JsonProperty("namespace")
    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    /**
     * Subjects hold references to which to authorize access to the claimed cluster.
     */
    @JsonProperty("subjects")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Subject> getSubjects() {
        return subjects;
    }

    /**
     * Subjects hold references to which to authorize access to the claimed cluster.
     */
    @JsonProperty("subjects")
    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    @JsonIgnore
    public ClusterClaimSpecBuilder edit() {
        return new ClusterClaimSpecBuilder(this);
    }

    @JsonIgnore
    public ClusterClaimSpecBuilder toBuilder() {
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
        if (!(o instanceof ClusterClaimSpec)) {
            return false;
        }
        ClusterClaimSpec other = (ClusterClaimSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$clusterPoolName = this.getClusterPoolName();
        Object other$clusterPoolName = other.getClusterPoolName();
        if (this$clusterPoolName == null ? other$clusterPoolName != null : !this$clusterPoolName.equals(other$clusterPoolName)) {
            return false;
        }
        Object this$lifetime = this.getLifetime();
        Object other$lifetime = other.getLifetime();
        if (this$lifetime == null ? other$lifetime != null : !this$lifetime.equals(other$lifetime)) {
            return false;
        }
        Object this$namespace = this.getNamespace();
        Object other$namespace = other.getNamespace();
        if (this$namespace == null ? other$namespace != null : !this$namespace.equals(other$namespace)) {
            return false;
        }
        Object this$subjects = this.getSubjects();
        Object other$subjects = other.getSubjects();
        if (this$subjects == null ? other$subjects != null : !this$subjects.equals(other$subjects)) {
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
        return other instanceof ClusterClaimSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $clusterPoolName = this.getClusterPoolName();
        result = result * prime + ($clusterPoolName == null ? 43 : $clusterPoolName.hashCode());
        Object $lifetime = this.getLifetime();
        result = result * prime + ($lifetime == null ? 43 : $lifetime.hashCode());
        Object $namespace = this.getNamespace();
        result = result * prime + ($namespace == null ? 43 : $namespace.hashCode());
        Object $subjects = this.getSubjects();
        result = result * prime + ($subjects == null ? 43 : $subjects.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ClusterClaimSpec(" + "clusterPoolName=" + this.getClusterPoolName() + ", lifetime=" + this.getLifetime() + ", namespace=" + this.getNamespace() + ", subjects=" + this.getSubjects() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
