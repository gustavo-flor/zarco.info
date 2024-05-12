#!/bin/bash

awslocal sqs create-queue \
  --queue-name zarco-new-station_dlq \
  --region us-east-1

awslocal sqs create-queue \
  --queue-name zarco-new-station \
  --region us-east-1 \
  --attributes '{
    "RedrivePolicy": "{\"deadLetterTargetArn\":\"arn:aws:sqs:us-east-1:000000000000:zarco-new-station_dlq\",\"maxReceiveCount\":\"3\"}"
  }'
