
package io.fabric8.istio.api.api.networking.v1alpha3;

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
