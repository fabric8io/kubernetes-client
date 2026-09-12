
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
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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

/**
 * AzureCustomerManagedBootDiagnostics provides reference to a customer managed storage account.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "storageAccountURI"
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
public class AzureCustomerManagedBootDiagnostics implements Editable<AzureCustomerManagedBootDiagnosticsBuilder>, KubernetesResource
{

    @JsonProperty("storageAccountURI")
    private String storageAccountURI;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AzureCustomerManagedBootDiagnostics() {
    }

    public AzureCustomerManagedBootDiagnostics(String storageAccountURI) {
        super();
        this.storageAccountURI = storageAccountURI;
    }

    /**
     * storageAccountURI is the URI of the customer managed storage account. The URI typically will be `https://&lt;mystorageaccountname&gt;.blob.core.windows.net/` but may differ if you are using Azure DNS zone endpoints. You can find the correct endpoint by looking for the Blob Primary Endpoint in the endpoints tab in the Azure console.
     */
    @JsonProperty("storageAccountURI")
    public String getStorageAccountURI() {
        return storageAccountURI;
    }

    /**
     * storageAccountURI is the URI of the customer managed storage account. The URI typically will be `https://&lt;mystorageaccountname&gt;.blob.core.windows.net/` but may differ if you are using Azure DNS zone endpoints. You can find the correct endpoint by looking for the Blob Primary Endpoint in the endpoints tab in the Azure console.
     */
    @JsonProperty("storageAccountURI")
    public void setStorageAccountURI(String storageAccountURI) {
        this.storageAccountURI = storageAccountURI;
    }

    @JsonIgnore
    public AzureCustomerManagedBootDiagnosticsBuilder edit() {
        return new AzureCustomerManagedBootDiagnosticsBuilder(this);
    }

    @JsonIgnore
    public AzureCustomerManagedBootDiagnosticsBuilder toBuilder() {
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
        if (!(o instanceof AzureCustomerManagedBootDiagnostics)) {
            return false;
        }
        AzureCustomerManagedBootDiagnostics other = (AzureCustomerManagedBootDiagnostics) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$storageAccountURI = this.getStorageAccountURI();
        Object other$storageAccountURI = other.getStorageAccountURI();
        if (this$storageAccountURI == null ? other$storageAccountURI != null : !this$storageAccountURI.equals(other$storageAccountURI)) {
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
        return other instanceof AzureCustomerManagedBootDiagnostics;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $storageAccountURI = this.getStorageAccountURI();
        result = result * prime + ($storageAccountURI == null ? 43 : $storageAccountURI.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "AzureCustomerManagedBootDiagnostics(" + "storageAccountURI=" + this.getStorageAccountURI() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
