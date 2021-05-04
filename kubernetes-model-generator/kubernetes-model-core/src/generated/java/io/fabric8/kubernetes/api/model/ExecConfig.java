
package io.fabric8.kubernetes.api.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.sundr.builder.annotations.Buildable;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "args",
    "command",
    "env",
    "installHint",
    "provideClusterInfo"
})
@ToString
@EqualsAndHashCode
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = true, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
public class ExecConfig implements KubernetesResource
{

    @JsonProperty("apiVersion")
    private String apiVersion;
    @JsonProperty("args")
    private List<String> args = new ArrayList<String>();
    @JsonProperty("command")
    private String command;
    @JsonProperty("env")
    private List<ExecEnvVar> env = new ArrayList<ExecEnvVar>();
    @JsonProperty("installHint")
    private String installHint;
    @JsonProperty("provideClusterInfo")
    private Boolean provideClusterInfo;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ExecConfig() {
    }

    /**
     * 
     * @param args
     * @param apiVersion
     * @param provideClusterInfo
     * @param env
     * @param installHint
     * @param command
     */
    public ExecConfig(String apiVersion, List<String> args, String command, List<ExecEnvVar> env, String installHint, Boolean provideClusterInfo) {
        super();
        this.apiVersion = apiVersion;
        this.args = args;
        this.command = command;
        this.env = env;
        this.installHint = installHint;
        this.provideClusterInfo = provideClusterInfo;
    }

    @JsonProperty("apiVersion")
    public String getApiVersion() {
        return apiVersion;
    }

    @JsonProperty("apiVersion")
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    @JsonProperty("args")
    public List<String> getArgs() {
        return args;
    }

    @JsonProperty("args")
    public void setArgs(List<String> args) {
        this.args = args;
    }

    @JsonProperty("command")
    public String getCommand() {
        return command;
    }

    @JsonProperty("command")
    public void setCommand(String command) {
        this.command = command;
    }

    @JsonProperty("env")
    public List<ExecEnvVar> getEnv() {
        return env;
    }

    @JsonProperty("env")
    public void setEnv(List<ExecEnvVar> env) {
        this.env = env;
    }

    @JsonProperty("installHint")
    public String getInstallHint() {
        return installHint;
    }

    @JsonProperty("installHint")
    public void setInstallHint(String installHint) {
        this.installHint = installHint;
    }

    @JsonProperty("provideClusterInfo")
    public Boolean getProvideClusterInfo() {
        return provideClusterInfo;
    }

    @JsonProperty("provideClusterInfo")
    public void setProvideClusterInfo(Boolean provideClusterInfo) {
        this.provideClusterInfo = provideClusterInfo;
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
