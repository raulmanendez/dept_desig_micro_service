Maven Skip Tests => mvn clean install -Dmaven.test.skip=true

kubectl apply -f deployment_kubectl.yaml

kubectl get node

kubectl get deployments

kubectl get service

kubectl get pods

kubectl delete pod department-584dfc5685-fftjf

kubectl logs department-584dfc5685-fftjf -f

kubectl get events

kubectl get ingress

minikube service web-app-service --url


minikube start --addons=ingress

kubectl get pods -n ingress-nginx

kubectl logs -n ingress-nginx ingress-nginx-controller-7799c6795f-b8psf -f




Get Inside minikube => minikube ssh


To transfer Image from host machine to minikube ssh

1. Create tar on host machine => docker save backend_java-webapp > backend_java-webapp.tar
2. Copy tar inside minikube => scp -i $(minikube ssh-key) backend_java-webapp.tar docker@$(minikube ip):/home/docker/
3. Load Image inside minikube => docker load -i backend_java-webapp.tar


Kafka setup -> download (version 2.8.1) and run zookeeper first using

nohup bin/zookeeper-server-stop.sh config/zookeeper.properties &

then start kafka-server

nohup bin/kafka-server-stop.sh config/server.properties &

run these commands within same drive where ubuntu is installed - I tries running in other drive that cause error : "Classpath is empty. Please build the project first e.g. by running './gradlew jar -PscalaVersion=2.13.5'"

I have used a topic 'logger-topic' and a group 'logger-group' in department/designation microservices and a consumer in logger-service.





