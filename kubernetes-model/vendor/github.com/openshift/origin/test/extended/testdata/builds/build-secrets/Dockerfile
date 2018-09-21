#
# Copyright (C) 2015 Red Hat, Inc.
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#         http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

FROM centos/ruby-22-centos7

USER root
ADD ./secret-dir /secrets
COPY ./secret2 /

# Create a shell script that will output secrets when the image is run
RUN echo '#!/bin/sh' > /secret_report.sh
RUN echo '(test -f /secrets/secret1 && echo -n "secret1=" && cat /secrets/secret1)' >> /secret_report.sh
RUN echo '(test -f /secret2 && echo -n "relative-secret2=" && cat /secret2)' >> /secret_report.sh
RUN chmod 755 /secret_report.sh

CMD ["/bin/sh", "-c", "/secret_report.sh"]
