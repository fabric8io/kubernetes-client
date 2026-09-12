
package io.fabric8.openshift.api.model.machine.v1alpha1;

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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "filter",
    "portSecurity",
    "portTags",
    "uuid"
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
public class SubnetParam implements Editable<SubnetParamBuilder>, KubernetesResource
{

    @JsonProperty("filter")
    private SubnetFilter filter;
    @JsonProperty("portSecurity")
    private Boolean portSecurity;
    @JsonProperty("portTags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> portTags = new ArrayList<>();
    @JsonProperty("uuid")
    private String uuid;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public SubnetParam() {
    }

    public SubnetParam(SubnetFilter filter, Boolean portSecurity, List<String> portTags, String uuid) {
        super();
        this.filter = filter;
        this.portSecurity = portSecurity;
        this.portTags = portTags;
        this.uuid = uuid;
    }

    @JsonProperty("filter")
    public SubnetFilter getFilter() {
        return filter;
    }

    @JsonProperty("filter")
    public void setFilter(SubnetFilter filter) {
        this.filter = filter;
    }

    /**
     * portSecurity optionally enables or disables security on ports managed by OpenStack Deprecated: portSecurity is silently ignored. Set portSecurity on the parent network instead.
     */
    @JsonProperty("portSecurity")
    public Boolean getPortSecurity() {
        return portSecurity;
    }

    /**
     * portSecurity optionally enables or disables security on ports managed by OpenStack Deprecated: portSecurity is silently ignored. Set portSecurity on the parent network instead.
     */
    @JsonProperty("portSecurity")
    public void setPortSecurity(Boolean portSecurity) {
        this.portSecurity = portSecurity;
    }

    /**
     * portTags are tags that are added to ports created on this subnet
     */
    @JsonProperty("portTags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getPortTags() {
        return portTags;
    }

    /**
     * portTags are tags that are added to ports created on this subnet
     */
    @JsonProperty("portTags")
    public void setPortTags(List<String> portTags) {
        this.portTags = portTags;
    }

    /**
     * The UUID of the network. Required if you omit the port attribute.
     */
    @JsonProperty("uuid")
    public String getUuid() {
        return uuid;
    }

    /**
     * The UUID of the network. Required if you omit the port attribute.
     */
    @JsonProperty("uuid")
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @JsonIgnore
    public SubnetParamBuilder edit() {
        return new SubnetParamBuilder(this);
    }

    @JsonIgnore
    public SubnetParamBuilder toBuilder() {
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
        if (!(o instanceof SubnetParam)) {
            return false;
        }
        SubnetParam other = (SubnetParam) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$filter = this.getFilter();
        Object other$filter = other.getFilter();
        if (this$filter == null ? other$filter != null : !this$filter.equals(other$filter)) {
            return false;
        }
        Object this$portSecurity = this.getPortSecurity();
        Object other$portSecurity = other.getPortSecurity();
        if (this$portSecurity == null ? other$portSecurity != null : !this$portSecurity.equals(other$portSecurity)) {
            return false;
        }
        Object this$portTags = this.getPortTags();
        Object other$portTags = other.getPortTags();
        if (this$portTags == null ? other$portTags != null : !this$portTags.equals(other$portTags)) {
            return false;
        }
        Object this$uuid = this.getUuid();
        Object other$uuid = other.getUuid();
        if (this$uuid == null ? other$uuid != null : !this$uuid.equals(other$uuid)) {
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
        return other instanceof SubnetParam;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $filter = this.getFilter();
        result = result * prime + ($filter == null ? 43 : $filter.hashCode());
        Object $portSecurity = this.getPortSecurity();
        result = result * prime + ($portSecurity == null ? 43 : $portSecurity.hashCode());
        Object $portTags = this.getPortTags();
        result = result * prime + ($portTags == null ? 43 : $portTags.hashCode());
        Object $uuid = this.getUuid();
        result = result * prime + ($uuid == null ? 43 : $uuid.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "SubnetParam(" + "filter=" + this.getFilter() + ", portSecurity=" + this.getPortSecurity() + ", portTags=" + this.getPortTags() + ", uuid=" + this.getUuid() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
