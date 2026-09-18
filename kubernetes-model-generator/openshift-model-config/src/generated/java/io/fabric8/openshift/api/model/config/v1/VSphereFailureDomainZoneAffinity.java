
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

/**
 * VSphereFailureDomainZoneAffinity contains the vCenter cluster vm-host group (virtual machine and host types) and the vm-host affinity rule that together creates an affinity configuration for vm-host based zonal. This configuration within vCenter creates the required association between a failure domain, virtual machines and ESXi hosts to create a vm-host based zone.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "hostGroup",
    "type"
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
public class VSphereFailureDomainZoneAffinity implements Editable<VSphereFailureDomainZoneAffinityBuilder>, KubernetesResource
{

    @JsonProperty("hostGroup")
    private VSphereFailureDomainHostGroup hostGroup;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public VSphereFailureDomainZoneAffinity() {
    }

    public VSphereFailureDomainZoneAffinity(VSphereFailureDomainHostGroup hostGroup, String type) {
        super();
        this.hostGroup = hostGroup;
        this.type = type;
    }

    /**
     * VSphereFailureDomainZoneAffinity contains the vCenter cluster vm-host group (virtual machine and host types) and the vm-host affinity rule that together creates an affinity configuration for vm-host based zonal. This configuration within vCenter creates the required association between a failure domain, virtual machines and ESXi hosts to create a vm-host based zone.
     */
    @JsonProperty("hostGroup")
    public VSphereFailureDomainHostGroup getHostGroup() {
        return hostGroup;
    }

    /**
     * VSphereFailureDomainZoneAffinity contains the vCenter cluster vm-host group (virtual machine and host types) and the vm-host affinity rule that together creates an affinity configuration for vm-host based zonal. This configuration within vCenter creates the required association between a failure domain, virtual machines and ESXi hosts to create a vm-host based zone.
     */
    @JsonProperty("hostGroup")
    public void setHostGroup(VSphereFailureDomainHostGroup hostGroup) {
        this.hostGroup = hostGroup;
    }

    /**
     * type determines the vSphere object type for a zone within this failure domain. Available types are ComputeCluster and HostGroup. When set to ComputeCluster, this means the vCenter cluster defined is the zone. When set to HostGroup, hostGroup must be configured with hostGroup, vmGroup and vmHostRule and this means the zone is defined by the grouping of those fields.<br><p> <br><p> Possible enum values:<br><p>  - `"ComputeCluster"` is a failure domain zone for a vCenter compute cluster.<br><p>  - `"HostGroup"` is a failure domain zone for a vCenter vm-host group.
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * type determines the vSphere object type for a zone within this failure domain. Available types are ComputeCluster and HostGroup. When set to ComputeCluster, this means the vCenter cluster defined is the zone. When set to HostGroup, hostGroup must be configured with hostGroup, vmGroup and vmHostRule and this means the zone is defined by the grouping of those fields.<br><p> <br><p> Possible enum values:<br><p>  - `"ComputeCluster"` is a failure domain zone for a vCenter compute cluster.<br><p>  - `"HostGroup"` is a failure domain zone for a vCenter vm-host group.
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    public VSphereFailureDomainZoneAffinityBuilder edit() {
        return new VSphereFailureDomainZoneAffinityBuilder(this);
    }

    @JsonIgnore
    public VSphereFailureDomainZoneAffinityBuilder toBuilder() {
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
        if (!(o instanceof VSphereFailureDomainZoneAffinity)) {
            return false;
        }
        VSphereFailureDomainZoneAffinity other = (VSphereFailureDomainZoneAffinity) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$hostGroup = this.getHostGroup();
        Object other$hostGroup = other.getHostGroup();
        if (this$hostGroup == null ? other$hostGroup != null : !this$hostGroup.equals(other$hostGroup)) {
            return false;
        }
        Object this$type = this.getType();
        Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) {
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
        return other instanceof VSphereFailureDomainZoneAffinity;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $hostGroup = this.getHostGroup();
        result = result * prime + ($hostGroup == null ? 43 : $hostGroup.hashCode());
        Object $type = this.getType();
        result = result * prime + ($type == null ? 43 : $type.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "VSphereFailureDomainZoneAffinity(" + "hostGroup=" + this.getHostGroup() + ", type=" + this.getType() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
