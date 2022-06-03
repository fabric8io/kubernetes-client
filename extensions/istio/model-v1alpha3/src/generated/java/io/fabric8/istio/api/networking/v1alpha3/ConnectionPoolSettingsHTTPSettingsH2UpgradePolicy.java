
package io.fabric8.istio.api.networking.v1alpha3;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ConnectionPoolSettingsHTTPSettingsH2UpgradePolicy {

    DEFAULT("DEFAULT"),
    DO_NOT_UPGRADE("DO_NOT_UPGRADE"),
    UPGRADE("UPGRADE");
    private final String value;
    private final static Map<String, ConnectionPoolSettingsHTTPSettingsH2UpgradePolicy> CONSTANTS = new HashMap<String, ConnectionPoolSettingsHTTPSettingsH2UpgradePolicy>();

    static {
        for (ConnectionPoolSettingsHTTPSettingsH2UpgradePolicy c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    private ConnectionPoolSettingsHTTPSettingsH2UpgradePolicy(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    @JsonValue
    public String value() {
        return this.value;
    }

    @JsonCreator
    public static ConnectionPoolSettingsHTTPSettingsH2UpgradePolicy fromValue(String value) {
        ConnectionPoolSettingsHTTPSettingsH2UpgradePolicy constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
