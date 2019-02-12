/*
 * Copyright 2016 The original authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package io.ap4k.crd.util;


import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringReplace implements Function<String, String> {

    private final String target;
    private final String replacement;
    private final Pattern pattern;


    public StringReplace(String target, String replacement) {
        this.target = target;
        this.replacement = replacement;
        this.pattern = Pattern.compile(target, Pattern.CASE_INSENSITIVE);
    }

    public String apply(String word) {
        Matcher matcher = this.pattern.matcher(word);
        if (!matcher.find()) {
            return null;
        }
        return matcher.replaceAll(replacement);
    }
}

