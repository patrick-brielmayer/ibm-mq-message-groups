# ibm-mq-message-groups

## Setup

1. Install IBM MQ
    ```
    docker volume create qm1data
    ```
    
    ```
    docker run --env LICENSE=accept --env MQ_QMGR_NAME=QM1 --volume qm1data:/mnt/mqm --publish 1414:1414 --publish 9443:9443 --detach --env MQ_APP_USER=app --env MQ_APP_PASSWORD=password --env MQ_ADMIN_USER=admin --env MQ_ADMIN_PASSWORD=password --name QM1 icr.io/ibm-messaging/mq:latest
    ```
2. Run the listener application
3. Run the producer application