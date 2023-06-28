
package io.fabric8.istio.api.networking.v1alpha3;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;

@Generated("jsonschema2pojo")
public enum HTTPRedirectRedirectPortSelection {

    FROM_PROTOCOL_DEFAULT(0),
    FROM_REQUEST_PORT(1);
    private final Integer value;
    private final static Map<Integer, HTTPRedirectRedirectPortSelection> CONSTANTS = new HashMap<Integer, HTTPRedirectRedirectPortSelection>();
    private final static Map<String, HTTPRedirectRedirectPortSelection> NAME_CONSTANTS = new HashMap<String, HTTPRedirectRedirectPortSelection>();

    static {
        for (HTTPRedirectRedirectPortSelection c: values()) {
            CONSTANTS.put(c.value, c);
        }
        for (HTTPRedirectRedirectPortSelection c: values()) {
            NAME_CONSTANTS.put(c.name().toLowerCase(), c);
        }
    }

    HTTPRedirectRedirectPortSelection(Integer value) {
        this.value = value;
    }

    @JsonCreator
    public static HTTPRedirectRedirectPortSelection fromValue(Object value) {
        if (value instanceof String) {
            {
                HTTPRedirectRedirectPortSelection constant = NAME_CONSTANTS.get(((String) value).toLowerCase());
                if (constant == null) {
                    throw new IllegalArgumentException((value +""));
                } else {
                    return constant;
                }
            }
        }
        HTTPRedirectRedirectPortSelection constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException((value +""));
        } else {
            return constant;
        }
    }

}
