
package io.fabric8.kubernetes.api.model.resource.v1alpha2;

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
 * ResourceFilter is a filter for resources from one particular driver.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "driverName",
    "namedResources"
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
public class ResourceFilter implements Editable<ResourceFilterBuilder>, KubernetesResource
{

    @JsonProperty("driverName")
    private String driverName;
    @JsonProperty("namedResources")
    private NamedResourcesFilter namedResources;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ResourceFilter() {
    }

    public ResourceFilter(String driverName, NamedResourcesFilter namedResources) {
        super();
        this.driverName = driverName;
        this.namedResources = namedResources;
    }

    /**
     * DriverName is the name used by the DRA driver kubelet plugin.
     */
    @JsonProperty("driverName")
    public String getDriverName() {
        return driverName;
    }

    /**
     * DriverName is the name used by the DRA driver kubelet plugin.
     */
    @JsonProperty("driverName")
    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    /**
     * ResourceFilter is a filter for resources from one particular driver.
     */
    @JsonProperty("namedResources")
    public NamedResourcesFilter getNamedResources() {
        return namedResources;
    }

    /**
     * ResourceFilter is a filter for resources from one particular driver.
     */
    @JsonProperty("namedResources")
    public void setNamedResources(NamedResourcesFilter namedResources) {
        this.namedResources = namedResources;
    }

    @JsonIgnore
    public ResourceFilterBuilder edit() {
        return new ResourceFilterBuilder(this);
    }

    @JsonIgnore
    public ResourceFilterBuilder toBuilder() {
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
        if (!(o instanceof ResourceFilter)) {
            return false;
        }
        ResourceFilter other = (ResourceFilter) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$driverName = this.getDriverName();
        Object other$driverName = other.getDriverName();
        if (this$driverName == null ? other$driverName != null : !this$driverName.equals(other$driverName)) {
            return false;
        }
        Object this$namedResources = this.getNamedResources();
        Object other$namedResources = other.getNamedResources();
        if (this$namedResources == null ? other$namedResources != null : !this$namedResources.equals(other$namedResources)) {
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
        return other instanceof ResourceFilter;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $driverName = this.getDriverName();
        result = result * prime + ($driverName == null ? 43 : $driverName.hashCode());
        Object $namedResources = this.getNamedResources();
        result = result * prime + ($namedResources == null ? 43 : $namedResources.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ResourceFilter(" + "driverName=" + this.getDriverName() + ", namedResources=" + this.getNamedResources() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
