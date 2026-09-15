
package io.fabric8.openshift.api.model;

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
 * BrokerTemplateInstanceSpec describes the state of a BrokerTemplateInstance.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "bindingIDs",
    "secret",
    "templateInstance"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class BrokerTemplateInstanceSpec implements Editable<BrokerTemplateInstanceSpecBuilder>, KubernetesResource
{

    @JsonProperty("bindingIDs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> bindingIDs = new ArrayList<>();
    @JsonProperty("secret")
    private ObjectReference secret;
    @JsonProperty("templateInstance")
    private ObjectReference templateInstance;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public BrokerTemplateInstanceSpec() {
    }

    public BrokerTemplateInstanceSpec(List<String> bindingIDs, ObjectReference secret, ObjectReference templateInstance) {
        super();
        this.bindingIDs = bindingIDs;
        this.secret = secret;
        this.templateInstance = templateInstance;
    }

    /**
     * bindingIDs is a list of 'binding_id's provided during successive bind calls to the template service broker.
     */
    @JsonProperty("bindingIDs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getBindingIDs() {
        return bindingIDs;
    }

    /**
     * bindingIDs is a list of 'binding_id's provided during successive bind calls to the template service broker.
     */
    @JsonProperty("bindingIDs")
    public void setBindingIDs(List<String> bindingIDs) {
        this.bindingIDs = bindingIDs;
    }

    /**
     * BrokerTemplateInstanceSpec describes the state of a BrokerTemplateInstance.
     */
    @JsonProperty("secret")
    public ObjectReference getSecret() {
        return secret;
    }

    /**
     * BrokerTemplateInstanceSpec describes the state of a BrokerTemplateInstance.
     */
    @JsonProperty("secret")
    public void setSecret(ObjectReference secret) {
        this.secret = secret;
    }

    /**
     * BrokerTemplateInstanceSpec describes the state of a BrokerTemplateInstance.
     */
    @JsonProperty("templateInstance")
    public ObjectReference getTemplateInstance() {
        return templateInstance;
    }

    /**
     * BrokerTemplateInstanceSpec describes the state of a BrokerTemplateInstance.
     */
    @JsonProperty("templateInstance")
    public void setTemplateInstance(ObjectReference templateInstance) {
        this.templateInstance = templateInstance;
    }

    @JsonIgnore
    public BrokerTemplateInstanceSpecBuilder edit() {
        return new BrokerTemplateInstanceSpecBuilder(this);
    }

    @JsonIgnore
    public BrokerTemplateInstanceSpecBuilder toBuilder() {
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
        if (!(o instanceof BrokerTemplateInstanceSpec)) {
            return false;
        }
        BrokerTemplateInstanceSpec other = (BrokerTemplateInstanceSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$bindingIDs = this.getBindingIDs();
        Object other$bindingIDs = other.getBindingIDs();
        if (this$bindingIDs == null ? other$bindingIDs != null : !this$bindingIDs.equals(other$bindingIDs)) {
            return false;
        }
        Object this$secret = this.getSecret();
        Object other$secret = other.getSecret();
        if (this$secret == null ? other$secret != null : !this$secret.equals(other$secret)) {
            return false;
        }
        Object this$templateInstance = this.getTemplateInstance();
        Object other$templateInstance = other.getTemplateInstance();
        if (this$templateInstance == null ? other$templateInstance != null : !this$templateInstance.equals(other$templateInstance)) {
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
        return other instanceof BrokerTemplateInstanceSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $bindingIDs = this.getBindingIDs();
        result = result * prime + ($bindingIDs == null ? 43 : $bindingIDs.hashCode());
        Object $secret = this.getSecret();
        result = result * prime + ($secret == null ? 43 : $secret.hashCode());
        Object $templateInstance = this.getTemplateInstance();
        result = result * prime + ($templateInstance == null ? 43 : $templateInstance.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "BrokerTemplateInstanceSpec(" + "bindingIDs=" + this.getBindingIDs() + ", secret=" + this.getSecret() + ", templateInstance=" + this.getTemplateInstance() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
