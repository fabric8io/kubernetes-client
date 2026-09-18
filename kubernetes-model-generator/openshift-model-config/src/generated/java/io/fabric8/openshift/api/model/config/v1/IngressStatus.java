
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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "componentRoutes",
    "defaultPlacement"
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
public class IngressStatus implements Editable<IngressStatusBuilder>, KubernetesResource
{

    @JsonProperty("componentRoutes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ComponentRouteStatus> componentRoutes = new ArrayList<>();
    @JsonProperty("defaultPlacement")
    private String defaultPlacement;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public IngressStatus() {
    }

    public IngressStatus(List<ComponentRouteStatus> componentRoutes, String defaultPlacement) {
        super();
        this.componentRoutes = componentRoutes;
        this.defaultPlacement = defaultPlacement;
    }

    /**
     * componentRoutes is where participating operators place the current route status for routes whose hostnames and serving certificates can be customized by the cluster-admin.
     */
    @JsonProperty("componentRoutes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ComponentRouteStatus> getComponentRoutes() {
        return componentRoutes;
    }

    /**
     * componentRoutes is where participating operators place the current route status for routes whose hostnames and serving certificates can be customized by the cluster-admin.
     */
    @JsonProperty("componentRoutes")
    public void setComponentRoutes(List<ComponentRouteStatus> componentRoutes) {
        this.componentRoutes = componentRoutes;
    }

    /**
     * defaultPlacement is set at installation time to control which nodes will host the ingress router pods by default. The options are control-plane nodes or worker nodes.<br><p> <br><p> This field works by dictating how the Cluster Ingress Operator will consider unset replicas and nodePlacement fields in IngressController resources when creating the corresponding Deployments.<br><p> <br><p> See the documentation for the IngressController replicas and nodePlacement fields for more information.<br><p> <br><p> When omitted, the default value is Workers
     */
    @JsonProperty("defaultPlacement")
    public String getDefaultPlacement() {
        return defaultPlacement;
    }

    /**
     * defaultPlacement is set at installation time to control which nodes will host the ingress router pods by default. The options are control-plane nodes or worker nodes.<br><p> <br><p> This field works by dictating how the Cluster Ingress Operator will consider unset replicas and nodePlacement fields in IngressController resources when creating the corresponding Deployments.<br><p> <br><p> See the documentation for the IngressController replicas and nodePlacement fields for more information.<br><p> <br><p> When omitted, the default value is Workers
     */
    @JsonProperty("defaultPlacement")
    public void setDefaultPlacement(String defaultPlacement) {
        this.defaultPlacement = defaultPlacement;
    }

    @JsonIgnore
    public IngressStatusBuilder edit() {
        return new IngressStatusBuilder(this);
    }

    @JsonIgnore
    public IngressStatusBuilder toBuilder() {
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
        if (!(o instanceof IngressStatus)) {
            return false;
        }
        IngressStatus other = (IngressStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$componentRoutes = this.getComponentRoutes();
        Object other$componentRoutes = other.getComponentRoutes();
        if (this$componentRoutes == null ? other$componentRoutes != null : !this$componentRoutes.equals(other$componentRoutes)) {
            return false;
        }
        Object this$defaultPlacement = this.getDefaultPlacement();
        Object other$defaultPlacement = other.getDefaultPlacement();
        if (this$defaultPlacement == null ? other$defaultPlacement != null : !this$defaultPlacement.equals(other$defaultPlacement)) {
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
        return other instanceof IngressStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $componentRoutes = this.getComponentRoutes();
        result = result * prime + ($componentRoutes == null ? 43 : $componentRoutes.hashCode());
        Object $defaultPlacement = this.getDefaultPlacement();
        result = result * prime + ($defaultPlacement == null ? 43 : $defaultPlacement.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "IngressStatus(" + "componentRoutes=" + this.getComponentRoutes() + ", defaultPlacement=" + this.getDefaultPlacement() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
