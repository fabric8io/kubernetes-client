
package io.fabric8.openclustermanagement.api.model.operator.v1;

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
 * ClusterManagerDeployOption describes the deployment options for cluster-manager
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "default",
    "hosted",
    "mode"
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
public class ClusterManagerDeployOption implements Editable<ClusterManagerDeployOptionBuilder>, KubernetesResource
{

    @JsonProperty("default")
    private DefaultClusterManagerConfiguration _default;
    @JsonProperty("hosted")
    private HostedClusterManagerConfiguration hosted;
    @JsonProperty("mode")
    private String mode;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ClusterManagerDeployOption() {
    }

    public ClusterManagerDeployOption(DefaultClusterManagerConfiguration _default, HostedClusterManagerConfiguration hosted, String mode) {
        super();
        this._default = _default;
        this.hosted = hosted;
        this.mode = mode;
    }

    /**
     * ClusterManagerDeployOption describes the deployment options for cluster-manager
     */
    @JsonProperty("default")
    public DefaultClusterManagerConfiguration getDefault() {
        return _default;
    }

    /**
     * ClusterManagerDeployOption describes the deployment options for cluster-manager
     */
    @JsonProperty("default")
    public void setDefault(DefaultClusterManagerConfiguration _default) {
        this._default = _default;
    }

    /**
     * ClusterManagerDeployOption describes the deployment options for cluster-manager
     */
    @JsonProperty("hosted")
    public HostedClusterManagerConfiguration getHosted() {
        return hosted;
    }

    /**
     * ClusterManagerDeployOption describes the deployment options for cluster-manager
     */
    @JsonProperty("hosted")
    public void setHosted(HostedClusterManagerConfiguration hosted) {
        this.hosted = hosted;
    }

    /**
     * Mode can be Default or Hosted. In Default mode, the Hub is installed as a whole and all parts of Hub are deployed in the same cluster. In Hosted mode, only crd and configurations are installed on one cluster(defined as hub-cluster). Controllers run in another cluster (defined as management-cluster) and connect to the hub with the kubeconfig in secret of "external-hub-kubeconfig"(a kubeconfig of hub-cluster with cluster-admin permission). Note: Do not modify the Mode field once it's applied.
     */
    @JsonProperty("mode")
    public String getMode() {
        return mode;
    }

    /**
     * Mode can be Default or Hosted. In Default mode, the Hub is installed as a whole and all parts of Hub are deployed in the same cluster. In Hosted mode, only crd and configurations are installed on one cluster(defined as hub-cluster). Controllers run in another cluster (defined as management-cluster) and connect to the hub with the kubeconfig in secret of "external-hub-kubeconfig"(a kubeconfig of hub-cluster with cluster-admin permission). Note: Do not modify the Mode field once it's applied.
     */
    @JsonProperty("mode")
    public void setMode(String mode) {
        this.mode = mode;
    }

    @JsonIgnore
    public ClusterManagerDeployOptionBuilder edit() {
        return new ClusterManagerDeployOptionBuilder(this);
    }

    @JsonIgnore
    public ClusterManagerDeployOptionBuilder toBuilder() {
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
        if (!(o instanceof ClusterManagerDeployOption)) {
            return false;
        }
        ClusterManagerDeployOption other = (ClusterManagerDeployOption) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$_default = this.getDefault();
        Object other$_default = other.getDefault();
        if (this$_default == null ? other$_default != null : !this$_default.equals(other$_default)) {
            return false;
        }
        Object this$hosted = this.getHosted();
        Object other$hosted = other.getHosted();
        if (this$hosted == null ? other$hosted != null : !this$hosted.equals(other$hosted)) {
            return false;
        }
        Object this$mode = this.getMode();
        Object other$mode = other.getMode();
        if (this$mode == null ? other$mode != null : !this$mode.equals(other$mode)) {
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
        return other instanceof ClusterManagerDeployOption;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $_default = this.getDefault();
        result = result * prime + ($_default == null ? 43 : $_default.hashCode());
        Object $hosted = this.getHosted();
        result = result * prime + ($hosted == null ? 43 : $hosted.hashCode());
        Object $mode = this.getMode();
        result = result * prime + ($mode == null ? 43 : $mode.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ClusterManagerDeployOption(" + "_default=" + this.getDefault() + ", hosted=" + this.getHosted() + ", mode=" + this.getMode() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
