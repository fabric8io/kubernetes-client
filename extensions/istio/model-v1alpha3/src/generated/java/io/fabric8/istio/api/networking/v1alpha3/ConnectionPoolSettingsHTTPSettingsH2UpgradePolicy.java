
package io.fabric8.istio.api.networking.v1alpha3;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;

@Generated("jsonschema2pojo")
public enum ConnectionPoolSettingsHTTPSettingsH2UpgradePolicy {

    DEFAULT(0),
    DO_NOT_UPGRADE(1),
    UPGRADE(2);
    private final Integer value;
    private final static Map<Integer, ConnectionPoolSettingsHTTPSettingsH2UpgradePolicy> CONSTANTS = new HashMap<Integer, ConnectionPoolSettingsHTTPSettingsH2UpgradePolicy>();
    private final static Map<String, ConnectionPoolSettingsHTTPSettingsH2UpgradePolicy> NAME_CONSTANTS = new HashMap<String, ConnectionPoolSettingsHTTPSettingsH2UpgradePolicy>();

    static {
        for (ConnectionPoolSettingsHTTPSettingsH2UpgradePolicy c: values()) {
            CONSTANTS.put(c.value, c);
        }
        for (ConnectionPoolSettingsHTTPSettingsH2UpgradePolicy c: values()) {
            NAME_CONSTANTS.put(c.name().toLowerCase(), c);
        }
    }

    ConnectionPoolSettingsHTTPSettingsH2UpgradePolicy(Integer value) {
        this.value = value;
    }

    @JsonCreator
    public static ConnectionPoolSettingsHTTPSettingsH2UpgradePolicy fromValue(Object value) {
        if (value instanceof String) {
            {
                ConnectionPoolSettingsHTTPSettingsH2UpgradePolicy constant = NAME_CONSTANTS.get(((String) value).toLowerCase());
                if (constant == null) {
                    throw new IllegalArgumentException((value +""));
                } else {
                    return constant;
                }
            }
        }
        ConnectionPoolSettingsHTTPSettingsH2UpgradePolicy constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException((value +""));
        } else {
            return constant;
        }
    }

}
