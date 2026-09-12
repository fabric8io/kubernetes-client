
package io.fabric8.kubernetes.api.model;

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
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import io.sundr.builder.annotations.Buildable;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "dryRun",
    "fieldManager",
    "fieldValidation"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Version("v1")
@Group("")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class CreateOptions implements Editable<CreateOptionsBuilder>, KubernetesResource
{

    @JsonProperty("apiVersion")
    private String apiVersion = "v1";
    @JsonProperty("dryRun")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> dryRun = new ArrayList<>();
    @JsonProperty("fieldManager")
    private String fieldManager;
    @JsonProperty("fieldValidation")
    private String fieldValidation;
    @JsonProperty("kind")
    private String kind = "CreateOptions";
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public CreateOptions() {
    }

    public CreateOptions(String apiVersion, List<String> dryRun, String fieldManager, String fieldValidation, String kind) {
        super();
        this.apiVersion = apiVersion;
        this.dryRun = dryRun;
        this.fieldManager = fieldManager;
        this.fieldValidation = fieldValidation;
        this.kind = kind;
    }

    @JsonProperty("apiVersion")
    public String getApiVersion() {
        return apiVersion;
    }

    @JsonProperty("apiVersion")
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    @JsonProperty("dryRun")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getDryRun() {
        return dryRun;
    }

    @JsonProperty("dryRun")
    public void setDryRun(List<String> dryRun) {
        this.dryRun = dryRun;
    }

    @JsonProperty("fieldManager")
    public String getFieldManager() {
        return fieldManager;
    }

    @JsonProperty("fieldManager")
    public void setFieldManager(String fieldManager) {
        this.fieldManager = fieldManager;
    }

    @JsonProperty("fieldValidation")
    public String getFieldValidation() {
        return fieldValidation;
    }

    @JsonProperty("fieldValidation")
    public void setFieldValidation(String fieldValidation) {
        this.fieldValidation = fieldValidation;
    }

    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    @JsonIgnore
    public CreateOptionsBuilder edit() {
        return new CreateOptionsBuilder(this);
    }

    @JsonIgnore
    public CreateOptionsBuilder toBuilder() {
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
        if (!(o instanceof CreateOptions)) {
            return false;
        }
        CreateOptions other = (CreateOptions) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$apiVersion = this.getApiVersion();
        Object other$apiVersion = other.getApiVersion();
        if (this$apiVersion == null ? other$apiVersion != null : !this$apiVersion.equals(other$apiVersion)) {
            return false;
        }
        Object this$dryRun = this.getDryRun();
        Object other$dryRun = other.getDryRun();
        if (this$dryRun == null ? other$dryRun != null : !this$dryRun.equals(other$dryRun)) {
            return false;
        }
        Object this$fieldManager = this.getFieldManager();
        Object other$fieldManager = other.getFieldManager();
        if (this$fieldManager == null ? other$fieldManager != null : !this$fieldManager.equals(other$fieldManager)) {
            return false;
        }
        Object this$fieldValidation = this.getFieldValidation();
        Object other$fieldValidation = other.getFieldValidation();
        if (this$fieldValidation == null ? other$fieldValidation != null : !this$fieldValidation.equals(other$fieldValidation)) {
            return false;
        }
        Object this$kind = this.getKind();
        Object other$kind = other.getKind();
        if (this$kind == null ? other$kind != null : !this$kind.equals(other$kind)) {
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
        return other instanceof CreateOptions;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $apiVersion = this.getApiVersion();
        result = result * prime + ($apiVersion == null ? 43 : $apiVersion.hashCode());
        Object $dryRun = this.getDryRun();
        result = result * prime + ($dryRun == null ? 43 : $dryRun.hashCode());
        Object $fieldManager = this.getFieldManager();
        result = result * prime + ($fieldManager == null ? 43 : $fieldManager.hashCode());
        Object $fieldValidation = this.getFieldValidation();
        result = result * prime + ($fieldValidation == null ? 43 : $fieldValidation.hashCode());
        Object $kind = this.getKind();
        result = result * prime + ($kind == null ? 43 : $kind.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "CreateOptions(" + "apiVersion=" + this.getApiVersion() + ", dryRun=" + this.getDryRun() + ", fieldManager=" + this.getFieldManager() + ", fieldValidation=" + this.getFieldValidation() + ", kind=" + this.getKind() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
