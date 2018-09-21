/**
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
package handlers

import (
	"bytes"
	"errors"
	"fmt"
	"strings"
	"text/template"

	"github.com/sirupsen/logrus"
)

// logHook is for hooking Panic in web application
type logHook struct {
	LevelsParam []string
	Mail        *mailer
}

// Fire forwards an error to LogHook
func (hook *logHook) Fire(entry *logrus.Entry) error {
	addr := strings.Split(hook.Mail.Addr, ":")
	if len(addr) != 2 {
		return errors.New("Invalid Mail Address")
	}
	host := addr[0]
	subject := fmt.Sprintf("[%s] %s: %s", entry.Level, host, entry.Message)

	html := `
	{{.Message}}

	{{range $key, $value := .Data}}
	{{$key}}: {{$value}}
	{{end}}
	`
	b := bytes.NewBuffer(make([]byte, 0))
	t := template.Must(template.New("mail body").Parse(html))
	if err := t.Execute(b, entry); err != nil {
		return err
	}
	body := fmt.Sprintf("%s", b)

	return hook.Mail.sendMail(subject, body)
}

// Levels contains hook levels to be catched
func (hook *logHook) Levels() []logrus.Level {
	levels := []logrus.Level{}
	for _, v := range hook.LevelsParam {
		lv, _ := logrus.ParseLevel(v)
		levels = append(levels, lv)
	}
	return levels
}
