
package io.fabric8.openshift.api.model.config.v1;

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
 * VSphereFailureDomainHostGroup holds the vmGroup and the hostGroup names in vCenter corresponds to a vm-host group of type Virtual Machine and Host respectively. Is also contains the vmHostRule which is an affinity vm-host rule in vCenter.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "hostGroup",
    "vmGroup",
    "vmHostRule"
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
public class VSphereFailureDomainHostGroup implements Editable<VSphereFailureDomainHostGroupBuilder>, KubernetesResource
{

    @JsonProperty("hostGroup")
    private String hostGroup;
    @JsonProperty("vmGroup")
    private String vmGroup;
    @JsonProperty("vmHostRule")
    private String vmHostRule;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public VSphereFailureDomainHostGroup() {
    }

    public VSphereFailureDomainHostGroup(String hostGroup, String vmGroup, String vmHostRule) {
        super();
        this.hostGroup = hostGroup;
        this.vmGroup = vmGroup;
        this.vmHostRule = vmHostRule;
    }

    /**
     * hostGroup is the name of the vm-host group of type host within vCenter for this failure domain. hostGroup is limited to 80 characters. This field is required when the VSphereFailureDomain ZoneType is HostGroup
     */
    @JsonProperty("hostGroup")
    public String getHostGroup() {
        return hostGroup;
    }

    /**
     * hostGroup is the name of the vm-host group of type host within vCenter for this failure domain. hostGroup is limited to 80 characters. This field is required when the VSphereFailureDomain ZoneType is HostGroup
     */
    @JsonProperty("hostGroup")
    public void setHostGroup(String hostGroup) {
        this.hostGroup = hostGroup;
    }

    /**
     * vmGroup is the name of the vm-host group of type virtual machine within vCenter for this failure domain. vmGroup is limited to 80 characters. This field is required when the VSphereFailureDomain ZoneType is HostGroup
     */
    @JsonProperty("vmGroup")
    public String getVmGroup() {
        return vmGroup;
    }

    /**
     * vmGroup is the name of the vm-host group of type virtual machine within vCenter for this failure domain. vmGroup is limited to 80 characters. This field is required when the VSphereFailureDomain ZoneType is HostGroup
     */
    @JsonProperty("vmGroup")
    public void setVmGroup(String vmGroup) {
        this.vmGroup = vmGroup;
    }

    /**
     * vmHostRule is the name of the affinity vm-host rule within vCenter for this failure domain. vmHostRule is limited to 80 characters. This field is required when the VSphereFailureDomain ZoneType is HostGroup
     */
    @JsonProperty("vmHostRule")
    public String getVmHostRule() {
        return vmHostRule;
    }

    /**
     * vmHostRule is the name of the affinity vm-host rule within vCenter for this failure domain. vmHostRule is limited to 80 characters. This field is required when the VSphereFailureDomain ZoneType is HostGroup
     */
    @JsonProperty("vmHostRule")
    public void setVmHostRule(String vmHostRule) {
        this.vmHostRule = vmHostRule;
    }

    @JsonIgnore
    public VSphereFailureDomainHostGroupBuilder edit() {
        return new VSphereFailureDomainHostGroupBuilder(this);
    }

    @JsonIgnore
    public VSphereFailureDomainHostGroupBuilder toBuilder() {
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
