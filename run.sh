#!/bin/bash

echo "nameserver 0.0.0.0" >> /etc/resolv.conf
cat /etc/resolv.conf
/bin/sleep 15


java -jar *.jar  --spring.profiles.active=prod
