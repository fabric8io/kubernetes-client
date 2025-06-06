
package io.fabric8.openshift.api.model.config.v1;

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
 * NutanixFailureDomain configures failure domain information for the Nutanix platform.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "cluster",
    "name",
    "subnets"
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
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class NutanixFailureDomain implements Editable<NutanixFailureDomainBuilder>, KubernetesResource
{

    @JsonProperty("cluster")
    private NutanixResourceIdentifier cluster;
    @JsonProperty("name")
    private String name;
    @JsonProperty("subnets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NutanixResourceIdentifier> subnets = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public NutanixFailureDomain() {
    }

    public NutanixFailureDomain(NutanixResourceIdentifier cluster, String name, List<NutanixResourceIdentifier> subnets) {
        super();
        this.cluster = cluster;
        this.name = name;
        this.subnets = subnets;
    }

    /**
     * NutanixFailureDomain configures failure domain information for the Nutanix platform.
     */
    @JsonProperty("cluster")
    public NutanixResourceIdentifier getCluster() {
        return cluster;
    }

    /**
     * NutanixFailureDomain configures failure domain information for the Nutanix platform.
     */
    @JsonProperty("cluster")
    public void setCluster(NutanixResourceIdentifier cluster) {
        this.cluster = cluster;
    }

    /**
     * name defines the unique name of a failure domain. Name is required and must be at most 64 characters in length. It must consist of only lower case alphanumeric characters and hyphens (-). It must start and end with an alphanumeric character. This value is arbitrary and is used to identify the failure domain within the platform.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * name defines the unique name of a failure domain. Name is required and must be at most 64 characters in length. It must consist of only lower case alphanumeric characters and hyphens (-). It must start and end with an alphanumeric character. This value is arbitrary and is used to identify the failure domain within the platform.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * subnets holds a list of identifiers (one or more) of the cluster's network subnets If the feature gate NutanixMultiSubnets is enabled, up to 32 subnets may be configured. for the Machine's VM to connect to. The subnet identifiers (uuid or name) can be obtained from the Prism Central console or using the prism_central API.
     */
    @JsonProperty("subnets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<NutanixResourceIdentifier> getSubnets() {
        return subnets;
    }

    /**
     * subnets holds a list of identifiers (one or more) of the cluster's network subnets If the feature gate NutanixMultiSubnets is enabled, up to 32 subnets may be configured. for the Machine's VM to connect to. The subnet identifiers (uuid or name) can be obtained from the Prism Central console or using the prism_central API.
     */
    @JsonProperty("subnets")
    public void setSubnets(List<NutanixResourceIdentifier> subnets) {
        this.subnets = subnets;
    }

    @JsonIgnore
    public NutanixFailureDomainBuilder edit() {
        return new NutanixFailureDomainBuilder(this);
    }

    @JsonIgnore
    public NutanixFailureDomainBuilder toBuilder() {
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
