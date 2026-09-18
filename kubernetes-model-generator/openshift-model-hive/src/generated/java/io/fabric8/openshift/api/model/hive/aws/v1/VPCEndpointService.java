
package io.fabric8.openshift.api.model.hive.aws.v1;

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
    "additionalAllowedPrincipals",
    "defaultAllowedPrincipal",
    "id",
    "name"
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
public class VPCEndpointService implements Editable<VPCEndpointServiceBuilder>, KubernetesResource
{

    @JsonProperty("additionalAllowedPrincipals")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> additionalAllowedPrincipals = new ArrayList<>();
    @JsonProperty("defaultAllowedPrincipal")
    private String defaultAllowedPrincipal;
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public VPCEndpointService() {
    }

    public VPCEndpointService(List<String> additionalAllowedPrincipals, String defaultAllowedPrincipal, String id, String name) {
        super();
        this.additionalAllowedPrincipals = additionalAllowedPrincipals;
        this.defaultAllowedPrincipal = defaultAllowedPrincipal;
        this.id = id;
        this.name = name;
    }

    /**
     * AdditionalAllowedPrincipals is a list of additional allowed principal ARNs that have been configured for the Private Link cluster's VPC Endpoint Service. This list in Status is used to determine if a sync of Allowed Principals is needed outside of the regular reconcile period of 2hrs.
     */
    @JsonProperty("additionalAllowedPrincipals")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getAdditionalAllowedPrincipals() {
        return additionalAllowedPrincipals;
    }

    /**
     * AdditionalAllowedPrincipals is a list of additional allowed principal ARNs that have been configured for the Private Link cluster's VPC Endpoint Service. This list in Status is used to determine if a sync of Allowed Principals is needed outside of the regular reconcile period of 2hrs.
     */
    @JsonProperty("additionalAllowedPrincipals")
    public void setAdditionalAllowedPrincipals(List<String> additionalAllowedPrincipals) {
        this.additionalAllowedPrincipals = additionalAllowedPrincipals;
    }

    /**
     * DefaultAllowedPrincipal is the ARN of the IAM entity used by Hive as configured for the Private Link cluster's VPC Endpoint Service.
     */
    @JsonProperty("defaultAllowedPrincipal")
    public String getDefaultAllowedPrincipal() {
        return defaultAllowedPrincipal;
    }

    /**
     * DefaultAllowedPrincipal is the ARN of the IAM entity used by Hive as configured for the Private Link cluster's VPC Endpoint Service.
     */
    @JsonProperty("defaultAllowedPrincipal")
    public void setDefaultAllowedPrincipal(String defaultAllowedPrincipal) {
        this.defaultAllowedPrincipal = defaultAllowedPrincipal;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    public VPCEndpointServiceBuilder edit() {
        return new VPCEndpointServiceBuilder(this);
    }

    @JsonIgnore
    public VPCEndpointServiceBuilder toBuilder() {
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
        if (!(o instanceof VPCEndpointService)) {
            return false;
        }
        VPCEndpointService other = (VPCEndpointService) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$additionalAllowedPrincipals = this.getAdditionalAllowedPrincipals();
        Object other$additionalAllowedPrincipals = other.getAdditionalAllowedPrincipals();
        if (this$additionalAllowedPrincipals == null ? other$additionalAllowedPrincipals != null : !this$additionalAllowedPrincipals.equals(other$additionalAllowedPrincipals)) {
            return false;
        }
        Object this$defaultAllowedPrincipal = this.getDefaultAllowedPrincipal();
        Object other$defaultAllowedPrincipal = other.getDefaultAllowedPrincipal();
        if (this$defaultAllowedPrincipal == null ? other$defaultAllowedPrincipal != null : !this$defaultAllowedPrincipal.equals(other$defaultAllowedPrincipal)) {
            return false;
        }
        Object this$id = this.getId();
        Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
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
        return other instanceof VPCEndpointService;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $additionalAllowedPrincipals = this.getAdditionalAllowedPrincipals();
        result = result * prime + ($additionalAllowedPrincipals == null ? 43 : $additionalAllowedPrincipals.hashCode());
        Object $defaultAllowedPrincipal = this.getDefaultAllowedPrincipal();
        result = result * prime + ($defaultAllowedPrincipal == null ? 43 : $defaultAllowedPrincipal.hashCode());
        Object $id = this.getId();
        result = result * prime + ($id == null ? 43 : $id.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "VPCEndpointService(" + "additionalAllowedPrincipals=" + this.getAdditionalAllowedPrincipals() + ", defaultAllowedPrincipal=" + this.getDefaultAllowedPrincipal() + ", id=" + this.getId() + ", name=" + this.getName() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
