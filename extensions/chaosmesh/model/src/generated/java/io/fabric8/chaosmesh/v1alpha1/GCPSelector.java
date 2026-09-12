
package io.fabric8.chaosmesh.v1alpha1;

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
    "deviceNames",
    "instance",
    "project",
    "zone"
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
public class GCPSelector implements Editable<GCPSelectorBuilder>, KubernetesResource
{

    @JsonProperty("deviceNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> deviceNames = new ArrayList<>();
    @JsonProperty("instance")
    private String instance;
    @JsonProperty("project")
    private String project;
    @JsonProperty("zone")
    private String zone;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public GCPSelector() {
    }

    public GCPSelector(List<String> deviceNames, String instance, String project, String zone) {
        super();
        this.deviceNames = deviceNames;
        this.instance = instance;
        this.project = project;
        this.zone = zone;
    }

    /**
     * The device name of disks to detach. Needed in disk-loss.
     */
    @JsonProperty("deviceNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getDeviceNames() {
        return deviceNames;
    }

    /**
     * The device name of disks to detach. Needed in disk-loss.
     */
    @JsonProperty("deviceNames")
    public void setDeviceNames(List<String> deviceNames) {
        this.deviceNames = deviceNames;
    }

    /**
     * Instance defines the name of the instance
     */
    @JsonProperty("instance")
    public String getInstance() {
        return instance;
    }

    /**
     * Instance defines the name of the instance
     */
    @JsonProperty("instance")
    public void setInstance(String instance) {
        this.instance = instance;
    }

    /**
     * Project defines the ID of gcp project.
     */
    @JsonProperty("project")
    public String getProject() {
        return project;
    }

    /**
     * Project defines the ID of gcp project.
     */
    @JsonProperty("project")
    public void setProject(String project) {
        this.project = project;
    }

    /**
     * Zone defines the zone of gcp project.
     */
    @JsonProperty("zone")
    public String getZone() {
        return zone;
    }

    /**
     * Zone defines the zone of gcp project.
     */
    @JsonProperty("zone")
    public void setZone(String zone) {
        this.zone = zone;
    }

    @JsonIgnore
    public GCPSelectorBuilder edit() {
        return new GCPSelectorBuilder(this);
    }

    @JsonIgnore
    public GCPSelectorBuilder toBuilder() {
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
        if (!(o instanceof GCPSelector)) {
            return false;
        }
        GCPSelector other = (GCPSelector) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$deviceNames = this.getDeviceNames();
        Object other$deviceNames = other.getDeviceNames();
        if (this$deviceNames == null ? other$deviceNames != null : !this$deviceNames.equals(other$deviceNames)) {
            return false;
        }
        Object this$instance = this.getInstance();
        Object other$instance = other.getInstance();
        if (this$instance == null ? other$instance != null : !this$instance.equals(other$instance)) {
            return false;
        }
        Object this$project = this.getProject();
        Object other$project = other.getProject();
        if (this$project == null ? other$project != null : !this$project.equals(other$project)) {
            return false;
        }
        Object this$zone = this.getZone();
        Object other$zone = other.getZone();
        if (this$zone == null ? other$zone != null : !this$zone.equals(other$zone)) {
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
        return other instanceof GCPSelector;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $deviceNames = this.getDeviceNames();
        result = result * prime + ($deviceNames == null ? 43 : $deviceNames.hashCode());
        Object $instance = this.getInstance();
        result = result * prime + ($instance == null ? 43 : $instance.hashCode());
        Object $project = this.getProject();
        result = result * prime + ($project == null ? 43 : $project.hashCode());
        Object $zone = this.getZone();
        result = result * prime + ($zone == null ? 43 : $zone.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "GCPSelector(" + "deviceNames=" + this.getDeviceNames() + ", instance=" + this.getInstance() + ", project=" + this.getProject() + ", zone=" + this.getZone() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
