
package io.fabric8.kubernetes.api.model;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.sundr.builder.annotations.Buildable;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "gmsaCredentialSpec",
    "gmsaCredentialSpecName",
    "hostProcess",
    "runAsUserName"
})
@ToString
@EqualsAndHashCode
@Setter
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = true, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("jsonschema2pojo")
public class WindowsSecurityContextOptions implements KubernetesResource
{

    @JsonProperty("gmsaCredentialSpec")
    private String gmsaCredentialSpec;
    @JsonProperty("gmsaCredentialSpecName")
    private String gmsaCredentialSpecName;
    @JsonProperty("hostProcess")
    private Boolean hostProcess;
    @JsonProperty("runAsUserName")
    private String runAsUserName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public WindowsSecurityContextOptions() {
    }

    public WindowsSecurityContextOptions(String gmsaCredentialSpec, String gmsaCredentialSpecName, Boolean hostProcess, String runAsUserName) {
        super();
        this.gmsaCredentialSpec = gmsaCredentialSpec;
        this.gmsaCredentialSpecName = gmsaCredentialSpecName;
        this.hostProcess = hostProcess;
        this.runAsUserName = runAsUserName;
    }

    @JsonProperty("gmsaCredentialSpec")
    public String getGmsaCredentialSpec() {
        return gmsaCredentialSpec;
    }

    @JsonProperty("gmsaCredentialSpec")
    public void setGmsaCredentialSpec(String gmsaCredentialSpec) {
        this.gmsaCredentialSpec = gmsaCredentialSpec;
    }

    @JsonProperty("gmsaCredentialSpecName")
    public String getGmsaCredentialSpecName() {
        return gmsaCredentialSpecName;
    }

    @JsonProperty("gmsaCredentialSpecName")
    public void setGmsaCredentialSpecName(String gmsaCredentialSpecName) {
        this.gmsaCredentialSpecName = gmsaCredentialSpecName;
    }

    @JsonProperty("hostProcess")
    public Boolean getHostProcess() {
        return hostProcess;
    }

    @JsonProperty("hostProcess")
    public void setHostProcess(Boolean hostProcess) {
        this.hostProcess = hostProcess;
    }

    @JsonProperty("runAsUserName")
    public String getRunAsUserName() {
        return runAsUserName;
    }

    @JsonProperty("runAsUserName")
    public void setRunAsUserName(String runAsUserName) {
        this.runAsUserName = runAsUserName;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
