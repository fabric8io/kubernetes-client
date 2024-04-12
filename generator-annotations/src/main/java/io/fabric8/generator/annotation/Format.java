/*
 * Copyright (C) 2015 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.fabric8.generator.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Java representation of the {@code format} field of JSONSchemaProps.
 *
 * <p>
 * The following formats are validated by Kubernetes:
 * </p>
 * <ul>
 * <li>{@code bsonobjectid}: a bson object ID, i.e. a 24 characters hex string</li>
 * <li>{@code uri}: an URI as parsed by Golang net/url.ParseRequestURI</li>
 * <li>{@code email}: an email address as parsed by Golang net/mail.ParseAddress</li>
 * <li>{@code hostname}: a valid representation for an Internet host name, as defined by RFC 1034, section 3.1 [RFC1034].</li>
 * <li>{@code ipv4}: an IPv4 IP as parsed by Golang net.ParseIP</li>
 * <li>{@code ipv6}: an IPv6 IP as parsed by Golang net.ParseIP</li>
 * <li>{@code cidr}: a CIDR as parsed by Golang net.ParseCIDR</li>
 * <li>{@code mac}: a MAC address as parsed by Golang net.ParseMAC</li>
 * <li>{@code uuid}: an UUID that allows uppercase defined by the regex
 * {@code (?i)^[0-9a-f]{8}-?[0-9a-f]{4}-?[0-9a-f]{4}-?[0-9a-f]{4}-?[0-9a-f]{12}$}</li>
 * <li>{@code uuid3}: an UUID3 that allows uppercase defined by the regex
 * {@code (?i)^[0-9a-f]{8}-?[0-9a-f]{4}-?3[0-9a-f]{3}-?[0-9a-f]{4}-?[0-9a-f]{12}$}</li>
 * <li>{@code uuid4}: an UUID4 that allows uppercase defined by the regex
 * {@code (?i)^[0-9a-f]{8}-?[0-9a-f]{4}-?4[0-9a-f]{3}-?[89ab][0-9a-f]{3}-?[0-9a-f]{12}$}</li>
 * <li>{@code uuid5}: an UUID5 that allows uppercase defined by the regex
 * {@code (?i)^[0-9a-f]{8}-?[0-9a-f]{4}-?5[0-9a-f]{3}-?[89ab][0-9a-f]{3}-?[0-9a-f]{12}$}</li>
 * <li>{@code isbn}: an ISBN10 or ISBN13 number string like "0321751043" or "978-0321751041"</li>
 * <li>{@code isbn10}: an ISBN10 number string like "0321751043"</li>
 * <li>{@code isbn13}: an ISBN13 number string like "978-0321751041"</li>
 * <li>{@code creditcard}: a credit card number defined by the regex
 * {@code ^(?:4[0-9]{12}(?:[0-9]{3})?|5[1-5][0-9]{14}|6(?:011|5[0-9][0-9])[0-9]{12}|3[47][0-9]{13}|3(?:0[0-5]|[68][0-9])[0-9]{11}|(?:2131|1800|35\d{3})\d{11})$}
 * with any non digit characters mixed in</li>
 * <li>{@code ssn}: a U.S. social security number following the regex {@code ^\d{3}[- ]?\d{2}[- ]?\d{4}$}</li>
 * <li>{@code hexcolor}: an hexadecimal color code like "#FFFFFF: following the regex
 * {@code ^#?([0-9a-fA-F]{3}|[0-9a-fA-F]{6})$}</li>
 * <li>{@code rgbcolor}: an RGB color code like rgb like "rgb(255,255,2559"</li>
 * <li>{@code byte}: base64 encoded binary data</li>
 * <li>{@code password}: any kind of string</li>
 * <li>{@code date}: a date string like "2006-01-02" as defined by full-date in RFC3339</li>
 * <li>{@code duration}: a duration string like "22 ns" as parsed by Golang time.ParseDuration or compatible with Scala duration
 * format</li>
 * <li>{@code date-time}: a date time string like "2014-12-15T19:30:20.000Z" as defined by date-time in RFC3339.</li>
 * </ul>
 * <p>
 * Unknown formats are ignored by Kubernetes and if another consumer is unaware of the meaning of the format,
 * they shall fall back to using the basic type without format.
 * </p>
 *
 * @see <a href=
 *      "https://kubernetes.io/docs/reference/kubernetes-api/extend-resources/custom-resource-definition-v1/#JSONSchemaProps">
 *      Kubernetes Docs - API Reference - CRD v1 - JSONSchemaProps
 *      </a>
 */
@Target({ ElementType.ANNOTATION_TYPE, ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Format {
  String value();
}
