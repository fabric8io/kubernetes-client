
package io.fabric8.openshift.api.model.machine.v1beta1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
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
import tools.jackson.databind.annotation.JsonDeserialize;

/**
 * DedicatedHost represents the configuration for the usage of dedicated host.
 */
@JsonDeserialize(using = tools.jackson.databind.ValueDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "allocationStrategy",
    "dynamicHostAllocation",
    "id"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectMeta.class),
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
public class DedicatedHost implements Editable<DedicatedHostBuilder>, KubernetesResource
{

    @JsonProperty("allocationStrategy")
    private String allocationStrategy;
    @JsonProperty("dynamicHostAllocation")
    private DynamicHostAllocationSpec dynamicHostAllocation;
    @JsonProperty("id")
    private String id;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public DedicatedHost() {
    }

    public DedicatedHost(String allocationStrategy, DynamicHostAllocationSpec dynamicHostAllocation, String id) {
        super();
        this.allocationStrategy = allocationStrategy;
        this.dynamicHostAllocation = dynamicHostAllocation;
        this.id = id;
    }

    /**
     * allocationStrategy specifies if the dedicated host will be provided by the admin through the id field or if the host will be dynamically allocated. Valid values are UserProvided and Dynamic. When omitted, the value defaults to "UserProvided", which requires the id field to be set. When allocationStrategy is set to UserProvided, an ID of the dedicated host to assign must be provided. When allocationStrategy is set to Dynamic, a dedicated host will be allocated and used to assign instances. When allocationStrategy is set to Dynamic, and dynamicHostAllocation is configured, a dedicated host will be allocated and the tags in dynamicHostAllocation will be assigned to that host.<br><p> <br><p> Possible enum values:<br><p>  - `"Dynamic"` specifies that the system should dynamically allocate a dedicated host for instances.<br><p>  - `"UserProvided"` specifies that the system should assign instances to a user-provided dedicated host.
     */
    @JsonProperty("allocationStrategy")
    public String getAllocationStrategy() {
        return allocationStrategy;
    }

    /**
     * allocationStrategy specifies if the dedicated host will be provided by the admin through the id field or if the host will be dynamically allocated. Valid values are UserProvided and Dynamic. When omitted, the value defaults to "UserProvided", which requires the id field to be set. When allocationStrategy is set to UserProvided, an ID of the dedicated host to assign must be provided. When allocationStrategy is set to Dynamic, a dedicated host will be allocated and used to assign instances. When allocationStrategy is set to Dynamic, and dynamicHostAllocation is configured, a dedicated host will be allocated and the tags in dynamicHostAllocation will be assigned to that host.<br><p> <br><p> Possible enum values:<br><p>  - `"Dynamic"` specifies that the system should dynamically allocate a dedicated host for instances.<br><p>  - `"UserProvided"` specifies that the system should assign instances to a user-provided dedicated host.
     */
    @JsonProperty("allocationStrategy")
    public void setAllocationStrategy(String allocationStrategy) {
        this.allocationStrategy = allocationStrategy;
    }

    /**
     * DedicatedHost represents the configuration for the usage of dedicated host.
     */
    @JsonProperty("dynamicHostAllocation")
    public DynamicHostAllocationSpec getDynamicHostAllocation() {
        return dynamicHostAllocation;
    }

    /**
     * DedicatedHost represents the configuration for the usage of dedicated host.
     */
    @JsonProperty("dynamicHostAllocation")
    public void setDynamicHostAllocation(DynamicHostAllocationSpec dynamicHostAllocation) {
        this.dynamicHostAllocation = dynamicHostAllocation;
    }

    /**
     * id identifies the AWS Dedicated Host on which the instance must run. The value must start with "h-" followed by either 8 or 17 lowercase hexadecimal characters (0-9 and a-f). The use of 8 lowercase hexadecimal characters is for older legacy hosts that may not have been migrated to newer format. Must be either 10 or 19 characters in length. This field is required when allocationStrategy is UserProvided, and forbidden otherwise. When omitted with allocationStrategy set to Dynamic, the platform will dynamically allocate a dedicated host.
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * id identifies the AWS Dedicated Host on which the instance must run. The value must start with "h-" followed by either 8 or 17 lowercase hexadecimal characters (0-9 and a-f). The use of 8 lowercase hexadecimal characters is for older legacy hosts that may not have been migrated to newer format. Must be either 10 or 19 characters in length. This field is required when allocationStrategy is UserProvided, and forbidden otherwise. When omitted with allocationStrategy set to Dynamic, the platform will dynamically allocate a dedicated host.
     */
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonIgnore
    public DedicatedHostBuilder edit() {
        return new DedicatedHostBuilder(this);
    }

    @JsonIgnore
    public DedicatedHostBuilder toBuilder() {
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
