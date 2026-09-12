
package io.fabric8.istio.api.api.networking.v1alpha3;

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
 * Conditions specified in `ClusterMatch` must be met for the patch to be applied to a cluster.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "portNumber",
    "service",
    "subset"
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
public class EnvoyFilterClusterMatch implements Editable<EnvoyFilterClusterMatchBuilder>, KubernetesResource
{

    @JsonProperty("name")
    private String name;
    @JsonProperty("portNumber")
    private Long portNumber;
    @JsonProperty("service")
    private String service;
    @JsonProperty("subset")
    private String subset;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public EnvoyFilterClusterMatch() {
    }

    public EnvoyFilterClusterMatch(String name, Long portNumber, String service, String subset) {
        super();
        this.name = name;
        this.portNumber = portNumber;
        this.service = service;
        this.subset = subset;
    }

    /**
     * The exact name of the cluster to match. To match a specific cluster by name, such as the internally generated `Passthrough` cluster, leave all fields in clusterMatch empty, except the name.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * The exact name of the cluster to match. To match a specific cluster by name, such as the internally generated `Passthrough` cluster, leave all fields in clusterMatch empty, except the name.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * The service port for which this cluster was generated.  If omitted, applies to clusters for any port. &#42;&#42;Note:&#42;&#42; for inbound cluster, it is the service target port.
     */
    @JsonProperty("portNumber")
    public Long getPortNumber() {
        return portNumber;
    }

    /**
     * The service port for which this cluster was generated.  If omitted, applies to clusters for any port. &#42;&#42;Note:&#42;&#42; for inbound cluster, it is the service target port.
     */
    @JsonProperty("portNumber")
    public void setPortNumber(Long portNumber) {
        this.portNumber = portNumber;
    }

    /**
     * The fully qualified service name for this cluster. If omitted, applies to clusters for any service. For services defined through service entries, the service name is same as the hosts defined in the service entry. &#42;&#42;Note:&#42;&#42; for inbound cluster, this is ignored.
     */
    @JsonProperty("service")
    public String getService() {
        return service;
    }

    /**
     * The fully qualified service name for this cluster. If omitted, applies to clusters for any service. For services defined through service entries, the service name is same as the hosts defined in the service entry. &#42;&#42;Note:&#42;&#42; for inbound cluster, this is ignored.
     */
    @JsonProperty("service")
    public void setService(String service) {
        this.service = service;
    }

    /**
     * The subset associated with the service. If omitted, applies to clusters for any subset of a service.
     */
    @JsonProperty("subset")
    public String getSubset() {
        return subset;
    }

    /**
     * The subset associated with the service. If omitted, applies to clusters for any subset of a service.
     */
    @JsonProperty("subset")
    public void setSubset(String subset) {
        this.subset = subset;
    }

    @JsonIgnore
    public EnvoyFilterClusterMatchBuilder edit() {
        return new EnvoyFilterClusterMatchBuilder(this);
    }

    @JsonIgnore
    public EnvoyFilterClusterMatchBuilder toBuilder() {
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
        if (!(o instanceof EnvoyFilterClusterMatch)) {
            return false;
        }
        EnvoyFilterClusterMatch other = (EnvoyFilterClusterMatch) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        Object this$portNumber = this.getPortNumber();
        Object other$portNumber = other.getPortNumber();
        if (this$portNumber == null ? other$portNumber != null : !this$portNumber.equals(other$portNumber)) {
            return false;
        }
        Object this$service = this.getService();
        Object other$service = other.getService();
        if (this$service == null ? other$service != null : !this$service.equals(other$service)) {
            return false;
        }
        Object this$subset = this.getSubset();
        Object other$subset = other.getSubset();
        if (this$subset == null ? other$subset != null : !this$subset.equals(other$subset)) {
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
        return other instanceof EnvoyFilterClusterMatch;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $portNumber = this.getPortNumber();
        result = result * prime + ($portNumber == null ? 43 : $portNumber.hashCode());
        Object $service = this.getService();
        result = result * prime + ($service == null ? 43 : $service.hashCode());
        Object $subset = this.getSubset();
        result = result * prime + ($subset == null ? 43 : $subset.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "EnvoyFilterClusterMatch(" + "name=" + this.getName() + ", portNumber=" + this.getPortNumber() + ", service=" + this.getService() + ", subset=" + this.getSubset() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
